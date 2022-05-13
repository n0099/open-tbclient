package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n53;
import com.repackage.z53;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m53 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ m53 f;

        public a(m53 m53Var, CallbackHandler callbackHandler, String str, Context context, u03 u03Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, callbackHandler, str, context, u03Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = m53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = u03Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                n53.b d = n53.d();
                d.n(false);
                d.o();
                s53.q(x53Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rs2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ m53 f;

        /* loaded from: classes6.dex */
        public class a implements nf3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.m53$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0462a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0462a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
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
                    this.a = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.b;
                        m53 m53Var = aVar.c.f;
                        u53 u53Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        m53Var.P(u53Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, u53 u53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, u53Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = u53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    oe3.a0(new RunnableC0462a(this, bool));
                }
            }
        }

        /* renamed from: com.repackage.m53$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0463b implements nf3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.m53$b$b$a */
            /* loaded from: classes6.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0463b a;

                public a(C0463b c0463b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0463b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0463b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0463b c0463b = this.a;
                        b bVar = c0463b.c;
                        bVar.f.P(c0463b.a, c0463b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0463b(b bVar, u53 u53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, u53Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = u53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    oe3.a0(new a(this));
                }
            }
        }

        public b(m53 m53Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, u03 u03Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, callbackHandler, str, jSONArray, u03Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = m53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = u03Var;
            this.e = activity;
        }

        @Override // com.repackage.rs2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, u53> g = ss2.g(true);
                u53 y = this.f.y(g, this.a, this.b);
                if (y != null) {
                    List<u53> w = this.f.w(g, this.c, this.a, this.b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.d.M().e(this.e)) {
                        this.f.z(new C0463b(this, y, w));
                        return;
                    } else {
                        bk2.Z().a(this.e, new a(this, y, w));
                        return;
                    }
                }
                n53.b d = n53.d();
                d.n(false);
                d.o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements p53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ m53 g;

        public c(m53 m53Var, CallbackHandler callbackHandler, String str, boolean z, u03 u03Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, callbackHandler, str, Boolean.valueOf(z), u03Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = m53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = u03Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.repackage.p53
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ux1.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    n53.b d = n53.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    s53.o(10003, this.a, this.b);
                    return;
                }
                n53.b d2 = n53.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.M().e(this.e)) {
                    n53.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (z2) {
                    this.g.K(this.f, this.e, this.a, this.b);
                } else {
                    n53.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m53 e;

        public d(m53 m53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.repackage.m53.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                ux1.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    n53.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                n53.b d = n53.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                s53.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements nf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m53 e;

        public e(m53 m53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m53 e;

        public f(m53 m53Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m53Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    n53.b d = n53.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                n53.b d2 = n53.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                s53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements nf3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m53 e;

        public g(m53 m53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    n53.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                n53.b d = n53.d();
                d.m(false);
                d.n(false);
                d.o();
                s53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(m53 m53Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (x53Var == null) {
                    s53.o(10001, this.a, this.b);
                    n53.b d = n53.d();
                    d.n(false);
                    d.o();
                    n73.r(10001, null);
                    return;
                }
                int b = x53Var.b();
                ux1.o("MultiAuthorize", "requestAuthorize " + x53Var.a() + ",  code=" + b + ", data=" + x53Var.a);
                if (b != 0) {
                    n53.b d2 = n53.d();
                    d2.n(false);
                    d2.o();
                    s53.o(b, this.a, this.b);
                    return;
                }
                n53.b d3 = n53.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(m53 m53Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m53Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    this.a.a(false, i);
                } else {
                    this.a.a(true, i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m53(r13 r13Var) {
        super(r13Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<u53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (u53 u53Var : list) {
                    if (u53Var != null && C(u53Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(u53 u53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u53Var)) == null) ? TextUtils.equals(u53Var.b, "mapp_location") || TextUtils.equals(u53Var.b, "mapp_images") || TextUtils.equals(u53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(u53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(u53Var.b, "ppcert") || TextUtils.equals(u53Var.b, "mapp_i_face_verify") || TextUtils.equals(u53Var.b, "snsapi_userinfo") || TextUtils.equals(u53Var.b, "mapp_choose_address") || TextUtils.equals(u53Var.b, "mobile") || TextUtils.equals(u53Var.b, "mapp_choose_invoice") || TextUtils.equals(u53Var.b, "mapp_i_read_contacts") || TextUtils.equals(u53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(u53 u53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u53Var)) == null) ? TextUtils.equals(u53Var.b, "ppcert") || TextUtils.equals(u53Var.b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<u53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (u53 u53Var : list) {
                if (u53Var != null && !E(u53Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(u53 u53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, u53Var)) == null) ? TextUtils.equals(u53Var.b, "mapp_location") || TextUtils.equals(u53Var.b, "mapp_images") || TextUtils.equals(u53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(u53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(u53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<u53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (u53 u53Var : list) {
                if (u53Var != null && C(u53Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<u53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, u03Var) == null) {
            if (D(list)) {
                n53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(u03Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<u53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                n53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<u53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                n53.b d2 = n53.d();
                d2.l(true);
                d2.i(true);
                ux1.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            n53.d().l(false);
            ux1.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<u53> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            z53 d2 = t03.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<u53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            bk2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull u03 u03Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, u03Var, activity, jVar) == null) {
            v(u03Var, activity, jVar);
        }
    }

    public final void M(nf3<String> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nf3Var) == null) {
            bk2.Z().b(false, nf3Var);
        }
    }

    public final void N(@NonNull Activity activity, u53 u53Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, u53Var, str) == null) {
            String Y = t03.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(u53Var.s)) {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12cd) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            } else if (equals) {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12cd) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            } else {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12cf) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            }
        }
    }

    public final void O(@NonNull Activity activity, u53 u53Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, u53Var, bool) == null) {
            String Y = t03.J().r().Y();
            boolean D = D(u53Var.s);
            boolean A = A(u53Var.s);
            if (!bool.booleanValue() && !D) {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ce) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            } else if (A) {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12cf) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            } else {
                u53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12cd) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12cc);
            }
        }
    }

    public final void P(u53 u53Var, List<u53> list, boolean z, @NonNull Activity activity, @NonNull u03 u03Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{u53Var, list, Boolean.valueOf(z), activity, u03Var, callbackHandler, str}) == null) {
            s53.u(activity, u03Var, u53Var, new JSONObject(), new c(this, callbackHandler, str, z, u03Var, activity, list));
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (u03Var != null && (context instanceof Activity)) {
                JSONObject a2 = r23.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        n53.d().n(true);
                        u03Var.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, u03Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    n53.b d2 = n53.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                n53.b d3 = n53.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            n53.b d4 = n53.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull u03 u03Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, u03Var, activity, jVar) == null) {
            u03Var.M().f(activity, null, new i(this, jVar));
        }
    }

    public final List<u53> w(Map<String, u53> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = u53.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    u53 u53Var = map.get(c2);
                    if (map.containsKey(c2) && u53Var != null && B(u53Var)) {
                        if (u53Var.d) {
                            s53.o(10005, callbackHandler, str);
                            n53.b d2 = n53.d();
                            d2.n(false);
                            d2.o();
                            n73.r(10005, u53Var);
                            return null;
                        }
                        if (!arrayList.contains(u53Var) && !u53Var.a()) {
                            arrayList.add(u53Var);
                        }
                        if (!u53Var.a()) {
                            z = false;
                        }
                    } else {
                        s53.o(10005, callbackHandler, str);
                        n53.b d3 = n53.d();
                        d3.n(false);
                        d3.o();
                        n73.r(10005, u53Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                n53.b d4 = n53.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            ux1.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                n53.b d5 = n53.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull u03 u03Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, u03Var, callbackHandler, jSONArray, str) == null) {
            qs2.g().z(new b(this, callbackHandler, str, jSONArray, u03Var, activity));
        }
    }

    public final u53 y(Map<String, u53> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            u53 u53Var = map.get("scope_multi_authorize");
            if (u53Var == null) {
                s53.o(10001, callbackHandler, str);
                n73.r(10001, null);
                return null;
            } else if (u53Var.d) {
                s53.o(10005, callbackHandler, str);
                n73.r(10005, u53Var);
                return null;
            } else {
                return u53Var;
            }
        }
        return (u53) invokeLLL.objValue;
    }

    public final void z(nf3<String> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, nf3Var) == null) {
            bk2.Z().c(bk2.c(), nf3Var);
        }
    }
}
