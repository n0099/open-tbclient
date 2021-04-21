package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f69830a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1937b f69831b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f69832c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f69833d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f69834e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f69835f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f69836g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f69837h;
    public b.e i;

    public void a() {
        this.f69830a = null;
        this.f69832c = null;
        this.f69831b = null;
        this.f69833d = null;
        this.f69834e = null;
        this.f69835f = null;
        this.f69836g = null;
        this.f69837h = null;
        this.i = null;
    }

    public final void a(int i) {
        b.a aVar = this.f69832c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        b.i iVar = this.f69834e;
        if (iVar != null) {
            iVar.a(this, i, i2, i3, i4);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f69832c = aVar;
    }

    public final void a(b.InterfaceC1937b interfaceC1937b) {
        this.f69831b = interfaceC1937b;
    }

    public final void a(b.c cVar) {
        this.f69835f = cVar;
    }

    public final void a(b.d dVar) {
        this.f69836g = dVar;
    }

    public final void a(b.e eVar) {
        this.i = eVar;
    }

    public final void a(b.f fVar) {
        this.f69830a = fVar;
    }

    public final void a(b.g gVar) {
        this.f69833d = gVar;
    }

    public final void a(b.i iVar) {
        this.f69834e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f69837h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i, int i2, Object obj) {
        b.c cVar = this.f69835f;
        return cVar != null && cVar.a(this, i, i2, obj);
    }

    public final void b() {
        b.f fVar = this.f69830a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i, int i2, Object obj) {
        b.d dVar = this.f69836g;
        return dVar != null && dVar.b(this, i, i2, obj);
    }

    public final void c() {
        b.InterfaceC1937b interfaceC1937b = this.f69831b;
        if (interfaceC1937b != null) {
            interfaceC1937b.b(this);
        }
    }

    public final boolean c(int i, int i2, Object obj) {
        b.e eVar = this.i;
        return eVar != null && eVar.c(this, i, i2, obj);
    }

    public final void d() {
        b.g gVar = this.f69833d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
