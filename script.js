// Initialize the state variable
let myStatus = "shown"; 

function triggerMenu() {
  let sideMenu = document.getElementById("sideMenu");

  if (myStatus === "hidden") {
    sideMenu.style.transition = "min-width 0.3s, padding 0.3s";
    sideMenu.style.minWidth = "15vw";
    sideMenu.style.padding = "10px";
    myStatus = "shown";
  } else if (myStatus === "shown") {
    sideMenu.style.transition = "none";
    sideMenu.style.maxWidth = "0vw";
    sideMenu.style.minWidth = "0vw"
    sideMenu.style.padding = "0px";
    myStatus = "hidden";
  }
}
function addTask() {
  let table = document.getElementById("dataTable");
  var row = table.insertRow();
  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  cell1.innerHTML = "NEW CELL";
  cell2.innerHTML =
    "TEST CELL";
  cell3.innerHTML = "hi";
}
/*TO DO:
Add code for remove and modify buttons.
*/
