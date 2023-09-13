package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", ExifInterface.LONGITUDE_EAST, "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExceptionsConstructorKt {
    public static final CtorCache ctorCache;
    public static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        CtorCache ctorCache2;
        try {
            if (FastServiceLoaderKt.getANDROID_DETECTED()) {
                ctorCache2 = WeakMapCtorCache.INSTANCE;
            } else {
                ctorCache2 = ClassValueCtorCache.INSTANCE;
            }
        } catch (Throwable unused) {
            ctorCache2 = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = ctorCache2;
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.internal.ClassValueCtorCache$cache$1.computeValue(java.lang.Class<?>):kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>] */
    public static final /* synthetic */ Function1 access$createConstructor(Class cls) {
        return createConstructor(cls);
    }

    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        for (Constructor constructor : ArraysKt___ArraysKt.sortedWith(cls.getConstructors(), new Comparator() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            }
        })) {
            Function1<Throwable, Throwable> createSafeConstructor = createSafeConstructor(constructor);
            if (createSafeConstructor != null) {
                return createSafeConstructor;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    public static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$safeCtor$1
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends java.lang.Throwable> */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object m850constructorimpl;
                Function1<Throwable, Throwable> function12 = function1;
                try {
                    Result.Companion companion = Result.Companion;
                    m850constructorimpl = Result.m850constructorimpl(function12.invoke(th));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m856isFailureimpl(m850constructorimpl)) {
                    m850constructorimpl = null;
                }
                return (Throwable) m850constructorimpl;
            }
        };
    }

    public static final Function1<Throwable, Throwable> createSafeConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length != 2 || !Intrinsics.areEqual(parameterTypes[0], String.class) || !Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return null;
                }
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object m850constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.Companion;
                            newInstance = constructor.newInstance(th.getMessage(), th);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (newInstance != null) {
                            m850constructorimpl = Result.m850constructorimpl((Throwable) newInstance);
                            if (Result.m856isFailureimpl(m850constructorimpl)) {
                                m850constructorimpl = null;
                            }
                            return (Throwable) m850constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.areEqual(cls, Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object m850constructorimpl;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.Companion;
                            newInstance = constructor.newInstance(th);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (newInstance != null) {
                            m850constructorimpl = Result.m850constructorimpl((Throwable) newInstance);
                            if (Result.m856isFailureimpl(m850constructorimpl)) {
                                m850constructorimpl = null;
                            }
                            return (Throwable) m850constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (!Intrinsics.areEqual(cls, String.class)) {
                return null;
            }
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object m850constructorimpl;
                    Object newInstance;
                    try {
                        Result.Companion companion = Result.Companion;
                        newInstance = constructor.newInstance(th.getMessage());
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (newInstance != null) {
                        Throwable th3 = (Throwable) newInstance;
                        th3.initCause(th);
                        m850constructorimpl = Result.m850constructorimpl(th3);
                        if (Result.m856isFailureimpl(m850constructorimpl)) {
                            m850constructorimpl = null;
                        }
                        return (Throwable) m850constructorimpl;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object m850constructorimpl;
                Object newInstance;
                try {
                    Result.Companion companion = Result.Companion;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th2));
                }
                if (newInstance != null) {
                    Throwable th3 = (Throwable) newInstance;
                    th3.initCause(th);
                    m850constructorimpl = Result.m850constructorimpl(th3);
                    if (Result.m856isFailureimpl(m850constructorimpl)) {
                        m850constructorimpl = null;
                    }
                    return (Throwable) m850constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    public static final int fieldsCount(Class<?> cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                i2++;
                if (!Modifier.isStatic(field.getModifiers())) {
                    i3++;
                }
            }
            i += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer m850constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            m850constructorimpl = Result.m850constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m856isFailureimpl(m850constructorimpl)) {
            m850constructorimpl = valueOf;
        }
        return ((Number) m850constructorimpl).intValue();
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: kotlinx.coroutines.internal.CtorCache */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object m850constructorimpl;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                m850constructorimpl = Result.m850constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m850constructorimpl = Result.m850constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m856isFailureimpl(m850constructorimpl)) {
                m850constructorimpl = null;
            }
            return (E) m850constructorimpl;
        }
        return (E) ctorCache.get(e.getClass()).invoke(e);
    }
}
