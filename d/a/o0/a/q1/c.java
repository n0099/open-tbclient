package d.a.o0.a.q1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g;
import d.a.o0.a.h0.g.k;
import d.a.o0.a.v2.o0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends d.a.o0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f47343c;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47343c = cVar;
        }

        @Override // d.a.o0.a.h0.j.a, d.a.o0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> t = o0.t(o0.o(str));
                    if (t != null && t.get("statusCode") != null) {
                        try {
                            e.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            e.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), null);
                        }
                    } else {
                        e.a().onPayResult(6, null);
                    }
                    k.L2();
                    return true;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }
    }

    public c() {
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

    /* JADX WARN: Type inference failed for: r6v5, types: [d.a.o0.a.p.e.c] */
    @Override // d.a.o0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(g.aiapps_webview_fragment, viewGroup, false);
            inflate.findViewById(d.a.o0.a.f.ai_apps_title_bar_root).setVisibility(8);
            d.a.o0.a.p.e.e m = m();
            this.C0 = m;
            m.Z(M2());
            this.D0 = this.C0.u();
            this.C0.loadUrl(this.E0);
            this.C0.l((FrameLayout) inflate.findViewById(d.a.o0.a.f.aiapps_webView_container), this.D0.covertToView());
            if (P1()) {
                inflate = S1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.o0.a.h0.g.k
    public d.a.o0.a.h0.j.d M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (d.a.o0.a.h0.j.d) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.g.k
    public d.a.o0.a.p.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.o0.a.h0.u.g.N().X().g(q()) : (d.a.o0.a.p.e.e) invokeV.objValue;
    }
}
