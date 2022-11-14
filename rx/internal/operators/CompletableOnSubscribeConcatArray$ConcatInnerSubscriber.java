package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n4a;
import com.baidu.tieba.pz9;
import com.baidu.tieba.qz9;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements qz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7965400327305809232L;
    public transient /* synthetic */ FieldHolder $fh;
    public final qz9 actual;
    public int index;
    public final n4a sd;
    public final pz9[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(qz9 qz9Var, pz9[] pz9VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qz9Var, pz9VarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = qz9Var;
        this.sources = pz9VarArr;
        this.sd = new n4a();
    }

    public void next() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        pz9[] pz9VarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == pz9VarArr.length) {
                this.actual.onCompleted();
                return;
            }
            pz9VarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.qz9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            next();
        }
    }

    @Override // com.baidu.tieba.qz9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.actual.onError(th);
        }
    }

    @Override // com.baidu.tieba.qz9
    public void onSubscribe(yz9 yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yz9Var) == null) {
            this.sd.a(yz9Var);
        }
    }
}
