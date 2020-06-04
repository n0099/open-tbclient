package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tieba.R;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes3.dex */
public abstract class PLA_AbsListView extends PLA_AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    private static final int INVALID_POINTER = -1;
    static final int LAYOUT_FORCE_BOTTOM = 3;
    static final int LAYOUT_FORCE_TOP = 1;
    static final int LAYOUT_MOVE_SELECTION = 6;
    static final int LAYOUT_NORMAL = 0;
    static final int LAYOUT_SET_SELECTION = 2;
    static final int LAYOUT_SPECIFIC = 4;
    static final int LAYOUT_SYNC = 5;
    private static final boolean PROFILE_FLINGING = false;
    private static final boolean PROFILE_SCROLLING = false;
    private static final String TAG = "PLA_AbsListView";
    protected static final int TOUCH_MODE_DONE_WAITING = 2;
    protected static final int TOUCH_MODE_DOWN = 0;
    protected static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    static final int TOUCH_MODE_REST = -1;
    protected static final int TOUCH_MODE_SCROLL = 3;
    protected static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mCacheColorHint;
    protected boolean mCachingStarted;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    PLA_AdapterView<ListAdapter>.b mDataSetObserver;
    boolean mDrawSelectorOnTop;
    private boolean mFlingProfilingStarted;
    private b mFlingRunnable;
    private boolean mIsChildViewEnabled;
    final boolean[] mIsScrap;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastY;
    int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    protected int mMotionPosition;
    int mMotionViewNewTop;
    int mMotionViewOriginalTop;
    int mMotionX;
    int mMotionY;
    private c mOnScrollListener;
    private Runnable mPendingCheckForTap;
    private h mPendingSync;
    private d mPerformClick;
    e mPositionScroller;
    final f mRecycler;
    int mResurrectToPosition;
    private boolean mScrollProfilingStarted;
    boolean mScrollingCacheEnabled;
    int mSelectedTop;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    boolean mStackFromBottom;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private int mTouchSlop;
    private int mTranscriptMode;
    private VelocityTracker mVelocityTracker;
    protected int mWidthMeasureSpec;

    /* loaded from: classes3.dex */
    public interface c {
        void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3);

        void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onMovedToScrapHeap(View view);
    }

    abstract void fillGap(boolean z);

    abstract int findMotionRow(int i2);

    public PLA_AbsListView(Context context) {
        super(context);
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorRect = new Rect();
        this.mRecycler = new f();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mLastScrollState = 0;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.View);
        try {
            View.class.getDeclaredMethod("initializeScrollbars", TypedArray.class).invoke(this, obtainStyledAttributes);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        obtainStyledAttributes.recycle();
    }

    public PLA_AbsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.absListViewStyle);
    }

    public PLA_AbsListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorRect = new Rect();
        this.mRecycler = new f();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mLastScrollState = 0;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsListView, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = obtainStyledAttributes.getBoolean(1, false);
        setStackFromBottom(obtainStyledAttributes.getBoolean(2, false));
        setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(3, true));
        setTranscriptMode(obtainStyledAttributes.getInt(5, 0));
        setCacheColorHint(obtainStyledAttributes.getColor(6, 0));
        setSmoothScrollbarEnabled(obtainStyledAttributes.getBoolean(8, true));
        obtainStyledAttributes.recycle();
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void setOnScrollListener(c cVar) {
        this.mOnScrollListener = cVar;
        invokeOnItemScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeOnItemScrollListener() {
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return this.mScrollingCacheEnabled;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
            return;
        }
        super.getFocusedRect(rect);
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(17301602));
    }

    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        return this.mStackFromBottom;
    }

    public void setStackFromBottom(boolean z) {
        if (this.mStackFromBottom != z) {
            this.mStackFromBottom = z;
            requestLayoutIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mNeedSync = false;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mSelectedTop = 0;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                int i2 = childCount * 100;
                View childAt = getChildAt(0);
                int fillChildTop = getFillChildTop();
                int height = childAt.getHeight();
                if (height > 0) {
                    i2 += (fillChildTop * 100) / height;
                }
                View childAt2 = getChildAt(childCount - 1);
                int scrollChildBottom = getScrollChildBottom();
                int height2 = childAt2.getHeight();
                if (height2 > 0) {
                    return i2 - (((scrollChildBottom - getHeight()) * 100) / height2);
                }
                return i2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        int i2 = 0;
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.mSmoothScrollbarEnabled) {
            View childAt = getChildAt(0);
            int fillChildTop = getFillChildTop();
            int height = childAt.getHeight();
            if (height > 0) {
                return Math.max(((i3 * 100) - ((fillChildTop * 100) / height)) + ((int) ((getScrollY() / getHeight()) * this.mItemCount * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.mItemCount;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            return Math.max(this.mItemCount * 100, 0);
        }
        return this.mItemCount;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        int childCount = getChildCount();
        float topFadingEdgeStrength = super.getTopFadingEdgeStrength();
        if (childCount != 0) {
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int top2 = getChildAt(0).getTop();
            return top2 < getPaddingTop() ? (-(top2 - getPaddingTop())) / getVerticalFadingEdgeLength() : topFadingEdgeStrength;
        }
        return topFadingEdgeStrength;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        int childCount = getChildCount();
        float bottomFadingEdgeStrength = super.getBottomFadingEdgeStrength();
        if (childCount != 0) {
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int bottom = getChildAt(childCount - 1).getBottom();
            int height = getHeight();
            return bottom > height - getPaddingBottom() ? ((bottom - height) + getPaddingBottom()) / getVerticalFadingEdgeLength() : bottomFadingEdgeStrength;
        }
        return bottomFadingEdgeStrength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.mRecycler.GA();
        }
        com.huewu.pla.lib.a.i("onLayout");
        layoutChildren();
        this.mInLayout = false;
    }

    protected void layoutChildren() {
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        return null;
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
    }

    public int getListPaddingBottom() {
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        return this.mListPadding.right;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View obtainView(int i2, boolean[] zArr) {
        View view;
        zArr[0] = false;
        View cQ = this.mRecycler.cQ(i2);
        if (cQ != null) {
            view = this.mAdapter.getView(i2, cQ, this);
            if (view != cQ) {
                com.huewu.pla.lib.a.i("obtainView");
                this.mRecycler.dq(cQ);
                if (this.mCacheColorHint != 0) {
                    view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                }
            } else {
                zArr[0] = true;
                dispatchFinishTemporaryDetach(view);
            }
        } else {
            com.huewu.pla.lib.a.i("makeView:" + i2);
            view = this.mAdapter.getView(i2, null, this);
            if (this.mCacheColorHint != 0) {
                view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionSelector(View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.mIsChildViewEnabled;
        if (view.isEnabled() != z) {
            this.mIsChildViewEnabled = !z;
            refreshDrawableState();
        }
    }

    private void positionSelector(int i2, int i3, int i4, int i5) {
        this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, this.mSelectionRightPadding + i4, this.mSelectionBottomPadding + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.mDrawSelectorOnTop;
        if (!z) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            drawSelector(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            com.huewu.pla.lib.a.Qv("data changed by onSizeChanged()");
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    boolean touchModeDrawsInPressedState() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    private void drawSelector(Canvas canvas) {
        if (shouldShowSelector() && this.mSelectorRect != null && !this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.mSelector != null) {
            this.mSelector.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        drawable.setState(getDrawableState());
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mSelector != null) {
            this.mSelector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i2);
        }
        int i3 = ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i3) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
            return onCreateDrawableState;
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnTouchModeChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mRecycler.clear();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnTouchModeChangeListener(this);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.huewu.pla.lib.a.i("onWindowFocusChanged");
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.mFlingRunnable != null) {
                removeCallbacks(this.mFlingRunnable);
                this.mFlingRunnable.Gy();
                if (getScrollY() != 0) {
                    scrollTo(getScrollX(), 0);
                    invalidate();
                }
            }
        } else if (i2 != this.mLastTouchMode && this.mLastTouchMode != -1) {
            this.mLayoutMode = 0;
            com.huewu.pla.lib.a.i("onWindowFocusChanged");
            layoutChildren();
        }
        this.mLastTouchMode = i2;
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j) {
        return new PLA_AdapterView.a(view, i2, j);
    }

    /* loaded from: classes3.dex */
    private class i {
        private int baC;

        private i() {
        }

        public void GF() {
            this.baC = PLA_AbsListView.this.getWindowAttachCount();
        }

        public boolean GG() {
            return PLA_AbsListView.this.hasWindowFocus() && PLA_AbsListView.this.getWindowAttachCount() == this.baC;
        }
    }

    /* loaded from: classes3.dex */
    private class d extends i implements Runnable {
        int baf;
        View mChild;

        private d() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PLA_AbsListView.this.mDataChanged) {
                ListAdapter listAdapter = PLA_AbsListView.this.mAdapter;
                int i = this.baf;
                if (listAdapter != null && PLA_AbsListView.this.mItemCount > 0 && i != -1 && i < listAdapter.getCount() && GG()) {
                    PLA_AbsListView.this.performItemClick(this.mChild, i, listAdapter.getItemId(i));
                }
            }
        }
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            boolean onItemLongClick = this.mOnItemLongClickListener != null ? this.mOnItemLongClickListener.onItemLongClick(this, view, positionForView, itemId) : false;
            if (!onItemLongClick) {
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                return super.showContextMenuForChild(view);
            }
            return onItemLongClick;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public int pointToPosition(int i2, int i3) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public long pointToRowId(int i2, int i3) {
        int pointToPosition = pointToPosition(i2, i3);
        if (pointToPosition >= 0) {
            return this.mAdapter.getItemId(pointToPosition);
        }
        return Long.MIN_VALUE;
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            if (PLA_AbsListView.this.mTouchMode == 0) {
                PLA_AbsListView.this.mTouchMode = 1;
                View childAt = PLA_AbsListView.this.getChildAt(PLA_AbsListView.this.mMotionPosition - PLA_AbsListView.this.mFirstPosition);
                if (childAt != null && !childAt.hasFocusable()) {
                    PLA_AbsListView.this.mLayoutMode = 0;
                    if (!PLA_AbsListView.this.mDataChanged) {
                        PLA_AbsListView.this.layoutChildren();
                        childAt.setPressed(true);
                        PLA_AbsListView.this.positionSelector(childAt);
                        PLA_AbsListView.this.setPressed(true);
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = PLA_AbsListView.this.isLongClickable();
                        if (PLA_AbsListView.this.mSelector != null && (current = PLA_AbsListView.this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (!isLongClickable) {
                            PLA_AbsListView.this.mTouchMode = 2;
                            return;
                        }
                        return;
                    }
                    PLA_AbsListView.this.mTouchMode = 2;
                }
            }
        }
    }

    private boolean startScrollIfNeeded(int i2) {
        if (Math.abs(i2) > this.mTouchSlop) {
            createScrollingCache();
            this.mTouchMode = 3;
            this.mMotionCorrection = i2;
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z && getHeight() > 0 && getChildCount() > 0) {
            layoutChildren();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (action & 255) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int pointToPosition = pointToPosition(x, y);
                if (!this.mDataChanged) {
                    if (this.mTouchMode != 4 && pointToPosition >= 0 && ((ListAdapter) getAdapter()).isEnabled(pointToPosition)) {
                        this.mTouchMode = 0;
                        if (this.mPendingCheckForTap == null) {
                            this.mPendingCheckForTap = new a();
                        }
                        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        i2 = pointToPosition;
                    } else if (motionEvent.getEdgeFlags() != 0 && pointToPosition < 0) {
                        return false;
                    } else {
                        if (this.mTouchMode == 4) {
                            createScrollingCache();
                            this.mTouchMode = 3;
                            this.mMotionCorrection = 0;
                            i2 = findMotionRow(y);
                            reportScrollStateChange(1);
                        }
                    }
                    if (i2 >= 0) {
                        this.mMotionViewOriginalTop = getChildAt(i2 - this.mFirstPosition).getTop();
                    }
                    this.mMotionX = x;
                    this.mMotionY = y;
                    this.mMotionPosition = i2;
                    this.mLastY = Integer.MIN_VALUE;
                    return true;
                }
                i2 = pointToPosition;
                if (i2 >= 0) {
                }
                this.mMotionX = x;
                this.mMotionY = y;
                this.mMotionPosition = i2;
                this.mLastY = Integer.MIN_VALUE;
                return true;
            case 1:
                switch (this.mTouchMode) {
                    case 0:
                    case 1:
                    case 2:
                        int i3 = this.mMotionPosition;
                        final View childAt = getChildAt(i3 - this.mFirstPosition);
                        if (childAt != null && !childAt.hasFocusable()) {
                            if (this.mTouchMode != 0) {
                                childAt.setPressed(false);
                            }
                            if (this.mPerformClick == null) {
                                this.mPerformClick = new d();
                            }
                            final d dVar = this.mPerformClick;
                            dVar.mChild = childAt;
                            dVar.baf = i3;
                            dVar.GF();
                            this.mResurrectToPosition = i3;
                            if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                this.mLayoutMode = 0;
                                if (!this.mDataChanged && this.mAdapter.isEnabled(i3)) {
                                    this.mTouchMode = 1;
                                    layoutChildren();
                                    childAt.setPressed(true);
                                    positionSelector(childAt);
                                    setPressed(true);
                                    if (this.mSelector != null && (current = this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                        ((TransitionDrawable) current).resetTransition();
                                    }
                                    postDelayed(new Runnable() { // from class: com.huewu.pla.lib.internal.PLA_AbsListView.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            childAt.setPressed(false);
                                            PLA_AbsListView.this.setPressed(false);
                                            if (!PLA_AbsListView.this.mDataChanged) {
                                                PLA_AbsListView.this.post(dVar);
                                            }
                                            PLA_AbsListView.this.mTouchMode = -1;
                                        }
                                    }, ViewConfiguration.getPressedStateDuration());
                                    return true;
                                }
                                this.mTouchMode = -1;
                                return true;
                            } else if (!this.mDataChanged && this.mAdapter.isEnabled(i3)) {
                                post(dVar);
                            }
                        }
                        this.mTouchMode = -1;
                        break;
                    case 3:
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            int fillChildTop = getFillChildTop();
                            int fillChildBottom = getFillChildBottom();
                            if (this.mFirstPosition == 0 && fillChildTop >= this.mListPadding.top && childCount + this.mFirstPosition < this.mItemCount && fillChildBottom <= getHeight() - this.mListPadding.bottom) {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                                break;
                            } else {
                                VelocityTracker velocityTracker = this.mVelocityTracker;
                                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                                if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                                    if (this.mFlingRunnable == null) {
                                        this.mFlingRunnable = new b();
                                    }
                                    reportScrollStateChange(2);
                                    this.mFlingRunnable.start(-yVelocity);
                                    break;
                                } else {
                                    this.mTouchMode = -1;
                                    reportScrollStateChange(0);
                                    break;
                                }
                            }
                        } else {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                            break;
                        }
                        break;
                }
                setPressed(false);
                invalidate();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.mActivePointerId = -1;
                return true;
            case 2:
                int y2 = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                int i4 = y2 - this.mMotionY;
                switch (this.mTouchMode) {
                    case 0:
                    case 1:
                    case 2:
                        startScrollIfNeeded(i4);
                        return true;
                    case 3:
                        if (y2 != this.mLastY) {
                            int i5 = i4 - this.mMotionCorrection;
                            int i6 = this.mLastY != Integer.MIN_VALUE ? y2 - this.mLastY : i5;
                            if ((i6 != 0 ? trackMotionScroll(i5, i6) : false) && getChildCount() > 0) {
                                int findMotionRow = findMotionRow(y2);
                                if (findMotionRow >= 0) {
                                    this.mMotionViewOriginalTop = getChildAt(findMotionRow - this.mFirstPosition).getTop();
                                }
                                this.mMotionY = y2;
                                this.mMotionPosition = findMotionRow;
                                invalidate();
                            }
                            this.mLastY = y2;
                            return true;
                        }
                        return true;
                    default:
                        return true;
                }
            case 3:
                this.mTouchMode = -1;
                setPressed(false);
                View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
                clearScrollingCache();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.mActivePointerId = -1;
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                onSecondaryPointerUp(motionEvent);
                int i7 = this.mMotionX;
                int i8 = this.mMotionY;
                int pointToPosition2 = pointToPosition(i7, i8);
                if (pointToPosition2 >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(pointToPosition2 - this.mFirstPosition).getTop();
                    this.mMotionPosition = pointToPosition2;
                }
                this.mLastY = i8;
                return true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                int i2 = this.mTouchMode;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                int findMotionRow = findMotionRow(y);
                if (i2 != 4 && findMotionRow >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(findMotionRow - this.mFirstPosition).getTop();
                    this.mMotionX = x;
                    this.mMotionY = y;
                    this.mMotionPosition = findMotionRow;
                    this.mTouchMode = 0;
                    clearScrollingCache();
                }
                this.mLastY = Integer.MIN_VALUE;
                if (i2 == 4) {
                    return true;
                }
                break;
            case 1:
                this.mTouchMode = -1;
                this.mActivePointerId = -1;
                reportScrollStateChange(0);
                break;
            case 2:
                switch (this.mTouchMode) {
                    case 0:
                        if (startScrollIfNeeded(((int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId))) - this.mMotionY)) {
                            return true;
                        }
                        break;
                }
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i2);
            this.mMotionY = (int) motionEvent.getY(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    void reportScrollStateChange(int i2) {
        if (i2 != this.mLastScrollState && this.mOnScrollListener != null) {
            this.mOnScrollListener.onScrollStateChanged(this, i2);
            this.mLastScrollState = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private int mLastFlingY;
        private final Scroller mScroller;

        b() {
            this.mScroller = new Scroller(PLA_AbsListView.this.getContext());
        }

        void start(int i) {
            int modifyFlingInitialVelocity = PLA_AbsListView.this.modifyFlingInitialVelocity(i);
            int i2 = modifyFlingInitialVelocity < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingY = i2;
            this.mScroller.fling(0, i2, 0, modifyFlingInitialVelocity, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            PLA_AbsListView.this.mTouchMode = 4;
            PLA_AbsListView.this.post(this);
        }

        void dz(int i, int i2) {
            int i3 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 0;
            this.mLastFlingY = i3;
            this.mScroller.startScroll(0, i3, 0, i, i2);
            PLA_AbsListView.this.mTouchMode = 4;
            PLA_AbsListView.this.post(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Gy() {
            this.mLastFlingY = 0;
            PLA_AbsListView.this.mTouchMode = -1;
            PLA_AbsListView.this.reportScrollStateChange(0);
            PLA_AbsListView.this.clearScrollingCache();
            PLA_AbsListView.this.removeCallbacks(this);
            if (PLA_AbsListView.this.mPositionScroller != null) {
                PLA_AbsListView.this.removeCallbacks(PLA_AbsListView.this.mPositionScroller);
            }
            this.mScroller.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            switch (PLA_AbsListView.this.mTouchMode) {
                case 4:
                    if (PLA_AbsListView.this.mItemCount == 0 || PLA_AbsListView.this.getChildCount() == 0) {
                        Gy();
                        return;
                    }
                    Scroller scroller = this.mScroller;
                    boolean computeScrollOffset = scroller.computeScrollOffset();
                    int currY = scroller.getCurrY();
                    int i = this.mLastFlingY - currY;
                    if (i > 0) {
                        PLA_AbsListView.this.mMotionPosition = PLA_AbsListView.this.mFirstPosition;
                        PLA_AbsListView.this.mMotionViewOriginalTop = PLA_AbsListView.this.getScrollChildTop();
                        max = Math.min(((PLA_AbsListView.this.getHeight() - PLA_AbsListView.this.getPaddingBottom()) - PLA_AbsListView.this.getPaddingTop()) - 1, i);
                    } else {
                        PLA_AbsListView.this.mMotionPosition = (PLA_AbsListView.this.getChildCount() - 1) + PLA_AbsListView.this.mFirstPosition;
                        PLA_AbsListView.this.mMotionViewOriginalTop = PLA_AbsListView.this.getScrollChildBottom();
                        max = Math.max(-(((PLA_AbsListView.this.getHeight() - PLA_AbsListView.this.getPaddingBottom()) - PLA_AbsListView.this.getPaddingTop()) - 1), i);
                    }
                    boolean trackMotionScroll = PLA_AbsListView.this.trackMotionScroll(max, max);
                    if (computeScrollOffset && !trackMotionScroll) {
                        PLA_AbsListView.this.invalidate();
                        this.mLastFlingY = currY;
                        PLA_AbsListView.this.post(this);
                        return;
                    }
                    Gy();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        private int bag;
        private int bah;
        private int bai;
        private int baj;
        private final int bak;
        private int mMode;

        e() {
            this.bak = ViewConfiguration.get(PLA_AbsListView.this.getContext()).getScaledFadingEdgeLength();
        }

        void start(int i) {
            int i2;
            int i3 = PLA_AbsListView.this.mFirstPosition;
            int childCount = (PLA_AbsListView.this.getChildCount() + i3) - 1;
            if (i <= i3) {
                i2 = (i3 - i) + 1;
                this.mMode = 2;
            } else if (i >= childCount) {
                i2 = (i - childCount) + 1;
                this.mMode = 1;
            } else {
                return;
            }
            if (i2 > 0) {
                this.baj = 400 / i2;
            } else {
                this.baj = 400;
            }
            this.bag = i;
            this.bah = -1;
            this.bai = -1;
            PLA_AbsListView.this.post(this);
        }

        void E(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i2 == -1) {
                start(i);
                return;
            }
            int i6 = PLA_AbsListView.this.mFirstPosition;
            int childCount = (PLA_AbsListView.this.getChildCount() + i6) - 1;
            if (i <= i6) {
                int i7 = childCount - i2;
                if (i7 >= 1) {
                    i4 = (i6 - i) + 1;
                    i5 = i7 - 1;
                    if (i5 < i4) {
                        this.mMode = 4;
                    } else {
                        this.mMode = 2;
                        i5 = i4;
                    }
                } else {
                    return;
                }
            } else if (i >= childCount && (i3 = i2 - i6) >= 1) {
                i4 = (i - childCount) + 1;
                i5 = i3 - 1;
                if (i5 < i4) {
                    this.mMode = 3;
                } else {
                    this.mMode = 1;
                    i5 = i4;
                }
            } else {
                return;
            }
            if (i5 > 0) {
                this.baj = 400 / i5;
            } else {
                this.baj = 400;
            }
            this.bag = i;
            this.bah = i2;
            this.bai = -1;
            PLA_AbsListView.this.post(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void stop() {
            PLA_AbsListView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = PLA_AbsListView.this.getHeight();
            int i = PLA_AbsListView.this.mFirstPosition;
            switch (this.mMode) {
                case 1:
                    int childCount = PLA_AbsListView.this.getChildCount() - 1;
                    int i2 = i + childCount;
                    if (childCount >= 0) {
                        if (i2 == this.bai) {
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        View childAt = PLA_AbsListView.this.getChildAt(childCount);
                        PLA_AbsListView.this.smoothScrollBy((i2 < PLA_AbsListView.this.mItemCount + (-1) ? this.bak : PLA_AbsListView.this.mListPadding.bottom) + (childAt.getHeight() - (height - childAt.getTop())), this.baj);
                        this.bai = i2;
                        if (i2 < this.bag) {
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i == this.bai) {
                        PLA_AbsListView.this.post(this);
                        return;
                    }
                    View childAt2 = PLA_AbsListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        PLA_AbsListView.this.smoothScrollBy(childAt2.getTop() - (i > 0 ? this.bak : PLA_AbsListView.this.mListPadding.top), this.baj);
                        this.bai = i;
                        if (i > this.bag) {
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = PLA_AbsListView.this.getChildCount();
                    if (i != this.bah && childCount2 > 1 && childCount2 + i < PLA_AbsListView.this.mItemCount) {
                        int i3 = i + 1;
                        if (i3 == this.bai) {
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        View childAt3 = PLA_AbsListView.this.getChildAt(1);
                        int height2 = childAt3.getHeight();
                        int top2 = childAt3.getTop();
                        int i4 = this.bak;
                        if (i3 < this.bah) {
                            PLA_AbsListView.this.smoothScrollBy(Math.max(0, (top2 + height2) - i4), this.baj);
                            this.bai = i3;
                            PLA_AbsListView.this.post(this);
                            return;
                        } else if (top2 > i4) {
                            PLA_AbsListView.this.smoothScrollBy(top2 - i4, this.baj);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 4:
                    int childCount3 = PLA_AbsListView.this.getChildCount() - 2;
                    if (childCount3 >= 0) {
                        int i5 = i + childCount3;
                        if (i5 == this.bai) {
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        View childAt4 = PLA_AbsListView.this.getChildAt(childCount3);
                        int height3 = childAt4.getHeight();
                        int top3 = childAt4.getTop();
                        int i6 = height - top3;
                        this.bai = i5;
                        if (i5 > this.bah) {
                            PLA_AbsListView.this.smoothScrollBy(-(i6 - this.bak), this.baj);
                            PLA_AbsListView.this.post(this);
                            return;
                        }
                        int i7 = height - this.bak;
                        int i8 = top3 + height3;
                        if (i7 > i8) {
                            PLA_AbsListView.this.smoothScrollBy(-(i7 - i8), this.baj);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new e();
        }
        this.mPositionScroller.start(i2);
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new e();
        }
        this.mPositionScroller.E(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        if (this.mFlingRunnable != null) {
            this.mFlingRunnable.Gy();
        } else {
            this.mFlingRunnable = new b();
        }
        this.mFlingRunnable.dz(i2, i3);
    }

    private void createScrollingCache() {
        if (this.mScrollingCacheEnabled && !this.mCachingStarted) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.mCachingStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (this.mClearScrollingCache == null) {
            this.mClearScrollingCache = new Runnable() { // from class: com.huewu.pla.lib.internal.PLA_AbsListView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PLA_AbsListView.this.mCachingStarted) {
                        PLA_AbsListView.this.mCachingStarted = false;
                        PLA_AbsListView.this.setChildrenDrawnWithCacheEnabled(false);
                        if ((PLA_AbsListView.this.getPersistentDrawingCache() & 2) == 0) {
                            PLA_AbsListView.this.setChildrenDrawingCacheEnabled(false);
                        }
                        if (!PLA_AbsListView.this.isAlwaysDrawnWithCacheEnabled()) {
                            PLA_AbsListView.this.invalidate();
                        }
                    }
                }
            };
        }
        post(this.mClearScrollingCache);
    }

    boolean trackMotionScroll(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int scrollChildTop = getScrollChildTop();
        int scrollChildBottom = getScrollChildBottom();
        Rect rect = this.mListPadding;
        int height = getHeight() - rect.bottom;
        int fillChildTop = rect.top - getFillChildTop();
        int fillChildBottom = getFillChildBottom() - height;
        int height2 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (i2 < 0) {
            min = Math.max(-(height2 - 1), i2);
        } else {
            min = Math.min(height2 - 1, i2);
        }
        if (i3 < 0) {
            min2 = Math.max((-(height2 - 1)) / 2, i3);
        } else {
            min2 = Math.min((height2 - 1) / 2, i3);
        }
        int i5 = this.mFirstPosition;
        if (i5 == 0 && scrollChildTop >= rect.top && min >= 0) {
            return true;
        }
        if (i5 + childCount == this.mItemCount && scrollChildBottom <= height && min <= 0) {
            return true;
        }
        boolean z = min2 < 0;
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        int i6 = 0;
        if (z) {
            int i7 = rect.top - min2;
            i4 = 0;
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (childAt.getBottom() >= i7) {
                    break;
                }
                int i9 = i4 + 1;
                int i10 = i5 + i8;
                if (i10 >= headerViewsCount && i10 < footerViewsCount) {
                    this.mRecycler.dq(childAt);
                }
                i8++;
                i4 = i9;
            }
        } else {
            int height3 = (getHeight() - rect.bottom) - min2;
            i4 = 0;
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt2 = getChildAt(i11);
                if (childAt2.getTop() <= height3) {
                    break;
                }
                int i12 = i4 + 1;
                int i13 = i5 + i11;
                if (i13 >= headerViewsCount && i13 < footerViewsCount) {
                    this.mRecycler.dq(childAt2);
                }
                i4 = i12;
                i6 = i11;
            }
        }
        this.mMotionViewNewTop = this.mMotionViewOriginalTop + min;
        this.mBlockLayoutRequests = true;
        if (i4 > 0) {
            detachViewsFromParent(i6, i4);
        }
        tryOffsetChildrenTopAndBottom(min2);
        if (z) {
            this.mFirstPosition = i4 + this.mFirstPosition;
        }
        invalidate();
        int abs = Math.abs(min2);
        if (fillChildTop < abs || fillChildBottom < abs) {
            fillGap(z);
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        awakenScrollBars();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryOffsetChildrenTopAndBottom(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).offsetTopAndBottom(i2);
        }
    }

    int getHeaderViewsCount() {
        return 0;
    }

    int getFooterViewsCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int reconcileSelectedPosition() {
        int i2 = this.mSelectedPosition;
        if (i2 < 0) {
            i2 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i2), this.mItemCount - 1);
    }

    int findClosestMotionRow(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int findMotionRow = findMotionRow(i2);
        return findMotionRow == -1 ? (this.mFirstPosition + childCount) - 1 : findMotionRow;
    }

    public void invalidateViews() {
        com.huewu.pla.lib.a.Qv("data changed by invalidateViews()");
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void handleDataChanged() {
        int i2 = this.mItemCount;
        if (i2 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.mPendingSync = null;
                if (this.mTranscriptMode == 2 || (this.mTranscriptMode == 1 && this.mFirstPosition + getChildCount() >= this.mOldItemCount)) {
                    this.mLayoutMode = 3;
                    return;
                }
                switch (this.mSyncMode) {
                    case 1:
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                            return;
                        }
                        int findSyncPosition = findSyncPosition();
                        if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                            this.mSyncPosition = findSyncPosition;
                            if (this.mSyncHeight == getHeight()) {
                                this.mLayoutMode = 5;
                                return;
                            } else {
                                this.mLayoutMode = 2;
                                return;
                            }
                        }
                        break;
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i2) {
                    selectedItemPosition = i2 - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                if (lookForSelectablePosition(selectedItemPosition, true) >= 0 || lookForSelectablePosition(selectedItemPosition, false) >= 0) {
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = this.mStackFromBottom ? 3 : 1;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mPendingSync = null;
        checkSelectionChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayoutSync(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayoutSyncFinished(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDistance(Rect rect, Rect rect2, int i2) {
        int width;
        int i3;
        int width2;
        int i4;
        switch (i2) {
            case 17:
                width = rect.left;
                i3 = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                i4 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                i3 = rect.top;
                width2 = (rect2.width() / 2) + rect2.left;
                i4 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                i3 = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                i4 = rect2.top + (rect2.height() / 2);
                break;
            case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                width = rect.left + (rect.width() / 2);
                i3 = rect.bottom;
                width2 = (rect2.width() / 2) + rect2.left;
                i4 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i5 = width2 - width;
        int i6 = i4 - i3;
        return (i6 * i6) + (i5 * i5);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setTranscriptMode(int i2) {
        this.mTranscriptMode = i2;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.mCacheColorHint) {
            this.mCacheColorHint = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.mRecycler.setCacheColorHint(i2);
        }
    }

    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    public void reclaimViews(List<View> list) {
        int childCount = getChildCount();
        g gVar = this.mRecycler.mIl;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null && this.mRecycler.cN(layoutParams.baa)) {
                list.add(childAt);
                if (gVar != null) {
                    gVar.onMovedToScrapHeap(childAt);
                }
            }
        }
        this.mRecycler.cR(list);
        removeAllViewsInLayout();
    }

    public void setRecyclerListener(g gVar) {
        this.mRecycler.mIl = gVar;
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = -1, to = "ITEM_VIEW_TYPE_IGNORE"), @ViewDebug.IntToString(from = -2, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")})
        public int baa;
        @ViewDebug.ExportedProperty
        public boolean bab;
        @ViewDebug.ExportedProperty
        public boolean bac;
        public int bad;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.baa = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f {
        private int bap;
        private View[] baq = new View[0];
        private int bas;
        private g mIl;
        private Stack<View>[] mIm;
        private Stack<View> mIn;

        f() {
        }

        public void cM(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            Stack<View>[] stackArr = new Stack[i];
            for (int i2 = 0; i2 < i; i2++) {
                stackArr[i2] = new Stack<>();
            }
            this.bas = i;
            this.mIn = stackArr[0];
            this.mIm = stackArr;
        }

        public void GA() {
            if (this.bas == 1) {
                Stack<View> stack = this.mIn;
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    stack.get(i).forceLayout();
                }
                return;
            }
            int i2 = this.bas;
            for (int i3 = 0; i3 < i2; i3++) {
                Stack<View> stack2 = this.mIm[i3];
                int size2 = stack2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    stack2.get(i4).forceLayout();
                }
            }
        }

        public boolean cN(int i) {
            return i >= 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            if (this.bas == 1) {
                Stack<View> stack = this.mIn;
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    PLA_AbsListView.this.removeDetachedView(stack.remove((size - 1) - i), false);
                }
                return;
            }
            int i2 = this.bas;
            for (int i3 = 0; i3 < i2; i3++) {
                Stack<View> stack2 = this.mIm[i3];
                int size2 = stack2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    PLA_AbsListView.this.removeDetachedView(stack2.remove((size2 - 1) - i4), false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void F(int i, int i2) {
            if (this.baq.length < i) {
                this.baq = new View[i];
            }
            this.bap = i2;
            View[] viewArr = this.baq;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = PLA_AbsListView.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.baa != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View cO(int i) {
            int i2 = i - this.bap;
            View[] viewArr = this.baq;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View cQ(int i) {
            Stack<View> stack;
            com.huewu.pla.lib.a.i("getFromScrap: " + i);
            if (PLA_AbsListView.this.getHeaderViewsCount() > i) {
                return null;
            }
            if (this.bas == 1) {
                stack = this.mIn;
            } else {
                int itemViewType = PLA_AbsListView.this.mAdapter.getItemViewType(i);
                if (itemViewType < 0 || itemViewType >= this.mIm.length) {
                    return null;
                }
                stack = this.mIm[itemViewType];
            }
            int size = stack.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                if (((LayoutParams) stack.get(i2).getLayoutParams()).bad == i) {
                    return stack.remove(i2);
                }
            }
            if (size > 0) {
                return stack.remove(0);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dq(View view) {
            com.huewu.pla.lib.a.i("addToScrap");
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                int i = layoutParams.baa;
                if (!cN(i)) {
                    if (i != -2) {
                        PLA_AbsListView.this.removeDetachedView(view, false);
                        return;
                    }
                    return;
                }
                if (this.bas == 1) {
                    PLA_AbsListView.this.dispatchFinishTemporaryDetach(view);
                    this.mIn.add(view);
                } else {
                    PLA_AbsListView.this.dispatchFinishTemporaryDetach(view);
                    this.mIm[i].push(view);
                }
                if (this.mIl != null) {
                    this.mIl.onMovedToScrapHeap(view);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void GD() {
            View[] viewArr = this.baq;
            boolean z = this.mIl != null;
            boolean z2 = this.bas > 1;
            Stack<View> stack = this.mIn;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    int i = ((LayoutParams) view.getLayoutParams()).baa;
                    viewArr[length] = null;
                    if (!cN(i)) {
                        if (i != -2) {
                            PLA_AbsListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        Stack<View> stack2 = z2 ? this.mIm[i] : stack;
                        PLA_AbsListView.this.dispatchFinishTemporaryDetach(view);
                        com.huewu.pla.lib.a.i("addToScrap from scrapActiveViews");
                        stack2.add(view);
                        if (z) {
                            this.mIl.onMovedToScrapHeap(view);
                        }
                        stack = stack2;
                    }
                }
            }
            GE();
        }

        private void GE() {
            int length = this.baq.length;
            int i = this.bas;
            Stack<View>[] stackArr = this.mIm;
            for (int i2 = 0; i2 < i; i2++) {
                Stack<View> stack = stackArr[i2];
                int size = stack.size();
                int i3 = size - length;
                int i4 = size - 1;
                int i5 = 0;
                while (i5 < i3) {
                    com.huewu.pla.lib.a.i("remove scarp views from pruneScrapViews");
                    PLA_AbsListView.this.removeDetachedView(stack.remove(i4), false);
                    i5++;
                    i4--;
                }
            }
        }

        void cR(List<View> list) {
            if (this.bas == 1) {
                list.addAll(this.mIn);
                return;
            }
            int i = this.bas;
            Stack<View>[] stackArr = this.mIm;
            for (int i2 = 0; i2 < i; i2++) {
                Stack<View> stack = stackArr[i2];
                com.huewu.pla.lib.a.i("add scarp views from reclaimScrapViews");
                list.addAll(stack);
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bas == 1) {
                Stack<View> stack = this.mIn;
                int size = stack.size();
                for (int i2 = 0; i2 < size; i2++) {
                    stack.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bas;
                for (int i4 = 0; i4 < i3; i4++) {
                    Stack<View> stack2 = this.mIm[i4];
                    int size2 = stack2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        stack2.get(i4).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.baq) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFinishTemporaryDetach(View view) {
        if (view != null) {
            view.onFinishTemporaryDetach();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    dispatchFinishTemporaryDetach(viewGroup.getChildAt(i2));
                }
            }
        }
    }

    protected int modifyFlingInitialVelocity(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollChildTop() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getChildAt(0).getTop();
    }

    protected int getFirstChildTop() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getChildAt(0).getTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFillChildTop() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getChildAt(0).getTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFillChildBottom() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getChildAt(childCount - 1).getBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollChildBottom() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getChildAt(childCount - 1).getBottom();
    }

    /* loaded from: classes3.dex */
    static class h {
        long baw;
        int height;
        int mIo;
        int mIq;
        int[] mIr;
        int position;

        h() {
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        if (this.mPendingSync != null) {
            bundle.putLong("firstId", this.mPendingSync.baw);
            bundle.putInt("viewTop", this.mPendingSync.mIo);
            bundle.putIntArray("viewTops", this.mPendingSync.mIr);
            bundle.putInt("position", this.mPendingSync.position);
            bundle.putInt("height", this.mPendingSync.height);
            bundle.putInt("childCount", this.mPendingSync.mIq);
            return bundle;
        }
        bundle.putInt("height", getHeight());
        int childCount = getChildCount();
        bundle.putInt("childCount", childCount);
        if ((childCount > 0 && this.mItemCount > 0) && this.mFirstPosition > 0) {
            int i2 = this.mFirstPosition;
            if (i2 >= this.mItemCount) {
                i2 = this.mItemCount - 1;
            }
            bundle.putInt("position", i2);
            bundle.putLong("firstId", this.mAdapter.getItemId(i2));
            bundle.putInt("viewTop", getChildAt(0).getTop());
            int[] iArr = new int[childCount];
            for (int i3 = 0; i3 < childCount; i3++) {
                iArr[i3] = getChildAt(i3).getTop();
            }
            bundle.putIntArray("viewTops", iArr);
        } else {
            bundle.putInt("viewTop", 0);
            bundle.putLong("firstId", -1L);
            bundle.putInt("position", 0);
            bundle.putIntArray("viewTops", new int[1]);
        }
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mDataChanged = true;
            this.mSyncHeight = bundle.getInt("height");
            long j = bundle.getLong("firstId");
            if (j >= 0) {
                this.mNeedSync = true;
                h hVar = new h();
                hVar.baw = j;
                hVar.height = (int) this.mSyncHeight;
                hVar.position = bundle.getInt("position");
                hVar.mIo = bundle.getInt("viewTop");
                hVar.mIq = bundle.getInt("childCount");
                hVar.mIr = bundle.getIntArray("viewTops");
                this.mPendingSync = hVar;
                this.mSyncRowId = hVar.baw;
                this.mSyncPosition = hVar.position;
                this.mSpecificTop = hVar.mIo;
                this.mSpecificTops = hVar.mIr;
            }
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
        requestLayout();
    }
}
