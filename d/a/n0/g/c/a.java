package d.a.n0.g.c;

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
import d.a.n0.a.k;
import d.a.n0.a.v2.k0;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49586h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f49587i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.g.c.b f49588a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.g.c.b f49589b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f49590c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g.c.d.c f49591d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49592e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f49593f;

    /* renamed from: g  reason: collision with root package name */
    public long f49594g;

    /* renamed from: d.a.n0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1063a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1063a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) && k.f45831a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49595a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f49596b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f49597c;

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
            this.f49597c = aVar;
            this.f49595a = str;
            this.f49596b = download;
        }

        @Override // d.a.n0.g.c.f.b
        public void b(d.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f49597c.f49588a.b(this.f49595a, new d.a.n0.g.c.g.c(this.f49596b));
                    } else {
                        this.f49597c.f49588a.b(this.f49595a, bVar);
                    }
                }
                this.f49597c.C(this.f49595a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49599f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49600g;

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
            this.f49600g = aVar;
            this.f49598e = str;
            this.f49599f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.n0.a.g1.g.a().b()) {
                return;
            }
            if (a.f49586h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f49598e);
            intent.putExtra("packageName", this.f49599f);
            if (this.f49600g.f49592e != null) {
                intent.putExtra("ubc_params", this.f49600g.f49592e.toString());
            }
            intent.setFlags(276824064);
            d.a.n0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f49601a;

        /* renamed from: d.a.n0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1064a implements d.a.n0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f49602a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f49603b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f49604c;

            public C1064a(d dVar, String str, Download download) {
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
                this.f49604c = dVar;
                this.f49602a = str;
                this.f49603b = download;
            }

            @Override // d.a.n0.g.c.f.b
            public void b(d.a.n0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f49604c.f49601a.f49588a.b(this.f49602a, new d.a.n0.g.c.g.c(this.f49603b));
                        } else {
                            this.f49604c.f49601a.f49588a.b(this.f49602a, bVar);
                        }
                    }
                    this.f49604c.f49601a.C(this.f49602a);
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
            this.f49601a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f49586h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.n0.h.t.a.d().a(download)) {
                    d.a.n0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.n0.g.c.i.a(this.f49601a.f49592e));
                    d.a.n0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.n0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.n0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f49601a.f49588a.d(valueOf)) {
                int i2 = h.f49611a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f49601a.f49591d.f();
                    d.a.n0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.n0.g.c.e.c(download, this.f49601a.f49592e).c(new C1064a(this, valueOf, download));
                    if (d.a.n0.h.t.a.d().a(download)) {
                        d.a.n0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f49601a.f49588a.b(valueOf, new d.a.n0.g.c.g.a(31015, "download is canceled"));
                    this.f49601a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f49601a.f49588a.b(valueOf, new d.a.n0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f49601a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (a.f49586h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = this.this$0.f49591d.o(schemeSpecificPart);
            if (!d.a.n0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                d.a.n0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f49589b.b(schemeSpecificPart, new d.a.n0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f49605a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f49608d;

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
            this.f49608d = aVar;
            this.f49605a = download;
            this.f49606b = str;
            this.f49607c = str2;
        }

        @Override // d.a.n0.g.c.f.b
        public void b(d.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f49605a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f49608d.f49588a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f49606b)) {
                            d.a.n0.g.c.i.c.c("installSuccess", this.f49606b, this.f49607c);
                        }
                        this.f49608d.f49588a.b(valueOf, new d.a.n0.g.c.g.c(this.f49605a));
                    }
                }
                this.f49608d.C(valueOf);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f49609a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f49610b;

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
            this.f49610b = aVar;
            this.f49609a = download;
        }

        @Override // d.a.n0.g.c.f.b
        public void b(d.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f49609a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f49610b.f49588a.b(valueOf, new d.a.n0.g.c.g.c(this.f49609a));
                    } else {
                        this.f49610b.f49588a.b(valueOf, bVar);
                    }
                }
                this.f49610b.C(valueOf);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49611a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144776750, "Ld/a/n0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2144776750, "Ld/a/n0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f49611a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49611a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49611a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49611a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49611a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f49611a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.n0.g.c.f.b {
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

        @Override // d.a.n0.g.c.f.b
        public void b(d.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2134078678, "Ld/a/n0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2134078678, "Ld/a/n0/g/c/a;");
                return;
            }
        }
        f49586h = k.f45831a;
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
        this.f49588a = new d.a.n0.g.c.b();
        this.f49589b = new d.a.n0.g.c.b();
        this.f49594g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f49590c = downloadManager;
        d.a.n0.g.c.d.c cVar = new d.a.n0.g.c.d.c(downloadManager);
        this.f49591d = cVar;
        cVar.e();
        this.f49591d.m();
        A();
        z();
        if (f49586h) {
            this.f49590c.registerOnProgressChangeListener(new C1063a(this));
        }
        d.a.n0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f49587i == null) {
                synchronized (a.class) {
                    if (f49587i == null) {
                        f49587i = new a();
                    }
                }
            }
            return f49587i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49590c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f49589b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f49588a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f49591d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f49588a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.n0.h.t.a.d().a(download)) {
                d.a.n0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.n0.g.c.i.a(this.f49592e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.n0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f49591d.u(optString, optString2);
                    if (u == null) {
                        d.a.n0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f49588a.d(valueOf)) {
                        this.f49588a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new d.a.n0.g.c.e.c(u, this.f49592e).c(new b(this, valueOf, u));
                        return;
                    }
                    d.a.n0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.n0.g.c.i.a(this.f49592e));
                    this.f49590c.resume(u.getId().longValue());
                    return;
                }
                bVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f49593f == null) {
                this.f49593f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.a.n0.a.c1.a.b().registerReceiver(this.f49593f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f49592e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.n0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (d.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.b(new d.a.n0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    d.a.n0.g.c.d.a aVar = new d.a.n0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f49590c.start(b2);
                    if (b2.getId() != null) {
                        this.f49588a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (d.a.n0.h.t.a.d().a(b2)) {
                        return;
                    }
                    d.a.n0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.n0.g.c.i.a(this.f49592e));
                    d.a.n0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f49588a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, d.a.n0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f49594g < 1000) {
                if (k.f45831a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f49594g));
                }
                return false;
            }
            this.f49594g = currentTimeMillis;
            Download v = this.f49591d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f45831a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.f49611a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                if (k.f45831a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            } else if (i2 != 6) {
                this.f49591d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f49590c.resume(v.getId().longValue());
                if (k.f45831a) {
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
                this.f49591d.d();
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
                    if (f49586h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f49591d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            d.a.n0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    d.a.n0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.n0.g.c.i.a(this.f49592e));
                    this.f49591d.h(r);
                    bVar.b(new d.a.n0.g.c.g.c(r));
                    return;
                }
                d.a.n0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.n0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f49591d.b(str)) {
                String i2 = this.f49591d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f49591d.c(i2)) {
                    return;
                }
                d.a.n0.g.c.i.c.a(str, "installHijack", null, null, new d.a.n0.g.c.i.a(this.f49592e));
                return;
            }
            d.a.n0.g.c.i.c.a(str, "installApp", "success", null, new d.a.n0.g.c.i.a(this.f49592e));
            Download o = this.f49591d.o(str);
            if (o != null) {
                d.a.n0.g.c.i.c.d(3, str, new d.a.n0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f49591d.w(str)) == null) {
            return;
        }
        d.a.n0.g.c.e.c cVar = new d.a.n0.g.c.e.c(w, this.f49592e);
        if (!TextUtils.isEmpty(str2)) {
            d.a.n0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull d.a.n0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f49591d.o(str2);
                if (o == null) {
                    aVar.b(new d.a.n0.g.c.g.a(31008, "download is not exist"));
                    this.f49591d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.b(new d.a.n0.g.c.g.a(31017, "download is not finished"));
                    this.f49591d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f49586h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.b(new d.a.n0.g.c.g.a(31001, "database no package or file name"));
                        this.f49591d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (d.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.b(new d.a.n0.g.c.g.c("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.b(new d.a.n0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.a(str3);
                        this.f49589b.a(str2, aVar);
                        if (!d.a.n0.g.c.e.a.j(context, str3, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.b(new d.a.n0.g.c.g.a(31004, "apk install fail"));
                            this.f49591d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = d.a.n0.g.c.e.a.c();
                            if (d.a.n0.g.c.e.a.k(c2)) {
                                d.a.n0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.b(new d.a.n0.g.c.g.a(31002, "file is not exist"));
                    this.f49591d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new d.a.n0.g.c.e.c(download, this.f49592e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f49591d.p(str)) {
                if (download != null) {
                    d.a.n0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f49591d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f49591d.u(optString, optString2);
                if (u == null) {
                    d.a.n0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.b(new d.a.n0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    d.a.n0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.n0.g.c.i.a(this.f49592e));
                    this.f49590c.pause(u.getId().longValue());
                    bVar.b(new d.a.n0.g.c.g.c(u));
                    return;
                }
            }
            bVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f49591d.n();
            if (n != null && !n.isEmpty()) {
                bVar.b(new d.a.n0.g.c.g.c(n));
            } else {
                bVar.b(new d.a.n0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.b(new d.a.n0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f49591d.v(optString);
            if (v == null) {
                d.a.n0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.b(new d.a.n0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f49591d.v(str) : (Download) invokeL.objValue;
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
