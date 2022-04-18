package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mo1;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oq1 extends mq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements mo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq1 a;

        public a(oq1 oq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq1Var;
        }

        @Override // com.repackage.mo1.a
        public js1 a(j03 j03Var, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, j03Var, jSONObject, str)) == null) ? this.a.E(j03Var, jSONObject, str) : (js1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ oq1 b;

        public b(oq1 oq1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oq1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.B(this.a, exc == null ? "" : exc.getMessage());
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
                this.b.d(this.a, this.b.D(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oq1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, str) == null) {
            k74 k74Var = new k74(request.url().toString(), request.body(), new b(this, str));
            k74Var.i = request.tag();
            k74Var.f = true;
            k74Var.g = true;
            k74Var.h = true;
            l74.g().e(k74Var);
        }
    }

    public final void B(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            d(str, new js1(500106, str2));
        }
    }

    public final RequestBody C(@NonNull j03 j03Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, j03Var, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String N = j03Var.N();
            String optString2 = jSONObject.optString("templateId");
            if (TextUtils.isEmpty(N) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new FormBody.Builder().add("appkey", N).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
        }
        return (RequestBody) invokeLL.objValue;
    }

    public js1 D(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new js1(0, optJSONObject, false);
                    }
                    return new js1(500106, "subscribe fail");
                } catch (Exception e) {
                    return new js1(500106, Log.getStackTraceString(e));
                }
            }
            return new js1(500106, "response body is null");
        }
        return (js1) invokeL.objValue;
    }

    public final js1 E(@NonNull j03 j03Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, j03Var, jSONObject, str)) == null) {
            Pair<Request, Integer> z = z(j03Var, jSONObject);
            Request request = (Request) z.first;
            if (request == null) {
                return new js1(((Integer) z.second).intValue(), IActiveUploadListener.PARAM_ERR_MSG);
            }
            A(request, str);
            return new js1(0, "success");
        }
        return (js1) invokeLLL.objValue;
    }

    public js1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#subscribe params=" + str, false);
            return l(str, true, new a(this));
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SubscribeServiceApi" : (String) invokeV.objValue;
    }

    public final Pair<Request, Integer> z(@NonNull j03 j03Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, j03Var, jSONObject)) == null) {
            RequestBody C = C(j03Var, jSONObject);
            if (C == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(qj2.W().a()).post(C).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }
}
