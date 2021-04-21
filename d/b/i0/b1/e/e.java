package d.b.i0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.b.i0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f50593e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50594f;

    /* renamed from: g  reason: collision with root package name */
    public int f50595g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f50596h;

    public e(ListView listView) {
        this.f50596h = listView;
    }

    @Override // d.b.i0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f50593e.recycle();
        this.f50593e = null;
    }

    @Override // d.b.i0.b1.e.a.j
    public View b(int i) {
        ListView listView = this.f50596h;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f50596h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f50593e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f50594f == null) {
            this.f50594f = new ImageView(this.f50596h.getContext());
        }
        this.f50594f.setBackgroundColor(this.f50595g);
        this.f50594f.setPadding(0, 0, 0, 0);
        this.f50594f.setImageBitmap(this.f50593e);
        this.f50594f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f50594f;
    }

    public void d(int i) {
        this.f50595g = i;
    }
}
