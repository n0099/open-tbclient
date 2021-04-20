package d.b.g0.a.g1;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public volatile Set<String> f44937a;

    public final synchronized boolean a() {
        Set<String> set;
        set = this.f44937a;
        return (set != null ? set.size() : 0) < 5;
    }

    public final synchronized void b(WebSocketTask webSocketTask) {
        if (this.f44937a == null) {
            this.f44937a = new LinkedHashSet();
        }
        Set<String> set = this.f44937a;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void c(String str) {
        Set<String> set = this.f44937a;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void d() {
        Set<String> set = this.f44937a;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.f44937a;
        if (set2 != null) {
            set2.clear();
        }
    }
}
