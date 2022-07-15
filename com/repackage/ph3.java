package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ph3 extends ko1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ph3 b;

        public a(ph3 ph3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.b.C(this.a);
                    return;
                }
                int b = k53Var.b();
                f53.f(b);
                this.b.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ph3 b;

        /* loaded from: classes6.dex */
        public class a implements oi3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
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

            @Override // com.repackage.oi3
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        b bVar = this.a;
                        bVar.b.d(bVar.a, new hs1(0));
                        return;
                    }
                    b bVar2 = this.a;
                    bVar2.b.d(bVar2.a, new hs1(10004, "user not logged in"));
                }
            }
        }

        public b(ph3 ph3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph3Var;
            this.a = str;
        }

        @Override // com.repackage.mi3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.b.d(this.a, new hs1(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i = quickLoginInfo.loginMode;
                if (z) {
                    pi3.e(g03.K().w(), i, new a(this));
                } else {
                    this.b.d(this.a, new hs1(10004, "user not logged in"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ph3 b;

        public c(ph3 ph3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.b.B(this.a);
                    return;
                }
                int b = k53Var.b();
                f53.f(b);
                this.b.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements mi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ph3 b;

        public d(ph3 ph3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph3Var;
            this.a = str;
        }

        @Override // com.repackage.mi3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.b.D(this.a);
                } else {
                    this.b.E(this.a, quickLoginInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ph3(@NonNull io1 io1Var) {
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

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            pi3.b(new d(this, str));
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            pi3.b(new b(this, str));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new hs1(10001, "internal error"));
        }
    }

    public final void E(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new hs1(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                d(str, new hs1(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new hs1(1001));
            }
        }
    }

    public hs1 F(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess() && (obj = s.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(1001, "cb is empty");
                }
                h03 b0 = h03.b0();
                if (b0 == null) {
                    return new hs1(1001);
                }
                b0.e0().g(getContext(), "scope_quick_login", new c(this, optString));
                return new hs1(0);
            }
            hx1.c("QuickLoginApi", "parse fail");
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 G(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#quickLogin", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (!hs1Var.isSuccess() || (obj = s.second) == null) {
                return hs1Var;
            }
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new hs1(1001, "cb is empty");
            }
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new hs1(1001);
            }
            b0.e0().g(getContext(), "scope_quick_login", new a(this, optString));
            return hs1.f();
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PrivateBusiness" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "QuickLoginApi" : (String) invokeV.objValue;
    }
}
