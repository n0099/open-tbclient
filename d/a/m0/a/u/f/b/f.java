package d.a.m0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49005b = k.f46983a;

    @Override // d.a.m0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f49001a) {
            if (f49005b) {
                Log.d("WorkThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q.i(basePendingOperation, "operation_work");
        }
        this.f49001a.clear();
    }
}
