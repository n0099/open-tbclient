package d.a.n0.a1;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.a.n0.b1.d.c;
/* loaded from: classes4.dex */
public class a extends CustomMessageTask {

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<c> {
        public b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            d.a.n0.k1.s.a c2;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.d() == null && (c2 = d.a.n0.k1.r.b.d().c(data.c(), data.f())) != null) {
                    c2.b(new d.a.n0.a1.b(data.e()));
                    data.i(c2);
                }
            }
            return null;
        }
    }

    public a() {
        super(2001406, new b());
        setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
    }
}
