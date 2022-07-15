package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as9;
/* loaded from: classes8.dex */
public final class OnSubscribeFromEmitter$NoneEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3776720187248809713L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeFromEmitter$NoneEmitter(as9<? super T> as9Var) {
        super(as9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {as9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((as9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || this.actual.isUnsubscribed()) {
            return;
        }
        this.actual.onNext(t);
        do {
            j = get();
            if (j == 0) {
                return;
            }
        } while (!compareAndSet(j, j - 1));
    }
}
