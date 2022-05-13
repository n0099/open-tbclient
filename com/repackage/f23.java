package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.repackage.oe3;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f23 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<u53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;
        public final /* synthetic */ f23 g;

        public a(f23 f23Var, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f23Var, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = f23Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.e = jSONObject;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u53Var) == null) {
                if (u53Var != null && !u53Var.d) {
                    if (this.g.m(u53Var, this.c)) {
                        this.g.l(this.d, this.e, this.a, this.b, this.f);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                if (r23.b) {
                    Log.i("OpenAppAction", "no configuration of authority");
                }
                s53.o(10005, this.a, this.b);
                n73.r(10005, u53Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oe3.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(f23 f23Var, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f23Var, callbackHandler, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.repackage.oe3.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                c.a("open", this.c, "confirm", this.d);
            }
        }

        @Override // com.repackage.oe3.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.c, "cancel", this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                w73 w73Var = new w73();
                u03 a0 = u03.a0();
                String str8 = "";
                if (a0 != null) {
                    str8 = n73.n(a0.l());
                    str6 = a0.getAppId();
                    str7 = a0.Y();
                    str5 = a0.V().T();
                } else {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                }
                String a = bk2.n().a();
                w73Var.a = str8;
                w73Var.b = str;
                w73Var.e = str2;
                w73Var.f = str6;
                w73Var.c = str5;
                w73Var.a("appName", str7);
                w73Var.a("hostName", a);
                w73Var.a("hostVersion", oe3.D());
                w73Var.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                w73Var.a("scheme", str4);
                b73.i("2572", "90", w73Var.f());
                if (r23.b) {
                    Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", w73Var.f()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f23(r13 r13Var) {
        super(r13Var, "/swanAPI/openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (!bk2.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (u03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else {
                JSONObject a2 = r23.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                    return false;
                }
                String optString = a2.optString("cb");
                if (r23.b) {
                    Log.i("OpenAppAction", "params is " + a2.toString());
                }
                String optString2 = a2.optString("open", "");
                String optString3 = a2.optString("invokeFrom", "");
                c.a("invoke", optString3, null, optString2);
                if (optString2.startsWith(BaseWebViewActivity.SHOUBAI_SCHEME)) {
                    if (!bk2.a().c()) {
                        m03.f(context, R.string.obfuscated_res_0x7f0f1228).G();
                        return false;
                    }
                    l(context, a2, callbackHandler, optString, optString3);
                } else {
                    u03Var.d0().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, callbackHandler, str, str2) == null) {
            String optString = jSONObject.optString("open");
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                optString = Uri.decode(optString);
                bk2.P().a(optString, jSONObject.optJSONObject("extraParams"));
                if (r23.b) {
                    Log.i("OpenAppAction", "openUrl:" + optString);
                }
                z = o(context, optString, callbackHandler, str, str2);
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (r23.b) {
                Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
            }
            if (!optBoolean) {
                if (z) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
            } else if (z) {
            } else {
                boolean e = oe3.e(context, jSONObject.optString("download"));
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(e ? 0 : 1001, e ? "下载APP成功" : "下载APP失败").toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(u53 u53Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, u53Var, str)) == null) {
            if (u53Var != null && !TextUtils.isEmpty(str)) {
                String T = t03.J().r().V().T();
                if (TextUtils.isEmpty(T)) {
                    T = "NA";
                }
                JSONObject jSONObject = u53Var.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (r23.b) {
                        Log.i("OpenAppAction", "source: " + T + " openUrl:" + str + " 配置数据:" + jSONObject);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    if (length > 0) {
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (T.equals(optJSONArray.optString(i))) {
                                z = true;
                            }
                        }
                        return z && n(str, optJSONArray2);
                    }
                    return n(str, optJSONArray2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jSONArray)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length > 0 && !TextUtils.isEmpty(str)) {
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        String decode = Uri.decode(optString);
                        int indexOf = decode.indexOf(":");
                        if (indexOf > 0) {
                            decode = decode.substring(0, indexOf);
                        }
                        if (str.startsWith(decode)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(Context context, String str, CallbackHandler callbackHandler, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, str, callbackHandler, str2, str3)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return oe3.Z(context, str, new b(this, callbackHandler, str2, str3, str));
        }
        return invokeLLLLL.booleanValue;
    }
}
