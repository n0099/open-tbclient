package d.b.i0.f3;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
/* loaded from: classes5.dex */
public class b implements d.b.h0.r.a0.a {

    /* renamed from: a  reason: collision with root package name */
    public a f54823a;

    @Override // d.b.h0.r.a0.a
    public void a(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            e(context, 1);
        } else {
            e(context, 0);
        }
    }

    @Override // d.b.h0.r.a0.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // d.b.h0.r.a0.a
    public Class<?> c() {
        return MainTabActivity.class;
    }

    @Override // d.b.h0.r.a0.a
    public void d(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // d.b.h0.r.a0.a
    public void e(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // d.b.h0.r.a0.a
    public String f() {
        return MainTabActivity.class.getName();
    }

    public void g(a aVar) {
        this.f54823a = aVar;
    }

    @Override // d.b.h0.r.a0.a
    public int getCurrentTabType() {
        a aVar = this.f54823a;
        if (aVar != null) {
            return aVar.getCurrentTabType();
        }
        return -1;
    }
}
