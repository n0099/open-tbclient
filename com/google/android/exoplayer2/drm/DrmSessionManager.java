package com.google.android.exoplayer2.drm;

import android.os.Looper;
/* loaded from: classes7.dex */
public interface DrmSessionManager {
    DrmSession acquireSession(Looper looper, DrmInitData drmInitData);

    boolean canAcquireSession(DrmInitData drmInitData);

    void releaseSession(DrmSession drmSession);
}
