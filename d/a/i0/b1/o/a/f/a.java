package d.a.i0.b1.o.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public Context f48308e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f48309f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f48310g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f48311h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.b1.o.a.c.a f48312i;
    public d.a.i0.b1.o.a.d.c j;
    public boolean k;
    public Animation l;
    public Animation m;
    public boolean n;
    public Dialog p;
    public View q;
    public int o = 80;
    public boolean r = true;
    public View.OnKeyListener s = new d();
    public final View.OnTouchListener t = new e();

    /* renamed from: d.a.i0.b1.o.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1030a implements View.OnClickListener {
        public View$OnClickListenerC1030a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f48312i.y.removeView(aVar.f48310g);
            a.this.n = false;
            a.this.k = false;
            if (a.this.j != null) {
                a.this.j.a(a.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 0 && a.this.p()) {
                a.this.f();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.j != null) {
                a.this.j.a(a.this);
            }
        }
    }

    public a(Context context) {
        this.f48308e = context;
    }

    public void e() {
        if (this.f48311h != null) {
            Dialog dialog = new Dialog(this.f48308e, R.style.custom_dialog2);
            this.p = dialog;
            dialog.setCancelable(this.f48312i.S);
            this.p.setContentView(this.f48311h);
            Window window = this.p.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.p.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (o()) {
            g();
        } else if (this.k) {
        } else {
            if (this.r) {
                this.l.setAnimationListener(new b());
                this.f48309f.startAnimation(this.l);
            } else {
                h();
            }
            this.k = true;
        }
    }

    public final void g() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void h() {
        this.f48312i.y.post(new c());
    }

    public View i(int i2) {
        return this.f48309f.findViewById(i2);
    }

    public Dialog j() {
        return this.p;
    }

    public final Animation k() {
        return AnimationUtils.loadAnimation(this.f48308e, d.a.i0.b1.o.a.e.c.a(this.o, true));
    }

    public final Animation l() {
        return AnimationUtils.loadAnimation(this.f48308e, d.a.i0.b1.o.a.e.c.a(this.o, false));
    }

    public void m() {
        this.m = k();
        this.l = l();
    }

    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f48308e);
        if (o()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f48311h = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f48311h.findViewById(R.id.content_container);
            this.f48309f = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f48311h.setOnClickListener(new View$OnClickListenerC1030a());
        } else {
            d.a.i0.b1.o.a.c.a aVar = this.f48312i;
            if (aVar.y == null) {
                aVar.y = (ViewGroup) ((Activity) this.f48308e).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f48312i.y, false);
            this.f48310g = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i2 = this.f48312i.P;
            if (i2 != -1) {
                this.f48310g.setBackgroundColor(i2);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f48310g.findViewById(R.id.content_container);
            this.f48309f = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        s(true);
    }

    public abstract boolean o();

    public boolean p() {
        if (o()) {
            return false;
        }
        return this.f48310g.getParent() != null || this.n;
    }

    public final void q(View view) {
        this.f48312i.y.addView(view);
        if (this.r) {
            this.f48309f.startAnimation(this.m);
        }
    }

    public void r() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.setCancelable(this.f48312i.S);
        }
    }

    public void s(boolean z) {
        ViewGroup viewGroup;
        if (o()) {
            viewGroup = this.f48311h;
        } else {
            viewGroup = this.f48310g;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.s);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public a t(boolean z) {
        ViewGroup viewGroup = this.f48310g;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.t);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void u() {
        if (o()) {
            v();
        } else if (p()) {
        } else {
            this.n = true;
            q(this.f48310g);
            this.f48310g.requestFocus();
        }
    }

    public final void v() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.show();
        }
    }
}
