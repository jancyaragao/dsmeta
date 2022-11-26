import axios from 'axios';
import { toast } from 'react-toastify';

import './styles.css';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';

type Props = {
    saleId: number;
}

function handleClick(saleId: number) {
    axios(`${BASE_URL}/${saleId}/notification`).then(response => {
        toast.dark("SMS enviado com sucesso!");
    })
}

// http://localhost:8080/sales/ID/notification
function NotificationButton({saleId} : Props) {

    return (
        <>
            <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
                <img src={icon} alt="Notificar" />
            </div>
        </>
    )
}

export default NotificationButton
