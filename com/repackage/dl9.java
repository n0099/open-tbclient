package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
/* loaded from: classes6.dex */
public class dl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ll9<Reporter> a;
    public static final ll9<Reporter> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ll9<Reporter> {
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
        @Override // com.repackage.ll9
        public Reporter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new il9("https://rpe.xdplt.com/evt/", true) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ll9<Reporter> {
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
        @Override // com.repackage.ll9
        public Reporter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new gl9("https://rpd.xdplt.com/evt/") : invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755763424, "Lcom/repackage/dl9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755763424, "Lcom/repackage/dl9;");
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
            ll9<Reporter> ll9Var = a;
            synchronized (ll9Var) {
                if (ll9Var.a == null) {
                    ll9Var.a = ll9Var.a();
                }
                reporter = ll9Var.a;
            }
            return reporter;
        }
        return (Reporter) invokeV.objValue;
    }
}
