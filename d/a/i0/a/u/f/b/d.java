package d.a.i0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45045b = k.f43025a;

    @Override // d.a.i0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f45043a) {
            if (f45045b) {
                Log.d("NetworkOperation", "       *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q.c(basePendingOperation, "operation_request", 100L, TimeUnit.MILLISECONDS);
        }
        this.f45043a.clear();
    }
}
