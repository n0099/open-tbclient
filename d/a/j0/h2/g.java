package d.a.j0.h2;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personExtra.PersonFriendByUidLocalMessage;
import com.baidu.tieba.personExtra.ResponsePersonFriendByUidLocalMessage;
/* loaded from: classes4.dex */
public class g implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonFriendByUidLocalMessage)) {
            return null;
        }
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        String str = d.a.i0.r.r.a.f().g("tb.my_pages").get("personal_myfollow_" + id);
        ResponsePersonFriendByUidLocalMessage responsePersonFriendByUidLocalMessage = new ResponsePersonFriendByUidLocalMessage();
        if (str != null) {
            try {
                responsePersonFriendByUidLocalMessage.decodeInBackGround(2001182, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return responsePersonFriendByUidLocalMessage;
    }
}
