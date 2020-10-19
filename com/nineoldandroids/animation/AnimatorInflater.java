package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes9.dex */
public class AnimatorInflater {
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int[] AnimatorSet = {16843490};
    private static final int[] PropertyAnimator = {16843489};
    private static final int[] Animator = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = context.getResources().getAnimation(i);
                    return createAnimatorFromXml(context, xmlResourceParser);
                } catch (XmlPullParserException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        int i2 = 0;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList2 = null;
        Animator animator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = loadObjectAnimator(context, attributeSet);
                    } else if (name.equals("animator")) {
                        animator = loadAnimator(context, attributeSet, null);
                    } else if (name.equals("set")) {
                        animator = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        createAnimatorFromXml(context, xmlPullParser, attributeSet, (AnimatorSet) animator, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(animator);
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                }
            }
        }
        if (animatorSet != null && arrayList2 != null) {
            Animator[] animatorArr = new Animator[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i;
        int i2;
        int i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j = obtainStyledAttributes.getInt(1, 0);
        long j2 = obtainStyledAttributes.getInt(2, 0);
        int i4 = obtainStyledAttributes.getInt(7, 0);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        boolean z = i4 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i5 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i6 = z3 ? peekValue2.type : 0;
        if ((z2 && i5 >= 28 && i5 <= 31) || (z3 && i6 >= 28 && i6 <= 31)) {
            z = false;
            valueAnimator.setEvaluator(new ArgbEvaluator());
        }
        if (z) {
            if (z2) {
                float dimension = i5 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
                if (z3) {
                    valueAnimator.setFloatValues(dimension, i6 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
                } else {
                    valueAnimator.setFloatValues(dimension);
                }
            } else {
                valueAnimator.setFloatValues(i6 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            }
        } else if (z2) {
            if (i5 == 5) {
                i2 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                i2 = (i5 < 28 || i5 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
            }
            if (z3) {
                if (i6 == 5) {
                    i3 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    i3 = (i6 < 28 || i6 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0);
                }
                valueAnimator.setIntValues(i2, i3);
            } else {
                valueAnimator.setIntValues(i2);
            }
        } else if (z3) {
            if (i6 == 5) {
                i = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                i = (i6 < 28 || i6 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0);
            }
            valueAnimator.setIntValues(i);
        }
        valueAnimator.setDuration(j);
        valueAnimator.setStartDelay(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator.setRepeatCount(obtainStyledAttributes.getInt(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator;
    }
}
