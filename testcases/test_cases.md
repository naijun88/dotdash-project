
# Test Cases:

## Test Case ID : TC_NSS_TODO_001

### Test Case Name : Verify Create a TODO functionality.
#### Steps:

1. Launch the Server
1. Enter a value "buy flowers" in the Add field
1. Select category "Personal" from the Category dropdown list
1. Select "1" from due date dropdown list
1. Select "Jul" from month dropdown list
1. Select "2018" from year dropdown list
1. Click on the "Add" button
1. The "buy flower" TODO is displayed and showing in the same color like Personal Category
   and date format as "01/07/18"

## Test Case ID : TC_NSS_TODO_002

### Test Case Name : Verify Create a Category functionality.
#### Steps:

1. Launch the Server
1. Enter a value "Work" in the Add Category field
1. Select "Blue" from Color dropdown list
1. Click on the "Add Category" button
1. The new Category "Work" is displayed and showing in Blue color as expected

## Test Case ID : TC_NSS_TODO_003

### Test Case Name : Verify Modify/Delete TODO functionality
#### Steps:

1. Launch the Server
1. Toggle the check box of "buy flower"
1. Click the Complete button
1. "buy flower" TODO is strikethrough means completed as expected
1. Toggle the check box of "buy flower" again
1. Click on the Remove button
1. The "buy flower" TODO is disappeared from the list as expected
