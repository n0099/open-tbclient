package com.kwai.filedownloader.download;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class DownloadLaunchRunnable implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor o;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;

    /* renamed from: a  reason: collision with root package name */
    public int f36757a;

    /* renamed from: b  reason: collision with root package name */
    public final d f36758b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36759c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.filedownloader.d.c f36760d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f36761e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36762f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36763g;

    /* renamed from: h  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f36764h;

    /* renamed from: i  reason: collision with root package name */
    public final x f36765i;
    public boolean j;
    public final boolean k;
    public final ArrayList<c> l;
    public e m;
    public boolean n;
    public boolean p;
    public boolean q;
    public boolean r;
    public final AtomicBoolean s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile Exception v;
    public String w;
    public long x;
    public long y;
    public long z;

    /* renamed from: com.kwai.filedownloader.download.DownloadLaunchRunnable$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class DiscardSafely extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4243896780616180062L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadLaunchRunnable this$0;

        public DiscardSafely(DownloadLaunchRunnable downloadLaunchRunnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadLaunchRunnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes6.dex */
    public class RetryDirectly extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4127585119566978768L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadLaunchRunnable this$0;

        public RetryDirectly(DownloadLaunchRunnable downloadLaunchRunnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadLaunchRunnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.kwai.filedownloader.d.c f36766a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f36767b;

        /* renamed from: c  reason: collision with root package name */
        public x f36768c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f36769d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f36770e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f36771f;

        /* renamed from: g  reason: collision with root package name */
        public Boolean f36772g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f36773h;

        public a() {
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

        public a a(com.kwai.filedownloader.d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f36767b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.d.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.f36766a = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xVar)) == null) {
                this.f36768c = xVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bool)) == null) {
                this.f36771f = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
                this.f36769d = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public DownloadLaunchRunnable a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f36766a == null || this.f36768c == null || this.f36769d == null || this.f36770e == null || this.f36771f == null || this.f36772g == null || this.f36773h == null) {
                    throw new IllegalArgumentException();
                }
                return new DownloadLaunchRunnable(this.f36766a, this.f36767b, this.f36768c, this.f36769d.intValue(), this.f36770e.intValue(), this.f36771f.booleanValue(), this.f36772g.booleanValue(), this.f36773h.intValue(), null);
            }
            return (DownloadLaunchRunnable) invokeV.objValue;
        }

        public a b(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bool)) == null) {
                this.f36772g = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) {
                this.f36770e = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num)) == null) {
                this.f36773h = num;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-912615623, "Lcom/kwai/filedownloader/download/DownloadLaunchRunnable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-912615623, "Lcom/kwai/filedownloader/download/DownloadLaunchRunnable;");
                return;
            }
        }
        o = com.kwai.filedownloader.f.b.a("ConnectionBlock");
    }

    public DownloadLaunchRunnable(com.kwai.filedownloader.d.c cVar, com.kwai.filedownloader.d.b bVar, x xVar, int i2, int i3, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, xVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36759c = 5;
        this.l = new ArrayList<>(5);
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.s = new AtomicBoolean(true);
        this.t = false;
        this.j = false;
        this.f36760d = cVar;
        this.f36761e = bVar;
        this.f36762f = z;
        this.f36763g = z2;
        this.f36764h = b.a().c();
        this.k = b.a().e();
        this.f36765i = xVar;
        this.f36757a = i4;
        this.f36758b = new d(cVar, i4, i2, i3);
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.d.c cVar, com.kwai.filedownloader.d.b bVar, x xVar, int i2, int i3, boolean z, boolean z2, int i4, AnonymousClass1 anonymousClass1) {
        this(cVar, bVar, xVar, i2, i3, z, z2, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwai.filedownloader.download.a a(List<com.kwai.filedownloader.d.a> list) {
        InterceptResult invokeL;
        long g2;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            int n = this.f36760d.n();
            String e2 = this.f36760d.e();
            String d2 = this.f36760d.d();
            boolean z2 = n > 1;
            if ((!z2 || this.k) && com.kwai.filedownloader.f.f.a(this.f36760d.a(), this.f36760d)) {
                if (!this.k) {
                    g2 = new File(e2).length();
                } else if (!z2) {
                    g2 = this.f36760d.g();
                } else if (n == list.size()) {
                    g2 = com.kwai.filedownloader.d.a.a(list);
                }
                j = g2;
                this.f36760d.a(j);
                z = j > 0;
                this.p = z;
                if (!z) {
                    this.f36764h.d(this.f36760d.a());
                    com.kwai.filedownloader.f.f.c(d2, e2);
                }
                return new com.kwai.filedownloader.download.a(0L, j, 0L, this.f36760d.h() - j);
            }
            j = 0;
            this.f36760d.a(j);
            if (j > 0) {
            }
            this.p = z;
            if (!z) {
            }
            return new com.kwai.filedownloader.download.a(0L, j, 0L, this.f36760d.h() - j);
        }
        return (com.kwai.filedownloader.download.a) invokeL.objValue;
    }

    private void a(int i2, List<com.kwai.filedownloader.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, list) == null) {
            if (i2 <= 1 || list.size() != i2) {
                throw new IllegalArgumentException();
            }
            a(list, this.f36760d.h());
        }
    }

    private void a(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            long j2 = j / i2;
            int a2 = this.f36760d.a();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            long j3 = 0;
            while (i3 < i2) {
                long j4 = i3 == i2 + (-1) ? 0L : (j3 + j2) - 1;
                com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
                aVar.a(a2);
                aVar.b(i3);
                aVar.a(j3);
                aVar.b(j3);
                aVar.c(j4);
                arrayList.add(aVar);
                this.f36764h.a(aVar);
                j3 += j2;
                i3++;
            }
            this.f36760d.b(i2);
            this.f36764h.a(a2, i2);
            a(arrayList, j);
        }
    }

    private void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(AdIconUtil.BAIDU_LOGO_ID, this, j, str) == null) {
            com.kwai.filedownloader.e.a aVar = null;
            if (j != -1) {
                try {
                    aVar = com.kwai.filedownloader.f.f.l(this.f36760d.e());
                    long length = new File(str).length();
                    long j2 = j - length;
                    long f2 = com.kwai.filedownloader.f.f.f(str);
                    if (f2 < j2) {
                        throw new FileDownloadOutOfSpaceException(f2, j2, length);
                    }
                    if (!com.kwai.filedownloader.f.e.a().f36851f) {
                        aVar.b(j);
                    }
                } finally {
                    if (0 != 0) {
                        aVar.b();
                    }
                }
            }
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, aVar, bVar) == null) {
            if (!this.q) {
                this.f36760d.a(0L);
                aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.f36776c, aVar.f36777d);
            }
            e.a aVar2 = new e.a();
            aVar2.a(this).b(this.f36760d.a()).a(-1).a(this.f36763g).a(bVar).a(aVar).a(this.f36760d.e());
            this.f36760d.b(1);
            this.f36764h.a(this.f36760d.a(), 1);
            this.m = aVar2.a();
            if (!this.t) {
                this.m.b();
                return;
            }
            this.f36760d.a((byte) -2);
            this.m.a();
        }
    }

    private void a(List<com.kwai.filedownloader.d.a> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, this, list, j) == null) {
            int a2 = this.f36760d.a();
            String j2 = this.f36760d.j();
            String str = this.w;
            if (str == null) {
                str = this.f36760d.b();
            }
            String e2 = this.f36760d.e();
            if (com.kwai.filedownloader.f.d.f36845a) {
                com.kwai.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a2), Long.valueOf(j));
            }
            boolean z = this.p;
            long j3 = 0;
            long j4 = 0;
            for (com.kwai.filedownloader.d.a aVar : list) {
                long d2 = aVar.e() == j3 ? j - aVar.d() : (aVar.e() - aVar.d()) + 1;
                j4 += aVar.d() - aVar.c();
                if (d2 != j3) {
                    c a3 = new c.a().a(a2).a(Integer.valueOf(aVar.b())).a(this).a(str).b(z ? j2 : null).a(this.f36761e).a(this.f36763g).a(new com.kwai.filedownloader.download.a(aVar.c(), aVar.d(), aVar.e(), d2)).c(e2).a();
                    if (com.kwai.filedownloader.f.d.f36845a) {
                        com.kwai.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                    }
                    if (a3 == null) {
                        throw new IllegalArgumentException("the download runnable must not be null!");
                    }
                    this.l.add(a3);
                } else if (com.kwai.filedownloader.f.d.f36845a) {
                    com.kwai.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.a()), Integer.valueOf(aVar.b()));
                }
                j3 = 0;
            }
            if (j4 != this.f36760d.g()) {
                com.kwai.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f36760d.g()), Long.valueOf(j4));
                this.f36760d.a(j4);
            }
            ArrayList arrayList = new ArrayList(this.l.size());
            Iterator<c> it = this.l.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (this.t) {
                    next.a();
                } else {
                    arrayList.add(Executors.callable(next));
                }
            }
            if (this.t) {
                this.f36760d.a((byte) -2);
                return;
            }
            List<Future> invokeAll = o.invokeAll(arrayList);
            if (com.kwai.filedownloader.f.d.f36845a) {
                for (Future future : invokeAll) {
                    com.kwai.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
                }
            }
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, this, map, connectTask, bVar) == null) {
            int a2 = this.f36760d.a();
            int e2 = bVar.e();
            this.q = e2 == 206 || e2 == 1;
            boolean z = e2 == 200 || e2 == 201 || e2 == 0;
            String j = this.f36760d.j();
            String a3 = com.kwai.filedownloader.f.f.a(a2, bVar);
            if (!(e2 == 412 || !(j == null || j.equals(a3) || (!z && !this.q)) || ((e2 == 201 && connectTask.b()) || (e2 == 416 && this.f36760d.g() > 0)))) {
                this.w = connectTask.c();
                if (!this.q && !z) {
                    throw new FileDownloadHttpException(e2, map, bVar.c());
                }
                long b2 = com.kwai.filedownloader.f.f.b(a2, bVar);
                String a4 = this.f36760d.l() ? com.kwai.filedownloader.f.f.a(bVar, this.f36760d.b()) : null;
                boolean z2 = b2 == -1;
                this.r = z2;
                this.f36758b.a(this.p && this.q, !z2 ? this.f36760d.g() + b2 : b2, a3, a4);
                return;
            }
            if (this.p) {
                com.kwai.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(a2), j, a3, Integer.valueOf(e2));
            }
            this.f36764h.d(this.f36760d.a());
            com.kwai.filedownloader.f.f.c(this.f36760d.d(), this.f36760d.e());
            this.p = false;
            if (j != 0 && j.equals(a3)) {
                com.kwai.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", j, a3, Integer.valueOf(e2), Integer.valueOf(a2));
                a3 = null;
            }
            this.f36760d.a(0L);
            this.f36760d.c(0L);
            this.f36760d.b(a3);
            this.f36760d.o();
            this.f36764h.a(a2, this.f36760d.j(), this.f36760d.g(), this.f36760d.h(), this.f36760d.n());
            throw new RetryDirectly(this);
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? (!this.p || this.f36760d.n() > 1) && this.q && this.k && !this.r : invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.f36763g && !com.kwai.filedownloader.f.f.j(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f36760d.a()), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
            }
            if (this.f36763g && com.kwai.filedownloader.f.f.d()) {
                throw new FileDownloadNetworkPolicyException();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int a2 = this.f36760d.a();
            if (this.f36760d.l()) {
                String d2 = this.f36760d.d();
                int b2 = com.kwai.filedownloader.f.f.b(this.f36760d.b(), d2);
                if (com.kwai.filedownloader.f.c.a(a2, d2, this.f36762f, false)) {
                    this.f36764h.e(a2);
                    this.f36764h.d(a2);
                    throw new DiscardSafely(this);
                }
                com.kwai.filedownloader.d.c b3 = this.f36764h.b(b2);
                if (b3 != null) {
                    if (com.kwai.filedownloader.f.c.a(a2, b3, this.f36765i, false)) {
                        this.f36764h.e(a2);
                        this.f36764h.d(a2);
                        throw new DiscardSafely(this);
                    }
                    List<com.kwai.filedownloader.d.a> c2 = this.f36764h.c(b2);
                    this.f36764h.e(b2);
                    this.f36764h.d(b2);
                    com.kwai.filedownloader.f.f.n(this.f36760d.d());
                    if (com.kwai.filedownloader.f.f.a(b2, b3)) {
                        this.f36760d.a(b3.g());
                        this.f36760d.c(b3.h());
                        this.f36760d.b(b3.j());
                        this.f36760d.b(b3.n());
                        this.f36764h.a(this.f36760d);
                        if (c2 != null) {
                            for (com.kwai.filedownloader.d.a aVar : c2) {
                                aVar.a(a2);
                                this.f36764h.a(aVar);
                            }
                        }
                        throw new RetryDirectly(this);
                    }
                }
                if (com.kwai.filedownloader.f.c.a(a2, this.f36760d.g(), this.f36760d.e(), d2, this.f36765i)) {
                    this.f36764h.e(a2);
                    this.f36764h.d(a2);
                    throw new DiscardSafely(this);
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t = true;
            e eVar = this.m;
            if (eVar != null) {
                eVar.a();
            }
            Iterator it = ((ArrayList) this.l.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.t) {
            return;
        }
        this.f36758b.a(j);
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(c cVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.t) {
                if (com.kwai.filedownloader.f.d.f36845a) {
                    com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f36760d.a()));
                    return;
                }
                return;
            }
            int i2 = cVar == null ? -1 : cVar.f36785a;
            if (com.kwai.filedownloader.f.d.f36845a) {
                com.kwai.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f36760d.h()));
            }
            if (!this.n) {
                synchronized (this.l) {
                    this.l.remove(cVar);
                }
            } else if (j == 0 || j2 == this.f36760d.h()) {
            } else {
                com.kwai.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f36760d.h()), Integer.valueOf(this.f36760d.a()));
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(Exception exc, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, exc, j) == null) {
            if (this.t) {
                if (com.kwai.filedownloader.f.d.f36845a) {
                    com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f36760d.a()));
                    return;
                }
                return;
            }
            int i2 = this.f36757a;
            int i3 = i2 - 1;
            this.f36757a = i3;
            if (i2 < 0) {
                com.kwai.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.f36760d.a()));
            }
            this.f36758b.a(exc, this.f36757a, j);
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public boolean a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, exc)) == null) {
            if (exc instanceof FileDownloadHttpException) {
                int code = ((FileDownloadHttpException) exc).getCode();
                if (this.n && code == 416 && !this.j) {
                    com.kwai.filedownloader.f.f.c(this.f36760d.d(), this.f36760d.e());
                    this.j = true;
                    return true;
                }
            }
            return this.f36757a > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f36760d.n() > 1) {
                List<com.kwai.filedownloader.d.a> c2 = this.f36764h.c(this.f36760d.a());
                if (this.f36760d.n() == c2.size()) {
                    this.f36760d.a(com.kwai.filedownloader.d.a.a(c2));
                } else {
                    this.f36760d.a(0L);
                    this.f36764h.d(this.f36760d.a());
                }
            }
            this.f36758b.c();
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            this.u = true;
            this.v = exc;
            if (this.t) {
                if (com.kwai.filedownloader.f.d.f36845a) {
                    com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f36760d.a()));
                    return;
                }
                return;
            }
            Iterator it = ((ArrayList) this.l.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.b();
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f36764h.a(this.f36760d.a(), this.f36760d.g());
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36760d.a() : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s.get() || this.f36758b.a() : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f36760d.e() : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e3, code lost:
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e7, code lost:
        a(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ec, code lost:
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ed, code lost:
        if (r9 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01ef, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0203, code lost:
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.f.f.a("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        if (com.kwai.filedownloader.f.d.f36845a == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
        com.kwai.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.f36760d.a()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        r19.f36758b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r19.t == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
        if (r19.u == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        r19.f36758b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0126, code lost:
        if (r19.t == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
        r19.f36760d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012d, code lost:
        if (r9 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012f, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0132, code lost:
        r19.f36758b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r19.t == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r19.u == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0143, code lost:
        r19.f36758b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014e, code lost:
        i();
        r14 = r19.f36760d.h();
        a(r14, r19.f36760d.e());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        if (g() == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0168, code lost:
        if (r19.p == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016a, code lost:
        r10 = r19.f36760d.n();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0173, code lost:
        r17 = r14;
        r10 = com.kwai.filedownloader.download.b.a().a(r19.f36760d.a(), r19.f36760d.b(), r19.f36760d.c(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0193, code lost:
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        if (r10 <= 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019a, code lost:
        if (r19.t == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019c, code lost:
        r19.f36760d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a1, code lost:
        if (r9 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a3, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a6, code lost:
        r19.f36758b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        if (r19.t == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b3, code lost:
        if (r19.u == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b7, code lost:
        r19.f36758b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01bf, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c2, code lost:
        if (r10 != 1) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c4, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c6, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c7, code lost:
        r19.n = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c9, code lost:
        if (r11 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cb, code lost:
        a(r8.e(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        if (r9 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d5, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d9, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01da, code lost:
        r19.f36758b.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e1, code lost:
        if (r19.p == false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0260 A[Catch: all -> 0x021b, TryCatch #24 {all -> 0x021b, blocks: (B:49:0x00d5, B:98:0x01da, B:100:0x01e3, B:101:0x01e7, B:154:0x025a, B:156:0x0260, B:159:0x0268, B:126:0x021f), top: B:209:0x025a }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02a0 A[Catch: all -> 0x02a4, TRY_ENTER, TryCatch #1 {all -> 0x02a4, blocks: (B:5:0x0009, B:8:0x0018, B:10:0x0020, B:12:0x0024, B:13:0x0036, B:27:0x0094, B:29:0x0098, B:30:0x009d, B:32:0x00a1, B:34:0x00a5, B:45:0x00ce, B:54:0x012f, B:77:0x01a3, B:104:0x01ef, B:175:0x02a0, B:176:0x02a3, B:131:0x022f, B:128:0x0227, B:161:0x026d), top: B:194:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0268 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        IOException iOException;
        Exception exc;
        Throwable th;
        ConnectTask a2;
        com.kwai.filedownloader.a.b a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                Process.setThreadPriority(10);
                if (this.f36760d.f() != 1) {
                    if (this.f36760d.f() != -2) {
                        b(new RuntimeException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f36760d.a()), Byte.valueOf(this.f36760d.f()), (byte) 1)));
                    } else if (com.kwai.filedownloader.f.d.f36845a) {
                        com.kwai.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f36760d.a()));
                    }
                    this.f36758b.b();
                    if (!this.t) {
                        if (!this.u) {
                            try {
                                this.f36758b.g();
                            } catch (IOException e2) {
                                iOException = e2;
                                this.f36758b.a(iOException);
                                this.s.set(false);
                            }
                        }
                        this.f36758b.a(this.v);
                    }
                    this.f36758b.f();
                } else {
                    if (!this.t) {
                        this.f36758b.d();
                    }
                    while (true) {
                        if (this.t) {
                            break;
                        } else if (this.f36764h == null) {
                            break;
                        } else {
                            com.kwai.filedownloader.a.b bVar = null;
                            try {
                                h();
                                List<com.kwai.filedownloader.d.a> c2 = this.f36764h.c(this.f36760d.a());
                                a2 = new ConnectTask.a().a(this.f36760d.a()).a(this.f36760d.b()).b(this.f36760d.j()).a(this.f36761e).a(a(c2)).a();
                                a3 = a2.a();
                            } catch (DiscardSafely unused) {
                            } catch (RetryDirectly unused2) {
                            } catch (FileDownloadGiveUpRetryException e3) {
                                e = e3;
                                exc = e;
                                try {
                                    if (a(exc)) {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.f();
                                        }
                                        this.f36758b.b();
                                        if (this.t) {
                                            this.f36758b.f();
                                        } else if (this.u) {
                                            this.f36758b.a(this.v);
                                        } else {
                                            try {
                                                this.f36758b.g();
                                            } catch (IOException e4) {
                                                this.f36758b.a(e4);
                                            }
                                        }
                                        this.s.set(false);
                                        return;
                                    }
                                    a(exc, 0L);
                                    if (bVar != null) {
                                        bVar.f();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bVar != null) {
                                        bVar.f();
                                    }
                                    throw th;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (IllegalAccessException e6) {
                                e = e6;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (IllegalArgumentException e7) {
                                e = e7;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (InterruptedException e8) {
                                e = e8;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (NullPointerException e9) {
                                e = e9;
                                exc = e;
                                if (a(exc)) {
                                }
                            }
                            try {
                                a(a2.d(), a2, a3);
                                break;
                            } catch (DiscardSafely unused3) {
                                bVar = a3;
                                if (bVar != null) {
                                    bVar.f();
                                }
                                this.f36758b.b();
                                if (!this.t) {
                                    if (!this.u) {
                                        try {
                                            this.f36758b.g();
                                        } catch (IOException e10) {
                                            iOException = e10;
                                            this.f36758b.a(iOException);
                                            this.s.set(false);
                                        }
                                        this.s.set(false);
                                    }
                                    this.f36758b.a(this.v);
                                    this.s.set(false);
                                }
                                this.f36758b.f();
                                this.s.set(false);
                            } catch (RetryDirectly unused4) {
                                bVar = a3;
                                this.f36760d.a((byte) 5);
                                if (bVar != null) {
                                    bVar.f();
                                }
                            } catch (FileDownloadGiveUpRetryException e11) {
                                e = e11;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IOException e12) {
                                e = e12;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IllegalAccessException e13) {
                                e = e13;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IllegalArgumentException e14) {
                                e = e14;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (InterruptedException e15) {
                                e = e15;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (NullPointerException e16) {
                                e = e16;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bVar = a3;
                                if (bVar != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    this.f36758b.a(this.v);
                }
                this.s.set(false);
            } catch (Throwable th4) {
                this.f36758b.b();
                if (this.t) {
                    this.f36758b.f();
                } else if (this.u) {
                    this.f36758b.a(this.v);
                } else {
                    try {
                        this.f36758b.g();
                    } catch (IOException e17) {
                        this.f36758b.a(e17);
                    }
                }
                this.s.set(false);
                throw th4;
            }
        }
    }
}
