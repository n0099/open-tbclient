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
import com.repackage.e63;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pb3 extends cp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final sf3<zb3<yb3>> f;
    public static final sf3<zb3<List<yb3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements cw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ xb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ pb3 d;

        /* renamed from: com.repackage.pb3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0554a implements sf3<zb3<yb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0554a(a aVar) {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(zb3<yb3> zb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) {
                    if (zb3Var.a != 0) {
                        zx1.i("WifiApi", "connectWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (zb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", zb3Var.c.n());
                        } catch (JSONException e) {
                            zx1.i("WifiApi", "getConnectedWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new zs1(zb3Var.a, zb3Var.b) : new zs1(zb3Var.a, zb3Var.b, jSONObject));
                }
            }
        }

        public a(pb3 pb3Var, Activity activity, xb3 xb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, activity, xb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pb3Var;
            this.a = activity;
            this.b = xb3Var;
            this.c = str;
        }

        @Override // com.repackage.cw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                wb3.s(this.a).a(this.b, new C0554a(this));
            }
        }

        @Override // com.repackage.cw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                zx1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new zs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements sf3<zb3<yb3>> {
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(zb3<yb3> zb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) || zb3Var == null || zb3Var.a != 0 || zb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", zb3Var.c);
            } catch (JSONException e) {
                zx1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            mm2.U().u(new ab2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements sf3<zb3<List<yb3>>> {
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(zb3<List<yb3>> zb3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) || zb3Var == null || zb3Var.a != 0 || zb3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (yb3 yb3Var : zb3Var.c) {
                jSONArray.put(yb3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                zx1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            mm2.U().u(new ab2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements sf3<zb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pb3 b;

        public d(pb3 pb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(zb3<Void> zb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) {
                if (zb3Var.a != 0) {
                    zx1.i("WifiApi", "startWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b);
                }
                this.b.d(this.a, new zs1(zb3Var.a, zb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements sf3<zb3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pb3 b;

        public e(pb3 pb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(zb3<Void> zb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) {
                if (zb3Var.a != 0) {
                    zx1.i("WifiApi", "stopWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b);
                }
                this.b.d(this.a, new zs1(zb3Var.a, zb3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pb3 b;

        public f(pb3 pb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (x53.h(c63Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = c63Var.b();
                zx1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + x53.f(b));
                this.b.d(this.a, new zs1(b, x53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements cw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pb3 c;

        /* loaded from: classes7.dex */
        public class a implements sf3<zb3<Void>> {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(zb3<Void> zb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) {
                    if (zb3Var.a != 0) {
                        zx1.i("WifiApi", "getWifiList: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new zs1(zb3Var.a, zb3Var.b));
                }
            }
        }

        public g(pb3 pb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.cw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                wb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.repackage.cw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                zx1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new zs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pb3 b;

        public h(pb3 pb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (x53.h(c63Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = c63Var.b();
                zx1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + x53.f(b));
                this.b.d(this.a, new zs1(b, x53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements cw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pb3 c;

        /* loaded from: classes7.dex */
        public class a implements sf3<zb3<yb3>> {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(zb3<yb3> zb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb3Var) == null) {
                    if (zb3Var.a != 0) {
                        zx1.i("WifiApi", "getConnectedWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (zb3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", zb3Var.c.n());
                        } catch (JSONException e) {
                            zx1.i("WifiApi", "getConnectedWifi: " + zb3Var.a + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.b + ZeusCrashHandler.NAME_SEPERATOR + zb3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new zs1(zb3Var.a, zb3Var.b) : new zs1(zb3Var.a, zb3Var.b, jSONObject));
                }
            }
        }

        public i(pb3 pb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.repackage.cw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                wb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.repackage.cw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                zx1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new zs1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xb3 b;
        public final /* synthetic */ pb3 c;

        public j(pb3 pb3Var, String str, xb3 xb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, str, xb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb3Var;
            this.a = str;
            this.b = xb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (x53.h(c63Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = c63Var.b();
                zx1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + x53.f(b));
                this.c.d(this.a, new zs1(b, x53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755415728, "Lcom/repackage/pb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755415728, "Lcom/repackage/pb3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb3(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public zs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new zs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                zx1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new zs1(1001, "swan activity is null");
            } else {
                Pair<zs1, JSONObject> s = s(str);
                zs1 zs1Var = (zs1) s.first;
                if (zs1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        zx1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new zs1(201, "callback is null");
                    }
                    xb3 a2 = xb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        zx1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new zs1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        zx1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new zs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return zs1.f();
                    }
                }
                return zs1Var;
            }
        }
        return (zs1) invokeL.objValue;
    }

    public zs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new zs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                zx1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new zs1(1001, "swan activity is null");
            } else {
                Pair<zs1, JSONObject> s = s(str);
                zs1 zs1Var = (zs1) s.first;
                if (zs1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        zx1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new zs1(201, "callback is null");
                    } else if (b0.n0()) {
                        zx1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new zs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return zs1.f();
                    }
                }
                return zs1Var;
            }
        }
        return (zs1) invokeL.objValue;
    }

    public zs1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new zs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                zx1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new zs1(1001, "swan activity is null");
            } else {
                Pair<zs1, JSONObject> s = s(str);
                zs1 zs1Var = (zs1) s.first;
                if (zs1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        zx1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new zs1(201, "callback is null");
                    } else if (b0.n0()) {
                        zx1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new zs1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return zs1.f();
                    }
                }
                return zs1Var;
            }
        }
        return (zs1) invokeL.objValue;
    }

    public final void D(String str, xb3 xb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, xb3Var) == null) {
            SwanAppActivity w = y03.K().w();
            bw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, xb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = y03.K().w();
            bw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = y03.K().w();
            bw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }

    public zs1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new zs1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                zx1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new zs1(1001, "swan activity is null");
            }
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    zx1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new zs1(201, "callback is null");
                }
                wb3 s2 = wb3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return zs1.f();
                }
                zx1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new zs1(12010, "unknown failed");
            }
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }

    public zs1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new zs1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                zx1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new zs1(1001, "swan activity is null");
            }
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    zx1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new zs1(201, "callback is null");
                }
                wb3 s2 = wb3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return zs1.f();
                }
                zx1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new zs1(12010, "unknown failed");
            }
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.cp1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
