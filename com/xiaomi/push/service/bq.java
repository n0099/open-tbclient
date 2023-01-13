package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class bq {
    public static /* synthetic */ Interceptable $ic = null;
    public static int d = 300000;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f970a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f971a;
    public int b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071163511, "Lcom/xiaomi/push/service/bq;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071163511, "Lcom/xiaomi/push/service/bq;");
        }
    }

    public bq(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.f971a = xMPushService;
        this.a = 500;
        this.f970a = 0L;
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.b > 8) {
                return 300000;
            }
            double random = (Math.random() * 2.0d) + 1.0d;
            int i = this.b;
            if (i > 4) {
                return (int) (random * 60000.0d);
            }
            if (i > 1) {
                return (int) (random * 10000.0d);
            }
            if (this.f970a == 0) {
                return 0;
            }
            if (System.currentTimeMillis() - this.f970a >= 310000) {
                this.a = 1000;
                this.c = 0;
                return 0;
            }
            int i2 = this.a;
            int i3 = d;
            if (i2 >= i3) {
                return i2;
            }
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 >= 4) {
                return i3;
            }
            this.a = (int) (i2 * 1.5d);
            return i2;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m721a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f970a = System.currentTimeMillis();
            this.f971a.a(1);
            this.b = 0;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!this.f971a.m666a()) {
                com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            } else if (z) {
                if (!this.f971a.m667a(1)) {
                    this.b++;
                }
                this.f971a.a(1);
                XMPushService xMPushService = this.f971a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.e(xMPushService));
            } else if (this.f971a.m667a(1)) {
            } else {
                int a = a();
                this.b++;
                com.xiaomi.channel.commonutils.logger.b.m103a("schedule reconnect in " + a + "ms");
                XMPushService xMPushService2 = this.f971a;
                xMPushService2.getClass();
                xMPushService2.a(new XMPushService.e(xMPushService2), (long) a);
                if (this.b == 2 && fh.m397a().m402a()) {
                    ap.b();
                }
                if (this.b == 3) {
                    ap.a();
                }
            }
        }
    }
}
