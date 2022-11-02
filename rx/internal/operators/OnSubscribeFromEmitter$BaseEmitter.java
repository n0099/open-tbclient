package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b0a;
import com.baidu.tieba.c4a;
import com.baidu.tieba.iz9;
import com.baidu.tieba.mz9;
import com.baidu.tieba.nz9;
import com.baidu.tieba.wz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, iz9, nz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7326289992464377023L;
    public transient /* synthetic */ FieldHolder $fh;
    public final mz9<? super T> actual;
    public final c4a serial;

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void onUnsubscribed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public OnSubscribeFromEmitter$BaseEmitter(mz9<? super T> mz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mz9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = mz9Var;
        this.serial = new c4a();
    }

    @Override // com.baidu.tieba.nz9
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.serial.isUnsubscribed();
        }
        return invokeV.booleanValue;
    }

    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onCompleted();
        } finally {
            this.serial.unsubscribe();
        }
    }

    public final long requested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.nz9
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.serial.unsubscribe();
            onUnsubscribed();
        }
    }

    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) != null) || this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onError(th);
        } finally {
            this.serial.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.iz9
    public final void request(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && b0a.h(j)) {
            b0a.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(wz9 wz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz9Var) == null) {
            setSubscription(new CancellableSubscription(wz9Var));
        }
    }

    public final void setSubscription(nz9 nz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nz9Var) == null) {
            this.serial.a(nz9Var);
        }
    }
}
