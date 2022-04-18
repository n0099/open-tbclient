package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.statis.CustomALSHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ak5 implements aj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static ak5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-526126584, "Lcom/repackage/ak5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-526126584, "Lcom/repackage/ak5$b;");
                    return;
                }
            }
            a = new ak5(null);
        }
    }

    public /* synthetic */ ak5(a aVar) {
        this();
    }

    public static ak5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ak5) invokeV.objValue;
    }

    @Override // com.repackage.aj8
    public void a(long j, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)}) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "pagetime");
            init.addParam("f2", str2);
            init.addParam("f3", j + "");
            init.addParam("f4", str);
            init.addParam("f5", j2);
            init.send();
        }
    }

    @Override // com.repackage.aj8
    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "fullvideoshow");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // com.repackage.aj8
    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "cardclick");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // com.repackage.aj8
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "cardshow");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // com.repackage.aj8
    public void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "alert_click");
            init.addParam("f2", str);
            init.addParam("f5", str2);
            init.addParam("extf", str3);
            init.send();
        }
    }

    @Override // com.repackage.aj8
    public void f(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "pageshow");
            init.addParam("f2", str2);
            init.addParam("f3", j + "");
            init.addParam("f4", str);
            init.send();
        }
    }

    public ak5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
