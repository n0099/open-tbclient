package d.a.l0.a.n1;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public volatile Set<String> f47399a;

    public final synchronized boolean a() {
        Set<String> set;
        set = this.f47399a;
        return (set != null ? set.size() : 0) < 5;
    }

    public final synchronized void b(WebSocketTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.f47399a == null) {
            this.f47399a = new LinkedHashSet();
        }
        Set<String> set = this.f47399a;
        if (set != null) {
            set.add(task.getTaskId());
        }
    }

    public final synchronized void c(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Set<String> set = this.f47399a;
        if (set != null) {
            set.remove(taskId);
        }
    }

    public final synchronized void d() {
        Set<String> set = this.f47399a;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.f47399a;
        if (set2 != null) {
            set2.clear();
        }
    }
}
