package com.win.opensdk;
/* loaded from: classes6.dex */
public final class O extends Throwable {
    public O(String str) {
        super(str);
    }

    public O(Throwable th) {
        super(th.getMessage(), th.getCause());
        setStackTrace(th.getStackTrace());
    }
}
