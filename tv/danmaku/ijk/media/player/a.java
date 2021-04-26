package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f68931a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1891b f68932b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f68933c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f68934d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f68935e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f68936f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f68937g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f68938h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f68939i;

    public void a() {
        this.f68931a = null;
        this.f68933c = null;
        this.f68932b = null;
        this.f68934d = null;
        this.f68935e = null;
        this.f68936f = null;
        this.f68937g = null;
        this.f68938h = null;
        this.f68939i = null;
    }

    public final void a(int i2) {
        b.a aVar = this.f68933c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar = this.f68935e;
        if (iVar != null) {
            iVar.a(this, i2, i3, i4, i5);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f68933c = aVar;
    }

    public final void a(b.InterfaceC1891b interfaceC1891b) {
        this.f68932b = interfaceC1891b;
    }

    public final void a(b.c cVar) {
        this.f68936f = cVar;
    }

    public final void a(b.d dVar) {
        this.f68937g = dVar;
    }

    public final void a(b.e eVar) {
        this.f68939i = eVar;
    }

    public final void a(b.f fVar) {
        this.f68931a = fVar;
    }

    public final void a(b.g gVar) {
        this.f68934d = gVar;
    }

    public final void a(b.i iVar) {
        this.f68935e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f68938h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i2, int i3, Object obj) {
        b.c cVar = this.f68936f;
        return cVar != null && cVar.a(this, i2, i3, obj);
    }

    public final void b() {
        b.f fVar = this.f68931a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i2, int i3, Object obj) {
        b.d dVar = this.f68937g;
        return dVar != null && dVar.b(this, i2, i3, obj);
    }

    public final void c() {
        b.InterfaceC1891b interfaceC1891b = this.f68932b;
        if (interfaceC1891b != null) {
            interfaceC1891b.b(this);
        }
    }

    public final boolean c(int i2, int i3, Object obj) {
        b.e eVar = this.f68939i;
        return eVar != null && eVar.c(this, i2, i3, obj);
    }

    public final void d() {
        b.g gVar = this.f68934d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
