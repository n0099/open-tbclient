package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes11.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    public transient /* synthetic */ FieldHolder $fh;
    public final MotionTiming collapseTiming;
    public final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
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
        this.expandTiming = new MotionTiming(75L, 150L);
        this.collapseTiming = new MotionTiming(0L, 150L);
    }

    private void createScrimAnimation(@NonNull View view, boolean z, boolean z2, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2), list, list2}) == null) {
            MotionTiming motionTiming = z ? this.expandTiming : this.collapseTiming;
            if (z) {
                if (!z2) {
                    view.setAlpha(0.0f);
                }
                ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
            }
            motionTiming.apply(ofFloat);
            list.add(ofFloat);
        }
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, coordinatorLayout, view, view2)) == null) ? view2 instanceof FloatingActionButton : invokeLLL.booleanValue;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, view2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            ArrayList arrayList = new ArrayList();
            createScrimAnimation(view2, z, z2, arrayList, new ArrayList());
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            animatorSet.addListener(new AnimatorListenerAdapter(this, z, view2) { // from class: com.google.android.material.transformation.FabTransformationScrimBehavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FabTransformationScrimBehavior this$0;
                public final /* synthetic */ View val$child;
                public final /* synthetic */ boolean val$expanded;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), view2};
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
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.val$expanded) {
                        return;
                    }
                    this.val$child.setVisibility(4);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.val$expanded) {
                        this.val$child.setVisibility(0);
                    }
                }
            });
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, coordinatorLayout, view, motionEvent)) == null) ? super.onTouchEvent(coordinatorLayout, view, motionEvent) : invokeLLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
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
        this.expandTiming = new MotionTiming(75L, 150L);
        this.collapseTiming = new MotionTiming(0L, 150L);
    }
}
