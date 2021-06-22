package d.a.m0.a.z1.b.f.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f50011a;

    /* renamed from: b  reason: collision with root package name */
    public View f50012b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f50013c;

    public b(Context context) {
        this.f50013c = context;
    }

    public b a(View view, View view2) {
        this.f50011a = view;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f50011a.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.f50011a);
            View view3 = this.f50012b;
            if (view3 != null) {
                viewGroup.removeView(view3);
            }
            this.f50012b = view2;
            view2.setLayoutParams(this.f50011a.getLayoutParams());
            viewGroup.addView(this.f50012b, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.f50011a.setVisibility(4);
            } else {
                this.f50011a.setVisibility(8);
            }
            return this;
        }
        return this;
    }
}
