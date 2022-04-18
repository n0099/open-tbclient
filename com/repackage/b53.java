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
import com.repackage.c53;
import com.repackage.o53;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b53 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ j03 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ b53 f;

        public a(b53 b53Var, CallbackHandler callbackHandler, String str, Context context, j03 j03Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, callbackHandler, str, context, j03Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = b53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = j03Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                c53.b d = c53.d();
                d.n(false);
                d.o();
                h53.q(m53Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gs2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ j03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ b53 f;

        /* loaded from: classes5.dex */
        public class a implements cf3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.b53$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0383a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0383a(a aVar, Boolean bool) {
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
                        b53 b53Var = aVar.c.f;
                        j53 j53Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        b53Var.P(j53Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, j53 j53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, j53Var, list};
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
                this.a = j53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    de3.a0(new RunnableC0383a(this, bool));
                }
            }
        }

        /* renamed from: com.repackage.b53$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0384b implements cf3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j53 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.b53$b$b$a */
            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0384b a;

                public a(C0384b c0384b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0384b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0384b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0384b c0384b = this.a;
                        b bVar = c0384b.c;
                        bVar.f.P(c0384b.a, c0384b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0384b(b bVar, j53 j53Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, j53Var, list};
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
                this.a = j53Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    de3.a0(new a(this));
                }
            }
        }

        public b(b53 b53Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, j03 j03Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, callbackHandler, str, jSONArray, j03Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = b53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = j03Var;
            this.e = activity;
        }

        @Override // com.repackage.gs2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, j53> g = hs2.g(true);
                j53 y = this.f.y(g, this.a, this.b);
                if (y != null) {
                    List<j53> w = this.f.w(g, this.c, this.a, this.b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.d.M().e(this.e)) {
                        this.f.z(new C0384b(this, y, w));
                        return;
                    } else {
                        qj2.Z().a(this.e, new a(this, y, w));
                        return;
                    }
                }
                c53.b d = c53.d();
                d.n(false);
                d.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements e53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ j03 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ b53 g;

        public c(b53 b53Var, CallbackHandler callbackHandler, String str, boolean z, j03 j03Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, callbackHandler, str, Boolean.valueOf(z), j03Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = b53Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = j03Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.repackage.e53
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                jx1.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    c53.b d = c53.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    h53.o(10003, this.a, this.b);
                    return;
                }
                c53.b d2 = c53.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.M().e(this.e)) {
                    c53.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (z2) {
                    this.g.K(this.f, this.e, this.a, this.b);
                } else {
                    c53.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b53 e;

        public d(b53 b53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.repackage.b53.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                jx1.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    c53.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                c53.b d = c53.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                h53.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements cf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b53 e;

        public e(b53 b53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements cf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b53 e;

        public f(b53 b53Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b53Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    c53.b d = c53.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                c53.b d2 = c53.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                h53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements cf3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b53 e;

        public g(b53 b53Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b53Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    c53.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                c53.b d = c53.d();
                d.m(false);
                d.n(false);
                d.o();
                h53.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(b53 b53Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, callbackHandler, str};
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (m53Var == null) {
                    h53.o(10001, this.a, this.b);
                    c53.b d = c53.d();
                    d.n(false);
                    d.o();
                    c73.r(10001, null);
                    return;
                }
                int b = m53Var.b();
                jx1.o("MultiAuthorize", "requestAuthorize " + m53Var.a() + ",  code=" + b + ", data=" + m53Var.a);
                if (b != 0) {
                    c53.b d2 = c53.d();
                    d2.n(false);
                    d2.o();
                    h53.o(b, this.a, this.b);
                    return;
                }
                c53.b d3 = c53.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements vg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(b53 b53Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b53Var, jVar};
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

        @Override // com.repackage.vg1
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

    /* loaded from: classes5.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b53(g13 g13Var) {
        super(g13Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
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

    public final boolean A(List<j53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (j53 j53Var : list) {
                    if (j53Var != null && C(j53Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(j53 j53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j53Var)) == null) ? TextUtils.equals(j53Var.b, "mapp_location") || TextUtils.equals(j53Var.b, "mapp_images") || TextUtils.equals(j53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(j53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(j53Var.b, "ppcert") || TextUtils.equals(j53Var.b, "mapp_i_face_verify") || TextUtils.equals(j53Var.b, "snsapi_userinfo") || TextUtils.equals(j53Var.b, "mapp_choose_address") || TextUtils.equals(j53Var.b, "mobile") || TextUtils.equals(j53Var.b, "mapp_choose_invoice") || TextUtils.equals(j53Var.b, "mapp_i_read_contacts") || TextUtils.equals(j53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(j53 j53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j53Var)) == null) ? TextUtils.equals(j53Var.b, "ppcert") || TextUtils.equals(j53Var.b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<j53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (j53 j53Var : list) {
                if (j53Var != null && !E(j53Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(j53 j53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, j53Var)) == null) ? TextUtils.equals(j53Var.b, "mapp_location") || TextUtils.equals(j53Var.b, "mapp_images") || TextUtils.equals(j53Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(j53Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(j53Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<j53> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (j53 j53Var : list) {
                if (j53Var != null && C(j53Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<j53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull j03 j03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, j03Var) == null) {
            if (D(list)) {
                c53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(j03Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<j53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                c53.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<j53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                c53.b d2 = c53.d();
                d2.l(true);
                d2.i(true);
                jx1.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            c53.d().l(false);
            jx1.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<j53> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            o53 d2 = i03.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<j53> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            qj2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull j03 j03Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, j03Var, activity, jVar) == null) {
            v(j03Var, activity, jVar);
        }
    }

    public final void M(cf3<String> cf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cf3Var) == null) {
            qj2.Z().b(false, cf3Var);
        }
    }

    public final void N(@NonNull Activity activity, j53 j53Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, j53Var, str) == null) {
            String Y = i03.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(j53Var.s)) {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ac) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            } else if (equals) {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ac) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            } else {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ae) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            }
        }
    }

    public final void O(@NonNull Activity activity, j53 j53Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, j53Var, bool) == null) {
            String Y = i03.J().r().Y();
            boolean D = D(j53Var.s);
            boolean A = A(j53Var.s);
            if (!bool.booleanValue() && !D) {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ad) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            } else if (A) {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ae) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            } else {
                j53Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12ac) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12ab);
            }
        }
    }

    public final void P(j53 j53Var, List<j53> list, boolean z, @NonNull Activity activity, @NonNull j03 j03Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{j53Var, list, Boolean.valueOf(z), activity, j03Var, callbackHandler, str}) == null) {
            h53.u(activity, j03Var, j53Var, new JSONObject(), new c(this, callbackHandler, str, z, j03Var, activity, list));
        }
    }

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (j03Var != null && (context instanceof Activity)) {
                JSONObject a2 = g23.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        c53.d().n(true);
                        j03Var.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, j03Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    c53.b d2 = c53.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                c53.b d3 = c53.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            c53.b d4 = c53.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull j03 j03Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, j03Var, activity, jVar) == null) {
            j03Var.M().f(activity, null, new i(this, jVar));
        }
    }

    public final List<j53> w(Map<String, j53> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = j53.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    j53 j53Var = map.get(c2);
                    if (map.containsKey(c2) && j53Var != null && B(j53Var)) {
                        if (j53Var.d) {
                            h53.o(10005, callbackHandler, str);
                            c53.b d2 = c53.d();
                            d2.n(false);
                            d2.o();
                            c73.r(10005, j53Var);
                            return null;
                        }
                        if (!arrayList.contains(j53Var) && !j53Var.a()) {
                            arrayList.add(j53Var);
                        }
                        if (!j53Var.a()) {
                            z = false;
                        }
                    } else {
                        h53.o(10005, callbackHandler, str);
                        c53.b d3 = c53.d();
                        d3.n(false);
                        d3.o();
                        c73.r(10005, j53Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                c53.b d4 = c53.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            jx1.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                c53.b d5 = c53.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull j03 j03Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, j03Var, callbackHandler, jSONArray, str) == null) {
            fs2.g().z(new b(this, callbackHandler, str, jSONArray, j03Var, activity));
        }
    }

    public final j53 y(Map<String, j53> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            j53 j53Var = map.get("scope_multi_authorize");
            if (j53Var == null) {
                h53.o(10001, callbackHandler, str);
                c73.r(10001, null);
                return null;
            } else if (j53Var.d) {
                h53.o(10005, callbackHandler, str);
                c73.r(10005, j53Var);
                return null;
            } else {
                return j53Var;
            }
        }
        return (j53) invokeLLL.objValue;
    }

    public final void z(cf3<String> cf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cf3Var) == null) {
            qj2.Z().c(qj2.c(), cf3Var);
        }
    }
}
