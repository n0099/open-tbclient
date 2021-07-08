package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0001H\u0082\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u0005H\u0082\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n\"\u001c\u0010\u000b\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u0012\u0004\b\f\u0010\n\"\u001c\u0010\r\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u0012\u0004\b\u000e\u0010\n\"\u001c\u0010\u000f\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\b\u0012\u0004\b\u0010\u0010\n\"\u001c\u0010\u0011\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\b\u0012\u0004\b\u0012\u0010\n\"\u0016\u0010\u0014\u001a\u00020\u00138\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u00138\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u00138\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015*(\b\u0000\u0010\u001b\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"E", "", "Lkotlinx/coroutines/channels/ValueOrClosed;", "toResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Object;", "ENQUEUE_FAILED", "Ljava/lang/Object;", "ENQUEUE_FAILED$annotations", "()V", "HANDLER_INVOKED", "HANDLER_INVOKED$annotations", "OFFER_FAILED", "OFFER_FAILED$annotations", "OFFER_SUCCESS", "OFFER_SUCCESS$annotations", "POLL_FAILED", "POLL_FAILED$annotations", "", "RECEIVE_NULL_ON_CLOSE", "I", "RECEIVE_RESULT", "RECEIVE_THROWS_ON_CLOSE", "Lkotlin/Function1;", "", "", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class AbstractChannelKt {
    public static final int RECEIVE_NULL_ON_CLOSE = 1;
    public static final int RECEIVE_RESULT = 2;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;
    @JvmField
    public static final Object OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    @JvmField
    public static final Object OFFER_FAILED = new Symbol("OFFER_FAILED");
    @JvmField
    public static final Object POLL_FAILED = new Symbol("POLL_FAILED");
    @JvmField
    public static final Object ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    @JvmField
    public static final Object HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");

    public static /* synthetic */ void ENQUEUE_FAILED$annotations() {
    }

    public static /* synthetic */ void HANDLER_INVOKED$annotations() {
    }

    public static /* synthetic */ void OFFER_FAILED$annotations() {
    }

    public static /* synthetic */ void OFFER_SUCCESS$annotations() {
    }

    public static /* synthetic */ void POLL_FAILED$annotations() {
    }

    public static final <E> Object toResult(Object obj) {
        if (obj instanceof Closed) {
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m1974constructorimpl(new ValueOrClosed.Closed(((Closed) obj).closeCause));
        }
        ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
        return ValueOrClosed.m1974constructorimpl(obj);
    }

    public static final <E> Object toResult(Closed<?> closed) {
        ValueOrClosed.Companion companion = ValueOrClosed.Companion;
        return ValueOrClosed.m1974constructorimpl(new ValueOrClosed.Closed(closed.closeCause));
    }
}
