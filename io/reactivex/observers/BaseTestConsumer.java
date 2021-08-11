package io.reactivex.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Notification;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean checkSubscriptionOnce;
    public long completions;
    public final CountDownLatch done;
    public final List<Throwable> errors;
    public int establishedFusionMode;
    public int initialFusionMode;
    public Thread lastThread;
    public CharSequence tag;
    public boolean timeout;
    public final List<T> values;

    /* renamed from: io.reactivex.observers.BaseTestConsumer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static abstract class TestWaitStrategy implements Runnable {
        public static final /* synthetic */ TestWaitStrategy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TestWaitStrategy SLEEP_1000MS;
        public static final TestWaitStrategy SLEEP_100MS;
        public static final TestWaitStrategy SLEEP_10MS;
        public static final TestWaitStrategy SLEEP_1MS;
        public static final TestWaitStrategy SPIN;
        public static final TestWaitStrategy YIELD;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1275084949, "Lio/reactivex/observers/BaseTestConsumer$TestWaitStrategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1275084949, "Lio/reactivex/observers/BaseTestConsumer$TestWaitStrategy;");
                    return;
                }
            }
            SPIN = new TestWaitStrategy("SPIN", 0) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }
            };
            YIELD = new TestWaitStrategy("YIELD", 1) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Thread.yield();
                    }
                }
            };
            SLEEP_1MS = new TestWaitStrategy("SLEEP_1MS", 2) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TestWaitStrategy.sleep(1);
                    }
                }
            };
            SLEEP_10MS = new TestWaitStrategy("SLEEP_10MS", 3) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TestWaitStrategy.sleep(10);
                    }
                }
            };
            SLEEP_100MS = new TestWaitStrategy("SLEEP_100MS", 4) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TestWaitStrategy.sleep(100);
                    }
                }
            };
            TestWaitStrategy testWaitStrategy = new TestWaitStrategy("SLEEP_1000MS", 5) { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (AnonymousClass1) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TestWaitStrategy.sleep(1000);
                    }
                }
            };
            SLEEP_1000MS = testWaitStrategy;
            $VALUES = new TestWaitStrategy[]{SPIN, YIELD, SLEEP_1MS, SLEEP_10MS, SLEEP_100MS, testWaitStrategy};
        }

        public TestWaitStrategy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static void sleep(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
                try {
                    Thread.sleep(i2);
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        public static TestWaitStrategy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TestWaitStrategy) Enum.valueOf(TestWaitStrategy.class, str) : (TestWaitStrategy) invokeL.objValue;
        }

        public static TestWaitStrategy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (TestWaitStrategy[]) $VALUES.clone() : (TestWaitStrategy[]) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public abstract void run();

        public /* synthetic */ TestWaitStrategy(String str, int i2, AnonymousClass1 anonymousClass1) {
            this(str, i2);
        }
    }

    public BaseTestConsumer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.values = new VolatileSizeArrayList();
        this.errors = new VolatileSizeArrayList();
        this.done = new CountDownLatch(1);
    }

    public static String valueAndClass(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj != null) {
                return obj + " (class: " + obj.getClass().getSimpleName() + SmallTailInfo.EMOTION_SUFFIX;
            }
            return StringUtil.NULL_STRING;
        }
        return (String) invokeL.objValue;
    }

    public final U assertComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.completions;
            if (j2 != 0) {
                if (j2 <= 1) {
                    return this;
                }
                throw fail("Multiple completions: " + j2);
            }
            throw fail("Not completed");
        }
        return (U) invokeV.objValue;
    }

    public final U assertEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete() : (U) invokeV.objValue;
    }

    public final U assertError(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, th)) == null) ? assertError(Functions.equalsWith(th)) : (U) invokeL.objValue;
    }

    public final U assertErrorMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            int size = this.errors.size();
            if (size != 0) {
                if (size == 1) {
                    String message = this.errors.get(0).getMessage();
                    if (ObjectHelper.equals(str, message)) {
                        return this;
                    }
                    throw fail("Error message differs; Expected: " + str + ", Actual: " + message);
                }
                throw fail("Multiple errors");
            }
            throw fail("No errors");
        }
        return (U) invokeL.objValue;
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cls, tArr)) == null) ? (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete() : (U) invokeLL.objValue;
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, str, tArr)) == null) ? (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete() : (U) invokeLLL.objValue;
    }

    public final U assertNever(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, t)) == null) {
            int size = this.values.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (ObjectHelper.equals(this.values.get(i2), t)) {
                    throw fail("Value at position " + i2 + " is equal to " + valueAndClass(t) + "; Expected them to be different");
                }
            }
            return this;
        }
        return (U) invokeL.objValue;
    }

    public final U assertNoErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.errors.size() == 0) {
                return this;
            }
            throw fail("Error(s) present: " + this.errors);
        }
        return (U) invokeV.objValue;
    }

    public final U assertNoTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.timeout) {
                throw fail("Timeout?!");
            }
            return this;
        }
        return (U) invokeV.objValue;
    }

    public final U assertNoValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? assertValueCount(0) : (U) invokeV.objValue;
    }

    public final U assertNotComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j2 = this.completions;
            int i2 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
            if (i2 != 0) {
                if (i2 <= 0) {
                    return this;
                }
                throw fail("Multiple completions: " + j2);
            }
            throw fail("Completed!");
        }
        return (U) invokeV.objValue;
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.done.getCount() != 0) {
                return this;
            }
            throw fail("Subscriber terminated!");
        }
        return (U) invokeV.objValue;
    }

    public final U assertResult(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, tArr)) == null) ? (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete() : (U) invokeL.objValue;
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.done.getCount() == 0) {
                long j2 = this.completions;
                if (j2 <= 1) {
                    int size = this.errors.size();
                    if (size > 1) {
                        throw fail("Terminated with multiple errors: " + size);
                    } else if (j2 == 0 || size == 0) {
                        return this;
                    } else {
                        throw fail("Terminated with multiple completions and errors: " + j2);
                    }
                }
                throw fail("Terminated with multiple completions: " + j2);
            }
            throw fail("Subscriber still running!");
        }
        return (U) invokeV.objValue;
    }

    public final U assertTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.timeout) {
                return this;
            }
            throw fail("No timeout?!");
        }
        return (U) invokeV.objValue;
    }

    public final U assertValue(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, t)) == null) {
            if (this.values.size() == 1) {
                T t2 = this.values.get(0);
                if (ObjectHelper.equals(t, t2)) {
                    return this;
                }
                throw fail("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
            }
            throw fail("Expected: " + valueAndClass(t) + ", Actual: " + this.values);
        }
        return (U) invokeL.objValue;
    }

    @Experimental
    public final U assertValueAt(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i2, t)) == null) {
            int size = this.values.size();
            if (size != 0) {
                if (i2 < size) {
                    T t2 = this.values.get(i2);
                    if (ObjectHelper.equals(t, t2)) {
                        return this;
                    }
                    throw fail("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
                }
                throw fail("Invalid index: " + i2);
            }
            throw fail("No values");
        }
        return (U) invokeIL.objValue;
    }

    public final U assertValueCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            int size = this.values.size();
            if (size == i2) {
                return this;
            }
            throw fail("Value counts differ; Expected: " + i2 + ", Actual: " + size);
        }
        return (U) invokeI.objValue;
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        boolean hasNext;
        boolean hasNext2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, iterable)) == null) {
            Iterator<T> it = this.values.iterator();
            Iterator<? extends T> it2 = iterable.iterator();
            int i2 = 0;
            while (true) {
                hasNext = it2.hasNext();
                hasNext2 = it.hasNext();
                if (!hasNext2 || !hasNext) {
                    break;
                }
                T next = it2.next();
                T next2 = it.next();
                if (!ObjectHelper.equals(next, next2)) {
                    throw fail("Values at position " + i2 + " differ; Expected: " + valueAndClass(next) + ", Actual: " + valueAndClass(next2));
                }
                i2++;
            }
            if (hasNext2) {
                throw fail("More values received than expected (" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            } else if (hasNext) {
                throw fail("Fewer values received than expected (" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                return this;
            }
        }
        return (U) invokeL.objValue;
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, collection)) == null) {
            if (collection.isEmpty()) {
                assertNoValues();
                return this;
            }
            for (T t : this.values) {
                if (!collection.contains(t)) {
                    throw fail("Value not in the expected collection: " + valueAndClass(t));
                }
            }
            return this;
        }
        return (U) invokeL.objValue;
    }

    public final U assertValues(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, tArr)) == null) {
            int size = this.values.size();
            if (size != tArr.length) {
                throw fail("Value count differs; Expected: " + tArr.length + " " + Arrays.toString(tArr) + ", Actual: " + size + " " + this.values);
            }
            for (int i2 = 0; i2 < size; i2++) {
                T t = this.values.get(i2);
                T t2 = tArr[i2];
                if (!ObjectHelper.equals(t2, t)) {
                    throw fail("Values at position " + i2 + " differ; Expected: " + valueAndClass(t2) + ", Actual: " + valueAndClass(t));
                }
            }
            return this;
        }
        return (U) invokeL.objValue;
    }

    @Experimental
    public final U assertValuesOnly(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, tArr)) == null) ? (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete() : (U) invokeL.objValue;
    }

    public final U await() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.done.getCount() == 0) {
                return this;
            }
            this.done.await();
            return this;
        }
        return (U) invokeV.objValue;
    }

    public final U awaitCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) ? awaitCount(i2, TestWaitStrategy.SLEEP_10MS, 5000L) : (U) invokeI.objValue;
    }

    public final U awaitDone(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048611, this, j2, timeUnit)) == null) {
            try {
                if (!this.done.await(j2, timeUnit)) {
                    this.timeout = true;
                    dispose();
                }
                return this;
            } catch (InterruptedException e2) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e2);
            }
        }
        return (U) invokeJL.objValue;
    }

    public final boolean awaitTerminalEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            try {
                await();
                return true;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final U clearTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            this.timeout = false;
            return this;
        }
        return (U) invokeV.objValue;
    }

    public final long completions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.completions : invokeV.longValue;
    }

    public final int errorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.errors.size() : invokeV.intValue;
    }

    public final List<Throwable> errors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.errors : (List) invokeV.objValue;
    }

    public final AssertionError fail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            StringBuilder sb = new StringBuilder(str.length() + 64);
            sb.append(str);
            sb.append(" (");
            sb.append("latch = ");
            sb.append(this.done.getCount());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("values = ");
            sb.append(this.values.size());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errors = ");
            sb.append(this.errors.size());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("completions = ");
            sb.append(this.completions);
            if (this.timeout) {
                sb.append(", timeout!");
            }
            if (isDisposed()) {
                sb.append(", disposed!");
            }
            CharSequence charSequence = this.tag;
            if (charSequence != null) {
                sb.append(", tag = ");
                sb.append(charSequence);
            }
            sb.append(')');
            AssertionError assertionError = new AssertionError(sb.toString());
            if (!this.errors.isEmpty()) {
                if (this.errors.size() == 1) {
                    assertionError.initCause(this.errors.get(0));
                } else {
                    assertionError.initCause(new CompositeException(this.errors));
                }
            }
            return assertionError;
        }
        return (AssertionError) invokeL.objValue;
    }

    public final List<List<Object>> getEvents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(values());
            arrayList.add(errors());
            ArrayList arrayList2 = new ArrayList();
            for (long j2 = 0; j2 < this.completions; j2++) {
                arrayList2.add(Notification.createOnComplete());
            }
            arrayList.add(arrayList2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.done.getCount() == 0 : invokeV.booleanValue;
    }

    public final boolean isTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.timeout : invokeV.booleanValue;
    }

    public final Thread lastThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.lastThread : (Thread) invokeV.objValue;
    }

    public final int valueCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.values.size() : invokeV.intValue;
    }

    public final List<T> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.values : (List) invokeV.objValue;
    }

    public final U withTag(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, charSequence)) == null) {
            this.tag = charSequence;
            return this;
        }
        return (U) invokeL.objValue;
    }

    public final U assertError(Class<? extends Throwable> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? assertError(Functions.isInstanceOf(cls)) : (U) invokeL.objValue;
    }

    public final U awaitCount(int i2, Runnable runnable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048609, this, i2, runnable)) == null) ? awaitCount(i2, runnable, 5000L) : (U) invokeIL.objValue;
    }

    public final U assertError(Predicate<Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, predicate)) == null) {
            int size = this.errors.size();
            if (size != 0) {
                boolean z = false;
                Iterator<Throwable> it = this.errors.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    try {
                        if (predicate.test(it.next())) {
                            z = true;
                            break;
                        }
                    } catch (Exception e2) {
                        throw ExceptionHelper.wrapOrThrow(e2);
                    }
                }
                if (z) {
                    if (size == 1) {
                        return this;
                    }
                    throw fail("Error present but other errors as well");
                }
                throw fail("Error not present");
            }
            throw fail("No errors");
        }
        return (U) invokeL.objValue;
    }

    public final boolean await(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048607, this, j2, timeUnit)) == null) {
            boolean z = this.done.getCount() == 0 || this.done.await(j2, timeUnit);
            this.timeout = !z;
            return z;
        }
        return invokeJL.booleanValue;
    }

    public final U awaitCount(int i2, Runnable runnable, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), runnable, Long.valueOf(j2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (j2 > 0 && System.currentTimeMillis() - currentTimeMillis >= j2) {
                    this.timeout = true;
                    break;
                } else if (this.done.getCount() == 0 || this.values.size() >= i2) {
                    break;
                } else {
                    runnable.run();
                }
            }
            return this;
        }
        return (U) invokeCommon.objValue;
    }

    public final boolean awaitTerminalEvent(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048613, this, j2, timeUnit)) == null) {
            try {
                return await(j2, timeUnit);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return invokeJL.booleanValue;
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, predicate, tArr)) == null) ? (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete() : (U) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
    public final U assertNever(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, predicate)) == null) {
            int size = this.values.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    if (predicate.test((T) this.values.get(i2))) {
                        throw fail("Value at position " + i2 + " matches predicate " + predicate.toString() + ", which was not expected.");
                    }
                } catch (Exception e2) {
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            return this;
        }
        return (U) invokeL.objValue;
    }

    public final U assertValue(Predicate<T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, predicate)) == null) {
            assertValueAt(0, (Predicate) predicate);
            if (this.values.size() <= 1) {
                return this;
            }
            throw fail("Value present but other values as well");
        }
        return (U) invokeL.objValue;
    }

    public final U assertValueAt(int i2, Predicate<T> predicate) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i2, predicate)) == null) {
            if (this.values.size() != 0) {
                if (i2 < this.values.size()) {
                    try {
                        if (predicate.test(this.values.get(i2))) {
                            return this;
                        }
                        throw fail("Value not present");
                    } catch (Exception e2) {
                        throw ExceptionHelper.wrapOrThrow(e2);
                    }
                }
                throw fail("Invalid index: " + i2);
            }
            throw fail("No values");
        }
        return (U) invokeIL.objValue;
    }
}
