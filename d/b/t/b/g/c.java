package d.b.t.b.g;

import android.opengl.EGLContext;
import d.b.t.b.f.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f65413e;

    /* renamed from: f  reason: collision with root package name */
    public d f65414f = new d();

    /* renamed from: g  reason: collision with root package name */
    public d.b.t.b.f.c f65415g = new d.b.t.b.f.c();

    /* renamed from: h  reason: collision with root package name */
    public d.b.t.b.f.a f65416h = new d.b.t.b.f.b();
    public a i = new a();
    public boolean j = false;
    public d.b.t.b.e.c k = null;
    public b l = new b();
    public int m;
    public boolean n;

    public c(EGLContext eGLContext, int i, boolean z) {
        this.f65413e = eGLContext;
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

    public d.b.t.b.f.a f() {
        return this.f65416h;
    }

    public EGLContext g() {
        return this.f65413e;
    }

    public d.b.t.b.e.c h() {
        return this.k;
    }

    public b i() {
        return this.l;
    }

    public d.b.t.b.f.c j() {
        return this.f65415g;
    }

    public d k() {
        return this.f65414f;
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
        this.f65413e = eGLContext;
    }

    public void p(d.b.t.b.e.c cVar) {
        this.k = cVar;
    }

    public void q(b bVar) {
        this.l = bVar;
    }

    public void r(d dVar) {
        this.f65414f = dVar;
    }
}
