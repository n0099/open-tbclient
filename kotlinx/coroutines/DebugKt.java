package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0081\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001c\u0010\b\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001c\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0011\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015\"\u001c\u0010\u0019\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b\"\u0016\u0010\u001b\u001a\u00020\u00138\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lkotlin/Function0;", "", "value", "", "assert", "(Lkotlin/Function0;)V", "resetCoroutineId", "()V", "ASSERTIONS_ENABLED", "Z", "getASSERTIONS_ENABLED", "()Z", "Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "", "DEBUG_PROPERTY_NAME", "Ljava/lang/String;", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class DebugKt {
    public static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
    public static final AtomicLong COROUTINE_ID;
    public static final boolean DEBUG;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    public static final boolean RECOVER_STACK_TRACES;
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0.equals("auto") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r0.equals("") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        r0 = true;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt.systemProp(DEBUG_PROPERTY_NAME);
        boolean z2 = false;
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (systemProp.equals(DEBUG_PROPERTY_VALUE_OFF)) {
                        z = false;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + systemProp + '\'').toString());
            }
            DEBUG = z;
            if (z && SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true)) {
                z2 = true;
            }
            RECOVER_STACK_TRACES = z2;
            COROUTINE_ID = new AtomicLong(0L);
        }
        z = ASSERTIONS_ENABLED;
        DEBUG = z;
        if (z) {
            z2 = true;
        }
        RECOVER_STACK_TRACES = z2;
        COROUTINE_ID = new AtomicLong(0L);
    }

    @InlineOnly
    /* renamed from: assert  reason: not valid java name */
    public static final void m3014assert(Function0<Boolean> function0) {
        if (getASSERTIONS_ENABLED() && !function0.invoke().booleanValue()) {
            throw new AssertionError();
        }
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return ASSERTIONS_ENABLED;
    }

    public static final AtomicLong getCOROUTINE_ID() {
        return COROUTINE_ID;
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return RECOVER_STACK_TRACES;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }
}
