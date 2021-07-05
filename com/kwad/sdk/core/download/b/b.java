package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.download.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f36056a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f36057b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36058c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f36059d;

    /* renamed from: e  reason: collision with root package name */
    public long f36060e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36061f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36062g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36063h;

    /* renamed from: i  reason: collision with root package name */
    public HashSet<KsAppDownloadListener> f36064i;

    /* renamed from: com.kwad.sdk.core.download.b.b$5  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36069a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(595524615, "Lcom/kwad/sdk/core/download/b/b$5;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(595524615, "Lcom/kwad/sdk/core/download/b/b$5;");
                    return;
                }
            }
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f36069a = iArr;
            try {
                iArr[DOWNLOADSTAUS.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36069a[DOWNLOADSTAUS.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36069a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36069a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36069a[DOWNLOADSTAUS.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36069a[DOWNLOADSTAUS.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36069a[DOWNLOADSTAUS.FINISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36069a[DOWNLOADSTAUS.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36069a[DOWNLOADSTAUS.INSTALL_FINSHED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36069a[DOWNLOADSTAUS.INSTALL_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36069a[DOWNLOADSTAUS.CANCELLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36069a[DOWNLOADSTAUS.DELETED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
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
        this.f36056a = new Handler(Looper.getMainLooper());
        this.f36064i = new HashSet<>();
        this.f36057b = adTemplate;
        this.f36058c = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36059d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        DownloadStatusManager.a().a(this, this.f36057b);
        DownloadStatusManager.a().a(this.f36057b);
        this.f36063h = com.kwad.sdk.core.response.b.c.j(this.f36057b).downloadSafeInfo.downloadPauseEnable;
    }

    public static void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, bVar, z) == null) || bVar == null) {
            return;
        }
        bVar.a(z);
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            this.f36062g = z;
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            String str = this.f36058c.adConversionInfo.marketUrl;
            com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "Market URL Schema=" + str);
            if (!TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f36058c.adBaseInfo.appPackageName) : false) {
                com.kwad.sdk.core.report.b.j(this.f36057b);
            } else if (c(context)) {
            } else {
                j();
            }
        }
    }

    private boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, context)) == null) {
            if (context == null || com.kwad.sdk.core.download.a.b.a() || this.f36058c.status == DOWNLOADSTAUS.PAUSED || !com.kwad.sdk.core.download.a.b.b(context, this.f36057b)) {
                return false;
            }
            return com.kwad.sdk.core.download.a.b.a(context, this.f36057b);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, ksAppDownloadListener) == null) {
            AdInfo adInfo = this.f36058c;
            int i2 = adInfo.progress;
            switch (AnonymousClass5.f36069a[adInfo.status.ordinal()]) {
                case 1:
                    ksAppDownloadListener.onIdle();
                    return;
                case 2:
                    ksAppDownloadListener.onProgressUpdate(0);
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.b(th);
                        return;
                    }
                case 3:
                case 4:
                    ksAppDownloadListener.onProgressUpdate(i2);
                    return;
                case 5:
                    if (ksAppDownloadListener instanceof c) {
                        ((c) ksAppDownloadListener).a(i2);
                        return;
                    }
                    return;
                case 6:
                    ksAppDownloadListener.onDownloadFailed();
                    return;
                case 7:
                case 8:
                    ksAppDownloadListener.onDownloadFinished();
                    return;
                case 9:
                    ksAppDownloadListener.onInstalled();
                    return;
                default:
                    return;
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f36056a.post(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36067a;

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
                    this.f36067a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f36067a.f36064i.iterator();
                        while (it.hasNext()) {
                            KsAppDownloadListener ksAppDownloadListener = (KsAppDownloadListener) it.next();
                            if (ksAppDownloadListener != null) {
                                this.f36067a.d(ksAppDownloadListener);
                            }
                        }
                    }
                }
            });
        }
    }

    private void h() {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            String str = this.f36058c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return;
            }
            if (y.a(context, str)) {
                this.f36058c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
                return;
            }
            AdInfo adInfo = this.f36058c;
            if (adInfo.status == DOWNLOADSTAUS.INSTALL_FINSHED) {
                adInfo.status = DOWNLOADSTAUS.UNKNOWN;
                adInfo.progress = 0;
            }
            AdInfo adInfo2 = this.f36058c;
            if (adInfo2.status == DOWNLOADSTAUS.FINISHED) {
                String str2 = adInfo2.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    AdInfo adInfo3 = this.f36058c;
                    adInfo3.status = DOWNLOADSTAUS.UNKNOWN;
                    adInfo3.progress = 0;
                }
            }
            if (this.f36058c.status != DOWNLOADSTAUS.UNKNOWN || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
                return;
            }
            String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transfrom(this.f36058c));
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            AdInfo adInfo4 = this.f36058c;
            adInfo4.downloadFilePath = downloadFilePath;
            adInfo4.status = DOWNLOADSTAUS.FINISHED;
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            String str = this.f36058c.adConversionInfo.marketUrl;
            com.kwad.sdk.core.d.a.b("ApkDownloadHelper", "isMarKet URL Schema=" + str);
            boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.e.a(KsAdSDKImpl.get().getContext(), str, this.f36058c.adBaseInfo.appPackageName) : false;
            if (a2) {
                com.kwad.sdk.core.report.b.j(this.f36057b);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        if (com.ksad.download.d.b.a(context)) {
            com.kwad.sdk.core.download.e.a(context, this.f36058c);
        } else {
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "no network while download app");
        }
    }

    private void k() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        com.kwad.sdk.core.download.e.a(context, this.f36058c.downloadId);
    }

    @Override // com.kwad.sdk.core.download.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36058c.downloadId : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f36057b.downloadSource = i2;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f36061f = false;
            h();
            switch (AnonymousClass5.f36069a[this.f36058c.status.ordinal()]) {
                case 1:
                case 2:
                case 5:
                case 6:
                case 11:
                case 12:
                    b(context);
                    break;
                case 3:
                case 4:
                    if (this.f36062g && this.f36063h) {
                        k();
                        break;
                    }
                    break;
                case 7:
                case 8:
                case 10:
                    e();
                    break;
                case 9:
                    d();
                    break;
            }
            this.f36062g = false;
        }
    }

    @UiThread
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        this.f36064i.add(ksAppDownloadListener);
        h();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f36058c.status = DOWNLOADSTAUS.INSTALLING;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048581, this, str, i2, i3, i4) == null) && this.f36058c.downloadId.equals(str)) {
            AdInfo adInfo = this.f36058c;
            adInfo.status = DOWNLOADSTAUS.PROGRESS;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, fVar) == null) {
            if (fVar.b()) {
                com.kwad.sdk.core.report.b.d(this.f36057b);
                fVar.a();
            }
            com.kwad.sdk.utils.f.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36066a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36066a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().b(this.f36066a.f36057b);
                        com.kwad.sdk.home.download.a.a().c(this.f36066a.f36057b);
                    }
                }
            });
            com.kwad.sdk.core.a.a().d(com.kwad.sdk.core.response.b.c.j(this.f36057b).downloadId);
            this.f36058c.status = DOWNLOADSTAUS.INSTALL_FINSHED;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, int i2, String str2, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, str2, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            this.f36058c.status = DOWNLOADSTAUS.FAILED;
            g();
            if (fVar.b()) {
                b.a aVar = new b.a(i2, str2);
                com.kwad.sdk.core.report.b.a(this.f36057b, aVar);
                com.kwad.sdk.core.report.e.d(this.f36057b, this.f36058c.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                fVar.a();
            }
            if (this.f36058c.adConversionInfo.retryH5TimeStep <= 0 || this.f36061f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f36060e;
            AdInfo adInfo = this.f36058c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.B(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.f36057b);
            this.f36061f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            if (this.f36058c.status != DOWNLOADSTAUS.START) {
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.b(this.f36057b);
                    fVar.a();
                }
                this.f36060e = System.currentTimeMillis();
            }
            this.f36058c.status = DOWNLOADSTAUS.START;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void a(String str, String str2, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            AdInfo adInfo = this.f36058c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != DOWNLOADSTAUS.FINISHED && !this.f36057b.mDownloadFinishReported) {
                com.kwad.sdk.utils.f.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f36065a;

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
                        this.f36065a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.home.download.a.a().a(this.f36065a.f36057b);
                        }
                    }
                });
                if (fVar.b()) {
                    com.kwad.sdk.core.report.b.e(this.f36057b, this.f36059d);
                    fVar.a();
                }
                this.f36057b.mDownloadFinishReported = true;
            }
            this.f36058c.status = DOWNLOADSTAUS.FINISHED;
            g();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f36058c.adBaseInfo.appPackageName : (String) invokeV.objValue;
    }

    public void b(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        this.f36064i.remove(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && this.f36058c.downloadId.equals(str)) {
            this.f36058c.status = DOWNLOADSTAUS.INSTALL_FAILED;
            g();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            if (this.f36058c.status != DOWNLOADSTAUS.PAUSED && fVar.b()) {
                com.kwad.sdk.core.report.b.c(this.f36057b, this.f36059d);
                fVar.a();
            }
            this.f36058c.status = DOWNLOADSTAUS.PAUSED;
            g();
        }
    }

    public void c(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        h();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public void c(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            if (this.f36058c.status != DOWNLOADSTAUS.DOWNLOADING && fVar.b()) {
                com.kwad.sdk.core.report.b.d(this.f36057b, this.f36059d);
                fVar.a();
            }
            this.f36058c.status = DOWNLOADSTAUS.DOWNLOADING;
            g();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i2 = AnonymousClass5.f36069a[this.f36058c.status.ordinal()];
            if (i2 != 1 && i2 != 2) {
                switch (i2) {
                    case 5:
                    case 6:
                    case 11:
                    case 12:
                        break;
                    case 7:
                    case 8:
                    case 10:
                        e();
                        return true;
                    case 9:
                        d();
                        return true;
                    default:
                        return false;
                }
            }
            return i();
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = this.f36058c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.utils.f.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.b.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f36068a;

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
                        this.f36068a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.home.download.a.a().d(this.f36068a.f36057b);
                        }
                    }
                });
                com.kwad.sdk.core.report.b.f(this.f36057b);
                y.b(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--appPkgName:" + str);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void d(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            if (this.f36058c.status != DOWNLOADSTAUS.CANCELLED && fVar.b()) {
                com.kwad.sdk.core.report.b.f(this.f36057b, this.f36059d);
                fVar.a();
            }
            this.f36058c.status = DOWNLOADSTAUS.CANCELLED;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String str = this.f36058c.downloadFilePath;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.report.b.g(this.f36057b);
                KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.d("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void e(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            if (fVar.b()) {
                com.kwad.sdk.core.report.b.g(this.f36057b);
                fVar.a();
            }
            this.f36058c.status = DOWNLOADSTAUS.INSTALL;
            g();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            HashSet<KsAppDownloadListener> hashSet = this.f36064i;
            if (hashSet != null) {
                hashSet.clear();
            }
            DownloadStatusManager.a().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public void f(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, fVar) == null) && this.f36058c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.b.e(this.f36057b);
        }
    }
}
