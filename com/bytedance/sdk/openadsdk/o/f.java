package com.bytedance.sdk.openadsdk.o;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.o.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f31614d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile ServerSocket f31615a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f31616b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f31617c;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.o.b.c f31618e;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.o.a.c f31619f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.o.a.b f31620g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Set<g>> f31621h;

    /* renamed from: i  reason: collision with root package name */
    public final g.c f31622i;
    public volatile c j;
    public volatile c k;
    public final Runnable l;
    public final AtomicBoolean m;

    /* loaded from: classes6.dex */
    public static final class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31629a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31630b;

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31629a = str;
            this.f31630b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Socket socket;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    socket = new Socket(this.f31629a, this.f31630b);
                    try {
                        socket.setSoTimeout(2000);
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.o.g.d.f31674a));
                        outputStream.flush();
                        if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                            return Boolean.TRUE;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            f.b("ping error", Log.getStackTraceString(th));
                            com.bytedance.sdk.openadsdk.o.g.d.a(socket);
                            return Boolean.FALSE;
                        } finally {
                            com.bytedance.sdk.openadsdk.o.g.d.a(socket);
                        }
                    }
                } catch (Throwable th3) {
                    socket = null;
                    th = th3;
                }
                com.bytedance.sdk.openadsdk.o.g.d.a(socket);
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public f() {
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
        this.f31617c = new AtomicInteger(0);
        this.f31621h = new SparseArray<>(2);
        this.f31622i = new g.c(this) { // from class: com.bytedance.sdk.openadsdk.o.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f31623a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f31623a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.o.g.c
            public void a(g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, gVar) == null) {
                    synchronized (this.f31623a.f31621h) {
                        Set set = (Set) this.f31623a.f31621h.get(gVar.f());
                        if (set != null) {
                            set.add(gVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.o.g.c
            public void b(g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                    if (e.f31597c) {
                        Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
                    }
                    int f2 = gVar.f();
                    synchronized (this.f31623a.f31621h) {
                        Set set = (Set) this.f31623a.f31621h.get(f2);
                        if (set != null) {
                            set.remove(gVar);
                        }
                    }
                }
            }
        };
        this.l = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.o.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f31624a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f31624a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        int i4 = 0;
                        this.f31624a.f31615a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                        f fVar = this.f31624a;
                        fVar.f31616b = fVar.f31615a.getLocalPort();
                        if (this.f31624a.f31616b != -1) {
                            j.a("127.0.0.1", this.f31624a.f31616b);
                            if (this.f31624a.g() && this.f31624a.f31617c.compareAndSet(0, 1)) {
                                if (e.f31597c) {
                                    Log.i("TAG_PROXY_ProxyServer", "proxy server start!");
                                }
                                while (this.f31624a.f31617c.get() == 1) {
                                    try {
                                        try {
                                            Socket accept = this.f31624a.f31615a.accept();
                                            com.bytedance.sdk.openadsdk.o.b.c cVar = this.f31624a.f31618e;
                                            if (cVar != null) {
                                                com.bytedance.sdk.component.e.e.a().execute(new com.bytedance.sdk.component.e.g(this, "ProxyTask", 10, new g.a().a(cVar).a(accept).a(this.f31624a.f31622i).a()) { // from class: com.bytedance.sdk.openadsdk.o.f.2.1
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ g f31625a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ AnonymousClass2 f31626b;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(r9, r10);
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                                            newInitContext2.initArgs = r2;
                                                            Object[] objArr = {this, r9, Integer.valueOf(r10), r11};
                                                            interceptable3.invokeUnInit(65536, newInitContext2);
                                                            int i5 = newInitContext2.flag;
                                                            if ((i5 & 1) != 0) {
                                                                int i6 = i5 & 2;
                                                                Object[] objArr2 = newInitContext2.callArgs;
                                                                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                                                                newInitContext2.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext2);
                                                                return;
                                                            }
                                                        }
                                                        this.f31626b = this;
                                                        this.f31625a = r11;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                            this.f31625a.run();
                                                        }
                                                    }
                                                });
                                            } else {
                                                com.bytedance.sdk.openadsdk.o.g.d.a(accept);
                                            }
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            f.b("accept error", Log.getStackTraceString(e2));
                                            i4++;
                                            if (i4 > 3) {
                                                break;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        String stackTraceString = Log.getStackTraceString(th);
                                        Log.e("TAG_PROXY_ProxyServer", "proxy server crashed!  " + stackTraceString);
                                        f.b("error", stackTraceString);
                                    }
                                }
                                if (e.f31597c) {
                                    Log.i("TAG_PROXY_ProxyServer", "proxy server closed!");
                                }
                                this.f31624a.e();
                                return;
                            }
                            return;
                        }
                        f.b("socket not bound", "");
                        this.f31624a.e();
                    } catch (IOException e3) {
                        if (e.f31597c) {
                            Log.e("TAG_PROXY_ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e3));
                        }
                        f.b("create ServerSocket error", Log.getStackTraceString(e3));
                        this.f31624a.e();
                    }
                }
            }
        };
        this.m = new AtomicBoolean();
        this.f31621h.put(0, new HashSet());
        this.f31621h.put(1, new HashSet());
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.f31617c.compareAndSet(1, 2) || this.f31617c.compareAndSet(0, 2)) {
                com.bytedance.sdk.openadsdk.o.g.d.a(this.f31615a);
                f();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f31621h) {
                int size = this.f31621h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Set<g> set = this.f31621h.get(this.f31621h.keyAt(i2));
                    if (set != null) {
                        arrayList.addAll(set);
                        set.clear();
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            com.bytedance.sdk.component.e.f fVar = new com.bytedance.sdk.component.e.f(new a("127.0.0.1", this.f31616b), 5, 1);
            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "pingTest", fVar) { // from class: com.bytedance.sdk.openadsdk.o.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.e.f f31627a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f31628b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31628b = this;
                    this.f31627a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.component.utils.j.b("TTExecutor", "pingTest.....run");
                        this.f31627a.run();
                    }
                }
            });
            h();
            try {
                if (!((Boolean) fVar.get()).booleanValue()) {
                    Log.e("TAG_PROXY_ProxyServer", "Ping error");
                    b("ping error", "");
                    e();
                    return false;
                }
                if (e.f31597c) {
                    Log.i("TAG_PROXY_ProxyServer", "Ping OK!");
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                b("ping error", Log.getStackTraceString(th));
                e();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Socket socket = null;
            try {
                try {
                    socket = this.f31615a.accept();
                    socket.setSoTimeout(2000);
                    if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.o.g.d.f31674a));
                        outputStream.flush();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    b("ping error", Log.getStackTraceString(e2));
                }
            } finally {
                com.bytedance.sdk.openadsdk.o.g.d.a(socket);
            }
        }
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (c) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (c) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.m.compareAndSet(false, true)) {
            Thread thread = new Thread(this.l);
            thread.setName("tt_pangle_thread_proxy_server");
            thread.start();
        }
    }

    public boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, str)) == null) {
            if (str == null) {
                return false;
            }
            synchronized (this.f31621h) {
                Set<g> set = this.f31621h.get(i2);
                if (set != null) {
                    for (g gVar : set) {
                        if (gVar != null && str.equals(gVar.f31522h)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f31614d == null) {
                synchronized (f.class) {
                    if (f31614d == null) {
                        f31614d = new f();
                    }
                }
            }
            return f31614d;
        }
        return (f) invokeV.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.o.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f31618e = cVar;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.o.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f31619f = cVar;
        }
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, strArr})) == null) {
            if (strArr != null && strArr.length != 0) {
                if (TextUtils.isEmpty(str)) {
                    b("key", "key is empty");
                    return strArr[0];
                } else if (this.f31618e == null) {
                    b(IMTrackDatabase.DbEnum.TABLE_NAME, "VideoProxyDB is null");
                    return strArr[0];
                } else {
                    if ((z ? this.f31620g : this.f31619f) == null) {
                        b(SapiOptions.KEY_CACHE, "Cache is null");
                        return strArr[0];
                    }
                    int i2 = this.f31617c.get();
                    if (i2 != 1) {
                        b("state", "ProxyServer is not running, " + i2);
                        return strArr[0];
                    }
                    List<String> a2 = com.bytedance.sdk.openadsdk.o.g.d.a(strArr);
                    if (a2 == null) {
                        b("url", "url not start with http/https");
                        return strArr[0];
                    }
                    String a3 = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.o.g.b.a(str), a2);
                    if (a3 == null) {
                        b("url", "combine proxy url error");
                        return strArr[0];
                    } else if (z) {
                        return "http://127.0.0.1:" + this.f31616b + "?f=1&" + a3;
                    } else {
                        return "http://127.0.0.1:" + this.f31616b + "?" + a3;
                    }
                }
            }
            b("url", "url is empty");
            return null;
        }
        return (String) invokeCommon.objValue;
    }
}
