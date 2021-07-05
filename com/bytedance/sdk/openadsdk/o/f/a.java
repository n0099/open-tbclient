package com.bytedance.sdk.openadsdk.o.f;

import android.text.TextUtils;
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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.o.a.c;
import com.bytedance.sdk.openadsdk.o.d;
import com.bytedance.sdk.openadsdk.o.e;
import com.bytedance.sdk.openadsdk.o.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f31631a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f31632b;

    /* renamed from: c  reason: collision with root package name */
    public C0359a f31633c;

    /* renamed from: com.bytedance.sdk.openadsdk.o.f.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f31646a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(306641786, "Lcom/bytedance/sdk/openadsdk/o/f/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(306641786, "Lcom/bytedance/sdk/openadsdk/o/f/a$b;");
                    return;
                }
            }
            f31646a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-263367752, "Lcom/bytedance/sdk/openadsdk/o/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-263367752, "Lcom/bytedance/sdk/openadsdk/o/f/a;");
                return;
            }
        }
        f31631a = j.c();
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f31646a : (a) invokeV.objValue;
    }

    public static c c() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            c cVar2 = null;
            if (com.bytedance.sdk.openadsdk.o.g.a.d()) {
                File file = new File(com.bytedance.sdk.openadsdk.o.g.a.a(com.bytedance.sdk.openadsdk.o.g.a.b(), SapiOptions.KEY_CACHE).getPath());
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
            if (this.f31633c != null) {
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
                C0359a c0359a = new C0359a(this);
                this.f31633c = c0359a;
                c0359a.setName("tt_pangle_thread_video_cache_preloader");
                this.f31633c.start();
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
        this.f31632b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.o.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (b()) {
                this.f31633c.a(bVar);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0359a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31634a;

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0360a> f31635b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31636c;

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0360a> f31637d;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0360a> f31638e;

        /* renamed from: com.bytedance.sdk.openadsdk.o.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0360a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f31639a;

            /* renamed from: b  reason: collision with root package name */
            public String f31640b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f31641c;

            /* renamed from: d  reason: collision with root package name */
            public int f31642d;

            /* renamed from: e  reason: collision with root package name */
            public String f31643e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.o.f.b f31644f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0359a f31645g;

            public C0360a(C0359a c0359a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0359a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31645g = c0359a;
            }
        }

        public C0359a(a aVar) {
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
            this.f31634a = aVar;
            this.f31637d = new ArrayBlockingQueue(10);
            this.f31635b = new LinkedBlockingQueue();
            this.f31636c = true;
            this.f31638e = new LinkedBlockingQueue();
        }

        private C0360a a(int i2, com.bytedance.sdk.openadsdk.o.f.b bVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, bVar)) == null) {
                b();
                j.b("VideoCachePreloader", "pool: " + this.f31637d.size());
                C0360a poll = this.f31637d.poll();
                if (poll == null) {
                    poll = new C0360a(this);
                }
                poll.f31639a = i2;
                poll.f31644f = bVar;
                return poll;
            }
            return (C0360a) invokeIL.objValue;
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            }
        }

        private synchronized void b(C0360a c0360a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, c0360a) == null) {
                synchronized (this) {
                    b();
                    this.f31638e.add(c0360a);
                    notify();
                }
            }
        }

        private void c(C0360a c0360a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, this, c0360a) == null) {
                a();
                if (c0360a == null) {
                    return;
                }
                this.f31635b.offer(c0360a);
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                while (this.f31636c) {
                    synchronized (this) {
                        if (!this.f31638e.isEmpty()) {
                            c();
                        }
                        while (!this.f31635b.isEmpty()) {
                            C0360a poll = this.f31635b.poll();
                            if (poll != null) {
                                int i2 = poll.f31639a;
                                if (i2 != 0) {
                                    if (i2 == 1) {
                                        d.c().a(poll.f31640b);
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
                                        this.f31636c = false;
                                    }
                                } else if (poll.f31641c != null && poll.f31641c.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : poll.f31641c) {
                                        if (com.bytedance.sdk.openadsdk.o.g.d.a(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    d.c().a(false, !TextUtils.isEmpty(poll.f31643e), poll.f31642d, poll.f31640b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0360a poll = this.f31638e.poll();
                if (poll == null) {
                    return;
                }
                poll.f31640b = poll.f31644f.a();
                poll.f31641c = new String[]{poll.f31644f.a()};
                poll.f31642d = poll.f31644f.c();
                poll.f31643e = poll.f31644f.b();
                if (!TextUtils.isEmpty(poll.f31644f.b())) {
                    poll.f31640b = poll.f31644f.b();
                }
                poll.f31644f = null;
                c(poll);
            }
        }

        private void a(C0360a c0360a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, c0360a) == null) {
                a();
                c0360a.f31641c = null;
                c0360a.f31640b = null;
                c0360a.f31639a = -1;
                c0360a.f31644f = null;
                this.f31637d.offer(c0360a);
            }
        }

        public void a(com.bytedance.sdk.openadsdk.o.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b(a(0, bVar));
            }
        }
    }

    public String b(com.bytedance.sdk.openadsdk.o.f.b bVar) {
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
