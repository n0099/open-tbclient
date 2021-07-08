package d.a.n0.f.j.n;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.install.GameNowInstallAntiBlockingActivity;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.w;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile e l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.f.j.n.d f49535a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.f.j.n.d f49536b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.f.j.n.d f49537c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f49538d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f.j.n.b f49539e;

    /* renamed from: f  reason: collision with root package name */
    public i f49540f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f49541g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f49542h;

    /* renamed from: i  reason: collision with root package name */
    public int f49543i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49546g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f49547h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f49548i;

        public a(e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49548i = eVar;
            this.f49544e = str;
            this.f49545f = str2;
            this.f49546g = str3;
            this.f49547h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.f.j.r.b.n().h(this.f49544e, new d.a.n0.f.j.r.a(this.f49548i.f49542h), this.f49545f, this.f49546g, this.f49547h);
                if (d.a.n0.a.g1.g.a().b()) {
                    return;
                }
                if (e.k) {
                    Log.d("GameNowAppManager", "start InstallAntiBlockingActivity");
                }
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.f49544e);
                intent.putExtra("packageName", this.f49545f);
                if (this.f49548i.f49542h != null) {
                    intent.putExtra("ubc_params", this.f49548i.f49542h.toString());
                }
                intent.setFlags(276824064);
                d.a.n0.a.v2.f.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f49549a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49549a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (k.f45831a) {
                    Log.d("GameNowAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
                }
                if (this.f49549a.f49537c.d(String.valueOf(j))) {
                    this.f49549a.f49537c.b(String.valueOf(j), new h(i2));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f49550a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49550a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            download.getKeyByUser();
            if (e.k) {
                Log.d("GameNowAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (this.f49550a.f49535a.d(valueOf)) {
                this.f49550a.f49535a.b(valueOf, new h(download));
                d.a.n0.f.j.n.a aVar = new d.a.n0.f.j.n.a(download);
                int i2 = C1061e.f49551a[download.getState().ordinal()];
                if (i2 == 1) {
                    d.a.n0.f.j.r.b.n().f("reallyPause", new d.a.n0.f.j.r.a(this.f49550a.f49542h), aVar.k(), aVar.h(), aVar.j());
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    d.a.n0.f.j.r.b.n().h("reallyDownloadFail", new d.a.n0.f.j.r.a(this.f49550a.f49542h), aVar.k(), aVar.h(), aVar.j());
                    this.f49550a.E(valueOf);
                    this.f49550a.D(valueOf);
                } else {
                    String h2 = aVar.h();
                    if (this.f49550a.v(download)) {
                        this.f49550a.J(download.getUrl(), download.getKeyByUser(), h2);
                        d.a.n0.f.j.r.b.n().f("reallyDownloaded", new d.a.n0.f.j.r.a(this.f49550a.f49542h), aVar.k(), aVar.h(), aVar.j());
                        if (TextUtils.equals(aVar.k(), d.a.n0.f.j.m.c.f49500a)) {
                            d.a.n0.f.j.r.b.n().p(12, aVar.k(), aVar.f(), aVar.j());
                        }
                        this.f49550a.E(valueOf);
                        this.f49550a.D(valueOf);
                        return;
                    }
                    aVar.m("download_current_bytes", download.getCurrentbytes());
                    aVar.m("download_total_bytes", download.getTotalbytes());
                    d.a.n0.f.j.r.b.n().h("analysisFailed", new d.a.n0.f.j.r.a(this.f49550a.f49542h), aVar.k(), aVar.h(), aVar.j());
                    String str = download.getRealDownloadDir() + File.separator + download.getFileName();
                    d.a.n0.f.j.r.b.n().q(1001, download.getKeyByUser(), download.getUrl(), this.f49550a.j, (TextUtils.isEmpty(str) || !new File(str).exists()) ? "" : d.a.n0.t.f.b(new File(str), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                    d.a.n0.a.z1.b.f.e.g(d.a.n0.a.c1.a.b(), d.a.n0.a.c1.a.b().getString(d.a.n0.f.j.k.aiapps_gamenow_download_fail)).F();
                    this.f49550a.r(download.getKeyByUser());
                    if (this.f49550a.f49543i >= 2) {
                        this.f49550a.E(valueOf);
                        this.f49550a.D(valueOf);
                        return;
                    }
                    this.f49550a.I(download.getUrl(), download.getKeyByUser(), download.getFromParam());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            if (e.k) {
                Log.d("GameNowAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            if (this.this$0.f49536b.d(schemeSpecificPart)) {
                this.this$0.f49536b.b(schemeSpecificPart, new h(true));
                this.this$0.C(schemeSpecificPart, null);
            }
            Download d2 = this.this$0.f49539e.d(schemeSpecificPart);
            if (d2 != null) {
                d.a.n0.f.j.n.a aVar = new d.a.n0.f.j.n.a(d2);
                String f2 = aVar.f();
                if (TextUtils.equals(aVar.k(), d.a.n0.f.j.m.c.f49500a) || TextUtils.isEmpty(f2)) {
                    d.a.n0.f.j.r.b.n().h("reallyInstalled", new d.a.n0.f.j.r.a(this.this$0.f49542h), aVar.k(), aVar.h(), aVar.j());
                    this.this$0.m(d2);
                }
            }
        }
    }

    /* renamed from: d.a.n0.f.j.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1061e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49551a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(347358700, "Ld/a/n0/f/j/n/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(347358700, "Ld/a/n0/f/j/n/e$e;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f49551a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49551a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49551a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(608182029, "Ld/a/n0/f/j/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(608182029, "Ld/a/n0/f/j/n/e;");
                return;
            }
        }
        k = k.f45831a;
        m = Executors.newSingleThreadExecutor();
    }

    public e() {
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
        this.f49535a = new d.a.n0.f.j.n.d();
        this.f49536b = new d.a.n0.f.j.n.d();
        this.f49537c = new d.a.n0.f.j.n.d();
        this.f49543i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f49538d = downloadManager;
        this.f49539e = new d.a.n0.f.j.n.b(downloadManager);
        A();
        B();
        z();
    }

    public static e s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (l == null) {
                synchronized (e.class) {
                    if (l == null) {
                        l = new e();
                    }
                }
            }
            return l;
        }
        return (e) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49538d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49538d.registerOnStateChangeListener(new c(this));
        }
    }

    public void C(String str, d.a.n0.f.j.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            this.f49536b.g(str, aVar);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f49537c.f(str);
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f49535a.f(str);
        }
    }

    public void F(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) || n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f49539e.d(str2);
        if (d2 == null) {
            I(str, str2, str3);
        } else if (d2.getState() == Download.DownloadState.FINISH) {
            d.a.n0.f.j.r.b.n().h("resumeDownloadInstall", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
            J(str, str2, str3);
        } else {
            this.f49535a.a(String.valueOf(d2.getId()), this.f49540f);
            this.f49537c.a(String.valueOf(d2.getId()), this.f49540f);
            this.f49538d.resume(d2.getId().longValue());
        }
    }

    public void G(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            this.f49540f = iVar;
        }
    }

    public void H(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f49542h = jSONObject;
    }

    public void I(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) || n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (d.a.n0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f49540f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f49539e.b(str2);
        d.a.n0.a.k2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        d.a.n0.f.j.n.a aVar = new d.a.n0.f.j.n.a();
        aVar.n(str);
        aVar.l(str2);
        aVar.a(optString);
        aVar.e(optString2);
        aVar.d(optString3);
        aVar.c(optString4);
        Download b2 = aVar.b();
        this.f49538d.start(b2);
        if (b2.getId() != null) {
            this.f49535a.a(String.valueOf(b2.getId()), this.f49540f);
            this.f49537c.a(String.valueOf(b2.getId()), this.f49540f);
        }
        if (TextUtils.equals(str2, d.a.n0.f.j.m.c.f49500a)) {
            d.a.n0.f.j.r.b.n().p(11, str2, optString, str);
        }
        d.a.n0.f.j.r.b.n().f("reallyBeginDownload", new d.a.n0.f.j.r.a(this.f49542h), str2, b2.getFromParam(), str);
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String l2 = l(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new d.a.n0.f.j.r.a(this.f49542h).a());
            bundle.putString("download_params", l2);
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtras(bundle);
            AppRuntime.getAppContext().startActivity(intent);
        }
    }

    public final <T> String l(String str, String str2, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, t)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put(str2, t);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public final void m(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, download) == null) {
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (!TextUtils.isEmpty(realDownloadDir) && !TextUtils.isEmpty(fileName)) {
                q(realDownloadDir + File.separator + fileName);
            }
            p();
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public void o(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f49539e.d(str2);
        if (d2 != null) {
            d.a.n0.f.j.n.a aVar = new d.a.n0.f.j.n.a(d2);
            long i2 = aVar.i();
            aVar.m("download_status", d2.getState());
            String h2 = aVar.h();
            if (i2 != 0 && System.currentTimeMillis() - i2 > j) {
                r(str2);
                d.a.n0.f.j.r.b.n().h("package_expired", new d.a.n0.f.j.r.a(this.f49542h), str2, h2, str);
                return;
            }
            y(str2);
            return;
        }
        i iVar = this.f49540f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f49539e.a();
            }
        }
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (k) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void r(String str) {
        Download d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f49539e.d(str)) == null) {
            return;
        }
        this.f49539e.b(str);
        i iVar = this.f49540f;
        if (iVar != null) {
            iVar.a(new h(d2, true));
        }
    }

    public boolean t(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, activity, str, str2, str3)) == null) {
            if (n()) {
                d.a.n0.f.j.r.b.n().h("checkIllegalProcess", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download d2 = this.f49539e.d(str2);
                if (d2 == null) {
                    d.a.n0.f.j.r.b.n().h("nullDownload", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                    I(str, str2, str3);
                    return false;
                }
                String realDownloadDir = d2.getRealDownloadDir();
                String fileName = d2.getFileName();
                if (k) {
                    Log.d("GameNowAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.f49539e.b(str2);
                }
                String str4 = realDownloadDir + File.separator + fileName;
                if (d.a.n0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
                    d.a.n0.f.j.r.b.n().h("hasInstalled", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                    i iVar = this.f49540f;
                    if (iVar != null) {
                        iVar.a(new h(true));
                    }
                    q(str4);
                    return false;
                }
                File file = new File(str4);
                if (file.isFile() && file.exists()) {
                    this.f49536b.a(str2, this.f49540f);
                    if (d.a.n0.f.j.o.a.i(activity, str4, false)) {
                        new d.a.n0.f.j.n.a(d2).m("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        d.a.n0.f.j.r.b.n().h("showInstallView", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = d.a.n0.f.j.o.a.c();
                        if (d.a.n0.f.j.o.a.j(c2)) {
                            d.a.n0.a.a2.d.i().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    d.a.n0.f.j.r.b.n().h("showInstallViewFailed", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                    C(str2, this.f49540f);
                    this.f49539e.b(str2);
                    return false;
                }
                d.a.n0.f.j.r.b.n().h("nullGamenowFile", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                I(str, str2, str3);
                return false;
            } else {
                d.a.n0.f.j.r.b.n().h("nullPackagenameOrUrl", new d.a.n0.f.j.r.a(this.f49542h), str2, str3, str);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean u(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j)) == null) {
            if (new File(str).length() < j) {
                this.j = 3;
                return false;
            }
            try {
                ZipFile zipFile = new ZipFile(str);
                boolean z = zipFile.getEntry("AndroidManifest.xml") != null;
                zipFile.close();
                return z;
            } catch (Exception e2) {
                if (k) {
                    Log.e("GameNowAppManager", "解析APK出错:" + e2.getMessage());
                }
                this.j = 4;
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public final boolean v(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, download)) == null) {
            this.f49543i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.j = 2;
                    return false;
                }
                return u(str, longValue);
            }
            if (k) {
                Log.e("GameNowAppManager", "apk文件找不到");
            }
            this.j = 1;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) || n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f49539e.d(str2);
        String fromParam = d2 != null ? d2.getFromParam() : "";
        if (d.a.n0.f.j.o.a.k(AppRuntime.getAppContext(), str2)) {
            d.a.n0.f.j.r.b.n().h("manualOpen", new d.a.n0.f.j.r.a(this.f49542h), str2, fromParam, str);
        }
    }

    public void x(String str) {
        Download d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f49539e.d(str)) == null) {
            return;
        }
        if (d2.getState() == Download.DownloadState.WAITING || d2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f49538d.pause(d2.getId().longValue());
            i iVar = this.f49540f;
            if (iVar != null) {
                iVar.a(new h(d2));
            }
        }
    }

    public void y(String str) {
        Download d2;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f49539e.d(str)) == null || (iVar = this.f49540f) == null) {
            return;
        }
        iVar.a(new h(d2));
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                this.f49541g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.f49541g, intentFilter);
            }
        }
    }
}
