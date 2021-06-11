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
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f36569a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f36518b);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36570b;

    /* renamed from: c  reason: collision with root package name */
    public final i f36571c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f36572d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f36573e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36574f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36575g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36576h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36577i;
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

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.glide.request.a.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final int f36578a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f36579b;

        /* renamed from: c  reason: collision with root package name */
        public final long f36580c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f36581d;

        public a(Handler handler, int i2, long j) {
            this.f36579b = handler;
            this.f36578a = i2;
            this.f36580c = j;
        }

        public Bitmap a() {
            return this.f36581d;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f36581d = bitmap;
            Message obtainMessage = this.f36579b.obtainMessage(1, this);
            this.f36579b.removeMessages(1);
            this.f36579b.sendMessageAtTime(obtainMessage, this.f36580c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            this.f36581d = null;
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes7.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                o.this.a((a) message.obj);
                return true;
            } else if (i2 == 2) {
                o.this.f36570b.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes7.dex */
    public static class e implements com.kwad.sdk.glide.load.c {

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f36583b;

        /* renamed from: c  reason: collision with root package name */
        public final int f36584c;

        public e(com.kwad.sdk.glide.load.c cVar, int i2) {
            this.f36583b = cVar;
            this.f36584c = i2;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.f36584c).array());
            this.f36583b.a(messageDigest);
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f36583b.equals(eVar.f36583b) && this.f36584c == eVar.f36584c;
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            return (this.f36583b.hashCode() * 31) + this.f36584c;
        }
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i2, int i3, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i2, i3), hVar, bitmap);
    }

    public o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36573e = new ArrayList();
        this.f36575g = false;
        this.f36576h = false;
        this.f36577i = false;
        this.f36570b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f36574f = eVar;
        this.f36572d = handler;
        this.j = fVar;
        this.f36571c = iVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f36225b).a(true).b(true).b(i2, i3));
    }

    private com.kwad.sdk.glide.load.c a(int i2) {
        return new e(new com.kwad.sdk.glide.f.b(this.f36571c), i2);
    }

    private void j() {
        if (this.f36575g) {
            return;
        }
        this.f36575g = true;
        this.l = false;
        l();
    }

    private void k() {
        this.f36575g = false;
    }

    private void l() {
        if (!this.f36575g || this.f36576h) {
            return;
        }
        if (this.f36577i) {
            com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
            this.f36571c.f();
            this.f36577i = false;
        }
        a aVar = this.p;
        if (aVar != null) {
            this.p = null;
            a(aVar);
            return;
        }
        this.f36576h = true;
        int c2 = this.f36571c.c();
        this.f36571c.b();
        int e2 = this.f36571c.e();
        this.m = new a(this.f36572d, e2, SystemClock.uptimeMillis() + c2);
        this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.f36571c.j().a())).a(this.f36571c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
    }

    private void m() {
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f36574f.a(bitmap);
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
        this.f36576h = false;
        if (this.l) {
            this.f36572d.obtainMessage(2, aVar).sendToTarget();
        } else if (this.f36575g) {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.k;
                this.k = aVar;
                for (int size = this.f36573e.size() - 1; size >= 0; size--) {
                    this.f36573e.get(size).f();
                }
                if (aVar2 != null) {
                    this.f36572d.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.f36577i) {
            this.f36572d.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.p = aVar;
        }
    }

    public void a(b bVar) {
        if (this.l) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f36573e.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f36573e.isEmpty();
        this.f36573e.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    public int b() {
        return this.s;
    }

    public void b(b bVar) {
        this.f36573e.remove(bVar);
        if (this.f36573e.isEmpty()) {
            k();
        }
    }

    public int c() {
        return this.t;
    }

    public int d() {
        return this.f36571c.g() + this.r;
    }

    public int e() {
        a aVar = this.k;
        if (aVar != null) {
            return aVar.f36578a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f36571c.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f36571c.d();
    }

    public void h() {
        this.f36573e.clear();
        m();
        k();
        a aVar = this.k;
        if (aVar != null) {
            this.f36570b.a(aVar);
            this.k = null;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            this.f36570b.a(aVar2);
            this.m = null;
        }
        a aVar3 = this.p;
        if (aVar3 != null) {
            this.f36570b.a(aVar3);
            this.p = null;
        }
        this.f36571c.i();
        this.l = true;
    }

    public Bitmap i() {
        a aVar = this.k;
        return aVar != null ? aVar.a() : this.n;
    }
}
