package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
        this.firstTime = true;
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.nineoldandroids.animation.KeyframeSet
    public IntKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (Keyframe.IntKeyframe) arrayList.get(i).m44clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float f) {
        int i = 1;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            if (this.mEvaluator == null) {
                return this.firstValue + ((int) (this.deltaValue * f));
            }
            return ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        } else if (f <= 0.0f) {
            Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
            int intValue = intKeyframe.getIntValue();
            int intValue2 = intKeyframe2.getIntValue();
            float fraction = intKeyframe.getFraction();
            float fraction2 = intKeyframe2.getFraction();
            Interpolator interpolator = intKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float f2 = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? ((int) (f2 * (intValue2 - intValue))) + intValue : ((Number) this.mEvaluator.evaluate(f2, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
        } else if (f >= 1.0f) {
            Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            int intValue3 = intKeyframe3.getIntValue();
            int intValue4 = intKeyframe4.getIntValue();
            float fraction3 = intKeyframe3.getFraction();
            float fraction4 = intKeyframe4.getFraction();
            Interpolator interpolator2 = intKeyframe4.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f3 = (f - fraction3) / (fraction4 - fraction3);
            return this.mEvaluator == null ? ((int) (f3 * (intValue4 - intValue3))) + intValue3 : ((Number) this.mEvaluator.evaluate(f3, Integer.valueOf(intValue3), Integer.valueOf(intValue4))).intValue();
        } else {
            Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            while (true) {
                Keyframe.IntKeyframe intKeyframe6 = intKeyframe5;
                if (i < this.mNumKeyframes) {
                    intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(i);
                    if (f >= intKeyframe5.getFraction()) {
                        i++;
                    } else {
                        Interpolator interpolator3 = intKeyframe5.getInterpolator();
                        if (interpolator3 != null) {
                            f = interpolator3.getInterpolation(f);
                        }
                        float fraction5 = (f - intKeyframe6.getFraction()) / (intKeyframe5.getFraction() - intKeyframe6.getFraction());
                        int intValue5 = intKeyframe6.getIntValue();
                        int intValue6 = intKeyframe5.getIntValue();
                        return this.mEvaluator == null ? ((int) ((intValue6 - intValue5) * fraction5)) + intValue5 : ((Number) this.mEvaluator.evaluate(fraction5, Integer.valueOf(intValue5), Integer.valueOf(intValue6))).intValue();
                    }
                } else {
                    return ((Number) this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).intValue();
                }
            }
        }
    }
}
