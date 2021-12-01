package kotlinx.coroutines.internal;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a8\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0082\b¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0082\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012\"\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"<\u0010\u0019\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00040\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c*(\b\u0002\u0010\u001d\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¨\u0006\u001e"}, d2 = {"Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "createConstructor", "(Ljava/lang/reflect/Constructor;)Lkotlin/Function1;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "safeCtor", "(Lkotlin/Function1;)Lkotlin/Function1;", "E", "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/Class;", "", "accumulator", "fieldsCount", "(Ljava/lang/Class;I)I", "defaultValue", "fieldsCountOrDefault", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ljava/util/WeakHashMap;", "throwableFields", "I", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt {
    public static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);
    public static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();

    public static final Function1<Throwable, Throwable> createConstructor(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.areEqual(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        }
        return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
    }

    public static final int fieldsCount(Class<?> cls, int i2) {
        do {
            int i3 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return fieldsCount(cls, i2);
    }

    public static final int fieldsCountOrDefault(Class<?> cls, int i2) {
        Integer m702constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            m702constructorimpl = Result.m702constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m702constructorimpl = Result.m702constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.m708isFailureimpl(m702constructorimpl)) {
            m702constructorimpl = valueOf;
        }
        return ((Number) m702constructorimpl).intValue();
    }

    public static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return new ExceptionsConstuctorKt$safeCtor$1(function1);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, ARITH, INVOKE] complete} */
    public static final <E extends Throwable> E tryCopyException(E e2) {
        Object m702constructorimpl;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                m702constructorimpl = Result.m702constructorimpl(((CopyableThrowable) e2).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m702constructorimpl = Result.m702constructorimpl(ResultKt.createFailure(th));
            }
            return (E) (Result.m708isFailureimpl(m702constructorimpl) ? null : m702constructorimpl);
        }
        ReentrantReadWriteLock.ReadLock readLock2 = cacheLock.readLock();
        readLock2.lock();
        try {
            Function1<Throwable, Throwable> function1 = exceptionCtors.get(e2.getClass());
            if (function1 != null) {
                return (E) function1.invoke(e2);
            }
            int i2 = 0;
            if (throwableFields != fieldsCountOrDefault(e2.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount; i3++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    exceptionCtors.put(e2.getClass(), ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE);
                    Unit unit = Unit.INSTANCE;
                    return null;
                } finally {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
            Iterator it = ArraysKt___ArraysKt.sortedWith(e2.getClass().getConstructors(), new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
                }
            }).iterator();
            Function1<Throwable, Throwable> function12 = null;
            while (it.hasNext() && (function12 = createConstructor((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = cacheLock;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i4 = 0; i4 < readHoldCount; i4++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                exceptionCtors.put(e2.getClass(), function12 != null ? function12 : ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE);
                Unit unit2 = Unit.INSTANCE;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                if (function12 != null) {
                    return (E) function12.invoke(e2);
                }
                return null;
            } finally {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
