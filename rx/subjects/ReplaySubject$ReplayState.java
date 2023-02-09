package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dea;
import com.baidu.tieba.jea;
import com.baidu.tieba.nia;
import com.baidu.tieba.xda;
import com.baidu.tieba.yda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements xda.a<T>, yda<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ReplaySubject$ReplayProducer[] EMPTY;
    public static final ReplaySubject$ReplayProducer[] TERMINATED;
    public static final long serialVersionUID = 5952362471246910544L;
    public transient /* synthetic */ FieldHolder $fh;
    public final nia<T> buffer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609902619, "Lrx/subjects/ReplaySubject$ReplayState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1609902619, "Lrx/subjects/ReplaySubject$ReplayState;");
                return;
            }
        }
        EMPTY = new ReplaySubject$ReplayProducer[0];
        TERMINATED = new ReplaySubject$ReplayProducer[0];
    }

    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (get() == TERMINATED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yda
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nia<T> niaVar = this.buffer;
            niaVar.complete();
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
                niaVar.a(replaySubject$ReplayProducer);
            }
        }
    }

    public ReplaySubject$ReplayState(nia<T> niaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {niaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.buffer = niaVar;
        lazySet(EMPTY);
    }

    @Override // com.baidu.tieba.yda
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
            nia<T> niaVar = this.buffer;
            niaVar.error(th);
            ArrayList arrayList = null;
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
                try {
                    niaVar.a(replaySubject$ReplayProducer);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            jea.d(arrayList);
        }
    }

    public boolean add(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replaySubject$ReplayProducer)) == null) {
            do {
                replaySubject$ReplayProducerArr = get();
                if (replaySubject$ReplayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replaySubject$ReplayProducerArr.length;
                replaySubject$ReplayProducerArr2 = new ReplaySubject$ReplayProducer[length + 1];
                System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr2, 0, length);
                replaySubject$ReplayProducerArr2[length] = replaySubject$ReplayProducer;
            } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void call(dea<? super T> deaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, deaVar) == null) {
            ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(deaVar, this);
            deaVar.b(replaySubject$ReplayProducer);
            deaVar.f(replaySubject$ReplayProducer);
            if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
                remove(replaySubject$ReplayProducer);
            } else {
                this.buffer.a(replaySubject$ReplayProducer);
            }
        }
    }

    @Override // com.baidu.tieba.yda
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            nia<T> niaVar = this.buffer;
            niaVar.next(t);
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
                niaVar.a(replaySubject$ReplayProducer);
            }
        }
    }

    @Override // com.baidu.tieba.xda.a, com.baidu.tieba.lea
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dea) ((dea) obj));
    }

    public void remove(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, replaySubject$ReplayProducer) == null) {
            do {
                replaySubject$ReplayProducerArr = get();
                if (replaySubject$ReplayProducerArr != TERMINATED && replaySubject$ReplayProducerArr != EMPTY) {
                    int length = replaySubject$ReplayProducerArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replaySubject$ReplayProducerArr[i2] == replaySubject$ReplayProducer) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        replaySubject$ReplayProducerArr2 = EMPTY;
                    } else {
                        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr3 = new ReplaySubject$ReplayProducer[length - 1];
                        System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr3, 0, i);
                        System.arraycopy(replaySubject$ReplayProducerArr, i + 1, replaySubject$ReplayProducerArr3, i, (length - i) - 1);
                        replaySubject$ReplayProducerArr2 = replaySubject$ReplayProducerArr3;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
        }
    }
}
