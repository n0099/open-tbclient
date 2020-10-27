package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes6.dex */
public class a {
    public static View qgd = null;

    /* renamed from: tv.chushou.zues.widget.kpswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1105a {
        void At(boolean z);
    }

    public static void a(final View view, final View view2, final View view3, final InterfaceC1105a interfaceC1105a) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.kpswitch.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean a2 = a.a(view2, view, view3);
                    if (interfaceC1105a != null) {
                        interfaceC1105a.At(a2);
                    }
                }
            });
        }
        if (aM(activity)) {
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

    public static void eg(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            d.eh(activity.getCurrentFocus());
        }
    }

    public static void e(View view, View view2) {
        d.bz(view2);
        if (aM((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean a(View view, View view2, View view3) {
        boolean z = true;
        boolean z2 = view2.getVisibility() != 0;
        if (!z2) {
            if (qgd == null || qgd == view) {
                e(view2, view3);
                z = z2;
            }
        } else {
            eg(view2);
            z = z2;
        }
        qgd = view;
        return z;
    }

    public static boolean f(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    static boolean aM(Activity activity) {
        return f(e.af(activity), e.C(activity), e.ag(activity));
    }
}
