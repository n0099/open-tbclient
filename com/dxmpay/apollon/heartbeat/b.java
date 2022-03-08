package com.dxmpay.apollon.heartbeat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.a.a;
import com.dxmpay.apollon.utils.LogUtil;
import java.util.Calendar;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.dxmpay.apollon.a.a f52223b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-619927134, "Lcom/dxmpay/apollon/heartbeat/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-619927134, "Lcom/dxmpay/apollon/heartbeat/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52223b = null;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.dxmpay.apollon.a.a aVar = new com.dxmpay.apollon.a.a(1);
            this.f52223b = aVar;
            aVar.getClass();
            aVar.a(new a.b(aVar, 1, 3, 1, new a.InterfaceC2046a(this) { // from class: com.dxmpay.apollon.heartbeat.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.a.a.InterfaceC2046a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.a;
                        LogUtil.i(str, b.a + " Idle ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.dxmpay.apollon.a.a aVar2 = this.f52223b;
            aVar2.getClass();
            aVar2.a(new a.b(aVar2, 3, 1, 2, new a.InterfaceC2046a(this) { // from class: com.dxmpay.apollon.heartbeat.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.a.a.InterfaceC2046a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.a;
                        LogUtil.i(str, b.a + " Active ---> Idle.");
                        HeartBeatManager.getInstance().stopHeartBeat();
                    }
                }
            }));
            com.dxmpay.apollon.a.a aVar3 = this.f52223b;
            aVar3.getClass();
            aVar3.a(new a.b(aVar3, 3, 2, 3, new a.InterfaceC2046a(this) { // from class: com.dxmpay.apollon.heartbeat.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.a.a.InterfaceC2046a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.a;
                        LogUtil.i(str, b.a + " Active ---> HalfActive.");
                        HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
                    }
                }
            }));
            com.dxmpay.apollon.a.a aVar4 = this.f52223b;
            aVar4.getClass();
            aVar4.a(new a.b(aVar4, 2, 3, 4, new a.InterfaceC2046a(this) { // from class: com.dxmpay.apollon.heartbeat.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.a.a.InterfaceC2046a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.a;
                        LogUtil.i(str, b.a + " HalfActive ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.dxmpay.apollon.a.a aVar5 = this.f52223b;
            aVar5.getClass();
            aVar5.a(new a.b(aVar5, 2, 1, 2, new a.InterfaceC2046a(this) { // from class: com.dxmpay.apollon.heartbeat.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.a.a.InterfaceC2046a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.a;
                        LogUtil.i(str, b.a + " HalfActive ---> Idle.");
                        HeartBeatManager.getInstance().stopHeartBeat();
                    }
                }
            }));
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 1 && i2 <= 4) {
                com.dxmpay.apollon.a.a aVar = this.f52223b;
                if (aVar != null) {
                    aVar.a(i2);
                    return;
                }
                throw new RuntimeException(a + " sendEvent but the mStateMachine is null.");
            }
            throw new IllegalArgumentException(a + " invalid params eventId:" + i2);
        }
    }
}
