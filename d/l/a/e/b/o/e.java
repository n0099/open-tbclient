package d.l.a.e.b.o;

import android.net.Uri;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<String, d> f75001a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f75002b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f75003c;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f75004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f75005f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f75006g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f75007h;

        public a(e eVar, String str, c cVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, cVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75007h = eVar;
            this.f75004e = str;
            this.f75005f = cVar;
            this.f75006g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f75007h.e(this.f75004e, this.f75005f, this.f75006g);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f75008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f75009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f75010g;

        public b(e eVar, c cVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75008e = cVar;
            this.f75009f = str;
            this.f75010g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f75008e) == null) {
                return;
            }
            String str = this.f75009f;
            d dVar = this.f75010g;
            cVar.a(str, dVar == null ? null : dVar.f75011a);
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<InetAddress> f75011a;

        /* renamed from: b  reason: collision with root package name */
        public long f75012b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: d.l.a.e.b.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2081e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f75013a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1228039180, "Ld/l/a/e/b/o/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1228039180, "Ld/l/a/e/b/o/e$e;");
                    return;
                }
            }
            f75013a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2081e.f75013a : (e) invokeV.objValue;
    }

    public void c(String str, c cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, cVar, Long.valueOf(j)}) == null) {
            this.f75002b.post(new a(this, str, cVar, j));
        }
    }

    public final void d(String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list) == null) {
            synchronized (this.f75001a) {
                d dVar = this.f75001a.get(str);
                if (dVar == null) {
                    dVar = new d(null);
                    this.f75001a.put(str, dVar);
                }
                dVar.f75011a = list;
                dVar.f75012b = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
        r10 = r2.f75011a;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0092 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #3 {all -> 0x0099, blocks: (B:4:0x0004, B:5:0x000e, B:9:0x001a, B:12:0x0038, B:14:0x003e, B:16:0x0056, B:23:0x0067, B:31:0x007c, B:34:0x0083, B:37:0x008b, B:39:0x0092, B:36:0x0089, B:25:0x006d, B:18:0x005c, B:26:0x0071, B:6:0x000f, B:7:0x0017), top: B:50:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String str, c cVar, long j) {
        d dVar;
        h J0;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, cVar, Long.valueOf(j)}) != null) {
            return;
        }
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.f75001a) {
                dVar = this.f75001a.get(host);
            }
            if (dVar != null && System.currentTimeMillis() - dVar.f75012b < d.l.a.e.b.j.a.r().b("dns_expire_min", 10) * 60 * 1000) {
                if (cVar != null) {
                    cVar.a(str, dVar.f75011a);
                    return;
                }
                return;
            }
            b bVar = new b(this, cVar, str, dVar);
            this.f75003c.postDelayed(bVar, j);
            List<InetAddress> list = null;
            if (d.l.a.e.b.j.a.r().b("use_host_dns", 1) == 1 && (J0 = d.l.a.e.b.g.e.J0()) != null) {
                list = J0.a(host);
            }
            if (list == null || list.isEmpty()) {
                list = d.l.a.e.b.g.e.K0().a(host);
            }
            if (list != null && !list.isEmpty()) {
                d(host, list);
                this.f75003c.removeCallbacks(bVar);
                if (cVar == null) {
                    cVar.a(str, list);
                    return;
                }
                return;
            }
            this.f75003c.removeCallbacks(bVar);
            if (cVar == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75001a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.f75002b = new Handler(d.l.a.e.b.o.b.b.a());
        this.f75003c = new Handler(d.l.a.e.b.k.e.a());
    }
}
