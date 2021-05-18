package d.a.k0.e1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes4.dex */
public class c {
    public static d.a.j0.v0.a a(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            d.a.j0.v0.a aVar = new d.a.j0.v0.a(i2, cls.newInstance());
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

    public static d.a.j0.v0.b b(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        d.a.j0.v0.b bVar = new d.a.j0.v0.b(i2);
        bVar.setResponsedClass(cls);
        bVar.h(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }
}
