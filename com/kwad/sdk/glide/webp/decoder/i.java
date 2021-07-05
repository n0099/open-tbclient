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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.b.a;
import com.kwad.sdk.glide.webp.WebpFrame;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.glide.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f38401a;

    /* renamed from: b  reason: collision with root package name */
    public WebpImage f38402b;

    /* renamed from: c  reason: collision with root package name */
    public final a.InterfaceC0454a f38403c;

    /* renamed from: d  reason: collision with root package name */
    public int f38404d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f38405e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.webp.c[] f38406f;

    /* renamed from: g  reason: collision with root package name */
    public int f38407g;

    /* renamed from: h  reason: collision with root package name */
    public int f38408h;

    /* renamed from: i  reason: collision with root package name */
    public int f38409i;
    public final Paint j;
    public WebpFrameCacheStrategy k;
    public Bitmap.Config l;
    public final LruCache<Integer, Bitmap> m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(a.InterfaceC0454a interfaceC0454a, WebpImage webpImage, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0454a, webpImage, byteBuffer, i2, WebpFrameCacheStrategy.f38378a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0454a, webpImage, byteBuffer, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((a.InterfaceC0454a) objArr2[0], (WebpImage) objArr2[1], (ByteBuffer) objArr2[2], ((Integer) objArr2[3]).intValue(), (WebpFrameCacheStrategy) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public i(a.InterfaceC0454a interfaceC0454a, WebpImage webpImage, ByteBuffer byteBuffer, int i2, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0454a, webpImage, byteBuffer, Integer.valueOf(i2), webpFrameCacheStrategy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38404d = -1;
        this.l = Bitmap.Config.ARGB_8888;
        this.f38403c = interfaceC0454a;
        this.f38402b = webpImage;
        this.f38405e = webpImage.getFrameDurations();
        this.f38406f = new com.kwad.sdk.glide.webp.c[webpImage.getFrameCount()];
        for (int i5 = 0; i5 < this.f38402b.getFrameCount(); i5++) {
            this.f38406f[i5] = this.f38402b.getFrameInfo(i5);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.f38406f[i5].toString());
            }
        }
        this.k = webpFrameCacheStrategy;
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.m = new LruCache<Integer, Bitmap>(this, this.k.b() ? webpImage.getFrameCount() : Math.max(5, this.k.c())) { // from class: com.kwad.sdk.glide.webp.decoder.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i f38410a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38410a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), num, bitmap, bitmap2}) == null) || bitmap == null) {
                    return;
                }
                this.f38410a.f38403c.a(bitmap);
            }
        };
        a(new com.kwad.sdk.glide.b.c(), byteBuffer, i2);
    }

    private void a(int i2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, bitmap) == null) {
            this.m.remove(Integer.valueOf(i2));
            Bitmap a2 = this.f38403c.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            a2.eraseColor(0);
            a2.setDensity(bitmap.getDensity());
            Canvas canvas = new Canvas(a2);
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            this.m.put(Integer.valueOf(i2), a2);
        }
    }

    private void a(int i2, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65540, this, i2, canvas) == null) {
            com.kwad.sdk.glide.webp.c cVar = this.f38406f[i2];
            int i3 = cVar.f38373d;
            int i4 = this.f38407g;
            int i5 = i3 / i4;
            int i6 = cVar.f38374e / i4;
            int i7 = cVar.f38371b / i4;
            int i8 = cVar.f38372c / i4;
            WebpFrame frame = this.f38402b.getFrame(i2);
            try {
                try {
                    Bitmap a2 = this.f38403c.a(i5, i6, this.l);
                    a2.eraseColor(0);
                    a2.setDensity(canvas.getDensity());
                    frame.renderFrame(i5, i6, a2);
                    canvas.drawBitmap(a2, i7, i8, (Paint) null);
                    this.f38403c.a(a2);
                } catch (IllegalStateException unused) {
                    Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i2);
                }
            } finally {
                frame.dispose();
            }
        }
    }

    private void a(Canvas canvas, com.kwad.sdk.glide.webp.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, canvas, cVar) == null) {
            int i2 = cVar.f38371b;
            int i3 = this.f38407g;
            int i4 = cVar.f38372c;
            canvas.drawRect(i2 / i3, i4 / i3, (i2 + cVar.f38373d) / i3, (i4 + cVar.f38374e) / i3, this.j);
        }
    }

    private boolean a(com.kwad.sdk.glide.webp.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar)) == null) ? cVar.f38371b == 0 && cVar.f38372c == 0 && cVar.f38373d == this.f38402b.getWidth() && cVar.f38374e == this.f38402b.getHeight() : invokeL.booleanValue;
    }

    private int b(int i2, Canvas canvas) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, this, i2, canvas)) == null) {
            while (i2 >= 0) {
                com.kwad.sdk.glide.webp.c cVar = this.f38406f[i2];
                if (cVar.f38377h && a(cVar)) {
                    return i2 + 1;
                }
                Bitmap bitmap = this.m.get(Integer.valueOf(i2));
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.setDensity(canvas.getDensity());
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    if (cVar.f38377h) {
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
        return invokeIL.intValue;
    }

    private boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            if (i2 == 0) {
                return true;
            }
            com.kwad.sdk.glide.webp.c[] cVarArr = this.f38406f;
            com.kwad.sdk.glide.webp.c cVar = cVarArr[i2];
            com.kwad.sdk.glide.webp.c cVar2 = cVarArr[i2 - 1];
            if (cVar.f38376g || !a(cVar)) {
                return cVar2.f38377h && a(cVar2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0) {
                int[] iArr = this.f38405e;
                if (i2 < iArr.length) {
                    return iArr[i2];
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38401a : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config) == null) {
            if (config == Bitmap.Config.ARGB_8888) {
                this.l = config;
                return;
            }
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
        }
    }

    public void a(com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, cVar, byteBuffer, i2) == null) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
            int highestOneBit = Integer.highestOneBit(i2);
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f38401a = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f38407g = highestOneBit;
            this.f38409i = this.f38402b.getWidth() / highestOneBit;
            this.f38408h = this.f38402b.getHeight() / highestOneBit;
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38404d = (this.f38404d + 1) % this.f38402b.getFrameCount();
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f38405e.length == 0 || (i2 = this.f38404d) < 0) {
                return 0;
            }
            return a(i2);
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38402b.getFrameCount() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38404d : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f38404d = -1;
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38402b.getSizeInBytes() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public Bitmap h() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int e2 = e();
            Bitmap a2 = this.f38403c.a(this.f38409i, this.f38408h, Bitmap.Config.ARGB_8888);
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
                com.kwad.sdk.glide.webp.c cVar = this.f38406f[b2];
                if (!cVar.f38376g) {
                    a(canvas, cVar);
                }
                a(b2, canvas);
                if (Log.isLoggable("WebpDecoder", 3)) {
                    Log.d("WebpDecoder", "renderFrame, index=" + b2 + ", blend=" + cVar.f38376g + ", dispose=" + cVar.f38377h);
                }
                if (cVar.f38377h) {
                    a(canvas, cVar);
                }
                b2++;
            }
            com.kwad.sdk.glide.webp.c cVar2 = this.f38406f[e2];
            if (!cVar2.f38376g) {
                a(canvas, cVar2);
            }
            a(e2, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "renderFrame, index=" + e2 + ", blend=" + cVar2.f38376g + ", dispose=" + cVar2.f38377h);
            }
            a(e2, a2);
            return a2;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f38402b.dispose();
            this.f38402b = null;
            this.m.evictAll();
            this.f38401a = null;
        }
    }

    public WebpFrameCacheStrategy j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : (WebpFrameCacheStrategy) invokeV.objValue;
    }
}
