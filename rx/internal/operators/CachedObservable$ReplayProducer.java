package rx.internal.operators;

import com.baidu.tieba.jnb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.zmb;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements pmb, umb {
    public static final long serialVersionUID = -2557562030197141021L;
    public final tmb<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final jnb<T> state;

    public CachedObservable$ReplayProducer(tmb<? super T> tmbVar, jnb<T> jnbVar) {
        this.child = tmbVar;
        this.state = jnbVar;
    }

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        if (get() < 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        if (get() >= 0 && getAndSet(-1L) >= 0) {
            this.state.e(this);
        }
    }

    public long produced(long j) {
        return addAndGet(-j);
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        long j2;
        long j3;
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

    /* JADX WARN: Removed duplicated region for block: B:87:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void replay() {
        boolean z;
        synchronized (this) {
            boolean z2 = true;
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            try {
                tmb<? super T> tmbVar = this.child;
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
                                    tmbVar.onCompleted();
                                    unsubscribe();
                                    return;
                                } else if (NotificationLite.g(obj)) {
                                    tmbVar.onError(NotificationLite.d(obj));
                                    unsubscribe();
                                    return;
                                }
                            } else if (i > 0) {
                                int i4 = 0;
                                while (i2 < b && j > 0) {
                                    if (tmbVar.isUnsubscribed()) {
                                        return;
                                    }
                                    if (i3 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i3 = 0;
                                    }
                                    Object obj2 = objArr[i3];
                                    try {
                                        if (NotificationLite.a(tmbVar, obj2)) {
                                            try {
                                                unsubscribe();
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                z = true;
                                                try {
                                                    zmb.e(th);
                                                    unsubscribe();
                                                    if (!NotificationLite.g(obj2) && !NotificationLite.f(obj2)) {
                                                        tmbVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj2)));
                                                        return;
                                                    }
                                                    return;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (!z) {
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
                                if (tmbVar.isUnsubscribed()) {
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
                            synchronized (this) {
                                this.emitting = false;
                            }
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
