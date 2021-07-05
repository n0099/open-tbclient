package com.kwad.sdk.glide.webp.decoder;

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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38411a;

    /* renamed from: b  reason: collision with root package name */
    public static final k.a f38412b;

    /* renamed from: c  reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f38413c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38414d;

    /* renamed from: e  reason: collision with root package name */
    public final DisplayMetrics f38415e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38416f;

    /* renamed from: g  reason: collision with root package name */
    public final List<ImageHeaderParser> f38417g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391955114, "Lcom/kwad/sdk/glide/webp/decoder/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1391955114, "Lcom/kwad/sdk/glide/webp/decoder/j;");
                return;
            }
        }
        f38411a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
        f38412b = new k.a() { // from class: com.kwad.sdk.glide.webp.decoder.j.1
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
        f38413c = com.kwad.sdk.glide.g.k.a(0);
    }

    public j(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
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
        this.f38417g = list;
        this.f38415e = (DisplayMetrics) com.kwad.sdk.glide.g.j.a(displayMetrics);
        this.f38414d = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar);
        this.f38416f = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar);
    }

    public static int a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) {
            int b2 = b(1.0E9d * d2);
            return b((d2 / (b2 / 1.0E9f)) * b2);
        }
        return invokeCommon.intValue;
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i2, int i3, boolean z2, k.a aVar) {
        InterceptResult invokeCommon;
        j jVar;
        int round;
        int round2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{inputStream, options, downsampleStrategy, decodeFormat, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), aVar})) == null) {
            long a2 = com.kwad.sdk.glide.g.f.a();
            int[] a3 = a(inputStream, options, aVar, this.f38414d);
            int i5 = a3[0];
            int i6 = a3[1];
            String str = options.outMimeType;
            boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
            int b2 = com.kwad.sdk.glide.load.b.b(this.f38417g, inputStream, this.f38416f);
            int a4 = t.a(b2);
            boolean b3 = t.b(b2);
            int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
            int i8 = i3 == Integer.MIN_VALUE ? i6 : i3;
            ImageHeaderParser.ImageType a5 = com.kwad.sdk.glide.load.b.a(this.f38417g, inputStream, this.f38416f);
            a(a5, inputStream, aVar, this.f38414d, downsampleStrategy, a4, i5, i6, i7, i8, options);
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
                        a(options, jVar.f38414d, round, round2);
                    }
                }
            } else {
                jVar = this;
            }
            Bitmap b4 = b(inputStream, options, aVar, jVar.f38414d);
            aVar.a(jVar.f38414d, b4);
            if (Log.isLoggable("WebpDownsampler", 2)) {
                i4 = b2;
                a(i5, i6, str, options, b4, i2, i3, a2);
            } else {
                i4 = b2;
            }
            Bitmap bitmap = null;
            if (b4 != null) {
                b4.setDensity(jVar.f38415e.densityDpi);
                bitmap = t.a(jVar.f38414d, b4, i4);
                if (!b4.equals(bitmap)) {
                    jVar.f38414d.a(b4);
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
            synchronized (j.class) {
                synchronized (f38413c) {
                    poll = f38413c.poll();
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
            Log.v("WebpDownsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.g.f.a(j));
        }
    }

    @TargetApi(26)
    public static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65544, null, options, eVar, i2, i3) == null) {
            if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
                options.inBitmap = eVar.b(i2, i3, options.inPreferredConfig);
            }
        }
    }

    public static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int floor;
        int floor2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{imageType, inputStream, aVar, eVar, downsampleStrategy, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), options}) == null) || i3 <= 0 || i4 <= 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{inputStream, decodeFormat, Boolean.valueOf(z), Boolean.valueOf(z2), options, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = com.kwad.sdk.glide.load.b.a(this.f38417g, inputStream, this.f38416f).hasAlpha();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, imageType)) == null) ? Build.VERSION.SDK_INT >= 19 : invokeL.booleanValue;
    }

    public static int[] a(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Double.valueOf(d2)})) == null) ? (int) (d2 + 0.5d) : invokeCommon.intValue;
    }

    public static Bitmap b(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
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
        return (Bitmap) invokeLLLL.objValue;
    }

    public static String b(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, options)) == null) ? a(options.inBitmap) : (String) invokeL.objValue;
    }

    public static void c(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, options) == null) {
            d(options);
            synchronized (f38413c) {
                f38413c.offer(options);
            }
        }
    }

    public static void d(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, options) == null) {
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

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? a(inputStream, i2, i3, eVar, f38412b) : (s) invokeCommon.objValue;
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar, k.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar, aVar})) == null) {
            com.kwad.sdk.glide.g.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
            byte[] bArr = (byte[]) this.f38416f.a(65536, byte[].class);
            BitmapFactory.Options a2 = a();
            a2.inTempStorage = bArr;
            DecodeFormat decodeFormat = (DecodeFormat) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38222a);
            try {
                return com.kwad.sdk.glide.load.resource.bitmap.d.a(a(inputStream, a2, (DownsampleStrategy) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38223b), decodeFormat, eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38225d) != null && ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38225d)).booleanValue(), i2, i3, ((Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38224c)).booleanValue(), aVar), this.f38414d);
            } finally {
                c(a2);
                this.f38416f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr, (Class<com.kwad.sdk.glide.load.engine.bitmap_recycle.b>) byte[].class);
            }
        }
        return (s) invokeCommon.objValue;
    }

    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, eVar)) == null) {
            if (((Boolean) eVar.a(f38411a)).booleanValue() || WebpHeaderParser.f38362a) {
                return false;
            }
            WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(inputStream, this.f38416f);
            return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
        }
        return invokeLL.booleanValue;
    }

    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, eVar)) == null) {
            if (((Boolean) eVar.a(f38411a)).booleanValue() || WebpHeaderParser.f38362a) {
                return false;
            }
            WebpHeaderParser.WebpImageType a2 = WebpHeaderParser.a(byteBuffer);
            return WebpHeaderParser.a(a2) && a2 != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
        }
        return invokeLL.booleanValue;
    }
}
