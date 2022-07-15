package com.repackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l06 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static final l06 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final m06 a;
    public boolean b;
    public int c;
    public CacheManager d;
    public int e;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l06 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l06.g : (l06) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755582849, "Lcom/repackage/l06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755582849, "Lcom/repackage/l06;");
                return;
            }
        }
        f = new a(null);
        g = new l06();
    }

    public l06() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new m06();
    }

    public final l06 b(int i, int i2, int i3, boolean z, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                this.a.a(i, i2, i3, z, i4);
                this.e = h(this.a.c());
            }
            return this;
        }
        return (l06) invokeCommon.objValue;
    }

    public final void d() {
        CacheManager i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                int i2 = this.c - 1;
                this.c = i2;
                if (i2 <= 0 && this.b && (i = i()) != null) {
                    i.l(this);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.c <= 0) {
                    n();
                } else {
                    this.b = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.a.b();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final m06 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m06 m06Var = this.a;
            if ((Intrinsics.areEqual(m06Var.c(), x16.b()) || m06Var.c().isRecycled()) ? false : true) {
                return m06Var;
            }
            return null;
        }
        return (m06) invokeV.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final int h(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public final CacheManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (CacheManager) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.e() : invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.f() : invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.c++;
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (!Intrinsics.areEqual(Thread.currentThread().getName(), "AkDanmaku-Cache")) {
                    BdLog.e(Intrinsics.stringPlus("DanmakuEngineDrawingCache recycle called must on cache thread but now on ", Thread.currentThread().getName()));
                }
                if (this.c > 0) {
                    return;
                }
                this.b = false;
                this.a.g();
                this.e = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void o(CacheManager cacheManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cacheManager) == null) {
            this.d = cacheManager;
        }
    }
}
