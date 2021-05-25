package d.a.n0.h3;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
/* loaded from: classes5.dex */
public class b implements d.a.m0.r.a0.a {

    /* renamed from: a  reason: collision with root package name */
    public a f55599a;

    @Override // d.a.m0.r.a0.a
    public void a(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            b(context, 1);
        } else {
            b(context, 0);
        }
    }

    @Override // d.a.m0.r.a0.a
    public void b(Context context, int i2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i2)));
    }

    @Override // d.a.m0.r.a0.a
    public void c(Context context, int i2, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i2, z)));
    }

    @Override // d.a.m0.r.a0.a
    public Class<?> d() {
        return MainTabActivity.class;
    }

    @Override // d.a.m0.r.a0.a
    public void e(Context context, int i2, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i2, z)));
    }

    @Override // d.a.m0.r.a0.a
    public String f() {
        return MainTabActivity.class.getName();
    }

    public void g(a aVar) {
        this.f55599a = aVar;
    }

    @Override // d.a.m0.r.a0.a
    public int getCurrentTabType() {
        a aVar = this.f55599a;
        if (aVar != null) {
            return aVar.getCurrentTabType();
        }
        return -1;
    }
}
