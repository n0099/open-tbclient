package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.b;
@TargetApi(16)
/* loaded from: classes6.dex */
public interface DrmSession<T extends b> {
    DrmSessionException duL();

    T duM();

    int getState();

    /* loaded from: classes6.dex */
    public static class DrmSessionException extends Exception {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }
}
