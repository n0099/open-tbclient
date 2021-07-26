package d.a.o0.a.p.d;

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
        public static final /* synthetic */ int[] f47110a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1677510384, "Ld/a/o0/a/p/d/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1677510384, "Ld/a/o0/a/p/d/o$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadParams.SwanAppDownloadType.values().length];
            f47110a = iArr;
            try {
                iArr[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47110a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47110a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47110a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47110a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47110a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
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
        public String f47111a;

        /* renamed from: b  reason: collision with root package name */
        public c f47112b;

        /* renamed from: c  reason: collision with root package name */
        public String f47113c;

        /* renamed from: d  reason: collision with root package name */
        public String f47114d;

        /* renamed from: e  reason: collision with root package name */
        public String f47115e;

        /* renamed from: f  reason: collision with root package name */
        public String f47116f;

        /* renamed from: g  reason: collision with root package name */
        public String f47117g;

        /* renamed from: h  reason: collision with root package name */
        public Context f47118h;

        /* renamed from: i  reason: collision with root package name */
        public CallbackHandler f47119i;

        /* loaded from: classes7.dex */
        public class a implements d.a.o0.f.i.k.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f47120a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f47121b;

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
                this.f47121b = bVar;
                this.f47120a = swanAppDownloadType;
            }

            @Override // d.a.o0.f.i.k.f.a
            public void a(int i2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange:" + i2);
                }
            }

            @Override // d.a.o0.f.i.k.f.a
            public void b() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // d.a.o0.f.i.k.f.a
            public void c(DownloadState downloadState, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i2);
                    }
                    switch (a.f47110a[this.f47120a.ordinal()]) {
                        case 1:
                            this.f47121b.u(downloadState, String.valueOf(i2));
                            return;
                        case 2:
                            this.f47121b.w(downloadState, String.valueOf(i2));
                            return;
                        case 3:
                            this.f47121b.t(String.valueOf(i2));
                            return;
                        case 4:
                            this.f47121b.r();
                            return;
                        case 5:
                            this.f47121b.v(downloadState, String.valueOf(i2));
                            return;
                        case 6:
                            this.f47121b.s();
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // d.a.o0.f.i.k.f.a
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // d.a.o0.f.i.k.f.a
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

            @Override // d.a.o0.f.i.k.f.a
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }
        }

        /* renamed from: d.a.o0.a.p.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0866b implements d.a.o0.a.s1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f47122a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f47123b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f47124c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f47125d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f47126e;

            public C0866b(b bVar, String str, String str2, String str3, boolean z, Context context) {
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
                this.f47122a = str;
                this.f47123b = str2;
                this.f47124c = str3;
                this.f47125d = z;
                this.f47126e = context;
            }

            @Override // d.a.o0.a.s1.f
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f47122a));
                    String str2 = this.f47122a;
                    request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.f47123b) && !TextUtils.isEmpty(this.f47124c)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.f47123b);
                        request.setDescription(this.f47124c);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (this.f47125d) {
                            return;
                        }
                        d.a.o0.a.v2.f.g(this.f47126e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // d.a.o0.a.s1.f
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1677510353, "Ld/a/o0/a/p/d/o$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1677510353, "Ld/a/o0/a/p/d/o$b;");
                    return;
                }
            }
            j = d.a.o0.a.k.f46335a;
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

        @Override // d.a.o0.a.p.d.o
        public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.o0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? p(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
        }

        @Override // d.a.o0.a.p.d.o
        public boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.f47118h = context;
                this.f47119i = callbackHandler;
                this.f47116f = jSONObject.optString("cb");
                this.f47117g = jSONObject.optString("onProgressUpdate");
                this.f47113c = jSONObject.optString("url");
                this.f47114d = jSONObject.optString("name");
                this.f47115e = String.valueOf(this.f47113c.hashCode());
                if (!TextUtils.isEmpty(this.f47116f) && !TextUtils.isEmpty(this.f47113c)) {
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

        @Override // d.a.o0.a.p.d.o
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

        public final boolean p(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.o0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, jSONObject, swanAppDownloadType, aVar)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
                d.a.o0.a.v1.c.e.a E = d.a.o0.a.v1.c.e.a.E();
                if (E != null) {
                    E.L(bundle, d.a.o0.a.o.h.a.class, new d.a.o0.a.o.h.b(aVar, swanAppDownloadType));
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
                    d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                }
                d.a.o0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0866b(this, optString, optString2, optString3, optBoolean, context));
                return true;
            }
            return invokeLL.booleanValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f47119i.handleSchemeDispatchCallback(this.f47117g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f47115e));
                this.f47119i.handleSchemeDispatchCallback(this.f47116f, n(true, null));
                String str = this.f47111a;
                if (str != null) {
                    this.f47119i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.f47111a = null;
                }
            }
        }

        public final void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (j) {
                    Log.d("SwanAdDownloadImpl", "handleInstallApp");
                }
                String concat = new File(d.a.o0.a.o.h.a.n()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.f47115e + ".apk");
                if (new File(concat2).exists()) {
                    x();
                    if (d.a.o0.f.i.r.g.c(concat2, false)) {
                        return;
                    }
                    this.f47119i.handleSchemeDispatchCallback(this.f47116f, n(false, "install apk error"));
                    return;
                }
                this.f47119i.handleSchemeDispatchCallback(this.f47116f, n(false, "Apk Not Found"));
            }
        }

        public final void t(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f47119i.handleSchemeDispatchCallback(this.f47117g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f47115e));
                this.f47119i.handleSchemeDispatchCallback(this.f47116f, n(true, null));
                String str2 = this.f47111a;
                if (str2 != null) {
                    this.f47119i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.f47111a = null;
                }
            }
        }

        public final void u(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, downloadState, str) == null) {
                this.f47119i.handleSchemeDispatchCallback(this.f47117g, l(downloadState, str, this.f47115e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.f47119i.handleSchemeDispatchCallback(this.f47116f, m(downloadState, str, this.f47115e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, "100")) {
                    this.f47119i.handleSchemeDispatchCallback(this.f47116f, l(DownloadState.DOWNLOADED, str, this.f47115e));
                } else {
                    this.f47119i.handleSchemeDispatchCallback(this.f47116f, l(downloadState, str, this.f47115e));
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
                this.f47111a = this.f47116f;
                this.f47119i.handleSchemeDispatchCallback(this.f47117g, l(downloadState, str, this.f47115e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.f47119i.handleSchemeDispatchCallback(this.f47116f, n(true, "onSuccess"));
                    this.f47111a = null;
                }
            }
        }

        public final void x() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f47112b == null) {
                this.f47112b = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                this.f47118h.registerReceiver(this.f47112b, intentFilter);
            }
        }

        public void y() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (cVar = this.f47112b) == null) {
                return;
            }
            this.f47118h.unregisterReceiver(cVar);
            this.f47112b = null;
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
                if (TextUtils.equals(this.this$0.f47114d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = this.this$0;
                    bVar.f47119i.handleSchemeDispatchCallback(bVar.f47116f, bVar.n(true, null));
                    this.this$0.y();
                }
            }

            public /* synthetic */ c(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.o0.f.i.k.f.a aVar);

    boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean d(Context context, JSONObject jSONObject);
}
