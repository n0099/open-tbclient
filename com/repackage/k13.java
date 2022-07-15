package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.km1;
import com.repackage.xr2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k13 extends jr2 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicLong f;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;

    /* loaded from: classes6.dex */
    public class a implements xr2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ k13 f;

        public a(k13 k13Var, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k13Var, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = k13Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.repackage.xr2.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(j74.g().getOkHttpClient(), this.c);
                this.f.q(this.d);
            }
        }

        @Override // com.repackage.xr2.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f.p(this.d) <= 500) {
                return;
            }
            if (i <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", i);
                    jSONObject.put("totalBytesWritten", j);
                    jSONObject.put("totalBytesExpectedToWrite", j2);
                    this.a.handleSchemeDispatchCallback(this.e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e) {
                    if (e23.b) {
                        e.printStackTrace();
                    }
                }
            }
            this.f.c.put(this.d, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // com.repackage.xr2.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(j74.g().getOkHttpClient(), this.c);
                this.f.q(this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ k13 j;

        public b(k13 k13Var, CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k13Var, callbackHandler, str, str2, str3, str4, str5, str6, str7, str8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = k13Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                ul2.U().R();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                this.j.q(this.c);
                if (SwanAppNetworkUtils.i(null)) {
                    a73.v(0, this.d, 0, iOException.getMessage(), this.e, this.f);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    if (!TextUtils.isEmpty(this.g)) {
                        str = this.j.y(this.g);
                    } else {
                        str = k13.A(jr2.s(response.headers()), this.h);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (e23.b) {
                    Log.d("DownloadFileAction", "the real file path is " + str);
                }
                try {
                    this.j.r(this.i, jr2.s(response.headers()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(this.g)) {
                    str2 = ul2.U().G().h(str);
                } else {
                    str2 = this.g;
                }
                if (TextUtils.isEmpty(str2)) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", code);
                        jSONObject.put(TextUtils.isEmpty(this.g) ? "tempFilePath" : "filePath", str2);
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (mg4.a(byteStream, file)) {
                            this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } else {
                            this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                        }
                    } catch (Exception e3) {
                        if (e23.b) {
                            e3.printStackTrace();
                        }
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(201, e3.getMessage()).toString());
                    }
                    this.j.q(this.c);
                    ul2.U().R();
                    if (e23.b) {
                        Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + this.d + ", msg=" + message);
                    }
                    a73.v(code, this.d, 0, message, this.e, this.f);
                } catch (Throwable th) {
                    this.j.q(this.c);
                    ul2.U().R();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements km1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(k13 k13Var, String str, CallbackHandler callbackHandler, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k13Var, str, callbackHandler, str2, str3, str4, str5, str6, str7, str8, str9, str10};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755611772, "Lcom/repackage/k13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755611772, "Lcom/repackage/k13;");
                return;
            }
        }
        f = new AtomicLong(System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k13(e13 e13Var) {
        super(e13Var, "/swanAPI/downloadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
    }

    @Nullable
    public static String A(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        String str2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, str)) == null) {
            String optString = jSONObject.optString("Content-Disposition", null);
            if (!TextUtils.isEmpty(optString)) {
                String e = dd3.e(optString);
                if (!TextUtils.isEmpty(e) && (lastIndexOf = e.lastIndexOf(".") + 1) > 0) {
                    str = e.substring(lastIndexOf);
                }
            } else {
                String optString2 = jSONObject.optString("Content-Type", null);
                if (!TextUtils.isEmpty(optString2)) {
                    String[] split = optString2.split(ParamableElem.DIVIDE_PARAM);
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String c2 = dd3.c(split[i]);
                        if (!TextUtils.isEmpty(c2)) {
                            str = c2;
                            break;
                        }
                        i++;
                    }
                }
            }
            long andIncrement = f.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append(andIncrement);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            sb.append(str2);
            return ul2.U().G().c(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    public km1.a B(CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, callbackHandler, str, jSONObject, str2)) == null) {
            String optString = jSONObject.optString("filePath");
            String optString2 = jSONObject.optString("url");
            String z = z(optString2);
            return new c(this, str, callbackHandler, jSONObject.optString("onProgressUpdate"), jSONObject.optString("cb"), str2, optString2, a73.l(), be3.n().e(), optString, z, jSONObject.optString("headersReceivedEvent"));
        }
        return (km1.a) invokeLLLL.objValue;
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (h03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = e23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String optString4 = a2.optString("filePath");
            if (!TextUtils.isEmpty(optString4) && jg4.x(optString4)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
                return false;
            }
            String g0 = h03.g0();
            if (TextUtils.isEmpty(g0)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = wp1.a(g0);
            Request x = x(a2, a3);
            if (x == null) {
                unitedSchemeEntity.result = t(this.e);
                return false;
            }
            String httpUrl = x.url().toString();
            String z = z(httpUrl);
            JSONObject optJSONObject = a2.optJSONObject("header");
            yr2 yr2Var = new yr2();
            HashMap<String, String> m = jr2.m(optJSONObject, true);
            String optString5 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString5)) {
                g94 h = fw2.h(optString5);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", ew2.b(h));
            }
            yr2Var.a(m);
            ul2.U().a0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.c.put(valueOf, 0L);
            if (oj2.v().i()) {
                lm1 lm1Var = new lm1();
                lm1Var.H(a2.optString("url"));
                lm1Var.G(optString4);
                oj2.v().C(context, new lm1().H(a2.optString("url")).I(false).E(a3).G(optString4).F(m), B(callbackHandler, valueOf, a2, a3));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
                return true;
            }
            xr2 xr2Var = new xr2();
            xr2Var.b(new a(this, callbackHandler, optString3, a3, valueOf, optString));
            String l = a73.l();
            String e = be3.n().e();
            if (SwanAppNetworkUtils.i(null)) {
                a73.A(httpUrl, 0);
            }
            OkHttpClient.Builder i = j74.g().i();
            i.addNetworkInterceptor(new as2());
            j74.g().w(i);
            i.addInterceptor(yr2Var).addNetworkInterceptor(xr2Var).build().newCall(zr2.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(this, callbackHandler, optString3, valueOf, httpUrl, l, e, optString4, z, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        HttpUrl f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = wp1.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = y03.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.e = c2;
            if (c2 != 0) {
                return null;
            }
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return (Request) invokeLL.objValue;
    }

    @Nullable
    public final String y(@NonNull String str) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String i = ul2.U().G().i(str);
            if (i == null || i.endsWith(File.separator) || (parentFile = new File(i).getParentFile()) == null || !parentFile.exists()) {
                return null;
            }
            return i;
        }
        return (String) invokeL.objValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return jg4.t(parse.getPath());
        }
        return (String) invokeL.objValue;
    }
}
