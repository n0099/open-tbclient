package io.reactivex.observers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public abstract class ResourceCompletableObserver implements CompletableObserver, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ListCompositeDisposable resources;
    public final AtomicReference<Disposable> s;

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public ResourceCompletableObserver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new AtomicReference<>();
        this.resources = new ListCompositeDisposable();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && DisposableHelper.dispose(this.s)) {
            this.resources.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return DisposableHelper.isDisposed(this.s.get());
        }
        return invokeV.booleanValue;
    }

    public final void add(@NonNull Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, disposable) == null) {
            ObjectHelper.requireNonNull(disposable, "resource is null");
            this.resources.add(disposable);
        }
    }

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(@NonNull Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) && EndConsumerHelper.setOnce(this.s, disposable, ResourceCompletableObserver.class)) {
            onStart();
        }
    }
}
