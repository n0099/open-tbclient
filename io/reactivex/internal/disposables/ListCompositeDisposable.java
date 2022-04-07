package io.reactivex.internal.disposables;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean disposed;
    public List<Disposable> resources;

    public ListCompositeDisposable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, disposable)) == null) {
            ObjectHelper.requireNonNull(disposable, "d is null");
            if (!this.disposed) {
                synchronized (this) {
                    if (!this.disposed) {
                        List list = this.resources;
                        if (list == null) {
                            list = new LinkedList();
                            this.resources = list;
                        }
                        list.add(disposable);
                        return true;
                    }
                }
            }
            disposable.dispose();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean addAll(Disposable... disposableArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposableArr)) == null) {
            ObjectHelper.requireNonNull(disposableArr, "ds is null");
            if (!this.disposed) {
                synchronized (this) {
                    if (!this.disposed) {
                        List list = this.resources;
                        if (list == null) {
                            list = new LinkedList();
                            this.resources = list;
                        }
                        for (Disposable disposable : disposableArr) {
                            ObjectHelper.requireNonNull(disposable, "d is null");
                            list.add(disposable);
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
            List<Disposable> list = this.resources;
            this.resources = null;
            dispose(list);
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable disposable) {
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
                List<Disposable> list = this.resources;
                if (list != null && list.remove(disposable)) {
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
            List<Disposable> list = this.resources;
            this.resources = null;
            dispose(list);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.disposed : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable disposable) {
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

    public ListCompositeDisposable(Disposable... disposableArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {disposableArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        ObjectHelper.requireNonNull(disposableArr, "resources is null");
        this.resources = new LinkedList();
        for (Disposable disposable : disposableArr) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ObjectHelper.requireNonNull(iterable, "resources is null");
        this.resources = new LinkedList();
        for (Disposable disposable : iterable) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public void dispose(List<Disposable> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Disposable disposable : list) {
            try {
                disposable.dispose();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
