package com.kwai.filedownloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes5.dex */
public final class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b atT;
    public final d atU;
    public final long atV;
    public volatile List<Integer> atW;
    public AtomicInteger atX;
    public volatile Thread atY;
    public Handler handler;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.atW = new CopyOnWriteArrayList();
        this.atX = new AtomicInteger();
        this.atT = new b();
        this.atU = new d();
        this.atV = com.kwai.filedownloader.e.e.EL().awN;
        HandlerThread handlerThread = new HandlerThread(f.eI("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback(this) { // from class: com.kwai.filedownloader.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c atZ;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.atZ = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    int i3 = message.what;
                    if (i3 == 0) {
                        if (this.atZ.atY != null) {
                            LockSupport.unpark(this.atZ.atY);
                            this.atZ.atY = null;
                        }
                        return false;
                    }
                    try {
                        this.atZ.atX.set(i3);
                        this.atZ.ci(i3);
                        this.atZ.atW.add(Integer.valueOf(i3));
                        return false;
                    } finally {
                        this.atZ.atX.set(0);
                        if (this.atZ.atY != null) {
                            LockSupport.unpark(this.atZ.atY);
                            this.atZ.atY = null;
                        }
                    }
                }
                return invokeL.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            this.atU.b(this.atT.cd(i));
            List<com.kwai.filedownloader.c.a> ce = this.atT.ce(i);
            this.atU.cf(i);
            for (com.kwai.filedownloader.c.a aVar : ce) {
                this.atU.a(aVar);
            }
        }
    }

    private boolean cj(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? !this.atW.contains(Integer.valueOf(i)) : invokeI.booleanValue;
    }

    private void ck(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.handler.removeMessages(i);
            if (this.atX.get() != i) {
                ci(i);
                return;
            }
            this.atY = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0404a Dh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.atU;
            b bVar = this.atT;
            return dVar.a(bVar.atQ, bVar.atR);
        }
        return (a.InterfaceC0404a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.atT.a(i, i2, j);
            if (cj(i)) {
                return;
            }
            this.atU.a(i, i2, j);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
            this.atT.a(i, j, str, str2);
            if (cj(i)) {
                return;
            }
            this.atU.a(i, j, str, str2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.atT.a(i, str, j, j2, i2);
            if (cj(i)) {
                return;
            }
            this.atU.a(i, str, j, j2, i2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, th) == null) {
            this.atT.a(i, th);
            if (cj(i)) {
                return;
            }
            this.atU.a(i, th);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), th, Long.valueOf(j)}) == null) {
            this.atT.a(i, th, j);
            if (cj(i)) {
                ck(i);
            }
            this.atU.a(i, th, j);
            this.atW.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.atT.a(aVar);
            if (cj(aVar.getId())) {
                return;
            }
            this.atU.a(aVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.atT.b(cVar);
            if (cj(cVar.getId())) {
                return;
            }
            this.atU.b(cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.atT.c(i, j);
            if (cj(i)) {
                return;
            }
            this.atU.c(i, j);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.handler.sendEmptyMessageDelayed(i, this.atV);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.atT.cd(i) : (com.kwai.filedownloader.c.c) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> ce(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this.atT.ce(i) : (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cf(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.atT.cf(i);
            if (cj(i)) {
                return;
            }
            this.atU.cf(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.atU.cg(i);
            return this.atT.cg(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void ch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.atT.ch(i);
            if (cj(i)) {
                return;
            }
            this.atU.ch(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.atT.clear();
            this.atU.clear();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.atT.d(i, j);
            if (cj(i)) {
                this.handler.removeMessages(i);
                if (this.atX.get() == i) {
                    this.atY = Thread.currentThread();
                    this.handler.sendEmptyMessage(0);
                    LockSupport.park();
                }
                this.atW.remove(Integer.valueOf(i));
            }
            this.atU.d(i, j);
            this.atW.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.atT.e(i, j);
            if (cj(i)) {
                ck(i);
            }
            this.atU.e(i, j);
            this.atW.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            this.atT.x(i, i2);
            if (cj(i)) {
                return;
            }
            this.atU.x(i, i2);
        }
    }
}
