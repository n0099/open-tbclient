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
    public Context f61171a;

    /* renamed from: b  reason: collision with root package name */
    public View f61172b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61173c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61174d;

    /* renamed from: e  reason: collision with root package name */
    public View f61175e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61176f;

    /* renamed from: g  reason: collision with root package name */
    public String f61177g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f61178h;
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
        public h f61182b;

        /* renamed from: c  reason: collision with root package name */
        public View f61183c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61184d;

        /* renamed from: e  reason: collision with root package name */
        public View f61185e;

        /* renamed from: f  reason: collision with root package name */
        public String f61186f;

        /* renamed from: h  reason: collision with root package name */
        public e f61188h;

        /* renamed from: g  reason: collision with root package name */
        public int f61187g = 17;
        public boolean i = true;
        public final View.OnClickListener j = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f61181a = hashCode();

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f61188h != null) {
                    c.this.f61188h.onClick();
                }
                if (c.this.f61182b == null || c.this.f61182b.l() == null) {
                    return;
                }
                c.this.f61182b.l().onItemClick(c.this.f61181a);
            }
        }

        public c(String str, h hVar) {
            this.f61186f = str;
            this.f61182b = hVar;
            f();
            e();
        }

        public View d() {
            return this.f61183c;
        }

        public final void e() {
            TextView textView = this.f61184d;
            if (textView != null) {
                textView.setOnClickListener(this.j);
            }
        }

        public final void f() {
            h hVar = this.f61182b;
            if (hVar == null || hVar.k() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f61182b.k()).inflate(R.layout.bottom_up_list_dialog_item, this.f61182b.m(), false);
            this.f61183c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f61184d = textView;
            textView.setText(this.f61186f);
            this.f61184d.setGravity(this.f61187g);
            View findViewById = this.f61183c.findViewById(R.id.divider_line);
            this.f61185e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            SkinManager.setBackgroundResource(this.f61184d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f61184d, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.f61185e, R.color.CAM_X0204);
        }

        public void h(e eVar) {
            this.f61188h = eVar;
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
        this.f61171a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
        this.f61172b = inflate;
        this.f61173c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f61174d = (TextView) this.f61172b.findViewById(R.id.title);
        this.f61175e = this.f61172b.findViewById(R.id.title_divide_line);
        this.f61178h = new ArrayList();
        this.f61176f = (TextView) this.f61172b.findViewById(R.id.dialog_bottom_cancel_button);
        RadioButton radioButton = (RadioButton) this.f61172b.findViewById(R.id.comment_grade_1);
        this.l = radioButton;
        radioButton.setOnClickListener(this.s);
        RadioButton radioButton2 = (RadioButton) this.f61172b.findViewById(R.id.comment_grade_2);
        this.m = radioButton2;
        radioButton2.setOnClickListener(this.s);
        RadioButton radioButton3 = (RadioButton) this.f61172b.findViewById(R.id.comment_grade_3);
        this.n = radioButton3;
        radioButton3.setOnClickListener(this.s);
        RadioButton radioButton4 = (RadioButton) this.f61172b.findViewById(R.id.comment_grade_4);
        this.o = radioButton4;
        radioButton4.setOnClickListener(this.s);
        RadioButton radioButton5 = (RadioButton) this.f61172b.findViewById(R.id.comment_grade_5);
        this.p = radioButton5;
        radioButton5.setOnClickListener(this.s);
        this.q = (LinearLayout) this.f61172b.findViewById(R.id.comment_grade);
    }

    public View j() {
        if (!StringUtils.isNull(this.f61177g)) {
            this.f61174d.setText(this.f61177g);
        } else {
            this.f61174d.setVisibility(8);
        }
        if (this.j != null) {
            this.f61176f.setOnClickListener(new b());
        }
        n();
        return this.f61172b;
    }

    public Context k() {
        return this.f61171a;
    }

    public f l() {
        return this.i;
    }

    public ViewGroup m() {
        return this.f61173c;
    }

    public void n() {
        SkinManager.setBackgroundColor(this.f61174d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f61174d, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.f61175e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61176f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f61176f, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.q, R.drawable.bg_bottom_up_list_dialog_item);
        List<c> list = this.f61178h;
        if (list != null) {
            for (c cVar : list) {
                cVar.g();
            }
        }
    }

    public void o(int i) {
        this.f61176f.setVisibility(i);
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
        this.f61178h = list;
        this.f61173c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar != null) {
                this.f61173c.addView(cVar.d());
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
        this.f61174d.setPadding(i, i2, i3, i4);
    }

    public void x(int i) {
        this.f61174d.setTextSize(0, l.g(this.f61171a, i));
    }

    public void y(String str) {
        this.f61177g = str;
    }
}
