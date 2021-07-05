package d.a.q0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.q0.a.v2.q0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class n extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47072g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47073h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47074i;
        public final /* synthetic */ String j;
        public final /* synthetic */ n k;

        public a(n nVar, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = nVar;
            this.f47070e = callbackHandler;
            this.f47071f = str;
            this.f47072g = str2;
            this.f47073h = context;
            this.f47074i = jSONObject;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar != null && !fVar.f47631d) {
                    if (this.k.m(fVar, this.f47072g)) {
                        this.k.l(this.f47073h, this.f47074i, this.f47070e, this.f47071f, this.j);
                        return;
                    } else {
                        this.f47070e.handleSchemeDispatchCallback(this.f47071f, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                if (a0.f46883b) {
                    Log.i("OpenAppAction", "no configuration of authority");
                }
                d.a.q0.a.e2.c.d.n(10005, this.f47070e, this.f47071f);
                d.a.q0.a.j2.k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q0.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47075a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47076b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47077c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47078d;

        public b(n nVar, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, callbackHandler, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47075a = callbackHandler;
            this.f47076b = str;
            this.f47077c = str2;
            this.f47078d = str3;
        }

        @Override // d.a.q0.a.v2.q0.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f47075a.handleSchemeDispatchCallback(this.f47076b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                c.a("open", this.f47077c, "confirm", this.f47078d);
            }
        }

        @Override // d.a.q0.a.v2.q0.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47075a.handleSchemeDispatchCallback(this.f47076b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.f47077c, QueryResponse.Options.CANCEL, this.f47078d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                String str8 = "";
                if (Q != null) {
                    str8 = d.a.q0.a.j2.k.m(Q.l());
                    str6 = Q.getAppId();
                    str7 = Q.O();
                    str5 = Q.L().T();
                } else {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                }
                String a2 = d.a.q0.a.c1.a.m().a();
                eVar.f49119a = str8;
                eVar.f49120b = str;
                eVar.f49123e = str2;
                eVar.f49124f = str6;
                eVar.f49121c = str5;
                eVar.a("appName", str7);
                eVar.a("hostName", a2);
                eVar.a("hostVersion", q0.D());
                eVar.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                eVar.a("scheme", str4);
                d.a.q0.a.j2.b.i("2572", "90", eVar.f());
                if (a0.f46883b) {
                    Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", eVar.f()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                return false;
            }
            String optString = a2.optString("cb");
            if (a0.f46883b) {
                Log.i("OpenAppAction", "params is " + a2.toString());
            }
            String optString2 = a2.optString("open", "");
            String optString3 = a2.optString("invokeFrom", "");
            c.a("invoke", optString3, null, optString2);
            eVar.T().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
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
                d.a.q0.a.c1.a.K().a(optString, jSONObject.optJSONObject("extraParams"));
                if (a0.f46883b) {
                    Log.i("OpenAppAction", "openUrl:" + optString);
                }
                z = o(context, optString, callbackHandler, str, str2);
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (a0.f46883b) {
                Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
            }
            if (!optBoolean) {
                if (z) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
            } else if (z) {
            } else {
                boolean e2 = q0.e(context, jSONObject.optString("download"));
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(e2 ? 0 : 1001, e2 ? "下载APP成功" : "下载APP失败").toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(d.a.q0.a.e2.c.f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            if (fVar != null && !TextUtils.isEmpty(str)) {
                String T = d.a.q0.a.a2.d.g().r().L().T();
                if (TextUtils.isEmpty(T)) {
                    T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                JSONObject jSONObject = fVar.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (a0.f46883b) {
                        Log.i("OpenAppAction", "source: " + T + " openUrl:" + str + " 配置数据:" + jSONObject);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    if (length > 0) {
                        boolean z = false;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (T.equals(optJSONArray.optString(i2))) {
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
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2);
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
            return q0.W(context, str, new b(this, callbackHandler, str2, str3, str));
        }
        return invokeLLLLL.booleanValue;
    }
}
