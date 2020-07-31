package com.qiniu.android.http;

import java.io.IOException;
/* loaded from: classes6.dex */
public interface CancellationHandler {

    /* loaded from: classes6.dex */
    public static class CancellationException extends IOException {
    }

    boolean isCancelled();
}
