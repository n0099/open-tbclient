package d.a.k0.u3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f62228a;

    /* renamed from: b  reason: collision with root package name */
    public View f62229b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62230c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62231d;

    /* renamed from: e  reason: collision with root package name */
    public View f62232e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62233f;

    /* renamed from: g  reason: collision with root package name */
    public String f62234g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f62235h;

    /* renamed from: i  reason: collision with root package name */
    public f f62236i;
    public d j;
    public g k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public LinearLayout q;
    public int r;
    public View.OnClickListener s = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.l) {
                h.this.m.setChecked(false);
                h.this.n.setChecked(false);
                h.this.o.setChecked(false);
                h.this.p.setChecked(false);
                h.this.r = 1;
            } else if (view == h.this.m) {
                h.this.l.setChecked(true);
                h.this.n.setChecked(false);
                h.this.o.setChecked(false);
                h.this.p.setChecked(false);
                h.this.r = 2;
            } else if (view == h.this.n) {
                h.this.l.setChecked(true);
                h.this.m.setChecked(true);
                h.this.o.setChecked(false);
                h.this.p.setChecked(false);
                h.this.r = 3;
            } else if (view == h.this.o) {
                h.this.l.setChecked(true);
                h.this.m.setChecked(true);
                h.this.n.setChecked(true);
                h.this.p.setChecked(false);
                h.this.r = 4;
            } else if (view == h.this.p) {
                h.this.l.setChecked(true);
                h.this.m.setChecked(true);
                h.this.n.setChecked(true);
                h.this.o.setChecked(true);
                h.this.r = 5;
            }
            if (h.this.k != null) {
                h.this.k.onClick(h.this.r);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        public h f62240b;

        /* renamed from: c  reason: collision with root package name */
        public View f62241c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62242d;

        /* renamed from: e  reason: collision with root package name */
        public View f62243e;

        /* renamed from: f  reason: collision with root package name */
        public String f62244f;

        /* renamed from: h  reason: collision with root package name */
        public e f62246h;

        /* renamed from: g  reason: collision with root package name */
        public int f62245g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f62247i = true;
        public final View.OnClickListener j = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f62239a = hashCode();

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f62246h != null) {
                    c.this.f62246h.onClick();
                }
                if (c.this.f62240b == null || c.this.f62240b.l() == null) {
                    return;
                }
                c.this.f62240b.l().onItemClick(c.this.f62239a);
            }
        }

        public c(String str, h hVar) {
            this.f62244f = str;
            this.f62240b = hVar;
            f();
            e();
        }

        public View d() {
            return this.f62241c;
        }

        public final void e() {
            TextView textView = this.f62242d;
            if (textView != null) {
                textView.setOnClickListener(this.j);
            }
        }

        public final void f() {
            h hVar = this.f62240b;
            if (hVar == null || hVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f62240b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f62240b.m(), false);
            this.f62241c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f62242d = textView;
            textView.setText(this.f62244f);
            this.f62242d.setGravity(this.f62245g);
            View findViewById = this.f62241c.findViewById(R.id.divider_line);
            this.f62243e = findViewById;
            if (this.f62247i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            SkinManager.setBackgroundResource(this.f62242d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f62242d, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.f62243e, R.color.CAM_X0204);
        }

        public void h(e eVar) {
            this.f62246h = eVar;
            e();
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface e {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onItemClick(int i2);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onClick(int i2);
    }

    public h(Context context) {
        if (context == null) {
            return;
        }
        this.f62228a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f62229b = inflate;
        this.f62230c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f62231d = (TextView) this.f62229b.findViewById(R.id.title);
        this.f62232e = this.f62229b.findViewById(R.id.title_divide_line);
        this.f62235h = new ArrayList();
        this.f62233f = (TextView) this.f62229b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f62229b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f62229b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f62229b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f62229b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f62229b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f62229b.findViewById(R.id.comment_grade);
    }

    public View j() {
        if (!StringUtils.isNull(this.f62234g)) {
            this.f62231d.setText(this.f62234g);
        } else {
            this.f62231d.setVisibility(8);
        }
        if (this.j != null) {
            this.f62233f.setOnClickListener(new b());
        }
        n();
        return this.f62229b;
    }

    public Context k() {
        return this.f62228a;
    }

    public f l() {
        return this.f62236i;
    }

    public ViewGroup m() {
        return this.f62230c;
    }

    public void n() {
        SkinManager.setBackgroundColor(this.f62231d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f62231d, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f62232e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62233f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f62233f, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
        List<c> list = this.f62235h;
        if (list != null) {
            for (c cVar : list) {
                cVar.g();
            }
        }
    }

    public void o(int i2) {
        this.f62233f.setVisibility(i2);
    }

    public void p(boolean z) {
        this.l.setEnabled(z);
        this.m.setEnabled(z);
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setEnabled(z);
    }

    public void q(int i2, int i3, int i4, int i5) {
        this.q.setPadding(i2, i3, i4, i5);
    }

    public void r(int i2) {
        if (i2 == 1) {
            this.l.setChecked(true);
            this.m.setChecked(false);
            this.n.setChecked(false);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i2 == 2) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(false);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i2 == 3) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i2 == 4) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(true);
            this.p.setChecked(false);
        } else if (i2 != 5) {
        } else {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(true);
            this.p.setChecked(true);
        }
    }

    public void s(int i2) {
        this.q.setVisibility(i2);
    }

    public void t(List<c> list) {
        if (list == null) {
            return;
        }
        this.f62235h = list;
        this.f62230c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                this.f62230c.addView(cVar.d());
            }
        }
    }

    public void u(d dVar) {
        this.j = dVar;
    }

    public void v(g gVar) {
        this.k = gVar;
    }

    public void w(int i2, int i3, int i4, int i5) {
        this.f62231d.setPadding(i2, i3, i4, i5);
    }

    public void x(int i2) {
        this.f62231d.setTextSize(0, l.g(this.f62228a, i2));
    }

    public void y(String str) {
        this.f62234g = str;
    }
}
