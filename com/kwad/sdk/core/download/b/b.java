package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.download.g;
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.kwad.sdk.core.download.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f64478a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f64479b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f64480c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64481d;

    /* renamed from: e  reason: collision with root package name */
    public long f64482e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64484g;

    /* renamed from: h  reason: collision with root package name */
    public a f64485h;

    /* renamed from: i  reason: collision with root package name */
    public DialogInterface.OnShowListener f64486i;
    public DialogInterface.OnDismissListener j;
    public List<KsAppDownloadListener> k;

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
    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, jSONObject};
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
    }

    public b(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, jSONObject, ksAppDownloadListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f64478a = new Handler(Looper.getMainLooper());
        this.k = new ArrayList();
        this.f64479b = adTemplate;
        this.f64480c = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f64481d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f64479b);
        DownloadStatusManager.a().a(this.f64479b);
        this.f64484g = com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.c.i(this.f64479b));
    }

    private int b(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, context, z)) == null) {
            String str = this.f64480c.adConversionInfo.marketUrl;
            if (!TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f64480c.adBaseInfo.appPackageName) : false) {
                com.kwad.sdk.core.report.a.k(this.f64479b);
                return 0;
            } else if (!com.ksad.download.d.b.a(context)) {
                r.a(context, s.a(context));
                return 0;
            } else if (c(context, z)) {
                return 0;
            } else {
                n();
                return 1;
            }
        }
        return invokeLZ.intValue;
    }

    private boolean c(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, this, context, z)) == null) {
            if (context == null) {
                return false;
            }
            if (l()) {
                return true;
            }
            if (!com.kwad.sdk.core.config.c.W() || an.a(this.f64480c.downloadSafeInfo.autoDownloadUrl)) {
                if (com.kwad.sdk.core.download.a.b.a() || this.f64480c.status == 4 || !com.kwad.sdk.core.download.a.b.a(context, this.f64479b) || z) {
                    return false;
                }
                return com.kwad.sdk.core.download.a.b.a(context, this.f64479b, null, this.f64486i, this.j);
            } else if (this.f64480c.status == 4 || !com.kwad.sdk.core.response.b.c.b(this.f64479b) || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                return false;
            } else {
                AdLandPageActivityProxy.launch(context, this.f64479b, this.f64480c.downloadSafeInfo.autoDownloadUrl);
                return true;
            }
        }
        return invokeLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, ksAppDownloadListener) == null) {
            AdInfo adInfo = this.f64480c;
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

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT < 29) {
                if (this.f64479b.mIsFromContent && com.kwad.sdk.core.config.c.I()) {
                    z = m();
                    if (z) {
                        com.kwad.sdk.core.report.a.f(this.f64479b);
                    }
                } else if (!this.f64479b.mIsFromContent && com.kwad.sdk.core.config.c.am() && (z = m())) {
                    com.kwad.sdk.core.report.a.g(this.f64479b);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f64478a.post(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f64490a;

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
                    this.f64490a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayList<KsAppDownloadListener> arrayList = new ArrayList(this.f64490a.k.size());
                        arrayList.addAll(this.f64490a.k);
                        for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                            if (ksAppDownloadListener != null) {
                                this.f64490a.d(ksAppDownloadListener);
                            }
                        }
                    }
                }
            });
        }
    }

    private void j() {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            String str = this.f64480c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return;
            }
            if (ac.a(context, str)) {
                this.f64480c.status = 12;
                return;
            }
            AdInfo adInfo = this.f64480c;
            if (adInfo.status == 12) {
                adInfo.status = 0;
                adInfo.progress = 0;
            }
            AdInfo adInfo2 = this.f64480c;
            if (adInfo2.status == 8) {
                String str2 = adInfo2.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    AdInfo adInfo3 = this.f64480c;
                    adInfo3.status = 0;
                    adInfo3.progress = 0;
                }
            }
            if (this.f64480c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
                return;
            }
            String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.f64480c));
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            AdInfo adInfo4 = this.f64480c;
            adInfo4.downloadFilePath = downloadFilePath;
            adInfo4.status = 8;
        }
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            String str = this.f64480c.adConversionInfo.marketUrl;
            com.kwad.sdk.core.d.a.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
            boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f64480c.adBaseInfo.appPackageName) : false;
            if (a2) {
                com.kwad.sdk.core.report.a.k(this.f64479b);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            a aVar = this.f64485h;
            if (aVar != null) {
                return aVar.a(new DialogInterface.OnClickListener(this) { // from class: com.kwad.sdk.core.download.b.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64491a;

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
                        this.f64491a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) && i2 == -1) {
                            switch (this.f64491a.f64480c.status) {
                                case 0:
                                case 1:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    this.f64491a.n();
                                    return;
                                case 2:
                                case 3:
                                case 10:
                                default:
                                    return;
                                case 8:
                                case 9:
                                case 11:
                                    this.f64491a.e();
                                    return;
                                case 12:
                                    this.f64491a.d();
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

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            String q = com.kwad.sdk.core.response.b.a.q(this.f64480c);
            Context context = KsAdSDKImpl.get().getContext();
            com.kwad.sdk.core.d.a.a("ApkDownloadHelper", "run forceOpenApp appContext:" + context + "--appPkgName:" + q);
            if (d.a(context, this.f64479b, 1) == 1) {
                return true;
            }
            if (context == null || TextUtils.isEmpty(q)) {
                com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "forceOpenApp fail appContext:" + context + "--appPkgName:" + q);
                return false;
            }
            return ac.c(context, q);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        if (com.ksad.download.d.b.a(context)) {
            com.kwad.sdk.core.download.e.a(context, this.f64480c);
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void o() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        com.kwad.sdk.core.download.e.a(context, this.f64480c.downloadId);
    }

    public int a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, context, z)) == null) ? a(context, z, false) : invokeLZ.intValue;
    }

    public int a(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.f64483f = false;
            j();
            switch (this.f64480c.status) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    return b(context, z2);
                case 2:
                case 3:
                    if (z && this.f64484g) {
                        o();
                        return 0;
                    }
                    return 1;
                case 8:
                case 9:
                case 11:
                    e();
                    return 0;
                case 10:
                default:
                    return 0;
                case 12:
                    d();
                    return 0;
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.kwad.sdk.core.download.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64480c.downloadId : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f64479b.downloadSource = i2;
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onDismissListener) == null) {
            this.j = onDismissListener;
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onShowListener) == null) {
            this.f64486i = onShowListener;
        }
    }

    @UiThread
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f64478a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.sdk.core.download.b.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAppDownloadListener f64493a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f64494b;

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
                    this.f64494b = this;
                    this.f64493a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f64494b.k.contains(this.f64493a)) {
                        return;
                    }
                    this.f64494b.k.add(0, this.f64493a);
                }
            });
        } else if (!this.k.contains(ksAppDownloadListener)) {
            this.k.add(0, ksAppDownloadListener);
        }
        j();
        d(ksAppDownloadListener);
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f64485h = aVar;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f64480c.status = 10;
            i();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048585, this, str, i2, i3, i4) == null) && this.f64480c.downloadId.equals(str)) {
            AdInfo adInfo = this.f64480c;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            i();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, g gVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, str, i2, gVar) == null) {
            AdInfo i3 = com.kwad.sdk.core.response.b.c.i(this.f64479b);
            if (gVar.b()) {
                com.kwad.sdk.core.report.a.c(this.f64479b);
                gVar.a();
                z = h();
                f.a().b(i3, this.f64479b);
            } else {
                z = false;
            }
            com.kwad.sdk.utils.g.a(new Runnable(this, z) { // from class: com.kwad.sdk.core.download.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f64488a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f64489b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64489b = this;
                    this.f64488a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().b(this.f64489b.f64479b);
                        if (this.f64488a) {
                            return;
                        }
                        com.kwad.sdk.home.download.a.a().c(this.f64489b.f64479b);
                    }
                }
            });
            com.kwad.sdk.core.a.a().d(i3.downloadId);
            this.f64480c.status = 12;
            i();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, String str2, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048587, this, str, i2, str2, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            this.f64480c.status = 7;
            i();
            if (gVar.b()) {
                a.C1910a c1910a = new a.C1910a(i2, str2);
                com.kwad.sdk.core.report.a.a(this.f64479b, c1910a);
                com.kwad.sdk.core.report.d.b(this.f64479b, this.f64480c.adConversionInfo.appDownloadUrl, c1910a.toJson().toString());
                gVar.a();
            }
            if (this.f64480c.adConversionInfo.retryH5TimeStep <= 0 || this.f64483f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f64482e;
            AdInfo adInfo = this.f64480c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.y(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f64479b);
            this.f64483f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            if (this.f64480c.status != 1) {
                if (gVar.b()) {
                    com.kwad.sdk.core.report.a.b(this.f64479b);
                    gVar.a();
                }
                this.f64482e = System.currentTimeMillis();
            }
            this.f64480c.status = 1;
            i();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, String str2, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            AdInfo adInfo = this.f64480c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.f64479b.mDownloadFinishReported) {
                com.kwad.sdk.utils.g.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64487a;

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
                        this.f64487a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.home.download.a.a().a(this.f64487a.f64479b);
                        }
                    }
                });
                if (gVar.b()) {
                    com.kwad.sdk.core.report.a.e(this.f64479b, this.f64481d);
                    gVar.a();
                }
                f.a().a(this.f64480c, this.f64479b);
                this.f64479b.mDownloadFinishReported = true;
            }
            this.f64480c.status = 8;
            i();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f64480c.adBaseInfo.appPackageName : (String) invokeV.objValue;
    }

    public void b(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.k.remove(ksAppDownloadListener);
        } else {
            this.f64478a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.sdk.core.download.b.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAppDownloadListener f64495a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f64496b;

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
                    this.f64496b = this;
                    this.f64495a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64496b.k.remove(this.f64495a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && this.f64480c.downloadId.equals(str)) {
            this.f64480c.status = 11;
            i();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            if (this.f64480c.status != 4 && gVar.b()) {
                com.kwad.sdk.core.report.a.c(this.f64479b, this.f64481d);
                gVar.a();
            }
            this.f64480c.status = 4;
            i();
        }
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        j();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void c(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            if (this.f64480c.status != 2 && gVar.b()) {
                com.kwad.sdk.core.report.a.d(this.f64479b, this.f64481d);
                gVar.a();
            }
            this.f64480c.status = 2;
            i();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            switch (this.f64480c.status) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    return k();
                case 2:
                case 3:
                case 10:
                default:
                    return false;
                case 8:
                case 9:
                case 11:
                    e();
                    return true;
                case 12:
                    d();
                    return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String str = this.f64480c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.utils.g.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64492a;

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
                        this.f64492a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.home.download.a.a().d(this.f64492a.f64479b);
                        }
                    }
                });
                com.kwad.sdk.core.report.a.e(this.f64479b);
                ac.c(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--appPkgName:" + str);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void d(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            if (this.f64480c.status != 5 && gVar.b()) {
                com.kwad.sdk.core.report.a.f(this.f64479b, this.f64481d);
                gVar.a();
            }
            this.f64480c.status = 5;
            i();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            String str = this.f64480c.downloadFilePath;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.report.a.h(this.f64479b);
                KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void e(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            if (gVar.b()) {
                com.kwad.sdk.core.report.a.h(this.f64479b);
                gVar.a();
            }
            this.f64480c.status = 9;
            i();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            g();
            DownloadStatusManager.a().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void f(String str, g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, str, gVar) == null) && this.f64480c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.d(this.f64479b);
        }
    }

    public void g() {
        List<KsAppDownloadListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (list = this.k) == null) {
            return;
        }
        list.clear();
    }
}
