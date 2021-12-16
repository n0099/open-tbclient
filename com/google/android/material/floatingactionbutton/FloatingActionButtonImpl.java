package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class FloatingActionButtonImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIM_STATE_HIDING = 1;
    public static final int ANIM_STATE_NONE = 0;
    public static final int ANIM_STATE_SHOWING = 2;
    public static final long ELEVATION_ANIM_DELAY = 100;
    public static final long ELEVATION_ANIM_DURATION = 100;
    public static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR;
    public static final int[] EMPTY_STATE_SET;
    public static final int[] ENABLED_STATE_SET;
    public static final int[] FOCUSED_ENABLED_STATE_SET;
    public static final float HIDE_ICON_SCALE = 0.0f;
    public static final float HIDE_OPACITY = 0.0f;
    public static final float HIDE_SCALE = 0.0f;
    public static final int[] HOVERED_ENABLED_STATE_SET;
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET;
    public static final int[] PRESSED_ENABLED_STATE_SET;
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static final float SHOW_ICON_SCALE = 1.0f;
    public static final float SHOW_OPACITY = 1.0f;
    public static final float SHOW_SCALE = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public int animState;
    @Nullable
    public BorderDrawable borderDrawable;
    @Nullable
    public Drawable contentBackground;
    @Nullable
    public Animator currentAnimator;
    @Nullable
    public MotionSpec defaultHideMotionSpec;
    @Nullable
    public MotionSpec defaultShowMotionSpec;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public ArrayList<Animator.AnimatorListener> hideListeners;
    @Nullable
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public float imageMatrixScale;
    public int maxImageSize;
    public int minTouchTargetSize;
    @Nullable
    public ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    @Nullable
    public Drawable rippleDrawable;
    public float rotation;
    public boolean shadowPaddingEnabled;
    public final ShadowViewDelegate shadowViewDelegate;
    @Nullable
    public ShapeAppearanceModel shapeAppearance;
    @Nullable
    public MaterialShapeDrawable shapeDrawable;
    public ArrayList<Animator.AnimatorListener> showListeners;
    @Nullable
    public MotionSpec showMotionSpec;
    @NonNull
    public final StateListAnimator stateListAnimator;
    public final Matrix tmpMatrix;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;
    public ArrayList<InternalTransformationCallback> transformationCallbacks;
    public final FloatingActionButton view;

    /* loaded from: classes3.dex */
    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0.0f;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
                return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
                return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* loaded from: classes3.dex */
    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* loaded from: classes3.dex */
    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResetElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.elevation : invokeV.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float shadowSizeEnd;
        public float shadowSizeStart;
        public final /* synthetic */ FloatingActionButtonImpl this$0;
        public boolean validValues;

        public ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
                this.validValues = false;
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, valueAnimator) == null) {
                if (!this.validValues) {
                    MaterialShapeDrawable materialShapeDrawable = this.this$0.shapeDrawable;
                    this.shadowSizeStart = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
                    this.shadowSizeEnd = getTargetShadowSize();
                    this.validValues = true;
                }
                FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
                float f2 = this.shadowSizeStart;
                floatingActionButtonImpl.updateShapeElevation((int) (f2 + ((this.shadowSizeEnd - f2) * valueAnimator.getAnimatedFraction())));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-484410472, "Lcom/google/android/material/floatingactionbutton/FloatingActionButtonImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-484410472, "Lcom/google/android/material/floatingactionbutton/FloatingActionButtonImpl;");
                return;
            }
        }
        ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{16843623, 16842908, 16842910};
        FOCUSED_ENABLED_STATE_SET = new int[]{16842908, 16842910};
        HOVERED_ENABLED_STATE_SET = new int[]{16843623, 16842910};
        ENABLED_STATE_SET = new int[]{16842910};
        EMPTY_STATE_SET = new int[0];
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {floatingActionButton, shadowViewDelegate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shadowPaddingEnabled = true;
        this.imageMatrixScale = 1.0f;
        this.animState = 0;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.stateListAnimator = stateListAnimator;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = this.view.getRotation();
    }

    private void calculateImageMatrixFromScale(float f2, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f2), matrix}) == null) {
            matrix.reset();
            Drawable drawable = this.view.getDrawable();
            if (drawable == null || this.maxImageSize == 0) {
                return;
            }
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i2 = this.maxImageSize;
            rectF2.set(0.0f, 0.0f, i2, i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.maxImageSize;
            matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{motionSpec, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, View.ALPHA, f2);
            motionSpec.getTiming("opacity").apply(ofFloat);
            arrayList.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, f3);
            motionSpec.getTiming(AnimationProperty.SCALE).apply(ofFloat2);
            workAroundOreoBug(ofFloat2);
            arrayList.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, f3);
            motionSpec.getTiming(AnimationProperty.SCALE).apply(ofFloat3);
            workAroundOreoBug(ofFloat3);
            arrayList.add(ofFloat3);
            calculateImageMatrixFromScale(f4, this.tmpMatrix);
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FloatingActionButtonImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
                public Matrix evaluate(float f5, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                    InterceptResult invokeCommon2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon2 = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f5), matrix, matrix2})) == null) {
                        this.this$0.imageMatrixScale = f5;
                        return super.evaluate(f5, matrix, matrix2);
                    }
                    return (Matrix) invokeCommon2.objValue;
                }
            }, new Matrix(this.tmpMatrix));
            motionSpec.getTiming("iconScale").apply(ofObject);
            arrayList.add(ofObject);
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @NonNull
    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, shadowAnimatorImpl)) == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
            valueAnimator.setDuration(100L);
            valueAnimator.addListener(shadowAnimatorImpl);
            valueAnimator.addUpdateListener(shadowAnimatorImpl);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            return valueAnimator;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    private MotionSpec getDefaultHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.defaultHideMotionSpec == null) {
                this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_hide_motion_spec);
            }
            return (MotionSpec) Preconditions.checkNotNull(this.defaultHideMotionSpec);
        }
        return (MotionSpec) invokeV.objValue;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.defaultShowMotionSpec == null) {
                this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_show_motion_spec);
            }
            return (MotionSpec) Preconditions.checkNotNull(this.defaultShowMotionSpec);
        }
        return (MotionSpec) invokeV.objValue;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.preDrawListener == null) {
                this.preDrawListener = new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FloatingActionButtonImpl this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                            this.this$0.onPreDraw();
                            return true;
                        }
                        return invokeV2.booleanValue;
                    }
                };
            }
            return this.preDrawListener;
        }
        return (ViewTreeObserver.OnPreDrawListener) invokeV.objValue;
    }

    private boolean shouldAnimateVisibilityChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode() : invokeV.booleanValue;
    }

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, objectAnimator) == null) && Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new TypeEvaluator<Float>(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public FloatEvaluator floatEvaluator;
                public final /* synthetic */ FloatingActionButtonImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.floatEvaluator = new FloatEvaluator();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.animation.TypeEvaluator
                public Float evaluate(float f2, Float f3, Float f4) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), f3, f4})) == null) {
                        float floatValue = this.floatEvaluator.evaluate(f2, (Number) f3, (Number) f4).floatValue();
                        if (floatValue < 0.1f) {
                            floatValue = 0.0f;
                        }
                        return Float.valueOf(floatValue);
                    }
                    return (Float) invokeCommon.objValue;
                }
            });
        }
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            if (this.hideListeners == null) {
                this.hideListeners = new ArrayList<>();
            }
            this.hideListeners.add(animatorListener);
        }
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListener) == null) {
            if (this.showListeners == null) {
                this.showListeners = new ArrayList<>();
            }
            this.showListeners.add(animatorListener);
        }
    }

    public void addTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, internalTransformationCallback) == null) {
            if (this.transformationCallbacks == null) {
                this.transformationCallbacks = new ArrayList<>();
            }
            this.transformationCallbacks.add(internalTransformationCallback);
        }
    }

    public MaterialShapeDrawable createShapeDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance)) : (MaterialShapeDrawable) invokeV.objValue;
    }

    @Nullable
    public final Drawable getContentBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.contentBackground : (Drawable) invokeV.objValue;
    }

    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.elevation : invokeV.floatValue;
    }

    public boolean getEnsureMinTouchTargetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.ensureMinTouchTargetSize : invokeV.booleanValue;
    }

    @Nullable
    public final MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.hideMotionSpec : (MotionSpec) invokeV.objValue;
    }

    public float getHoveredFocusedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.hoveredFocusedTranslationZ : invokeV.floatValue;
    }

    public void getPadding(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            int sizeDimension = this.ensureMinTouchTargetSize ? (this.minTouchTargetSize - this.view.getSizeDimension()) / 2 : 0;
            float elevation = this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f;
            int max = Math.max(sizeDimension, (int) Math.ceil(elevation));
            int max2 = Math.max(sizeDimension, (int) Math.ceil(elevation * 1.5f));
            rect.set(max, max2, max, max2);
        }
    }

    public float getPressedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.pressedTranslationZ : invokeV.floatValue;
    }

    @Nullable
    public final ShapeAppearanceModel getShapeAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.shapeAppearance : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public final MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.showMotionSpec : (MotionSpec) invokeV.objValue;
    }

    public void hide(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, internalVisibilityChangedListener, z) == null) || isOrWillBeHidden()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (shouldAnimateVisibilityChange()) {
            MotionSpec motionSpec = this.hideMotionSpec;
            if (motionSpec == null) {
                motionSpec = getDefaultHideMotionSpec();
            }
            AnimatorSet createAnimator = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
            createAnimator.addListener(new AnimatorListenerAdapter(this, z, internalVisibilityChangedListener) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean cancelled;
                public final /* synthetic */ FloatingActionButtonImpl this$0;
                public final /* synthetic */ boolean val$fromUser;
                public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), internalVisibilityChangedListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fromUser = z;
                    this.val$listener = internalVisibilityChangedListener;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.cancelled = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.animState = 0;
                        this.this$0.currentAnimator = null;
                        if (this.cancelled) {
                            return;
                        }
                        this.this$0.view.internalSetVisibility(this.val$fromUser ? 8 : 4, this.val$fromUser);
                        InternalVisibilityChangedListener internalVisibilityChangedListener2 = this.val$listener;
                        if (internalVisibilityChangedListener2 != null) {
                            internalVisibilityChangedListener2.onHidden();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator2) == null) {
                        this.this$0.view.internalSetVisibility(0, this.val$fromUser);
                        this.this$0.animState = 1;
                        this.this$0.currentAnimator = animator2;
                        this.cancelled = false;
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    createAnimator.addListener(it.next());
                }
            }
            createAnimator.start();
            return;
        }
        this.view.internalSetVisibility(z ? 8 : 4, z);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onHidden();
        }
    }

    public void initializeBackgroundDrawable(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048590, this, colorStateList, mode, colorStateList2, i2) == null) {
            MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
            this.shapeDrawable = createShapeDrawable;
            createShapeDrawable.setTintList(colorStateList);
            if (mode != null) {
                this.shapeDrawable.setTintMode(mode);
            }
            this.shapeDrawable.setShadowColor(-12303292);
            this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
            RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
            rippleDrawableCompat.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
            this.rippleDrawable = rippleDrawableCompat;
            this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.shapeDrawable), rippleDrawableCompat});
        }
    }

    public boolean isOrWillBeHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.view.getVisibility() == 0 ? this.animState == 1 : this.animState != 2 : invokeV.booleanValue;
    }

    public boolean isOrWillBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.view.getVisibility() != 0 ? this.animState == 2 : this.animState != 1 : invokeV.booleanValue;
    }

    public void jumpDrawableToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.stateListAnimator.jumpToCurrentState();
        }
    }

    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (materialShapeDrawable != null) {
                MaterialShapeUtils.setParentAbsoluteElevation(this.view, materialShapeDrawable);
            }
            if (requirePreDrawListener()) {
                this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
            }
        }
    }

    public void onCompatShadowChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
            if (onPreDrawListener != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
                this.preDrawListener = null;
            }
        }
    }

    public void onDrawableStateChanged(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iArr) == null) {
            this.stateListAnimator.setState(iArr);
        }
    }

    public void onElevationsChanged(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            updatePadding();
            updateShapeElevation(f2);
        }
    }

    public void onPaddingUpdated(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, rect) == null) {
            Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
            if (shouldAddPadding()) {
                this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
                return;
            }
            this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
        }
    }

    public void onPreDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            float rotation = this.view.getRotation();
            if (this.rotation != rotation) {
                this.rotation = rotation;
                updateFromViewRotation();
            }
        }
    }

    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (arrayList = this.transformationCallbacks) == null) {
            return;
        }
        Iterator<InternalTransformationCallback> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onScaleChanged();
        }
    }

    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (arrayList = this.transformationCallbacks) == null) {
            return;
        }
        Iterator<InternalTransformationCallback> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTranslationChanged();
        }
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, animatorListener) == null) || (arrayList = this.hideListeners) == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, animatorListener) == null) || (arrayList = this.showListeners) == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, internalTransformationCallback) == null) || (arrayList = this.transformationCallbacks) == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    public boolean requirePreDrawListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, colorStateList) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            BorderDrawable borderDrawable = this.borderDrawable;
            if (borderDrawable != null) {
                borderDrawable.setBorderTint(colorStateList);
            }
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, mode) == null) || (materialShapeDrawable = this.shapeDrawable) == null) {
            return;
        }
        materialShapeDrawable.setTintMode(mode);
    }

    public final void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048609, this, f2) == null) || this.elevation == f2) {
            return;
        }
        this.elevation = f2;
        onElevationsChanged(f2, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.ensureMinTouchTargetSize = z;
        }
    }

    public final void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, motionSpec) == null) {
            this.hideMotionSpec = motionSpec;
        }
    }

    public final void setHoveredFocusedTranslationZ(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || this.hoveredFocusedTranslationZ == f2) {
            return;
        }
        this.hoveredFocusedTranslationZ = f2;
        onElevationsChanged(this.elevation, f2, this.pressedTranslationZ);
    }

    public final void setImageMatrixScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.imageMatrixScale = f2;
            Matrix matrix = this.tmpMatrix;
            calculateImageMatrixFromScale(f2, matrix);
            this.view.setImageMatrix(matrix);
        }
    }

    public final void setMaxImageSize(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i2) == null) || this.maxImageSize == i2) {
            return;
        }
        this.maxImageSize = i2;
        updateImageMatrixScale();
    }

    public void setMinTouchTargetSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.minTouchTargetSize = i2;
        }
    }

    public final void setPressedTranslationZ(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048616, this, f2) == null) || this.pressedTranslationZ == f2) {
            return;
        }
        this.pressedTranslationZ = f2;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, colorStateList) == null) || (drawable = this.rippleDrawable) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
    }

    public void setShadowPaddingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.shadowPaddingEnabled = z;
            updatePadding();
        }
    }

    public final void setShapeAppearance(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, shapeAppearanceModel) == null) {
            this.shapeAppearance = shapeAppearanceModel;
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
            }
            Drawable drawable = this.rippleDrawable;
            if (drawable instanceof Shapeable) {
                ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
            }
            BorderDrawable borderDrawable = this.borderDrawable;
            if (borderDrawable != null) {
                borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
            }
        }
    }

    public final void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, motionSpec) == null) {
            this.showMotionSpec = motionSpec;
        }
    }

    public boolean shouldAddPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean shouldExpandBoundsForA11y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? !this.ensureMinTouchTargetSize || this.view.getSizeDimension() >= this.minTouchTargetSize : invokeV.booleanValue;
    }

    public void show(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048623, this, internalVisibilityChangedListener, z) == null) || isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (shouldAnimateVisibilityChange()) {
            if (this.view.getVisibility() != 0) {
                this.view.setAlpha(0.0f);
                this.view.setScaleY(0.0f);
                this.view.setScaleX(0.0f);
                setImageMatrixScale(0.0f);
            }
            MotionSpec motionSpec = this.showMotionSpec;
            if (motionSpec == null) {
                motionSpec = getDefaultShowMotionSpec();
            }
            AnimatorSet createAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
            createAnimator.addListener(new AnimatorListenerAdapter(this, z, internalVisibilityChangedListener) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FloatingActionButtonImpl this$0;
                public final /* synthetic */ boolean val$fromUser;
                public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), internalVisibilityChangedListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fromUser = z;
                    this.val$listener = internalVisibilityChangedListener;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.this$0.animState = 0;
                        this.this$0.currentAnimator = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener2 = this.val$listener;
                        if (internalVisibilityChangedListener2 != null) {
                            internalVisibilityChangedListener2.onShown();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.view.internalSetVisibility(0, this.val$fromUser);
                        this.this$0.animState = 2;
                        this.this$0.currentAnimator = animator2;
                    }
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    createAnimator.addListener(it.next());
                }
            }
            createAnimator.start();
            return;
        }
        this.view.internalSetVisibility(0, z);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onShown();
        }
    }

    public void updateFromViewRotation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (Build.VERSION.SDK_INT == 19) {
                if (this.rotation % 90.0f != 0.0f) {
                    if (this.view.getLayerType() != 1) {
                        this.view.setLayerType(1, null);
                    }
                } else if (this.view.getLayerType() != 0) {
                    this.view.setLayerType(0, null);
                }
            }
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setShadowCompatRotation((int) this.rotation);
            }
        }
    }

    public final void updateImageMatrixScale() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            setImageMatrixScale(this.imageMatrixScale);
        }
    }

    public final void updatePadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            Rect rect = this.tmpRect;
            getPadding(rect);
            onPaddingUpdated(rect);
            this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void updateShapeElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048627, this, f2) == null) || (materialShapeDrawable = this.shapeDrawable) == null) {
            return;
        }
        materialShapeDrawable.setElevation(f2);
    }
}
