package d.b.i0.b1.o.a.f;

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
    public Context f50739e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f50740f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f50741g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f50742h;
    public d.b.i0.b1.o.a.c.a i;
    public d.b.i0.b1.o.a.d.c j;
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

    /* renamed from: d.b.i0.b1.o.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1091a implements View.OnClickListener {
        public View$OnClickListenerC1091a() {
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
            aVar.i.y.removeView(aVar.f50741g);
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
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.q()) {
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
        this.f50739e = context;
    }

    public void e() {
        if (this.f50742h != null) {
            Dialog dialog = new Dialog(this.f50739e, R.style.custom_dialog2);
            this.p = dialog;
            dialog.setCancelable(this.i.S);
            this.p.setContentView(this.f50742h);
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
                this.f50740f.startAnimation(this.l);
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
        this.i.y.post(new c());
    }

    public View j(int i) {
        return this.f50740f.findViewById(i);
    }

    public Dialog k() {
        return this.p;
    }

    public final Animation l() {
        return AnimationUtils.loadAnimation(this.f50739e, d.b.i0.b1.o.a.e.c.a(this.o, true));
    }

    public final Animation m() {
        return AnimationUtils.loadAnimation(this.f50739e, d.b.i0.b1.o.a.e.c.a(this.o, false));
    }

    public void n() {
        this.m = l();
        this.l = m();
    }

    public void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f50739e);
        if (p()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f50742h = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f50742h.findViewById(R.id.content_container);
            this.f50740f = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f50742h.setOnClickListener(new View$OnClickListenerC1091a());
        } else {
            d.b.i0.b1.o.a.c.a aVar = this.i;
            if (aVar.y == null) {
                aVar.y = (ViewGroup) ((Activity) this.f50739e).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.i.y, false);
            this.f50741g = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i = this.i.P;
            if (i != -1) {
                this.f50741g.setBackgroundColor(i);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f50741g.findViewById(R.id.content_container);
            this.f50740f = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        u(true);
    }

    public abstract boolean p();

    public boolean q() {
        if (p()) {
            return false;
        }
        return this.f50741g.getParent() != null || this.n;
    }

    public final void r(View view) {
        this.i.y.addView(view);
        if (this.r) {
            this.f50740f.startAnimation(this.m);
        }
    }

    public void s() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.setCancelable(this.i.S);
        }
    }

    public void u(boolean z) {
        ViewGroup viewGroup;
        if (p()) {
            viewGroup = this.f50742h;
        } else {
            viewGroup = this.f50741g;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.s);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public a v(boolean z) {
        ViewGroup viewGroup = this.f50741g;
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

    public void w() {
        if (p()) {
            x();
        } else if (q()) {
        } else {
            this.n = true;
            r(this.f50741g);
            this.f50741g.requestFocus();
        }
    }

    public final void x() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.show();
        }
    }
}
