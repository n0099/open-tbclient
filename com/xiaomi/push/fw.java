package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class fw {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f404a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f405a;

    /* renamed from: a  reason: collision with other field name */
    public long f406a;

    /* renamed from: a  reason: collision with other field name */
    public fx f407a;

    /* renamed from: a  reason: collision with other field name */
    public gi f408a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f409a;

    /* renamed from: a  reason: collision with other field name */
    public String f410a;

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fz> f411a;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f412a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<gb, a> f413a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f414b;

    /* renamed from: b  reason: collision with other field name */
    public String f415b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<gb, a> f416b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f417c;
    public long d;
    public long e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gb a;

        /* renamed from: a  reason: collision with other field name */
        public gj f418a;

        public a(gb gbVar, gj gjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gbVar, gjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gbVar;
            this.f418a = gjVar;
        }

        public void a(fl flVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, flVar) == null) {
                this.a.a(flVar);
            }
        }

        public void a(gn gnVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnVar) == null) {
                gj gjVar = this.f418a;
                if (gjVar == null || gjVar.a(gnVar)) {
                    this.a.a(gnVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374385, "Lcom/xiaomi/push/fw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374385, "Lcom/xiaomi/push/fw;");
                return;
            }
        }
        a = new AtomicInteger(0);
        f404a = false;
        try {
            f404a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        gc.m365a();
    }

    public fw(XMPushService xMPushService, fx fxVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fxVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f405a = 0;
        this.f406a = -1L;
        this.f414b = 0L;
        this.f417c = 0L;
        this.f412a = new LinkedList<>();
        this.f411a = new CopyOnWriteArrayList();
        this.f413a = new ConcurrentHashMap();
        this.f416b = new ConcurrentHashMap();
        this.f408a = null;
        this.f410a = "";
        this.f415b = "";
        this.c = 2;
        this.b = a.getAndIncrement();
        this.e = 0L;
        this.d = 0L;
        this.f407a = fxVar;
        this.f409a = xMPushService;
        m359b();
    }

    private String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) ? i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m352a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            synchronized (this.f412a) {
                if (i == 1) {
                    this.f412a.clear();
                } else {
                    this.f412a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                    if (this.f412a.size() > 6) {
                        this.f412a.remove(0);
                    }
                }
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f405a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m353a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f417c : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fx m354a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f407a : (fx) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m355a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f407a.c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<gb, a> m356a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f413a : (Map) invokeV.objValue;
    }

    public void a(int i, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, exc) == null) {
            int i3 = this.c;
            if (i != i3) {
                com.xiaomi.channel.commonutils.logger.b.m90a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
            }
            if (bj.b(this.f409a)) {
                m352a(i);
            }
            if (i == 1) {
                this.f409a.a(10);
                if (this.c != 0) {
                    com.xiaomi.channel.commonutils.logger.b.m90a("try set connected while not connecting.");
                }
                this.c = i;
                for (fz fzVar : this.f411a) {
                    fzVar.b(this);
                }
            } else if (i == 0) {
                if (this.c != 2) {
                    com.xiaomi.channel.commonutils.logger.b.m90a("try set connecting while not disconnected.");
                }
                this.c = i;
                for (fz fzVar2 : this.f411a) {
                    fzVar2.a(this);
                }
            } else if (i == 2) {
                this.f409a.a(10);
                int i4 = this.c;
                if (i4 == 0) {
                    for (fz fzVar3 : this.f411a) {
                        fzVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                    }
                } else if (i4 == 1) {
                    for (fz fzVar4 : this.f411a) {
                        fzVar4.a(this, i2, exc);
                    }
                }
                this.c = i;
            }
        }
    }

    public void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fzVar) == null) || fzVar == null || this.f411a.contains(fzVar)) {
            return;
        }
        this.f411a.add(fzVar);
    }

    public void a(gb gbVar, gj gjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gbVar, gjVar) == null) {
            if (gbVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f413a.put(gbVar, new a(gbVar, gjVar));
        }
    }

    public abstract void a(gn gnVar);

    public abstract void a(bg.b bVar);

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                if (this.c == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m90a("setChallenge hash = " + bo.a(str).substring(0, 8));
                    this.f410a = str;
                    a(1, 0, null);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m90a("ignore setChallenge because connection was disconnected");
                }
            }
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean a(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            synchronized (this) {
                z = this.e >= j;
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m358b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f407a.b() : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m359b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f407a.m363a() && this.f408a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f408a = new fu(this);
                return;
            }
            try {
                this.f408a = (gi) cls.getConstructor(fw.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fzVar) == null) {
            this.f411a.remove(fzVar);
        }
    }

    public void b(gb gbVar, gj gjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, gbVar, gjVar) == null) {
            if (gbVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f416b.put(gbVar, new a(gbVar, gjVar));
        }
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m360b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.c == 0 : invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.e = SystemClock.elapsedRealtime();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m361c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.c == 1 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this.f412a) {
                this.f412a.clear();
            }
        }
    }
}
