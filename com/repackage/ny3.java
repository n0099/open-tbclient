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
public class ny3 extends my3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r62 b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<sy3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uy3 a;
        public final /* synthetic */ or1 b;
        public final /* synthetic */ ny3 c;

        /* renamed from: com.repackage.ny3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0484a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sy3 a;
            public final /* synthetic */ a b;

            public RunnableC0484a(a aVar, sy3 sy3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, sy3Var};
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
                this.a = sy3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s14.call(this.b.b, true, this.a);
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
                    s14.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(ny3 ny3Var, uy3 uy3Var, or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny3Var, uy3Var, or1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ny3Var;
            this.a = uy3Var;
            this.b = or1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(sy3 sy3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sy3Var, i) == null) {
                if (my3.a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.c.b.post(new RunnableC0484a(this, sy3Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public sy3 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (my3.a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (my3.a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    uy3 uy3Var = this.a;
                    uy3Var.errNo = optString;
                    uy3Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                sy3 sy3Var = new sy3();
                sy3Var.result = !TextUtils.equals(optString2, "0");
                sy3Var.errNo = "0";
                sy3Var.errMsg = s14.b("checkIsUserAdvisedToRest", "ok");
                return sy3Var;
            }
            return (sy3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (my3.a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uy3 uy3Var = this.a;
                    uy3Var.errNo = "100";
                    uy3Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    public ny3(@NonNull r62 r62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = r62Var;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        or1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (F = or1.F(jsObject)) == null || this.b == null) {
            return;
        }
        uy3 uy3Var = new uy3();
        try {
            int d = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", hz2.f0());
                jSONObject.put("todayPlayedTime", String.valueOf(d));
            } catch (JSONException e) {
                if (my3.a) {
                    e.printStackTrace();
                }
            }
            a(xv3.b().f(), jSONObject.toString(), new a(this, uy3Var, F));
        } catch (JSTypeMismatchException e2) {
            if (my3.a) {
                e2.printStackTrace();
            }
            uy3Var.errNo = FontParser.sFontWeightDefault;
            uy3Var.errMsg = s14.a("checkIsUserAdvisedToRest", e2);
            s14.call(F, false, uy3Var);
        }
    }
}
