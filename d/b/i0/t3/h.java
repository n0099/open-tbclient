package d.b.i0.t3;

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
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f61170a;

    /* renamed from: b  reason: collision with root package name */
    public View f61171b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61172c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61173d;

    /* renamed from: e  reason: collision with root package name */
    public View f61174e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61175f;

    /* renamed from: g  reason: collision with root package name */
    public String f61176g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f61177h;
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
        public h f61181b;

        /* renamed from: c  reason: collision with root package name */
        public View f61182c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61183d;

        /* renamed from: e  reason: collision with root package name */
        public View f61184e;

        /* renamed from: f  reason: collision with root package name */
        public String f61185f;

        /* renamed from: h  reason: collision with root package name */
        public e f61187h;

        /* renamed from: g  reason: collision with root package name */
        public int f61186g = 17;
        public boolean i = true;
        public final View.OnClickListener j = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f61180a = hashCode();

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f61187h != null) {
                    c.this.f61187h.onClick();
                }
                if (c.this.f61181b == null || c.this.f61181b.l() == null) {
                    return;
                }
                c.this.f61181b.l().onItemClick(c.this.f61180a);
            }
        }

        public c(String str, h hVar) {
            this.f61185f = str;
            this.f61181b = hVar;
            f();
            e();
        }

        public View d() {
            return this.f61182c;
        }

        public final void e() {
            TextView textView = this.f61183d;
            if (textView != null) {
                textView.setOnClickListener(this.j);
            }
        }

        public final void f() {
            h hVar = this.f61181b;
            if (hVar == null || hVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f61181b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f61181b.m(), false);
            this.f61182c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f61183d = textView;
            textView.setText(this.f61185f);
            this.f61183d.setGravity(this.f61186g);
            View findViewById = this.f61182c.findViewById(R.id.divider_line);
            this.f61184e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            SkinManager.setBackgroundResource(this.f61183d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f61183d, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.f61184e, R.color.CAM_X0204);
        }

        public void h(e eVar) {
            this.f61187h = eVar;
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
        this.f61170a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f61171b = inflate;
        this.f61172c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f61173d = (TextView) this.f61171b.findViewById(R.id.title);
        this.f61174e = this.f61171b.findViewById(R.id.title_divide_line);
        this.f61177h = new ArrayList();
        this.f61175f = (TextView) this.f61171b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f61171b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f61171b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f61171b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f61171b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f61171b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f61171b.findViewById(R.id.comment_grade);
    }

    public View j() {
        if (!StringUtils.isNull(this.f61176g)) {
            this.f61173d.setText(this.f61176g);
        } else {
            this.f61173d.setVisibility(8);
        }
        if (this.j != null) {
            this.f61175f.setOnClickListener(new b());
        }
        n();
        return this.f61171b;
    }

    public Context k() {
        return this.f61170a;
    }

    public f l() {
        return this.i;
    }

    public ViewGroup m() {
        return this.f61172c;
    }

    public void n() {
        SkinManager.setBackgroundColor(this.f61173d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f61173d, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f61174e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61175f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f61175f, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
        List<c> list = this.f61177h;
        if (list != null) {
            for (c cVar : list) {
                cVar.g();
            }
        }
    }

    public void o(int i) {
        this.f61175f.setVisibility(i);
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
        this.f61177h = list;
        this.f61172c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar != null) {
                this.f61172c.addView(cVar.d());
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
        this.f61173d.setPadding(i, i2, i3, i4);
    }

    public void x(int i) {
        this.f61173d.setTextSize(0, l.g(this.f61170a, i));
    }

    public void y(String str) {
        this.f61176g = str;
    }
}
