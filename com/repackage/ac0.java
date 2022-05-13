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
/* loaded from: classes5.dex */
public class ac0 {
    public static /* synthetic */ Interceptable $ic;
    public static final kc0 a;
    public static final g90 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bc0<T> m;
        public cc0<T> n;

        public a(bc0<T> bc0Var, cc0<T> cc0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc0Var, cc0Var};
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
            this.m = bc0Var;
            this.n = cc0Var;
        }

        @Override // com.baidu.live.asynctask.BdAsyncTask
        public void q(T t) {
            cc0<T> cc0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (cc0Var = this.n) == null) {
                return;
            }
            cc0Var.onReturnDataInUI(t);
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
                    jc0.c(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755861725, "Lcom/repackage/ac0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755861725, "Lcom/repackage/ac0;");
                return;
            }
        }
        a = kc0.a();
        b = new g90(BdAsyncTaskParallelType.SERIAL, a);
    }

    public static <T> BdAsyncTask a(bc0<T> bc0Var, cc0<T> cc0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bc0Var, cc0Var)) == null) ? b(bc0Var, cc0Var, 2) : (BdAsyncTask) invokeLL.objValue;
    }

    public static <T> BdAsyncTask b(bc0<T> bc0Var, cc0<T> cc0Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bc0Var, cc0Var, i)) == null) {
            if (bc0Var != null) {
                a aVar = new a(bc0Var, cc0Var);
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
