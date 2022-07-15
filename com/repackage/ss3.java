package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.swan.gamecenter.network.models.ReservationGameResultData;
import com.baidu.swan.gamecenter.network.models.ResultData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ss3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Gson a;

    /* loaded from: classes7.dex */
    public class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts3 a;
        public final /* synthetic */ ss3 b;

        /* renamed from: com.repackage.ss3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0732a extends TypeToken<ResultData<ReservationGameResultData>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0732a(a aVar) {
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
                    }
                }
            }
        }

        public a(ss3 ss3Var, ts3 ts3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss3Var, ts3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ss3Var;
            this.a = ts3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || TextUtils.isEmpty(str) || this.a == null) {
                return;
            }
            ResultData resultData = (ResultData) this.b.a.fromJson(str, new C0732a(this).getType());
            if (resultData == null) {
                this.a.onFail("result is null");
            } else if (resultData.errno == 0) {
                T t = resultData.data;
                if (t != 0 && ((ReservationGameResultData) t).apps != null) {
                    this.a.onSuccess(((ReservationGameResultData) t).apps);
                    return;
                }
                this.a.onFail("result data is null");
            } else {
                ts3 ts3Var = this.a;
                if (ts3Var != null) {
                    ts3Var.onFail(resultData.errmsg);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            ts3 ts3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) || (ts3Var = this.a) == null) {
                return;
            }
            ts3Var.onFail(exc.toString());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ss3 ss3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ss3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-3473249, "Lcom/repackage/ss3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-3473249, "Lcom/repackage/ss3$c;");
                    return;
                }
            }
            a = new ss3(null);
        }
    }

    public /* synthetic */ ss3(a aVar) {
        this();
    }

    public static final ss3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a : (ss3) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                zz2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f019b).G();
            } else if (TextUtils.isEmpty(str)) {
            } else {
                String n = xw3.b().n();
                j53 a2 = oj2.q().a();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", Long.valueOf(str));
                    j74.g().getRequest().cookieManager(a2).url(n).addUrlParam("data", jSONObject.toString()).build().executeAsync(new b(this));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void d(ts3<List<ReservationGameInfo>> ts3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ts3Var) == null) && SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            String c2 = xw3.b().c();
            j53 a2 = oj2.q().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 2);
                j74.g().getRequest().cookieManager(a2).url(c2).addUrlParam("data", jSONObject.toString()).build().executeAsync(new a(this, ts3Var));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public ss3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Gson();
    }
}
