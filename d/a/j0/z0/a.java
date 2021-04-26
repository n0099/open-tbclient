package d.a.j0.z0;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.a.j0.a1.c.c;
/* loaded from: classes4.dex */
public class a extends CustomMessageTask {

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<c> {
        public b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            d.a.j0.j1.s.a c2;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.d() == null && (c2 = d.a.j0.j1.r.b.d().c(data.c(), data.f())) != null) {
                    c2.b(new d.a.j0.z0.b(data.e()));
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
