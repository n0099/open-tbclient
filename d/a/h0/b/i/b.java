package d.a.h0.b.i;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation implements d.a.h0.a.i2.u0.b<Bundle> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: a */
    public void onCallback(Bundle bundle) {
        this.mResult.putBundle("result", bundle);
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        boolean c2 = d.a.h0.a.i2.u.c(this.mParams, "isRealName", false);
        String g2 = d.a.h0.a.i2.u.g(this.mParams, "swanAppId");
        if (c2) {
            a.K(getAgent(), g2, this);
        } else {
            a.N(getAgent(), g2, this);
        }
        return false;
    }
}
