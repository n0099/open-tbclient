package d.a.i0.k.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.swan.menu.viewpager.PointPageIndicator;
/* loaded from: classes3.dex */
public class a extends PointPageIndicator {
    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.menu.viewpager.PointPageIndicator
    public /* bridge */ /* synthetic */ PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        g(drawable, drawable2);
        return this;
    }

    public a g(Drawable drawable, Drawable drawable2) {
        this.f11928e = drawable;
        this.f11929f = drawable2;
        this.f11930g.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f11931h.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        return this;
    }
}
