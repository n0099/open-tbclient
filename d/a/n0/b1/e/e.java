package d.a.n0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.a.n0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f52788e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52789f;

    /* renamed from: g  reason: collision with root package name */
    public int f52790g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f52791h;

    public e(ListView listView) {
        this.f52791h = listView;
    }

    @Override // d.a.n0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f52788e.recycle();
        this.f52788e = null;
    }

    @Override // d.a.n0.b1.e.a.j
    public View b(int i2) {
        ListView listView = this.f52791h;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f52791h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f52788e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f52789f == null) {
            this.f52789f = new ImageView(this.f52791h.getContext());
        }
        this.f52789f.setBackgroundColor(this.f52790g);
        this.f52789f.setPadding(0, 0, 0, 0);
        this.f52789f.setImageBitmap(this.f52788e);
        this.f52789f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f52789f;
    }

    public void d(int i2) {
        this.f52790g = i2;
    }
}
