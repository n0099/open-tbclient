package org.webrtc;
/* loaded from: classes2.dex */
public interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    int getCodecConfigFramerate();

    void reportEncodedFrame(int i2);

    void setTargets(int i2, int i3);
}
