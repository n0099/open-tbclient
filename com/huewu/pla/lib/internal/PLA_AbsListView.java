package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes6.dex */
public abstract class PLA_AbsListView extends PLA_AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public static final int LAYOUT_FORCE_BOTTOM = 3;
    public static final int LAYOUT_FORCE_TOP = 1;
    public static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_SET_SELECTION = 2;
    public static final int LAYOUT_SPECIFIC = 4;
    public static final int LAYOUT_SYNC = 5;
    public static final boolean PROFILE_FLINGING = false;
    public static final boolean PROFILE_SCROLLING = false;
    public static final String TAG = "PLA_AbsListView";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    public static final int TOUCH_MODE_OFF = 1;
    public static final int TOUCH_MODE_ON = 0;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    public static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public ListAdapter mAdapter;
    public int mCacheColorHint;
    public boolean mCachingStarted;
    public Runnable mClearScrollingCache;
    public ContextMenu.ContextMenuInfo mContextMenuInfo;
    public PLA_AdapterView<ListAdapter>.c mDataSetObserver;
    public boolean mDrawSelectorOnTop;
    public boolean mFlingProfilingStarted;
    public d mFlingRunnable;
    public boolean mIsChildViewEnabled;
    public final boolean[] mIsScrap;
    public int mLastScrollState;
    public int mLastTouchMode;
    public int mLastY;
    public int mLayoutMode;
    public Rect mListPadding;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mMotionCorrection;
    public int mMotionPosition;
    public int mMotionViewNewTop;
    public int mMotionViewOriginalTop;
    public int mMotionX;
    public int mMotionY;
    public e mOnScrollListener;
    public Runnable mPendingCheckForTap;
    public j mPendingSync;
    public f mPerformClick;
    public g mPositionScroller;
    public final h mRecycler;
    public int mResurrectToPosition;
    public boolean mScrollProfilingStarted;
    public boolean mScrollingCacheEnabled;
    public int mSelectedTop;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public Drawable mSelector;
    public Rect mSelectorRect;
    public boolean mSmoothScrollbarEnabled;
    public boolean mStackFromBottom;
    public Rect mTouchFrame;
    public int mTouchMode;
    public int mTouchSlop;
    public int mTranscriptMode;
    public VelocityTracker mVelocityTracker;
    public int mWidthMeasureSpec;

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = -1, to = "ITEM_VIEW_TYPE_IGNORE"), @ViewDebug.IntToString(from = -2, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")})

        /* renamed from: a  reason: collision with root package name */
        public int f33599a;

        /* renamed from: b  reason: collision with root package name */
        public int f33600b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public boolean f33601c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f33602d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33599a = i4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f33603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f33604f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33605g;

        public a(PLA_AbsListView pLA_AbsListView, View view, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33605g = pLA_AbsListView;
            this.f33603e = view;
            this.f33604f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33603e.setPressed(false);
                this.f33605g.setPressed(false);
                PLA_AbsListView pLA_AbsListView = this.f33605g;
                if (!pLA_AbsListView.mDataChanged) {
                    pLA_AbsListView.post(this.f33604f);
                }
                this.f33605g.mTouchMode = -1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33606e;

        public b(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33606e = pLA_AbsListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PLA_AbsListView pLA_AbsListView = this.f33606e;
                if (pLA_AbsListView.mCachingStarted) {
                    pLA_AbsListView.mCachingStarted = false;
                    pLA_AbsListView.setChildrenDrawnWithCacheEnabled(false);
                    if ((this.f33606e.getPersistentDrawingCache() & 2) == 0) {
                        this.f33606e.setChildrenDrawingCacheEnabled(false);
                    }
                    if (this.f33606e.isAlwaysDrawnWithCacheEnabled()) {
                        return;
                    }
                    this.f33606e.invalidate();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33607e;

        public c(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33607e = pLA_AbsListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PLA_AbsListView pLA_AbsListView = this.f33607e;
                if (pLA_AbsListView.mTouchMode == 0) {
                    pLA_AbsListView.mTouchMode = 1;
                    View childAt = pLA_AbsListView.getChildAt(pLA_AbsListView.mMotionPosition - pLA_AbsListView.mFirstPosition);
                    if (childAt == null || childAt.hasFocusable()) {
                        return;
                    }
                    PLA_AbsListView pLA_AbsListView2 = this.f33607e;
                    pLA_AbsListView2.mLayoutMode = 0;
                    if (!pLA_AbsListView2.mDataChanged) {
                        pLA_AbsListView2.layoutChildren();
                        childAt.setPressed(true);
                        this.f33607e.positionSelector(childAt);
                        this.f33607e.setPressed(true);
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = this.f33607e.isLongClickable();
                        Drawable drawable = this.f33607e.mSelector;
                        if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            return;
                        }
                        this.f33607e.mTouchMode = 2;
                        return;
                    }
                    pLA_AbsListView2.mTouchMode = 2;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Scroller f33608e;

        /* renamed from: f  reason: collision with root package name */
        public int f33609f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33610g;

        public d(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33610g = pLA_AbsListView;
            this.f33608e = new Scroller(pLA_AbsListView.getContext());
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33609f = 0;
                PLA_AbsListView pLA_AbsListView = this.f33610g;
                pLA_AbsListView.mTouchMode = -1;
                pLA_AbsListView.reportScrollStateChange(0);
                this.f33610g.clearScrollingCache();
                this.f33610g.removeCallbacks(this);
                PLA_AbsListView pLA_AbsListView2 = this.f33610g;
                g gVar = pLA_AbsListView2.mPositionScroller;
                if (gVar != null) {
                    pLA_AbsListView2.removeCallbacks(gVar);
                }
                this.f33608e.forceFinished(true);
            }
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int modifyFlingInitialVelocity = this.f33610g.modifyFlingInitialVelocity(i2);
                int i3 = modifyFlingInitialVelocity < 0 ? Integer.MAX_VALUE : 0;
                this.f33609f = i3;
                this.f33608e.fling(0, i3, 0, modifyFlingInitialVelocity, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                PLA_AbsListView pLA_AbsListView = this.f33610g;
                pLA_AbsListView.mTouchMode = 4;
                pLA_AbsListView.post(this);
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                int i4 = i2 < 0 ? Integer.MAX_VALUE : 0;
                this.f33609f = i4;
                this.f33608e.startScroll(0, i4, 0, i2, i3);
                PLA_AbsListView pLA_AbsListView = this.f33610g;
                pLA_AbsListView.mTouchMode = 4;
                pLA_AbsListView.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                PLA_AbsListView pLA_AbsListView = this.f33610g;
                if (pLA_AbsListView.mTouchMode != 4) {
                    return;
                }
                if (pLA_AbsListView.mItemCount != 0 && pLA_AbsListView.getChildCount() != 0) {
                    Scroller scroller = this.f33608e;
                    boolean computeScrollOffset = scroller.computeScrollOffset();
                    int currY = scroller.getCurrY();
                    int i2 = this.f33609f - currY;
                    if (i2 > 0) {
                        PLA_AbsListView pLA_AbsListView2 = this.f33610g;
                        pLA_AbsListView2.mMotionPosition = pLA_AbsListView2.mFirstPosition;
                        pLA_AbsListView2.mMotionViewOriginalTop = pLA_AbsListView2.getScrollChildTop();
                        max = Math.min(((this.f33610g.getHeight() - this.f33610g.getPaddingBottom()) - this.f33610g.getPaddingTop()) - 1, i2);
                    } else {
                        PLA_AbsListView pLA_AbsListView3 = this.f33610g;
                        pLA_AbsListView3.mMotionPosition = pLA_AbsListView3.mFirstPosition + (this.f33610g.getChildCount() - 1);
                        pLA_AbsListView3.mMotionViewOriginalTop = pLA_AbsListView3.getScrollChildBottom();
                        max = Math.max(-(((this.f33610g.getHeight() - this.f33610g.getPaddingBottom()) - this.f33610g.getPaddingTop()) - 1), i2);
                    }
                    boolean trackMotionScroll = this.f33610g.trackMotionScroll(max, max);
                    if (computeScrollOffset && !trackMotionScroll) {
                        this.f33610g.invalidate();
                        this.f33609f = currY;
                        this.f33610g.post(this);
                        return;
                    }
                    b();
                    return;
                }
                b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i3, int i4);

        void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2);
    }

    /* loaded from: classes6.dex */
    public class f extends k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public View f33611g;

        /* renamed from: h  reason: collision with root package name */
        public int f33612h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33613i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PLA_AbsListView pLA_AbsListView) {
            super(pLA_AbsListView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((PLA_AbsListView) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33613i = pLA_AbsListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PLA_AbsListView pLA_AbsListView = this.f33613i;
                if (pLA_AbsListView.mDataChanged) {
                    return;
                }
                ListAdapter listAdapter = pLA_AbsListView.mAdapter;
                int i2 = this.f33612h;
                if (listAdapter == null || pLA_AbsListView.mItemCount <= 0 || i2 == -1 || i2 >= listAdapter.getCount() || !b()) {
                    return;
                }
                this.f33613i.performItemClick(this.f33611g, i2, listAdapter.getItemId(i2));
            }
        }

        public /* synthetic */ f(PLA_AbsListView pLA_AbsListView, a aVar) {
            this(pLA_AbsListView);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f33614e;

        /* renamed from: f  reason: collision with root package name */
        public int f33615f;

        /* renamed from: g  reason: collision with root package name */
        public int f33616g;

        /* renamed from: h  reason: collision with root package name */
        public int f33617h;

        /* renamed from: i  reason: collision with root package name */
        public int f33618i;
        public final int j;
        public final /* synthetic */ PLA_AbsListView k;

        public g(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = pLA_AbsListView;
            this.j = ViewConfiguration.get(pLA_AbsListView.getContext()).getScaledFadingEdgeLength();
        }

        public void a(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                PLA_AbsListView pLA_AbsListView = this.k;
                int i4 = pLA_AbsListView.mFirstPosition;
                int childCount = (pLA_AbsListView.getChildCount() + i4) - 1;
                if (i2 <= i4) {
                    i3 = (i4 - i2) + 1;
                    this.f33614e = 2;
                } else if (i2 < childCount) {
                    return;
                } else {
                    i3 = (i2 - childCount) + 1;
                    this.f33614e = 1;
                }
                if (i3 > 0) {
                    this.f33618i = 400 / i3;
                } else {
                    this.f33618i = 400;
                }
                this.f33615f = i2;
                this.f33616g = -1;
                this.f33617h = -1;
                this.k.post(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0046  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (i3 == -1) {
                    a(i2);
                    return;
                }
                PLA_AbsListView pLA_AbsListView = this.k;
                int i7 = pLA_AbsListView.mFirstPosition;
                int childCount = (pLA_AbsListView.getChildCount() + i7) - 1;
                if (i2 > i7) {
                    if (i2 < childCount || (i4 = i3 - i7) < 1) {
                        return;
                    }
                    i5 = (i2 - childCount) + 1;
                    i6 = i4 - 1;
                    if (i6 < i5) {
                        this.f33614e = 3;
                        if (i6 <= 0) {
                        }
                        this.f33615f = i2;
                        this.f33616g = i3;
                        this.f33617h = -1;
                        this.k.post(this);
                    }
                    this.f33614e = 1;
                    i6 = i5;
                    if (i6 <= 0) {
                    }
                    this.f33615f = i2;
                    this.f33616g = i3;
                    this.f33617h = -1;
                    this.k.post(this);
                }
                int i8 = childCount - i3;
                if (i8 < 1) {
                    return;
                }
                i6 = (i7 - i2) + 1;
                i5 = i8 - 1;
                if (i5 < i6) {
                    this.f33614e = 4;
                    i6 = i5;
                    if (i6 <= 0) {
                        this.f33618i = 400 / i6;
                    } else {
                        this.f33618i = 400;
                    }
                    this.f33615f = i2;
                    this.f33616g = i3;
                    this.f33617h = -1;
                    this.k.post(this);
                }
                this.f33614e = 2;
                if (i6 <= 0) {
                }
                this.f33615f = i2;
                this.f33616g = i3;
                this.f33617h = -1;
                this.k.post(this);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.k.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int height = this.k.getHeight();
                PLA_AbsListView pLA_AbsListView = this.k;
                int i2 = pLA_AbsListView.mFirstPosition;
                int i3 = this.f33614e;
                if (i3 == 1) {
                    int childCount2 = pLA_AbsListView.getChildCount() - 1;
                    int i4 = i2 + childCount2;
                    if (childCount2 < 0) {
                        return;
                    }
                    if (i4 == this.f33617h) {
                        this.k.post(this);
                        return;
                    }
                    View childAt = this.k.getChildAt(childCount2);
                    int height2 = childAt.getHeight();
                    int top = height - childAt.getTop();
                    PLA_AbsListView pLA_AbsListView2 = this.k;
                    this.k.smoothScrollBy((height2 - top) + (i4 < pLA_AbsListView2.mItemCount - 1 ? this.j : pLA_AbsListView2.mListPadding.bottom), this.f33618i);
                    this.f33617h = i4;
                    if (i4 < this.f33615f) {
                        this.k.post(this);
                    }
                } else if (i3 == 2) {
                    if (i2 == this.f33617h) {
                        pLA_AbsListView.post(this);
                        return;
                    }
                    View childAt2 = pLA_AbsListView.getChildAt(0);
                    if (childAt2 == null) {
                        return;
                    }
                    this.k.smoothScrollBy(childAt2.getTop() - (i2 > 0 ? this.j : this.k.mListPadding.top), this.f33618i);
                    this.f33617h = i2;
                    if (i2 > this.f33615f) {
                        this.k.post(this);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4 && (childCount = pLA_AbsListView.getChildCount() - 2) >= 0) {
                        int i5 = i2 + childCount;
                        if (i5 == this.f33617h) {
                            this.k.post(this);
                            return;
                        }
                        View childAt3 = this.k.getChildAt(childCount);
                        int height3 = childAt3.getHeight();
                        int top2 = childAt3.getTop();
                        int i6 = height - top2;
                        this.f33617h = i5;
                        if (i5 > this.f33616g) {
                            this.k.smoothScrollBy(-(i6 - this.j), this.f33618i);
                            this.k.post(this);
                            return;
                        }
                        int i7 = height - this.j;
                        int i8 = top2 + height3;
                        if (i7 > i8) {
                            this.k.smoothScrollBy(-(i7 - i8), this.f33618i);
                        }
                    }
                } else {
                    int childCount3 = pLA_AbsListView.getChildCount();
                    if (i2 == this.f33616g || childCount3 <= 1) {
                        return;
                    }
                    int i9 = childCount3 + i2;
                    PLA_AbsListView pLA_AbsListView3 = this.k;
                    if (i9 >= pLA_AbsListView3.mItemCount) {
                        return;
                    }
                    int i10 = i2 + 1;
                    if (i10 == this.f33617h) {
                        pLA_AbsListView3.post(this);
                        return;
                    }
                    View childAt4 = pLA_AbsListView3.getChildAt(1);
                    int height4 = childAt4.getHeight();
                    int top3 = childAt4.getTop();
                    int i11 = this.j;
                    if (i10 < this.f33616g) {
                        this.k.smoothScrollBy(Math.max(0, (height4 + top3) - i11), this.f33618i);
                        this.f33617h = i10;
                        this.k.post(this);
                    } else if (top3 > i11) {
                        this.k.smoothScrollBy(top3 - i11, this.f33618i);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public i f33619a;

        /* renamed from: b  reason: collision with root package name */
        public int f33620b;

        /* renamed from: c  reason: collision with root package name */
        public View[] f33621c;

        /* renamed from: d  reason: collision with root package name */
        public Stack<View>[] f33622d;

        /* renamed from: e  reason: collision with root package name */
        public int f33623e;

        /* renamed from: f  reason: collision with root package name */
        public Stack<View> f33624f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33625g;

        public h(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33625g = pLA_AbsListView;
            this.f33621c = new View[0];
        }

        public void c(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.g.a.a.a.c("addToScrap");
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                int i2 = layoutParams.f33599a;
                if (!n(i2)) {
                    if (i2 != -2) {
                        this.f33625g.removeDetachedView(view, false);
                        return;
                    }
                    return;
                }
                if (this.f33623e == 1) {
                    this.f33625g.dispatchFinishTemporaryDetach(view);
                    this.f33624f.add(view);
                } else {
                    this.f33625g.dispatchFinishTemporaryDetach(view);
                    this.f33622d[i2].push(view);
                }
                i iVar = this.f33619a;
                if (iVar != null) {
                    iVar.onMovedToScrapHeap(view);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f33623e;
                if (i2 == 1) {
                    Stack<View> stack = this.f33624f;
                    int size = stack.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        this.f33625g.removeDetachedView(stack.remove((size - 1) - i3), false);
                    }
                    return;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Stack<View> stack2 = this.f33622d[i4];
                    int size2 = stack2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        this.f33625g.removeDetachedView(stack2.remove((size2 - 1) - i5), false);
                    }
                }
            }
        }

        public void e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                if (this.f33621c.length < i2) {
                    this.f33621c = new View[i2];
                }
                this.f33620b = i3;
                View[] viewArr = this.f33621c;
                for (int i4 = 0; i4 < i2; i4++) {
                    View childAt = this.f33625g.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams != null && layoutParams.f33599a != -2) {
                        viewArr[i4] = childAt;
                    }
                }
            }
        }

        public View f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = i2 - this.f33620b;
                View[] viewArr = this.f33621c;
                if (i3 < 0 || i3 >= viewArr.length) {
                    return null;
                }
                View view = viewArr[i3];
                viewArr[i3] = null;
                return view;
            }
            return (View) invokeI.objValue;
        }

        public View g(int i2) {
            InterceptResult invokeI;
            Stack<View> stack;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                d.g.a.a.a.c("getFromScrap: " + i2);
                if (this.f33625g.getHeaderViewsCount() > i2) {
                    return null;
                }
                if (this.f33623e == 1) {
                    stack = this.f33624f;
                } else {
                    int itemViewType = this.f33625g.mAdapter.getItemViewType(i2);
                    if (itemViewType >= 0) {
                        Stack<View>[] stackArr = this.f33622d;
                        if (itemViewType < stackArr.length) {
                            stack = stackArr[itemViewType];
                        }
                    }
                    return null;
                }
                int size = stack.size();
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    if (((LayoutParams) stack.get(i3).getLayoutParams()).f33600b == i2) {
                        return stack.remove(i3);
                    }
                }
                if (size > 0) {
                    return stack.remove(0);
                }
                return null;
            }
            return (View) invokeI.objValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f33623e;
                if (i2 == 1) {
                    Stack<View> stack = this.f33624f;
                    int size = stack.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        stack.get(i3).forceLayout();
                    }
                    return;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Stack<View> stack2 = this.f33622d[i4];
                    int size2 = stack2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        stack2.get(i5).forceLayout();
                    }
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                int length = this.f33621c.length;
                int i2 = this.f33623e;
                Stack<View>[] stackArr = this.f33622d;
                for (int i3 = 0; i3 < i2; i3++) {
                    Stack<View> stack = stackArr[i3];
                    int size = stack.size();
                    int i4 = size - length;
                    int i5 = size - 1;
                    int i6 = 0;
                    while (i6 < i4) {
                        d.g.a.a.a.c("remove scarp views from pruneScrapViews");
                        this.f33625g.removeDetachedView(stack.remove(i5), false);
                        i6++;
                        i5--;
                    }
                }
            }
        }

        public void j(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
                int i2 = this.f33623e;
                if (i2 == 1) {
                    list.addAll(this.f33624f);
                    return;
                }
                Stack<View>[] stackArr = this.f33622d;
                for (int i3 = 0; i3 < i2; i3++) {
                    Stack<View> stack = stackArr[i3];
                    d.g.a.a.a.c("add scarp views from reclaimScrapViews");
                    list.addAll(stack);
                }
            }
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                View[] viewArr = this.f33621c;
                boolean z = this.f33619a != null;
                boolean z2 = this.f33623e > 1;
                Stack<View> stack = this.f33624f;
                for (int length = viewArr.length - 1; length >= 0; length--) {
                    View view = viewArr[length];
                    if (view != null) {
                        int i2 = ((LayoutParams) view.getLayoutParams()).f33599a;
                        viewArr[length] = null;
                        if (n(i2)) {
                            if (z2) {
                                stack = this.f33622d[i2];
                            }
                            this.f33625g.dispatchFinishTemporaryDetach(view);
                            d.g.a.a.a.c("addToScrap from scrapActiveViews");
                            stack.add(view);
                            if (z) {
                                this.f33619a.onMovedToScrapHeap(view);
                            }
                        } else if (i2 != -2) {
                            this.f33625g.removeDetachedView(view, false);
                        }
                    }
                }
                i();
            }
        }

        public void l(int i2) {
            View[] viewArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                int i3 = this.f33623e;
                if (i3 == 1) {
                    Stack<View> stack = this.f33624f;
                    int size = stack.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        stack.get(i4).setDrawingCacheBackgroundColor(i2);
                    }
                } else {
                    for (int i5 = 0; i5 < i3; i5++) {
                        Stack<View> stack2 = this.f33622d[i5];
                        int size2 = stack2.size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            stack2.get(i5).setDrawingCacheBackgroundColor(i2);
                        }
                    }
                }
                for (View view : this.f33621c) {
                    if (view != null) {
                        view.setDrawingCacheBackgroundColor(i2);
                    }
                }
            }
        }

        public void m(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                if (i2 >= 1) {
                    Stack<View>[] stackArr = new Stack[i2];
                    for (int i3 = 0; i3 < i2; i3++) {
                        stackArr[i3] = new Stack<>();
                    }
                    this.f33623e = i2;
                    this.f33624f = stackArr[0];
                    this.f33622d = stackArr;
                    return;
                }
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
        }

        public boolean n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 >= 0 : invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface i {
        void onMovedToScrapHeap(View view);
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f33626a;

        /* renamed from: b  reason: collision with root package name */
        public int f33627b;

        /* renamed from: c  reason: collision with root package name */
        public int f33628c;

        /* renamed from: d  reason: collision with root package name */
        public int f33629d;

        /* renamed from: e  reason: collision with root package name */
        public int f33630e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f33631f;

        public j() {
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
    }

    /* loaded from: classes6.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f33632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PLA_AbsListView f33633f;

        public k(PLA_AbsListView pLA_AbsListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pLA_AbsListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33633f = pLA_AbsListView;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33632e = this.f33633f.getWindowAttachCount();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33633f.hasWindowFocus() && this.f33633f.getWindowAttachCount() == this.f33632e : invokeV.booleanValue;
        }

        public /* synthetic */ k(PLA_AbsListView pLA_AbsListView, a aVar) {
            this(pLA_AbsListView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PLA_AbsListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorRect = new Rect();
        this.mRecycler = new h(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.View);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.mClearScrollingCache == null) {
                this.mClearScrollingCache = new b(this);
            }
            post(this.mClearScrollingCache);
        }
    }

    private void createScrollingCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.mScrollingCacheEnabled && !this.mCachingStarted) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.mCachingStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFinishTemporaryDetach(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, view) == null) || view == null) {
            return;
        }
        view.onFinishTemporaryDetach();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                dispatchFinishTemporaryDetach(viewGroup.getChildAt(i2));
            }
        }
    }

    private void drawSelector(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, canvas) == null) || !shouldShowSelector() || (rect = this.mSelectorRect) == null || rect.isEmpty()) {
            return;
        }
        Drawable drawable = this.mSelector;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    public static int getDistance(Rect rect, Rect rect2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        int height;
        int i4;
        int i5;
        int height2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, null, rect, rect2, i2)) == null) {
            if (i2 != 17) {
                if (i2 == 33) {
                    i3 = rect.left + (rect.width() / 2);
                    height = rect.top;
                    i4 = rect2.left + (rect2.width() / 2);
                    i6 = rect2.bottom;
                } else if (i2 == 66) {
                    i3 = rect.right;
                    height = (rect.height() / 2) + rect.top;
                    i4 = rect2.left;
                    i5 = rect2.top;
                    height2 = rect2.height() / 2;
                } else if (i2 == 130) {
                    i3 = rect.left + (rect.width() / 2);
                    height = rect.bottom;
                    i4 = rect2.left + (rect2.width() / 2);
                    i6 = rect2.top;
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i7 = i4 - i3;
                int i8 = i6 - height;
                return (i8 * i8) + (i7 * i7);
            }
            i3 = rect.left;
            height = (rect.height() / 2) + rect.top;
            i4 = rect2.right;
            i5 = rect2.top;
            height2 = rect2.height() / 2;
            i6 = height2 + i5;
            int i72 = i4 - i3;
            int i82 = i6 - height;
            return (i82 * i82) + (i72 * i72);
        }
        return invokeLLI.intValue;
    }

    private void initAbsListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
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
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, motionEvent) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            if (motionEvent.getPointerId(action) == this.mActivePointerId) {
                int i2 = action == 0 ? 1 : 0;
                this.mMotionX = (int) motionEvent.getX(i2);
                this.mMotionY = (int) motionEvent.getY(i2);
                this.mActivePointerId = motionEvent.getPointerId(i2);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    private boolean startScrollIfNeeded(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, this, i2)) == null) {
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
        return invokeI.booleanValue;
    }

    private void useDefaultSelector() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            setSelector(getResources().getDrawable(17301602));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            int childCount = getChildCount();
            int i2 = this.mFirstPosition;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
                    return height2 > 0 ? i2 - (((scrollChildBottom - getHeight()) * 100) / height2) : i2;
                }
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.mFirstPosition;
            int childCount = getChildCount();
            int i3 = 0;
            if (i2 >= 0 && childCount > 0) {
                if (this.mSmoothScrollbarEnabled) {
                    View childAt = getChildAt(0);
                    int fillChildTop = getFillChildTop();
                    int height = childAt.getHeight();
                    if (height > 0) {
                        return Math.max(((i2 * 100) - ((fillChildTop * 100) / height)) + ((int) ((getScrollY() / getHeight()) * this.mItemCount * 100.0f)), 0);
                    }
                } else {
                    int i4 = this.mItemCount;
                    if (i2 != 0) {
                        i3 = i2 + childCount == i4 ? i4 : (childCount / 2) + i2;
                    }
                    return (int) (i2 + (childCount * (i3 / i4)));
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mSmoothScrollbarEnabled) {
                return Math.max(this.mItemCount * 100, 0);
            }
            return this.mItemCount;
        }
        return invokeV.intValue;
    }

    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? new PLA_AdapterView.b(view, i2, j2) : (ContextMenu.ContextMenuInfo) invokeCommon.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            boolean z = this.mDrawSelectorOnTop;
            if (!z) {
                drawSelector(canvas);
            }
            super.dispatchDraw(canvas);
            if (z) {
                drawSelector(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.mSelector;
            if (drawable != null) {
                drawable.setState(getDrawableState());
            }
        }
    }

    public abstract void fillGap(boolean z);

    public int findClosestMotionRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return -1;
            }
            int findMotionRow = findMotionRow(i2);
            return findMotionRow != -1 ? findMotionRow : (this.mFirstPosition + childCount) - 1;
        }
        return invokeI.intValue;
    }

    public abstract int findMotionRow(int i2);

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int childCount = getChildCount();
            float bottomFadingEdgeStrength = super.getBottomFadingEdgeStrength();
            if (childCount == 0) {
                return bottomFadingEdgeStrength;
            }
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int bottom = getChildAt(childCount - 1).getBottom();
            int height = getHeight();
            return bottom > height - getPaddingBottom() ? ((bottom - height) + getPaddingBottom()) / getVerticalFadingEdgeLength() : bottomFadingEdgeStrength;
        }
        return invokeV.floatValue;
    }

    public int getCacheColorHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mCacheColorHint : invokeV.intValue;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mContextMenuInfo : (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    public int getFillChildBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return 0;
            }
            return getChildAt(childCount - 1).getBottom();
        }
        return invokeV.intValue;
    }

    public int getFillChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return getChildAt(0).getTop();
        }
        return invokeV.intValue;
    }

    public int getFirstChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return getChildAt(0).getTop();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            View selectedView = getSelectedView();
            if (selectedView != null && selectedView.getParent() == this) {
                selectedView.getFocusedRect(rect);
                offsetDescendantRectToMyCoords(selectedView, rect);
                return;
            }
            super.getFocusedRect(rect);
        }
    }

    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getListPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mListPadding.bottom : invokeV.intValue;
    }

    public int getListPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mListPadding.left : invokeV.intValue;
    }

    public int getListPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mListPadding.right : invokeV.intValue;
    }

    public int getListPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mListPadding.top : invokeV.intValue;
    }

    public int getScrollChildBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return 0;
            }
            return getChildAt(childCount - 1).getBottom();
        }
        return invokeV.intValue;
    }

    public int getScrollChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            return getChildAt(0).getTop();
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mSelector : (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public int getSolidColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mCacheColorHint : invokeV.intValue;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int childCount = getChildCount();
            float topFadingEdgeStrength = super.getTopFadingEdgeStrength();
            if (childCount == 0) {
                return topFadingEdgeStrength;
            }
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int top = getChildAt(0).getTop();
            return top < getPaddingTop() ? (-(top - getPaddingTop())) / getVerticalFadingEdgeLength() : topFadingEdgeStrength;
        }
        return invokeV.floatValue;
    }

    public int getTranscriptMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mTranscriptMode : invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void handleDataChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            int i2 = this.mItemCount;
            if (i2 > 0) {
                if (this.mNeedSync) {
                    this.mNeedSync = false;
                    this.mPendingSync = null;
                    int i3 = this.mTranscriptMode;
                    if (i3 != 2 && (i3 != 1 || this.mFirstPosition + getChildCount() < this.mOldItemCount)) {
                        int i4 = this.mSyncMode;
                        if (i4 != 0) {
                            if (i4 == 1) {
                                this.mLayoutMode = 5;
                                this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                                return;
                            }
                        } else if (isInTouchMode()) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                            return;
                        } else {
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
                        }
                    } else {
                        this.mLayoutMode = 3;
                        return;
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
    }

    public void invalidateViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            d.g.a.a.a.a("data changed by invalidateViews()");
            this.mDataChanged = true;
            rememberSyncState();
            requestLayout();
            invalidate();
        }
    }

    public void invokeOnItemScrollListener() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (eVar = this.mOnScrollListener) == null) {
            return;
        }
        eVar.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mScrollingCacheEnabled : invokeV.booleanValue;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mSmoothScrollbarEnabled : invokeV.booleanValue;
    }

    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mStackFromBottom : invokeV.booleanValue;
    }

    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public int modifyFlingInitialVelocity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    public View obtainView(int i2, boolean[] zArr) {
        InterceptResult invokeIL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048619, this, i2, zArr)) == null) {
            zArr[0] = false;
            View g2 = this.mRecycler.g(i2);
            if (g2 != null) {
                view = this.mAdapter.getView(i2, g2, this);
                if (view != g2) {
                    d.g.a.a.a.c("obtainView");
                    this.mRecycler.c(g2);
                    int i3 = this.mCacheColorHint;
                    if (i3 != 0) {
                        view.setDrawingCacheBackgroundColor(i3);
                    }
                } else {
                    zArr[0] = true;
                    dispatchFinishTemporaryDetach(view);
                }
            } else {
                d.g.a.a.a.c("makeView:" + i2);
                view = this.mAdapter.getView(i2, null, this);
                int i4 = this.mCacheColorHint;
                if (i4 != 0) {
                    view.setDrawingCacheBackgroundColor(i4);
                }
            }
            return view;
        }
        return (View) invokeIL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onAttachedToWindow();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnTouchModeChangeListener(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            if (this.mIsChildViewEnabled) {
                return super.onCreateDrawableState(i2);
            }
            int i3 = ViewGroup.ENABLED_STATE_SET[0];
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
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onDetachedFromWindow();
            this.mRecycler.d();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnTouchModeChangeListener(this);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
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
            } else if (action == 1) {
                this.mTouchMode = -1;
                this.mActivePointerId = -1;
                reportScrollStateChange(0);
            } else if (action != 2) {
                if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            } else if (this.mTouchMode == 0 && startScrollIfNeeded(((int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId))) - this.mMotionY)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048625, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mInLayout = true;
            if (z) {
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    getChildAt(i6).forceLayout();
                }
                this.mRecycler.h();
            }
            d.g.a.a.a.c("onLayout");
            layoutChildren();
            this.mInLayout = false;
        }
    }

    public void onLayoutSync(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
        }
    }

    public void onLayoutSyncFinished(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048629, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.mSelector == null) {
                useDefaultSelector();
            }
            Rect rect = this.mListPadding;
            rect.left = this.mSelectionLeftPadding + getPaddingLeft();
            rect.top = this.mSelectionTopPadding + getPaddingTop();
            rect.right = this.mSelectionRightPadding + getPaddingRight();
            rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                this.mDataChanged = true;
                this.mSyncHeight = bundle.getInt("height");
                long j2 = bundle.getLong("firstId");
                if (j2 >= 0) {
                    this.mNeedSync = true;
                    j jVar = new j();
                    jVar.f33626a = j2;
                    jVar.f33629d = (int) this.mSyncHeight;
                    jVar.f33628c = bundle.getInt("position");
                    jVar.f33627b = bundle.getInt("viewTop");
                    jVar.f33630e = bundle.getInt("childCount");
                    int[] intArray = bundle.getIntArray("viewTops");
                    jVar.f33631f = intArray;
                    this.mPendingSync = jVar;
                    this.mSyncRowId = jVar.f33626a;
                    this.mSyncPosition = jVar.f33628c;
                    this.mSpecificTop = jVar.f33627b;
                    this.mSpecificTops = intArray;
                }
                parcelable = bundle.getParcelable("instanceState");
            }
            super.onRestoreInstanceState(parcelable);
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            j jVar = this.mPendingSync;
            if (jVar != null) {
                bundle.putLong("firstId", jVar.f33626a);
                bundle.putInt("viewTop", this.mPendingSync.f33627b);
                bundle.putIntArray("viewTops", this.mPendingSync.f33631f);
                bundle.putInt("position", this.mPendingSync.f33628c);
                bundle.putInt("height", this.mPendingSync.f33629d);
                bundle.putInt("childCount", this.mPendingSync.f33630e);
                return bundle;
            }
            bundle.putInt("height", getHeight());
            int childCount = getChildCount();
            bundle.putInt("childCount", childCount);
            if ((childCount > 0 && this.mItemCount > 0) && (i2 = this.mFirstPosition) > 0) {
                int i3 = this.mItemCount;
                if (i2 >= i3) {
                    i2 = i3 - 1;
                }
                bundle.putInt("position", i2);
                bundle.putLong("firstId", this.mAdapter.getItemId(i2));
                bundle.putInt("viewTop", getChildAt(0).getTop());
                int[] iArr = new int[childCount];
                for (int i4 = 0; i4 < childCount; i4++) {
                    iArr[i4] = getChildAt(i4).getTop();
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
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048632, this, i2, i3, i4, i5) == null) || getChildCount() <= 0) {
            return;
        }
        d.g.a.a.a.a("data changed by onSizeChanged()");
        this.mDataChanged = true;
        rememberSyncState();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Drawable current;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, motionEvent)) == null) {
            if (!isEnabled()) {
                return isClickable() || isLongClickable();
            }
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int i3 = action & 255;
            if (i3 == 0) {
                this.mActivePointerId = motionEvent.getPointerId(0);
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int pointToPosition = pointToPosition(x, y);
                if (!this.mDataChanged) {
                    if (this.mTouchMode != 4 && pointToPosition >= 0 && ((ListAdapter) getAdapter()).isEnabled(pointToPosition)) {
                        this.mTouchMode = 0;
                        if (this.mPendingCheckForTap == null) {
                            this.mPendingCheckForTap = new c(this);
                        }
                        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } else if (motionEvent.getEdgeFlags() != 0 && pointToPosition < 0) {
                        return false;
                    } else {
                        if (this.mTouchMode == 4) {
                            createScrollingCache();
                            this.mTouchMode = 3;
                            this.mMotionCorrection = 0;
                            pointToPosition = findMotionRow(y);
                            reportScrollStateChange(1);
                        }
                    }
                }
                if (pointToPosition >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(pointToPosition - this.mFirstPosition).getTop();
                }
                this.mMotionX = x;
                this.mMotionY = y;
                this.mMotionPosition = pointToPosition;
                this.mLastY = Integer.MIN_VALUE;
            } else if (i3 == 1) {
                int i4 = this.mTouchMode;
                if (i4 == 0 || i4 == 1 || i4 == 2) {
                    int i5 = this.mMotionPosition;
                    View childAt = getChildAt(i5 - this.mFirstPosition);
                    if (childAt != null && !childAt.hasFocusable()) {
                        if (this.mTouchMode != 0) {
                            childAt.setPressed(false);
                        }
                        if (this.mPerformClick == null) {
                            this.mPerformClick = new f(this, null);
                        }
                        f fVar = this.mPerformClick;
                        fVar.f33611g = childAt;
                        fVar.f33612h = i5;
                        fVar.a();
                        this.mResurrectToPosition = i5;
                        int i6 = this.mTouchMode;
                        if (i6 != 0 && i6 != 1) {
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i5)) {
                                post(fVar);
                            }
                        } else {
                            this.mLayoutMode = 0;
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i5)) {
                                this.mTouchMode = 1;
                                layoutChildren();
                                childAt.setPressed(true);
                                positionSelector(childAt);
                                setPressed(true);
                                Drawable drawable = this.mSelector;
                                if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                postDelayed(new a(this, childAt, fVar), ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.mTouchMode = -1;
                            }
                            return true;
                        }
                    }
                    this.mTouchMode = -1;
                } else if (i4 == 3) {
                    int childCount = getChildCount();
                    if (childCount > 0) {
                        int fillChildTop = getFillChildTop();
                        int fillChildBottom = getFillChildBottom();
                        int i7 = this.mFirstPosition;
                        if (i7 == 0 && fillChildTop >= this.mListPadding.top && i7 + childCount < this.mItemCount && fillChildBottom <= getHeight() - this.mListPadding.bottom) {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                            if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                                if (this.mFlingRunnable == null) {
                                    this.mFlingRunnable = new d(this);
                                }
                                reportScrollStateChange(2);
                                this.mFlingRunnable.c(-yVelocity);
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                            }
                        }
                    } else {
                        this.mTouchMode = -1;
                        reportScrollStateChange(0);
                    }
                }
                setPressed(false);
                invalidate();
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.mVelocityTracker = null;
                }
                this.mActivePointerId = -1;
            } else if (i3 == 2) {
                int y2 = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                int i8 = y2 - this.mMotionY;
                int i9 = this.mTouchMode;
                if (i9 == 0 || i9 == 1 || i9 == 2) {
                    startScrollIfNeeded(i8);
                } else if (i9 == 3 && y2 != (i2 = this.mLastY)) {
                    int i10 = i8 - this.mMotionCorrection;
                    int i11 = i2 != Integer.MIN_VALUE ? y2 - i2 : i10;
                    if ((i11 != 0 ? trackMotionScroll(i10, i11) : false) && getChildCount() > 0) {
                        int findMotionRow = findMotionRow(y2);
                        if (findMotionRow >= 0) {
                            this.mMotionViewOriginalTop = getChildAt(findMotionRow - this.mFirstPosition).getTop();
                        }
                        this.mMotionY = y2;
                        this.mMotionPosition = findMotionRow;
                        invalidate();
                    }
                    this.mLastY = y2;
                }
            } else if (i3 == 3) {
                this.mTouchMode = -1;
                setPressed(false);
                View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
                clearScrollingCache();
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
                this.mActivePointerId = -1;
            } else if (i3 == 6) {
                onSecondaryPointerUp(motionEvent);
                int i12 = this.mMotionX;
                int i13 = this.mMotionY;
                int pointToPosition2 = pointToPosition(i12, i13);
                if (pointToPosition2 >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(pointToPosition2 - this.mFirstPosition).getTop();
                    this.mMotionPosition = pointToPosition2;
                }
                this.mLastY = i13;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048634, this, z) == null) || !z || getHeight() <= 0 || getChildCount() <= 0) {
            return;
        }
        layoutChildren();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            super.onWindowFocusChanged(z);
            d.g.a.a.a.c("onWindowFocusChanged");
            int i2 = !isInTouchMode();
            if (!z) {
                setChildrenDrawingCacheEnabled(false);
                d dVar = this.mFlingRunnable;
                if (dVar != null) {
                    removeCallbacks(dVar);
                    this.mFlingRunnable.b();
                    if (getScrollY() != 0) {
                        scrollTo(getScrollX(), 0);
                        invalidate();
                    }
                }
            } else {
                int i3 = this.mLastTouchMode;
                if (i2 != i3 && i3 != -1) {
                    this.mLayoutMode = 0;
                    d.g.a.a.a.c("onWindowFocusChanged");
                    layoutChildren();
                }
            }
            this.mLastTouchMode = i2;
        }
    }

    public int pointToPosition(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048636, this, i2, i3)) == null) {
            Rect rect = this.mTouchFrame;
            if (rect == null) {
                rect = new Rect();
                this.mTouchFrame = rect;
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
        return invokeII.intValue;
    }

    public long pointToRowId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048637, this, i2, i3)) == null) {
            int pointToPosition = pointToPosition(i2, i3);
            if (pointToPosition >= 0) {
                return this.mAdapter.getItemId(pointToPosition);
            }
            return Long.MIN_VALUE;
        }
        return invokeII.longValue;
    }

    public void positionSelector(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, view) == null) {
            Rect rect = this.mSelectorRect;
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            positionSelector(rect.left, rect.top, rect.right, rect.bottom);
            boolean z = this.mIsChildViewEnabled;
            if (view.isEnabled() != z) {
                this.mIsChildViewEnabled = !z;
                refreshDrawableState();
            }
        }
    }

    public void reclaimViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, list) == null) {
            int childCount = getChildCount();
            i iVar = this.mRecycler.f33619a;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && this.mRecycler.n(layoutParams.f33599a)) {
                    list.add(childAt);
                    if (iVar != null) {
                        iVar.onMovedToScrapHeap(childAt);
                    }
                }
            }
            this.mRecycler.j(list);
            removeAllViewsInLayout();
        }
    }

    public int reconcileSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int i2 = this.mSelectedPosition;
            if (i2 < 0) {
                i2 = this.mResurrectToPosition;
            }
            return Math.min(Math.max(0, i2), this.mItemCount - 1);
        }
        return invokeV.intValue;
    }

    public void reportScrollStateChange(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048641, this, i2) == null) || i2 == this.mLastScrollState || (eVar = this.mOnScrollListener) == null) {
            return;
        }
        eVar.onScrollStateChanged(this, i2);
        this.mLastScrollState = i2;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || this.mBlockLayoutRequests || this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    public void requestLayoutIfNecessary() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || getChildCount() <= 0) {
            return;
        }
        resetList();
        requestLayout();
        invalidate();
    }

    public void resetList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
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
    }

    public void setCacheColorHint(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048645, this, i2) == null) || i2 == this.mCacheColorHint) {
            return;
        }
        this.mCacheColorHint = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setDrawingCacheBackgroundColor(i2);
        }
        this.mRecycler.l(i2);
    }

    public void setDrawSelectorOnTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.mDrawSelectorOnTop = z;
        }
    }

    public void setOnScrollListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, eVar) == null) {
            this.mOnScrollListener = eVar;
            invokeOnItemScrollListener();
        }
    }

    public void setRecyclerListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, iVar) == null) {
            this.mRecycler.f33619a = iVar;
        }
    }

    public void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            if (this.mScrollingCacheEnabled && !z) {
                clearScrollingCache();
            }
            this.mScrollingCacheEnabled = z;
        }
    }

    public void setSelector(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            setSelector(getResources().getDrawable(i2));
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.mSmoothScrollbarEnabled = z;
        }
    }

    public void setStackFromBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048653, this, z) == null) || this.mStackFromBottom == z) {
            return;
        }
        this.mStackFromBottom = z;
        requestLayoutIfNecessary();
    }

    public void setTranscriptMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.mTranscriptMode = i2;
        }
    }

    public boolean shouldShowSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, view)) == null) {
            int positionForView = getPositionForView(view);
            if (positionForView >= 0) {
                long itemId = this.mAdapter.getItemId(positionForView);
                PLA_AdapterView.e eVar = this.mOnItemLongClickListener;
                boolean onItemLongClick = eVar != null ? eVar.onItemLongClick(this, view, positionForView, itemId) : false;
                if (onItemLongClick) {
                    return onItemLongClick;
                }
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                return super.showContextMenuForChild(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void smoothScrollBy(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048657, this, i2, i3) == null) {
            d dVar = this.mFlingRunnable;
            if (dVar != null) {
                dVar.b();
            } else {
                this.mFlingRunnable = new d(this);
            }
            this.mFlingRunnable.d(i2, i3);
        }
    }

    public void smoothScrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new g(this);
            }
            this.mPositionScroller.a(i2);
        }
    }

    public boolean touchModeDrawsInPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            int i2 = this.mTouchMode;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean trackMotionScroll(int i2, int i3) {
        InterceptResult invokeII;
        int min;
        int min2;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048661, this, i2, i3)) == null) {
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
            int i6 = this.mFirstPosition;
            if (i6 != 0 || scrollChildTop < rect.top || min < 0) {
                if (i6 + childCount != this.mItemCount || scrollChildBottom > height || min > 0) {
                    boolean z = min2 < 0;
                    int headerViewsCount = getHeaderViewsCount();
                    int footerViewsCount = this.mItemCount - getFooterViewsCount();
                    if (z) {
                        int i7 = rect.top - min2;
                        i5 = 0;
                        for (int i8 = 0; i8 < childCount; i8++) {
                            View childAt = getChildAt(i8);
                            if (childAt.getBottom() >= i7) {
                                break;
                            }
                            i5++;
                            int i9 = i6 + i8;
                            if (i9 >= headerViewsCount && i9 < footerViewsCount) {
                                this.mRecycler.c(childAt);
                            }
                        }
                        i4 = 0;
                    } else {
                        int height3 = (getHeight() - rect.bottom) - min2;
                        i4 = 0;
                        i5 = 0;
                        for (int i10 = childCount - 1; i10 >= 0; i10--) {
                            View childAt2 = getChildAt(i10);
                            if (childAt2.getTop() <= height3) {
                                break;
                            }
                            i5++;
                            int i11 = i6 + i10;
                            if (i11 >= headerViewsCount && i11 < footerViewsCount) {
                                this.mRecycler.c(childAt2);
                            }
                            i4 = i10;
                        }
                    }
                    this.mMotionViewNewTop = this.mMotionViewOriginalTop + min;
                    this.mBlockLayoutRequests = true;
                    if (i5 > 0) {
                        detachViewsFromParent(i4, i5);
                    }
                    tryOffsetChildrenTopAndBottom(min2);
                    if (z) {
                        this.mFirstPosition += i5;
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
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public void tryOffsetChildrenTopAndBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i2) == null) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).offsetTopAndBottom(i2);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, drawable)) == null) ? this.mSelector == drawable || super.verifyDrawable(drawable) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, drawable) == null) {
            Drawable drawable2 = this.mSelector;
            if (drawable2 != null) {
                drawable2.setCallback(null);
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048659, this, i2, i3) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new g(this);
            }
            this.mPositionScroller.b(i2, i3);
        }
    }

    private void positionSelector(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65557, this, i2, i3, i4, i5) == null) {
            this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, i4 + this.mSelectionRightPadding, i5 + this.mSelectionBottomPadding);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PLA_AbsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.absListViewStyle);
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
    public PLA_AbsListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorRect = new Rect();
        this.mRecycler = new h(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AbsListView, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.AbsListView_listSelector);
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = obtainStyledAttributes.getBoolean(R$styleable.AbsListView_drawSelectorOnTop, false);
        setStackFromBottom(obtainStyledAttributes.getBoolean(R$styleable.AbsListView_stackFromBottom, false));
        setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(R$styleable.AbsListView_scrollingCache, true));
        setTranscriptMode(obtainStyledAttributes.getInt(R$styleable.AbsListView_transcriptMode, 0));
        setCacheColorHint(obtainStyledAttributes.getColor(R$styleable.AbsListView_cacheColorHint, 0));
        setSmoothScrollbarEnabled(obtainStyledAttributes.getBoolean(R$styleable.AbsListView_smoothScrollbar, true));
        obtainStyledAttributes.recycle();
    }
}
