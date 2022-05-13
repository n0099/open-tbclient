package com.tachikoma.core.component.listview.viewpager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.listview.viewpager.RecyclerViewPager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_POSITION = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    public static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    public static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    public static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int mAdapterState;
    public RecyclerViewPager.OnPageChangeCallback mCallback;
    public boolean mDispatchSelected;
    public int mDragStartPosition;
    @NonNull
    public final LinearLayoutManager mLayoutManager;
    public boolean mScrollHappened;
    public int mScrollState;
    public ScrollEventValues mScrollValues;
    public int mTarget;

    /* loaded from: classes7.dex */
    public @interface Orientation {
    }

    /* loaded from: classes7.dex */
    public static final class ScrollEventValues {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mOffset;
        public int mOffsetPx;
        public int mPosition;

        public ScrollEventValues() {
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

        public ScrollEventValues reset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.mPosition = -1;
                this.mOffset = 0.0f;
                this.mOffsetPx = 0;
                return this;
            }
            return (ScrollEventValues) invokeV.objValue;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface ScrollState {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668400740, "Lcom/tachikoma/core/component/listview/viewpager/ScrollEventAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668400740, "Lcom/tachikoma/core/component/listview/viewpager/ScrollEventAdapter;");
                return;
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public ScrollEventAdapter(@NonNull LinearLayoutManager linearLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.TAG = ScrollEventAdapter.class.getSimpleName();
        this.mLayoutManager = linearLayoutManager;
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i, float f, int i2) {
        RecyclerViewPager.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || (onPageChangeCallback = this.mCallback) == null) {
            return;
        }
        onPageChangeCallback.onPageScrolled(i, f, i2);
    }

    private void dispatchSelected(int i) {
        RecyclerViewPager.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i) == null) || (onPageChangeCallback = this.mCallback) == null) {
            return;
        }
        onPageChangeCallback.onPageSelected(i);
    }

    private void dispatchStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i) {
                return;
            }
            this.mScrollState = i;
            RecyclerViewPager.OnPageChangeCallback onPageChangeCallback = this.mCallback;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        }
    }

    private int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.mLayoutManager.findFirstVisibleItemPosition() : invokeV.intValue;
    }

    private boolean isLayoutRTL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.mLayoutManager.getLayoutDirection() == 1 : invokeV.booleanValue;
    }

    private void resetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mAdapterState = 0;
            this.mScrollState = 0;
            this.mScrollValues.reset();
            this.mDragStartPosition = -1;
            this.mTarget = -1;
            this.mDispatchSelected = false;
            this.mScrollHappened = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ScrollEventValues updateScrollEventValues() {
        InterceptResult invokeV;
        View findViewByPosition;
        int height;
        int top;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ScrollEventValues scrollEventValues = this.mScrollValues;
            int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
            scrollEventValues.mPosition = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition != -1 && (findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition)) != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = findViewByPosition.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) findViewByPosition.getLayoutParams() : ZERO_MARGIN_LAYOUT_PARAMS;
                if (this.mLayoutManager.getOrientation() == 0) {
                    height = findViewByPosition.getWidth();
                    if (isLayoutRTL()) {
                        i2 = (height - findViewByPosition.getRight()) + marginLayoutParams.rightMargin;
                        i3 = -i2;
                        scrollEventValues.mOffsetPx = i3;
                        if (i3 < 0) {
                            scrollEventValues.mOffset = height == 0 ? 0.0f : i3 / height;
                            return scrollEventValues;
                        }
                        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.mOffsetPx)));
                    }
                    top = findViewByPosition.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    height = findViewByPosition.getHeight();
                    top = findViewByPosition.getTop();
                    i = marginLayoutParams.topMargin;
                }
                i2 = top - i;
                i3 = -i2;
                scrollEventValues.mOffsetPx = i3;
                if (i3 < 0) {
                }
            }
            return scrollEventValues.reset();
        }
        return (ScrollEventValues) invokeV.objValue;
    }

    public float getRelativeScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            updateScrollEventValues();
            ScrollEventValues scrollEventValues = this.mScrollValues;
            return scrollEventValues.mPosition + scrollEventValues.mOffset;
        }
        return invokeV.floatValue;
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdapterState == 0 : invokeV.booleanValue;
    }

    public void notifyProgrammaticScroll(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mAdapterState = z ? 2 : 3;
            boolean z2 = this.mTarget != i;
            this.mTarget = i;
            dispatchStateChanged(2);
            if (z2) {
                dispatchSelected(i);
            }
        }
    }

    public void notifyRestoreCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i == 0) {
            return;
        }
        dispatchSelected(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, recyclerView, i) == null) {
            if (this.mAdapterState != 1 && i == 1) {
                this.mAdapterState = 1;
                int i2 = this.mTarget;
                if (i2 != -1) {
                    this.mDragStartPosition = i2;
                    this.mTarget = -1;
                } else {
                    this.mDragStartPosition = getPosition();
                }
                dispatchStateChanged(1);
            } else if (this.mAdapterState == 1 && i == 2) {
                if (!this.mScrollHappened) {
                    dispatchScrolled(getPosition(), 0.0f, 0);
                    return;
                }
                dispatchStateChanged(2);
                this.mDispatchSelected = true;
                this.mScrollHappened = false;
            } else if (this.mAdapterState == 1 && i == 0) {
                if (this.mScrollState == 1 && this.mScrollValues.mOffsetPx == 0) {
                    if (this.mScrollHappened) {
                        this.mDispatchSelected = true;
                        this.mScrollHappened = false;
                    } else {
                        dispatchScrolled(getPosition(), 0.0f, 0);
                    }
                } else if (this.mScrollState == 2 && !this.mScrollHappened) {
                    Log.e(this.TAG, "RecyclerView sent SCROLL_STATE_SETTLING event without scrolling any further before going to SCROLL_STATE_IDLE");
                }
                if (this.mScrollHappened) {
                    return;
                }
                if (this.mDispatchSelected) {
                    updateScrollEventValues();
                    int i3 = this.mDragStartPosition;
                    int i4 = this.mScrollValues.mPosition;
                    if (i3 != i4) {
                        dispatchSelected(i4);
                    }
                }
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if ((r6 < 0) == isLayoutRTL()) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, recyclerView, i, i2) == null) {
            this.mScrollHappened = true;
            ScrollEventValues updateScrollEventValues = updateScrollEventValues();
            if (this.mDispatchSelected) {
                this.mDispatchSelected = false;
                if (i2 <= 0) {
                    if (i2 == 0) {
                    }
                    z = false;
                    i3 = (z || updateScrollEventValues.mOffsetPx == 0) ? updateScrollEventValues.mPosition : updateScrollEventValues.mPosition + 1;
                    this.mTarget = i3;
                    if (this.mDragStartPosition != i3) {
                        dispatchSelected(i3);
                    }
                }
                z = true;
                if (z) {
                }
                this.mTarget = i3;
                if (this.mDragStartPosition != i3) {
                }
            }
            dispatchScrolled(updateScrollEventValues.mPosition, updateScrollEventValues.mOffset, updateScrollEventValues.mOffsetPx);
            int i4 = updateScrollEventValues.mPosition;
            int i5 = this.mTarget;
            if ((i4 == i5 || i5 == -1) && updateScrollEventValues.mOffsetPx == 0 && this.mScrollState != 1) {
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    public void setOnPageChangeCallback(RecyclerViewPager.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onPageChangeCallback) == null) {
            this.mCallback = onPageChangeCallback;
        }
    }
}
