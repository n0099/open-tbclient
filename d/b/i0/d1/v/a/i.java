package d.b.i0.d1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int d2 = d.b.b.e.m.b.d(customMessage.getData(), 0);
        if (d.b.i0.d1.h.l.t().o(String.valueOf(d2))) {
            return new CustomResponsedMessage<>(2001151, String.valueOf(d2));
        }
        return null;
    }
}
