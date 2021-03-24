package org.json.alipay;
/* loaded from: classes7.dex */
public class JSONException extends Exception {
    public Throwable cause;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(Throwable th) {
        super(th.getMessage());
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
