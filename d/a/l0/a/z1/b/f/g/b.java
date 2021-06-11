package d.a.l0.a.z1.b.f.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f49903a;

    /* renamed from: b  reason: collision with root package name */
    public View f49904b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f49905c;

    public b(Context context) {
        this.f49905c = context;
    }

    public b a(View view, View view2) {
        this.f49903a = view;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f49903a.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.f49903a);
            View view3 = this.f49904b;
            if (view3 != null) {
                viewGroup.removeView(view3);
            }
            this.f49904b = view2;
            view2.setLayoutParams(this.f49903a.getLayoutParams());
            viewGroup.addView(this.f49904b, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.f49903a.setVisibility(4);
            } else {
                this.f49903a.setVisibility(8);
            }
            return this;
        }
        return this;
    }
}
