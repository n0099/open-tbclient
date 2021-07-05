package io.reactivex.disposables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean disposed;
    public OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(@NonNull Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, disposable)) == null) {
            ObjectHelper.requireNonNull(disposable, "d is null");
            if (!this.disposed) {
                synchronized (this) {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>();
                            this.resources = openHashSet;
                        }
                        openHashSet.add(disposable);
                        return true;
                    }
                }
            }
            disposable.dispose();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean addAll(@NonNull Disposable... disposableArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposableArr)) == null) {
            ObjectHelper.requireNonNull(disposableArr, "ds is null");
            if (!this.disposed) {
                synchronized (this) {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>(disposableArr.length + 1);
                            this.resources = openHashSet;
                        }
                        for (Disposable disposable : disposableArr) {
                            ObjectHelper.requireNonNull(disposable, "d is null");
                            openHashSet.add(disposable);
                        }
                        return true;
                    }
                }
            }
            for (Disposable disposable2 : disposableArr) {
                disposable2.dispose();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            OpenHashSet<Disposable> openHashSet = this.resources;
            this.resources = null;
            dispose(openHashSet);
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(@NonNull Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, disposable)) == null) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            if (this.disposed) {
                return false;
            }
            synchronized (this) {
                if (this.disposed) {
                    return false;
                }
                OpenHashSet<Disposable> openHashSet = this.resources;
                if (openHashSet != null && openHashSet.remove(disposable)) {
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            OpenHashSet<Disposable> openHashSet = this.resources;
            this.resources = null;
            dispose(openHashSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.disposed : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(@NonNull Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, disposable)) == null) {
            if (delete(disposable)) {
                disposable.dispose();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.disposed) {
                return 0;
            }
            synchronized (this) {
                if (this.disposed) {
                    return 0;
                }
                OpenHashSet<Disposable> openHashSet = this.resources;
                return openHashSet != null ? openHashSet.size() : 0;
            }
        }
        return invokeV.intValue;
    }

    public CompositeDisposable(@NonNull Disposable... disposableArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {disposableArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        ObjectHelper.requireNonNull(disposableArr, "resources is null");
        this.resources = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public CompositeDisposable(@NonNull Iterable<? extends Disposable> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ObjectHelper.requireNonNull(iterable, "resources is null");
        this.resources = new OpenHashSet<>();
        for (Disposable disposable : iterable) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public void dispose(OpenHashSet<Disposable> openHashSet) {
        Object[] keys;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, openHashSet) == null) || openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.keys()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
