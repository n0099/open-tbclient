package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements e3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3534218984725836979L;
    public transient /* synthetic */ FieldHolder $fh;
    public final T[] array;
    public final i3a<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(i3a<? super T> i3aVar, T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3aVar, tArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = i3aVar;
        this.array = tArr;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i3a<? super T> i3aVar = this.child;
            for (T t : this.array) {
                Object obj = (Object) t;
                if (i3aVar.isUnsubscribed()) {
                    return;
                }
                i3aVar.onNext(obj);
            }
            if (i3aVar.isUnsubscribed()) {
                return;
            }
            i3aVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.e3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (j == Long.MAX_VALUE) {
                    if (x3a.b(this, j) == 0) {
                        fastPath();
                        return;
                    }
                    return;
                } else if (i != 0 && x3a.b(this, j) == 0) {
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
            i3a<? super T> i3aVar = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j != 0 && i != length) {
                        if (i3aVar.isUnsubscribed()) {
                            return;
                        }
                        i3aVar.onNext((Object) tArr[i]);
                        i++;
                        if (i == length) {
                            if (!i3aVar.isUnsubscribed()) {
                                i3aVar.onCompleted();
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
