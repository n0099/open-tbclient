package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.ss.android.socialbase.downloader.i.h<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f62625b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f62626c;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<InetAddress> a;

        /* renamed from: b  reason: collision with root package name */
        public long f62633b;

        public b() {
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
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2200c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746061432, "Lcom/ss/android/socialbase/downloader/network/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1746061432, "Lcom/ss/android/socialbase/downloader/network/c$c;");
                    return;
                }
            }
            a = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
        r10 = r2.a;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0092 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #3 {all -> 0x0099, blocks: (B:4:0x0004, B:5:0x000e, B:9:0x001a, B:12:0x0038, B:14:0x003e, B:16:0x0056, B:23:0x0067, B:31:0x007c, B:34:0x0083, B:37:0x008b, B:39:0x0092, B:36:0x0089, B:25:0x006d, B:18:0x005c, B:26:0x0071, B:6:0x000f, B:7:0x0017), top: B:50:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, a aVar, long j2) {
        b bVar;
        f u;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{str, aVar, Long.valueOf(j2)}) != null) {
            return;
        }
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.a) {
                bVar = this.a.get(host);
            }
            if (bVar != null && System.currentTimeMillis() - bVar.f62633b < com.ss.android.socialbase.downloader.g.a.c().a("dns_expire_min", 10) * 60 * 1000) {
                if (aVar != null) {
                    aVar.a(str, bVar.a);
                    return;
                }
                return;
            }
            Runnable runnable = new Runnable(this, aVar, str, bVar) { // from class: com.ss.android.socialbase.downloader.network.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f62630b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f62631c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ c f62632d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, str, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62632d = this;
                    this.a = aVar;
                    this.f62630b = str;
                    this.f62631c = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar2 = this.a) == null) {
                        return;
                    }
                    String str2 = this.f62630b;
                    b bVar2 = this.f62631c;
                    aVar2.a(str2, bVar2 == null ? null : bVar2.a);
                }
            };
            this.f62626c.postDelayed(runnable, j2);
            List<InetAddress> list = null;
            if (com.ss.android.socialbase.downloader.g.a.c().a("use_host_dns", 1) == 1 && (u = com.ss.android.socialbase.downloader.downloader.c.u()) != null) {
                list = u.a(host);
            }
            if (list == null || list.isEmpty()) {
                list = com.ss.android.socialbase.downloader.downloader.c.v().a(host);
            }
            if (list != null && !list.isEmpty()) {
                a(host, list);
                this.f62626c.removeCallbacks(runnable);
                if (aVar == null) {
                    aVar.a(str, list);
                    return;
                }
                return;
            }
            this.f62626c.removeCallbacks(runnable);
            if (aVar == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public c() {
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
        this.a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.f62625b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.f62626c = new Handler(com.ss.android.socialbase.downloader.h.e.a());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2200c.a : (c) invokeV.objValue;
    }

    public void a(String str, a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, aVar, Long.valueOf(j2)}) == null) {
            this.f62625b.post(new Runnable(this, str, aVar, j2) { // from class: com.ss.android.socialbase.downloader.network.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f62627b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f62628c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ c f62629d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, aVar, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62629d = this;
                    this.a = str;
                    this.f62627b = aVar;
                    this.f62628c = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62629d.b(this.a, this.f62627b, this.f62628c);
                    }
                }
            });
        }
    }

    private void a(String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, list) == null) {
            synchronized (this.a) {
                b bVar = this.a.get(str);
                if (bVar == null) {
                    bVar = new b();
                    this.a.put(str, bVar);
                }
                bVar.a = list;
                bVar.f62633b = System.currentTimeMillis();
            }
        }
    }
}
