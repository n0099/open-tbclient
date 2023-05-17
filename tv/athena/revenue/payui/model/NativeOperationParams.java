package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes2.dex */
public class NativeOperationParams {
    public int opCode;
    public String params;

    public NativeOperationParams(int i) {
        this.opCode = i;
    }

    public NativeOperationParams(int i, String str) {
        this.opCode = i;
        this.params = str;
    }

    public String toString() {
        return "NativeOperationParams{opCode=" + this.opCode + "params=" + this.params + '}';
    }
}
