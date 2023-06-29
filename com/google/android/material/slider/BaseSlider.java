package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.baidu.tieba.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    public static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    public static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    public static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    public static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    public static final int HALO_ALPHA = 63;
    public static final double THRESHOLD = 1.0E-4d;
    public static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    public BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
    @NonNull
    public final AccessibilityHelper accessibilityHelper;
    public final AccessibilityManager accessibilityManager;
    public int activeThumbIdx;
    @NonNull
    public final Paint activeTicksPaint;
    @NonNull
    public final Paint activeTrackPaint;
    @NonNull
    public final List<L> changeListeners;
    public boolean dirtyConfig;
    public int focusedThumbIdx;
    public boolean forceDrawCompatHalo;
    public LabelFormatter formatter;
    @NonNull
    public ColorStateList haloColor;
    @NonNull
    public final Paint haloPaint;
    public int haloRadius;
    @NonNull
    public final Paint inactiveTicksPaint;
    @NonNull
    public final Paint inactiveTrackPaint;
    public boolean isLongPress;
    public int labelBehavior;
    @NonNull
    public final TooltipDrawableFactory labelMaker;
    public int labelPadding;
    @NonNull
    public final List<TooltipDrawable> labels;
    public MotionEvent lastEvent;
    public final int scaledTouchSlop;
    public float stepSize;
    @NonNull
    public final MaterialShapeDrawable thumbDrawable;
    public boolean thumbIsPressed;
    @NonNull
    public final Paint thumbPaint;
    public int thumbRadius;
    @NonNull
    public ColorStateList tickColorActive;
    @NonNull
    public ColorStateList tickColorInactive;
    public float[] ticksCoordinates;
    public float touchDownX;
    @NonNull
    public final List<T> touchListeners;
    public float touchPosition;
    @NonNull
    public ColorStateList trackColorActive;
    @NonNull
    public ColorStateList trackColorInactive;
    public int trackHeight;
    public int trackSidePadding;
    public int trackTop;
    public int trackWidth;
    public float valueFrom;
    public float valueTo;
    public ArrayList<Float> values;
    public int widgetHeight;
    public static final String TAG = BaseSlider.class.getSimpleName();
    public static final int DEF_STYLE_RES = R.style.obfuscated_res_0x7f100396;

    /* loaded from: classes9.dex */
    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    /* loaded from: classes9.dex */
    public class AccessibilityEventSender implements Runnable {
        public int virtualViewId;

        public AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public void setVirtualViewId(int i) {
            this.virtualViewId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    /* loaded from: classes9.dex */
    public static class AccessibilityHelper extends ExploreByTouchHelper {
        public final BaseSlider<?, ?, ?> slider;
        public Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }

        @NonNull
        private String startOrEndDescription(int i) {
            if (i == this.slider.getValues().size() - 1) {
                return this.slider.getContext().getString(R.string.obfuscated_res_0x7f0f0c42);
            }
            if (i == 0) {
                return this.slider.getContext().getString(R.string.obfuscated_res_0x7f0f0c43);
            }
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float calculateStepIncrement = this.slider.calculateStepIncrement(20);
                if (i2 == 8192) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                if (this.slider.isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                if (this.slider.snapThumbToValue(i, MathUtils.clamp(this.slider.getValues().get(i).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    this.slider.updateHaloHotspot();
                    this.slider.postInvalidate();
                    invalidateVirtualView(i);
                    return true;
                }
                return false;
            }
            if (i2 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.slider.snapThumbToValue(i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.slider.updateHaloHotspot();
                    this.slider.postInvalidate();
                    invalidateVirtualView(i);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            float floatValue = values.get(i).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(startOrEndDescription(i));
                sb.append(this.slider.formatValue(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    private int calculateTop() {
        int i = this.trackTop;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        return i + i2;
    }

    private void dispatchOnChangedProgramatically() {
        for (L l : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f = this.valueTo;
        float f2 = this.valueFrom;
        return (float) ((snapPosition * (f - f2)) + f2);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f = this.touchPosition;
        if (isRtl()) {
            f = 1.0f - f;
        }
        float f2 = this.valueTo;
        float f3 = this.valueFrom;
        return (f * (f2 - f3)) + f3;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void onStartTrackingTouch() {
        for (T t : this.touchListeners) {
            t.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        for (T t : this.touchListeners) {
            t.onStopTrackingTouch(this);
        }
    }

    private boolean shouldDrawCompatHalo() {
        if (!this.forceDrawCompatHalo && Build.VERSION.SDK_INT >= 21 && (getBackground() instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateValueFrom() {
        if (this.valueFrom < this.valueTo) {
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.toString(this.valueFrom), Float.toString(this.valueTo)));
    }

    private void validateValueTo() {
        if (this.valueTo > this.valueFrom) {
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, Float.toString(this.valueTo), Float.toString(this.valueFrom)));
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter != null) {
            return true;
        }
        return false;
    }

    public final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable tooltipDrawable : this.labels) {
            attachLabelToContentView(tooltipDrawable);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        for (TooltipDrawable tooltipDrawable : this.labels) {
            detachLabelFromContentView(tooltipDrawable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    /* loaded from: classes9.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        };
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList<Float> values;

        public SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i) {
        float f;
        float f2;
        float calculateStepIncrement = calculateStepIncrement();
        if ((this.valueTo - this.valueFrom) / calculateStepIncrement <= i) {
            return calculateStepIncrement;
        }
        return Math.round(f / f2) * calculateStepIncrement;
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private void dispatchOnChangedFromUser(int i) {
        for (L l : this.changeListeners) {
            l.onValueChange(this, this.values.get(i).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            scheduleAccessibilityEventSender(i);
        }
    }

    private void focusThumbOnFocusGained(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i == 66) {
                        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
                return;
            }
            moveFocus(Integer.MIN_VALUE);
            return;
        }
        moveFocus(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float f) {
        String str;
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f);
        }
        if (((int) f) == f) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, Float.valueOf(f));
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void loadResources(@NonNull Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070622);
        this.trackSidePadding = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070620);
        this.trackTop = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070621);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07061a);
    }

    private boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(i2 + i, 0L, this.values.size() - 1);
        this.focusedThumbIdx = clamp;
        if (clamp == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl()) {
            if (i == Integer.MIN_VALUE) {
                i = Integer.MAX_VALUE;
            } else {
                i = -i;
            }
        }
        return moveFocus(i);
    }

    private float normalizeValue(float f) {
        float f2 = this.valueFrom;
        float f3 = (f - f2) / (this.valueTo - f2);
        if (isRtl()) {
            return 1.0f - f3;
        }
        return f3;
    }

    private void scheduleAccessibilityEventSender(int i) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private boolean snapActiveThumbToValue(float f) {
        return snapThumbToValue(this.activeThumbIdx, f);
    }

    private double snapPosition(float f) {
        float f2 = this.stepSize;
        if (f2 > 0.0f) {
            int i = (int) ((this.valueTo - this.valueFrom) / f2);
            return Math.round(f * i) / i;
        }
        return f;
    }

    private float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    public void addOnChangeListener(@Nullable L l) {
        this.changeListeners.add(l);
    }

    public void addOnSliderTouchListener(@NonNull T t) {
        this.touchListeners.add(t);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.accessibilityHelper.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z) {
        this.forceDrawCompatHalo = z;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    public void removeOnChangeListener(@NonNull L l) {
        this.changeListeners.remove(l);
    }

    public void removeOnSliderTouchListener(@NonNull T t) {
        this.touchListeners.remove(t);
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int i;
        super.setEnabled(z);
        if (z) {
            i = 0;
        } else {
            i = 2;
        }
        setLayerType(i, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i >= 0 && i < this.values.size()) {
            this.focusedThumbIdx = i;
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i) {
        if (i == this.haloRadius) {
            return;
        }
        this.haloRadius = i;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setThumbElevation(float f) {
        this.thumbDrawable.setElevation(f);
    }

    public void setThumbElevationResource(@DimenRes int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i) {
        if (i == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i;
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        this.thumbDrawable.setFillColor(colorStateList);
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i) {
        if (this.trackHeight != i) {
            this.trackHeight = i;
            invalidateTrack();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040697);
    }

    private float getClampedValue(int i, float f) {
        float floatValue;
        float floatValue2;
        int i2 = i + 1;
        if (i2 >= this.values.size()) {
            floatValue = this.valueTo;
        } else {
            floatValue = this.values.get(i2).floatValue();
        }
        int i3 = i - 1;
        if (i3 < 0) {
            floatValue2 = this.valueFrom;
        } else {
            floatValue2 = this.values.get(i3).floatValue();
        }
        return MathUtils.clamp(f, floatValue2, floatValue);
    }

    @NonNull
    public static TooltipDrawable parseLabelDrawable(@NonNull Context context, @NonNull TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(8, R.style.obfuscated_res_0x7f1003ae));
    }

    public static int pivotIndex(float[] fArr, float f) {
        return Math.round(f * ((fArr.length / 2) - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i, float f) {
        if (Math.abs(f - this.values.get(i).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.values.set(i, Float.valueOf(getClampedValue(i, f)));
        this.focusedThumbIdx = i;
        dispatchOnChangedFromUser(i);
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.widgetHeight;
        int i4 = 0;
        if (this.labelBehavior == 1) {
            i4 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3 + i4, 1073741824));
    }

    public void updateBoundsForVirturalViewId(int i, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int calculateTop = calculateTop();
        int i2 = this.thumbRadius;
        rect.set(normalizeValue - i2, calculateTop - i2, normalizeValue + i2, calculateTop + i2);
    }

    public BaseSlider(@NonNull Context context, @Nullable final AttributeSet attributeSet, final int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.thumbDrawable = new MaterialShapeDrawable();
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.activeTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.thumbPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        this.activeTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new TooltipDrawableFactory() { // from class: com.google.android.material.slider.BaseSlider.1
            @Override // com.google.android.material.slider.BaseSlider.TooltipDrawableFactory
            public TooltipDrawable createTooltipDrawable() {
                TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), attributeSet, com.google.android.material.R.styleable.Slider, i, BaseSlider.DEF_STYLE_RES, new int[0]);
                TooltipDrawable parseLabelDrawable = BaseSlider.parseLabelDrawable(BaseSlider.this.getContext(), obtainStyledAttributes);
                obtainStyledAttributes.recycle();
                return parseLabelDrawable;
            }
        };
        processAttributes(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        this.valueFrom = obtainStyledAttributes.getFloat(3, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(2, 0.0f);
        int i4 = 15;
        boolean hasValue = obtainStyledAttributes.hasValue(15);
        if (hasValue) {
            i2 = 15;
        } else {
            i2 = 17;
        }
        if (!hasValue) {
            i4 = 16;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i2);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607e3);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i4);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607e0);
        }
        setTrackActiveTintList(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, 9));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607e1);
        }
        setHaloTintList(colorStateList3);
        int i5 = 12;
        boolean hasValue2 = obtainStyledAttributes.hasValue(12);
        if (hasValue2) {
            i3 = 12;
        } else {
            i3 = 14;
        }
        if (!hasValue2) {
            i5 = 13;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i3);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607e2);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607df);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(11, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(10, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(18, 0));
        this.labelBehavior = obtainStyledAttributes.getInt(7, 0);
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void drawActiveTrack(@NonNull Canvas canvas, int i, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float f = i;
        float f2 = i2;
        canvas.drawLine(i3 + (activeRange[0] * f), f2, i3 + (activeRange[1] * f), f2, this.activeTrackPaint);
    }

    private Float calculateIncrementForKey(int i) {
        float calculateStepIncrement;
        if (this.isLongPress) {
            calculateStepIncrement = calculateStepIncrement(20);
        } else {
            calculateStepIncrement = calculateStepIncrement();
        }
        if (i != 21) {
            if (i != 22) {
                if (i != 69) {
                    if (i != 70 && i != 81) {
                        return null;
                    }
                    return Float.valueOf(calculateStepIncrement);
                }
                return Float.valueOf(-calculateStepIncrement);
            }
            if (isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return Float.valueOf(calculateStepIncrement);
        }
        if (!isRtl()) {
            calculateStepIncrement = -calculateStepIncrement;
        }
        return Float.valueOf(calculateStepIncrement);
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            if (this.stepSize > 0.0f) {
                calculateTicksCoordinates();
            }
        }
        super.onDraw(canvas);
        int calculateTop = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, calculateTop);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, calculateTop);
        }
        if (this.stepSize > 0.0f) {
            drawTicks(canvas);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, calculateTop);
            if (this.activeThumbIdx != -1) {
                ensureLabels();
            }
        }
        drawThumbs(canvas, this.trackWidth, calculateTop);
    }

    private void calculateTicksCoordinates() {
        validateConfigurationIfDirty();
        int min = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != min * 2) {
            this.ticksCoordinates = new float[min * 2];
        }
        float f = this.trackWidth / (min - 1);
        for (int i = 0; i < min * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = this.trackSidePadding + ((i / 2) * f);
            fArr2[i + 1] = calculateTop();
        }
    }

    private void warnAboutFloatingPointError() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "stepSize", Float.valueOf(f)));
        }
        float f2 = this.valueFrom;
        if (((int) f2) != f2) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "valueFrom", Float.valueOf(f2)));
        }
        float f3 = this.valueTo;
        if (((int) f3) != f3) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, "valueTo", Float.valueOf(f3)));
        }
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable tooltipDrawable : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (this.labels.size() < this.values.size()) {
            TooltipDrawable createTooltipDrawable = this.labelMaker.createTooltipDrawable();
            this.labels.add(createTooltipDrawable);
            if (ViewCompat.isAttachedToWindow(this)) {
                attachLabelToContentView(createTooltipDrawable);
            }
        }
        int i = 1;
        if (this.labels.size() == 1) {
            i = 0;
        }
        for (TooltipDrawable tooltipDrawable2 : this.labels) {
            tooltipDrawable2.setStrokeWidth(i);
        }
    }

    private void ensureLabels() {
        if (this.labelBehavior == 2) {
            return;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
            if (i != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i).floatValue());
            }
        }
        if (it.hasNext()) {
            setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
    }

    private void validateValues() {
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.valueFrom && next.floatValue() <= this.valueTo) {
                if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                    throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)));
                }
            } else {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
            }
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    private void drawInactiveTrack(@NonNull Canvas canvas, int i, int i2) {
        int i3;
        float[] activeRange = getActiveRange();
        float f = i;
        float f2 = this.trackSidePadding + (activeRange[1] * f);
        if (f2 < i3 + i) {
            float f3 = i2;
            canvas.drawLine(f2, f3, i3 + i, f3, this.inactiveTrackPaint);
        }
        int i4 = this.trackSidePadding;
        float f4 = i4 + (activeRange[0] * f);
        if (f4 > i4) {
            float f5 = i2;
            canvas.drawLine(i4, f5, f4, f5, this.inactiveTrackPaint);
        }
    }

    private void maybeDrawHalo(@NonNull Canvas canvas, int i, int i2) {
        if (shouldDrawCompatHalo()) {
            int normalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i));
            if (Build.VERSION.SDK_INT < 28) {
                int i3 = this.haloRadius;
                canvas.clipRect(normalizeValue - i3, i2 - i3, normalizeValue + i3, i3 + i2, Region.Op.UNION);
            }
            canvas.drawCircle(normalizeValue, i2, this.haloRadius, this.haloPaint);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            this.activeThumbIdx = -1;
            for (TooltipDrawable tooltipDrawable : this.labels) {
                ViewUtils.getContentViewOverlay(this).remove(tooltipDrawable);
            }
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        focusThumbOnFocusGained(i);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    private void drawThumbs(@NonNull Canvas canvas, int i, int i2) {
        if (!isEnabled()) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.trackSidePadding + (normalizeValue(it.next().floatValue()) * i), i2, this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(it2.next().floatValue()) * i));
            int i3 = this.thumbRadius;
            canvas.translate(normalizeValue - i3, i2 - i3);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void drawTicks(@NonNull Canvas canvas) {
        float[] activeRange = getActiveRange();
        int pivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int pivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int i = pivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, i, this.inactiveTicksPaint);
        int i2 = pivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, i, i2 - i, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.inactiveTicksPaint);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
                return;
            }
            this.values = arrayList;
            this.dirtyConfig = true;
            this.focusedThumbIdx = 0;
            updateHaloHotspot();
            createLabelPool();
            dispatchOnChangedProgramatically();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean valueLandsOnTick(float f) {
        double doubleValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(doubleValue) - doubleValue) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.stepSize != f) {
                this.stepSize = f;
                this.dirtyConfig = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(f), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue2);
        float normalizeValue2 = normalizeValue(floatValue);
        return isRtl() ? new float[]{normalizeValue2, normalizeValue} : new float[]{normalizeValue, normalizeValue2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
                int calculateTop = calculateTop();
                int i = this.haloRadius;
                DrawableCompat.setHotspotBounds(background, normalizeValue - i, calculateTop - i, normalizeValue + i, calculateTop + i);
            }
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private Boolean onKeyDownNoActiveThumb(int i, @NonNull KeyEvent keyEvent) {
        if (i != 61) {
            if (i != 66) {
                if (i != 81) {
                    if (i != 69) {
                        if (i != 70) {
                            switch (i) {
                                case 21:
                                    moveFocusInAbsoluteDirection(-1);
                                    return Boolean.TRUE;
                                case 22:
                                    moveFocusInAbsoluteDirection(1);
                                    return Boolean.TRUE;
                                case 23:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        moveFocus(-1);
                        return Boolean.TRUE;
                    }
                }
                moveFocus(1);
                return Boolean.TRUE;
            }
            this.activeThumbIdx = this.focusedThumbIdx;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(moveFocus(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(moveFocus(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        tooltipDrawable.setText(formatValue(f));
        int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i, keyEvent);
            if (onKeyDownNoActiveThumb != null) {
                return onKeyDownNoActiveThumb.booleanValue();
            }
            return super.onKeyDown(i, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i != 61) {
                if (i != 66) {
                    return super.onKeyDown(i, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(1);
            } else {
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return moveFocus(-1);
            }
        }
        this.activeThumbIdx = -1;
        for (TooltipDrawable tooltipDrawable : this.labels) {
            ViewUtils.getContentViewOverlay(this).remove(tooltipDrawable);
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        if (this.stepSize > 0.0f) {
            calculateTicksCoordinates();
        }
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f = (x - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = f;
        float max = Math.max(0.0f, f);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.thumbIsPressed) {
                        if (Math.abs(x - this.touchDownX) < this.scaledTouchSlop) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        onStartTrackingTouch();
                    }
                    if (pickActiveThumb()) {
                        this.thumbIsPressed = true;
                        snapTouchPosition();
                        updateHaloHotspot();
                        invalidate();
                    }
                }
            } else {
                this.thumbIsPressed = false;
                MotionEvent motionEvent2 = this.lastEvent;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= this.scaledTouchSlop && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= this.scaledTouchSlop) {
                    pickActiveThumb();
                }
                if (this.activeThumbIdx != -1) {
                    snapTouchPosition();
                    this.activeThumbIdx = -1;
                }
                for (TooltipDrawable tooltipDrawable : this.labels) {
                    ViewUtils.getContentViewOverlay(this).remove(tooltipDrawable);
                }
                onStopTrackingTouch();
                invalidate();
            }
        } else {
            this.touchDownX = x;
            if (!isInScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    public boolean pickActiveThumb() {
        boolean z;
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float abs2 = Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            if (!isRtl() ? valueToX2 - valueToX < 0.0f : valueToX2 - valueToX > 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                    this.activeThumbIdx = -1;
                    return false;
                } else if (z) {
                    this.activeThumbIdx = i;
                }
            }
            abs = abs2;
        }
        if (this.activeThumbIdx != -1) {
            return true;
        }
        return false;
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }
}
