package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
        this.firstTime = true;
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.nineoldandroids.animation.KeyframeSet
    public FloatKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i = 0; i < size; i++) {
            floatKeyframeArr[i] = (Keyframe.FloatKeyframe) arrayList.get(i).m51clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float getFloatValue(float f) {
        int i = 1;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                this.lastValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            if (this.mEvaluator == null) {
                return this.firstValue + (this.deltaValue * f);
            }
            return ((Number) this.mEvaluator.evaluate(f, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        } else if (f <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
            float floatValue = floatKeyframe.getFloatValue();
            float floatValue2 = floatKeyframe2.getFloatValue();
            float fraction = floatKeyframe.getFraction();
            float fraction2 = floatKeyframe2.getFraction();
            Interpolator interpolator = floatKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float f2 = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? (f2 * (floatValue2 - floatValue)) + floatValue : ((Number) this.mEvaluator.evaluate(f2, Float.valueOf(floatValue), Float.valueOf(floatValue2))).floatValue();
        } else if (f >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            float floatValue3 = floatKeyframe3.getFloatValue();
            float floatValue4 = floatKeyframe4.getFloatValue();
            float fraction3 = floatKeyframe3.getFraction();
            float fraction4 = floatKeyframe4.getFraction();
            Interpolator interpolator2 = floatKeyframe4.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f3 = (f - fraction3) / (fraction4 - fraction3);
            return this.mEvaluator == null ? (f3 * (floatValue4 - floatValue3)) + floatValue3 : ((Number) this.mEvaluator.evaluate(f3, Float.valueOf(floatValue3), Float.valueOf(floatValue4))).floatValue();
        } else {
            Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            while (true) {
                Keyframe.FloatKeyframe floatKeyframe6 = floatKeyframe5;
                if (i < this.mNumKeyframes) {
                    floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i);
                    if (f >= floatKeyframe5.getFraction()) {
                        i++;
                    } else {
                        Interpolator interpolator3 = floatKeyframe5.getInterpolator();
                        if (interpolator3 != null) {
                            f = interpolator3.getInterpolation(f);
                        }
                        float fraction5 = (f - floatKeyframe6.getFraction()) / (floatKeyframe5.getFraction() - floatKeyframe6.getFraction());
                        float floatValue5 = floatKeyframe6.getFloatValue();
                        float floatValue6 = floatKeyframe5.getFloatValue();
                        return this.mEvaluator == null ? ((floatValue6 - floatValue5) * fraction5) + floatValue5 : ((Number) this.mEvaluator.evaluate(fraction5, Float.valueOf(floatValue5), Float.valueOf(floatValue6))).floatValue();
                    }
                } else {
                    return ((Number) this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).floatValue();
                }
            }
        }
    }
}
