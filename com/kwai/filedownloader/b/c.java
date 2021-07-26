package com.kwai.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes6.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f36879a;

    /* renamed from: b  reason: collision with root package name */
    public final d f36880b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f36881c;

    /* renamed from: d  reason: collision with root package name */
    public final long f36882d;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f36883e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f36884f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f36885g;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36883e = new CopyOnWriteArrayList();
        this.f36884f = new AtomicInteger();
        this.f36879a = new b();
        this.f36880b = new d();
        this.f36882d = com.kwai.filedownloader.f.e.a().f37036b;
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f36881c = new Handler(handlerThread.getLooper(), new Handler.Callback(this) { // from class: com.kwai.filedownloader.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36886a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36886a = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    int i4 = message.what;
                    if (i4 == 0) {
                        if (this.f36886a.f36885g != null) {
                            LockSupport.unpark(this.f36886a.f36885g);
                            this.f36886a.f36885g = null;
                        }
                        return false;
                    }
                    try {
                        this.f36886a.f36884f.set(i4);
                        this.f36886a.g(i4);
                        this.f36886a.f36883e.add(Integer.valueOf(i4));
                        return false;
                    } finally {
                        this.f36886a.f36884f.set(0);
                        if (this.f36886a.f36885g != null) {
                            LockSupport.unpark(this.f36886a.f36885g);
                            this.f36886a.f36885g = null;
                        }
                    }
                }
                return invokeL.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            this.f36880b.a(this.f36879a.b(i2));
            List<com.kwai.filedownloader.d.a> c2 = this.f36879a.c(i2);
            this.f36880b.d(i2);
            for (com.kwai.filedownloader.d.a aVar : c2) {
                this.f36880b.a(aVar);
            }
        }
    }

    private boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) ? !this.f36883e.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    private void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            this.f36881c.removeMessages(i2);
            if (this.f36884f.get() != i2) {
                g(i2);
                return;
            }
            this.f36885g = Thread.currentThread();
            this.f36881c.sendEmptyMessage(0);
            LockSupport.park();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36879a.a();
            this.f36880b.a();
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f36881c.sendEmptyMessageDelayed(i2, this.f36882d);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f36879a.a(i2, i3);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, i3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            this.f36879a.a(i2, i3, j);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, i3, j);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f36879a.a(i2, j);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, j);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) {
            this.f36879a.a(i2, j, str, str2);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, j, str, str2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f36879a.a(i2, str, j, j2, i3);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, str, j, j2, i3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, th) == null) {
            this.f36879a.a(i2, th);
            if (h(i2)) {
                return;
            }
            this.f36880b.a(i2, th);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), th, Long.valueOf(j)}) == null) {
            this.f36879a.a(i2, th, j);
            if (h(i2)) {
                i(i2);
            }
            this.f36880b.a(i2, th, j);
            this.f36883e.remove(Integer.valueOf(i2));
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f36879a.a(aVar);
            if (h(aVar.a())) {
                return;
            }
            this.f36880b.a(aVar);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f36879a.a(cVar);
            if (h(cVar.a())) {
                return;
            }
            this.f36880b.a(cVar);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0452a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d dVar = this.f36880b;
            b bVar = this.f36879a;
            return dVar.a(bVar.f36875a, bVar.f36876b);
        }
        return (a.InterfaceC0452a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.f36879a.b(i2) : (com.kwai.filedownloader.d.c) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f36879a.b(i2, j);
            if (h(i2)) {
                this.f36881c.removeMessages(i2);
                if (this.f36884f.get() == i2) {
                    this.f36885g = Thread.currentThread();
                    this.f36881c.sendEmptyMessage(0);
                    LockSupport.park();
                }
                this.f36883e.remove(Integer.valueOf(i2));
            }
            this.f36880b.b(i2, j);
            this.f36883e.remove(Integer.valueOf(i2));
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.f36879a.c(i2) : (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f36879a.c(i2, j);
            if (h(i2)) {
                i(i2);
            }
            this.f36880b.c(i2, j);
            this.f36883e.remove(Integer.valueOf(i2));
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f36879a.d(i2);
            if (h(i2)) {
                return;
            }
            this.f36880b.d(i2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.f36880b.e(i2);
            return this.f36879a.e(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f36879a.f(i2);
            if (h(i2)) {
                return;
            }
            this.f36880b.f(i2);
        }
    }
}
