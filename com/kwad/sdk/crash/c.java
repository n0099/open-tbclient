package com.kwad.sdk.crash;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final double f65439a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f65440b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f65441c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f65442d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f65443e;

    /* renamed from: f  reason: collision with root package name */
    public static int f65444f;

    /* renamed from: g  reason: collision with root package name */
    public static String f65445g;
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
        f65439a = Runtime.getRuntime().maxMemory();
        f65440b = Pattern.compile("/data/user");
        f65441c = Pattern.compile("/data");
        f65442d = Pattern.compile("/data/data/(.*)/data/.*");
        f65443e = Pattern.compile("/data/user/.*/(.*)/data/.*");
        f65444f = 20;
        f65445g = "sessionId";
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
