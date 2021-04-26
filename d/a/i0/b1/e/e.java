package d.a.i0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.a.i0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f48154e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f48155f;

    /* renamed from: g  reason: collision with root package name */
    public int f48156g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f48157h;

    public e(ListView listView) {
        this.f48157h = listView;
    }

    @Override // d.a.i0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f48154e.recycle();
        this.f48154e = null;
    }

    @Override // d.a.i0.b1.e.a.j
    public View b(int i2) {
        ListView listView = this.f48157h;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f48157h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f48154e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f48155f == null) {
            this.f48155f = new ImageView(this.f48157h.getContext());
        }
        this.f48155f.setBackgroundColor(this.f48156g);
        this.f48155f.setPadding(0, 0, 0, 0);
        this.f48155f.setImageBitmap(this.f48154e);
        this.f48155f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f48155f;
    }

    public void d(int i2) {
        this.f48156g = i2;
    }
}
