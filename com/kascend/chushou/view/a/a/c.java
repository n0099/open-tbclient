package com.kascend.chushou.view.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ItemDecoration {
    private int c;
    private int d;
    private int e;
    private Paint f;
    private GridLayoutManager ngV;
    private GridLayoutManager.SpanSizeLookup ngW;

    public c(GridLayoutManager gridLayoutManager, int i) {
        this(gridLayoutManager, i, -1);
    }

    public c(GridLayoutManager gridLayoutManager, int i, @ColorInt int i2) {
        this.ngV = gridLayoutManager;
        this.ngW = this.ngV.getSpanSizeLookup();
        this.ngW.setSpanIndexCacheEnabled(true);
        this.c = this.ngV.getSpanCount();
        this.d = i;
        this.e = this.d / 2;
        this.f = new Paint();
        this.f.setColor(i2);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanSize = this.ngW.getSpanSize(childAdapterPosition);
        if (spanSize != this.c) {
            int i = this.d;
            int spanIndex = this.ngW.getSpanIndex(childAdapterPosition, this.c);
            int i2 = (this.c - spanIndex) - spanSize;
            int i3 = this.c / spanSize;
            int i4 = (int) (((i3 - 1) * (i * 1.0f)) / i3);
            int i5 = (int) ((i * 1.0f) / i3);
            if (spanIndex == 0) {
                rect.right = i4;
            } else if (i2 == 0) {
                rect.left = i4;
            } else if (spanIndex % 2 == 1) {
                rect.left = i5;
                rect.right = i4 - i5;
            } else {
                rect.left = i4 - i5;
                rect.right = i5;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int i3 = this.d;
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                int spanSize = this.ngW.getSpanSize(childAdapterPosition);
                if (spanSize != this.c) {
                    int spanIndex = this.ngW.getSpanIndex(childAdapterPosition, this.c);
                    int i4 = (this.c - spanIndex) - spanSize;
                    int i5 = this.c / spanSize;
                    int i6 = (int) (((i5 - 1) * (i3 * 1.0f)) / i5);
                    int i7 = (int) ((i3 * 1.0f) / i5);
                    if (spanIndex == 0) {
                        b(canvas, childAt, i6);
                    } else if (i4 == 0) {
                        a(canvas, childAt, i6);
                    } else {
                        if (spanIndex % 2 == 1) {
                            i = i6 - i7;
                        } else {
                            i = i7;
                            i7 = i6 - i7;
                        }
                        a(canvas, childAt, i7, i);
                    }
                }
            }
        }
    }

    private void a(Canvas canvas, View view, int i, int i2) {
        a(canvas, view, i);
        b(canvas, view, i2);
    }

    private void a(Canvas canvas, View view, int i) {
        canvas.drawRect(view.getLeft() - i, view.getTop(), view.getLeft(), view.getBottom(), this.f);
    }

    private void b(Canvas canvas, View view, int i) {
        int top2 = view.getTop();
        int bottom = view.getBottom();
        int right = view.getRight();
        canvas.drawRect(right, top2, right + i, bottom, this.f);
    }
}
