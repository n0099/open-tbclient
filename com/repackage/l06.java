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
public final class l06 extends q0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final k06 j;
    public final i26 k;
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

        public static /* synthetic */ l06 c(a aVar, b26 b26Var, t16 t16Var, int i, Object obj) {
            if ((i & 2) != 0) {
                t16Var = aVar.a();
            }
            return aVar.b(b26Var, t16Var);
        }

        public final x16 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new x16(new u16(), TuplesKt.to(5, new v16()), TuplesKt.to(1, new w16()), TuplesKt.to(4, new s16())) : (x16) invokeV.objValue;
        }

        public final l06 b(b26 renderer, t16 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new l06(renderer, layouter);
            }
            return (l06) invokeLL.objValue;
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
        m = new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l06(b26 renderer, t16 layouter) {
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
        k06 k06Var = new k06(renderer);
        this.j = k06Var;
        this.k = k06Var.f();
        j16 j16Var = new j16(this.j);
        j16Var.a = 1;
        Unit unit = Unit.INSTANCE;
        g(j16Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        Unit unit2 = Unit.INSTANCE;
        g(dataSystem);
        l16 l16Var = new l16(this.j);
        l16Var.a = 3;
        Unit unit3 = Unit.INSTANCE;
        g(l16Var);
        h16 h16Var = new h16(this.j);
        h16Var.a = 4;
        Unit unit4 = Unit.INSTANCE;
        g(h16Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        Unit unit5 = Unit.INSTANCE;
        g(renderSystem);
        l16 l16Var2 = (l16) k(l16.class);
        if (l16Var2 == null) {
            return;
        }
        l16Var2.p(layouter);
    }

    public static /* synthetic */ void E(l06 l06Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        l06Var.D(f);
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
            i26.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i26.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final void D(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f) == null) {
            q16.b("Engine_step");
            this.k.g(f);
            q16.a();
        }
    }

    public final void F(zz5 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            j16 j16Var = (j16) k(j16.class);
            if (j16Var == null) {
                return;
            }
            j16Var.m(danmakuConfig);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q16.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            i26 i26Var = this.k;
            long a2 = i26Var.a() - this.l;
            update(i26Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = i26Var.a();
            q16.a();
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

    public final zz5 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            j16 j16Var = (j16) k(j16.class);
            if (j16Var == null) {
                return null;
            }
            return j16Var.k();
        }
        return (zz5) invokeV.objValue;
    }

    public final k06 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (k06) invokeV.objValue;
    }

    public final long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k.a() : invokeV.longValue;
    }

    public final i26 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (i26) invokeV.objValue;
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
