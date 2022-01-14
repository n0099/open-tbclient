package com.tachikoma.core.component.listview.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecyclerViewPager extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int mCurrentItem;
    public List<OnPageChangeListener> mPageListeners;
    public int mPrevItem;
    public ScrollEventAdapter mScrollEventAdapter;
    public PagerSnapHelper mSnapHelper;

    /* loaded from: classes4.dex */
    public static abstract class OnPageChangeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnPageChangeCallback() {
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

        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        public void onPageScrolled(int i2, float f2, @Px int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageScrolled(int i2, float f2, @Px int i3);

        void onPageSelected(int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public static class SmoothScrollToPosition implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mPosition;
        public final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPosition = i2;
            this.mRecyclerView = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mRecyclerView.smoothScrollToPosition(this.mPosition);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerViewPager(Context context) {
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
    public RecyclerViewPager(Context context, @Nullable AttributeSet attributeSet) {
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
    public RecyclerViewPager(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.TAG = RecyclerViewPager.class.getSimpleName();
        this.mPageListeners = new ArrayList();
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.mSnapHelper = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this);
    }

    public void addOnPageListener(OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onPageChangeListener) == null) {
            this.mPageListeners.add(onPageChangeListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? super.fling(i2, i3) : invokeII.booleanValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentItem : invokeV.intValue;
    }

    public void notifyPageScrolled(int i2, float f2, @Px int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }
    }

    public void notifyPageSelected(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            String str = "position: " + i2 + " mPrevPosition: " + i3;
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageSelected(i2, i3);
            }
        }
    }

    public void notifyScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }
    }

    public void removeOnPageListener(OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onPageChangeListener) == null) {
            this.mPageListeners.remove(onPageChangeListener);
        }
    }

    public void setCurrent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            setCurrentItem(i2, false);
        }
    }

    public final void setCurrentItem(int i2, boolean z) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (adapter = getAdapter()) == null || adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (min == this.mCurrentItem && this.mScrollEventAdapter.isIdle()) {
            return;
        }
        if (min == this.mCurrentItem && z) {
            return;
        }
        float f2 = this.mCurrentItem;
        this.mCurrentItem = min;
        if (!this.mScrollEventAdapter.isIdle()) {
            f2 = this.mScrollEventAdapter.getRelativeScrollPosition();
        }
        this.mScrollEventAdapter.notifyProgrammaticScroll(min, z);
        if (!z) {
            scrollToPosition(min);
            return;
        }
        float f3 = min;
        if (Math.abs(f3 - f2) <= 3.0f) {
            smoothScrollToPosition(min);
            return;
        }
        scrollToPosition(f3 > f2 ? min - 3 : min + 3);
        post(new SmoothScrollToPosition(min, this));
    }

    public void setDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), i2, false);
            super.setLayoutManager(linearLayoutManager);
            ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(linearLayoutManager);
            this.mScrollEventAdapter = scrollEventAdapter;
            addOnScrollListener(scrollEventAdapter);
            this.mScrollEventAdapter.setOnPageChangeCallback(new OnPageChangeCallback(this) { // from class: com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerViewPager this$0;

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

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageScrollStateChanged(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                        super.onPageScrollStateChanged(i3);
                        this.this$0.notifyScrollStateChanged(i3);
                    }
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageScrolled(int i3, float f2, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)}) == null) {
                        super.onPageScrolled(i3, f2, i4);
                        this.this$0.notifyPageScrolled(i3, f2, i4);
                    }
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageSelected(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                        super.onPageSelected(i3);
                        this.this$0.mCurrentItem = i3;
                        RecyclerViewPager recyclerViewPager = this.this$0;
                        recyclerViewPager.notifyPageSelected(recyclerViewPager.mCurrentItem, this.this$0.mPrevItem);
                        RecyclerViewPager recyclerViewPager2 = this.this$0;
                        recyclerViewPager2.mPrevItem = recyclerViewPager2.mCurrentItem;
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Deprecated
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutManager) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.smoothScrollToPosition(i2);
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, getContext()) { // from class: com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyclerViewPager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((Context) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, displayMetrics)) == null) ? super.calculateSpeedPerPixel(displayMetrics) * 3.0f : invokeL.floatValue;
                }
            };
            linearSmoothScroller.setTargetPosition(i2);
            getLayoutManager().startSmoothScroll(linearSmoothScroller);
        }
    }
}
