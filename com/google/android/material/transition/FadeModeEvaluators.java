package com.google.android.material.transition;
/* loaded from: classes6.dex */
public class FadeModeEvaluators {
    public static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f2, float f3, float f4) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f3, f4, f2));
        }
    };
    public static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f4, f2), 255);
        }
    };
    public static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f4, f2), TransitionUtils.lerp(0, 255, f3, f4, f2));
        }
    };
    public static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f2, float f3, float f4) {
            float f5 = ((f4 - f3) * 0.35f) + f3;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f5, f2), TransitionUtils.lerp(0, 255, f5, f4, f2));
        }
    };

    public static FadeModeEvaluator get(int i2, boolean z) {
        if (i2 == 0) {
            return z ? IN : OUT;
        } else if (i2 == 1) {
            return z ? OUT : IN;
        } else if (i2 != 2) {
            if (i2 == 3) {
                return THROUGH;
            }
            throw new IllegalArgumentException("Invalid fade mode: " + i2);
        } else {
            return CROSS;
        }
    }
}
