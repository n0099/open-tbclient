package d.a.i0.h.k0;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {
    @V8JavascriptField
    @JvmField
    public final String address;
    @V8JavascriptField
    @JvmField
    public final String family;
    @V8JavascriptField
    @JvmField
    public final int port;
    @V8JavascriptField
    @JvmField
    public final int size;

    public f(String address, int i2, int i3, String family) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(family, "family");
        this.address = address;
        this.size = i2;
        this.port = i3;
        this.family = family;
    }
}
