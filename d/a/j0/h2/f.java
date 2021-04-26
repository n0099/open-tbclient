package d.a.j0.h2;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personExtra.PersonBarByUidLocalMessage;
import com.baidu.tieba.personExtra.ResponsePersonBarByUidLocalMessage;
/* loaded from: classes4.dex */
public class f implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof PersonBarByUidLocalMessage)) {
            return null;
        }
        String str = d.a.i0.r.r.a.f().g("tb.my_pages").get(TbadkCoreApplication.getCurrentAccount());
        ResponsePersonBarByUidLocalMessage responsePersonBarByUidLocalMessage = new ResponsePersonBarByUidLocalMessage();
        if (str != null) {
            try {
                responsePersonBarByUidLocalMessage.decodeInBackGround(2001183, str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return responsePersonBarByUidLocalMessage;
    }
}
