package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.b.g0.a.q1.b.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f45545h;
    public FrameLayout i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f45546a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f45547b;

        /* renamed from: c  reason: collision with root package name */
        public int f45548c;

        /* renamed from: d  reason: collision with root package name */
        public int f45549d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f45550e;

        public a(CharSequence charSequence, int i, c cVar) {
            this.f45548c = -1;
            this.f45546a = charSequence;
            this.f45548c = i;
            this.f45550e = cVar;
        }
    }

    /* renamed from: d.b.g0.a.q1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0761b extends g.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f45551f;

        public C0761b(Context context) {
            super(context);
            this.f45551f = new ArrayList();
            k(false);
            u(false);
        }

        public C0761b a0(a aVar) {
            if (aVar != null) {
                this.f45551f.add(aVar);
            }
            return this;
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public g c() {
            b bVar = (b) super.c();
            bVar.n(this.f45551f);
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f45552a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45553b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f45554c;

        /* renamed from: d  reason: collision with root package name */
        public b f45555d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f45557e;

            public a(a aVar) {
                this.f45557e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f45555d.dismiss();
                c cVar = this.f45557e.f45550e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f45552a = (TextView) view.findViewById(d.b.g0.a.f.hv_btn_text);
                this.f45553b = (TextView) view.findViewById(d.b.g0.a.f.hv_btn_subtext);
                this.f45554c = (LinearLayout) view;
                this.f45555d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f45552a.setText(aVar.f45546a);
            if (aVar.f45548c > 0) {
                this.f45552a.setTextColor(b.this.i.getResources().getColor(aVar.f45548c));
            }
            if (!TextUtils.isEmpty(aVar.f45547b)) {
                this.f45553b.setVisibility(0);
                this.f45553b.setText(aVar.f45547b);
            } else {
                this.f45553b.setVisibility(8);
            }
            if (aVar.f45549d > 0) {
                this.f45553b.setTextColor(b.this.i.getResources().getColor(aVar.f45549d));
            }
            this.f45554c.setOnClickListener(new a(aVar));
        }
    }

    public b(Context context) {
        super(context, d.b.g0.a.i.NoTitleDialog);
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.b.g0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).a(aVar);
        return linearLayout2;
    }

    public final void j(List<a> list) {
        if (list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.k);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (list.size() > this.n) {
            linearLayout.setOrientation(1);
        } else {
            linearLayout.setOrientation(0);
        }
        for (int i = 0; i < list.size(); i++) {
            linearLayout.addView(i(list.get(i), linearLayout));
            if (i < list.size() - 1) {
                if (list.size() > this.n) {
                    linearLayout.addView(l(1));
                } else {
                    linearLayout.addView(l(0));
                }
            }
        }
        this.j.removeAllViews();
        this.j.addView(linearLayout);
    }

    public View k(ViewGroup viewGroup) {
        return null;
    }

    public final View l(int i) {
        View view = new View(this.k);
        view.setBackgroundColor(this.i.getResources().getColor(d.b.g0.a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    public final void m() {
        Context context = getContext();
        this.k = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.b.g0.a.g.aiapps_view_hv_dialog, c().e(), false);
        this.f45545h = viewGroup;
        this.i = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.hv_content);
        this.l = this.f45545h.findViewById(d.b.g0.a.f.hv_divider);
        this.j = (FrameLayout) this.f45545h.findViewById(d.b.g0.a.f.hv_btn_content);
        View k = k(this.i);
        if (k != null) {
            this.i.addView(k);
        }
        o();
        j(this.m);
    }

    public final void n(List<a> list) {
        this.m.clear();
        if (list != null) {
            this.m.addAll(list);
        }
    }

    public final void o() {
        this.l.setBackgroundColor(getContext().getResources().getColor(d.b.g0.a.c.aiapps_dialog_gray));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        c().W(this.f45545h);
    }
}
