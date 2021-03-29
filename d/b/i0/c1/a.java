package d.b.i0.c1;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.hottopicselect.HotSelectCacheReqMessage;
import com.baidu.tieba.hottopicselect.HotSelectCacheResponseMessage;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof HotSelectCacheReqMessage)) {
            return null;
        }
        HotSelectCacheResponseMessage hotSelectCacheResponseMessage = new HotSelectCacheResponseMessage();
        try {
            hotSelectCacheResponseMessage.decodeInBackGround(2016491, (byte[]) null);
        } catch (Exception unused) {
        }
        return hotSelectCacheResponseMessage;
    }
}
