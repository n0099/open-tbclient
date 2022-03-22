package kotlinx.coroutines.channels;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0014\b\u0087@\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u0001:\u0002! B\u0016\b\u0000\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0019J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8F@\u0006¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u001b\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001c\u0010\u0019ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed;", "T", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "getCloseCause-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "closeCause$annotations", "()V", "closeCause", "holder", "Ljava/lang/Object;", "isClosed-impl", "isClosed", "getValue-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "value$annotations", "value", "getValueOrNull-impl", "valueOrNull$annotations", "valueOrNull", "constructor-impl", "Companion", "Closed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ValueOrClosed<T> {
    public static final Companion Companion = new Companion(null);
    public final Object holder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u0000B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Closed {
        @JvmField
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00012\u0006\u0010\b\u001a\u00028\u0001H\u0080\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed$Companion;", "E", "", "cause", "Lkotlinx/coroutines/channels/ValueOrClosed;", "closed$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "closed", "value", "value$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public final <E> Object closed$kotlinx_coroutines_core(Throwable th) {
            return ValueOrClosed.m2082constructorimpl(new Closed(th));
        }

        public final <E> Object value$kotlinx_coroutines_core(E e2) {
            return ValueOrClosed.m2082constructorimpl(e2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.channels.ValueOrClosed.box-impl(java.lang.Object):kotlinx.coroutines.channels.ValueOrClosed] */
    public /* synthetic */ ValueOrClosed(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ValueOrClosed m2081boximpl(Object obj) {
        return new ValueOrClosed(obj);
    }

    public static /* synthetic */ void closeCause$annotations() {
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m2082constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2083equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ValueOrClosed) && Intrinsics.areEqual(obj, ((ValueOrClosed) obj2).m2091unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2084equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: getCloseCause-impl  reason: not valid java name */
    public static final Throwable m2085getCloseCauseimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).cause;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getValue-impl  reason: not valid java name */
    public static final T m2086getValueimpl(Object obj) {
        if (obj instanceof Closed) {
            throw new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE.toString());
        }
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getValueOrNull-impl  reason: not valid java name */
    public static final T m2087getValueOrNullimpl(Object obj) {
        if (obj instanceof Closed) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2088hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m2089isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2090toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public static /* synthetic */ void value$annotations() {
    }

    public static /* synthetic */ void valueOrNull$annotations() {
    }

    public boolean equals(Object obj) {
        return m2083equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m2088hashCodeimpl(this.holder);
    }

    public String toString() {
        return m2090toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m2091unboximpl() {
        return this.holder;
    }
}
