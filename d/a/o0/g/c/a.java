package d.a.o0.g.c;

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
import d.a.o0.a.k;
import d.a.o0.a.v2.k0;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50090h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f50091i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.g.c.b f50092a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.g.c.b f50093b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f50094c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.g.c.d.c f50095d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50096e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f50097f;

    /* renamed from: g  reason: collision with root package name */
    public long f50098g;

    /* renamed from: d.a.o0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1072a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1072a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) && k.f46335a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f50100b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f50101c;

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
            this.f50101c = aVar;
            this.f50099a = str;
            this.f50100b = download;
        }

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f50101c.f50092a.b(this.f50099a, new d.a.o0.g.c.g.c(this.f50100b));
                    } else {
                        this.f50101c.f50092a.b(this.f50099a, bVar);
                    }
                }
                this.f50101c.C(this.f50099a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50104g;

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
            this.f50104g = aVar;
            this.f50102e = str;
            this.f50103f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.o0.a.g1.g.a().b()) {
                return;
            }
            if (a.f50090h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f50102e);
            intent.putExtra("packageName", this.f50103f);
            if (this.f50104g.f50096e != null) {
                intent.putExtra("ubc_params", this.f50104g.f50096e.toString());
            }
            intent.setFlags(276824064);
            d.a.o0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50105a;

        /* renamed from: d.a.o0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1073a implements d.a.o0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f50106a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f50107b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f50108c;

            public C1073a(d dVar, String str, Download download) {
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
                this.f50108c = dVar;
                this.f50106a = str;
                this.f50107b = download;
            }

            @Override // d.a.o0.g.c.f.b
            public void b(d.a.o0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f50108c.f50105a.f50092a.b(this.f50106a, new d.a.o0.g.c.g.c(this.f50107b));
                        } else {
                            this.f50108c.f50105a.f50092a.b(this.f50106a, bVar);
                        }
                    }
                    this.f50108c.f50105a.C(this.f50106a);
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
            this.f50105a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f50090h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!d.a.o0.h.t.a.d().a(download)) {
                    d.a.o0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new d.a.o0.g.c.i.a(this.f50105a.f50096e));
                    d.a.o0.g.c.i.c.d(2, download.getKeyByUser(), new d.a.o0.g.c.d.a(download).c(), download.getUrl());
                }
                d.a.o0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f50105a.f50092a.d(valueOf)) {
                int i2 = h.f50115a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f50105a.f50095d.f();
                    d.a.o0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new d.a.o0.g.c.e.c(download, this.f50105a.f50096e).c(new C1073a(this, valueOf, download));
                    if (d.a.o0.h.t.a.d().a(download)) {
                        d.a.o0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f50105a.f50092a.b(valueOf, new d.a.o0.g.c.g.a(31015, "download is canceled"));
                    this.f50105a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f50105a.f50092a.b(valueOf, new d.a.o0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f50105a.C(valueOf);
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
            if (a.f50090h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = this.this$0.f50095d.o(schemeSpecificPart);
            if (!d.a.o0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                d.a.o0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f50093b.b(schemeSpecificPart, new d.a.o0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50111c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f50112d;

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
            this.f50112d = aVar;
            this.f50109a = download;
            this.f50110b = str;
            this.f50111c = str2;
        }

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f50109a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f50112d.f50092a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f50110b)) {
                            d.a.o0.g.c.i.c.c("installSuccess", this.f50110b, this.f50111c);
                        }
                        this.f50112d.f50092a.b(valueOf, new d.a.o0.g.c.g.c(this.f50109a));
                    }
                }
                this.f50112d.C(valueOf);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.o0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f50113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f50114b;

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
            this.f50114b = aVar;
            this.f50113a = download;
        }

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f50113a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f50114b.f50092a.b(valueOf, new d.a.o0.g.c.g.c(this.f50113a));
                    } else {
                        this.f50114b.f50092a.b(valueOf, bVar);
                    }
                }
                this.f50114b.C(valueOf);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50115a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353239187, "Ld/a/o0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(353239187, "Ld/a/o0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f50115a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50115a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50115a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50115a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50115a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50115a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.g.c.f.b {
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

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(326624215, "Ld/a/o0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(326624215, "Ld/a/o0/g/c/a;");
                return;
            }
        }
        f50090h = k.f46335a;
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
        this.f50092a = new d.a.o0.g.c.b();
        this.f50093b = new d.a.o0.g.c.b();
        this.f50098g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f50094c = downloadManager;
        d.a.o0.g.c.d.c cVar = new d.a.o0.g.c.d.c(downloadManager);
        this.f50095d = cVar;
        cVar.e();
        this.f50095d.m();
        A();
        z();
        if (f50090h) {
            this.f50094c.registerOnProgressChangeListener(new C1072a(this));
        }
        d.a.o0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f50091i == null) {
                synchronized (a.class) {
                    if (f50091i == null) {
                        f50091i = new a();
                    }
                }
            }
            return f50091i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f50094c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f50093b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f50092a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f50095d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f50092a.a(String.valueOf(download.getId()), new i(this));
            if (!d.a.o0.h.t.a.d().a(download)) {
                d.a.o0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new d.a.o0.g.c.i.a(this.f50096e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.o0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f50095d.u(optString, optString2);
                    if (u == null) {
                        d.a.o0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f50092a.d(valueOf)) {
                        this.f50092a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new d.a.o0.g.c.e.c(u, this.f50096e).c(new b(this, valueOf, u));
                        return;
                    }
                    d.a.o0.g.c.i.c.a(optString2, "resumeDownload", null, null, new d.a.o0.g.c.i.a(this.f50096e));
                    this.f50094c.resume(u.getId().longValue());
                    return;
                }
                bVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f50097f == null) {
                this.f50097f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.a.o0.a.c1.a.b().registerReceiver(this.f50097f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f50096e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new d.a.o0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (d.a.o0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.b(new d.a.o0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    d.a.o0.g.c.d.a aVar = new d.a.o0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f50094c.start(b2);
                    if (b2.getId() != null) {
                        this.f50092a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (d.a.o0.h.t.a.d().a(b2)) {
                        return;
                    }
                    d.a.o0.g.c.i.c.a(str2, "startDownload", null, null, new d.a.o0.g.c.i.a(this.f50096e));
                    d.a.o0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f50092a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, d.a.o0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f50098g < 1000) {
                if (k.f46335a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f50098g));
                }
                return false;
            }
            this.f50098g = currentTimeMillis;
            Download v = this.f50095d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f46335a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.f50115a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                if (k.f46335a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            } else if (i2 != 6) {
                this.f50095d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f50094c.resume(v.getId().longValue());
                if (k.f46335a) {
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
                this.f50095d.d();
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
                    if (f50090h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f50095d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            d.a.o0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    d.a.o0.g.c.i.c.a(optString2, "deleteDownload", null, null, new d.a.o0.g.c.i.a(this.f50096e));
                    this.f50095d.h(r);
                    bVar.b(new d.a.o0.g.c.g.c(r));
                    return;
                }
                d.a.o0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.o0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f50095d.b(str)) {
                String i2 = this.f50095d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f50095d.c(i2)) {
                    return;
                }
                d.a.o0.g.c.i.c.a(str, "installHijack", null, null, new d.a.o0.g.c.i.a(this.f50096e));
                return;
            }
            d.a.o0.g.c.i.c.a(str, "installApp", "success", null, new d.a.o0.g.c.i.a(this.f50096e));
            Download o = this.f50095d.o(str);
            if (o != null) {
                d.a.o0.g.c.i.c.d(3, str, new d.a.o0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f50095d.w(str)) == null) {
            return;
        }
        d.a.o0.g.c.e.c cVar = new d.a.o0.g.c.e.c(w, this.f50096e);
        if (!TextUtils.isEmpty(str2)) {
            d.a.o0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull d.a.o0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f50095d.o(str2);
                if (o == null) {
                    aVar.b(new d.a.o0.g.c.g.a(31008, "download is not exist"));
                    this.f50095d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.b(new d.a.o0.g.c.g.a(31017, "download is not finished"));
                    this.f50095d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f50090h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.b(new d.a.o0.g.c.g.a(31001, "database no package or file name"));
                        this.f50095d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (d.a.o0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.b(new d.a.o0.g.c.g.c("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.b(new d.a.o0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.a(str3);
                        this.f50093b.a(str2, aVar);
                        if (!d.a.o0.g.c.e.a.j(context, str3, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.b(new d.a.o0.g.c.g.a(31004, "apk install fail"));
                            this.f50095d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = d.a.o0.g.c.e.a.c();
                            if (d.a.o0.g.c.e.a.k(c2)) {
                                d.a.o0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.b(new d.a.o0.g.c.g.a(31002, "file is not exist"));
                    this.f50095d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new d.a.o0.g.c.e.c(download, this.f50096e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f50095d.p(str)) {
                if (download != null) {
                    d.a.o0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f50095d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f50095d.u(optString, optString2);
                if (u == null) {
                    d.a.o0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.b(new d.a.o0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    d.a.o0.g.c.i.c.a(optString2, "pauseDownload", null, null, new d.a.o0.g.c.i.a(this.f50096e));
                    this.f50094c.pause(u.getId().longValue());
                    bVar.b(new d.a.o0.g.c.g.c(u));
                    return;
                }
            }
            bVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f50095d.n();
            if (n != null && !n.isEmpty()) {
                bVar.b(new d.a.o0.g.c.g.c(n));
            } else {
                bVar.b(new d.a.o0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new d.a.o0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.b(new d.a.o0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f50095d.v(optString);
            if (v == null) {
                d.a.o0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.b(new d.a.o0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f50095d.v(str) : (Download) invokeL.objValue;
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
