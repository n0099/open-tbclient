package d.a.y.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes9.dex */
public abstract class b<V> extends FutureTask<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f70993e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, bdAsyncTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Callable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70993e = null;
        this.f70993e = bdAsyncTask;
    }

    public abstract void a();

    public BdAsyncTask<?, ?, ?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70993e : (BdAsyncTask) invokeV.objValue;
    }
}
