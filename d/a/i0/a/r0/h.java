package d.a.i0.a.r0;

import d.a.i0.a.v2.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f44219e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f44220f;

    /* renamed from: g  reason: collision with root package name */
    public String f44221g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f44222h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f44223i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f44219e = iVar;
        this.f44220f = runnable;
        this.f44221g = str;
        this.f44222h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f44222h;
    }

    public String c() {
        return this.f44221g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.f44223i.get();
    }

    public void f() {
        q.j(this, this.f44221g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f44220f.run();
    }

    public void i() {
        this.f44223i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f44219e.g(this);
        }
    }
}
