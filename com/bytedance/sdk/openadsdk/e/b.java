package com.bytedance.sdk.openadsdk.e;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.e.g;
import com.bytedance.sdk.openadsdk.e.i;
import com.bytedance.sdk.openadsdk.j.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class b<T extends i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g<T> f67686a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f67687b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f67688c;

    /* loaded from: classes9.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.e.a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f67689a;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f67689a == null) {
                    synchronized (a.class) {
                        if (f67689a == null) {
                            f67689a = new a();
                        }
                    }
                }
                return f67689a;
            }
            return (a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.e.b
        public void a(@NonNull com.bytedance.sdk.openadsdk.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.e.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.e.b
        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1917b extends b<c.a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile C1917b f67696a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1917b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C1917b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f67696a == null) {
                    synchronized (C1917b.class) {
                        if (f67696a == null) {
                            f67696a = new C1917b();
                        }
                    }
                }
                return f67696a;
            }
            return (C1917b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.e.b
        public void a(@NonNull c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.e.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.e.b
        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                }
            }
        }
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, pVar, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67686a = new g<>(eVar, pVar, bVar, aVar);
        this.f67688c = new AtomicBoolean(false);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.e() : (a) invokeV.objValue;
    }

    public static C1917b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C1917b.e() : (C1917b) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if ((this.f67688c == null || !this.f67688c.get()) && this.f67686a.getLooper() == null) {
                    if (this.f67688c != null && !this.f67688c.get()) {
                        this.f67686a.start();
                        Handler handler = new Handler(this.f67686a.getLooper(), this.f67686a);
                        this.f67687b = handler;
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 5;
                        this.f67687b.sendMessageDelayed(obtainMessage, 10000L);
                        this.f67688c.set(true);
                    }
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67688c.set(false);
            this.f67686a.quit();
            this.f67687b.removeCallbacksAndMessages(null);
        }
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar, g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, pVar, bVar, aVar, gVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f67686a = gVar;
        this.f67688c = new AtomicBoolean(false);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            if (!this.f67688c.get()) {
                a();
            }
            Message obtainMessage = this.f67687b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f67687b.sendMessage(obtainMessage);
        }
    }
}
