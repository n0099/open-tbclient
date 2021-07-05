package com.kuaishou.aegon;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.aegon.a.a;
/* loaded from: classes7.dex */
public final /* synthetic */ class Aegon$$Lambda$12 implements a.InterfaceC0400a {
    public static /* synthetic */ Interceptable $ic;
    public static final Aegon$$Lambda$12 instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976130666, "Lcom/kuaishou/aegon/Aegon$$Lambda$12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(976130666, "Lcom/kuaishou/aegon/Aegon$$Lambda$12;");
                return;
            }
        }
        instance = new Aegon$$Lambda$12();
    }

    public Aegon$$Lambda$12() {
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getVersionString():java.lang.String] */
    public static a.InterfaceC0400a lambdaFactory$() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? instance : (a.InterfaceC0400a) invokeV.objValue;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0400a
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Aegon.nativeGetVersionString() : invokeV.objValue;
    }
}
