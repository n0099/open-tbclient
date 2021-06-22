package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f73107a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC2011b f73108b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f73109c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f73110d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f73111e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f73112f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f73113g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f73114h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f73115i;

    public void a() {
        this.f73107a = null;
        this.f73109c = null;
        this.f73108b = null;
        this.f73110d = null;
        this.f73111e = null;
        this.f73112f = null;
        this.f73113g = null;
        this.f73114h = null;
        this.f73115i = null;
    }

    public final void a(int i2) {
        b.a aVar = this.f73109c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public void a(int i2, int i3) {
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar = this.f73111e;
        if (iVar != null) {
            iVar.a(this, i2, i3, i4, i5);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f73109c = aVar;
    }

    public final void a(b.InterfaceC2011b interfaceC2011b) {
        this.f73108b = interfaceC2011b;
    }

    public final void a(b.c cVar) {
        this.f73112f = cVar;
    }

    public final void a(b.d dVar) {
        this.f73113g = dVar;
    }

    public final void a(b.e eVar) {
        this.f73115i = eVar;
    }

    public final void a(b.f fVar) {
        this.f73107a = fVar;
    }

    public final void a(b.g gVar) {
        this.f73110d = gVar;
    }

    public final void a(b.i iVar) {
        this.f73111e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f73114h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i2, int i3, Object obj) {
        b.c cVar = this.f73112f;
        return cVar != null && cVar.a(this, i2, i3, obj);
    }

    public final void b() {
        b.f fVar = this.f73107a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i2, int i3, Object obj) {
        b.d dVar = this.f73113g;
        return dVar != null && dVar.b(this, i2, i3, obj);
    }

    public final void c() {
        b.InterfaceC2011b interfaceC2011b = this.f73108b;
        if (interfaceC2011b != null) {
            interfaceC2011b.b(this);
        }
    }

    public final boolean c(int i2, int i3, Object obj) {
        b.e eVar = this.f73115i;
        return eVar != null && eVar.c(this, i2, i3, obj);
    }

    public final void d() {
        b.g gVar = this.f73110d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
