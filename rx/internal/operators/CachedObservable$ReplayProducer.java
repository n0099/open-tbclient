package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.ev9;
import com.repackage.jv9;
import com.repackage.tv9;
import com.repackage.zu9;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements zu9, ev9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2557562030197141021L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final tv9<T> state;

    public CachedObservable$ReplayProducer(dv9<? super T> dv9Var, tv9<T> tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var, tv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = dv9Var;
        this.state = tv9Var;
    }

    @Override // com.repackage.ev9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() < 0 : invokeV.booleanValue;
    }

    public long produced(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? addAndGet(-j) : invokeJ.longValue;
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
                dv9<? super T> dv9Var = this.child;
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
                                    dv9Var.onCompleted();
                                    unsubscribe();
                                    return;
                                } else if (NotificationLite.g(obj)) {
                                    dv9Var.onError(NotificationLite.d(obj));
                                    unsubscribe();
                                    return;
                                }
                            } else if (i > 0) {
                                int i4 = 0;
                                while (i2 < b && j > 0) {
                                    if (dv9Var.isUnsubscribed()) {
                                        return;
                                    }
                                    if (i3 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i3 = 0;
                                    }
                                    Object obj2 = objArr[i3];
                                    try {
                                        if (NotificationLite.a(dv9Var, obj2)) {
                                            try {
                                                unsubscribe();
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                z = true;
                                                try {
                                                    jv9.e(th);
                                                    unsubscribe();
                                                    if (NotificationLite.g(obj2) || NotificationLite.f(obj2)) {
                                                        return;
                                                    }
                                                    dv9Var.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj2)));
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
                                if (dv9Var.isUnsubscribed()) {
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

    @Override // com.repackage.zu9
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

    @Override // com.repackage.ev9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || get() < 0 || getAndSet(-1L) < 0) {
            return;
        }
        this.state.e(this);
    }
}
