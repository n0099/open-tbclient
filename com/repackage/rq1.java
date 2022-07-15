package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ga3;
import com.repackage.ko1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rq1 extends nq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ko1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq1 a;

        /* renamed from: com.repackage.rq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0724a implements ga3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zq1 a;
            public final /* synthetic */ a b;

            public C0724a(a aVar, zq1 zq1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zq1Var};
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
                this.a = zq1Var;
            }

            @Override // com.repackage.ga3.c
            public void a(float f, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f);
                        jSONObject.put("accuracy", ga3.h(i));
                        this.a.d(this.b.a, jSONObject);
                    } catch (JSONException e) {
                        hx1.c("CompassApi", "handle compass,json error，" + e.toString());
                        this.a.f(this.b.a, "Json error");
                    }
                }
            }
        }

        public a(rq1 rq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq1Var;
        }

        @Override // com.repackage.ko1.a
        public hs1 a(h03 h03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, h03Var, jSONObject, str)) == null) {
                zq1 zq1Var = new zq1("compassChange", jSONObject, str);
                ga3 i = ga3.i();
                i.l(this.a.getContext());
                i.o(new C0724a(this, zq1Var));
                hx1.i("CompassApi", "start listen compass");
                i.p();
                zq1Var.b(this.a);
                return hs1.f();
            }
            return (hs1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CompassApi" : (String) invokeV.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#startCompass", true);
            return l(str, true, new a(this));
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#stopCompass", true);
            ga3.i().q();
            return hs1.f();
        }
        return (hs1) invokeV.objValue;
    }
}
