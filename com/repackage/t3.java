package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j7[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964028506, "Lcom/repackage/t3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964028506, "Lcom/repackage/t3;");
                return;
            }
        }
        new i3(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public t3(s3 s3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new y6();
        new y6();
        new i3(1.0f, 1.0f, 1.0f, 1.0f);
        int i3 = s3Var.b.b;
        if (i3 != 0) {
            float[][] fArr = new float[i3];
            int[] iArr = new int[i3];
            if (i3 > 1) {
                j7[] j7VarArr = new j7[i3];
                this.a = j7VarArr;
                int length = j7VarArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    this.a[i4] = new j7();
                }
            }
            int[] iArr2 = new int[i3];
            return;
        }
        throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    }
}
