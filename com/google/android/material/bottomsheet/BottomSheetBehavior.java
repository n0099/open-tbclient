package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORNER_ANIMATION_DURATION = 500;

    /* renamed from: DEF_STYLE_RES */
    public static final int obfuscated_res_0x7f100331 = 2131755825;
    public static final float HIDE_FRICTION = 0.1f;
    public static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    public static final String TAG = "BottomSheetBehavior";
    public transient /* synthetic */ FieldHolder $fh;
    public int activePointerId;
    @NonNull
    public final ArrayList<BottomSheetCallback> callbacks;
    public int childHeight;
    public int collapsedOffset;
    public final ViewDragHelper.Callback dragCallback;
    public boolean draggable;
    public float elevation;
    public int expandedOffset;
    public boolean fitToContents;
    public int fitToContentsOffset;
    public int gestureInsetBottom;
    public boolean gestureInsetBottomIgnored;
    public int halfExpandedOffset;
    public float halfExpandedRatio;
    public boolean hideable;
    public boolean ignoreEvents;
    @Nullable
    public Map<View, Integer> importantForAccessibilityMap;
    public int initialY;
    @Nullable
    public ValueAnimator interpolatorAnimator;
    public boolean isShapeExpanded;
    public int lastNestedScrollDy;
    public MaterialShapeDrawable materialShapeDrawable;
    public float maximumVelocity;
    public boolean nestedScrolled;
    @Nullable
    public WeakReference<View> nestedScrollingChildRef;
    public int parentHeight;
    public int parentWidth;
    public int peekHeight;
    public boolean peekHeightAuto;
    public int peekHeightGestureInsetBuffer;
    public int peekHeightMin;
    public int saveFlags;
    public BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    public ShapeAppearanceModel shapeAppearanceModelDefault;
    public boolean shapeThemingEnabled;
    public boolean skipCollapsed;
    public int state;
    public boolean touchingScrollingChild;
    public boolean updateImportantForAccessibilityOnSiblings;
    @Nullable
    public VelocityTracker velocityTracker;
    @Nullable
    public ViewDragHelper viewDragHelper;
    @Nullable
    public WeakReference<V> viewRef;

    /* loaded from: classes7.dex */
    public static abstract class BottomSheetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BottomSheetCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void onSlide(@NonNull View view2, float f);

        public abstract void onStateChanged(@NonNull View view2, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes7.dex */
    public @interface SaveFlags {
    }

    /* loaded from: classes7.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean fitToContents;
        public boolean hideable;
        public int peekHeight;
        public boolean skipCollapsed;
        public final int state;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1575058220, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1575058220, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, (ClassLoader) null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.state);
                parcel.writeInt(this.peekHeight);
                parcel.writeInt(this.fitToContents ? 1 : 0);
                parcel.writeInt(this.hideable ? 1 : 0);
                parcel.writeInt(this.skipCollapsed ? 1 : 0);
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
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable, bottomSheetBehavior};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable, Integer.valueOf(i)};
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
            this.state = i;
        }
    }

    /* loaded from: classes7.dex */
    public class SettleRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isPosted;
        public int targetState;
        public final /* synthetic */ BottomSheetBehavior this$0;

        /* renamed from: view  reason: collision with root package name */
        public final View f1071view;

        public SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bottomSheetBehavior, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bottomSheetBehavior;
            this.f1071view = view2;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewDragHelper viewDragHelper = this.this$0.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    ViewCompat.postOnAnimation(this.f1071view, this);
                } else {
                    this.this$0.setStateInternal(this.targetState);
                }
                this.isPosted = false;
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes7.dex */
    public @interface State {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2039048484, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2039048484, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;");
        }
    }

    public BottomSheetBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.Callback(this) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomSheetBehavior this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private boolean releasedLow(@NonNull View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, view2)) == null) {
                    int top = view2.getTop();
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
                }
                return invokeL.booleanValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view2, int i3, int i4) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, view2, i3, i4)) == null) ? view2.getLeft() : invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view2, int i3, int i4) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i3, i4)) == null) {
                    int expandedOffset = this.this$0.getExpandedOffset();
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    return MathUtils.clamp(i3, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
                }
                return invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    if (bottomSheetBehavior.hideable) {
                        return bottomSheetBehavior.parentHeight;
                    }
                    return bottomSheetBehavior.collapsedOffset;
                }
                return invokeL.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeI(1048579, this, i3) == null) && i3 == 1 && this.this$0.draggable) {
                    this.this$0.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view2, int i3, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{view2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                    this.this$0.dispatchOnSlide(i4);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view2, float f, float f2) {
                int i3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    int i4 = 4;
                    if (f2 < 0.0f) {
                        if (this.this$0.fitToContents) {
                            i3 = this.this$0.fitToContentsOffset;
                        } else {
                            int top = view2.getTop();
                            BottomSheetBehavior bottomSheetBehavior = this.this$0;
                            int i5 = bottomSheetBehavior.halfExpandedOffset;
                            if (top > i5) {
                                i3 = i5;
                                i4 = 6;
                            } else {
                                i3 = bottomSheetBehavior.expandedOffset;
                            }
                        }
                        i4 = 3;
                    } else {
                        BottomSheetBehavior bottomSheetBehavior2 = this.this$0;
                        if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view2, f2)) {
                            if ((Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view2)) {
                                if (this.this$0.fitToContents) {
                                    i3 = this.this$0.fitToContentsOffset;
                                } else if (Math.abs(view2.getTop() - this.this$0.expandedOffset) < Math.abs(view2.getTop() - this.this$0.halfExpandedOffset)) {
                                    i3 = this.this$0.expandedOffset;
                                } else {
                                    i3 = this.this$0.halfExpandedOffset;
                                    i4 = 6;
                                }
                                i4 = 3;
                            } else {
                                i3 = this.this$0.parentHeight;
                                i4 = 5;
                            }
                        } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                            if (this.this$0.fitToContents) {
                                i3 = this.this$0.collapsedOffset;
                            } else {
                                int top2 = view2.getTop();
                                if (Math.abs(top2 - this.this$0.halfExpandedOffset) < Math.abs(top2 - this.this$0.collapsedOffset)) {
                                    i3 = this.this$0.halfExpandedOffset;
                                    i4 = 6;
                                } else {
                                    i3 = this.this$0.collapsedOffset;
                                }
                            }
                        } else {
                            int top3 = view2.getTop();
                            if (this.this$0.fitToContents) {
                                if (Math.abs(top3 - this.this$0.fitToContentsOffset) < Math.abs(top3 - this.this$0.collapsedOffset)) {
                                    i3 = this.this$0.fitToContentsOffset;
                                    i4 = 3;
                                } else {
                                    i3 = this.this$0.collapsedOffset;
                                }
                            } else {
                                BottomSheetBehavior bottomSheetBehavior3 = this.this$0;
                                int i6 = bottomSheetBehavior3.halfExpandedOffset;
                                if (top3 < i6) {
                                    if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                        i3 = this.this$0.expandedOffset;
                                        i4 = 3;
                                    } else {
                                        i3 = this.this$0.halfExpandedOffset;
                                    }
                                } else if (Math.abs(top3 - i6) < Math.abs(top3 - this.this$0.collapsedOffset)) {
                                    i3 = this.this$0.halfExpandedOffset;
                                } else {
                                    i3 = this.this$0.collapsedOffset;
                                }
                                i4 = 6;
                            }
                        }
                    }
                    this.this$0.startSettlingAnimation(view2, i4, i3, true);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view2, int i3) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048582, this, view2, i3)) == null) {
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    int i4 = bottomSheetBehavior.state;
                    if (i4 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                        return false;
                    }
                    if (i4 == 3 && bottomSheetBehavior.activePointerId == i3) {
                        WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                        View view3 = weakReference != null ? weakReference.get() : null;
                        if (view3 != null && view3.canScrollVertically(-1)) {
                            return false;
                        }
                    }
                    WeakReference<V> weakReference2 = this.this$0.viewRef;
                    return weakReference2 != null && weakReference2.get() == view2;
                }
                return invokeLI.booleanValue;
            }
        };
    }

    private void addAccessibilityActionForState(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, this, v, accessibilityActionCompat, i) == null) {
            ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new AccessibilityViewCommand(this, i) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetBehavior this$0;
                public final /* synthetic */ int val$state;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$state = i;
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, commandArguments)) == null) {
                        this.this$0.setState(this.val$state);
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    private void calculateCollapsedOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int calculatePeekHeight = calculatePeekHeight();
            if (this.fitToContents) {
                this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
            } else {
                this.collapsedOffset = this.parentHeight - calculatePeekHeight;
            }
        }
    }

    private void calculateHalfExpandedOffset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
        }
    }

    private int calculatePeekHeight() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.peekHeightAuto) {
                return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
            }
            if (!this.gestureInsetBottomIgnored && (i = this.gestureInsetBottom) > 0) {
                return Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
            }
            return this.peekHeight;
        }
        return invokeV.intValue;
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65550, this, context, attributeSet, z) == null) {
            createMaterialShapeDrawable(context, attributeSet, z, null);
        }
    }

    private void createShapeValueAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.interpolatorAnimator = ofFloat;
            ofFloat.setDuration(500L);
            this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetBehavior this$0;

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (this.this$0.materialShapeDrawable != null) {
                            this.this$0.materialShapeDrawable.setInterpolation(floatValue);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, v)) == null) {
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) behavior;
                }
                throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            }
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        return (BottomSheetBehavior) invokeL.objValue;
    }

    private float getYVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker == null) {
                return 0.0f;
            }
            velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
            return this.velocityTracker.getYVelocity(this.activePointerId);
        }
        return invokeV.floatValue;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, savedState) == null) || (i = this.saveFlags) == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        int i2 = this.saveFlags;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        int i3 = this.saveFlags;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        int i4 = this.saveFlags;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setSystemGestureInsets(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, view2) == null) || Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view2, new ViewUtils.OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomSheetBehavior this$0;

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

            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view3, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, view3, windowInsetsCompat, relativePadding)) == null) {
                    this.this$0.gestureInsetBottom = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                    this.this$0.updatePeekHeight(false);
                    return windowInsetsCompat;
                }
                return (WindowInsetsCompat) invokeLLL.objValue;
            }
        });
    }

    private void settleToStatePendingLayout(int i) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65558, this, i) == null) || (v = this.viewRef.get()) == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new Runnable(this, v, i) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetBehavior this$0;
                public final /* synthetic */ View val$child;
                public final /* synthetic */ int val$finalState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, v, Integer.valueOf(i)};
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
                    this.val$child = v;
                    this.val$finalState = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.settleToState(this.val$child, this.val$finalState);
                    }
                }
            });
        } else {
            settleToState(v, i);
        }
    }

    private void updateAccessibilityActions() {
        WeakReference<V> weakReference;
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (weakReference = this.viewRef) == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i = this.state;
        if (i == 3) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.fitToContents ? 4 : 6);
        } else if (i == 4) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.fitToContents ? 3 : 6);
        } else if (i != 6) {
        } else {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void updateDrawableForTargetState(int i) {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65560, this, i) == null) || i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.isShapeExpanded != z) {
            this.isShapeExpanded = z;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - f, f);
            this.interpolatorAnimator.start();
        }
    }

    private void updateImportantForAccessibility(boolean z) {
        WeakReference<V> weakReference;
        Map<View, Integer> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65561, this, z) == null) || (weakReference = this.viewRef) == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                }
                this.importantForAccessibilityMap = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65562, this, z) == null) || this.viewRef == null) {
            return;
        }
        calculateCollapsedOffset();
        if (this.state != 4 || (v = this.viewRef.get()) == null) {
            return;
        }
        if (z) {
            settleToStatePendingLayout(this.state);
        } else {
            v.requestLayout();
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bottomSheetCallback) == null) || this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.interpolatorAnimator = null;
        }
    }

    public void dispatchOnSlide(int i) {
        V v;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (v = this.viewRef.get()) == null || this.callbacks.isEmpty()) {
            return;
        }
        int i2 = this.collapsedOffset;
        if (i <= i2 && i2 != getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            f = i3 - i;
            f2 = i3 - getExpandedOffset();
        } else {
            int i4 = this.collapsedOffset;
            f = i4 - i;
            f2 = this.parentHeight - i4;
        }
        float f3 = f / f2;
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onSlide(v, f3);
        }
    }

    @Nullable
    @VisibleForTesting
    public View findScrollingChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            if (ViewCompat.isNestedScrollingEnabled(view2)) {
                return view2;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                    if (findScrollingChild != null) {
                        return findScrollingChild;
                    }
                }
                return null;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public int getExpandedOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fitToContents ? this.fitToContentsOffset : this.expandedOffset : invokeV.intValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.halfExpandedRatio : invokeV.floatValue;
    }

    public int getPeekHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.peekHeightAuto) {
                return -1;
            }
            return this.peekHeight;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.peekHeightMin : invokeV.intValue;
    }

    public int getSaveFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.saveFlags : invokeV.intValue;
    }

    public boolean getSkipCollapsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.skipCollapsed : invokeV.booleanValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.state : invokeV.intValue;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.draggable : invokeV.booleanValue;
    }

    public boolean isFitToContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.fitToContents : invokeV.booleanValue;
    }

    public boolean isGestureInsetBottomIgnored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.gestureInsetBottomIgnored : invokeV.booleanValue;
    }

    public boolean isHideable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.hideable : invokeV.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            this.viewRef = null;
            this.viewDragHelper = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromLayoutParams();
            this.viewRef = null;
            this.viewDragHelper = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        ViewDragHelper viewDragHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, coordinatorLayout, v, motionEvent)) == null) {
            if (v.isShown() && this.draggable) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    reset();
                }
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.addMovement(motionEvent);
                if (actionMasked == 0) {
                    int x = (int) motionEvent.getX();
                    this.initialY = (int) motionEvent.getY();
                    if (this.state != 2) {
                        WeakReference<View> weakReference = this.nestedScrollingChildRef;
                        View view2 = weakReference != null ? weakReference.get() : null;
                        if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                            this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.touchingScrollingChild = true;
                        }
                    }
                    this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
                } else if (actionMasked == 1 || actionMasked == 3) {
                    this.touchingScrollingChild = false;
                    this.activePointerId = -1;
                    if (this.ignoreEvents) {
                        this.ignoreEvents = false;
                        return false;
                    }
                }
                if (this.ignoreEvents || (viewDragHelper = this.viewDragHelper) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                    WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
                    View view3 = weakReference2 != null ? weakReference2.get() : null;
                    return (actionMasked != 2 || view3 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
                }
                return true;
            }
            this.ignoreEvents = true;
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        InterceptResult invokeLLI;
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, coordinatorLayout, v, i)) == null) {
            if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
                v.setFitsSystemWindows(true);
            }
            if (this.viewRef == null) {
                this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070200);
                setSystemGestureInsets(v);
                this.viewRef = new WeakReference<>(v);
                if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                    ViewCompat.setBackground(v, materialShapeDrawable);
                }
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                if (materialShapeDrawable2 != null) {
                    float f = this.elevation;
                    if (f == -1.0f) {
                        f = ViewCompat.getElevation(v);
                    }
                    materialShapeDrawable2.setElevation(f);
                    boolean z = this.state == 3;
                    this.isShapeExpanded = z;
                    this.materialShapeDrawable.setInterpolation(z ? 0.0f : 1.0f);
                }
                updateAccessibilityActions();
                if (ViewCompat.getImportantForAccessibility(v) == 0) {
                    ViewCompat.setImportantForAccessibility(v, 1);
                }
            }
            if (this.viewDragHelper == null) {
                this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
            }
            int top = v.getTop();
            coordinatorLayout.onLayoutChild(v, i);
            this.parentWidth = coordinatorLayout.getWidth();
            this.parentHeight = coordinatorLayout.getHeight();
            int height = v.getHeight();
            this.childHeight = height;
            this.fitToContentsOffset = Math.max(0, this.parentHeight - height);
            calculateHalfExpandedOffset();
            calculateCollapsedOffset();
            int i2 = this.state;
            if (i2 == 3) {
                ViewCompat.offsetTopAndBottom(v, getExpandedOffset());
            } else if (i2 == 6) {
                ViewCompat.offsetTopAndBottom(v, this.halfExpandedOffset);
            } else if (this.hideable && i2 == 5) {
                ViewCompat.offsetTopAndBottom(v, this.parentHeight);
            } else {
                int i3 = this.state;
                if (i3 == 4) {
                    ViewCompat.offsetTopAndBottom(v, this.collapsedOffset);
                } else if (i3 == 1 || i3 == 2) {
                    ViewCompat.offsetTopAndBottom(v, top - v.getTop());
                }
            }
            this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
            return true;
        }
        return invokeLLI.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{coordinatorLayout, v, view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference == null || view2 != weakReference.get()) {
                return false;
            }
            return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view2, f, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, @NonNull int[] iArr, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{coordinatorLayout, v, view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) || i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (view2 != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < getExpandedOffset()) {
                iArr[1] = top - getExpandedOffset();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                setStateInternal(3);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
            int i5 = this.collapsedOffset;
            if (i4 > i5 && !this.hideable) {
                iArr[1] = top - i5;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                setStateInternal(4);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v.getTop());
        this.lastNestedScrollDy = i2;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{coordinatorLayout, v, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr}) == null) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, coordinatorLayout, v, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
            restoreOptionalState(savedState);
            int i = savedState.state;
            if (i != 1 && i != 2) {
                this.state = i;
            } else {
                this.state = 4;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, coordinatorLayout, v)) == null) ? new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this) : (Parcelable) invokeLL.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{coordinatorLayout, v, view2, view3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.lastNestedScrollDy = 0;
            this.nestedScrolled = false;
            return (i & 2) != 0;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048601, this, coordinatorLayout, v, view2, i) == null) {
            int i3 = 3;
            if (v.getTop() == getExpandedOffset()) {
                setStateInternal(3);
                return;
            }
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null && view2 == weakReference.get() && this.nestedScrolled) {
                if (this.lastNestedScrollDy > 0) {
                    if (this.fitToContents) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        int top = v.getTop();
                        int i4 = this.halfExpandedOffset;
                        if (top > i4) {
                            i2 = i4;
                            i3 = 6;
                        } else {
                            i2 = this.expandedOffset;
                        }
                    }
                } else if (this.hideable && shouldHide(v, getYVelocity())) {
                    i2 = this.parentHeight;
                    i3 = 5;
                } else if (this.lastNestedScrollDy == 0) {
                    int top2 = v.getTop();
                    if (this.fitToContents) {
                        if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.fitToContentsOffset;
                        } else {
                            i2 = this.collapsedOffset;
                            i3 = 4;
                        }
                    } else {
                        int i5 = this.halfExpandedOffset;
                        if (top2 < i5) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i2 = this.expandedOffset;
                            } else {
                                i2 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i2 = this.collapsedOffset;
                            i3 = 4;
                        }
                        i3 = 6;
                    }
                } else {
                    if (this.fitToContents) {
                        i2 = this.collapsedOffset;
                    } else {
                        int top3 = v.getTop();
                        if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                            i3 = 6;
                        } else {
                            i2 = this.collapsedOffset;
                        }
                    }
                    i3 = 4;
                }
                startSettlingAnimation(v, i3, i2, false);
                this.nestedScrolled = false;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, coordinatorLayout, v, motionEvent)) == null) {
            if (v.isShown()) {
                int actionMasked = motionEvent.getActionMasked();
                if (this.state == 1 && actionMasked == 0) {
                    return true;
                }
                ViewDragHelper viewDragHelper = this.viewDragHelper;
                if (viewDragHelper != null) {
                    viewDragHelper.processTouchEvent(motionEvent);
                }
                if (actionMasked == 0) {
                    reset();
                }
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.addMovement(motionEvent);
                if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
                    this.viewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
                return !this.ignoreEvents;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bottomSheetCallback) == null) {
            this.callbacks.remove(bottomSheetCallback);
        }
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bottomSheetCallback) == null) {
            Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
            this.callbacks.clear();
            if (bottomSheetCallback != null) {
                this.callbacks.add(bottomSheetCallback);
            }
        }
    }

    public void setDraggable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.draggable = z;
        }
    }

    public void setExpandedOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            if (i >= 0) {
                this.expandedOffset = i;
                return;
            }
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
    }

    public void setFitToContents(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.gestureInsetBottomIgnored = z;
        }
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f) == null) {
            if (f > 0.0f && f < 1.0f) {
                this.halfExpandedRatio = f;
                if (this.viewRef != null) {
                    calculateHalfExpandedOffset();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
    }

    public void setHideable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || this.hideable == z) {
            return;
        }
        this.hideable = z;
        if (!z && this.state == 5) {
            setState(4);
        }
        updateAccessibilityActions();
    }

    public void setPeekHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            setPeekHeight(i, false);
        }
    }

    public void setSaveFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.saveFlags = i;
        }
    }

    public void setSkipCollapsed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.skipCollapsed = z;
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i) == null) || i == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.state = i;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i);
    }

    public void setStateInternal(int i) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i) == null) || this.state == i) {
            return;
        }
        this.state = i;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 6 || i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onStateChanged(v, i);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.updateImportantForAccessibilityOnSiblings = z;
        }
    }

    public void settleToState(@NonNull View view2, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, view2, i) == null) {
            if (i == 4) {
                i2 = this.collapsedOffset;
            } else if (i == 6) {
                int i4 = this.halfExpandedOffset;
                if (!this.fitToContents || i4 > (i3 = this.fitToContentsOffset)) {
                    i2 = i4;
                } else {
                    i2 = i3;
                    i = 3;
                }
            } else if (i == 3) {
                i2 = getExpandedOffset();
            } else if (this.hideable && i == 5) {
                i2 = this.parentHeight;
            } else {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            startSettlingAnimation(view2, i, i2, false);
        }
    }

    public boolean shouldHide(@NonNull View view2, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048619, this, view2, f)) == null) {
            if (this.skipCollapsed) {
                return true;
            }
            if (view2.getTop() < this.collapsedOffset) {
                return false;
            }
            return Math.abs((((float) view2.getTop()) + (f * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
        }
        return invokeLF.booleanValue;
    }

    public void startSettlingAnimation(View view2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view2, view2.getLeft(), i2) : !viewDragHelper.settleCapturedViewAt(view2.getLeft(), i2))) {
                setStateInternal(2);
                updateDrawableForTargetState(i);
                if (this.settleRunnable == null) {
                    this.settleRunnable = new SettleRunnable(this, view2, i);
                }
                if (!this.settleRunnable.isPosted) {
                    BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
                    settleRunnable.targetState = i;
                    ViewCompat.postOnAnimation(view2, settleRunnable);
                    this.settleRunnable.isPosted = true;
                    return;
                }
                this.settleRunnable.targetState = i;
                return;
            }
            setStateInternal(i);
        }
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{context, attributeSet, Boolean.valueOf(z), colorStateList}) == null) && this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, (int) R.attr.obfuscated_res_0x7f0400f6, obfuscated_res_0x7f100331).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public final void setPeekHeight(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            boolean z2 = true;
            if (i == -1) {
                if (!this.peekHeightAuto) {
                    this.peekHeightAuto = true;
                }
                z2 = false;
            } else {
                if (this.peekHeightAuto || this.peekHeight != i) {
                    this.peekHeightAuto = false;
                    this.peekHeight = Math.max(0, i);
                }
                z2 = false;
            }
            if (z2) {
                updatePeekHeight(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.Callback(this) { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomSheetBehavior this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private boolean releasedLow(@NonNull View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, view2)) == null) {
                    int top = view2.getTop();
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
                }
                return invokeL.booleanValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view2, int i32, int i4) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, view2, i32, i4)) == null) ? view2.getLeft() : invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view2, int i32, int i4) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i32, i4)) == null) {
                    int expandedOffset = this.this$0.getExpandedOffset();
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    return MathUtils.clamp(i32, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
                }
                return invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    if (bottomSheetBehavior.hideable) {
                        return bottomSheetBehavior.parentHeight;
                    }
                    return bottomSheetBehavior.collapsedOffset;
                }
                return invokeL.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i32) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeI(1048579, this, i32) == null) && i32 == 1 && this.this$0.draggable) {
                    this.this$0.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view2, int i32, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{view2, Integer.valueOf(i32), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                    this.this$0.dispatchOnSlide(i4);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view2, float f, float f2) {
                int i32;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    int i4 = 4;
                    if (f2 < 0.0f) {
                        if (this.this$0.fitToContents) {
                            i32 = this.this$0.fitToContentsOffset;
                        } else {
                            int top = view2.getTop();
                            BottomSheetBehavior bottomSheetBehavior = this.this$0;
                            int i5 = bottomSheetBehavior.halfExpandedOffset;
                            if (top > i5) {
                                i32 = i5;
                                i4 = 6;
                            } else {
                                i32 = bottomSheetBehavior.expandedOffset;
                            }
                        }
                        i4 = 3;
                    } else {
                        BottomSheetBehavior bottomSheetBehavior2 = this.this$0;
                        if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view2, f2)) {
                            if ((Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view2)) {
                                if (this.this$0.fitToContents) {
                                    i32 = this.this$0.fitToContentsOffset;
                                } else if (Math.abs(view2.getTop() - this.this$0.expandedOffset) < Math.abs(view2.getTop() - this.this$0.halfExpandedOffset)) {
                                    i32 = this.this$0.expandedOffset;
                                } else {
                                    i32 = this.this$0.halfExpandedOffset;
                                    i4 = 6;
                                }
                                i4 = 3;
                            } else {
                                i32 = this.this$0.parentHeight;
                                i4 = 5;
                            }
                        } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                            if (this.this$0.fitToContents) {
                                i32 = this.this$0.collapsedOffset;
                            } else {
                                int top2 = view2.getTop();
                                if (Math.abs(top2 - this.this$0.halfExpandedOffset) < Math.abs(top2 - this.this$0.collapsedOffset)) {
                                    i32 = this.this$0.halfExpandedOffset;
                                    i4 = 6;
                                } else {
                                    i32 = this.this$0.collapsedOffset;
                                }
                            }
                        } else {
                            int top3 = view2.getTop();
                            if (this.this$0.fitToContents) {
                                if (Math.abs(top3 - this.this$0.fitToContentsOffset) < Math.abs(top3 - this.this$0.collapsedOffset)) {
                                    i32 = this.this$0.fitToContentsOffset;
                                    i4 = 3;
                                } else {
                                    i32 = this.this$0.collapsedOffset;
                                }
                            } else {
                                BottomSheetBehavior bottomSheetBehavior3 = this.this$0;
                                int i6 = bottomSheetBehavior3.halfExpandedOffset;
                                if (top3 < i6) {
                                    if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                        i32 = this.this$0.expandedOffset;
                                        i4 = 3;
                                    } else {
                                        i32 = this.this$0.halfExpandedOffset;
                                    }
                                } else if (Math.abs(top3 - i6) < Math.abs(top3 - this.this$0.collapsedOffset)) {
                                    i32 = this.this$0.halfExpandedOffset;
                                } else {
                                    i32 = this.this$0.collapsedOffset;
                                }
                                i4 = 6;
                            }
                        }
                    }
                    this.this$0.startSettlingAnimation(view2, i4, i32, true);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view2, int i32) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048582, this, view2, i32)) == null) {
                    BottomSheetBehavior bottomSheetBehavior = this.this$0;
                    int i4 = bottomSheetBehavior.state;
                    if (i4 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                        return false;
                    }
                    if (i4 == 3 && bottomSheetBehavior.activePointerId == i32) {
                        WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                        View view3 = weakReference != null ? weakReference.get() : null;
                        if (view3 != null && view3.canScrollVertically(-1)) {
                            return false;
                        }
                    }
                    WeakReference<V> weakReference2 = this.this$0.viewRef;
                    return weakReference2 != null && weakReference2.get() == view2;
                }
                return invokeLI.booleanValue;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704b9);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843840, R.attr.obfuscated_res_0x7f0400b9, R.attr.obfuscated_res_0x7f0400d4, R.attr.obfuscated_res_0x7f0400d5, R.attr.obfuscated_res_0x7f0400d6, R.attr.obfuscated_res_0x7f0400d7, R.attr.obfuscated_res_0x7f0400d8, R.attr.obfuscated_res_0x7f0400da, R.attr.obfuscated_res_0x7f0400db, R.attr.obfuscated_res_0x7f0400dc, R.attr.obfuscated_res_0x7f0402e9, R.attr.obfuscated_res_0x7f040615, R.attr.obfuscated_res_0x7f040618});
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(11);
        boolean hasValue = obtainStyledAttributes.hasValue(1);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, 1));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(0, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(7);
        if (peekValue != null && (i = peekValue.data) == -1) {
            setPeekHeight(i);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(7, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(6, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(10, false));
        setFitToContents(obtainStyledAttributes.getBoolean(4, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(9, false));
        setDraggable(obtainStyledAttributes.getBoolean(2, true));
        setSaveFlags(obtainStyledAttributes.getInt(8, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(5, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(3);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
