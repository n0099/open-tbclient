package d.b.i0.w0;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.b.b.e.p.l;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.w0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC1645a implements Runnable {
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

    public static boolean c(int i) {
        switch (i) {
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
        if (!l.B()) {
            TbadkCoreApplication.getInst().handler.post(new RunnableC1645a());
        } else {
            e();
        }
    }

    public static final void e() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        d.b.h0.l.a.q(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
    }
}
