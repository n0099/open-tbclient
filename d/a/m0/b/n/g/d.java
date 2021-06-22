package d.a.m0.b.n.g;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import d.a.m0.a.v2.v;
/* loaded from: classes3.dex */
public class d extends ActivityDelegation {

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.m0.b.n.g.e
        public void onResult(int i2) {
            d.this.mResult.putInt("quick_login", i2);
            d.this.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        f.d(getAgent(), v.f(this.mParams, "quick_login_mode", 0), new a());
        return false;
    }
}
