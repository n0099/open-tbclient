package d.b.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.b.h0.a.q1.b.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f46267h;
    public FrameLayout i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f46268a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f46269b;

        /* renamed from: c  reason: collision with root package name */
        public int f46270c;

        /* renamed from: d  reason: collision with root package name */
        public int f46271d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f46272e;

        public a(CharSequence charSequence, int i, c cVar) {
            this.f46270c = -1;
            this.f46268a = charSequence;
            this.f46270c = i;
            this.f46272e = cVar;
        }
    }

    /* renamed from: d.b.h0.a.q1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0794b extends g.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f46273f;

        public C0794b(Context context) {
            super(context);
            this.f46273f = new ArrayList();
            k(false);
            u(false);
        }

        public C0794b a0(a aVar) {
            if (aVar != null) {
                this.f46273f.add(aVar);
            }
            return this;
        }

        @Override // d.b.h0.a.q1.b.b.g.a
        public g c() {
            b bVar = (b) super.c();
            bVar.n(this.f46273f);
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
        public TextView f46274a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46275b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f46276c;

        /* renamed from: d  reason: collision with root package name */
        public b f46277d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f46279e;

            public a(a aVar) {
                this.f46279e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f46277d.dismiss();
                c cVar = this.f46279e.f46272e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f46274a = (TextView) view.findViewById(d.b.h0.a.f.hv_btn_text);
                this.f46275b = (TextView) view.findViewById(d.b.h0.a.f.hv_btn_subtext);
                this.f46276c = (LinearLayout) view;
                this.f46277d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f46274a.setText(aVar.f46268a);
            if (aVar.f46270c > 0) {
                this.f46274a.setTextColor(b.this.i.getResources().getColor(aVar.f46270c));
            }
            if (!TextUtils.isEmpty(aVar.f46269b)) {
                this.f46275b.setVisibility(0);
                this.f46275b.setText(aVar.f46269b);
            } else {
                this.f46275b.setVisibility(8);
            }
            if (aVar.f46271d > 0) {
                this.f46275b.setTextColor(b.this.i.getResources().getColor(aVar.f46271d));
            }
            this.f46276c.setOnClickListener(new a(aVar));
        }
    }

    public b(Context context) {
        super(context, d.b.h0.a.i.NoTitleDialog);
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.b.h0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(d.b.h0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        view.setBackgroundColor(this.i.getResources().getColor(d.b.h0.a.c.aiapps_dialog_gray));
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.b.h0.a.g.aiapps_view_hv_dialog, c().e(), false);
        this.f46267h = viewGroup;
        this.i = (FrameLayout) viewGroup.findViewById(d.b.h0.a.f.hv_content);
        this.l = this.f46267h.findViewById(d.b.h0.a.f.hv_divider);
        this.j = (FrameLayout) this.f46267h.findViewById(d.b.h0.a.f.hv_btn_content);
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
        this.l.setBackgroundColor(getContext().getResources().getColor(d.b.h0.a.c.aiapps_dialog_gray));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        c().W(this.f46267h);
    }
}
