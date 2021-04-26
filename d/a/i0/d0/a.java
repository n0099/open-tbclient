package d.a.i0.d0;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class a {
    public View attachedView;
    public boolean isAttached;
    public boolean isWrapStyle = false;

    public a(View view) {
        this.attachedView = view;
    }

    public void attachView(View view, boolean z) {
        View view2;
        if (view == null || (view2 = this.attachedView) == null || view2.getParent() != null) {
            return;
        }
        this.isAttached = true;
        e.b(view, this.isWrapStyle).a(view, this.attachedView, z);
        onViewAttached();
    }

    public void dettachView(View view) {
        View view2;
        if (view == null || (view2 = this.attachedView) == null || view2.getParent() == null || !(view instanceof ViewGroup)) {
            return;
        }
        try {
            onViewDettached();
            ((ViewGroup) view).removeView(this.attachedView);
            this.isAttached = false;
        } catch (Exception unused) {
        }
    }

    public View getView() {
        return this.attachedView;
    }

    public boolean isViewAttached() {
        return this.isAttached;
    }

    public void onViewAttached() {
    }

    public void onViewDettached() {
    }

    public void setWrapStyle(boolean z) {
        this.isWrapStyle = z;
    }

    public void attachView(View view) {
        attachView(view, false);
    }
}
