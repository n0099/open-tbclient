package d.a.l0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48894b = k.f46875a;

    @Override // d.a.l0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f48893a) {
            if (f48894b) {
                Log.d("MainThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q0.b0(basePendingOperation);
        }
        this.f48893a.clear();
    }
}
