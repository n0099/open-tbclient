package d.b.j0.u3;

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
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f63281a;

    /* renamed from: b  reason: collision with root package name */
    public View f63282b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f63283c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63284d;

    /* renamed from: e  reason: collision with root package name */
    public View f63285e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63286f;

    /* renamed from: g  reason: collision with root package name */
    public String f63287g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f63288h;
    public f i;
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
                h.this.k.a(h.this.r);
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
        public h f63292b;

        /* renamed from: c  reason: collision with root package name */
        public View f63293c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63294d;

        /* renamed from: e  reason: collision with root package name */
        public View f63295e;

        /* renamed from: f  reason: collision with root package name */
        public String f63296f;

        /* renamed from: h  reason: collision with root package name */
        public e f63298h;

        /* renamed from: g  reason: collision with root package name */
        public int f63297g = 17;
        public boolean i = true;
        public final View.OnClickListener j = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f63291a = hashCode();

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f63298h != null) {
                    c.this.f63298h.onClick();
                }
                if (c.this.f63292b == null || c.this.f63292b.l() == null) {
                    return;
                }
                c.this.f63292b.l().onItemClick(c.this.f63291a);
            }
        }

        public c(String str, h hVar) {
            this.f63296f = str;
            this.f63292b = hVar;
            f();
            e();
        }

        public View d() {
            return this.f63293c;
        }

        public final void e() {
            TextView textView = this.f63294d;
            if (textView != null) {
                textView.setOnClickListener(this.j);
            }
        }

        public final void f() {
            h hVar = this.f63292b;
            if (hVar == null || hVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f63292b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f63292b.m(), false);
            this.f63293c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f63294d = textView;
            textView.setText(this.f63296f);
            this.f63294d.setGravity(this.f63297g);
            View findViewById = this.f63293c.findViewById(R.id.divider_line);
            this.f63295e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            SkinManager.setBackgroundResource(this.f63294d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f63294d, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.f63295e, R.color.CAM_X0204);
        }

        public void h(e eVar) {
            this.f63298h = eVar;
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
        void onItemClick(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(int i);
    }

    public h(Context context) {
        if (context == null) {
            return;
        }
        this.f63281a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f63282b = inflate;
        this.f63283c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f63284d = (TextView) this.f63282b.findViewById(R.id.title);
        this.f63285e = this.f63282b.findViewById(R.id.title_divide_line);
        this.f63288h = new ArrayList();
        this.f63286f = (TextView) this.f63282b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f63282b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f63282b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f63282b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f63282b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f63282b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f63282b.findViewById(R.id.comment_grade);
    }

    public View j() {
        if (!StringUtils.isNull(this.f63287g)) {
            this.f63284d.setText(this.f63287g);
        } else {
            this.f63284d.setVisibility(8);
        }
        if (this.j != null) {
            this.f63286f.setOnClickListener(new b());
        }
        n();
        return this.f63282b;
    }

    public Context k() {
        return this.f63281a;
    }

    public f l() {
        return this.i;
    }

    public ViewGroup m() {
        return this.f63283c;
    }

    public void n() {
        SkinManager.setBackgroundColor(this.f63284d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f63284d, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f63285e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f63286f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f63286f, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
        List<c> list = this.f63288h;
        if (list != null) {
            for (c cVar : list) {
                cVar.g();
            }
        }
    }

    public void o(int i) {
        this.f63286f.setVisibility(i);
    }

    public void p(boolean z) {
        this.l.setEnabled(z);
        this.m.setEnabled(z);
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setEnabled(z);
    }

    public void q(int i, int i2, int i3, int i4) {
        this.q.setPadding(i, i2, i3, i4);
    }

    public void r(int i) {
        if (i == 1) {
            this.l.setChecked(true);
            this.m.setChecked(false);
            this.n.setChecked(false);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i == 2) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(false);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i == 3) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(false);
            this.p.setChecked(false);
        } else if (i == 4) {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(true);
            this.p.setChecked(false);
        } else if (i != 5) {
        } else {
            this.l.setChecked(true);
            this.m.setChecked(true);
            this.n.setChecked(true);
            this.o.setChecked(true);
            this.p.setChecked(true);
        }
    }

    public void s(int i) {
        this.q.setVisibility(i);
    }

    public void t(List<c> list) {
        if (list == null) {
            return;
        }
        this.f63288h = list;
        this.f63283c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar != null) {
                this.f63283c.addView(cVar.d());
            }
        }
    }

    public void u(d dVar) {
        this.j = dVar;
    }

    public void v(g gVar) {
        this.k = gVar;
    }

    public void w(int i, int i2, int i3, int i4) {
        this.f63284d.setPadding(i, i2, i3, i4);
    }

    public void x(int i) {
        this.f63284d.setTextSize(0, l.g(this.f63281a, i));
    }

    public void y(String str) {
        this.f63287g = str;
    }
}
