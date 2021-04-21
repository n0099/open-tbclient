package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f36253a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f36204b);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36254b;

    /* renamed from: c  reason: collision with root package name */
    public final i f36255c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f36256d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f36257e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36258f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36259g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36260h;
    public boolean i;
    public com.kwad.sdk.glide.f<Bitmap> j;
    public a k;
    public boolean l;
    public a m;
    public Bitmap n;
    public com.kwad.sdk.glide.load.h<Bitmap> o;
    public a p;
    @Nullable
    public d q;
    public int r;
    public int s;
    public int t;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.glide.request.a.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final int f36261a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f36262b;

        /* renamed from: c  reason: collision with root package name */
        public final long f36263c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f36264d;

        public a(Handler handler, int i, long j) {
            this.f36262b = handler;
            this.f36261a = i;
            this.f36263c = j;
        }

        public Bitmap a() {
            return this.f36264d;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f36264d = bitmap;
            Message obtainMessage = this.f36262b.obtainMessage(1, this);
            this.f36262b.removeMessages(1);
            this.f36262b.sendMessageAtTime(obtainMessage, this.f36263c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            this.f36264d = null;
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes6.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                o.this.a((a) message.obj);
                return true;
            } else if (i == 2) {
                o.this.f36254b.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes6.dex */
    public static class e implements com.kwad.sdk.glide.load.c {

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f36266b;

        /* renamed from: c  reason: collision with root package name */
        public final int f36267c;

        public e(com.kwad.sdk.glide.load.c cVar, int i) {
            this.f36266b = cVar;
            this.f36267c = i;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.f36267c).array());
            this.f36266b.a(messageDigest);
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f36266b.equals(eVar.f36266b) && this.f36267c == eVar.f36267c;
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            return (this.f36266b.hashCode() * 31) + this.f36267c;
        }
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    public o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36257e = new ArrayList();
        this.f36259g = false;
        this.f36260h = false;
        this.i = false;
        this.f36254b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f36258f = eVar;
        this.f36256d = handler;
        this.j = fVar;
        this.f36255c = iVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f35921b).a(true).b(true).b(i, i2));
    }

    private com.kwad.sdk.glide.load.c a(int i) {
        return new e(new com.kwad.sdk.glide.f.b(this.f36255c), i);
    }

    private void j() {
        if (this.f36259g) {
            return;
        }
        this.f36259g = true;
        this.l = false;
        l();
    }

    private void k() {
        this.f36259g = false;
    }

    private void l() {
        if (!this.f36259g || this.f36260h) {
            return;
        }
        if (this.i) {
            com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
            this.f36255c.f();
            this.i = false;
        }
        a aVar = this.p;
        if (aVar != null) {
            this.p = null;
            a(aVar);
            return;
        }
        this.f36260h = true;
        int c2 = this.f36255c.c();
        this.f36255c.b();
        int e2 = this.f36255c.e();
        this.m = new a(this.f36256d, e2, SystemClock.uptimeMillis() + c2);
        this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.f36255c.j().a())).a(this.f36255c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
    }

    private void m() {
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f36258f.a(bitmap);
            this.n = null;
        }
    }

    public Bitmap a() {
        return this.n;
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.o = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
        this.n = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
        this.j = this.j.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
        this.r = com.kwad.sdk.glide.g.k.a(bitmap);
        this.s = bitmap.getWidth();
        this.t = bitmap.getHeight();
    }

    public void a(a aVar) {
        d dVar = this.q;
        if (dVar != null) {
            dVar.a();
        }
        this.f36260h = false;
        if (this.l) {
            this.f36256d.obtainMessage(2, aVar).sendToTarget();
        } else if (this.f36259g) {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.k;
                this.k = aVar;
                for (int size = this.f36257e.size() - 1; size >= 0; size--) {
                    this.f36257e.get(size).f();
                }
                if (aVar2 != null) {
                    this.f36256d.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.i) {
            this.f36256d.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.p = aVar;
        }
    }

    public void a(b bVar) {
        if (this.l) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f36257e.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f36257e.isEmpty();
        this.f36257e.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    public int b() {
        return this.s;
    }

    public void b(b bVar) {
        this.f36257e.remove(bVar);
        if (this.f36257e.isEmpty()) {
            k();
        }
    }

    public int c() {
        return this.t;
    }

    public int d() {
        return this.f36255c.g() + this.r;
    }

    public int e() {
        a aVar = this.k;
        if (aVar != null) {
            return aVar.f36261a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f36255c.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f36255c.d();
    }

    public void h() {
        this.f36257e.clear();
        m();
        k();
        a aVar = this.k;
        if (aVar != null) {
            this.f36254b.a(aVar);
            this.k = null;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            this.f36254b.a(aVar2);
            this.m = null;
        }
        a aVar3 = this.p;
        if (aVar3 != null) {
            this.f36254b.a(aVar3);
            this.p = null;
        }
        this.f36255c.i();
        this.l = true;
    }

    public Bitmap i() {
        a aVar = this.k;
        return aVar != null ? aVar.a() : this.n;
    }
}
