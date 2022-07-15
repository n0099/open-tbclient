package com.repackage;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile fr3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public gr3 a;
    public gr3 b;
    public DownloadManager c;
    public rr3 d;
    public JSONObject e;
    public AppDownloadNetworkStateReceiver f;
    public long g;

    /* loaded from: classes6.dex */
    public class a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fr3 fr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && rg1.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Download b;
        public final /* synthetic */ fr3 c;

        public b(fr3 fr3Var, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fr3Var;
            this.a = str;
            this.b = download;
        }

        @Override // com.repackage.zr3
        public void a(bs3 bs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bs3Var) == null) {
                if (bs3Var != null) {
                    if (bs3Var.d()) {
                        this.c.a.b(this.a, new cs3(this.b));
                    } else {
                        this.c.a.b(this.a, bs3Var);
                    }
                }
                this.c.C(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fr3 c;

        public c(fr3 fr3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fr3Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || vl2.a().b()) {
                return;
            }
            if (fr3.h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.b);
            if (this.c.e != null) {
                intent.putExtra("ubc_params", this.c.e.toString());
            }
            intent.setFlags(276824064);
            qc3.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr3 a;

        /* loaded from: classes6.dex */
        public class a implements zr3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Download b;
            public final /* synthetic */ d c;

            public a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.a = str;
                this.b = download;
            }

            @Override // com.repackage.zr3
            public void a(bs3 bs3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bs3Var) == null) {
                    if (bs3Var != null) {
                        if (bs3Var.d()) {
                            this.c.a.a.b(this.a, new cs3(this.b));
                        } else {
                            this.c.a.a.b(this.a, bs3Var);
                        }
                    }
                    this.c.a.C(this.a);
                }
            }
        }

        public d(fr3 fr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr3Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (fr3.h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!xw3.d().a(download)) {
                    hs3.a(download.getKeyByUser(), "startDownload", "success", null, new fs3(this.a.e));
                    hs3.d(2, download.getKeyByUser(), new pr3(download).c(), download.getUrl());
                }
                ds3.f().m(download, true, "downloadfinish");
            }
            if (this.a.a.d(valueOf)) {
                int i = h.a[download.getState().ordinal()];
                if (i == 1) {
                    this.a.d.f();
                    xw3.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new xr3(download, this.a.e).c(new a(this, valueOf, download));
                    if (xw3.d().a(download)) {
                        xw3.d().b(download);
                    }
                } else if (i == 2) {
                    this.a.a.b(valueOf, new as3(31015, "download is canceled"));
                    this.a.C(valueOf);
                } else if (i != 3) {
                } else {
                    this.a.a.b(valueOf, new as3(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr3 this$0;

        public e(fr3 fr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fr3Var;
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
            if (fr3.h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = this.this$0.d.o(schemeSpecificPart);
            if (!xw3.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                xw3.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.b.b(schemeSpecificPart, new cs3((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements zr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ fr3 d;

        public f(fr3 fr3Var, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fr3Var;
            this.a = download;
            this.b = str;
            this.c = str2;
        }

        @Override // com.repackage.zr3
        public void a(bs3 bs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bs3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (bs3Var != null) {
                    if (!bs3Var.d()) {
                        this.d.a.b(valueOf, bs3Var);
                    } else {
                        if (!TextUtils.isEmpty(this.b)) {
                            hs3.c("installSuccess", this.b, this.c);
                        }
                        this.d.a.b(valueOf, new cs3(this.a));
                    }
                }
                this.d.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements zr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;
        public final /* synthetic */ fr3 b;

        public g(fr3 fr3Var, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fr3Var;
            this.a = download;
        }

        @Override // com.repackage.zr3
        public void a(bs3 bs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bs3Var) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (bs3Var != null) {
                    if (bs3Var.d()) {
                        this.b.a.b(valueOf, new cs3(this.a));
                    } else {
                        this.b.a.b(valueOf, bs3Var);
                    }
                }
                this.b.C(valueOf);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376575578, "Lcom/repackage/fr3$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-376575578, "Lcom/repackage/fr3$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements zr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(fr3 fr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.zr3
        public void a(bs3 bs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bs3Var) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755698262, "Lcom/repackage/fr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755698262, "Lcom/repackage/fr3;");
                return;
            }
        }
        h = rg1.a;
    }

    public fr3() {
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
        this.a = new gr3();
        this.b = new gr3();
        this.g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.c = downloadManager;
        rr3 rr3Var = new rr3(downloadManager);
        this.d = rr3Var;
        rr3Var.e();
        this.d.m();
        A();
        z();
        if (h) {
            this.c.registerOnProgressChangeListener(new a(this));
        }
        ds3.f().j();
        F();
        o();
    }

    public static fr3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (fr3.class) {
                    if (i == null) {
                        i = new fr3();
                    }
                }
            }
            return i;
        }
        return (fr3) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, zr3Var) == null) {
            this.b.g(str, zr3Var);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.a.a(String.valueOf(download.getId()), new i(this));
            if (!xw3.d().a(download)) {
                hs3.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new fs3(this.e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                zr3Var.a(new as3(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.d.u(optString, optString2);
                    if (u == null) {
                        sr3.b().e(jSONObject, zr3Var);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), zr3Var);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new xr3(u, this.e).c(new b(this, valueOf, u));
                        return;
                    }
                    hs3.a(optString2, "resumeDownload", null, null, new fs3(this.e));
                    this.c.resume(u.getId().longValue());
                    return;
                }
                zr3Var.a(new as3(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f == null) {
                this.f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            oj2.c().registerReceiver(this.f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                zr3Var.a(new as3(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (vr3.h(AppRuntime.getAppContext(), str2)) {
                    zr3Var.a(new as3(31005, "apk is already installed"));
                } else if (j(str, zr3Var)) {
                    pr3 pr3Var = new pr3();
                    pr3Var.g(str);
                    pr3Var.f(str2);
                    pr3Var.a(str3);
                    Download b2 = pr3Var.b();
                    this.c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), zr3Var);
                    }
                    if (xw3.d().a(b2)) {
                        return;
                    }
                    hs3.a(str2, "startDownload", null, null, new fs3(this.e));
                    hs3.d(1, str2, str3, str);
                }
            } else {
                zr3Var.a(new as3(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, zr3Var) == null) || download.getId() == null) {
            return;
        }
        this.a.a(String.valueOf(download.getId()), zr3Var);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, zr3 zr3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, zr3Var)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g < 1000) {
                if (rg1.a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.g));
                }
                return false;
            }
            this.g = currentTimeMillis;
            Download v = this.d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (rg1.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 == 1) {
                h(v, zr3Var);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, zr3Var);
                if (rg1.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            } else if (i2 != 6) {
                this.d.g(str);
                return true;
            } else {
                h(v, zr3Var);
                this.c.resume(v.getId().longValue());
                if (rg1.a) {
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
                this.d.d();
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
                    if (h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            xw3.c().c(optString);
                            break;
                        }
                    }
                    hs3.a(optString2, "deleteDownload", null, null, new fs3(this.e));
                    this.d.h(r);
                    zr3Var.a(new cs3(r));
                    return;
                }
                sr3.b().a(jSONObject, zr3Var);
                return;
            }
            zr3Var.a(new as3(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            zs3.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.d.b(str)) {
                String i2 = this.d.i(str);
                if (TextUtils.isEmpty(i2) || !this.d.c(i2)) {
                    return;
                }
                hs3.a(str, "installHijack", null, null, new fs3(this.e));
                return;
            }
            hs3.a(str, "installApp", "success", null, new fs3(this.e));
            Download o = this.d.o(str);
            if (o != null) {
                hs3.d(3, str, new pr3(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.d.w(str)) == null) {
            return;
        }
        xr3 xr3Var = new xr3(w, this.e);
        if (!TextUtils.isEmpty(str2)) {
            hs3.c("notifyInstall", str2, str);
        }
        xr3Var.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull yr3 yr3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, yr3Var)) == null) {
            if (i()) {
                yr3Var.a(new as3(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                yr3Var.a(new as3(31007, "invalid params"));
                return null;
            } else {
                Download o = this.d.o(str2);
                if (o == null) {
                    yr3Var.a(new as3(31008, "download is not exist"));
                    this.d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    yr3Var.a(new as3(31017, "download is not finished"));
                    this.d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        yr3Var.a(new as3(31001, "database no package or file name"));
                        this.d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (vr3.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        yr3Var.a(new cs3("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (vd3.c() <= file.length()) {
                            yr3Var.a(new as3(31020, "not enough space to install"));
                            return null;
                        }
                        yr3Var.setPackageName(str2);
                        yr3Var.setFilePath(str3);
                        this.b.a(str2, yr3Var);
                        if (!vr3.j(context, str3, false)) {
                            t(str2);
                            B(str2, yr3Var);
                            yr3Var.a(new as3(31004, "apk install fail"));
                            this.d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = vr3.c();
                            if (vr3.k(c2)) {
                                g03.M().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    yr3Var.a(new as3(31002, "file is not exist"));
                    this.d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new xr3(download, this.e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.d.p(str)) {
                if (download != null) {
                    ds3.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.d.u(optString, optString2);
                if (u == null) {
                    sr3.b().c(jSONObject, zr3Var);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    zr3Var.a(new as3(31013, "download is not started"));
                    return;
                } else {
                    hs3.a(optString2, "pauseDownload", null, null, new fs3(this.e));
                    this.c.pause(u.getId().longValue());
                    zr3Var.a(new cs3(u));
                    return;
                }
            }
            zr3Var.a(new as3(31007, "invalid params"));
        }
    }

    public void w(@NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.d.n();
            if (n != null && !n.isEmpty()) {
                zr3Var.a(new cs3(n));
            } else {
                zr3Var.a(new as3(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, zr3Var) == null) {
            if (i()) {
                zr3Var.a(new as3(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                zr3Var.a(new as3(31007, "invalid params"));
                return;
            }
            Download v = this.d.v(optString);
            if (v == null) {
                sr3.b().d(jSONObject, zr3Var);
            } else {
                zr3Var.a(new cs3(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.d.v(str) : (Download) invokeL.objValue;
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }
}
