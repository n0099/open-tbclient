package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes6.dex */
public class a {
    public static View poR = null;

    /* renamed from: tv.chushou.zues.widget.kpswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1033a {
        void zl(boolean z);
    }

    public static void a(final View view, final View view2, final View view3, final InterfaceC1033a interfaceC1033a) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean a2 = a.a(view2, view, view3);
                    if (interfaceC1033a != null) {
                        interfaceC1033a.zl(a2);
                    }
                }
            });
        }
        if (aJ(activity)) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view4, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setVisibility(4);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public static void dY(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            d.dZ(activity.getCurrentFocus());
        }
    }

    public static void e(View view, View view2) {
        d.by(view2);
        if (aJ((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean a(View view, View view2, View view3) {
        boolean z = true;
        boolean z2 = view2.getVisibility() != 0;
        if (!z2) {
            if (poR == null || poR == view) {
                e(view2, view3);
                z = z2;
            }
        } else {
            dY(view2);
            z = z2;
        }
        poR = view;
        return z;
    }

    public static boolean f(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    static boolean aJ(Activity activity) {
        return f(e.af(activity), e.C(activity), e.ag(activity));
    }
}
