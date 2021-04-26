package d.a.h0.i.r;

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
        this.f12586e = drawable;
        this.f12587f = drawable2;
        this.f12588g.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f12589h.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        return this;
    }
}
