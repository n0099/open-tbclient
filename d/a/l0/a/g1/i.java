package d.a.l0.a.g1;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<h>> f41930a = new ArrayList();

    public static void a(d.a.l0.a.p.e.d dVar) {
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar = f41930a.get(size).get();
            if (hVar == null) {
                f41930a.remove(size);
            } else {
                hVar.d(dVar);
            }
        }
    }

    public static void b(d.a.l0.a.p.e.d dVar) {
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar = f41930a.get(size).get();
            if (hVar == null) {
                f41930a.remove(size);
            } else {
                hVar.b(dVar);
            }
        }
    }

    public static void c(d.a.l0.a.p.e.d dVar) {
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar = f41930a.get(size).get();
            if (hVar == null) {
                f41930a.remove(size);
            } else {
                hVar.c(dVar);
            }
        }
    }

    public static void d(d.a.l0.a.p.e.d dVar) {
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar = f41930a.get(size).get();
            if (hVar == null) {
                f41930a.remove(size);
            } else {
                hVar.a(dVar);
            }
        }
    }

    public static void e(h hVar) {
        if (hVar == null) {
            return;
        }
        boolean z = false;
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar2 = f41930a.get(size).get();
            if (hVar2 == null) {
                f41930a.remove(size);
            } else {
                z = hVar2 == hVar;
            }
        }
        if (z) {
            return;
        }
        f41930a.add(new WeakReference<>(hVar));
    }

    public static void f(h hVar) {
        if (hVar == null) {
            return;
        }
        for (int size = f41930a.size() - 1; size >= 0; size--) {
            h hVar2 = f41930a.get(size).get();
            if (hVar2 == null || hVar == hVar2) {
                f41930a.remove(size);
            }
        }
    }
}
