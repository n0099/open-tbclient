package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mv9;
import com.repackage.tu9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements tu9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4114392207069098388L;
    public transient /* synthetic */ FieldHolder $fh;
    public final xu9<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(xu9<? super Integer> xu9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xu9Var, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.childSubscriber = xu9Var;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.endOfRange + 1;
            xu9<? super Integer> xu9Var = this.childSubscriber;
            for (long j2 = this.currentIndex; j2 != j; j2++) {
                if (xu9Var.isUnsubscribed()) {
                    return;
                }
                xu9Var.onNext(Integer.valueOf((int) j2));
            }
            if (xu9Var.isUnsubscribed()) {
                return;
            }
            xu9Var.onCompleted();
        }
    }

    @Override // com.repackage.tu9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j <= 0 || mv9.b(this, j) != 0) {
        } else {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long j2 = this.endOfRange + 1;
            long j3 = this.currentIndex;
            xu9<? super Integer> xu9Var = this.childSubscriber;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 != j && j3 != j2) {
                        if (xu9Var.isUnsubscribed()) {
                            return;
                        }
                        xu9Var.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else if (xu9Var.isUnsubscribed()) {
                        return;
                    } else {
                        if (j3 == j2) {
                            xu9Var.onCompleted();
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
