package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f68670a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1897b f68671b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f68672c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f68673d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f68674e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f68675f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f68676g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f68677h;
    public b.e i;

    public void a() {
        this.f68670a = null;
        this.f68672c = null;
        this.f68671b = null;
        this.f68673d = null;
        this.f68674e = null;
        this.f68675f = null;
        this.f68676g = null;
        this.f68677h = null;
        this.i = null;
    }

    public final void a(int i) {
        b.a aVar = this.f68672c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        b.i iVar = this.f68674e;
        if (iVar != null) {
            iVar.a(this, i, i2, i3, i4);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f68672c = aVar;
    }

    public final void a(b.InterfaceC1897b interfaceC1897b) {
        this.f68671b = interfaceC1897b;
    }

    public final void a(b.c cVar) {
        this.f68675f = cVar;
    }

    public final void a(b.d dVar) {
        this.f68676g = dVar;
    }

    public final void a(b.e eVar) {
        this.i = eVar;
    }

    public final void a(b.f fVar) {
        this.f68670a = fVar;
    }

    public final void a(b.g gVar) {
        this.f68673d = gVar;
    }

    public final void a(b.i iVar) {
        this.f68674e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f68677h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i, int i2, Object obj) {
        b.c cVar = this.f68675f;
        return cVar != null && cVar.a(this, i, i2, obj);
    }

    public final void b() {
        b.f fVar = this.f68670a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i, int i2, Object obj) {
        b.d dVar = this.f68676g;
        return dVar != null && dVar.b(this, i, i2, obj);
    }

    public final void c() {
        b.InterfaceC1897b interfaceC1897b = this.f68671b;
        if (interfaceC1897b != null) {
            interfaceC1897b.b(this);
        }
    }

    public final boolean c(int i, int i2, Object obj) {
        b.e eVar = this.i;
        return eVar != null && eVar.c(this, i, i2, obj);
    }

    public final void d() {
        b.g gVar = this.f68673d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
