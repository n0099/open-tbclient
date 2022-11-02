package io.reactivex.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes8.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final BehaviorDisposable[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final BehaviorDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public long index;
    public final ReadWriteLock lock;
    public final Lock readLock;
    public final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    public final AtomicReference<Throwable> terminalEvent;
    public final AtomicReference<Object> value;
    public final Lock writeLock;

    /* loaded from: classes8.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public volatile boolean cancelled;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList<Object> queue;
        public final BehaviorSubject<T> state;

        public BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, behaviorSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.state = behaviorSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        public void emitLoop() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                while (!this.cancelled) {
                    synchronized (this) {
                        appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                    }
                    appendOnlyLinkedArrayList.forEachWhile(this);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        public void emitFirst() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorSubject<T> behaviorSubject = this.state;
                Lock lock = behaviorSubject.readLock;
                lock.lock();
                this.index = behaviorSubject.index;
                Object obj = behaviorSubject.value.get();
                lock.unlock();
                if (obj != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.emitting = z;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        public void emitNext(Object obj, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLJ(1048579, this, obj, j) != null) || this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (!this.cancelled && !NotificationLite.accept(obj, this.actual)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310792924, "Lio/reactivex/subjects/BehaviorSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310792924, "Lio/reactivex/subjects/BehaviorSubject;");
                return;
            }
        }
        EMPTY_ARRAY = new Object[0];
        EMPTY = new BehaviorDisposable[0];
        TERMINATED = new BehaviorDisposable[0];
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new BehaviorSubject<>();
        }
        return (BehaviorSubject) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.value.get();
            if (NotificationLite.isError(obj)) {
                return NotificationLite.getError(obj);
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Nullable
    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.value.get();
            if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                return (T) NotificationLite.getValue(obj);
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.subjects.BehaviorSubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            if (values == EMPTY_ARRAY) {
                return new Object[0];
            }
            return values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return NotificationLite.isComplete(this.value.get());
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.subscribers.get().length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return NotificationLite.isError(this.value.get());
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object obj = this.value.get();
            if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            return;
        }
        Object complete = NotificationLite.complete();
        for (BehaviorDisposable<T> behaviorDisposable : terminate(complete)) {
            behaviorDisposable.emitNext(complete, this.index);
        }
    }

    public int subscriberCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.subscribers.get().length;
        }
        return invokeV.intValue;
    }

    public BehaviorSubject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
        this.terminalEvent = new AtomicReference<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BehaviorSubject(T t) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.terminalEvent.compareAndSet(null, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            Object error = NotificationLite.error(th);
            for (BehaviorDisposable<T> behaviorDisposable : terminate(error)) {
                behaviorDisposable.emitNext(error, this.index);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.terminalEvent.get() != null) {
                return;
            }
            Object next = NotificationLite.next(t);
            setCurrent(next);
            for (BehaviorDisposable<T> behaviorDisposable : this.subscribers.get()) {
                behaviorDisposable.emitNext(next, this.index);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, observer) == null) {
            BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
            observer.onSubscribe(behaviorDisposable);
            if (add(behaviorDisposable)) {
                if (behaviorDisposable.cancelled) {
                    remove(behaviorDisposable);
                    return;
                } else {
                    behaviorDisposable.emitFirst();
                    return;
                }
            }
            Throwable th = this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        }
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return new BehaviorSubject<>(t);
        }
        return (BehaviorSubject) invokeL.objValue;
    }

    public boolean add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable<T>[] behaviorDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, behaviorDisposable)) == null) {
            do {
                behaviorDisposableArr = this.subscribers.get();
                if (behaviorDisposableArr == TERMINATED) {
                    return false;
                }
                int length = behaviorDisposableArr.length;
                behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
                behaviorDisposableArr2[length] = behaviorDisposable;
            } while (!this.subscribers.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, disposable) == null) && this.terminalEvent.get() != null) {
            disposable.dispose();
        }
    }

    public void setCurrent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, obj) == null) {
            this.writeLock.lock();
            this.index++;
            this.value.lazySet(obj);
            this.writeLock.unlock();
        }
    }

    public BehaviorDisposable<T>[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            BehaviorDisposable<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
            if (andSet != TERMINATED) {
                setCurrent(obj);
            }
            return andSet;
        }
        return (BehaviorDisposable[]) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
            Object obj = this.value.get();
            if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                Object value = NotificationLite.getValue(obj);
                if (tArr.length != 0) {
                    tArr[0] = value;
                    if (tArr.length != 1) {
                        tArr[1] = 0;
                        return tArr;
                    }
                    return tArr;
                }
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = value;
                return tArr2;
            }
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.BehaviorSubject$BehaviorDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, behaviorDisposable) == null) {
            do {
                behaviorDisposableArr = this.subscribers.get();
                int length = behaviorDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (behaviorDisposableArr[i2] == behaviorDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    behaviorDisposableArr2 = EMPTY;
                } else {
                    BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                    System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                    System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                    behaviorDisposableArr2 = behaviorDisposableArr3;
                }
            } while (!this.subscribers.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
        }
    }
}
