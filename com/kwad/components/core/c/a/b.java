package com.kwad.components.core.c.a;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.download.h;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements NetworkMonitor.a, f, com.kwad.sdk.core.webview.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    @NonNull
    public AdTemplate b;
    @NonNull
    public AdInfo c;
    public JSONObject d;
    public long e;
    public boolean f;
    public boolean g;
    public a h;
    public DialogInterface.OnShowListener i;
    public DialogInterface.OnDismissListener j;
    public List<KsAppDownloadListener> k;

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this(adTemplate, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, ksAppDownloadListener, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (JSONObject) objArr2[1], (KsAppDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        AdInfo adInfo = this.c;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = z.a(str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.k = new ArrayList();
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.i(adTemplate);
        this.d = jSONObject;
        if (ksAppDownloadListener != null) {
            a(ksAppDownloadListener);
        }
        k();
        e.a().a(this, this.b);
        e.a().a(this.b);
        this.g = com.kwad.sdk.core.response.a.a.aR(com.kwad.sdk.core.response.a.d.i(this.b));
        if (com.kwad.sdk.core.config.d.V()) {
            NetworkMonitor.a().a(KsAdSDKImpl.get().getContext(), this);
        }
        com.kwad.sdk.kwai.kwai.b.a().a(this.b);
    }

    public static void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, context, adTemplate) == null) || context == null || adTemplate == null) {
            return;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
    }

    public static int b(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c0507a)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(c0507a.b());
            if (i.downloadSafeInfo.complianceInfo != null) {
                int h = c0507a.h();
                return h != 2 ? h != 3 ? i.downloadSafeInfo.complianceInfo.actionBarType : i.downloadSafeInfo.complianceInfo.materialJumpType : i.downloadSafeInfo.complianceInfo.describeBarType;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private int c(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, c0507a)) == null) {
            Context a2 = c0507a.a();
            String be = com.kwad.sdk.core.response.a.a.be(this.c);
            if (com.kwad.sdk.utils.d.a(a2, be, this.b)) {
                com.kwad.sdk.core.report.a.f(this.b, 1);
                return 0;
            } else if (com.kwad.sdk.utils.d.a(a2, be, com.kwad.sdk.core.response.a.a.C(this.c))) {
                com.kwad.sdk.core.report.a.f(this.b, 0);
                return 0;
            } else if (p()) {
                return 0;
            } else {
                if (!ac.b(a2)) {
                    t.a(a2, u.b(a2));
                    return 0;
                } else if (c0507a.o() && com.kwad.sdk.core.config.d.o()) {
                    return d(c0507a);
                } else {
                    if (c0507a.k()) {
                        return e(c0507a);
                    }
                    if (f(c0507a)) {
                        return 0;
                    }
                    r();
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    private int d(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, c0507a)) == null) {
            Context a2 = c0507a.a();
            AdTemplate b = c0507a.b();
            int p = c0507a.p();
            if (p == 1) {
                r();
                return 0;
            }
            if (p == 2 && com.kwad.sdk.core.response.a.b.x(b)) {
                com.kwad.components.core.c.kwai.b.a(new b.a().a(a2).a(b).a(com.kwad.sdk.core.response.a.b.w(b)).a(this.i).a(this.j).a());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, ksAppDownloadListener) == null) {
            AdInfo adInfo = this.c;
            int i = adInfo.progress;
            int i2 = adInfo.status;
            if (i2 == 0) {
                ksAppDownloadListener.onIdle();
            } else if (i2 == 1) {
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                    ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                }
            } else if (i2 == 2 || i2 == 3) {
                ksAppDownloadListener.onProgressUpdate(i);
            } else if (i2 == 4) {
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                    ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).a(i);
                }
            } else if (i2 == 7) {
                ksAppDownloadListener.onDownloadFailed();
            } else if (i2 == 8 || i2 == 9) {
                ksAppDownloadListener.onDownloadFinished();
            } else if (i2 != 12) {
            } else {
                ksAppDownloadListener.onInstalled();
            }
        }
    }

    private int e(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, c0507a)) == null) {
            Context a2 = c0507a.a();
            AdTemplate b = c0507a.b();
            int b2 = b(c0507a);
            if (b2 == 1) {
                if (com.kwad.sdk.core.response.a.b.x(b)) {
                    com.kwad.components.core.c.kwai.b.a(new b.a().a(a2).a(b).a(com.kwad.sdk.core.response.a.b.w(b)).a(this.i).a(this.j).a());
                }
                return 0;
            } else if (b2 == 2) {
                a(c0507a.a(), c0507a.b());
                return 0;
            } else if (b2 == 3 || f(c0507a)) {
                return 0;
            } else {
                r();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    private boolean f(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, c0507a)) == null) {
            if (c0507a.g() || this.c.status == 4 || !com.kwad.sdk.core.response.a.b.z(this.b) || !g(c0507a)) {
                return false;
            }
            return com.kwad.components.core.c.kwai.b.a(new b.a().a(c0507a.a()).a(this.b).a(com.kwad.sdk.core.response.a.b.y(this.b)).a(this.i).a(this.j).a());
        }
        return invokeL.booleanValue;
    }

    public static boolean g(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, c0507a)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(c0507a.b());
            if (com.kwad.sdk.core.response.a.a.ag(i) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0507a.b().isWebViewDownload)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.ah(i) && !ac.c(c0507a.a());
        }
        return invokeL.booleanValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            e.a();
            int a2 = e.a(b());
            if (a2 != 0) {
                this.c.status = a2;
            }
            n();
            m();
        }
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                if (this.b.mIsFromContent && com.kwad.sdk.core.config.d.a()) {
                    r1 = q();
                    if (r1) {
                        com.kwad.sdk.core.report.a.f(this.b);
                    }
                } else if (!this.b.mIsFromContent && com.kwad.sdk.core.config.d.E()) {
                    boolean a2 = com.kwad.components.core.f.b.a(KsAdSDKImpl.get().getContext());
                    com.kwad.sdk.core.d.b.a("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + a2);
                    r1 = a2 ? q() : false;
                    if (r1) {
                        com.kwad.sdk.core.report.a.g(this.b);
                    }
                }
            }
            return r1;
        }
        return invokeV.booleanValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.a.post(new Runnable(this) { // from class: com.kwad.components.core.c.a.b.3
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayList<KsAppDownloadListener> arrayList = new ArrayList(this.a.k.size());
                        arrayList.addAll(this.a.k);
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

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            String str = this.c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return;
            }
            if (af.a(context, str)) {
                this.c.status = 12;
                return;
            }
            AdInfo adInfo = this.c;
            if (adInfo.status == 12) {
                adInfo.status = 0;
                adInfo.progress = 0;
            }
            int i = this.c.status;
            if (i == 8 || i == 9) {
                String str2 = this.c.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    AdInfo adInfo2 = this.c;
                    adInfo2.status = 0;
                    adInfo2.progress = 0;
                }
            }
            AdInfo adInfo3 = this.c;
            if (adInfo3.status == 0) {
                String a2 = com.kwad.sdk.core.download.a.a(adInfo3);
                if (TextUtils.isEmpty(a2) || !new File(a2).exists()) {
                    return;
                }
                AdInfo adInfo4 = this.c;
                adInfo4.downloadFilePath = a2;
                adInfo4.status = 8;
            }
        }
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            String str = this.c.adConversionInfo.marketUrl;
            com.kwad.sdk.core.d.b.c("ApkDownloadHelper", "isMarKet URL Schema=" + str);
            boolean a2 = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.d.a(KsAdSDKImpl.get().getContext(), str, this.c.adBaseInfo.appPackageName) : false;
            if (a2) {
                com.kwad.sdk.core.report.a.f(this.b, 0);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            a aVar = this.h;
            if (aVar != null) {
                return aVar.a(new DialogInterface.OnClickListener(this) { // from class: com.kwad.components.core.c.a.b.4
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) && i == -1) {
                            switch (this.a.c.status) {
                                case 0:
                                case 1:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    this.a.r();
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

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (c.a(new a.C0507a(context).a(this.b), 1) == 1) {
                return true;
            }
            boolean c = af.c(context, com.kwad.sdk.core.response.a.a.C(this.c));
            if (c) {
                com.kwad.sdk.core.report.a.e(this.b);
            }
            return c;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            com.kwad.sdk.core.download.a.b(this.c);
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n();
            int i = this.c.status;
            if (i == 3) {
                return 2;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final int a(a.C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0507a)) == null) {
            this.f = false;
            n();
            switch (this.c.status) {
                case 0:
                case 1:
                case 5:
                case 6:
                case 7:
                    return c(c0507a);
                case 2:
                case 3:
                    if (c0507a.e() && this.g) {
                        com.kwad.sdk.core.download.a.a(this.c.downloadId);
                        return 0;
                    }
                    return 0;
                case 4:
                    r();
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

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b.downloadSource = i;
        }
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.j = onDismissListener;
        }
    }

    public final void a(DialogInterface.OnShowListener onShowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onShowListener) == null) {
            this.i = onShowListener;
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.h = aVar;
        }
    }

    @UiThread
    public final void a(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.components.core.c.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAppDownloadListener a;
                public final /* synthetic */ b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksAppDownloadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.k.contains(this.a)) {
                        return;
                    }
                    this.b.k.add(0, this.a);
                }
            });
        } else if (!this.k.contains(ksAppDownloadListener)) {
            this.k.add(0, ksAppDownloadListener);
        }
        n();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, networkState) == null) && this.c.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            r();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.c.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.d(this.b);
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048585, this, str, i, i2, i3) == null) && this.c.downloadId.equals(str)) {
            AdInfo adInfo = this.c;
            adInfo.status = 3;
            adInfo.progress = i;
            adInfo.soFarBytes = i2;
            adInfo.totalBytes = i3;
            m();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, h hVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, str, i, hVar) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(this.b);
            if (hVar.b()) {
                com.kwad.sdk.core.report.a.c(this.b);
                hVar.a();
                z = l();
                com.kwad.sdk.kwai.kwai.b.a().d(this.b);
                com.kwad.sdk.kwai.kwai.b.a().b(this.b);
            } else {
                z = false;
            }
            g.a(new Runnable(this, z) { // from class: com.kwad.components.core.c.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ b b;

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
                    this.b = this;
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                    }
                }
            });
            com.kwad.sdk.core.a.a().d(i2.downloadId);
            this.c.status = 12;
            m();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, String str2, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048587, this, str, i, str2, hVar) == null) && this.c.downloadId.equals(str)) {
            this.c.status = 7;
            m();
            if (hVar.b()) {
                a.C0544a c0544a = new a.C0544a(i, str2);
                com.kwad.sdk.core.report.a.a(this.b, c0544a);
                com.kwad.components.core.i.a.a().b(this.b, this.c.adConversionInfo.appDownloadUrl, c0544a.toJson().toString());
                hVar.a();
            }
            if (this.c.adConversionInfo.retryH5TimeStep <= 0 || this.f) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.e;
            AdInfo adInfo = this.c;
            if (currentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.N(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.b);
            this.f = true;
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, hVar) == null) && this.c.downloadId.equals(str)) {
            if (this.c.status != 1) {
                if (hVar.b()) {
                    com.kwad.sdk.core.report.a.b(this.b);
                    hVar.a();
                }
                this.e = System.currentTimeMillis();
            }
            this.c.status = 1;
            m();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, String str2, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, hVar) == null) && this.c.downloadId.equals(str)) {
            AdInfo adInfo = this.c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.b.mDownloadFinishReported) {
                g.a(new Runnable(this) { // from class: com.kwad.components.core.c.a.b.1
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                        }
                    }
                });
                if (hVar.b()) {
                    com.kwad.sdk.core.report.a.d(this.b, this.d);
                    hVar.a();
                }
                com.kwad.sdk.kwai.kwai.b.a().c(this.b);
                com.kwad.sdk.kwai.kwai.b.a().a(this.b);
                this.b.mDownloadFinishReported = true;
            }
            this.c.status = 8;
            m();
            ApkCacheManager.a().b();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c.downloadId : (String) invokeV.objValue;
    }

    public final void b(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.k.remove(ksAppDownloadListener);
        } else {
            this.a.post(new Runnable(this, ksAppDownloadListener) { // from class: com.kwad.components.core.c.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAppDownloadListener a;
                public final /* synthetic */ b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksAppDownloadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = ksAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.k.remove(this.a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void b(String str, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, hVar) == null) && this.c.downloadId.equals(str)) {
            if (this.c.status != 4 && hVar.b()) {
                com.kwad.sdk.core.report.a.b(this.b, this.d);
                hVar.a();
            }
            this.c.status = 4;
            m();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.c.adBaseInfo.appPackageName : (String) invokeV.objValue;
    }

    public final void c(KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ksAppDownloadListener) == null) || ksAppDownloadListener == null) {
            return;
        }
        n();
        d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.f
    public final void c(String str, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, hVar) == null) && this.c.downloadId.equals(str)) {
            if (this.c.status != 2 && hVar.b()) {
                com.kwad.sdk.core.report.a.c(this.b, this.d);
                hVar.a();
            }
            this.c.status = 2;
            m();
        }
    }

    @Override // com.kwad.sdk.core.download.f
    public final void d(String str, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, str, hVar) == null) && this.c.downloadId.equals(str)) {
            if (this.c.status != 5 && hVar.b()) {
                com.kwad.sdk.core.report.a.e(this.b, this.d);
                hVar.a();
            }
            this.c.status = 5;
            m();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            switch (this.c.status) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    return o();
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
    public final AdTemplate e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.b : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.download.f
    public final void e(String str, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, str, hVar) == null) && this.c.downloadId.equals(str)) {
            if (hVar.b()) {
                com.kwad.sdk.core.report.a.b(this.b, 2);
                hVar.a();
            }
            this.c.status = 9;
            m();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.c.status == 0) {
                return o();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            g.a(new Runnable(this) { // from class: com.kwad.components.core.c.a.b.5
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                    }
                }
            });
            if (af.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.C(this.c))) {
                com.kwad.sdk.core.report.a.e(this.b);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && af.d(KsAdSDKImpl.get().getContext(), this.c.downloadFilePath)) {
            com.kwad.sdk.core.report.a.b(this.b, 1);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            j();
            e.a().a(this);
            if (com.kwad.sdk.core.config.d.V()) {
                NetworkMonitor.a().a(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void j() {
        List<KsAppDownloadListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (list = this.k) == null) {
            return;
        }
        list.clear();
    }
}
