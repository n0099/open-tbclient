package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f73003a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC2008b f73004b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f73005c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f73006d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f73007e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f73008f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f73009g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f73010h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f73011i;

    public void a() {
        this.f73003a = null;
        this.f73005c = null;
        this.f73004b = null;
        this.f73006d = null;
        this.f73007e = null;
        this.f73008f = null;
        this.f73009g = null;
        this.f73010h = null;
        this.f73011i = null;
    }

    public final void a(int i2) {
        b.a aVar = this.f73005c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public void a(int i2, int i3) {
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar = this.f73007e;
        if (iVar != null) {
            iVar.a(this, i2, i3, i4, i5);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f73005c = aVar;
    }

    public final void a(b.InterfaceC2008b interfaceC2008b) {
        this.f73004b = interfaceC2008b;
    }

    public final void a(b.c cVar) {
        this.f73008f = cVar;
    }

    public final void a(b.d dVar) {
        this.f73009g = dVar;
    }

    public final void a(b.e eVar) {
        this.f73011i = eVar;
    }

    public final void a(b.f fVar) {
        this.f73003a = fVar;
    }

    public final void a(b.g gVar) {
        this.f73006d = gVar;
    }

    public final void a(b.i iVar) {
        this.f73007e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f73010h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i2, int i3, Object obj) {
        b.c cVar = this.f73008f;
        return cVar != null && cVar.a(this, i2, i3, obj);
    }

    public final void b() {
        b.f fVar = this.f73003a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i2, int i3, Object obj) {
        b.d dVar = this.f73009g;
        return dVar != null && dVar.b(this, i2, i3, obj);
    }

    public final void c() {
        b.InterfaceC2008b interfaceC2008b = this.f73004b;
        if (interfaceC2008b != null) {
            interfaceC2008b.b(this);
        }
    }

    public final boolean c(int i2, int i3, Object obj) {
        b.e eVar = this.f73011i;
        return eVar != null && eVar.c(this, i2, i3, obj);
    }

    public final void d() {
        b.g gVar = this.f73006d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
