package io.reactivex.internal.disposables;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes3.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2746389416410565408L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayCompositeDisposable(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (get(0) != DisposableHelper.DISPOSED) {
                int length = length();
                for (int i2 = 0; i2 < length; i2++) {
                    Disposable disposable = get(i2);
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    if (disposable != disposableHelper && (andSet = getAndSet(i2, disposableHelper)) != DisposableHelper.DISPOSED && andSet != null) {
                        andSet.dispose();
                    }
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get(0) == DisposableHelper.DISPOSED : invokeV.booleanValue;
    }

    public Disposable replaceResource(int i2, Disposable disposable) {
        Disposable disposable2;
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, disposable)) == null) {
            do {
                disposable2 = get(i2);
                if (disposable2 == DisposableHelper.DISPOSED) {
                    disposable.dispose();
                    return null;
                }
            } while (!compareAndSet(i2, disposable2, disposable));
            return disposable2;
        }
        return (Disposable) invokeIL.objValue;
    }

    public boolean setResource(int i2, Disposable disposable) {
        Disposable disposable2;
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, disposable)) == null) {
            do {
                disposable2 = get(i2);
                if (disposable2 == DisposableHelper.DISPOSED) {
                    disposable.dispose();
                    return false;
                }
            } while (!compareAndSet(i2, disposable2, disposable));
            if (disposable2 != null) {
                disposable2.dispose();
                return true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }
}
