package com.repackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes7.dex */
public class xs2 extends vz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends s12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs2 c;

        public a(xs2 xs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xs2Var;
        }

        @Override // com.repackage.s12, com.repackage.v12
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> t = zd3.t(zd3.o(str));
                    if (t != null && t.get("statusCode") != null) {
                        try {
                            zs2.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            zs2.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), null);
                        }
                    } else {
                        zs2.a().onPayResult(6, null);
                    }
                    vz1.Y2();
                    return true;
                }
                return super.b(str);
            }
            return invokeL.booleanValue;
        }
    }

    public xs2() {
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

    @Override // com.repackage.vz1
    public v12 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (v12) invokeV.objValue;
    }

    @Override // com.repackage.vz1
    public qm1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b72.U().f0().i(getContext()) : (qm1) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.repackage.om1] */
    @Override // com.repackage.vz1, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00db, viewGroup, false);
            inflate.findViewById(R.id.obfuscated_res_0x7f09017b).setVisibility(8);
            qm1 l = l();
            this.F0 = l;
            l.b0(Z2());
            this.G0 = this.F0.t();
            this.F0.loadUrl(this.H0);
            this.F0.k((FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a6), this.G0.covertToView());
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
