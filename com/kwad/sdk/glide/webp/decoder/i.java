package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.kwad.sdk.glide.b.a;
import com.kwad.sdk.glide.webp.WebpFrame;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.glide.b.a {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f36131a;

    /* renamed from: b  reason: collision with root package name */
    public WebpImage f36132b;

    /* renamed from: c  reason: collision with root package name */
    public final a.InterfaceC0421a f36133c;

    /* renamed from: d  reason: collision with root package name */
    public int f36134d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f36135e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.webp.c[] f36136f;

    /* renamed from: g  reason: collision with root package name */
    public int f36137g;

    /* renamed from: h  reason: collision with root package name */
    public int f36138h;
    public int i;
    public final Paint j;
    public WebpFrameCacheStrategy k;
    public Bitmap.Config l;
    public final LruCache<Integer, Bitmap> m;

    public i(a.InterfaceC0421a interfaceC0421a, WebpImage webpImage, ByteBuffer byteBuffer, int i) {
        this(interfaceC0421a, webpImage, byteBuffer, i, WebpFrameCacheStrategy.f36108a);
    }

    public i(a.InterfaceC0421a interfaceC0421a, WebpImage webpImage, ByteBuffer byteBuffer, int i, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        this.f36134d = -1;
        this.l = Bitmap.Config.ARGB_8888;
        this.f36133c = interfaceC0421a;
        this.f36132b = webpImage;
        this.f36135e = webpImage.getFrameDurations();
        this.f36136f = new com.kwad.sdk.glide.webp.c[webpImage.getFrameCount()];
        for (int i2 = 0; i2 < this.f36132b.getFrameCount(); i2++) {
            this.f36136f[i2] = this.f36132b.getFrameInfo(i2);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.f36136f[i2].toString());
            }
        }
        this.k = webpFrameCacheStrategy;
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.m = new LruCache<Integer, Bitmap>(this.k.b() ? webpImage.getFrameCount() : Math.max(5, this.k.c())) { // from class: com.kwad.sdk.glide.webp.decoder.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    i.this.f36133c.a(bitmap);
                }
            }
        };
        a(new com.kwad.sdk.glide.b.c(), byteBuffer, i);
    }

    private void a(int i, Bitmap bitmap) {
        this.m.remove(Integer.valueOf(i));
        Bitmap a2 = this.f36133c.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        a2.eraseColor(0);
        a2.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.m.put(Integer.valueOf(i), a2);
    }

    private void a(int i, Canvas canvas) {
        com.kwad.sdk.glide.webp.c cVar = this.f36136f[i];
        int i2 = cVar.f36103d;
        int i3 = this.f36137g;
        int i4 = i2 / i3;
        int i5 = cVar.f36104e / i3;
        int i6 = cVar.f36101b / i3;
        int i7 = cVar.f36102c / i3;
        WebpFrame frame = this.f36132b.getFrame(i);
        try {
            try {
                Bitmap a2 = this.f36133c.a(i4, i5, this.l);
                a2.eraseColor(0);
                a2.setDensity(canvas.getDensity());
                frame.renderFrame(i4, i5, a2);
                canvas.drawBitmap(a2, i6, i7, (Paint) null);
                this.f36133c.a(a2);
            } catch (IllegalStateException unused) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i);
            }
        } finally {
            frame.dispose();
        }
    }

    private void a(Canvas canvas, com.kwad.sdk.glide.webp.c cVar) {
        int i = cVar.f36101b;
        int i2 = this.f36137g;
        int i3 = cVar.f36102c;
        canvas.drawRect(i / i2, i3 / i2, (i + cVar.f36103d) / i2, (i3 + cVar.f36104e) / i2, this.j);
    }

    private boolean a(com.kwad.sdk.glide.webp.c cVar) {
        return cVar.f36101b == 0 && cVar.f36102c == 0 && cVar.f36103d == this.f36132b.getWidth() && cVar.f36104e == this.f36132b.getHeight();
    }

    private int b(int i, Canvas canvas) {
        while (i >= 0) {
            com.kwad.sdk.glide.webp.c cVar = this.f36136f[i];
            if (cVar.f36107h && a(cVar)) {
                return i + 1;
            }
            Bitmap bitmap = this.m.get(Integer.valueOf(i));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (cVar.f36107h) {
                    a(canvas, cVar);
                }
                return i + 1;
            } else if (b(i)) {
                return i;
            } else {
                i--;
            }
        }
        return 0;
    }

    private boolean b(int i) {
        if (i == 0) {
            return true;
        }
        com.kwad.sdk.glide.webp.c[] cVarArr = this.f36136f;
        com.kwad.sdk.glide.webp.c cVar = cVarArr[i];
        com.kwad.sdk.glide.webp.c cVar2 = cVarArr[i - 1];
        if (cVar.f36106g || !a(cVar)) {
            return cVar2.f36107h && a(cVar2);
        }
        return true;
    }

    public int a(int i) {
        if (i >= 0) {
            int[] iArr = this.f36135e;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public ByteBuffer a() {
        return this.f36131a;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            this.l = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    public void a(com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f36131a = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f36137g = highestOneBit;
        this.i = this.f36132b.getWidth() / highestOneBit;
        this.f36138h = this.f36132b.getHeight() / highestOneBit;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.f36134d = (this.f36134d + 1) % this.f36132b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        int i;
        if (this.f36135e.length == 0 || (i = this.f36134d) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.f36132b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        return this.f36134d;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        this.f36134d = -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        return this.f36132b.getSizeInBytes();
    }

    @Override // com.kwad.sdk.glide.b.a
    public Bitmap h() {
        Bitmap bitmap;
        int e2 = e();
        Bitmap a2 = this.f36133c.a(this.i, this.f36138h, Bitmap.Config.ARGB_8888);
        a2.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            a2.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!this.k.a() && (bitmap = this.m.get(Integer.valueOf(e2))) != null) {
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "hit frame bitmap from memory cache, frameNumber=" + e2);
            }
            bitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return a2;
        }
        int b2 = !b(e2) ? b(e2 - 1, canvas) : e2;
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "frameNumber=" + e2 + ", nextIndex=" + b2);
        }
        while (b2 < e2) {
            com.kwad.sdk.glide.webp.c cVar = this.f36136f[b2];
            if (!cVar.f36106g) {
                a(canvas, cVar);
            }
            a(b2, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "renderFrame, index=" + b2 + ", blend=" + cVar.f36106g + ", dispose=" + cVar.f36107h);
            }
            if (cVar.f36107h) {
                a(canvas, cVar);
            }
            b2++;
        }
        com.kwad.sdk.glide.webp.c cVar2 = this.f36136f[e2];
        if (!cVar2.f36106g) {
            a(canvas, cVar2);
        }
        a(e2, canvas);
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "renderFrame, index=" + e2 + ", blend=" + cVar2.f36106g + ", dispose=" + cVar2.f36107h);
        }
        a(e2, a2);
        return a2;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.f36132b.dispose();
        this.f36132b = null;
        this.m.evictAll();
        this.f36131a = null;
    }

    public WebpFrameCacheStrategy j() {
        return this.k;
    }
}
