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
import com.kwai.filedownloader.w;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public class k implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f74091a;

    /* renamed from: b  reason: collision with root package name */
    public a.d f74092b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<MessageSnapshot> f74093c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74094d;

    public k(a.b bVar, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74094d = false;
        b(bVar, dVar);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65537, this, i2) == null) && com.kwai.filedownloader.d.d.a(i2)) {
            if (!this.f74093c.isEmpty()) {
                MessageSnapshot peek = this.f74093c.peek();
                com.kwai.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.m()), Integer.valueOf(this.f74093c.size()), Byte.valueOf(peek.b()));
            }
            this.f74091a = null;
        }
    }

    private void b(a.b bVar, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, bVar, dVar) == null) {
            this.f74091a = bVar;
            this.f74092b = dVar;
            this.f74093c = new LinkedBlockingQueue();
        }
    }

    private void k(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, messageSnapshot) == null) {
            a.b bVar = this.f74091a;
            if (bVar == null) {
                if (com.kwai.filedownloader.f.d.f74064a) {
                    com.kwai.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()));
                }
            } else if (!this.f74094d && bVar.F().p() != null) {
                this.f74093c.offer(messageSnapshot);
                j.a().a(this);
            } else {
                if ((l.b() || this.f74091a.O()) && messageSnapshot.b() == 4) {
                    this.f74092b.c();
                }
                a(messageSnapshot.b());
            }
        }
    }

    @Override // com.kwai.filedownloader.s
    public void a(a.b bVar, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, dVar) == null) {
            if (this.f74091a != null) {
                throw new IllegalStateException(com.kwai.filedownloader.f.f.a("the messenger is working, can't re-appointment for %s", bVar));
            }
            b(bVar, dVar);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify pending %s", this.f74091a);
            }
            this.f74092b.b_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify begin %s", this.f74091a);
            }
            if (this.f74091a == null) {
                com.kwai.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f74093c.size()));
                return false;
            }
            this.f74092b.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.s
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f74094d) {
            return;
        }
        MessageSnapshot poll = this.f74093c.poll();
        byte b2 = poll.b();
        a.b bVar = this.f74091a;
        if (bVar == null) {
            return;
        }
        a F = bVar.F();
        i p = F.p();
        w.a G = bVar.G();
        a(b2);
        if (p == null || p.a()) {
            return;
        }
        if (b2 == 4) {
            try {
                p.b(F);
                j(((com.kwai.filedownloader.message.a) poll).c_());
                return;
            } catch (Throwable th) {
                h(G.a(th));
                return;
            }
        }
        g gVar = p instanceof g ? (g) p : null;
        if (b2 == -4) {
            p.d(F);
        } else if (b2 == -3) {
            p.c(F);
        } else if (b2 == -2) {
            if (gVar != null) {
                gVar.c(F, poll.i(), poll.d());
            } else {
                p.c(F, poll.a(), poll.c());
            }
        } else if (b2 == -1) {
            p.a(F, poll.j());
        } else if (b2 == 1) {
            if (gVar != null) {
                gVar.a(F, poll.i(), poll.d());
            } else {
                p.a(F, poll.a(), poll.c());
            }
        } else if (b2 == 2) {
            String h2 = poll.h();
            boolean g2 = poll.g();
            if (gVar != null) {
                gVar.a(F, h2, g2, F.r(), poll.d());
            } else {
                p.a(F, h2, g2, F.q(), poll.c());
            }
        } else if (b2 == 3) {
            if (gVar != null) {
                gVar.b(F, poll.i(), F.t());
            } else {
                p.b(F, poll.a(), F.s());
            }
        } else if (b2 != 5) {
            if (b2 != 6) {
                return;
            }
            p.a(F);
        } else if (gVar != null) {
            gVar.a(F, poll.j(), poll.k(), poll.i());
        } else {
            p.a(F, poll.j(), poll.k(), poll.a());
        }
    }

    @Override // com.kwai.filedownloader.s
    public void b(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify started %s", this.f74091a);
            }
            this.f74092b.b_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void c(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify connected %s", this.f74091a);
            }
            this.f74092b.b_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74091a.F().C() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.s
    public void d(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, messageSnapshot) == null) {
            a F = this.f74091a.F();
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify progress %s %d %d", F, Long.valueOf(F.r()), Long.valueOf(F.t()));
            }
            if (F.j() > 0) {
                this.f74092b.b_();
                k(messageSnapshot);
            } else if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.f74091a);
            }
        }
    }

    @Override // com.kwai.filedownloader.s
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f74093c.peek().b() == 4 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.s
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f74094d = true;
        }
    }

    @Override // com.kwai.filedownloader.s
    public void e(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify block completed %s %s", this.f74091a, Thread.currentThread().getName());
            }
            this.f74092b.b_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void f(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                a F = this.f74091a.F();
                com.kwai.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.f74091a, Integer.valueOf(F.A()), Integer.valueOf(F.B()), F.y());
            }
            this.f74092b.b_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void g(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify warn %s", this.f74091a);
            }
            this.f74092b.c();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void h(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                a.b bVar = this.f74091a;
                com.kwai.filedownloader.f.d.c(this, "notify error %s %s", bVar, bVar.F().y());
            }
            this.f74092b.c();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.s
    public void i(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify paused %s", this.f74091a);
            }
            this.f74092b.c();
            k(messageSnapshot);
        }
    }

    public void j(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.f.d.f74064a) {
                com.kwai.filedownloader.f.d.c(this, "notify completed %s", this.f74091a);
            }
            this.f74092b.c();
            k(messageSnapshot);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Object[] objArr = new Object[2];
            a.b bVar = this.f74091a;
            objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.F().h());
            objArr[1] = super.toString();
            return com.kwai.filedownloader.f.f.a("%d:%s", objArr);
        }
        return (String) invokeV.objValue;
    }
}
