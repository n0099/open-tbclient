package d.a.l0.a.w1.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45615e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f45616f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f45617g;

        public a(View view, View view2, c cVar) {
            this.f45615e = view;
            this.f45616f = view2;
            this.f45617g = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.l0.a.w1.h.b.c().e()) {
                boolean c2 = b.c(this.f45615e, this.f45616f);
                c cVar = this.f45617g;
                if (cVar != null) {
                    cVar.onClickSwitch(view, c2);
                }
            }
        }
    }

    /* renamed from: d.a.l0.a.w1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnTouchListenerC0894b implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45618e;

        public View$OnTouchListenerC0894b(View view) {
            this.f45618e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                this.f45618e.setVisibility(4);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClickSwitch(View view, boolean z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public static void b(View view, View view2, View view3, c cVar) {
        if (view2 != null) {
            view2.setOnClickListener(new a(view, view3, cVar));
        }
        if (e(view.getContext())) {
            view3.setOnTouchListener(new View$OnTouchListenerC0894b(view));
        }
    }

    public static boolean c(View view, View view2) {
        boolean z = view.getVisibility() != 0;
        if (!z) {
            h(view, view2);
        } else {
            g(view, view2);
        }
        return z;
    }

    public static void d(View view, View view2) {
        if (view2 != null) {
            e.k(view2);
            view2.clearFocus();
        }
        view.setVisibility(8);
    }

    public static boolean e(Context context) {
        if (context instanceof Activity) {
            boolean d2 = g.d((Activity) context);
            f(d2);
            return d2;
        }
        return false;
    }

    public static boolean f(boolean z) {
        return z;
    }

    public static void g(View view, View view2) {
        view.setVisibility(0);
        if (view2 != null) {
            e.k(view2);
        }
    }

    public static void h(View view, View view2) {
        e.m(view2);
        if (e(view.getContext())) {
            view.setVisibility(4);
        }
    }
}
