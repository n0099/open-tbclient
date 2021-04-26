package d.a.i0.r.o;

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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f49028a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.b0.a f49029b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f49030c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f49031d;

    /* renamed from: e  reason: collision with root package name */
    public View f49032e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f49033f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f49034g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f49035h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f49036i;
    public c l;
    public boolean j = false;
    public boolean k = true;
    public int m = -1;
    public View.OnClickListener n = new View$OnClickListenerC1059a();
    public View.OnClickListener o = new b();

    /* renamed from: d.a.i0.r.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1059a implements View.OnClickListener {
        public View$OnClickListenerC1059a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                a.this.l.onCancel();
                a.this.f49030c.dismiss();
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
                a.this.f49030c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onCancel();
    }

    public a(Activity activity) {
        this.f49028a = activity;
        this.f49031d = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public final void c() {
        d.a.i0.a.b0.a aVar = this.f49029b;
        if (aVar == null) {
            return;
        }
        this.f49033f.setText(aVar.y);
        this.f49034g.setText(this.f49029b.z);
        this.f49035h.setText(this.f49029b.A);
        this.f49036i.setText(this.f49029b.B);
    }

    public a d() {
        if (this.j) {
            return this;
        }
        this.j = true;
        this.f49032e = this.f49031d.findViewById(R.id.root_dialog_view);
        this.f49033f = (EMTextView) this.f49031d.findViewById(R.id.title);
        this.f49034g = (EMTextView) this.f49031d.findViewById(R.id.content);
        this.f49035h = (EMTextView) this.f49031d.findViewById(R.id.cancel);
        this.f49036i = (EMTextView) this.f49031d.findViewById(R.id.confirm);
        this.f49035h.setClickable(true);
        this.f49036i.setClickable(true);
        this.f49035h.setOnClickListener(this.n);
        this.f49036i.setOnClickListener(this.o);
        return this;
    }

    public final void e() {
        if (this.f49029b == null) {
            return;
        }
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f49032e);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        d.a.i0.r.u.c d3 = d.a.i0.r.u.c.d(this.f49033f);
        d3.v(R.string.F_X02);
        d3.q(R.color.CAM_X0105);
        d.a.i0.r.u.c.d(this.f49034g).q(R.color.CAM_X0107);
        d.a.i0.r.u.c d4 = d.a.i0.r.u.c.d(this.f49035h);
        d4.q(R.color.CAM_X0105);
        d4.k(R.string.J_X07);
        d4.i(R.dimen.L_X02);
        d4.h(R.color.CAM_X0902);
        d.a.i0.r.u.c d5 = d.a.i0.r.u.c.d(this.f49036i);
        d5.q(R.color.CAM_X0304);
        d5.k(R.string.J_X07);
        d5.e(R.string.A_X07);
        d5.i(R.dimen.L_X02);
        d5.h(R.color.CAM_X0304);
    }

    public void f(d.a.i0.a.b0.a aVar) {
        this.f49029b = aVar;
    }

    public void g(c cVar) {
        this.l = cVar;
    }

    public a h() {
        if (this.j) {
            AlertDialog create = new AlertDialog.Builder(this.f49028a).create();
            this.f49030c = create;
            create.setCanceledOnTouchOutside(this.k);
            g.i(this.f49030c, this.f49028a);
            c();
            e();
            Window window = this.f49030c.getWindow();
            if (this.m == -1) {
                this.m = 17;
            }
            window.setGravity(this.m);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f49028a);
            if (q != null) {
                int g2 = l.g(this.f49028a, R.dimen.M_W_X009);
                if (UtilHelper.getRealScreenOrientation(this.f49028a) == 2) {
                    attributes.width = q.heightPixels - (g2 * 2);
                } else {
                    attributes.width = q.widthPixels - (g2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f49031d);
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
