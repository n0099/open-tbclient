package io.reactivex.internal.operators.single;

import f.a.o;
import f.a.r;
import f.a.t.b;
import f.a.u.a;
import f.a.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements r<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public final o<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public b f68089d;
    public volatile Iterator<? extends R> it;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(o<? super R> oVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
        this.actual = oVar;
        this.mapper = hVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public void clear() {
        this.it = null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        this.cancelled = true;
        this.f68089d.dispose();
        this.f68089d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public boolean isEmpty() {
        return this.it == null;
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f68089d = DisposableHelper.DISPOSED;
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68089d, bVar)) {
            this.f68089d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: R, ? super R */
    @Override // f.a.r
    public void onSuccess(T t) {
        o<? super R> oVar = this.actual;
        try {
            Iterator<? extends R> it = this.mapper.apply(t).iterator();
            if (!it.hasNext()) {
                oVar.onComplete();
            } else if (this.outputFused) {
                this.it = it;
                oVar.onNext(null);
                oVar.onComplete();
            } else {
                while (!this.cancelled) {
                    try {
                        oVar.onNext((R) it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                oVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            a.a(th);
                            oVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        a.a(th2);
                        oVar.onError(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            a.a(th3);
            this.actual.onError(th3);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public R poll() throws Exception {
        Iterator<? extends R> it = this.it;
        if (it != null) {
            R next = it.next();
            f.a.x.b.a.b(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return next;
        }
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }
}
