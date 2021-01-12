package com.win.opensdk;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public final class m {

    /* loaded from: classes3.dex */
    public static final class java extends Throwable {
        public int java;

        public java(@NonNull String str) {
            super(str);
        }

        public java(@NonNull Throwable th) {
            super(th.getMessage(), th.getCause());
            setStackTrace(th.getStackTrace());
        }
    }
}
