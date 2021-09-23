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
    public g<T> f67997a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f67998b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f67999c;

    /* loaded from: classes9.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.e.a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f68000a;
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
                if (f68000a == null) {
                    synchronized (a.class) {
                        if (f68000a == null) {
                            f68000a = new a();
                        }
                    }
                }
                return f68000a;
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
    public static class C1921b extends b<c.a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile C1921b f68007a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1921b() {
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

        public static C1921b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f68007a == null) {
                    synchronized (C1921b.class) {
                        if (f68007a == null) {
                            f68007a = new C1921b();
                        }
                    }
                }
                return f68007a;
            }
            return (C1921b) invokeV.objValue;
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
        this.f67997a = new g<>(eVar, pVar, bVar, aVar);
        this.f67999c = new AtomicBoolean(false);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.e() : (a) invokeV.objValue;
    }

    public static C1921b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C1921b.e() : (C1921b) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if ((this.f67999c == null || !this.f67999c.get()) && this.f67997a.getLooper() == null) {
                    if (this.f67999c != null && !this.f67999c.get()) {
                        this.f67997a.start();
                        Handler handler = new Handler(this.f67997a.getLooper(), this.f67997a);
                        this.f67998b = handler;
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 5;
                        this.f67998b.sendMessageDelayed(obtainMessage, 10000L);
                        this.f67999c.set(true);
                    }
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67999c.set(false);
            this.f67997a.quit();
            this.f67998b.removeCallbacksAndMessages(null);
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
        this.f67997a = gVar;
        this.f67999c = new AtomicBoolean(false);
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
            if (!this.f67999c.get()) {
                a();
            }
            Message obtainMessage = this.f67998b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f67998b.sendMessage(obtainMessage);
        }
    }
}
