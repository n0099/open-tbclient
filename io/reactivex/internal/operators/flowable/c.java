package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class c<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final io.reactivex.c.a nnn;
    final io.reactivex.c.a onComplete;
    final io.reactivex.c.g<? super Throwable> onError;
    final io.reactivex.c.g<? super T> onNext;

    public c(io.reactivex.g<T> gVar, io.reactivex.c.g<? super T> gVar2, io.reactivex.c.g<? super Throwable> gVar3, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        super(gVar);
        this.onNext = gVar2;
        this.onError = gVar3;
        this.onComplete = aVar;
        this.nnn = aVar2;
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.nmU.a((j) new a((io.reactivex.internal.a.a) cVar, this.onNext, this.onError, this.onComplete, this.nnn));
        } else {
            this.nmU.a((j) new b(cVar, this.onNext, this.onError, this.onComplete, this.nnn));
        }
    }

    /* loaded from: classes7.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final io.reactivex.c.a nnn;
        final io.reactivex.c.a onComplete;
        final io.reactivex.c.g<? super Throwable> onError;
        final io.reactivex.c.g<? super T> onNext;

        b(org.a.c<? super T> cVar, io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
            super(cVar);
            this.onNext = gVar;
            this.onError = gVar2;
            this.onComplete = aVar;
            this.nnn = aVar2;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.actual.onNext(t);
                } catch (Throwable th) {
                    M(th);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.b, org.a.c
        public void onError(Throwable th) {
            boolean z;
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            try {
                this.onError.accept(th);
                z = true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.L(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.nnn.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.L(th3);
                io.reactivex.e.a.onError(th3);
            }
        }

        @Override // io.reactivex.internal.subscribers.b, org.a.c
        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.actual.onComplete();
                    try {
                        this.nnn.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        io.reactivex.e.a.onError(th);
                    }
                } catch (Throwable th2) {
                    M(th2);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return JG(i);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.onNext.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.L(th);
                            this.onError.accept(th);
                            throw ExceptionHelper.O(th);
                        } finally {
                            this.nnn.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.L(th2);
                try {
                    this.onError.accept(th2);
                    throw ExceptionHelper.O(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final io.reactivex.c.a nnn;
        final io.reactivex.c.a onComplete;
        final io.reactivex.c.g<? super Throwable> onError;
        final io.reactivex.c.g<? super T> onNext;

        a(io.reactivex.internal.a.a<? super T> aVar, io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3) {
            super(aVar);
            this.onNext = gVar;
            this.onError = gVar2;
            this.onComplete = aVar2;
            this.nnn = aVar3;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.actual.onNext(t);
                } catch (Throwable th) {
                    M(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                this.onNext.accept(t);
                return this.actual.tryOnNext(t);
            } catch (Throwable th) {
                M(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.a, org.a.c
        public void onError(Throwable th) {
            boolean z;
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            try {
                this.onError.accept(th);
                z = true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.L(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.nnn.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.L(th3);
                io.reactivex.e.a.onError(th3);
            }
        }

        @Override // io.reactivex.internal.subscribers.a, org.a.c
        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.actual.onComplete();
                    try {
                        this.nnn.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        io.reactivex.e.a.onError(th);
                    }
                } catch (Throwable th2) {
                    M(th2);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return JG(i);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.onNext.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.L(th);
                            this.onError.accept(th);
                            throw ExceptionHelper.O(th);
                        } finally {
                            this.nnn.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.L(th2);
                try {
                    this.onError.accept(th2);
                    throw ExceptionHelper.O(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }
}
