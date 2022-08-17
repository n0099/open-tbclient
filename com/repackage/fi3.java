package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bp1;
import com.repackage.e63;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fi3 extends cp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends bp1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 d;

        /* renamed from: com.repackage.fi3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0478a implements sf3<c63<e63.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bp1.b a;
            public final /* synthetic */ a b;

            public C0478a(a aVar, bp1.b bVar) {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(c63<e63.e> c63Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                    if (x53.h(c63Var)) {
                        this.a.a(this.b.d.z());
                        return;
                    }
                    int b = c63Var.b();
                    this.a.a(new zs1(b, x53.f(b)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fi3 fi3Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var, str};
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
            this.d = fi3Var;
        }

        @Override // com.repackage.bp1
        @NonNull
        public zs1 d(@NonNull JSONObject jSONObject, @NonNull bp1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                z03 b0 = z03.b0();
                if (b0 == null) {
                    return new zs1(1001, "null swan runtime");
                }
                b0.e0().g(y03.K(), "mapp_i_get_bduss", new C0478a(this, bVar));
                return zs1.f();
            }
            return (zs1) invokeLL.objValue;
        }

        @Override // com.repackage.bp1
        @NonNull
        public zs1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.d.z() : (zs1) invokeL.objValue;
        }

        @Override // com.repackage.bp1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? y03.K().E() && y03.K().q().e0().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi3(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.cp1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public zs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new a(this, "getBDUSS"));
        }
        return (zs1) invokeL.objValue;
    }

    @NonNull
    public final zs1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = zg3.i(y03.K());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i);
                return new zs1(0, jSONObject);
            } catch (JSONException e) {
                p("#getBdussResult json put data fail", e, false);
                return new zs1(1001, "json put data fail");
            }
        }
        return (zs1) invokeV.objValue;
    }
}
