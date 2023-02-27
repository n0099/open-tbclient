package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes8.dex */
public class b extends g {
    public Rect Gp;
    public int Gq;
    public int Gr;
    public boolean Gs;
    public int Gt;
    public a Gu;
    public boolean Gv;
    public boolean Gw;

    /* loaded from: classes8.dex */
    public interface a {
        boolean nV();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gt = Integer.MIN_VALUE;
        this.Gw = false;
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.Gt == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Gt = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                int i4 = i - findFirstVisibleItemPosition;
                if (getChildCount() > i4) {
                    int[] iArr2 = new int[2];
                    getChildAt(i4).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Gt) - i3);
                    return;
                }
                return;
            } else if (i > findLastVisibleItemPosition) {
                scrollBy(0, i2);
                a(i, i2, i3);
                return;
            } else {
                scrollBy(0, -i2);
            }
        }
    }

    private void nT() {
        Rect rect = this.Gp;
        if (rect == null) {
            this.Gp = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.Gp.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void nU() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).nY();
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Gq != 0) {
            nT();
            Rect rect = this.Gp;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Gp);
                canvas.drawColor(this.Gq);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gv) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Gw) {
            stopScroll();
        }
        a aVar = this.Gu;
        if (aVar == null || !aVar.nV()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.Gr;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.Gr, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Gv) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.Gs) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.Gv = z;
    }

    public void setDownStop(boolean z) {
        this.Gw = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Gu = aVar;
    }

    public void setUnderneathColor(int i) {
        this.Gq = i;
        nT();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.Gs = z;
    }
}
