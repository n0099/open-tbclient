package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wa0 {
    public static /* synthetic */ Interceptable $ic;
    public static final gb0 a;
    public static final y70 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xa0<T> m;
        public ya0<T> n;

        public a(xa0<T> xa0Var, ya0<T> ya0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa0Var, ya0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = null;
            this.n = null;
            this.m = xa0Var;
            this.n = ya0Var;
        }

        @Override // com.baidu.live.asynctask.BdAsyncTask
        public void q(T t) {
            ya0<T> ya0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (ya0Var = this.n) == null) {
                return;
            }
            ya0Var.onReturnDataInUI(t);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.asynctask.BdAsyncTask
        /* renamed from: z */
        public T f(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    if (this.m != null) {
                        return this.m.a();
                    }
                    return null;
                } catch (Throwable th) {
                    fb0.c(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755208245, "Lcom/repackage/wa0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755208245, "Lcom/repackage/wa0;");
                return;
            }
        }
        a = gb0.a();
        b = new y70(BdAsyncTaskParallelType.SERIAL, a);
    }

    public static <T> BdAsyncTask a(xa0<T> xa0Var, ya0<T> ya0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xa0Var, ya0Var)) == null) ? b(xa0Var, ya0Var, 2) : (BdAsyncTask) invokeLL.objValue;
    }

    public static <T> BdAsyncTask b(xa0<T> xa0Var, ya0<T> ya0Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, xa0Var, ya0Var, i)) == null) {
            if (xa0Var != null) {
                a aVar = new a(xa0Var, ya0Var);
                aVar.v(b);
                aVar.x(a);
                aVar.w(i);
                aVar.g(new String[0]);
                return aVar;
            }
            return null;
        }
        return (BdAsyncTask) invokeLLI.objValue;
    }
}
