package com.repackage;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class or1 extends fr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ or1 c;

        public a(or1 or1Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or1Var, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = or1Var;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b = vz2.b();
                LinearLayout d = vz2.d();
                int i = this.a;
                if (i == -90) {
                    if (b != null) {
                        b.setVisibility(8);
                    }
                    if (d != null) {
                        d.setVisibility(8);
                    }
                    vz2.g();
                    vz2.m(true);
                    or1.D(8);
                } else if (i == 0) {
                    if (d != null) {
                        d.setVisibility(8);
                    }
                    or1.C();
                } else if (i != 90) {
                    vz2.o();
                    if (b != null) {
                        b.setVisibility(0);
                    }
                    if (d != null) {
                        d.setVisibility(0);
                    }
                    or1.E();
                } else {
                    if (b != null) {
                        b.setVisibility(8);
                    }
                    if (d != null) {
                        d.setVisibility(8);
                    }
                    vz2.g();
                    vz2.m(true);
                    or1.D(0);
                }
                qr1.e().u(this.a);
                this.c.d(this.b, new zs1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public or1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            SwanAppActivity activity = mm2.U().getActivity();
            if (id3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            h02 H = mm2.U().H();
            if (H != null) {
                H.R3(true);
                H.p2();
            }
        }
    }

    public static void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (mm2.U().H() != null) {
                mm2.U().H().R3(false);
            }
            SwanAppActivity activity = mm2.U().getActivity();
            if (id3.d(activity)) {
                activity.setRequestedOrientation(i);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(2048);
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            SwanAppActivity activity = mm2.U().getActivity();
            h02 H = mm2.U().H();
            if (id3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            if (!vz2.i(vz2.e(activity))) {
                vz2.m(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (H != null) {
                H.R3(false);
                H.p2();
                ag3 I1 = H.I1();
                if (I1 != null) {
                    int i = I1.d().b;
                    View b = vz2.b();
                    if (b != null) {
                        b.findViewById(R.id.obfuscated_res_0x7f090180).setBackgroundColor(i);
                    }
                }
                SwanAppActionBar K1 = H.K1();
                K1.f(K1.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    public final void A(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            te3.a0(new a(this, i, str));
        }
    }

    public final int B(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                return i;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public zs1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setFullScreen", false);
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                A(B(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
                return zs1.f();
            }
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RequestFullScreenApi" : (String) invokeV.objValue;
    }
}
