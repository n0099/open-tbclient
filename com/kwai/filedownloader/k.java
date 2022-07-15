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
import com.kwai.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class k implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0555a a;
    public a.c b;
    public Queue<MessageSnapshot> c;
    public boolean d;

    public k(a.InterfaceC0555a interfaceC0555a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0555a, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        b(interfaceC0555a, cVar);
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65537, this, i) == null) && com.kwai.filedownloader.c.d.a(i)) {
            if (!this.c.isEmpty()) {
                MessageSnapshot peek = this.c.peek();
                com.kwai.filedownloader.e.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.m()), Integer.valueOf(this.c.size()), Byte.valueOf(peek.b()));
            }
            this.a = null;
        }
    }

    private void b(a.InterfaceC0555a interfaceC0555a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, interfaceC0555a, cVar) == null) {
            this.a = interfaceC0555a;
            this.b = cVar;
            this.c = new LinkedBlockingQueue();
        }
    }

    private void j(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify completed %s", this.a);
            }
            this.b.n_();
            k(messageSnapshot);
        }
    }

    private void k(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, messageSnapshot) == null) {
            a.InterfaceC0555a interfaceC0555a = this.a;
            if (interfaceC0555a == null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()));
                }
            } else if (!this.d && interfaceC0555a.F().p() != null) {
                this.c.offer(messageSnapshot);
                j.a().a(this);
            } else {
                if ((l.b() || this.a.O()) && messageSnapshot.b() == 4) {
                    this.b.n_();
                }
                a(messageSnapshot.b());
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void a(a.InterfaceC0555a interfaceC0555a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, interfaceC0555a, cVar) == null) {
            if (this.a != null) {
                throw new IllegalStateException(com.kwai.filedownloader.e.f.a("the messenger is working, can't re-appointment for %s", interfaceC0555a));
            }
            b(interfaceC0555a, cVar);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify pending %s", this.a);
            }
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify begin %s", this.a);
            }
            if (this.a == null) {
                com.kwai.filedownloader.e.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.c.size()));
                return false;
            }
            this.b.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.d) {
            return;
        }
        MessageSnapshot poll = this.c.poll();
        byte b = poll.b();
        a.InterfaceC0555a interfaceC0555a = this.a;
        if (interfaceC0555a == null) {
            return;
        }
        a F = interfaceC0555a.F();
        i p = F.p();
        x.a G = interfaceC0555a.G();
        a(b);
        if (p == null) {
            return;
        }
        if (b == 4) {
            try {
                p.b(F);
                j(((com.kwai.filedownloader.message.a) poll).o_());
                return;
            } catch (Throwable th) {
                h(G.a(th));
                return;
            }
        }
        g gVar = p instanceof g ? (g) p : null;
        if (b == -4) {
            p.d(F);
        } else if (b == -3) {
            p.c(F);
        } else if (b == -2) {
            if (gVar == null) {
                p.c(F, poll.a(), poll.c());
                return;
            }
            poll.i();
            poll.d();
        } else if (b == -1) {
            p.a(F, poll.j());
        } else if (b == 1) {
            if (gVar == null) {
                p.a(F, poll.a(), poll.c());
                return;
            }
            poll.i();
            poll.d();
        } else if (b == 2) {
            if (gVar == null) {
                p.a(F, poll.h(), poll.g(), F.q(), poll.c());
                return;
            }
            poll.h();
            poll.g();
            poll.d();
        } else if (b == 3) {
            if (gVar != null) {
                poll.i();
            } else {
                p.b(F, poll.a(), F.s());
            }
        } else if (b != 5) {
            if (b != 6) {
                return;
            }
            p.a(F);
        } else {
            poll.j();
            poll.k();
            if (gVar != null) {
                poll.i();
            } else {
                poll.a();
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void b(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify started %s", this.a);
            }
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void c(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify connected %s", this.a);
            }
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.F().C() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final void d(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, messageSnapshot) == null) {
            a F = this.a.F();
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify progress %s %d %d", F, Long.valueOf(F.r()), Long.valueOf(F.t()));
            }
            if (F.j() > 0) {
                k(messageSnapshot);
            } else if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify progress but client not request notify %s", this.a);
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c.peek().b() == 4 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d = true;
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void e(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify block completed %s %s", this.a, Thread.currentThread().getName());
            }
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                a F = this.a.F();
                com.kwai.filedownloader.e.d.c(this, "notify retry %s %d %d %s", this.a, Integer.valueOf(F.A()), Integer.valueOf(F.B()), F.y());
            }
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify warn %s", this.a);
            }
            this.b.n_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                a.InterfaceC0555a interfaceC0555a = this.a;
                com.kwai.filedownloader.e.d.c(this, "notify error %s %s", interfaceC0555a, interfaceC0555a.F().y());
            }
            this.b.n_();
            k(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "notify paused %s", this.a);
            }
            this.b.n_();
            k(messageSnapshot);
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object[] objArr = new Object[2];
            a.InterfaceC0555a interfaceC0555a = this.a;
            objArr[0] = Integer.valueOf(interfaceC0555a == null ? -1 : interfaceC0555a.F().h());
            objArr[1] = super.toString();
            return com.kwai.filedownloader.e.f.a("%d:%s", objArr);
        }
        return (String) invokeV.objValue;
    }
}
