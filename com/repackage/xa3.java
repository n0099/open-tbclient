package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.PermissionChecker;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.m53;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xa3 extends ko1 {
    public static /* synthetic */ Interceptable $ic;
    public static final af3<hb3<gb3>> f;
    public static final af3<hb3<List<gb3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ fb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xa3 d;

        /* renamed from: com.repackage.xa3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0770a implements af3<hb3<gb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0770a(a aVar) {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(hb3<gb3> hb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) {
                    if (hb3Var.a != 0) {
                        hx1.i("WifiApi", "connectWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hb3Var.c.n());
                        } catch (JSONException e) {
                            hx1.i("WifiApi", "getConnectedWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new hs1(hb3Var.a, hb3Var.b) : new hs1(hb3Var.a, hb3Var.b, jSONObject));
                }
            }
        }

        public a(xa3 xa3Var, Activity activity, fb3 fb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, activity, fb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xa3Var;
            this.a = activity;
            this.b = fb3Var;
            this.c = str;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eb3.s(this.a).a(this.b, new C0770a(this));
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hx1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new hs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements af3<hb3<gb3>> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(hb3<gb3> hb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) || hb3Var == null || hb3Var.a != 0 || hb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", hb3Var.c);
            } catch (JSONException e) {
                hx1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            ul2.U().u(new ia2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements af3<hb3<List<gb3>>> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(hb3<List<gb3>> hb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) || hb3Var == null || hb3Var.a != 0 || hb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (gb3 gb3Var : hb3Var.c) {
                jSONArray.put(gb3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                hx1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            ul2.U().u(new ia2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements af3<hb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xa3 b;

        public d(xa3 xa3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(hb3<Void> hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) {
                if (hb3Var.a != 0) {
                    hx1.i("WifiApi", "startWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b);
                }
                this.b.d(this.a, new hs1(hb3Var.a, hb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements af3<hb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xa3 b;

        public e(xa3 xa3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(hb3<Void> hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) {
                if (hb3Var.a != 0) {
                    hx1.i("WifiApi", "stopWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b);
                }
                this.b.d(this.a, new hs1(hb3Var.a, hb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xa3 b;

        public f(xa3 xa3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = k53Var.b();
                hx1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + f53.f(b));
                this.b.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xa3 c;

        /* loaded from: classes7.dex */
        public class a implements af3<hb3<Void>> {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(hb3<Void> hb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) {
                    if (hb3Var.a != 0) {
                        hx1.i("WifiApi", "getWifiList: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new hs1(hb3Var.a, hb3Var.b));
                }
            }
        }

        public g(xa3 xa3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hx1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new hs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xa3 b;

        public h(xa3 xa3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = k53Var.b();
                hx1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + f53.f(b));
                this.b.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xa3 c;

        /* loaded from: classes7.dex */
        public class a implements af3<hb3<gb3>> {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(hb3<gb3> hb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var) == null) {
                    if (hb3Var.a != 0) {
                        hx1.i("WifiApi", "getConnectedWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hb3Var.c.n());
                        } catch (JSONException e) {
                            hx1.i("WifiApi", "getConnectedWifi: " + hb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new hs1(hb3Var.a, hb3Var.b) : new hs1(hb3Var.a, hb3Var.b, jSONObject));
                }
            }
        }

        public i(xa3 xa3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hx1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new hs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fb3 b;
        public final /* synthetic */ xa3 c;

        public j(xa3 xa3Var, String str, fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa3Var, str, fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa3Var;
            this.a = str;
            this.b = fb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = k53Var.b();
                hx1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + f53.f(b));
                this.c.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755178361, "Lcom/repackage/xa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755178361, "Lcom/repackage/xa3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xa3(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new hs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                hx1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new hs1(1001, "swan activity is null");
            } else {
                Pair<hs1, JSONObject> s = s(str);
                hs1 hs1Var = (hs1) s.first;
                if (hs1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hx1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new hs1(201, "callback is null");
                    }
                    fb3 a2 = fb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        hx1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new hs1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        hx1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new hs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return hs1.f();
                    }
                }
                return hs1Var;
            }
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new hs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                hx1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new hs1(1001, "swan activity is null");
            } else {
                Pair<hs1, JSONObject> s = s(str);
                hs1 hs1Var = (hs1) s.first;
                if (hs1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hx1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new hs1(201, "callback is null");
                    } else if (b0.n0()) {
                        hx1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new hs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return hs1.f();
                    }
                }
                return hs1Var;
            }
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new hs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                hx1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new hs1(1001, "swan activity is null");
            } else {
                Pair<hs1, JSONObject> s = s(str);
                hs1 hs1Var = (hs1) s.first;
                if (hs1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hx1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new hs1(201, "callback is null");
                    } else if (b0.n0()) {
                        hx1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new hs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return hs1.f();
                    }
                }
                return hs1Var;
            }
        }
        return (hs1) invokeL.objValue;
    }

    public final void D(String str, fb3 fb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fb3Var) == null) {
            SwanAppActivity w = g03.K().w();
            jv2.g(w, new String[]{PermissionChecker.ACCESS_FINE_LOCATION, PermissionChecker.ACCESS_COARSE_LOCATION}, 0, new a(this, w, fb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = g03.K().w();
            jv2.g(w, new String[]{PermissionChecker.ACCESS_FINE_LOCATION, PermissionChecker.ACCESS_COARSE_LOCATION}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = g03.K().w();
            jv2.g(w, new String[]{PermissionChecker.ACCESS_FINE_LOCATION, PermissionChecker.ACCESS_COARSE_LOCATION}, 0, new g(this, w, str));
        }
    }

    public hs1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new hs1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                hx1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new hs1(1001, "swan activity is null");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hx1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new hs1(201, "callback is null");
                }
                eb3 s2 = eb3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return hs1.f();
                }
                hx1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new hs1(12010, "unknown failed");
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new hs1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                hx1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new hs1(1001, "swan activity is null");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hx1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new hs1(201, "callback is null");
                }
                eb3 s2 = eb3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return hs1.f();
                }
                hx1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new hs1(12010, "unknown failed");
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
