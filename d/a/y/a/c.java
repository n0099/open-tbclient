package d.a.y.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.y.e.b f70994a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f70995b;

    /* renamed from: c  reason: collision with root package name */
    public int f70996c;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.y.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdAsyncTaskParallelType, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70994a = null;
        this.f70995b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f70996c = 1;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f70995b = bdAsyncTaskParallelType;
            this.f70994a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70996c : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.y.e.b bVar = this.f70994a;
            if (bVar == null) {
                return 0;
            }
            return bVar.b();
        }
        return invokeV.intValue;
    }

    public BdAsyncTaskParallelType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70995b : (BdAsyncTaskParallelType) invokeV.objValue;
    }
}
