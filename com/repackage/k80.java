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
import com.repackage.g80;
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
/* loaded from: classes6.dex */
public final class k80 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c80 D;
    public static volatile k80 E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;
    public AtomicInteger b;
    public int c;
    public boolean d;
    public volatile LinkedList<h80> e;
    public final HashMap<Long, h80> f;
    public final Object g;
    public final Object h;
    public o80 i;
    public Map<Long, f80> j;
    public Map<Long, f80> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public i80 r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements g80.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ k80 d;

        public a(k80 k80Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k80Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.repackage.g80.d
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                b90.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                k80 k80Var = this.d;
                k80Var.w = str2;
                v70 d = t70.h(k80Var.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.b).d("ip", str2).d("domain", this.a).d(ProbeTB.PROTOCOL, this.c);
                d.d("P31", "DNS result:" + i).d("con_err_code", "P31");
                if (i == 0) {
                    t70.h(this.d.q).g(601110).b("connect_state", 2);
                    w80 a = w80.a(this.d.q);
                    k80 k80Var2 = this.d;
                    a.b(new e(k80Var2, str2, this.b, Integer.valueOf(k80Var2.b.incrementAndGet())));
                    return;
                }
                t70.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k80 a;

        public b(k80 k80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k80Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k80 a;

        public c(k80 k80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k80Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k80 k80Var = this.a;
                k80Var.f0(k80Var.i.b(this.a.q, 1L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-287083538, "Lcom/repackage/k80$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-287083538, "Lcom/repackage/k80$d;");
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

    /* loaded from: classes6.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ k80 d;

        /* loaded from: classes6.dex */
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
                    a90.c(this.a.d.q);
                    a90.e("lcp connect:" + (System.currentTimeMillis() - this.a.d.A));
                }
            }
        }

        public e(k80 k80Var, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k80Var;
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
                        b90.c("SocketTransceiver", "connectRunnable", e);
                    }
                    if (!this.d.I()) {
                        if (this.d.m != null && this.d.m.isAlive()) {
                            this.d.m.interrupt();
                            b90.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.d.l != null && this.d.l.isAlive()) {
                            this.d.l.interrupt();
                            b90.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.d, this.c, this.b);
                        this.d.u.a(this.b);
                        this.d.u.postDelayed(fVar, 15000L);
                        try {
                            t70.h(this.d.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            j80 e2 = this.d.r.e(this.b, Integer.valueOf(this.a).intValue());
                            if (this.d.I()) {
                                t70.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.d.p.get()).e();
                                b90.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.d.J(e2);
                                return;
                            } else if (e2.b.booleanValue()) {
                                synchronized (this.d.a) {
                                    b90.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.d.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.d.I()) {
                                        if (this.d.a.get(this.c) == null) {
                                            b90.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.d.r.c(e2);
                                        }
                                        t70.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c90.B(this.d.q, this.d.p.get() == 0 ? 1 : 2);
                                        b90.d("SocketTransceiver", "create Socket ok");
                                        g80.g(this.d.q, this.b);
                                        t70.h(this.d.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.d.f0(this.d.i.b(this.d.q, 1L));
                                        this.d.v = SystemClock.currentThreadTimeMillis();
                                        if (z80.a(this.d.q) != 0) {
                                            w80.a(this.d.q).b(new a(this));
                                        }
                                        b90.a("SocketTransceiver", "connectImpl time:" + this.d.v);
                                        k80.D.a = -2;
                                        this.d.o = false;
                                        this.d.l = new j(this.d, this.b);
                                        this.d.l.start();
                                        this.d.m = new i(this.d, this.b);
                                        this.d.m.start();
                                        return;
                                    }
                                    b90.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.d.J(e2);
                                    return;
                                }
                            } else {
                                t70.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.b).d("con_err_code", "P14").b("retry_cout", this.d.p.get()).e();
                                this.d.u.removeCallbacks(fVar);
                                this.d.i0("connect env error:", this.b);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            b90.c("SocketTransceiver", str, th);
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
                    b90.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    t70.h(this.d.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;
        public boolean b;
        public String c;
        public final /* synthetic */ k80 d;

        public f(k80 k80Var, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k80Var;
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
                    if (!this.b && k80.D.a != 0) {
                        this.d.a.put(this.a, Boolean.TRUE);
                        t70.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.d.O("time out:", this.c);
                        return;
                    }
                    b90.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.d.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ k80 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(k80 k80Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, looper};
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
            this.b = k80Var;
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

    /* loaded from: classes6.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ k80 b;

        public i(k80 k80Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k80Var;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            h80 h80Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.o) {
                    try {
                        try {
                            h80 c = this.b.i.c(this.b.r.b());
                            if (c != null && c.n > 0) {
                                this.b.u.removeCallbacks(this.b.s);
                                c.m = false;
                                b90.d("SocketTransceiver", "ReadThread :" + c.toString());
                                if (!c.k) {
                                    if (c.i == 1 && c.h == 4) {
                                        Context context = this.b.q;
                                        y80.a(context, 1L, "read", c.n + "");
                                    }
                                    if (c.i == 50 && c.h == 2) {
                                        Context context2 = this.b.q;
                                        y80.a(context2, 50L, "read", c.n + "");
                                    }
                                    synchronized (this.b.h) {
                                        b90.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        h80Var = (h80) this.b.f.remove(Long.valueOf(c.n));
                                    }
                                    this.b.W(c, h80Var, this.a);
                                }
                                synchronized (this.b.h) {
                                    if (this.b.f.size() != 0) {
                                        b90.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
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
                            b90.c("SocketTransceiver", "ReadThread exception: " + e, e);
                            this.b.d = false;
                            k80 k80Var = this.b;
                            k80Var.O("ReadThread exception: " + e, this.a);
                            return;
                        }
                    } catch (Exception e2) {
                        if (this.b.o) {
                            return;
                        }
                        b90.c("SocketTransceiver", "onStartCommand", e2);
                        this.b.d = false;
                        k80 k80Var2 = this.b;
                        k80Var2.O("onStartCommand:" + e2, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ k80 b;

        public j(k80 k80Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k80Var;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.o) {
                    try {
                        h80 h80Var = null;
                        try {
                            synchronized (this.b.e) {
                                if (this.b.e.size() == 0) {
                                    this.b.e.wait();
                                } else {
                                    h80Var = (h80) this.b.e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            b90.b("SocketTransceiver", "SendThread wait exception: " + e);
                            k80 k80Var = this.b;
                            k80Var.O("SendThread wait exception: " + e, this.a);
                        }
                        if (h80Var != null) {
                            try {
                                if (this.b.o) {
                                    this.b.X(h80Var.n, this.a);
                                    return;
                                }
                                h80Var.m = true;
                                h80Var.j = k80.D.a;
                                if (h80Var.o) {
                                    synchronized (this.b.h) {
                                        if (this.b.f.isEmpty()) {
                                            this.b.u.removeCallbacks(this.b.s);
                                            this.b.s.b(h80Var.n);
                                            this.b.s.a(this.a);
                                            this.b.u.a(this.a);
                                            this.b.u.postDelayed(this.b.s, 15000L);
                                        }
                                    }
                                }
                                b90.e("SocketTransceiver", "SendThread :" + h80Var.toString());
                                if (h80Var.i == 1 && h80Var.h == 4) {
                                    Context context = this.b.q;
                                    y80.a(context, 1L, ReturnKeyType.SEND, h80Var.n + "");
                                }
                                if (h80Var.i == 50 && h80Var.h == 2) {
                                    Context context2 = this.b.q;
                                    y80.a(context2, 50L, ReturnKeyType.SEND, h80Var.n + "");
                                }
                                synchronized (this.b.g) {
                                    this.b.r.f(h80Var);
                                }
                                if (!h80Var.k && h80Var.o) {
                                    synchronized (this.b.h) {
                                        this.b.f.put(Long.valueOf(h80Var.n), h80Var);
                                    }
                                }
                            } catch (Exception e2) {
                                b90.c("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                                this.b.T(h80Var.n, e2.toString(), this.a);
                                k80 k80Var2 = this.b;
                                k80Var2.O("SendThread sendMessage Exception:" + e2, this.a);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        b90.c("SocketTransceiver", "SendThread Exception:", e3);
                        k80 k80Var3 = this.b;
                        k80Var3.O("SendThread Exception:" + e3, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public final /* synthetic */ k80 c;

        public k(k80 k80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k80Var;
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

        public /* synthetic */ k(k80 k80Var, a aVar) {
            this(k80Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755605138, "Lcom/repackage/k80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755605138, "Lcom/repackage/k80;");
                return;
            }
        }
        D = new c80();
    }

    public k80(Context context) {
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
        this.i = new o80();
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

    public static synchronized k80 S(Context context) {
        InterceptResult invokeL;
        k80 k80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (k80.class) {
                if (E == null) {
                    E = new k80(context.getApplicationContext());
                }
                k80Var = E;
            }
            return k80Var;
        }
        return (k80) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, f80 f80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, f80Var) == null) {
            synchronized (this) {
                if (c90.m(this.q)) {
                    h80 h80Var = new h80();
                    h80Var.h = bLCPRequest.a;
                    h80Var.i = bLCPRequest.b;
                    h80Var.a = bLCPRequest.c;
                    if (bLCPRequest.d < 0) {
                        h80Var.n = System.currentTimeMillis();
                    } else {
                        h80Var.n = bLCPRequest.d;
                    }
                    int i2 = d.a[bLCPRequest.e.ordinal()];
                    if (i2 == 1) {
                        h80Var.b = 20000L;
                    } else if (i2 == 2) {
                        h80Var.b = 30000L;
                    } else if (i2 != 3) {
                        h80Var.b = 15000L;
                    } else {
                        h80Var.b = 50000L;
                    }
                    if (bLCPRequest instanceof e80) {
                        long j2 = (h80Var.h * 10000) + h80Var.i;
                        h80Var.n = j2;
                        g0(h80Var.h, h80Var.i, j2, true, f80Var);
                    } else {
                        g0(h80Var.h, h80Var.i, h80Var.n, false, f80Var);
                        this.i.a(h80Var, true);
                        f0(h80Var);
                    }
                }
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i80 i80Var = this.r;
            return (i80Var == null || i80Var.a() == null || this.r.a().c == null || !this.r.a().c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(j80 j80Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j80Var) == null) && j80Var != null && j80Var.a.booleanValue()) {
            try {
                if (j80Var.c != null) {
                    if (j80Var.c.hashCode() == this.r.a().c.hashCode()) {
                        b90.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    j80Var.c.close();
                    j80Var.c = null;
                    if (j80Var.d != null) {
                        j80Var.d.close();
                        j80Var.d = null;
                    }
                    if (j80Var.e != null) {
                        j80Var.e.close();
                        j80Var.e = null;
                    }
                    b90.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                b90.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                t70.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                g80.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    t70.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
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
                b90.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                t70.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (c90.m(this.q)) {
                    b90.d("SocketTransceiver", "destroy");
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.e) {
                            this.e.notifyAll();
                            b90.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            b90.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            b90.c("SocketTransceiver", "Exception destroy:", e2);
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
                b90.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c90.m(this.q));
                t70.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                v70 c2 = t70.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c90.m(this.q)) {
                    P(str2);
                    if (this.d) {
                        v70 c3 = t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                b90.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.e) {
                    while (this.e.size() > 0) {
                        Q(this.e.removeFirst(), str);
                    }
                    b90.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.h) {
                    b90.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f.keySet()) {
                        Q(this.f.get(l), str);
                    }
                    this.f.clear();
                    b90.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                b90.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(h80 h80Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, h80Var, str) == null) || h80Var == null || h80Var.h == 1) {
            return;
        }
        b90.b("SocketTransceiver", "fetalAndClearAllMsgs :" + h80Var.n + ", serviceId :" + h80Var.h + ", methodId :" + h80Var.i);
        W(new h80(), h80Var, str);
    }

    public c80 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (c80) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f.size() <= 0 || !this.f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                b90.a("SocketTransceiver", "handle msg exception!!! " + this.f.get(Long.valueOf(j2)).toString());
                h80 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.g4;
                remove.d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                b90.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(h80 h80Var, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, h80Var, str) == null) {
            if (h80Var.c == 0) {
                long j2 = h80Var.g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = h80Var.i;
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
                    D.a = h80Var.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + h80Var.c + " errmsg:" + h80Var.d;
            if (!String.valueOf(h80Var.c).startsWith("30") && (i2 = h80Var.c) != 1011 && i2 != 2003) {
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
                t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                b90.a("SocketTransceiver", "login error :" + h80Var.c);
                return;
            }
            b90.a("SocketTransceiver", "login error, then request token, error :" + h80Var.c);
            i0("errorCode:" + String.valueOf(h80Var.c), str);
            c90.z(this.q, "");
            t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            t70.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            d80.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                t70.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    b90.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                b90.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(h80 h80Var, h80 h80Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, h80Var, h80Var2, str) == null) {
            long j2 = h80Var.h;
            if (j2 == 1) {
                U(h80Var, str);
            } else if (j2 != -1) {
                a0(h80Var);
            } else if (h80Var2 == null) {
            } else {
                if (h80Var2.h == 1) {
                    U(h80Var2, str);
                } else {
                    a0(h80Var2);
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
                b90.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f.get(Long.valueOf(j2)).toString());
                h80 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.h4;
                remove.d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                b90.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
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
                b90.a("SocketTransceiver", "handle msg timeout!!! " + this.f.get(Long.valueOf(j2)).toString());
                h80 remove = this.f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.c = com.kuaishou.weapon.un.w0.f4;
                remove.d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                b90.a("SocketTransceiver", "handle msg timeout!!! " + e2);
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

    public final synchronized void a0(h80 h80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, h80Var) == null) {
            synchronized (this) {
                f80 f80Var = null;
                try {
                    Long valueOf = Long.valueOf(!h80Var.e ? h80Var.n : (h80Var.h * 10000) + h80Var.i);
                    b90.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + h80Var.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        f80Var = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        f80Var = this.j.remove(valueOf);
                    }
                    if (f80Var != null) {
                        b90.a("SocketTransceiver", "onBLCPResponse methodId :" + h80Var.i + ", serviceId :" + h80Var.h + ", error :" + h80Var.c + ", msgId :" + h80Var.n + ", errMsg :" + h80Var.d + ", invoke keys :" + this.j.keySet().toString());
                        f80Var.onResponse(h80Var.c, h80Var.d, h80Var.h, h80Var.i, h80Var.n, h80Var.f);
                        if (h80Var.c == 1011) {
                            b90.a("SocketTransceiver", "onBLCPResponse errorCode :" + h80Var.c + ", and will send lcm login msg .");
                            f0(this.i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    b90.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b90.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && g80.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                b90.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.c);
                String[] split = c90.h(this.q, this.c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.c >= c90.i(this.q)) {
                    this.c = 0;
                    b90.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new l80(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof l80))) {
                    this.r = new l80(this.q, str);
                }
                this.c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    b90.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            g80.i();
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
                    t70.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    b90.d("SocketTransceiver", sb2);
                    return;
                }
                v70 c2 = t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                v70 c3 = t70.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                b90.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(h80 h80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, h80Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    b90.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.e) {
                    boolean z = false;
                    Iterator<h80> it = this.e.iterator();
                    while (it.hasNext()) {
                        h80 next = it.next();
                        b90.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (h80Var.l) {
                        if (!z && D.a == -1) {
                            this.e.addFirst(h80Var);
                            this.e.notifyAll();
                        }
                        b90.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.e.size() <= 0 || !z) {
                                this.e.addFirst(this.i.b(this.q, 1L));
                                this.e.notifyAll();
                            }
                            if (!h80Var.k) {
                                this.e.add(h80Var);
                                this.e.notifyAll();
                            }
                        } else {
                            if (h80Var.k) {
                                t70.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.e.add(h80Var);
                        }
                    } else {
                        this.e.add(h80Var);
                        this.e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, f80 f80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), f80Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, f80Var);
            } else if (f80Var != null) {
                this.k.put(valueOf, f80Var);
            }
            b90.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && c90.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (c90.m(this.q)) {
                    b90.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    g80.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ k80 b;

        public h(k80 k80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k80Var;
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
                if (c90.m(this.b.q)) {
                    this.b.u.postDelayed(this.b.n, this.a);
                    k80 k80Var = this.b;
                    k80Var.f0(k80Var.i.b(this.b.q, 3L));
                }
            }
        }

        public /* synthetic */ h(k80 k80Var, a aVar) {
            this(k80Var);
        }
    }
}
