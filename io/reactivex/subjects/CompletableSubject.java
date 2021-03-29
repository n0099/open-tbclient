package io.reactivex.subjects;

import f.a.a;
import f.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableSubject extends a implements b {

    /* renamed from: h  reason: collision with root package name */
    public static final CompletableDisposable[] f68107h = new CompletableDisposable[0];
    public static final CompletableDisposable[] i = new CompletableDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public Throwable f68110g;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f68109f = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f68108e = new AtomicReference<>(f68107h);

    /* loaded from: classes7.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements f.a.t.b {
        public static final long serialVersionUID = -7650903191002190468L;
        public final b actual;

        public CompletableDisposable(b bVar, CompletableSubject completableSubject) {
            this.actual = bVar;
            lazySet(completableSubject);
        }

        @Override // f.a.t.b
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.e(this);
            }
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @Override // f.a.a
    public void b(b bVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(bVar, this);
        bVar.onSubscribe(completableDisposable);
        if (d(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                e(completableDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f68110g;
        if (th != null) {
            bVar.onError(th);
        } else {
            bVar.onComplete();
        }
    }

    public boolean d(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f68108e.get();
            if (completableDisposableArr == i) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f68108e.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void e(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f68108e.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (completableDisposableArr[i3] == completableDisposable) {
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
                completableDisposableArr2 = f68107h;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i2);
                System.arraycopy(completableDisposableArr, i2 + 1, completableDisposableArr3, i2, (length - i2) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!this.f68108e.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    @Override // f.a.b
    public void onComplete() {
        if (this.f68109f.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f68108e.getAndSet(i)) {
                completableDisposable.actual.onComplete();
            }
        }
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        f.a.x.b.a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f68109f.compareAndSet(false, true)) {
            this.f68110g = th;
            for (CompletableDisposable completableDisposable : this.f68108e.getAndSet(i)) {
                completableDisposable.actual.onError(th);
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.b
    public void onSubscribe(f.a.t.b bVar) {
        if (this.f68108e.get() == i) {
            bVar.dispose();
        }
    }
}
