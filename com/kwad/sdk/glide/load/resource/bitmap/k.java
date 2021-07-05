package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DecodeFormat> f38222a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f38223b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38224c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38225d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f38226e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f38227f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f38228g;

    /* renamed from: h  reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f38229h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38230i;
    public final DisplayMetrics j;
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b k;
    public final List<ImageHeaderParser> l;
    public final p m;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649293, "Lcom/kwad/sdk/glide/load/resource/bitmap/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649293, "Lcom/kwad/sdk/glide/load/resource/bitmap/k;");
                return;
            }
        }
        f38222a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        f38223b = DownsampleStrategy.f38197h;
        f38224c = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
        f38225d = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
        f38226e = Collections.unmodifiableSet(new HashSet(Arrays.asList(Downsampler.WBMP_MIME_TYPE, Downsampler.ICO_MIME_TYPE)));
        f38227f = new a() { // from class: com.kwad.sdk.glide.load.resource.bitmap.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
            public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bitmap) == null) {
                }
            }
        };
        f38228g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f38229h = com.kwad.sdk.glide.g.k.a(0);
    }

    public k(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, displayMetrics, eVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = p.a();
        this.l = list;
        this.j = (DisplayMetrics) com.kwad.sdk.glide.g.j.a(displayMetrics);
        this.f38230i = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar);
        this.k = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar);
    }

    public static int a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) {
            int b2 = b(d2);
            int c2 = c(b2 * d2);
            return c((d2 / (c2 / b2)) * c2);
        }
        return invokeCommon.intValue;
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i2, int i3, boolean z2, a aVar) {
        InterceptResult invokeCommon;
        k kVar;
        int round;
        int round2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{inputStream, options, downsampleStrategy, decodeFormat, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), aVar})) == null) {
            long a2 = com.kwad.sdk.glide.g.f.a();
            int[] a3 = a(inputStream, options, aVar, this.f38230i);
            int i5 = a3[0];
            int i6 = a3[1];
            String str = options.outMimeType;
            boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
            int b2 = com.kwad.sdk.glide.load.b.b(this.l, inputStream, this.k);
            int a4 = t.a(b2);
            boolean b3 = t.b(b2);
            int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
            int i8 = i3 == Integer.MIN_VALUE ? i6 : i3;
            ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.l, inputStream, this.k);
            a(a5, inputStream, aVar, this.f38230i, downsampleStrategy, a4, i5, i6, i7, i8, options);
            a(inputStream, decodeFormat, z3, b3, options, i7, i8);
            boolean z4 = Build.VERSION.SDK_INT >= 19;
            if (options.inSampleSize == 1 || z4) {
                kVar = this;
                if (kVar.a(a5)) {
                    if (i5 < 0 || i6 < 0 || !z2 || !z4) {
                        float f2 = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                        int i9 = options.inSampleSize;
                        float f3 = i9;
                        round = Math.round(((int) Math.ceil(i5 / f3)) * f2);
                        round2 = Math.round(((int) Math.ceil(i6 / f3)) * f2);
                        if (Log.isLoggable(Downsampler.TAG, 2)) {
                            Log.v(Downsampler.TAG, "Calculated target [" + round + "x" + round2 + "] for source [" + i5 + "x" + i6 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                        }
                    } else {
                        round = i7;
                        round2 = i8;
                    }
                    if (round > 0 && round2 > 0) {
                        a(options, kVar.f38230i, round, round2);
                    }
                }
            } else {
                kVar = this;
            }
            Bitmap b4 = b(inputStream, options, aVar, kVar.f38230i);
            aVar.a(kVar.f38230i, b4);
            if (Log.isLoggable(Downsampler.TAG, 2)) {
                i4 = b2;
                a(i5, i6, str, options, b4, i2, i3, a2);
            } else {
                i4 = b2;
            }
            Bitmap bitmap = null;
            if (b4 != null) {
                b4.setDensity(kVar.j.densityDpi);
                bitmap = t.a(kVar.f38230i, b4, i4);
                if (!b4.equals(bitmap)) {
                    kVar.f38230i.a(b4);
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static synchronized BitmapFactory.Options a() {
        InterceptResult invokeV;
        BitmapFactory.Options poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (k.class) {
                synchronized (f38229h) {
                    poll = f38229h.poll();
                }
                if (poll == null) {
                    poll = new BitmapFactory.Options();
                    d(poll);
                }
            }
            return poll;
        }
        return (BitmapFactory.Options) invokeV.objValue;
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{illegalArgumentException, Integer.valueOf(i2), Integer.valueOf(i3), str, options})) == null) {
            return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
        }
        return (IOException) invokeCommon.objValue;
    }

    @Nullable
    @TargetApi(19)
    public static String a(Bitmap bitmap) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                str = " (" + bitmap.getAllocationByteCount() + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                str = "";
            }
            return PreferencesUtil.LEFT_MOUNT + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
        }
        return (String) invokeL.objValue;
    }

    public static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, options, bitmap, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)}) == null) {
            Log.v(Downsampler.TAG, "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
        }
    }

    @TargetApi(26)
    public static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i2, int i3) {
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65544, null, options, eVar, i2, i3) == null) {
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
            options.inBitmap = eVar.b(i2, i3, config);
        }
    }

    public static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int max;
        int floor;
        int floor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{imageType, inputStream, aVar, eVar, downsampleStrategy, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), options}) == null) {
            if (i3 <= 0 || i4 <= 0) {
                if (Log.isLoggable(Downsampler.TAG, 3)) {
                    Log.d(Downsampler.TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + PreferencesUtil.RIGHT_MOUNT);
                    return;
                }
                return;
            }
            float a2 = (i2 == 90 || i2 == 270) ? downsampleStrategy.a(i4, i3, i5, i6) : downsampleStrategy.a(i3, i4, i5, i6);
            if (a2 <= 0.0f) {
                throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + PreferencesUtil.RIGHT_MOUNT);
            }
            DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy.b(i3, i4, i5, i6);
            if (b2 == null) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            float f2 = i3;
            float f3 = i4;
            int c2 = i3 / c(a2 * f2);
            int c3 = i4 / c(a2 * f3);
            int max2 = b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(c2, c3) : Math.min(c2, c3);
            if (Build.VERSION.SDK_INT > 23 || !f38226e.contains(options.outMimeType)) {
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
                        int i8 = a3[0];
                        floor2 = a3[1];
                        floor = i8;
                    }
                }
                float f5 = max;
                floor = (int) Math.floor(f2 / f5);
                floor2 = (int) Math.floor(f3 / f5);
            }
            double a4 = downsampleStrategy.a(floor, floor2, i5, i6);
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
                Log.v(Downsampler.TAG, "Calculate scaling, source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + a4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
            }
        }
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{inputStream, decodeFormat, Boolean.valueOf(z), Boolean.valueOf(z2), options, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || this.m.a(i2, i3, options, decodeFormat, z, z2)) {
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
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, options)) == null) {
            int i3 = options.inTargetDensity;
            return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
        }
        return invokeL.booleanValue;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, imageType)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return true;
            }
            return f38228g.contains(imageType);
        }
        return invokeL.booleanValue;
    }

    public static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, inputStream, options, aVar, eVar)) == null) {
            options.inJustDecodeBounds = true;
            b(inputStream, options, aVar, eVar);
            options.inJustDecodeBounds = false;
            return new int[]{options.outWidth, options.outHeight};
        }
        return (int[]) invokeLLLL.objValue;
    }

    public static int b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 > 1.0d) {
                d2 = 1.0d / d2;
            }
            return (int) Math.round(d2 * 2.147483647E9d);
        }
        return invokeCommon.intValue;
    }

    public static Bitmap b(InputStream inputStream, BitmapFactory.Options options, a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, inputStream, options, aVar, eVar)) == null) {
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
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    t.a().unlock();
                    if (options.inJustDecodeBounds) {
                        inputStream.reset();
                    }
                    return decodeStream;
                } catch (IllegalArgumentException e2) {
                    IOException a2 = a(e2, i2, i3, str, options);
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
        return (Bitmap) invokeLLLL.objValue;
    }

    public static String b(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, options)) == null) ? a(options.inBitmap) : (String) invokeL.objValue;
    }

    public static int c(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Double.valueOf(d2)})) == null) ? (int) (d2 + 0.5d) : invokeCommon.intValue;
    }

    public static void c(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, options) == null) {
            d(options);
            synchronized (f38229h) {
                f38229h.offer(options);
            }
        }
    }

    public static void d(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, options) == null) {
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
    }

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? a(inputStream, i2, i3, eVar, f38227f) : (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar, aVar})) == null) {
            com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
            byte[] bArr = (byte[]) this.k.a(65536, byte[].class);
            BitmapFactory.Options a2 = a();
            a2.inTempStorage = bArr;
            DecodeFormat decodeFormat = (DecodeFormat) eVar.a(f38222a);
            try {
                return d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(DownsampleStrategy.f38197h), decodeFormat, eVar.a(f38225d) != null && ((Boolean) eVar.a(f38225d)).booleanValue(), i2, i3, ((Boolean) eVar.a(f38224c)).booleanValue(), aVar), this.f38230i);
            } finally {
                c(a2);
                this.k.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            }
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    public boolean a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
