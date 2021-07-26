package d.a.o0.b.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.b.n.g.e;
import d.a.o0.b.n.g.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f49412f;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49412f = cVar;
            this.f49411e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f49412f.w(this.f49411e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = d.a.o0.a.e2.c.d.f(b2);
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.e("Api-QuickLogin", "quick login failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f49412f.d(this.f49411e, new d.a.o0.a.u.h.b(b2, d.a.o0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.b.n.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49413a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f49414b;

        /* loaded from: classes7.dex */
        public class a implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f49415a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49415a = bVar;
            }

            @Override // d.a.o0.b.n.g.e
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        b bVar = this.f49415a;
                        bVar.f49414b.d(bVar.f49413a, new d.a.o0.a.u.h.b(0));
                        return;
                    }
                    b bVar2 = this.f49415a;
                    bVar2.f49414b.d(bVar2.f49413a, new d.a.o0.a.u.h.b(10004, "user not logged in"));
                }
            }
        }

        public b(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49414b = cVar;
            this.f49413a = str;
        }

        @Override // d.a.o0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f49414b.d(this.f49413a, new d.a.o0.a.u.h.b(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i2 = quickLoginInfo.loginMode;
                if (z) {
                    f.e(d.a.o0.a.a2.d.g().x(), i2, new a(this));
                } else {
                    this.f49414b.d(this.f49413a, new d.a.o0.a.u.h.b(10004, "user not logged in"));
                }
            }
        }
    }

    /* renamed from: d.a.o0.b.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1023c implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f49417f;

        public C1023c(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49417f = cVar;
            this.f49416e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f49417f.v(this.f49416e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = d.a.o0.a.e2.c.d.f(b2);
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.e("Api-QuickLogin", "query quick login info failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f49417f.d(this.f49416e, new d.a.o0.a.u.h.b(b2, d.a.o0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.b.n.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f49419b;

        public d(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49419b = cVar;
            this.f49418a = str;
        }

        @Override // d.a.o0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f49419b.x(this.f49418a);
                } else {
                    this.f49419b.y(this.f49418a, quickLoginInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.o0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-QuickLogin", "exec quickLogin");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-QuickLogin", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(1001, "cb is empty");
                }
                d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
                if (Q == null) {
                    return new d.a.o0.a.u.h.b(1001);
                }
                Q.T().g(i(), "scope_quick_login", new a(this, optString));
                return new d.a.o0.a.u.h.b(0);
            }
            d.a.o0.a.e0.d.b("Api-QuickLogin", "parse fail");
            return bVar;
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            f.b(new d(this, str));
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            f.b(new b(this, str));
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d(str, new d.a.o0.a.u.h.b(10001, "internal error"));
        }
    }

    public final void y(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new d.a.o0.a.u.h.b(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-QuickLogin", "query login info; data: " + jSONObject.toString());
                }
                d(str, new d.a.o0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    e2.printStackTrace();
                }
                d(str, new d.a.o0.a.u.h.b(1001));
            }
        }
    }

    public d.a.o0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-QuickLogin", "query quick login info");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-QuickLogin", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(1001, "cb is empty");
                }
                d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
                if (Q == null) {
                    return new d.a.o0.a.u.h.b(1001);
                }
                Q.T().g(i(), "scope_quick_login", new C1023c(this, optString));
                return new d.a.o0.a.u.h.b(0);
            }
            d.a.o0.a.e0.d.b("Api-QuickLogin", "parse fail");
            return bVar;
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
