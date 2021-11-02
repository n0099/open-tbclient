package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;

    /* loaded from: classes2.dex */
    public static class FabTransformationSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Positioning positioning;
        @Nullable
        public MotionSpec timings;

        public FabTransformationSpec() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public FabTransformationBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            View findViewById = view.findViewById(R.id.mtrl_child_content_container);
            if (findViewById != null) {
                return toViewGroupOrNull(findViewById);
            }
            if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
                return toViewGroupOrNull(view);
            }
            return toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
        }
        return (ViewGroup) invokeL.objValue;
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View view, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, @NonNull MotionTiming motionTiming2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{view, fabTransformationSpec, motionTiming, motionTiming2, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), rectF}) == null) {
            float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f2, f4);
            float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f3, f5);
            Rect rect = this.tmpRect;
            view.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.tmpRectF1;
            rectF2.set(rect);
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view, rectF3);
            rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        }
    }

    private void calculateDependencyWindowBounds(@NonNull View view, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, rectF) == null) {
            calculateWindowBounds(view, rectF);
            rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        }
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f2, float f3, boolean z, @NonNull FabTransformationSpec fabTransformationSpec) {
        InterceptResult invokeCommon;
        MotionTiming timing;
        MotionTiming timing2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), fabTransformationSpec})) == null) {
            if (f2 == 0.0f || f3 == 0.0f) {
                timing = fabTransformationSpec.timings.getTiming("translationXLinear");
                timing2 = fabTransformationSpec.timings.getTiming("translationYLinear");
            } else if ((z && f3 < 0.0f) || (!z && i2 > 0)) {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
            } else {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
            }
            return new Pair<>(timing, timing2);
        }
        return (Pair) invokeCommon.objValue;
    }

    private float calculateRevealCenterX(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, view, view2, positioning)) == null) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            calculateDependencyWindowBounds(view, rectF);
            calculateWindowBounds(view2, rectF2);
            rectF2.offset(-calculateTranslationX(view, view2, positioning), 0.0f);
            return rectF.centerX() - rectF2.left;
        }
        return invokeLLL.floatValue;
    }

    private float calculateRevealCenterY(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, view, view2, positioning)) == null) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            calculateDependencyWindowBounds(view, rectF);
            calculateWindowBounds(view2, rectF2);
            rectF2.offset(0.0f, -calculateTranslationY(view, view2, positioning));
            return rectF.centerY() - rectF2.top;
        }
        return invokeLLL.floatValue;
    }

    private float calculateTranslationX(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        InterceptResult invokeLLL;
        float centerX;
        float centerX2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, view, view2, positioning)) == null) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            calculateDependencyWindowBounds(view, rectF);
            calculateWindowBounds(view2, rectF2);
            int i2 = positioning.gravity & 7;
            if (i2 == 1) {
                centerX = rectF2.centerX();
                centerX2 = rectF.centerX();
            } else if (i2 == 3) {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            } else if (i2 == 5) {
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                f2 = 0.0f;
                return f2 + positioning.xAdjustment;
            }
            f2 = centerX - centerX2;
            return f2 + positioning.xAdjustment;
        }
        return invokeLLL.floatValue;
    }

    private float calculateTranslationY(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        InterceptResult invokeLLL;
        float centerY;
        float centerY2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, view, view2, positioning)) == null) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            calculateDependencyWindowBounds(view, rectF);
            calculateWindowBounds(view2, rectF2);
            int i2 = positioning.gravity & 112;
            if (i2 == 16) {
                centerY = rectF2.centerY();
                centerY2 = rectF.centerY();
            } else if (i2 == 48) {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            } else if (i2 == 80) {
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                f2 = 0.0f;
                return f2 + positioning.yAdjustment;
            }
            f2 = centerY - centerY2;
            return f2 + positioning.yAdjustment;
        }
        return invokeLLL.floatValue;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{fabTransformationSpec, motionTiming, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            long delay = motionTiming.getDelay();
            long duration = motionTiming.getDuration();
            MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
            return AnimationUtils.lerp(f2, f3, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDelay() + timing.getDuration()) + 17) - delay)) / ((float) duration)));
        }
        return invokeCommon.floatValue;
    }

    private void calculateWindowBounds(@NonNull View view, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, view, rectF) == null) {
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            int[] iArr = this.tmpArray;
            view.getLocationInWindow(iArr);
            rectF.offsetTo(iArr[0], iArr[1]);
            rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
        }
    }

    private void createChildrenFadeAnimation(View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup calculateChildContentContainer;
        ObjectAnimator ofFloat;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, list, list2}) == null) && (view2 instanceof ViewGroup)) {
            if (((view2 instanceof CircularRevealWidget) && CircularRevealHelper.STRATEGY == 0) || (calculateChildContentContainer = calculateChildContentContainer(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    ChildrenAlphaProperty.CHILDREN_ALPHA.set(calculateChildContentContainer, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
            }
            fabTransformationSpec.timings.getTiming("contentFade").apply(ofFloat);
            list.add(ofFloat);
        }
    }

    private void createColorAnimation(@NonNull View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, list, list2}) == null) && (view2 instanceof CircularRevealWidget)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int backgroundTint = getBackgroundTint(view);
            int i2 = 16777215 & backgroundTint;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(backgroundTint);
                }
                ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, backgroundTint);
            }
            ofInt.setEvaluator(ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming("color").apply(ofInt);
            list.add(ofInt);
        }
    }

    private void createDependencyTranslationAnimation(@NonNull View view, @NonNull View view2, boolean z, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{view, view2, Boolean.valueOf(z), fabTransformationSpec, list}) == null) {
            float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
            float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
            Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
            MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
            MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            if (!z) {
                calculateTranslationX = this.dependencyOriginalTranslationX;
            }
            fArr[0] = calculateTranslationX;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
            Property property2 = View.TRANSLATION_Y;
            float[] fArr2 = new float[1];
            if (!z) {
                calculateTranslationY = this.dependencyOriginalTranslationY;
            }
            fArr2[0] = calculateTranslationY;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
            motionTiming.apply(ofFloat);
            motionTiming2.apply(ofFloat2);
            list.add(ofFloat);
            list.add(ofFloat2);
        }
    }

    @TargetApi(21)
    private void createElevationAnimation(View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, list, list2}) == null) {
            float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
            if (z) {
                if (!z2) {
                    view2.setTranslationZ(-elevation);
                }
                ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
            }
            fabTransformationSpec.timings.getTiming(Key.ELEVATION).apply(ofFloat);
            list.add(ofFloat);
        }
    }

    private void createExpansionAnimation(@NonNull View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, Float.valueOf(f2), Float.valueOf(f3), list, list2}) == null) && (view2 instanceof CircularRevealWidget)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            float calculateRevealCenterX = calculateRevealCenterX(view, view2, fabTransformationSpec.positioning);
            float calculateRevealCenterY = calculateRevealCenterY(view, view2, fabTransformationSpec.positioning);
            ((FloatingActionButton) view).getContentRect(this.tmpRect);
            float width = this.tmpRect.width() / 2.0f;
            MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(calculateRevealCenterX, calculateRevealCenterY, width));
                }
                if (z2) {
                    width = circularRevealWidget.getRevealInfo().radius;
                }
                animator = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, MathUtils.distanceToFurthestCorner(calculateRevealCenterX, calculateRevealCenterY, 0.0f, 0.0f, f2, f3));
                animator.addListener(new AnimatorListenerAdapter(this, circularRevealWidget) { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FabTransformationBehavior this$0;
                    public final /* synthetic */ CircularRevealWidget val$circularRevealChild;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, circularRevealWidget};
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
                        this.val$circularRevealChild = circularRevealWidget;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                            CircularRevealWidget.RevealInfo revealInfo = this.val$circularRevealChild.getRevealInfo();
                            revealInfo.radius = Float.MAX_VALUE;
                            this.val$circularRevealChild.setRevealInfo(revealInfo);
                        }
                    }
                });
                createPreFillRadialExpansion(view2, timing.getDelay(), (int) calculateRevealCenterX, (int) calculateRevealCenterY, width, list);
            } else {
                float f4 = circularRevealWidget.getRevealInfo().radius;
                Animator createCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, width);
                int i2 = (int) calculateRevealCenterX;
                int i3 = (int) calculateRevealCenterY;
                createPreFillRadialExpansion(view2, timing.getDelay(), i2, i3, f4, list);
                createPostFillRadialExpansion(view2, timing.getDelay(), timing.getDuration(), fabTransformationSpec.timings.getTotalDuration(), i2, i3, width, list);
                animator = createCircularReveal;
            }
            timing.apply(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
        }
    }

    private void createIconFadeAnimation(View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, list, list2}) == null) && (view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
            }
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view2) { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FabTransformationBehavior this$0;
                public final /* synthetic */ View val$child;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
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
                    this.val$child = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.val$child.invalidate();
                    }
                }
            });
            fabTransformationSpec.timings.getTiming("iconFade").apply(ofInt);
            list.add(ofInt);
            list2.add(new AnimatorListenerAdapter(this, circularRevealWidget, drawable) { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FabTransformationBehavior this$0;
                public final /* synthetic */ CircularRevealWidget val$circularRevealChild;
                public final /* synthetic */ Drawable val$icon;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, circularRevealWidget, drawable};
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
                    this.val$circularRevealChild = circularRevealWidget;
                    this.val$icon = drawable;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.val$circularRevealChild.setCircularRevealOverlayDrawable(null);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.val$circularRevealChild.setCircularRevealOverlayDrawable(this.val$icon);
                    }
                }
            });
        }
    }

    private void createPostFillRadialExpansion(View view, long j, long j2, long j3, int i2, int i3, float f2, @NonNull List<Animator> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{view, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), list}) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        long j4 = j + j2;
        if (j4 < j3) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(j4);
            createCircularReveal.setDuration(j3 - j4);
            list.add(createCircularReveal);
        }
    }

    private void createPreFillRadialExpansion(View view, long j, int i2, int i3, float f2, @NonNull List<Animator> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{view, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), list}) == null) || Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    private void createTranslationAnimation(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2), fabTransformationSpec, list, list2, rectF}) == null) {
            float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
            float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
            Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
            MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
            MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
            if (z) {
                if (!z2) {
                    view2.setTranslationX(-calculateTranslationX);
                    view2.setTranslationY(-calculateTranslationY);
                }
                ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
                ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
                calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec, motionTiming, motionTiming2, -calculateTranslationX, -calculateTranslationY, 0.0f, 0.0f, rectF);
            } else {
                ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -calculateTranslationX);
                ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -calculateTranslationY);
            }
            motionTiming.apply(ofFloat);
            motionTiming2.apply(ofFloat2);
            list.add(ofFloat);
            list.add(ofFloat2);
        }
    }

    private int getBackgroundTint(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, view)) == null) {
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            if (backgroundTintList != null) {
                return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, view)) == null) {
            if (view instanceof ViewGroup) {
                return (ViewGroup) view;
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, coordinatorLayout, view, view2)) == null) {
            if (view.getVisibility() != 8) {
                if (view2 instanceof FloatingActionButton) {
                    int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                    return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
                }
                return false;
            }
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams) == null) && layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z);
            if (z) {
                this.dependencyOriginalTranslationX = view.getTranslationX();
                this.dependencyOriginalTranslationY = view.getTranslationY();
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                createElevationAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
            }
            RectF rectF = this.tmpRectF1;
            createTranslationAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2, rectF);
            float width = rectF.width();
            float height = rectF.height();
            createDependencyTranslationAnimation(view, view2, z, onCreateMotionSpec, arrayList);
            createIconFadeAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
            createExpansionAnimation(view, view2, z, z2, onCreateMotionSpec, width, height, arrayList, arrayList2);
            createColorAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
            createChildrenFadeAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            animatorSet.addListener(new AnimatorListenerAdapter(this, z, view2, view) { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FabTransformationBehavior this$0;
                public final /* synthetic */ View val$child;
                public final /* synthetic */ View val$dependency;
                public final /* synthetic */ boolean val$expanded;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), view2, view};
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
                    this.val$expanded = z;
                    this.val$child = view2;
                    this.val$dependency = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.val$expanded) {
                        return;
                    }
                    this.val$child.setVisibility(4);
                    this.val$dependency.setAlpha(1.0f);
                    this.val$dependency.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.val$expanded) {
                        this.val$child.setVisibility(0);
                        this.val$dependency.setAlpha(0.0f);
                        this.val$dependency.setVisibility(4);
                    }
                }
            });
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                animatorSet.addListener(arrayList2.get(i2));
            }
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
