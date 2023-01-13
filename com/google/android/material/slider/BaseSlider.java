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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_STYLE_RES;
    public static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    public static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    public static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    public static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    public static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    public static final int HALO_ALPHA = 63;
    public static final String TAG;
    public static final double THRESHOLD = 1.0E-4d;
    public static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    /* loaded from: classes7.dex */
    public class AccessibilityEventSender implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSlider this$0;
        public int virtualViewId;

        public AccessibilityEventSender(BaseSlider baseSlider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseSlider;
            this.virtualViewId = -1;
        }

        public void setVirtualViewId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.virtualViewId = i;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class AccessibilityHelper extends ExploreByTouchHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BaseSlider<?, ?, ?> slider;
        public Rect virtualViewBounds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }

        @NonNull
        private String startOrEndDescription(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
                if (i == this.slider.getValues().size() - 1) {
                    return this.slider.getContext().getString(R.string.obfuscated_res_0x7f0f0b29);
                }
                if (i == 0) {
                    return this.slider.getContext().getString(R.string.obfuscated_res_0x7f0f0b2a);
                }
                return "";
            }
            return (String) invokeI.objValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
                for (int i = 0; i < this.slider.getValues().size(); i++) {
                    this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
                    if (this.virtualViewBounds.contains((int) f, (int) f2)) {
                        return i;
                    }
                }
                return -1;
            }
            return invokeCommon.intValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                for (int i = 0; i < this.slider.getValues().size(); i++) {
                    list.add(Integer.valueOf(i));
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, bundle)) == null) {
                if (!this.slider.isEnabled()) {
                    return false;
                }
                if (i2 != 4096 && i2 != 8192) {
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
                float calculateStepIncrement = this.slider.calculateStepIncrement(20);
                if (i2 == 8192) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                if (this.slider.isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                if (!this.slider.snapThumbToValue(i, MathUtils.clamp(this.slider.getValues().get(i).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    return false;
                }
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(i);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, accessibilityNodeInfoCompat) == null) {
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
    }

    /* loaded from: classes7.dex */
    public static class SliderState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SliderState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList<Float> values;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1298596037, "Lcom/google/android/material/slider/BaseSlider$SliderState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1298596037, "Lcom/google/android/material/slider/BaseSlider$SliderState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SliderState createFromParcel(@NonNull Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SliderState(parcel);
                    }
                    return (SliderState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SliderState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new SliderState[i];
                    }
                    return (SliderState[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SliderState(@NonNull Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeFloat(this.valueFrom);
                parcel.writeFloat(this.valueTo);
                parcel.writeList(this.values);
                parcel.writeFloat(this.stepSize);
                parcel.writeBooleanArray(new boolean[]{this.hasFocus});
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SliderState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(960331047, "Lcom/google/android/material/slider/BaseSlider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(960331047, "Lcom/google/android/material/slider/BaseSlider;");
                return;
            }
        }
        TAG = BaseSlider.class.getSimpleName();
        DEF_STYLE_RES = R.style.obfuscated_res_0x7f100383;
    }

    private float calculateStepIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            float f = this.stepSize;
            if (f == 0.0f) {
                return 1.0f;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    private int calculateTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            int i = this.trackTop;
            int i2 = 0;
            if (this.labelBehavior == 1) {
                i2 = this.labels.get(0).getIntrinsicHeight();
            }
            return i + i2;
        }
        return invokeV.intValue;
    }

    private float getValueOfTouchPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            double snapPosition = snapPosition(this.touchPosition);
            if (isRtl()) {
                snapPosition = 1.0d - snapPosition;
            }
            float f = this.valueTo;
            float f2 = this.valueFrom;
            return (float) ((snapPosition * (f - f2)) + f2);
        }
        return invokeV.floatValue;
    }

    private float getValueOfTouchPositionAbsolute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            float f = this.touchPosition;
            if (isRtl()) {
                f = 1.0f - f;
            }
            float f2 = this.valueTo;
            float f3 = this.valueFrom;
            return (f * (f2 - f3)) + f3;
        }
        return invokeV.floatValue;
    }

    private boolean isInScrollingContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void onStartTrackingTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            for (T t : this.touchListeners) {
                t.onStartTrackingTouch(this);
            }
        }
    }

    private void onStopTrackingTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            for (T t : this.touchListeners) {
                t.onStopTrackingTouch(this);
            }
        }
    }

    private boolean shouldDrawCompatHalo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            if (!this.forceDrawCompatHalo && Build.VERSION.SDK_INT >= 21 && (getBackground() instanceof RippleDrawable)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean snapTouchPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) {
            return snapActiveThumbToValue(getValueOfTouchPosition());
        }
        return invokeV.booleanValue;
    }

    private void validateConfigurationIfDirty() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65591, this) == null) && this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    public void clearOnChangeListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.changeListeners.clear();
        }
    }

    public void clearOnSliderTouchListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.touchListeners.clear();
        }
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return SeekBar.class.getName();
        }
        return (CharSequence) invokeV.objValue;
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
        }
        return invokeV.intValue;
    }

    public int getActiveThumbIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.activeThumbIdx;
        }
        return invokeV.intValue;
    }

    public int getFocusedThumbIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.focusedThumbIdx;
        }
        return invokeV.intValue;
    }

    @Dimension
    public int getHaloRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.haloRadius;
        }
        return invokeV.intValue;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.haloColor;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public int getLabelBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.labelBehavior;
        }
        return invokeV.intValue;
    }

    public float getStepSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.stepSize;
        }
        return invokeV.floatValue;
    }

    public float getThumbElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.thumbDrawable.getElevation();
        }
        return invokeV.floatValue;
    }

    @Dimension
    public int getThumbRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.thumbRadius;
        }
        return invokeV.intValue;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.thumbDrawable.getFillColor();
        }
        return (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.tickColorActive;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.tickColorInactive;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.tickColorInactive.equals(this.tickColorActive)) {
                return this.tickColorActive;
            }
            throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        }
        return (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.trackColorActive;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getTrackHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.trackHeight;
        }
        return invokeV.intValue;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.trackColorInactive;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getTrackSidePadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.trackSidePadding;
        }
        return invokeV.intValue;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.trackColorInactive.equals(this.trackColorActive)) {
                return this.trackColorActive;
            }
            throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getTrackWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.trackWidth;
        }
        return invokeV.intValue;
    }

    public float getValueFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.valueFrom;
        }
        return invokeV.floatValue;
    }

    public float getValueTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.valueTo;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public List<Float> getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return new ArrayList(this.values);
        }
        return (List) invokeV.objValue;
    }

    public boolean hasLabelFormatter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.formatter != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onAttachedToWindow();
            for (TooltipDrawable tooltipDrawable : this.labels) {
                attachLabelToContentView(tooltipDrawable);
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
            if (accessibilityEventSender != null) {
                removeCallbacks(accessibilityEventSender);
            }
            for (TooltipDrawable tooltipDrawable : this.labels) {
                detachLabelFromContentView(tooltipDrawable);
            }
            super.onDetachedFromWindow();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlider(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void dispatchOnChangedFromUser(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i) == null) {
            for (L l : this.changeListeners) {
                l.onValueChange(this, this.values.get(i).floatValue(), true);
            }
            AccessibilityManager accessibilityManager = this.accessibilityManager;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                scheduleAccessibilityEventSender(i);
            }
        }
    }

    private void drawTicks(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, canvas) == null) {
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
    }

    private void focusThumbOnFocusGained(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float f) {
        InterceptResult invokeF;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65563, this, f)) == null) {
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
        return (String) invokeF.objValue;
    }

    private void loadResources(@NonNull Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, resources) == null) {
            this.widgetHeight = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704ce);
            this.trackSidePadding = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704cb);
            this.trackTop = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704cc);
            this.labelPadding = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c5);
        }
    }

    private boolean moveFocus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65573, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, parcelable) == null) {
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
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, colorStateList) != null) || colorStateList.equals(this.haloColor)) {
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

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048634, this, i) != null) || i == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i;
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040633);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private float getClampedValue(int i, float f) {
        InterceptResult invokeCommon;
        float floatValue;
        float floatValue2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
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
        return invokeCommon.floatValue;
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65583, this, tooltipDrawable, f) == null) {
            tooltipDrawable.setText(formatValue(f));
            int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
            tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
            Rect rect = new Rect(tooltipDrawable.getBounds());
            DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
            tooltipDrawable.setBounds(rect);
            ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (Math.abs(f - this.values.get(i).floatValue()) < 1.0E-4d) {
                return false;
            }
            this.values.set(i, Float.valueOf(getClampedValue(i, f)));
            this.focusedThumbIdx = i;
            dispatchOnChangedFromUser(i);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
        this.labelMaker = new TooltipDrawableFactory(this, attributeSet, i) { // from class: com.google.android.material.slider.BaseSlider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseSlider this$0;
            public final /* synthetic */ AttributeSet val$attrs;
            public final /* synthetic */ int val$defStyleAttr;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, attributeSet, Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$attrs = attributeSet;
                this.val$defStyleAttr = i;
            }

            @Override // com.google.android.material.slider.BaseSlider.TooltipDrawableFactory
            public TooltipDrawable createTooltipDrawable() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.this$0.getContext(), this.val$attrs, com.google.android.material.R.styleable.Slider, this.val$defStyleAttr, BaseSlider.DEF_STYLE_RES, new int[0]);
                    TooltipDrawable parseLabelDrawable = BaseSlider.parseLabelDrawable(this.this$0.getContext(), obtainStyledAttributes);
                    obtainStyledAttributes.recycle();
                    return parseLabelDrawable;
                }
                return (TooltipDrawable) invokeV.objValue;
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

    @NonNull
    public static TooltipDrawable parseLabelDrawable(@NonNull Context context, @NonNull TypedArray typedArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, context, typedArray)) == null) {
            return TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(8, R.style.obfuscated_res_0x7f10039b));
        }
        return (TooltipDrawable) invokeLL.objValue;
    }

    public static int pivotIndex(float[] fArr, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65580, null, fArr, f)) == null) {
            return Math.round(f * ((fArr.length / 2) - 1));
        }
        return invokeLF.intValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i, keyEvent)) == null) {
            this.isLongPress = false;
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i, i2) == null) {
            int i3 = this.widgetHeight;
            int i4 = 0;
            if (this.labelBehavior == 1) {
                i4 = this.labels.get(0).getIntrinsicHeight();
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3 + i4, 1073741824));
        }
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, tooltipDrawable) == null) {
            tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i) {
        InterceptResult invokeI;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i)) == null) {
            float calculateStepIncrement = calculateStepIncrement();
            if ((this.valueTo - this.valueFrom) / calculateStepIncrement <= i) {
                return calculateStepIncrement;
            }
            return Math.round(f / f2) * calculateStepIncrement;
        }
        return invokeI.floatValue;
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, tooltipDrawable) == null) && (contentViewOverlay = ViewUtils.getContentViewOverlay(this)) != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, colorStateList)) == null) {
            return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        }
        return invokeL.intValue;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65574, this, i)) == null) {
            if (isRtl()) {
                if (i == Integer.MIN_VALUE) {
                    i = Integer.MAX_VALUE;
                } else {
                    i = -i;
                }
            }
            return moveFocus(i);
        }
        return invokeI.booleanValue;
    }

    private float normalizeValue(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65575, this, f)) == null) {
            float f2 = this.valueFrom;
            float f3 = (f - f2) / (this.valueTo - f2);
            if (isRtl()) {
                return 1.0f - f3;
            }
            return f3;
        }
        return invokeF.floatValue;
    }

    private void scheduleAccessibilityEventSender(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65582, this, i) == null) {
            BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
            if (accessibilityEventSender == null) {
                this.accessibilityEventSender = new AccessibilityEventSender();
            } else {
                removeCallbacks(accessibilityEventSender);
            }
            this.accessibilityEventSender.setVirtualViewId(i);
            postDelayed(this.accessibilityEventSender, 200L);
        }
    }

    private boolean snapActiveThumbToValue(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65586, this, f)) == null) {
            return snapThumbToValue(this.activeThumbIdx, f);
        }
        return invokeF.booleanValue;
    }

    private double snapPosition(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65587, this, f)) == null) {
            float f2 = this.stepSize;
            if (f2 > 0.0f) {
                int i = (int) ((this.valueTo - this.valueFrom) / f2);
                return Math.round(f * i) / i;
            }
            return f;
        }
        return invokeF.doubleValue;
    }

    private float valueToX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65597, this, f)) == null) {
            return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
        }
        return invokeF.floatValue;
    }

    public void addOnChangeListener(@Nullable L l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
            this.changeListeners.add(l);
        }
    }

    public void addOnSliderTouchListener(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.touchListeners.add(t);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (!this.accessibilityHelper.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keyEvent)) == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.forceDrawCompatHalo = z;
        }
    }

    public void removeOnChangeListener(@NonNull L l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, l) == null) {
            this.changeListeners.remove(l);
        }
    }

    public void removeOnSliderTouchListener(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, t) == null) {
            this.touchListeners.remove(t);
        }
    }

    public void setActiveThumbIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.activeThumbIdx = i;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                i = 0;
            } else {
                i = 2;
            }
            setLayerType(i, null);
        }
    }

    public void setFocusedThumbIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            if (i >= 0 && i < this.values.size()) {
                this.focusedThumbIdx = i;
                this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
                postInvalidate();
                return;
            }
            throw new IllegalArgumentException("index out of range");
        }
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048626, this, i) != null) || i == this.haloRadius) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            setHaloRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setLabelBehavior(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && this.labelBehavior != i) {
            this.labelBehavior = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, labelFormatter) == null) {
            this.formatter = labelFormatter;
        }
    }

    public void setThumbElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f) == null) {
            this.thumbDrawable.setElevation(f);
        }
    }

    public void setThumbElevationResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            setThumbElevation(getResources().getDimension(i));
        }
    }

    public void setThumbRadiusResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            setThumbRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, colorStateList) == null) {
            this.thumbDrawable.setFillColor(colorStateList);
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, colorStateList) != null) || colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, colorStateList) != null) || colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, colorStateList) == null) {
            setTickInactiveTintList(colorStateList);
            setTickActiveTintList(colorStateList);
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, colorStateList) != null) || colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i) == null) && this.trackHeight != i) {
            this.trackHeight = i;
            invalidateTrack();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048642, this, colorStateList) != null) || colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, colorStateList) == null) {
            setTrackInactiveTintList(colorStateList);
            setTrackActiveTintList(colorStateList);
        }
    }

    public void setValueFrom(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048644, this, f) == null) {
            this.valueFrom = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setValueTo(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f) == null) {
            this.valueTo = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setValues(@NonNull List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, list) == null) {
            setValuesInternal(new ArrayList<>(list));
        }
    }

    private void drawActiveTrack(@NonNull Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65557, this, canvas, i, i2) == null) {
            float[] activeRange = getActiveRange();
            int i3 = this.trackSidePadding;
            float f = i;
            float f2 = i2;
            canvas.drawLine(i3 + (activeRange[0] * f), f2, i3 + (activeRange[1] * f), f2, this.activeTrackPaint);
        }
    }

    private Float calculateIncrementForKey(int i) {
        InterceptResult invokeI;
        float calculateStepIncrement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
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
        return (Float) invokeI.objValue;
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, this, arrayList) == null) {
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
    }

    private boolean valueLandsOnTick(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65596, this, f)) == null) {
            double doubleValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
            if (Math.abs(Math.round(doubleValue) - doubleValue) < 1.0E-4d) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public void setStepSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f) == null) {
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
    }

    private void calculateTicksCoordinates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
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
    }

    private float[] getActiveRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            float floatValue = ((Float) Collections.max(getValues())).floatValue();
            float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
            if (this.values.size() == 1) {
                floatValue2 = this.valueFrom;
            }
            float normalizeValue = normalizeValue(floatValue2);
            float normalizeValue2 = normalizeValue(floatValue);
            return isRtl() ? new float[]{normalizeValue2, normalizeValue} : new float[]{normalizeValue, normalizeValue2};
        }
        return (float[]) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65590, this) == null) && !shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65592, this) == null) && this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private void createLabelPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
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
    }

    private void ensureLabels() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65561, this) != null) || this.labelBehavior == 2) {
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

    private void warnAboutFloatingPointError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
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
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
    }

    private void dispatchOnChangedProgramatically() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            for (L l : this.changeListeners) {
                Iterator<Float> it = this.values.iterator();
                while (it.hasNext()) {
                    l.onValueChange(this, it.next().floatValue(), false);
                }
            }
        }
    }

    private void invalidateTrack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
            this.activeTrackPaint.setStrokeWidth(this.trackHeight);
            this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
            this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        }
    }

    private void validateValueFrom() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65593, this) != null) || this.valueFrom < this.valueTo) {
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.toString(this.valueFrom), Float.toString(this.valueTo)));
    }

    private void validateValueTo() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65594, this) != null) || this.valueTo > this.valueFrom) {
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, Float.toString(this.valueTo), Float.toString(this.valueFrom)));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SliderState sliderState = new SliderState(super.onSaveInstanceState());
            sliderState.valueFrom = this.valueFrom;
            sliderState.valueTo = this.valueTo;
            sliderState.values = new ArrayList<>(this.values);
            sliderState.stepSize = this.stepSize;
            sliderState.hasFocus = hasFocus();
            return sliderState;
        }
        return (Parcelable) invokeV.objValue;
    }

    private void drawInactiveTrack(@NonNull Canvas canvas, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65558, this, canvas, i, i2) == null) {
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
    }

    private void maybeDrawHalo(@NonNull Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65572, this, canvas, i, i2) == null) && shouldDrawCompatHalo()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
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
    }

    private void drawThumbs(@NonNull Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65559, this, canvas, i, i2) == null) {
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
    }

    private Boolean onKeyDownNoActiveThumb(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65576, this, i, keyEvent)) == null) {
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
        return (Boolean) invokeIL.objValue;
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65581, this, context, attributeSet, i) == null) {
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
                colorStateList = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607cc);
            }
            setTrackInactiveTintList(colorStateList);
            ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i4);
            if (colorStateList2 == null) {
                colorStateList2 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607c9);
            }
            setTrackActiveTintList(colorStateList2);
            this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, 9));
            ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
            if (colorStateList3 == null) {
                colorStateList3 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607ca);
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
                colorStateList4 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607cb);
            }
            setTickInactiveTintList(colorStateList4);
            ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
            if (colorStateList5 == null) {
                colorStateList5 = AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0607c8);
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
    }

    private void validateValues() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
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
    }

    public boolean pickActiveThumb() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, canvas) == null) {
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
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, keyEvent)) == null) {
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
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i, i2, i3, i4) == null) {
            this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
            if (this.stepSize > 0.0f) {
                calculateTicksCoordinates();
            }
            updateHaloHotspot();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setValues(@NonNull Float... fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, fArr) == null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            Collections.addAll(arrayList, fArr);
            setValuesInternal(arrayList);
        }
    }

    public void updateBoundsForVirturalViewId(int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048648, this, i, rect) == null) {
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
            int calculateTop = calculateTop();
            int i2 = this.thumbRadius;
            rect.set(normalizeValue - i2, calculateTop - i2, normalizeValue + i2, calculateTop + i2);
        }
    }
}
