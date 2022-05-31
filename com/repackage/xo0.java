package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.or0;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes7.dex */
public abstract class xo0 extends ko0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public lr0 A;
    public or0 B;
    public kr0 C;
    public String D;
    public boolean E;
    public final SimpleArrayMap<Class<? extends Object>, Object> F;

    /* loaded from: classes7.dex */
    public class a implements or0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public long c;
        public final /* synthetic */ xo0 d;

        public a(xo0 xo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xo0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xo0Var;
            this.c = 0L;
        }

        @Override // com.repackage.or0.a
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || xo0.W0()) {
                return;
            }
            xo0 xo0Var = this.d;
            if (xo0Var.e == null || !xo0Var.N0() || this.d.U0() || or0.f(jo0.b())) {
                return;
            }
            if (!this.d.V0()) {
                this.a = false;
                if (or0.d(i)) {
                    this.b = true;
                }
                if (this.b && or0.c(i) && this.d.e.getVisibility() == 0 && System.currentTimeMillis() - this.c > 1000) {
                    this.c = System.currentTimeMillis();
                    this.d.c1(0);
                    this.b = false;
                    return;
                }
                return;
            }
            this.b = false;
            if (or0.e(i)) {
                this.a = true;
                fw0.a(this.d.getActivity(), true);
            } else if (or0.c(i)) {
                this.a = true;
                fw0.a(this.d.getActivity(), false);
            } else if (or0.d(i) && this.a && System.currentTimeMillis() - this.c > 1000) {
                this.c = System.currentTimeMillis();
                this.d.d1(0);
                this.a = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755165000, "Lcom/repackage/xo0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755165000, "Lcom/repackage/xo0;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xo0(@NonNull ds0 ds0Var, @Nullable Context context) {
        super(ds0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ds0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ds0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = PlayerConstant.HALF_MODE;
        this.F = new SimpleArrayMap<>();
        zv0.c().b();
    }

    public static boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? G : invokeV.booleanValue;
    }

    @Override // com.repackage.ko0
    public void G0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }

    @Override // com.repackage.ko0
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = new vp0();
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void O0() {
        or0 or0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (or0Var = this.B) == null) {
            return;
        }
        this.E = false;
        or0Var.disable();
    }

    @Override // com.repackage.ko0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            S0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.B.canDetectOrientation()) {
            this.E = this.B.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ko0
    @NonNull
    /* renamed from: Q0 */
    public vp0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (vp0) this.m : (vp0) invokeV.objValue;
    }

    @NonNull
    public aw0 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? bw0.a : (aw0) invokeV.objValue;
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.A = new rr0(this);
            or0 or0Var = new or0(jo0.b(), 3);
            this.B = or0Var;
            if (or0Var.canDetectOrientation()) {
                this.E = true;
                this.B.disable();
                this.B.g(new a(this));
            }
            this.C = new sr0(this);
        }
    }

    public boolean T0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TextUtils.equals(this.D, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TextUtils.equals(this.D, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            or0 or0Var = this.B;
            if (or0Var == null || !this.E) {
                return false;
            }
            return or0.e(or0Var.b());
        }
        return invokeV.booleanValue;
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.D = PlayerConstant.FULL_MODE;
            } else {
                this.D = PlayerConstant.HALF_MODE;
            }
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            G = z;
            if (z) {
                return;
            }
            P0();
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Z0(!G);
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (T0(true)) {
                pw0.d(getActivity(), true);
            }
            nw0.b(UniversalPlayer.TAG, "player start switchToFull");
            y().t();
            this.C.switchToFullStyle();
            q0(uq0.w(LayerEvent.ACTION_SWITCH_FULL));
            y().z();
        }
    }

    public void c1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            b1();
        }
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (T0(false)) {
                pw0.d(getActivity(), false);
            }
            y().u();
            nw0.b(UniversalPlayer.TAG, "player start switchToHalf");
            this.C.switchToNormalStyle();
            q0(uq0.w(LayerEvent.ACTION_SWITCH_HALF));
            y().A();
        }
    }

    @Override // com.repackage.ko0
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.g0();
            this.F.clear();
        }
    }
}
