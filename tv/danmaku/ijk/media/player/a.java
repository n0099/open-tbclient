package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public b.f f69656a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1958b f69657b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f69658c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f69659d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f69660e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f69661f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f69662g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f69663h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f69664i;

    public void a() {
        this.f69656a = null;
        this.f69658c = null;
        this.f69657b = null;
        this.f69659d = null;
        this.f69660e = null;
        this.f69661f = null;
        this.f69662g = null;
        this.f69663h = null;
        this.f69664i = null;
    }

    public final void a(int i2) {
        b.a aVar = this.f69658c;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar = this.f69660e;
        if (iVar != null) {
            iVar.a(this, i2, i3, i4, i5);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.f69658c = aVar;
    }

    public final void a(b.InterfaceC1958b interfaceC1958b) {
        this.f69657b = interfaceC1958b;
    }

    public final void a(b.c cVar) {
        this.f69661f = cVar;
    }

    public final void a(b.d dVar) {
        this.f69662g = dVar;
    }

    public final void a(b.e eVar) {
        this.f69664i = eVar;
    }

    public final void a(b.f fVar) {
        this.f69656a = fVar;
    }

    public final void a(b.g gVar) {
        this.f69659d = gVar;
    }

    public final void a(b.i iVar) {
        this.f69660e = iVar;
    }

    public final void a(c cVar) {
        b.h hVar = this.f69663h;
        if (hVar != null) {
            hVar.a(this, cVar);
        }
    }

    public final boolean a(int i2, int i3, Object obj) {
        b.c cVar = this.f69661f;
        return cVar != null && cVar.a(this, i2, i3, obj);
    }

    public final void b() {
        b.f fVar = this.f69656a;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public final boolean b(int i2, int i3, Object obj) {
        b.d dVar = this.f69662g;
        return dVar != null && dVar.b(this, i2, i3, obj);
    }

    public final void c() {
        b.InterfaceC1958b interfaceC1958b = this.f69657b;
        if (interfaceC1958b != null) {
            interfaceC1958b.b(this);
        }
    }

    public final boolean c(int i2, int i3, Object obj) {
        b.e eVar = this.f69664i;
        return eVar != null && eVar.c(this, i2, i3, obj);
    }

    public final void d() {
        b.g gVar = this.f69659d;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
