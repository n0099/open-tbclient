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
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f35868a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f35819b);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f35869b;

    /* renamed from: c  reason: collision with root package name */
    public final i f35870c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35871d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f35872e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35873f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35874g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35875h;
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
        public final int f35876a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f35877b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35878c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f35879d;

        public a(Handler handler, int i, long j) {
            this.f35877b = handler;
            this.f35876a = i;
            this.f35878c = j;
        }

        public Bitmap a() {
            return this.f35879d;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f35879d = bitmap;
            Message obtainMessage = this.f35877b.obtainMessage(1, this);
            this.f35877b.removeMessages(1);
            this.f35877b.sendMessageAtTime(obtainMessage, this.f35878c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            this.f35879d = null;
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
                o.this.f35869b.a((a) message.obj);
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
        public final com.kwad.sdk.glide.load.c f35881b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35882c;

        public e(com.kwad.sdk.glide.load.c cVar, int i) {
            this.f35881b = cVar;
            this.f35882c = i;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.f35882c).array());
            this.f35881b.a(messageDigest);
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f35881b.equals(eVar.f35881b) && this.f35882c == eVar.f35882c;
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            return (this.f35881b.hashCode() * 31) + this.f35882c;
        }
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    public o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f35872e = new ArrayList();
        this.f35874g = false;
        this.f35875h = false;
        this.i = false;
        this.f35869b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f35873f = eVar;
        this.f35871d = handler;
        this.j = fVar;
        this.f35870c = iVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f35536b).a(true).b(true).b(i, i2));
    }

    private com.kwad.sdk.glide.load.c a(int i) {
        return new e(new com.kwad.sdk.glide.f.b(this.f35870c), i);
    }

    private void j() {
        if (this.f35874g) {
            return;
        }
        this.f35874g = true;
        this.l = false;
        l();
    }

    private void k() {
        this.f35874g = false;
    }

    private void l() {
        if (!this.f35874g || this.f35875h) {
            return;
        }
        if (this.i) {
            com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
            this.f35870c.f();
            this.i = false;
        }
        a aVar = this.p;
        if (aVar != null) {
            this.p = null;
            a(aVar);
            return;
        }
        this.f35875h = true;
        int c2 = this.f35870c.c();
        this.f35870c.b();
        int e2 = this.f35870c.e();
        this.m = new a(this.f35871d, e2, SystemClock.uptimeMillis() + c2);
        this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.f35870c.j().a())).a(this.f35870c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
    }

    private void m() {
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f35873f.a(bitmap);
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
        this.f35875h = false;
        if (this.l) {
            this.f35871d.obtainMessage(2, aVar).sendToTarget();
        } else if (this.f35874g) {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.k;
                this.k = aVar;
                for (int size = this.f35872e.size() - 1; size >= 0; size--) {
                    this.f35872e.get(size).f();
                }
                if (aVar2 != null) {
                    this.f35871d.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.i) {
            this.f35871d.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.p = aVar;
        }
    }

    public void a(b bVar) {
        if (this.l) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f35872e.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f35872e.isEmpty();
        this.f35872e.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    public int b() {
        return this.s;
    }

    public void b(b bVar) {
        this.f35872e.remove(bVar);
        if (this.f35872e.isEmpty()) {
            k();
        }
    }

    public int c() {
        return this.t;
    }

    public int d() {
        return this.f35870c.g() + this.r;
    }

    public int e() {
        a aVar = this.k;
        if (aVar != null) {
            return aVar.f35876a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f35870c.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f35870c.d();
    }

    public void h() {
        this.f35872e.clear();
        m();
        k();
        a aVar = this.k;
        if (aVar != null) {
            this.f35869b.a(aVar);
            this.k = null;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            this.f35869b.a(aVar2);
            this.m = null;
        }
        a aVar3 = this.p;
        if (aVar3 != null) {
            this.f35869b.a(aVar3);
            this.p = null;
        }
        this.f35870c.i();
        this.l = true;
    }

    public Bitmap i() {
        a aVar = this.k;
        return aVar != null ? aVar.a() : this.n;
    }
}
