package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.plugin.Plugin;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pv2 extends ko1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements t12<sv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv2 a;

        public a(pv2 pv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(sv2 sv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var) == null) {
                this.a.C(sv2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements t12<sv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv2 a;

        public b(pv2 pv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(sv2 sv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var) == null) {
                this.a.C(sv2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements t12<sv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv2 a;

        public c(pv2 pv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(sv2 sv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var) == null) {
                this.a.C(sv2Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pv2(@NonNull io1 io1Var) {
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

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#invokePluginPayment", false);
            rv2 B = B(str);
            if (B.b()) {
                zv2.b(B.toString());
                return B.i;
            }
            return new xv2().l(B, new c(this));
        }
        return (hs1) invokeL.objValue;
    }

    public final rv2 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            rv2 rv2Var = new rv2();
            Pair<hs1, JSONObject> s = s(str);
            rv2Var.i = (hs1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return rv2Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                rv2Var.i = new hs1(201, "pluginProvider is empty");
                return rv2Var;
            }
            g94 g = fw2.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        rv2Var.i = new hs1(201, "providerRootPath is empty");
                        return rv2Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        rv2Var.i = new hs1(201, "slaveId is empty");
                        return rv2Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        rv2Var.i = new hs1(201, "componentId is empty");
                        return rv2Var;
                    }
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    String optString6 = jSONObject.optString("cb");
                    rv2Var.a = str2;
                    rv2Var.b = optString;
                    rv2Var.c = optString2;
                    rv2Var.d = str3;
                    rv2Var.e = optString3;
                    rv2Var.f = optString4;
                    rv2Var.g = optJSONObject;
                    rv2Var.h = optString6;
                    return rv2Var;
                }
            }
            rv2Var.i = new hs1(201, "pluginProvider exchange for truth app key，but empty");
            return rv2Var;
        }
        return (rv2) invokeL.objValue;
    }

    public final void C(sv2 sv2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sv2Var) == null) || sv2Var == null) {
            return;
        }
        sv2Var.b();
    }

    @Override // com.repackage.ko1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Plugin.TAG : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#invokePluginChooseAddress", false);
            rv2 B = B(str);
            if (B.b()) {
                zv2.b(B.toString());
                return B.i;
            }
            return new wv2().l(B, new b(this));
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            rv2 B = B(str);
            if (B.b()) {
                zv2.b(B.toString());
                return B.i;
            }
            return new yv2().l(B, new a(this));
        }
        return (hs1) invokeL.objValue;
    }
}
