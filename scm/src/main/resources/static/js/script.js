console.log("Script loaded");

//change theme work
let currentTheme=getTheme();

//intial -->
document.addEventListener('DOMContentLoaded',()=>{
    changeTheme();
    
});


//TODO
function changeTheme(){
    //set to web page
    changePageTheme(currentTheme,currentTheme);

    document.querySelector('html').classList.add(currentTheme);

    //set the listener to chage theme button
    const changeThemeBtn = document.querySelector('#theme_change_button');

    changeThemeBtn.addEventListener("click",(evt)=>{
        let oldTheme=currentTheme;
        console.log("change them button clicked");
        
        if(currentTheme === "dark"){
            //theme to light
            currentTheme="light";
        }else{
            //theme to dark
            currentTheme="dark";
        }
        changePageTheme(currentTheme,oldTheme);
        
    });
}


//set theme to localstorage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from localstorage
function getTheme(){
    let theme=localStorage.getItem("theme");
    return theme ? theme : "light";
}

//change current page theme
function changePageTheme(currentTheme,oldTheme){
    //lcoalstorage maien update karenge
    setTheme(currentTheme);
    //remove the current theme
    document.querySelector("html").classList.remove(oldTheme);
    //set the current theme
    document.querySelector("html").classList.add(currentTheme);

    //change the text
    document.querySelector('#theme_change_button').querySelector('span').textContent = currentTheme==="light"?"Dark":"Light";
}

//change page end
