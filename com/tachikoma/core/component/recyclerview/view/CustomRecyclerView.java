package com.tachikoma.core.component.recyclerview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.library.widget.refresh.d;
/* loaded from: classes2.dex */
public class CustomRecyclerView extends RecyclerView implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanPullToRefresh;
    public boolean mDisableScroll;
    public int mDistanceToScreenTop;
    public boolean mDistanceToScreenTopUseCache;
    public boolean mDownStop;
    public int mDownX;
    public int mDownY;
    @FixScrollDirection
    public int mFixScrollDirection;
    public TouchEventInterceptor mIgnoreTouchSwipeHandler;
    public int mMaxHeight;
    public int mTouchSlop;
    public int mUnderneathColor;
    public Rect mUnderneathRect;
    public boolean mUseCustomScrollToPosition;

    /* loaded from: classes2.dex */
    public @interface FixScrollDirection {
        public static final int HORIZONTAL = 1;
        public static final int NONE = 0;
        public static final int VERTICAL = 2;
    }

    /* loaded from: classes2.dex */
    public interface TouchEventInterceptor {
        boolean shouldInterceptTouchEvent(MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomRecyclerView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDistanceToScreenTop = Integer.MIN_VALUE;
        this.mDistanceToScreenTopUseCache = true;
        this.mCanPullToRefresh = true;
        this.mFixScrollDirection = 0;
        this.mDownStop = false;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void computeUnderneathRect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Rect rect = this.mUnderneathRect;
            if (rect == null) {
                this.mUnderneathRect = new Rect();
            } else {
                rect.setEmpty();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    this.mUnderneathRect.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                }
            }
        }
    }

    private boolean fixInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mDownX = (int) motionEvent.getX();
                this.mDownY = (int) motionEvent.getY();
                return false;
            } else if (actionMasked != 2) {
                return false;
            } else {
                int abs = (int) Math.abs(motionEvent.getX() - this.mDownX);
                int abs2 = (int) Math.abs(motionEvent.getY() - this.mDownY);
                int i2 = this.mTouchSlop;
                if (abs <= i2 || abs2 <= i2) {
                    return false;
                }
                if (this.mFixScrollDirection != 1 || abs <= abs2) {
                    return this.mFixScrollDirection == 2 && abs < abs2;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private void startScroll(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIII(65541, this, i2, i3, i4) != null) {
            return;
        }
        RecyclerViewPositionHelper createHelper = RecyclerViewPositionHelper.createHelper(this);
        while (true) {
            int findFirstVisibleItemPosition = createHelper.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = createHelper.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (this.mDistanceToScreenTop == Integer.MIN_VALUE || !this.mDistanceToScreenTopUseCache) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.mDistanceToScreenTop = iArr[1];
            }
            if (i2 >= findFirstVisibleItemPosition && i2 <= findLastVisibleItemPosition) {
                int i5 = i2 - findFirstVisibleItemPosition;
                if (getChildCount() > i5) {
                    int[] iArr2 = new int[2];
                    getChildAt(i5).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.mDistanceToScreenTop) - i4);
                    return;
                }
                return;
            } else if (i2 > findLastVisibleItemPosition) {
                scrollBy(0, i3);
            } else {
                scrollBy(0, -i3);
            }
        }
    }

    public void afterDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.kwai.library.widget.refresh.d
    public boolean canPullToRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCanPullToRefresh : invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            afterDetachedFromWindow();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.mUnderneathColor != 0) {
                computeUnderneathRect();
                Rect rect = this.mUnderneathRect;
                if (rect != null && !rect.isEmpty()) {
                    canvas.save();
                    canvas.clipRect(this.mUnderneathRect);
                    canvas.drawColor(this.mUnderneathColor);
                    canvas.restore();
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.mDisableScroll) {
                return false;
            }
            if (motionEvent.getAction() == 0 && this.mDownStop) {
                stopScroll();
            }
            TouchEventInterceptor touchEventInterceptor = this.mIgnoreTouchSwipeHandler;
            if ((touchEventInterceptor == null || !touchEventInterceptor.shouldInterceptTouchEvent(motionEvent)) && !fixInterceptTouchEvent(motionEvent)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            int i4 = this.mMaxHeight;
            if (i4 > 0 && i4 < size) {
                i3 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, View.MeasureSpec.getMode(i3));
            }
            super.onMeasure(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.mDisableScroll) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.mUseCustomScrollToPosition) {
                startScroll(i2, (getHeight() * 2) / 3, 0);
            } else {
                super.scrollToPosition(i2);
            }
        }
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            startScroll(i2, getHeight(), i3);
        }
    }

    public void setCanPullToRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mCanPullToRefresh = z;
        }
    }

    public void setDisableScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mDisableScroll = z;
        }
    }

    public void setDistanceToScreenTopUseCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mDistanceToScreenTopUseCache = z;
        }
    }

    public void setDownStop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mDownStop = z;
        }
    }

    public void setFixScrollConflictDirection(@FixScrollDirection int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mFixScrollDirection = i2;
        }
    }

    public void setIgnoreTouchSwipeHandler(TouchEventInterceptor touchEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, touchEventInterceptor) == null) {
            this.mIgnoreTouchSwipeHandler = touchEventInterceptor;
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mMaxHeight = i2;
        }
    }

    public void setUnderneathColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mUnderneathColor = i2;
            computeUnderneathRect();
            invalidate();
        }
    }

    public void setUseCustomScrollToPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mUseCustomScrollToPosition = z;
        }
    }
}
