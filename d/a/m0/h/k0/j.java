package d.a.m0.h.k0;

import com.baidu.searchbox.v8engine.JSRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final j f51218c = new j();

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<g> f51216a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Integer> f51217b = new ArrayList<>();

    public final void a(int i2) {
        if (f51217b.contains(Integer.valueOf(i2))) {
            return;
        }
        f51217b.add(Integer.valueOf(i2));
    }

    public final g b(JSRuntime jsRuntime) {
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        g gVar = new g(jsRuntime);
        f51216a.add(gVar);
        return gVar;
    }

    public final boolean c(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return !f51216a.contains(socket);
    }

    public final boolean d(int i2) {
        return f51217b.contains(Integer.valueOf(i2));
    }

    public final void e(g socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (f51216a.contains(socket)) {
            g(socket.C());
            f51216a.remove(socket);
        }
    }

    public final void f() {
        Iterator<g> it = f51216a.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public final void g(int i2) {
        f51217b.remove(Integer.valueOf(i2));
    }
}
