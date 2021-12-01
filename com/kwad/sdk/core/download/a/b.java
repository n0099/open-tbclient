package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.kwad.sdk.core.download.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57361b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f57362c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f57363d;

    /* renamed from: e  reason: collision with root package name */
    public long f57364e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57365f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57366g;

    /* renamed from: h  reason: collision with root package name */
    public a f57367h;

    /* renamed from: i  reason: collision with root package name */
    public DialogInterface.OnShowListener f57368i;

    /* renamed from: j  reason: collision with root package name */
    public DialogInterface.OnDismissListener f57369j;

    /* renamed from: k  reason: collision with root package name */
    public List<KsAppDownloadListener> f57370k;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(DialogInterface.OnClickListener onClickListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (JSONObject) objArr2[1], (KsAppDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, ksAppDownloadListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (JSONObject) objArr2[1], (KsAppDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, ksAppDownloadListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, ksAppDownloadListener, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (JSONObject) objArr2[1], (KsAppDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        AdInfo adInfo = this.f57362c;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = aa.a(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (JSONObject) objArr2[1], (KsAppDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, jSONObject, ksAppDownloadListener};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f57370k = new ArrayList();
        this.f57361b = adTemplate;
        this.f57362c = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57363d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f57361b);
        DownloadStatusManager.a().a(this.f57361b);
        this.f57366g = com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.j(this.f57361b));
    }

    public static void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, context, adTemplate) == null) || context == null || adTemplate == null) {
            return;
        }
        AdWebViewLandPageActivityProxy.launch(context, adTemplate);
    }

    public static boolean b(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c2015a)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2015a.b());
            if (com.kwad.sdk.core.response.a.a.ad(j2) && (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2015a.b().isWebViewDownload)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.ae(j2) && !com.ksad.download.c.b.b(c2015a.a());
        }
        return invokeL.booleanValue;
    }

    public static int c(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, c2015a)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2015a.b());
            if (j2.downloadSafeInfo.complianceInfo != null) {
                int g2 = c2015a.g();
                return g2 != 2 ? g2 != 3 ? j2.downloadSafeInfo.complianceInfo.actionBarType : j2.downloadSafeInfo.complianceInfo.materialJumpType : j2.downloadSafeInfo.complianceInfo.describeBarType;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private int d(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, c2015a)) == null) {
            Context a2 = c2015a.a();
            String aL = com.kwad.sdk.core.response.a.a.aL(this.f57362c);
            if (com.kwad.sdk.utils.f.a(a2, aL, this.f57361b)) {
                return 0;
            }
            if (com.kwad.sdk.utils.f.a(a2, aL, com.kwad.sdk.core.response.a.a.v(this.f57362c))) {
                com.kwad.sdk.core.report.a.k(this.f57361b);
                return 0;
            } else if (o()) {
                return 0;
            } else {
                if (!com.ksad.download.c.b.a(a2)) {
                    u.a(a2, v.a(a2));
                    return 0;
                } else if (c2015a.i()) {
                    return e(c2015a);
                } else {
                    if (f(c2015a)) {
                        return 0;
                    }
                    q();
                    return 1;
                }
            }
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, ksAppDownloadListener) == null) {
            AdInfo adInfo = this.f57362c;
            int i2 = adInfo.progress;
            int i3 = adInfo.status;
            if (i3 == 0) {
                ksAppDownloadListener.onIdle();
            } else if (i3 == 1) {
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof c) {
                    ((c) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            } else if (i3 == 2 || i3 == 3) {
                ksAppDownloadListener.onProgressUpdate(i2);
            } else if (i3 == 4) {
                if (ksAppDownloadListener instanceof c) {
                    ((c) ksAppDownloadListener).a(i2);
                }
            } else if (i3 == 7) {
                ksAppDownloadListener.onDownloadFailed();
            } else if (i3 == 8 || i3 == 9) {
                ksAppDownloadListener.onDownloadFinished();
            } else if (i3 != 12) {
            } else {
                ksAppDownloadListener.onInstalled();
            }
        }
    }

    private int e(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, c2015a)) == null) {
            int c2 = c(c2015a);
            if (c2 == 1) {
                com.kwad.sdk.core.download.kwai.b.a(c2015a.a(), c2015a.b(), null, this.f57368i, this.f57369j);
                return 0;
            } else if (c2 == 2) {
                a(c2015a.a(), c2015a.b());
                return 0;
            } else if (c2 == 3 || f(c2015a)) {
                return 0;
            } else {
                q();
                return 1;
            }
        }
        return invokeL.intValue;
    }

    private boolean f(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, c2015a)) == null) {
            String b2 = com.kwad.sdk.core.config.b.b();
            if (!URLUtil.isNetworkUrl(b2) || c2015a.f() || com.kwad.sdk.core.download.kwai.b.a() || this.f57362c.status == 4 || !b(c2015a)) {
                return false;
            }
            return com.kwad.sdk.core.download.kwai.b.a(c2015a.a(), this.f57361b, b2, this.f57368i, this.f57369j);
        }
        return invokeL.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT < 29) {
                if (this.f57361b.mIsFromContent && com.kwad.sdk.core.config.b.K()) {
                    z = p();
                    if (z) {
                        com.kwad.sdk.core.report.a.f(this.f57361b);
                    }
                } else if (!this.f57361b.mIsFromContent && com.kwad.sdk.core.config.b.au() && (z = p())) {
                    com.kwad.sdk.core.report.a.g(this.f57361b);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.a.post(new Runnable(this) { // from class: com.kwad.sdk.core.download.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayList<KsAppDownloadListener> arrayList = new ArrayList(this.a.f57370k.size());
                        arrayList.addAll(this.a.f57370k);
                        for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                            if (ksAppDownloadListener != null) {
                                this.a.d(ksAppDownloadListener);
                            }
                        }
                    }
                }
            });
        }
    }

    private void m() {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            String str = this.f57362c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return;
            }
            if (ag.a(context, str)) {
                this.f57362c.status = 12;
                return;
            }
            AdInfo adInfo = this.f57362c;
            if (adInfo.status == 12) {
                adInfo.status = 0;
                adInfo.progress = 0;
            }
            AdInfo adInfo2 = this.f57362c;
            if (adInfo2.status == 8) {
                String str2 = adInfo2.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    AdInfo adInfo3 = this.f57362c;
                    adInfo3.status = 0;
                    adInfo3.progress = 0;
                }
            }
            if (this.f57362c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
                return;
            }
            String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transform(this.f57362c));
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            AdInfo adInfo4 = this.f57362c;
            adInfo4.downloadFilePath = downloadFilePath;
            adInfo4.status = 8;
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            String str = this.f57362c.adConversionInfo.marketUrl;
            com.kwad.sdk.core.d.a.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
            boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.f.a(KsAdSDKImpl.get().getContext(), str, this.f57362c.adBaseInfo.appPackageName) : false;
            if (a2) {
                com.kwad.sdk.core.report.a.k(this.f57361b);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            a aVar = this.f57367h;
            if (aVar != null) {
                return aVar.a(new DialogInterface.OnClickListener(this) { // from class: com.kwad.sdk.core.download.a.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) && i2 == -1) {
                            switch (this.a.f57362c.status) {
                                case 0:
                                case 1:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    this.a.q();
                                    return;
                                case 2:
                                case 3:
                                case 10:
                                default:
                                    return;
                                case 8:
                                case 9:
                                case 11:
                                    this.a.h();
                                    return;
                                case 12:
                                    this.a.g();
                                    return;
                            }
                        }
                    }
                });
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (d.a(context, this.f57361b, 1) == 1) {
                return true;
            }
            boolean c2 = ag.c(context, com.kwad.sdk.core.response.a.a.v(this.f57362c));
            if (c2) {
                com.kwad.sdk.core.report.a.e(this.f57361b);
            }
            return c2;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        if (com.ksad.download.c.b.a(context)) {
            com.kwad.sdk.core.download.d.a(context, this.f57362c);
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void r() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        com.kwad.sdk.core.download.d.a(context, this.f57362c.downloadId);
    }

    public int a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, context, z)) == null) ? a(new a.C2015a(context).a(z).b(false).d(false)) : invokeLZ.intValue;
    }

    public int a(a.C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2015a)) == null) {
            this.f57365f = false;
            m();
            switch (this.f57362c.status) {
                case 0:
                case 1:
                case 5:
                case 6:
                case 7:
                    return d(c2015a);
                case 2:
                case 3:
                    if (c2015a.e() && this.f57366g) {
                        r();
                        return 0;
                    }
                    return 1;
                case 4:
                    q();
                    return 0;
                case 8:
                case 9:
                case 11:
                    h();
                    return 0;
                case 10:
                default:
                    return 0;
                case 12:
                    g();
                    return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57362c.downloadId : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f57361b.downloadSource = i2;
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onDismissListener) == null) {
            this.f57369j = onDismissListener;
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onShowListener) == null) {
            this.f57368i = onShowListener;
        }
    }

    @UiThread
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.sdk.core.download.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAppDownloadListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f57372b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksAppDownloadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57372b = this;
                    this.a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f57372b.f57370k.contains(this.a)) {
                        return;
                    }
                    this.f57372b.f57370k.add(0, this.a);
                }
            });
        } else if (!this.f57370k.contains(ksAppDownloadListener)) {
            this.f57370k.add(0, ksAppDownloadListener);
        }
        m();
        d(ksAppDownloadListener);
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f57367h = aVar;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, i3, i4) == null) && this.f57362c.downloadId.equals(str)) {
            AdInfo adInfo = this.f57362c;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, com.kwad.sdk.core.download.f fVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, str, i2, fVar) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f57361b);
            if (fVar.b()) {
                com.kwad.sdk.core.report.a.c(this.f57361b);
                fVar.a();
                z = k();
                com.kwad.sdk.core.download.e.a().b(j2, this.f57361b);
            } else {
                z = false;
            }
            i.a(new Runnable(this, z) { // from class: com.kwad.sdk.core.download.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f57371b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57371b = this;
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().b(this.f57371b.f57361b);
                        if (this.a) {
                            return;
                        }
                        com.kwad.sdk.home.download.a.a().c(this.f57371b.f57361b);
                    }
                }
            });
            com.kwad.sdk.core.a.a().d(j2.downloadId);
            this.f57362c.status = 12;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, String str2, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048586, this, str, i2, str2, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            this.f57362c.status = 7;
            l();
            if (fVar.b()) {
                a.C2025a c2025a = new a.C2025a(i2, str2);
                com.kwad.sdk.core.report.a.a(this.f57361b, c2025a);
                com.kwad.sdk.core.report.d.b(this.f57361b, this.f57362c.adConversionInfo.appDownloadUrl, c2025a.toJson().toString());
                fVar.a();
            }
            if (this.f57362c.adConversionInfo.retryH5TimeStep <= 0 || this.f57365f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f57364e;
            AdInfo adInfo = this.f57362c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f57361b);
            this.f57365f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            if (this.f57362c.status != 1) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.b(this.f57361b);
                    fVar.a();
                }
                this.f57364e = System.currentTimeMillis();
            }
            this.f57362c.status = 1;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, String str2, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            AdInfo adInfo = this.f57362c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.f57361b.mDownloadFinishReported) {
                i.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.home.download.a.a().a(this.a.f57361b);
                        }
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.a.e(this.f57361b, this.f57363d);
                    fVar.a();
                }
                com.kwad.sdk.core.download.e.a().a(this.f57362c, this.f57361b);
                this.f57361b.mDownloadFinishReported = true;
            }
            this.f57362c.status = 8;
            l();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57362c.adBaseInfo.appPackageName : (String) invokeV.objValue;
    }

    public void b(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f57370k.remove(ksAppDownloadListener);
        } else {
            this.a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.sdk.core.download.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAppDownloadListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f57373b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksAppDownloadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57373b = this;
                    this.a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57373b.f57370k.remove(this.a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            if (this.f57362c.status != 4 && fVar.b()) {
                com.kwad.sdk.core.report.a.c(this.f57361b, this.f57363d);
                fVar.a();
            }
            this.f57362c.status = 4;
            l();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            m();
            int i2 = this.f57362c.status;
            if (i2 == 3) {
                return 2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        m();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public void c(String str, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            if (this.f57362c.status != 2 && fVar.b()) {
                com.kwad.sdk.core.report.a.d(this.f57361b, this.f57363d);
                fVar.a();
            }
            this.f57362c.status = 2;
            l();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void d(String str, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            if (this.f57362c.status != 5 && fVar.b()) {
                com.kwad.sdk.core.report.a.f(this.f57361b, this.f57363d);
                fVar.a();
            }
            this.f57362c.status = 5;
            l();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            switch (this.f57362c.status) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    return n();
                case 2:
                case 3:
                case 10:
                default:
                    return false;
                case 8:
                case 9:
                case 11:
                    h();
                    return true;
                case 12:
                    g();
                    return true;
            }
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public AdTemplate e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f57361b : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public void e(String str, com.kwad.sdk.core.download.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, fVar) == null) && this.f57362c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.d(this.f57361b);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.f57362c.status == 0) {
                return n();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            i.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.a.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().d(this.a.f57361b);
                    }
                }
            });
            if (ag.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.v(this.f57362c))) {
                com.kwad.sdk.core.report.a.e(this.f57361b);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            String str = this.f57362c.downloadFilePath;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.report.a.h(this.f57361b);
                KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            j();
            DownloadStatusManager.a().a(this);
        }
    }

    public void j() {
        List<KsAppDownloadListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (list = this.f57370k) == null) {
            return;
        }
        list.clear();
    }
}
