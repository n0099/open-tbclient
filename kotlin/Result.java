package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m564boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m566equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && q.h(obj, ((Result) obj2).m574unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m567equalsimpl0(Object obj, Object obj2) {
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m570hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m566equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m570hashCodeimpl(this.value);
    }

    public String toString() {
        return m573toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m574unboximpl() {
        return this.value;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.Result.box-impl(java.lang.Object):kotlin.Result] */
    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m565constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m572isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m571isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m569getOrNullimpl(Object obj) {
        if (m571isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m568exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m573toStringimpl(Object obj) {
        return obj instanceof Failure ? obj.toString() : "Success(" + obj + ')';
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            q.j(th, com.baidu.fsg.base.statistics.b.k);
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && q.h(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
