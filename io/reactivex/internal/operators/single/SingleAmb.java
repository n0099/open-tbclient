package io.reactivex.internal.operators.single;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleAmb<T> extends Single<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SingleSource<? extends T>[] sources;
    public final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    /* loaded from: classes9.dex */
    public static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1944085461036028108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver<? super T> s;
        public final CompositeDisposable set;

        public AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, compositeDisposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = singleObserver;
            this.set = compositeDisposable;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (compareAndSet(false, true)) {
                    this.set.dispose();
                    this.s.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposable) == null) {
                this.set.add(disposable);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) && compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSourceArr, iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            SingleSource<? extends T>[] singleSourceArr = this.sources;
            if (singleSourceArr == null) {
                singleSourceArr = new SingleSource[8];
                try {
                    length = 0;
                    for (SingleSource<? extends T> singleSource : this.sourcesIterable) {
                        if (singleSource == null) {
                            EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                            return;
                        }
                        if (length == singleSourceArr.length) {
                            SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                            System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                            singleSourceArr = singleSourceArr2;
                        }
                        int i2 = length + 1;
                        singleSourceArr[length] = singleSource;
                        length = i2;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, singleObserver);
                    return;
                }
            } else {
                length = singleSourceArr.length;
            }
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            AmbSingleObserver ambSingleObserver = new AmbSingleObserver(singleObserver, compositeDisposable);
            singleObserver.onSubscribe(compositeDisposable);
            for (int i3 = 0; i3 < length; i3++) {
                SingleSource<? extends T> singleSource2 = singleSourceArr[i3];
                if (ambSingleObserver.get()) {
                    return;
                }
                if (singleSource2 == null) {
                    compositeDisposable.dispose();
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (ambSingleObserver.compareAndSet(false, true)) {
                        singleObserver.onError(nullPointerException);
                        return;
                    } else {
                        RxJavaPlugins.onError(nullPointerException);
                        return;
                    }
                }
                singleSource2.subscribe(ambSingleObserver);
            }
        }
    }
}
