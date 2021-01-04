package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
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
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DecodeFormat> f10582a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f10583b = DownsampleStrategy.h;
    public static final com.kwad.sdk.glide.load.d<Boolean> c = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final com.kwad.sdk.glide.load.d<Boolean> d = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    private static final Set<String> e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    private static final a f = new a() { // from class: com.kwad.sdk.glide.load.resource.bitmap.k.1
        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    };
    private static final Set<ImageHeaderParser.ImageType> g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> h = com.kwad.sdk.glide.g.k.a(0);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e i;
    private final DisplayMetrics j;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b k;
    private final List<ImageHeaderParser> l;
    private final p m = p.a();

    /* loaded from: classes5.dex */
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

    private static int a(double d2) {
        int b2 = b(d2);
        int c2 = c(b2 * d2);
        return c(c2 * (d2 / (c2 / b2)));
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, a aVar) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        int[] a3 = a(inputStream, options, aVar, this.i);
        int i3 = a3[0];
        int i4 = a3[1];
        String str = options.outMimeType;
        boolean z3 = (i3 == -1 || i4 == -1) ? false : z;
        int b2 = com.kwad.sdk.glide.load.b.b(this.l, inputStream, this.k);
        int a4 = t.a(b2);
        boolean b3 = t.b(b2);
        int i5 = i == Integer.MIN_VALUE ? i3 : i;
        int i6 = i2 == Integer.MIN_VALUE ? i4 : i2;
        ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.l, inputStream, this.k);
        a(a5, inputStream, aVar, this.i, downsampleStrategy, a4, i3, i4, i5, i6, options);
        a(inputStream, decodeFormat, z3, b3, options, i5, i6);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z4) && a(a5)) {
            if (i3 < 0 || i4 < 0 || !z2 || !z4) {
                float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i7 = options.inSampleSize;
                i5 = Math.round(((int) Math.ceil(i3 / i7)) * f2);
                i6 = Math.round(((int) Math.ceil(i4 / i7)) * f2);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + i5 + "x" + i6 + "] for source [" + i3 + "x" + i4 + "], sampleSize: " + i7 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                }
            }
            if (i5 > 0 && i6 > 0) {
                a(options, this.i, i5, i6);
            }
        }
        Bitmap b4 = b(inputStream, options, aVar, this.i);
        aVar.a(this.i, b4);
        if (Log.isLoggable("Downsampler", 2)) {
            a(i3, i4, str, options, b4, i, i2, a2);
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(this.j.densityDpi);
            bitmap = t.a(this.i, b4, b2);
            if (!b4.equals(bitmap)) {
                this.i.a(b4);
            }
        }
        return bitmap;
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            synchronized (h) {
                poll = h.poll();
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
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (Build.VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + b(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i, int i2) {
        Bitmap.Config config = null;
        if (Build.VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return;
            }
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i, i2, config);
    }

    private static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int max;
        int floor;
        int floor2;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
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
        int c2 = i2 / c(i2 * a2);
        int c3 = i3 / c(i3 * a2);
        int max2 = b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(c2, c3) : Math.min(c2, c3);
        if (Build.VERSION.SDK_INT > 23 || !e.contains(options.outMimeType)) {
            max = Math.max(1, Integer.highestOneBit(max2));
            if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / a2) {
                max <<= 1;
            }
        } else {
            max = 1;
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
            options.inDensity = b(a4);
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean z3;
        if (this.m.a(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = com.kwad.sdk.glide.load.b.a(this.l, inputStream, this.k).hasAlpha();
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
            }
            z3 = false;
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return g.contains(imageType);
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(2.147483647E9d * d2);
    }

    private static Bitmap b(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
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
                b2 = BitmapFactory.decodeStream(inputStream, null, options);
                t.a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
            } catch (IllegalArgumentException e2) {
                IOException a2 = a(e2, i, i2, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
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
                } catch (IOException e3) {
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

    private static int c(double d2) {
        return (int) (0.5d + d2);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (h) {
            h.offer(options);
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

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        return a(inputStream, i, i2, eVar, f);
    }

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar, a aVar) {
        com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.k.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.a(f10582a);
        try {
            return d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(DownsampleStrategy.h), decodeFormat, eVar.a(d) != null && ((Boolean) eVar.a(d)).booleanValue(), i, i2, ((Boolean) eVar.a(c)).booleanValue(), aVar), this.i);
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
