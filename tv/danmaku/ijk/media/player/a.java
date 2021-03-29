package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f68675a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1898b f68676b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f68677c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f68678d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f68679e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f68680f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f68681g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f68682h;
    public b.e i;

    public void a() {
        this.f68675a = null;
        this.f68677c = null;
        this.f68676b = null;
        this.f68678d = null;
        this.f68679e = null;
        this.f68680f = null;
        this.f68681g = null;
        this.f68682h = null;
        this.i = null;
    }

    public final void a(int i) {
        b.a aVar = this.f68677c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        b.i iVar = this.f68679e;
        if (iVar != null) {
            iVar.a(this, i, i2, i3, i4);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f68677c = aVar;
    }

    public final void a(b.InterfaceC1898b interfaceC1898b) {
        this.f68676b = interfaceC1898b;
    }

    public final void a(b.c cVar) {
        this.f68680f = cVar;
    }

    public final void a(b.d dVar) {
        this.f68681g = dVar;
    }

    public final void a(b.e eVar) {
        this.i = eVar;
    }

    public final void a(b.f fVar) {
        this.f68675a = fVar;
    }

    public final void a(b.g gVar) {
        this.f68678d = gVar;
    }

    public final void a(b.i iVar) {
        this.f68679e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f68682h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i, int i2, Object obj) {
        b.c cVar = this.f68680f;
        return cVar != null && cVar.a(this, i, i2, obj);
    }

    public final void b() {
        b.f fVar = this.f68675a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i, int i2, Object obj) {
        b.d dVar = this.f68681g;
        return dVar != null && dVar.b(this, i, i2, obj);
    }

    public final void c() {
        b.InterfaceC1898b interfaceC1898b = this.f68676b;
        if (interfaceC1898b != null) {
            interfaceC1898b.b(this);
        }
    }

    public final boolean c(int i, int i2, Object obj) {
        b.e eVar = this.i;
        return eVar != null && eVar.c(this, i, i2, obj);
    }

    public final void d() {
        b.g gVar = this.f68678d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
