package com.facebook.drawee.backends.pipeline.info;
/* loaded from: classes11.dex */
public interface ImagePerfNotifier {
    void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i2);

    void notifyStatusUpdated(ImagePerfState imagePerfState, int i2);
}
