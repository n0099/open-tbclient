package d.a.m0.a.r0;

import d.a.m0.a.v2.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f48177e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f48178f;

    /* renamed from: g  reason: collision with root package name */
    public String f48179g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f48180h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f48181i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f48177e = iVar;
        this.f48178f = runnable;
        this.f48179g = str;
        this.f48180h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f48180h;
    }

    public String c() {
        return this.f48179g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.f48181i.get();
    }

    public void f() {
        q.j(this, this.f48179g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f48178f.run();
    }

    public void i() {
        this.f48181i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f48177e.g(this);
        }
    }
}
