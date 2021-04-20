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
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f36158a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f36109b);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36159b;

    /* renamed from: c  reason: collision with root package name */
    public final i f36160c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f36161d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f36162e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36163f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36164g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36165h;
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
        public final int f36166a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f36167b;

        /* renamed from: c  reason: collision with root package name */
        public final long f36168c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f36169d;

        public a(Handler handler, int i, long j) {
            this.f36167b = handler;
            this.f36166a = i;
            this.f36168c = j;
        }

        public Bitmap a() {
            return this.f36169d;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f36169d = bitmap;
            Message obtainMessage = this.f36167b.obtainMessage(1, this);
            this.f36167b.removeMessages(1);
            this.f36167b.sendMessageAtTime(obtainMessage, this.f36168c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            this.f36169d = null;
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
                o.this.f36159b.a((a) message.obj);
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
        public final com.kwad.sdk.glide.load.c f36171b;

        /* renamed from: c  reason: collision with root package name */
        public final int f36172c;

        public e(com.kwad.sdk.glide.load.c cVar, int i) {
            this.f36171b = cVar;
            this.f36172c = i;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.f36172c).array());
            this.f36171b.a(messageDigest);
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f36171b.equals(eVar.f36171b) && this.f36172c == eVar.f36172c;
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            return (this.f36171b.hashCode() * 31) + this.f36172c;
        }
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    public o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36162e = new ArrayList();
        this.f36164g = false;
        this.f36165h = false;
        this.i = false;
        this.f36159b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f36163f = eVar;
        this.f36161d = handler;
        this.j = fVar;
        this.f36160c = iVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f35826b).a(true).b(true).b(i, i2));
    }

    private com.kwad.sdk.glide.load.c a(int i) {
        return new e(new com.kwad.sdk.glide.f.b(this.f36160c), i);
    }

    private void j() {
        if (this.f36164g) {
            return;
        }
        this.f36164g = true;
        this.l = false;
        l();
    }

    private void k() {
        this.f36164g = false;
    }

    private void l() {
        if (!this.f36164g || this.f36165h) {
            return;
        }
        if (this.i) {
            com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
            this.f36160c.f();
            this.i = false;
        }
        a aVar = this.p;
        if (aVar != null) {
            this.p = null;
            a(aVar);
            return;
        }
        this.f36165h = true;
        int c2 = this.f36160c.c();
        this.f36160c.b();
        int e2 = this.f36160c.e();
        this.m = new a(this.f36161d, e2, SystemClock.uptimeMillis() + c2);
        this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.f36160c.j().a())).a(this.f36160c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
    }

    private void m() {
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f36163f.a(bitmap);
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
        this.f36165h = false;
        if (this.l) {
            this.f36161d.obtainMessage(2, aVar).sendToTarget();
        } else if (this.f36164g) {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.k;
                this.k = aVar;
                for (int size = this.f36162e.size() - 1; size >= 0; size--) {
                    this.f36162e.get(size).f();
                }
                if (aVar2 != null) {
                    this.f36161d.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.i) {
            this.f36161d.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.p = aVar;
        }
    }

    public void a(b bVar) {
        if (this.l) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f36162e.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f36162e.isEmpty();
        this.f36162e.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    public int b() {
        return this.s;
    }

    public void b(b bVar) {
        this.f36162e.remove(bVar);
        if (this.f36162e.isEmpty()) {
            k();
        }
    }

    public int c() {
        return this.t;
    }

    public int d() {
        return this.f36160c.g() + this.r;
    }

    public int e() {
        a aVar = this.k;
        if (aVar != null) {
            return aVar.f36166a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f36160c.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f36160c.d();
    }

    public void h() {
        this.f36162e.clear();
        m();
        k();
        a aVar = this.k;
        if (aVar != null) {
            this.f36159b.a(aVar);
            this.k = null;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            this.f36159b.a(aVar2);
            this.m = null;
        }
        a aVar3 = this.p;
        if (aVar3 != null) {
            this.f36159b.a(aVar3);
            this.p = null;
        }
        this.f36160c.i();
        this.l = true;
    }

    public Bitmap i() {
        a aVar = this.k;
        return aVar != null ? aVar.a() : this.n;
    }
}
