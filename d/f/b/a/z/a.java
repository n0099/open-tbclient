package d.f.b.a.z;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import d.f.b.a.z.b;
@TargetApi(16)
/* loaded from: classes10.dex */
public interface a<T extends b> {
    void a(DrmSession<T> drmSession);

    boolean b(DrmInitData drmInitData);

    DrmSession<T> c(Looper looper, DrmInitData drmInitData);
}
