package com.kwad.sdk.crash;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final double f35312a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f35313b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f35314c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f35315d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f35316e;

    /* renamed from: f  reason: collision with root package name */
    public static int f35317f;

    /* renamed from: g  reason: collision with root package name */
    public static String f35318g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-519586949, "Lcom/kwad/sdk/crash/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-519586949, "Lcom/kwad/sdk/crash/c;");
                return;
            }
        }
        f35312a = Runtime.getRuntime().maxMemory();
        f35313b = Pattern.compile("/data/user");
        f35314c = Pattern.compile("/data");
        f35315d = Pattern.compile("/data/data/(.*)/data/.*");
        f35316e = Pattern.compile("/data/user/.*/(.*)/data/.*");
        f35317f = 20;
        f35318g = "sessionId";
    }

    public c() {
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
