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
    public Bitmap f52681e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52682f;

    /* renamed from: g  reason: collision with root package name */
    public int f52683g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f52684h;

    public e(ListView listView) {
        this.f52684h = listView;
    }

    @Override // d.a.m0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f52681e.recycle();
        this.f52681e = null;
    }

    @Override // d.a.m0.b1.e.a.j
    public View b(int i2) {
        ListView listView = this.f52684h;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f52684h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f52681e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f52682f == null) {
            this.f52682f = new ImageView(this.f52684h.getContext());
        }
        this.f52682f.setBackgroundColor(this.f52683g);
        this.f52682f.setPadding(0, 0, 0, 0);
        this.f52682f.setImageBitmap(this.f52681e);
        this.f52682f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f52682f;
    }

    public void d(int i2) {
        this.f52683g = i2;
    }
}
