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
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.glide.b.a {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f36540a;

    /* renamed from: b  reason: collision with root package name */
    public WebpImage f36541b;

    /* renamed from: c  reason: collision with root package name */
    public final a.InterfaceC0407a f36542c;

    /* renamed from: d  reason: collision with root package name */
    public int f36543d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f36544e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.webp.c[] f36545f;

    /* renamed from: g  reason: collision with root package name */
    public int f36546g;

    /* renamed from: h  reason: collision with root package name */
    public int f36547h;

    /* renamed from: i  reason: collision with root package name */
    public int f36548i;
    public final Paint j;
    public WebpFrameCacheStrategy k;
    public Bitmap.Config l;
    public final LruCache<Integer, Bitmap> m;

    public i(a.InterfaceC0407a interfaceC0407a, WebpImage webpImage, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0407a, webpImage, byteBuffer, i2, WebpFrameCacheStrategy.f36517a);
    }

    public i(a.InterfaceC0407a interfaceC0407a, WebpImage webpImage, ByteBuffer byteBuffer, int i2, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        this.f36543d = -1;
        this.l = Bitmap.Config.ARGB_8888;
        this.f36542c = interfaceC0407a;
        this.f36541b = webpImage;
        this.f36544e = webpImage.getFrameDurations();
        this.f36545f = new com.kwad.sdk.glide.webp.c[webpImage.getFrameCount()];
        for (int i3 = 0; i3 < this.f36541b.getFrameCount(); i3++) {
            this.f36545f[i3] = this.f36541b.getFrameInfo(i3);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.f36545f[i3].toString());
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
                    i.this.f36542c.a(bitmap);
                }
            }
        };
        a(new com.kwad.sdk.glide.b.c(), byteBuffer, i2);
    }

    private void a(int i2, Bitmap bitmap) {
        this.m.remove(Integer.valueOf(i2));
        Bitmap a2 = this.f36542c.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        a2.eraseColor(0);
        a2.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.m.put(Integer.valueOf(i2), a2);
    }

    private void a(int i2, Canvas canvas) {
        com.kwad.sdk.glide.webp.c cVar = this.f36545f[i2];
        int i3 = cVar.f36512d;
        int i4 = this.f36546g;
        int i5 = i3 / i4;
        int i6 = cVar.f36513e / i4;
        int i7 = cVar.f36510b / i4;
        int i8 = cVar.f36511c / i4;
        WebpFrame frame = this.f36541b.getFrame(i2);
        try {
            try {
                Bitmap a2 = this.f36542c.a(i5, i6, this.l);
                a2.eraseColor(0);
                a2.setDensity(canvas.getDensity());
                frame.renderFrame(i5, i6, a2);
                canvas.drawBitmap(a2, i7, i8, (Paint) null);
                this.f36542c.a(a2);
            } catch (IllegalStateException unused) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i2);
            }
        } finally {
            frame.dispose();
        }
    }

    private void a(Canvas canvas, com.kwad.sdk.glide.webp.c cVar) {
        int i2 = cVar.f36510b;
        int i3 = this.f36546g;
        int i4 = cVar.f36511c;
        canvas.drawRect(i2 / i3, i4 / i3, (i2 + cVar.f36512d) / i3, (i4 + cVar.f36513e) / i3, this.j);
    }

    private boolean a(com.kwad.sdk.glide.webp.c cVar) {
        return cVar.f36510b == 0 && cVar.f36511c == 0 && cVar.f36512d == this.f36541b.getWidth() && cVar.f36513e == this.f36541b.getHeight();
    }

    private int b(int i2, Canvas canvas) {
        while (i2 >= 0) {
            com.kwad.sdk.glide.webp.c cVar = this.f36545f[i2];
            if (cVar.f36516h && a(cVar)) {
                return i2 + 1;
            }
            Bitmap bitmap = this.m.get(Integer.valueOf(i2));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (cVar.f36516h) {
                    a(canvas, cVar);
                }
                return i2 + 1;
            } else if (b(i2)) {
                return i2;
            } else {
                i2--;
            }
        }
        return 0;
    }

    private boolean b(int i2) {
        if (i2 == 0) {
            return true;
        }
        com.kwad.sdk.glide.webp.c[] cVarArr = this.f36545f;
        com.kwad.sdk.glide.webp.c cVar = cVarArr[i2];
        com.kwad.sdk.glide.webp.c cVar2 = cVarArr[i2 - 1];
        if (cVar.f36515g || !a(cVar)) {
            return cVar2.f36516h && a(cVar2);
        }
        return true;
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int[] iArr = this.f36544e;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public ByteBuffer a() {
        return this.f36540a;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            this.l = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    public void a(com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
        int highestOneBit = Integer.highestOneBit(i2);
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f36540a = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f36546g = highestOneBit;
        this.f36548i = this.f36541b.getWidth() / highestOneBit;
        this.f36547h = this.f36541b.getHeight() / highestOneBit;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.f36543d = (this.f36543d + 1) % this.f36541b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        int i2;
        if (this.f36544e.length == 0 || (i2 = this.f36543d) < 0) {
            return 0;
        }
        return a(i2);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.f36541b.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        return this.f36543d;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        this.f36543d = -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        return this.f36541b.getSizeInBytes();
    }

    @Override // com.kwad.sdk.glide.b.a
    public Bitmap h() {
        Bitmap bitmap;
        int e2 = e();
        Bitmap a2 = this.f36542c.a(this.f36548i, this.f36547h, Bitmap.Config.ARGB_8888);
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
            com.kwad.sdk.glide.webp.c cVar = this.f36545f[b2];
            if (!cVar.f36515g) {
                a(canvas, cVar);
            }
            a(b2, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "renderFrame, index=" + b2 + ", blend=" + cVar.f36515g + ", dispose=" + cVar.f36516h);
            }
            if (cVar.f36516h) {
                a(canvas, cVar);
            }
            b2++;
        }
        com.kwad.sdk.glide.webp.c cVar2 = this.f36545f[e2];
        if (!cVar2.f36515g) {
            a(canvas, cVar2);
        }
        a(e2, canvas);
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "renderFrame, index=" + e2 + ", blend=" + cVar2.f36515g + ", dispose=" + cVar2.f36516h);
        }
        a(e2, a2);
        return a2;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.f36541b.dispose();
        this.f36541b = null;
        this.m.evictAll();
        this.f36540a = null;
    }

    public WebpFrameCacheStrategy j() {
        return this.k;
    }
}
