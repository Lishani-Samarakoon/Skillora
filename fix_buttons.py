import os
import re

dir_path = "app/src/main/java/ui/screens"

for filename in os.listdir(dir_path):
    if not filename.endswith(".kt"): continue
    filepath = os.path.join(dir_path, filename)
    with open(filepath, "r", encoding="utf-8") as f:
        content = f.read()
    
    # Check if onClick = { } exists
    if "onClick = { }" in content:
        # Add LocalContext.current if it's not present
        
        # Replace empty lambdas
        content = content.replace("onClick = { }", "onClick = { android.widget.Toast.makeText(context, \"Not Implemented Yet\", android.widget.Toast.LENGTH_SHORT).show() }")
        
        # Now we need to inject context inside the composables if it's missing, but it might be easier to just use a helper,
        # but wait, `context` must be declared. So actually let's insert:
        # val context = androidx.compose.ui.platform.LocalContext.current
        # We can find the main Composable name from the filename: SignInScreen.kt -> SignInScreen
        composable_name = filename.replace(".kt", "")
        # Find the line with `fun ScreenName(`
        pattern = rf'(fun {composable_name}[^{{]+{{)'
        
        match = re.search(pattern, content)
        if match:
            # check if context is already there
            if "val context = " not in content:
                replacement = match.group(1) + "\n    val context = androidx.compose.ui.platform.LocalContext.current\n"
                content = content.replace(match.group(1), replacement, 1)
        
        with open(filepath, "w", encoding="utf-8") as f:
            f.write(content)
        print(f"Fixed {filename}")

# AppNavGraph.kt
app_nav = "app/src/main/java/navigation/AppNavGraph.kt"
with open(app_nav, "r", encoding="utf-8") as f:
    content = f.read()
if "onClick = { }" in content:
    content = content.replace("onClick = { }", "onClick = { } // Intentionally empty")
with open(app_nav, "w", encoding="utf-8") as f:
    f.write(content)
print("Fixed AppNavGraph.kt")
