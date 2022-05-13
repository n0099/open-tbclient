package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001c\u0010\u0001\u001a\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "ANDROID_DETECTED", "Z", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FastServiceLoaderKt {
    public static final boolean ANDROID_DETECTED;

    static {
        Object m689constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m689constructorimpl = Result.m689constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m689constructorimpl = Result.m689constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m696isSuccessimpl(m689constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
