package tv.chushou.zues.widget.adapterview.recyclerview.b;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.lang.reflect.Field;
import tv.chushou.zues.utils.e;
/* loaded from: classes6.dex */
public class b extends LinearLayoutManager {
    private static boolean pmT = true;
    private static Field pmU = null;
    private final Rect idC;
    private int overScrollMode;
    private final int[] pmV;
    private int pmW;
    private boolean pmX;
    private final RecyclerView view;

    public b(Context context, int i, boolean z) {
        super(context, i, z);
        this.pmV = new int[2];
        this.pmW = 100;
        this.overScrollMode = 0;
        this.idC = new Rect();
        this.view = null;
    }

    public static int euk() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int i3;
        int i4;
        int min;
        int paddingTop;
        int i5;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = mode != 0;
        boolean z2 = mode2 != 0;
        boolean z3 = mode == 1073741824;
        boolean z4 = mode2 == 1073741824;
        int euk = euk();
        if (z3 && z4) {
            super.onMeasure(recycler, state, i, i2);
            return;
        }
        boolean z5 = getOrientation() == 1;
        o(size, size2, z5);
        int i6 = 0;
        int i7 = 0;
        recycler.clear();
        int itemCount = state.getItemCount();
        int itemCount2 = getItemCount();
        int i8 = 0;
        while (true) {
            if (i8 >= itemCount2) {
                i3 = i7;
                i4 = i6;
                break;
            } else if (z5) {
                if (!this.pmX) {
                    if (i8 < itemCount) {
                        a(recycler, i8, size, euk, this.pmV);
                    } else {
                        PU(i8);
                    }
                }
                i5 = this.pmV[1] + i7;
                i4 = i8 == 0 ? this.pmV[0] : i6;
                if (z2 && i5 >= size2) {
                    i3 = i5;
                    break;
                }
                i8++;
                i7 = i5;
                i6 = i4;
            } else {
                if (!this.pmX) {
                    if (i8 < itemCount) {
                        a(recycler, i8, euk, size2, this.pmV);
                    } else {
                        PU(i8);
                    }
                }
                i4 = i6 + this.pmV[0];
                i5 = i8 == 0 ? this.pmV[1] : i7;
                if (z && i4 >= size) {
                    i3 = i5;
                    break;
                }
                i8++;
                i7 = i5;
                i6 = i4;
            }
        }
        if (z3) {
            min = size;
        } else {
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i4;
            min = z ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (z4) {
            paddingTop = size2;
        } else {
            paddingTop = getPaddingTop() + getPaddingBottom() + i3;
            if (z2) {
                paddingTop = Math.min(paddingTop, size2);
            }
        }
        setMeasuredDimension(min, paddingTop);
        if (this.view != null && this.overScrollMode == 1) {
            ViewCompat.setOverScrollMode(this.view, (z5 && (!z2 || paddingTop < size2)) || (!z5 && (!z || min < size)) ? 2 : 0);
        }
    }

    private void PU(int i) {
        e.w("WrapContentManager", "Can't measure child #" + i + ", previously used dimensions will be reused.To remove this message either use #setChildSize() method or don't run RecyclerView animations");
    }

    private void o(int i, int i2, boolean z) {
        if (this.pmV[0] == 0 && this.pmV[1] == 0) {
            if (z) {
                this.pmV[0] = i;
                this.pmV[1] = this.pmW;
                return;
            }
            this.pmV[0] = this.pmW;
            this.pmV[1] = i2;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void setOrientation(int i) {
        if (this.pmV != null && getOrientation() != i) {
            this.pmV[0] = 0;
            this.pmV[1] = 0;
        }
        super.setOrientation(i);
    }

    private void a(RecyclerView.Recycler recycler, int i, int i2, int i3, int[] iArr) {
        try {
            View viewForPosition = recycler.getViewForPosition(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int i4 = layoutParams.leftMargin + layoutParams.rightMargin;
            int i5 = layoutParams.topMargin + layoutParams.bottomMargin;
            a(layoutParams);
            calculateItemDecorationsForChild(viewForPosition, this.idC);
            viewForPosition.measure(getChildMeasureSpec(i2, paddingLeft + i4 + getRightDecorationWidth(viewForPosition) + getLeftDecorationWidth(viewForPosition), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(i3, paddingTop + i5 + getTopDecorationHeight(viewForPosition) + getBottomDecorationHeight(viewForPosition), layoutParams.height, canScrollVertically()));
            iArr[0] = getDecoratedMeasuredWidth(viewForPosition) + layoutParams.leftMargin + layoutParams.rightMargin;
            iArr[1] = getDecoratedMeasuredHeight(viewForPosition) + layoutParams.bottomMargin + layoutParams.topMargin;
            a(layoutParams);
            recycler.recycleView(viewForPosition);
        } catch (IndexOutOfBoundsException e) {
            e.e("WrapContentManager", "WrapContentLinearLayoutManager doesn't work well with animations. Consider switching them off");
        }
    }

    private static void a(RecyclerView.LayoutParams layoutParams) {
        if (pmT) {
            try {
                if (pmU == null) {
                    pmU = RecyclerView.LayoutParams.class.getDeclaredField("mInsetsDirty");
                    pmU.setAccessible(true);
                }
                pmU.set(layoutParams, true);
            } catch (Exception e) {
                eul();
            }
        }
    }

    private static void eul() {
        pmT = false;
        e.w("WrapContentManager", "Can't make LayoutParams insets dirty, decorations measurements might be incorrect");
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
