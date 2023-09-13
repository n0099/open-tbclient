package org.chromium.base;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x8c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.chromium.base.Promise;
/* loaded from: classes2.dex */
public class Promise<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public Exception mRejectReason;
    public T mResult;
    public boolean mThrowingRejectionHandler;
    public int mState = 0;
    public final List<Callback<T>> mFulfillCallbacks = new LinkedList();
    public final List<Callback<Exception>> mRejectCallbacks = new LinkedList();
    public final Thread mThread = Thread.currentThread();
    public final Handler mHandler = new Handler();

    /* loaded from: classes2.dex */
    public interface AsyncFunction<A, RT> extends Function<A, Promise<RT>> {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    private void checkThread() {
    }

    /* loaded from: classes2.dex */
    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static <T> Promise<T> rejected() {
        Promise<T> promise = new Promise<>();
        promise.reject();
        return promise;
    }

    public T getResult() {
        return this.mResult;
    }

    public boolean isFulfilled() {
        checkThread();
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    public boolean isRejected() {
        checkThread();
        if (this.mState == 2) {
            return true;
        }
        return false;
    }

    public void reject() {
        reject(null);
    }

    public static /* synthetic */ void a(Exception exc) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", exc);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.chromium.base.Callback<java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> callback) {
        int i = this.mState;
        if (i == 2) {
            postCallbackToLooper(callback, this.mRejectReason);
        } else if (i == 0) {
            this.mRejectCallbacks.add(callback);
        }
    }

    public static <T> Promise<T> fulfilled(T t) {
        Promise<T> promise = new Promise<>();
        promise.fulfill(t);
        return promise;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.chromium.base.Callback<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> callback) {
        int i = this.mState;
        if (i == 1) {
            postCallbackToLooper(callback, this.mResult);
        } else if (i == 0) {
            this.mFulfillCallbacks.add(callback);
        }
    }

    public void except(Callback<Exception> callback) {
        checkThread();
        exceptInner(callback);
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: org.chromium.base.Callback<T>, org.chromium.base.Callback<S> */
    public void fulfill(T t) {
        checkThread();
        this.mState = 1;
        this.mResult = t;
        Iterator<Callback<T>> it = this.mFulfillCallbacks.iterator();
        while (it.hasNext()) {
            postCallbackToLooper((Callback<T>) it.next(), t);
        }
        this.mFulfillCallbacks.clear();
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: org.chromium.base.Callback<java.lang.Exception>, org.chromium.base.Callback<S> */
    public void reject(Exception exc) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = exc;
        Iterator<Callback<Exception>> it = this.mRejectCallbacks.iterator();
        while (it.hasNext()) {
            postCallbackToLooper(it.next(), exc);
        }
        this.mRejectCallbacks.clear();
    }

    public <RT> Promise<RT> then(final Function<T, RT> function) {
        checkThread();
        final Promise<RT> promise = new Promise<>();
        thenInner(new Callback() { // from class: com.baidu.tieba.r8c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.chromium.base.Callback
            public /* synthetic */ Runnable bind(T t) {
                return y8c.$default$bind(this, t);
            }

            @Override // org.chromium.base.Callback
            public final void onResult(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    Promise.b(Promise.this, function, obj);
                }
            }
        });
        exceptInner(new x8c(promise));
        return promise;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.chromium.base.Promise */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(Promise promise, Function function, Object obj) {
        try {
            promise.fulfill(function.apply(obj));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public static /* synthetic */ void c(AsyncFunction asyncFunction, final Promise promise, Object obj) {
        try {
            Objects.requireNonNull(promise);
            Callback<T> callback = new Callback() { // from class: com.baidu.tieba.m8c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // org.chromium.base.Callback
                public /* synthetic */ Runnable bind(T t) {
                    return y8c.$default$bind(this, t);
                }

                @Override // org.chromium.base.Callback
                public final void onResult(Object obj2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj2) == null) {
                        Promise.this.fulfill(obj2);
                    }
                }
            };
            Objects.requireNonNull(promise);
            asyncFunction.apply(obj).then(callback, new x8c(promise));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    private <S> void postCallbackToLooper(Callback<S> callback, S s) {
        this.mHandler.post(callback.bind(s));
    }

    public void then(Callback<T> callback, Callback<Exception> callback2) {
        checkThread();
        thenInner(callback);
        exceptInner(callback2);
    }

    public <RT> Promise<RT> then(final AsyncFunction<T, RT> asyncFunction) {
        checkThread();
        final Promise<RT> promise = new Promise<>();
        thenInner(new Callback() { // from class: com.baidu.tieba.s8c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.chromium.base.Callback
            public /* synthetic */ Runnable bind(T t) {
                return y8c.$default$bind(this, t);
            }

            @Override // org.chromium.base.Callback
            public final void onResult(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    Promise.c(Promise.AsyncFunction.this, promise, obj);
                }
            }
        });
        exceptInner(new x8c(promise));
        return promise;
    }

    public void then(Callback<T> callback) {
        checkThread();
        if (this.mThrowingRejectionHandler) {
            thenInner(callback);
            return;
        }
        then(callback, new Callback() { // from class: com.baidu.tieba.q8c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.chromium.base.Callback
            public /* synthetic */ Runnable bind(T t) {
                return y8c.$default$bind(this, t);
            }

            @Override // org.chromium.base.Callback
            public final void onResult(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    Promise.a((Exception) obj);
                    throw null;
                }
            }
        });
        this.mThrowingRejectionHandler = true;
    }
}
