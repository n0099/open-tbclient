package d.a.q0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v2.k0;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f52888h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f52889i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.g.c.b f52890a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.g.c.b f52891b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f52892c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.g.c.d.c f52893d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f52894e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f52895f;

    /* renamed from: g  reason: collision with root package name */
    public long f52896g;

    /* renamed from: d.a.q0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1114a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1114a(a aVar) {
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
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) && k.f49133a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f52898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f52899c;

        public b(a aVar, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52899c = aVar;
            this.f52897a = str;
            this.f52898b = download;
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f52899c.f52890a.b(this.f52897a, new d.a.q0.g.c.g.c(this.f52898b));
                    } else {
                        this.f52899c.f52890a.b(this.f52897a, bVar);
                    }
                }
                this.f52899c.C(this.f52897a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52901f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f52902g;

        public c(a aVar, String str, String str2) {
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
            this.f52902g = aVar;
            this.f52900e = str;
            this.f52901f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.q0.a.g1.g.a().b()) {
                return;
            }
            if (a.f52888h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f52900e);
            intent.putExtra("packageName", this.f52901f);
            if (this.f52902g.f52894e != null) {
                intent.putExtra("ubc_params", this.f52902g.f52894e.toString());
            }
            intent.setFlags(276824064);
            d.a.q0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52903a;

        /* renamed from: d.a.q0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1115a implements d.a.q0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f52904a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f52905b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f52906c;

            public C1115a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52906c = dVar;
                this.f52904a = str;
                this.f52905b = download;
            }

            @Override // d.a.q0.g.c.f.b
            public void b(d.a.q0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f52906c.f52903a.f52890a.b(this.f52904a, new d.a.q0.g.c.g.c(this.f52905b));
                        } else {
                            this.f52906c.f52903a.f52890a.b(this.f52904a, bVar);
                        }
                    }
                    this.f52906c.f52903a.C(this.f52904a);
                }
            }
        }

        public d(a aVar) {
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
            this.f52903a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f52888h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.q0.h.t.a.d().a(download)) {
                    d.a.q0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.q0.g.c.i.a(this.f52903a.f52894e));
                    d.a.q0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.q0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.q0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f52903a.f52890a.d(valueOf)) {
                int i2 = h.f52913a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f52903a.f52893d.f();
                    d.a.q0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.q0.g.c.e.c(download, this.f52903a.f52894e).c(new C1115a(this, valueOf, download));
                    if (d.a.q0.h.t.a.d().a(download)) {
                        d.a.q0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f52903a.f52890a.b(valueOf, new d.a.q0.g.c.g.a(31015, "download is canceled"));
                    this.f52903a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f52903a.f52890a.b(valueOf, new d.a.q0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f52903a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public e(a aVar) {
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
            this.this$0 = aVar;
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
            if (a.f52888h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = this.this$0.f52893d.o(schemeSpecificPart);
            if (!d.a.q0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                d.a.q0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f52891b.b(schemeSpecificPart, new d.a.q0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f52907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52909c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f52910d;

        public f(a aVar, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52910d = aVar;
            this.f52907a = download;
            this.f52908b = str;
            this.f52909c = str2;
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f52907a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f52910d.f52890a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f52908b)) {
                            d.a.q0.g.c.i.c.c("installSuccess", this.f52908b, this.f52909c);
                        }
                        this.f52910d.f52890a.b(valueOf, new d.a.q0.g.c.g.c(this.f52907a));
                    }
                }
                this.f52910d.C(valueOf);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f52911a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f52912b;

        public g(a aVar, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52912b = aVar;
            this.f52911a = download;
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f52911a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f52912b.f52890a.b(valueOf, new d.a.q0.g.c.g.c(this.f52911a));
                    } else {
                        this.f52912b.f52890a.b(valueOf, bVar);
                    }
                }
                this.f52912b.C(valueOf);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52913a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054303765, "Ld/a/q0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1054303765, "Ld/a/q0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f52913a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52913a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52913a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52913a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52913a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52913a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
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
                }
            }
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1006682585, "Ld/a/q0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1006682585, "Ld/a/q0/g/c/a;");
                return;
            }
        }
        f52888h = k.f49133a;
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
        this.f52890a = new d.a.q0.g.c.b();
        this.f52891b = new d.a.q0.g.c.b();
        this.f52896g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f52892c = downloadManager;
        d.a.q0.g.c.d.c cVar = new d.a.q0.g.c.d.c(downloadManager);
        this.f52893d = cVar;
        cVar.e();
        this.f52893d.m();
        A();
        z();
        if (f52888h) {
            this.f52892c.registerOnProgressChangeListener(new C1114a(this));
        }
        d.a.q0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f52889i == null) {
                synchronized (a.class) {
                    if (f52889i == null) {
                        f52889i = new a();
                    }
                }
            }
            return f52889i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52892c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f52891b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f52890a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f52893d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f52890a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.q0.h.t.a.d().a(download)) {
                d.a.q0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.q0.g.c.i.a(this.f52894e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.q0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f52893d.u(optString, optString2);
                    if (u == null) {
                        d.a.q0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f52890a.d(valueOf)) {
                        this.f52890a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new d.a.q0.g.c.e.c(u, this.f52894e).c(new b(this, valueOf, u));
                        return;
                    }
                    d.a.q0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.q0.g.c.i.a(this.f52894e));
                    this.f52892c.resume(u.getId().longValue());
                    return;
                }
                bVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f52895f == null) {
                this.f52895f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.a.q0.a.c1.a.b().registerReceiver(this.f52895f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f52894e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.q0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (d.a.q0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.b(new d.a.q0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    d.a.q0.g.c.d.a aVar = new d.a.q0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f52892c.start(b2);
                    if (b2.getId() != null) {
                        this.f52890a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (d.a.q0.h.t.a.d().a(b2)) {
                        return;
                    }
                    d.a.q0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.q0.g.c.i.a(this.f52894e));
                    d.a.q0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f52890a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, d.a.q0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f52896g < 1000) {
                if (k.f49133a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f52896g));
                }
                return false;
            }
            this.f52896g = currentTimeMillis;
            Download v = this.f52893d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f49133a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.f52913a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                if (k.f49133a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            } else if (i2 != 6) {
                this.f52893d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f52892c.resume(v.getId().longValue());
                if (k.f49133a) {
                    Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f52893d.d();
            }
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (f52888h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f52893d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            d.a.q0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    d.a.q0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.q0.g.c.i.a(this.f52894e));
                    this.f52893d.h(r);
                    bVar.b(new d.a.q0.g.c.g.c(r));
                    return;
                }
                d.a.q0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.q0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f52893d.b(str)) {
                String i2 = this.f52893d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f52893d.c(i2)) {
                    return;
                }
                d.a.q0.g.c.i.c.a(str, "installHijack", null, null, new d.a.q0.g.c.i.a(this.f52894e));
                return;
            }
            d.a.q0.g.c.i.c.a(str, "installApp", "success", null, new d.a.q0.g.c.i.a(this.f52894e));
            Download o = this.f52893d.o(str);
            if (o != null) {
                d.a.q0.g.c.i.c.d(3, str, new d.a.q0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f52893d.w(str)) == null) {
            return;
        }
        d.a.q0.g.c.e.c cVar = new d.a.q0.g.c.e.c(w, this.f52894e);
        if (!TextUtils.isEmpty(str2)) {
            d.a.q0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull d.a.q0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f52893d.o(str2);
                if (o == null) {
                    aVar.b(new d.a.q0.g.c.g.a(31008, "download is not exist"));
                    this.f52893d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.b(new d.a.q0.g.c.g.a(31017, "download is not finished"));
                    this.f52893d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f52888h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.b(new d.a.q0.g.c.g.a(31001, "database no package or file name"));
                        this.f52893d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (d.a.q0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.b(new d.a.q0.g.c.g.c("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.b(new d.a.q0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.a(str3);
                        this.f52891b.a(str2, aVar);
                        if (!d.a.q0.g.c.e.a.j(context, str3, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.b(new d.a.q0.g.c.g.a(31004, "apk install fail"));
                            this.f52893d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = d.a.q0.g.c.e.a.c();
                            if (d.a.q0.g.c.e.a.k(c2)) {
                                d.a.q0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.b(new d.a.q0.g.c.g.a(31002, "file is not exist"));
                    this.f52893d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new d.a.q0.g.c.e.c(download, this.f52894e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f52893d.p(str)) {
                if (download != null) {
                    d.a.q0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f52893d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f52893d.u(optString, optString2);
                if (u == null) {
                    d.a.q0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.b(new d.a.q0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    d.a.q0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.q0.g.c.i.a(this.f52894e));
                    this.f52892c.pause(u.getId().longValue());
                    bVar.b(new d.a.q0.g.c.g.c(u));
                    return;
                }
            }
            bVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f52893d.n();
            if (n != null && !n.isEmpty()) {
                bVar.b(new d.a.q0.g.c.g.c(n));
            } else {
                bVar.b(new d.a.q0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.q0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.b(new d.a.q0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f52893d.v(optString);
            if (v == null) {
                d.a.q0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.b(new d.a.q0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f52893d.v(str) : (Download) invokeL.objValue;
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }
}
