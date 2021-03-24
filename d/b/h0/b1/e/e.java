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
    public Bitmap f49863e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49864f;

    /* renamed from: g  reason: collision with root package name */
    public int f49865g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public ListView f49866h;

    public e(ListView listView) {
        this.f49866h = listView;
    }

    @Override // d.b.h0.b1.e.a.j
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f49863e.recycle();
        this.f49863e = null;
    }

    @Override // d.b.h0.b1.e.a.j
    public View b(int i) {
        ListView listView = this.f49866h;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f49866h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f49863e = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f49864f == null) {
            this.f49864f = new ImageView(this.f49866h.getContext());
        }
        this.f49864f.setBackgroundColor(this.f49865g);
        this.f49864f.setPadding(0, 0, 0, 0);
        this.f49864f.setImageBitmap(this.f49863e);
        this.f49864f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f49864f;
    }

    public void d(int i) {
        this.f49865g = i;
    }
}
