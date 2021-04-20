package io.reactivex.internal.operators.flowable;

import f.b.u.a;
import f.b.w.h;
import f.b.x.c.f;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements d {
    public static final long serialVersionUID = -2434867452883857743L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    public final h<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
        this.actual = cVar;
        this.zipper = hVar;
        this.delayErrors = z;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = new FlowableZip$ZipSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            flowableZip$ZipSubscriberArr[i3] = new FlowableZip$ZipSubscriber<>(this, i2);
        }
        this.current = new Object[i];
        this.subscribers = flowableZip$ZipSubscriberArr;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber : this.subscribers) {
            flowableZip$ZipSubscriber.cancel();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cc, code lost:
        if (r16 != 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
        if (r18.cancelled == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d2, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d5, code lost:
        if (r18.delayErrors != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dd, code lost:
        if (r18.errors.get() == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00df, code lost:
        cancelAll();
        r2.onError(r18.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00eb, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ec, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ed, code lost:
        if (r6 >= r4) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ef, code lost:
        r0 = r3[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f3, code lost:
        if (r5[r6] != null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
        r10 = r0.done;
        r0 = r0.queue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
        if (r0 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fb, code lost:
        r0 = r0.poll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0100, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0101, code lost:
        if (r0 != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0103, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0105, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0106, code lost:
        if (r10 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0108, code lost:
        if (r11 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010a, code lost:
        cancelAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0115, code lost:
        if (r18.errors.get() == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0117, code lost:
        r2.onError(r18.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0121, code lost:
        r2.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0124, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0125, code lost:
        if (r11 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0127, code lost:
        r5[r6] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x012a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x012b, code lost:
        f.b.u.a.a(r0);
        r18.errors.addThrowable(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0135, code lost:
        if (r18.delayErrors == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0137, code lost:
        cancelAll();
        r2.onError(r18.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0143, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0144, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x014b, code lost:
        if (r12 == 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x014d, code lost:
        r0 = r3.length;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x014f, code lost:
        if (r15 >= r0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0151, code lost:
        r3[r15].request(r12);
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
        if (r8 == Long.MAX_VALUE) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0162, code lost:
        r18.requested.addAndGet(-r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0168, code lost:
        r7 = addAndGet(-r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        boolean z;
        T poll;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super R> cVar = this.actual;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        int length = flowableZip$ZipSubscriberArr.length;
        Object[] objArr = this.current;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    return;
                } else {
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                    boolean z3 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                z = flowableZip$ZipSubscriber.done;
                                f<T> fVar = flowableZip$ZipSubscriber.queue;
                                poll = fVar != null ? fVar.poll() : null;
                                z2 = poll == null;
                            } catch (Throwable th) {
                                a.a(th);
                                this.errors.addThrowable(th);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    cVar.onError(this.errors.terminate());
                                    return;
                                }
                            }
                            if (z && z2) {
                                cancelAll();
                                if (this.errors.get() != null) {
                                    cVar.onError(this.errors.terminate());
                                    return;
                                } else {
                                    cVar.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                objArr[i3] = poll;
                            }
                            z3 = true;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        Object obj = (R) this.zipper.apply(objArr.clone());
                        f.b.x.b.a.b(obj, "The zipper returned a null value");
                        cVar.onNext(obj);
                        j2++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        a.a(th2);
                        cancelAll();
                        this.errors.addThrowable(th2);
                        cVar.onError(this.errors.terminate());
                        return;
                    }
                }
            }
        } while (i != 0);
    }

    public void error(FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber, Throwable th) {
        if (this.errors.addThrowable(th)) {
            flowableZip$ZipSubscriber.done = true;
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }

    public void subscribe(g.d.b<? extends T>[] bVarArr, int i) {
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
            if (!this.delayErrors && this.errors.get() != null) {
                return;
            }
            bVarArr[i2].subscribe(flowableZip$ZipSubscriberArr[i2]);
        }
    }
}
