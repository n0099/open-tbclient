package com.kwai.filedownloader.download;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.y;
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
/* loaded from: classes5.dex */
public class DownloadLaunchRunnable implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor o;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public int a;
    public final d b;
    public final int c;
    public final com.kwai.filedownloader.c.c d;
    public final com.kwai.filedownloader.c.b e;
    public final boolean f;
    public final boolean g;
    public final com.kwai.filedownloader.a.a h;
    public final y i;
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
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwai.filedownloader.c.c a;
        public com.kwai.filedownloader.c.b b;
        public y c;
        public Integer d;
        public Integer e;
        public Boolean f;
        public Boolean g;
        public Integer h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(com.kwai.filedownloader.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.a = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yVar)) == null) {
                this.c = yVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bool)) == null) {
                this.f = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
                this.d = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public DownloadLaunchRunnable a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.a == null || this.c == null || this.d == null || this.e == null || this.f == null || this.g == null || this.h == null) {
                    throw new IllegalArgumentException();
                }
                return new DownloadLaunchRunnable(this.a, this.b, this.c, this.d.intValue(), this.e.intValue(), this.f.booleanValue(), this.g.booleanValue(), this.h.intValue(), null);
            }
            return (DownloadLaunchRunnable) invokeV.objValue;
        }

        public a b(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bool)) == null) {
                this.g = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) {
                this.e = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num)) == null) {
                this.h = num;
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
        o = com.kwai.filedownloader.e.b.a("ConnectionBlock");
    }

    public DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, yVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 5;
        this.l = new ArrayList<>(5);
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.s = new AtomicBoolean(true);
        this.t = false;
        this.j = false;
        this.d = cVar;
        this.e = bVar;
        this.f = z;
        this.g = z2;
        this.h = b.a().c();
        this.k = b.a().e();
        this.i = yVar;
        this.a = i3;
        this.b = new d(cVar, i3, i, i2);
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, AnonymousClass1 anonymousClass1) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwai.filedownloader.download.a a(List<com.kwai.filedownloader.c.a> list) {
        InterceptResult invokeL;
        long g;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            int n = this.d.n();
            String e = this.d.e();
            String d = this.d.d();
            boolean z2 = n > 1;
            if ((!z2 || this.k) && com.kwai.filedownloader.e.f.a(this.d.a(), this.d)) {
                if (!this.k) {
                    g = new File(e).length();
                } else if (!z2) {
                    g = this.d.g();
                } else if (n == list.size()) {
                    g = com.kwai.filedownloader.c.a.a(list);
                }
                j = g;
                this.d.a(j);
                z = j > 0;
                this.p = z;
                if (!z) {
                    this.h.d(this.d.a());
                    com.kwai.filedownloader.e.f.c(d, e);
                }
                return new com.kwai.filedownloader.download.a(0L, j, 0L, this.d.h() - j);
            }
            j = 0;
            this.d.a(j);
            if (j > 0) {
            }
            this.p = z;
            if (!z) {
            }
            return new com.kwai.filedownloader.download.a(0L, j, 0L, this.d.h() - j);
        }
        return (com.kwai.filedownloader.download.a) invokeL.objValue;
    }

    private void a(int i, List<com.kwai.filedownloader.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, list) == null) {
            if (i <= 1 || list.size() != i) {
                throw new IllegalArgumentException();
            }
            a(list, this.d.h());
        }
    }

    private void a(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long j2 = j / i;
            int a2 = this.d.a();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            long j3 = 0;
            while (i2 < i) {
                long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
                com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                aVar.a(a2);
                aVar.b(i2);
                aVar.a(j3);
                aVar.b(j3);
                aVar.c(j4);
                arrayList.add(aVar);
                this.h.a(aVar);
                j3 += j2;
                i2++;
            }
            this.d.b(i);
            this.h.a(a2, i);
            a(arrayList, j);
        }
    }

    private void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65542, this, j, str) == null) {
            com.kwai.filedownloader.d.a aVar = null;
            if (j != -1) {
                try {
                    aVar = com.kwai.filedownloader.e.f.l(this.d.e());
                    long length = new File(str).length();
                    long j2 = j - length;
                    long f = com.kwai.filedownloader.e.f.f(str);
                    if (f < j2) {
                        throw new FileDownloadOutOfSpaceException(f, j2, length);
                    }
                    if (!com.kwai.filedownloader.e.e.a().f) {
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

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, aVar, bVar) == null) {
            if (!this.q) {
                this.d.a(0L);
                aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.c, aVar.d);
            }
            e.a aVar2 = new e.a();
            aVar2.a(this).b(this.d.a()).a(-1).a(this.g).a(bVar).a(aVar).a(this.d.e());
            this.d.b(1);
            this.h.a(this.d.a(), 1);
            this.m = aVar2.a();
            if (!this.t) {
                this.m.b();
                return;
            }
            this.d.a((byte) -2);
            this.m.a();
        }
    }

    private void a(List<com.kwai.filedownloader.c.a> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, this, list, j) == null) {
            int a2 = this.d.a();
            String j2 = this.d.j();
            String str = this.w;
            if (str == null) {
                str = this.d.b();
            }
            String e = this.d.e();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a2), Long.valueOf(j));
            }
            boolean z = this.p;
            long j3 = 0;
            long j4 = 0;
            for (com.kwai.filedownloader.c.a aVar : list) {
                long d = aVar.e() == j3 ? j - aVar.d() : (aVar.e() - aVar.d()) + 1;
                j4 += aVar.d() - aVar.c();
                if (d != j3) {
                    c a3 = new c.a().a(a2).a(Integer.valueOf(aVar.b())).a(this).a(str).b(z ? j2 : null).a(this.e).a(this.g).a(new com.kwai.filedownloader.download.a(aVar.c(), aVar.d(), aVar.e(), d)).c(e).a();
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "enable multiple connection: %s", aVar);
                    }
                    if (a3 == null) {
                        throw new IllegalArgumentException("the download runnable must not be null!");
                    }
                    this.l.add(a3);
                } else if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.a()), Integer.valueOf(aVar.b()));
                }
                j3 = 0;
            }
            if (j4 != this.d.g()) {
                com.kwai.filedownloader.e.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.d.g()), Long.valueOf(j4));
                this.d.a(j4);
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
                this.d.a((byte) -2);
                return;
            }
            List<Future> invokeAll = o.invokeAll(arrayList);
            if (com.kwai.filedownloader.e.d.a) {
                for (Future future : invokeAll) {
                    com.kwai.filedownloader.e.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
                }
            }
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, this, map, connectTask, bVar) == null) {
            int a2 = this.d.a();
            int e = bVar.e();
            this.q = e == 206 || e == 1;
            boolean z = e == 200 || e == 201 || e == 0;
            String j = this.d.j();
            String a3 = com.kwai.filedownloader.e.f.a(a2, bVar);
            if (!(e == 412 || !(j == null || j.equals(a3) || (!z && !this.q)) || ((e == 201 && connectTask.b()) || (e == 416 && this.d.g() > 0)))) {
                this.w = connectTask.c();
                if (!this.q && !z) {
                    throw new FileDownloadHttpException(e, map, bVar.c());
                }
                long b = com.kwai.filedownloader.e.f.b(a2, bVar);
                String a4 = this.d.l() ? com.kwai.filedownloader.e.f.a(bVar, this.d.b()) : null;
                boolean z2 = b == -1;
                this.r = z2;
                this.b.a(this.p && this.q, !z2 ? this.d.g() + b : b, a3, a4);
                return;
            }
            if (this.p) {
                com.kwai.filedownloader.e.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(a2), j, a3, Integer.valueOf(e));
            }
            this.h.d(this.d.a());
            com.kwai.filedownloader.e.f.c(this.d.d(), this.d.e());
            this.p = false;
            if (j != 0 && j.equals(a3)) {
                com.kwai.filedownloader.e.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", j, a3, Integer.valueOf(e), Integer.valueOf(a2));
                a3 = null;
            }
            this.d.a(0L);
            this.d.c(0L);
            this.d.b(a3);
            this.d.o();
            this.h.a(a2, this.d.j(), this.d.g(), this.d.h(), this.d.n());
            throw new RetryDirectly(this);
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? (!this.p || this.d.n() > 1) && this.q && this.k && !this.r : invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.g && !com.kwai.filedownloader.e.f.j("android.permission.ACCESS_NETWORK_STATE")) {
                throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.d.a()), "android.permission.ACCESS_NETWORK_STATE"));
            }
            if (this.g && com.kwai.filedownloader.e.f.d()) {
                throw new FileDownloadNetworkPolicyException();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int a2 = this.d.a();
            if (this.d.l()) {
                String d = this.d.d();
                int b = com.kwai.filedownloader.e.f.b(this.d.b(), d);
                if (com.kwai.filedownloader.e.c.a(a2, d, this.f, false)) {
                    this.h.e(a2);
                    this.h.d(a2);
                    throw new DiscardSafely(this);
                }
                com.kwai.filedownloader.c.c b2 = this.h.b(b);
                if (b2 != null) {
                    if (com.kwai.filedownloader.e.c.a(a2, b2, this.i, false)) {
                        this.h.e(a2);
                        this.h.d(a2);
                        throw new DiscardSafely(this);
                    }
                    List<com.kwai.filedownloader.c.a> c = this.h.c(b);
                    this.h.e(b);
                    this.h.d(b);
                    com.kwai.filedownloader.e.f.n(this.d.d());
                    if (com.kwai.filedownloader.e.f.a(b, b2)) {
                        this.d.a(b2.g());
                        this.d.c(b2.h());
                        this.d.b(b2.j());
                        this.d.b(b2.n());
                        this.h.a(this.d);
                        if (c != null) {
                            for (com.kwai.filedownloader.c.a aVar : c) {
                                aVar.a(a2);
                                this.h.a(aVar);
                            }
                        }
                        throw new RetryDirectly(this);
                    }
                }
                if (com.kwai.filedownloader.e.c.a(a2, this.d.g(), this.d.e(), d, this.i)) {
                    this.h.e(a2);
                    this.h.d(a2);
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
        this.b.a(j);
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(c cVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.t) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.d.a()));
                    return;
                }
                return;
            }
            int i = cVar == null ? -1 : cVar.a;
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.d.h()));
            }
            if (!this.n) {
                synchronized (this.l) {
                    this.l.remove(cVar);
                }
            } else if (j == 0 || j2 == this.d.h()) {
            } else {
                com.kwai.filedownloader.e.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.d.h()), Integer.valueOf(this.d.a()));
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(Exception exc, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, exc, j) == null) {
            if (this.t) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.d.a()));
                    return;
                }
                return;
            }
            int i = this.a;
            int i2 = i - 1;
            this.a = i2;
            if (i < 0) {
                com.kwai.filedownloader.e.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.d.a()));
            }
            this.b.a(exc, this.a, j);
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
                    com.kwai.filedownloader.e.f.c(this.d.d(), this.d.e());
                    this.j = true;
                    return true;
                }
            }
            return this.a > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d.n() > 1) {
                List<com.kwai.filedownloader.c.a> c = this.h.c(this.d.a());
                if (this.d.n() == c.size()) {
                    this.d.a(com.kwai.filedownloader.c.a.a(c));
                } else {
                    this.d.a(0L);
                    this.h.d(this.d.a());
                }
            }
            this.b.c();
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            this.u = true;
            this.v = exc;
            if (this.t) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.d.a()));
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
            this.h.a(this.d.a(), this.d.g());
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d.a() : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s.get() || this.b.a() : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d.e() : (String) invokeV.objValue;
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
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.e.f.a("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        if (com.kwai.filedownloader.e.d.a == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
        com.kwai.filedownloader.e.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.d.a()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        r19.b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r19.t == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
        if (r19.u == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        r19.b.g();
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
        r19.d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012d, code lost:
        if (r9 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012f, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0132, code lost:
        r19.b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r19.t == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r19.u == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0143, code lost:
        r19.b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014e, code lost:
        i();
        r14 = r19.d.h();
        a(r14, r19.d.e());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        if (g() == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0168, code lost:
        if (r19.p == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016a, code lost:
        r10 = r19.d.n();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0173, code lost:
        r17 = r14;
        r10 = com.kwai.filedownloader.download.b.a().a(r19.d.a(), r19.d.b(), r19.d.c(), r17);
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
        r19.d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a1, code lost:
        if (r9 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a3, code lost:
        r9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a6, code lost:
        r19.b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        if (r19.t == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b3, code lost:
        if (r19.u == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b7, code lost:
        r19.b.g();
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
        r19.b.e();
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
        com.kwai.filedownloader.kwai.b a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                Process.setThreadPriority(10);
                if (this.d.f() != 1) {
                    if (this.d.f() != -2) {
                        b(new RuntimeException(com.kwai.filedownloader.e.f.a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.d.a()), Byte.valueOf(this.d.f()), (byte) 1)));
                    } else if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.d.a()));
                    }
                    this.b.b();
                    if (!this.t) {
                        if (!this.u) {
                            try {
                                this.b.g();
                            } catch (IOException e) {
                                iOException = e;
                                this.b.a(iOException);
                                this.s.set(false);
                            }
                        }
                        this.b.a(this.v);
                    }
                    this.b.f();
                } else {
                    if (!this.t) {
                        this.b.d();
                    }
                    while (true) {
                        if (this.t) {
                            break;
                        } else if (this.h == null) {
                            break;
                        } else {
                            com.kwai.filedownloader.kwai.b bVar = null;
                            try {
                                h();
                                List<com.kwai.filedownloader.c.a> c = this.h.c(this.d.a());
                                a2 = new ConnectTask.a().a(this.d.a()).a(this.d.b()).b(this.d.j()).a(this.e).a(a(c)).a();
                                a3 = a2.a();
                            } catch (DiscardSafely unused) {
                            } catch (RetryDirectly unused2) {
                            } catch (FileDownloadGiveUpRetryException e2) {
                                e = e2;
                                exc = e;
                                try {
                                    if (a(exc)) {
                                        b(exc);
                                        if (bVar != null) {
                                            bVar.f();
                                        }
                                        this.b.b();
                                        if (this.t) {
                                            this.b.f();
                                        } else if (this.u) {
                                            this.b.a(this.v);
                                        } else {
                                            try {
                                                this.b.g();
                                            } catch (IOException e3) {
                                                this.b.a(e3);
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
                            } catch (IOException e4) {
                                e = e4;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (IllegalAccessException e5) {
                                e = e5;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (IllegalArgumentException e6) {
                                e = e6;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (InterruptedException e7) {
                                e = e7;
                                exc = e;
                                if (a(exc)) {
                                }
                            } catch (NullPointerException e8) {
                                e = e8;
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
                                this.b.b();
                                if (!this.t) {
                                    if (!this.u) {
                                        try {
                                            this.b.g();
                                        } catch (IOException e9) {
                                            iOException = e9;
                                            this.b.a(iOException);
                                            this.s.set(false);
                                        }
                                        this.s.set(false);
                                    }
                                    this.b.a(this.v);
                                    this.s.set(false);
                                }
                                this.b.f();
                                this.s.set(false);
                            } catch (RetryDirectly unused4) {
                                bVar = a3;
                                this.d.a((byte) 5);
                                if (bVar != null) {
                                    bVar.f();
                                }
                            } catch (FileDownloadGiveUpRetryException e10) {
                                e = e10;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IOException e11) {
                                e = e11;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IllegalAccessException e12) {
                                e = e12;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (IllegalArgumentException e13) {
                                e = e13;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (InterruptedException e14) {
                                e = e14;
                                exc = e;
                                bVar = a3;
                                if (a(exc)) {
                                }
                            } catch (NullPointerException e15) {
                                e = e15;
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
                    this.b.a(this.v);
                }
                this.s.set(false);
            } catch (Throwable th4) {
                this.b.b();
                if (this.t) {
                    this.b.f();
                } else if (this.u) {
                    this.b.a(this.v);
                } else {
                    try {
                        this.b.g();
                    } catch (IOException e16) {
                        this.b.a(e16);
                    }
                }
                this.s.set(false);
                throw th4;
            }
        }
    }
}
