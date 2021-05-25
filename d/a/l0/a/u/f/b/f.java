package d.a.l0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45223b = k.f43199a;

    @Override // d.a.l0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f45219a) {
            if (f45223b) {
                Log.d("WorkThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q.i(basePendingOperation, "operation_work");
        }
        this.f45219a.clear();
    }
}
