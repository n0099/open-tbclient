package d.a.l0.a.u.f.b;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45221b = k.f43199a;

    @Override // d.a.l0.a.u.f.b.b
    public void a() {
        for (BasePendingOperation basePendingOperation : this.f45219a) {
            if (f45221b) {
                Log.d("NetworkOperation", "       *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            q.c(basePendingOperation, "operation_request", 100L, TimeUnit.MILLISECONDS);
        }
        this.f45219a.clear();
    }
}
