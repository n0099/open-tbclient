package d.a.m0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49002b = k.f46983a;

    @Override // d.a.m0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f49001a) {
            if (f49002b) {
                Log.d("MainThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q0.b0(basePendingOperation);
        }
        this.f49001a.clear();
    }
}
