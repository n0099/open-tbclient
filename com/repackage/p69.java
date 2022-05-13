package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* loaded from: classes6.dex */
public class p69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-145516799, "Lcom/repackage/p69$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-145516799, "Lcom/repackage/p69$a;");
                    return;
                }
            }
            int[] iArr = new int[EncryptAlgorithm.values().length];
            a = iArr;
            try {
                iArr[EncryptAlgorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static o69 a(r69 r69Var) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r69Var)) == null) {
            if (a.a[r69Var.a().ordinal()] != 1) {
                return null;
            }
            return new q69(r69Var.b());
        }
        return (o69) invokeL.objValue;
    }
}
