package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.b;
@TargetApi(16)
/* loaded from: classes5.dex */
public interface a<T extends b> {
    DrmSession<T> a(Looper looper, DrmInitData drmInitData);

    void a(DrmSession<T> drmSession);

    boolean c(DrmInitData drmInitData);
}
