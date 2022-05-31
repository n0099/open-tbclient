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
import com.repackage.m43;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x93 extends kn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ae3<ha3<ga3>> f;
    public static final ae3<ha3<List<ga3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ fa3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ x93 d;

        /* renamed from: com.repackage.x93$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0558a implements ae3<ha3<ga3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0558a(a aVar) {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(ha3<ga3> ha3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) {
                    if (ha3Var.a != 0) {
                        hw1.i("WifiApi", "connectWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ha3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ha3Var.c.n());
                        } catch (JSONException e) {
                            hw1.i("WifiApi", "getConnectedWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new hr1(ha3Var.a, ha3Var.b) : new hr1(ha3Var.a, ha3Var.b, jSONObject));
                }
            }
        }

        public a(x93 x93Var, Activity activity, fa3 fa3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, activity, fa3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x93Var;
            this.a = activity;
            this.b = fa3Var;
            this.c = str;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ea3.s(this.a).a(this.b, new C0558a(this));
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hw1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new hr1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ae3<ha3<ga3>> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(ha3<ga3> ha3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) || ha3Var == null || ha3Var.a != 0 || ha3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", ha3Var.c);
            } catch (JSONException e) {
                hw1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            uk2.U().u(new i92("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements ae3<ha3<List<ga3>>> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(ha3<List<ga3>> ha3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) || ha3Var == null || ha3Var.a != 0 || ha3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (ga3 ga3Var : ha3Var.c) {
                jSONArray.put(ga3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                hw1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            uk2.U().u(new i92("getWifiList", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ae3<ha3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x93 b;

        public d(x93 x93Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x93Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(ha3<Void> ha3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) {
                if (ha3Var.a != 0) {
                    hw1.i("WifiApi", "startWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b);
                }
                this.b.d(this.a, new hr1(ha3Var.a, ha3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ae3<ha3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x93 b;

        public e(x93 x93Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x93Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(ha3<Void> ha3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) {
                if (ha3Var.a != 0) {
                    hw1.i("WifiApi", "stopWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b);
                }
                this.b.d(this.a, new hr1(ha3Var.a, ha3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x93 b;

        public f(x93 x93Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x93Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = k43Var.b();
                hw1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + f43.f(b));
                this.b.d(this.a, new hr1(b, f43.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ x93 c;

        /* loaded from: classes7.dex */
        public class a implements ae3<ha3<Void>> {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(ha3<Void> ha3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) {
                    if (ha3Var.a != 0) {
                        hw1.i("WifiApi", "getWifiList: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new hr1(ha3Var.a, ha3Var.b));
                }
            }
        }

        public g(x93 x93Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x93Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ea3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hw1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new hr1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x93 b;

        public h(x93 x93Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x93Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = k43Var.b();
                hw1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + f43.f(b));
                this.b.d(this.a, new hr1(b, f43.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ x93 c;

        /* loaded from: classes7.dex */
        public class a implements ae3<ha3<ga3>> {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(ha3<ga3> ha3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ha3Var) == null) {
                    if (ha3Var.a != 0) {
                        hw1.i("WifiApi", "getConnectedWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ha3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ha3Var.c.n());
                        } catch (JSONException e) {
                            hw1.i("WifiApi", "getConnectedWifi: " + ha3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ha3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new hr1(ha3Var.a, ha3Var.b) : new hr1(ha3Var.a, ha3Var.b, jSONObject));
                }
            }
        }

        public i(x93 x93Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x93Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ea3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                hw1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new hr1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fa3 b;
        public final /* synthetic */ x93 c;

        public j(x93 x93Var, String str, fa3 fa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str, fa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x93Var;
            this.a = str;
            this.b = fa3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = k43Var.b();
                hw1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + f43.f(b));
                this.c.d(this.a, new hr1(b, f43.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755216801, "Lcom/repackage/x93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755216801, "Lcom/repackage/x93;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x93(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public hr1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new hr1(1001, "swan app is null");
            } else if (a0.x() == null) {
                hw1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new hr1(1001, "swan activity is null");
            } else {
                Pair<hr1, JSONObject> s = s(str);
                hr1 hr1Var = (hr1) s.first;
                if (hr1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hw1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new hr1(201, "callback is null");
                    }
                    fa3 a2 = fa3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        hw1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new hr1(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        hw1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new hr1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return hr1.f();
                    }
                }
                return hr1Var;
            }
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new hr1(1001, "swan app is null");
            } else if (a0.x() == null) {
                hw1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new hr1(1001, "swan activity is null");
            } else {
                Pair<hr1, JSONObject> s = s(str);
                hr1 hr1Var = (hr1) s.first;
                if (hr1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hw1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new hr1(201, "callback is null");
                    } else if (a0.m0()) {
                        hw1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new hr1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return hr1.f();
                    }
                }
                return hr1Var;
            }
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new hr1(1001, "swan app is null");
            } else if (a0.x() == null) {
                hw1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new hr1(1001, "swan activity is null");
            } else {
                Pair<hr1, JSONObject> s = s(str);
                hr1 hr1Var = (hr1) s.first;
                if (hr1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        hw1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new hr1(201, "callback is null");
                    } else if (a0.m0()) {
                        hw1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new hr1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return hr1.f();
                    }
                }
                return hr1Var;
            }
        }
        return (hr1) invokeL.objValue;
    }

    public final void D(String str, fa3 fa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fa3Var) == null) {
            SwanAppActivity x = gz2.J().x();
            ju2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new a(this, x, fa3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = gz2.J().x();
            ju2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = gz2.J().x();
            ju2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new g(this, x, str));
        }
    }

    public hr1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new hr1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                hw1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new hr1(1001, "swan activity is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hw1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new hr1(201, "callback is null");
                }
                ea3 s2 = ea3.s(x);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return hr1.f();
                }
                hw1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new hr1(12010, "unknown failed");
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new hr1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                hw1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new hr1(1001, "swan activity is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hw1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new hr1(201, "callback is null");
                }
                ea3 s2 = ea3.s(x);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return hr1.f();
                }
                hw1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new hr1(12010, "unknown failed");
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
