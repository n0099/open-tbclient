package com.ss.android.downloadlib.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, eVar)) == null) {
            DeepLink deepLink = eVar.f68514b.getDeepLink();
            String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
            JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), eVar);
            l.a(a2, "applink_source", "click_by_sdk");
            com.ss.android.downloadlib.d.a.a().b("applink_click", a2, eVar);
            com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(openUrl, eVar);
            if (a3.getType() == 2) {
                if (!TextUtils.isEmpty(openUrl)) {
                    b("by_url", a3, a2, eVar);
                }
                a3 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar.f68514b.getPackageName(), eVar);
            }
            boolean z2 = false;
            if (a(eVar.f68513a) && com.ss.android.downloadlib.addownload.j.i().optInt("link_ad_click_event") == 1) {
                DownloadModel downloadModel = eVar.f68514b;
                if (downloadModel instanceof AdDownloadModel) {
                    ((AdDownloadModel) downloadModel).setFunnelType(4);
                }
                com.ss.android.downloadlib.d.a.a().a(eVar.f68513a, 0);
                z = true;
            } else {
                z = false;
            }
            int type = a3.getType();
            if (type == 1) {
                b("by_url", a2, eVar);
            } else if (type == 3) {
                a("by_package", a2, eVar);
            } else {
                if (type != 4) {
                    com.ss.android.downloadlib.e.c.a().b("AppLinkClick default");
                } else {
                    a("by_package", a3, a2, eVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(eVar.f68513a, eVar.f68514b.getLogExtra())) || com.ss.android.downloadlib.d.c.a().c())) {
                    com.ss.android.downloadlib.d.a.a().a(eVar.f68513a, 2);
                }
                return z2;
            }
            z2 = true;
            if (z2) {
                com.ss.android.downloadlib.d.a.a().a(eVar.f68513a, 2);
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
        JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        l.a(a2, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a2, bVar);
        com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(f2, bVar);
        if (a3.getType() == 2) {
            if (!TextUtils.isEmpty(f2)) {
                b("dialog_by_url", a3, a2, bVar);
            }
            a3 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
        }
        int type = a3.getType();
        if (type == 1) {
            b("dialog_by_url", a2, bVar);
        } else if (type == 3) {
            a("dialog_by_package", a2, bVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickDialog default");
        } else {
            a("dialog_by_package", a3, a2, bVar);
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

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f68702a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.a f68703b;

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
                            this.f68702a = jSONObject;
                            this.f68703b = aVar;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", this.f68702a, this.f68703b);
                                if (z) {
                                    com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), this.f68703b.u(), this.f68703b.w(), this.f68703b.v(), this.f68703b.e(), 0);
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
            JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
            l.a(a2, "applink_source", "notify_click_by_sdk");
            com.ss.android.downloadlib.d.a.a().b("applink_click", a2, bVar);
            com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(f2, bVar);
            if (a3.getType() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    b("notify_by_url", a3, a2, bVar);
                }
                a3 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
            }
            int type = a3.getType();
            if (type == 1) {
                b("notify_by_url", a2, bVar);
            } else if (type == 3) {
                a("notify_by_package", a2, bVar);
            } else if (type != 4) {
                com.ss.android.downloadlib.e.c.a().b("AppLinkClickNotification default");
            } else {
                a("notify_by_package", a3, a2, bVar);
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
                com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(bVar, bVar.f(), bVar.e());
                int type = a2.getType();
                if (type == 1) {
                    b("auto_by_url", jSONObject, bVar);
                    return true;
                } else if (type == 2) {
                    b("auto_by_url", a2, jSONObject, bVar);
                    return false;
                } else if (type == 3) {
                    a("auto_by_package", jSONObject, bVar);
                    return true;
                } else if (type != 4) {
                    return false;
                } else {
                    a("auto_by_package", a2, jSONObject, bVar);
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

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f68700a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.a f68701b;

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
                            this.f68700a = jSONObject;
                            this.f68701b = aVar;
                        }

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", this.f68700a, this.f68701b);
                                if (z) {
                                    com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), this.f68701b.u(), this.f68701b.w(), this.f68701b.v(), this.f68701b.e(), 0);
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
            com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar, eVar.f68514b.getPackageName());
            String a3 = l.a(a2.b(), "open_market");
            int type = a2.getType();
            if (type == 5) {
                a(a3, jSONObject, eVar, true);
            } else if (type == 6) {
                l.a(jSONObject, "error_code", Integer.valueOf(a2.a()));
                l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            } else if (type != 7) {
                return false;
            }
            com.ss.android.downloadlib.d.a.a().a(eVar.f68513a, i2);
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

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f68704a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f68705b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ JSONObject f68706c;

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
                        this.f68704a = str;
                        this.f68705b = eVar;
                        this.f68706c = jSONObject;
                    }

                    @Override // com.ss.android.downloadlib.b.d
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (!z2 && !"open_market".equals(this.f68704a)) {
                                Context context = com.ss.android.downloadlib.addownload.j.getContext();
                                a.a(com.ss.android.downloadlib.g.i.a(context, Uri.parse(BaseConstants.MARKET_PREFIX + this.f68705b.e())), this.f68705b, false);
                            }
                            com.ss.android.downloadlib.d.a.a().a(z2 ? "market_delay_success" : "market_delay_failed", this.f68706c, this.f68705b);
                            if (z2) {
                                r t = com.ss.android.downloadlib.addownload.j.t();
                                Context context2 = com.ss.android.downloadlib.addownload.j.getContext();
                                com.ss.android.downloadlib.addownload.b.e eVar2 = this.f68705b;
                                DownloadModel downloadModel = eVar2.f68514b;
                                t.a(context2, downloadModel, eVar2.f68516d, eVar2.f68515c, downloadModel.getPackageName(), 2);
                            }
                        }
                    }
                });
            } else {
                com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), eVar.f68514b, eVar.f68516d, eVar.f68515c, eVar.f68514b.getPackageName(), str);
            }
            com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f68514b, eVar.f68515c, eVar.f68516d);
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
            String a2 = l.a(gVar.b(), "open_market");
            JSONObject jSONObject = new JSONObject();
            l.a(jSONObject, "ttdownloader_type", UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            int type = gVar.getType();
            if (type == 5) {
                a(a2, jSONObject, eVar, z);
            } else if (type != 6) {
            } else {
                l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
                l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
            }
        }
    }

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) ? com.ss.android.downloadlib.addownload.b.f.a().d(j) == null : invokeJ.booleanValue;
    }
}
