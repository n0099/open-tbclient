package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes8.dex */
public class NativeOperationParams {
    public int opCode;
    public String params;

    public NativeOperationParams(int i2) {
        this.opCode = i2;
    }

    public String toString() {
        return "NativeOperationParams{opCode=" + this.opCode + "params=" + this.params + '}';
    }

    public NativeOperationParams(int i2, String str) {
        this.opCode = i2;
        this.params = str;
    }
}
