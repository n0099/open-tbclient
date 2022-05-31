package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import com.repackage.i54;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class pk3 extends zh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n54 a;
        public final /* synthetic */ pk3 b;

        public a(pk3 pk3Var, n54 n54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pk3Var, n54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pk3Var;
            this.a = n54Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.v();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.x(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    public pk3() {
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

    @Override // com.repackage.zh1, com.repackage.i54
    public void d(int i, List<n54> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if ("wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(gz2.J().getAppId()) || "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(gz2.J().getAppId()) || !oi2.L().a()) {
                    return;
                }
                o(list);
            }
        }
    }

    @Override // com.repackage.i54
    public void f(int i, List<n54> list, i54.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.repackage.i54
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.zh1, com.repackage.i54
    public boolean j(n54 n54Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, n54Var)) == null) {
            int c = n54Var.c();
            if (c == 40) {
                u(n54Var);
            } else if (c == 45) {
                t(n54Var);
            }
            return super.j(n54Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.i54
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        hz2 a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (bd3.Q()) {
                Context appContext = AppRuntime.getAppContext();
                if (nn1.y(appContext) && (a0 = hz2.a0()) != null && a0.M().e(appContext)) {
                    PMSAppInfo f0 = a0.V().f0();
                    return (a0.v0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void o(List<n54> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        list.add(new n54(40, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800f2, true));
    }

    public final Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void q(n54 n54Var) {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, n54Var) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        hc3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, a0.getAppId());
        hc3.f(jSONObject, "srcAppPage", hp2.b(bd3.n()));
        JSONObject jSONObject2 = new JSONObject();
        hc3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        hc3.f(jSONObject2, "path", "pages/conversation/index");
        hc3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(a0));
        hc3.f(jSONObject, "params", jSONObject2);
        String I = oi2.o().I();
        i64 i64Var = new i64(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, n54Var));
        i64Var.f = true;
        i64Var.g = false;
        i64Var.h = true;
        j64.g().e(i64Var);
    }

    public final void r(List<n54> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && bd3.Q() && nn1.y(AppRuntime.getAppContext())) {
            list.add(new n54(45, R.string.obfuscated_res_0x7f0f1255, R.drawable.obfuscated_res_0x7f0800df, true));
        }
    }

    public final JSONObject s(hz2 hz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hz2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = hz2Var.V().f0();
            hc3.f(jSONObject, "appname", f0.appName);
            hc3.f(jSONObject, "iconUrl", f0.iconUrl);
            hc3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            hc3.f(jSONObject, "pa", f0.paNumber);
            hc3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            hc3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(bd3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void t(n54 n54Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, n54Var) == null) || hz2.a0() == null) {
            return;
        }
        q(n54Var);
    }

    public final void u(n54 n54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, n54Var) == null) {
            xo2.o("appletCenter");
            jl3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void w(n54 n54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, n54Var) == null) {
            oi2.i().d();
            fp2.j(n54Var);
            xo2.q("customerService", String.valueOf(n54Var.e() > 0 ? 1 : 0), "click");
            fp2.i();
        }
    }

    public final void x(Response response, n54 n54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, n54Var) == null) {
            try {
                if (!response.isSuccessful()) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    v();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    v();
                    return;
                }
                Uri p = p(optJSONObject.optString("scheme"));
                if (p == null) {
                    v();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), p, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    w(n54Var);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }
}
