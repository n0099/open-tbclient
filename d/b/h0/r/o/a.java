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
import d.b.b.e.m.g;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f50666a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.b0.a f50667b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f50668c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f50669d;

    /* renamed from: e  reason: collision with root package name */
    public View f50670e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f50671f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f50672g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f50673h;
    public EMTextView i;
    public c l;
    public boolean j = false;
    public boolean k = true;
    public int m = -1;
    public View.OnClickListener n = new View$OnClickListenerC1084a();
    public View.OnClickListener o = new b();

    /* renamed from: d.b.h0.r.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1084a implements View.OnClickListener {
        public View$OnClickListenerC1084a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                a.this.l.onCancel();
                a.this.f50668c.dismiss();
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
                a.this.f50668c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onCancel();
    }

    public a(Activity activity) {
        this.f50666a = activity;
        this.f50669d = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public final void c() {
        d.b.h0.a.b0.a aVar = this.f50667b;
        if (aVar == null) {
            return;
        }
        this.f50671f.setText(aVar.y);
        this.f50672g.setText(this.f50667b.z);
        this.f50673h.setText(this.f50667b.A);
        this.i.setText(this.f50667b.B);
    }

    public a d() {
        if (this.j) {
            return this;
        }
        this.j = true;
        this.f50670e = this.f50669d.findViewById(R.id.root_dialog_view);
        this.f50671f = (EMTextView) this.f50669d.findViewById(R.id.title);
        this.f50672g = (EMTextView) this.f50669d.findViewById(R.id.content);
        this.f50673h = (EMTextView) this.f50669d.findViewById(R.id.cancel);
        this.i = (EMTextView) this.f50669d.findViewById(R.id.confirm);
        this.f50673h.setClickable(true);
        this.i.setClickable(true);
        this.f50673h.setOnClickListener(this.n);
        this.i.setOnClickListener(this.o);
        return this;
    }

    public final void e() {
        if (this.f50667b == null) {
            return;
        }
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f50670e);
        a2.h(R.string.J_X06);
        a2.c(R.color.CAM_X0201);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.f50671f);
        a3.s(R.string.F_X02);
        a3.n(R.color.CAM_X0105);
        d.b.h0.r.u.c.a(this.f50672g).n(R.color.CAM_X0107);
        d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(this.f50673h);
        a4.n(R.color.CAM_X0105);
        a4.h(R.string.J_X07);
        a4.f(R.dimen.L_X02);
        a4.e(R.color.CAM_X0902);
        d.b.h0.r.u.c a5 = d.b.h0.r.u.c.a(this.i);
        a5.n(R.color.CAM_X0304);
        a5.h(R.string.J_X07);
        a5.b(R.string.A_X07);
        a5.f(R.dimen.L_X02);
        a5.e(R.color.CAM_X0304);
    }

    public void f(d.b.h0.a.b0.a aVar) {
        this.f50667b = aVar;
    }

    public void g(c cVar) {
        this.l = cVar;
    }

    public a h() {
        if (this.j) {
            AlertDialog create = new AlertDialog.Builder(this.f50666a).create();
            this.f50668c = create;
            create.setCanceledOnTouchOutside(this.k);
            g.i(this.f50668c, this.f50666a);
            c();
            e();
            Window window = this.f50668c.getWindow();
            if (this.m == -1) {
                this.m = 17;
            }
            window.setGravity(this.m);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f50666a);
            if (q != null) {
                int g2 = l.g(this.f50666a, R.dimen.M_W_X009);
                if (UtilHelper.getRealScreenOrientation(this.f50666a) == 2) {
                    attributes.width = q.heightPixels - (g2 * 2);
                } else {
                    attributes.width = q.widthPixels - (g2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f50669d);
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
