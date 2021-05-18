package d.a.k0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes4.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int d2 = d.a.c.e.m.b.d(customMessage.getData(), 0);
        if (d.a.k0.e1.h.l.t().o(String.valueOf(d2))) {
            return new CustomResponsedMessage<>(2001151, String.valueOf(d2));
        }
        return null;
    }
}
