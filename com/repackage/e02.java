package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String F0;
    public JSONObject G0;
    public boolean H0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ e02 b;

        public a(e02 e02Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e02Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e02Var;
            this.a = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hm2.U().u(new gw2(this.b.F0, this.a.toString(), this.b.G0.optString("slaveId")).a());
                this.b.H0 = false;
            }
        }
    }

    public e02() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.H0 = true;
    }

    public static e02 X2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            e02 e02Var = new e02();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                e02Var.i1(bundle);
            }
            return e02Var;
        }
        return (e02) invokeLL.objValue;
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i0 = null;
            super.C0();
        }
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.H0 || (jSONObject = this.G0) == null) {
                return false;
            }
            fw2 fw2Var = new fw2(jSONObject.optString("componentId"));
            fw2Var.a = this.G0.optString("slaveId");
            fw2Var.b();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            U1(view2);
            s2(-1);
            B2(-16777216);
            u2(H(R.string.obfuscated_res_0x7f0f1253));
            w2(true);
            I2(false);
        }
    }

    public final void W2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null || this.G0 == null) {
            return;
        }
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e2d);
        u03 a0 = u03.a0();
        if (a0 != null) {
            textView.setText(a0.X().K());
        }
        JSONObject optJSONObject = this.G0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e2e)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e30);
        t94 g = sw2.g(this.G0.optString("pluginProvider"));
        if (g != null) {
            textView2.setText(g.s);
        }
        ((Button) view2.findViewById(R.id.obfuscated_res_0x7f090e2f)).setOnClickListener(new a(this, optJSONObject));
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.a02, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.a02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            G2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.v0(bundle);
            Bundle q = q();
            if (q == null) {
                return;
            }
            this.F0 = q.getString("plugin_fun_page_path");
            this.G0 = ud3.d(q.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07b8, viewGroup, false);
            T1(inflate);
            W2(inflate);
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.z0();
            t03.J().r().d0().v();
        }
    }
}
