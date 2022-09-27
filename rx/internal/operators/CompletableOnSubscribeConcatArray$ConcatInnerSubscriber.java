package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b2a;
import com.baidu.tieba.dx9;
import com.baidu.tieba.ex9;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements ex9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7965400327305809232L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ex9 actual;
    public int index;
    public final b2a sd;
    public final dx9[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(ex9 ex9Var, dx9[] dx9VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ex9Var, dx9VarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = ex9Var;
        this.sources = dx9VarArr;
        this.sd = new b2a();
    }

    public void next() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
            dx9[] dx9VarArr = this.sources;
            while (!this.sd.isUnsubscribed()) {
                int i = this.index;
                this.index = i + 1;
                if (i == dx9VarArr.length) {
                    this.actual.onCompleted();
                    return;
                }
                dx9VarArr[i].j(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ex9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            next();
        }
    }

    @Override // com.baidu.tieba.ex9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.actual.onError(th);
        }
    }

    @Override // com.baidu.tieba.ex9
    public void onSubscribe(mx9 mx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mx9Var) == null) {
            this.sd.a(mx9Var);
        }
    }
}
