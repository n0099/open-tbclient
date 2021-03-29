package d.b.i0.y0;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.b.i0.z0.c.c;
/* loaded from: classes3.dex */
public class a extends CustomMessageTask {

    /* loaded from: classes3.dex */
    public static class b implements CustomMessageTask.CustomRunnable<c> {
        public b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            d.b.i0.i1.s.a a2;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.d() == null && (a2 = d.b.i0.i1.r.b.d().a(data.c(), data.f())) != null) {
                    a2.b(new d.b.i0.y0.b(data.e()));
                    data.i(a2);
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
