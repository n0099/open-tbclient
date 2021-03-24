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
        double d2 = this.bitrateAdjustmentScaleExp;
        Double.isNaN(d2);
        return Math.pow(4.0d, d2 / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        double d2 = this.targetBitrateBps;
        double bitrateAdjustmentScale = getBitrateAdjustmentScale();
        Double.isNaN(d2);
        return (int) (d2 * bitrateAdjustmentScale);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        int i2 = this.targetFps;
        if (i2 == 0) {
            return;
        }
        int i3 = this.targetBitrateBps;
        double d2 = i3;
        Double.isNaN(d2);
        double d3 = i2;
        Double.isNaN(d3);
        double d4 = (d2 / 8.0d) / d3;
        double d5 = this.deviationBytes;
        double d6 = i;
        Double.isNaN(d6);
        double d7 = d5 + (d6 - d4);
        this.deviationBytes = d7;
        double d8 = this.timeSinceLastAdjustmentMs;
        double d9 = i2;
        Double.isNaN(d9);
        this.timeSinceLastAdjustmentMs = d8 + (1000.0d / d9);
        double d10 = i3;
        Double.isNaN(d10);
        double d11 = d10 / 8.0d;
        double d12 = 3.0d * d11;
        double min = Math.min(d7, d12);
        this.deviationBytes = min;
        double max = Math.max(min, -d12);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d11) {
            int i4 = this.bitrateAdjustmentScaleExp - ((int) ((max / d11) + 0.5d));
            this.bitrateAdjustmentScaleExp = i4;
            this.bitrateAdjustmentScaleExp = Math.max(i4, -20);
            this.deviationBytes = d11;
        } else {
            double d13 = -d11;
            if (max < d13) {
                int i5 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d11) + 0.5d));
                this.bitrateAdjustmentScaleExp = i5;
                this.bitrateAdjustmentScaleExp = Math.min(i5, 20);
                this.deviationBytes = d13;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i, int i2) {
        int i3 = this.targetBitrateBps;
        if (i3 > 0 && i < i3) {
            double d2 = this.deviationBytes;
            double d3 = i;
            Double.isNaN(d3);
            double d4 = d2 * d3;
            double d5 = i3;
            Double.isNaN(d5);
            this.deviationBytes = d4 / d5;
        }
        super.setTargets(i, i2);
    }
}
