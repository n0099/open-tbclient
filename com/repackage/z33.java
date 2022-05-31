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
import com.repackage.a43;
import com.repackage.m43;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z33 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ hz2 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ z33 f;

        public a(z33 z33Var, CallbackHandler callbackHandler, String str, Context context, hz2 hz2Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, callbackHandler, str, context, hz2Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z33Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = hz2Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                a43.b d = a43.d();
                d.n(false);
                d.o();
                f43.q(k43Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements er2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ hz2 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ z33 f;

        /* loaded from: classes7.dex */
        public class a implements ae3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h43 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.z33$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0575a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0575a(a aVar, Boolean bool) {
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
                        z33 z33Var = aVar.c.f;
                        h43 h43Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        z33Var.P(h43Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, h43 h43Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h43Var, list};
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
                this.a = h43Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    bd3.a0(new RunnableC0575a(this, bool));
                }
            }
        }

        /* renamed from: com.repackage.z33$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0576b implements ae3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h43 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.z33$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0576b a;

                public a(C0576b c0576b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0576b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0576b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0576b c0576b = this.a;
                        b bVar = c0576b.c;
                        bVar.f.P(c0576b.a, c0576b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0576b(b bVar, h43 h43Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h43Var, list};
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
                this.a = h43Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    bd3.a0(new a(this));
                }
            }
        }

        public b(z33 z33Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, hz2 hz2Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, callbackHandler, str, jSONArray, hz2Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z33Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = hz2Var;
            this.e = activity;
        }

        @Override // com.repackage.er2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, h43> g = fr2.g(true);
                h43 y = this.f.y(g, this.a, this.b);
                if (y != null) {
                    List<h43> w = this.f.w(g, this.c, this.a, this.b);
                    if (w == null) {
                        return;
                    }
                    y.i(w);
                    if (this.d.M().e(this.e)) {
                        this.f.z(new C0576b(this, y, w));
                        return;
                    } else {
                        oi2.Z().a(this.e, new a(this, y, w));
                        return;
                    }
                }
                a43.b d = a43.d();
                d.n(false);
                d.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ hz2 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ z33 g;

        public c(z33 z33Var, CallbackHandler callbackHandler, String str, boolean z, hz2 hz2Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, callbackHandler, str, Boolean.valueOf(z), hz2Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z33Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = hz2Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.repackage.c43
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                hw1.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    a43.b d = a43.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    f43.o(10003, this.a, this.b);
                    return;
                }
                a43.b d2 = a43.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.M().e(this.e)) {
                    a43.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (z2) {
                    this.g.K(this.f, this.e, this.a, this.b);
                } else {
                    a43.d().m(false);
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
        public final /* synthetic */ z33 e;

        public d(z33 z33Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z33Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.repackage.z33.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                hw1.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    a43.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                a43.b d = a43.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                f43.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ae3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z33 e;

        public e(z33 z33Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z33Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ae3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z33 e;

        public f(z33 z33Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z33Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    a43.b d = a43.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                a43.b d2 = a43.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                f43.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ae3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ z33 e;

        public g(z33 z33Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z33Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    a43.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                a43.b d = a43.d();
                d.m(false);
                d.n(false);
                d.o();
                f43.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(z33 z33Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, callbackHandler, str};
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (k43Var == null) {
                    f43.o(10001, this.a, this.b);
                    a43.b d = a43.d();
                    d.n(false);
                    d.o();
                    a63.r(10001, null);
                    return;
                }
                int b = k43Var.b();
                hw1.o("MultiAuthorize", "requestAuthorize " + k43Var.a() + ",  code=" + b + ", data=" + k43Var.a);
                if (b != 0) {
                    a43.b d2 = a43.d();
                    d2.n(false);
                    d2.o();
                    f43.o(b, this.a, this.b);
                    return;
                }
                a43.b d3 = a43.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements tf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(z33 z33Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, jVar};
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

        @Override // com.repackage.tf1
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
    public z33(e03 e03Var) {
        super(e03Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    public final boolean A(List<h43> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (h43 h43Var : list) {
                    if (h43Var != null && C(h43Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(h43 h43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h43Var)) == null) ? TextUtils.equals(h43Var.b, "mapp_location") || TextUtils.equals(h43Var.b, "mapp_images") || TextUtils.equals(h43Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(h43Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(h43Var.b, "ppcert") || TextUtils.equals(h43Var.b, "mapp_i_face_verify") || TextUtils.equals(h43Var.b, "snsapi_userinfo") || TextUtils.equals(h43Var.b, "mapp_choose_address") || TextUtils.equals(h43Var.b, "mobile") || TextUtils.equals(h43Var.b, "mapp_choose_invoice") || TextUtils.equals(h43Var.b, "mapp_i_read_contacts") || TextUtils.equals(h43Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean C(h43 h43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h43Var)) == null) ? TextUtils.equals(h43Var.b, "ppcert") || TextUtils.equals(h43Var.b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<h43> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (h43 h43Var : list) {
                if (h43Var != null && !E(h43Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(h43 h43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, h43Var)) == null) ? TextUtils.equals(h43Var.b, "mapp_location") || TextUtils.equals(h43Var.b, "mapp_images") || TextUtils.equals(h43Var.b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(h43Var.b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(h43Var.b, "scope_calendar") : invokeL.booleanValue;
    }

    public final boolean F(List<h43> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (h43 h43Var : list) {
                if (h43Var != null && C(h43Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<h43> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull hz2 hz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, hz2Var) == null) {
            if (D(list)) {
                a43.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(hz2Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    public final void H(List<h43> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                a43.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<h43> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                a43.b d2 = a43.d();
                d2.l(true);
                d2.i(true);
                hw1.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            a43.d().l(false);
            hw1.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<h43> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            m43 d2 = gz2.J().y().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void K(List<h43> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            oi2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull hz2 hz2Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, hz2Var, activity, jVar) == null) {
            v(hz2Var, activity, jVar);
        }
    }

    public final void M(ae3<String> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ae3Var) == null) {
            oi2.Z().b(false, ae3Var);
        }
    }

    public final void N(@NonNull Activity activity, h43 h43Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, h43Var, str) == null) {
            String Y = gz2.J().r().Y();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(h43Var.s)) {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12df) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            } else if (equals) {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12df) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            } else {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e1) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            }
        }
    }

    public final void O(@NonNull Activity activity, h43 h43Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, h43Var, bool) == null) {
            String Y = gz2.J().r().Y();
            boolean D = D(h43Var.s);
            boolean A = A(h43Var.s);
            if (!bool.booleanValue() && !D) {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e0) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            } else if (A) {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12e1) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            } else {
                h43Var.r = activity.getString(R.string.obfuscated_res_0x7f0f12df) + Y + activity.getString(R.string.obfuscated_res_0x7f0f12de);
            }
        }
    }

    public final void P(h43 h43Var, List<h43> list, boolean z, @NonNull Activity activity, @NonNull hz2 hz2Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{h43Var, list, Boolean.valueOf(z), activity, hz2Var, callbackHandler, str}) == null) {
            f43.u(activity, hz2Var, h43Var, new JSONObject(), new c(this, callbackHandler, str, z, hz2Var, activity, list));
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (hz2Var != null && (context instanceof Activity)) {
                JSONObject a2 = e13.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        a43.d().n(true);
                        hz2Var.d0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, hz2Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    a43.b d2 = a43.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                a43.b d3 = a43.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            a43.b d4 = a43.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull hz2 hz2Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, hz2Var, activity, jVar) == null) {
            hz2Var.M().f(activity, null, new i(this, jVar));
        }
    }

    public final List<h43> w(Map<String, h43> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = h43.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    h43 h43Var = map.get(c2);
                    if (map.containsKey(c2) && h43Var != null && B(h43Var)) {
                        if (h43Var.d) {
                            f43.o(10005, callbackHandler, str);
                            a43.b d2 = a43.d();
                            d2.n(false);
                            d2.o();
                            a63.r(10005, h43Var);
                            return null;
                        }
                        if (!arrayList.contains(h43Var) && !h43Var.a()) {
                            arrayList.add(h43Var);
                        }
                        if (!h43Var.a()) {
                            z = false;
                        }
                    } else {
                        f43.o(10005, callbackHandler, str);
                        a43.b d3 = a43.d();
                        d3.n(false);
                        d3.o();
                        a63.r(10005, h43Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                a43.b d4 = a43.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            hw1.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                a43.b d5 = a43.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull hz2 hz2Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, hz2Var, callbackHandler, jSONArray, str) == null) {
            dr2.g().z(new b(this, callbackHandler, str, jSONArray, hz2Var, activity));
        }
    }

    public final h43 y(Map<String, h43> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            h43 h43Var = map.get("scope_multi_authorize");
            if (h43Var == null) {
                f43.o(10001, callbackHandler, str);
                a63.r(10001, null);
                return null;
            } else if (h43Var.d) {
                f43.o(10005, callbackHandler, str);
                a63.r(10005, h43Var);
                return null;
            } else {
                return h43Var;
            }
        }
        return (h43) invokeLLL.objValue;
    }

    public final void z(ae3<String> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, ae3Var) == null) {
            oi2.Z().c(oi2.c(), ae3Var);
        }
    }
}
