package d.a.q0.f.i.p;

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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import d.a.q0.f.i.j.a;
import d.a.q0.f.i.o.c;
import d.a.q0.f.i.r.h;
import d.a.q0.f.i.r.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements d.a.q0.f.i.l.b, d.a.q0.f.i.l.c, d.a.q0.f.i.l.a, d.a.q0.f.i.l.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String E = "0";
    public static String F = "101";
    public static String G = "102";
    public static String H = "103";
    public static String I = "104";
    public static String J = "1";
    public static String K = "0";
    public static String L = "status";
    public static String M = "isPaused";
    public static String N = "token";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Map<String, String> B;
    public d.a.q0.f.i.k.b C;
    public Activity D;

    /* renamed from: a  reason: collision with root package name */
    public Context f52728a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.f.i.s.a f52729b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.f.i.m.b.c f52730c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f52731d;

    /* renamed from: e  reason: collision with root package name */
    public int f52732e;

    /* renamed from: f  reason: collision with root package name */
    public int f52733f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.f.i.j.a f52734g;

    /* renamed from: h  reason: collision with root package name */
    public String f52735h;

    /* renamed from: i  reason: collision with root package name */
    public String f52736i;
    public d.a.q0.f.i.p.a j;
    public d.a.q0.f.i.o.b k;
    public String l;
    public d.a.q0.f.i.n.a m;
    public String n;
    public String o;
    public Map<String, String> p;
    public d.a.q0.f.i.q.c q;
    public DownloadState r;
    public DownloadParams s;
    public d.a.q0.f.i.k.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public d.a.q0.f.i.l.f y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52737e;

        public a(b bVar) {
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
            this.f52737e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52737e.c0();
                if (this.f52737e.y.c(this.f52737e.f52729b.r())) {
                    this.f52737e.y.removeView(this.f52737e.f52729b.r());
                }
                if (!this.f52737e.y.d(this.f52737e.f52729b.r(), d.a.q0.f.i.i.a.d())) {
                    this.f52737e.Z("3010000");
                    return;
                }
                this.f52737e.f52732e = 260;
                this.f52737e.f52729b.G(this.f52737e.f52731d.getVideoUrl());
                d.a.q0.f.i.q.b.n("showSuccess", this.f52737e.B, this.f52737e.k);
            }
        }
    }

    /* renamed from: d.a.q0.f.i.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterface$OnDismissListenerC1105b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC1105b(b bVar) {
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

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52738e;

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
            this.f52738e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f52738e.P();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52739e;

        public d(b bVar) {
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
            this.f52739e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (!this.f52739e.x || this.f52739e.f52729b == null) {
                    this.f52739e.U();
                    return;
                }
                if (this.f52739e.f52730c != null) {
                    this.f52739e.f52730c.pause();
                }
                this.f52739e.f52732e = PlayerEvent.PLAY_LOADING_END;
                this.f52739e.f52729b.B();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52740a;

        public e(b bVar) {
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
            this.f52740a = bVar;
        }

        @Override // d.a.q0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 0 || i2 > 100) {
                return;
            }
            if (i2 != 100 || this.f52740a.n == b.F) {
                if (this.f52740a.n == b.F || this.f52740a.n == b.I) {
                    return;
                }
                this.f52740a.n = String.valueOf(i2);
                return;
            }
            this.f52740a.n = b.G;
        }

        @Override // d.a.q0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f52740a.q.c("appinstallbegin");
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                if (!this.f52740a.u) {
                    this.f52740a.m0(downloadState);
                }
                this.f52740a.u = true;
                if (this.f52740a.r == downloadState) {
                    return;
                }
                if (this.f52740a.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f52740a.o = b.K;
                    this.f52740a.q.c("appdownloadbegin");
                } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (this.f52740a.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                        this.f52740a.o = b.K;
                        this.f52740a.q.c("appdownloadcontinue");
                    } else if (downloadState == DownloadState.DOWNLOADED) {
                        this.f52740a.o = b.K;
                        this.f52740a.n = b.G;
                        this.f52740a.q.c("appdownloadfinish");
                        this.f52740a.q.c("appinstallbegin");
                    } else if (downloadState == DownloadState.INSTALLED) {
                        this.f52740a.o = b.K;
                        this.f52740a.n = b.H;
                        this.f52740a.q.c("appinstallfinish");
                    } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                        this.f52740a.o = b.K;
                        this.f52740a.n = b.I;
                    }
                } else {
                    this.f52740a.o = b.J;
                    this.f52740a.q.c("appdownloadpause");
                }
                this.f52740a.r = downloadState;
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f52740a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.q0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.f.i.l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52741a;

        public f(b bVar) {
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
            this.f52741a = bVar;
        }

        @Override // d.a.q0.f.i.l.e
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52741a.A = false;
                this.f52741a.T();
            }
        }

        @Override // d.a.q0.f.i.l.e
        public boolean onError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f52741a.j0();
                this.f52741a.Z("3010001");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.q0.f.i.l.e
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f52741a.A) {
                this.f52741a.i0();
                this.f52741a.A = false;
            }
        }

        @Override // d.a.q0.f.i.l.e
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f52741a.f52729b != null) {
                    this.f52741a.f52729b.y();
                }
                this.f52741a.f52732e = PlayerEvent.PLAY_LOADING_START;
                this.f52741a.f52733f = 0;
                if (this.f52741a.f52729b != null) {
                    this.f52741a.f52729b.p();
                }
                if (this.f52741a.j != null) {
                    this.f52741a.j.b(true, "");
                }
                if (this.f52741a.v) {
                    d.a.q0.f.i.q.d.f(this.f52741a.f52731d, this.f52741a.k);
                } else {
                    d.a.q0.f.i.q.b.j(this.f52741a.f52731d, this.f52741a.k);
                    d.a.q0.f.i.q.b.q(this.f52741a.f52731d, this.f52741a.k);
                    String str = this.f52741a.f52736i;
                    b bVar = this.f52741a;
                    d.a.q0.f.i.q.b.f(str, bVar.f52735h, bVar.l, this.f52741a.k);
                }
                d.a.q0.f.i.q.b.n("show", this.f52741a.B, this.f52741a.k);
            }
        }

        @Override // d.a.q0.f.i.l.e
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f52741a.A = true;
                this.f52741a.P();
            }
        }

        @Override // d.a.q0.f.i.l.e
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f52741a.A = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52742a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2076475631, "Ld/a/q0/f/i/p/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2076475631, "Ld/a/q0/f/i/p/b$g;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            f52742a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52742a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52742a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-516274414, "Ld/a/q0/f/i/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-516274414, "Ld/a/q0/f/i/p/b;");
        }
    }

    public b(Activity activity, String str, String str2, boolean z, d.a.q0.f.i.p.a aVar, d.a.q0.f.i.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), aVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52732e = 256;
        this.f52733f = 0;
        this.f52735h = "";
        this.n = F;
        this.o = K;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = false;
        this.B = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f52728a = appContext;
        this.f52736i = str;
        this.f52735h = str2;
        this.v = z;
        this.w = z;
        this.k = new d.a.q0.f.i.o.b(appContext);
        this.m = new d.a.q0.f.i.n.a();
        this.x = i.i();
        this.j = aVar;
        this.y = fVar;
        this.D = activity;
    }

    public synchronized void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f52730c != null && this.f52729b != null) {
                    if (this.f52734g == null || !this.f52734g.isShowing()) {
                        if (!this.A && !this.f52729b.t()) {
                            this.f52730c.resume();
                            this.f52729b.D();
                        } else {
                            d.a.q0.f.i.q.b.q(this.f52731d, this.k);
                        }
                    }
                }
            }
        }
    }

    public final d.a.q0.f.i.q.a Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            d.a.q0.f.i.q.a aVar = new d.a.q0.f.i.q.a();
            aVar.f52751i = String.valueOf(this.f52731d.getDuration());
            aVar.j = String.valueOf(this.f52733f);
            aVar.k = String.valueOf(i2);
            String str = "1";
            aVar.l = this.f52733f == 0 ? "1" : "0";
            aVar.m = i2 == this.f52731d.getDuration() ? "1" : "0";
            int i3 = 1;
            aVar.n = this.f52728a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i4 = this.f52733f;
            if (i4 != 0) {
                i3 = i4 == this.f52731d.getDuration() ? 3 : 2;
            }
            aVar.o = String.valueOf(i3);
            aVar.p = (this.f52733f == 0 && NetworkUtils.g(this.f52728a)) ? "2" : "2";
            aVar.q = String.valueOf(0);
            return aVar;
        }
        return (d.a.q0.f.i.q.a) invokeI.objValue;
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.f.i.m.b.c cVar = this.f52730c;
            if (cVar != null && cVar.isEnd()) {
                return this.f52730c.getDuration() / 1000;
            }
            return S();
        }
        return invokeV.intValue;
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.f.i.m.b.c cVar = this.f52730c;
            if (cVar != null) {
                return cVar.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f52730c == null || this.f52729b == null) {
            return;
        }
        i0();
        this.f52732e = PlayerEvent.PLAY_LOADING_END;
        if (this.f52729b != null) {
            if (this.f52730c.isEnd()) {
                this.f52729b.A();
            } else {
                this.f52729b.B();
            }
        }
    }

    public final void U() {
        d.a.q0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j != null && (cVar = this.f52730c) != null) {
                int duration = cVar.getDuration() / 1000;
                this.j.c(this.f52730c.isEnd() || this.f52730c.getCurrentPosition() / 1000 >= Math.min(this.f52731d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.f52731d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            d.a.q0.f.i.q.b.p(this.f52731d, this.k);
            this.f52732e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
            e0();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (d.a.q0.f.i.r.g.a(this.f52728a, this.s.f11746b)) {
                this.n = H;
                h0(this.f52728a, this.s.f11746b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = E;
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = K;
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = G;
                this.t.b();
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                h0(this.f52728a, this.s.f11746b);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            U();
        }
    }

    public final void X(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.v && (adElementInfo = this.f52731d) != null) {
            d.a.q0.f.i.q.d.d(adElementInfo, this.k);
            d.a.q0.f.i.q.a aVar = new d.a.q0.f.i.q.a();
            aVar.f52743a = String.valueOf(h.i(this.f52728a));
            aVar.f52744b = String.valueOf(h.h(this.f52728a));
            aVar.f52745c = String.valueOf(h.i(this.f52728a));
            aVar.f52746d = String.valueOf(h.h(this.f52728a));
            aVar.f52747e = String.valueOf((int) view.getX());
            aVar.f52748f = String.valueOf((int) view.getY());
            aVar.f52749g = String.valueOf((int) view.getX());
            aVar.f52750h = String.valueOf((int) view.getY());
            if (this.f52731d.getActionType() == 2) {
                d.a.q0.f.i.q.d.a(aVar, this.f52731d, this.k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.f52731d;
            if (adElementInfo2 != null) {
                this.y.a(d.a.q0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.f52731d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", d.a.q0.f.i.q.b.b("landingPageLoad", this.B));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            d.a.q0.f.i.p.a aVar = this.j;
            if (aVar != null) {
                aVar.onError(str);
                this.j.b(false, "");
            }
            this.f52732e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
        }
    }

    @Override // d.a.q0.f.i.l.b
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this) {
                this.f52732e = 259;
                f0(str);
            }
        }
    }

    public final boolean a0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
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

    @Override // d.a.q0.f.i.l.a
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, commandType, uri) == null) {
            synchronized (this) {
                this.f52731d.getClickUrl();
                String packageName = this.f52731d.getPackageName();
                int i2 = g.f52742a[commandType.ordinal()];
                if (i2 == 1) {
                    if (this.f52731d.getActionType() == 2) {
                        V();
                    } else {
                        Y();
                        d.a.q0.f.i.q.b.n("lpClick", this.B, this.k);
                    }
                    d.a.q0.f.i.q.b.g(this.f52731d, this.k);
                    d.a.q0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.B, this.k);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.o = J;
                        V();
                    }
                } else if (this.m == null) {
                } else {
                    if (a0(this.f52728a, packageName)) {
                        this.n = H;
                    }
                    String queryParameter = uri.getQueryParameter(N);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(L, this.n);
                        jSONObject.put(M, this.o);
                        this.m.b(queryParameter, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = new d.a.q0.f.i.q.c(this.f52728a, this.f52731d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.f52731d.getClickUrl();
            String packageName = this.f52731d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.f52731d.getTitle());
            this.u = false;
            if (h.o()) {
                d.a.q0.f.i.m.a.b().b(this.f52728a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // d.a.q0.f.i.l.b
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adElementInfo) == null) {
            synchronized (this) {
                this.f52731d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.f52732e = 258;
                g0();
                if (!this.v && this.f52731d.getActionType() == 2) {
                    b0();
                }
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.f52729b = new d.a.q0.f.i.s.b(this.f52728a, this.f52731d, this.m);
            } else {
                this.f52729b = new d.a.q0.f.i.s.c(this.f52728a, this.f52731d, this.m);
            }
            if (this.v) {
                this.f52729b.F(this);
            }
            this.f52729b.E(this);
            d.a.q0.f.i.m.b.c s = this.f52729b.s();
            this.f52730c = s;
            s.g(new f(this));
            this.f52729b.r().setAnimation(AnimationUtils.loadAnimation(this.f52728a, d.a.q0.f.i.a.ng_game_ad_open));
        }
    }

    @Override // d.a.q0.f.i.l.d
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.f52731d.getTitle());
                        jSONObject.put("description", this.f52731d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.C == null) {
                            this.C = new d.a.q0.f.i.k.b(this.f52728a, this.f52731d, this.k);
                        }
                        this.C.k(str);
                        d.a.q0.f.i.m.a.b().b(this.f52728a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.C);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AdElementInfo adElementInfo = this.f52731d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.f52731d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f.i.l.c
    public synchronized void e(View view) {
        int min;
        int i2;
        int i3;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            synchronized (this) {
                if (this.f52730c != null && this.f52731d != null) {
                    if (this.f52734g == null || !this.f52734g.isShowing()) {
                        if (view != null && d.a.q0.f.i.e.close_ad != view.getId()) {
                            W();
                            return;
                        }
                        int currentPosition = this.f52730c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.f52731d.getRewardTime(), this.f52730c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            T();
                            return;
                        }
                        int q = d.a.q0.f.i.m.a.b().q();
                        int p = d.a.q0.f.i.m.a.b().p();
                        if (this.y.b()) {
                            min = (int) (q * 0.275f);
                            i3 = (int) (p * 0.05f);
                            i2 = min;
                        } else {
                            min = (int) (Math.min(q, p) * 0.1f);
                            i2 = min;
                            i3 = 0;
                        }
                        i0();
                        this.f52728a.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_dialog_msg_more);
                        if (this.x) {
                            format = String.format(this.f52728a.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f52730c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.f52728a.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.f52734g != null) {
                            this.f52734g.d(format);
                            this.f52734g.show();
                        } else {
                            a.C1095a c1095a = new a.C1095a(this.D);
                            c1095a.c(true);
                            c1095a.i(d.a.q0.f.i.g.ad_close, new d(this));
                            c1095a.g(format);
                            c1095a.l(d.a.q0.f.i.g.ad_continue_watch, new c(this));
                            c1095a.n(d.a.q0.f.i.b.swan_ad_game_continue_watch);
                            c1095a.k(new DialogInterface$OnDismissListenerC1105b(this));
                            c1095a.f(min, 0, i2, i3);
                            this.f52734g = c1095a.p();
                        }
                    }
                }
            }
        }
    }

    public synchronized void e0() {
        d.a.q0.f.i.o.e gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                if (this.f52732e == 257) {
                    return;
                }
                d.a.q0.f.i.q.b.n("loadApi", this.B, this.k);
                d.a.q0.f.i.m.a.a().b(this.v);
                int i2 = this.f52732e;
                if (i2 != 256 && i2 != 272) {
                    switch (i2) {
                        case 258:
                            if (d0()) {
                                this.f52732e = AuthorityState.STATE_INIT_ING;
                                return;
                            } else {
                                g0();
                                return;
                            }
                        case 259:
                        case PlayerEvent.PLAY_LOADING_END /* 262 */:
                        case PayBeanFactory.BEAN_ID_CREDIT_PAY /* 263 */:
                        case PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK /* 264 */:
                            break;
                        case 260:
                        case PlayerEvent.PLAY_LOADING_START /* 261 */:
                        case 265:
                            f0("3010006");
                            return;
                        default:
                            return;
                    }
                }
                String appKey = d.a.q0.f.i.m.a.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.f52736i) && !TextUtils.isEmpty(this.f52735h)) {
                    this.f52732e = 257;
                    c.b bVar = new c.b();
                    bVar.m(this.f52736i);
                    bVar.j(this.f52735h);
                    bVar.o(appKey);
                    bVar.l(h.i(this.f52728a));
                    bVar.i(h.h(this.f52728a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    d.a.q0.f.i.o.c h2 = bVar.h();
                    if (this.w) {
                        this.v = true;
                        gVar = new d.a.q0.f.i.o.f(this.f52728a, h2, 5, 5);
                    } else {
                        this.v = false;
                        gVar = new d.a.q0.f.i.o.g(this.f52728a, h2);
                        this.l = gVar.c();
                    }
                    d.a.q0.f.i.o.a aVar = new d.a.q0.f.i.o.a(this.f52728a, false);
                    aVar.k(this);
                    aVar.i(gVar, this.k);
                    return;
                }
                f0("3010007");
            }
        }
    }

    @Override // d.a.q0.f.i.l.d
    public synchronized void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            synchronized (this) {
                if (this.j != null) {
                    this.j.onClick(R());
                }
                if (this.v) {
                    X(view);
                }
            }
        }
    }

    public final void f0(String str) {
        d.a.q0.f.i.p.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.onError(str);
        this.j.a(false, str);
    }

    public final void g0() {
        d.a.q0.f.i.p.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.a(true, "");
    }

    public final boolean h0(Context context, String str) {
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
            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                try {
                    context.startActivity(intent2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                if (this.f52730c != null && this.f52729b != null) {
                    if (this.f52730c.isPlaying()) {
                        this.f52730c.pause();
                        this.f52729b.z();
                        if (this.v) {
                            d.a.q0.f.i.q.d.g(Q(S()), this.f52731d, this.k);
                        } else {
                            d.a.q0.f.i.q.b.o(S(), this.f52733f, this.f52731d, this.k);
                        }
                    } else {
                        d.a.q0.f.i.q.b.o(S(), this.f52733f, this.f52731d, this.k);
                        this.f52733f = S();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            d.a.q0.f.i.m.b.c cVar = this.f52730c;
            if (cVar != null) {
                cVar.pause();
                this.f52730c.stop();
            }
            d.a.q0.f.i.s.a aVar = this.f52729b;
            if (aVar != null) {
                aVar.n();
                this.f52729b.r().setAnimation(AnimationUtils.loadAnimation(this.f52728a, d.a.q0.f.i.a.ng_game_ad_close));
                this.y.removeView(this.f52729b.r());
                this.f52729b = null;
            }
            d.a.q0.f.i.k.b bVar = this.C;
            if (bVar != null) {
                bVar.i();
                this.C = null;
            }
        }
    }

    public void k0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, map) == null) {
            this.B = map;
            this.z = d.a.q0.f.i.q.b.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                d.a.q0.f.i.q.b.n("showApi", this.B, this.k);
                if (this.f52732e != 261 && this.f52732e != 260 && this.f52732e != 265) {
                    if (this.f52732e == 258 && !d0()) {
                        if (this.f52731d != null && TextUtils.isEmpty(this.f52731d.getVideoUrl())) {
                            Z("3010008");
                            return;
                        }
                        if (this.f52732e == 258) {
                            this.f52732e = 265;
                            this.y.e();
                            d.a.q0.f.i.r.d.c(new a(this));
                        }
                        return;
                    }
                    Z("3010004");
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
        if (interceptable == null || interceptable.invokeL(1048605, this, downloadState) == null) {
            this.r = downloadState;
            if (downloadState == DownloadState.NOT_START) {
                this.n = F;
                this.o = K;
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                this.n = E;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOADED) {
                this.n = G;
                this.o = K;
            } else if (downloadState == DownloadState.INSTALLED) {
                this.n = H;
                this.o = K;
            } else if (downloadState == DownloadState.DOWNLOADING) {
                this.n = E;
                this.o = K;
            }
        }
    }
}
