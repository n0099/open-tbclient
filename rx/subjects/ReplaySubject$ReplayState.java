package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.jv9;
import com.repackage.nz9;
import com.repackage.xu9;
import com.repackage.yu9;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements xu9.a<T>, yu9<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ReplaySubject$ReplayProducer[] EMPTY;
    public static final ReplaySubject$ReplayProducer[] TERMINATED;
    public static final long serialVersionUID = 5952362471246910544L;
    public transient /* synthetic */ FieldHolder $fh;
    public final nz9<T> buffer;

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

    public ReplaySubject$ReplayState(nz9<T> nz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.buffer = nz9Var;
        lazySet(EMPTY);
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

    @Override // com.repackage.xu9.a, com.repackage.lv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dv9) ((dv9) obj));
    }

    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() == TERMINATED : invokeV.booleanValue;
    }

    @Override // com.repackage.yu9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nz9<T> nz9Var = this.buffer;
            nz9Var.complete();
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
                nz9Var.a(replaySubject$ReplayProducer);
            }
        }
    }

    @Override // com.repackage.yu9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
            nz9<T> nz9Var = this.buffer;
            nz9Var.error(th);
            ArrayList arrayList = null;
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
                try {
                    nz9Var.a(replaySubject$ReplayProducer);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            jv9.d(arrayList);
        }
    }

    @Override // com.repackage.yu9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            nz9<T> nz9Var = this.buffer;
            nz9Var.next(t);
            for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
                nz9Var.a(replaySubject$ReplayProducer);
            }
        }
    }

    public void remove(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, replaySubject$ReplayProducer) == null) {
            do {
                replaySubject$ReplayProducerArr = get();
                if (replaySubject$ReplayProducerArr == TERMINATED || replaySubject$ReplayProducerArr == EMPTY) {
                    return;
                }
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
            } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
        }
    }

    public void call(dv9<? super T> dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dv9Var) == null) {
            ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(dv9Var, this);
            dv9Var.b(replaySubject$ReplayProducer);
            dv9Var.f(replaySubject$ReplayProducer);
            if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
                remove(replaySubject$ReplayProducer);
            } else {
                this.buffer.a(replaySubject$ReplayProducer);
            }
        }
    }
}
