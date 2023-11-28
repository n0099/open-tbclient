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
/* loaded from: classes10.dex */
public class b extends g {
    public Rect Pg;
    public int Ph;
    public int Pi;
    public boolean Pj;
    public int Pk;
    public a Pl;
    public boolean Pm;
    public boolean Pn;

    /* loaded from: classes10.dex */
    public interface a {
        boolean pF();
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Ph != 0) {
            pD();
            Rect rect = this.Pg;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Pg);
                canvas.drawColor(this.Ph);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pm) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Pn) {
            stopScroll();
        }
        a aVar = this.Pl;
        if (aVar != null && aVar.pF()) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Pm) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.Pj) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.Pm = z;
    }

    public void setDownStop(boolean z) {
        this.Pn = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Pl = aVar;
    }

    public void setUnderneathColor(int i) {
        this.Ph = i;
        pD();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.Pj = z;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.Pi;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.Pi, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Pk = Integer.MIN_VALUE;
        this.Pn = false;
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.Pk == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Pk = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                    int i4 = i - findFirstVisibleItemPosition;
                    if (getChildCount() > i4) {
                        int[] iArr2 = new int[2];
                        getChildAt(i4).getLocationOnScreen(iArr2);
                        scrollBy(0, (iArr2[1] - this.Pk) - i3);
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
            } else {
                return;
            }
        }
    }

    private void pD() {
        Rect rect = this.Pg;
        if (rect == null) {
            this.Pg = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.Pg.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void pE() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).pI();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pE();
    }
}
