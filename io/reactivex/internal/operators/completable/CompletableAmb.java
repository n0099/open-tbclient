package io.reactivex.internal.operators.completable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class CompletableAmb extends Completable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CompletableSource[] sources;
    public final Iterable<? extends CompletableSource> sourcesIterable;

    /* loaded from: classes3.dex */
    public static final class Amb implements CompletableObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean once;
        public final CompletableObserver s;
        public final CompositeDisposable set;

        public Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicBoolean, compositeDisposable, completableObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.once = atomicBoolean;
            this.set = compositeDisposable;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.once.compareAndSet(false, true)) {
                    this.set.dispose();
                    this.s.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                this.set.add(disposable);
            }
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {completableSourceArr, iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = completableSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, completableObserver) == null) {
            CompletableSource[] completableSourceArr = this.sources;
            if (completableSourceArr == null) {
                completableSourceArr = new CompletableSource[8];
                try {
                    length = 0;
                    for (CompletableSource completableSource : this.sourcesIterable) {
                        if (completableSource == null) {
                            EmptyDisposable.error(new NullPointerException("One of the sources is null"), completableObserver);
                            return;
                        }
                        if (length == completableSourceArr.length) {
                            CompletableSource[] completableSourceArr2 = new CompletableSource[(length >> 2) + length];
                            System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                            completableSourceArr = completableSourceArr2;
                        }
                        int i2 = length + 1;
                        completableSourceArr[length] = completableSource;
                        length = i2;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, completableObserver);
                    return;
                }
            } else {
                length = completableSourceArr.length;
            }
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            completableObserver.onSubscribe(compositeDisposable);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            Amb amb = new Amb(atomicBoolean, compositeDisposable, completableObserver);
            for (int i3 = 0; i3 < length; i3++) {
                CompletableSource completableSource2 = completableSourceArr[i3];
                if (compositeDisposable.isDisposed()) {
                    return;
                }
                if (completableSource2 == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeDisposable.dispose();
                        completableObserver.onError(nullPointerException);
                        return;
                    }
                    RxJavaPlugins.onError(nullPointerException);
                    return;
                }
                completableSource2.subscribe(amb);
            }
            if (length == 0) {
                completableObserver.onComplete();
            }
        }
    }
}
