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
import com.repackage.a53;
import com.repackage.m53;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z43 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ z43 f;

        public a(z43 z43Var, CallbackHandler callbackHandler, String str, Context context, h03 h03Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, callbackHandler, str, context, h03Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z43Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = h03Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                a53.b d = a53.d();
                d.n(false);
                d.o();
                f53.q(k53Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements es2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ z43 f;

        /* loaded from: classes7.dex */
        public class a implements af3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.z43$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0785a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0785a(a aVar, Boolean bool) {
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
                        z43 z43Var = aVar.c.f;
                        h53 h53Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        z43Var.P(h53Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, h53 h53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h53Var, list};
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
                this.a = h53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    be3.a0(new RunnableC0785a(this, bool));
                }
            }
        }

        /* renamed from: com.repackage.z43$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0786b implements af3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.z43$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0786b a;

                public a(C0786b c0786b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0786b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0786b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0786b c0786b = this.a;
                        b bVar = c0786b.c;
                        bVar.f.P(c0786b.a, c0786b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0786b(b bVar, h53 h53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h53Var, list};
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
                this.a = h53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    be3.a0(new a(this));
                }
            }
        }

        public b(z43 z43Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, h03 h03Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, callbackHandler, str, jSONArray, h03Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z43Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = h03Var;
            this.e = activity;
        }

        @Override // com.repackage.es2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, h53> g = fs2.g(true);
                h53 y = this.f.y(g, this.a, this.b);
                if (y != null) {
                    List<h53> w = this.f.w(g, this.c, this.a, this.b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.d.N().e(this.e)) {
                        this.f.z(new C0786b(this, y, w));
                        return;
                    } else {
                        oj2.Z().a(this.e, new a(this, y, w));
                        return;
                    }
                }
                a53.b d = a53.d();
                d.n(false);
                d.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ z43 g;

        public c(z43 z43Var, CallbackHandler callbackHandler, String str, boolean z, h03 h03Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, callbackHandler, str, Boolean.valueOf(z), h03Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z43Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = h03Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.repackage.c53
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                hx1.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    a53.b d = a53.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    f53.o(10003, this.a, this.b);
                    return;
                }
                a53.b d2 = a53.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    a53.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (z2) {
                    this.g.K(this.f, this.e, this.a, this.b);
                } else {
                    a53.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z43 e;

        public d(z43 z43Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z43Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.repackage.z43.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                hx1.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    a53.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                a53.b d = a53.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                f53.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements af3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z43 e;

        public e(z43 z43Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z43Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements af3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z43 e;

        public f(z43 z43Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z43Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    a53.b d = a53.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                a53.b d2 = a53.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                f53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements af3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z43 e;

        public g(z43 z43Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z43Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    a53.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                a53.b d = a53.d();
                d.m(false);
                d.n(false);
                d.o();
                f53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(z43 z43Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, callbackHandler, str};
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (k53Var == null) {
                    f53.o(10001, this.a, this.b);
                    a53.b d = a53.d();
                    d.n(false);
                    d.o();
                    a73.r(10001, null);
                    return;
                }
                int b = k53Var.b();
                hx1.o("MultiAuthorize", "requestAuthorize " + k53Var.a() + ",  code=" + b + ", data=" + k53Var.a);
                if (b != 0) {
                    a53.b d2 = a53.d();
                    d2.n(false);
                    d2.o();
                    f53.o(b, this.a, this.b);
                    return;
                }
                a53.b d3 = a53.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(z43 z43Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, jVar};
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

        @Override // com.repackage.tg1
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

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z43(e13 e13Var) {
        super(e13Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
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

    public final boolean A(List<h53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (h53 h53Var : list) {
                    if (h53Var != null && C(h53Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(h53 h53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var)) == null) ? TextUtils.equals(h53Var.b, "mapp_location") || TextUtils.equals(h53Var.b, "mapp_images") || TextUtils.equals(h53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(h53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(h53Var.b, "ppcert") || TextUtils.equals(h53Var.b, "mapp_i_face_verify") || TextUtils.equals(h53Var.b, "snsapi_userinfo") || TextUtils.equals(h53Var.b, "mapp_choose_address") || TextUtils.equals(h53Var.b, "mobile") || TextUtils.equals(h53Var.b, "mapp_choose_invoice") || TextUtils.equals(h53Var.b, "mapp_i_read_contacts") || TextUtils.equals(h53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(h53 h53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h53Var)) == null) ? TextUtils.equals(h53Var.b, "ppcert") || TextUtils.equals(h53Var.b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<h53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (h53 h53Var : list) {
                if (h53Var != null && !E(h53Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(h53 h53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, h53Var)) == null) ? TextUtils.equals(h53Var.b, "mapp_location") || TextUtils.equals(h53Var.b, "mapp_images") || TextUtils.equals(h53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(h53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(h53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<h53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (h53 h53Var : list) {
                if (h53Var != null && C(h53Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<h53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull h03 h03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, h03Var) == null) {
            if (D(list)) {
                a53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(h03Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<h53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                a53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<h53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                a53.b d2 = a53.d();
                d2.l(true);
                d2.i(true);
                hx1.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            a53.d().l(false);
            hx1.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<h53> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            m53 d2 = g03.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<h53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            oj2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull h03 h03Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, h03Var, activity, jVar) == null) {
            v(h03Var, activity, jVar);
        }
    }

    public final void M(af3<String> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, af3Var) == null) {
            oj2.Z().b(false, af3Var);
        }
    }

    public final void N(@NonNull Activity activity, h53 h53Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, h53Var, str) == null) {
            String Z = g03.K().q().Z();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(h53Var.s)) {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e5) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            } else if (equals) {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e5) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            } else {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e7) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            }
        }
    }

    public final void O(@NonNull Activity activity, h53 h53Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, h53Var, bool) == null) {
            String Z = g03.K().q().Z();
            boolean D = D(h53Var.s);
            boolean A = A(h53Var.s);
            if (!bool.booleanValue() && !D) {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e6) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            } else if (A) {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e7) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            } else {
                h53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e5) + Z + activity.getString(R.string.obfuscated_res_0x7f0f12e4);
            }
        }
    }

    public final void P(h53 h53Var, List<h53> list, boolean z, @NonNull Activity activity, @NonNull h03 h03Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{h53Var, list, Boolean.valueOf(z), activity, h03Var, callbackHandler, str}) == null) {
            f53.u(activity, h03Var, h53Var, new JSONObject(), new c(this, callbackHandler, str, z, h03Var, activity, list));
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (h03Var != null && (context instanceof Activity)) {
                JSONObject a2 = e23.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        a53.d().n(true);
                        h03Var.e0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, h03Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    a53.b d2 = a53.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                a53.b d3 = a53.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            a53.b d4 = a53.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull h03 h03Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, h03Var, activity, jVar) == null) {
            h03Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final List<h53> w(Map<String, h53> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = h53.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    h53 h53Var = map.get(c2);
                    if (map.containsKey(c2) && h53Var != null && B(h53Var)) {
                        if (h53Var.d) {
                            f53.o(10005, callbackHandler, str);
                            a53.b d2 = a53.d();
                            d2.n(false);
                            d2.o();
                            a73.r(10005, h53Var);
                            return null;
                        }
                        if (!arrayList.contains(h53Var) && !h53Var.a()) {
                            arrayList.add(h53Var);
                        }
                        if (!h53Var.a()) {
                            z = false;
                        }
                    } else {
                        f53.o(10005, callbackHandler, str);
                        a53.b d3 = a53.d();
                        d3.n(false);
                        d3.o();
                        a73.r(10005, h53Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                a53.b d4 = a53.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            hx1.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                a53.b d5 = a53.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull h03 h03Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, h03Var, callbackHandler, jSONArray, str) == null) {
            ds2.g().z(new b(this, callbackHandler, str, jSONArray, h03Var, activity));
        }
    }

    public final h53 y(Map<String, h53> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            h53 h53Var = map.get("scope_multi_authorize");
            if (h53Var == null) {
                f53.o(10001, callbackHandler, str);
                a73.r(10001, null);
                return null;
            } else if (h53Var.d) {
                f53.o(10005, callbackHandler, str);
                a73.r(10005, h53Var);
                return null;
            } else {
                return h53Var;
            }
        }
        return (h53) invokeLLL.objValue;
    }

    public final void z(af3<String> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, af3Var) == null) {
            oj2.Z().c(oj2.c(), af3Var);
        }
    }
}
