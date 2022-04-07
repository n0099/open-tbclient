package com.tachikoma.core.component.listview.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
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
/* loaded from: classes8.dex */
public class RecyclerViewPager extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int mCurrentItem;
    public List<OnPageChangeListener> mPageListeners;
    public int mPrevItem;
    public ScrollEventAdapter mScrollEventAdapter;
    public PagerSnapHelper mSnapHelper;

    /* loaded from: classes8.dex */
    public static abstract class OnPageChangeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnPageChangeCallback() {
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

        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public void onPageScrolled(int i, float f, @Px int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, @Px int i2);

        void onPageSelected(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public static class SmoothScrollToPosition implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mPosition;
        public final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPosition = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewPager(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public boolean fling(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) ? super.fling(i, i2) : invokeII.booleanValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentItem : invokeV.intValue;
    }

    public void notifyPageScrolled(int i, float f, @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
    }

    public void notifyPageSelected(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            String str = this.TAG;
            Log.i(str, "position: " + i + " mPrevPosition: " + i2);
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageSelected(i, i2);
            }
        }
    }

    public void notifyScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            for (OnPageChangeListener onPageChangeListener : this.mPageListeners) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }
    }

    public void removeOnPageListener(OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onPageChangeListener) == null) {
            this.mPageListeners.remove(onPageChangeListener);
        }
    }

    public void setCurrent(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            setCurrentItem(i, false);
        }
    }

    public final void setCurrentItem(int i, boolean z) {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (adapter = getAdapter()) == null || adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
        if (min == this.mCurrentItem && this.mScrollEventAdapter.isIdle()) {
            return;
        }
        if (min == this.mCurrentItem && z) {
            return;
        }
        float f = this.mCurrentItem;
        this.mCurrentItem = min;
        if (!this.mScrollEventAdapter.isIdle()) {
            f = this.mScrollEventAdapter.getRelativeScrollPosition();
        }
        this.mScrollEventAdapter.notifyProgrammaticScroll(min, z);
        if (!z) {
            scrollToPosition(min);
            return;
        }
        float f2 = min;
        if (Math.abs(f2 - f) <= 3.0f) {
            smoothScrollToPosition(min);
            return;
        }
        scrollToPosition(f2 > f ? min - 3 : min + 3);
        post(new SmoothScrollToPosition(min, this));
    }

    public void setDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), i, false);
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

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageScrollStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        super.onPageScrollStateChanged(i2);
                        this.this$0.notifyScrollStateChanged(i2);
                    }
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageScrolled(int i2, float f, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)}) == null) {
                        super.onPageScrolled(i2, f, i3);
                        this.this$0.notifyPageScrolled(i2, f, i3);
                    }
                }

                @Override // com.tachikoma.core.component.listview.viewpager.RecyclerViewPager.OnPageChangeCallback
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                        super.onPageSelected(i2);
                        this.this$0.mCurrentItem = i2;
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
    public void smoothScrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.smoothScrollToPosition(i);
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
            linearSmoothScroller.setTargetPosition(i);
            getLayoutManager().startSmoothScroll(linearSmoothScroller);
        }
    }
}
