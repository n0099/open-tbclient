package com.kwad.sdk.glide.webp.decoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobstat.Config;
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
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f6850a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpDownsampler.DisableDecoder", false);
    private static final k.a b = new k.a() { // from class: com.kwad.sdk.glide.webp.decoder.j.1
        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    };
    private static final Queue<BitmapFactory.Options> c = com.kwad.sdk.glide.g.k.a(0);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e d;
    private final DisplayMetrics e;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f;
    private final List<ImageHeaderParser> g;

    public j(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.g = list;
        this.e = (DisplayMetrics) com.kwad.sdk.glide.g.j.a(displayMetrics);
        this.d = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar);
        this.f = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar);
    }

    private static int a(double d) {
        int b2 = b(1.0E9d * d);
        return b(b2 * (d / (b2 / 1.0E9f)));
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, k.a aVar) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        int[] a3 = a(inputStream, options, aVar, this.d);
        int i3 = a3[0];
        int i4 = a3[1];
        String str = options.outMimeType;
        boolean z3 = (i3 == -1 || i4 == -1) ? false : z;
        int b2 = com.kwad.sdk.glide.load.b.b(this.g, inputStream, this.f);
        int a4 = t.a(b2);
        boolean b3 = t.b(b2);
        int i5 = i == Integer.MIN_VALUE ? i3 : i;
        int i6 = i2 == Integer.MIN_VALUE ? i4 : i2;
        ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.g, inputStream, this.f);
        a(a5, inputStream, aVar, this.d, downsampleStrategy, a4, i3, i4, i5, i6, options);
        a(inputStream, decodeFormat, z3, b3, options, i5, i6);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z4) && a(a5)) {
            if (!z2 || !z4) {
                float f = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i7 = options.inSampleSize;
                i5 = Math.round(((int) Math.ceil(i3 / i7)) * f);
                i6 = Math.round(((int) Math.ceil(i4 / i7)) * f);
                if (Log.isLoggable("WebpDownsampler", 2)) {
                    Log.v("WebpDownsampler", "Calculated target [" + i5 + Config.EVENT_HEAT_X + i6 + "] for source [" + i3 + Config.EVENT_HEAT_X + i4 + "], sampleSize: " + i7 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
            }
            if (i5 > 0 && i6 > 0) {
                a(options, this.d, i5, i6);
            }
        }
        Bitmap b4 = b(inputStream, options, aVar, this.d);
        aVar.a(this.d, b4);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            a(i3, i4, str, options, b4, i, i2, a2);
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(this.e.densityDpi);
            bitmap = t.a(this.d, b4, b2);
            if (!b4.equals(bitmap)) {
                this.d.a(b4);
            }
        }
        return bitmap;
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (j.class) {
            synchronized (c) {
                poll = c.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    @Nullable
    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + Config.EVENT_HEAT_X + bitmap.getHeight() + "] " + bitmap.getConfig() + (Build.VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("WebpDownsampler", "Decoded " + a(bitmap) + " from [" + i + Config.EVENT_HEAT_X + i2 + "] " + str + " with inBitmap " + b(options) + " for [" + i3 + Config.EVENT_HEAT_X + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = eVar.b(i, i2, options.inPreferredConfig);
        }
    }

    static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int floor;
        int floor2;
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        float a2 = (i == 90 || i == 270) ? downsampleStrategy.a(i3, i2, i4, i5) : downsampleStrategy.a(i2, i3, i4, i5);
        if (a2 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy + ", source: [" + i2 + Config.EVENT_HEAT_X + i3 + "], target: [" + i4 + Config.EVENT_HEAT_X + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy.b(i2, i3, i4, i5);
        if (b2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int b3 = i2 / b(i2 * a2);
        int b4 = i3 / b(i3 * a2);
        int max = Math.max(1, Integer.highestOneBit(b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(b3, b4) : Math.min(b3, b4)));
        if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / a2) {
            max <<= 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            int min = Math.min(max, 8);
            floor = (int) Math.ceil(i2 / min);
            floor2 = (int) Math.ceil(i3 / min);
            int i6 = max / 8;
            if (i6 > 0) {
                floor /= i6;
                floor2 /= i6;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            floor = (int) Math.floor(i2 / max);
            floor2 = (int) Math.floor(i3 / max);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            if (Build.VERSION.SDK_INT >= 24) {
                floor = Math.round(i2 / max);
                floor2 = Math.round(i3 / max);
            } else {
                floor = (int) Math.floor(i2 / max);
                floor2 = (int) Math.floor(i3 / max);
            }
        } else if (i2 % max == 0 && i3 % max == 0) {
            floor = i2 / max;
            floor2 = i3 / max;
        } else {
            int[] a3 = a(inputStream, options, aVar, eVar);
            floor = a3[0];
            floor2 = a3[1];
        }
        double a4 = downsampleStrategy.a(floor, floor2, i4, i5);
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
            Log.v("WebpDownsampler", "Calculate scaling, source: [" + i2 + Config.EVENT_HEAT_X + i3 + "], target: [" + i4 + Config.EVENT_HEAT_X + i5 + "], power of two scaled: [" + floor + Config.EVENT_HEAT_X + floor2 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean z3;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = com.kwad.sdk.glide.load.b.a(this.g, inputStream, this.f).hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("WebpDownsampler", 3)) {
                Log.d("WebpDownsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            z3 = false;
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565 || options.inPreferredConfig == Bitmap.Config.ARGB_4444 || options.inPreferredConfig == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return Build.VERSION.SDK_INT >= 19;
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int b(double d) {
        return (int) (0.5d + d);
    }

    private static Bitmap b(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        Bitmap b2;
        if (options.inJustDecodeBounds) {
            inputStream.mark(com.baidu.android.common.logging.Log.FILE_LIMETE);
        } else {
            aVar.a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        t.a().lock();
        try {
            try {
                b2 = WebpBitmapFactory.decodeStream(inputStream, null, options);
                t.a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
            } catch (IllegalArgumentException e) {
                IOException a2 = a(e, i, i2, str, options);
                if (Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
                }
                if (options.inBitmap == null) {
                    throw a2;
                }
                try {
                    inputStream.reset();
                    eVar.a(options.inBitmap);
                    options.inBitmap = null;
                    b2 = b(inputStream, options, aVar, eVar);
                    t.a().unlock();
                } catch (IOException e2) {
                    throw a2;
                }
            }
            return b2;
        } catch (Throwable th) {
            t.a().unlock();
            throw th;
        }
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (c) {
            c.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
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

    public s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        return a(inputStream, i, i2, eVar, b);
    }

    public s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar, k.a aVar) {
        com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f6792a);
        try {
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.b), decodeFormat, eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.d) != null && ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.d)).booleanValue(), i, i2, ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.c)).booleanValue(), aVar), this.d);
        } finally {
            c(a2);
            this.f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr, (Class<com.kwad.sdk.glide.load.engine.bitmap_recycle.b>) byte[].class);
        }
    }

    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f6850a)).booleanValue() || WebpHeaderParser.f6833a) {
            return false;
        }
        WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(inputStream, this.f);
        return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }

    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f6850a)).booleanValue() || WebpHeaderParser.f6833a) {
            return false;
        }
        WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(byteBuffer);
        return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }
}
