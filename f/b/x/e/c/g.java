package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class g<T> implements o<T>, f.b.t.b {

    /* renamed from: h  reason: collision with root package name */
    public static final ObservablePublish$InnerDisposable[] f68505h = new ObservablePublish$InnerDisposable[0];
    public static final ObservablePublish$InnerDisposable[] i = new ObservablePublish$InnerDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<g<T>> f68506e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<ObservablePublish$InnerDisposable<T>[]> f68507f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68508g;

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable<T>[] observablePublish$InnerDisposableArr;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr2;
        do {
            observablePublish$InnerDisposableArr = this.f68507f.get();
            int length = observablePublish$InnerDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (observablePublish$InnerDisposableArr[i3].equals(observablePublish$InnerDisposable)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                observablePublish$InnerDisposableArr2 = f68505h;
            } else {
                ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr3 = new ObservablePublish$InnerDisposable[length - 1];
                System.arraycopy(observablePublish$InnerDisposableArr, 0, observablePublish$InnerDisposableArr3, 0, i2);
                System.arraycopy(observablePublish$InnerDisposableArr, i2 + 1, observablePublish$InnerDisposableArr3, i2, (length - i2) - 1);
                observablePublish$InnerDisposableArr2 = observablePublish$InnerDisposableArr3;
            }
        } while (!this.f68507f.compareAndSet(observablePublish$InnerDisposableArr, observablePublish$InnerDisposableArr2));
    }

    @Override // f.b.t.b
    public void dispose() {
        ObservablePublish$InnerDisposable<T>[] observablePublish$InnerDisposableArr = this.f68507f.get();
        ObservablePublish$InnerDisposable<T>[] observablePublish$InnerDisposableArr2 = i;
        if (observablePublish$InnerDisposableArr == observablePublish$InnerDisposableArr2 || this.f68507f.getAndSet(observablePublish$InnerDisposableArr2) == i) {
            return;
        }
        this.f68506e.compareAndSet(this, null);
        DisposableHelper.dispose(this.f68508g);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f68507f.get() == i;
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68506e.compareAndSet(this, null);
        for (ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable : this.f68507f.getAndSet(i)) {
            observablePublish$InnerDisposable.child.onComplete();
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.f68506e.compareAndSet(this, null);
        ObservablePublish$InnerDisposable<T>[] andSet = this.f68507f.getAndSet(i);
        if (andSet.length != 0) {
            for (ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable : andSet) {
                observablePublish$InnerDisposable.child.onError(th);
            }
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        for (ObservablePublish$InnerDisposable<T> observablePublish$InnerDisposable : this.f68507f.get()) {
            observablePublish$InnerDisposable.child.onNext(t);
        }
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.setOnce(this.f68508g, bVar);
    }
}
