package d.a.m0.a.u.f.b.g;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.m0.a.k;
import d.a.m0.a.u.f.b.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49007b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d.a.m0.a.u.f.b.a> f49008a = new LinkedHashMap();

    public synchronized void a(BasePendingOperation basePendingOperation) {
        if (basePendingOperation == null) {
            return;
        }
        if (f49007b) {
            Log.d("PendingOperationHandler", "*************** 【Add pending module】:" + basePendingOperation.b() + " params: " + basePendingOperation.c());
        }
        c(basePendingOperation.d()).b(basePendingOperation);
    }

    public synchronized void b() {
        for (Map.Entry<String, d.a.m0.a.u.f.b.a> entry : this.f49008a.entrySet()) {
            entry.getValue().c();
        }
        this.f49008a.clear();
    }

    public final d.a.m0.a.u.f.b.a c(BasePendingOperation.OperationType operationType) {
        if (!this.f49008a.containsKey(operationType.name())) {
            d.a.m0.a.u.f.b.a a2 = e.a(operationType);
            this.f49008a.put(operationType.name(), a2);
            return a2;
        }
        return this.f49008a.get(operationType.name());
    }

    public synchronized void d() {
        for (Map.Entry<String, d.a.m0.a.u.f.b.a> entry : this.f49008a.entrySet()) {
            entry.getValue().a();
        }
    }
}
