package d.b.i0.v0.c.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
/* loaded from: classes4.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GodSquareCacheRequestMsg)) {
            return null;
        }
        byte[] a2 = new d.b.i0.v0.c.a().a(((GodSquareCacheRequestMsg) customMessage).cacheKey);
        GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = new GodSquareCacheResponsedMsg();
        try {
            godSquareCacheResponsedMsg.decodeInBackGround(2016446, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return godSquareCacheResponsedMsg;
    }
}
