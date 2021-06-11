package d.a.l0.a.r0;

import d.a.l0.a.v2.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f48069e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f48070f;

    /* renamed from: g  reason: collision with root package name */
    public String f48071g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f48072h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f48073i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f48069e = iVar;
        this.f48070f = runnable;
        this.f48071g = str;
        this.f48072h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f48072h;
    }

    public String c() {
        return this.f48071g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.f48073i.get();
    }

    public void f() {
        q.j(this, this.f48071g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f48070f.run();
    }

    public void i() {
        this.f48073i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f48069e.g(this);
        }
    }
}
