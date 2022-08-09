package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kv9;
import com.repackage.ru9;
import com.repackage.vu9;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements ru9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4114392207069098388L;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu9<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(vu9<? super Integer> vu9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vu9Var, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.childSubscriber = vu9Var;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.endOfRange + 1;
            vu9<? super Integer> vu9Var = this.childSubscriber;
            for (long j2 = this.currentIndex; j2 != j; j2++) {
                if (vu9Var.isUnsubscribed()) {
                    return;
                }
                vu9Var.onNext(Integer.valueOf((int) j2));
            }
            if (vu9Var.isUnsubscribed()) {
                return;
            }
            vu9Var.onCompleted();
        }
    }

    @Override // com.repackage.ru9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j <= 0 || kv9.b(this, j) != 0) {
        } else {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long j2 = this.endOfRange + 1;
            long j3 = this.currentIndex;
            vu9<? super Integer> vu9Var = this.childSubscriber;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 != j && j3 != j2) {
                        if (vu9Var.isUnsubscribed()) {
                            return;
                        }
                        vu9Var.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else if (vu9Var.isUnsubscribed()) {
                        return;
                    } else {
                        if (j3 == j2) {
                            vu9Var.onCompleted();
                            return;
                        }
                        j = get();
                        if (j == j4) {
                            this.currentIndex = j3;
                            j = addAndGet(-j4);
                        }
                    }
                }
            } while (j != 0);
        }
    }
}
