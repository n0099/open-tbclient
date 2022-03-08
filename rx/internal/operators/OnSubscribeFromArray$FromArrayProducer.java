package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.o.a.a;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3534218984725836979L;
    public transient /* synthetic */ FieldHolder $fh;
    public final T[] array;
    public final j<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(j<? super T> jVar, T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, tArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = jVar;
        this.array = tArr;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j<? super T> jVar = this.child;
            for (T t : this.array) {
                Object obj = (Object) t;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(obj);
            }
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        }
    }

    @Override // i.f
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j2);
            } else if (j2 == Long.MAX_VALUE) {
                if (a.b(this, j2) == 0) {
                    fastPath();
                }
            } else if (i2 == 0 || a.b(this, j2) != 0) {
            } else {
                slowPath(j2);
            }
        }
    }

    public void slowPath(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            j<? super T> jVar = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i2 = this.index;
            do {
                long j3 = 0;
                while (true) {
                    if (j2 != 0 && i2 != length) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onNext((Object) tArr[i2]);
                        i2++;
                        if (i2 == length) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            jVar.onCompleted();
                            return;
                        }
                        j2--;
                        j3--;
                    } else {
                        j2 = get() + j3;
                        if (j2 == 0) {
                            this.index = i2;
                            j2 = addAndGet(j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }
}
