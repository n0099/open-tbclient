package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f69683a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1933b f69684b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f69685c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f69686d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f69687e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f69688f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f69689g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f69690h;
    public b.e i;

    public void a() {
        this.f69683a = null;
        this.f69685c = null;
        this.f69684b = null;
        this.f69686d = null;
        this.f69687e = null;
        this.f69688f = null;
        this.f69689g = null;
        this.f69690h = null;
        this.i = null;
    }

    public final void a(int i) {
        b.a aVar = this.f69685c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        b.i iVar = this.f69687e;
        if (iVar != null) {
            iVar.a(this, i, i2, i3, i4);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f69685c = aVar;
    }

    public final void a(b.InterfaceC1933b interfaceC1933b) {
        this.f69684b = interfaceC1933b;
    }

    public final void a(b.c cVar) {
        this.f69688f = cVar;
    }

    public final void a(b.d dVar) {
        this.f69689g = dVar;
    }

    public final void a(b.e eVar) {
        this.i = eVar;
    }

    public final void a(b.f fVar) {
        this.f69683a = fVar;
    }

    public final void a(b.g gVar) {
        this.f69686d = gVar;
    }

    public final void a(b.i iVar) {
        this.f69687e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f69690h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i, int i2, Object obj) {
        b.c cVar = this.f69688f;
        return cVar != null && cVar.a(this, i, i2, obj);
    }

    public final void b() {
        b.f fVar = this.f69683a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i, int i2, Object obj) {
        b.d dVar = this.f69689g;
        return dVar != null && dVar.b(this, i, i2, obj);
    }

    public final void c() {
        b.InterfaceC1933b interfaceC1933b = this.f69684b;
        if (interfaceC1933b != null) {
            interfaceC1933b.b(this);
        }
    }

    public final boolean c(int i, int i2, Object obj) {
        b.e eVar = this.i;
        return eVar != null && eVar.c(this, i, i2, obj);
    }

    public final void d() {
        b.g gVar = this.f69686d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
