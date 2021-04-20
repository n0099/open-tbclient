package d.b.g0.a.x1;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.b.g0.a.c;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f47346a = null;

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f47346a == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f47346a = frameLayout;
            frameLayout.setBackgroundResource(c.aiapps_night_mode_cover_layer);
        }
        viewGroup.removeView(this.f47346a);
        viewGroup.addView(this.f47346a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f47346a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f47346a = null;
    }

    public void c(int i) {
        FrameLayout frameLayout = this.f47346a;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(i);
    }
}
