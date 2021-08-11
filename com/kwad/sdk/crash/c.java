package com.kwad.sdk.crash;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final double f72260a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f72261b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f72262c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f72263d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f72264e;

    /* renamed from: f  reason: collision with root package name */
    public static int f72265f;

    /* renamed from: g  reason: collision with root package name */
    public static String f72266g;
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
        f72260a = Runtime.getRuntime().maxMemory();
        f72261b = Pattern.compile("/data/user");
        f72262c = Pattern.compile("/data");
        f72263d = Pattern.compile("/data/data/(.*)/data/.*");
        f72264e = Pattern.compile("/data/user/.*/(.*)/data/.*");
        f72265f = 20;
        f72266g = "sessionId";
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
