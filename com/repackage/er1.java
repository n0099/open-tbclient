package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ta3;
import com.repackage.xo1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class er1 extends ar1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er1 a;

        /* renamed from: com.repackage.er1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0409a implements ta3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mr1 a;
            public final /* synthetic */ a b;

            public C0409a(a aVar, mr1 mr1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, mr1Var};
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
                this.a = mr1Var;
            }

            @Override // com.repackage.ta3.c
            public void a(float f, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f);
                        jSONObject.put("accuracy", ta3.h(i));
                        this.a.d(this.b.a, jSONObject);
                    } catch (JSONException e) {
                        ux1.c("CompassApi", "handle compass,json error，" + e.toString());
                        this.a.f(this.b.a, "Json error");
                    }
                }
            }
        }

        public a(er1 er1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = er1Var;
        }

        @Override // com.repackage.xo1.a
        public us1 a(u03 u03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, u03Var, jSONObject, str)) == null) {
                mr1 mr1Var = new mr1("compassChange", jSONObject, str);
                ta3 i = ta3.i();
                i.l(this.a.getContext());
                i.o(new C0409a(this, mr1Var));
                ux1.i("CompassApi", "start listen compass");
                i.p();
                mr1Var.b(this.a);
                return us1.f();
            }
            return (us1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CompassApi" : (String) invokeV.objValue;
    }

    public us1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#startCompass", true);
            return l(str, true, new a(this));
        }
        return (us1) invokeL.objValue;
    }

    public us1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#stopCompass", true);
            ta3.i().q();
            return us1.f();
        }
        return (us1) invokeV.objValue;
    }
}
