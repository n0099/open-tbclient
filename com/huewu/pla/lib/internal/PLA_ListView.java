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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R$styleable;
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

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f70549a;

        /* renamed from: b  reason: collision with root package name */
        public Object f70550b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70551c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PLA_ListView f70552d;

        public a(PLA_ListView pLA_ListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_ListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70552d = pLA_ListView;
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

    private View addViewAbove(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, view, i2)) == null) {
            int i3 = i2 - 1;
            c.k.a.a.a.c("addViewAbove:" + i2);
            View obtainView = obtainView(i3, this.mIsScrap);
            setupChild(obtainView, i3, view.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private View addViewBelow(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, view, i2)) == null) {
            int i3 = i2 + 1;
            c.k.a.a.a.c("addViewBelow:" + i2);
            View obtainView = obtainView(i3, this.mIsScrap);
            setupChild(obtainView, i3, view.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private void adjustViewsUpOrDown() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        int i2 = 0;
        if (!this.mStackFromBottom) {
            int scrollChildTop = getScrollChildTop() - this.mListPadding.top;
            if (this.mFirstPosition != 0) {
                scrollChildTop -= this.mDividerHeight;
            }
            if (scrollChildTop >= 0) {
                i2 = scrollChildTop;
            }
        } else {
            int scrollChildBottom = getScrollChildBottom() - (getHeight() - this.mListPadding.bottom);
            if (this.mFirstPosition + childCount < this.mItemCount) {
                scrollChildBottom += this.mDividerHeight;
            }
            if (scrollChildBottom <= 0) {
                i2 = scrollChildBottom;
            }
        }
        if (i2 != 0) {
            tryOffsetChildrenTopAndBottom(-i2);
        }
    }

    private void clearRecycledState(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, arrayList) == null) || arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) arrayList.get(i2).f70549a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f70511c = false;
            }
        }
    }

    private void correctTooHigh(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, this, i2) == null) && (this.mFirstPosition + i2) - 1 == this.mItemCount - 1 && i2 > 0) {
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

    private void correctTooLow(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65544, this, i2) == null) && this.mFirstPosition == 0 && i2 > 0) {
            int scrollChildTop = getScrollChildTop();
            int i3 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int i4 = scrollChildTop - i3;
            int scrollChildBottom = getScrollChildBottom();
            int i5 = (this.mFirstPosition + i2) - 1;
            if (i4 > 0) {
                int i6 = this.mItemCount;
                if (i5 >= i6 - 1 && scrollChildBottom <= bottom) {
                    if (i5 == i6 - 1) {
                        adjustViewsUpOrDown();
                        return;
                    }
                    return;
                }
                if (i5 == this.mItemCount - 1) {
                    i4 = Math.min(i4, scrollChildBottom - bottom);
                }
                tryOffsetChildrenTopAndBottom(-i4);
                if (i5 < this.mItemCount - 1) {
                    fillDown(i5 + 1, getFillChildBottom() + this.mDividerHeight);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void drawContentBackground(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, canvas) == null) || getHeaderViewsCount() <= 0) {
            return;
        }
        Rect rect = this.mTempRect;
        rect.left = getLeft();
        rect.right = getRight();
        if (isHeaderView(getChildAt(getFirstVisiblePosition()))) {
            ArrayList<a> arrayList = this.mHeaderViewInfos;
            rect.top = arrayList.get(arrayList.size() - 1).f70549a.getBottom();
        } else {
            rect.top = 0;
        }
        rect.bottom = getBottom();
        canvas.drawRect(rect, this.mContentPaint);
    }

    private View fillDown(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, this, i2, i3)) == null) {
            c.k.a.a.a.c("fill down: " + i2);
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            while (i3 < bottom && i2 < this.mItemCount) {
                makeAndAddView(i2, getItemTop(i2), true, false);
                i2++;
                i3 = getFillChildBottom() + this.mDividerHeight;
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    private View fillFromTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            int min = Math.min(this.mFirstPosition, -1);
            this.mFirstPosition = min;
            int min2 = Math.min(min, this.mItemCount - 1);
            this.mFirstPosition = min2;
            if (min2 < 0) {
                this.mFirstPosition = 0;
            }
            return fillDown(this.mFirstPosition, i2);
        }
        return (View) invokeI.objValue;
    }

    private View fillSpecific(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i2, i3)) == null) {
            if (this.mDataChanged) {
                c.k.a.a.a.c("fill specific: " + i2 + ":" + i3);
            }
            View makeAndAddView = makeAndAddView(i2, i3, true, false);
            this.mFirstPosition = i2;
            int i4 = this.mDividerHeight;
            if (!this.mStackFromBottom) {
                fillUp(i2 - 1, getFillChildTop());
                adjustViewsUpOrDown();
                fillDown(i2 + 1, getFillChildBottom() + this.mDividerHeight);
                int childCount = getChildCount();
                if (childCount > 0) {
                    correctTooHigh(childCount);
                    return null;
                }
                return null;
            }
            fillDown(i2 + 1, makeAndAddView.getBottom() + i4);
            adjustViewsUpOrDown();
            fillUp(i2 - 1, getFillChildTop());
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooLow(childCount2);
                return null;
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    private void fillSynced(int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, this, i2, iArr) == null) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                makeAndAddView(i2 + i3, iArr[i3], true, false);
                adjustViewsUpOrDown();
            }
            this.mFirstPosition = i2;
        }
    }

    private View fillUp(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, this, i2, i3)) == null) {
            c.k.a.a.a.c("fill up: " + i2);
            int i4 = this.mListPadding.top;
            while (i3 > i4 && i2 >= 0) {
                makeAndAddView(i2, getItemBottom(i2), false, false);
                i2--;
                i3 = getItemBottom(i2);
            }
            this.mFirstPosition = i2 + 1;
            return null;
        }
        return (View) invokeII.objValue;
    }

    private boolean isHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view)) == null) {
            Iterator<a> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                if (it.next().f70549a == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private View makeAndAddView(int i2, int i3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!this.mDataChanged && (f2 = this.mRecycler.f(i2)) != null) {
                setupChild(f2, i2, i3, z, getItemLeft(i2), z2, true);
                return f2;
            }
            onItemAddedToList(i2, z);
            int itemLeft = getItemLeft(i2);
            c.k.a.a.a.c("makeAndAddView:" + i2);
            View obtainView = obtainView(i2, this.mIsScrap);
            if (obtainView == null) {
                c.k.a.a.a.b("child is null:" + i2);
            } else {
                setupChild(obtainView, i2, i3, z, itemLeft, z2, this.mIsScrap[0]);
            }
            return obtainView;
        }
        return (View) invokeCommon.objValue;
    }

    private void measureScrapChild(View view, int i2, int i3) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65553, this, view, i2, i3) == null) {
            PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
                view.setLayoutParams(layoutParams);
            }
            layoutParams.f70509a = this.mAdapter.getItemViewType(i2);
            layoutParams.f70512d = true;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
            int i4 = ((ViewGroup.LayoutParams) layoutParams).height;
            if (i4 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    private void removeFixedViewInfo(View view, ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, view, arrayList) == null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).f70549a == view) {
                    arrayList.remove(i2);
                    return;
                }
            }
        }
    }

    private void scrollListItemsBy(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            tryOffsetChildrenTopAndBottom(i2);
            int height = getHeight();
            Rect rect = this.mListPadding;
            int i5 = height - rect.bottom;
            int i6 = rect.top;
            PLA_AbsListView.h hVar = this.mRecycler;
            if (i2 < 0) {
                View lastChild = getLastChild();
                for (int childCount = getChildCount(); lastChild.getBottom() < i5 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1; childCount++) {
                    addViewBelow(lastChild, i4);
                    lastChild = getLastChild();
                }
                if (lastChild.getBottom() < i5) {
                    tryOffsetChildrenTopAndBottom(i5 - lastChild.getBottom());
                }
                View childAt = getChildAt(0);
                while (childAt.getBottom() < i6) {
                    if (hVar.n(((PLA_AbsListView.LayoutParams) childAt.getLayoutParams()).f70509a)) {
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
            while (childAt2.getTop() > i6 && (i3 = this.mFirstPosition) > 0) {
                childAt2 = addViewAbove(childAt2, i3);
                this.mFirstPosition--;
            }
            if (childAt2.getTop() > i6) {
                tryOffsetChildrenTopAndBottom(i6 - childAt2.getTop());
            }
            int childCount2 = getChildCount() - 1;
            View childAt3 = getChildAt(childCount2);
            while (childAt3.getTop() > i5) {
                if (hVar.n(((PLA_AbsListView.LayoutParams) childAt3.getLayoutParams()).f70509a)) {
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

    private void setupChild(View view, int i2, int i3, boolean z, int i4, boolean z2, boolean z3) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = z2 && shouldShowSelector();
            boolean z5 = z4 != view.isSelected();
            int i5 = this.mTouchMode;
            boolean z6 = i5 > 0 && i5 < 3 && this.mMotionPosition == i2;
            boolean z7 = z6 != view.isPressed();
            boolean z8 = !z3 || z5 || view.isLayoutRequested();
            PLA_AbsListView.LayoutParams layoutParams = (PLA_AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new PLA_AbsListView.LayoutParams(-1, -2, 0);
            }
            layoutParams.f70509a = this.mAdapter.getItemViewType(i2);
            layoutParams.f70510b = i2;
            if ((z3 && !layoutParams.f70512d) || (layoutParams.f70511c && layoutParams.f70509a == -2)) {
                attachViewToParent(view, z ? -1 : 0, layoutParams);
            } else {
                layoutParams.f70512d = false;
                if (layoutParams.f70509a == -2) {
                    layoutParams.f70511c = true;
                }
                addViewInLayout(view, z ? -1 : 0, layoutParams, true);
            }
            if (z5) {
                view.setSelected(z4);
            }
            if (z7) {
                view.setPressed(z6);
            }
            if (z8) {
                int i6 = this.mWidthMeasureSpec;
                Rect rect = this.mListPadding;
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
                int i7 = ((ViewGroup.LayoutParams) layoutParams).height;
                if (i7 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                onMeasureChild(view, i2, childMeasureSpec, makeMeasureSpec);
            } else {
                cleanupLayoutState(view);
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i8 = z ? i3 : i3 - measuredHeight;
            if (z8) {
                onLayoutChild(view, i2, i4, i8, i4 + measuredWidth, i8 + measuredHeight);
            } else {
                onOffsetChild(view, i2, i4 - view.getLeft(), i8 - view.getTop());
            }
            if (!this.mCachingStarted || view.isDrawingCacheEnabled()) {
                return;
            }
            view.setDrawingCacheEnabled(true);
        }
    }

    private boolean showingBottomFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int childCount = getChildCount();
            return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount + (-1)).getBottom() < (getScrollY() + getHeight()) - this.mListPadding.bottom;
        }
        return invokeV.booleanValue;
    }

    private boolean showingTopFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            return this.mFirstPosition > 0 || getChildAt(0).getTop() > getScrollY() + this.mListPadding.top;
        }
        return invokeV.booleanValue;
    }

    public void addFooterView(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, obj, z) == null) {
            addFooterView(view, obj, z, -1);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            a aVar = new a(this);
            aVar.f70549a = view;
            aVar.f70550b = obj;
            aVar.f70551c = z;
            if (i2 >= 0 && i2 <= this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(i2, aVar);
            } else {
                this.mHeaderViewInfos.add(aVar);
            }
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof c.k.a.a.b.a) {
                setAdapter(((c.k.a.a.b.a) listAdapter).getWrappedAdapter());
            } else if (listAdapter != null) {
                setAdapter(listAdapter);
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.canAnimate() && this.mItemCount > 0 : invokeV.booleanValue;
    }

    public void clearChoices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
        boolean z;
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
            int i7 = drawable != null ? 1 : 0;
            boolean z2 = drawable2 != null;
            boolean z3 = i6 > 0 && this.mDivider != null;
            drawContentBackground(canvas);
            if (z3 || i7 != 0 || z2) {
                Rect rect = this.mTempRect;
                rect.left = getPaddingLeft();
                rect.right = (getRight() - getLeft()) - getPaddingRight();
                int childCount = getChildCount();
                int size = this.mHeaderViewInfos.size();
                int i8 = this.mItemCount;
                int size2 = (i8 - this.mFooterViewInfos.size()) - 1;
                boolean z4 = this.mHeaderDividersEnabled;
                boolean z5 = this.mFooterDividersEnabled;
                int i9 = this.mFirstPosition;
                boolean z6 = this.mAreAllItemsSelectable;
                ListAdapter listAdapter3 = this.mAdapter;
                boolean z7 = z3 && isOpaque() && !super.isOpaque();
                if (z7) {
                    listAdapter = listAdapter3;
                    if (this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                        Paint paint3 = new Paint();
                        this.mDividerPaint = paint3;
                        z = z6;
                        paint3.setColor(getCacheColorHint());
                    } else {
                        z = z6;
                    }
                } else {
                    z = z6;
                    listAdapter = listAdapter3;
                }
                Paint paint4 = this.mDividerPaint;
                int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) + getScrollY();
                boolean z8 = z2;
                if (!this.mStackFromBottom) {
                    int scrollY = getScrollY();
                    if (childCount > 0 && scrollY < 0) {
                        if (i7 != 0) {
                            rect.bottom = 0;
                            rect.top = scrollY;
                            drawOverscrollHeader(canvas, drawable, rect);
                        } else if (z3) {
                            rect.bottom = 0;
                            rect.top = -i6;
                            drawDivider(canvas, rect, -1);
                        }
                    }
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < childCount) {
                        if ((z4 || i9 + i10 >= size) && (z5 || i9 + i10 < size2)) {
                            i11 = getChildAt(i10).getBottom();
                            if (z3 && i11 < bottom && (!z8 || i10 != childCount - 1)) {
                                if (z) {
                                    listAdapter2 = listAdapter;
                                    i5 = bottom;
                                } else {
                                    int i12 = i9 + i10;
                                    listAdapter2 = listAdapter;
                                    if (listAdapter2.isEnabled(i12)) {
                                        i5 = bottom;
                                        if (i10 != childCount - 1) {
                                        }
                                    } else {
                                        i5 = bottom;
                                    }
                                    if (z7) {
                                        rect.top = i11;
                                        rect.bottom = i11 + i6;
                                        paint2 = paint4;
                                        canvas.drawRect(rect, paint2);
                                        i10++;
                                        paint4 = paint2;
                                        bottom = i5;
                                        listAdapter = listAdapter2;
                                    }
                                    paint2 = paint4;
                                    i10++;
                                    paint4 = paint2;
                                    bottom = i5;
                                    listAdapter = listAdapter2;
                                }
                                paint2 = paint4;
                                rect.top = i11;
                                rect.bottom = i11 + i6;
                                drawDivider(canvas, rect, i10);
                                i10++;
                                paint4 = paint2;
                                bottom = i5;
                                listAdapter = listAdapter2;
                            }
                        }
                        listAdapter2 = listAdapter;
                        i5 = bottom;
                        paint2 = paint4;
                        i10++;
                        paint4 = paint2;
                        bottom = i5;
                        listAdapter = listAdapter2;
                    }
                    int bottom2 = getBottom() + getScrollY();
                    if (z8 && i9 + childCount == i8 && bottom2 > i11) {
                        rect.top = i11;
                        rect.bottom = bottom2;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    }
                } else {
                    ListAdapter listAdapter4 = listAdapter;
                    int i13 = this.mListPadding.top;
                    int scrollY2 = getScrollY();
                    if (childCount <= 0 || i7 == 0) {
                        i2 = i7;
                    } else {
                        rect.top = scrollY2;
                        i2 = i7;
                        rect.bottom = getChildAt(0).getTop();
                        drawOverscrollHeader(canvas, drawable, rect);
                    }
                    int i14 = i2;
                    while (i14 < childCount) {
                        if ((z4 || i9 + i14 >= size) && (z5 || i9 + i14 < size2)) {
                            int top = getChildAt(i14).getTop();
                            if (z3 && top > i13) {
                                i3 = i13;
                                if (z) {
                                    i4 = i9;
                                } else {
                                    int i15 = i9 + i14;
                                    if (listAdapter4.isEnabled(i15)) {
                                        i4 = i9;
                                        if (i14 != childCount - 1) {
                                        }
                                    } else {
                                        i4 = i9;
                                    }
                                    if (z7) {
                                        rect.top = top - i6;
                                        rect.bottom = top;
                                        paint = paint4;
                                        canvas.drawRect(rect, paint);
                                        i14++;
                                        paint4 = paint;
                                        i13 = i3;
                                        i9 = i4;
                                    }
                                    paint = paint4;
                                    i14++;
                                    paint4 = paint;
                                    i13 = i3;
                                    i9 = i4;
                                }
                                paint = paint4;
                                rect.top = top - i6;
                                rect.bottom = top;
                                drawDivider(canvas, rect, i14 - 1);
                                i14++;
                                paint4 = paint;
                                i13 = i3;
                                i9 = i4;
                            }
                        }
                        i3 = i13;
                        i4 = i9;
                        paint = paint4;
                        i14++;
                        paint4 = paint;
                        i13 = i3;
                        i9 = i4;
                    }
                    if (childCount > 0 && scrollY2 > 0) {
                        if (z8) {
                            int bottom3 = getBottom();
                            rect.top = bottom3;
                            rect.bottom = bottom3 + scrollY2;
                            drawOverscrollFooter(canvas, drawable2, rect);
                        } else if (z3) {
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

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, accessibilityEvent)) == null) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            if (!dispatchPopulateAccessibilityEvent) {
                int selectedItemPosition = getSelectedItemPosition();
                ListAdapter adapter = getAdapter();
                int i2 = 0;
                if (adapter != null) {
                    int count = adapter.getCount();
                    if (count < 15) {
                        int i3 = 0;
                        while (i2 < count) {
                            if (adapter.isEnabled(i2)) {
                                i3++;
                            } else if (i2 <= selectedItemPosition) {
                                selectedItemPosition--;
                            }
                            i2++;
                        }
                        i2 = i3;
                    } else {
                        i2 = count;
                    }
                }
                accessibilityEvent.setItemCount(i2);
                accessibilityEvent.setCurrentItemIndex(selectedItemPosition);
            }
            return dispatchPopulateAccessibilityEvent;
        }
        return invokeL.booleanValue;
    }

    public void drawDivider(Canvas canvas, Rect rect, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, canvas, rect, i2) == null) {
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
            int i2 = rect.bottom;
            int i3 = rect.top;
            if (i2 - i3 < minimumHeight) {
                rect.bottom = i3 + minimumHeight;
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
            int i2 = rect.bottom;
            if (i2 - rect.top < minimumHeight) {
                rect.top = i2 - minimumHeight;
            }
            drawable.setBounds(rect);
            drawable.draw(canvas);
            canvas.restore();
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

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int findMotionRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                if (this.mStackFromBottom) {
                    for (int i3 = childCount - 1; i3 >= 0; i3--) {
                        if (i2 >= getChildAt(i3).getTop()) {
                            return this.mFirstPosition + i3;
                        }
                    }
                    return -1;
                }
                for (int i4 = 0; i4 < childCount; i4++) {
                    if (i2 <= getChildAt(i4).getBottom()) {
                        return this.mFirstPosition + i4;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public boolean fullScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            boolean z = false;
            if (i2 == 33) {
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
            if (i2 == 130) {
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

    @Deprecated
    public long[] getCheckItemIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            return (listAdapter == null || !listAdapter.hasStableIds()) ? new long[0] : getCheckedItemIds();
        }
        return (long[]) invokeV.objValue;
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

    public Drawable getDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mDivider : (Drawable) invokeV.objValue;
    }

    public int getDividerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mDividerHeight : invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Math.max(0, this.mFirstPosition - getHeaderViewsCount()) : invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mFooterViewInfos.size() : invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mHeaderViewInfos.size() : invokeV.intValue;
    }

    public int getItemBottom(int i2) {
        InterceptResult invokeI;
        int height;
        int listPaddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
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

    public int getItemLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.mListPadding.left : invokeI.intValue;
    }

    public int getItemTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            int childCount = getChildCount();
            return childCount > 0 ? getChildAt(childCount - 1).getBottom() + this.mDividerHeight : getListPaddingTop();
        }
        return invokeI.intValue;
    }

    public boolean getItemsCanFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mItemsCanFocus : invokeV.booleanValue;
    }

    public View getLastChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? getChildAt(getChildCount() - 1) : (View) invokeV.objValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? Math.min((this.mFirstPosition + getChildCount()) - 1, this.mAdapter.getCount() - 1) : invokeV.intValue;
    }

    public int getMaxScrollAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (int) ((getBottom() - getTop()) * 0.33f) : invokeV.intValue;
    }

    public Drawable getOverscrollFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mOverScrollFooter : (Drawable) invokeV.objValue;
    }

    public Drawable getOverscrollHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mOverScrollHeader : (Drawable) invokeV.objValue;
    }

    public boolean isFixedView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, view)) == null) {
            ArrayList<a> arrayList = this.mHeaderViewInfos;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).f70549a == view) {
                    return true;
                }
            }
            ArrayList<a> arrayList2 = this.mFooterViewInfos;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (arrayList2.get(i3).f70549a == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isItemChecked(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.mCachingStarted && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IPUT] complete} */
    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void layoutChildren() {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (z = this.mBlockLayoutRequests)) {
            return;
        }
        this.mBlockLayoutRequests = true;
        try {
            invalidate();
            if (this.mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                return;
            }
            int fillChildBottom = getFillChildBottom() + this.mDividerHeight;
            int fillChildTop = getFillChildTop();
            int childCount = getChildCount();
            int i2 = this.mLayoutMode;
            View childAt = (i2 == 1 || i2 == 3 || i2 == 4 || i2 == 5) ? null : getChildAt(0);
            boolean z2 = this.mDataChanged;
            if (z2) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            } else if (this.mItemCount == this.mAdapter.getCount()) {
                int i3 = this.mFirstPosition;
                PLA_AbsListView.h hVar = this.mRecycler;
                if (z2) {
                    for (int i4 = childCount - 1; i4 >= 0; i4--) {
                        hVar.c(getChildAt(i4));
                    }
                } else {
                    hVar.e(childCount, i3);
                }
                int i5 = this.mLayoutMode;
                if (i5 == 1) {
                    detachAllViewsFromParent();
                    this.mFirstPosition = 0;
                    fillFromTop(fillChildBottom);
                    adjustViewsUpOrDown();
                } else if (i5 == 3) {
                    detachAllViewsFromParent();
                    fillUp(this.mItemCount - 1, fillChildTop);
                    adjustViewsUpOrDown();
                } else if (i5 == 4) {
                    detachAllViewsFromParent();
                    fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
                } else if (i5 == 5) {
                    onLayoutSync(this.mSyncPosition);
                    detachAllViewsFromParent();
                    if (this.mSpecificTops != null) {
                        fillSynced(this.mSyncPosition, this.mSpecificTops);
                        this.mSpecificTops = null;
                    } else {
                        fillSpecific(this.mSyncPosition, this.mSpecificTop);
                    }
                    onLayoutSyncFinished(this.mSyncPosition);
                } else if (childCount == 0) {
                    detachAllViewsFromParent();
                    if (!this.mStackFromBottom) {
                        fillFromTop(fillChildBottom);
                    } else {
                        fillUp(this.mItemCount - 1, fillChildTop);
                    }
                } else if (this.mFirstPosition < this.mItemCount) {
                    onLayoutSync(this.mFirstPosition);
                    detachAllViewsFromParent();
                    int i6 = this.mFirstPosition;
                    if (childAt != null) {
                        fillChildBottom = childAt.getTop();
                    }
                    fillSpecific(i6, fillChildBottom);
                    onLayoutSyncFinished(this.mFirstPosition);
                } else {
                    onLayoutSync(0);
                    detachAllViewsFromParent();
                    fillSpecific(0, fillChildBottom);
                    onLayoutSyncFinished(0);
                }
                hVar.k();
                if (this.mTouchMode > 0 && this.mTouchMode < 3) {
                    View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt2 != null) {
                        positionSelector(childAt2);
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
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            } else {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            }
        } finally {
            if (!z) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public int lookForSelectablePosition(int i2, boolean z) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && !isInTouchMode()) {
                int count = listAdapter.getCount();
                if (!this.mAreAllItemsSelectable) {
                    if (z) {
                        min = Math.max(0, i2);
                        while (min < count && !listAdapter.isEnabled(min)) {
                            min++;
                        }
                    } else {
                        min = Math.min(i2, count - 1);
                        while (min >= 0 && !listAdapter.isEnabled(min)) {
                            min--;
                        }
                    }
                    if (min < 0 || min >= count) {
                        return -1;
                    }
                    return min;
                } else if (i2 >= 0 && i2 < count) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int measureHeightOfChildren(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                Rect rect = this.mListPadding;
                return rect.top + rect.bottom;
            }
            Rect rect2 = this.mListPadding;
            int i7 = rect2.top + rect2.bottom;
            int i8 = 0;
            int i9 = (this.mDividerHeight <= 0 || this.mDivider == null) ? 0 : 0;
            if (i4 == -1) {
                i4 = listAdapter.getCount() - 1;
            }
            PLA_AbsListView.h hVar = this.mRecycler;
            boolean recycleOnMeasure = recycleOnMeasure();
            boolean[] zArr = this.mIsScrap;
            while (i3 <= i4) {
                c.k.a.a.a.c("measureHeightOfChildren:" + i3);
                View obtainView = obtainView(i3, zArr);
                measureScrapChild(obtainView, i3, i2);
                if (i3 > 0) {
                    i7 += i9;
                }
                if (recycleOnMeasure && hVar.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).f70509a)) {
                    c.k.a.a.a.c("measureHeightOfChildren");
                    hVar.c(obtainView);
                }
                i7 += obtainView.getMeasuredHeight();
                if (i7 >= i5) {
                    return (i6 < 0 || i3 <= i6 || i8 <= 0 || i7 == i5) ? i5 : i8;
                }
                if (i6 >= 0 && i3 >= i6) {
                    i8 = i7;
                }
                i3++;
            }
            return i7;
        }
        return invokeCommon.intValue;
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

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onFinishInflate();
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    addHeaderView(getChildAt(i2));
                }
                removeAllViews();
            }
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            int i3 = -1;
            if (z && rect != null) {
                rect.offset(getScrollX(), getScrollY());
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
                Rect rect2 = this.mTempRect;
                int i4 = Integer.MAX_VALUE;
                int childCount = getChildCount();
                int i5 = this.mFirstPosition;
                for (int i6 = 0; i6 < childCount; i6++) {
                    if (listAdapter.isEnabled(i5 + i6)) {
                        View childAt = getChildAt(i6);
                        childAt.getDrawingRect(rect2);
                        offsetDescendantRectToMyCoords(childAt, rect2);
                        int distance = PLA_AbsListView.getDistance(rect, rect2, i2);
                        if (distance < i4) {
                            i3 = i6;
                            i4 = distance;
                        }
                    }
                }
            }
            if (i3 >= 0) {
                setSelection(i3 + this.mFirstPosition);
            } else {
                requestLayout();
            }
        }
    }

    public void onItemAddedToList(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onLayoutChild(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            view.layout(i3, i4, i5, i6);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            ListAdapter listAdapter = this.mAdapter;
            int i5 = 0;
            int count = listAdapter == null ? 0 : listAdapter.getCount();
            this.mItemCount = count;
            if (count <= 0 || !(mode == 0 || mode2 == 0)) {
                i4 = 0;
            } else {
                View obtainView = obtainView(0, this.mIsScrap);
                measureScrapChild(obtainView, 0, i2);
                i5 = obtainView.getMeasuredWidth();
                i4 = obtainView.getMeasuredHeight();
                if (recycleOnMeasure() && this.mRecycler.n(((PLA_AbsListView.LayoutParams) obtainView.getLayoutParams()).f70509a)) {
                    this.mRecycler.c(obtainView);
                }
            }
            if (mode == 0) {
                Rect rect = this.mListPadding;
                size = rect.left + rect.right + i5 + getVerticalScrollbarWidth();
            }
            if (mode2 == 0) {
                Rect rect2 = this.mListPadding;
                size2 = (getVerticalFadingEdgeLength() * 2) + rect2.top + rect2.bottom + i4;
            }
            int i6 = size2;
            if (mode2 == Integer.MIN_VALUE) {
                i6 = measureHeightOfChildren(i2, 0, -1, i6, -1);
            }
            setMeasuredDimension(size, i6);
            this.mWidthMeasureSpec = i2;
        }
    }

    public void onMeasureChild(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048624, this, view, i2, i3, i4) == null) {
            view.measure(i3, i4);
        }
    }

    public void onOffsetChild(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048625, this, view, i2, i3, i4) == null) {
            view.offsetLeftAndRight(i3);
            view.offsetTopAndBottom(i4);
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

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public boolean performItemClick(View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? super.performItemClick(view, i2, j2) | false : invokeCommon.booleanValue;
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

    public boolean removeFooterView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, view)) == null) {
            boolean z = false;
            if (this.mFooterViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((c.k.a.a.b.a) listAdapter).d(view)) {
                    this.mDataSetObserver.onChanged();
                    z = true;
                }
                removeFixedViewInfo(view, this.mFooterViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean removeHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, view)) == null) {
            boolean z = false;
            if (this.mHeaderViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((c.k.a.a.b.a) listAdapter).e(view)) {
                    this.mDataSetObserver.onChanged();
                    z = true;
                }
                removeFixedViewInfo(view, this.mHeaderViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048631, this, view, rect, z)) == null) {
            int i5 = rect.top;
            rect.offset(view.getLeft(), view.getTop());
            rect.offset(-view.getScrollX(), -view.getScrollY());
            int height = getHeight();
            int scrollY = getScrollY();
            int i6 = scrollY + height;
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (showingTopFadingEdge() && i5 > verticalFadingEdgeLength) {
                scrollY += verticalFadingEdgeLength;
            }
            int bottom = getChildAt(getChildCount() - 1).getBottom();
            if (showingBottomFadingEdge() && rect.bottom < bottom - verticalFadingEdgeLength) {
                i6 -= verticalFadingEdgeLength;
            }
            if (rect.bottom > i6 && rect.top > scrollY) {
                if (rect.height() > height) {
                    i4 = rect.top - scrollY;
                } else {
                    i4 = rect.bottom - i6;
                }
                i2 = Math.min(i4 + 0, bottom - i6);
            } else if (rect.top >= scrollY || rect.bottom >= i6) {
                i2 = 0;
            } else {
                if (rect.height() > height) {
                    i3 = 0 - (i6 - rect.bottom);
                } else {
                    i3 = 0 - (scrollY - rect.top);
                }
                i2 = Math.max(i3, getChildAt(0).getTop() - scrollY);
            }
            boolean z2 = i2 != 0;
            if (z2) {
                scrollListItemsBy(-i2);
                positionSelector(view);
                this.mSelectedTop = view.getTop();
                invalidate();
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
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

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setCacheColorHint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            boolean z = (i2 >>> 24) == 255;
            this.mIsCacheColorOpaque = z;
            if (z) {
                if (this.mDividerPaint == null) {
                    this.mDividerPaint = new Paint();
                }
                this.mDividerPaint.setColor(i2);
            }
            super.setCacheColorHint(i2);
        }
    }

    public void setContentBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            Paint paint = new Paint();
            this.mContentPaint = paint;
            paint.setColor(i2);
        }
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

    public void setDividerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mDividerHeight = i2;
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

    public void setItemChecked(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    public void setItemsCanFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.mItemsCanFocus = z;
            if (z) {
                return;
            }
            setDescendantFocusability(393216);
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

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
        }
    }

    public void setSelectionFromTop(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048646, this, i2, i3) == null) {
            this.mLayoutMode = 4;
            this.mSpecificTop = this.mListPadding.top + i3;
            if (this.mNeedSync) {
                this.mSyncPosition = i2;
                this.mSyncRowId = this.mAdapter.getItemId(i2);
            }
            PLA_AbsListView.g gVar = this.mPositionScroller;
            if (gVar != null) {
                gVar.c();
            }
            requestLayout();
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

    public void addFooterView(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            a aVar = new a(this);
            aVar.f70549a = view;
            aVar.f70550b = obj;
            aVar.f70551c = z;
            if (i2 >= 0 && i2 <= this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(i2, aVar);
            } else {
                this.mFooterViewInfos.add(aVar);
            }
            PLA_AdapterView<ListAdapter>.c cVar = this.mDataSetObserver;
            if (cVar != null) {
                cVar.onChanged();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAdapter : (ListAdapter) invokeV.objValue;
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
                this.mAdapter = new c.k.a.a.b.a(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_ListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mContentPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListView, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ListView_overScrollHeader);
        if (drawable != null) {
            setOverscrollHeader(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ListView_overScrollFooter);
        if (drawable2 != null) {
            setOverscrollFooter(drawable2);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ListView_dividerHeight, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(R$styleable.ListView_headerDividersEnabled, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(R$styleable.ListView_footerDividersEnabled, true);
        if (obtainStyledAttributes.hasValue(R$styleable.ListView_plaContentBackground)) {
            int color = obtainStyledAttributes.getColor(R$styleable.ListView_plaContentBackground, 0);
            Paint paint = new Paint();
            this.mContentPaint = paint;
            paint.setColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    public void addFooterView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            addFooterView(view, null, true);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view, obj, z) == null) {
            addHeaderView(view, obj, z, -1);
        }
    }

    public void addHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            addHeaderView(view, null, true);
        }
    }
}
