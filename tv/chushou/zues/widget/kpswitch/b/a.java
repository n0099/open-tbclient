package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes6.dex */
public class a {
    public static View oZv = null;

    /* renamed from: tv.chushou.zues.widget.kpswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1015a {
        void yE(boolean z);
    }

    public static void a(final View view, final View view2, final View view3, final InterfaceC1015a interfaceC1015a) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean a = a.a(view2, view, view3);
                    if (interfaceC1015a != null) {
                        interfaceC1015a.yE(a);
                    }
                }
            });
        }
        if (aI(activity)) {
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

    public static void dU(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            d.dV(activity.getCurrentFocus());
        }
    }

    public static void e(View view, View view2) {
        d.bu(view2);
        if (aI((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean a(View view, View view2, View view3) {
        boolean z = true;
        boolean z2 = view2.getVisibility() != 0;
        if (!z2) {
            if (oZv == null || oZv == view) {
                e(view2, view3);
                z = z2;
            }
        } else {
            dU(view2);
            z = z2;
        }
        oZv = view;
        return z;
    }

    public static boolean f(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    static boolean aI(Activity activity) {
        return f(e.af(activity), e.B(activity), e.ag(activity));
    }
}
