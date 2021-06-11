package com.kwad.sdk.glide.webp.decoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import com.kwad.sdk.glide.load.resource.bitmap.t;
import com.kwad.sdk.glide.webp.WebpBitmapFactory;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f36550a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public static final k.a f36551b = new k.a() { // from class: com.kwad.sdk.glide.webp.decoder.j.1
        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f36552c = com.kwad.sdk.glide.g.k.a(0);

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36553d;

    /* renamed from: e  reason: collision with root package name */
    public final DisplayMetrics f36554e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36555f;

    /* renamed from: g  reason: collision with root package name */
    public final List<ImageHeaderParser> f36556g;

    public j(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36556g = list;
        this.f36554e = (DisplayMetrics) com.kwad.sdk.glide.g.j.a(displayMetrics);
        this.f36553d = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar);
        this.f36555f = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar);
    }

    public static int a(double d2) {
        int b2 = b(1.0E9d * d2);
        return b((d2 / (b2 / 1.0E9f)) * b2);
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i2, int i3, boolean z2, k.a aVar) {
        j jVar;
        int round;
        int round2;
        int i4;
        long a2 = com.kwad.sdk.glide.g.f.a();
        int[] a3 = a(inputStream, options, aVar, this.f36553d);
        int i5 = a3[0];
        int i6 = a3[1];
        String str = options.outMimeType;
        boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
        int b2 = com.kwad.sdk.glide.load.b.b(this.f36556g, inputStream, this.f36555f);
        int a4 = t.a(b2);
        boolean b3 = t.b(b2);
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        int i8 = i3 == Integer.MIN_VALUE ? i6 : i3;
        ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.f36556g, inputStream, this.f36555f);
        a(a5, inputStream, aVar, this.f36553d, downsampleStrategy, a4, i5, i6, i7, i8, options);
        a(inputStream, decodeFormat, z3, b3, options, i7, i8);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            jVar = this;
            if (jVar.a(a5)) {
                if (z2 && z4) {
                    round = i7;
                    round2 = i8;
                } else {
                    float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i9 = options.inSampleSize;
                    float f3 = i9;
                    round = Math.round(((int) Math.ceil(i5 / f3)) * f2);
                    round2 = Math.round(((int) Math.ceil(i6 / f3)) * f2);
                    if (Log.isLoggable("WebpDownsampler", 2)) {
                        Log.v("WebpDownsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i5 + "x" + i6 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                }
                if (round > 0 && round2 > 0) {
                    a(options, jVar.f36553d, round, round2);
                }
            }
        } else {
            jVar = this;
        }
        Bitmap b4 = b(inputStream, options, aVar, jVar.f36553d);
        aVar.a(jVar.f36553d, b4);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            i4 = b2;
            a(i5, i6, str, options, b4, i2, i3, a2);
        } else {
            i4 = b2;
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(jVar.f36554e.densityDpi);
            bitmap = t.a(jVar.f36553d, b4, i4);
            if (!b4.equals(bitmap)) {
                jVar.f36553d.a(b4);
            }
        }
        return bitmap;
    }

    public static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (j.class) {
            synchronized (f36552c) {
                poll = f36552c.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    @Nullable
    @TargetApi(19)
    public static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    public static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        Log.v("WebpDownsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
    }

    @TargetApi(26)
    public static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = eVar.b(i2, i3, options.inPreferredConfig);
        }
    }

    public static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int floor;
        int floor2;
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        float a2 = (i2 == 90 || i2 == 270) ? downsampleStrategy.a(i4, i3, i5, i6) : downsampleStrategy.a(i3, i4, i5, i6);
        if (a2 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy.b(i3, i4, i5, i6);
        if (b2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i3;
        float f3 = i4;
        int b3 = i3 / b(a2 * f2);
        int b4 = i4 / b(a2 * f3);
        int max = Math.max(1, Integer.highestOneBit(b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(b3, b4) : Math.min(b3, b4)));
        if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / a2) {
            max <<= 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(max, 8);
            floor = (int) Math.ceil(f2 / min);
            floor2 = (int) Math.ceil(f3 / min);
            int i7 = max / 8;
            if (i7 > 0) {
                floor /= i7;
                floor2 /= i7;
            }
        } else {
            if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        float f4 = max;
                        floor = Math.round(f2 / f4);
                        floor2 = Math.round(f3 / f4);
                    }
                } else if (i3 % max == 0 && i4 % max == 0) {
                    floor = i3 / max;
                    floor2 = i4 / max;
                } else {
                    int[] a3 = a(inputStream, options, aVar, eVar);
                    floor = a3[0];
                    floor2 = a3[1];
                }
            }
            float f5 = max;
            floor = (int) Math.floor(f2 / f5);
            floor2 = (int) Math.floor(f3 / f5);
        }
        double a4 = downsampleStrategy.a(floor, floor2, i5, i6);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = a(a4);
            options.inDensity = 1000000000;
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("WebpDownsampler", 2)) {
            Log.v("WebpDownsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean z3 = false;
        try {
            z3 = com.kwad.sdk.glide.load.b.a(this.f36556g, inputStream, this.f36555f).hasAlpha();
        } catch (IOException e2) {
            if (Log.isLoggable("WebpDownsampler", 3)) {
                Log.d("WebpDownsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
            }
        }
        Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    public static boolean a(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static int[] a(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int b(double d2) {
        return (int) (d2 + 0.5d);
    }

    public static Bitmap b(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.a();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        t.a().lock();
        try {
            try {
                Bitmap decodeStream = WebpBitmapFactory.decodeStream(inputStream, null, options);
                t.a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e2) {
                IOException a2 = a(e2, i2, i3, str, options);
                if (Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        eVar.a(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap b2 = b(inputStream, options, aVar, eVar);
                        t.a().unlock();
                        return b2;
                    } catch (IOException unused) {
                        throw a2;
                    }
                }
                throw a2;
            }
        } catch (Throwable th) {
            t.a().unlock();
            throw th;
        }
    }

    public static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    public static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (f36552c) {
            f36552c.offer(options);
        }
    }

    public static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        return a(inputStream, i2, i3, eVar, f36551b);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar, k.a aVar) {
        com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f36555f.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36361a);
        try {
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36362b), decodeFormat, eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36364d) != null && ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36364d)).booleanValue(), i2, i3, ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36363c)).booleanValue(), aVar), this.f36553d);
        } finally {
            c(a2);
            this.f36555f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr, (Class<com.kwad.sdk.glide.load.engine.bitmap_recycle.b>) byte[].class);
        }
    }

    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36550a)).booleanValue() || WebpHeaderParser.f36501a) {
            return false;
        }
        WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(inputStream, this.f36555f);
        return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }

    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36550a)).booleanValue() || WebpHeaderParser.f36501a) {
            return false;
        }
        WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(byteBuffer);
        return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }
}
