package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0089\u0001\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a`\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001ab\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001c\u0010\u0018\u001aU\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0018\u001a\\\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\b2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u001e0\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0011\u0010\u0018\u001a\\\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\b2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u001e0\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0010\u0010\u0018\u001af\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b \u0010\u0018\u001aY\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0018\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0018\u001a\u001a\u0010#\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\bH\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"", "exception", "", "createFailure", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "R", "Lkotlin/Function0;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Result;", "runCatching", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onSuccess", "onFailure", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "transform", "map", "mapCatching", "", "action", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ResultKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Object createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T> R fold(Object obj, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function12) {
        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
        if (m655exceptionOrNullimpl == null) {
            return function1.invoke(obj);
        }
        return function12.invoke(m655exceptionOrNullimpl);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T extends R> R getOrDefault(Object obj, R r) {
        return Result.m658isFailureimpl(obj) ? r : obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
        return m655exceptionOrNullimpl == null ? obj : function1.invoke(m655exceptionOrNullimpl);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> T getOrThrow(Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T> Object map(Object obj, Function1<? super T, ? extends R> function1) {
        if (Result.m659isSuccessimpl(obj)) {
            Result.Companion companion = Result.Companion;
            return Result.m652constructorimpl(function1.invoke(obj));
        }
        return Result.m652constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> function1) {
        if (Result.m659isSuccessimpl(obj)) {
            try {
                Result.Companion companion = Result.Companion;
                return Result.m652constructorimpl(function1.invoke(obj));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                return Result.m652constructorimpl(createFailure(th));
            }
        }
        return Result.m652constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> Object onFailure(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
        if (m655exceptionOrNullimpl != null) {
            function1.invoke(m655exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> Object onSuccess(Object obj, Function1<? super T, Unit> function1) {
        if (Result.m659isSuccessimpl(obj)) {
            function1.invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T extends R> Object recover(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
        if (m655exceptionOrNullimpl == null) {
            return obj;
        }
        Result.Companion companion = Result.Companion;
        return Result.m652constructorimpl(function1.invoke(m655exceptionOrNullimpl));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
        if (m655exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            return Result.m652constructorimpl(function1.invoke(m655exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m652constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R> Object runCatching(Function0<? extends R> function0) {
        try {
            Result.Companion companion = Result.Companion;
            return Result.m652constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m652constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> function1) {
        try {
            Result.Companion companion = Result.Companion;
            return Result.m652constructorimpl(function1.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m652constructorimpl(createFailure(th));
        }
    }
}
