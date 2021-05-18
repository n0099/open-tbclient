package d.a.i0.a.v2;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class m0 implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public View f45255e;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            View view2 = this.f45255e;
            if (view2 == null) {
                view.setAlpha(d.a.i0.a.c1.a.H().a() ? 0.5f : 0.2f);
                return false;
            }
            view2.setAlpha(d.a.i0.a.c1.a.H().a() ? 0.5f : 0.2f);
            return false;
        } else if (action != 2) {
            View view3 = this.f45255e;
            if (view3 == null) {
                view.setAlpha(1.0f);
                return false;
            }
            view3.setAlpha(1.0f);
            return false;
        } else {
            return false;
        }
    }
}
