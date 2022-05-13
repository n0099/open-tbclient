package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
/* loaded from: classes7.dex */
public class ve9 {
    public static /* synthetic */ Interceptable $ic;
    public static final bf9<Reporter> a;
    public static final bf9<Reporter> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends bf9<Reporter> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.internal.api.reporter.Reporter, java.lang.Object] */
        @Override // com.repackage.bf9
        public Reporter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ze9("https://rpe.xdplt.com/evt/", true) : invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends bf9<Reporter> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.internal.api.reporter.Reporter, java.lang.Object] */
        @Override // com.repackage.bf9
        public Reporter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new xe9("https://rpd.xdplt.com/evt/") : invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755233913, "Lcom/repackage/ve9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755233913, "Lcom/repackage/ve9;");
                return;
            }
        }
        a = new a();
        b = new b();
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.Object] */
    public static Reporter a() {
        InterceptResult invokeV;
        Reporter reporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            bf9<Reporter> bf9Var = a;
            synchronized (bf9Var) {
                if (bf9Var.a == null) {
                    bf9Var.a = bf9Var.a();
                }
                reporter = bf9Var.a;
            }
            return reporter;
        }
        return (Reporter) invokeV.objValue;
    }
}
