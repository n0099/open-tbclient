package rx.b;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public class d<T> implements rx.e<T> {
    private boolean emitting;
    private final rx.e<? super T> kAY;
    private a kAZ;
    private volatile boolean terminated;

    /* loaded from: classes2.dex */
    static final class a {
        Object[] array;
        int size;

        a() {
        }

        public void add(Object obj) {
            Object[] objArr;
            int i = this.size;
            Object[] objArr2 = this.array;
            if (objArr2 == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i == objArr2.length) {
                objArr = new Object[(i >> 2) + i];
                System.arraycopy(objArr2, 0, objArr, 0, i);
                this.array = objArr;
            } else {
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.size = i + 1;
        }
    }

    public d(rx.e<? super T> eVar) {
        this.kAY = eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
        continue;
     */
    @Override // rx.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    if (this.emitting) {
                        a aVar = this.kAZ;
                        if (aVar == null) {
                            aVar = new a();
                            this.kAZ = aVar;
                        }
                        aVar.add(NotificationLite.bq(t));
                        return;
                    }
                    this.emitting = true;
                    try {
                        this.kAY.onNext(t);
                        while (true) {
                            synchronized (this) {
                                a aVar2 = this.kAZ;
                                if (aVar2 == null) {
                                    this.emitting = false;
                                    return;
                                }
                                this.kAZ = null;
                                Object[] objArr = aVar2.array;
                                for (Object obj : objArr) {
                                    if (obj != null) {
                                        try {
                                            if (NotificationLite.a(this.kAY, obj)) {
                                                this.terminated = true;
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            this.terminated = true;
                                            rx.exceptions.a.K(th);
                                            this.kAY.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        this.terminated = true;
                        rx.exceptions.a.a(th2, this.kAY, t);
                    }
                }
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        rx.exceptions.a.K(th);
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        a aVar = this.kAZ;
                        if (aVar == null) {
                            aVar = new a();
                            this.kAZ = aVar;
                        }
                        aVar.add(NotificationLite.N(th));
                        return;
                    }
                    this.emitting = true;
                    this.kAY.onError(th);
                }
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        a aVar = this.kAZ;
                        if (aVar == null) {
                            aVar = new a();
                            this.kAZ = aVar;
                        }
                        aVar.add(NotificationLite.cPn());
                        return;
                    }
                    this.emitting = true;
                    this.kAY.onCompleted();
                }
            }
        }
    }
}
