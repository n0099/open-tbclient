package com.facebook.drawee.backends.pipeline.info;
/* loaded from: classes7.dex */
public interface ImagePerfNotifier {
    void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i);

    void notifyStatusUpdated(ImagePerfState imagePerfState, int i);
}
