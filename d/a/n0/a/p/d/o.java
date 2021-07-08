package d.a.n0.a.p.d;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface o {

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46606a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1384107377, "Ld/a/n0/a/p/d/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1384107377, "Ld/a/n0/a/p/d/o$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadParams.SwanAppDownloadType.values().length];
            f46606a = iArr;
            try {
                iArr[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46606a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46606a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46606a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46606a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46606a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements o {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f46607a;

        /* renamed from: b  reason: collision with root package name */
        public c f46608b;

        /* renamed from: c  reason: collision with root package name */
        public String f46609c;

        /* renamed from: d  reason: collision with root package name */
        public String f46610d;

        /* renamed from: e  reason: collision with root package name */
        public String f46611e;

        /* renamed from: f  reason: collision with root package name */
        public String f46612f;

        /* renamed from: g  reason: collision with root package name */
        public String f46613g;

        /* renamed from: h  reason: collision with root package name */
        public Context f46614h;

        /* renamed from: i  reason: collision with root package name */
        public CallbackHandler f46615i;

        /* loaded from: classes7.dex */
        public class a implements d.a.n0.f.i.k.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f46616a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f46617b;

            public a(b bVar, DownloadParams.SwanAppDownloadType swanAppDownloadType) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppDownloadType};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46617b = bVar;
                this.f46616a = swanAppDownloadType;
            }

            @Override // d.a.n0.f.i.k.f.a
            public void a(int i2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange:" + i2);
                }
            }

            @Override // d.a.n0.f.i.k.f.a
            public void b() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // d.a.n0.f.i.k.f.a
            public void c(DownloadState downloadState, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i2);
                    }
                    switch (a.f46606a[this.f46616a.ordinal()]) {
                        case 1:
                            this.f46617b.u(downloadState, String.valueOf(i2));
                            return;
                        case 2:
                            this.f46617b.w(downloadState, String.valueOf(i2));
                            return;
                        case 3:
                            this.f46617b.t(String.valueOf(i2));
                            return;
                        case 4:
                            this.f46617b.r();
                            return;
                        case 5:
                            this.f46617b.v(downloadState, String.valueOf(i2));
                            return;
                        case 6:
                            this.f46617b.s();
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // d.a.n0.f.i.k.f.a
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // d.a.n0.f.i.k.f.a
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onAppOpen:");
                        return null;
                    }
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // d.a.n0.f.i.k.f.a
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }
        }

        /* renamed from: d.a.n0.a.p.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0857b implements d.a.n0.a.s1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f46618a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46619b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f46620c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f46621d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f46622e;

            public C0857b(b bVar, String str, String str2, String str3, boolean z, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z), context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46618a = str;
                this.f46619b = str2;
                this.f46620c = str3;
                this.f46621d = z;
                this.f46622e = context;
            }

            @Override // d.a.n0.a.s1.f
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f46618a));
                    String str2 = this.f46618a;
                    request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.f46619b) && !TextUtils.isEmpty(this.f46620c)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.f46619b);
                        request.setDescription(this.f46620c);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (this.f46621d) {
                            return;
                        }
                        d.a.n0.a.v2.f.g(this.f46622e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // d.a.n0.a.s1.f
            public void b(int i2, String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && b.j) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1384107346, "Ld/a/n0/a/p/d/o$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1384107346, "Ld/a/n0/a/p/d/o$b;");
                    return;
                }
            }
            j = d.a.n0.a.k.f45831a;
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
                }
            }
        }

        @Override // d.a.n0.a.p.d.o
        public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.n0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? p(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
        }

        @Override // d.a.n0.a.p.d.o
        public boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.f46614h = context;
                this.f46615i = callbackHandler;
                this.f46612f = jSONObject.optString("cb");
                this.f46613g = jSONObject.optString("onProgressUpdate");
                this.f46609c = jSONObject.optString("url");
                this.f46610d = jSONObject.optString("name");
                this.f46611e = String.valueOf(this.f46609c.hashCode());
                if (!TextUtils.isEmpty(this.f46612f) && !TextUtils.isEmpty(this.f46609c)) {
                    if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                        x();
                    }
                    DownloadParams.SwanAppDownloadType find = DownloadParams.SwanAppDownloadType.find(swanAppDownloadType.getTypeName());
                    return p(context, jSONObject, find, new a(this, find));
                }
                n(false, "Missing parameters");
                return false;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // d.a.n0.a.p.d.o
        public boolean d(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject)) == null) ? q(context, jSONObject) : invokeLL.booleanValue;
        }

        @NonNull
        public final String l(DownloadState downloadState, @NonNull String str, @NonNull String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, downloadState, str, str2)) == null) ? m(downloadState, str, str2, -1) : (String) invokeLLL.objValue;
        }

        @NonNull
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i2) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048580, this, downloadState, str, str2, i2)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (i2 > 0) {
                        jSONObject.put("state", i2);
                    } else {
                        jSONObject.put("state", downloadState);
                    }
                    jSONObject.put("progress", str);
                    jSONObject.put("fileId", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return o(true, null, jSONObject);
            }
            return (String) invokeLLLI.objValue;
        }

        @NonNull
        public final String n(boolean z, @Nullable String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZL = interceptable.invokeZL(1048581, this, z, str)) == null) ? o(z, str, null) : (String) invokeZL.objValue;
        }

        @NonNull
        public final String o(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, jSONObject})) == null) {
                if (str == null) {
                    str = z ? "success" : SmsLoginView.f.l;
                }
                return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
            }
            return (String) invokeCommon.objValue;
        }

        public final boolean p(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.n0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, jSONObject, swanAppDownloadType, aVar)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
                d.a.n0.a.v1.c.e.a E = d.a.n0.a.v1.c.e.a.E();
                if (E != null) {
                    E.L(bundle, d.a.n0.a.o.h.a.class, new d.a.n0.a.o.h.b(aVar, swanAppDownloadType));
                    return true;
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        public final boolean q(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject)) == null) {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("description");
                boolean optBoolean = jSONObject.optBoolean("autoinstall");
                if (TextUtils.isEmpty(optString)) {
                    d.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                }
                d.a.n0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0857b(this, optString, optString2, optString3, optBoolean, context));
                return true;
            }
            return invokeLL.booleanValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f46615i.handleSchemeDispatchCallback(this.f46613g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f46611e));
                this.f46615i.handleSchemeDispatchCallback(this.f46612f, n(true, null));
                String str = this.f46607a;
                if (str != null) {
                    this.f46615i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.f46607a = null;
                }
            }
        }

        public final void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (j) {
                    Log.d("SwanAdDownloadImpl", "handleInstallApp");
                }
                String concat = new File(d.a.n0.a.o.h.a.n()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.f46611e + ".apk");
                if (new File(concat2).exists()) {
                    x();
                    if (d.a.n0.f.i.r.g.c(concat2, false)) {
                        return;
                    }
                    this.f46615i.handleSchemeDispatchCallback(this.f46612f, n(false, "install apk error"));
                    return;
                }
                this.f46615i.handleSchemeDispatchCallback(this.f46612f, n(false, "Apk Not Found"));
            }
        }

        public final void t(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f46615i.handleSchemeDispatchCallback(this.f46613g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f46611e));
                this.f46615i.handleSchemeDispatchCallback(this.f46612f, n(true, null));
                String str2 = this.f46607a;
                if (str2 != null) {
                    this.f46615i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.f46607a = null;
                }
            }
        }

        public final void u(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, downloadState, str) == null) {
                this.f46615i.handleSchemeDispatchCallback(this.f46613g, l(downloadState, str, this.f46611e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.f46615i.handleSchemeDispatchCallback(this.f46612f, m(downloadState, str, this.f46611e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, "100")) {
                    this.f46615i.handleSchemeDispatchCallback(this.f46612f, l(DownloadState.DOWNLOADED, str, this.f46611e));
                } else {
                    this.f46615i.handleSchemeDispatchCallback(this.f46612f, l(downloadState, str, this.f46611e));
                }
            }
        }

        public final void v(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048589, this, downloadState, str) == null) && j) {
                Log.d("SwanAdDownloadImpl", "handleResumeDownload");
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, downloadState, str) == null) {
                this.f46607a = this.f46612f;
                this.f46615i.handleSchemeDispatchCallback(this.f46613g, l(downloadState, str, this.f46611e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.f46615i.handleSchemeDispatchCallback(this.f46612f, n(true, "onSuccess"));
                    this.f46607a = null;
                }
            }
        }

        public final void x() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f46608b == null) {
                this.f46608b = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                this.f46614h.registerReceiver(this.f46608b, intentFilter);
            }
        }

        public void y() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (cVar = this.f46608b) == null) {
                return;
            }
            this.f46614h.unregisterReceiver(cVar);
            this.f46608b = null;
        }

        /* loaded from: classes7.dex */
        public class c extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b this$0;
            public long time;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = bVar;
                this.time = 0L;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                    return;
                }
                if (TextUtils.equals(this.this$0.f46610d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = this.this$0;
                    bVar.f46615i.handleSchemeDispatchCallback(bVar.f46612f, bVar.n(true, null));
                    this.this$0.y();
                }
            }

            public /* synthetic */ c(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.n0.f.i.k.f.a aVar);

    boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean d(Context context, JSONObject jSONObject);
}
