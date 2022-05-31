package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kn1;
import com.repackage.t83;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class op1 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements kn1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ op1 a;

        /* renamed from: com.repackage.op1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0485a implements t83.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ zp1 b;
            public final /* synthetic */ a c;

            public C0485a(a aVar, String str, zp1 zp1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, zp1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = str;
                this.b = zp1Var;
            }

            @Override // com.repackage.t83.a
            public void a(double[] dArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                    if (dArr == null || dArr.length != 3) {
                        this.c.a.p("illegal accelerometers", null, true);
                        this.c.a.d(this.a, new hr1(1001));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.b.d(this.c.a, jSONObject);
                    } catch (JSONException e) {
                        this.c.a.p("json put data fail", e, true);
                        this.b.f(this.c.a, "json put data fail");
                    }
                }
            }
        }

        public a(op1 op1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = op1Var;
        }

        @Override // com.repackage.kn1.a
        public hr1 a(hz2 hz2Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hz2Var, jSONObject, str)) == null) {
                zp1 zp1Var = new zp1("accelerometerChange", jSONObject, str);
                t83 a = t83.a();
                a.b(this.a.getContext(), b.a(jSONObject.optString("interval")));
                a.e(new C0485a(this, str, zp1Var));
                a.f();
                zp1Var.b(this.a);
                return hr1.f();
            }
            return (hr1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static ArrayMap<String, Integer> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-120820029, "Lcom/repackage/op1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-120820029, "Lcom/repackage/op1$b;");
                    return;
                }
            }
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            a = arrayMap;
            arrayMap.put("ui", 60);
            a.put("game", 20);
            a.put("normal", 200);
        }

        public static int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                Integer num = a.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 200;
            }
            return invokeL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public op1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hr1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startAccelerometer", false);
            return l(str, true, new a(this));
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#stopAccelerometer", true);
            t83.a().g();
            return hr1.f();
        }
        return (hr1) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "AccelerometerApi" : (String) invokeV.objValue;
    }
}
