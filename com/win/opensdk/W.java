package com.win.opensdk;
/* loaded from: classes7.dex */
public final class W extends Throwable {
    public W(String str) {
        super(str);
    }

    public W(Throwable th) {
        super(th.getMessage(), th.getCause());
        setStackTrace(th.getStackTrace());
    }
}
