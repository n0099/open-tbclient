package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.k;
import i.m.a;
import i.o.a.b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes5.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements f, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2557562030197141021L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final b<T> state;

    public CachedObservable$ReplayProducer(j<? super T> jVar, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, bVar};
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
        this.state = bVar;
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() < 0 : invokeV.booleanValue;
    }

    public long produced(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? addAndGet(-j2) : invokeJ.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void replay() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        synchronized (this) {
            boolean z2 = true;
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            try {
                j<? super T> jVar = this.child;
                while (true) {
                    long j2 = get();
                    int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                    if (i2 < 0) {
                        return;
                    }
                    int b2 = this.state.b();
                    if (b2 != 0) {
                        Object[] objArr = this.currentBuffer;
                        if (objArr == null) {
                            objArr = this.state.a();
                            this.currentBuffer = objArr;
                        }
                        int length = objArr.length - 1;
                        int i3 = this.index;
                        int i4 = this.currentIndexInBuffer;
                        try {
                            if (i2 == 0) {
                                Object obj = objArr[i4];
                                if (NotificationLite.f(obj)) {
                                    jVar.onCompleted();
                                    unsubscribe();
                                    return;
                                } else if (NotificationLite.g(obj)) {
                                    jVar.onError(NotificationLite.d(obj));
                                    unsubscribe();
                                    return;
                                }
                            } else if (i2 > 0) {
                                int i5 = 0;
                                while (i3 < b2 && j2 > 0) {
                                    if (jVar.isUnsubscribed()) {
                                        return;
                                    }
                                    if (i4 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i4 = 0;
                                    }
                                    Object obj2 = objArr[i4];
                                    try {
                                        if (NotificationLite.a(jVar, obj2)) {
                                            try {
                                                unsubscribe();
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                z = true;
                                                try {
                                                    a.e(th);
                                                    unsubscribe();
                                                    if (NotificationLite.g(obj2) || NotificationLite.f(obj2)) {
                                                        return;
                                                    }
                                                    jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj2)));
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
                                        i4++;
                                        i3++;
                                        j2--;
                                        i5++;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = false;
                                    }
                                }
                                if (jVar.isUnsubscribed()) {
                                    return;
                                }
                                this.index = i3;
                                this.currentIndexInBuffer = i4;
                                this.currentBuffer = objArr;
                                produced(i5);
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

    @Override // i.f
    public void request(long j2) {
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            do {
                j3 = get();
                if (j3 < 0) {
                    return;
                }
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j3, j4));
            replay();
        }
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || get() < 0 || getAndSet(-1L) < 0) {
            return;
        }
        this.state.e(this);
    }
}
