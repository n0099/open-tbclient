package d.a.d.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f41510d;

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f41511e;

    /* renamed from: f  reason: collision with root package name */
    public static d f41512f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f41513a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f41514b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f41515c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402482433, "Ld/a/d/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402482433, "Ld/a/d/e/a/d;");
                return;
            }
        }
        f41510d = BdUniqueId.gen();
        f41511e = BdUniqueId.gen();
        f41512f = null;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41513a = null;
        this.f41514b = null;
        this.f41515c = null;
        this.f41514b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f41515c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f41513a = new b();
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41512f == null) {
                synchronized (d.class) {
                    if (f41512f == null) {
                        f41512f = new d();
                    }
                }
            }
            return f41512f;
        }
        return (d) invokeV.objValue;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, diskFileOperate)) == null) {
            if (diskFileOperate == null) {
                return false;
            }
            if (diskFileOperate.isSdCard()) {
                return f(diskFileOperate, f41510d, this.f41514b, 10);
            }
            return f(diskFileOperate, f41511e, this.f41515c, 5);
        }
        return invokeL.booleanValue;
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, diskFileOperate, bdUniqueId, bdAsyncTaskParallel)) == null) {
            c cVar = new c(this.f41513a, diskFileOperate);
            cVar.setTag(bdUniqueId);
            cVar.setParallel(bdAsyncTaskParallel);
            cVar.setPriority(4);
            cVar.setKey(c(diskFileOperate));
            cVar.execute(new DiskFileOperate[0]);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final String c(DiskFileOperate diskFileOperate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, diskFileOperate)) == null) {
            if (diskFileOperate == null) {
                return null;
            }
            if (diskFileOperate.getPath() == null) {
                return diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
            }
            return diskFileOperate.getPath() + "/" + diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
        }
        return (String) invokeL.objValue;
    }

    public boolean d(DiskFileOperate diskFileOperate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, diskFileOperate)) == null) {
            if (diskFileOperate == null) {
                return false;
            }
            boolean b2 = new e(this.f41513a, diskFileOperate).b();
            diskFileOperate.callback(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, diskFileOperate) == null) || (c2 = c(diskFileOperate)) == null) {
            return;
        }
        BdAsyncTask.removeAllTask(f41510d, c2);
        BdAsyncTask.removeAllTask(f41511e, c2);
    }

    public final boolean f(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, diskFileOperate, bdUniqueId, bdAsyncTaskParallel, i2)) == null) {
            if (diskFileOperate == null) {
                return false;
            }
            if (diskFileOperate.getOperateType() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < i2 + diskFileOperate.getTrySuccessWeight()) {
                return b(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f41513a.e(str);
        }
    }
}
