package d.b.i0.d2.k.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalRequestMessage;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalResponseMessage;
/* loaded from: classes3.dex */
public class v0 implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof PbPageReadLocalRequestMessage)) {
            return null;
        }
        PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = (PbPageReadLocalRequestMessage) customMessage;
        byte[] a2 = k.b().a(pbPageReadLocalRequestMessage.getCacheKey(), pbPageReadLocalRequestMessage.isMarkCache());
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = new PbPageReadLocalResponseMessage();
        pbPageReadLocalResponseMessage.setPostId(pbPageReadLocalRequestMessage.getPostId());
        pbPageReadLocalResponseMessage.setMarkCache(pbPageReadLocalRequestMessage.isMarkCache());
        pbPageReadLocalResponseMessage.setUpdateType(pbPageReadLocalRequestMessage.getUpdateType());
        pbPageReadLocalResponseMessage.setContext(pbPageReadLocalRequestMessage.getContext());
        try {
            pbPageReadLocalResponseMessage.decodeInBackGround(2004003, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return pbPageReadLocalResponseMessage;
    }
}
