package org.webrtc;
/* loaded from: classes7.dex */
public class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    public static final int INITIAL_FPS = 30;

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return 30;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i2, int i3) {
        if (this.targetFps == 0) {
            i3 = 30;
        }
        super.setTargets(i2, i3);
        this.targetBitrateBps = (this.targetBitrateBps * 30) / this.targetFps;
    }
}
