package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
@TargetApi(19)
/* loaded from: classes6.dex */
public class DraweeTransition extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPNAME_BOUNDS = "draweeTransition:bounds";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final PointF mFromFocusPoint;
    public final ScalingUtils.ScaleType mFromScale;
    @Nullable
    public final PointF mToFocusPoint;
    public final ScalingUtils.ScaleType mToScale;

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scaleType, scaleType2, pointF, pointF2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFromScale = scaleType;
        this.mToScale = scaleType2;
        this.mFromFocusPoint = pointF;
        this.mToFocusPoint = pointF2;
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, transitionValues) == null) && (transitionValues.view instanceof GenericDraweeView)) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, scaleType, scaleType2)) == null) ? createTransitionSet(scaleType, scaleType2, null, null) : (TransitionSet) invokeLL.objValue;
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues != null && transitionValues2 != null) {
                Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
                Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
                if (rect != null && rect2 != null) {
                    if (this.mFromScale == this.mToScale && this.mFromFocusPoint == this.mToFocusPoint) {
                        return null;
                    }
                    GenericDraweeView genericDraweeView = (GenericDraweeView) transitionValues.view;
                    ScalingUtils.InterpolatingScaleType interpolatingScaleType = new ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, rect, rect2, this.mFromFocusPoint, this.mToFocusPoint);
                    genericDraweeView.getHierarchy().setActualImageScaleType(interpolatingScaleType);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, interpolatingScaleType) { // from class: com.facebook.drawee.view.DraweeTransition.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DraweeTransition this$0;
                        public final /* synthetic */ ScalingUtils.InterpolatingScaleType val$scaleType;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interpolatingScaleType};
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
                            this.val$scaleType = interpolatingScaleType;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                                this.val$scaleType.setValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            }
                        }
                    });
                    ofFloat.addListener(new AnimatorListenerAdapter(this, genericDraweeView) { // from class: com.facebook.drawee.view.DraweeTransition.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DraweeTransition this$0;
                        public final /* synthetic */ GenericDraweeView val$draweeView;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, genericDraweeView};
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
                            this.val$draweeView = genericDraweeView;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                this.val$draweeView.getHierarchy().setActualImageScaleType(this.this$0.mToScale);
                                if (this.this$0.mToFocusPoint != null) {
                                    this.val$draweeView.getHierarchy().setActualImageFocusPoint(this.this$0.mToFocusPoint);
                                }
                            }
                        }
                    });
                    return ofFloat;
                }
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, scaleType, scaleType2, pointF, pointF2)) == null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.addTransition(new DraweeTransition(scaleType, scaleType2, pointF, pointF2));
            return transitionSet;
        }
        return (TransitionSet) invokeLLLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scaleType, scaleType2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ScalingUtils.ScaleType) objArr2[0], (ScalingUtils.ScaleType) objArr2[1], (PointF) objArr2[2], (PointF) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
