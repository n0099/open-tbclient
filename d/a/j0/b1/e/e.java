package d.a.j0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.a.j0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f48982e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f48983f;

    /* renamed from: g  reason: collision with root package name */
    public int f48984g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f48985h;

    public e(ListView listView) {
        this.f48985h = listView;
    }

    @Override // d.a.j0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f48982e.recycle();
        this.f48982e = null;
    }

    @Override // d.a.j0.b1.e.a.j
    public View b(int i2) {
        ListView listView = this.f48985h;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f48985h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f48982e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f48983f == null) {
            this.f48983f = new ImageView(this.f48985h.getContext());
        }
        this.f48983f.setBackgroundColor(this.f48984g);
        this.f48983f.setPadding(0, 0, 0, 0);
        this.f48983f.setImageBitmap(this.f48982e);
        this.f48983f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f48983f;
    }

    public void d(int i2) {
        this.f48984g = i2;
    }
}
