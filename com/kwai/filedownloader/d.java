package com.kwai.filedownloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements a.d, x, x.a, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f58232b;

    /* renamed from: c  reason: collision with root package name */
    public final a f58233c;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte f58234d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f58235e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f58236f;

    /* renamed from: g  reason: collision with root package name */
    public final s.b f58237g;

    /* renamed from: h  reason: collision with root package name */
    public final s.a f58238h;

    /* renamed from: i  reason: collision with root package name */
    public long f58239i;

    /* renamed from: j  reason: collision with root package name */
    public long f58240j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;

    /* loaded from: classes3.dex */
    public interface a {
        com.kwai.filedownloader.c.b Q();

        a.b R();

        ArrayList<a.InterfaceC2160a> S();

        void c(String str);
    }

    public d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58234d = (byte) 0;
        this.f58236f = null;
        this.o = false;
        this.f58232b = obj;
        this.f58233c = aVar;
        b bVar = new b();
        this.f58237g = bVar;
        this.f58238h = bVar;
        this.a = new k(aVar.R(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        t tVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, messageSnapshot) == null) {
            com.kwai.filedownloader.a F = this.f58233c.R().F();
            byte b2 = messageSnapshot.b();
            a(b2);
            this.l = messageSnapshot.n();
            if (b2 == -4) {
                this.f58237g.a();
                int a2 = h.a().a(F.h());
                if (a2 + ((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.e.f.b(F.i(), F.o()))) <= 1) {
                    byte b3 = n.a().b(F.h());
                    com.kwai.filedownloader.e.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b3));
                    if (com.kwai.filedownloader.c.d.b(b3)) {
                        a((byte) 1);
                        this.f58240j = messageSnapshot.d();
                        long i2 = messageSnapshot.i();
                        this.f58239i = i2;
                        this.f58237g.a(i2);
                        tVar = this.a;
                        messageSnapshot = ((MessageSnapshot.a) messageSnapshot).l();
                        tVar.a(messageSnapshot);
                        return;
                    }
                }
                h.a().a(this.f58233c.R(), messageSnapshot);
            }
            if (b2 == -3) {
                this.o = messageSnapshot.e();
                this.f58239i = messageSnapshot.d();
                this.f58240j = messageSnapshot.d();
            } else if (b2 != -1) {
                if (b2 == 1) {
                    this.f58239i = messageSnapshot.i();
                    this.f58240j = messageSnapshot.d();
                    tVar = this.a;
                    tVar.a(messageSnapshot);
                    return;
                } else if (b2 == 2) {
                    this.f58240j = messageSnapshot.d();
                    this.m = messageSnapshot.g();
                    this.n = messageSnapshot.h();
                    String f2 = messageSnapshot.f();
                    if (f2 != null) {
                        if (F.n() != null) {
                            com.kwai.filedownloader.e.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.n(), f2);
                        }
                        this.f58233c.c(f2);
                    }
                    this.f58237g.a(this.f58239i);
                    this.a.c(messageSnapshot);
                    return;
                } else if (b2 == 3) {
                    this.f58239i = messageSnapshot.i();
                    this.f58237g.c(messageSnapshot.i());
                    this.a.d(messageSnapshot);
                    return;
                } else if (b2 != 5) {
                    if (b2 != 6) {
                        return;
                    }
                    this.a.b(messageSnapshot);
                    return;
                } else {
                    this.f58239i = messageSnapshot.i();
                    this.f58236f = messageSnapshot.j();
                    this.k = messageSnapshot.k();
                    this.f58237g.a();
                    this.a.f(messageSnapshot);
                    return;
                }
            } else {
                this.f58236f = messageSnapshot.j();
                this.f58239i = messageSnapshot.i();
            }
            h.a().a(this.f58233c.R(), messageSnapshot);
        }
    }

    private void q() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwai.filedownloader.a F = this.f58233c.R().F();
            if (F.l() == null) {
                F.a(com.kwai.filedownloader.e.f.b(F.i()));
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "save Path is null to %s", F.l());
                }
            }
            if (F.m()) {
                file = new File(F.l());
            } else {
                String h2 = com.kwai.filedownloader.e.f.h(F.l());
                if (h2 == null) {
                    throw new InvalidParameterException(com.kwai.filedownloader.e.f.a("the provided mPath[%s] is invalid, can't find its directory", F.l()));
                }
                file = new File(h2);
            }
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                throw new IOException(com.kwai.filedownloader.e.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
            }
        }
    }

    private int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f58233c.R().F().h() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public MessageSnapshot a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
            a((byte) -1);
            this.f58236f = th;
            return com.kwai.filedownloader.message.f.a(r(), j(), th);
        }
        return (MessageSnapshot) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (l.b()) {
                l.a().b(this.f58233c.R().F());
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
            }
        }
    }

    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            this.f58234d = b2;
            this.f58235e = System.currentTimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public boolean a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.a(g(), messageSnapshot.b())) {
                e(messageSnapshot);
                return true;
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f58234d), Byte.valueOf(g()), Integer.valueOf(r()));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.s.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58238h.b() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public boolean b(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, messageSnapshot)) == null) {
            byte g2 = g();
            byte b2 = messageSnapshot.b();
            if (-2 == g2 && com.kwai.filedownloader.c.d.b(b2)) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(r()));
                }
                return true;
            } else if (com.kwai.filedownloader.c.d.b(g2, b2)) {
                e(messageSnapshot);
                return true;
            } else {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f58234d), Byte.valueOf(g()), Integer.valueOf(r()));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.kwai.filedownloader.a F = this.f58233c.R().F();
            if (l.b()) {
                l.a().d(F);
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
            }
            this.f58237g.b(this.f58239i);
            if (this.f58233c.S() != null) {
                ArrayList arrayList = (ArrayList) this.f58233c.S().clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((a.InterfaceC2160a) arrayList.get(i2)).a(F);
                }
            }
            r.a().e().b(this.f58233c.R());
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public boolean c(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.a(this.f58233c.R().F())) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public t d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (t) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public boolean d(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, messageSnapshot)) == null) {
            if (this.f58233c.R().F().m() && messageSnapshot.b() == -4 && g() == 2) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f58232b) {
                if (this.f58234d != 0) {
                    com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(r()), Byte.valueOf(this.f58234d));
                    return;
                }
                a((byte) 10);
                a.b R = this.f58233c.R();
                com.kwai.filedownloader.a F = R.F();
                if (l.b()) {
                    l.a().a(F);
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", F.i(), F.l(), F.p(), F.z());
                }
                try {
                    q();
                    z = true;
                } catch (Throwable th) {
                    h.a().b(R);
                    h.a().a(R, a(th));
                    z = false;
                }
                if (z) {
                    q.a().a(this);
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(r()));
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void e_() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && l.b() && g() == 6) {
            l.a().c(this.f58233c.R().F());
        }
    }

    @Override // com.kwai.filedownloader.x
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (com.kwai.filedownloader.c.d.a(g())) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.f58233c.R().F().h()));
                }
                return false;
            }
            a((byte) -2);
            a.b R = this.f58233c.R();
            com.kwai.filedownloader.a F = R.F();
            q.a().b(this);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(r()));
            }
            if (r.a().c()) {
                n.a().a(F.h());
            } else if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.h()));
            }
            h.a().b(R);
            h.a().a(R, com.kwai.filedownloader.message.f.a(F));
            r.a().e().b(R);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public byte g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f58234d : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.x
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f58235e : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f58236f = null;
            this.n = null;
            this.m = false;
            this.k = 0;
            this.o = false;
            this.l = false;
            this.f58239i = 0L;
            this.f58240j = 0L;
            this.f58237g.a();
            if (com.kwai.filedownloader.c.d.a(this.f58234d)) {
                this.a.e();
                this.a = new k(this.f58233c.R(), this);
            } else {
                this.a.a(this.f58233c.R(), this);
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.x
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f58239i : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f58240j : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public Throwable l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f58236f : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(r()), Byte.valueOf(this.f58234d));
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.x.b
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.f58234d != 10) {
                com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f58234d));
                return;
            }
            a.b R = this.f58233c.R();
            com.kwai.filedownloader.a F = R.F();
            v e2 = r.a().e();
            try {
                if (e2.c(R)) {
                    return;
                }
                synchronized (this.f58232b) {
                    if (this.f58234d != 10) {
                        com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f58234d));
                        return;
                    }
                    a((byte) 11);
                    h.a().b(R);
                    if (com.kwai.filedownloader.e.c.a(F.h(), F.o(), F.x(), true)) {
                        return;
                    }
                    boolean a2 = n.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.f58233c.Q(), F.E());
                    if (this.f58234d == -2) {
                        com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(r()));
                        if (a2) {
                            n.a().a(r());
                        }
                    } else if (a2) {
                        e2.b(R);
                    } else if (e2.c(R)) {
                    } else {
                        MessageSnapshot a3 = a(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                        if (h.a().a(R)) {
                            e2.b(R);
                            h.a().b(R);
                        }
                        h.a().a(R, a3);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                h.a().a(R, a(th));
            }
        }
    }
}
