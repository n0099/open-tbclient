package com.kwad.sdk.lib.desigin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CustomReboundBehavior extends CustomAppBarLayoutBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_REBOUND_MAX_OFFSET = 150;
    public static final int REBOUND_ANIM_TIME = 200;
    public static final String TAG;
    public static final int TYPE_UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<KSAppBarLayout> mAppBartReference;
    public WeakReference<KSCoordinatorLayout> mCoordinatorReference;
    public List<CustomReboundOffsetCallback> mCustomReboundOffsetCallbacks;
    public boolean mEnableRebound;
    public HeaderTopBottomOffsetChangeListener mHeaderTopBottomOffsetChangeListener;
    public int mOffsetDelta;
    public int mOffsetRebound;
    public int mPreHeadHeight;
    public final int mReboundMaxOffset;
    public ValueAnimator mReboundRecoverAnimator;
    public View mReboundView;
    public final int mReboundViewId;
    public int mReboundViewOriginHeight;
    public int mReboundViewOriginWidth;

    /* loaded from: classes7.dex */
    public interface HeaderTopBottomOffsetChangeListener {
        void onHeaderTopBottomOffsetChange(int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(552495438, "Lcom/kwad/sdk/lib/desigin/CustomReboundBehavior;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(552495438, "Lcom/kwad/sdk/lib/desigin/CustomReboundBehavior;");
                return;
            }
        }
        TAG = CustomReboundBehavior.class.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReboundBehavior(Context context, AttributeSet attributeSet) {
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
        int i4 = R.attr.ksad_reboundMaxOffset;
        int i5 = R.attr.ksad_reboundViewId;
        int i6 = R.attr.ksad_enableRebound;
        int[] iArr = {i4, i5, i6};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mReboundMaxOffset = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i4), (int) ((context.getResources().getDisplayMetrics().density * 150.0f) + 0.5f));
        this.mReboundViewId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i5), 0);
        this.mEnableRebound = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i6), true);
        obtainStyledAttributes.recycle();
        if (this.mReboundViewId == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReboundBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        super(customAppBarBehaviorParams);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {customAppBarBehaviorParams};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((CustomAppBarBehaviorParams) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mReboundMaxOffset = customAppBarBehaviorParams.mReboundMaxOffset;
        this.mEnableRebound = customAppBarBehaviorParams.mEnableRebound;
        int i4 = customAppBarBehaviorParams.mReboundViewId;
        this.mReboundViewId = i4;
        if (i4 == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    private void animateReboundRecover(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, this, kSCoordinatorLayout, kSAppBarLayout) == null) {
            ValueAnimator valueAnimator = this.mReboundRecoverAnimator;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.mReboundRecoverAnimator = valueAnimator2;
                valueAnimator2.setDuration(200L);
                this.mReboundRecoverAnimator.setInterpolator(new DecelerateInterpolator());
                this.mReboundRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, kSCoordinatorLayout, kSAppBarLayout) { // from class: com.kwad.sdk.lib.desigin.CustomReboundBehavior.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CustomReboundBehavior this$0;
                    public final /* synthetic */ KSAppBarLayout val$appBarLayout;
                    public final /* synthetic */ KSCoordinatorLayout val$coordinatorLayout;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, kSCoordinatorLayout, kSAppBarLayout};
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
                        this.val$coordinatorLayout = kSCoordinatorLayout;
                        this.val$appBarLayout = kSAppBarLayout;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            this.this$0.updateReboundHeaderHeight(this.val$coordinatorLayout, this.val$appBarLayout, ((Integer) valueAnimator3.getAnimatedValue()).intValue(), 2);
                        }
                    }
                });
            } else if (valueAnimator.isRunning()) {
                this.mReboundRecoverAnimator.cancel();
            }
            this.mReboundRecoverAnimator.setIntValues(this.mOffsetRebound, 0);
            this.mReboundRecoverAnimator.start();
        }
    }

    private void checkShouldReboundRecover(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, kSCoordinatorLayout, kSAppBarLayout) == null) || this.mOffsetRebound <= 0) {
            return;
        }
        animateReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
    }

    private int getHeaderExpandedHeight(KSAppBarLayout kSAppBarLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, kSAppBarLayout)) == null) {
            int childCount = kSAppBarLayout.getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = kSAppBarLayout.getChildAt(i3);
                KSAppBarLayout.LayoutParams layoutParams = (KSAppBarLayout.LayoutParams) childAt.getLayoutParams();
                i2 += ((LinearLayout.LayoutParams) layoutParams).bottomMargin + ((LinearLayout.LayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight();
            }
            return Math.max(0, i2);
        }
        return invokeL.intValue;
    }

    public static int getScreenWidthPx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    private int updateReboundByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, this, kSCoordinatorLayout, kSAppBarLayout, i2, i3)) == null) {
            if (kSAppBarLayout.getHeight() < this.mPreHeadHeight || i2 != 1) {
                updateReboundOffsetByScroll(kSCoordinatorLayout, kSAppBarLayout, this.mOffsetRebound + (i3 / 3));
                return getTopBottomOffsetForScrollingSibling() - i3;
            }
            return i3;
        }
        return invokeLLII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReboundHeaderHeight(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65545, this, kSCoordinatorLayout, kSAppBarLayout, i2, i3) == null) || kSAppBarLayout.getHeight() < this.mPreHeadHeight || i2 < 0 || i2 > (i4 = this.mReboundMaxOffset)) {
            return;
        }
        this.mOffsetRebound = i2;
        List<CustomReboundOffsetCallback> list = this.mCustomReboundOffsetCallbacks;
        if (list != null && this.mEnableRebound) {
            float f2 = (i2 * 1.0f) / i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mCustomReboundOffsetCallbacks.get(size).rebound(i3, f2, this.mOffsetRebound);
            }
        }
        View view = this.mReboundView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.mReboundViewOriginHeight + i2;
            int i5 = layoutParams.width;
            int i6 = this.mReboundViewOriginWidth;
            if (i5 != i6) {
                layoutParams.width = i6;
            }
            this.mReboundView.setLayoutParams(layoutParams);
        }
        kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
    }

    private void updateReboundOffsetByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, this, kSCoordinatorLayout, kSAppBarLayout, i2) == null) {
            ValueAnimator valueAnimator = this.mReboundRecoverAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mReboundRecoverAnimator.cancel();
            }
            updateReboundHeaderHeight(kSCoordinatorLayout, kSAppBarLayout, i2, 1);
        }
    }

    public void addReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, customReboundOffsetCallback) == null) {
            if (this.mCustomReboundOffsetCallbacks == null) {
                this.mCustomReboundOffsetCallbacks = new ArrayList();
            }
            this.mCustomReboundOffsetCallbacks.add(customReboundOffsetCallback);
        }
    }

    public void clearReboundOffsetCallback() {
        List<CustomReboundOffsetCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.mCustomReboundOffsetCallbacks) == null) {
            return;
        }
        list.clear();
    }

    public int getOffsetDelta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOffsetDelta : invokeV.intValue;
    }

    public int getOffsetRebound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOffsetRebound : invokeV.intValue;
    }

    public int getReboundMaxOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mReboundMaxOffset : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getTopAndBottomOffset() + this.mOffsetDelta : invokeV.intValue;
    }

    public boolean isEnableRebound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEnableRebound : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kSCoordinatorLayout, kSAppBarLayout) == null) {
            super.onFlingFinished(kSCoordinatorLayout, kSAppBarLayout);
            checkShouldReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            boolean onMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, i5);
            if (this.mPreHeadHeight != kSAppBarLayout.getMeasuredHeight() && kSAppBarLayout.getMeasuredHeight() != 0) {
                this.mPreHeadHeight = getHeaderExpandedHeight(kSAppBarLayout);
            }
            if (this.mReboundView == null) {
                View findViewById = kSAppBarLayout.findViewById(this.mReboundViewId);
                if (findViewById == null) {
                    throw new NullPointerException(String.format("find rebound view with id %d is null", Integer.valueOf(this.mReboundViewId)));
                }
                this.mReboundViewOriginHeight = findViewById.getMeasuredHeight();
                this.mReboundViewOriginWidth = getScreenWidthPx(findViewById.getContext());
                this.mReboundView = findViewById;
            }
            if (this.mCoordinatorReference == null) {
                this.mCoordinatorReference = new WeakReference<>(kSCoordinatorLayout);
            }
            if (this.mAppBartReference == null) {
                this.mAppBartReference = new WeakReference<>(kSAppBarLayout);
            }
            return onMeasureChild;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (i5 < 0 && i6 == 1 && (headerTopBottomOffsetChangeListener = this.mHeaderTopBottomOffsetChangeListener) != null) {
                headerTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange());
            }
            super.onNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i2, i3, i4, i5, i6);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i2, int i3) {
        InterceptResult invokeCommon;
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            boolean onStartNestedScroll = super.onStartNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, view2, i2, i3);
            if (onStartNestedScroll && (valueAnimator = this.mReboundRecoverAnimator) != null && valueAnimator.isRunning()) {
                this.mReboundRecoverAnimator.cancel();
            }
            return onStartNestedScroll;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048592, this, kSCoordinatorLayout, kSAppBarLayout, view, i2) == null) {
            super.onStopNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i2);
            checkShouldReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
        }
    }

    public void removeReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        List<CustomReboundOffsetCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, customReboundOffsetCallback) == null) || (list = this.mCustomReboundOffsetCallbacks) == null) {
            return;
        }
        list.remove(customReboundOffsetCallback);
    }

    public void setEnableRebound(boolean z) {
        WeakReference<KSAppBarLayout> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mEnableRebound = z;
            WeakReference<KSCoordinatorLayout> weakReference2 = this.mCoordinatorReference;
            if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.mAppBartReference) == null || weakReference.get() == null) {
                return;
            }
            animateReboundRecover(this.mCoordinatorReference.get(), this.mAppBartReference.get());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, kSCoordinatorLayout, kSAppBarLayout, i2)) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, Integer.MIN_VALUE, Integer.MAX_VALUE) : invokeLLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, -1) : invokeCommon.intValue;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener = this.mHeaderTopBottomOffsetChangeListener;
            if (headerTopBottomOffsetChangeListener != null) {
                headerTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(i2, i3);
            }
            if (this.mEnableRebound) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                if (this.mOffsetRebound <= 0 || kSAppBarLayout.getHeight() < this.mPreHeadHeight) {
                    int scrollableSize = getScrollableSize();
                    int i6 = i2 - topBottomOffsetForScrollingSibling;
                    if (i6 <= 0) {
                        if (scrollableSize <= 0) {
                            return -i6;
                        }
                        int i7 = scrollableSize + i2;
                        if (i7 <= 0) {
                            setTopAndBottomOffset(-scrollableSize);
                            return i7;
                        }
                    }
                    if (i3 == 0 || topBottomOffsetForScrollingSibling < i3 || topBottomOffsetForScrollingSibling > i4) {
                        this.mOffsetDelta = 0;
                        return 0;
                    }
                    int clamp = MathUtils.clamp(i2, i3, i4);
                    if (topBottomOffsetForScrollingSibling == clamp) {
                        if (topBottomOffsetForScrollingSibling != i3) {
                            return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i5, i2);
                        }
                        return 0;
                    }
                    int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    this.mOffsetDelta = clamp - interpolateOffset;
                    int i8 = topBottomOffsetForScrollingSibling - clamp;
                    if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                        kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                    }
                    kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    return i8;
                }
                return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i5, i2);
            }
            return super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, i5);
        }
        return invokeCommon.intValue;
    }

    public void setHeaderTopBottomOffsetChangeListener(HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, headerTopBottomOffsetChangeListener) == null) {
            this.mHeaderTopBottomOffsetChangeListener = headerTopBottomOffsetChangeListener;
        }
    }
}
