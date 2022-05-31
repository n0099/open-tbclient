package com.repackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.repackage.ho3;
import com.repackage.wm3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class no3 implements sn3, tn3, qn3, un3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String D = "0";
    public static String E = "101";
    public static String F = "102";
    public static String G = "103";
    public static String H = "104";
    public static String I = "1";
    public static String J = "0";
    public static String K = "status";
    public static String L = "isPaused";
    public static String M = "token";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> A;
    public zm3 B;
    public Activity C;
    public Context a;
    public bp3 b;
    public bo3 c;
    public AdElementInfo d;
    public int e;
    public int f;
    public wm3 g;
    public String h;
    public String i;
    public mo3 j;
    public go3 k;
    public String l;
    public co3 m;
    public String n;
    public String o;
    public Map<String, String> p;
    public qo3 q;
    public DownloadState r;
    public DownloadParams s;
    public hn3 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public wn3 y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public a(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a0();
                if (this.a.y.c(this.a.b.r())) {
                    this.a.y.removeView(this.a.b.r());
                }
                if (!this.a.y.d(this.a.b.r(), qm3.a())) {
                    this.a.X("3010000");
                    return;
                }
                this.a.e = 260;
                this.a.b.G(this.a.d.getVideoUrl());
                po3.n("showSuccess", this.a.A, this.a.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public c(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public d(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (!this.a.x || this.a.b == null) {
                    this.a.S();
                    return;
                }
                if (this.a.c != null) {
                    this.a.c.pause();
                }
                this.a.e = 262;
                this.a.b.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements hn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public e(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // com.repackage.hn3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i == 0 || i > 100) {
                return;
            }
            if (i != 100 || this.a.n == no3.E) {
                if (this.a.n == no3.E || this.a.n == no3.H) {
                    return;
                }
                this.a.n = String.valueOf(i);
                return;
            }
            this.a.n = no3.F;
        }

        @Override // com.repackage.hn3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q.c("appinstallbegin");
            }
        }

        @Override // com.repackage.hn3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                if (!this.a.u) {
                    this.a.m0(downloadState);
                }
                this.a.u = true;
                if (this.a.r == downloadState) {
                    return;
                }
                if (this.a.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.o = no3.J;
                    this.a.q.c("appdownloadbegin");
                } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (this.a.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                        this.a.o = no3.J;
                        this.a.q.c("appdownloadcontinue");
                    } else if (downloadState == DownloadState.DOWNLOADED) {
                        this.a.o = no3.J;
                        this.a.n = no3.F;
                        this.a.q.c("appdownloadfinish");
                        this.a.q.c("appinstallbegin");
                    } else if (downloadState == DownloadState.INSTALLED) {
                        this.a.o = no3.J;
                        this.a.n = no3.G;
                        this.a.q.c("appinstallfinish");
                    } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                        this.a.o = no3.J;
                        this.a.n = no3.H;
                    }
                } else {
                    this.a.o = no3.I;
                    this.a.q.c("appdownloadpause");
                }
                this.a.r = downloadState;
            }
        }

        @Override // com.repackage.hn3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // com.repackage.hn3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // com.repackage.hn3
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements vn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public f(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // com.repackage.vn3
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }

        @Override // com.repackage.vn3
        public boolean onError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.a.j0();
                this.a.X("3010001");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.vn3
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.z();
        }

        @Override // com.repackage.vn3
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.b.y();
                }
                this.a.e = com.kuaishou.weapon.un.w0.F;
                this.a.f = 0;
                if (this.a.b != null) {
                    this.a.b.p();
                }
                if (this.a.j != null) {
                    this.a.j.b(true, "");
                }
                if (this.a.v) {
                    ro3.f(this.a.d, this.a.k);
                } else {
                    po3.j(this.a.d, this.a.k);
                    po3.q(this.a.d, this.a.k);
                    String str = this.a.i;
                    no3 no3Var = this.a;
                    po3.f(str, no3Var.h, no3Var.l, this.a.k);
                }
                po3.n("show", this.a.A, this.a.k);
            }
        }

        @Override // com.repackage.vn3
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.D();
        }

        @Override // com.repackage.vn3
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-150312964, "Lcom/repackage/no3$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-150312964, "Lcom/repackage/no3$g;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CommandType.DOWNLOAD_PERMISSION_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CommandType.DOWNLOAD_PRIVACY_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755462817, "Lcom/repackage/no3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755462817, "Lcom/repackage/no3;");
        }
    }

    public no3(Activity activity, String str, String str2, boolean z, mo3 mo3Var, wn3 wn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), mo3Var, wn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 256;
        this.f = 0;
        this.h = "";
        this.n = E;
        this.o = J;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.i = str;
        this.h = str2;
        this.v = z;
        this.w = z;
        this.k = new go3(appContext);
        this.m = new co3();
        this.x = ap3.i();
        this.j = mo3Var;
        this.y = wn3Var;
        this.C = activity;
    }

    public synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.c != null && this.b != null) {
                    if (this.g == null || !this.g.isShowing()) {
                        if (!this.b.t()) {
                            this.c.resume();
                        } else {
                            po3.q(this.d, this.k);
                        }
                    }
                }
            }
        }
    }

    public final oo3 O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            oo3 oo3Var = new oo3();
            oo3Var.i = String.valueOf(this.d.getDuration());
            oo3Var.j = String.valueOf(this.f);
            oo3Var.k = String.valueOf(i);
            String str = "1";
            oo3Var.l = this.f == 0 ? "1" : "0";
            oo3Var.m = i == this.d.getDuration() ? "1" : "0";
            int i2 = 1;
            oo3Var.n = this.a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i3 = this.f;
            if (i3 != 0) {
                i2 = i3 == this.d.getDuration() ? 3 : 2;
            }
            oo3Var.o = String.valueOf(i2);
            oo3Var.p = (this.f == 0 && NetworkUtils.g(this.a)) ? "2" : "2";
            oo3Var.q = String.valueOf(0);
            return oo3Var;
        }
        return (oo3) invokeI.objValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bo3 bo3Var = this.c;
            if (bo3Var != null && bo3Var.isEnd()) {
                return this.c.getDuration() / 1000;
            }
            return Q();
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            bo3 bo3Var = this.c;
            if (bo3Var != null) {
                return bo3Var.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.c == null || this.b == null) {
            return;
        }
        i0();
        this.e = 262;
        if (this.b != null) {
            if (this.c.isEnd()) {
                this.b.A();
            } else {
                this.b.B();
            }
        }
    }

    public final void S() {
        bo3 bo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j != null && (bo3Var = this.c) != null) {
                int duration = bo3Var.getDuration() / 1000;
                this.j.c(this.c.isEnd() || this.c.getCurrentPosition() / 1000 >= Math.min(this.d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            po3.p(this.d, this.k);
            this.e = 263;
            c0();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (yo3.a(this.a, this.s.b)) {
                this.n = G;
                f0(this.a, this.s.b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = D;
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = J;
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = F;
                this.t.b();
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                f0(this.a, this.s.b);
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S();
        }
    }

    public final void V(View view2) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.v && (adElementInfo = this.d) != null) {
            ro3.d(adElementInfo, this.k);
            oo3 oo3Var = new oo3();
            oo3Var.a = String.valueOf(zo3.i(this.a));
            oo3Var.b = String.valueOf(zo3.h(this.a));
            oo3Var.c = String.valueOf(zo3.i(this.a));
            oo3Var.d = String.valueOf(zo3.h(this.a));
            oo3Var.e = String.valueOf((int) view2.getX());
            oo3Var.f = String.valueOf((int) view2.getY());
            oo3Var.g = String.valueOf((int) view2.getX());
            oo3Var.h = String.valueOf((int) view2.getY());
            if (this.d.getActionType() == 2) {
                ro3.a(oo3Var, this.d, this.k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.d;
            if (adElementInfo2 != null) {
                this.y.a(ro3.c(adElementInfo2.getClickUrl(), oo3Var), new JSONObject());
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", po3.b("landingPageLoad", this.A));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            mo3 mo3Var = this.j;
            if (mo3Var != null) {
                mo3Var.onError(str);
                this.j.b(false, "");
            }
            this.e = 264;
        }
    }

    public final boolean Y(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        context.getPackageManager().getPackageInfo(str, 0);
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q = new qo3(this.a, this.d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.d.getClickUrl();
            String packageName = this.d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.d.getTitle());
            this.u = false;
            if (zo3.o()) {
                yn3.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // com.repackage.sn3
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                this.e = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
                d0(str);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.b = new cp3(this.a, this.d, this.m);
            } else {
                this.b = new dp3(this.a, this.d, this.m);
            }
            if (this.v) {
                this.b.F(this);
            }
            this.b.E(this);
            bo3 s = this.b.s();
            this.c = s;
            s.g(new f(this));
            this.b.r().setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100af));
        }
    }

    @Override // com.repackage.qn3
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, commandType, uri) == null) {
            synchronized (this) {
                this.d.getClickUrl();
                String packageName = this.d.getPackageName();
                int i = g.a[commandType.ordinal()];
                if (i == 1) {
                    if (this.d.getActionType() == 2) {
                        T();
                    } else {
                        W();
                        po3.n("lpClick", this.A, this.k);
                    }
                    po3.g(this.d, this.k);
                    po3.n("click", this.A, this.k);
                } else if (i != 2) {
                    if (i == 3) {
                        this.o = I;
                        T();
                    } else if (i == 4) {
                        g0();
                    } else if (i == 5) {
                        h0();
                    }
                } else if (this.m == null) {
                } else {
                    if (Y(this.a, packageName)) {
                        this.n = G;
                    }
                    String queryParameter = uri.getQueryParameter(M);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(K, this.n);
                        jSONObject.put(L, this.o);
                        this.m.b(queryParameter, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AdElementInfo adElementInfo = this.d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sn3
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adElementInfo) == null) {
            synchronized (this) {
                this.d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.e = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512;
                e0();
                if (!this.v && this.d.getActionType() == 2) {
                    Z();
                }
            }
        }
    }

    public synchronized void c0() {
        jo3 lo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                if (this.e == 257) {
                    return;
                }
                po3.n("loadApi", this.A, this.k);
                yn3.a().b(this.v);
                int i = this.e;
                if (i != 256 && i != 272) {
                    switch (i) {
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                            if (b0()) {
                                this.e = 272;
                                return;
                            } else {
                                e0();
                                return;
                            }
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                        case 262:
                        case 263:
                        case 264:
                            break;
                        case 260:
                        case com.kuaishou.weapon.un.w0.F /* 261 */:
                        case 265:
                            d0("3010006");
                            return;
                        default:
                            return;
                    }
                }
                String appKey = yn3.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.h)) {
                    this.e = 257;
                    ho3.b bVar = new ho3.b();
                    bVar.m(this.i);
                    bVar.j(this.h);
                    bVar.o(appKey);
                    bVar.l(zo3.i(this.a));
                    bVar.i(zo3.h(this.a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    ho3 h = bVar.h();
                    if (this.w) {
                        this.v = true;
                        lo3Var = new ko3(this.a, h, 5, 5);
                    } else {
                        this.v = false;
                        lo3Var = new lo3(this.a, h);
                        this.l = lo3Var.c();
                    }
                    eo3 eo3Var = new eo3(this.a, false);
                    eo3Var.k(this);
                    eo3Var.i(lo3Var, this.k);
                    return;
                }
                d0("3010007");
            }
        }
    }

    @Override // com.repackage.un3
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.d.getTitle());
                        jSONObject.put("description", this.d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.B == null) {
                            this.B = new zm3(this.a, this.d, this.k);
                        }
                        this.B.k(str);
                        yn3.b().d(this.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.B);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void d0(String str) {
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (mo3Var = this.j) == null) {
            return;
        }
        mo3Var.onError(str);
        this.j.a(false, str);
    }

    @Override // com.repackage.tn3
    public synchronized void e(View view2) {
        int min;
        int i;
        int i2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            synchronized (this) {
                if (this.c != null && this.d != null) {
                    if (this.g == null || !this.g.isShowing()) {
                        if (view2 != null && R.id.obfuscated_res_0x7f090646 != view2.getId()) {
                            U();
                            return;
                        }
                        int currentPosition = this.c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.d.getRewardTime(), this.c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            R();
                            return;
                        }
                        int q = yn3.b().q();
                        int p = yn3.b().p();
                        if (this.y.b()) {
                            min = (int) (q * 0.275f);
                            i2 = (int) (p * 0.05f);
                            i = min;
                        } else {
                            min = (int) (Math.min(q, p) * 0.1f);
                            i = min;
                            i2 = 0;
                        }
                        i0();
                        this.a.getResources().getString(R.string.obfuscated_res_0x7f0f133a);
                        if (this.x) {
                            format = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f133b), Integer.valueOf(15 - (this.c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f133d), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.g != null) {
                            this.g.d(format);
                            this.g.show();
                        } else {
                            wm3.a aVar = new wm3.a(this.C);
                            aVar.c(true);
                            aVar.i(R.string.obfuscated_res_0x7f0f00a4, new d(this));
                            aVar.g(format);
                            aVar.l(R.string.obfuscated_res_0x7f0f00a7, new c(this));
                            aVar.n(R.color.obfuscated_res_0x7f060a2b);
                            aVar.k(new b(this));
                            aVar.f(min, 0, i, i2);
                            this.g = aVar.p();
                        }
                    }
                }
            }
        }
    }

    public final void e0() {
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (mo3Var = this.j) == null) {
            return;
        }
        mo3Var.a(true, "");
    }

    @Override // com.repackage.un3
    public synchronized void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            synchronized (this) {
                if (this.j != null) {
                    this.j.onClick(P());
                }
                if (this.v) {
                    V(view2);
                }
            }
        }
    }

    public final boolean f0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.iterator().next() == null) {
                return false;
            }
            String str2 = queryIntentActivities.iterator().next().activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return yn3.b().b(context, intent2, yn3.b().getAppKey(), null, str);
        }
        return invokeLL.booleanValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.y.a(this.d.getPermissionUrl(), new JSONObject());
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y.a(this.d.getPrivacyUrl(), new JSONObject());
        }
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.c != null && this.b != null) {
                    if (this.c.isPlaying()) {
                        this.c.pause();
                        if (this.v) {
                            ro3.g(O(Q()), this.d, this.k);
                        } else {
                            po3.o(Q(), this.f, this.d, this.k);
                        }
                    } else {
                        po3.o(Q(), this.f, this.d, this.k);
                        this.f = Q();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            bo3 bo3Var = this.c;
            if (bo3Var != null) {
                bo3Var.pause();
                this.c.stop();
            }
            bp3 bp3Var = this.b;
            if (bp3Var != null) {
                bp3Var.n();
                this.b.r().setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100ae));
                this.y.removeView(this.b.r());
                this.b = null;
            }
            zm3 zm3Var = this.B;
            if (zm3Var != null) {
                zm3Var.i();
                this.B = null;
            }
        }
    }

    public void k0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, map) == null) {
            this.A = map;
            this.z = po3.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                po3.n("showApi", this.A, this.k);
                if (this.e != 261 && this.e != 260 && this.e != 265) {
                    if (this.e == 258 && !b0()) {
                        if (this.d != null && TextUtils.isEmpty(this.d.getVideoUrl())) {
                            X("3010008");
                            return;
                        }
                        if (this.e == 258) {
                            this.e = 265;
                            this.y.e();
                            vo3.c(new a(this));
                        }
                        return;
                    }
                    X("3010004");
                    return;
                }
                if (this.j != null) {
                    this.j.onError("3010004");
                    this.j.b(false, "3010004");
                }
            }
        }
    }

    public final void m0(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, downloadState) == null) {
            this.r = downloadState;
            if (downloadState == DownloadState.NOT_START) {
                this.n = E;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                this.n = D;
                this.o = I;
            } else if (downloadState == DownloadState.DOWNLOADED) {
                this.n = F;
                this.o = J;
            } else if (downloadState == DownloadState.INSTALLED) {
                this.n = G;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOADING) {
                this.n = D;
                this.o = J;
            }
        }
    }
}
