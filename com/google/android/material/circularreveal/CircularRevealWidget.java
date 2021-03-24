package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;
/* loaded from: classes6.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* loaded from: classes6.dex */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
        public final RevealInfo revealInfo = new RevealInfo();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public RevealInfo evaluate(float f2, RevealInfo revealInfo, RevealInfo revealInfo2) {
            this.revealInfo.set(MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f2), MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f2), MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f2));
            return this.revealInfo;
        }
    }

    /* loaded from: classes6.dex */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");

        public CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes6.dex */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        public CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        public boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }

        public void set(float f2, float f3, float f4) {
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }

        public RevealInfo() {
        }

        public RevealInfo(float f2, float f3, float f4) {
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }

        public void set(RevealInfo revealInfo) {
            set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }

        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i);

    void setRevealInfo(@Nullable RevealInfo revealInfo);
}
