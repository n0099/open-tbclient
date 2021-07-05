package com.kwad.sdk.support;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Paint f39282a;

    /* renamed from: b  reason: collision with root package name */
    public static final Paint f39283b;

    /* renamed from: c  reason: collision with root package name */
    public static final Paint f39284c;

    /* renamed from: d  reason: collision with root package name */
    public static final Paint f39285d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f39286e;

    /* renamed from: f  reason: collision with root package name */
    public static final Lock f39287f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements Lock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException("Should not be called");
            }
            return (Condition) invokeV.objValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, timeUnit)) == null) {
                return true;
            }
            return invokeJL.booleanValue;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1184088948, "Lcom/kwad/sdk/support/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1184088948, "Lcom/kwad/sdk/support/b;");
                return;
            }
        }
        f39282a = new Paint(6);
        f39283b = new Paint(7);
        Paint paint = new Paint(7);
        f39285d = paint;
        paint.setColor(Color.parseColor("#EAEAEA"));
        f39285d.setStyle(Paint.Style.STROKE);
        f39285d.setAntiAlias(true);
        f39285d.setStrokeWidth(1.0f);
        f39285d.setDither(true);
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f39286e = hashSet;
        f39287f = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint2 = new Paint(7);
        f39284c = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @NonNull
    public static Bitmap.Config a(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) ? (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16 : (Bitmap.Config) invokeL.objValue;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, eVar, bitmap)) == null) {
            Bitmap.Config a2 = a(bitmap);
            if (a2.equals(bitmap.getConfig())) {
                return bitmap;
            }
            Bitmap a3 = eVar.a(bitmap.getWidth(), bitmap.getHeight(), a2);
            new Canvas(a3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return a3;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, eVar, bitmap, i2, i3)) == null) {
            int min = Math.min(i2, i3);
            float f2 = min;
            float f3 = f2 / 2.0f;
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float max = Math.max(f2 / width, f2 / height);
            float f4 = width * max;
            float f5 = max * height;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = (f2 - f5) / 2.0f;
            RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
            Bitmap a2 = a(eVar, bitmap);
            Bitmap a3 = eVar.a(min, min, a(bitmap));
            a3.setHasAlpha(true);
            f39287f.lock();
            try {
                Canvas canvas = new Canvas(a3);
                canvas.drawCircle(f3, f3, f3, f39283b);
                canvas.drawBitmap(a2, (Rect) null, rectF, f39284c);
                canvas.drawCircle(f3, f3, f3 - 0.0f, f39285d);
                a(canvas);
                f39287f.unlock();
                if (!a2.equals(bitmap)) {
                    eVar.a(a2);
                }
                return a3;
            } catch (Throwable th) {
                f39287f.unlock();
                throw th;
            }
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public static void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, canvas) == null) {
            canvas.setBitmap(null);
        }
    }
}
