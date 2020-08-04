package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class c<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final io.reactivex.c.a nSZ;
    final io.reactivex.c.a onComplete;
    final io.reactivex.c.g<? super Throwable> onError;
    final io.reactivex.c.g<? super T> onNext;

    public c(io.reactivex.g<T> gVar, io.reactivex.c.g<? super T> gVar2, io.reactivex.c.g<? super Throwable> gVar3, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        super(gVar);
        this.onNext = gVar2;
        this.onError = gVar3;
        this.onComplete = aVar;
        this.nSZ = aVar2;
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.nSG.a((j) new a((io.reactivex.internal.a.a) cVar, this.onNext, this.onError, this.onComplete, this.nSZ));
        } else {
            this.nSG.a((j) new b(cVar, this.onNext, this.onError, this.onComplete, this.nSZ));
        }
    }

    /* loaded from: classes7.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final io.reactivex.c.a nSZ;
        final io.reactivex.c.a onComplete;
        final io.reactivex.c.g<? super Throwable> onError;
        final io.reactivex.c.g<? super T> onNext;

        b(org.a.c<? super T> cVar, io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
            super(cVar);
            this.onNext = gVar;
            this.onError = gVar2;
            this.onComplete = aVar;
            this.nSZ = aVar2;
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
                    L(th);
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
                io.reactivex.exceptions.a.K(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.nSZ.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.K(th3);
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
                        this.nSZ.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.K(th);
                        io.reactivex.e.a.onError(th);
                    }
                } catch (Throwable th2) {
                    L(th2);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return Lj(i);
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
                            io.reactivex.exceptions.a.K(th);
                            this.onError.accept(th);
                            throw ExceptionHelper.N(th);
                        } finally {
                            this.nSZ.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.K(th2);
                try {
                    this.onError.accept(th2);
                    throw ExceptionHelper.N(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final io.reactivex.c.a nSZ;
        final io.reactivex.c.a onComplete;
        final io.reactivex.c.g<? super Throwable> onError;
        final io.reactivex.c.g<? super T> onNext;

        a(io.reactivex.internal.a.a<? super T> aVar, io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3) {
            super(aVar);
            this.onNext = gVar;
            this.onError = gVar2;
            this.onComplete = aVar2;
            this.nSZ = aVar3;
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
                    L(th);
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
                L(th);
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
                io.reactivex.exceptions.a.K(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.nSZ.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.K(th3);
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
                        this.nSZ.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.K(th);
                        io.reactivex.e.a.onError(th);
                    }
                } catch (Throwable th2) {
                    L(th2);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return Lj(i);
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
                            io.reactivex.exceptions.a.K(th);
                            this.onError.accept(th);
                            throw ExceptionHelper.N(th);
                        } finally {
                            this.nSZ.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.K(th2);
                try {
                    this.onError.accept(th2);
                    throw ExceptionHelper.N(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }
}
