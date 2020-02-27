package com.nineoldandroids.animation;
/* loaded from: classes7.dex */
public class FloatEvaluator implements TypeEvaluator<Number> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + ((number2.floatValue() - floatValue) * f));
    }
}
