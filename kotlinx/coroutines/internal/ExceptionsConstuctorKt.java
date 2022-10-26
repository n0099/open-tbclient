package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a8\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0082\b¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0082\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012\"\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"<\u0010\u0019\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00040\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c*(\b\u0002\u0010\u001d\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¨\u0006\u001e"}, d2 = {"Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "createConstructor", "(Ljava/lang/reflect/Constructor;)Lkotlin/Function1;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "safeCtor", "(Lkotlin/Function1;)Lkotlin/Function1;", ExifInterface.LONGITUDE_EAST, "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/Class;", "", "accumulator", "fieldsCount", "(Ljava/lang/Class;I)I", "defaultValue", "fieldsCountOrDefault", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ljava/util/WeakHashMap;", "throwableFields", "I", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ExceptionsConstuctorKt {
    public static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);
    public static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    public static final WeakHashMap exceptionCtors = new WeakHashMap();

    public static final Function1 createConstructor(Constructor constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length != 2 || !Intrinsics.areEqual(parameterTypes[0], String.class) || !Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return null;
                }
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
            }
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.areEqual(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (!Intrinsics.areEqual(cls, String.class)) {
                return null;
            }
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
        }
        return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
    }

    public static final int fieldsCount(Class cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static final int fieldsCountOrDefault(Class cls, int i) {
        Integer m698constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            m698constructorimpl = Result.m698constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m698constructorimpl = Result.m698constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m704isFailureimpl(m698constructorimpl)) {
            m698constructorimpl = valueOf;
        }
        return ((Number) m698constructorimpl).intValue();
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    public static final Function1 safeCtor(Function1 function1) {
        return new ExceptionsConstuctorKt$safeCtor$1(function1);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, ARITH, INVOKE] complete} */
    public static final Throwable tryCopyException(Throwable th) {
        Object m698constructorimpl;
        ReentrantReadWriteLock.ReadLock readLock;
        int i;
        ReentrantReadWriteLock.WriteLock writeLock;
        Function1 function1;
        int i2;
        Throwable th2 = null;
        if (th instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                m698constructorimpl = Result.m698constructorimpl(((CopyableThrowable) th).createCopy());
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                m698constructorimpl = Result.m698constructorimpl(ResultKt.createFailure(th3));
            }
            if (!Result.m704isFailureimpl(m698constructorimpl)) {
                th2 = m698constructorimpl;
            }
            return th2;
        }
        ReentrantReadWriteLock.ReadLock readLock2 = cacheLock.readLock();
        readLock2.lock();
        try {
            Function1 function12 = (Function1) exceptionCtors.get(th.getClass());
            if (function12 != null) {
                return (Throwable) function12.invoke(th);
            }
            int i3 = 0;
            if (throwableFields != fieldsCountOrDefault(th.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
                readLock = reentrantReadWriteLock.readLock();
                if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    i2 = reentrantReadWriteLock.getReadHoldCount();
                } else {
                    i2 = 0;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    exceptionCtors.put(th.getClass(), ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE);
                    Unit unit = Unit.INSTANCE;
                    return null;
                } finally {
                    while (i3 < i) {
                        readLock.lock();
                        i3++;
                    }
                    writeLock.unlock();
                }
            }
            Iterator it = ArraysKt___ArraysKt.sortedWith(th.getClass().getConstructors(), new Comparator() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) obj2).getParameterTypes().length), Integer.valueOf(((Constructor) obj).getParameterTypes().length));
                }
            }).iterator();
            Function1 function13 = null;
            while (it.hasNext() && (function13 = createConstructor((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = cacheLock;
            readLock = reentrantReadWriteLock2.readLock();
            if (reentrantReadWriteLock2.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock2.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i5 = 0; i5 < i; i5++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                WeakHashMap weakHashMap = exceptionCtors;
                Class<?> cls = th.getClass();
                if (function13 != null) {
                    function1 = function13;
                } else {
                    function1 = ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE;
                }
                weakHashMap.put(cls, function1);
                Unit unit2 = Unit.INSTANCE;
                while (i3 < i) {
                    readLock.lock();
                    i3++;
                }
                writeLock.unlock();
                if (function13 == null) {
                    return null;
                }
                return (Throwable) function13.invoke(th);
            } finally {
                while (i3 < i) {
                    readLock.lock();
                    i3++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
