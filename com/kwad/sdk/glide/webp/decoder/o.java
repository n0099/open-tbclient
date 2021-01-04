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
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy> f10688a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.f10664b);

    /* renamed from: b  reason: collision with root package name */
    final com.kwad.sdk.glide.g f10689b;
    private final i c;
    private final Handler d;
    private final List<b> e;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f;
    private boolean g;
    private boolean h;
    private boolean i;
    private com.kwad.sdk.glide.f<Bitmap> j;
    private a k;
    private boolean l;
    private a m;
    private Bitmap n;
    private com.kwad.sdk.glide.load.h<Bitmap> o;
    private a p;
    @Nullable
    private d q;
    private int r;
    private int s;
    private int t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.glide.request.a.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f10690a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f10691b;
        private final long c;
        private Bitmap d;

        a(Handler handler, int i, long j) {
            this.f10691b = handler;
            this.f10690a = i;
            this.c = j;
        }

        Bitmap a() {
            return this.d;
        }

        public void a(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.d = bitmap;
            Message obtainMessage = this.f10691b.obtainMessage(1, this);
            this.f10691b.removeMessages(1);
            this.f10691b.sendMessageAtTime(obtainMessage, this.c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public void a(@Nullable Drawable drawable) {
            this.d = null;
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes5.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                o.this.a((a) message.obj);
                return true;
            }
            if (message.what == 2) {
                o.this.f10689b.a((a) message.obj);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e implements com.kwad.sdk.glide.load.c {

        /* renamed from: b  reason: collision with root package name */
        private final com.kwad.sdk.glide.load.c f10693b;
        private final int c;

        e(com.kwad.sdk.glide.load.c cVar, int i) {
            this.f10693b = cVar;
            this.c = i;
        }

        @Override // com.kwad.sdk.glide.load.c
        public void a(@NonNull MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.c).array());
            this.f10693b.a(messageDigest);
        }

        @Override // com.kwad.sdk.glide.load.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f10693b.equals(eVar.f10693b) && this.c == eVar.c;
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public int hashCode() {
            return (this.f10693b.hashCode() * 31) + this.c;
        }
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), iVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.e = new ArrayList();
        this.g = false;
        this.h = false;
        this.i = false;
        this.f10689b = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f = eVar;
        this.d = handler;
        this.j = fVar;
        this.c = iVar;
        a(hVar, bitmap);
    }

    private static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f10516b).a(true).b(true).b(i, i2));
    }

    private com.kwad.sdk.glide.load.c a(int i) {
        return new e(new com.kwad.sdk.glide.f.b(this.c), i);
    }

    private void j() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.l = false;
        l();
    }

    private void k() {
        this.g = false;
    }

    private void l() {
        if (!this.g || this.h) {
            return;
        }
        if (this.i) {
            com.kwad.sdk.glide.g.j.a(this.p == null, "Pending target must be null when starting from the first frame");
            this.c.f();
            this.i = false;
        }
        if (this.p != null) {
            a aVar = this.p;
            this.p = null;
            a(aVar);
            return;
        }
        this.h = true;
        long c2 = this.c.c() + SystemClock.uptimeMillis();
        this.c.b();
        int e2 = this.c.e();
        this.m = new a(this.d, e2, c2);
        this.j.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(a(e2)).b(this.c.j().a())).a(this.c).a((com.kwad.sdk.glide.f<Bitmap>) this.m);
    }

    private void m() {
        if (this.n != null) {
            this.f.a(this.n);
            this.n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.o = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
        this.n = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
        this.j = this.j.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
        this.r = com.kwad.sdk.glide.g.k.a(bitmap);
        this.s = bitmap.getWidth();
        this.t = bitmap.getHeight();
    }

    void a(a aVar) {
        if (this.q != null) {
            this.q.a();
        }
        this.h = false;
        if (this.l) {
            this.d.obtainMessage(2, aVar).sendToTarget();
        } else if (this.g) {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.k;
                this.k = aVar;
                for (int size = this.e.size() - 1; size >= 0; size--) {
                    this.e.get(size).f();
                }
                if (aVar2 != null) {
                    this.d.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.i) {
            this.d.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.p = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.l) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.e.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.e.isEmpty();
        this.e.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        this.e.remove(bVar);
        if (this.e.isEmpty()) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.c.g() + this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.k != null) {
            return this.k.f10690a;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.c.a().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.e.clear();
        m();
        k();
        if (this.k != null) {
            this.f10689b.a(this.k);
            this.k = null;
        }
        if (this.m != null) {
            this.f10689b.a(this.m);
            this.m = null;
        }
        if (this.p != null) {
            this.f10689b.a(this.p);
            this.p = null;
        }
        this.c.i();
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap i() {
        return this.k != null ? this.k.a() : this.n;
    }
}
