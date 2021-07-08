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
/* loaded from: classes6.dex */
public abstract class fl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f40127a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f391a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f392a;

    /* renamed from: a  reason: collision with other field name */
    public long f393a;

    /* renamed from: a  reason: collision with other field name */
    public fm f394a;

    /* renamed from: a  reason: collision with other field name */
    public fx f395a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f396a;

    /* renamed from: a  reason: collision with other field name */
    public String f397a;

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fo> f398a;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f399a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<fq, a> f400a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40128b;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f401b;

    /* renamed from: b  reason: collision with other field name */
    public String f402b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<fq, a> f403b;

    /* renamed from: c  reason: collision with root package name */
    public int f40129c;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f404c;

    /* renamed from: d  reason: collision with root package name */
    public long f40130d;

    /* renamed from: e  reason: collision with root package name */
    public long f40131e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public fq f40132a;

        /* renamed from: a  reason: collision with other field name */
        public fy f405a;

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
            this.f40132a = fqVar;
            this.f405a = fyVar;
        }

        public void a(fa faVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
                this.f40132a.a(faVar);
            }
        }

        public void a(gc gcVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar) == null) {
                fy fyVar = this.f405a;
                if (fyVar == null || fyVar.a(gcVar)) {
                    this.f40132a.a(gcVar);
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
        f40127a = new AtomicInteger(0);
        f391a = false;
        try {
            f391a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fr.m331a();
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
        this.f392a = 0;
        this.f393a = -1L;
        this.f401b = 0L;
        this.f404c = 0L;
        this.f399a = new LinkedList<>();
        this.f398a = new CopyOnWriteArrayList();
        this.f400a = new ConcurrentHashMap();
        this.f403b = new ConcurrentHashMap();
        this.f395a = null;
        this.f397a = "";
        this.f402b = "";
        this.f40129c = 2;
        this.f40128b = f40127a.getAndIncrement();
        this.f40131e = 0L;
        this.f40130d = 0L;
        this.f394a = fmVar;
        this.f396a = xMPushService;
        m325b();
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown" : (String) invokeI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m318a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            synchronized (this.f399a) {
                if (i2 == 1) {
                    this.f399a.clear();
                } else {
                    this.f399a.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                    if (this.f399a.size() > 6) {
                        this.f399a.remove(0);
                    }
                }
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f392a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m319a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f404c : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fm m320a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f394a : (fm) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m321a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f394a.c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<fq, a> m322a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f400a : (Map) invokeV.objValue;
    }

    public void a(int i2, int i3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, exc) == null) {
            int i4 = this.f40129c;
            if (i2 != i4) {
                com.xiaomi.channel.commonutils.logger.b.m70a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), com.xiaomi.push.service.az.a(i3)));
            }
            if (bg.b(this.f396a)) {
                m318a(i2);
            }
            if (i2 == 1) {
                this.f396a.a(10);
                if (this.f40129c != 0) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("try set connected while not connecting.");
                }
                this.f40129c = i2;
                for (fo foVar : this.f398a) {
                    foVar.b(this);
                }
            } else if (i2 == 0) {
                if (this.f40129c != 2) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("try set connecting while not disconnected.");
                }
                this.f40129c = i2;
                for (fo foVar2 : this.f398a) {
                    foVar2.a(this);
                }
            } else if (i2 == 2) {
                this.f396a.a(10);
                int i5 = this.f40129c;
                if (i5 == 0) {
                    for (fo foVar3 : this.f398a) {
                        foVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                    }
                } else if (i5 == 1) {
                    for (fo foVar4 : this.f398a) {
                        foVar4.a(this, i3, exc);
                    }
                }
                this.f40129c = i2;
            }
        }
    }

    public void a(fo foVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, foVar) == null) || foVar == null || this.f398a.contains(foVar)) {
            return;
        }
        this.f398a.add(foVar);
    }

    public void a(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f400a.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void a(gc gcVar);

    public abstract void a(av.b bVar);

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                if (this.f40129c == 0) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("setChallenge hash = " + bl.a(str).substring(0, 8));
                    this.f397a = str;
                    a(1, 0, null);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m70a("ignore setChallenge because connection was disconnected");
                }
            }
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fa[] faVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m323a() {
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
                z = this.f40131e >= j;
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40129c : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m324b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f394a.b() : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m325b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f394a.m329a() && this.f395a == null) {
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
                this.f395a = new fj(this);
                return;
            }
            try {
                this.f395a = (fx) cls.getConstructor(fl.class, Writer.class, Reader.class).newInstance(this);
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
            this.f398a.remove(foVar);
        }
    }

    public void b(fq fqVar, fy fyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, fqVar, fyVar) == null) {
            if (fqVar == null) {
                throw new NullPointerException("Packet listener is null.");
            }
            this.f403b.put(fqVar, new a(fqVar, fyVar));
        }
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m326b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f40129c == 0 : invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.f40131e = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m327c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f40129c == 1 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this.f399a) {
                this.f399a.clear();
            }
        }
    }
}
