package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy9;
import com.repackage.jy9;
import com.repackage.ky9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements jy9, dy9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4262875056400218316L;
    public transient /* synthetic */ FieldHolder $fh;
    public ky9<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(ky9<? super Resource> ky9Var, Resource resource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ky9Var, resource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dispose = ky9Var;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.repackage.ky9<? super Resource>, Resource] */
    @Override // com.repackage.jy9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && compareAndSet(false, true)) {
            ?? r0 = (Resource) false;
            try {
                this.dispose.call((Resource) this.resource);
            } finally {
                this.resource = null;
                this.dispose = null;
            }
        }
    }

    @Override // com.repackage.dy9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() : invokeV.booleanValue;
    }

    @Override // com.repackage.dy9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            call();
        }
    }
}
