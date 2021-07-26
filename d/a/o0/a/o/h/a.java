package d.a.o0.a.o.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.o0.a.k;
import d.a.o0.a.v2.w;
import d.a.o0.f.i.k.d.a;
import d.a.o0.f.i.r.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f47013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47014g;

    /* renamed from: h  reason: collision with root package name */
    public AdDownloadService.a f47015h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f47016i;

    /* renamed from: d.a.o0.a.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC0857a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47017e;

        public ServiceConnectionC0857a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47017e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f47017e.f47015h = (AdDownloadService.a) iBinder;
                if (k.f46335a) {
                    Log.d("AdDownload", "service connected");
                }
                a aVar = this.f47017e;
                aVar.l(aVar.f47013f);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f47017e.f47015h = null;
                if (k.f46335a) {
                    Log.d("AdDownload", "service disconnected");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47019f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47020g;

        public b(a aVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47020g = aVar;
            this.f47018e = i2;
            this.f47019f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47020g.f48402d.putInt("state", this.f47018e);
                this.f47020g.f48402d.putInt("progress", this.f47019f);
                this.f47020g.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47022f;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47022f = aVar;
            this.f47021e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47022f.f48402d.putString("packageName", this.f47021e);
                this.f47022f.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47023a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f47024b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988746200, "Ld/a/o0/a/o/h/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(988746200, "Ld/a/o0/a/o/h/a$d;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f47024b = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47024b[DownloadState.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47024b[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47024b[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47024b[DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47024b[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f47024b[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f47024b[DownloadState.DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f47023a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f47023a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f47023a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f47023a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f47023a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f47023a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.f.i.k.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f47025a;

        /* renamed from: b  reason: collision with root package name */
        public final String f47026b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f47027c;

        /* renamed from: d.a.o0.a.o.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0858a extends a.d<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.f.i.k.f.d f47028a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f47029b;

            public C0858a(e eVar, d.a.o0.f.i.k.f.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47029b = eVar;
                this.f47028a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.f.i.k.d.a.d
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    super.a(bool);
                    if (bool.booleanValue()) {
                        if (k.f46335a) {
                            Log.d("AdDownload", "安装完成");
                        }
                        d.a.o0.f.i.k.f.d dVar = this.f47028a;
                        dVar.b(dVar.g(this.f47029b.f47026b));
                        this.f47029b.f47027c.y(DownloadState.INSTALLED.value(), Integer.parseInt("100"));
                    }
                }
            }
        }

        public e(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47027c = aVar;
            this.f47025a = str;
            this.f47026b = str2;
        }

        @Override // d.a.o0.f.i.k.f.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47027c.y(DownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载完成");
                }
                String str2 = this.f47025a;
                if (TextUtils.isEmpty(str2) && (str = this.f47026b) != null) {
                    str2 = this.f47027c.w(str);
                    this.f47027c.x(str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Uri parse = Uri.parse(this.f47026b);
                d.a.o0.f.i.k.f.d m = d.a.o0.f.i.k.d.a.m(this.f47027c.m(), null);
                m.f(str2, parse, new C0858a(this, m));
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void b(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                this.f47027c.y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f47027c.y(DownloadState.DELETED.value(), Integer.parseInt("0"));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载移除");
                }
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f47027c.y(DownloadState.NOT_START.value(), Integer.parseInt("0"));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载等待");
                }
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void e(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                String o = a.o(j, j2);
                this.f47027c.y(DownloadState.DOWNLOADING.value(), Integer.parseInt(o));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载进度" + o);
                }
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void f(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                String o = a.o(j, j2);
                this.f47027c.y(DownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(o));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载暂停" + o);
                }
            }
        }

        @Override // d.a.o0.f.i.k.f.c
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f47027c.y(DownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
                if (k.f46335a) {
                    Log.d("AdDownload", "下载开始");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1169919528, "Ld/a/o0/a/o/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1169919528, "Ld/a/o0/a/o/h/a;");
                return;
            }
        }
        j = AppRuntime.getAppContext().getPackageName();
        k = false;
    }

    public a() {
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
        this.f47014g = false;
        this.f47016i = new ServiceConnectionC0857a(this);
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "swanAdDownload";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return str;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String o(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j3 <= 0 || j2 <= 0) ? "0" : String.valueOf((int) Math.floor((j2 * 100) / j3)) : (String) invokeCommon.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k) {
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            m.stopService(intent);
            k = false;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f47014g) {
            this.f47014g = false;
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            m.unbindService(this.f47016i);
        }
    }

    @Override // d.a.o0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.f47013f = bundle;
            if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
                A();
                return;
            }
            z();
            k();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f47014g) {
            return;
        }
        this.f47014g = true;
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        m.bindService(intent, this.f47016i, 128);
    }

    public void l(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            try {
                SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
                JSONObject d2 = w.d(bundle.getString(PushConstants.PARAMS, null));
                String optString = d2.optString("url");
                if (!TextUtils.isEmpty(optString) && this.f47015h != null) {
                    switch (d.f47023a[find.ordinal()]) {
                        case 1:
                            t(d2, optString);
                            return;
                        case 2:
                            v(d2, optString);
                            return;
                        case 3:
                            s(optString);
                            return;
                        case 4:
                            p(optString);
                            return;
                        case 5:
                            u(optString);
                            return;
                        case 6:
                            r(d2, optString);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception unused) {
                q();
            }
        }
    }

    public final Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public final void p(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f47015h.a(this.f47015h.b(str));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
        }
    }

    public final void r(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str) == null) || (b2 = this.f47015h.b(str)) == null) {
            return;
        }
        g.c(b2.getPath(), false);
    }

    public final void s(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f47015h.c(this.f47015h.b(str));
        }
    }

    public final void t(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f47015h.b(str);
            int value = DownloadState.NOT_START.value();
            int parseInt = Integer.parseInt("0");
            if (b2 == null) {
                y(value, parseInt);
                return;
            }
            long progress = b2.getProgress();
            long size = b2.getSize();
            switch (d.f47024b[DownloadState.convert(b2.getStatus()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                    value = DownloadState.NOT_START.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 4:
                    value = DownloadState.DOWNLOADED.value();
                    parseInt = Integer.parseInt("100");
                    break;
                case 5:
                    value = DownloadState.DOWNLOADING.value();
                    parseInt = Integer.parseInt(o(progress, size));
                    break;
                case 6:
                    value = DownloadState.DOWNLOAD_FAILED.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 7:
                    value = DownloadState.DOWNLOAD_PAUSED.value();
                    parseInt = Integer.parseInt(o(progress, size));
                    break;
                case 8:
                    value = DownloadState.DELETED.value();
                    parseInt = Integer.parseInt("0");
                    break;
            }
            y(value, parseInt);
        }
    }

    public final void u(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f47015h.d(this.f47015h.b(str));
        }
    }

    public final void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f47015h.b(str);
            String optString = jSONObject.optString("name");
            String n = n();
            if (TextUtils.isEmpty(n)) {
                q();
                return;
            }
            File file = new File(n);
            String valueOf = String.valueOf(str.hashCode());
            String concat = file.getAbsolutePath().concat("/");
            String concat2 = concat.concat(valueOf + ".apk");
            if (b2 == null) {
                DownloadInfo.a aVar = new DownloadInfo.a();
                aVar.e(str);
                aVar.d(concat2);
                aVar.c(optString);
                b2 = aVar.a();
            }
            b2.setDownloadListener(new e(this, optString, str));
            this.f47015h.e(b2);
        }
    }

    public final String w(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            DownloadInfo b2 = this.f47015h.b(str);
            return b2 == null ? "" : b2.getPackageName();
        }
        return (String) invokeL.objValue;
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d.a.o0.a.a2.d.i().post(new c(this, str));
        }
    }

    public final void y(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            d.a.o0.a.a2.d.i().post(new b(this, i2, i3));
            B();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || k) {
            return;
        }
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        m.startService(intent);
        k = true;
    }
}
