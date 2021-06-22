package d.a.m0.b.j;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes3.dex */
public class b extends ActivityDelegation implements d.a.m0.a.v2.e1.b<Bundle> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(Bundle bundle) {
        this.mResult.putBundle("result", bundle);
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        boolean c2 = d.a.m0.a.v2.v.c(this.mParams, "isRealName", false);
        String g2 = d.a.m0.a.v2.v.g(this.mParams, "swanAppId");
        if (c2) {
            a.I(getAgent(), g2, this);
        } else {
            a.L(getAgent(), g2, this);
        }
        return false;
    }
}
