package d.a.m0.b1.o.a.f;

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
    public Context f49161e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f49162f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f49163g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f49164h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.b1.o.a.c.a f49165i;
    public d.a.m0.b1.o.a.d.c j;
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

    /* renamed from: d.a.m0.b1.o.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1113a implements View.OnClickListener {
        public View$OnClickListenerC1113a() {
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
            aVar.f49165i.y.removeView(aVar.f49163g);
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
        this.f49161e = context;
    }

    public void e() {
        if (this.f49164h != null) {
            Dialog dialog = new Dialog(this.f49161e, R.style.custom_dialog2);
            this.p = dialog;
            dialog.setCancelable(this.f49165i.S);
            this.p.setContentView(this.f49164h);
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
                this.f49162f.startAnimation(this.l);
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
        this.f49165i.y.post(new c());
    }

    public View i(int i2) {
        return this.f49162f.findViewById(i2);
    }

    public Dialog j() {
        return this.p;
    }

    public final Animation k() {
        return AnimationUtils.loadAnimation(this.f49161e, d.a.m0.b1.o.a.e.c.a(this.o, true));
    }

    public final Animation l() {
        return AnimationUtils.loadAnimation(this.f49161e, d.a.m0.b1.o.a.e.c.a(this.o, false));
    }

    public void m() {
        this.m = k();
        this.l = l();
    }

    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f49161e);
        if (o()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f49164h = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f49164h.findViewById(R.id.content_container);
            this.f49162f = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f49164h.setOnClickListener(new View$OnClickListenerC1113a());
        } else {
            d.a.m0.b1.o.a.c.a aVar = this.f49165i;
            if (aVar.y == null) {
                aVar.y = (ViewGroup) ((Activity) this.f49161e).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f49165i.y, false);
            this.f49163g = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i2 = this.f49165i.P;
            if (i2 != -1) {
                this.f49163g.setBackgroundColor(i2);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f49163g.findViewById(R.id.content_container);
            this.f49162f = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        s(true);
    }

    public abstract boolean o();

    public boolean p() {
        if (o()) {
            return false;
        }
        return this.f49163g.getParent() != null || this.n;
    }

    public final void q(View view) {
        this.f49165i.y.addView(view);
        if (this.r) {
            this.f49162f.startAnimation(this.m);
        }
    }

    public void r() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.setCancelable(this.f49165i.S);
        }
    }

    public void s(boolean z) {
        ViewGroup viewGroup;
        if (o()) {
            viewGroup = this.f49164h;
        } else {
            viewGroup = this.f49163g;
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
        ViewGroup viewGroup = this.f49163g;
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
            q(this.f49163g);
            this.f49163g.requestFocus();
        }
    }

    public final void v() {
        Dialog dialog = this.p;
        if (dialog != null) {
            dialog.show();
        }
    }
}
