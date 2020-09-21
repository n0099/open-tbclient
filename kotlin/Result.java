package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m591boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m593equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && q.l(obj, ((Result) obj2).m601unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m594equalsimpl0(Object obj, Object obj2) {
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m597hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m593equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m597hashCodeimpl(this.value);
    }

    public String toString() {
        return m600toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m601unboximpl() {
        return this.value;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.Result.box-impl(java.lang.Object):kotlin.Result] */
    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m592constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m599isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m598isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m596getOrNullimpl(Object obj) {
        if (m598isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m595exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m600toStringimpl(Object obj) {
        return obj instanceof Failure ? obj.toString() : "Success(" + obj + ')';
    }

    @h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            q.m(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && q.l(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
