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
import com.repackage.a74;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class hm3 extends rj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f74 a;
        public final /* synthetic */ hm3 b;

        public a(hm3 hm3Var, f74 f74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm3Var, f74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm3Var;
            this.a = f74Var;
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

    public hm3() {
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

    @Override // com.repackage.rj1, com.repackage.a74
    public void d(int i, List<f74> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if ("wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(y03.K().getAppId()) || "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(y03.K().getAppId()) || !gk2.L().a()) {
                    return;
                }
                o(list);
            }
        }
    }

    @Override // com.repackage.a74
    public void f(int i, List<f74> list, a74.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.repackage.a74
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.rj1, com.repackage.a74
    public boolean j(f74 f74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f74Var)) == null) {
            int c = f74Var.c();
            if (c == 40) {
                u(f74Var);
            } else if (c == 45) {
                t(f74Var);
            }
            return super.j(f74Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.a74
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        z03 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (te3.Q()) {
                Context appContext = AppRuntime.getAppContext();
                if (fp1.y(appContext) && (b0 = z03.b0()) != null && b0.N().e(appContext)) {
                    PMSAppInfo f0 = b0.W().f0();
                    return (b0.w0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void o(List<f74> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        list.add(new f74(40, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800f1, true));
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

    public final void q(f74 f74Var) {
        z03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, f74Var) == null) || (b0 = z03.b0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zd3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, b0.getAppId());
        zd3.f(jSONObject, "srcAppPage", zq2.b(te3.n()));
        JSONObject jSONObject2 = new JSONObject();
        zd3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        zd3.f(jSONObject2, "path", "pages/conversation/index");
        zd3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(b0));
        zd3.f(jSONObject, "params", jSONObject2);
        String I = gk2.o().I();
        a84 a84Var = new a84(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, f74Var));
        a84Var.f = true;
        a84Var.g = false;
        a84Var.h = true;
        b84.g().e(a84Var);
    }

    public final void r(List<f74> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && te3.Q() && fp1.y(AppRuntime.getAppContext())) {
            list.add(new f74(45, R.string.obfuscated_res_0x7f0f1248, R.drawable.obfuscated_res_0x7f0800de, true));
        }
    }

    public final JSONObject s(z03 z03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, z03Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = z03Var.W().f0();
            zd3.f(jSONObject, "appname", f0.appName);
            zd3.f(jSONObject, "iconUrl", f0.iconUrl);
            zd3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            zd3.f(jSONObject, "pa", f0.paNumber);
            zd3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            zd3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(te3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void t(f74 f74Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, f74Var) == null) || z03.b0() == null) {
            return;
        }
        q(f74Var);
    }

    public final void u(f74 f74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, f74Var) == null) {
            pq2.o("appletCenter");
            bn3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void w(f74 f74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, f74Var) == null) {
            gk2.i().d();
            xq2.j(f74Var);
            pq2.q("customerService", String.valueOf(f74Var.e() > 0 ? 1 : 0), "click");
            xq2.i();
        }
    }

    public final void x(Response response, f74 f74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, f74Var) == null) {
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
                    w(f74Var);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }
}
