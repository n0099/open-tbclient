package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m0a;
import com.baidu.tieba.tz9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements tz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3534218984725836979L;
    public transient /* synthetic */ FieldHolder $fh;
    public final T[] array;
    public final xz9<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(xz9<? super T> xz9Var, T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xz9Var, tArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = xz9Var;
        this.array = tArr;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xz9<? super T> xz9Var = this.child;
            for (T t : this.array) {
                Object obj = (Object) t;
                if (xz9Var.isUnsubscribed()) {
                    return;
                }
                xz9Var.onNext(obj);
            }
            if (xz9Var.isUnsubscribed()) {
                return;
            }
            xz9Var.onCompleted();
        }
    }

    @Override // com.baidu.tieba.tz9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (j == Long.MAX_VALUE) {
                    if (m0a.b(this, j) == 0) {
                        fastPath();
                        return;
                    }
                    return;
                } else if (i != 0 && m0a.b(this, j) == 0) {
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
            xz9<? super T> xz9Var = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j != 0 && i != length) {
                        if (xz9Var.isUnsubscribed()) {
                            return;
                        }
                        xz9Var.onNext((Object) tArr[i]);
                        i++;
                        if (i == length) {
                            if (!xz9Var.isUnsubscribed()) {
                                xz9Var.onCompleted();
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
