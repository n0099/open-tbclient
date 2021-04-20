package d.b.g0.g.l;

import d.b.g0.a.i2.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f48845e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f48846f;

    /* renamed from: g  reason: collision with root package name */
    public String f48847g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f48848h;
    public AtomicBoolean i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f48845e = iVar;
        this.f48846f = runnable;
        this.f48847g = str;
        this.f48848h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f48848h;
    }

    public String c() {
        return this.f48847g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.i.get();
    }

    public void f() {
        p.k(this, this.f48847g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f48846f.run();
    }

    public void i() {
        this.i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f48845e.g(this);
        }
    }
}
