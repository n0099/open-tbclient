package d.a.n0.b1.o.a.f;

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
    public Context f52942e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f52943f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f52944g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f52945h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.b1.o.a.c.a f52946i;
    public d.a.n0.b1.o.a.d.c j;
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

    /* renamed from: d.a.n0.b1.o.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1172a implements View.OnClickListener {
        public View$OnClickListenerC1172a() {
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
            a.this.i();
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
            aVar.f52946i.y.removeView(aVar.f52944g);
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
            if (i2 == 4 && keyEvent.getAction() == 0 && a.this.q()) {
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
        this.f52942e = context;
    }

    public void e() {
        if (this.f52945h != null) {
            Dialog dialog = new Dialog(this.f52942e, R.style.custom_dialog2);
            this.p = dialog;
            dialog.setCancelable(this.f52946i.S);
            this.p.setContentView(this.f52945h);
            Window window = this.p.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.p.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (p()) {
            h();
        } else if (this.k) {
        } else {
            if (this.r) {
                this.l.setAnimationListener(new b());
                this.f52943f.startAnimation(this.l);
            } else {
                i();
            }
            this.k = true;
        }
    }

    public final void h() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void i() {
        this.f52946i.y.post(new c());
    }

    public View j(int i2) {
        return this.f52943f.findViewById(i2);
    }

    public Dialog k() {
        return this.p;
    }

    public final Animation l() {
        return AnimationUtils.loadAnimation(this.f52942e, d.a.n0.b1.o.a.e.c.a(this.o, true));
    }

    public final Animation m() {
        return AnimationUtils.loadAnimation(this.f52942e, d.a.n0.b1.o.a.e.c.a(this.o, false));
    }

    public void n() {
        this.m = l();
        this.l = m();
    }

    public void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f52942e);
        if (p()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f52945h = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f52945h.findViewById(R.id.content_container);
            this.f52943f = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f52945h.setOnClickListener(new View$OnClickListenerC1172a());
        } else {
            d.a.n0.b1.o.a.c.a aVar = this.f52946i;
            if (aVar.y == null) {
                aVar.y = (ViewGroup) ((Activity) this.f52942e).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f52946i.y, false);
            this.f52944g = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i2 = this.f52946i.P;
            if (i2 != -1) {
                this.f52944g.setBackgroundColor(i2);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f52944g.findViewById(R.id.content_container);
            this.f52943f = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        t(true);
    }

    public abstract boolean p();

    public boolean q() {
        if (p()) {
            return false;
        }
        return this.f52944g.getParent() != null || this.n;
    }

    public final void r(View view) {
        this.f52946i.y.addView(view);
        if (this.r) {
            this.f52943f.startAnimation(this.m);
        }
    }

    public void s() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.setCancelable(this.f52946i.S);
        }
    }

    public void t(boolean z) {
        ViewGroup viewGroup;
        if (p()) {
            viewGroup = this.f52945h;
        } else {
            viewGroup = this.f52944g;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.s);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public a u(boolean z) {
        ViewGroup viewGroup = this.f52944g;
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

    public void v() {
        if (p()) {
            w();
        } else if (q()) {
        } else {
            this.n = true;
            r(this.f52944g);
            this.f52944g.requestFocus();
        }
    }

    public final void w() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.show();
        }
    }
}
