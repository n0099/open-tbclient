package d.a.n0.e3.d0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.m0.v0.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f57642a = 1;

    public static String a(String str, int i2) {
        return TbConfig.SERVER_ADDRESS + str + "?cmd=" + i2;
    }

    public static d.a.m0.v0.a b(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            d.a.m0.v0.a aVar = new d.a.m0.v0.a(i2, cls.newInstance());
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

    public static TbHttpMessageTask c(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i3, a(str, i2));
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i3);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }

    public static void d(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        h(i3, cls2, false, false);
        c(i3, i2, str, cls, false, true, true, false);
    }

    public static TbHttpMessageTask e(int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }

    public static b f(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return g(i2, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
    }

    public static b g(int i2, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        b bVar = new b(i2);
        bVar.setResponsedClass(cls);
        bVar.h(z);
        bVar.f(dupLicateMode);
        bVar.setRetry(f57642a);
        MessageManager.getInstance().unRegisterTask(i2);
        MessageManager.getInstance().registerTask(bVar);
        bVar.setNeedEncrypt(z2);
        return bVar;
    }

    public static b h(int i2, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        return g(i2, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
    }
}
