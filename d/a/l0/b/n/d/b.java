package d.a.l0.b.n.d;

import android.content.Intent;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation implements d.a.l0.a.m.a {
    public final void a() {
        c.b();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        Intent intent = new Intent(getAgent(), LoginAndGetMobileActivity.class);
        intent.putExtras(this.mParams);
        getAgent().startActivity(intent);
        getAgent().overridePendingTransition(d.a.l0.b.b.login_get_mobile_act_enter, 0);
        c.c(this);
        return false;
    }

    @Override // d.a.l0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("loginStatusCode", i2);
        a();
    }
}
