package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class KeyframeSet {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes = new ArrayList<>();
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        this.mKeyframes.addAll(Arrays.asList(keyframeArr));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        this.mLastKeyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }

    public static KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                intKeyframeArr[i] = (Keyframe.IntKeyframe) Keyframe.ofInt(i / (length - 1), iArr[i]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofFloat(float... fArr) {
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                floatKeyframeArr[i] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(i / (length - 1), fArr[i]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            if (keyframeArr[i] instanceof Keyframe.FloatKeyframe) {
                z3 = true;
            } else if (keyframeArr[i] instanceof Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z = true;
            }
        }
        if (z3 && !z2 && !z) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[length];
            for (int i2 = 0; i2 < length; i2++) {
                floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) keyframeArr[i2];
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (z2 && !z3 && !z) {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[length];
            for (int i3 = 0; i3 < length; i3++) {
                intKeyframeArr[i3] = (Keyframe.IntKeyframe) keyframeArr[i3];
            }
            return new IntKeyframeSet(intKeyframeArr);
        } else {
            return new KeyframeSet(keyframeArr);
        }
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                objectKeyframeArr[i] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(i / (length - 1), objArr[i]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public KeyframeSet m52clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i = 0; i < size; i++) {
            keyframeArr[i] = arrayList.get(i).m51clone();
        }
        return new KeyframeSet(keyframeArr);
    }

    public Object getValue(float f) {
        if (this.mNumKeyframes == 2) {
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator.evaluate(f, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        } else if (f <= 0.0f) {
            Keyframe keyframe = this.mKeyframes.get(1);
            Interpolator interpolator = keyframe.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        } else if (f >= 1.0f) {
            Keyframe keyframe2 = this.mKeyframes.get(this.mNumKeyframes - 2);
            Interpolator interpolator2 = this.mLastKeyframe.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((f - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        } else {
            Keyframe keyframe3 = this.mFirstKeyframe;
            int i = 1;
            while (i < this.mNumKeyframes) {
                Keyframe keyframe4 = this.mKeyframes.get(i);
                if (f >= keyframe4.getFraction()) {
                    i++;
                    keyframe3 = keyframe4;
                } else {
                    Interpolator interpolator3 = keyframe4.getInterpolator();
                    if (interpolator3 != null) {
                        f = interpolator3.getInterpolation(f);
                    }
                    float fraction3 = keyframe3.getFraction();
                    return this.mEvaluator.evaluate((f - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
                }
            }
            return this.mLastKeyframe.getValue();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.mNumKeyframes) {
            String str2 = str + this.mKeyframes.get(i).getValue() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
