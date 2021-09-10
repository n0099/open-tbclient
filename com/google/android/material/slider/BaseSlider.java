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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
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
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseSlider;
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
            }
        }

        public void setVirtualViewId(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.virtualViewId = i2;
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        private String startOrEndDescription(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
                if (i2 == this.slider.getValues().size() - 1) {
                    return this.slider.getContext().getString(R.string.material_slider_range_end);
                }
                return i2 == 0 ? this.slider.getContext().getString(R.string.material_slider_range_start) : "";
            }
            return (String) invokeI.objValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                for (int i2 = 0; i2 < this.slider.getValues().size(); i2++) {
                    this.slider.updateBoundsForVirturalViewId(i2, this.virtualViewBounds);
                    if (this.virtualViewBounds.contains((int) f2, (int) f3)) {
                        return i2;
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
                for (int i2 = 0; i2 < this.slider.getValues().size(); i2++) {
                    list.add(Integer.valueOf(i2));
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, bundle)) == null) {
                if (this.slider.isEnabled()) {
                    if (i3 == 4096 || i3 == 8192) {
                        float calculateStepIncrement = this.slider.calculateStepIncrement(20);
                        if (i3 == 8192) {
                            calculateStepIncrement = -calculateStepIncrement;
                        }
                        if (this.slider.isRtl()) {
                            calculateStepIncrement = -calculateStepIncrement;
                        }
                        if (this.slider.snapThumbToValue(i2, MathUtils.clamp(this.slider.getValues().get(i2).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                            this.slider.updateHaloHotspot();
                            this.slider.postInvalidate();
                            invalidateVirtualView(i2);
                            return true;
                        }
                        return false;
                    }
                    if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                        if (this.slider.snapThumbToValue(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                            this.slider.updateHaloHotspot();
                            this.slider.postInvalidate();
                            invalidateVirtualView(i2);
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, accessibilityNodeInfoCompat) == null) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
                List<Float> values = this.slider.getValues();
                float floatValue = values.get(i2).floatValue();
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
                    sb.append(startOrEndDescription(i2));
                    sb.append(this.slider.formatValue(floatValue));
                }
                accessibilityNodeInfoCompat.setContentDescription(sb.toString());
                this.slider.updateBoundsForVirturalViewId(i2, this.virtualViewBounds);
                accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SliderState(parcel) : (SliderState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SliderState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SliderState[i2] : (SliderState[]) invokeI.objValue;
                }
            };
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    }

    /* loaded from: classes10.dex */
    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
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
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, tooltipDrawable) == null) {
            tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
        }
    }

    private Float calculateIncrementForKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
            float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
            if (i2 == 21) {
                if (!isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                return Float.valueOf(calculateStepIncrement);
            } else if (i2 == 22) {
                if (isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                return Float.valueOf(calculateStepIncrement);
            } else if (i2 != 69) {
                if (i2 == 70 || i2 == 81) {
                    return Float.valueOf(calculateStepIncrement);
                }
                return null;
            } else {
                return Float.valueOf(-calculateStepIncrement);
            }
        }
        return (Float) invokeI.objValue;
    }

    private float calculateStepIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            float f2 = this.stepSize;
            if (f2 == 0.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeV.floatValue;
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
            float f2 = this.trackWidth / (min - 1);
            for (int i2 = 0; i2 < min * 2; i2 += 2) {
                float[] fArr2 = this.ticksCoordinates;
                fArr2[i2] = this.trackSidePadding + ((i2 / 2) * f2);
                fArr2[i2 + 1] = calculateTop();
            }
        }
    }

    private int calculateTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            return this.trackTop + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0);
        }
        return invokeV.intValue;
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
            int i2 = this.labels.size() == 1 ? 0 : 1;
            for (TooltipDrawable tooltipDrawable2 : this.labels) {
                tooltipDrawable2.setStrokeWidth(i2);
            }
        }
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, tooltipDrawable) == null) || (contentViewOverlay = ViewUtils.getContentViewOverlay(this)) == null) {
            return;
        }
        contentViewOverlay.remove(tooltipDrawable);
        tooltipDrawable.detachView(ViewUtils.getContentView(this));
    }

    private void dispatchOnChangedFromUser(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            for (L l : this.changeListeners) {
                l.onValueChange(this, this.values.get(i2).floatValue(), true);
            }
            AccessibilityManager accessibilityManager = this.accessibilityManager;
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            scheduleAccessibilityEventSender(i2);
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

    private void drawActiveTrack(@NonNull Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65557, this, canvas, i2, i3) == null) {
            float[] activeRange = getActiveRange();
            int i4 = this.trackSidePadding;
            float f2 = i2;
            float f3 = i3;
            canvas.drawLine(i4 + (activeRange[0] * f2), f3, i4 + (activeRange[1] * f2), f3, this.activeTrackPaint);
        }
    }

    private void drawInactiveTrack(@NonNull Canvas canvas, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65558, this, canvas, i2, i3) == null) {
            float[] activeRange = getActiveRange();
            float f2 = i2;
            float f3 = this.trackSidePadding + (activeRange[1] * f2);
            if (f3 < i4 + i2) {
                float f4 = i3;
                canvas.drawLine(f3, f4, i4 + i2, f4, this.inactiveTrackPaint);
            }
            int i5 = this.trackSidePadding;
            float f5 = i5 + (activeRange[0] * f2);
            if (f5 > i5) {
                float f6 = i3;
                canvas.drawLine(i5, f6, f5, f6, this.inactiveTrackPaint);
            }
        }
    }

    private void drawThumbs(@NonNull Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65559, this, canvas, i2, i3) == null) {
            if (!isEnabled()) {
                Iterator<Float> it = this.values.iterator();
                while (it.hasNext()) {
                    canvas.drawCircle(this.trackSidePadding + (normalizeValue(it.next().floatValue()) * i2), i3, this.thumbRadius, this.thumbPaint);
                }
            }
            Iterator<Float> it2 = this.values.iterator();
            while (it2.hasNext()) {
                canvas.save();
                int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(it2.next().floatValue()) * i2));
                int i4 = this.thumbRadius;
                canvas.translate(normalizeValue - i4, i3 - i4);
                this.thumbDrawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void drawTicks(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, canvas) == null) {
            float[] activeRange = getActiveRange();
            int pivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
            int pivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
            int i2 = pivotIndex * 2;
            canvas.drawPoints(this.ticksCoordinates, 0, i2, this.inactiveTicksPaint);
            int i3 = pivotIndex2 * 2;
            canvas.drawPoints(this.ticksCoordinates, i2, i3 - i2, this.activeTicksPaint);
            float[] fArr = this.ticksCoordinates;
            canvas.drawPoints(fArr, i3, fArr.length - i3, this.inactiveTicksPaint);
        }
    }

    private void ensureLabels() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.labelBehavior == 2) {
            return;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i2 = 0; i2 < this.values.size() && it.hasNext(); i2++) {
            if (i2 != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i2).floatValue());
            }
        }
        if (it.hasNext()) {
            setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
    }

    private void focusThumbOnFocusGained(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i2) == null) {
            if (i2 == 1) {
                moveFocus(Integer.MAX_VALUE);
            } else if (i2 == 2) {
                moveFocus(Integer.MIN_VALUE);
            } else if (i2 == 17) {
                moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
            } else if (i2 != 66) {
            } else {
                moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65563, this, f2)) == null) {
            if (hasLabelFormatter()) {
                return this.formatter.getFormattedValue(f2);
            }
            return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
        }
        return (String) invokeF.objValue;
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

    private float getClampedValue(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int i3 = i2 + 1;
            int i4 = i2 - 1;
            return MathUtils.clamp(f2, i4 < 0 ? this.valueFrom : this.values.get(i4).floatValue(), i3 >= this.values.size() ? this.valueTo : this.values.get(i3).floatValue());
        }
        return invokeCommon.floatValue;
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, this, colorStateList)) == null) ? colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()) : invokeL.intValue;
    }

    private float getValueOfTouchPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            double snapPosition = snapPosition(this.touchPosition);
            if (isRtl()) {
                snapPosition = 1.0d - snapPosition;
            }
            float f2 = this.valueTo;
            float f3 = this.valueFrom;
            return (float) ((snapPosition * (f2 - f3)) + f3);
        }
        return invokeV.floatValue;
    }

    private float getValueOfTouchPositionAbsolute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            float f2 = this.touchPosition;
            if (isRtl()) {
                f2 = 1.0f - f2;
            }
            float f3 = this.valueTo;
            float f4 = this.valueFrom;
            return (f2 * (f3 - f4)) + f4;
        }
        return invokeV.floatValue;
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

    private void loadResources(@NonNull Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, resources) == null) {
            this.widgetHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
            this.trackSidePadding = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
            this.trackTop = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
            this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        }
    }

    private void maybeDrawHalo(@NonNull Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65572, this, canvas, i2, i3) == null) && shouldDrawCompatHalo()) {
            int normalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.haloRadius;
                canvas.clipRect(normalizeValue - i4, i3 - i4, normalizeValue + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(normalizeValue, i3, this.haloRadius, this.haloPaint);
        }
    }

    private boolean moveFocus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65573, this, i2)) == null) {
            int i3 = this.focusedThumbIdx;
            int clamp = (int) MathUtils.clamp(i3 + i2, 0L, this.values.size() - 1);
            this.focusedThumbIdx = clamp;
            if (clamp == i3) {
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

    private boolean moveFocusInAbsoluteDirection(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65574, this, i2)) == null) {
            if (isRtl()) {
                i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
            }
            return moveFocus(i2);
        }
        return invokeI.booleanValue;
    }

    private float normalizeValue(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65575, this, f2)) == null) {
            float f3 = this.valueFrom;
            float f4 = (f2 - f3) / (this.valueTo - f3);
            return isRtl() ? 1.0f - f4 : f4;
        }
        return invokeF.floatValue;
    }

    private Boolean onKeyDownNoActiveThumb(int i2, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65576, this, i2, keyEvent)) == null) {
            if (i2 != 61) {
                if (i2 != 66) {
                    if (i2 != 81) {
                        if (i2 == 69) {
                            moveFocus(-1);
                            return Boolean.TRUE;
                        } else if (i2 != 70) {
                            switch (i2) {
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

    @NonNull
    public static TooltipDrawable parseLabelDrawable(@NonNull Context context, @NonNull TypedArray typedArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, context, typedArray)) == null) ? TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip)) : (TooltipDrawable) invokeLL.objValue;
    }

    public static int pivotIndex(float[] fArr, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65580, null, fArr, f2)) == null) ? Math.round(f2 * ((fArr.length / 2) - 1)) : invokeLF.intValue;
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65581, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i2, DEF_STYLE_RES, new int[0]);
            this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
            this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
            setValues(Float.valueOf(this.valueFrom));
            this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.Slider_trackColor);
            int i3 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
            int i4 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
            ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i3);
            if (colorStateList == null) {
                colorStateList = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
            }
            setTrackInactiveTintList(colorStateList);
            ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i4);
            if (colorStateList2 == null) {
                colorStateList2 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
            }
            setTrackActiveTintList(colorStateList2);
            this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
            ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
            if (colorStateList3 == null) {
                colorStateList3 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
            }
            setHaloTintList(colorStateList3);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.Slider_tickColor);
            int i5 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
            int i6 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
            ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
            if (colorStateList4 == null) {
                colorStateList4 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
            }
            setTickInactiveTintList(colorStateList4);
            ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i6);
            if (colorStateList5 == null) {
                colorStateList5 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
            }
            setTickActiveTintList(colorStateList5);
            setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
            setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
            setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
            setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
            this.labelBehavior = obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0);
            if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
                setEnabled(false);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void scheduleAccessibilityEventSender(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65582, this, i2) == null) {
            BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
            if (accessibilityEventSender == null) {
                this.accessibilityEventSender = new AccessibilityEventSender();
            } else {
                removeCallbacks(accessibilityEventSender);
            }
            this.accessibilityEventSender.setVirtualViewId(i2);
            postDelayed(this.accessibilityEventSender, 200L);
        }
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65583, this, tooltipDrawable, f2) == null) {
            tooltipDrawable.setText(formatValue(f2));
            int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f2) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
            tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
            Rect rect = new Rect(tooltipDrawable.getBounds());
            DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
            tooltipDrawable.setBounds(rect);
            ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
        }
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

    private boolean shouldDrawCompatHalo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) ? this.forceDrawCompatHalo || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable) : invokeV.booleanValue;
    }

    private boolean snapActiveThumbToValue(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65586, this, f2)) == null) ? snapThumbToValue(this.activeThumbIdx, f2) : invokeF.booleanValue;
    }

    private double snapPosition(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65587, this, f2)) == null) {
            float f3 = this.stepSize;
            if (f3 > 0.0f) {
                int i2 = (int) ((this.valueTo - this.valueFrom) / f3);
                return Math.round(f2 * i2) / i2;
            }
            return f2;
        }
        return invokeF.doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            if (Math.abs(f2 - this.values.get(i2).floatValue()) < 1.0E-4d) {
                return false;
            }
            this.values.set(i2, Float.valueOf(getClampedValue(i2, f2)));
            this.focusedThumbIdx = i2;
            dispatchOnChangedFromUser(i2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean snapTouchPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) ? snapActiveThumbToValue(getValueOfTouchPosition()) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65590, this) == null) || shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int calculateTop = calculateTop();
            int i2 = this.haloRadius;
            DrawableCompat.setHotspotBounds(background, normalizeValue - i2, calculateTop - i2, normalizeValue + i2, calculateTop + i2);
        }
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

    private void validateStepSize() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65592, this) == null) && this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private void validateValueFrom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65593, this) == null) && this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    private void validateValueTo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65594, this) == null) && this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, Float.toString(this.valueTo), Float.toString(this.valueFrom)));
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

    private boolean valueLandsOnTick(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65596, this, f2)) == null) {
            double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
            return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
        }
        return invokeF.booleanValue;
    }

    private float valueToX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65597, this, f2)) == null) ? (normalizeValue(f2) * this.trackWidth) + this.trackSidePadding : invokeF.floatValue;
    }

    private void warnAboutFloatingPointError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            float f2 = this.stepSize;
            if (f2 == 0.0f) {
                return;
            }
            if (((int) f2) != f2) {
                String.format(WARNING_FLOATING_POINT_ERRROR, "stepSize", Float.valueOf(f2));
            }
            float f3 = this.valueFrom;
            if (((int) f3) != f3) {
                String.format(WARNING_FLOATING_POINT_ERRROR, "valueFrom", Float.valueOf(f3));
            }
            float f4 = this.valueTo;
            if (((int) f4) != f4) {
                String.format(WARNING_FLOATING_POINT_ERRROR, "valueTo", Float.valueOf(f4));
            }
        }
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
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) ? this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
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

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.forceDrawCompatHalo = z;
        }
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? SeekBar.class.getName() : (CharSequence) invokeV.objValue;
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.accessibilityHelper.getAccessibilityFocusedVirtualViewId() : invokeV.intValue;
    }

    public int getActiveThumbIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.activeThumbIdx : invokeV.intValue;
    }

    public int getFocusedThumbIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.focusedThumbIdx : invokeV.intValue;
    }

    @Dimension
    public int getHaloRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.haloRadius : invokeV.intValue;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.haloColor : (ColorStateList) invokeV.objValue;
    }

    public int getLabelBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.labelBehavior : invokeV.intValue;
    }

    public float getStepSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.stepSize : invokeV.floatValue;
    }

    public float getThumbElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.thumbDrawable.getElevation() : invokeV.floatValue;
    }

    @Dimension
    public int getThumbRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.thumbRadius : invokeV.intValue;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.thumbDrawable.getFillColor() : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.tickColorActive : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.tickColorInactive : (ColorStateList) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.trackColorActive : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getTrackHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.trackHeight : invokeV.intValue;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.trackColorInactive : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getTrackSidePadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.trackSidePadding : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.trackWidth : invokeV.intValue;
    }

    public float getValueFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.valueFrom : invokeV.floatValue;
    }

    public float getValueTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.valueTo : invokeV.floatValue;
    }

    @NonNull
    public List<Float> getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? new ArrayList(this.values) : (List) invokeV.objValue;
    }

    public boolean hasLabelFormatter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.formatter != null : invokeV.booleanValue;
    }

    public final boolean isRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? ViewCompat.getLayoutDirection(this) == 1 : invokeV.booleanValue;
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

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            if (!z) {
                this.activeThumbIdx = -1;
                for (TooltipDrawable tooltipDrawable : this.labels) {
                    ViewUtils.getContentViewOverlay(this).remove(tooltipDrawable);
                }
                this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
                return;
            }
            focusThumbOnFocusGained(i2);
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i2, keyEvent)) == null) {
            if (!isEnabled()) {
                return super.onKeyDown(i2, keyEvent);
            }
            if (this.values.size() == 1) {
                this.activeThumbIdx = 0;
            }
            if (this.activeThumbIdx == -1) {
                Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i2, keyEvent);
                return onKeyDownNoActiveThumb != null ? onKeyDownNoActiveThumb.booleanValue() : super.onKeyDown(i2, keyEvent);
            }
            this.isLongPress |= keyEvent.isLongPress();
            Float calculateIncrementForKey = calculateIncrementForKey(i2);
            if (calculateIncrementForKey != null) {
                if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                    updateHaloHotspot();
                    postInvalidate();
                }
                return true;
            }
            if (i2 != 23) {
                if (i2 == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        return moveFocus(1);
                    }
                    if (keyEvent.isShiftPressed()) {
                        return moveFocus(-1);
                    }
                    return false;
                } else if (i2 != 66) {
                    return super.onKeyDown(i2, keyEvent);
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

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i2, keyEvent)) == null) {
            this.isLongPress = false;
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0), 1073741824));
        }
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

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i2, i3, i4, i5) == null) {
            this.trackWidth = Math.max(i2 - (this.trackSidePadding * 2), 0);
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
            if (isEnabled()) {
                float x = motionEvent.getX();
                float f2 = (x - this.trackSidePadding) / this.trackWidth;
                this.touchPosition = f2;
                float max = Math.max(0.0f, f2);
                this.touchPosition = max;
                this.touchPosition = Math.min(1.0f, max);
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
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
                } else if (actionMasked == 1) {
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
                } else if (actionMasked == 2) {
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
                setPressed(this.thumbIsPressed);
                this.lastEvent = MotionEvent.obtain(motionEvent);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean pickActiveThumb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.activeThumbIdx != -1) {
                return true;
            }
            float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
            float valueToX = valueToX(valueOfTouchPositionAbsolute);
            this.activeThumbIdx = 0;
            float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
            for (int i2 = 1; i2 < this.values.size(); i2++) {
                float abs2 = Math.abs(this.values.get(i2).floatValue() - valueOfTouchPositionAbsolute);
                float valueToX2 = valueToX(this.values.get(i2).floatValue());
                if (Float.compare(abs2, abs) > 1) {
                    break;
                }
                boolean z = !isRtl() ? valueToX2 - valueToX >= 0.0f : valueToX2 - valueToX <= 0.0f;
                if (Float.compare(abs2, abs) < 0) {
                    this.activeThumbIdx = i2;
                } else {
                    if (Float.compare(abs2, abs) != 0) {
                        continue;
                    } else if (Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    } else if (z) {
                        this.activeThumbIdx = i2;
                    }
                }
                abs = abs2;
            }
            return this.activeThumbIdx != -1;
        }
        return invokeV.booleanValue;
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

    public void setActiveThumbIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.activeThumbIdx = i2;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.setEnabled(z);
            setLayerType(z ? 0 : 2, null);
        }
    }

    public void setFocusedThumbIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            if (i2 >= 0 && i2 < this.values.size()) {
                this.focusedThumbIdx = i2;
                this.accessibilityHelper.requestKeyboardFocusForVirtualView(i2);
                postInvalidate();
                return;
            }
            throw new IllegalArgumentException("index out of range");
        }
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || i2 == this.haloRadius) {
            return;
        }
        this.haloRadius = i2;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            setHaloRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, colorStateList) == null) || colorStateList.equals(this.haloColor)) {
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

    public void setLabelBehavior(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i2) == null) || this.labelBehavior == i2) {
            return;
        }
        this.labelBehavior = i2;
        requestLayout();
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, labelFormatter) == null) {
            this.formatter = labelFormatter;
        }
    }

    public void setStepSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f2) == null) {
            if (f2 >= 0.0f) {
                if (this.stepSize != f2) {
                    this.stepSize = f2;
                    this.dirtyConfig = true;
                    postInvalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.toString(f2), Float.toString(this.valueFrom), Float.toString(this.valueTo)));
        }
    }

    public void setThumbElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            this.thumbDrawable.setElevation(f2);
        }
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            setThumbElevation(getResources().getDimension(i2));
        }
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048634, this, i2) == null) || i2 == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i2;
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i3 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            setThumbRadius(getResources().getDimensionPixelSize(i2));
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
        if (!(interceptable == null || interceptable.invokeL(1048637, this, colorStateList) == null) || colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, colorStateList) == null) || colorStateList.equals(this.tickColorInactive)) {
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
        if (!(interceptable == null || interceptable.invokeL(1048640, this, colorStateList) == null) || colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048641, this, i2) == null) || this.trackHeight == i2) {
            return;
        }
        this.trackHeight = i2;
        invalidateTrack();
        postInvalidate();
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, colorStateList) == null) || colorStateList.equals(this.trackColorInactive)) {
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

    public void setValueFrom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048644, this, f2) == null) {
            this.valueFrom = f2;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setValueTo(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f2) == null) {
            this.valueTo = f2;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setValues(@NonNull Float... fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, fArr) == null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            Collections.addAll(arrayList, fArr);
            setValuesInternal(arrayList);
        }
    }

    public void updateBoundsForVirturalViewId(int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048648, this, i2, rect) == null) {
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i2).floatValue()) * this.trackWidth));
            int calculateTop = calculateTop();
            int i3 = this.thumbRadius;
            rect.set(normalizeValue - i3, calculateTop - i3, normalizeValue + i3, calculateTop + i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i2) {
        InterceptResult invokeI;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            float calculateStepIncrement = calculateStepIncrement();
            return (this.valueTo - this.valueFrom) / calculateStepIncrement <= i2 ? calculateStepIncrement : Math.round(f2 / f3) * calculateStepIncrement;
        }
        return invokeI.floatValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, DEF_STYLE_RES), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.labelMaker = new TooltipDrawableFactory(this, attributeSet, i2) { // from class: com.google.android.material.slider.BaseSlider.1
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
                    Object[] objArr3 = {this, attributeSet, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$attrs = attributeSet;
                this.val$defStyleAttr = i2;
            }

            @Override // com.google.android.material.slider.BaseSlider.TooltipDrawableFactory
            public TooltipDrawable createTooltipDrawable() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.this$0.getContext(), this.val$attrs, R.styleable.Slider, this.val$defStyleAttr, BaseSlider.DEF_STYLE_RES, new int[0]);
                    TooltipDrawable parseLabelDrawable = BaseSlider.parseLabelDrawable(this.this$0.getContext(), obtainStyledAttributes);
                    obtainStyledAttributes.recycle();
                    return parseLabelDrawable;
                }
                return (TooltipDrawable) invokeV.objValue;
            }
        };
        processAttributes(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, list) == null) {
            setValuesInternal(new ArrayList<>(list));
        }
    }
}
