package d.b.i0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
/* loaded from: classes4.dex */
public class n implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GroupsByUidLocalMessage)) {
            return null;
        }
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        byte[] bArr = d.b.h0.r.r.a.f().d("tb.im_entergroup").get(ResponseGroupsByUidMessage.CACHE_KEY_PREFIX + id);
        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = new ResponseGroupsByUidLocalMessage();
        if (bArr != null) {
            try {
                responseGroupsByUidLocalMessage.decodeInBackGround(2001106, bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return responseGroupsByUidLocalMessage;
    }
}
