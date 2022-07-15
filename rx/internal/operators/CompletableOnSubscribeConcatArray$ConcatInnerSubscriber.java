package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs9;
import com.repackage.qw9;
import com.repackage.sr9;
import com.repackage.tr9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements tr9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7965400327305809232L;
    public transient /* synthetic */ FieldHolder $fh;
    public final tr9 actual;
    public int index;
    public final qw9 sd;
    public final sr9[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(tr9 tr9Var, sr9[] sr9VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tr9Var, sr9VarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = tr9Var;
        this.sources = sr9VarArr;
        this.sd = new qw9();
    }

    public void next() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
            sr9[] sr9VarArr = this.sources;
            while (!this.sd.isUnsubscribed()) {
                int i = this.index;
                this.index = i + 1;
                if (i == sr9VarArr.length) {
                    this.actual.onCompleted();
                    return;
                }
                sr9VarArr[i].j(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // com.repackage.tr9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            next();
        }
    }

    @Override // com.repackage.tr9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.actual.onError(th);
        }
    }

    @Override // com.repackage.tr9
    public void onSubscribe(bs9 bs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bs9Var) == null) {
            this.sd.a(bs9Var);
        }
    }
}
