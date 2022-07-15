package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek1;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ug1 extends i03 {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public final xe3 a;
    public String b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ Bundle d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ug1 ug1Var, tg1 tg1Var, Activity activity, Bundle bundle) {
            super(ug1Var, tg1Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug1Var, tg1Var, activity, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ug1) objArr2[0], (tg1) objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = activity;
            this.d = bundle;
        }

        @Override // com.repackage.ug1.c
        public void c(tg1 tg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tg1Var) == null) {
                oj2.h0().b(this.c, this.d, tg1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek1.b a;

        public b(ek1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.b(exc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    hx1.c("SwanAppAccount", "Response is null");
                    this.a.a(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    this.a.a(true);
                } else {
                    this.a.a(false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(mg4.b(response.body().byteStream()));
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class c extends ve3 implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tg1 b;

        public /* synthetic */ c(ug1 ug1Var, tg1 tg1Var, a aVar) {
            this(ug1Var, tg1Var);
        }

        public abstract void c(tg1 tg1Var);

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                tg1 tg1Var = this.b;
                if (tg1Var != null) {
                    tg1Var.onResult(i);
                }
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c(this);
            }
        }

        public c(ug1 ug1Var, tg1 tg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug1Var, tg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tg1Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755262030, "Lcom/repackage/ug1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755262030, "Lcom/repackage/ug1;");
                return;
            }
        }
        d = bx1.b() + "/ma/relate2user";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug1(h03 h03Var) {
        super(h03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new xe3();
        this.c = false;
    }

    public static void b(String str, ek1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, bVar) == null) {
            j74.g().getRequest().url(d).cookieManager(oj2.q().a()).addUrlParam(GameGuideConfigInfo.KEY_APP_KEY, str).addUrlParam("launchid", hu2.b()).build().executeAsyncOnUIBack(new b(bVar));
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.a.c();
            }
        }
    }

    public String c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            String h = oj2.h0().h(context);
            h(h);
            return h;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c) {
                return TextUtils.isEmpty(this.b) ? "" : this.b;
            }
            return c(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? oj2.h0().e(context) : invokeL.booleanValue;
    }

    public void f(Activity activity, Bundle bundle, tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, bundle, tg1Var) == null) {
            g(new a(this, tg1Var, activity, bundle));
        }
    }

    public final void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.a.d(cVar);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
            this.c = true;
        }
    }
}
