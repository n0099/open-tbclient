package com.kwai.filedownloader;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.x;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements com.kwai.filedownloader.a, a.b, d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public final x f60455b;

    /* renamed from: c  reason: collision with root package name */
    public final x.a f60456c;

    /* renamed from: d  reason: collision with root package name */
    public int f60457d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<a.InterfaceC2137a> f60458e;

    /* renamed from: f  reason: collision with root package name */
    public final String f60459f;

    /* renamed from: g  reason: collision with root package name */
    public String f60460g;

    /* renamed from: h  reason: collision with root package name */
    public String f60461h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60462i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwai.filedownloader.c.b f60463j;

    /* renamed from: k  reason: collision with root package name */
    public i f60464k;
    public Object l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public final Object t;
    public final Object u;
    public volatile boolean v;

    /* renamed from: com.kwai.filedownloader.c$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            cVar.s = true;
        }

        public /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }

        @Override // com.kwai.filedownloader.a.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int h2 = this.a.h();
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "add the task[%d] to the queue", Integer.valueOf(h2));
                }
                h.a().c(this.a);
                return h2;
            }
            return invokeV.intValue;
        }
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = 100;
        this.q = 10;
        this.r = false;
        this.a = 0;
        this.s = false;
        this.u = new Object();
        this.v = false;
        this.f60459f = str;
        Object obj = new Object();
        this.t = obj;
        d dVar = new d(this, obj);
        this.f60455b = dVar;
        this.f60456c = dVar;
    }

    private int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!P()) {
                if (!d()) {
                    J();
                }
                this.f60455b.e();
                return h();
            } else if (c()) {
                throw new IllegalStateException(com.kwai.filedownloader.e.f.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(h())));
            } else {
                throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.f60455b.toString());
            }
        }
        return invokeV.intValue;
    }

    private void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f60463j == null) {
            synchronized (this.u) {
                if (this.f60463j == null) {
                    this.f60463j = new com.kwai.filedownloader.c.b();
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a
    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60455b.m() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60455b.n() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public com.kwai.filedownloader.a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (com.kwai.filedownloader.a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public x.a G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60456c : (x.a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwai.filedownloader.c.d.a(v()) : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = p() != null ? p().hashCode() : hashCode();
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.v = true;
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f60455b.o();
            if (h.a().a(this)) {
                this.v = false;
            }
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            T();
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList<a.InterfaceC2137a> arrayList = this.f60458e;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f60455b.g() != 0 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public com.kwai.filedownloader.c.b Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f60463j : (com.kwai.filedownloader.c.b) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public a.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (a.b) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public ArrayList<a.InterfaceC2137a> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f60458e : (ArrayList) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new a(this, null) : (a.c) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.m = i2;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, iVar)) == null) {
            this.f60464k = iVar;
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "setListener %s", iVar);
            }
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            this.l = obj;
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "setTag %s", obj);
            }
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? a(str, false) : (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, str2)) == null) {
            U();
            this.f60463j.a(str, str2);
            return this;
        }
        return (com.kwai.filedownloader.a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048601, this, str, z)) == null) {
            this.f60460g = str;
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "setPath %s", str);
            }
            this.f60462i = z;
            this.f60461h = z ? null : new File(str).getName();
            return this;
        }
        return (com.kwai.filedownloader.a) invokeLZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            this.r = z;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (this.f60463j == null) {
                synchronized (this.u) {
                    if (this.f60463j == null) {
                        return this;
                    }
                }
            }
            this.f60463j.a(str);
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            this.o = z;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (c()) {
                com.kwai.filedownloader.e.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(h()));
                return false;
            }
            this.a = 0;
            this.s = false;
            this.v = false;
            this.f60455b.i();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? h() == i2 : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f60461h = str;
        }
    }

    @Override // com.kwai.filedownloader.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (r.a().e().a(this)) {
                return true;
            }
            return com.kwai.filedownloader.c.d.b(v());
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.a != 0 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.s) {
                throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
            }
            return T();
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean f() {
        InterceptResult invokeV;
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this.t) {
                f2 = this.f60455b.f();
            }
            return f2;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? f() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            int i2 = this.f60457d;
            if (i2 != 0) {
                return i2;
            }
            if (TextUtils.isEmpty(this.f60460g) || TextUtils.isEmpty(this.f60459f)) {
                return 0;
            }
            int a2 = com.kwai.filedownloader.e.f.a(this.f60459f, this.f60460g, this.f60462i);
            this.f60457d = a2;
            return a2;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f60459f : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.p : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.q : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f60460g : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f60462i : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f60461h : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? com.kwai.filedownloader.e.f.a(l(), m(), n()) : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public i p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f60464k : (i) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.f60455b.j() > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) this.f60455b.j();
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f60455b.j() : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.a
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.f60455b.k() > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) this.f60455b.k();
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f60455b.k() : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? com.kwai.filedownloader.e.f.a("%d@%s", Integer.valueOf(h()), super.toString()) : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f60455b.b() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public byte v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f60455b.g() : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.a
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f60455b.h() : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.a
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public Throwable y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f60455b.l() : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public Object z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.l : invokeV.objValue;
    }
}
