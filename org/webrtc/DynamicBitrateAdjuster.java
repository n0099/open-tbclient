package org.webrtc;
/* loaded from: classes10.dex */
class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        if (this.targetFps == 0) {
            return;
        }
        this.deviationBytes = (i - ((this.targetBitrateBps / BITS_PER_BYTE) / this.targetFps)) + this.deviationBytes;
        this.timeSinceLastAdjustmentMs += 1000.0d / this.targetFps;
        double d = this.targetBitrateBps / BITS_PER_BYTE;
        double d2 = BITRATE_ADJUSTMENT_SEC * d;
        this.deviationBytes = Math.min(this.deviationBytes, d2);
        this.deviationBytes = Math.max(this.deviationBytes, -d2);
        if (this.timeSinceLastAdjustmentMs > 3000.0d) {
            if (this.deviationBytes > d) {
                this.bitrateAdjustmentScaleExp -= (int) ((this.deviationBytes / d) + 0.5d);
                this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
                this.deviationBytes = d;
            } else {
                double d3 = -d;
                if (this.deviationBytes < d3) {
                    this.bitrateAdjustmentScaleExp = ((int) (((-this.deviationBytes) / d) + 0.5d)) + this.bitrateAdjustmentScaleExp;
                    this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
                    this.deviationBytes = d3;
                }
            }
            this.timeSinceLastAdjustmentMs = 0.0d;
        }
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i, int i2) {
        if (this.targetBitrateBps > 0 && i < this.targetBitrateBps) {
            this.deviationBytes = (this.deviationBytes * i) / this.targetBitrateBps;
        }
        super.setTargets(i, i2);
    }
}
