package rx.internal.operators;

import h.f;
import h.j;
import h.k;
import h.m.a;
import h.o.a.b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements f, k {
    public static final long serialVersionUID = -2557562030197141021L;
    public final j<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final b<T> state;

    public CachedObservable$ReplayProducer(j<? super T> jVar, b<T> bVar) {
        this.child = jVar;
        this.state = bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return get() < 0;
    }

    public long produced(long j) {
        return addAndGet(-j);
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
                j<? super T> jVar = this.child;
                while (true) {
                    long j = get();
                    int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
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
                                while (i3 < b2 && j > 0) {
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
                                                    }
                                                    throw th;
                                                }
                                            }
                                        }
                                        i4++;
                                        i3++;
                                        j--;
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

    @Override // h.f
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

    @Override // h.k
    public void unsubscribe() {
        if (get() < 0 || getAndSet(-1L) < 0) {
            return;
        }
        this.state.e(this);
    }
}
