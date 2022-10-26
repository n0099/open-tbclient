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
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
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
    public BorderDrawable borderDrawable;
    public Drawable contentBackground;
    public Animator currentAnimator;
    public MotionSpec defaultHideMotionSpec;
    public MotionSpec defaultShowMotionSpec;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public ArrayList hideListeners;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public float imageMatrixScale;
    public int maxImageSize;
    public int minTouchTargetSize;
    public ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    public float rotation;
    public boolean shadowPaddingEnabled;
    public final ShadowViewDelegate shadowViewDelegate;
    public ShapeAppearanceModel shapeAppearance;
    public MaterialShapeDrawable shapeDrawable;
    public ArrayList showListeners;
    public MotionSpec showMotionSpec;
    public final StateListAnimator stateListAnimator;
    public final Matrix tmpMatrix;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;
    public ArrayList transformationCallbacks;

    /* renamed from: view  reason: collision with root package name */
    public final FloatingActionButton f1073view;

    /* loaded from: classes7.dex */
    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* loaded from: classes7.dex */
    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public void onCompatShadowChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public boolean requirePreDrawListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldAddPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0.0f;
            }
            return invokeV.floatValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                return this.this$0.elevation;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float shadowSizeEnd;
        public float shadowSizeStart;
        public final /* synthetic */ FloatingActionButtonImpl this$0;
        public boolean validValues;

        public abstract float getTargetShadowSize();

        public ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButtonImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButtonImpl;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
                this.validValues = false;
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float elevation;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, valueAnimator) == null) {
                if (!this.validValues) {
                    MaterialShapeDrawable materialShapeDrawable = this.this$0.shapeDrawable;
                    if (materialShapeDrawable == null) {
                        elevation = 0.0f;
                    } else {
                        elevation = materialShapeDrawable.getElevation();
                    }
                    this.shadowSizeStart = elevation;
                    this.shadowSizeEnd = getTargetShadowSize();
                    this.validValues = true;
                }
                FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
                float f = this.shadowSizeStart;
                floatingActionButtonImpl.updateShapeElevation((int) (f + ((this.shadowSizeEnd - f) * valueAnimator.getAnimatedFraction())));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f1073view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.stateListAnimator = stateListAnimator;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = this.f1073view.getRotation();
    }

    private void calculateImageMatrixFromScale(float f, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f), matrix}) == null) {
            matrix.reset();
            Drawable drawable = this.f1073view.getDrawable();
            if (drawable != null && this.maxImageSize != 0) {
                RectF rectF = this.tmpRectF1;
                RectF rectF2 = this.tmpRectF2;
                rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                int i = this.maxImageSize;
                rectF2.set(0.0f, 0.0f, i, i);
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                int i2 = this.maxImageSize;
                matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
            }
        }
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{motionSpec, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            ArrayList arrayList = new ArrayList();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f1073view, View.ALPHA, f);
            motionSpec.getTiming(NativeConstants.OPACITY).apply(ofFloat);
            arrayList.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f1073view, View.SCALE_X, f2);
            motionSpec.getTiming("scale").apply(ofFloat2);
            workAroundOreoBug(ofFloat2);
            arrayList.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f1073view, View.SCALE_Y, f2);
            motionSpec.getTiming("scale").apply(ofFloat3);
            workAroundOreoBug(ofFloat3);
            arrayList.add(ofFloat3);
            calculateImageMatrixFromScale(f3, this.tmpMatrix);
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f1073view, new ImageMatrixProperty(), new MatrixEvaluator(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
                public Matrix evaluate(float f4, Matrix matrix, Matrix matrix2) {
                    InterceptResult invokeCommon2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeCommon2 = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f4), matrix, matrix2})) != null) {
                        return (Matrix) invokeCommon2.objValue;
                    }
                    this.this$0.imageMatrixScale = f4;
                    return super.evaluate(f4, matrix, matrix2);
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

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
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

    public void onPaddingUpdated(Rect rect) {
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

    private MotionSpec getDefaultHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.defaultHideMotionSpec == null) {
                this.defaultHideMotionSpec = MotionSpec.createFromResource(this.f1073view.getContext(), R.animator.obfuscated_res_0x7f020001);
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
                this.defaultShowMotionSpec = MotionSpec.createFromResource(this.f1073view.getContext(), R.animator.obfuscated_res_0x7f020002);
            }
            return (MotionSpec) Preconditions.checkNotNull(this.defaultShowMotionSpec);
        }
        return (MotionSpec) invokeV.objValue;
    }

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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (ViewCompat.isLaidOut(this.f1073view) && !this.f1073view.isInEditMode()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public MaterialShapeDrawable createShapeDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        }
        return (MaterialShapeDrawable) invokeV.objValue;
    }

    public final Drawable getContentBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.contentBackground;
        }
        return (Drawable) invokeV.objValue;
    }

    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.elevation;
        }
        return invokeV.floatValue;
    }

    public boolean getEnsureMinTouchTargetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.ensureMinTouchTargetSize;
        }
        return invokeV.booleanValue;
    }

    public final MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.hideMotionSpec;
        }
        return (MotionSpec) invokeV.objValue;
    }

    public float getHoveredFocusedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.hoveredFocusedTranslationZ;
        }
        return invokeV.floatValue;
    }

    public float getPressedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.pressedTranslationZ;
        }
        return invokeV.floatValue;
    }

    public final ShapeAppearanceModel getShapeAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.shapeAppearance;
        }
        return (ShapeAppearanceModel) invokeV.objValue;
    }

    public final MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.showMotionSpec;
        }
        return (MotionSpec) invokeV.objValue;
    }

    public boolean isOrWillBeHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f1073view.getVisibility() == 0) {
                if (this.animState != 1) {
                    return false;
                }
                return true;
            } else if (this.animState == 2) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isOrWillBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f1073view.getVisibility() != 0) {
                if (this.animState != 2) {
                    return false;
                }
                return true;
            } else if (this.animState == 1) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
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
                MaterialShapeUtils.setParentAbsoluteElevation(this.f1073view, materialShapeDrawable);
            }
            if (requirePreDrawListener()) {
                this.f1073view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
            }
        }
    }

    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ViewTreeObserver viewTreeObserver = this.f1073view.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
            if (onPreDrawListener != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
                this.preDrawListener = null;
            }
        }
    }

    public void onPreDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            float rotation = this.f1073view.getRotation();
            if (this.rotation != rotation) {
                this.rotation = rotation;
                updateFromViewRotation();
            }
        }
    }

    public void onScaleChanged() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (arrayList = this.transformationCallbacks) != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InternalTransformationCallback) it.next()).onScaleChanged();
            }
        }
    }

    public void onTranslationChanged() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (arrayList = this.transformationCallbacks) != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InternalTransformationCallback) it.next()).onTranslationChanged();
            }
        }
    }

    public final boolean shouldExpandBoundsForA11y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.ensureMinTouchTargetSize && this.f1073view.getSizeDimension() < this.minTouchTargetSize) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, this, objectAnimator) != null) || Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new TypeEvaluator(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public Float evaluate(float f, Float f2, Float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), f2, f3})) == null) {
                    float floatValue = this.floatEvaluator.evaluate(f, (Number) f2, (Number) f3).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
                return (Float) invokeCommon.objValue;
            }
        });
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            if (this.hideListeners == null) {
                this.hideListeners = new ArrayList();
            }
            this.hideListeners.add(animatorListener);
        }
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListener) == null) {
            if (this.showListeners == null) {
                this.showListeners = new ArrayList();
            }
            this.showListeners.add(animatorListener);
        }
    }

    public void addTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, internalTransformationCallback) == null) {
            if (this.transformationCallbacks == null) {
                this.transformationCallbacks = new ArrayList();
            }
            this.transformationCallbacks.add(internalTransformationCallback);
        }
    }

    public void onDrawableStateChanged(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iArr) == null) {
            this.stateListAnimator.setState(iArr);
        }
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, animatorListener) != null) || (arrayList = this.hideListeners) == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, animatorListener) != null) || (arrayList = this.showListeners) == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, internalTransformationCallback) != null) || (arrayList = this.transformationCallbacks) == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
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

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, mode) == null) && (materialShapeDrawable = this.shapeDrawable) != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    public final void setElevation(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048609, this, f) == null) && this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(f, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.ensureMinTouchTargetSize = z;
        }
    }

    public final void setHideMotionSpec(MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, motionSpec) == null) {
            this.hideMotionSpec = motionSpec;
        }
    }

    public final void setHoveredFocusedTranslationZ(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048612, this, f) == null) && this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, f, this.pressedTranslationZ);
        }
    }

    public final void setImageMatrixScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f) == null) {
            this.imageMatrixScale = f;
            Matrix matrix = this.tmpMatrix;
            calculateImageMatrixFromScale(f, matrix);
            this.f1073view.setImageMatrix(matrix);
        }
    }

    public final void setMaxImageSize(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    public void setMinTouchTargetSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.minTouchTargetSize = i;
        }
    }

    public final void setPressedTranslationZ(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048616, this, f) == null) && this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, colorStateList) == null) && (drawable = this.rippleDrawable) != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    public void setShadowPaddingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.shadowPaddingEnabled = z;
            updatePadding();
        }
    }

    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
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

    public final void setShowMotionSpec(MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, motionSpec) == null) {
            this.showMotionSpec = motionSpec;
        }
    }

    public void updateShapeElevation(float f) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048627, this, f) == null) && (materialShapeDrawable = this.shapeDrawable) != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    public void getPadding(Rect rect) {
        int i;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            if (this.ensureMinTouchTargetSize) {
                i = (this.minTouchTargetSize - this.f1073view.getSizeDimension()) / 2;
            } else {
                i = 0;
            }
            if (this.shadowPaddingEnabled) {
                f = getElevation() + this.pressedTranslationZ;
            } else {
                f = 0.0f;
            }
            int max = Math.max(i, (int) Math.ceil(f));
            int max2 = Math.max(i, (int) Math.ceil(f * 1.5f));
            rect.set(max, max2, max, max2);
        }
    }

    public void hide(InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048589, this, internalVisibilityChangedListener, z) != null) || isOrWillBeHidden()) {
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
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator2) == null) {
                        this.this$0.f1073view.internalSetVisibility(0, this.val$fromUser);
                        this.this$0.animState = 1;
                        this.this$0.currentAnimator = animator2;
                        this.cancelled = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.animState = 0;
                        this.this$0.currentAnimator = null;
                        if (!this.cancelled) {
                            FloatingActionButton floatingActionButton = this.this$0.f1073view;
                            if (this.val$fromUser) {
                                i2 = 8;
                            } else {
                                i2 = 4;
                            }
                            floatingActionButton.internalSetVisibility(i2, this.val$fromUser);
                            InternalVisibilityChangedListener internalVisibilityChangedListener2 = this.val$listener;
                            if (internalVisibilityChangedListener2 != null) {
                                internalVisibilityChangedListener2.onHidden();
                            }
                        }
                    }
                }
            });
            ArrayList arrayList = this.hideListeners;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    createAnimator.addListener((Animator.AnimatorListener) it.next());
                }
            }
            createAnimator.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f1073view;
        if (z) {
            i = 8;
        } else {
            i = 4;
        }
        floatingActionButton.internalSetVisibility(i, z);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onHidden();
        }
    }

    public void show(InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048623, this, internalVisibilityChangedListener, z) != null) || isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (shouldAnimateVisibilityChange()) {
            if (this.f1073view.getVisibility() != 0) {
                this.f1073view.setAlpha(0.0f);
                this.f1073view.setScaleY(0.0f);
                this.f1073view.setScaleX(0.0f);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, animator2) != null) {
                        return;
                    }
                    this.this$0.animState = 0;
                    this.this$0.currentAnimator = null;
                    InternalVisibilityChangedListener internalVisibilityChangedListener2 = this.val$listener;
                    if (internalVisibilityChangedListener2 != null) {
                        internalVisibilityChangedListener2.onShown();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.f1073view.internalSetVisibility(0, this.val$fromUser);
                        this.this$0.animState = 2;
                        this.this$0.currentAnimator = animator2;
                    }
                }
            });
            ArrayList arrayList = this.showListeners;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    createAnimator.addListener((Animator.AnimatorListener) it.next());
                }
            }
            createAnimator.start();
            return;
        }
        this.f1073view.internalSetVisibility(0, z);
        this.f1073view.setAlpha(1.0f);
        this.f1073view.setScaleY(1.0f);
        this.f1073view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onShown();
        }
    }

    public void initializeBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048590, this, colorStateList, mode, colorStateList2, i) == null) {
            MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
            this.shapeDrawable = createShapeDrawable;
            createShapeDrawable.setTintList(colorStateList);
            if (mode != null) {
                this.shapeDrawable.setTintMode(mode);
            }
            this.shapeDrawable.setShadowColor(-12303292);
            this.shapeDrawable.initializeElevationOverlay(this.f1073view.getContext());
            RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
            rippleDrawableCompat.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
            this.rippleDrawable = rippleDrawableCompat;
            this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.shapeDrawable), rippleDrawableCompat});
        }
    }

    public void onElevationsChanged(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            updatePadding();
            updateShapeElevation(f);
        }
    }

    public void updateFromViewRotation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (Build.VERSION.SDK_INT == 19) {
                if (this.rotation % 90.0f != 0.0f) {
                    if (this.f1073view.getLayerType() != 1) {
                        this.f1073view.setLayerType(1, null);
                    }
                } else if (this.f1073view.getLayerType() != 0) {
                    this.f1073view.setLayerType(0, null);
                }
            }
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setShadowCompatRotation((int) this.rotation);
            }
        }
    }
}
