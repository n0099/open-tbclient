package kotlin;

import com.baidu.sapi2.views.SmsLoginView;
import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087@\u0018\u0000 \u001f*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u001f B\u0016\b\u0001\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u001dø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "", "hashCode", "()I", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "isFailure-impl", "isFailure", "isSuccess-impl", "isSuccess", "value", "Ljava/lang/Object;", "getValue$annotations", "()V", "constructor-impl", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class Result<T> implements Serializable {
    public static final Companion Companion = new Companion(null);
    public final Object value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0007\u001a\u00028\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/Result$Companion;", "T", "", "exception", "Lkotlin/Result;", SmsLoginView.f.l, "(Ljava/lang/Throwable;)Ljava/lang/Object;", "value", "success", "(Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        @InlineOnly
        @JvmName(name = SmsLoginView.f.l)
        private final <T> Object failure(Throwable th) {
            return Result.m649constructorimpl(ResultKt.createFailure(th));
        }

        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object success(T t) {
            return Result.m649constructorimpl(t);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "exception", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Failure implements Serializable {
        @JvmField
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.Result.box-impl(java.lang.Object):kotlin.Result] */
    @PublishedApi
    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m648boximpl(Object obj) {
        return new Result(obj);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m649constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m650equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).m658unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m651equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m652exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl  reason: not valid java name */
    public static final T m653getOrNullimpl(Object obj) {
        if (m655isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m654hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m655isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m656isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m657toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m650equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m654hashCodeimpl(this.value);
    }

    public String toString() {
        return m657toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m658unboximpl() {
        return this.value;
    }
}
