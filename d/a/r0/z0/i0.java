package d.a.r0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f56949a;

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f56950b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f56951a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f56952b;

        public a(f0<T> f0Var, n<T> nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0Var, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56951a = null;
            this.f56952b = null;
            this.f56951a = f0Var;
            this.f56952b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    if (this.f56951a != null) {
                        return this.f56951a.doInBackground();
                    }
                    return null;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || (nVar = this.f56952b) == null) {
                return;
            }
            nVar.onReturnDataInUI(t);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-257389401, "Ld/a/r0/z0/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-257389401, "Ld/a/r0/z0/i0;");
                return;
            }
        }
        f56949a = BdUniqueId.gen();
        f56950b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f56949a);
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            BdAsyncTask.removeAllTask(f56949a);
        }
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, f0Var, nVar) == null) || f0Var == null) {
            return;
        }
        a aVar = new a(f0Var, nVar);
        aVar.setParallel(f56950b);
        aVar.setTag(f56949a);
        aVar.setPriority(4);
        aVar.execute(new String[0]);
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, f0Var, nVar) == null) || f0Var == null) {
            return;
        }
        a aVar = new a(f0Var, nVar);
        aVar.setParallel(TiebaIMConfig.getParallel());
        aVar.setTag(f56949a);
        aVar.setPriority(4);
        aVar.execute(new String[0]);
    }
}
