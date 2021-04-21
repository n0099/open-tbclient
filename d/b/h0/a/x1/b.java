package d.b.h0.a.x1;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.b.h0.a.c;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f47675a = null;

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f47675a == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f47675a = frameLayout;
            frameLayout.setBackgroundResource(c.aiapps_night_mode_cover_layer);
        }
        viewGroup.removeView(this.f47675a);
        viewGroup.addView(this.f47675a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f47675a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f47675a = null;
    }

    public void c(int i) {
        FrameLayout frameLayout = this.f47675a;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(i);
    }
}
