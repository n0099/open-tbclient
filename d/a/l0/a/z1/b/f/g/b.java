package d.a.l0.a.z1.b.f.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f46229a;

    /* renamed from: b  reason: collision with root package name */
    public View f46230b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f46231c;

    public b(Context context) {
        this.f46231c = context;
    }

    public b a(View view, View view2) {
        this.f46229a = view;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f46229a.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.f46229a);
            View view3 = this.f46230b;
            if (view3 != null) {
                viewGroup.removeView(view3);
            }
            this.f46230b = view2;
            view2.setLayoutParams(this.f46229a.getLayoutParams());
            viewGroup.addView(this.f46230b, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.f46229a.setVisibility(4);
            } else {
                this.f46229a.setVisibility(8);
            }
            return this;
        }
        return this;
    }
}
