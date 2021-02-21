package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes5.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private b.f f14756a;

    /* renamed from: b  reason: collision with root package name */
    private b.InterfaceC1329b f14757b;
    private b.a c;
    private b.g d;
    private b.i e;
    private b.c f;
    private b.d g;
    private b.h h;
    private b.e i;

    public void a() {
        this.f14756a = null;
        this.c = null;
        this.f14757b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        if (this.c != null) {
            this.c.a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, int i2, int i3, int i4) {
        if (this.e != null) {
            this.e.a(this, i, i2, i3, i4);
        }
    }

    public void a(String str) {
    }

    public final void a(b.a aVar) {
        this.c = aVar;
    }

    public final void a(b.InterfaceC1329b interfaceC1329b) {
        this.f14757b = interfaceC1329b;
    }

    public final void a(b.c cVar) {
        this.f = cVar;
    }

    public final void a(b.d dVar) {
        this.g = dVar;
    }

    public final void a(b.e eVar) {
        this.i = eVar;
    }

    public final void a(b.f fVar) {
        this.f14756a = fVar;
    }

    public final void a(b.g gVar) {
        this.d = gVar;
    }

    public final void a(b.i iVar) {
        this.e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(c cVar) {
        if (this.h != null) {
            this.h.a(this, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i, int i2, Object obj) {
        return this.f != null && this.f.a(this, i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f14756a != null) {
            this.f14756a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i, int i2, Object obj) {
        return this.g != null && this.g.b(this, i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f14757b != null) {
            this.f14757b.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int i, int i2, Object obj) {
        return this.i != null && this.i.c(this, i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.d != null) {
            this.d.c(this);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }
}
