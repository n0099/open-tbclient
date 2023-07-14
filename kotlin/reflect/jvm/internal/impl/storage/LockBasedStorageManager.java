package kotlin.reflect.jvm.internal.impl.storage;

import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes2.dex */
public class LockBasedStorageManager implements StorageManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final String debugText;
    public final ExceptionHandlingStrategy exceptionHandlingStrategy;
    public final Lock lock;
    public static final String PACKAGE_NAME = StringsKt__StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, NoLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1", "recursionDetectedDefault"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        public <T> RecursionDetectedResult<T> recursionDetectedDefault() {
            RecursionDetectedResult<T> fallThrough = RecursionDetectedResult.fallThrough();
            if (fallThrough == null) {
                $$$reportNull$$$0(0);
            }
            return fallThrough;
        }
    };

    /* loaded from: classes2.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th);
            }
        };

        RuntimeException handleException(Throwable th);
    }

    /* loaded from: classes2.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 8 || i == 12 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 8 || i == 12 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 3:
            case 6:
                objArr[0] = "exceptionHandlingStrategy";
                break;
            case 2:
            case 5:
            default:
                objArr[0] = "debugText";
                break;
            case 4:
                objArr[0] = "lock";
                break;
            case 7:
            case 9:
            case 11:
            case 13:
                objArr[0] = "compute";
                break;
            case 8:
            case 12:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
            case 10:
            case 14:
                objArr[0] = "map";
                break;
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 23:
            case 24:
            case 26:
                objArr[0] = "computable";
                break;
            case 17:
            case 19:
                objArr[0] = "onRecursiveCall";
                break;
            case 21:
            case 25:
                objArr[0] = "postCompute";
                break;
            case 27:
                objArr[0] = "throwable";
                break;
        }
        if (i == 8) {
            objArr[1] = "createMemoizedFunction";
        } else if (i == 12) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 7:
            case 9:
            case 10:
                objArr[2] = "createMemoizedFunction";
                break;
            case 8:
            case 12:
            case 28:
                break;
            case 11:
            case 13:
            case 14:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 15:
            case 16:
            case 17:
                objArr[2] = "createLazyValue";
                break;
            case 18:
            case 19:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 20:
            case 21:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 22:
                objArr[2] = "createNullableLazyValue";
                break;
            case 23:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 24:
            case 25:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 26:
                objArr[2] = "compute";
                break;
            case 27:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 8 && i != 12 && i != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* loaded from: classes2.dex */
    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }
    }

    /* loaded from: classes2.dex */
    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new Function1<KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((KeyWithComputation<K, Object>) obj);
                }

                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return (V) keyWithComputation.computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k, function0));
        }
    }

    /* loaded from: classes2.dex */
    public static class KeyWithComputation<K, V> {
        public final Function0<? extends V> computation;
        public final K key;

        public KeyWithComputation(K k, Function0<? extends V> function0) {
            this.key = k;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && KeyWithComputation.class == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        public final Function0<? extends T> computable;
        public final LockBasedStorageManager storageManager;
        public volatile Object value;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public void postCompute(T t) {
        }

        public LockBasedLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.value;
                if (!(obj2 instanceof NotValue)) {
                    invoke = (T) WrappedValues.unescapeThrowable(obj2);
                } else {
                    if (obj2 == NotValue.COMPUTING) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult<T> recursionDetected = recursionDetected(true);
                        if (!recursionDetected.isFallThrough()) {
                            invoke = recursionDetected.getValue();
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult<T> recursionDetected2 = recursionDetected(false);
                        if (!recursionDetected2.isFallThrough()) {
                            invoke = recursionDetected2.getValue();
                        }
                    }
                    this.value = NotValue.COMPUTING;
                    invoke = this.computable.invoke();
                    postCompute(invoke);
                    this.value = invoke;
                }
                return invoke;
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED && this.value != NotValue.COMPUTING) {
                return true;
            }
            return false;
        }

        public RecursionDetectedResult<T> recursionDetected(boolean z) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault();
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        public volatile SingleThreadValue<T> valuePostCompute;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public abstract void doPostCompute(T t);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue != null && singleThreadValue.hasValue()) {
                return singleThreadValue.getValue();
            }
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public final void postCompute(T t) {
            this.valuePostCompute = new SingleThreadValue<>(t);
            try {
                doPostCompute(t);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST;
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST;
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    /* loaded from: classes2.dex */
    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        public final ConcurrentMap<K, Object> cache;
        public final Function1<? super K, ? extends V> compute;
        public final LockBasedStorageManager storageManager;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        private AssertionError raceCondition(K k, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        private AssertionError recursionDetected(K k) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Recursion detected on input: " + k + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(3);
            }
            return assertionError;
        }

        public LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K k) {
            Object obj = this.cache.get(k);
            if (obj != null && obj != NotValue.COMPUTING) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.cache.get(k);
                if (obj2 != NotValue.COMPUTING) {
                    if (obj2 != null) {
                        return (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    }
                    this.cache.put(k, NotValue.COMPUTING);
                    V invoke = this.compute.invoke(k);
                    Object put = this.cache.put(k, WrappedValues.escapeNull(invoke));
                    if (put == NotValue.COMPUTING) {
                        return invoke;
                    }
                    throw raceCondition(k, put);
                }
                throw recursionDetected(k);
            } finally {
                this.storageManager.lock.unlock();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST;
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }
    }

    /* loaded from: classes2.dex */
    public static class RecursionDetectedResult<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final boolean fallThrough;
        public final T value;

        public RecursionDetectedResult(T t, boolean z) {
            this.value = t;
            this.fallThrough = z;
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>(null, true);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            if (isFallThrough()) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.value);
        }

        public static <T> RecursionDetectedResult<T> value(T t) {
            return new RecursionDetectedResult<>(t, false);
        }
    }

    public static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    public <T> RecursionDetectedResult<T> recursionDetectedDefault() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Recursive call in a lazy value under " + this)));
    }

    public LockBasedStorageManager(String str) {
        this(str, ExceptionHandlingStrategy.THROW, new ReentrantLock());
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue.invoke():T, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction.invoke(K):V] */
    public static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager lockBasedStorageManager) {
        return lockBasedStorageManager.exceptionHandlingStrategy;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(26);
        }
        this.lock.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(15);
        }
        return new LockBasedNotNullLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(7);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(8);
        }
        return createMemoizedFunction;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(11);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(12);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(22);
        }
        return new LockBasedLazyValue(this, function0);
    }

    public LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, Lock lock) {
        if (str == null) {
            $$$reportNull$$$0(2);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(3);
        }
        if (lock == null) {
            $$$reportNull$$$0(4);
        }
        this.lock = lock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> function0, final Function1<? super Boolean, ? extends T> function1, final Function1<? super T, Unit> function12) {
        if (function0 == null) {
            $$$reportNull$$$0(20);
        }
        if (function12 == null) {
            $$$reportNull$$$0(21);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[i != 2 ? 2 : 3];
                if (i != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4";
                } else {
                    objArr[0] = "value";
                }
                if (i != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4";
                }
                if (i == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                if (i == 2) {
                    throw new IllegalArgumentException(format);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            public void doPostCompute(T t) {
                if (t == null) {
                    $$$reportNull$$$0(2);
                }
                function12.invoke(t);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                Function1 function13 = function1;
                if (function13 == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(function13.invoke(Boolean.valueOf(z)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }
        };
    }

    public static <T extends Throwable> T sanitizeStackTrace(T t) {
        if (t == null) {
            $$$reportNull$$$0(27);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (!stackTrace[i2].getClassName().startsWith(PACKAGE_NAME)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        if (t == null) {
            $$$reportNull$$$0(28);
        }
        return t;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(10);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(13);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(14);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, final T t) {
        if (function0 == null) {
            $$$reportNull$$$0(18);
        }
        if (t == null) {
            $$$reportNull$$$0(19);
        }
        return new LockBasedNotNullLazyValue<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.3
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + SmallTailInfo.EMOTION_SUFFIX;
    }
}
