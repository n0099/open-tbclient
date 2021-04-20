package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DecodeFormat> f35957a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f35958b = DownsampleStrategy.f35932h;

    /* renamed from: c  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35959c = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);

    /* renamed from: d  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35960d = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f35961e = Collections.unmodifiableSet(new HashSet(Arrays.asList(Downsampler.WBMP_MIME_TYPE, Downsampler.ICO_MIME_TYPE)));

    /* renamed from: f  reason: collision with root package name */
    public static final a f35962f = new a() { // from class: com.kwad.sdk.glide.load.resource.bitmap.k.1
        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f35963g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: h  reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f35964h = com.kwad.sdk.glide.g.k.a(0);
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e i;
    public final DisplayMetrics j;
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b k;
    public final List<ImageHeaderParser> l;
    public final p m = p.a();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap);
    }

    public k(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.l = list;
        this.j = (DisplayMetrics) com.kwad.sdk.glide.g.j.a(displayMetrics);
        this.i = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar);
        this.k = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar);
    }

    public static int a(double d2) {
        int b2 = b(d2);
        int c2 = c(b2 * d2);
        return c((d2 / (c2 / b2)) * c2);
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, a aVar) {
        k kVar;
        int round;
        int round2;
        int i3;
        long a2 = com.kwad.sdk.glide.g.f.a();
        int[] a3 = a(inputStream, options, aVar, this.i);
        int i4 = a3[0];
        int i5 = a3[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int b2 = com.kwad.sdk.glide.load.b.b(this.l, inputStream, this.k);
        int a4 = t.a(b2);
        boolean b3 = t.b(b2);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.l, inputStream, this.k);
        a(a5, inputStream, aVar, this.i, downsampleStrategy, a4, i4, i5, i6, i7, options);
        a(inputStream, decodeFormat, z3, b3, options, i6, i7);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            kVar = this;
            if (kVar.a(a5)) {
                if (i4 < 0 || i5 < 0 || !z2 || !z4) {
                    float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i8 = options.inSampleSize;
                    float f3 = i8;
                    round = Math.round(((int) Math.ceil(i4 / f3)) * f2);
                    round2 = Math.round(((int) Math.ceil(i5 / f3)) * f2);
                    if (Log.isLoggable(Downsampler.TAG, 2)) {
                        Log.v(Downsampler.TAG, "Calculated target [" + round + "x" + round2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    round = i6;
                    round2 = i7;
                }
                if (round > 0 && round2 > 0) {
                    a(options, kVar.i, round, round2);
                }
            }
        } else {
            kVar = this;
        }
        Bitmap b4 = b(inputStream, options, aVar, kVar.i);
        aVar.a(kVar.i, b4);
        if (Log.isLoggable(Downsampler.TAG, 2)) {
            i3 = b2;
            a(i4, i5, str, options, b4, i, i2, a2);
        } else {
            i3 = b2;
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(kVar.j.densityDpi);
            bitmap = t.a(kVar.i, b4, i3);
            if (!b4.equals(bitmap)) {
                kVar.i.a(b4);
            }
        }
        return bitmap;
    }

    public static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            synchronized (f35964h) {
                poll = f35964h.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
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

    public static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(Downsampler.TAG, "Decoded " + a(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + b(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
    }

    @TargetApi(26)
    public static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i, i2, config);
    }

    public static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int max;
        int floor;
        int floor2;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable(Downsampler.TAG, 3)) {
                Log.d(Downsampler.TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
                return;
            }
            return;
        }
        float a2 = (i == 90 || i == 270) ? downsampleStrategy.a(i3, i2, i4, i5) : downsampleStrategy.a(i2, i3, i4, i5);
        if (a2 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy.b(i2, i3, i4, i5);
        if (b2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i2;
        float f3 = i3;
        int c2 = i2 / c(a2 * f2);
        int c3 = i3 / c(a2 * f3);
        int max2 = b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(c2, c3) : Math.min(c2, c3);
        if (Build.VERSION.SDK_INT > 23 || !f35961e.contains(options.outMimeType)) {
            max = Math.max(1, Integer.highestOneBit(max2));
            if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / a2) {
                max <<= 1;
            }
        } else {
            max = 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(max, 8);
            floor = (int) Math.ceil(f2 / min);
            floor2 = (int) Math.ceil(f3 / min);
            int i6 = max / 8;
            if (i6 > 0) {
                floor /= i6;
                floor2 /= i6;
            }
        } else {
            if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        float f4 = max;
                        floor = Math.round(f2 / f4);
                        floor2 = Math.round(f3 / f4);
                    }
                } else if (i2 % max == 0 && i3 % max == 0) {
                    floor = i2 / max;
                    floor2 = i3 / max;
                } else {
                    int[] a3 = a(inputStream, options, aVar, eVar);
                    int i7 = a3[0];
                    floor2 = a3[1];
                    floor = i7;
                }
            }
            float f5 = max;
            floor = (int) Math.floor(f2 / f5);
            floor2 = (int) Math.floor(f3 / f5);
        }
        double a4 = downsampleStrategy.a(floor, floor2, i4, i5);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = a(a4);
            options.inDensity = b(a4);
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable(Downsampler.TAG, 2)) {
            Log.v(Downsampler.TAG, "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.m.a(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean z3 = false;
        try {
            z3 = com.kwad.sdk.glide.load.b.a(this.l, inputStream, this.k).hasAlpha();
        } catch (IOException e2) {
            if (Log.isLoggable(Downsampler.TAG, 3)) {
                Log.d(Downsampler.TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
            }
        }
        Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    public static boolean a(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f35963g.contains(imageType);
    }

    public static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    public static Bitmap b(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        t.a().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                t.a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e2) {
                IOException a2 = a(e2, i, i2, str, options);
                if (Log.isLoggable(Downsampler.TAG, 3)) {
                    Log.d(Downsampler.TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
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

    public static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    public static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (f35964h) {
            f35964h.offer(options);
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

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        return a(inputStream, i, i2, eVar, f35962f);
    }

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar, a aVar) {
        com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.k.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.a(f35957a);
        try {
            return d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(DownsampleStrategy.f35932h), decodeFormat, eVar.a(f35960d) != null && ((Boolean) eVar.a(f35960d)).booleanValue(), i, i2, ((Boolean) eVar.a(f35959c)).booleanValue(), aVar), this.i);
        } finally {
            c(a2);
            this.k.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
        }
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }
}
