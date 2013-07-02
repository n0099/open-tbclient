package com.mofamulu.tieba.dslv;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.tieba.hp.DragSortListView;
/* loaded from: classes.dex */
public class e implements DragSortListView.FloatViewManager {
    private Bitmap a;
    private ImageView b;
    private int c = -16777216;
    private ListView d;

    public e(ListView listView) {
        this.d = listView;
    }

    public void d(int i) {
        this.c = i;
    }

    @Override // com.baidu.tieba.hp.DragSortListView.FloatViewManager
    public View a(int i) {
        View childAt = this.d.getChildAt((this.d.getHeaderViewsCount() + i) - this.d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.b == null) {
            this.b = new ImageView(this.d.getContext());
        }
        this.b.setBackgroundColor(this.c);
        this.b.setPadding(0, 0, 0, 0);
        this.b.setImageBitmap(this.a);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.b;
    }

    @Override // com.baidu.tieba.hp.DragSortListView.FloatViewManager
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tieba.hp.DragSortListView.FloatViewManager
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.a.recycle();
        this.a = null;
    }
}
