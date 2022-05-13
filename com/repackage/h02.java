package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class h02 extends i02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean O0;
    public transient /* synthetic */ FieldHolder $fh;
    public int M0;
    public FrameLayout N0;

    /* loaded from: classes6.dex */
    public class a extends f22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h02 c;

        public a(h02 h02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h02Var;
        }

        @Override // com.repackage.f22, com.repackage.i22
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.b(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? i93.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false) : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755702137, "Lcom/repackage/h02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755702137, "Lcom/repackage/h02;");
                return;
            }
        }
        O0 = eh1.a;
    }

    public h02() {
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
        this.M0 = 20;
    }

    @Override // com.repackage.a02
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.F0 == null) {
                if (O0) {
                    Log.e("SwanAppWebModeFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String c = this.F0.c();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c);
            bn1 bn1Var = this.G0;
            if (bn1Var != null) {
                hashMap.put("webViewUrl", bn1Var.getUrl());
            }
            va2 va2Var = new va2("sharebtn", hashMap);
            hm2.U().m(c, va2Var);
            ux1.i("SwanAppWebModeFragment", "share msg: " + va2Var.s().toString());
        }
    }

    @Override // com.repackage.i02, com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.T1(view2);
            this.l0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l0.getLayoutParams();
            layoutParams.topMargin = le3.t();
            this.l0.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.i02
    public i22 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (i22) invokeV.objValue;
    }

    @Override // com.repackage.i02
    public void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.n0 == null) {
                this.n0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.m0 != null) {
                return;
            }
            this.m0 = new z64(activity, this.l0, h3(), bk2.K(), new dg3());
            new kq2(this.m0, this, this.n0).z();
        }
    }

    public URI f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(mg3.c().a().e());
            } catch (Exception e) {
                if (O0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.repackage.a02
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g2();
            pg3.a().j();
        }
    }

    public URI g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(mg3.c().e());
            } catch (Exception e) {
                if (O0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (c2()) {
                return 19;
            }
            return this.M0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.i02, com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Z2();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(s72.n(t03.J().getAppId()));
            }
            this.m0.u(bk2.M().a(), G1(), this.n0, false);
        }
    }

    public void i3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.M0 = i;
        }
    }

    @Override // com.repackage.i02
    public dn1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? o72.U().f0().a(getContext()) : (dn1) invokeV.objValue;
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI g3 = g3();
            URI f3 = f3();
            if (g3 == null || f3 == null) {
                return;
            }
            if (!TextUtils.equals(g3.getPath(), f3.getPath()) && !TextUtils.equals(g3.getQuery(), f3.getQuery())) {
                this.F0.loadUrl(f3.toString());
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: refresh url " + f3.toString());
                }
                mg3.c().m("3");
                pg3.b("3");
                pg3.a().m();
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                    return;
                }
                return;
            }
            e73.s(t03.J().r().V());
            if (O0) {
                Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.repackage.bn1] */
    @Override // com.repackage.i02, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00df, viewGroup, false);
            T1(inflate);
            dn1 m = m();
            this.F0 = m;
            m.c0(Y2());
            this.G0 = this.F0.u();
            pg3.a().i(this.H0);
            mg3.c().m("0");
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.N0 = frameLayout;
            this.F0.l(frameLayout, this.G0.covertToView());
            V2(this.N0);
            if (S1()) {
                inflate = V1(inflate);
                w1(0, true);
            }
            le3.Q(getActivity());
            mg3.c().p(this.F0.c());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
