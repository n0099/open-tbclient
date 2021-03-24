package d.b.i0.c3.d0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.b.h0.v0.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f53332a = 1;

    public static String a(String str, int i) {
        return TbConfig.SERVER_ADDRESS + str + "?cmd=" + i;
    }

    public static d.b.h0.v0.a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
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

    public static TbHttpMessageTask c(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, a(str, i));
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }

    public static void d(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        h(i2, cls2, false, false);
        c(i2, i, str, cls, false, true, true, false);
    }

    public static TbHttpMessageTask e(int i, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }

    public static b f(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
    }

    public static b g(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        b bVar = new b(i);
        bVar.setResponsedClass(cls);
        bVar.h(z);
        bVar.f(dupLicateMode);
        bVar.setRetry(f53332a);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(bVar);
        bVar.setNeedEncrypt(z2);
        return bVar;
    }

    public static b h(int i, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
    }
}
