package d.b.g0.b.m.g;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import d.b.g0.a.i2.u;
/* loaded from: classes3.dex */
public class d extends ActivityDelegation {

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.b.g0.b.m.g.e
        public void onResult(int i) {
            d.this.mResult.putInt("quick_login", i);
            d.this.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        f.d(getAgent(), u.f(this.mParams, "quick_login_mode", 0), new a());
        return false;
    }
}
