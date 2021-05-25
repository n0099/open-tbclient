package d.a.l0.a.r0;

import d.a.l0.a.v2.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f44395e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f44396f;

    /* renamed from: g  reason: collision with root package name */
    public String f44397g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f44398h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f44399i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f44395e = iVar;
        this.f44396f = runnable;
        this.f44397g = str;
        this.f44398h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f44398h;
    }

    public String c() {
        return this.f44397g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.f44399i.get();
    }

    public void f() {
        q.j(this, this.f44397g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f44396f.run();
    }

    public void i() {
        this.f44399i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f44395e.g(this);
        }
    }
}
