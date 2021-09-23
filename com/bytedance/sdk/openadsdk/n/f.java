package com.bytedance.sdk.openadsdk.n;

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
import com.bytedance.sdk.openadsdk.n.g;
import com.dxmpay.wallet.utils.StatHelper;
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
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f68551d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile ServerSocket f68552a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f68553b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f68554c;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.b.c f68555e;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.a.c f68556f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.a.b f68557g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Set<g>> f68558h;

    /* renamed from: i  reason: collision with root package name */
    public final g.c f68559i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c f68560j;
    public volatile c k;
    public final Runnable l;
    public final AtomicBoolean m;

    /* loaded from: classes9.dex */
    public static final class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f68567a;

        /* renamed from: b  reason: collision with root package name */
        public final int f68568b;

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
            this.f68567a = str;
            this.f68568b = i2;
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
                    socket = new Socket(this.f68567a, this.f68568b);
                    try {
                        socket.setSoTimeout(2000);
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.n.g.d.f68613a));
                        outputStream.flush();
                        if (StatHelper.SENSOR_OK.equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                            return Boolean.TRUE;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            f.b("ping error", Log.getStackTraceString(th));
                            com.bytedance.sdk.openadsdk.n.g.d.a(socket);
                            return Boolean.FALSE;
                        } finally {
                            com.bytedance.sdk.openadsdk.n.g.d.a(socket);
                        }
                    }
                } catch (Throwable th3) {
                    socket = null;
                    th = th3;
                }
                com.bytedance.sdk.openadsdk.n.g.d.a(socket);
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
        this.f68554c = new AtomicInteger(0);
        this.f68558h = new SparseArray<>(2);
        this.f68559i = new g.c(this) { // from class: com.bytedance.sdk.openadsdk.n.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f68561a;

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
                this.f68561a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.n.g.c
            public void a(g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, gVar) == null) {
                    synchronized (this.f68561a.f68558h) {
                        Set set = (Set) this.f68561a.f68558h.get(gVar.f());
                        if (set != null) {
                            set.add(gVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.n.g.c
            public void b(g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                    if (e.f68533c) {
                        String str = "afterExecute, ProxyTask: " + gVar;
                    }
                    int f2 = gVar.f();
                    synchronized (this.f68561a.f68558h) {
                        Set set = (Set) this.f68561a.f68558h.get(f2);
                        if (set != null) {
                            set.remove(gVar);
                        }
                    }
                }
            }
        };
        this.l = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.n.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f68562a;

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
                this.f68562a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        int i4 = 0;
                        this.f68562a.f68552a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                        f fVar = this.f68562a;
                        fVar.f68553b = fVar.f68552a.getLocalPort();
                        if (this.f68562a.f68553b != -1) {
                            j.a("127.0.0.1", this.f68562a.f68553b);
                            if (this.f68562a.g() && this.f68562a.f68554c.compareAndSet(0, 1)) {
                                boolean z = e.f68533c;
                                while (this.f68562a.f68554c.get() == 1) {
                                    try {
                                        try {
                                            Socket accept = this.f68562a.f68552a.accept();
                                            com.bytedance.sdk.openadsdk.n.b.c cVar = this.f68562a.f68555e;
                                            if (cVar != null) {
                                                com.bytedance.sdk.component.d.e.a().execute(new com.bytedance.sdk.component.d.g(this, "ProxyTask", 10, new g.a().a(cVar).a(accept).a(this.f68562a.f68559i).a()) { // from class: com.bytedance.sdk.openadsdk.n.f.2.1
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ g f68563a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ AnonymousClass2 f68564b;

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
                                                        this.f68564b = this;
                                                        this.f68563a = r11;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                            this.f68563a.run();
                                                        }
                                                    }
                                                });
                                            } else {
                                                com.bytedance.sdk.openadsdk.n.g.d.a(accept);
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
                                        String str = "proxy server crashed!  " + stackTraceString;
                                        f.b("error", stackTraceString);
                                    }
                                }
                                boolean z2 = e.f68533c;
                                this.f68562a.e();
                                return;
                            }
                            return;
                        }
                        f.b("socket not bound", "");
                        this.f68562a.e();
                    } catch (IOException e3) {
                        if (e.f68533c) {
                            String str2 = "create ServerSocket error!  " + Log.getStackTraceString(e3);
                        }
                        f.b("create ServerSocket error", Log.getStackTraceString(e3));
                        this.f68562a.e();
                    }
                }
            }
        };
        this.m = new AtomicBoolean();
        this.f68558h.put(0, new HashSet());
        this.f68558h.put(1, new HashSet());
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
            if (this.f68554c.compareAndSet(1, 2) || this.f68554c.compareAndSet(0, 2)) {
                com.bytedance.sdk.openadsdk.n.g.d.a(this.f68552a);
                f();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f68558h) {
                int size = this.f68558h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Set<g> set = this.f68558h.get(this.f68558h.keyAt(i2));
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
            com.bytedance.sdk.component.d.f fVar = new com.bytedance.sdk.component.d.f(new a("127.0.0.1", this.f68553b), 5, 1);
            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "pingTest", fVar) { // from class: com.bytedance.sdk.openadsdk.n.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.d.f f68565a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f68566b;

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
                    this.f68566b = this;
                    this.f68565a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.component.utils.k.b("TTExecutor", "pingTest.....run");
                        this.f68565a.run();
                    }
                }
            });
            h();
            try {
                if (!((Boolean) fVar.get()).booleanValue()) {
                    b("ping error", "");
                    e();
                    return false;
                }
                boolean z = e.f68533c;
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
                    socket = this.f68552a.accept();
                    socket.setSoTimeout(2000);
                    if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.n.g.d.f68613a));
                        outputStream.flush();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    b("ping error", Log.getStackTraceString(e2));
                }
            } finally {
                com.bytedance.sdk.openadsdk.n.g.d.a(socket);
            }
        }
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68560j : (c) invokeV.objValue;
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
            synchronized (this.f68558h) {
                Set<g> set = this.f68558h.get(i2);
                if (set != null) {
                    for (g gVar : set) {
                        if (gVar != null && str.equals(gVar.f68454h)) {
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
            if (f68551d == null) {
                synchronized (f.class) {
                    if (f68551d == null) {
                        f68551d = new f();
                    }
                }
            }
            return f68551d;
        }
        return (f) invokeV.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f68555e = cVar;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.n.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f68556f = cVar;
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
                } else if (this.f68555e == null) {
                    b(IMTrackDatabase.DbEnum.TABLE_NAME, "VideoProxyDB is null");
                    return strArr[0];
                } else {
                    if ((z ? this.f68557g : this.f68556f) == null) {
                        b(SapiOptions.KEY_CACHE, "Cache is null");
                        return strArr[0];
                    }
                    int i2 = this.f68554c.get();
                    if (i2 != 1) {
                        b("state", "ProxyServer is not running, " + i2);
                        return strArr[0];
                    }
                    List<String> a2 = com.bytedance.sdk.openadsdk.n.g.d.a(strArr);
                    if (a2 == null) {
                        b("url", "url not start with http/https");
                        return strArr[0];
                    }
                    String a3 = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.n.g.b.a(str), a2);
                    if (a3 == null) {
                        b("url", "combine proxy url error");
                        return strArr[0];
                    } else if (z) {
                        return "http://127.0.0.1:" + this.f68553b + "?f=1&" + a3;
                    } else {
                        return "http://127.0.0.1:" + this.f68553b + "?" + a3;
                    }
                }
            }
            b("url", "url is empty");
            return null;
        }
        return (String) invokeCommon.objValue;
    }
}
