package io.reactivex.internal.operators.observable;

import f.b.c0.a;
import f.b.p;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class ObservableReplay$SizeAndTimeBoundReplayBuffer<T> extends ObservableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final p scheduler;
    public final TimeUnit unit;

    public ObservableReplay$SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, p pVar) {
        this.scheduler = pVar;
        this.limit = i;
        this.maxAge = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    public Object enterTransform(Object obj) {
        return new a(obj, this.scheduler.b(this.unit), this.unit);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    public ObservableReplay$Node getHead() {
        ObservableReplay$Node observableReplay$Node;
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node observableReplay$Node2 = get();
        ObservableReplay$Node observableReplay$Node3 = observableReplay$Node2.get();
        while (true) {
            ObservableReplay$Node observableReplay$Node4 = observableReplay$Node3;
            observableReplay$Node = observableReplay$Node2;
            observableReplay$Node2 = observableReplay$Node4;
            if (observableReplay$Node2 != null) {
                a aVar = (a) observableReplay$Node2.value;
                if (NotificationLite.isComplete(aVar.b()) || NotificationLite.isError(aVar.b()) || aVar.a() > b2) {
                    break;
                }
                observableReplay$Node3 = observableReplay$Node2.get();
            } else {
                break;
            }
        }
        return observableReplay$Node;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    public Object leaveTransform(Object obj) {
        return ((a) obj).b();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    public void truncate() {
        ObservableReplay$Node observableReplay$Node;
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node observableReplay$Node2 = get();
        ObservableReplay$Node observableReplay$Node3 = observableReplay$Node2.get();
        int i = 0;
        while (true) {
            ObservableReplay$Node observableReplay$Node4 = observableReplay$Node3;
            observableReplay$Node = observableReplay$Node2;
            observableReplay$Node2 = observableReplay$Node4;
            if (observableReplay$Node2 != null) {
                int i2 = this.size;
                if (i2 > this.limit) {
                    i++;
                    this.size = i2 - 1;
                    observableReplay$Node3 = observableReplay$Node2.get();
                } else if (((a) observableReplay$Node2.value).a() > b2) {
                    break;
                } else {
                    i++;
                    this.size--;
                    observableReplay$Node3 = observableReplay$Node2.get();
                }
            } else {
                break;
            }
        }
        if (i != 0) {
            setFirst(observableReplay$Node);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        setFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        return;
     */
    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void truncateFinal() {
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node observableReplay$Node = get();
        ObservableReplay$Node observableReplay$Node2 = observableReplay$Node.get();
        int i = 0;
        while (true) {
            ObservableReplay$Node observableReplay$Node3 = observableReplay$Node2;
            ObservableReplay$Node observableReplay$Node4 = observableReplay$Node;
            observableReplay$Node = observableReplay$Node3;
            if (observableReplay$Node == null || this.size <= 1 || ((a) observableReplay$Node.value).a() > b2) {
                break;
            }
            i++;
            this.size--;
            observableReplay$Node2 = observableReplay$Node.get();
        }
    }
}
