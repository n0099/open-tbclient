package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.t60;
import com.tachikoma.core.component.input.ReturnKeyType;
import com.yy.gslbsdk.db.ProbeTB;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes7.dex */
public final class x60 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p60 D;
    public static volatile x60 E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;
    public AtomicInteger b;
    public int c;
    public boolean d;
    public volatile LinkedList<u60> e;
    public final HashMap<Long, u60> f;
    public final Object g;
    public final Object h;
    public b70 i;
    public Map<Long, s60> j;
    public Map<Long, s60> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public v60 r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes7.dex */
    public class a implements t60.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ x60 d;

        public a(x60 x60Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x60Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.repackage.t60.d
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                o70.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                x60 x60Var = this.d;
                x60Var.w = str2;
                i60 d = g60.h(x60Var.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.b).d("ip", str2).d("domain", this.a).d(ProbeTB.PROTOCOL, this.c);
                d.d("P31", "DNS result:" + i).d("con_err_code", "P31");
                if (i == 0) {
                    g60.h(this.d.q).g(601110).b("connect_state", 2);
                    j70 a = j70.a(this.d.q);
                    x60 x60Var2 = this.d;
                    a.b(new e(x60Var2, str2, this.b, Integer.valueOf(x60Var2.b.incrementAndGet())));
                    return;
                }
                g60.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x60 a;

        public b(x60 x60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x60Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x60 a;

        public c(x60 x60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x60Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x60 x60Var = this.a;
                x60Var.f0(x60Var.i.b(this.a.q, 1L));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(83248383, "Lcom/repackage/x60$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(83248383, "Lcom/repackage/x60$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ x60 d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    n70.c(this.a.d.q);
                    n70.e("lcp connect:" + (System.currentTimeMillis() - this.a.d.A));
                }
            }
        }

        public e(x60 x60Var, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x60Var;
            this.b = str;
            this.a = str2;
            this.c = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e) {
                        o70.c("SocketTransceiver", "connectRunnable", e);
                    }
                    if (!this.d.I()) {
                        if (this.d.m != null && this.d.m.isAlive()) {
                            this.d.m.interrupt();
                            o70.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.d.l != null && this.d.l.isAlive()) {
                            this.d.l.interrupt();
                            o70.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.d, this.c, this.b);
                        this.d.u.a(this.b);
                        this.d.u.postDelayed(fVar, 15000L);
                        try {
                            g60.h(this.d.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            w60 e2 = this.d.r.e(this.b, Integer.valueOf(this.a).intValue());
                            if (this.d.I()) {
                                g60.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.d.p.get()).e();
                                o70.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.d.J(e2);
                                return;
                            } else if (e2.b.booleanValue()) {
                                synchronized (this.d.a) {
                                    o70.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.d.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.d.I()) {
                                        if (this.d.a.get(this.c) == null) {
                                            o70.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.d.r.c(e2);
                                        }
                                        g60.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        p70.B(this.d.q, this.d.p.get() == 0 ? 1 : 2);
                                        o70.d("SocketTransceiver", "create Socket ok");
                                        t60.g(this.d.q, this.b);
                                        g60.h(this.d.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.d.f0(this.d.i.b(this.d.q, 1L));
                                        this.d.v = SystemClock.currentThreadTimeMillis();
                                        if (m70.a(this.d.q) != 0) {
                                            j70.a(this.d.q).b(new a(this));
                                        }
                                        o70.a("SocketTransceiver", "connectImpl time:" + this.d.v);
                                        x60.D.a = -2;
                                        this.d.o = false;
                                        this.d.l = new j(this.d, this.b);
                                        this.d.l.start();
                                        this.d.m = new i(this.d, this.b);
                                        this.d.m.start();
                                        return;
                                    }
                                    o70.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.d.J(e2);
                                    return;
                                }
                            } else {
                                g60.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.b).d("con_err_code", "P14").b("retry_cout", this.d.p.get()).e();
                                this.d.u.removeCallbacks(fVar);
                                this.d.i0("connect env error:", this.b);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            o70.c("SocketTransceiver", str, th);
                            this.d.u.removeCallbacks(fVar);
                            fVar.a();
                            synchronized (this.d.a) {
                                if (this.d.a.get(this.c) != null) {
                                    this.d.a.remove(this.c);
                                    return;
                                }
                                this.d.O("ConnectTask exception:" + str, this.b);
                                return;
                            }
                        }
                    }
                    o70.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    g60.h(this.d.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;
        public boolean b;
        public String c;
        public final /* synthetic */ x60 d;

        public f(x60 x60Var, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x60Var;
            this.b = false;
            this.a = num;
            this.c = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.d.a) {
                    if (!this.b && x60.D.a != 0) {
                        this.d.a.put(this.a, Boolean.TRUE);
                        g60.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.d.O("time out:", this.c);
                        return;
                    }
                    o70.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.d.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ x60 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(x60 x60Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x60Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = str;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                long j = message.arg1;
                synchronized (this.b.h) {
                    this.b.Y(j, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ x60 b;

        public i(x60 x60Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x60Var;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            u60 u60Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.o) {
                    try {
                        try {
                            u60 c = this.b.i.c(this.b.r.b());
                            if (c != null && c.n > 0) {
                                this.b.u.removeCallbacks(this.b.s);
                                c.m = false;
                                o70.d("SocketTransceiver", "ReadThread :" + c.toString());
                                if (!c.k) {
                                    if (c.i == 1 && c.h == 4) {
                                        Context context = this.b.q;
                                        l70.a(context, 1L, "read", c.n + "");
                                    }
                                    if (c.i == 50 && c.h == 2) {
                                        Context context2 = this.b.q;
                                        l70.a(context2, 50L, "read", c.n + "");
                                    }
                                    synchronized (this.b.h) {
                                        o70.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        u60Var = (u60) this.b.f.remove(Long.valueOf(c.n));
                                    }
                                    this.b.W(c, u60Var, this.a);
                                }
                                synchronized (this.b.h) {
                                    if (this.b.f.size() != 0) {
                                        o70.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.b.s.b(c.n);
                                        this.b.s.a(this.a);
                                        this.b.u.a(this.a);
                                        this.b.u.postDelayed(this.b.s, c.b);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            if (this.b.o) {
                                return;
                            }
                            o70.c("SocketTransceiver", "ReadThread exception: " + e, e);
                            this.b.d = false;
                            x60 x60Var = this.b;
                            x60Var.O("ReadThread exception: " + e, this.a);
                            return;
                        }
                    } catch (Exception e2) {
                        if (this.b.o) {
                            return;
                        }
                        o70.c("SocketTransceiver", "onStartCommand", e2);
                        this.b.d = false;
                        x60 x60Var2 = this.b;
                        x60Var2.O("onStartCommand:" + e2, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ x60 b;

        public j(x60 x60Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x60Var;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.o) {
                    try {
                        u60 u60Var = null;
                        try {
                            synchronized (this.b.e) {
                                if (this.b.e.size() == 0) {
                                    this.b.e.wait();
                                } else {
                                    u60Var = (u60) this.b.e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            o70.b("SocketTransceiver", "SendThread wait exception: " + e);
                            x60 x60Var = this.b;
                            x60Var.O("SendThread wait exception: " + e, this.a);
                        }
                        if (u60Var != null) {
                            try {
                                if (this.b.o) {
                                    this.b.X(u60Var.n, this.a);
                                    return;
                                }
                                u60Var.m = true;
                                u60Var.j = x60.D.a;
                                if (u60Var.o) {
                                    synchronized (this.b.h) {
                                        if (this.b.f.isEmpty()) {
                                            this.b.u.removeCallbacks(this.b.s);
                                            this.b.s.b(u60Var.n);
                                            this.b.s.a(this.a);
                                            this.b.u.a(this.a);
                                            this.b.u.postDelayed(this.b.s, 15000L);
                                        }
                                    }
                                }
                                o70.e("SocketTransceiver", "SendThread :" + u60Var.toString());
                                if (u60Var.i == 1 && u60Var.h == 4) {
                                    Context context = this.b.q;
                                    l70.a(context, 1L, ReturnKeyType.SEND, u60Var.n + "");
                                }
                                if (u60Var.i == 50 && u60Var.h == 2) {
                                    Context context2 = this.b.q;
                                    l70.a(context2, 50L, ReturnKeyType.SEND, u60Var.n + "");
                                }
                                synchronized (this.b.g) {
                                    this.b.r.f(u60Var);
                                }
                                if (!u60Var.k && u60Var.o) {
                                    synchronized (this.b.h) {
                                        this.b.f.put(Long.valueOf(u60Var.n), u60Var);
                                    }
                                }
                            } catch (Exception e2) {
                                o70.c("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                                this.b.T(u60Var.n, e2.toString(), this.a);
                                x60 x60Var2 = this.b;
                                x60Var2.O("SendThread sendMessage Exception:" + e2, this.a);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        o70.c("SocketTransceiver", "SendThread Exception:", e3);
                        x60 x60Var3 = this.b;
                        x60Var3.O("SendThread Exception:" + e3, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public final /* synthetic */ x60 c;

        public k(x60 x60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x60Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.Y(this.a, this.b);
                this.c.O("read and write thread timeout:", this.b);
            }
        }

        public /* synthetic */ k(x60 x60Var, a aVar) {
            this(x60Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755219777, "Lcom/repackage/x60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755219777, "Lcom/repackage/x60;");
                return;
            }
        }
        D = new p60();
    }

    public x60(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new TreeMap();
        this.b = new AtomicInteger(0);
        this.c = 0;
        this.d = false;
        this.e = new LinkedList<>();
        this.f = new LinkedHashMap();
        this.g = new Object();
        this.h = new Object();
        this.i = new b70();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.n = new h(this, null);
        this.o = false;
        this.p = new AtomicInteger(0);
        this.s = new k(this, null);
        this.x = "";
        this.y = "";
        this.z = "";
        this.B = new b(this);
        this.C = new c(this);
        this.q = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new g(this, this.t.getLooper());
    }

    public static synchronized x60 S(Context context) {
        InterceptResult invokeL;
        x60 x60Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (x60.class) {
                if (E == null) {
                    E = new x60(context.getApplicationContext());
                }
                x60Var = E;
            }
            return x60Var;
        }
        return (x60) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, s60 s60Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, s60Var) == null) {
            synchronized (this) {
                if (p70.m(this.q)) {
                    u60 u60Var = new u60();
                    u60Var.h = bLCPRequest.a;
                    u60Var.i = bLCPRequest.b;
                    u60Var.a = bLCPRequest.c;
                    if (bLCPRequest.d < 0) {
                        u60Var.n = System.currentTimeMillis();
                    } else {
                        u60Var.n = bLCPRequest.d;
                    }
                    int i2 = d.a[bLCPRequest.e.ordinal()];
                    if (i2 == 1) {
                        u60Var.b = 20000L;
                    } else if (i2 == 2) {
                        u60Var.b = 30000L;
                    } else if (i2 != 3) {
                        u60Var.b = 15000L;
                    } else {
                        u60Var.b = 50000L;
                    }
                    if (bLCPRequest instanceof r60) {
                        long j2 = (u60Var.h * 10000) + u60Var.i;
                        u60Var.n = j2;
                        g0(u60Var.h, u60Var.i, j2, true, s60Var);
                    } else {
                        g0(u60Var.h, u60Var.i, u60Var.n, false, s60Var);
                        this.i.a(u60Var, true);
                        f0(u60Var);
                    }
                }
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            v60 v60Var = this.r;
            return (v60Var == null || v60Var.a() == null || this.r.a().c == null || !this.r.a().c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(w60 w60Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w60Var) == null) && w60Var != null && w60Var.a.booleanValue()) {
            try {
                if (w60Var.c != null) {
                    if (w60Var.c.hashCode() == this.r.a().c.hashCode()) {
                        o70.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    w60Var.c.close();
                    w60Var.c = null;
                    if (w60Var.d != null) {
                        w60Var.d.close();
                        w60Var.d = null;
                    }
                    if (w60Var.e != null) {
                        w60Var.e.close();
                        w60Var.e = null;
                    }
                    o70.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                o70.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final long K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 3) {
                return i2 * 1000;
            }
            return 3000L;
        }
        return invokeI.longValue;
    }

    public final synchronized void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                g60.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                t60.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    g60.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.a != 0 && D.a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                o70.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                g60.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (p70.m(this.q)) {
                    o70.d("SocketTransceiver", "destroy");
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.e) {
                            this.e.notifyAll();
                            o70.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            o70.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            o70.c("SocketTransceiver", "Exception destroy:", e2);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            synchronized (this) {
                o70.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + p70.m(this.q));
                g60.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                i60 c2 = g60.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (p70.m(this.q)) {
                    P(str2);
                    if (this.d) {
                        i60 c3 = g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    e0(false);
                }
            }
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                o70.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.e) {
                    while (this.e.size() > 0) {
                        Q(this.e.removeFirst(), str);
                    }
                    o70.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.h) {
                    o70.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f.keySet()) {
                        Q(this.f.get(l), str);
                    }
                    this.f.clear();
                    o70.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                o70.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(u60 u60Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, u60Var, str) == null) || u60Var == null || u60Var.h == 1) {
            return;
        }
        o70.b("SocketTransceiver", "fetalAndClearAllMsgs :" + u60Var.n + ", serviceId :" + u60Var.h + ", methodId :" + u60Var.i);
        W(new u60(), u60Var, str);
    }

    public p60 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (p60) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f.size() <= 0 || !this.f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                o70.a("SocketTransceiver", "handle msg exception!!! " + this.f.get(Long.valueOf(j2)).toString());
                u60 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.g4;
                remove.d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                o70.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(u60 u60Var, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, u60Var, str) == null) {
            if (u60Var.c == 0) {
                long j2 = u60Var.g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = u60Var.i;
                if (j4 == 1) {
                    V(j3, true, str);
                    return;
                } else if (j4 != 2) {
                    if (j4 == 3) {
                        this.n.a(j3);
                        return;
                    }
                    return;
                } else {
                    i0("LCP logout:", str);
                    D.a = u60Var.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + u60Var.c + " errmsg:" + u60Var.d;
            if (!String.valueOf(u60Var.c).startsWith("30") && (i2 = u60Var.c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                o70.a("SocketTransceiver", "login error :" + u60Var.c);
                return;
            }
            o70.a("SocketTransceiver", "login error, then request token, error :" + u60Var.c);
            i0("errorCode:" + String.valueOf(u60Var.c), str);
            p70.z(this.q, "");
            g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            g60.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            q60.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                g60.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    o70.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                o70.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(u60 u60Var, u60 u60Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, u60Var, u60Var2, str) == null) {
            long j2 = u60Var.h;
            if (j2 == 1) {
                U(u60Var, str);
            } else if (j2 != -1) {
                a0(u60Var);
            } else if (u60Var2 == null) {
            } else {
                if (u60Var2.h == 1) {
                    U(u60Var2, str);
                } else {
                    a0(u60Var2);
                }
            }
        }
    }

    public final void X(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j2, str) == null) {
            try {
                if (this.f.size() <= 0 || !this.f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                o70.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f.get(Long.valueOf(j2)).toString());
                u60 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.h4;
                remove.d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                o70.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f.size() <= 0 || !this.f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                o70.a("SocketTransceiver", "handle msg timeout!!! " + this.f.get(Long.valueOf(j2)).toString());
                u60 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.f4;
                remove.d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                o70.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(u60 u60Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, u60Var) == null) {
            synchronized (this) {
                s60 s60Var = null;
                try {
                    Long valueOf = Long.valueOf(!u60Var.e ? u60Var.n : (u60Var.h * 10000) + u60Var.i);
                    o70.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + u60Var.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        s60Var = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        s60Var = this.j.remove(valueOf);
                    }
                    if (s60Var != null) {
                        o70.a("SocketTransceiver", "onBLCPResponse methodId :" + u60Var.i + ", serviceId :" + u60Var.h + ", error :" + u60Var.c + ", msgId :" + u60Var.n + ", errMsg :" + u60Var.d + ", invoke keys :" + this.j.keySet().toString());
                        s60Var.onResponse(u60Var.c, u60Var.d, u60Var.h, u60Var.i, u60Var.n, u60Var.f);
                        if (u60Var.c == 1011) {
                            o70.a("SocketTransceiver", "onBLCPResponse errorCode :" + u60Var.c + ", and will send lcm login msg .");
                            f0(this.i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    o70.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            o70.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && t60.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                o70.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.c);
                String[] split = p70.h(this.q, this.c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.c >= p70.i(this.q)) {
                    this.c = 0;
                    o70.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new y60(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof y60))) {
                    this.r = new y60(this.q, str);
                }
                this.c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    o70.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                    this.x = str2;
                    this.y = str3;
                    this.z = str;
                    L(str2, str3, str);
                } else {
                    this.x = "";
                    this.y = "";
                    c0();
                }
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c = 0;
            this.p.set(0);
            t60.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.a == -1) {
                    long K = K(this.p.get());
                    this.u.removeCallbacks(this.n);
                    this.u.removeCallbacks(z ? this.B : this.C);
                    this.u.postDelayed(z ? this.C : this.B, K);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Schedule retry ");
                    sb.append(z ? "login" : "connect");
                    sb.append(" -- retry times: ");
                    sb.append(this.p.get());
                    sb.append(" time delay: ");
                    sb.append(K);
                    String sb2 = sb.toString();
                    g60.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    o70.d("SocketTransceiver", sb2);
                    return;
                }
                i60 c2 = g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                i60 c3 = g60.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                o70.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(u60 u60Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, u60Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    o70.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.e) {
                    boolean z = false;
                    Iterator<u60> it = this.e.iterator();
                    while (it.hasNext()) {
                        u60 next = it.next();
                        o70.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (u60Var.l) {
                        if (!z && D.a == -1) {
                            this.e.addFirst(u60Var);
                            this.e.notifyAll();
                        }
                        o70.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.e.size() <= 0 || !z) {
                                this.e.addFirst(this.i.b(this.q, 1L));
                                this.e.notifyAll();
                            }
                            if (!u60Var.k) {
                                this.e.add(u60Var);
                                this.e.notifyAll();
                            }
                        } else {
                            if (u60Var.k) {
                                g60.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.e.add(u60Var);
                        }
                    } else {
                        this.e.add(u60Var);
                        this.e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, s60 s60Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), s60Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, s60Var);
            } else if (s60Var != null) {
                this.k.put(valueOf, s60Var);
            }
            o70.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && p70.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (p70.m(this.q)) {
                    o70.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    t60.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ x60 b;

        public h(x60 x60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x60Var;
            this.a = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.u.removeCallbacks(this.b.n);
                if (p70.m(this.b.q)) {
                    this.b.u.postDelayed(this.b.n, this.a);
                    x60 x60Var = this.b;
                    x60Var.f0(x60Var.i.b(this.b.q, 3L));
                }
            }
        }

        public /* synthetic */ h(x60 x60Var, a aVar) {
            this(x60Var);
        }
    }
}
