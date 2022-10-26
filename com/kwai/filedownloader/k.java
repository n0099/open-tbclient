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
/* loaded from: classes8.dex */
public final class k implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0617a ato;
    public a.c atp;
    public Queue atq;
    public boolean atr;

    public k(a.InterfaceC0617a interfaceC0617a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0617a, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.atr = false;
        a(interfaceC0617a, cVar);
    }

    private void a(a.InterfaceC0617a interfaceC0617a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, interfaceC0617a, cVar) == null) {
            this.ato = interfaceC0617a;
            this.atp = cVar;
            this.atq = new LinkedBlockingQueue();
        }
    }

    private void bV(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i) == null) && com.kwai.filedownloader.c.d.cy(i)) {
            if (!this.atq.isEmpty()) {
                MessageSnapshot messageSnapshot = (MessageSnapshot) this.atq.peek();
                com.kwai.filedownloader.e.d.f(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshot.getId()), Integer.valueOf(this.atq.size()), Byte.valueOf(messageSnapshot.Ca()));
            }
            this.ato = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify completed %s", this.ato);
            }
            this.atp.Cr();
            p(messageSnapshot);
        }
    }

    private void p(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, messageSnapshot) == null) {
            a.InterfaceC0617a interfaceC0617a = this.ato;
            if (interfaceC0617a == null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ca()));
                }
            } else if (!this.atr && interfaceC0617a.Ci().BX() != null) {
                this.atq.offer(messageSnapshot);
                j.CI().a(this);
            } else {
                if ((l.isValid() || this.ato.Cp()) && messageSnapshot.Ca() == 4) {
                    this.atp.Cr();
                }
                bV(messageSnapshot.Ca());
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean CL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify begin %s", this.ato);
            }
            if (this.ato == null) {
                com.kwai.filedownloader.e.d.f(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.atq.size()));
                return false;
            }
            this.atp.onBegin();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final void CM() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.atr) {
            return;
        }
        MessageSnapshot messageSnapshot = (MessageSnapshot) this.atq.poll();
        byte Ca = messageSnapshot.Ca();
        a.InterfaceC0617a interfaceC0617a = this.ato;
        if (interfaceC0617a == null) {
            return;
        }
        a Ci = interfaceC0617a.Ci();
        i BX = Ci.BX();
        x.a Cj = interfaceC0617a.Cj();
        bV(Ca);
        if (BX == null) {
            return;
        }
        if (Ca == 4) {
            try {
                BX.b(Ci);
                o(((com.kwai.filedownloader.message.a) messageSnapshot).DY());
                return;
            } catch (Throwable th) {
                m(Cj.n(th));
                return;
            }
        }
        g gVar = BX instanceof g ? (g) BX : null;
        if (Ca == -4) {
            BX.d(Ci);
        } else if (Ca == -3) {
            BX.c(Ci);
        } else if (Ca == -2) {
            if (gVar == null) {
                BX.c(Ci, messageSnapshot.DZ(), messageSnapshot.Ea());
                return;
            }
            messageSnapshot.Ed();
            messageSnapshot.Eb();
        } else if (Ca == -1) {
            BX.a(Ci, messageSnapshot.Ee());
        } else if (Ca == 1) {
            if (gVar == null) {
                BX.a(Ci, messageSnapshot.DZ(), messageSnapshot.Ea());
                return;
            }
            messageSnapshot.Ed();
            messageSnapshot.Eb();
        } else if (Ca == 2) {
            if (gVar == null) {
                BX.a(Ci, messageSnapshot.getEtag(), messageSnapshot.DR(), Ci.getSmallFileSoFarBytes(), messageSnapshot.Ea());
                return;
            }
            messageSnapshot.getEtag();
            messageSnapshot.DR();
            messageSnapshot.Eb();
        } else if (Ca == 3) {
            if (gVar != null) {
                messageSnapshot.Ed();
            } else {
                BX.b(Ci, messageSnapshot.DZ(), Ci.getSmallFileTotalBytes());
            }
        } else if (Ca != 5) {
            if (Ca != 6) {
                return;
            }
            BX.a(Ci);
        } else {
            messageSnapshot.Ee();
            messageSnapshot.Ce();
            if (gVar != null) {
                messageSnapshot.Ed();
            } else {
                messageSnapshot.DZ();
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean CN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ato.Ci().Cf() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final boolean CO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((MessageSnapshot) this.atq.peek()).Ca() == 4 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.t
    public final void CP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.atr = true;
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void b(a.InterfaceC0617a interfaceC0617a, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interfaceC0617a, cVar) == null) {
            if (this.ato != null) {
                throw new IllegalStateException(com.kwai.filedownloader.e.f.h("the messenger is working, can't re-appointment for %s", interfaceC0617a));
            }
            a(interfaceC0617a, cVar);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify pending %s", this.ato);
            }
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify started %s", this.ato);
            }
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify connected %s", this.ato);
            }
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, messageSnapshot) == null) {
            a Ci = this.ato.Ci();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify progress %s %d %d", Ci, Long.valueOf(Ci.BY()), Long.valueOf(Ci.BZ()));
            }
            if (Ci.BU() > 0) {
                p(messageSnapshot);
            } else if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify progress but client not request notify %s", this.ato);
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify block completed %s %s", this.ato, Thread.currentThread().getName());
            }
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                a Ci = this.ato.Ci();
                com.kwai.filedownloader.e.d.e(this, "notify retry %s %d %d %s", this.ato, Integer.valueOf(Ci.Cd()), Integer.valueOf(Ci.Ce()), Ci.Cc());
            }
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify warn %s", this.ato);
            }
            this.atp.Cr();
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                a.InterfaceC0617a interfaceC0617a = this.ato;
                com.kwai.filedownloader.e.d.e(this, "notify error %s %s", interfaceC0617a, interfaceC0617a.Ci().Cc());
            }
            this.atp.Cr();
            p(messageSnapshot);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, messageSnapshot) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "notify paused %s", this.ato);
            }
            this.atp.Cr();
            p(messageSnapshot);
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object[] objArr = new Object[2];
            a.InterfaceC0617a interfaceC0617a = this.ato;
            objArr[0] = Integer.valueOf(interfaceC0617a == null ? -1 : interfaceC0617a.Ci().getId());
            objArr[1] = super.toString();
            return com.kwai.filedownloader.e.f.h("%d:%s", objArr);
        }
        return (String) invokeV.objValue;
    }
}
