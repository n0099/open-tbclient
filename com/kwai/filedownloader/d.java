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
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.w;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d implements a.d, w, w.a, w.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public s f36910a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f36911b;

    /* renamed from: c  reason: collision with root package name */
    public final a f36912c;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte f36913d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f36914e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f36915f;

    /* renamed from: g  reason: collision with root package name */
    public final r.b f36916g;

    /* renamed from: h  reason: collision with root package name */
    public final r.a f36917h;

    /* renamed from: i  reason: collision with root package name */
    public long f36918i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;

    /* loaded from: classes6.dex */
    public interface a {
        com.kwai.filedownloader.d.b Q();

        a.b R();

        ArrayList<a.InterfaceC0451a> S();

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
        this.f36913d = (byte) 0;
        this.f36915f = null;
        this.o = false;
        this.f36911b = obj;
        this.f36912c = aVar;
        b bVar = new b();
        this.f36916g = bVar;
        this.f36917h = bVar;
        this.f36910a = new k(aVar.R(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, messageSnapshot) == null) {
            com.kwai.filedownloader.a F = this.f36912c.R().F();
            byte b2 = messageSnapshot.b();
            a(b2);
            this.l = messageSnapshot.n();
            if (b2 == -4) {
                this.f36916g.a();
                int a2 = h.a().a(F.h());
                if (a2 + ((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.f.f.b(F.i(), F.o()))) <= 1) {
                    byte b3 = m.a().b(F.h());
                    com.kwai.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b3));
                    if (com.kwai.filedownloader.d.d.b(b3)) {
                        a((byte) 1);
                        this.j = messageSnapshot.d();
                        long i2 = messageSnapshot.i();
                        this.f36918i = i2;
                        this.f36916g.a(i2);
                        sVar = this.f36910a;
                        messageSnapshot = ((MessageSnapshot.a) messageSnapshot).l();
                        sVar.a(messageSnapshot);
                        return;
                    }
                }
                h.a().a(this.f36912c.R(), messageSnapshot);
            }
            if (b2 == -3) {
                this.o = messageSnapshot.e();
                this.f36918i = messageSnapshot.d();
                this.j = messageSnapshot.d();
            } else if (b2 != -1) {
                if (b2 == 1) {
                    this.f36918i = messageSnapshot.i();
                    this.j = messageSnapshot.d();
                    sVar = this.f36910a;
                    sVar.a(messageSnapshot);
                    return;
                } else if (b2 == 2) {
                    this.j = messageSnapshot.d();
                    this.m = messageSnapshot.g();
                    this.n = messageSnapshot.h();
                    String f2 = messageSnapshot.f();
                    if (f2 != null) {
                        if (F.n() != null) {
                            com.kwai.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.n(), f2);
                        }
                        this.f36912c.c(f2);
                    }
                    this.f36916g.a(this.f36918i);
                    this.f36910a.c(messageSnapshot);
                    return;
                } else if (b2 == 3) {
                    this.f36918i = messageSnapshot.i();
                    this.f36916g.c(messageSnapshot.i());
                    this.f36910a.d(messageSnapshot);
                    return;
                } else if (b2 != 5) {
                    if (b2 != 6) {
                        return;
                    }
                    this.f36910a.b(messageSnapshot);
                    return;
                } else {
                    this.f36918i = messageSnapshot.i();
                    this.f36915f = messageSnapshot.j();
                    this.k = messageSnapshot.k();
                    this.f36916g.a();
                    this.f36910a.f(messageSnapshot);
                    return;
                }
            } else {
                this.f36915f = messageSnapshot.j();
                this.f36918i = messageSnapshot.i();
            }
            h.a().a(this.f36912c.R(), messageSnapshot);
        }
    }

    private void q() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwai.filedownloader.a F = this.f36912c.R().F();
            if (F.l() == null) {
                F.a(com.kwai.filedownloader.f.f.b(F.i()));
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.c(this, "save Path is null to %s", F.l());
                }
            }
            if (F.m()) {
                file = new File(F.l());
            } else {
                String h2 = com.kwai.filedownloader.f.f.h(F.l());
                if (h2 == null) {
                    throw new InvalidParameterException(com.kwai.filedownloader.f.f.a("the provided mPath[%s] is invalid, can't find its directory", F.l()));
                }
                file = new File(h2);
            }
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                throw new IOException(com.kwai.filedownloader.f.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
            }
        }
    }

    private int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f36912c.R().F().h() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.w.a
    public MessageSnapshot a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
            a((byte) -1);
            this.f36915f = th;
            return com.kwai.filedownloader.message.f.a(r(), j(), th);
        }
        return (MessageSnapshot) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (l.b()) {
                l.a().b(this.f36912c.R().F());
            }
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
            }
        }
    }

    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            this.f36913d = b2;
            this.f36914e = System.currentTimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.d.d.a(g(), messageSnapshot.b())) {
                e(messageSnapshot);
                return true;
            }
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f36913d), Byte.valueOf(g()), Integer.valueOf(r()));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36917h.b() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean b(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, messageSnapshot)) == null) {
            byte g2 = g();
            byte b2 = messageSnapshot.b();
            if (-2 == g2 && com.kwai.filedownloader.d.d.b(b2)) {
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(r()));
                }
                return true;
            } else if (com.kwai.filedownloader.d.d.b(g2, b2)) {
                e(messageSnapshot);
                return true;
            } else {
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f36913d), Byte.valueOf(g()), Integer.valueOf(r()));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.d
    public void b_() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && l.b() && g() == 6) {
            l.a().c(this.f36912c.R().F());
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwai.filedownloader.a F = this.f36912c.R().F();
            if (l.b()) {
                l.a().d(F);
            }
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
            }
            this.f36916g.b(this.f36918i);
            if (this.f36912c.S() != null) {
                ArrayList arrayList = (ArrayList) this.f36912c.S().clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((a.InterfaceC0451a) arrayList.get(i2)).a(F);
                }
            }
            q.a().e().b(this.f36912c.R());
        }
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean c(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.d.d.a(this.f36912c.R().F())) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.w.a
    public s d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36910a : (s) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean d(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, messageSnapshot)) == null) {
            if (this.f36912c.R().F().m() && messageSnapshot.b() == -4 && g() == 2) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.w
    public void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this.f36911b) {
                if (this.f36913d != 0) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(r()), Byte.valueOf(this.f36913d));
                    return;
                }
                a((byte) 10);
                a.b R = this.f36912c.R();
                com.kwai.filedownloader.a F = R.F();
                if (l.b()) {
                    l.a().a(F);
                }
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", F.i(), F.l(), F.p(), F.z());
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
                    p.a().a(this);
                }
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(r()));
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (com.kwai.filedownloader.d.d.a(g())) {
                if (com.kwai.filedownloader.f.d.f37034a) {
                    com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.f36912c.R().F().h()));
                }
                return false;
            }
            a((byte) -2);
            a.b R = this.f36912c.R();
            com.kwai.filedownloader.a F = R.F();
            p.a().b(this);
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(r()));
            }
            if (q.a().c()) {
                m.a().a(F.h());
            } else if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.h()));
            }
            h.a().b(R);
            h.a().a(R, com.kwai.filedownloader.message.f.a(F));
            q.a().e().b(R);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.w
    public byte g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f36913d : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.w
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36914e : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.w
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f36915f = null;
            this.n = null;
            this.m = false;
            this.k = 0;
            this.o = false;
            this.l = false;
            this.f36918i = 0L;
            this.j = 0L;
            this.f36916g.a();
            if (com.kwai.filedownloader.d.d.a(this.f36913d)) {
                this.f36910a.e();
                this.f36910a = new k(this.f36912c.R(), this);
            } else {
                this.f36910a.a(this.f36912c.R(), this);
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.w
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36918i : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.w
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.w
    public Throwable l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f36915f : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.w
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.w
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.w
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (com.kwai.filedownloader.f.d.f37034a) {
                com.kwai.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(r()), Byte.valueOf(this.f36913d));
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.w.b
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.f36913d != 10) {
                com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f36913d));
                return;
            }
            a.b R = this.f36912c.R();
            com.kwai.filedownloader.a F = R.F();
            u e2 = q.a().e();
            try {
                if (e2.c(R)) {
                    return;
                }
                synchronized (this.f36911b) {
                    if (this.f36913d != 10) {
                        com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f36913d));
                        return;
                    }
                    a((byte) 11);
                    h.a().b(R);
                    if (com.kwai.filedownloader.f.c.a(F.h(), F.o(), F.x(), true)) {
                        return;
                    }
                    boolean a2 = m.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.f36912c.Q(), F.E());
                    if (this.f36913d == -2) {
                        com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(r()));
                        if (a2) {
                            m.a().a(r());
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
