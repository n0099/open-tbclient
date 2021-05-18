package d.a.j0.l0;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f49455a;

    public static synchronized d c() {
        d dVar;
        synchronized (d.class) {
            if (f49455a == null) {
                f49455a = new d();
            }
            dVar = f49455a;
        }
        return dVar;
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig != null && context != null) {
            if (!g()) {
                h(R.string.plugin_pay_wallet_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
            return;
        }
        h(R.string.plugin_pay_error);
    }

    public void b(String str, TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
    }

    public boolean d() {
        try {
            Class.forName("com.baidu.wallet.api.BaiduWallet");
            return true;
        } catch (ClassNotFoundException e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public boolean e() {
        try {
            Class.forName("com.baidu.wallet.lightapp.business.LightappBrowseActivity");
            return true;
        } catch (ClassNotFoundException e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public boolean f() {
        try {
            Class.forName("com.baidu.wallet.home.WalletNewHomeActivity");
            return true;
        } catch (ClassNotFoundException e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public boolean g() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001351) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && d();
    }

    public final void h(int i2) {
        l.L(TbadkCoreApplication.getInst().getContext(), i2);
    }
}
