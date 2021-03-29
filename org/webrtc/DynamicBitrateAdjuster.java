package org.webrtc;
/* loaded from: classes7.dex */
public class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    public static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    public static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    public static final int BITRATE_ADJUSTMENT_STEPS = 20;
    public static final double BITS_PER_BYTE = 8.0d;
    public int bitrateAdjustmentScaleExp;
    public double deviationBytes;
    public double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(4.0d, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        int i2 = this.targetFps;
        if (i2 == 0) {
            return;
        }
        int i3 = this.targetBitrateBps;
        double d2 = this.deviationBytes + (i - ((i3 / 8.0d) / i2));
        this.deviationBytes = d2;
        this.timeSinceLastAdjustmentMs += 1000.0d / i2;
        double d3 = i3 / 8.0d;
        double d4 = 3.0d * d3;
        double min = Math.min(d2, d4);
        this.deviationBytes = min;
        double max = Math.max(min, -d4);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d3) {
            int i4 = this.bitrateAdjustmentScaleExp - ((int) ((max / d3) + 0.5d));
            this.bitrateAdjustmentScaleExp = i4;
            this.bitrateAdjustmentScaleExp = Math.max(i4, -20);
            this.deviationBytes = d3;
        } else {
            double d5 = -d3;
            if (max < d5) {
                int i5 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d3) + 0.5d));
                this.bitrateAdjustmentScaleExp = i5;
                this.bitrateAdjustmentScaleExp = Math.min(i5, 20);
                this.deviationBytes = d5;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i, int i2) {
        int i3 = this.targetBitrateBps;
        if (i3 > 0 && i < i3) {
            this.deviationBytes = (this.deviationBytes * i) / i3;
        }
        super.setTargets(i, i2);
    }
}
