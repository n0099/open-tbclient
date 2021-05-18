package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f69613a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1954b f69614b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f69615c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f69616d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f69617e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f69618f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f69619g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f69620h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f69621i;

    public void a() {
        this.f69613a = null;
        this.f69615c = null;
        this.f69614b = null;
        this.f69616d = null;
        this.f69617e = null;
        this.f69618f = null;
        this.f69619g = null;
        this.f69620h = null;
        this.f69621i = null;
    }

    public final void a(int i2) {
        b.a aVar = this.f69615c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar = this.f69617e;
        if (iVar != null) {
            iVar.a(this, i2, i3, i4, i5);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f69615c = aVar;
    }

    public final void a(b.InterfaceC1954b interfaceC1954b) {
        this.f69614b = interfaceC1954b;
    }

    public final void a(b.c cVar) {
        this.f69618f = cVar;
    }

    public final void a(b.d dVar) {
        this.f69619g = dVar;
    }

    public final void a(b.e eVar) {
        this.f69621i = eVar;
    }

    public final void a(b.f fVar) {
        this.f69613a = fVar;
    }

    public final void a(b.g gVar) {
        this.f69616d = gVar;
    }

    public final void a(b.i iVar) {
        this.f69617e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f69620h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i2, int i3, Object obj) {
        b.c cVar = this.f69618f;
        return cVar != null && cVar.a(this, i2, i3, obj);
    }

    public final void b() {
        b.f fVar = this.f69613a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i2, int i3, Object obj) {
        b.d dVar = this.f69619g;
        return dVar != null && dVar.b(this, i2, i3, obj);
    }

    public final void c() {
        b.InterfaceC1954b interfaceC1954b = this.f69614b;
        if (interfaceC1954b != null) {
            interfaceC1954b.b(this);
        }
    }

    public final boolean c(int i2, int i3, Object obj) {
        b.e eVar = this.f69621i;
        return eVar != null && eVar.c(this, i2, i3, obj);
    }

    public final void d() {
        b.g gVar = this.f69616d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
