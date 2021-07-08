package d.a.n0.a.s.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.h0.g.k;
import d.a.n0.k.n;
/* loaded from: classes7.dex */
public class e extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends d.a.n0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f47204c;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47204c = eVar;
        }

        @Override // d.a.n0.a.h0.j.a, d.a.n0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.c(str) : invokeL.booleanValue;
        }
    }

    public e() {
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

    /* JADX WARN: Type inference failed for: r6v3, types: [d.a.n0.a.p.e.c] */
    @Override // d.a.n0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(d.a.n0.a.g.aiapps_webview_fragment, viewGroup, false);
            Q1(inflate);
            d.a.n0.a.p.e.e m = m();
            this.C0 = m;
            m.Z(M2());
            this.D0 = this.C0.u();
            this.C0.loadUrl(this.E0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.a.n0.a.f.aiapps_webView_container);
            this.C0.l(frameLayout, this.D0.covertToView());
            J2(frameLayout);
            return P1() ? S1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.n0.a.h0.g.k, d.a.n0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.n0.a.p.e.c cVar = this.D0;
            if (cVar != null && cVar.canGoBack()) {
                this.D0.goBack();
                return true;
            }
            T2();
            f.f47208d.a(g.d(), g.a());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.k
    public d.a.n0.a.h0.j.d M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (d.a.n0.a.h0.j.d) invokeV.objValue;
    }

    @Override // d.a.n0.a.h0.g.k
    public void N2() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (h2 = h()) != null && this.o0 == null) {
            this.o0 = new n(h2, this.n0, U2(), d.a.n0.a.c1.a.G(), new d.a.n0.a.w2.h.b());
            new d.a.n0.a.j1.a(this.o0, this).z();
        }
    }

    @Override // d.a.n0.a.h0.g.k, d.a.n0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.Q1(view);
            this.n0.setRightZoneVisibility(true);
        }
    }

    public final void T2() {
        d.a.n0.a.m.a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || f.f47208d.c() || (d2 = f.f47208d.d()) == null) {
            return;
        }
        d2.onResult(-2);
    }

    public final int U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Y1() ? 18 : 12 : invokeV.intValue;
    }

    @Override // d.a.n0.a.h0.g.k, d.a.n0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.k
    public d.a.n0.a.p.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.a.n0.a.h0.u.g.N().X().c(q()) : (d.a.n0.a.p.e.e) invokeV.objValue;
    }

    @Override // d.a.n0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            T2();
            super.onDestroy();
        }
    }
}
