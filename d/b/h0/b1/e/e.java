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
    public Bitmap f49864e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49865f;

    /* renamed from: g  reason: collision with root package name */
    public int f49866g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f49867h;

    public e(ListView listView) {
        this.f49867h = listView;
    }

    @Override // d.b.h0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f49864e.recycle();
        this.f49864e = null;
    }

    @Override // d.b.h0.b1.e.a.j
    public View b(int i) {
        ListView listView = this.f49867h;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f49867h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f49864e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f49865f == null) {
            this.f49865f = new ImageView(this.f49867h.getContext());
        }
        this.f49865f.setBackgroundColor(this.f49866g);
        this.f49865f.setPadding(0, 0, 0, 0);
        this.f49865f.setImageBitmap(this.f49864e);
        this.f49865f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f49865f;
    }

    public void d(int i) {
        this.f49866g = i;
    }
}
