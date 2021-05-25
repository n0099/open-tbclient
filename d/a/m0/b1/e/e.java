package d.a.m0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.a.m0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f49007e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49008f;

    /* renamed from: g  reason: collision with root package name */
    public int f49009g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f49010h;

    public e(ListView listView) {
        this.f49010h = listView;
    }

    @Override // d.a.m0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f49007e.recycle();
        this.f49007e = null;
    }

    @Override // d.a.m0.b1.e.a.j
    public View b(int i2) {
        ListView listView = this.f49010h;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f49010h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f49007e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f49008f == null) {
            this.f49008f = new ImageView(this.f49010h.getContext());
        }
        this.f49008f.setBackgroundColor(this.f49009g);
        this.f49008f.setPadding(0, 0, 0, 0);
        this.f49008f.setImageBitmap(this.f49007e);
        this.f49008f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f49008f;
    }

    public void d(int i2) {
        this.f49009g = i2;
    }
}
