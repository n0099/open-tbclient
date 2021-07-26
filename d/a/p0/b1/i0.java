package d.a.p0.b1;

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
/* loaded from: classes7.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f52081a;

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f52082b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f52083a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f52084b;

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
            this.f52083a = null;
            this.f52084b = null;
            this.f52083a = f0Var;
            this.f52084b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    if (this.f52083a != null) {
                        return this.f52083a.doInBackground();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || (nVar = this.f52084b) == null) {
                return;
            }
            nVar.onReturnDataInUI(t);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1623623874, "Ld/a/p0/b1/i0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1623623874, "Ld/a/p0/b1/i0;");
                return;
            }
        }
        f52081a = BdUniqueId.gen();
        f52082b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f52081a);
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            BdAsyncTask.removeAllTask(f52081a);
        }
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, f0Var, nVar) == null) || f0Var == null) {
            return;
        }
        a aVar = new a(f0Var, nVar);
        aVar.setParallel(f52082b);
        aVar.setTag(f52081a);
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
        aVar.setTag(f52081a);
        aVar.setPriority(4);
        aVar.execute(new String[0]);
    }
}
