package com.xiaomi.push;

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
import com.xiaomi.push.service.av;
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
public abstract class fl {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f372a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f373a;

    /* renamed from: a  reason: collision with other field name */
    public long f374a;

    /* renamed from: a  reason: collision with other field name */
    public fm f375a;

    /* renamed from: a  reason: collision with other field name */
    public fx f376a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f377a;

    /* renamed from: a  reason: collision with other field name */
    public String f378a;

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fo> f379a;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f380a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<fq, a> f381a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f382b;

    /* renamed from: b  reason: collision with other field name */
    public String f383b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<fq, a> f384b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f385c;
    public long d;
    public long e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fq a;

        /* renamed from: a  reason: collision with other field name */
        public fy f386a;

        public a(fq fqVar, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fqVar, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fqVar;
            this.f386a = fyVar;
        }

        public void a(fa faVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
                this.a.a(faVar);
            }
        }

        public void a(gc gcVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar) == null) {
                fy fyVar = this.f386a;
                if (fyVar == null || fyVar.a(gcVar)) {
                    this.a.a(gcVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374726, "Lcom/xiaomi/push/fl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374726, "Lcom/xiaomi/push/fl;");
                return;
            }
        }
        a = new AtomicInteger(0);
        f372a = false;
        try {
            f372a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fr.m370a();
    }

    public fl(XMPushService xMPushService, fm fmVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fmVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f373a = 0;
        this.f374a = -1L;
        this.f382b = 0L;
        this.f385c = 0L;
        this.f380a = new LinkedList<>();
        this.f379a = new CopyOnWriteArrayList();
        this.f381a = new ConcurrentHashMap();
        this.f384b = new ConcurrentHashMap();
        this.f376a = null;
        this.f378a = "";
        this.f383b = "";
        this.c = 2;
        this.b = a.getAndIncrement();
        this.e = 0L;
        this.d = 0L;
        this.f375a = fmVar;
        this.f377a = xMPushService;
        m364b();
    }

    private String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) ? i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m357a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            synchronized (this.f380a) {
                if (i == 1) {
                    this.f380a.clear();
                } else {
                    this.f380a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                    if (this.f380a.size() > 6) {
                        this.f380a.remove(0);
                    }
                }
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f373a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m358a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f385c : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fm m359a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f375a : (fm) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m360a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f375a.c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<fq, a> m361a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f381a : (Map) invokeV.objValue;
    }

    public void a(int i, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, exc) == null) {
            int i3 = this.c;
            if (i != i3) {
                com.xiaomi.channel.commonutils.logger.b.m109a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.az.a(i2)));
            }
            if (bg.b(this.f377a)) {
                m357a(i);
            }
            if (i == 1) {
                this.f377a.a(10);
                if (this.c != 0) {
                    com.xiaomi.channel.commonutils.logger.b.m109a("try set connected while not connecting.");
                }
                this.c = i;
                for (fo foVar : this.f379a) {
                    foVar.b(this);
                }
            } else if (i == 0) {
                if (this.c != 2) {
                    com.xiaomi.channel.commonutils.logger.b.m109a("try set connecting while not disconnected.");
                }
                this.c = i;
                for (fo foVar2 : this.f379a) {
                    foVar2.a(this);
                }
            } else if (i == 2) {
                this.f377a.a(10);
                int i4 = this.c;
                if (i4 == 0) {
                    for (fo foVar3 : this.f379a) {
                        foVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                    }
                } else if (i4 == 1) {
                    for (fo foVar4 : this.f379a) {
                        foVar4.a(this, i2, exc);
                    }
                }
                this.c = i;
            }
        }
    }

    public void a(fo foVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, foVar) == null) || foVar == null || this.f379a.contains(foVar)) {
            return;
        }
        this.f379a.add(foVar);
    }

    public void a(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f381a.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void a(gc gcVar);

    public abstract void a(av.b bVar);

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                if (this.c == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m109a("setChallenge hash = " + bl.a(str).substring(0, 8));
                    this.f378a = str;
                    a(1, 0, null);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m109a("ignore setChallenge because connection was disconnected");
                }
            }
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fa[] faVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m362a() {
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
    public String m363b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f375a.b() : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m364b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f375a.m368a() && this.f376a == null) {
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
                this.f376a = new fj(this);
                return;
            }
            try {
                this.f376a = (fx) cls.getConstructor(fl.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fa faVar);

    public void b(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, foVar) == null) {
            this.f379a.remove(foVar);
        }
    }

    public void b(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f384b.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m365b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.c == 0 : invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.e = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m366c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.c == 1 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this.f380a) {
                this.f380a.clear();
            }
        }
    }
}
