package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mz5;
import com.baidu.tieba.yvb;
import com.baidu.tieba.zvb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class PLA_ListView extends PLA_AbsListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float MAX_SCROLL_FACTOR = 0.33f;
    public static final int NO_POSITION = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAreAllItemsSelectable;
    public boolean mClipDivider;
    public Paint mContentPaint;
    public Drawable mDivider;
    public int mDividerHeight;
    public boolean mDividerIsOpaque;
    public Paint mDividerPaint;
    public boolean mFooterDividersEnabled;
    public ArrayList<a> mFooterViewInfos;
    public boolean mHeaderDividersEnabled;
    public ArrayList<a> mHeaderViewInfos;
    public boolean mIsCacheColorOpaque;
    public boolean mItemsCanFocus;
    public Drawable mOverScrollFooter;
    public Drawable mOverScrollHeader;
    public final Rect mTempRect;

    public void clearChoices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public long[] getCheckedItemIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new long[0] : (long[]) invokeV.objValue;
    }

    public int getCheckedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (SparseBooleanArray) invokeV.objValue;
    }

    public boolean isItemChecked(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public void onItemAddedToList(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @ViewDebug.ExportedProperty(category = "list")
    public boolean recycleOnMeasure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setItemChecked(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public Object b;
        public boolean c;
        public final /* synthetic */ PLA_ListView d;

        public a(PLA_ListView pLA_ListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_ListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pLA_ListView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PLA_ListView(Context context) {
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

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int findMotionRow(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                if (!this.mStackFromBottom) {
                    for (int i2 = 0; i2 < childCount; i2++) {
                        if (i <= getChildAt(i2).getBottom()) {
                            return this.mFirstPosition + i2;
                        }
                    }
                    return -1;
                }
                for (int i3 = childCount - 1; i3 >= 0; i3--) {
                    if (i >= getChildAt(i3).getTop()) {
                        return this.mFirstPosition + i3;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public boolean fullScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            boolean z = false;
            if (i == 33) {
                if (lookForSelectablePosition(0, true) >= 0) {
                    this.mLayoutMode = 1;
                    invokeOnItemScrollListener();
                    z = true;
                }
                if (z && !awakenScrollBars()) {
                    awakenScrollBars();
                    invalidate();
                }
                return z;
            }
            if (i == 130) {
                if (lookForSelectablePosition(this.mItemCount - 1, true) >= 0) {
                    this.mLayoutMode = 3;
                    invokeOnItemScrollListener();
                }
                z = true;
            }
            if (z) {
                awakenScrollBars();
                invalidate();
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public boolean isFixedView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, view2)) == null) {
            ArrayList<a> arrayList = this.mHeaderViewInfos;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).a == view2) {
                    return true;
                }
            }
            ArrayList<a> arrayList2 = this.mFooterViewInfos;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (arrayList2.get(i2).a == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, drawable) == null) {
            boolean z = false;
            if (drawable != null) {
                this.mDividerHeight = drawable.getIntrinsicHeight();
                this.mClipDivider = drawable instanceof ColorDrawable;
            } else {
                this.mDividerHeight = 0;
                this.mClipDivider = false;
            }
            this.mDivider = drawable;
            this.mDividerIsOpaque = (drawable == null || drawable.getOpacity() == -1) ? true : true;
            requestLayoutIfNecessary();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PLA_ListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
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

    private View addViewAbove(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, view2, i)) == null) {
            int i2 = i - 1;
            yvb.c("addViewAbove:" + i);
            View obtainView = obtainView(i2, this.mIsScrap);
            setupChild(obtainView, i2, view2.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private View addViewBelow(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, i)) == null) {
            int i2 = i + 1;
            yvb.c("addViewBelow:" + i);
            View obtainView = obtainView(i2, this.mIsScrap);
            setupChild(obtainView, i2, view2.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private View fillDown(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, this, i, i2)) == null) {
            yvb.c("fill down: " + i);
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            while (i2 < bottom && i < this.mItemCount) {
                makeAndAddView(i, getItemTop(i), true, false);
                i++;
                i2 = getFillChildBottom() + this.mDividerHeight;
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_ListView(Context context, AttributeSet attributeSet, int i) {
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
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mContentPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mz5.ListView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(4);
        if (drawable != null) {
            setOverscrollHeader(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        if (drawable2 != null) {
            setOverscrollFooter(drawable2);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(2, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(1, true);
        if (obtainStyledAttributes.hasValue(5)) {
            int color = obtainStyledAttributes.getColor(5, 0);
            Paint paint = new Paint();
            this.mContentPaint = paint;
            paint.setColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048631, this, view2, rect, z)) == null) {
            int i4 = rect.top;
            rect.offset(view2.getLeft(), view2.getTop());
            rect.offset(-view2.getScrollX(), -view2.getScrollY());
            int height = getHeight();
            int scrollY = getScrollY();
            int i5 = scrollY + height;
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (showingTopFadingEdge() && i4 > verticalFadingEdgeLength) {
                scrollY += verticalFadingEdgeLength;
            }
            boolean z2 = true;
            int bottom = getChildAt(getChildCount() - 1).getBottom();
            if (showingBottomFadingEdge() && rect.bottom < bottom - verticalFadingEdgeLength) {
                i5 -= verticalFadingEdgeLength;
            }
            if (rect.bottom > i5 && rect.top > scrollY) {
                if (rect.height() > height) {
                    i3 = rect.top - scrollY;
                } else {
                    i3 = rect.bottom - i5;
                }
                i = Math.min(i3 + 0, bottom - i5);
            } else if (rect.top < scrollY && rect.bottom < i5) {
                if (rect.height() > height) {
                    i2 = 0 - (i5 - rect.bottom);
                } else {
                    i2 = 0 - (scrollY - rect.top);
                }
                i = Math.max(i2, getChildAt(0).getTop() - scrollY);
            } else {
                i = 0;
            }
            if (i == 0) {
                z2 = false;
            }
            if (z2) {
                scrollListItemsBy(-i);
                positionSelector(view2);
                this.mSelectedTop = view2.getTop();
                invalidate();
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
    }

    private void adjustViewsUpOrDown() {
        int childCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (childCount = getChildCount()) > 0) {
            int i = 0;
            if (!this.mStackFromBottom) {
                int scrollChildTop = getScrollChildTop() - this.mListPadding.top;
                if (this.mFirstPosition != 0) {
                    scrollChildTop -= this.mDividerHeight;
                }
                if (scrollChildTop >= 0) {
                    i = scrollChildTop;
                }
            } else {
                int scrollChildBottom = getScrollChildBottom() - (getHeight() - this.mListPadding.bottom);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    scrollChildBottom += this.mDividerHeight;
                }
                if (scrollChildBottom <= 0) {
                    i = scrollChildBottom;
                }
            }
            if (i != 0) {
                tryOffsetChildrenTopAndBottom(-i);
            }
        }
    }

    private void clearRecycledState(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, arrayList) == null) && arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) arrayList.get(i).a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.c = false;
                }
            }
        }
    }

    private View fillFromTop(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            int min = Math.min(this.mFirstPosition, -1);
            this.mFirstPosition = min;
            int min2 = Math.min(min, this.mItemCount - 1);
            this.mFirstPosition = min2;
            if (min2 < 0) {
                this.mFirstPosition = 0;
            }
            return fillDown(this.mFirstPosition, i);
        }
        return (View) invokeI.objValue;
    }

    private boolean isHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view2)) == null) {
            Iterator<a> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                if (it.next().a == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            addFooterView(view2, null, true);
        }
    }

    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            addHeaderView(view2, null, true);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void fillGap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            int childCount = getChildCount();
            if (z) {
                fillDown(this.mFirstPosition + childCount, getFillChildBottom() + this.mDividerHeight);
            } else {
                fillUp(this.mFirstPosition - 1, getFillChildTop());
            }
            onAdjustChildViews(z);
        }
    }

    public int getItemBottom(int i) {
        InterceptResult invokeI;
        int height;
        int listPaddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            if (getChildCount() > 0) {
                height = getChildAt(0).getTop();
                listPaddingBottom = this.mDividerHeight;
            } else {
                height = getHeight();
                listPaddingBottom = getListPaddingBottom();
            }
            return height - listPaddingBottom;
        }
        return invokeI.intValue;
    }

    public int getItemLeft(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            return this.mListPadding.left;
        }
        return invokeI.intValue;
    }

    public int getItemTop(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                return getChildAt(childCount - 1).getBottom() + this.mDividerHeight;
            }
            return getListPaddingTop();
        }
        return invokeI.intValue;
    }

    public void onAdjustChildViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            if (z) {
                correctTooHigh(getChildCount());
            } else {
                correctTooLow(getChildCount());
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, motionEvent)) == null) {
            if (this.mItemsCanFocus && motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, view2)) == null) {
            boolean z = false;
            if (this.mFooterViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((zvb) listAdapter).d(view2)) {
                    this.mDataSetObserver.onChanged();
                    z = true;
                }
                removeFixedViewInfo(view2, this.mFooterViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, view2)) == null) {
            boolean z = false;
            if (this.mHeaderViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((zvb) listAdapter).e(view2)) {
                    this.mDataSetObserver.onChanged();
                    z = true;
                }
                removeFixedViewInfo(view2, this.mHeaderViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setCacheColorHint(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            if ((i >>> 24) == 255) {
                z = true;
            } else {
                z = false;
            }
            this.mIsCacheColorOpaque = z;
            if (z) {
                if (this.mDividerPaint == null) {
                    this.mDividerPaint = new Paint();
                }
                this.mDividerPaint.setColor(i);
            }
            super.setCacheColorHint(i);
        }
    }

    public void setContentBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            Paint paint = new Paint();
            this.mContentPaint = paint;
            paint.setColor(i);
        }
    }

    public void setDividerHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.mDividerHeight = i;
            requestLayoutIfNecessary();
        }
    }

    public void setFooterDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.mFooterDividersEnabled = z;
            invalidate();
        }
    }

    public void setHeaderDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.mHeaderDividersEnabled = z;
            invalidate();
        }
    }

    public void setItemsCanFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.mItemsCanFocus = z;
            if (!z) {
                setDescendantFocusability(393216);
            }
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, drawable) == null) {
            this.mOverScrollFooter = drawable;
            invalidate();
        }
    }

    public void setOverscrollHeader(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, drawable) == null) {
            this.mOverScrollHeader = drawable;
            if (getScrollY() < 0) {
                invalidate();
            }
        }
    }

    private void correctTooHigh(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, this, i) == null) && (this.mFirstPosition + i) - 1 == this.mItemCount - 1 && i > 0) {
            int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) - getScrollChildBottom();
            int scrollChildTop = getScrollChildTop();
            if (bottom > 0) {
                if (this.mFirstPosition > 0 || scrollChildTop < this.mListPadding.top) {
                    if (this.mFirstPosition == 0) {
                        bottom = Math.min(bottom, this.mListPadding.top - scrollChildTop);
                    }
                    tryOffsetChildrenTopAndBottom(bottom);
                    if (this.mFirstPosition > 0) {
                        getScrollChildTop();
                        fillUp(this.mFirstPosition - 1, getFillChildTop());
                        adjustViewsUpOrDown();
                    }
                }
            }
        }
    }

    private void correctTooLow(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65544, this, i) == null) && this.mFirstPosition == 0 && i > 0) {
            int scrollChildTop = getScrollChildTop();
            int i2 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int i3 = scrollChildTop - i2;
            int scrollChildBottom = getScrollChildBottom();
            int i4 = (this.mFirstPosition + i) - 1;
            if (i3 > 0) {
                int i5 = this.mItemCount;
                if (i4 >= i5 - 1 && scrollChildBottom <= bottom) {
                    if (i4 == i5 - 1) {
                        adjustViewsUpOrDown();
                        return;
                    }
                    return;
                }
                if (i4 == this.mItemCount - 1) {
                    i3 = Math.min(i3, scrollChildBottom - bottom);
                }
                tryOffsetChildrenTopAndBottom(-i3);
                if (i4 < this.mItemCount - 1) {
                    fillDown(i4 + 1, getFillChildBottom() + this.mDividerHeight);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
            }
            resetList();
            this.mRecycler.d();
            if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
                this.mAdapter = listAdapter;
            } else {
                this.mAdapter = new zvb(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
            }
            this.mOldSelectedPosition = -1;
            this.mOldSelectedRowId = Long.MIN_VALUE;
            ListAdapter listAdapter3 = this.mAdapter;
            if (listAdapter3 != null) {
                this.mAreAllItemsSelectable = listAdapter3.areAllItemsEnabled();
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = this.mAdapter.getCount();
                PLA_AdapterView<ListAdapter>.c cVar = new PLA_AdapterView.c(this);
                this.mDataSetObserver = cVar;
                this.mAdapter.registerDataSetObserver(cVar);
                this.mRecycler.m(this.mAdapter.getViewTypeCount());
            } else {
                this.mAreAllItemsSelectable = true;
            }
            requestLayout();
        }
    }

    private void drawContentBackground(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, canvas) == null) && getHeaderViewsCount() > 0) {
            Rect rect = this.mTempRect;
            rect.left = getLeft();
            rect.right = getRight();
            if (isHeaderView(getChildAt(getFirstVisiblePosition()))) {
                ArrayList<a> arrayList = this.mHeaderViewInfos;
                rect.top = arrayList.get(arrayList.size() - 1).a.getBottom();
            } else {
                rect.top = 0;
            }
            rect.bottom = getBottom();
            canvas.drawRect(rect, this.mContentPaint);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, accessibilityEvent)) == null) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            if (!dispatchPopulateAccessibilityEvent) {
                int selectedItemPosition = getSelectedItemPosition();
                ListAdapter adapter = getAdapter();
                int i = 0;
                if (adapter != null) {
                    int count = adapter.getCount();
                    if (count < 15) {
                        int i2 = 0;
                        while (i < count) {
                            if (adapter.isEnabled(i)) {
                                i2++;
                            } else if (i <= selectedItemPosition) {
                                selectedItemPosition--;
                            }
                            i++;
                        }
                        i = i2;
                    } else {
                        i = count;
                    }
                }
                accessibilityEvent.setItemCount(i);
                accessibilityEvent.setCurrentItemIndex(selectedItemPosition);
            }
            return dispatchPopulateAccessibilityEvent;
        }
        return invokeL.booleanValue;
    }

    private View fillSpecific(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i, i2)) == null) {
            if (this.mDataChanged) {
                yvb.c("fill specific: " + i + ":" + i2);
            }
            View makeAndAddView = makeAndAddView(i, i2, true, false);
            this.mFirstPosition = i;
            int i3 = this.mDividerHeight;
            if (!this.mStackFromBottom) {
                fillUp(i - 1, getFillChildTop());
                adjustViewsUpOrDown();
                fillDown(i + 1, getFillChildBottom() + this.mDividerHeight);
                int childCount = getChildCount();
                if (childCount > 0) {
                    correctTooHigh(childCount);
                    return null;
                }
                return null;
            }
            fillDown(i + 1, makeAndAddView.getBottom() + i3);
            adjustViewsUpOrDown();
            fillUp(i - 1, getFillChildTop());
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooLow(childCount2);
                return null;
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && !isInTouchMode()) {
                int count = listAdapter.getCount();
                if (!this.mAreAllItemsSelectable) {
                    if (z) {
                        min = Math.max(0, i);
                        while (min < count && !listAdapter.isEnabled(min)) {
                            min++;
                        }
                    } else {
                        min = Math.min(i, count - 1);
                        while (min >= 0 && !listAdapter.isEnabled(min)) {
                            min--;
                        }
                    }
                    if (min < 0 || min >= count) {
                        return -1;
                    }
                    return min;
                } else if (i >= 0 && i < count) {
                    return i;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    private void fillSynced(int i, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, this, i, iArr) == null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                makeAndAddView(i + i2, iArr[i2], true, false);
                adjustViewsUpOrDown();
            }
            this.mFirstPosition = i;
        }
    }

    private void removeFixedViewInfo(View view2, ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, view2, arrayList) == null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).a == view2) {
                    arrayList.remove(i);
                    return;
                }
            }
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048646, this, i, i2) == null) {
            this.mLayoutMode = 4;
            this.mSpecificTop = this.mListPadding.top + i2;
            if (this.mNeedSync) {
                this.mSyncPosition = i;
                this.mSyncRowId = this.mAdapter.getItemId(i);
            }
            PLA_AbsListView.g gVar = this.mPositionScroller;
            if (gVar != null) {
                gVar.c();
            }
            requestLayout();
        }
    }

    private View fillUp(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, this, i, i2)) == null) {
            yvb.c("fill up: " + i);
            int i3 = this.mListPadding.top;
            while (i2 > i3 && i >= 0) {
                makeAndAddView(i, getItemBottom(i), false, false);
                i--;
                i2 = getItemBottom(i);
            }
            this.mFirstPosition = i + 1;
            return null;
        }
        return (View) invokeII.objValue;
    }

    private View makeAndAddView(int i, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!this.mDataChanged && (f = this.mRecycler.f(i)) != null) {
                setupChild(f, i, i2, z, getItemLeft(i), z2, true);
                return f;
            }
            onItemAddedToList(i, z);
            int itemLeft = getItemLeft(i);
            yvb.c("makeAndAddView:" + i);
            View obtainView = obtainView(i, this.mIsScrap);
            if (obtainView == null) {
                yvb.b("child is null:" + i);
            } else {
                setupChild(obtainView, i, i2, z, itemLeft, z2, this.mIsScrap[0]);
            }
            return obtainView;
        }
        return (View) invokeCommon.objValue;
    }

    private void measureScrapChild(View view2, int i, int i2) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65553, this, view2, i, i2) == null) {
            PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
                view2.setLayoutParams(layoutParams);
            }
            layoutParams.a = this.mAdapter.getItemViewType(i);
            layoutParams.d = true;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
            int i3 = ((ViewGroup.LayoutParams) layoutParams).height;
            if (i3 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i) == null) {
            tryOffsetChildrenTopAndBottom(i);
            int height = getHeight();
            Rect rect = this.mListPadding;
            int i4 = height - rect.bottom;
            int i5 = rect.top;
            PLA_AbsListView.h hVar = this.mRecycler;
            if (i < 0) {
                View lastChild = getLastChild();
                for (int childCount = getChildCount(); lastChild.getBottom() < i4 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1; childCount++) {
                    addViewBelow(lastChild, i3);
                    lastChild = getLastChild();
                }
                if (lastChild.getBottom() < i4) {
                    tryOffsetChildrenTopAndBottom(i4 - lastChild.getBottom());
                }
                View childAt = getChildAt(0);
                while (childAt.getBottom() < i5) {
                    if (hVar.n(((PLA_AbsListView.LayoutParams) childAt.getLayoutParams()).a)) {
                        detachViewFromParent(childAt);
                        hVar.c(childAt);
                    } else {
                        removeViewInLayout(childAt);
                    }
                    childAt = getChildAt(0);
                    this.mFirstPosition++;
                }
                return;
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getTop() > i5 && (i2 = this.mFirstPosition) > 0) {
                childAt2 = addViewAbove(childAt2, i2);
                this.mFirstPosition--;
            }
            if (childAt2.getTop() > i5) {
                tryOffsetChildrenTopAndBottom(i5 - childAt2.getTop());
            }
            int childCount2 = getChildCount() - 1;
            View childAt3 = getChildAt(childCount2);
            while (childAt3.getTop() > i4) {
                if (hVar.n(((PLA_AbsListView.LayoutParams) childAt3.getLayoutParams()).a)) {
                    detachViewFromParent(childAt3);
                    hVar.c(childAt3);
                } else {
                    removeViewInLayout(childAt3);
                }
                childCount2--;
                childAt3 = getChildAt(childCount2);
            }
        }
    }

    private void setupChild(View view2, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i4;
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z2 && shouldShowSelector()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 != view2.isSelected()) {
                z5 = true;
            } else {
                z5 = false;
            }
            int i5 = this.mTouchMode;
            if (i5 > 0 && i5 < 3 && this.mMotionPosition == i) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 != view2.isPressed()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z3 && !z5 && !view2.isLayoutRequested()) {
                z8 = false;
            } else {
                z8 = true;
            }
            PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view2.getLayoutParams();
            int i6 = -1;
            if (layoutParams == null) {
                layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
            }
            layoutParams.a = this.mAdapter.getItemViewType(i);
            layoutParams.b = i;
            if ((z3 && !layoutParams.d) || (layoutParams.c && layoutParams.a == -2)) {
                if (!z) {
                    i6 = 0;
                }
                attachViewToParent(view2, i6, layoutParams);
            } else {
                layoutParams.d = false;
                if (layoutParams.a == -2) {
                    layoutParams.c = true;
                }
                if (!z) {
                    i6 = 0;
                }
                addViewInLayout(view2, i6, layoutParams, true);
            }
            if (z5) {
                view2.setSelected(z4);
            }
            if (z7) {
                view2.setPressed(z6);
            }
            if (z8) {
                int i7 = this.mWidthMeasureSpec;
                Rect rect = this.mListPadding;
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
                int i8 = ((ViewGroup.LayoutParams) layoutParams).height;
                if (i8 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                onMeasureChild(view2, i, childMeasureSpec, makeMeasureSpec);
            } else {
                cleanupLayoutState(view2);
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            if (z) {
                i4 = i2;
            } else {
                i4 = i2 - measuredHeight;
            }
            if (z8) {
                onLayoutChild(view2, i, i3, i4, i3 + measuredWidth, i4 + measuredHeight);
            } else {
                onOffsetChild(view2, i, i3 - view2.getLeft(), i4 - view2.getTop());
            }
            if (this.mCachingStarted && !view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(true);
            }
        }
    }

    private boolean showingBottomFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int childCount = getChildCount();
            int bottom = getChildAt(childCount - 1).getBottom();
            int i = (this.mFirstPosition + childCount) - 1;
            int scrollY = (getScrollY() + getHeight()) - this.mListPadding.bottom;
            if (i < this.mItemCount - 1 || bottom < scrollY) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean showingTopFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            int scrollY = getScrollY() + this.mListPadding.top;
            if (this.mFirstPosition <= 0 && getChildAt(0).getTop() <= scrollY) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (super.canAnimate() && this.mItemCount > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && listAdapter.hasStableIds()) {
                return getCheckedItemIds();
            }
            return new long[0];
        }
        return (long[]) invokeV.objValue;
    }

    public Drawable getDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mDivider;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getDividerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mDividerHeight;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return Math.max(0, this.mFirstPosition - getHeaderViewsCount());
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mFooterViewInfos.size();
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mHeaderViewInfos.size();
        }
        return invokeV.intValue;
    }

    public boolean getItemsCanFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mItemsCanFocus;
        }
        return invokeV.booleanValue;
    }

    public View getLastChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return getChildAt(getChildCount() - 1);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return Math.min((this.mFirstPosition + getChildCount()) - 1, this.mAdapter.getCount() - 1);
        }
        return invokeV.intValue;
    }

    public int getMaxScrollAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return (int) ((getBottom() - getTop()) * 0.33f);
        }
        return invokeV.intValue;
    }

    public Drawable getOverscrollFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mOverScrollFooter;
        }
        return (Drawable) invokeV.objValue;
    }

    public Drawable getOverscrollHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mOverScrollHeader;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if ((this.mCachingStarted && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onFinishInflate();
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    addHeaderView(getChildAt(i));
                }
                removeAllViews();
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void resetList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            clearRecycledState(this.mHeaderViewInfos);
            clearRecycledState(this.mFooterViewInfos);
            super.resetList();
            this.mLayoutMode = 0;
        }
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, obj, z) == null) {
            addFooterView(view2, obj, z, -1);
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view2, obj, z) == null) {
            addHeaderView(view2, obj, z, -1);
        }
    }

    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, canvas, rect, i) == null) {
            Drawable drawable = this.mDivider;
            boolean z = this.mClipDivider;
            if (!z) {
                drawable.setBounds(rect);
            } else {
                canvas.save();
                canvas.clipRect(rect);
            }
            drawable.draw(canvas);
            if (z) {
                canvas.restore();
            }
        }
    }

    public void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, canvas, drawable, rect) == null) {
            int minimumHeight = drawable.getMinimumHeight();
            canvas.save();
            canvas.clipRect(rect);
            int i = rect.bottom;
            int i2 = rect.top;
            if (i - i2 < minimumHeight) {
                rect.bottom = i2 + minimumHeight;
            }
            drawable.setBounds(rect);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, canvas, drawable, rect) == null) {
            int minimumHeight = drawable.getMinimumHeight();
            canvas.save();
            canvas.clipRect(rect);
            int i = rect.bottom;
            if (i - rect.top < minimumHeight) {
                rect.top = i - minimumHeight;
            }
            drawable.setBounds(rect);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public boolean performItemClick(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return super.performItemClick(view2, i, j) | false;
        }
        return invokeCommon.booleanValue;
    }

    public void addFooterView(View view2, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, obj, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            a aVar = new a(this);
            aVar.a = view2;
            aVar.b = obj;
            aVar.c = z;
            if (i >= 0 && i <= this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(i, aVar);
            } else {
                this.mFooterViewInfos.add(aVar);
            }
            PLA_AdapterView<ListAdapter>.c cVar = this.mDataSetObserver;
            if (cVar != null) {
                cVar.onChanged();
            }
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, obj, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            a aVar = new a(this);
            aVar.a = view2;
            aVar.b = obj;
            aVar.c = z;
            if (i >= 0 && i <= this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(i, aVar);
            } else {
                this.mHeaderViewInfos.add(aVar);
            }
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof zvb) {
                setAdapter(((zvb) listAdapter).getWrappedAdapter());
            } else if (listAdapter != null) {
                setAdapter(listAdapter);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x01c9, code lost:
        if (r8.isEnabled(r4 + 1) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011c, code lost:
        if (r8.isEnabled(r7 + 1) == false) goto L67;
     */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ListAdapter listAdapter;
        int i2;
        int i3;
        int i4;
        Paint paint;
        ListAdapter listAdapter2;
        int i5;
        Paint paint2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            int i6 = this.mDividerHeight;
            Drawable drawable = this.mOverScrollHeader;
            Drawable drawable2 = this.mOverScrollFooter;
            if (drawable != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (drawable2 != null) {
                z = true;
            } else {
                z = false;
            }
            if (i6 > 0 && this.mDivider != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            drawContentBackground(canvas);
            if (z2 || i != 0 || z) {
                Rect rect = this.mTempRect;
                rect.left = getPaddingLeft();
                rect.right = (getRight() - getLeft()) - getPaddingRight();
                int childCount = getChildCount();
                int size = this.mHeaderViewInfos.size();
                int i7 = this.mItemCount;
                int size2 = (i7 - this.mFooterViewInfos.size()) - 1;
                boolean z5 = this.mHeaderDividersEnabled;
                boolean z6 = this.mFooterDividersEnabled;
                int i8 = this.mFirstPosition;
                boolean z7 = this.mAreAllItemsSelectable;
                ListAdapter listAdapter3 = this.mAdapter;
                if (z2 && isOpaque() && !super.isOpaque()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    listAdapter = listAdapter3;
                    if (this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                        Paint paint3 = new Paint();
                        this.mDividerPaint = paint3;
                        z4 = z7;
                        paint3.setColor(getCacheColorHint());
                    } else {
                        z4 = z7;
                    }
                } else {
                    z4 = z7;
                    listAdapter = listAdapter3;
                }
                Paint paint4 = this.mDividerPaint;
                Paint paint5 = paint4;
                int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) + getScrollY();
                boolean z8 = z;
                if (!this.mStackFromBottom) {
                    int scrollY = getScrollY();
                    if (childCount > 0 && scrollY < 0) {
                        if (i != 0) {
                            rect.bottom = 0;
                            rect.top = scrollY;
                            drawOverscrollHeader(canvas, drawable, rect);
                        } else if (z2) {
                            rect.bottom = 0;
                            rect.top = -i6;
                            drawDivider(canvas, rect, -1);
                        }
                    }
                    int i9 = 0;
                    int i10 = 0;
                    while (i9 < childCount) {
                        if ((z5 || i8 + i9 >= size) && (z6 || i8 + i9 < size2)) {
                            i10 = getChildAt(i9).getBottom();
                            if (z2 && i10 < bottom && (!z8 || i9 != childCount - 1)) {
                                if (!z4) {
                                    int i11 = i8 + i9;
                                    listAdapter2 = listAdapter;
                                    if (listAdapter2.isEnabled(i11)) {
                                        i5 = bottom;
                                        if (i9 != childCount - 1) {
                                        }
                                    } else {
                                        i5 = bottom;
                                    }
                                    if (z3) {
                                        rect.top = i10;
                                        rect.bottom = i10 + i6;
                                        paint2 = paint5;
                                        canvas.drawRect(rect, paint2);
                                        i9++;
                                        paint5 = paint2;
                                        bottom = i5;
                                        listAdapter = listAdapter2;
                                    }
                                    paint2 = paint5;
                                    i9++;
                                    paint5 = paint2;
                                    bottom = i5;
                                    listAdapter = listAdapter2;
                                } else {
                                    listAdapter2 = listAdapter;
                                    i5 = bottom;
                                }
                                paint2 = paint5;
                                rect.top = i10;
                                rect.bottom = i10 + i6;
                                drawDivider(canvas, rect, i9);
                                i9++;
                                paint5 = paint2;
                                bottom = i5;
                                listAdapter = listAdapter2;
                            }
                        }
                        listAdapter2 = listAdapter;
                        i5 = bottom;
                        paint2 = paint5;
                        i9++;
                        paint5 = paint2;
                        bottom = i5;
                        listAdapter = listAdapter2;
                    }
                    int bottom2 = getBottom() + getScrollY();
                    if (z8 && i8 + childCount == i7 && bottom2 > i10) {
                        rect.top = i10;
                        rect.bottom = bottom2;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    }
                } else {
                    ListAdapter listAdapter4 = listAdapter;
                    int i12 = this.mListPadding.top;
                    int scrollY2 = getScrollY();
                    if (childCount > 0 && i != 0) {
                        rect.top = scrollY2;
                        i2 = i;
                        rect.bottom = getChildAt(0).getTop();
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else {
                        i2 = i;
                    }
                    int i13 = i2;
                    while (i13 < childCount) {
                        if ((z5 || i8 + i13 >= size) && (z6 || i8 + i13 < size2)) {
                            int top = getChildAt(i13).getTop();
                            if (z2 && top > i12) {
                                i3 = i12;
                                if (!z4) {
                                    int i14 = i8 + i13;
                                    if (listAdapter4.isEnabled(i14)) {
                                        i4 = i8;
                                        if (i13 != childCount - 1) {
                                        }
                                    } else {
                                        i4 = i8;
                                    }
                                    if (z3) {
                                        rect.top = top - i6;
                                        rect.bottom = top;
                                        paint = paint5;
                                        canvas.drawRect(rect, paint);
                                        i13++;
                                        paint5 = paint;
                                        i12 = i3;
                                        i8 = i4;
                                    }
                                    paint = paint5;
                                    i13++;
                                    paint5 = paint;
                                    i12 = i3;
                                    i8 = i4;
                                } else {
                                    i4 = i8;
                                }
                                paint = paint5;
                                rect.top = top - i6;
                                rect.bottom = top;
                                drawDivider(canvas, rect, i13 - 1);
                                i13++;
                                paint5 = paint;
                                i12 = i3;
                                i8 = i4;
                            }
                        }
                        i3 = i12;
                        i4 = i8;
                        paint = paint5;
                        i13++;
                        paint5 = paint;
                        i12 = i3;
                        i8 = i4;
                    }
                    if (childCount > 0 && scrollY2 > 0) {
                        if (z8) {
                            int bottom3 = getBottom();
                            rect.top = bottom3;
                            rect.bottom = bottom3 + scrollY2;
                            drawOverscrollFooter(canvas, drawable2, rect);
                        } else if (z2) {
                            rect.top = bottom;
                            rect.bottom = bottom + i6;
                            drawDivider(canvas, rect, -1);
                        }
                    }
                }
            }
            super.dispatchDraw(canvas);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mAdapter;
        }
        return (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IPUT] complete} */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void layoutChildren() {
        boolean z;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && !(z = this.mBlockLayoutRequests)) {
            this.mBlockLayoutRequests = true;
            try {
                invalidate();
                if (this.mAdapter == null) {
                    resetList();
                    invokeOnItemScrollListener();
                    if (!z) {
                        return;
                    }
                    return;
                }
                int fillChildBottom = getFillChildBottom() + this.mDividerHeight;
                int fillChildTop = getFillChildTop();
                int childCount = getChildCount();
                int i = this.mLayoutMode;
                if (i != 1 && i != 3 && i != 4 && i != 5) {
                    view2 = getChildAt(0);
                } else {
                    view2 = null;
                }
                boolean z2 = this.mDataChanged;
                if (z2) {
                    handleDataChanged();
                }
                if (this.mItemCount == 0) {
                    resetList();
                    invokeOnItemScrollListener();
                    if (!z) {
                        this.mBlockLayoutRequests = false;
                    }
                } else if (this.mItemCount == this.mAdapter.getCount()) {
                    int i2 = this.mFirstPosition;
                    PLA_AbsListView.h hVar = this.mRecycler;
                    if (z2) {
                        for (int i3 = childCount - 1; i3 >= 0; i3--) {
                            hVar.c(getChildAt(i3));
                        }
                    } else {
                        hVar.e(childCount, i2);
                    }
                    int i4 = this.mLayoutMode;
                    if (i4 != 1) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    if (childCount == 0) {
                                        detachAllViewsFromParent();
                                        if (!this.mStackFromBottom) {
                                            fillFromTop(fillChildBottom);
                                        } else {
                                            fillUp(this.mItemCount - 1, fillChildTop);
                                        }
                                    } else if (this.mFirstPosition < this.mItemCount) {
                                        onLayoutSync(this.mFirstPosition);
                                        detachAllViewsFromParent();
                                        int i5 = this.mFirstPosition;
                                        if (view2 != null) {
                                            fillChildBottom = view2.getTop();
                                        }
                                        fillSpecific(i5, fillChildBottom);
                                        onLayoutSyncFinished(this.mFirstPosition);
                                    } else {
                                        onLayoutSync(0);
                                        detachAllViewsFromParent();
                                        fillSpecific(0, fillChildBottom);
                                        onLayoutSyncFinished(0);
                                    }
                                } else {
                                    onLayoutSync(this.mSyncPosition);
                                    detachAllViewsFromParent();
                                    if (this.mSpecificTops != null) {
                                        fillSynced(this.mSyncPosition, this.mSpecificTops);
                                        this.mSpecificTops = null;
                                    } else {
                                        fillSpecific(this.mSyncPosition, this.mSpecificTop);
                                    }
                                    onLayoutSyncFinished(this.mSyncPosition);
                                }
                            } else {
                                detachAllViewsFromParent();
                                fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
                            }
                        } else {
                            detachAllViewsFromParent();
                            fillUp(this.mItemCount - 1, fillChildTop);
                            adjustViewsUpOrDown();
                        }
                    } else {
                        detachAllViewsFromParent();
                        this.mFirstPosition = 0;
                        fillFromTop(fillChildBottom);
                        adjustViewsUpOrDown();
                    }
                    hVar.k();
                    if (this.mTouchMode > 0 && this.mTouchMode < 3) {
                        View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                        if (childAt != null) {
                            positionSelector(childAt);
                        }
                    } else {
                        this.mSelectedTop = 0;
                        this.mSelectorRect.setEmpty();
                    }
                    this.mLayoutMode = 0;
                    this.mDataChanged = false;
                    this.mNeedSync = false;
                    if (this.mItemCount > 0) {
                        checkSelectionChanged();
                    }
                    invokeOnItemScrollListener();
                    if (!z) {
                        this.mBlockLayoutRequests = false;
                    }
                } else {
                    throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
                }
            } finally {
                if (!z) {
                    this.mBlockLayoutRequests = false;
                }
            }
        }
    }

    public final int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                Rect rect = this.mListPadding;
                return rect.top + rect.bottom;
            }
            Rect rect2 = this.mListPadding;
            int i6 = rect2.top + rect2.bottom;
            int i7 = 0;
            int i8 = (this.mDividerHeight <= 0 || this.mDivider == null) ? 0 : 0;
            if (i3 == -1) {
                i3 = listAdapter.getCount() - 1;
            }
            PLA_AbsListView.h hVar = this.mRecycler;
            boolean recycleOnMeasure = recycleOnMeasure();
            boolean[] zArr = this.mIsScrap;
            while (i2 <= i3) {
                yvb.c("measureHeightOfChildren:" + i2);
                View obtainView = obtainView(i2, zArr);
                measureScrapChild(obtainView, i2, i);
                if (i2 > 0) {
                    i6 += i8;
                }
                if (recycleOnMeasure && hVar.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).a)) {
                    yvb.c("measureHeightOfChildren");
                    hVar.c(obtainView);
                }
                i6 += obtainView.getMeasuredHeight();
                if (i6 >= i4) {
                    if (i5 >= 0 && i2 > i5 && i7 > 0 && i6 != i4) {
                        return i7;
                    }
                    return i4;
                }
                if (i5 >= 0 && i2 >= i5) {
                    i7 = i6;
                }
                i2++;
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
            super.onFocusChanged(z, i, rect);
            int i2 = -1;
            if (z && rect != null) {
                rect.offset(getScrollX(), getScrollY());
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
                Rect rect2 = this.mTempRect;
                int i3 = Integer.MAX_VALUE;
                int childCount = getChildCount();
                int i4 = this.mFirstPosition;
                for (int i5 = 0; i5 < childCount; i5++) {
                    if (listAdapter.isEnabled(i4 + i5)) {
                        View childAt = getChildAt(i5);
                        childAt.getDrawingRect(rect2);
                        offsetDescendantRectToMyCoords(childAt, rect2);
                        int distance = PLA_AbsListView.getDistance(rect, rect2, i);
                        if (distance < i3) {
                            i2 = i5;
                            i3 = distance;
                        }
                    }
                }
            }
            if (i2 >= 0) {
                setSelection(i2 + this.mFirstPosition);
            } else {
                requestLayout();
            }
        }
    }

    public void onLayoutChild(View view2, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            view2.layout(i2, i3, i4, i5);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int count;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ListAdapter listAdapter = this.mAdapter;
            int i4 = 0;
            if (listAdapter == null) {
                count = 0;
            } else {
                count = listAdapter.getCount();
            }
            this.mItemCount = count;
            if (count > 0 && (mode == 0 || mode2 == 0)) {
                View obtainView = obtainView(0, this.mIsScrap);
                measureScrapChild(obtainView, 0, i);
                i4 = obtainView.getMeasuredWidth();
                i3 = obtainView.getMeasuredHeight();
                if (recycleOnMeasure() && this.mRecycler.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).a)) {
                    this.mRecycler.c(obtainView);
                }
            } else {
                i3 = 0;
            }
            if (mode == 0) {
                Rect rect = this.mListPadding;
                size = rect.left + rect.right + i4 + getVerticalScrollbarWidth();
            }
            if (mode2 == 0) {
                Rect rect2 = this.mListPadding;
                size2 = (getVerticalFadingEdgeLength() * 2) + rect2.top + rect2.bottom + i3;
            }
            int i5 = size2;
            if (mode2 == Integer.MIN_VALUE) {
                i5 = measureHeightOfChildren(i, 0, -1, i5, -1);
            }
            setMeasuredDimension(size, i5);
            this.mWidthMeasureSpec = i;
        }
    }

    public void onMeasureChild(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048624, this, view2, i, i2, i3) == null) {
            view2.measure(i2, i3);
        }
    }

    public void onOffsetChild(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048625, this, view2, i, i2, i3) == null) {
            view2.offsetLeftAndRight(i2);
            view2.offsetTopAndBottom(i3);
        }
    }
}
