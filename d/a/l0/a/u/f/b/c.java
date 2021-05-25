package d.a.l0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45220b = k.f43199a;

    @Override // d.a.l0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f45219a) {
            if (f45220b) {
                Log.d("MainThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q0.b0(basePendingOperation);
        }
        this.f45219a.clear();
    }
}
