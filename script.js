let myStatus = "hidden";

function triggerMenu() {
   let sideMenu = document.getElementById("sideMenu");

   if (myStatus == "hidden") {
      sideMenu.style.transition = "width 0.3s, padding 0.3s";
      sideMenu.style.width = '15%';
      sideMenu.style.padding = '10px';
      myStatus = "shown";
   } else if (myStatus == "shown") {
      sideMenu.style.transition = "none";
      sideMenu.style.padding = '0px';
      sideMenu.style.width = '0px';
      myStatus = "hidden";
   }
}