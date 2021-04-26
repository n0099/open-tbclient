package d.a.h0.g.l;

import d.a.h0.a.i2.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final i f46666e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f46667f;

    /* renamed from: g  reason: collision with root package name */
    public String f46668g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f46669h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f46670i = new AtomicBoolean(false);
    public List<h> j = Collections.synchronizedList(new ArrayList());

    public h(i iVar, Runnable runnable, String str, String[] strArr) {
        this.f46666e = iVar;
        this.f46667f = runnable;
        this.f46668g = str;
        this.f46669h = strArr;
    }

    public void a(h hVar) {
        if (this.j.contains(hVar)) {
            return;
        }
        this.j.add(hVar);
    }

    public String[] b() {
        return this.f46669h;
    }

    public String c() {
        return this.f46668g;
    }

    public boolean d() {
        return this.j.isEmpty();
    }

    public boolean e() {
        return this.f46670i.get();
    }

    public void f() {
        p.k(this, this.f46668g);
    }

    public void g(h hVar) {
        this.j.remove(hVar);
    }

    public void h() {
        this.f46667f.run();
    }

    public void i() {
        this.f46670i.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
        } finally {
            this.f46666e.g(this);
        }
    }
}
