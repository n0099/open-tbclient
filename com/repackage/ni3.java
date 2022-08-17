package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e63;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ni3 extends bs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ z03 d;
        public final /* synthetic */ ni3 e;

        /* renamed from: com.repackage.ni3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0536a implements sf3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0536a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    a aVar = this.a;
                    aVar.e.E(str, aVar.a, aVar.b, aVar.d);
                }
            }
        }

        public a(ni3 ni3Var, CallbackHandler callbackHandler, String str, String str2, z03 z03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, callbackHandler, str, str2, z03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ni3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = z03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (!x53.h(c63Var)) {
                    x53.q(c63Var, this.a, this.b);
                } else {
                    ni3.z(this.c, new C0536a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public b(ni3 ni3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, callbackHandler, str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.b, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;
        public final /* synthetic */ Request b;

        public c(sf3 sf3Var, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf3Var, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf3Var;
            this.b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.a(ni3.A(exc == null ? "" : exc.getMessage()));
                e83.b(SwanInterfaceType.REAL_NAME_CHECK, 2101, this.b.url().toString(), null, exc != null ? exc.getMessage() : "");
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                ni3.F(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements sf3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;

        public d(sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(Bundle bundle) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                if (bundle == null) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String g = yd3.g(bundle, "callbackKey");
                if (TextUtils.isEmpty(g)) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, yd3.g(bundle, "failMsg")).toString());
                    return;
                }
                zx1.i("FaceVerifyAction", g);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", g);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e) {
                    if (ni3.e) {
                        e.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.a.a(wrapCallbackParams.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755468583, "Lcom/repackage/ni3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755468583, "Lcom/repackage/ni3;");
                return;
            }
        }
        e = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni3(w13 w13Var) {
        super(w13Var, "/swanAPI/faceVerify");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((w13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            zx1.i("FaceVerifyAction", str);
            return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str, int i, String str2, Response response) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i, str2, response)) == null) {
            e83.c(SwanInterfaceType.REAL_NAME_CHECK, i, str2, response);
            return A(str);
        }
        return (String) invokeLILL.objValue;
    }

    public static void C(@NonNull Request request, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, sf3Var) == null) {
            a84 a84Var = new a84(request.url().toString(), request.body(), new c(sf3Var, request));
            a84Var.i = request.tag();
            a84Var.f = true;
            a84Var.g = true;
            a84Var.h = true;
            b84.g().e(a84Var);
            e83.a(SwanInterfaceType.REAL_NAME_CHECK);
        }
    }

    public static void D(String str, z03 z03Var, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, z03Var, sf3Var) == null) {
            zg3.J(z03Var.w(), str, z03Var.b, new d(sf3Var));
        }
    }

    public static void F(Response response, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, response, sf3Var) == null) {
            String str = null;
            if (response == null) {
                sf3Var.a(B(ADConfigError.REASON_NULL_RESPONSE, 2103, null, null));
            } else if (!response.isSuccessful()) {
                sf3Var.a(B("response code is error", 2104, null, response));
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    sf3Var.a(B("body is null", 2103, null, response));
                    return;
                }
                try {
                    str = body.string();
                } catch (IOException e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
                if (e) {
                    Log.d("FaceVerifyAction", "response body : " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    sf3Var.a(B("body is null", 2103, str, response));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        sf3Var.a(B(jSONObject.optString("errmsg"), optInt, str, response));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        sf3Var.a(A("server data is null"));
                    } else {
                        sf3Var.a(String.valueOf(optJSONObject.optInt("real_name")));
                    }
                } catch (JSONException e3) {
                    if (e) {
                        e3.printStackTrace();
                    }
                    sf3Var.a(B("body format error", 2103, str, response));
                }
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(vx1.a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
            for (Map.Entry<String, String> entry : ux1.b().d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            builder.post(new FormBody.Builder().build());
            builder.url(vx1.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }

    public static void z(String str, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, sf3Var) == null) {
            Request y = y(str);
            if (y == null) {
                sf3Var.a(null);
            } else {
                C(y, sf3Var);
            }
        }
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, z03 z03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, callbackHandler, str2, z03Var) == null) {
            if (str == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            } else {
                D(str, z03Var, new b(this, callbackHandler, str2));
            }
        }
    }

    @Override // com.repackage.w23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, z03Var)) == null) {
            if (z03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (z03Var.n0()) {
                if (e) {
                    Log.d("FaceVerifyAction", "FaceVerifyAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                    return false;
                }
                String a2 = oq1.a(z03Var.b);
                JSONObject n = n(a2);
                z03Var.e0().h(context, "mapp_i_face_verify", x53.j(optParamsAsJo), new a(this, callbackHandler, optString, a2, z03Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
