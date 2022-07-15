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
/* loaded from: classes5.dex */
public final class d implements a.c, x, x.a, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t a;
    public final Object b;
    public final a c;
    public volatile byte d;
    public volatile long e;
    public Throwable f;
    public final s.b g;
    public final s.a h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;

    /* loaded from: classes5.dex */
    public interface a {
        com.kwai.filedownloader.c.b P();

        a.InterfaceC0555a Q();

        ArrayList<Object> R();

        void c(String str);
    }

    public d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = (byte) 0;
        this.f = null;
        this.o = false;
        this.b = obj;
        this.c = aVar;
        b bVar = new b();
        this.g = bVar;
        this.h = bVar;
        this.a = new k(aVar.Q(), this);
    }

    private void a(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(65537, this, b) == null) {
            this.d = b;
            this.e = System.currentTimeMillis();
        }
    }

    private void e(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, messageSnapshot) == null) {
            com.kwai.filedownloader.a F = this.c.Q().F();
            byte b = messageSnapshot.b();
            a(b);
            this.l = messageSnapshot.n();
            if (b == -4) {
                this.g.a();
                int a2 = h.a().a(F.h());
                if (a2 + ((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.e.f.a(F.i(), F.o()))) <= 1) {
                    byte b2 = n.a().b(F.h());
                    com.kwai.filedownloader.e.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b2));
                    if (com.kwai.filedownloader.c.d.b(b2)) {
                        a((byte) 1);
                        this.j = messageSnapshot.d();
                        long i = messageSnapshot.i();
                        this.i = i;
                        this.g.a(i);
                        this.a.a(((MessageSnapshot.a) messageSnapshot).l());
                        return;
                    }
                }
                h.a().a(this.c.Q(), messageSnapshot);
            } else if (b == -3) {
                this.o = messageSnapshot.e();
                this.i = messageSnapshot.d();
                this.j = messageSnapshot.d();
                h.a().a(this.c.Q(), messageSnapshot);
            } else if (b == -1) {
                this.f = messageSnapshot.j();
                this.i = messageSnapshot.i();
                h.a().a(this.c.Q(), messageSnapshot);
            } else if (b == 1) {
                this.i = messageSnapshot.i();
                this.j = messageSnapshot.d();
                this.a.a(messageSnapshot);
            } else if (b == 2) {
                this.j = messageSnapshot.d();
                this.m = messageSnapshot.g();
                this.n = messageSnapshot.h();
                String f = messageSnapshot.f();
                if (f != null) {
                    if (F.n() != null) {
                        com.kwai.filedownloader.e.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.n(), f);
                    }
                    this.c.c(f);
                }
                this.g.a(this.i);
                this.a.c(messageSnapshot);
            } else if (b == 3) {
                this.i = messageSnapshot.i();
                this.g.c(messageSnapshot.i());
                this.a.d(messageSnapshot);
            } else if (b != 5) {
                if (b != 6) {
                    return;
                }
                this.a.b(messageSnapshot);
            } else {
                this.i = messageSnapshot.i();
                this.f = messageSnapshot.j();
                this.k = messageSnapshot.k();
                this.g.a();
                this.a.f(messageSnapshot);
            }
        }
    }

    private void p() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwai.filedownloader.a F = this.c.Q().F();
            if (F.l() == null) {
                F.a(com.kwai.filedownloader.e.f.a(F.i()));
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "save Path is null to %s", F.l());
                }
            }
            if (F.m()) {
                file = new File(F.l());
            } else {
                String e = com.kwai.filedownloader.e.f.e(F.l());
                if (e == null) {
                    throw new InvalidParameterException(com.kwai.filedownloader.e.f.a("the provided mPath[%s] is invalid, can't find its directory", F.l()));
                }
                file = new File(e);
            }
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                throw new IOException(com.kwai.filedownloader.e.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
            }
        }
    }

    private int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.c.Q().F().h() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final MessageSnapshot a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
            a((byte) -1);
            this.f = th;
            return com.kwai.filedownloader.message.f.a(q(), i(), th);
        }
        return (MessageSnapshot) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a.c
    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && com.kwai.filedownloader.e.d.a) {
            com.kwai.filedownloader.e.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(f()));
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.a(f(), messageSnapshot.b())) {
                e(messageSnapshot);
                return true;
            }
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(f()), Integer.valueOf(q()));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.s.a
    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h.b() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, messageSnapshot)) == null) {
            byte f = f();
            byte b = messageSnapshot.b();
            if (-2 == f && com.kwai.filedownloader.c.d.b(b)) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(q()));
                }
                return true;
            } else if (com.kwai.filedownloader.c.d.b(f, b)) {
                e(messageSnapshot);
                return true;
            } else {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(f()), Integer.valueOf(q()));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final t c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (t) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.a(this.c.Q().F())) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.b) {
                if (this.d != 0) {
                    com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(q()), Byte.valueOf(this.d));
                    return;
                }
                a((byte) 10);
                a.InterfaceC0555a Q = this.c.Q();
                com.kwai.filedownloader.a F = Q.F();
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", F.i(), F.l(), F.p(), F.z());
                }
                try {
                    p();
                    z = true;
                } catch (Throwable th) {
                    h.a().b(Q);
                    h.a().a(Q, a(th));
                    z = false;
                }
                if (z) {
                    q.a().a(this);
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(q()));
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messageSnapshot)) == null) {
            if (this.c.Q().F().m() && messageSnapshot.b() == -4 && f() == 2) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (com.kwai.filedownloader.c.d.a(f())) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(f()), Integer.valueOf(this.c.Q().F().h()));
                }
                return false;
            }
            a((byte) -2);
            a.InterfaceC0555a Q = this.c.Q();
            com.kwai.filedownloader.a F = Q.F();
            q.a().b(this);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(q()));
            }
            r.a();
            if (r.c()) {
                n.a().a(F.h());
            } else if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.h()));
            }
            h.a().b(Q);
            h.a().a(Q, com.kwai.filedownloader.message.f.a(F));
            r.a().e().b(Q);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final byte f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.x
    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f = null;
            this.n = null;
            this.m = false;
            this.k = 0;
            this.o = false;
            this.l = false;
            this.i = 0L;
            this.j = 0L;
            this.g.a();
            if (com.kwai.filedownloader.c.d.a(this.d)) {
                this.a.e();
                this.a = new k(this.c.Q(), this);
            } else {
                this.a.a(this.c.Q(), this);
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.x
    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public final Throwable k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x
    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x
    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(q()), Byte.valueOf(this.d));
            }
            a((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.a.c
    public final void n_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(f()));
            }
            this.g.b(this.i);
            if (this.c.R() != null) {
                ArrayList arrayList = (ArrayList) this.c.R().clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i);
                }
            }
            r.a().e().b(this.c.Q());
        }
    }

    @Override // com.kwai.filedownloader.x.b
    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.d != 10) {
                com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(q()), Byte.valueOf(this.d));
                return;
            }
            a.InterfaceC0555a Q = this.c.Q();
            com.kwai.filedownloader.a F = Q.F();
            v e = r.a().e();
            try {
                if (e.c(Q)) {
                    return;
                }
                synchronized (this.b) {
                    if (this.d != 10) {
                        com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(q()), Byte.valueOf(this.d));
                        return;
                    }
                    a(Constants.GZIP_CAST_TYPE);
                    h.a().b(Q);
                    if (com.kwai.filedownloader.e.c.a(F.h(), F.o(), F.x(), true)) {
                        return;
                    }
                    boolean a2 = n.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.c.P(), F.E());
                    if (this.d == -2) {
                        com.kwai.filedownloader.e.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(q()));
                        if (a2) {
                            n.a().a(q());
                        }
                    } else if (a2) {
                        e.b(Q);
                    } else if (e.c(Q)) {
                    } else {
                        MessageSnapshot a3 = a(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                        if (h.a().a(Q)) {
                            e.b(Q);
                            h.a().b(Q);
                        }
                        h.a().a(Q, a3);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                h.a().a(Q, a(th));
            }
        }
    }
}
