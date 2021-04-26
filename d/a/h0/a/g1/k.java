package d.a.h0.a.g1;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public volatile Set<String> f42579a;

    public final synchronized boolean a() {
        Set<String> set;
        set = this.f42579a;
        return (set != null ? set.size() : 0) < 5;
    }

    public final synchronized void b(WebSocketTask webSocketTask) {
        if (this.f42579a == null) {
            this.f42579a = new LinkedHashSet();
        }
        Set<String> set = this.f42579a;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void c(String str) {
        Set<String> set = this.f42579a;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void d() {
        Set<String> set = this.f42579a;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.f42579a;
        if (set2 != null) {
            set2.clear();
        }
    }
}
