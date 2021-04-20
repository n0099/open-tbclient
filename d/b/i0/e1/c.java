package d.b.i0.e1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes4.dex */
public class c {
    public static d.b.h0.v0.a a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            d.b.h0.v0.a aVar = new d.b.h0.v0.a(i, cls.newInstance());
            MessageManager.getInstance().registerTask(aVar);
            return aVar;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static d.b.h0.v0.b b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(i);
        bVar.setResponsedClass(cls);
        bVar.h(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }
}
