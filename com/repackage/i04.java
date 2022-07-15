package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class i04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<i04> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i04 i04Var, i04 i04Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i04Var, i04Var2)) == null) ? (int) (i04Var.a - i04Var2.a) : invokeLL.intValue;
        }
    }

    public i04() {
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

    public static long[] a(i04 i04Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i04Var)) == null) {
            if (i04Var == null) {
                return null;
            }
            return new long[]{i04Var.a, i04Var.b};
        }
        return (long[]) invokeL.objValue;
    }

    public boolean b(i04 i04Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i04Var)) == null) {
            long j = this.a;
            if (j <= i04Var.b) {
                long j2 = this.b;
                long j3 = i04Var.a;
                if (j2 < j3) {
                    return false;
                }
                this.a = Math.min(j, j3);
                this.b = Math.max(this.b, i04Var.b);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
