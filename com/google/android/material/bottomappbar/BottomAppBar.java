package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANIMATION_DURATION = 300;
    public static final int DEF_STYLE_RES;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int animatingModeChangeCounter;
    public ArrayList<AnimationListener> animationListeners;
    public Behavior behavior;
    public int bottomInset;
    public int fabAlignmentMode;
    @NonNull
    public AnimatorListenerAdapter fabAnimationListener;
    public int fabAnimationMode;
    public boolean fabAttached;
    public final int fabOffsetEndMode;
    @NonNull
    public TransformationCallback<FloatingActionButton> fabTransformationCallback;
    public boolean hideOnScroll;
    public int leftInset;
    public final MaterialShapeDrawable materialShapeDrawable;
    @Nullable
    public Animator menuAnimator;
    @Nullable
    public Animator modeAnimator;
    public final boolean paddingBottomSystemWindowInsets;
    public final boolean paddingLeftSystemWindowInsets;
    public final boolean paddingRightSystemWindowInsets;
    public int rightInset;

    /* loaded from: classes2.dex */
    public interface AnimationListener {
        void onAnimationEnd(BottomAppBar bottomAppBar);

        void onAnimationStart(BottomAppBar bottomAppBar);
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Rect fabContentRect;
        public final View.OnLayoutChangeListener fabLayoutListener;
        public int originalBottomMargin;
        public WeakReference<BottomAppBar> viewRef;

        public Behavior() {
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
            this.fabLayoutListener = new View.OnLayoutChangeListener(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Behavior this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11)}) == null) {
                        BottomAppBar bottomAppBar = (BottomAppBar) this.this$0.viewRef.get();
                        if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            floatingActionButton.getMeasuredContentRect(this.this$0.fabContentRect);
                            int height = this.this$0.fabContentRect.height();
                            bottomAppBar.setFabDiameter(height);
                            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                            if (this.this$0.originalBottomMargin == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                                if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.fabOffsetEndMode;
                                    return;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.fabOffsetEndMode;
                                    return;
                                }
                            }
                            return;
                        }
                        view.removeOnLayoutChangeListener(this);
                    }
                }
            };
            this.fabContentRect = new Rect();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, bottomAppBar, i2)) == null) {
                this.viewRef = new WeakReference<>(bottomAppBar);
                View findDependentView = bottomAppBar.findDependentView();
                if (findDependentView != null && !ViewCompat.isLaidOut(findDependentView)) {
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) findDependentView.getLayoutParams();
                    layoutParams.anchorGravity = 49;
                    this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (findDependentView instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) findDependentView;
                        floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                        bottomAppBar.addFabAnimationListeners(floatingActionButton);
                    }
                    bottomAppBar.setCutoutState();
                }
                coordinatorLayout.onLayoutChild(bottomAppBar, i2);
                return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i2);
            }
            return invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{coordinatorLayout, bottomAppBar, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i2, i3) : invokeCommon.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attributeSet) {
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
            this.fabLayoutListener = new View.OnLayoutChangeListener(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Behavior this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = objArr;
                        Object[] objArr3 = {this};
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
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11)}) == null) {
                        BottomAppBar bottomAppBar = (BottomAppBar) this.this$0.viewRef.get();
                        if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            floatingActionButton.getMeasuredContentRect(this.this$0.fabContentRect);
                            int height = this.this$0.fabContentRect.height();
                            bottomAppBar.setFabDiameter(height);
                            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                            if (this.this$0.originalBottomMargin == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                                if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.fabOffsetEndMode;
                                    return;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.fabOffsetEndMode;
                                    return;
                                }
                            }
                            return;
                        }
                        view.removeOnLayoutChangeListener(this);
                    }
                }
            };
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FabAnimationMode {
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int fabAlignmentMode;
        public boolean fabAttached;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1243513168, "Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1243513168, "Lcom/google/android/material/bottomappbar/BottomAppBar$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.fabAlignmentMode);
                parcel.writeInt(this.fabAttached ? 1 : 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1516241096, "Lcom/google/android/material/bottomappbar/BottomAppBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1516241096, "Lcom/google/android/material/bottomappbar/BottomAppBar;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFabAnimationListeners(@NonNull FloatingActionButton floatingActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, floatingActionButton) == null) {
            floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
            floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomAppBar this$0;

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

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.fabAnimationListener.onAnimationStart(animator);
                        FloatingActionButton findDependentFab = this.this$0.findDependentFab();
                        if (findDependentFab != null) {
                            findDependentFab.setTranslationX(this.this$0.getFabTranslationX());
                        }
                    }
                }
            });
            floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.modeAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
        }
    }

    private void createFabTranslationXAnimation(int i2, @NonNull List<Animator> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, this, i2, list) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), AnimationProperty.TRANSLATE_X, getFabTranslationX(i2));
            ofFloat.setDuration(300L);
            list.add(ofFloat);
        }
    }

    private void createMenuViewTranslationAnimation(int i2, boolean z, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65572, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) || (actionMenuView = getActionMenuView()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, AnimationProperty.OPACITY, 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i2, z)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, AnimationProperty.OPACITY, 0.0f);
            ofFloat2.addListener(new AnimatorListenerAdapter(this, actionMenuView, i2, z) { // from class: com.google.android.material.bottomappbar.BottomAppBar.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean cancelled;
                public final /* synthetic */ BottomAppBar this$0;
                public final /* synthetic */ ActionMenuView val$actionMenuView;
                public final /* synthetic */ boolean val$targetAttached;
                public final /* synthetic */ int val$targetMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, actionMenuView, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$actionMenuView = actionMenuView;
                    this.val$targetMode = i2;
                    this.val$targetAttached = z;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.cancelled = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.cancelled) {
                        return;
                    }
                    this.this$0.translateActionMenuView(this.val$actionMenuView, this.val$targetMode, this.val$targetAttached);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        ArrayList<AnimationListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            int i2 = this.animatingModeChangeCounter - 1;
            this.animatingModeChangeCounter = i2;
            if (i2 != 0 || (arrayList = this.animationListeners) == null) {
                return;
            }
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationStart() {
        ArrayList<AnimationListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            int i2 = this.animatingModeChangeCounter;
            this.animatingModeChangeCounter = i2 + 1;
            if (i2 != 0 || (arrayList = this.animationListeners) == null) {
                return;
            }
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onAnimationStart(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton findDependentFab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            View findDependentView = findDependentView();
            if (findDependentView instanceof FloatingActionButton) {
                return (FloatingActionButton) findDependentView;
            }
            return null;
        }
        return (FloatingActionButton) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findDependentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            if (getParent() instanceof CoordinatorLayout) {
                for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
                    if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                        return view;
                    }
                    while (r0.hasNext()) {
                    }
                }
                return null;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ActionMenuView) {
                    return (ActionMenuView) childAt;
                }
            }
            return null;
        }
        return (ActionMenuView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) ? this.bottomInset : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65580, this, i2)) == null) {
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (i2 == 1) {
                return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (isLayoutRtl ? this.leftInset : this.rightInset))) * (isLayoutRtl ? -1 : 1);
            }
            return 0.0f;
        }
        return invokeI.floatValue;
    }

    private float getFabTranslationY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) ? -getTopEdgeTreatment().getCradleVerticalOffset() : invokeV.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) ? this.leftInset : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) ? this.rightInset : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) ? (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge() : (BottomAppBarTopEdgeTreatment) invokeV.objValue;
    }

    private boolean isFabVisibleOrWillBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            FloatingActionButton findDependentFab = findDependentFab();
            return findDependentFab != null && findDependentFab.isOrWillBeShown();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeAnimateMenuView(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ViewCompat.isLaidOut(this)) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!isFabVisibleOrWillBeShown()) {
                i2 = 0;
                z = false;
            }
            createMenuViewTranslationAnimation(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.menuAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomAppBar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.this$0.dispatchAnimationEnd();
                        this.this$0.menuAnimator = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.dispatchAnimationStart();
                    }
                }
            });
            this.menuAnimator.start();
        }
    }

    private void maybeAnimateModeChange(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65587, this, i2) == null) && this.fabAlignmentMode != i2 && ViewCompat.isLaidOut(this)) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAnimationMode == 1) {
                createFabTranslationXAnimation(i2, arrayList);
            } else {
                createFabDefaultXAnimation(i2, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomAppBar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.this$0.dispatchAnimationEnd();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                        this.this$0.dispatchAnimationStart();
                    }
                }
            });
            this.modeAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionMenuViewPosition() {
        ActionMenuView actionMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65588, this) == null) || (actionMenuView = getActionMenuView()) == null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (!isFabVisibleOrWillBeShown()) {
            translateActionMenuView(actionMenuView, 0, false);
        } else {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCutoutState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
            View findDependentView = findDependentView();
            this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : 0.0f);
            if (findDependentView != null) {
                findDependentView.setTranslationY(getFabTranslationY());
                findDependentView.setTranslationX(getFabTranslationX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, this, new Object[]{actionMenuView, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            actionMenuView.setTranslationX(getActionMenuViewTranslationX(actionMenuView, i2, z));
        }
    }

    public void addAnimationListener(@NonNull AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationListener) == null) {
            if (this.animationListeners == null) {
                this.animationListeners = new ArrayList<>();
            }
            this.animationListeners.add(animationListener);
        }
    }

    public void createFabDefaultXAnimation(int i2, List<Animator> list) {
        FloatingActionButton findDependentFab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, list) == null) || (findDependentFab = findDependentFab()) == null || findDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        findDependentFab.hide(new FloatingActionButton.OnVisibilityChangedListener(this, i2) { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomAppBar this$0;
            public final /* synthetic */ int val$targetMode;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$targetMode = i2;
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, floatingActionButton) == null) {
                    floatingActionButton.setTranslationX(this.this$0.getFabTranslationX(this.val$targetMode));
                    floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass5 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                        public void onShown(FloatingActionButton floatingActionButton2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, floatingActionButton2) == null) {
                                this.this$1.this$0.dispatchAnimationEnd();
                            }
                        }
                    });
                }
            }
        });
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{actionMenuView, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == 1 && z) {
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                int measuredWidth = isLayoutRtl ? getMeasuredWidth() : 0;
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                        if (isLayoutRtl) {
                            measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                        } else {
                            measuredWidth = Math.max(measuredWidth, childAt.getRight());
                        }
                    }
                }
                return measuredWidth - ((isLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (isLayoutRtl ? this.rightInset : -this.leftInset));
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.materialShapeDrawable.getTintList() : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getTopEdgeTreatment().getCradleVerticalOffset() : invokeV.floatValue;
    }

    public int getFabAlignmentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.fabAlignmentMode : invokeV.intValue;
    }

    public int getFabAnimationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.fabAnimationMode : invokeV.intValue;
    }

    public float getFabCradleMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getTopEdgeTreatment().getFabCradleMargin() : invokeV.floatValue;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getTopEdgeTreatment().getFabCradleRoundedCornerRadius() : invokeV.floatValue;
    }

    public boolean getHideOnScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.hideOnScroll : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                cancelAnimations();
                setCutoutState();
            }
            setActionMenuViewPosition();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.fabAlignmentMode = savedState.fabAlignmentMode;
            this.fabAttached = savedState.fabAttached;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.fabAlignmentMode = this.fabAlignmentMode;
            savedState.fabAttached = this.fabAttached;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void performHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            getBehavior().slideDown(this);
        }
    }

    public void performShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            getBehavior().slideUp(this);
        }
    }

    public void removeAnimationListener(@NonNull AnimationListener animationListener) {
        ArrayList<AnimationListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, animationListener) == null) || (arrayList = this.animationListeners) == null) {
            return;
        }
        arrayList.remove(animationListener);
    }

    public void replaceMenu(@MenuRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            getMenu().clear();
            inflateMenu(i2);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, colorStateList) == null) {
            DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
        }
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048597, this, f2) == null) || f2 == getCradleVerticalOffset()) {
            return;
        }
        getTopEdgeTreatment().setCradleVerticalOffset(f2);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutState();
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.materialShapeDrawable.setElevation(f2);
            getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
        }
    }

    public void setFabAlignmentMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            maybeAnimateModeChange(i2);
            maybeAnimateMenuView(i2, this.fabAttached);
            this.fabAlignmentMode = i2;
        }
    }

    public void setFabAnimationMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.fabAnimationMode = i2;
        }
    }

    public void setFabCradleMargin(@Dimension float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048601, this, f2) == null) || f2 == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().setFabCradleMargin(f2);
        this.materialShapeDrawable.invalidateSelf();
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048602, this, f2) == null) || f2 == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f2);
        this.materialShapeDrawable.invalidateSelf();
    }

    public boolean setFabDiameter(@Px int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            float f2 = i2;
            if (f2 != getTopEdgeTreatment().getFabDiameter()) {
                getTopEdgeTreatment().setFabDiameter(f2);
                this.materialShapeDrawable.invalidateSelf();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setHideOnScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.hideOnScroll = z;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, charSequence) == null) {
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, charSequence) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.behavior == null) {
                this.behavior = new Behavior();
            }
            return this.behavior;
        }
        return (Behavior) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.materialShapeDrawable = new MaterialShapeDrawable();
        this.animatingModeChangeCounter = 0;
        this.fabAttached = true;
        this.fabAnimationListener = new AnimatorListenerAdapter(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomAppBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    BottomAppBar bottomAppBar = this.this$0;
                    bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, this.this$0.fabAttached);
                }
            }
        };
        this.fabTransformationCallback = new TransformationCallback<FloatingActionButton>(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomAppBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.android.material.animation.TransformationCallback
            public void onScaleChanged(@NonNull FloatingActionButton floatingActionButton) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, floatingActionButton) == null) {
                    this.this$0.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.android.material.animation.TransformationCallback
            public void onTranslationChanged(@NonNull FloatingActionButton floatingActionButton) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, floatingActionButton) == null) {
                    float translationX = floatingActionButton.getTranslationX();
                    if (this.this$0.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                        this.this$0.getTopEdgeTreatment().setHorizontalOffset(translationX);
                        this.this$0.materialShapeDrawable.invalidateSelf();
                    }
                    float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
                    if (this.this$0.getTopEdgeTreatment().getCradleVerticalOffset() != max) {
                        this.this$0.getTopEdgeTreatment().setCradleVerticalOffset(max);
                        this.this$0.materialShapeDrawable.invalidateSelf();
                    }
                    this.this$0.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
                }
            }
        };
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BottomAppBar, i2, DEF_STYLE_RES, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0))).build());
        this.materialShapeDrawable.setShadowCompatibilityMode(2);
        this.materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        this.materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, this.materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i2, DEF_STYLE_RES, new ViewUtils.OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomAppBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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
            }

            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                InterceptResult invokeLLL;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, view, windowInsetsCompat, relativePadding)) == null) {
                    if (this.this$0.paddingBottomSystemWindowInsets) {
                        this.this$0.bottomInset = windowInsetsCompat.getSystemWindowInsetBottom();
                    }
                    boolean z2 = false;
                    if (this.this$0.paddingLeftSystemWindowInsets) {
                        z = this.this$0.leftInset != windowInsetsCompat.getSystemWindowInsetLeft();
                        this.this$0.leftInset = windowInsetsCompat.getSystemWindowInsetLeft();
                    } else {
                        z = false;
                    }
                    if (this.this$0.paddingRightSystemWindowInsets) {
                        boolean z3 = this.this$0.rightInset != windowInsetsCompat.getSystemWindowInsetRight();
                        this.this$0.rightInset = windowInsetsCompat.getSystemWindowInsetRight();
                        z2 = z3;
                    }
                    if (z || z2) {
                        this.this$0.cancelAnimations();
                        this.this$0.setCutoutState();
                        this.this$0.setActionMenuViewPosition();
                    }
                    return windowInsetsCompat;
                }
                return (WindowInsetsCompat) invokeLLL.objValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) ? getFabTranslationX(this.fabAlignmentMode) : invokeV.floatValue;
    }
}
