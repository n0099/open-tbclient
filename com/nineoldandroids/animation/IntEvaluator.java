package com.nineoldandroids.animation;
/* loaded from: classes9.dex */
public class IntEvaluator implements TypeEvaluator<Integer> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (((num2.intValue() - intValue) * f) + intValue));
    }
}
