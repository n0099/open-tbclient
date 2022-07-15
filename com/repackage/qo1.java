package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qo1 extends mo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qo1 b;

        public a(qo1 qo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qo1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<JSONObject> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                hs1 hs1Var = new hs1();
                String z = this.b.z(k53Var);
                if (TextUtils.isEmpty(z)) {
                    hs1Var.b = 1001;
                    hs1Var.c = "openid is empty";
                    this.b.d(this.a, hs1Var);
                    return;
                }
                hs1Var.g("openid", z);
                hs1Var.b = 0;
                this.b.d(this.a, hs1Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755373506, "Lcom/repackage/qo1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755373506, "Lcom/repackage/qo1;");
                return;
            }
        }
        f = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "OpenIdApi" : (String) invokeV.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getOpenId", false);
            if (f) {
                Log.d("OpenIdApi", "#getOpenId params = " + str);
            }
            Pair<hs1, JSONObject> s = s(str);
            if (!((hs1) s.first).isSuccess()) {
                return (hs1) s.first;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new hs1(202, "cb is empty");
            }
            o53 f2 = g03.K().x().a().b().f(g03.K());
            f2.o(new a(this, optString));
            f2.call();
            return hs1.f();
        }
        return (hs1) invokeL.objValue;
    }

    public final String z(k53<JSONObject> k53Var) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k53Var)) == null) ? (!k53Var.c() || (jSONObject = k53Var.a) == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? "" : optJSONObject.optString("openid") : (String) invokeL.objValue;
    }
}
