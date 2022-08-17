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
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class f04 extends e04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j82 b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<k04> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m04 a;
        public final /* synthetic */ gt1 b;
        public final /* synthetic */ f04 c;

        /* renamed from: com.repackage.f04$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0474a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k04 a;
            public final /* synthetic */ a b;

            public RunnableC0474a(a aVar, k04 k04Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, k04Var};
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
                this.a = k04Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    k34.call(this.b.b, true, this.a);
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
                    k34.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(f04 f04Var, m04 m04Var, gt1 gt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var, m04Var, gt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f04Var;
            this.a = m04Var;
            this.b = gt1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(k04 k04Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, k04Var, i) == null) {
                if (e04.a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.c.b.post(new RunnableC0474a(this, k04Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public k04 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (e04.a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (e04.a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    m04 m04Var = this.a;
                    m04Var.errNo = optString;
                    m04Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString(TiebaStatic.LogFields.RESULT);
                k04 k04Var = new k04();
                k04Var.result = !TextUtils.equals(optString2, "0");
                k04Var.errNo = "0";
                k04Var.errMsg = k34.b("checkIsUserAdvisedToRest", "ok");
                return k04Var;
            }
            return (k04) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (e04.a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    m04 m04Var = this.a;
                    m04Var.errNo = "100";
                    m04Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    public f04(@NonNull j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j82Var;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        gt1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (F = gt1.F(jsObject)) == null || this.b == null) {
            return;
        }
        m04 m04Var = new m04();
        try {
            int d = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", z03.g0());
                jSONObject.put("todayPlayedTime", String.valueOf(d));
            } catch (JSONException e) {
                if (e04.a) {
                    e.printStackTrace();
                }
            }
            a(px3.b().f(), jSONObject.toString(), new a(this, m04Var, F));
        } catch (JSTypeMismatchException e2) {
            if (e04.a) {
                e2.printStackTrace();
            }
            m04Var.errNo = FontParser.sFontWeightDefault;
            m04Var.errMsg = k34.a("checkIsUserAdvisedToRest", e2);
            k34.call(F, false, m04Var);
        }
    }
}
