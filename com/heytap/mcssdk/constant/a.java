package com.heytap.mcssdk.constant;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final Long b;
    public static final long c = 1000;
    public static final long d = 60000;
    public static final long e = 3600000;
    public static final long f = 86400000;
    public static final long g = 43200000;
    public static final long h = 900000;
    public static final long i = 1800000;
    public static final long j = 240000;
    public static final long k = 300000;
    public static final long l = 600000;
    public static final long m = 1800000;
    public static final long n = 7200000;
    public static final long o = 1800000;
    public static final long p = 300000;
    public static final long q = 10000;
    public static final long r = 5000;
    public static final long s = 300;
    public static final long t = 600000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.heytap.mcssdk.constant.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0589a {
        public static final int a = -1;
        public static final int b = -2;
        public static final int c = -3;
        public static final int d = -4;
        public static final int e = -5;
        public static final int f = -6;
        public static final int g = -7;
        public static final int h = -8;
        public static final int i = -9;
        public static final int j = -10;
        public static final int k = -11;
        public static final int l = -12;
        public static final int m = -13;
        public static final int n = -14;
        public static final int o = -15;
        public static final int p = -16;
        public static final int q = -17;
    }

    /* loaded from: classes9.dex */
    public interface b {
        public static final String a = "pushSdkLimit100";
        public static final String b = "57913";
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899402527, "Lcom/heytap/mcssdk/constant/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899402527, "Lcom/heytap/mcssdk/constant/a;");
                return;
            }
        }
        b = 0L;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
