package d.l.a.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.a.a.c.s;
import d.l.a.a.a.f.c;
import d.l.a.b.a.a.a;
import d.l.a.b.a.a.b;
import d.l.a.d.b.c;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.b.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements d.l.a.b.a.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f74346b = "c";

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f74347c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.l.a.d.h f74348a;

    /* loaded from: classes10.dex */
    public class a implements f.d.b<Dialog> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f74349a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f74350b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f74351c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f74352d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74354f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.e f74355g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f74356h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f74357i;
        public final /* synthetic */ c j;

        public a(c cVar, Context context, String str, boolean z, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar2, d.l.a.a.a.d.b bVar, d.l.a.a.a.d.e eVar, int i2, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, str, Boolean.valueOf(z), dVar, cVar2, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f74349a = context;
            this.f74350b = str;
            this.f74351c = z;
            this.f74352d = dVar;
            this.f74353e = cVar2;
            this.f74354f = bVar;
            this.f74355g = eVar;
            this.f74356h = i2;
            this.f74357i = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.l.a.d.f.d.b
        /* renamed from: a */
        public Dialog b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j.k(this.f74349a, this.f74350b, this.f74351c, this.f74352d, this.f74353e, this.f74354f, this.f74355g, this.f74356h, this.f74357i) : (Dialog) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.InterfaceC2044c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f74358a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74359b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74360c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f74361d;

        public b(c cVar, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar2, d.l.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, cVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74361d = cVar;
            this.f74358a = dVar;
            this.f74359b = cVar2;
            this.f74360c = bVar;
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void a(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                e.c.a().l("landing_download_dialog_cancel", this.f74358a, this.f74359b, this.f74360c);
                dialogInterface.dismiss();
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void b(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                this.f74361d.f74348a.h(this.f74358a.a(), this.f74358a.d(), 2, this.f74359b, this.f74360c);
                e.c.a().l("landing_download_dialog_confirm", this.f74358a, this.f74359b, this.f74360c);
                dialogInterface.dismiss();
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void c(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                e.c.a().l("landing_download_dialog_cancel", this.f74358a, this.f74359b, this.f74360c);
            }
        }
    }

    /* renamed from: d.l.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2056c implements f.d.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f74362a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Uri f74363b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f74364c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74365d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f74367f;

        public C2056c(c cVar, Context context, Uri uri, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar2, d.l.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, uri, dVar, cVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74367f = cVar;
            this.f74362a = context;
            this.f74363b = uri;
            this.f74364c = dVar;
            this.f74365d = cVar2;
            this.f74366e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.l.a.d.f.d.b
        /* renamed from: a */
        public Boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(this.f74367f.n(this.f74362a, this.f74363b, this.f74364c, this.f74365d, this.f74366e)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f74368a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.a f74369b;

            public a(JSONObject jSONObject, d.l.a.b.a.c.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jSONObject, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74368a = jSONObject;
                this.f74369b = aVar;
            }

            @Override // d.l.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    e.c.a().w(z ? "deeplink_success" : "deeplink_failed", this.f74368a, this.f74369b);
                    if (z) {
                        d.l.a.d.b.l.G().a(d.l.a.d.b.l.a(), this.f74369b.u(), this.f74369b.w(), this.f74369b.v(), this.f74369b.e(), 0);
                    }
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f74370a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.a f74371b;

            public b(JSONObject jSONObject, d.l.a.b.a.c.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jSONObject, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74370a = jSONObject;
                this.f74371b = aVar;
            }

            @Override // d.l.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    e.c.a().w(z ? "deeplink_success" : "deeplink_failed", this.f74370a, this.f74371b);
                    if (z) {
                        d.l.a.d.b.l.G().a(d.l.a.d.b.l.a(), this.f74371b.u(), this.f74371b.w(), this.f74371b.v(), this.f74371b.e(), 0);
                    }
                }
            }
        }

        /* renamed from: d.l.a.d.c$d$c  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2057c implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f74372a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.f f74373b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ JSONObject f74374c;

            public C2057c(String str, c.f fVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, fVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74372a = str;
                this.f74373b = fVar;
                this.f74374c = jSONObject;
            }

            @Override // d.l.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (!z && !"open_market".equals(this.f74372a)) {
                        Context a2 = d.l.a.d.b.l.a();
                        d.b(h.o.a(a2, Uri.parse("market://details?id=" + this.f74373b.e())), this.f74373b, false);
                    }
                    e.c.a().r(z ? "market_delay_success" : "market_delay_failed", this.f74374c, this.f74373b);
                    if (z) {
                        s G = d.l.a.d.b.l.G();
                        Context a3 = d.l.a.d.b.l.a();
                        c.f fVar = this.f74373b;
                        d.l.a.a.a.d.d dVar = fVar.f74225b;
                        G.a(a3, dVar, fVar.f74227d, fVar.f74226c, dVar.v(), 2);
                    }
                }
            }
        }

        public static void a(@NonNull d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
                String f2 = bVar.f();
                JSONObject jSONObject = new JSONObject();
                h.l.a(jSONObject, bVar);
                h.r.q(jSONObject, "applink_source", "notify_click_by_sdk");
                e.c.a().w("applink_click", jSONObject, bVar);
                c.h f3 = h.o.f(f2, bVar);
                if (f3.a() == 2) {
                    if (!TextUtils.isEmpty(f2)) {
                        k("notify_by_url", f3, jSONObject, bVar);
                    }
                    f3 = h.o.d(d.l.a.d.b.l.a(), bVar.e(), bVar);
                }
                int a2 = f3.a();
                if (a2 == 1) {
                    l("notify_by_url", jSONObject, bVar);
                } else if (a2 == 3) {
                    d("notify_by_package", jSONObject, bVar);
                } else if (a2 != 4) {
                    f.e.b().g("AppLinkClickNotification default");
                } else {
                    c("notify_by_package", f3, jSONObject, bVar);
                }
            }
        }

        public static void b(c.h hVar, c.f fVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(65537, null, hVar, fVar, z) == null) {
                String m = h.r.m(hVar.c(), "open_market");
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "ttdownloader_type", UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
                int a2 = hVar.a();
                if (a2 == 5) {
                    e(m, jSONObject, fVar, z);
                } else if (a2 != 6) {
                } else {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                    h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                }
            }
        }

        public static void c(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull d.l.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65538, null, str, hVar, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_app_open_fail", jSONObject, aVar);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void d(String str, @NonNull JSONObject jSONObject, @NonNull d.l.a.b.a.c.a aVar) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, str, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_app_open", jSONObject, aVar);
                switch (str.hashCode()) {
                    case -1282070764:
                        if (str.equals("notify_by_package")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -441514770:
                        if (str.equals("auto_by_package")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -185950114:
                        if (str.equals("by_package")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 368401333:
                        if (str.equals("dialog_by_package")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if ((d.l.a.d.b.l.v().optInt("check_applink_mode") & 1) != 0) {
                        h.r.q(jSONObject, "check_applink_result_by_sdk", 1);
                        h.d().e(new a(jSONObject, aVar));
                        return;
                    }
                    d.l.a.d.b.l.o().b(d.l.a.d.b.l.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                }
            }
        }

        public static void e(String str, @Nullable JSONObject jSONObject, c.f fVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{str, jSONObject, fVar, Boolean.valueOf(z)}) == null) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception e2) {
                        f.e.b().a(e2, "onMarketSuccess");
                        return;
                    }
                }
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                if (z) {
                    e.c.a().w("market_open_success", jSONObject, fVar);
                }
                if ((d.l.a.d.b.l.v().optInt("check_applink_mode") & 4) != 0) {
                    h.d().g(new C2057c(str, fVar, jSONObject));
                } else {
                    d.l.a.d.b.l.o().b(d.l.a.d.b.l.a(), fVar.f74225b, fVar.f74227d, fVar.f74226c, fVar.f74225b.v(), str);
                }
                d.l.a.b.a.c.b bVar = new d.l.a.b.a.c.b(fVar.f74225b, fVar.f74226c, fVar.f74227d);
                bVar.x0(2);
                bVar.C0(System.currentTimeMillis());
                bVar.J0(4);
                bVar.N0(2);
                c.g.e().j(bVar);
            }
        }

        public static boolean f(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) ? c.g.e().u(j) == null : invokeJ.booleanValue;
        }

        public static boolean g(@NonNull c.f fVar) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
                d.l.a.a.a.f.b x = fVar.f74225b.x();
                String d2 = x == null ? null : x.d();
                JSONObject jSONObject = new JSONObject();
                h.l.a(jSONObject, fVar);
                h.r.q(jSONObject, "applink_source", "click_by_sdk");
                e.c.a().w("applink_click", jSONObject, fVar);
                c.h f2 = h.o.f(d2, fVar);
                if (f2.a() == 2) {
                    if (!TextUtils.isEmpty(d2)) {
                        k("by_url", f2, jSONObject, fVar);
                    }
                    f2 = h.o.d(d.l.a.d.b.l.a(), fVar.f74225b.v(), fVar);
                }
                boolean z2 = false;
                if (f(fVar.f74224a) && d.l.a.d.b.l.v().optInt("link_ad_click_event") == 1) {
                    d.l.a.a.a.d.d dVar = fVar.f74225b;
                    if (dVar instanceof d.l.a.b.a.a.c) {
                        ((d.l.a.b.a.a.c) dVar).b(4);
                    }
                    e.c.a().c(fVar.f74224a, 0);
                    z = true;
                } else {
                    z = false;
                }
                int a2 = f2.a();
                if (a2 == 1) {
                    l("by_url", jSONObject, fVar);
                } else if (a2 == 3) {
                    d("by_package", jSONObject, fVar);
                } else {
                    if (a2 != 4) {
                        f.e.b().g("AppLinkClick default");
                    } else {
                        c("by_package", f2, jSONObject, fVar);
                    }
                    if (z2 && !z && ((e.C2063e.a().c() && !e.C2063e.a().d(fVar.f74224a, fVar.f74225b.u())) || e.C2063e.a().f())) {
                        e.c.a().c(fVar.f74224a, 2);
                    }
                    return z2;
                }
                z2 = true;
                if (z2) {
                    e.c.a().c(fVar.f74224a, 2);
                }
                return z2;
            }
            return invokeL.booleanValue;
        }

        public static boolean h(@NonNull c.f fVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, fVar, i2)) == null) {
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                e.c.a().w("market_click_open", jSONObject, fVar);
                c.h b2 = h.o.b(d.l.a.d.b.l.a(), fVar, fVar.f74225b.v());
                String m = h.r.m(b2.c(), "open_market");
                int a2 = b2.a();
                if (a2 == 5) {
                    e(m, jSONObject, fVar, true);
                } else if (a2 == 6) {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(b2.b()));
                    h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                    return false;
                } else if (a2 != 7) {
                    return false;
                }
                e.c.a().c(fVar.f74224a, i2);
                return true;
            }
            return invokeLI.booleanValue;
        }

        public static boolean i(String str, @NonNull d.l.a.b.a.c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, bVar)) == null) {
                if (d.l.a.d.b.j.h(bVar.L())) {
                    if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
                        return false;
                    }
                    d.l.a.e.b.p.b.a().m(bVar.s());
                    JSONObject jSONObject = new JSONObject();
                    h.l.a(jSONObject, bVar);
                    h.r.q(jSONObject, "applink_source", "auto_click");
                    e.c.a().v("applink_click", bVar);
                    c.h e2 = h.o.e(bVar, bVar.f(), bVar.e());
                    int a2 = e2.a();
                    if (a2 == 1) {
                        l("auto_by_url", jSONObject, bVar);
                        return true;
                    } else if (a2 == 2) {
                        k("auto_by_url", e2, jSONObject, bVar);
                        return false;
                    } else if (a2 == 3) {
                        d("auto_by_package", jSONObject, bVar);
                        return true;
                    } else if (a2 != 4) {
                        return false;
                    } else {
                        c("auto_by_package", e2, jSONObject, bVar);
                        return false;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public static void j(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65545, null, bVar) == null) || bVar == null) {
                return;
            }
            String f2 = d.l.a.e.b.j.a.r().m("app_link_opt") == 1 ? bVar.f() : null;
            JSONObject jSONObject = new JSONObject();
            h.l.a(jSONObject, bVar);
            h.r.q(jSONObject, "applink_source", "dialog_click_by_sdk");
            e.c.a().w("applink_click", jSONObject, bVar);
            c.h f3 = h.o.f(f2, bVar);
            if (f3.a() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    k("dialog_by_url", f3, jSONObject, bVar);
                }
                f3 = h.o.d(d.l.a.d.b.l.a(), bVar.e(), bVar);
            }
            int a2 = f3.a();
            if (a2 == 1) {
                l("dialog_by_url", jSONObject, bVar);
            } else if (a2 == 3) {
                d("dialog_by_package", jSONObject, bVar);
            } else if (a2 != 4) {
                f.e.b().g("AppLinkClickDialog default");
            } else {
                c("dialog_by_package", f3, jSONObject, bVar);
            }
        }

        public static void k(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull d.l.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65546, null, str, hVar, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_url_open_fail", jSONObject, aVar);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void l(String str, @NonNull JSONObject jSONObject, @NonNull d.l.a.b.a.c.a aVar) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65547, null, str, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_url_open", jSONObject, aVar);
                switch (str.hashCode()) {
                    case -1721882089:
                        if (str.equals("auto_by_url")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1374618233:
                        if (str.equals("by_url")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -129544387:
                        if (str.equals("notify_by_url")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 829750366:
                        if (str.equals("dialog_by_url")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if ((d.l.a.d.b.l.v().optInt("check_applink_mode") & 1) != 0) {
                        h.r.q(jSONObject, "check_applink_result_by_sdk", 1);
                        h.d().e(new b(jSONObject, aVar));
                        return;
                    }
                    d.l.a.d.b.l.o().b(d.l.a.d.b.l.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74375e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f74376f;

            /* renamed from: d.l.a.d.c$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C2058a implements k {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f74377a;

                public C2058a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74377a = aVar;
                }

                @Override // d.l.a.d.c.k
                public void a(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        this.f74377a.f74376f.a(z);
                    }
                }
            }

            public a(e eVar, d.l.a.b.a.c.b bVar, j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74375e = bVar;
                this.f74376f = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (l.a(this.f74375e)) {
                        this.f74376f.a(false);
                    } else if (!i.c(this.f74375e)) {
                        this.f74376f.a(false);
                    } else {
                        i.b(this.f74375e, new C2058a(this));
                    }
                }
            }
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(@NonNull d.l.a.b.a.c.b bVar, @NonNull j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bVar, jVar, i2) == null) {
                d.l.a.d.e.a().c(new a(this, bVar, jVar), i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74378e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.l.a.d.i.a.a f74379f;

            public a(d.l.a.b.a.c.b bVar, d.l.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74378e = bVar;
                this.f74379f = aVar;
            }

            @Override // d.l.a.e.b.a.a.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.l.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                    d.l.a.e.b.a.a.c().i(this);
                    if (h.r.C(this.f74378e)) {
                        return;
                    }
                    this.f74378e.b1(true);
                    e.c.a().m("install_delay_invoke", this.f74378e);
                    this.f74379f.a();
                }
            }

            @Override // d.l.a.e.b.a.a.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        }

        public static void a(d.l.a.b.a.c.b bVar, @NonNull d.l.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, bVar, aVar) == null) {
                boolean k = d.l.a.e.b.a.a.c().k();
                if (!k && Build.VERSION.SDK_INT >= 29) {
                    h.r.A();
                }
                boolean k2 = d.l.a.e.b.a.a.c().k();
                if (!k && k2 && bVar != null) {
                    bVar.Z0(true);
                }
                aVar.a();
                d.l.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + k2);
                if (k2) {
                    return;
                }
                d.l.a.e.b.a.a.c().f(new a(bVar, aVar));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes10.dex */
    public class h implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f74380e;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f74381e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f74382f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h f74383g;

            public a(h hVar, long j, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Long.valueOf(j), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74383g = hVar;
                this.f74381e = j;
                this.f74382f = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (d.l.a.e.b.a.a.c().m() && System.currentTimeMillis() - this.f74383g.f74380e > this.f74381e) {
                        this.f74382f.a(false);
                    } else {
                        this.f74382f.a(true);
                    }
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static h f74384a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(75278345, "Ld/l/a/d/c$h$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(75278345, "Ld/l/a/d/c$h$b;");
                        return;
                    }
                }
                f74384a = new h(null);
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public static h d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f74384a : (h) invokeV.objValue;
        }

        @Override // d.l.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74380e = System.currentTimeMillis();
            }
        }

        @Override // d.l.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
                f(gVar, 5000L);
            }
        }

        public void f(g gVar, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(1048579, this, gVar, j) == null) || gVar == null) {
                return;
            }
            d.l.a.d.e.a().c(new a(this, j, gVar), j);
        }

        public void g(g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || gVar == null) {
                return;
            }
            int optInt = d.l.a.d.b.l.v().optInt("check_an_result_delay", 1200);
            f(gVar, optInt > 0 ? optInt : 1200);
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74380e = 0L;
            d.l.a.e.b.a.a.c().f(this);
        }
    }

    /* loaded from: classes10.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74385e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f74386f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f74387g;

            /* renamed from: d.l.a.d.c$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class RunnableC2059a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f74388e;

                public RunnableC2059a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74388e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        boolean F = h.r.F(this.f74388e.f74385e.e());
                        long h2 = i.h(this.f74388e.f74385e);
                        if (!F || h2 >= System.currentTimeMillis() - this.f74388e.f74386f) {
                            long k = i.k(this.f74388e.f74385e);
                            long currentTimeMillis = System.currentTimeMillis();
                            a aVar = this.f74388e;
                            if (currentTimeMillis - aVar.f74386f > k) {
                                e.c.a().m("deeplink_delay_timeout", this.f74388e.f74385e);
                                return;
                            }
                            aVar.f74385e.Z0(true);
                            e.c.a().m("deeplink_delay_invoke", this.f74388e.f74385e);
                            this.f74388e.f74387g.a(true);
                            d.l.a.b.a.c.b bVar = this.f74388e.f74385e;
                            i.d(bVar, i.m(bVar));
                        }
                    }
                }
            }

            public a(d.l.a.b.a.c.b bVar, long j, k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j), kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74385e = bVar;
                this.f74386f = j;
                this.f74387g = kVar;
            }

            @Override // d.l.a.e.b.a.a.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.l.a.e.b.a.a.c().i(this);
                    d.l.a.d.e.a().b(new RunnableC2059a(this));
                }
            }

            @Override // d.l.a.e.b.a.a.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f74389e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f74390f;

            public b(d.l.a.b.a.c.b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74389e = bVar;
                this.f74390f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 1;
                    if (h.r.F(this.f74389e.e())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!this.f74389e.c0()) {
                                i2 = 2;
                            }
                            jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        e.c.a().r("deeplink_success_2", jSONObject, this.f74389e);
                        return;
                    }
                    i.d(this.f74389e, this.f74390f - 1);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(768792614, "Ld/l/a/d/c$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(768792614, "Ld/l/a/d/c$i;");
                    return;
                }
            }
            new Handler(Looper.getMainLooper());
        }

        public static void b(d.l.a.b.a.c.b bVar, @NonNull k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, bVar, kVar) == null) {
                boolean k = d.l.a.e.b.a.a.c().k();
                if (!k && Build.VERSION.SDK_INT >= 29) {
                    h.r.A();
                }
                boolean k2 = d.l.a.e.b.a.a.c().k();
                boolean z = !k && k2;
                if (bVar != null) {
                    bVar.Z0(z);
                }
                kVar.a(z);
                if (bVar == null) {
                    return;
                }
                d(bVar, m(bVar));
                if (k2) {
                    return;
                }
                d.l.a.e.b.a.a.c().f(new a(bVar, System.currentTimeMillis(), kVar));
            }
        }

        public static boolean c(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_switch") == 1 : invokeL.booleanValue;
        }

        public static void d(@NonNull d.l.a.b.a.c.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(65540, null, bVar, i2) == null) || i2 <= 0) {
                return;
            }
            d.l.a.d.e.a().c(new b(bVar, i2), l(bVar) * 1000);
        }

        public static boolean e(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_install_switch") == 1 : invokeL.booleanValue;
        }

        public static boolean f(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_invoke_switch") == 1 : invokeL.booleanValue;
        }

        public static boolean g(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_dialog_switch") == 1 : invokeL.booleanValue;
        }

        public static long h(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bVar)) == null) {
                if (bVar == null) {
                    return 3000L;
                }
                return h.k.c(bVar).b("app_link_opt_back_time_limit", 3) * 1000;
            }
            return invokeL.longValue;
        }

        public static long k(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) ? h.k.c(bVar).c("app_link_check_timeout", 300000L) : invokeL.longValue;
        }

        public static int l(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bVar)) == null) ? h.k.c(bVar).b("app_link_check_delay", 1) : invokeL.intValue;
        }

        public static int m(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bVar)) == null) ? h.k.c(bVar).b("app_link_check_count", 10) : invokeL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface j {
        void a(boolean z);
    }

    /* loaded from: classes10.dex */
    public interface k {
        void a(boolean z);
    }

    /* loaded from: classes10.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(@NonNull d.l.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? d.l.a.e.a.h.e.h() && Build.VERSION.SDK_INT < 29 && d.l.a.d.b.l.x() != null && d.l.a.d.b.l.x().a() && h.k.c(aVar).m("invoke_app_form_background_switch") == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(179570763, "Ld/l/a/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(179570763, "Ld/l/a/d/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74348a = d.l.a.d.h.b(d.l.a.d.b.l.a());
    }

    public static d.l.a.a.a.d.b e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            a.C2045a c2045a = new a.C2045a();
            c2045a.a(0);
            c2045a.c(true);
            c2045a.g(false);
            c2045a.h(false);
            if (z) {
                c2045a.e(2);
            } else {
                c2045a.e(0);
            }
            return c2045a.d();
        }
        return (d.l.a.a.a.d.b) invokeZ.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f74347c == null) {
                synchronized (c.class) {
                    if (f74347c == null) {
                        f74347c = new c();
                    }
                }
            }
            return f74347c;
        }
        return (c) invokeV.objValue;
    }

    public static d.l.a.a.a.d.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? e(false) : (d.l.a.a.a.d.b) invokeV.objValue;
    }

    public static d.l.a.a.a.d.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            b.a aVar = new b.a();
            aVar.b("landing_h5_download_ad_button");
            aVar.e("landing_h5_download_ad_button");
            aVar.g("click_start_detail");
            aVar.i("click_pause_detail");
            aVar.j("click_continue_detail");
            aVar.k("click_install_detail");
            aVar.l("click_open_detail");
            aVar.m("storage_deny_detail");
            aVar.a(1);
            aVar.c(false);
            aVar.f(true);
            aVar.h(false);
            return aVar.d();
        }
        return (d.l.a.a.a.d.c) invokeV.objValue;
    }

    @Override // d.l.a.b.a.d
    public Dialog a(Context context, String str, boolean z, @NonNull d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, d.l.a.a.a.d.e eVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2)})) == null) ? d(context, str, z, dVar, cVar, bVar, eVar, i2, false) : (Dialog) invokeCommon.objValue;
    }

    @Override // d.l.a.b.a.d
    public boolean b(Context context, long j2, String str, d.l.a.a.a.d.e eVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j2), str, eVar, Integer.valueOf(i2)})) == null) {
            d.l.a.b.a.c.b u = c.g.e().u(j2);
            if (u != null) {
                this.f74348a.e(context, i2, eVar, u.h0());
                return true;
            }
            d.l.a.a.a.d.d a2 = c.g.e().a(j2);
            if (a2 != null) {
                this.f74348a.e(context, i2, eVar, a2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.l.a.b.a.d
    public boolean c(Context context, Uri uri, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, uri, dVar, cVar, bVar)) == null) ? ((Boolean) f.d.a(new C2056c(this, context, uri, dVar, cVar, bVar))).booleanValue() : invokeLLLLL.booleanValue;
    }

    public Dialog d(Context context, String str, boolean z, @NonNull d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, d.l.a.a.a.d.e eVar, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) ? (Dialog) f.d.a(new a(this, context, str, z, dVar, cVar, bVar, eVar, i2, z2)) : (Dialog) invokeCommon.objValue;
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            d.l.a.a.a.d.d a2 = c.g.e().a(j2);
            d.l.a.b.a.c.b u = c.g.e().u(j2);
            if (a2 == null && u != null) {
                a2 = u.h0();
            }
            if (a2 == null) {
                return;
            }
            d.l.a.a.a.d.c n = c.g.e().n(j2);
            d.l.a.a.a.d.b s = c.g.e().s(j2);
            if (n instanceof d.l.a.a.a.d.h) {
                n = null;
            }
            if (s instanceof d.l.a.a.a.d.g) {
                s = null;
            }
            if (u == null) {
                if (n == null) {
                    n = o();
                }
                if (s == null) {
                    s = l();
                }
            } else {
                if (n == null) {
                    b.a aVar = new b.a();
                    aVar.b(u.j());
                    aVar.n(u.i());
                    aVar.h(u.m());
                    aVar.c(false);
                    aVar.g("click_start_detail");
                    aVar.i("click_pause_detail");
                    aVar.j("click_continue_detail");
                    aVar.k("click_install_detail");
                    aVar.m("storage_deny_detail");
                    n = aVar.d();
                }
                if (s == null) {
                    s = u.j0();
                }
            }
            d.l.a.a.a.d.c cVar = n;
            cVar.a(1);
            this.f74348a.h(a2.a(), j2, 2, cVar, s);
        }
    }

    public void i(long j2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), cVar, bVar}) == null) {
            d.l.a.a.a.d.d a2 = c.g.e().a(j2);
            d.l.a.b.a.c.b u = c.g.e().u(j2);
            if (a2 == null && u != null) {
                a2 = u.h0();
            }
            if (a2 == null) {
                return;
            }
            if (cVar != null && bVar != null && !(cVar instanceof d.l.a.a.a.d.h) && !(bVar instanceof d.l.a.a.a.d.g)) {
                cVar.a(1);
                this.f74348a.h(a2.a(), j2, 2, cVar, bVar);
                return;
            }
            h(j2);
        }
    }

    public Dialog k(Context context, String str, boolean z, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, d.l.a.a.a.d.e eVar, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (m(dVar.d())) {
                if (z2) {
                    i(dVar.d(), cVar, bVar);
                } else {
                    h(dVar.d());
                }
                return null;
            } else if (context == null || TextUtils.isEmpty(dVar.a())) {
                return null;
            } else {
                this.f74348a.e(context, i2, eVar, dVar);
                boolean z3 = true;
                d.l.a.a.a.d.c cVar2 = (d.l.a.a.a.d.c) h.r.k(cVar, o());
                d.l.a.a.a.d.b bVar2 = (d.l.a.a.a.d.b) h.r.k(bVar, l());
                cVar2.a(1);
                boolean z4 = (d.l.a.d.b.l.v().optInt("disable_lp_dialog", 0) == 1) | z;
                if (!bVar2.e() || !d.l.a.d.b.e.b.a().e(dVar)) {
                    z3 = z4;
                }
                if (z3) {
                    this.f74348a.h(dVar.a(), dVar.d(), 2, cVar2, bVar2);
                    return null;
                }
                String str2 = f74346b;
                h.q.b(str2, "tryStartDownload show dialog appName:" + dVar.a(), null);
                d.l.a.a.a.c.k p = d.l.a.d.b.l.p();
                c.b bVar3 = new c.b(context);
                bVar3.e(dVar.h());
                bVar3.h("确认要下载此应用吗？");
                bVar3.j("确认");
                bVar3.l("取消");
                bVar3.d(new b(this, dVar, cVar2, bVar2));
                bVar3.b(0);
                Dialog b2 = p.b(bVar3.g());
                e.c.a().l("landing_download_dialog_show", dVar, cVar2, bVar2);
                return b2;
            }
        }
        return (Dialog) invokeCommon.objValue;
    }

    public boolean m(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? (c.g.e().a(j2) == null && c.g.e().u(j2) == null) ? false : true : invokeJ.booleanValue;
    }

    public final boolean n(Context context, Uri uri, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, uri, dVar, cVar, bVar)) == null) {
            d.l.a.a.a.d.b bVar2 = bVar;
            if (d.l.a.a.a.g.a.a(uri) && d.l.a.d.b.l.v().optInt("disable_market") != 1) {
                Context a2 = context == null ? d.l.a.d.b.l.a() : context;
                String b2 = d.l.a.a.a.g.a.b(uri);
                if (dVar == null) {
                    return h.o.c(a2, b2).a() == 5;
                }
                if (!TextUtils.isEmpty(b2) && (dVar instanceof d.l.a.b.a.a.c)) {
                    ((d.l.a.b.a.a.c) dVar).e(b2);
                }
                if (bVar2 != null) {
                    bVar2.a(2);
                } else if ((dVar instanceof d.l.a.b.a.a.c) && TextUtils.isEmpty(dVar.a())) {
                    ((d.l.a.b.a.a.c) dVar).f(uri.toString());
                    bVar2 = e(true);
                } else if (dVar.a().startsWith("market")) {
                    bVar2 = e(true);
                } else {
                    bVar2 = l();
                }
                c.f fVar = new c.f(dVar.d(), dVar, (d.l.a.a.a.d.c) h.r.k(cVar, o()), bVar2);
                c.g.e().i(fVar.f74225b);
                c.g.e().h(fVar.f74224a, fVar.f74226c);
                c.g.e().g(fVar.f74224a, fVar.f74227d);
                if (h.r.v(dVar) && d.l.a.e.b.j.a.r().m("app_link_opt") == 1 && d.g(fVar)) {
                    return true;
                }
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "market_url", uri.toString());
                h.r.q(jSONObject, "download_scene", 1);
                e.c.a().w("market_click_open", jSONObject, fVar);
                c.h b3 = h.o.b(a2, fVar, b2);
                String m = h.r.m(b3.c(), "open_market");
                if (b3.a() == 5) {
                    d.e(m, jSONObject, fVar, true);
                    return true;
                } else if (b3.a() == 6) {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(b3.b()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
