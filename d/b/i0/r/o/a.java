package d.b.i0.r.o;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.e.m.g;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f51410a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.a.b0.a f51411b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f51412c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f51413d;

    /* renamed from: e  reason: collision with root package name */
    public View f51414e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f51415f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f51416g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f51417h;
    public EMTextView i;
    public c l;
    public boolean j = false;
    public boolean k = true;
    public int m = -1;
    public View.OnClickListener n = new View$OnClickListenerC1120a();
    public View.OnClickListener o = new b();

    /* renamed from: d.b.i0.r.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1120a implements View.OnClickListener {
        public View$OnClickListenerC1120a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                a.this.l.onCancel();
                a.this.f51412c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                a.this.l.a();
                a.this.f51412c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onCancel();
    }

    public a(Activity activity) {
        this.f51410a = activity;
        this.f51413d = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public final void c() {
        d.b.i0.a.b0.a aVar = this.f51411b;
        if (aVar == null) {
            return;
        }
        this.f51415f.setText(aVar.y);
        this.f51416g.setText(this.f51411b.z);
        this.f51417h.setText(this.f51411b.A);
        this.i.setText(this.f51411b.B);
    }

    public a d() {
        if (this.j) {
            return this;
        }
        this.j = true;
        this.f51414e = this.f51413d.findViewById(R.id.root_dialog_view);
        this.f51415f = (EMTextView) this.f51413d.findViewById(R.id.title);
        this.f51416g = (EMTextView) this.f51413d.findViewById(R.id.content);
        this.f51417h = (EMTextView) this.f51413d.findViewById(R.id.cancel);
        this.i = (EMTextView) this.f51413d.findViewById(R.id.confirm);
        this.f51417h.setClickable(true);
        this.i.setClickable(true);
        this.f51417h.setOnClickListener(this.n);
        this.i.setOnClickListener(this.o);
        return this;
    }

    public final void e() {
        if (this.f51411b == null) {
            return;
        }
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.f51414e);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        d.b.i0.r.u.c d3 = d.b.i0.r.u.c.d(this.f51415f);
        d3.v(R.string.F_X02);
        d3.q(R.color.CAM_X0105);
        d.b.i0.r.u.c.d(this.f51416g).q(R.color.CAM_X0107);
        d.b.i0.r.u.c d4 = d.b.i0.r.u.c.d(this.f51417h);
        d4.q(R.color.CAM_X0105);
        d4.k(R.string.J_X07);
        d4.i(R.dimen.L_X02);
        d4.h(R.color.CAM_X0902);
        d.b.i0.r.u.c d5 = d.b.i0.r.u.c.d(this.i);
        d5.q(R.color.CAM_X0304);
        d5.k(R.string.J_X07);
        d5.e(R.string.A_X07);
        d5.i(R.dimen.L_X02);
        d5.h(R.color.CAM_X0304);
    }

    public void f(d.b.i0.a.b0.a aVar) {
        this.f51411b = aVar;
    }

    public void g(c cVar) {
        this.l = cVar;
    }

    public a h() {
        if (this.j) {
            AlertDialog create = new AlertDialog.Builder(this.f51410a).create();
            this.f51412c = create;
            create.setCanceledOnTouchOutside(this.k);
            g.i(this.f51412c, this.f51410a);
            c();
            e();
            Window window = this.f51412c.getWindow();
            if (this.m == -1) {
                this.m = 17;
            }
            window.setGravity(this.m);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f51410a);
            if (q != null) {
                int g2 = l.g(this.f51410a, R.dimen.M_W_X009);
                if (UtilHelper.getRealScreenOrientation(this.f51410a) == 2) {
                    attributes.width = q.heightPixels - (g2 * 2);
                } else {
                    attributes.width = q.widthPixels - (g2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f51413d);
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
