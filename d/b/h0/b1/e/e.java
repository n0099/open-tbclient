package d.b.h0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import d.b.h0.b1.e.a;
/* loaded from: classes3.dex */
public class e implements a.j {

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f50257e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50258f;

    /* renamed from: g  reason: collision with root package name */
    public int f50259g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f50260h;

    public e(ListView listView) {
        this.f50260h = listView;
    }

    @Override // d.b.h0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f50257e.recycle();
        this.f50257e = null;
    }

    @Override // d.b.h0.b1.e.a.j
    public View b(int i) {
        ListView listView = this.f50260h;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f50260h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f50257e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f50258f == null) {
            this.f50258f = new ImageView(this.f50260h.getContext());
        }
        this.f50258f.setBackgroundColor(this.f50259g);
        this.f50258f.setPadding(0, 0, 0, 0);
        this.f50258f.setImageBitmap(this.f50257e);
        this.f50258f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f50258f;
    }

    public void d(int i) {
        this.f50259g = i;
    }
}
