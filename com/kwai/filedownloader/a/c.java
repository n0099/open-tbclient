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
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public final d b;
    public Handler c;
    public final long d;
    public volatile List<Integer> e;
    public AtomicInteger f;
    public volatile Thread g;

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
        this.e = new CopyOnWriteArrayList();
        this.f = new AtomicInteger();
        this.a = new b();
        this.b = new d();
        this.d = com.kwai.filedownloader.e.e.a().b;
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper(), new Handler.Callback(this) { // from class: com.kwai.filedownloader.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    int i3 = message.what;
                    if (i3 == 0) {
                        if (this.a.g != null) {
                            LockSupport.unpark(this.a.g);
                            this.a.g = null;
                        }
                        return false;
                    }
                    try {
                        this.a.f.set(i3);
                        this.a.g(i3);
                        this.a.e.add(Integer.valueOf(i3));
                        return false;
                    } finally {
                        this.a.f.set(0);
                        if (this.a.g != null) {
                            LockSupport.unpark(this.a.g);
                            this.a.g = null;
                        }
                    }
                }
                return invokeL.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            this.b.a(this.a.b(i));
            List<com.kwai.filedownloader.c.a> c = this.a.c(i);
            this.b.d(i);
            for (com.kwai.filedownloader.c.a aVar : c) {
                this.b.a(aVar);
            }
        }
    }

    private boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? !this.e.contains(Integer.valueOf(i)) : invokeI.booleanValue;
    }

    private void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.c.removeMessages(i);
            if (this.f.get() != i) {
                g(i);
                return;
            }
            this.g = Thread.currentThread();
            this.c.sendEmptyMessage(0);
            LockSupport.park();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.a();
            this.b.a();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c.sendEmptyMessageDelayed(i, this.d);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.a(i, i2);
            if (h(i)) {
                return;
            }
            this.b.a(i, i2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.a.a(i, i2, j);
            if (h(i)) {
                return;
            }
            this.b.a(i, i2, j);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.a(i, j);
            if (h(i)) {
                return;
            }
            this.b.a(i, j);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
            this.a.a(i, j, str, str2);
            if (h(i)) {
                return;
            }
            this.b.a(i, j, str, str2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.a.a(i, str, j, j2, i2);
            if (h(i)) {
                return;
            }
            this.b.a(i, str, j, j2, i2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, th) == null) {
            this.a.a(i, th);
            if (h(i)) {
                return;
            }
            this.b.a(i, th);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), th, Long.valueOf(j)}) == null) {
            this.a.a(i, th, j);
            if (h(i)) {
                i(i);
            }
            this.b.a(i, th, j);
            this.e.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.a.a(aVar);
            if (h(aVar.a())) {
                return;
            }
            this.b.a(aVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.a.a(cVar);
            if (h(cVar.a())) {
                return;
            }
            this.b.a(cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public a.InterfaceC0350a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d dVar = this.b;
            b bVar = this.a;
            return dVar.a(bVar.a, bVar.b);
        }
        return (a.InterfaceC0350a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public com.kwai.filedownloader.c.c b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.a.b(i) : (com.kwai.filedownloader.c.c) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void b(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.b(i, j);
            if (h(i)) {
                this.c.removeMessages(i);
                if (this.f.get() == i) {
                    this.g = Thread.currentThread();
                    this.c.sendEmptyMessage(0);
                    LockSupport.park();
                }
                this.e.remove(Integer.valueOf(i));
            }
            this.b.b(i, j);
            this.e.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public List<com.kwai.filedownloader.c.a> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? this.a.c(i) : (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.c(i, j);
            if (h(i)) {
                i(i);
            }
            this.b.c(i, j);
            this.e.remove(Integer.valueOf(i));
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.a.d(i);
            if (h(i)) {
                return;
            }
            this.b.d(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.b.e(i);
            return this.a.e(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a.f(i);
            if (h(i)) {
                return;
            }
            this.b.f(i);
        }
    }
}
