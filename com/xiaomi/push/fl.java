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
/* loaded from: classes4.dex */
public abstract class fl {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f396a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f397a;

    /* renamed from: a  reason: collision with other field name */
    public long f398a;

    /* renamed from: a  reason: collision with other field name */
    public fm f399a;

    /* renamed from: a  reason: collision with other field name */
    public fx f400a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f401a;

    /* renamed from: a  reason: collision with other field name */
    public String f402a;

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fo> f403a;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f404a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<fq, a> f405a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63461b;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f406b;

    /* renamed from: b  reason: collision with other field name */
    public String f407b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<fq, a> f408b;

    /* renamed from: c  reason: collision with root package name */
    public int f63462c;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f409c;

    /* renamed from: d  reason: collision with root package name */
    public long f63463d;

    /* renamed from: e  reason: collision with root package name */
    public long f63464e;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fq a;

        /* renamed from: a  reason: collision with other field name */
        public fy f410a;

        public a(fq fqVar, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fqVar, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fqVar;
            this.f410a = fyVar;
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
                fy fyVar = this.f410a;
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
        f396a = false;
        try {
            f396a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fr.m383a();
    }

    public fl(XMPushService xMPushService, fm fmVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fmVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f397a = 0;
        this.f398a = -1L;
        this.f406b = 0L;
        this.f409c = 0L;
        this.f404a = new LinkedList<>();
        this.f403a = new CopyOnWriteArrayList();
        this.f405a = new ConcurrentHashMap();
        this.f408b = new ConcurrentHashMap();
        this.f400a = null;
        this.f402a = "";
        this.f407b = "";
        this.f63462c = 2;
        this.f63461b = a.getAndIncrement();
        this.f63464e = 0L;
        this.f63463d = 0L;
        this.f399a = fmVar;
        this.f401a = xMPushService;
        m377b();
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m370a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            synchronized (this.f404a) {
                if (i2 == 1) {
                    this.f404a.clear();
                } else {
                    this.f404a.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                    if (this.f404a.size() > 6) {
                        this.f404a.remove(0);
                    }
                }
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f397a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m371a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f409c : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fm m372a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f399a : (fm) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m373a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f399a.c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<fq, a> m374a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f405a : (Map) invokeV.objValue;
    }

    public void a(int i2, int i3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, exc) == null) {
            int i4 = this.f63462c;
            if (i2 != i4) {
                com.xiaomi.channel.commonutils.logger.b.m122a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), com.xiaomi.push.service.az.a(i3)));
            }
            if (bg.b(this.f401a)) {
                m370a(i2);
            }
            if (i2 == 1) {
                this.f401a.a(10);
                if (this.f63462c != 0) {
                    com.xiaomi.channel.commonutils.logger.b.m122a("try set connected while not connecting.");
                }
                this.f63462c = i2;
                for (fo foVar : this.f403a) {
                    foVar.b(this);
                }
            } else if (i2 == 0) {
                if (this.f63462c != 2) {
                    com.xiaomi.channel.commonutils.logger.b.m122a("try set connecting while not disconnected.");
                }
                this.f63462c = i2;
                for (fo foVar2 : this.f403a) {
                    foVar2.a(this);
                }
            } else if (i2 == 2) {
                this.f401a.a(10);
                int i5 = this.f63462c;
                if (i5 == 0) {
                    for (fo foVar3 : this.f403a) {
                        foVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                    }
                } else if (i5 == 1) {
                    for (fo foVar4 : this.f403a) {
                        foVar4.a(this, i3, exc);
                    }
                }
                this.f63462c = i2;
            }
        }
    }

    public void a(fo foVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, foVar) == null) || foVar == null || this.f403a.contains(foVar)) {
            return;
        }
        this.f403a.add(foVar);
    }

    public void a(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f405a.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void a(gc gcVar);

    public abstract void a(av.b bVar);

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                if (this.f63462c == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m122a("setChallenge hash = " + bl.a(str).substring(0, 8));
                    this.f402a = str;
                    a(1, 0, null);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m122a("ignore setChallenge because connection was disconnected");
                }
            }
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fa[] faVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean a(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            synchronized (this) {
                z = this.f63464e >= j2;
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f63462c : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m376b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f399a.b() : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m377b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f399a.m381a() && this.f400a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f400a = new fj(this);
                return;
            }
            try {
                this.f400a = (fx) cls.getConstructor(fl.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public abstract void b(int i2, Exception exc);

    public abstract void b(fa faVar);

    public void b(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, foVar) == null) {
            this.f403a.remove(foVar);
        }
    }

    public void b(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f408b.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m378b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f63462c == 0 : invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.f63464e = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m379c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f63462c == 1 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this.f404a) {
                this.f404a.clear();
            }
        }
    }
}
