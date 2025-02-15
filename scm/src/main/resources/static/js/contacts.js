console.log("contacts js page");
//const baseUrl="http://localhost:8081";
const baseUrl="http://scm1.ap-south-1.elasticbeanstalk.com";

const viewContactModel = document.getElementById('view_contact_modal');

// options with default values
const options = {
    placement: 'bottom-right',
    backdrop: 'dynamic',
    backdropClasses:
        'bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40',
    closable: true,
    onHide: () => {
        console.log('modal is hidden');
    },
    onShow: () => {
        console.log('modal is shown');
    },
    onToggle: () => {
        console.log('modal has been toggled');
    },
};

// instance options object
const instanceOptions = {
  id: 'view_contact_modal',
  override: true
};

const contactModal = new Modal(viewContactModel,options,instanceOptions);

function openContactModal(){
    contactModal.show();
}

function closeContactModal(){
    contactModal.hide();
}

async function loadContactdata(id){
    //fucntion call to load data
    console.log(id);

    try {
        const data = await(await fetch(`${baseUrl}/api/contacts/${id}`)).json();
        console.log(data);
        const contactImg=document.querySelector("#contact_img");
        if(data.picture){
            contactImg.src=data.picture;
        }else{
            contactImg.src="https://static-00.iconduck.com/assets.00/profile-default-icon-2048x2045-u3j7s5nj.png";
        }
        
        document.querySelector("#contact_name").innerHTML=data.name;
        document.querySelector("#contact_email").innerHTML=data.email;
        document.querySelector("#contact_address").innerHTML=data.address;
        document.querySelector("#contact_phone").innerHTML=data.phoneNumber;
        document.querySelector("#contact_about").innerHTML=data.description;
        const contactFavourite = document.querySelector("#contact_favourite");
        if(data.favorite){
            contactFavourite.innerHTML="<i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i>";
            
        }else{
            contactFavourite.innerHTML="Not Favourite Contact";
        }
        document.querySelector("#contact_github").href=data.websiteLink;
        document.querySelector("#contact_github").innerHTML=data.websiteLink;
        document.querySelector("#contact_linkedIn").href=data.linkedInLink;
        document.querySelector("#contact_linkedIn").innerHTML=data.linkedInLink;

        openContactModal();

        
    } catch (error) {
        console.log(error);
    }

}


//delete contact
async function deleteContact(id){

    Swal.fire({
        title: "Are you sure, Want to delete it?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
      }).then((result) => {
        if (result.isConfirmed) {
            const url=`${baseUrl}/user/contacts/delete/`+id;
            window.location.replace(url);
          Swal.fire({
            title: "Deleted!",
            text: "Your file has been deleted.",
            icon: "success"
          });
        }
      });

}

   
