package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.po1;
@Service
/* loaded from: classes5.dex */
public class bh3 implements hk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements ak1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bh3 bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ak1
        @NonNull
        public l53 a(Activity activity, boolean z, String str, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, Boolean.valueOf(z), str, str2})) == null) ? new ug3(activity, z, str, str2) : (l53) invokeCommon.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public q53 b(Activity activity, po1.d dVar, Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, dVar, bundle)) == null) ? new zg3(activity, dVar, bundle) : (q53) invokeLLL.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public r53 c(Activity activity, String str, String str2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new ah3(activity, str, str2, z, z2) : (r53) invokeCommon.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public m53 d(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)})) == null) ? new vg3(context, z, z2, strArr, str, z3) : (m53) invokeCommon.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public p53 e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new yg3(context) : (p53) invokeL.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public o53 f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new xg3(context) : (o53) invokeL.objValue;
        }

        @Override // com.repackage.ak1
        @NonNull
        public n53 g(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) ? new wg3(context, str) : (n53) invokeLL.objValue;
        }

        public /* synthetic */ b(bh3 bh3Var, a aVar) {
            this(bh3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755827036, "Lcom/repackage/bh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755827036, "Lcom/repackage/bh3;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public bh3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.hk1
    public tj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new tg3() : (tj1) invokeV.objValue;
    }

    @Override // com.repackage.hk1
    public ak1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, null) : (ak1) invokeV.objValue;
    }
}
