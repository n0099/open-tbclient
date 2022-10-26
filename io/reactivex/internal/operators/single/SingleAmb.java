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
/* loaded from: classes8.dex */
public final class SingleAmb extends Single {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SingleSource[] sources;
    public final Iterable sourcesIterable;

    /* loaded from: classes8.dex */
    public final class AmbSingleObserver extends AtomicBoolean implements SingleObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1944085461036028108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver s;
        public final CompositeDisposable set;

        public AmbSingleObserver(SingleObserver singleObserver, CompositeDisposable compositeDisposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, compositeDisposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(obj);
            }
        }
    }

    public SingleAmb(SingleSource[] singleSourceArr, Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSourceArr, iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            SingleSource[] singleSourceArr = this.sources;
            if (singleSourceArr == null) {
                singleSourceArr = new SingleSource[8];
                try {
                    length = 0;
                    for (SingleSource singleSource : this.sourcesIterable) {
                        if (singleSource == null) {
                            EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                            return;
                        }
                        if (length == singleSourceArr.length) {
                            SingleSource[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                            System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                            singleSourceArr = singleSourceArr2;
                        }
                        int i = length + 1;
                        singleSourceArr[length] = singleSource;
                        length = i;
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
            for (int i2 = 0; i2 < length; i2++) {
                SingleSource singleSource2 = singleSourceArr[i2];
                if (ambSingleObserver.get()) {
                    return;
                }
                if (singleSource2 == null) {
                    compositeDisposable.dispose();
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
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
