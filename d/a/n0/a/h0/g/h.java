package d.a.n0.a.h0.g;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.w;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String C0;
    public JSONObject D0;
    public boolean E0;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f44723f;

        public a(h hVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44723f = hVar;
            this.f44722e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.n0.a.g1.f.V().v(new d.a.n0.a.t1.c.c.b(this.f44723f.C0, this.f44722e.toString(), this.f44723f.D0.optString("slaveId")).a());
                this.f44723f.E0 = false;
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E0 = true;
    }

    public static h L2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            h hVar = new h();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                hVar.j1(bundle);
            }
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(d.a.n0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
            Q1(inflate);
            K2(inflate);
            if (P1()) {
                inflate = S1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.n0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k0 = null;
            super.E0();
        }
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.E0 || (jSONObject = this.D0) == null) {
                return false;
            }
            d.a.n0.a.t1.c.c.a aVar = new d.a.n0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f47387a = this.D0.optString("slaveId");
            aVar.b();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K2(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null || this.D0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.n0.a.f.id_swan_app_plugin_app_name);
        d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
        if (Q != null) {
            textView.setText(Q.N().K());
        }
        JSONObject optJSONObject = this.D0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(d.a.n0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(d.a.n0.a.f.id_swan_app_plugin_service_name);
        d.a.n0.n.h.h g2 = d.a.n0.a.t1.g.b.g(this.D0.optString("pluginProvider"));
        if (g2 != null) {
            textView2.setText(g2.s);
        }
        ((Button) view.findViewById(d.a.n0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(this, optJSONObject));
    }

    @Override // d.a.n0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            R1(view);
            l2(-1);
            t2(-16777216);
            n2(J(d.a.n0.a.h.swan_app_plugin_fun_page_title));
            p2(true);
            z2(false);
        }
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // d.a.n0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle n = n();
            if (n == null) {
                return;
            }
            this.C0 = n.getString("plugin_fun_page_path");
            this.D0 = w.d(n.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            d.a.n0.a.a2.d.g().r().T().v();
        }
    }

    @Override // d.a.n0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            x2(1);
        }
    }
}
