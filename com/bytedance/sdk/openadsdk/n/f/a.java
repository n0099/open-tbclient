package com.bytedance.sdk.openadsdk.n.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.n.a.c;
import com.bytedance.sdk.openadsdk.n.d;
import com.bytedance.sdk.openadsdk.n.e;
import com.bytedance.sdk.openadsdk.n.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f68078a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f68079b;

    /* renamed from: c  reason: collision with root package name */
    public C1925a f68080c;

    /* renamed from: com.bytedance.sdk.openadsdk.n.f.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f68093a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436168549, "Lcom/bytedance/sdk/openadsdk/n/f/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1436168549, "Lcom/bytedance/sdk/openadsdk/n/f/a$b;");
                    return;
                }
            }
            f68093a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291996903, "Lcom/bytedance/sdk/openadsdk/n/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-291996903, "Lcom/bytedance/sdk/openadsdk/n/f/a;");
                return;
            }
        }
        f68078a = k.c();
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f68093a : (a) invokeV.objValue;
    }

    public static c c() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c cVar2 = null;
            if (com.bytedance.sdk.openadsdk.n.g.a.d()) {
                File file = new File(com.bytedance.sdk.openadsdk.n.g.a.a(com.bytedance.sdk.openadsdk.n.g.a.b(), SapiOptions.KEY_CACHE).getPath());
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    cVar = new c(file);
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    cVar.a(104857600L);
                    return cVar;
                } catch (IOException e3) {
                    e = e3;
                    cVar2 = cVar;
                    e.printStackTrace();
                    return cVar2;
                }
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f68080c != null) {
                return true;
            }
            c c2 = c();
            if (c2 == null) {
                return false;
            }
            e.a(true);
            e.b(true);
            e.a(1);
            f.a().d();
            try {
                C1925a c1925a = new C1925a(this);
                this.f68080c = c1925a;
                c1925a.setName("tt_pangle_thread_video_cache_preloader");
                this.f68080c.start();
                e.a(c2, o.a());
                d.c().a(30000L, 30000L, 30000L);
                d.c().a(10485759);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
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
        this.f68079b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (b()) {
                this.f68080c.a(bVar);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.n.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1925a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68081a;

        /* renamed from: b  reason: collision with root package name */
        public Queue<C1926a> f68082b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f68083c;

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C1926a> f68084d;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C1926a> f68085e;

        /* renamed from: com.bytedance.sdk.openadsdk.n.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1926a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f68086a;

            /* renamed from: b  reason: collision with root package name */
            public String f68087b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f68088c;

            /* renamed from: d  reason: collision with root package name */
            public int f68089d;

            /* renamed from: e  reason: collision with root package name */
            public String f68090e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.n.f.b f68091f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1925a f68092g;

            public C1926a(C1925a c1925a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1925a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68092g = c1925a;
            }
        }

        public C1925a(a aVar) {
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
            this.f68081a = aVar;
            this.f68084d = new ArrayBlockingQueue(10);
            this.f68082b = new LinkedBlockingQueue();
            this.f68083c = true;
            this.f68085e = new LinkedBlockingQueue();
        }

        private C1926a a(int i2, com.bytedance.sdk.openadsdk.n.f.b bVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, bVar)) == null) {
                b();
                k.b("VideoCachePreloader", "pool: " + this.f68084d.size());
                C1926a poll = this.f68084d.poll();
                if (poll == null) {
                    poll = new C1926a(this);
                }
                poll.f68086a = i2;
                poll.f68091f = bVar;
                return poll;
            }
            return (C1926a) invokeIL.objValue;
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            }
        }

        private synchronized void b(C1926a c1926a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, c1926a) == null) {
                synchronized (this) {
                    b();
                    this.f68085e.add(c1926a);
                    notify();
                }
            }
        }

        private void c(C1926a c1926a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, this, c1926a) == null) {
                a();
                if (c1926a == null) {
                    return;
                }
                this.f68082b.offer(c1926a);
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                while (this.f68083c) {
                    synchronized (this) {
                        if (!this.f68085e.isEmpty()) {
                            c();
                        }
                        while (!this.f68082b.isEmpty()) {
                            C1926a poll = this.f68082b.poll();
                            if (poll != null) {
                                int i2 = poll.f68086a;
                                if (i2 != 0) {
                                    if (i2 == 1) {
                                        d.c().a(poll.f68087b);
                                    } else if (i2 == 2) {
                                        d.c().d();
                                    } else if (i2 == 3) {
                                        d.c().d();
                                        if (e.c() != null) {
                                            e.c().a();
                                        }
                                        if (e.b() != null) {
                                            e.b().a();
                                        }
                                    } else if (i2 == 4) {
                                        d.c().d();
                                        this.f68083c = false;
                                    }
                                } else if (poll.f68088c != null && poll.f68088c.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : poll.f68088c) {
                                        if (com.bytedance.sdk.openadsdk.n.g.d.a(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    d.c().a(false, !TextUtils.isEmpty(poll.f68090e), poll.f68089d, poll.f68087b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                                a(poll);
                            }
                        }
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) != null) {
                return;
            }
            a();
            while (true) {
                C1926a poll = this.f68085e.poll();
                if (poll == null) {
                    return;
                }
                poll.f68087b = poll.f68091f.a();
                poll.f68088c = new String[]{poll.f68091f.a()};
                poll.f68089d = poll.f68091f.d();
                poll.f68090e = poll.f68091f.b();
                if (!TextUtils.isEmpty(poll.f68091f.b())) {
                    poll.f68087b = poll.f68091f.b();
                }
                poll.f68091f = null;
                c(poll);
            }
        }

        private void a(C1926a c1926a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, c1926a) == null) {
                a();
                c1926a.f68088c = null;
                c1926a.f68087b = null;
                c1926a.f68086a = -1;
                c1926a.f68091f = null;
                this.f68084d.offer(c1926a);
            }
        }

        public void a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b(a(0, bVar));
            }
        }
    }

    public String b(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            boolean z = !TextUtils.isEmpty(bVar.b());
            return f.a().a(false, z, z ? bVar.b() : bVar.a(), bVar.a());
        }
        return (String) invokeL.objValue;
    }
}
