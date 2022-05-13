package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy9;
/* loaded from: classes8.dex */
public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8360058422307496563L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeFromEmitter$DropEmitter(cy9<? super T> cy9Var) {
        super(cy9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cy9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cy9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }
}
