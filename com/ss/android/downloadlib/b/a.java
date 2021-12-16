package com.ss.android.downloadlib.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.l;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eVar)) == null) {
            DeepLink deepLink = eVar.f61804b.getDeepLink();
            String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
            JSONObject a = com.ss.android.downloadlib.g.f.a(new JSONObject(), eVar);
            l.a(a, "applink_source", "click_by_sdk");
            com.ss.android.downloadlib.d.a.a().b("applink_click", a, eVar);
            com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(openUrl, eVar);
            if (a2.getType() == 2) {
                if (!TextUtils.isEmpty(openUrl)) {
                    b("by_url", a2, a, eVar);
                }
                a2 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar.f61804b.getPackageName(), eVar);
            }
            boolean z2 = false;
            if (a(eVar.a) && com.ss.android.downloadlib.addownload.j.i().optInt("link_ad_click_event") == 1) {
                DownloadModel downloadModel = eVar.f61804b;
                if (downloadModel instanceof AdDownloadModel) {
                    ((AdDownloadModel) downloadModel).setFunnelType(4);
                }
                com.ss.android.downloadlib.d.a.a().a(eVar.a, 0);
                z = true;
            } else {
                z = false;
            }
            int type = a2.getType();
            if (type == 1) {
                b("by_url", a, eVar);
            } else if (type == 3) {
                a("by_package", a, eVar);
            } else {
                if (type != 4) {
                    com.ss.android.downloadlib.e.c.a().b("AppLinkClick default");
                } else {
                    a("by_package", a2, a, eVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(eVar.a, eVar.f61804b.getLogExtra())) || com.ss.android.downloadlib.d.c.a().c())) {
                    com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
                }
                return z2;
            }
            z2 = true;
            if (z2) {
                com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
            }
            return z2;
        }
        return invokeL.booleanValue;
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, bVar) == null) || bVar == null) {
            return;
        }
        String f2 = com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 ? bVar.f() : null;
        JSONObject a = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        l.a(a, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a, bVar);
        com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(f2, bVar);
        if (a2.getType() == 2) {
            if (!TextUtils.isEmpty(f2)) {
                b("dialog_by_url", a2, a, bVar);
            }
            a2 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
        }
        int type = a2.getType();
        if (type == 1) {
            b("dialog_by_url", a, bVar);
        } else if (type == 3) {
            a("dialog_by_package", a, bVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickDialog default");
        } else {
            a("dialog_by_package", a2, a, bVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, jSONObject, aVar) == null) {
            l.a(jSONObject, "applink_source", str);
            l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
            com.ss.android.downloadlib.d.a.a().b("deeplink_url_open", jSONObject, aVar);
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
                if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 1) != 0) {
                    l.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d(jSONObject, aVar) { // from class: com.ss.android.downloadlib.b.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ JSONObject a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.a f61929b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {jSONObject, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = jSONObject;
                            this.f61929b = aVar;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", this.a, this.f61929b);
                                if (z) {
                                    com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), this.f61929b.u(), this.f61929b.w(), this.f61929b.v(), this.f61929b.e(), 0);
                                }
                            }
                        }
                    });
                    return;
                }
                com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
            }
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            String f2 = bVar.f();
            JSONObject a = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
            l.a(a, "applink_source", "notify_click_by_sdk");
            com.ss.android.downloadlib.d.a.a().b("applink_click", a, bVar);
            com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(f2, bVar);
            if (a2.getType() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    b("notify_by_url", a2, a, bVar);
                }
                a2 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
            }
            int type = a2.getType();
            if (type == 1) {
                b("notify_by_url", a, bVar);
            } else if (type == 3) {
                a("notify_by_package", a, bVar);
            } else if (type != 4) {
                com.ss.android.downloadlib.e.c.a().b("AppLinkClickNotification default");
            } else {
                a("notify_by_package", a2, a, bVar);
            }
        }
    }

    public static void b(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, str, gVar, jSONObject, aVar) == null) {
            l.a(jSONObject, "applink_source", str);
            l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
            l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
            com.ss.android.downloadlib.d.a.a().b("deeplink_url_open_fail", jSONObject, aVar);
        }
    }

    public static boolean a(String str, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, bVar)) == null) {
            if (com.ss.android.downloadlib.addownload.h.b(bVar.O())) {
                if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
                    return false;
                }
                com.ss.android.socialbase.downloader.notification.b.a().f(bVar.s());
                JSONObject jSONObject = new JSONObject();
                com.ss.android.downloadlib.g.f.a(jSONObject, bVar);
                l.a(jSONObject, "applink_source", "auto_click");
                com.ss.android.downloadlib.d.a.a().b("applink_click", bVar);
                com.ss.android.downloadlib.addownload.b.g a = com.ss.android.downloadlib.g.i.a(bVar, bVar.f(), bVar.e());
                int type = a.getType();
                if (type == 1) {
                    b("auto_by_url", jSONObject, bVar);
                    return true;
                } else if (type == 2) {
                    b("auto_by_url", a, jSONObject, bVar);
                    return false;
                } else if (type == 3) {
                    a("auto_by_package", jSONObject, bVar);
                    return true;
                } else if (type != 4) {
                    return false;
                } else {
                    a("auto_by_package", a, jSONObject, bVar);
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, jSONObject, aVar) == null) {
            l.a(jSONObject, "applink_source", str);
            l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
            com.ss.android.downloadlib.d.a.a().b("deeplink_app_open", jSONObject, aVar);
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
                if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 1) != 0) {
                    l.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d(jSONObject, aVar) { // from class: com.ss.android.downloadlib.b.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ JSONObject a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.a f61928b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {jSONObject, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = jSONObject;
                            this.f61928b = aVar;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", this.a, this.f61928b);
                                if (z) {
                                    com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), this.f61928b.u(), this.f61928b.w(), this.f61928b.v(), this.f61928b.e(), 0);
                                }
                            }
                        }
                    });
                    return;
                }
                com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
            }
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, gVar, jSONObject, aVar) == null) {
            l.a(jSONObject, "applink_source", str);
            l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
            l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
            com.ss.android.downloadlib.d.a.a().b("deeplink_app_open_fail", jSONObject, aVar);
        }
    }

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, eVar, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
            com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
            com.ss.android.downloadlib.addownload.b.g a = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar, eVar.f61804b.getPackageName());
            String a2 = l.a(a.b(), "open_market");
            int type = a.getType();
            if (type == 5) {
                a(a2, jSONObject, eVar, true);
            } else if (type == 6) {
                l.a(jSONObject, "error_code", Integer.valueOf(a.a()));
                l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            } else if (type != 7) {
                return false;
            }
            com.ss.android.downloadlib.d.a.a().a(eVar.a, i2);
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void a(String str, @Nullable JSONObject jSONObject, com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, jSONObject, eVar, Boolean.valueOf(z)}) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e2) {
                    com.ss.android.downloadlib.e.c.a().a(e2, "onMarketSuccess");
                    return;
                }
            }
            l.a(jSONObject, "applink_source", str);
            l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
            if (z) {
                com.ss.android.downloadlib.d.a.a().b("market_open_success", jSONObject, eVar);
            }
            if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 4) != 0) {
                e.a().b(new d(str, eVar, jSONObject) { // from class: com.ss.android.downloadlib.b.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f61930b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ JSONObject f61931c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, eVar, jSONObject};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = str;
                        this.f61930b = eVar;
                        this.f61931c = jSONObject;
                    }

                    @Override // com.ss.android.downloadlib.b.d
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (!z2 && !"open_market".equals(this.a)) {
                                Context context = com.ss.android.downloadlib.addownload.j.getContext();
                                a.a(com.ss.android.downloadlib.g.i.a(context, Uri.parse(BaseConstants.MARKET_PREFIX + this.f61930b.e())), this.f61930b, false);
                            }
                            com.ss.android.downloadlib.d.a.a().a(z2 ? "market_delay_success" : "market_delay_failed", this.f61931c, this.f61930b);
                            if (z2) {
                                r t = com.ss.android.downloadlib.addownload.j.t();
                                Context context2 = com.ss.android.downloadlib.addownload.j.getContext();
                                com.ss.android.downloadlib.addownload.b.e eVar2 = this.f61930b;
                                DownloadModel downloadModel = eVar2.f61804b;
                                t.a(context2, downloadModel, eVar2.f61806d, eVar2.f61805c, downloadModel.getPackageName(), 2);
                            }
                        }
                    }
                });
            } else {
                com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), eVar.f61804b, eVar.f61806d, eVar.f61805c, eVar.f61804b.getPackageName(), str);
            }
            com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f61804b, eVar.f61805c, eVar.f61806d);
            bVar.e(2);
            bVar.f(System.currentTimeMillis());
            bVar.h(4);
            bVar.i(2);
            com.ss.android.downloadlib.addownload.b.f.a().a(bVar);
        }
    }

    public static void a(com.ss.android.downloadlib.addownload.b.g gVar, com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, gVar, eVar, z) == null) {
            String a = l.a(gVar.b(), "open_market");
            JSONObject jSONObject = new JSONObject();
            l.a(jSONObject, "ttdownloader_type", UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            int type = gVar.getType();
            if (type == 5) {
                a(a, jSONObject, eVar, z);
            } else if (type != 6) {
            } else {
                l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
                l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
            }
        }
    }

    public static boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) ? com.ss.android.downloadlib.addownload.b.f.a().d(j2) == null : invokeJ.booleanValue;
    }
}
