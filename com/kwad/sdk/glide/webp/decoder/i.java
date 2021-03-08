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
/* loaded from: classes3.dex */
public class i implements com.kwad.sdk.glide.b.a {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f6848a;
    private WebpImage b;
    private final a.InterfaceC1139a c;
    private int d;
    private final int[] e;
    private final com.kwad.sdk.glide.webp.c[] f;
    private int g;
    private int h;
    private int i;
    private final Paint j;
    private WebpFrameCacheStrategy k;
    private Bitmap.Config l;
    private final LruCache<Integer, Bitmap> m;

    public i(a.InterfaceC1139a interfaceC1139a, WebpImage webpImage, ByteBuffer byteBuffer, int i) {
        this(interfaceC1139a, webpImage, byteBuffer, i, WebpFrameCacheStrategy.f6839a);
    }

    public i(a.InterfaceC1139a interfaceC1139a, WebpImage webpImage, ByteBuffer byteBuffer, int i, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        this.d = -1;
        this.l = Bitmap.Config.ARGB_8888;
        this.c = interfaceC1139a;
        this.b = webpImage;
        this.e = webpImage.getFrameDurations();
        this.f = new com.kwad.sdk.glide.webp.c[webpImage.getFrameCount()];
        for (int i2 = 0; i2 < this.b.getFrameCount(); i2++) {
            this.f[i2] = this.b.getFrameInfo(i2);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.f[i2].toString());
            }
        }
        this.k = webpFrameCacheStrategy;
        this.j = new Paint();
        this.j.setColor(0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.m = new LruCache<Integer, Bitmap>(this.k.b() ? webpImage.getFrameCount() : Math.max(5, this.k.c())) { // from class: com.kwad.sdk.glide.webp.decoder.i.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    i.this.c.a(bitmap);
                }
            }
        };
        a(new com.kwad.sdk.glide.b.c(), byteBuffer, i);
    }

    private void a(int i, Bitmap bitmap) {
        this.m.remove(Integer.valueOf(i));
        Bitmap a2 = this.c.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        a2.eraseColor(0);
        a2.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.m.put(Integer.valueOf(i), a2);
    }

    private void a(int i, Canvas canvas) {
        com.kwad.sdk.glide.webp.c cVar = this.f[i];
        int i2 = cVar.d / this.g;
        int i3 = cVar.e / this.g;
        int i4 = cVar.b / this.g;
        int i5 = cVar.c / this.g;
        WebpFrame frame = this.b.getFrame(i);
        try {
            try {
                Bitmap a2 = this.c.a(i2, i3, this.l);
                a2.eraseColor(0);
                a2.setDensity(canvas.getDensity());
                frame.renderFrame(i2, i3, a2);
                canvas.drawBitmap(a2, i4, i5, (Paint) null);
                this.c.a(a2);
                frame.dispose();
            } catch (IllegalStateException e) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i);
                frame.dispose();
            }
        } catch (Throwable th) {
            frame.dispose();
            throw th;
        }
    }

    private void a(Canvas canvas, com.kwad.sdk.glide.webp.c cVar) {
        canvas.drawRect(cVar.b / this.g, cVar.c / this.g, (cVar.b + cVar.d) / this.g, (cVar.c + cVar.e) / this.g, this.j);
    }

    private boolean a(com.kwad.sdk.glide.webp.c cVar) {
        return cVar.b == 0 && cVar.c == 0 && cVar.d == this.b.getWidth() && cVar.e == this.b.getHeight();
    }

    private int b(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            com.kwad.sdk.glide.webp.c cVar = this.f[i2];
            if (cVar.h && a(cVar)) {
                return i2 + 1;
            }
            Bitmap bitmap = this.m.get(Integer.valueOf(i2));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (cVar.h) {
                    a(canvas, cVar);
                }
                return i2 + 1;
            } else if (b(i2)) {
                return i2;
            }
        }
        return 0;
    }

    private boolean b(int i) {
        if (i == 0) {
            return true;
        }
        com.kwad.sdk.glide.webp.c cVar = this.f[i];
        com.kwad.sdk.glide.webp.c cVar2 = this.f[i - 1];
        if (cVar.g || !a(cVar)) {
            return cVar2.h && a(cVar2);
        }
        return true;
    }

    public int a(int i) {
        if (i < 0 || i >= this.e.length) {
            return -1;
        }
        return this.e[i];
    }

    @Override // com.kwad.sdk.glide.b.a
    public ByteBuffer a() {
        return this.f6848a;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
        }
        this.l = config;
    }

    public void a(com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.f6848a = byteBuffer.asReadOnlyBuffer();
        this.f6848a.position(0);
        this.g = highestOneBit;
        this.i = this.b.getWidth() / highestOneBit;
        this.h = this.b.getHeight() / highestOneBit;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.d = (this.d + 1) % this.b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        if (this.e.length == 0 || this.d < 0) {
            return 0;
        }
        return a(this.d);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        return this.d;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        this.d = -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        return this.b.getSizeInBytes();
    }

    @Override // com.kwad.sdk.glide.b.a
    public Bitmap h() {
        Bitmap bitmap;
        int e = e();
        Bitmap a2 = this.c.a(this.i, this.h, Bitmap.Config.ARGB_8888);
        a2.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            a2.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!this.k.a() && (bitmap = this.m.get(Integer.valueOf(e))) != null) {
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "hit frame bitmap from memory cache, frameNumber=" + e);
            }
            bitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return a2;
        }
        int b = !b(e) ? b(e - 1, canvas) : e;
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "frameNumber=" + e + ", nextIndex=" + b);
        }
        while (b < e) {
            com.kwad.sdk.glide.webp.c cVar = this.f[b];
            if (!cVar.g) {
                a(canvas, cVar);
            }
            a(b, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "renderFrame, index=" + b + ", blend=" + cVar.g + ", dispose=" + cVar.h);
            }
            if (cVar.h) {
                a(canvas, cVar);
            }
            b++;
        }
        com.kwad.sdk.glide.webp.c cVar2 = this.f[e];
        if (!cVar2.g) {
            a(canvas, cVar2);
        }
        a(e, canvas);
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "renderFrame, index=" + e + ", blend=" + cVar2.g + ", dispose=" + cVar2.h);
        }
        a(e, a2);
        return a2;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.b.dispose();
        this.b = null;
        this.m.evictAll();
        this.f6848a = null;
    }

    public WebpFrameCacheStrategy j() {
        return this.k;
    }
}
