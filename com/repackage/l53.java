package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l53 extends s53<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String m;
    public final Activity n;
    public final boolean o;
    public final String p;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final boolean b;
        public final JSONObject c;

        public /* synthetic */ b(boolean z, String str, JSONObject jSONObject, a aVar) {
            this(z, str, jSONObject);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.b), this.a) : (String) invokeV.objValue;
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.b = z;
            this.c = jSONObject;
        }
    }

    public l53(Activity activity, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = activity;
        this.m = str;
        this.o = z;
        this.p = str2;
    }

    @Override // com.repackage.s53
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
            fs2.f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e53
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: P */
    public b m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            JSONObject c = f53.c(jSONObject);
            int optInt = c.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    f53.m(c);
                    f53.t("Accredit", c.toString());
                }
                if (e53.f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c.optString("errms"));
                }
            }
            JSONObject jSONObject3 = c.getJSONObject("data");
            String str = "";
            if (jSONObject3 != null) {
                str = jSONObject3.optString("code", "");
                jSONObject2 = jSONObject3.optJSONObject("opendata");
            } else {
                jSONObject2 = null;
            }
            return new b(this.o, str, jSONObject2, null);
        }
        return (b) invokeL.objValue;
    }

    @Override // com.repackage.e53
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().O());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, M().O());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", f53.g());
                String l = oj2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("permit", Boolean.toString(this.o));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(this.m, jSONObject3);
                jSONObject.put("accredits", jSONObject4);
                if (!TextUtils.isEmpty(this.p)) {
                    jSONObject.put("provider_appkey", this.p);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s53
    public HttpRequest w(s53 s53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, s53Var)) == null) ? oj2.o().o(this.n, s53Var.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // com.repackage.s53
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SwanInterfaceType.ACCREDIT_DATA : (SwanInterfaceType) invokeV.objValue;
    }
}
