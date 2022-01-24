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
/* loaded from: classes5.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4114392207069098388L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(j<? super Integer> jVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.childSubscriber = jVar;
        this.currentIndex = i2;
        this.endOfRange = i3;
    }

    public void fastPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.endOfRange + 1;
            j<? super Integer> jVar = this.childSubscriber;
            for (long j3 = this.currentIndex; j3 != j2; j3++) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(Integer.valueOf((int) j3));
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
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || get() == Long.MAX_VALUE) {
            return;
        }
        if (j2 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j2 <= 0 || a.b(this, j2) != 0) {
        } else {
            slowPath(j2);
        }
    }

    public void slowPath(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long j3 = this.endOfRange + 1;
            long j4 = this.currentIndex;
            j<? super Integer> jVar = this.childSubscriber;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 != j2 && j4 != j3) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onNext(Integer.valueOf((int) j4));
                        j4++;
                        j5++;
                    } else if (jVar.isUnsubscribed()) {
                        return;
                    } else {
                        if (j4 == j3) {
                            jVar.onCompleted();
                            return;
                        }
                        j2 = get();
                        if (j2 == j5) {
                            this.currentIndex = j4;
                            j2 = addAndGet(-j5);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }
}
