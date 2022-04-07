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
import com.repackage.o53;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class za3 extends mo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final cf3<jb3<ib3>> f;
    public static final cf3<jb3<List<ib3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements mv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ za3 d;

        /* renamed from: com.repackage.za3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0566a implements cf3<jb3<ib3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0566a(a aVar) {
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
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(jb3<ib3> jb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) {
                    if (jb3Var.a != 0) {
                        jx1.i("WifiApi", "connectWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (jb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", jb3Var.c.n());
                        } catch (JSONException e) {
                            jx1.i("WifiApi", "getConnectedWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new js1(jb3Var.a, jb3Var.b) : new js1(jb3Var.a, jb3Var.b, jSONObject));
                }
            }
        }

        public a(za3 za3Var, Activity activity, hb3 hb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, activity, hb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = za3Var;
            this.a = activity;
            this.b = hb3Var;
            this.c = str;
        }

        @Override // com.repackage.mv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gb3.s(this.a).a(this.b, new C0566a(this));
            }
        }

        @Override // com.repackage.mv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                jx1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new js1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements cf3<jb3<ib3>> {
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(jb3<ib3> jb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) || jb3Var == null || jb3Var.a != 0 || jb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", jb3Var.c);
            } catch (JSONException e) {
                jx1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            wl2.U().u(new ka2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements cf3<jb3<List<ib3>>> {
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(jb3<List<ib3>> jb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) || jb3Var == null || jb3Var.a != 0 || jb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (ib3 ib3Var : jb3Var.c) {
                jSONArray.put(ib3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                jx1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            wl2.U().u(new ka2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements cf3<jb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ za3 b;

        public d(za3 za3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(jb3<Void> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) {
                if (jb3Var.a != 0) {
                    jx1.i("WifiApi", "startWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b);
                }
                this.b.d(this.a, new js1(jb3Var.a, jb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cf3<jb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ za3 b;

        public e(za3 za3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(jb3<Void> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) {
                if (jb3Var.a != 0) {
                    jx1.i("WifiApi", "stopWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b);
                }
                this.b.d(this.a, new js1(jb3Var.a, jb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ za3 b;

        public f(za3 za3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = m53Var.b();
                jx1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + h53.f(b));
                this.b.d(this.a, new js1(b, h53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements mv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ za3 c;

        /* loaded from: classes7.dex */
        public class a implements cf3<jb3<Void>> {
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
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(jb3<Void> jb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) {
                    if (jb3Var.a != 0) {
                        jx1.i("WifiApi", "getWifiList: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new js1(jb3Var.a, jb3Var.b));
                }
            }
        }

        public g(za3 za3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = za3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.mv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.mv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                jx1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new js1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ za3 b;

        public h(za3 za3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = m53Var.b();
                jx1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + h53.f(b));
                this.b.d(this.a, new js1(b, h53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements mv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ za3 c;

        /* loaded from: classes7.dex */
        public class a implements cf3<jb3<ib3>> {
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
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(jb3<ib3> jb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jb3Var) == null) {
                    if (jb3Var.a != 0) {
                        jx1.i("WifiApi", "getConnectedWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (jb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", jb3Var.c.n());
                        } catch (JSONException e) {
                            jx1.i("WifiApi", "getConnectedWifi: " + jb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + jb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new js1(jb3Var.a, jb3Var.b) : new js1(jb3Var.a, jb3Var.b, jSONObject));
                }
            }
        }

        public i(za3 za3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = za3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.mv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.mv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                jx1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new js1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ za3 c;

        public j(za3 za3Var, String str, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za3Var, str, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = za3Var;
            this.a = str;
            this.b = hb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = m53Var.b();
                jx1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + h53.f(b));
                this.c.d(this.a, new js1(b, h53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755118779, "Lcom/repackage/za3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755118779, "Lcom/repackage/za3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za3(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public js1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            j03 a0 = j03.a0();
            if (a0 == null) {
                jx1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new js1(1001, "swan app is null");
            } else if (a0.x() == null) {
                jx1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new js1(1001, "swan activity is null");
            } else {
                Pair<js1, JSONObject> s = s(str);
                js1 js1Var = (js1) s.first;
                if (js1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        jx1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new js1(201, "callback is null");
                    }
                    hb3 a2 = hb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        jx1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new js1(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        jx1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new js1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return js1.f();
                    }
                }
                return js1Var;
            }
        }
        return (js1) invokeL.objValue;
    }

    public js1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            j03 a0 = j03.a0();
            if (a0 == null) {
                jx1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new js1(1001, "swan app is null");
            } else if (a0.x() == null) {
                jx1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new js1(1001, "swan activity is null");
            } else {
                Pair<js1, JSONObject> s = s(str);
                js1 js1Var = (js1) s.first;
                if (js1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        jx1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new js1(201, "callback is null");
                    } else if (a0.m0()) {
                        jx1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new js1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return js1.f();
                    }
                }
                return js1Var;
            }
        }
        return (js1) invokeL.objValue;
    }

    public js1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            j03 a0 = j03.a0();
            if (a0 == null) {
                jx1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new js1(1001, "swan app is null");
            } else if (a0.x() == null) {
                jx1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new js1(1001, "swan activity is null");
            } else {
                Pair<js1, JSONObject> s = s(str);
                js1 js1Var = (js1) s.first;
                if (js1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        jx1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new js1(201, "callback is null");
                    } else if (a0.m0()) {
                        jx1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new js1(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return js1.f();
                    }
                }
                return js1Var;
            }
        }
        return (js1) invokeL.objValue;
    }

    public final void D(String str, hb3 hb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hb3Var) == null) {
            SwanAppActivity x = i03.J().x();
            lv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new a(this, x, hb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = i03.J().x();
            lv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = i03.J().x();
            lv2.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new g(this, x, str));
        }
    }

    public js1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            j03 a0 = j03.a0();
            if (a0 == null) {
                jx1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new js1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                jx1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new js1(1001, "swan activity is null");
            }
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    jx1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new js1(201, "callback is null");
                }
                gb3 s2 = gb3.s(x);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return js1.f();
                }
                jx1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new js1(12010, "unknown failed");
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }

    public js1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            j03 a0 = j03.a0();
            if (a0 == null) {
                jx1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new js1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                jx1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new js1(1001, "swan activity is null");
            }
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    jx1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new js1(201, "callback is null");
                }
                gb3 s2 = gb3.s(x);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return js1.f();
                }
                jx1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new js1(12010, "unknown failed");
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.mo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
