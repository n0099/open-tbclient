package d.a.l0.h.k0;

import com.baidu.searchbox.v8engine.JSRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final j f47436c = new j();

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<g> f47434a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Integer> f47435b = new ArrayList<>();

    public final void a(int i2) {
        if (f47435b.contains(Integer.valueOf(i2))) {
            return;
        }
        f47435b.add(Integer.valueOf(i2));
    }

    public final g b(JSRuntime jsRuntime) {
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        g gVar = new g(jsRuntime);
        f47434a.add(gVar);
        return gVar;
    }

    public final boolean c(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return !f47434a.contains(socket);
    }

    public final boolean d(int i2) {
        return f47435b.contains(Integer.valueOf(i2));
    }

    public final void e(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (f47434a.contains(socket)) {
            g(socket.C());
            f47434a.remove(socket);
        }
    }

    public final void f() {
        Iterator<g> it = f47434a.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public final void g(int i2) {
        f47435b.remove(Integer.valueOf(i2));
    }
}
