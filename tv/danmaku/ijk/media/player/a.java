package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes.dex */
public abstract class a implements b {
    private b.e a;
    private b.InterfaceC0843b b;
    private b.a c;
    private b.f d;
    private b.h e;
    private b.c f;
    private b.d g;
    private b.g h;

    public void a() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
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

    public final void a(b.a aVar) {
        this.c = aVar;
    }

    public final void a(b.InterfaceC0843b interfaceC0843b) {
        this.b = interfaceC0843b;
    }

    public final void a(b.c cVar) {
        this.f = cVar;
    }

    public final void a(b.d dVar) {
        this.g = dVar;
    }

    public final void a(b.e eVar) {
        this.a = eVar;
    }

    public final void a(b.f fVar) {
        this.d = fVar;
    }

    public final void a(b.h hVar) {
        this.e = hVar;
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
        if (this.a != null) {
            this.a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i, int i2, Object obj) {
        return this.g != null && this.g.b(this, i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.b != null) {
            this.b.b(this);
        }
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
