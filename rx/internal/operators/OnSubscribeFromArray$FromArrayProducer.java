package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer extends AtomicLong implements zx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3534218984725836979L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] array;
    public final dy9 child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(dy9 dy9Var, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {dy9Var, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = dy9Var;
        this.array = objArr;
    }

    public void fastPath() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dy9 dy9Var = this.child;
            for (Object obj : this.array) {
                if (dy9Var.isUnsubscribed()) {
                    return;
                }
                dy9Var.onNext(obj);
            }
            if (dy9Var.isUnsubscribed()) {
                return;
            }
            dy9Var.onCompleted();
        }
    }

    @Override // com.baidu.tieba.zx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (j == Long.MAX_VALUE) {
                    if (sy9.b(this, j) == 0) {
                        fastPath();
                        return;
                    }
                    return;
                } else if (i != 0 && sy9.b(this, j) == 0) {
                    slowPath(j);
                    return;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    public void slowPath(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            dy9 dy9Var = this.child;
            Object[] objArr = this.array;
            int length = objArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j != 0 && i != length) {
                        if (dy9Var.isUnsubscribed()) {
                            return;
                        }
                        dy9Var.onNext(objArr[i]);
                        i++;
                        if (i == length) {
                            if (!dy9Var.isUnsubscribed()) {
                                dy9Var.onCompleted();
                                return;
                            }
                            return;
                        }
                        j--;
                        j2--;
                    } else {
                        j = get() + j2;
                        if (j == 0) {
                            this.index = i;
                            j = addAndGet(j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }
}
