package d.a.i0.a.g2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.i0.a.c;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f41773a = null;

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f41773a == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f41773a = frameLayout;
            frameLayout.setBackgroundResource(c.aiapps_night_mode_cover_layer);
        }
        viewGroup.removeView(this.f41773a);
        viewGroup.addView(this.f41773a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f41773a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f41773a = null;
    }

    public void c(int i2) {
        FrameLayout frameLayout = this.f41773a;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(i2);
    }
}
