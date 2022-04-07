package com.repackage;

import android.graphics.Canvas;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j06 extends q0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final i06 j;
    public final g26 k;
    public long l;

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

        public static /* synthetic */ j06 c(a aVar, z16 z16Var, r16 r16Var, int i, Object obj) {
            if ((i & 2) != 0) {
                r16Var = aVar.a();
            }
            return aVar.b(z16Var, r16Var);
        }

        public final v16 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new v16(new s16(), TuplesKt.to(5, new t16()), TuplesKt.to(1, new u16()), TuplesKt.to(4, new q16())) : (v16) invokeV.objValue;
        }

        public final j06 b(z16 renderer, r16 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new j06(renderer, layouter);
            }
            return (j06) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755642431, "Lcom/repackage/j06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755642431, "Lcom/repackage/j06;");
                return;
            }
        }
        m = new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j06(z16 renderer, r16 layouter) {
        super(200, 1000, 200, 1500);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, layouter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        i06 i06Var = new i06(renderer);
        this.j = i06Var;
        this.k = i06Var.f();
        h16 h16Var = new h16(this.j);
        h16Var.a = 1;
        Unit unit = Unit.INSTANCE;
        g(h16Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        Unit unit2 = Unit.INSTANCE;
        g(dataSystem);
        j16 j16Var = new j16(this.j);
        j16Var.a = 3;
        Unit unit3 = Unit.INSTANCE;
        g(j16Var);
        f16 f16Var = new f16(this.j);
        f16Var.a = 4;
        Unit unit4 = Unit.INSTANCE;
        g(f16Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        Unit unit5 = Unit.INSTANCE;
        g(renderSystem);
        j16 j16Var2 = (j16) k(j16.class);
        if (j16Var2 == null) {
            return;
        }
        j16Var2.p(layouter);
    }

    public static /* synthetic */ void E(j06 j06Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        j06Var.D(f);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.d(true);
            v0<n0> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (n0 n0Var : systems) {
                p(n0Var);
            }
        }
    }

    public final void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            g26.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g26.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final void D(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f) == null) {
            o16.b("Engine_step");
            this.k.g(f);
            o16.a();
        }
    }

    public final void F(xz5 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            h16 h16Var = (h16) k(h16.class);
            if (h16Var == null) {
                return;
            }
            h16Var.m(danmakuConfig);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o16.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            g26 g26Var = this.k;
            long a2 = g26Var.a() - this.l;
            update(g26Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = g26Var.a();
            o16.a();
        }
    }

    public final void s(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem == null) {
                return;
            }
            renderSystem.k(canvas, onRenderReady);
        }
    }

    public final xz5 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h16 h16Var = (h16) k(h16.class);
            if (h16Var == null) {
                return null;
            }
            return h16Var.k();
        }
        return (xz5) invokeV.objValue;
    }

    public final i06 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (i06) invokeV.objValue;
    }

    public final long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k.a() : invokeV.longValue;
    }

    public final g26 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (g26) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k.c() : invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.d(true);
        }
    }

    public final void z() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dataSystem = (DataSystem) k(DataSystem.class)) == null) {
            return;
        }
        dataSystem.D();
    }
}
