package d.a.n0.y0;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.a.c.e.p.l;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.n0.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC1802a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.e();
        }
    }

    public static boolean b(NetWork netWork) {
        if (netWork == null) {
            return false;
        }
        if ((netWork.isNetSuccess() ? netWork.getServerErrorCode() : netWork.getNetErrorCode()) == 1990055) {
            d();
            return true;
        }
        return false;
    }

    public static boolean c(int i2) {
        switch (i2) {
            case 202001:
            case 205001:
            case 309456:
            case CmdConfigHttp.CMD_CHECK_REAL_NAME /* 1003325 */:
                return true;
            default:
                return false;
        }
    }

    public static void d() {
        if (!l.C()) {
            TbadkCoreApplication.getInst().handler.post(new RunnableC1802a());
        } else {
            e();
        }
    }

    public static final void e() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        d.a.m0.l.a.q(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
    }
}
