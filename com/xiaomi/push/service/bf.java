package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gx;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f78488d = 300000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f78489a;

    /* renamed from: a  reason: collision with other field name */
    public long f930a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f931a;

    /* renamed from: b  reason: collision with root package name */
    public int f78490b;

    /* renamed from: c  reason: collision with root package name */
    public int f78491c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071163170, "Lcom/xiaomi/push/service/bf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071163170, "Lcom/xiaomi/push/service/bf;");
        }
    }

    public bf(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f78490b = 0;
        this.f78491c = 0;
        this.f931a = xMPushService;
        this.f78489a = 500;
        this.f930a = 0L;
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.f78490b > 8) {
                return 300000;
            }
            double random = (Math.random() * 2.0d) + 1.0d;
            int i2 = this.f78490b;
            if (i2 > 4) {
                return (int) (random * 60000.0d);
            }
            if (i2 > 1) {
                return (int) (random * 10000.0d);
            }
            if (this.f930a == 0) {
                return 0;
            }
            if (System.currentTimeMillis() - this.f930a >= 310000) {
                this.f78489a = 1000;
                this.f78491c = 0;
                return 0;
            }
            int i3 = this.f78489a;
            int i4 = f78488d;
            if (i3 >= i4) {
                return i3;
            }
            int i5 = this.f78491c + 1;
            this.f78491c = i5;
            if (i5 >= 4) {
                return i4;
            }
            this.f78489a = (int) (i3 * 1.5d);
            return i3;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m614a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f930a = System.currentTimeMillis();
            this.f931a.a(1);
            this.f78490b = 0;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!this.f931a.m566a()) {
                com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            } else if (z) {
                if (!this.f931a.m567a(1)) {
                    this.f78490b++;
                }
                this.f931a.a(1);
                XMPushService xMPushService = this.f931a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.d(xMPushService));
            } else if (this.f931a.m567a(1)) {
            } else {
                int a2 = a();
                this.f78490b++;
                com.xiaomi.channel.commonutils.logger.b.m73a("schedule reconnect in " + a2 + "ms");
                XMPushService xMPushService2 = this.f931a;
                xMPushService2.getClass();
                xMPushService2.a(new XMPushService.d(xMPushService2), (long) a2);
                if (this.f78490b == 2 && gx.m366a().m371a()) {
                    ag.b();
                }
                if (this.f78490b == 3) {
                    ag.a();
                }
            }
        }
    }
}
