package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a {
    public static View nQi = null;

    /* renamed from: tv.chushou.zues.widget.kpswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0924a {
        void wz(boolean z);
    }

    public static void a(final View view, final View view2, final View view3, final InterfaceC0924a interfaceC0924a) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean a = a.a(view2, view, view3);
                    if (interfaceC0924a != null) {
                        interfaceC0924a.wz(a);
                    }
                }
            });
        }
        if (aC(activity)) {
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

    public static void dC(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            d.dE(activity.getCurrentFocus());
        }
    }

    public static void d(View view, View view2) {
        d.dD(view2);
        if (aC((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean a(View view, View view2, View view3) {
        boolean z = true;
        boolean z2 = view2.getVisibility() != 0;
        if (!z2) {
            if (nQi == null || nQi == view) {
                d(view2, view3);
                z = z2;
            }
        } else {
            dC(view2);
            z = z2;
        }
        nQi = view;
        return z;
    }

    public static boolean l(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    static boolean aC(Activity activity) {
        return l(e.isFullScreen(activity), e.A(activity), e.aD(activity));
    }
}
