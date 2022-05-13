package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.z53;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kb3 extends xo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final nf3<ub3<tb3>> f;
    public static final nf3<ub3<List<tb3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ sb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kb3 d;

        /* renamed from: com.repackage.kb3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0445a implements nf3<ub3<tb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0445a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(ub3<tb3> ub3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) {
                    if (ub3Var.a != 0) {
                        ux1.i("WifiApi", "connectWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ub3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ub3Var.c.n());
                        } catch (JSONException e) {
                            ux1.i("WifiApi", "getConnectedWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new us1(ub3Var.a, ub3Var.b) : new us1(ub3Var.a, ub3Var.b, jSONObject));
                }
            }
        }

        public a(kb3 kb3Var, Activity activity, sb3 sb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, activity, sb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kb3Var;
            this.a = activity;
            this.b = sb3Var;
            this.c = str;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                rb3.s(this.a).a(this.b, new C0445a(this));
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ux1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new us1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements nf3<ub3<tb3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(ub3<tb3> ub3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) || ub3Var == null || ub3Var.a != 0 || ub3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", ub3Var.c);
            } catch (JSONException e) {
                ux1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            hm2.U().u(new va2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements nf3<ub3<List<tb3>>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(ub3<List<tb3>> ub3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) || ub3Var == null || ub3Var.a != 0 || ub3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (tb3 tb3Var : ub3Var.c) {
                jSONArray.put(tb3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                ux1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            hm2.U().u(new va2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements nf3<ub3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kb3 b;

        public d(kb3 kb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(ub3<Void> ub3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) {
                if (ub3Var.a != 0) {
                    ux1.i("WifiApi", "startWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b);
                }
                this.b.d(this.a, new us1(ub3Var.a, ub3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements nf3<ub3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kb3 b;

        public e(kb3 kb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(ub3<Void> ub3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) {
                if (ub3Var.a != 0) {
                    ux1.i("WifiApi", "stopWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b);
                }
                this.b.d(this.a, new us1(ub3Var.a, ub3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kb3 b;

        public f(kb3 kb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = x53Var.b();
                ux1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + s53.f(b));
                this.b.d(this.a, new us1(b, s53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kb3 c;

        /* loaded from: classes6.dex */
        public class a implements nf3<ub3<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(ub3<Void> ub3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) {
                    if (ub3Var.a != 0) {
                        ux1.i("WifiApi", "getWifiList: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new us1(ub3Var.a, ub3Var.b));
                }
            }
        }

        public g(kb3 kb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                rb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ux1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new us1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kb3 b;

        public h(kb3 kb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = x53Var.b();
                ux1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + s53.f(b));
                this.b.d(this.a, new us1(b, s53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kb3 c;

        /* loaded from: classes6.dex */
        public class a implements nf3<ub3<tb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(ub3<tb3> ub3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ub3Var) == null) {
                    if (ub3Var.a != 0) {
                        ux1.i("WifiApi", "getConnectedWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ub3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ub3Var.c.n());
                        } catch (JSONException e) {
                            ux1.i("WifiApi", "getConnectedWifi: " + ub3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ub3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new us1(ub3Var.a, ub3Var.b) : new us1(ub3Var.a, ub3Var.b, jSONObject));
                }
            }
        }

        public i(kb3 kb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                rb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ux1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new us1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sb3 b;
        public final /* synthetic */ kb3 c;

        public j(kb3 kb3Var, String str, sb3 sb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str, sb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kb3Var;
            this.a = str;
            this.b = sb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = x53Var.b();
                ux1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + s53.f(b));
                this.c.d(this.a, new us1(b, s53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755564683, "Lcom/repackage/kb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755564683, "Lcom/repackage/kb3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb3(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new us1(1001, "swan app is null");
            } else if (a0.x() == null) {
                ux1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new us1(1001, "swan activity is null");
            } else {
                Pair<us1, JSONObject> s = s(str);
                us1 us1Var = (us1) s.first;
                if (us1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ux1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new us1(201, "callback is null");
                    }
                    sb3 a2 = sb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        ux1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new us1(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        ux1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new us1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return us1.f();
                    }
                }
                return us1Var;
            }
        }
        return (us1) invokeL.objValue;
    }

    public us1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new us1(1001, "swan app is null");
            } else if (a0.x() == null) {
                ux1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new us1(1001, "swan activity is null");
            } else {
                Pair<us1, JSONObject> s = s(str);
                us1 us1Var = (us1) s.first;
                if (us1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ux1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new us1(201, "callback is null");
                    } else if (a0.m0()) {
                        ux1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new us1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return us1.f();
                    }
                }
                return us1Var;
            }
        }
        return (us1) invokeL.objValue;
    }

    public us1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new us1(1001, "swan app is null");
            } else if (a0.x() == null) {
                ux1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new us1(1001, "swan activity is null");
            } else {
                Pair<us1, JSONObject> s = s(str);
                us1 us1Var = (us1) s.first;
                if (us1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ux1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new us1(201, "callback is null");
                    } else if (a0.m0()) {
                        ux1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new us1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return us1.f();
                    }
                }
                return us1Var;
            }
        }
        return (us1) invokeL.objValue;
    }

    public final void D(String str, sb3 sb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, sb3Var) == null) {
            SwanAppActivity x = t03.J().x();
            wv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new a(this, x, sb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = t03.J().x();
            wv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = t03.J().x();
            wv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new g(this, x, str));
        }
    }

    public us1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new us1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                ux1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new us1(1001, "swan activity is null");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ux1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new us1(201, "callback is null");
                }
                rb3 s2 = rb3.s(x);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return us1.f();
                }
                ux1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new us1(12010, "unknown failed");
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    public us1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new us1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                ux1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new us1(1001, "swan activity is null");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ux1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new us1(201, "callback is null");
                }
                rb3 s2 = rb3.s(x);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return us1.f();
                }
                ux1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new us1(12010, "unknown failed");
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
