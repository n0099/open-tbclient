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
import com.repackage.n53;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ya3 extends lo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final bf3<ib3<hb3>> f;
    public static final bf3<ib3<List<hb3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements lv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ gb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ya3 d;

        /* renamed from: com.repackage.ya3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0628a implements bf3<ib3<hb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0628a(a aVar) {
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
            @Override // com.repackage.bf3
            /* renamed from: b */
            public void a(ib3<hb3> ib3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) {
                    if (ib3Var.a != 0) {
                        ix1.i("WifiApi", "connectWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ib3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ib3Var.c.n());
                        } catch (JSONException e) {
                            ix1.i("WifiApi", "getConnectedWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new is1(ib3Var.a, ib3Var.b) : new is1(ib3Var.a, ib3Var.b, jSONObject));
                }
            }
        }

        public a(ya3 ya3Var, Activity activity, gb3 gb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, activity, gb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ya3Var;
            this.a = activity;
            this.b = gb3Var;
            this.c = str;
        }

        @Override // com.repackage.lv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fb3.s(this.a).a(this.b, new C0628a(this));
            }
        }

        @Override // com.repackage.lv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ix1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new is1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements bf3<ib3<hb3>> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(ib3<hb3> ib3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) || ib3Var == null || ib3Var.a != 0 || ib3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", ib3Var.c);
            } catch (JSONException e) {
                ix1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            vl2.U().u(new ja2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements bf3<ib3<List<hb3>>> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(ib3<List<hb3>> ib3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) || ib3Var == null || ib3Var.a != 0 || ib3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (hb3 hb3Var : ib3Var.c) {
                jSONArray.put(hb3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                ix1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            vl2.U().u(new ja2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bf3<ib3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ya3 b;

        public d(ya3 ya3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(ib3<Void> ib3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) {
                if (ib3Var.a != 0) {
                    ix1.i("WifiApi", "startWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b);
                }
                this.b.d(this.a, new is1(ib3Var.a, ib3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements bf3<ib3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ya3 b;

        public e(ya3 ya3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(ib3<Void> ib3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) {
                if (ib3Var.a != 0) {
                    ix1.i("WifiApi", "stopWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b);
                }
                this.b.d(this.a, new is1(ib3Var.a, ib3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ya3 b;

        public f(ya3 ya3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = l53Var.b();
                ix1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + g53.f(b));
                this.b.d(this.a, new is1(b, g53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements lv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ya3 c;

        /* loaded from: classes7.dex */
        public class a implements bf3<ib3<Void>> {
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
            @Override // com.repackage.bf3
            /* renamed from: b */
            public void a(ib3<Void> ib3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) {
                    if (ib3Var.a != 0) {
                        ix1.i("WifiApi", "getWifiList: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new is1(ib3Var.a, ib3Var.b));
                }
            }
        }

        public g(ya3 ya3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ya3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.lv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.lv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ix1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new is1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ya3 b;

        public h(ya3 ya3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = l53Var.b();
                ix1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + g53.f(b));
                this.b.d(this.a, new is1(b, g53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements lv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ya3 c;

        /* loaded from: classes7.dex */
        public class a implements bf3<ib3<hb3>> {
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
            @Override // com.repackage.bf3
            /* renamed from: b */
            public void a(ib3<hb3> ib3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib3Var) == null) {
                    if (ib3Var.a != 0) {
                        ix1.i("WifiApi", "getConnectedWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ib3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ib3Var.c.n());
                        } catch (JSONException e) {
                            ix1.i("WifiApi", "getConnectedWifi: " + ib3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ib3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new is1(ib3Var.a, ib3Var.b) : new is1(ib3Var.a, ib3Var.b, jSONObject));
                }
            }
        }

        public i(ya3 ya3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ya3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.lv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.lv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ix1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new is1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gb3 b;
        public final /* synthetic */ ya3 c;

        public j(ya3 ya3Var, String str, gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya3Var, str, gb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ya3Var;
            this.a = str;
            this.b = gb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = l53Var.b();
                ix1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + g53.f(b));
                this.c.d(this.a, new is1(b, g53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755148570, "Lcom/repackage/ya3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755148570, "Lcom/repackage/ya3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya3(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public is1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new is1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ix1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new is1(1001, "swan activity is null");
            } else {
                Pair<is1, JSONObject> s = s(str);
                is1 is1Var = (is1) s.first;
                if (is1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ix1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new is1(201, "callback is null");
                    }
                    gb3 a2 = gb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        ix1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new is1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        ix1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new is1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return is1.f();
                    }
                }
                return is1Var;
            }
        }
        return (is1) invokeL.objValue;
    }

    public is1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new is1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ix1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new is1(1001, "swan activity is null");
            } else {
                Pair<is1, JSONObject> s = s(str);
                is1 is1Var = (is1) s.first;
                if (is1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ix1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new is1(201, "callback is null");
                    } else if (b0.n0()) {
                        ix1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new is1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return is1.f();
                    }
                }
                return is1Var;
            }
        }
        return (is1) invokeL.objValue;
    }

    public is1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new is1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ix1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new is1(1001, "swan activity is null");
            } else {
                Pair<is1, JSONObject> s = s(str);
                is1 is1Var = (is1) s.first;
                if (is1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ix1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new is1(201, "callback is null");
                    } else if (b0.n0()) {
                        ix1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new is1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return is1.f();
                    }
                }
                return is1Var;
            }
        }
        return (is1) invokeL.objValue;
    }

    public final void D(String str, gb3 gb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, gb3Var) == null) {
            SwanAppActivity w = h03.K().w();
            kv2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, gb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = h03.K().w();
            kv2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = h03.K().w();
            kv2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }

    public is1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new is1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                ix1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new is1(1001, "swan activity is null");
            }
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ix1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new is1(201, "callback is null");
                }
                fb3 s2 = fb3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return is1.f();
                }
                ix1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new is1(12010, "unknown failed");
            }
            return is1Var;
        }
        return (is1) invokeL.objValue;
    }

    public is1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new is1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                ix1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new is1(1001, "swan activity is null");
            }
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ix1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new is1(201, "callback is null");
                }
                fb3 s2 = fb3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return is1.f();
                }
                ix1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new is1(12010, "unknown failed");
            }
            return is1Var;
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.lo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
