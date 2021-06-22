package d.a.m0.h.k0;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e {
    @V8JavascriptField
    @JvmField
    public final byte[] message;
    @V8JavascriptField
    @JvmField
    public final Object remoteInfo;

    public e(byte[] message, Object remoteInfo) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(remoteInfo, "remoteInfo");
        this.message = message;
        this.remoteInfo = remoteInfo;
    }
}
