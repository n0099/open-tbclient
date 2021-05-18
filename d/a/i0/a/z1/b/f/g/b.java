package d.a.i0.a.z1.b.f.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f46053a;

    /* renamed from: b  reason: collision with root package name */
    public View f46054b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f46055c;

    public b(Context context) {
        this.f46055c = context;
    }

    public b a(View view, View view2) {
        this.f46053a = view;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f46053a.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.f46053a);
            View view3 = this.f46054b;
            if (view3 != null) {
                viewGroup.removeView(view3);
            }
            this.f46054b = view2;
            view2.setLayoutParams(this.f46053a.getLayoutParams());
            viewGroup.addView(this.f46054b, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.f46053a.setVisibility(4);
            } else {
                this.f46053a.setVisibility(8);
            }
            return this;
        }
        return this;
    }
}
