package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.b;
import com.ss.android.downloadlib.g.i;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.ss.android.downloadad.api.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68679a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f68680b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public g f68681c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1020732096, "Lcom/ss/android/downloadlib/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1020732096, "Lcom/ss/android/downloadlib/b;");
        }
    }

    public b() {
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
        this.f68681c = g.a(j.getContext());
    }

    public static DownloadEventConfig c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build() : (DownloadEventConfig) invokeV.objValue;
    }

    public Dialog b(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (b(downloadModel.getId())) {
                if (z2) {
                    a(downloadModel.getId(), downloadEventConfig, downloadController);
                } else {
                    a(downloadModel.getId());
                }
                return null;
            } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                return null;
            } else {
                this.f68681c.a(context, i2, downloadStatusChangeListener, downloadModel);
                boolean z3 = true;
                DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) l.a(downloadEventConfig, c());
                DownloadController downloadController2 = (DownloadController) l.a(downloadController, b());
                downloadEventConfig2.setDownloadScene(1);
                boolean z4 = (j.i().optInt("disable_lp_dialog", 0) == 1) | z;
                if (!downloadController2.enableShowComplianceDialog() || !com.ss.android.downloadlib.addownload.compliance.b.a().a(downloadModel)) {
                    z3 = z4;
                }
                if (z3) {
                    this.f68681c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    return null;
                }
                String str2 = f68679a;
                k.a(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
                Dialog b2 = j.c().b(new b.a(context).a(downloadModel.getName()).b("确认要下载此应用吗？").c("确认").d("取消").a(new b.InterfaceC1965b(this, downloadModel, downloadEventConfig2, downloadController2) { // from class: com.ss.android.downloadlib.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DownloadModel f68691a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DownloadEventConfig f68692b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ DownloadController f68693c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ b f68694d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, downloadModel, downloadEventConfig2, downloadController2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68694d = this;
                        this.f68691a = downloadModel;
                        this.f68692b = downloadEventConfig2;
                        this.f68693c = downloadController2;
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                    public void a(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.f68694d.f68681c.a(this.f68691a.getDownloadUrl(), this.f68691a.getId(), 2, this.f68692b, this.f68693c);
                            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_confirm", this.f68691a, this.f68692b, this.f68693c);
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                    public void b(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", this.f68691a, this.f68692b, this.f68693c);
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                    public void c(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", this.f68691a, this.f68692b, this.f68693c);
                        }
                    }
                }).a(0).a());
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
                return b2;
            }
        }
        return (Dialog) invokeCommon.objValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f68680b == null) {
                synchronized (b.class) {
                    if (f68680b == null) {
                        f68680b = new b();
                    }
                }
            }
            return f68680b;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.b
    public Dialog a(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, Boolean.valueOf(z), downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, Integer.valueOf(i2)})) == null) ? a(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false) : (Dialog) invokeCommon.objValue;
    }

    public Dialog a(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Boolean.valueOf(z), downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) ? (Dialog) com.ss.android.downloadlib.e.b.a(new b.a<Dialog>(this, context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2) { // from class: com.ss.android.downloadlib.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f68682a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f68683b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f68684c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DownloadModel f68685d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DownloadEventConfig f68686e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DownloadController f68687f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ DownloadStatusChangeListener f68688g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f68689h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f68690i;
            public final /* synthetic */ b j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, str, Boolean.valueOf(z), downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, Integer.valueOf(i2), Boolean.valueOf(z2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = this;
                this.f68682a = context;
                this.f68683b = str;
                this.f68684c = z;
                this.f68685d = downloadModel;
                this.f68686e = downloadEventConfig;
                this.f68687f = downloadController;
                this.f68688g = downloadStatusChangeListener;
                this.f68689h = i2;
                this.f68690i = z2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Dialog b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.j.b(this.f68682a, this.f68683b, this.f68684c, this.f68685d, this.f68686e, this.f68687f, this.f68688g, this.f68689h, this.f68690i) : (Dialog) invokeV.objValue;
            }
        }) : (Dialog) invokeCommon.objValue;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), str, downloadStatusChangeListener, Integer.valueOf(i2)})) == null) {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
            if (d2 != null) {
                this.f68681c.a(context, i2, downloadStatusChangeListener, d2.af());
                return true;
            }
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
            if (a2 != null) {
                this.f68681c.a(context, i2, downloadStatusChangeListener, a2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void a(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), downloadEventConfig, downloadController}) == null) {
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
            if (a2 == null && d2 != null) {
                a2 = d2.af();
            }
            if (a2 == null) {
                return;
            }
            if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.c) && !(downloadController instanceof com.ss.android.download.api.download.b)) {
                downloadEventConfig.setDownloadScene(1);
                this.f68681c.a(a2.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
                return;
            }
            a(j);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
            if (a2 == null && d2 != null) {
                a2 = d2.af();
            }
            if (a2 == null) {
                return;
            }
            DownloadEventConfig b2 = com.ss.android.downloadlib.addownload.b.f.a().b(j);
            DownloadController c2 = com.ss.android.downloadlib.addownload.b.f.a().c(j);
            if (b2 instanceof com.ss.android.download.api.download.c) {
                b2 = null;
            }
            if (c2 instanceof com.ss.android.download.api.download.b) {
                c2 = null;
            }
            if (d2 == null) {
                if (b2 == null) {
                    b2 = c();
                }
                if (c2 == null) {
                    c2 = b();
                }
            } else {
                if (b2 == null) {
                    b2 = new AdDownloadEventConfig.Builder().setClickButtonTag(d2.j()).setRefer(d2.i()).setIsEnableV3Event(d2.m()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
                }
                if (c2 == null) {
                    c2 = d2.ah();
                }
            }
            DownloadEventConfig downloadEventConfig = b2;
            downloadEventConfig.setDownloadScene(1);
            this.f68681c.a(a2.getDownloadUrl(), j, 2, downloadEventConfig, c2);
        }
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? (com.ss.android.downloadlib.addownload.b.f.a().a(j) == null && com.ss.android.downloadlib.addownload.b.f.a().d(j) == null) ? false : true : invokeJ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, this, context, uri, downloadModel, downloadEventConfig, downloadController)) == null) {
            DownloadController downloadController2 = downloadController;
            if (com.ss.android.download.api.c.a.a(uri) && j.i().optInt("disable_market") != 1) {
                Context context2 = context == null ? j.getContext() : context;
                String b2 = com.ss.android.download.api.c.a.b(uri);
                if (downloadModel == null) {
                    return i.a(context2, b2).getType() == 5;
                }
                if (!TextUtils.isEmpty(b2) && (downloadModel instanceof AdDownloadModel)) {
                    ((AdDownloadModel) downloadModel).setPackageName(b2);
                }
                if (downloadController2 != null) {
                    downloadController2.setDownloadMode(2);
                } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                    ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                    downloadController2 = a(true);
                } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
                    downloadController2 = a(true);
                } else {
                    downloadController2 = b();
                }
                com.ss.android.downloadlib.addownload.b.e eVar = new com.ss.android.downloadlib.addownload.b.e(downloadModel.getId(), downloadModel, (DownloadEventConfig) l.a(downloadEventConfig, c()), downloadController2);
                com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f68515b);
                com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f68514a, eVar.f68516c);
                com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f68514a, eVar.f68517d);
                if (l.a(downloadModel) && com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.a(eVar)) {
                    return true;
                }
                JSONObject jSONObject = new JSONObject();
                l.a(jSONObject, "market_url", uri.toString());
                l.a(jSONObject, "download_scene", (Object) 1);
                com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
                com.ss.android.downloadlib.addownload.b.g a2 = i.a(context2, eVar, b2);
                String a3 = l.a(a2.b(), "open_market");
                if (a2.getType() == 5) {
                    com.ss.android.downloadlib.b.a.a(a3, jSONObject, eVar, true);
                    return true;
                } else if (a2.getType() == 6) {
                    l.a(jSONObject, "error_code", Integer.valueOf(a2.a()));
                    com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, context, uri, downloadModel, downloadEventConfig, downloadController)) == null) ? ((Boolean) com.ss.android.downloadlib.e.b.a(new b.a<Boolean>(this, context, uri, downloadModel, downloadEventConfig, downloadController) { // from class: com.ss.android.downloadlib.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f68695a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Uri f68696b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ DownloadModel f68697c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DownloadEventConfig f68698d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DownloadController f68699e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f68700f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, uri, downloadModel, downloadEventConfig, downloadController};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68700f = this;
                this.f68695a = context;
                this.f68696b = uri;
                this.f68697c = downloadModel;
                this.f68698d = downloadEventConfig;
                this.f68699e = downloadController;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(this.f68700f.b(this.f68695a, this.f68696b, this.f68697c, this.f68698d, this.f68699e)) : (Boolean) invokeV.objValue;
            }
        })).booleanValue() : invokeLLLLL.booleanValue;
    }

    public static DownloadController a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
            if (z) {
                shouldUseNewWebView.setDownloadMode(2);
            } else {
                shouldUseNewWebView.setDownloadMode(0);
            }
            return shouldUseNewWebView.build();
        }
        return (DownloadController) invokeZ.objValue;
    }

    public static DownloadController b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? a(false) : (DownloadController) invokeV.objValue;
    }
}
