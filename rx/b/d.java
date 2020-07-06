package rx.b;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes6.dex */
public class d<T> implements rx.e<T> {
    private boolean emitting;
    private final rx.e<? super T> ogH;
    private a ogI;
    private volatile boolean terminated;

    /* loaded from: classes6.dex */
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
        this.ogH = eVar;
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
                        a aVar = this.ogI;
                        if (aVar == null) {
                            aVar = new a();
                            this.ogI = aVar;
                        }
                        aVar.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                    try {
                        this.ogH.onNext(t);
                        while (true) {
                            synchronized (this) {
                                a aVar2 = this.ogI;
                                if (aVar2 == null) {
                                    this.emitting = false;
                                    return;
                                }
                                this.ogI = null;
                                Object[] objArr = aVar2.array;
                                for (Object obj : objArr) {
                                    if (obj != null) {
                                        try {
                                            if (NotificationLite.a(this.ogH, obj)) {
                                                this.terminated = true;
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            this.terminated = true;
                                            rx.exceptions.a.L(th);
                                            this.ogH.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        this.terminated = true;
                        rx.exceptions.a.a(th2, this.ogH, t);
                    }
                }
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        rx.exceptions.a.L(th);
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        a aVar = this.ogI;
                        if (aVar == null) {
                            aVar = new a();
                            this.ogI = aVar;
                        }
                        aVar.add(NotificationLite.error(th));
                        return;
                    }
                    this.emitting = true;
                    this.ogH.onError(th);
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
                        a aVar = this.ogI;
                        if (aVar == null) {
                            aVar = new a();
                            this.ogI = aVar;
                        }
                        aVar.add(NotificationLite.dUz());
                        return;
                    }
                    this.emitting = true;
                    this.ogH.onCompleted();
                }
            }
        }
    }
}
