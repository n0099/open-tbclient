package d.b.h0.r.o;

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
    public final Activity f51074a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.b0.a f51075b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f51076c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f51077d;

    /* renamed from: e  reason: collision with root package name */
    public View f51078e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f51079f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f51080g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f51081h;
    public EMTextView i;
    public c l;
    public boolean j = false;
    public boolean k = true;
    public int m = -1;
    public View.OnClickListener n = new View$OnClickListenerC1098a();
    public View.OnClickListener o = new b();

    /* renamed from: d.b.h0.r.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1098a implements View.OnClickListener {
        public View$OnClickListenerC1098a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                a.this.l.onCancel();
                a.this.f51076c.dismiss();
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
                a.this.f51076c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onCancel();
    }

    public a(Activity activity) {
        this.f51074a = activity;
        this.f51077d = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public final void c() {
        d.b.h0.a.b0.a aVar = this.f51075b;
        if (aVar == null) {
            return;
        }
        this.f51079f.setText(aVar.y);
        this.f51080g.setText(this.f51075b.z);
        this.f51081h.setText(this.f51075b.A);
        this.i.setText(this.f51075b.B);
    }

    public a d() {
        if (this.j) {
            return this;
        }
        this.j = true;
        this.f51078e = this.f51077d.findViewById(R.id.root_dialog_view);
        this.f51079f = (EMTextView) this.f51077d.findViewById(R.id.title);
        this.f51080g = (EMTextView) this.f51077d.findViewById(R.id.content);
        this.f51081h = (EMTextView) this.f51077d.findViewById(R.id.cancel);
        this.i = (EMTextView) this.f51077d.findViewById(R.id.confirm);
        this.f51081h.setClickable(true);
        this.i.setClickable(true);
        this.f51081h.setOnClickListener(this.n);
        this.i.setOnClickListener(this.o);
        return this;
    }

    public final void e() {
        if (this.f51075b == null) {
            return;
        }
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f51078e);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        d.b.h0.r.u.c d3 = d.b.h0.r.u.c.d(this.f51079f);
        d3.v(R.string.F_X02);
        d3.q(R.color.CAM_X0105);
        d.b.h0.r.u.c.d(this.f51080g).q(R.color.CAM_X0107);
        d.b.h0.r.u.c d4 = d.b.h0.r.u.c.d(this.f51081h);
        d4.q(R.color.CAM_X0105);
        d4.k(R.string.J_X07);
        d4.i(R.dimen.L_X02);
        d4.h(R.color.CAM_X0902);
        d.b.h0.r.u.c d5 = d.b.h0.r.u.c.d(this.i);
        d5.q(R.color.CAM_X0304);
        d5.k(R.string.J_X07);
        d5.e(R.string.A_X07);
        d5.i(R.dimen.L_X02);
        d5.h(R.color.CAM_X0304);
    }

    public void f(d.b.h0.a.b0.a aVar) {
        this.f51075b = aVar;
    }

    public void g(c cVar) {
        this.l = cVar;
    }

    public a h() {
        if (this.j) {
            AlertDialog create = new AlertDialog.Builder(this.f51074a).create();
            this.f51076c = create;
            create.setCanceledOnTouchOutside(this.k);
            g.i(this.f51076c, this.f51074a);
            c();
            e();
            Window window = this.f51076c.getWindow();
            if (this.m == -1) {
                this.m = 17;
            }
            window.setGravity(this.m);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f51074a);
            if (q != null) {
                int g2 = l.g(this.f51074a, R.dimen.M_W_X009);
                if (UtilHelper.getRealScreenOrientation(this.f51074a) == 2) {
                    attributes.width = q.heightPixels - (g2 * 2);
                } else {
                    attributes.width = q.widthPixels - (g2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f51077d);
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
