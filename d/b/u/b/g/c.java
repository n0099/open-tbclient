package d.b.u.b.g;

import android.opengl.EGLContext;
import d.b.u.b.f.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f65677e;

    /* renamed from: f  reason: collision with root package name */
    public d f65678f = new d();

    /* renamed from: g  reason: collision with root package name */
    public d.b.u.b.f.c f65679g = new d.b.u.b.f.c();

    /* renamed from: h  reason: collision with root package name */
    public d.b.u.b.f.a f65680h = new d.b.u.b.f.b();
    public a i = new a();
    public boolean j = false;
    public d.b.u.b.e.c k = null;
    public b l = new b();
    public int m;
    public boolean n;

    public c(EGLContext eGLContext, int i, boolean z) {
        this.f65677e = eGLContext;
        this.m = i;
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
            cVar.n(this.i.clone());
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
        return this.i;
    }

    public int e() {
        return this.m;
    }

    public d.b.u.b.f.a f() {
        return this.f65680h;
    }

    public EGLContext g() {
        return this.f65677e;
    }

    public d.b.u.b.e.c h() {
        return this.k;
    }

    public b i() {
        return this.l;
    }

    public d.b.u.b.f.c j() {
        return this.f65679g;
    }

    public d k() {
        return this.f65678f;
    }

    public boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.j;
    }

    public void n(a aVar) {
        this.i = aVar;
    }

    public void o(EGLContext eGLContext) {
        this.f65677e = eGLContext;
    }

    public void p(d.b.u.b.e.c cVar) {
        this.k = cVar;
    }

    public void q(b bVar) {
        this.l = bVar;
    }

    public void r(d dVar) {
        this.f65678f = dVar;
    }
}
