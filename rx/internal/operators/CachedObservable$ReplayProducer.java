package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.n3a;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes9.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements d3a, i3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2557562030197141021L;
    public transient /* synthetic */ FieldHolder $fh;
    public final h3a<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final x3a<T> state;

    public CachedObservable$ReplayProducer(h3a<? super T> h3aVar, x3a<T> x3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h3aVar, x3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = h3aVar;
        this.state = x3aVar;
    }

    @Override // com.baidu.tieba.i3a
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (get() < 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.i3a
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && get() >= 0 && getAndSet(-1L) >= 0) {
            this.state.e(this);
        }
    }

    public long produced(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return addAndGet(-j);
        }
        return invokeJ.longValue;
    }

    @Override // com.baidu.tieba.d3a
    public void request(long j) {
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            do {
                j2 = get();
                if (j2 < 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void replay() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                boolean z2 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                try {
                    h3a<? super T> h3aVar = this.child;
                    while (true) {
                        long j = get();
                        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i < 0) {
                            return;
                        }
                        int b = this.state.b();
                        if (b != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.a();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i2 = this.index;
                            int i3 = this.currentIndexInBuffer;
                            try {
                                if (i == 0) {
                                    Object obj = objArr[i3];
                                    if (NotificationLite.f(obj)) {
                                        h3aVar.onCompleted();
                                        unsubscribe();
                                        return;
                                    } else if (NotificationLite.g(obj)) {
                                        h3aVar.onError(NotificationLite.d(obj));
                                        unsubscribe();
                                        return;
                                    }
                                } else if (i > 0) {
                                    int i4 = 0;
                                    while (i2 < b && j > 0) {
                                        if (h3aVar.isUnsubscribed()) {
                                            return;
                                        }
                                        if (i3 == length) {
                                            objArr = (Object[]) objArr[length];
                                            i3 = 0;
                                        }
                                        Object obj2 = objArr[i3];
                                        try {
                                            if (NotificationLite.a(h3aVar, obj2)) {
                                                try {
                                                    unsubscribe();
                                                    return;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    z = true;
                                                    try {
                                                        n3a.e(th);
                                                        unsubscribe();
                                                        if (!NotificationLite.g(obj2) && !NotificationLite.f(obj2)) {
                                                            h3aVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj2)));
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (!z) {
                                                            synchronized (this) {
                                                                this.emitting = false;
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                }
                                            }
                                            i3++;
                                            i2++;
                                            j--;
                                            i4++;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z = false;
                                        }
                                    }
                                    if (h3aVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.index = i2;
                                    this.currentIndexInBuffer = i3;
                                    this.currentBuffer = objArr;
                                    produced(i4);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                z = true;
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.missed = false;
                                } catch (Throwable th5) {
                                    th = th5;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            z = z2;
                            th = th7;
                            if (!z) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    z = false;
                }
            }
        }
    }
}
