package d.a.q0.a.u.f.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends BasePendingOperation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0990a f51152e;

    /* renamed from: d.a.q0.a.u.f.b.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0990a {
        void a();
    }

    public a(InterfaceC0990a interfaceC0990a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0990a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51152e = interfaceC0990a;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public BasePendingOperation.OperationType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST : (BasePendingOperation.OperationType) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0990a interfaceC0990a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interfaceC0990a = this.f51152e) == null) {
            return;
        }
        interfaceC0990a.a();
    }
}
