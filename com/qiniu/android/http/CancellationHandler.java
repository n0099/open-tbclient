package com.qiniu.android.http;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface CancellationHandler {

    /* loaded from: classes4.dex */
    public static class CancellationException extends IOException {
    }

    boolean isCancelled();
}
