package com.thunder.livesdk;

import com.thunder.livesdk.ThunderPublisher;
/* loaded from: classes6.dex */
public abstract class ThunderVideoCapture {
    public abstract ThunderVideoCaptureConfig getCaptureConfig();

    public abstract void startCapture(ThunderPublisher.IVideoPublisher iVideoPublisher);

    public abstract void stopCapture();
}
