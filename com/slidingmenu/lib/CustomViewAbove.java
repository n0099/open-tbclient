package com.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.baidu.tbadk.TbConfig;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CustomViewAbove extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final String TAG = "CustomViewAbove";
    private static final boolean USE_CACHE = false;
    private static int max_settle_duration = TbConfig.POST_IMAGE_SMALL;
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.slidingmenu.lib.CustomViewAbove.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    protected int mActivePointerId;
    private SlidingMenu.OnClosedListener mClosedListener;
    private View mContent;
    private int mCurItem;
    private long mCurrentTime;
    private boolean mEnabled;
    private int mFlingDistance;
    private List<View> mIgnoredViews;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    protected int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnPageChangeListener mOnPageChangeListener;
    private SlidingMenu.OnOpenedListener mOpenedListener;
    private boolean mQuickReturn;
    private float mScrollX;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    private SlidingMenu.CanvasTransformer mTransformer;
    protected VelocityTracker mVelocityTracker;
    private CustomViewBehind mViewBehind;

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public void setSettleDuration(int i) {
        max_settle_duration = i;
    }

    /* loaded from: classes.dex */
    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // com.slidingmenu.lib.CustomViewAbove.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.slidingmenu.lib.CustomViewAbove.OnPageChangeListener
        public void onPageSelected(int i) {
        }

        public void onPageScrollStateChanged(int i) {
        }
    }

    public CustomViewAbove(Context context) {
        this(context, null);
    }

    public CustomViewAbove(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mEnabled = true;
        this.mCurrentTime = 0L;
        this.mIgnoredViews = new ArrayList();
        this.mTouchMode = 0;
        this.mQuickReturn = false;
        this.mScrollX = 0.0f;
        initCustomViewAbove();
    }

    void initCustomViewAbove() {
        setWillNotDraw(false);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setInternalPageChangeListener(new SimpleOnPageChangeListener() { // from class: com.slidingmenu.lib.CustomViewAbove.2
            @Override // com.slidingmenu.lib.CustomViewAbove.SimpleOnPageChangeListener, com.slidingmenu.lib.CustomViewAbove.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CustomViewAbove.this.mViewBehind != null) {
                    switch (i) {
                        case 0:
                        case 2:
                            CustomViewAbove.this.mViewBehind.setChildrenEnabled(true);
                            return;
                        case 1:
                            CustomViewAbove.this.mViewBehind.setChildrenEnabled(false);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.mFlingDistance = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public void setCurrentItem(int i) {
        setCurrentItemInternal(i, true, false);
    }

    public void setCurrentItem(int i, boolean z) {
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (!z2 && this.mCurItem == i) {
            setScrollingCacheEnabled(false);
            return;
        }
        int menuPage = this.mViewBehind.getMenuPage(i);
        boolean z3 = this.mCurItem != menuPage;
        this.mCurItem = menuPage;
        int destScrollX = getDestScrollX(this.mCurItem);
        if (z3 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(menuPage);
        }
        if (z3 && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(menuPage);
        }
        if (z) {
            smoothScrollTo(destScrollX, 0, i2);
            return;
        }
        completeScroll();
        scrollTo(destScrollX, 0);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setOnOpenedListener(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.mOpenedListener = onOpenedListener;
    }

    public void setOnClosedListener(SlidingMenu.OnClosedListener onClosedListener) {
        this.mClosedListener = onClosedListener;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void addIgnoredView(View view) {
        if (!this.mIgnoredViews.contains(view)) {
            this.mIgnoredViews.add(view);
        }
    }

    public void removeIgnoredView(View view) {
        this.mIgnoredViews.remove(view);
    }

    public void clearIgnoredViews() {
        this.mIgnoredViews.clear();
    }

    float distanceInfluenceForSnapDuration(float f) {
        return FloatMath.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    public int getDestScrollX(int i) {
        switch (i) {
            case 0:
            case 2:
                return this.mViewBehind.getMenuLeft(this.mContent, i);
            case 1:
                return this.mContent.getLeft();
            default:
                return 0;
        }
    }

    private int getLeftBound() {
        return this.mViewBehind.getAbsLeftBound(this.mContent);
    }

    private int getRightBound() {
        return this.mViewBehind.getAbsRightBound(this.mContent);
    }

    public int getContentLeft() {
        return this.mContent.getLeft() + this.mContent.getPaddingLeft();
    }

    public boolean isMenuOpen() {
        return this.mCurItem == 0 || this.mCurItem == 2;
    }

    private boolean isInIgnoredView(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (View view : this.mIgnoredViews) {
            view.getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    public int getBehindWidth() {
        if (this.mViewBehind == null) {
            return 0;
        }
        return this.mViewBehind.getBehindWidth();
    }

    public int getChildWidth(int i) {
        switch (i) {
            case 0:
                return getBehindWidth();
            case 1:
                return this.mContent.getWidth();
            default:
                return 0;
        }
    }

    public boolean isSlidingEnabled() {
        return this.mEnabled;
    }

    public void setSlidingEnabled(boolean z) {
        this.mEnabled = z;
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll();
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                    return;
                }
                return;
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
                return;
            } else {
                return;
            }
        }
        setScrollingCacheEnabled(true);
        this.mScrolling = true;
        int behindWidth = getBehindWidth();
        int i7 = behindWidth / 2;
        float distanceInfluenceForSnapDuration = (i7 * distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i5) * 1.0f) / behindWidth))) + i7;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / abs)) * 4;
        } else {
            int abs2 = (int) (((Math.abs(i5) / behindWidth) + 1.0f) * 100.0f);
            i4 = max_settle_duration;
        }
        this.mScroller.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, max_settle_duration));
        invalidate();
    }

    public void setContent(View view) {
        if (this.mContent != null) {
            removeView(this.mContent);
        }
        this.mContent = view;
        addView(this.mContent);
    }

    public View getContent() {
        return this.mContent;
    }

    public void setCustomViewBehind(CustomViewBehind customViewBehind) {
        this.mViewBehind = customViewBehind;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.mContent.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            completeScroll();
            scrollTo(getDestScrollX(this.mCurItem), getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContent.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setAboveOffset(int i) {
        this.mContent.setPadding(i, this.mContent.getPaddingTop(), this.mContent.getPaddingRight(), this.mContent.getPaddingBottom());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                pageScrolled(currX);
            }
            invalidate();
            return;
        }
        completeScroll();
    }

    private void pageScrolled(int i) {
        int width = getWidth();
        int i2 = i % width;
        onPageScrolled(i / width, i2 / width, i2);
    }

    protected void onPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void completeScroll() {
        if (this.mScrolling) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                }
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
            }
        }
        this.mScrolling = false;
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    private boolean thisTouchAllowed(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + this.mScrollX);
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenTouchAllowed(this.mContent, this.mCurItem, x);
        }
        switch (this.mTouchMode) {
            case 0:
                return this.mViewBehind.marginTouchAllowed(this.mContent, x);
            case 1:
                return !isInIgnoredView(motionEvent);
            case 2:
            default:
                return false;
        }
    }

    private boolean thisSlideAllowed(float f) {
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenSlideAllowed(f);
        }
        return this.mViewBehind.menuClosedSlideAllowed(f);
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
            if (action == 3 || action == 1 || (action != 0 && this.mIsUnableToDrag)) {
                endDrag();
                return false;
            }
            switch (action) {
                case 0:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    if (this.mActivePointerId != -1) {
                        float x = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                        if (thisTouchAllowed(motionEvent)) {
                            this.mIsBeingDragged = false;
                            this.mIsUnableToDrag = false;
                            if (isMenuOpen() && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, motionEvent.getX() + this.mScrollX)) {
                                this.mQuickReturn = true;
                                break;
                            }
                        } else {
                            this.mIsUnableToDrag = true;
                            break;
                        }
                    }
                    break;
                case 2:
                    determineDrag(motionEvent);
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    break;
            }
            if (!this.mIsBeingDragged) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
            }
            return this.mIsBeingDragged || this.mQuickReturn;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            if (this.mIsBeingDragged || thisTouchAllowed(motionEvent)) {
                int action = motionEvent.getAction();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                switch (action & MotionEventCompat.ACTION_MASK) {
                    case 0:
                        this.mCurrentTime = System.currentTimeMillis();
                        completeScroll();
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                        float x = motionEvent.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        if (isMenuOpen()) {
                            startDrag();
                            break;
                        }
                        break;
                    case 1:
                        long currentTimeMillis = System.currentTimeMillis() - this.mCurrentTime;
                        if (isMenuOpen() && currentTimeMillis < 200) {
                            setCurrentItem(1);
                            endDrag();
                            break;
                        } else if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                            float scrollX = (getScrollX() - getDestScrollX(this.mCurItem)) / getBehindWidth();
                            int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                            if (this.mActivePointerId != -1) {
                                setCurrentItemInternal(determineTargetPage(scrollX, xVelocity, (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mInitialMotionX)), true, true, xVelocity);
                            } else {
                                setCurrentItemInternal(this.mCurItem, true, true, xVelocity);
                            }
                            this.mActivePointerId = -1;
                            endDrag();
                            break;
                        } else if (this.mQuickReturn && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, motionEvent.getX() + this.mScrollX)) {
                            setCurrentItem(1);
                            endDrag();
                            break;
                        }
                        break;
                    case 2:
                        if (!this.mIsBeingDragged) {
                            determineDrag(motionEvent);
                            if (this.mIsUnableToDrag) {
                                return false;
                            }
                        }
                        if (this.mIsBeingDragged) {
                            int pointerIndex2 = getPointerIndex(motionEvent, this.mActivePointerId);
                            if (this.mActivePointerId != -1) {
                                float x2 = MotionEventCompat.getX(motionEvent, pointerIndex2);
                                float f = this.mLastMotionX - x2;
                                this.mLastMotionX = x2;
                                float scrollX2 = getScrollX() + f;
                                float leftBound = getLeftBound();
                                float rightBound = getRightBound();
                                if (scrollX2 >= leftBound) {
                                    leftBound = scrollX2 > rightBound ? rightBound : scrollX2;
                                }
                                this.mLastMotionX += leftBound - ((int) leftBound);
                                scrollTo((int) leftBound, getScrollY());
                                pageScrolled((int) leftBound);
                                break;
                            }
                        }
                        break;
                    case 3:
                        if (this.mIsBeingDragged) {
                            setCurrentItemInternal(this.mCurItem, true, true);
                            this.mActivePointerId = -1;
                            endDrag();
                            break;
                        }
                        break;
                    case 5:
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        break;
                    case 6:
                        onSecondaryPointerUp(motionEvent);
                        int pointerIndex3 = getPointerIndex(motionEvent, this.mActivePointerId);
                        if (this.mActivePointerId != -1) {
                            this.mLastMotionX = MotionEventCompat.getX(motionEvent, pointerIndex3);
                            break;
                        }
                        break;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float f = x - this.mLastMotionX;
                float abs = Math.abs(f);
                float abs2 = Math.abs(y - this.mLastMotionY);
                if (abs > (isMenuOpen() ? this.mTouchSlop / 2 : this.mTouchSlop) && abs > abs2 && thisSlideAllowed(f)) {
                    startDrag();
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    setScrollingCacheEnabled(true);
                } else if (abs > this.mTouchSlop) {
                    this.mIsUnableToDrag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.mScrollX = i;
        this.mViewBehind.scrollBehindTo(this.mContent, i, i2);
        ((SlidingMenu) getParent()).manageLayers(getPercentOpen());
    }

    private int determineTargetPage(float f, int i, int i2) {
        int i3 = this.mCurItem;
        if (Math.abs(i2) > this.mFlingDistance && Math.abs(i) > this.mMinimumVelocity) {
            if (i > 0 && i2 > 0) {
                return i3 - 1;
            }
            if (i < 0 && i2 < 0) {
                return i3 + 1;
            }
            return i3;
        }
        return Math.round(this.mCurItem + f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getPercentOpen() {
        return Math.abs(this.mScrollX - this.mContent.getLeft()) / getBehindWidth();
    }

    public void setCanvasTransformer(SlidingMenu.CanvasTransformer canvasTransformer) {
        this.mTransformer = canvasTransformer;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewBehind.drawFade(this.mContent, canvas, getPercentOpen());
        if (this.mTransformer != null) {
            canvas.save();
            this.mTransformer.transformCanvas(canvas, getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
        } else {
            super.dispatchDraw(canvas);
        }
        this.mViewBehind.drawShadow(this.mContent, canvas);
        this.mViewBehind.drawSelector(this.mContent, canvas, getPercentOpen());
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void startDrag() {
        this.mIsBeingDragged = true;
        this.mQuickReturn = false;
    }

    private void endDrag() {
        this.mQuickReturn = false;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return arrowScroll(2);
                }
                if (!KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return false;
                }
                return arrowScroll(1);
            default:
                return false;
        }
    }

    public boolean arrowScroll(int i) {
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null && findNextFocus != findFocus) {
            if (i == 17) {
                pageLeft = findNextFocus.requestFocus();
            } else {
                if (i == 66) {
                    if (findFocus != null && findNextFocus.getLeft() <= findFocus.getLeft()) {
                        pageLeft = pageRight();
                    } else {
                        pageLeft = findNextFocus.requestFocus();
                    }
                }
                pageLeft = false;
            }
        } else if (i == 17 || i == 1) {
            pageLeft = pageLeft();
        } else {
            if (i == 66 || i == 2) {
                pageLeft = pageRight();
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    boolean pageLeft() {
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        if (this.mCurItem < 1) {
            setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }
}
