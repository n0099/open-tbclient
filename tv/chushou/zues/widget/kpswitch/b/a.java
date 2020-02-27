package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a {
    public static View nZn = null;

    /* renamed from: tv.chushou.zues.widget.kpswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0817a {
        void wi(boolean z);
    }

    public static void a(final View view, final View view2, final View view3, final InterfaceC0817a interfaceC0817a) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean a = a.a(view2, view, view3);
                    if (interfaceC0817a != null) {
                        interfaceC0817a.wi(a);
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

    public static void dK(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            d.dM(activity.getCurrentFocus());
        }
    }

    public static void h(View view, View view2) {
        d.dL(view2);
        if (aI((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean a(View view, View view2, View view3) {
        boolean z = true;
        boolean z2 = view2.getVisibility() != 0;
        if (!z2) {
            if (nZn == null || nZn == view) {
                h(view2, view3);
                z = z2;
            }
        } else {
            dK(view2);
            z = z2;
        }
        nZn = view;
        return z;
    }

    public static boolean l(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    static boolean aI(Activity activity) {
        return l(e.isFullScreen(activity), e.D(activity), e.F(activity));
    }
}
