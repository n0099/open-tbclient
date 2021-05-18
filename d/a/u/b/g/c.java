package d.a.u.b.g;

import android.opengl.EGLContext;
import d.a.u.b.f.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f64713e;

    /* renamed from: f  reason: collision with root package name */
    public d f64714f = new d();

    /* renamed from: g  reason: collision with root package name */
    public d.a.u.b.f.c f64715g = new d.a.u.b.f.c();

    /* renamed from: h  reason: collision with root package name */
    public d.a.u.b.f.a f64716h = new d.a.u.b.f.b();

    /* renamed from: i  reason: collision with root package name */
    public a f64717i = new a();
    public boolean j = false;
    public d.a.u.b.e.c k = null;
    public b l = new b();
    public int m;
    public boolean n;

    public c(EGLContext eGLContext, int i2, boolean z) {
        this.f64713e = eGLContext;
        this.m = i2;
        this.n = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.n(this.f64717i.clone());
            cVar.q(this.l.clone());
        }
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(c cVar) {
        return this.m < cVar.e() ? -1 : 1;
    }

    public a d() {
        return this.f64717i;
    }

    public int e() {
        return this.m;
    }

    public d.a.u.b.f.a f() {
        return this.f64716h;
    }

    public EGLContext g() {
        return this.f64713e;
    }

    public d.a.u.b.e.c h() {
        return this.k;
    }

    public b i() {
        return this.l;
    }

    public d.a.u.b.f.c j() {
        return this.f64715g;
    }

    public d k() {
        return this.f64714f;
    }

    public boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.j;
    }

    public void n(a aVar) {
        this.f64717i = aVar;
    }

    public void o(EGLContext eGLContext) {
        this.f64713e = eGLContext;
    }

    public void p(d.a.u.b.e.c cVar) {
        this.k = cVar;
    }

    public void q(b bVar) {
        this.l = bVar;
    }

    public void r(d dVar) {
        this.f64714f = dVar;
    }
}
