package d.l.a.d.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.t;
import d.l.a.a.a.c.v;
import d.l.a.a.a.d.h;
import d.l.a.d.b.c;
import d.l.a.d.b.f;
import d.l.a.d.b.i;
import d.l.a.d.d;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.a.d;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements d.l.a.d.b.h, h.s.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h.s f74300a;

    /* renamed from: b  reason: collision with root package name */
    public d.l.a.d.b.i f74301b;

    /* renamed from: c  reason: collision with root package name */
    public d.l.a.d.b.f f74302c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f74303d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, Object> f74304e;

    /* renamed from: f  reason: collision with root package name */
    public d.l.a.a.a.f.e f74305f;

    /* renamed from: g  reason: collision with root package name */
    public DownloadInfo f74306g;

    /* renamed from: h  reason: collision with root package name */
    public h f74307h;

    /* renamed from: i  reason: collision with root package name */
    public final d.l.a.e.b.f.b f74308i;
    public boolean j;
    public long k;
    public long l;
    public d.l.a.a.a.d.d m;
    public d.l.a.a.a.d.c n;
    public d.l.a.a.a.d.b o;
    public SoftReference<v> p;
    public boolean q;
    public final boolean r;
    public SoftReference<d.l.a.a.a.c.n> s;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f74309e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74309e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d.l.a.a.a.d.e eVar : d.l.a.d.b.i.d(this.f74309e.f74304e)) {
                    eVar.b(this.f74309e.U());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f74310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f74311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f74312c;

        public b(g gVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74312c = gVar;
            this.f74310a = i2;
            this.f74311b = i3;
        }

        @Override // d.l.a.d.b.g.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f74312c.f74302c.n()) {
                return;
            }
            g gVar = this.f74312c;
            gVar.n(this.f74310a, this.f74311b, gVar.f74306g);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements f.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f74313a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f74314b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f74315c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74316d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f74317e;

        public c(g gVar, boolean z, d.l.a.b.a.c.b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z), bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74317e = gVar;
            this.f74313a = z;
            this.f74314b = bVar;
            this.f74315c = i2;
            this.f74316d = i3;
        }

        @Override // d.l.a.d.b.f.i
        public void a(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f74317e.f74301b.k(this.f74317e.f74306g, this.f74313a);
                if (d.l.a.e.b.l.f.g0(l.a()) && this.f74317e.f74306g.isPauseReserveOnWifi()) {
                    this.f74317e.f74306g.stopPauseReserveOnWifi();
                    e.c.a().v("pause_reserve_wifi_cancel_on_wifi", this.f74314b);
                    return;
                }
                g gVar = this.f74317e;
                gVar.n(this.f74315c, this.f74316d, gVar.f74306g);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f74320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f74321b;

        public e(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74321b = gVar;
            this.f74320a = z;
        }

        @Override // d.l.a.d.b.g.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f74321b.f74302c.n()) {
                return;
            }
            this.f74321b.I(this.f74320a);
        }
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a();
    }

    /* renamed from: d.l.a.d.b.g$g  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2055g {
        void a(long j);
    }

    /* loaded from: classes10.dex */
    public class h extends AsyncTask<String, Void, DownloadInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f74322a;

        public h(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74322a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                DownloadInfo downloadInfo = null;
                if (strArr != null) {
                    if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                        String str = strArr[0];
                        if (this.f74322a.m != null && !TextUtils.isEmpty(this.f74322a.m.n())) {
                            downloadInfo = d.l.a.e.b.g.a.H(l.a()).g(str, this.f74322a.m.n());
                        }
                        return downloadInfo == null ? d.l.a.e.a.e.G().e(l.a(), str) : downloadInfo;
                    }
                    return null;
                }
                return null;
            }
            return (DownloadInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                super.onPostExecute(downloadInfo);
                if (isCancelled() || this.f74322a.m == null) {
                    return;
                }
                try {
                    c.d j = h.r.j(this.f74322a.m.v(), this.f74322a.m.r(), this.f74322a.m.s());
                    c.i.a().b(this.f74322a.m.r(), j.c(), c.g.e().c(downloadInfo));
                    boolean b2 = j.b();
                    if (downloadInfo != null && downloadInfo.getId() != 0 && (b2 || !d.l.a.e.b.g.a.H(l.a()).s(downloadInfo))) {
                        d.l.a.e.b.g.a.H(l.a()).x(downloadInfo.getId());
                        if (this.f74322a.f74306g == null || this.f74322a.f74306g.getStatus() != -4) {
                            this.f74322a.f74306g = downloadInfo;
                            if (this.f74322a.r) {
                                d.l.a.e.b.g.a.H(l.a()).E(this.f74322a.f74306g.getId(), this.f74322a.f74308i, false);
                            } else {
                                d.l.a.e.b.g.a.H(l.a()).D(this.f74322a.f74306g.getId(), this.f74322a.f74308i);
                            }
                        } else {
                            this.f74322a.f74306g = null;
                        }
                        this.f74322a.f74301b.j(this.f74322a.f74306g, this.f74322a.U(), d.l.a.d.b.i.d(this.f74322a.f74304e));
                    } else {
                        if (downloadInfo != null && d.l.a.e.b.g.a.H(l.a()).s(downloadInfo)) {
                            d.l.a.e.b.p.b.a().m(downloadInfo.getId());
                            this.f74322a.f74306g = null;
                        }
                        if (this.f74322a.f74306g != null) {
                            d.l.a.e.b.g.a.H(l.a()).x(this.f74322a.f74306g.getId());
                            if (this.f74322a.r) {
                                d.l.a.e.b.g.a.H(this.f74322a.O()).E(this.f74322a.f74306g.getId(), this.f74322a.f74308i, false);
                            } else {
                                d.l.a.e.b.g.a.H(this.f74322a.O()).D(this.f74322a.f74306g.getId(), this.f74322a.f74308i);
                            }
                        }
                        if (!b2) {
                            for (d.l.a.a.a.d.e eVar : d.l.a.d.b.i.d(this.f74322a.f74304e)) {
                                eVar.a();
                            }
                            this.f74322a.f74306g = null;
                        } else {
                            this.f74322a.f74306g = new DownloadInfo.b(this.f74322a.m.a()).E();
                            this.f74322a.f74306g.setStatus(-3);
                            this.f74322a.f74301b.j(this.f74322a.f74306g, this.f74322a.U(), d.l.a.d.b.i.d(this.f74322a.f74304e));
                        }
                    }
                    this.f74322a.f74301b.t(this.f74322a.f74306g);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public /* synthetic */ h(g gVar, a aVar) {
            this(gVar);
        }
    }

    /* loaded from: classes10.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(DownloadInfo downloadInfo, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{downloadInfo, Long.valueOf(j), str, str2}) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(768773332, "Ld/l/a/d/b/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(768773332, "Ld/l/a/d/b/g;");
        }
    }

    public g() {
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
        this.f74300a = new h.s(Looper.getMainLooper(), this);
        this.f74304e = new ConcurrentHashMap();
        this.f74308i = new i.d(this.f74300a);
        this.l = -1L;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f74301b = new d.l.a.d.b.i(this);
        this.f74302c = new d.l.a.d.b.f(this.f74300a);
        this.r = d.l.a.e.b.j.a.r().l("ttdownloader_callback_twice");
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (h.k.g(this.m).m("notification_opt_2") == 1 && this.f74306g != null) {
                d.l.a.e.b.p.b.a().m(this.f74306g.getId());
            }
            C(z);
        }
    }

    public final void C(boolean z) {
        d.l.a.a.a.d.d dVar;
        d.l.a.a.a.d.b bVar;
        d.l.a.a.a.d.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            h.q.b(t, "performButtonClickWithNewDownloader", null);
            if (S()) {
                c.f v = c.g.e().v(this.l);
                DownloadInfo downloadInfo = this.f74306g;
                if (downloadInfo != null && downloadInfo.getStatus() != 0) {
                    r(z, true);
                    return;
                } else if (this.q) {
                    if (this.m.t() && this.s != null) {
                        if (V() && (bVar2 = v.f74227d) != null && bVar2.f()) {
                            r(z, true);
                            return;
                        }
                        return;
                    }
                    r(z, true);
                    return;
                } else if (this.m.t() && (bVar = v.f74227d) != null && bVar.e() && v.f74225b != null && d.l.a.d.b.e.b.a().e(v.f74225b) && d.l.a.d.b.e.b.a().f(v)) {
                    return;
                } else {
                    r(z, true);
                    return;
                }
            }
            String str = t;
            h.q.b(str, "performButtonClickWithNewDownloader continue download, status:" + this.f74306g.getStatus(), null);
            DownloadInfo downloadInfo2 = this.f74306g;
            if (downloadInfo2 != null && (dVar = this.m) != null) {
                downloadInfo2.setOnlyWifi(dVar.m());
            }
            int status = this.f74306g.getStatus();
            int id = this.f74306g.getId();
            d.l.a.b.a.c.b c2 = c.g.e().c(this.f74306g);
            if (status != -2 && status != -1) {
                if (n.c(status)) {
                    if (this.m.L()) {
                        this.f74302c.m(true);
                        d.k.a().g(c.g.e().u(this.l));
                        f.l.a().b(c2, status, new c(this, z, c2, id, status));
                        return;
                    }
                    return;
                }
                this.f74301b.k(this.f74306g, z);
                n(id, status, this.f74306g);
                return;
            }
            this.f74301b.k(this.f74306g, z);
            if (c2 != null) {
                c2.K0(System.currentTimeMillis());
                c2.O0(this.f74306g.getCurBytes());
            }
            this.f74306g.setDownloadFromReserveWifi(false);
            this.f74302c.j(new c.f(this.l, this.m, P(), Q()));
            this.f74302c.f(id, this.f74306g.getCurBytes(), this.f74306g.getTotalBytes(), new b(this, id, status));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l.v().optInt("quick_app_enable_switch", 0) == 0 && this.m.B() != null && !TextUtils.isEmpty(this.m.B().a()) && d.l.a.d.b.d.e(this.f74306g) && h.r.t(O(), new Intent("android.intent.action.VIEW", Uri.parse(this.m.B().a()))) : invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f74300a.post(new a(this));
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f74302c.j(new c.f(this.l, this.m, P(), Q()));
            this.f74302c.f(0, 0L, 0L, new e(this, z));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f74304e.size() == 0) {
            return;
        }
        for (d.l.a.a.a.d.e eVar : d.l.a.d.b.i.d(this.f74304e)) {
            eVar.a();
        }
        DownloadInfo downloadInfo = this.f74306g;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            for (d.l.a.a.a.d.e eVar : d.l.a.d.b.i.d(this.f74304e)) {
                eVar.a(this.m, Q());
            }
            int a2 = this.f74301b.a(l.a(), this.f74308i);
            String str = t;
            h.q.b(str, "beginDownloadWithNewDownloader id:" + a2, null);
            if (a2 != 0) {
                if (this.f74306g != null && !d.l.a.e.b.j.a.r().l("fix_click_start")) {
                    this.f74301b.k(this.f74306g, false);
                } else if (z) {
                    this.f74301b.e();
                }
            } else {
                DownloadInfo E = new DownloadInfo.b(this.m.a()).E();
                E.setStatus(-1);
                q(E);
                e.c.a().e(this.l, new BaseException(2, "start download failed, id=0"));
                f.e.b().g("beginDownloadWithNewDownloader");
            }
            if (this.f74301b.n(x())) {
                String str2 = t;
                h.q.b(str2, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
                N();
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SoftReference<v> softReference = this.p;
            if (softReference != null && softReference.get() != null) {
                this.p.get().a(this.m, P(), Q());
                this.p = null;
                return;
            }
            l.o().a(O(), this.m, Q(), P());
        }
    }

    public final Context O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference<Context> weakReference = this.f74303d;
            if (weakReference != null && weakReference.get() != null) {
                return this.f74303d.get();
            }
            return l.a();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public final d.l.a.a.a.d.c P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.l.a.a.a.d.c cVar = this.n;
            return cVar == null ? new h.b().a() : cVar;
        }
        return (d.l.a.a.a.d.c) invokeV.objValue;
    }

    @NonNull
    public final d.l.a.a.a.d.b Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.o == null) {
                this.o = new d.l.a.a.a.d.g();
            }
            return this.o;
        }
        return (d.l.a.a.a.d.b) invokeV.objValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h.q.b(t, "performItemClickWithNewDownloader", null);
            if (this.f74301b.w(this.f74306g)) {
                h.q.b(t, "performItemClickWithNewDownloader ButtonClick", null);
                C(false);
                return;
            }
            h.q.b(t, "performItemClickWithNewDownloader onItemClick", null);
            N();
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (d.l.a.e.b.j.a.r().l("fix_click_start")) {
                DownloadInfo downloadInfo = this.f74306g;
                if (downloadInfo == null) {
                    return true;
                }
                if ((downloadInfo.getStatus() == -3 && this.f74306g.getCurBytes() <= 0) || this.f74306g.getStatus() == 0 || this.f74306g.getStatus() == -4) {
                    return true;
                }
                return d.l.a.e.b.l.f.I(this.f74306g.getStatus(), this.f74306g.getSavePath(), this.f74306g.getName());
            }
            DownloadInfo downloadInfo2 = this.f74306g;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || d.l.a.e.b.g.a.H(l.a()).a(this.f74306g.getId())) || this.f74306g.getStatus() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h hVar = this.f74307h;
            if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f74307h.cancel(true);
            }
            h hVar2 = new h(this, null);
            this.f74307h = hVar2;
            h.C2065h.a(hVar2, this.m.a(), this.m.v());
        }
    }

    public final d.l.a.a.a.f.e U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f74305f == null) {
                this.f74305f = new d.l.a.a.a.f.e();
            }
            return this.f74305f;
        }
        return (d.l.a.a.a.f.e) invokeV.objValue;
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SoftReference<d.l.a.a.a.c.n> softReference = this.s;
            if (softReference != null && softReference.get() != null) {
                this.s.get().a(true);
                this.s = null;
                return true;
            }
            f.e.b().g("mDownloadButtonClickListener has recycled");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.d.b.h
    public /* synthetic */ d.l.a.d.b.h a(d.l.a.a.a.d.b bVar) {
        i(bVar);
        return this;
    }

    @Override // d.l.a.d.b.h
    public /* synthetic */ d.l.a.d.b.h b(Context context) {
        h(context);
        return this;
    }

    @Override // d.l.a.d.b.h
    public /* synthetic */ d.l.a.d.b.h c(d.l.a.a.a.d.d dVar) {
        k(dVar);
        return this;
    }

    @Override // d.l.a.d.b.h
    public d.l.a.d.b.h d(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vVar)) == null) {
            if (vVar == null) {
                this.p = null;
            } else {
                this.p = new SoftReference<>(vVar);
            }
            return this;
        }
        return (d.l.a.d.b.h) invokeL.objValue;
    }

    @Override // d.l.a.d.b.h
    public d.l.a.d.b.h e(d.l.a.a.a.c.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, nVar)) == null) {
            if (nVar == null) {
                this.s = null;
            } else {
                this.s = new SoftReference<>(nVar);
            }
            return this;
        }
        return (d.l.a.d.b.h) invokeL.objValue;
    }

    @Override // d.l.a.d.b.h
    public /* synthetic */ d.l.a.d.b.h f(int i2, d.l.a.a.a.d.e eVar) {
        g(i2, eVar);
        return this;
    }

    public g g(int i2, d.l.a.a.a.d.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i2, eVar)) == null) {
            if (eVar != null) {
                if (l.v().optInt("back_use_softref_listener") == 1) {
                    this.f74304e.put(Integer.valueOf(i2), eVar);
                } else {
                    this.f74304e.put(Integer.valueOf(i2), new SoftReference(eVar));
                }
            }
            return this;
        }
        return (g) invokeIL.objValue;
    }

    public g h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) {
            if (context != null) {
                this.f74303d = new WeakReference<>(context);
            }
            l.n(context);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g i(d.l.a.a.a.d.b bVar) {
        InterceptResult invokeL;
        JSONObject z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bVar)) == null) {
            this.o = bVar;
            if (h.k.g(this.m).m("force_auto_open") == 1) {
                Q().b(1);
            }
            if (d.l.a.e.b.j.a.r().l("fix_show_dialog") && (z = this.m.z()) != null && z.optInt("subprocess") > 0) {
                Q().a(false);
            }
            c.g.e().g(this.l, Q());
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g j(d.l.a.a.a.d.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, cVar)) == null) {
            this.n = cVar;
            this.q = P().k() == 0;
            c.g.e().h(this.l, P());
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g k(d.l.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, dVar)) == null) {
            if (dVar != null) {
                if (dVar.t()) {
                    if (dVar.d() <= 0 || TextUtils.isEmpty(dVar.u())) {
                        f.e.b().d("setDownloadModel ad error");
                    }
                } else if (dVar.d() == 0 && (dVar instanceof d.l.a.b.a.a.c)) {
                    f.e.b().e(false, "setDownloadModel id=0");
                    if (d.l.a.e.b.j.a.r().l("fix_model_id")) {
                        ((d.l.a.b.a.a.c) dVar).d(dVar.a().hashCode());
                    }
                }
                c.g.e().i(dVar);
                this.l = dVar.d();
                this.m = dVar;
                if (j.f(dVar)) {
                    ((d.l.a.b.a.a.c) dVar).c(3L);
                    d.l.a.b.a.c.b u = c.g.e().u(this.l);
                    if (u != null && u.l() != 3) {
                        u.y0(3L);
                        c.j.b().c(u);
                    }
                }
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final void n(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, downloadInfo) == null) {
            if (d.l.a.e.b.j.a.r().l("fix_click_start")) {
                if (i3 != -3 && !d.l.a.e.b.g.f.c().B(i2)) {
                    r(false, false);
                    return;
                } else {
                    d.l.a.e.a.e.G().j(l.a(), i2, i3);
                    return;
                }
            }
            d.l.a.e.a.e.G().j(l.a(), i2, i3);
        }
    }

    public final void q(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, downloadInfo) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            this.f74300a.sendMessage(obtain);
        }
    }

    public void r(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                e.c.a().c(this.l, 2);
            }
            if (!h.p.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION) && !Q().g()) {
                this.m.a(this.f74301b.p());
            }
            if (h.k.k(this.m) == 0) {
                h.q.b(t, "performButtonClickWithNewDownloader not start", null);
                this.f74301b.h(new d(this, z2));
                return;
            }
            G(z2);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            A(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (z) {
                e.c.a().c(this.l, 1);
            }
            R();
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            DownloadInfo downloadInfo = this.f74306g;
            return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            if (D()) {
                int i3 = -1;
                String a2 = this.m.B().a();
                if (i2 == 1) {
                    i3 = 5;
                } else if (i2 == 2) {
                    i3 = 4;
                }
                d.l.a.a.a.d.d dVar = this.m;
                if (dVar instanceof d.l.a.b.a.a.c) {
                    ((d.l.a.b.a.a.c) dVar).b(3);
                }
                boolean h2 = h.o.h(l.a(), a2);
                if (h2) {
                    e.c.a().c(this.l, i2);
                    Message obtain = Message.obtain();
                    obtain.what = i3;
                    obtain.obj = Long.valueOf(this.m.d());
                    d.l.a.d.b.d.a().c(this, i3, this.m);
                } else {
                    e.c.a().f(this.l, false, 0);
                }
                return h2;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class d implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f74318a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f74319b;

        public d(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74319b = gVar;
            this.f74318a = z;
        }

        @Override // d.l.a.a.a.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.q.b(g.t, "performButtonClickWithNewDownloader start download", null);
                this.f74319b.G(this.f74318a);
            }
        }

        @Override // d.l.a.a.a.c.t
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h.q.b(g.t, "performButtonClickWithNewDownloader onDenied", null);
            }
        }
    }

    @Override // d.l.a.d.b.h
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.j = true;
            c.g.e().h(this.l, P());
            c.g.e().g(this.l, Q());
            this.f74301b.f(this.l);
            T();
            if (l.v().optInt("enable_empty_listener", 1) == 1 && this.f74304e.get(Integer.MIN_VALUE) == null) {
                g(Integer.MIN_VALUE, new d.l.a.a.a.c.a());
            }
        }
    }

    @Override // d.l.a.d.b.h
    public /* synthetic */ d.l.a.d.b.h b(d.l.a.a.a.d.c cVar) {
        j(cVar);
        return this;
    }

    @Override // d.l.a.d.b.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // d.l.a.d.b.h
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // d.l.a.d.b.h
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            c.g.e().w(this.l);
        }
    }

    @Override // d.l.a.d.b.h
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalArgumentException("error actionType");
            }
            this.f74301b.f(this.l);
            if (!c.g.e().v(this.l).y()) {
                f.e.b().d("handleDownload ModelBox !isStrictValid");
            }
            if (this.f74301b.m(O(), i2, this.q)) {
                return;
            }
            boolean y = y(i2);
            if (i2 == 1) {
                if (y) {
                    return;
                }
                String str = t;
                h.q.b(str, "handleDownload id:" + this.l + ",tryPerformItemClick:", null);
                w(true);
            } else if (i2 == 2 && !y) {
                String str2 = t;
                h.q.b(str2, "handleDownload id:" + this.l + ",tryPerformButtonClick:", null);
                u(true);
            }
        }
    }

    @Override // d.l.a.d.b.h
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (i2 == 0) {
                this.f74304e.clear();
            } else {
                this.f74304e.remove(Integer.valueOf(i2));
            }
            if (this.f74304e.isEmpty()) {
                this.j = false;
                this.k = System.currentTimeMillis();
                if (this.f74306g != null) {
                    d.l.a.e.b.g.a.H(l.a()).x(this.f74306g.getId());
                }
                h hVar = this.f74307h;
                if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                    this.f74307h.cancel(true);
                }
                this.f74301b.i(this.f74306g);
                String str = t;
                StringBuilder sb = new StringBuilder();
                sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
                DownloadInfo downloadInfo = this.f74306g;
                sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
                h.q.b(str, sb.toString(), null);
                this.f74300a.removeCallbacksAndMessages(null);
                this.f74305f = null;
                this.f74306g = null;
                return true;
            }
            if (this.f74304e.size() == 1 && this.f74304e.containsKey(Integer.MIN_VALUE)) {
                this.f74301b.s(this.f74306g);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.d.b.h
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.f74306g == null) {
            return;
        }
        if (z) {
            d.f u = d.l.a.e.a.e.G().u();
            if (u != null) {
                u.a(this.f74306g);
            }
            d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).c(this.f74306g.getId(), true);
            return;
        }
        Intent intent = new Intent(l.a(), DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
        intent.putExtra("extra_click_download_ids", this.f74306g.getId());
        l.a().startService(intent);
    }

    @Override // d.l.a.d.b.h
    public d.l.a.d.b.h a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            if (j != 0) {
                d.l.a.a.a.d.d a2 = c.g.e().a(j);
                if (a2 != null) {
                    this.m = a2;
                    this.l = j;
                    this.f74301b.f(j);
                }
            } else {
                f.e.b().e(false, "setModelId");
            }
            return this;
        }
        return (d.l.a.d.b.h) invokeJ.objValue;
    }

    @Override // d.l.a.d.h.s.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, message) == null) && message != null && this.j && message.what == 3) {
            this.f74306g = (DownloadInfo) message.obj;
            this.f74301b.g(message, U(), this.f74304e);
        }
    }
}
