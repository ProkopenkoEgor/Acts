import {request} from '../helpers/axios_helper';

export default function onLoginSignIn(username,password){        
    return request(
            "POST",
            "/login",
            {
                login: username,
                password: password
            })
    // return new Promise((resolve,reject) => {
    //     setTimeout(() => {
    //         resolve({
    //             data: {
    //                 token: 'jwt token'
    //             }
    //         })
    //         reject("down")
    //     }, 3000);
    // })
}