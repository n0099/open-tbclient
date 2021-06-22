package d.a.m0.h.y.h;

import com.baidu.searchbox.websocket.WebSocketTask;
import d.a.m0.a.n1.k;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b {
    public final boolean a() {
        k d2 = d();
        if (d2 != null) {
            return d2.a();
        }
        return false;
    }

    public final void b(WebSocketTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        k d2 = d();
        if (d2 != null) {
            d2.b(task);
        }
    }

    public final void c(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        k d2 = d();
        if (d2 != null) {
            d2.c(taskId);
        }
    }

    public final k d() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 != null) {
            return i2.b0();
        }
        return null;
    }
}
