package d.a.h0.b.m.g;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import d.a.h0.a.i2.u;
/* loaded from: classes3.dex */
public class d extends ActivityDelegation {

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.h0.b.m.g.e
        public void onResult(int i2) {
            d.this.mResult.putInt("quick_login", i2);
            d.this.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        f.d(getAgent(), u.f(this.mParams, "quick_login_mode", 0), new a());
        return false;
    }
}
