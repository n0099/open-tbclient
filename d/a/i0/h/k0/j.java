package d.a.i0.h.k0;

import com.baidu.searchbox.v8engine.JSRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final j f47260c = new j();

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<g> f47258a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Integer> f47259b = new ArrayList<>();

    public final void a(int i2) {
        if (f47259b.contains(Integer.valueOf(i2))) {
            return;
        }
        f47259b.add(Integer.valueOf(i2));
    }

    public final g b(JSRuntime jsRuntime) {
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        g gVar = new g(jsRuntime);
        f47258a.add(gVar);
        return gVar;
    }

    public final boolean c(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return !f47258a.contains(socket);
    }

    public final boolean d(int i2) {
        return f47259b.contains(Integer.valueOf(i2));
    }

    public final void e(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (f47258a.contains(socket)) {
            g(socket.C());
            f47258a.remove(socket);
        }
    }

    public final void f() {
        Iterator<g> it = f47258a.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public final void g(int i2) {
        f47259b.remove(Integer.valueOf(i2));
    }
}
