package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nz3 extends mz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r72 b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<sz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ nz3 c;

        /* renamed from: com.repackage.nz3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0695a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sz3 a;
            public final /* synthetic */ a b;

            public RunnableC0695a(a aVar, sz3 sz3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, sz3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = sz3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    s24.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(nz3 nz3Var, uz3 uz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz3Var, uz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz3Var;
            this.a = uz3Var;
            this.b = os1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(sz3 sz3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sz3Var, i) == null) {
                if (mz3.a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.c.b.post(new RunnableC0695a(this, sz3Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public sz3 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                sz3 sz3Var = new sz3();
                sz3Var.result = !TextUtils.equals(optString2, "0");
                sz3Var.errNo = "0";
                sz3Var.errMsg = s24.b("checkIsUserAdvisedToRest", "ok");
                return sz3Var;
            }
            return (sz3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (mz3.a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    public nz3(@NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = r72Var;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (F = os1.F(jsObject)) == null || this.b == null) {
            return;
        }
        uz3 uz3Var = new uz3();
        try {
            int d = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", h03.g0());
                jSONObject.put("todayPlayedTime", String.valueOf(d));
            } catch (JSONException e) {
                if (mz3.a) {
                    e.printStackTrace();
                }
            }
            a(xw3.b().f(), jSONObject.toString(), new a(this, uz3Var, F));
        } catch (JSTypeMismatchException e2) {
            if (mz3.a) {
                e2.printStackTrace();
            }
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.a("checkIsUserAdvisedToRest", e2);
            s24.call(F, false, uz3Var);
        }
    }
}
