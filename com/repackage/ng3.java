package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jn1;
import com.repackage.m43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ng3 extends kn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends jn1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng3 d;

        /* renamed from: com.repackage.ng3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0482a implements ae3<k43<m43.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jn1.b a;
            public final /* synthetic */ a b;

            public C0482a(a aVar, jn1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(k43<m43.e> k43Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                    if (f43.h(k43Var)) {
                        this.a.a(this.b.d.z());
                        return;
                    }
                    int b = k43Var.b();
                    this.a.a(new hr1(b, f43.f(b)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ng3 ng3Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ng3Var;
        }

        @Override // com.repackage.jn1
        @NonNull
        public hr1 d(@NonNull JSONObject jSONObject, @NonNull jn1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                hz2 a0 = hz2.a0();
                if (a0 == null) {
                    return new hr1(1001, "null swan runtime");
                }
                a0.d0().g(gz2.J(), "mapp_i_get_bduss", new C0482a(this, bVar));
                return hr1.f();
            }
            return (hr1) invokeLL.objValue;
        }

        @Override // com.repackage.jn1
        @NonNull
        public hr1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.d.z() : (hr1) invokeL.objValue;
        }

        @Override // com.repackage.jn1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? gz2.J().D() && gz2.J().r().d0().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ng3(@NonNull in1 in1Var) {
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

    @Override // com.repackage.kn1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public hr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new a(this, "getBDUSS"));
        }
        return (hr1) invokeL.objValue;
    }

    @NonNull
    public final hr1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = hf3.i(gz2.J());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i);
                return new hr1(0, jSONObject);
            } catch (JSONException e) {
                p("#getBdussResult json put data fail", e, false);
                return new hr1(1001, "json put data fail");
            }
        }
        return (hr1) invokeV.objValue;
    }
}
