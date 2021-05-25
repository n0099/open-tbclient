package d.a.l0.b.j;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes3.dex */
public class k extends ActivityDelegation implements d.a.l0.a.m.a {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (!this.mParams.getBoolean("key_login_force", false) && a.F(getAgent())) {
            this.mResult.putInt("result_code", 0);
            finish();
            return true;
        }
        a.M(getAgent(), this.mParams.getBundle("key_login_params"), this);
        return false;
    }

    @Override // d.a.l0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("result_code", i2);
        finish();
    }
}
