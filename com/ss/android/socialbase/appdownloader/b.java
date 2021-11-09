package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68903a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static c f68904b;

    /* renamed from: c  reason: collision with root package name */
    public static a f68905c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements a.InterfaceC1983a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f68906a;

        /* renamed from: b  reason: collision with root package name */
        public final int f68907b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f68908c;

        public a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC1980b interfaceC1980b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, Integer.valueOf(i2), jSONObject, interfaceC1980b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68908c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f68907b = optInt;
            this.f68906a = new e(context, intent, i2, interfaceC1980b, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f68906a.f68922i) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    this.f68906a.f68919f.sendMessage(obtain);
                }
                com.ss.android.socialbase.downloader.a.a.a().b(this);
                a unused = b.f68905c = null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int optInt = this.f68908c.optInt("time_out_second", 20);
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.f68906a.f68919f.sendMessage(obtain);
                if (optInt <= 0 || optInt >= 60) {
                    return;
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                this.f68906a.f68919f.sendMessageDelayed(obtain2, optInt * 1000);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1980b {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* loaded from: classes2.dex */
    public static class d implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f68910a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC1980b f68911b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f68912c;

        /* renamed from: d  reason: collision with root package name */
        public final long f68913d;

        public d(Handler handler, Context context, InterfaceC1980b interfaceC1980b, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, context, interfaceC1980b, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68910a = context;
            this.f68911b = interfaceC1980b;
            this.f68912c = handler;
            this.f68913d = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f68911b != null && this.f68913d > 0 && this.f68913d <= 10000) {
                    Context context = this.f68910a;
                    boolean a2 = context != null ? this.f68911b.a(context) : false;
                    Message obtain = Message.obtain();
                    if (a2) {
                        obtain.what = 2;
                        this.f68912c.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f68912c.sendMessageDelayed(obtain, this.f68913d);
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements h.a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f68914a;

        /* renamed from: b  reason: collision with root package name */
        public static int f68915b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final Context f68916c;

        /* renamed from: d  reason: collision with root package name */
        public final Intent f68917d;

        /* renamed from: e  reason: collision with root package name */
        public final InterfaceC1980b f68918e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f68919f;

        /* renamed from: g  reason: collision with root package name */
        public final long f68920g;

        /* renamed from: h  reason: collision with root package name */
        public Future<Boolean> f68921h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f68922i;

        public e(Context context, Intent intent, int i2, InterfaceC1980b interfaceC1980b, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, Integer.valueOf(i2), interfaceC1980b, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68922i = false;
            this.f68916c = context;
            this.f68917d = intent;
            f68915b = i2;
            this.f68918e = interfaceC1980b;
            this.f68919f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
            this.f68920g = j;
        }

        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                long j = this.f68920g;
                if (j <= 0 || j > 10000) {
                    return;
                }
                f68914a = 1;
                this.f68921h = com.ss.android.socialbase.downloader.downloader.c.l().submit(new d(this.f68919f, this.f68916c, this.f68918e, this.f68920g));
            } else if (i2 == 2) {
                f68914a = 2;
                this.f68919f.removeMessages(2);
                this.f68919f.removeMessages(1);
                Future<Boolean> future = this.f68921h;
                if (future != null) {
                    future.cancel(true);
                }
                if (!this.f68922i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                    Intent intent = this.f68917d;
                    if (intent != null) {
                        b.b(this.f68916c, intent);
                    } else {
                        DownloadInfo downloadInfo = Downloader.getInstance(this.f68916c).getDownloadInfo(f68915b);
                        if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                            com.ss.android.socialbase.appdownloader.c.b(this.f68916c, f68915b, false);
                        }
                    }
                    this.f68922i = true;
                }
                b.b(f68915b, this.f68917d == null, b.a(this.f68916c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1522867374, "Lcom/ss/android/socialbase/appdownloader/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1522867374, "Lcom/ss/android/socialbase/appdownloader/b;");
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
            }
        }
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                return context.getPackageManager().canRequestPackageInstalls();
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65564, null, context, downloadInfo, jSONObject, aVar)) == null) {
            if (context != null && jSONObject != null) {
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                aVar.f68895d = SchedulerSupport.CUSTOM;
                com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, SchedulerSupport.CUSTOM, jSONObject, downloadInfo);
                if (a2 != null && a2.a()) {
                    Intent b2 = a2.b();
                    if (b2 == null) {
                        return false;
                    }
                    if (a(new File(savePath), downloadInfo, jSONObject)) {
                        if (b(context, b2)) {
                            aVar.f68893b = 0;
                            return true;
                        }
                        aVar.f68893b = 1;
                    } else {
                        aVar.f68893b = 6;
                    }
                    return false;
                }
                aVar.f68893b = 3;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static void c(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65565, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_open_setting", jSONObject2);
        }
    }

    public static void d(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65567, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_show", jSONObject2);
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, downloadInfo, intent, Boolean.valueOf(z)})) == null) {
            JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
            if (e2 != null) {
                int length = e2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = e2.optJSONObject(i2);
                    if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        InterceptResult invokeCommon;
        char c2;
        com.ss.android.socialbase.appdownloader.a a2;
        boolean a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, downloadInfo, intent, jSONObject, Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (jSONObject != null && downloadInfo != null) {
                com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
                String optString = jSONObject.optString("type");
                if (!TextUtils.isEmpty(optString)) {
                    com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
                    aVar.f68892a = optString;
                    switch (optString.hashCode()) {
                        case -985763637:
                            if (optString.equals("plan_a")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763636:
                            if (optString.equals("plan_b")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763635:
                            if (optString.equals("plan_c")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763634:
                            if (optString.equals("plan_d")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763633:
                            if (optString.equals("plan_e")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763632:
                            if (optString.equals("plan_f")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763631:
                            if (optString.equals("plan_g")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763630:
                            if (optString.equals("plan_h")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                            if (!downloadInfo.isSavePathRedirected()) {
                                aVar.f68893b = downloadInfo.getAntiHijackErrorCode(-1);
                                break;
                            }
                        case 2:
                            a2 = a(jSONObject, a4);
                            if (a2.f68893b == 0) {
                                if (optString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                    aVar.f68893b = downloadInfo.getAntiHijackErrorCode(10);
                                    break;
                                } else {
                                    a3 = a(context, downloadInfo, jSONObject, aVar);
                                    z2 = a3;
                                    break;
                                }
                            }
                            aVar = a2;
                            break;
                        case 3:
                            a2 = a(jSONObject, a4);
                            if (a2.f68893b == 0) {
                                if (!downloadInfo.isSavePathRedirected()) {
                                    aVar.f68893b = downloadInfo.getAntiHijackErrorCode(-1);
                                    break;
                                } else {
                                    a3 = b(context, downloadInfo, jSONObject, aVar);
                                    z2 = a3;
                                    break;
                                }
                            }
                            aVar = a2;
                            break;
                        case 4:
                            aVar.f68892a = "plan_d";
                            if (!com.ss.android.socialbase.appdownloader.f.d.c()) {
                                aVar.f68893b = 2;
                                break;
                            } else {
                                try {
                                    com.ss.android.socialbase.appdownloader.c.a(context, intent);
                                    aVar.f68893b = 0;
                                    z2 = true;
                                    break;
                                } catch (Throwable th) {
                                    aVar.f68893b = 4;
                                    aVar.f68894c = th.toString();
                                    break;
                                }
                            }
                        case 5:
                            a2 = b(jSONObject, a4);
                            if (a2.f68893b == 0) {
                                a3 = a(context, downloadInfo, jSONObject, aVar, a4);
                                z2 = a3;
                                break;
                            }
                            aVar = a2;
                            break;
                        case 6:
                            String a5 = com.ss.android.socialbase.appdownloader.f.c.a(a4.c("bh"), a4.c("s"));
                            com.ss.android.socialbase.appdownloader.a a6 = a(jSONObject, a5, context, a4);
                            if (a6.f68893b == 0) {
                                String packageName = context.getPackageName();
                                if (com.ss.android.socialbase.appdownloader.f.a.a(com.ss.android.socialbase.downloader.g.a.b(), context, a5)) {
                                    try {
                                        com.ss.android.socialbase.appdownloader.c.a(context, intent);
                                        aVar.f68893b = 0;
                                        z2 = true;
                                        break;
                                    } catch (Throwable th2) {
                                        try {
                                            aVar.f68893b = 1;
                                            aVar.f68894c = th2.toString();
                                            break;
                                        } finally {
                                            com.ss.android.socialbase.appdownloader.f.a.a(com.ss.android.socialbase.downloader.g.a.b(), context, packageName);
                                        }
                                    }
                                } else {
                                    aVar.f68893b = 11;
                                    break;
                                }
                            } else {
                                aVar = a6;
                                break;
                            }
                        case 7:
                            if (Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.appdownloader.f.d.b()) {
                                if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                    if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                        a3 = a(context, intent, jSONObject, downloadInfo.getId(), aVar);
                                        z2 = a3;
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    if (z2) {
                        downloadInfo.getTempCacheData().put("ah_attempt", aVar.a());
                    }
                    if (f68904b != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        f68904b.a(downloadInfo, aVar);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, jSONObject, aVar)) == null) {
            com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
            if (jSONObject == null) {
                return aVar2;
            }
            aVar2.f68892a = jSONObject.optString("type");
            aVar2.f68896e = "vbi";
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "vbi", jSONObject, aVar)) {
                aVar2.f68893b = 0;
            } else {
                a(aVar2, 3);
            }
            return aVar2;
        }
        return (com.ss.android.socialbase.appdownloader.a) invokeLL.objValue;
    }

    public static void b(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65560, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_cancel", jSONObject2);
        }
    }

    public static void b(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            int i3 = 1;
            try {
                jSONObject.put("scene", z ? 1 : 2);
                if (!z2) {
                    i3 = 2;
                }
                jSONObject.put("result_code", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_result", jSONObject);
        }
    }

    public static boolean b(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, intent)) == null) ? a(context, intent, true) : invokeLL.booleanValue;
    }

    public static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65557, null, context, downloadInfo, jSONObject, aVar, aVar2)) == null) {
            String optString = jSONObject.optString("type");
            aVar.f68892a = optString;
            Intent b2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
            StringBuilder sb = new StringBuilder();
            try {
                z = b(context, b2);
            } catch (Throwable th) {
                sb.append(optString);
                sb.append(" startActivity failed : ");
                sb.append(a(th));
                a(aVar, 1);
                z = false;
            }
            if (!z) {
                aVar.f68894c = sb.toString();
            } else {
                aVar.f68893b = 0;
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, context, downloadInfo, jSONObject, aVar)) == null) {
            if (context != null && jSONObject != null) {
                String optString = jSONObject.optString("device_plans");
                aVar.f68896e = optString;
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    String savePath = downloadInfo.getSavePath();
                    if (TextUtils.isEmpty(savePath)) {
                        return false;
                    }
                    File file = new File(savePath);
                    StringBuilder sb = new StringBuilder();
                    String str = null;
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        z = true;
                        if (i2 >= length) {
                            z = false;
                            break;
                        }
                        String str2 = split[i2];
                        com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                        if (a2 != null) {
                            Intent b2 = a2.b();
                            if (b2 != null) {
                                if (a(file, downloadInfo, jSONObject)) {
                                    try {
                                        a(context, b2, false);
                                        str = str2;
                                        break;
                                    } catch (Throwable th) {
                                        sb.append(str2);
                                        sb.append(" startActivity failed : ");
                                        sb.append(a(th));
                                        a(aVar, 1);
                                    }
                                } else {
                                    a(aVar, 6);
                                    sb.append(str2);
                                    sb.append(" createDescFile failed! ");
                                }
                            } else {
                                a(aVar, 3);
                                sb.append(str2);
                                sb.append(" resolveActivity failed! ");
                            }
                        }
                        sb.append(GlideException.IndentedAppendable.INDENT);
                        i2++;
                    }
                    if (!z) {
                        aVar.f68894c = sb.toString();
                    } else {
                        aVar.f68895d = str;
                        aVar.f68893b = 0;
                    }
                    return z;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            JSONObject d2 = aVar.d("download_dir");
            if (d2 != null ? !TextUtils.isEmpty(d2.optString("dir_name")) : false) {
                if (com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
                    JSONArray e2 = aVar.e("ah_plans");
                    int i2 = -1;
                    if (e2 != null) {
                        int length = e2.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject optJSONObject = e2.optJSONObject(i3);
                            if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject)) {
                                String optString = optJSONObject.optString("type");
                                if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                    if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i2 = b(optJSONObject, aVar).f68893b) == 0)) {
                                        return 0;
                                    }
                                } else {
                                    i2 = a(optJSONObject, aVar).f68893b;
                                    if (i2 == 0) {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                    return i2;
                }
                return 4;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, aVar)) == null) {
            com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
            if (jSONObject == null) {
                return aVar2;
            }
            String optString = jSONObject.optString("type");
            aVar2.f68892a = optString;
            if ("plan_b".equals(optString)) {
                aVar2.f68896e = SchedulerSupport.CUSTOM;
                if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), SchedulerSupport.CUSTOM, jSONObject, aVar)) {
                    aVar2.f68893b = 0;
                    return aVar2;
                }
                a(aVar2, 3);
            } else {
                String optString2 = jSONObject.optString("device_plans");
                aVar2.f68896e = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    for (String str : optString2.split(",")) {
                        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), str, jSONObject, aVar)) {
                            aVar2.f68893b = 0;
                            return aVar2;
                        }
                        a(aVar2, 3);
                    }
                }
            }
            return aVar2;
        }
        return (com.ss.android.socialbase.appdownloader.a) invokeLL.objValue;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str, context, aVar)) == null) {
            com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
            if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.d.b()) {
                aVar2.f68892a = jSONObject.optString("type");
                if (aVar.a(NotificationStyle.BANNER_IMAGE_URL, 0) == 1) {
                    aVar2.f68893b = 0;
                    return aVar2;
                } else if (a(context)) {
                    aVar2.f68893b = 2;
                } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                    aVar2.f68893b = 0;
                } else {
                    aVar2.f68893b = 9;
                }
            }
            return aVar2;
        }
        return (com.ss.android.socialbase.appdownloader.a) invokeLLLL.objValue;
    }

    public static void a(com.ss.android.socialbase.appdownloader.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, aVar, i2) == null) {
            int i3 = aVar.f68893b;
            if (i3 != -1) {
                aVar.f68893b = (i3 * 10) + i2;
            } else {
                aVar.f68893b = i2;
            }
        }
    }

    public static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, file, downloadInfo, jSONObject)) == null) {
            if (file == null) {
                return false;
            }
            String path = file.getPath();
            JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
            File file2 = null;
            String optString = d2 != null ? d2.optString("ins_desc") : null;
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
                file2 = new File(path + File.separator + optString);
            }
            if (file2 != null) {
                try {
                    if (file2.createNewFile()) {
                        file2.deleteOnExit();
                        return true;
                    }
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, intent, jSONObject, Integer.valueOf(i2), aVar})) == null) {
            if (context != null && jSONObject != null) {
                long optLong = jSONObject.optLong("jump_interval", 0L);
                if (optLong <= 0) {
                    return false;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
                if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !a(context)) {
                    sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                    if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                        Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                        intent2.addFlags(268435456);
                        intent2.putExtra("intent", intent);
                        intent2.putExtra(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, jSONObject.toString());
                        intent2.putExtra("id", i2);
                        try {
                            if (a(context, intent2, false)) {
                                d(i2, jSONObject);
                            }
                            return true;
                        } catch (Throwable th) {
                            if (aVar != null) {
                                aVar.f68893b = 1;
                                aVar.f68894c = "tryShowUnknownSourceDialog" + a(th);
                            }
                            return false;
                        }
                    }
                    if (a(context, intent, i2, jSONObject)) {
                        c(i2, jSONObject);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65551, null, context, intent, i2, jSONObject)) == null) {
            try {
                if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26 && !d(context)) {
                    com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                    if (fVar.a()) {
                        a(context, intent, i2, jSONObject, new InterfaceC1980b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC1980b
                            public boolean a(@NonNull Context context2) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context2)) == null) ? b.d(context2) : invokeL.booleanValue;
                            }
                        });
                        return b(context, fVar.b());
                    }
                } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                    com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                    if (bVar.a()) {
                        a(context, intent, i2, jSONObject, new InterfaceC1980b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC1980b
                            public boolean a(@NonNull Context context2) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context2)) == null) ? b.e(context2) : invokeL.booleanValue;
                            }
                        });
                        return b(context, bVar.b());
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context == null) {
                return true;
            }
            if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26) {
                return d(context);
            }
            if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                return e(context);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? e.f68914a == 1 : invokeV.booleanValue;
    }

    public static void a(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_confirm", jSONObject2);
        }
    }

    public static void a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC1980b interfaceC1980b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, intent, Integer.valueOf(i2), jSONObject, interfaceC1980b}) == null) {
            if (f68905c != null) {
                com.ss.android.socialbase.downloader.a.a.a().b(f68905c);
                f68905c = null;
            }
            f68905c = new a(context, intent, i2, jSONObject, interfaceC1980b);
            com.ss.android.socialbase.downloader.a.a.a().a(f68905c);
        }
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65553, null, context, intent, z)) == null) {
            if (context == null || intent == null) {
                return false;
            }
            if (z) {
                try {
                    intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                    context.startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th)) == null) {
            String th2 = th.toString();
            return th2.length() > 800 ? th2.substring(0, 500) : th2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cVar) == null) {
            f68904b = cVar;
        }
    }
}
