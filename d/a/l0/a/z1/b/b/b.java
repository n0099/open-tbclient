package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.l0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends h {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f49721h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f49722i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f49723a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f49724b;

        /* renamed from: c  reason: collision with root package name */
        public int f49725c;

        /* renamed from: d  reason: collision with root package name */
        public int f49726d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f49727e;

        public a(CharSequence charSequence, int i2, c cVar) {
            this.f49725c = -1;
            this.f49723a = charSequence;
            this.f49725c = i2;
            this.f49727e = cVar;
        }
    }

    /* renamed from: d.a.l0.a.z1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0987b extends h.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f49728f;

        public C0987b(Context context) {
            super(context);
            this.f49728f = new ArrayList();
            k(false);
            t(false);
        }

        public C0987b a0(a aVar) {
            if (aVar != null) {
                this.f49728f.add(aVar);
            }
            return this;
        }

        @Override // d.a.l0.a.z1.b.b.h.a
        public h c() {
            b bVar = (b) super.c();
            bVar.n(this.f49728f);
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
        public TextView f49729a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49730b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f49731c;

        /* renamed from: d  reason: collision with root package name */
        public b f49732d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f49734e;

            public a(a aVar) {
                this.f49734e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f49732d.dismiss();
                c cVar = this.f49734e.f49727e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f49729a = (TextView) view.findViewById(d.a.l0.a.f.hv_btn_text);
                this.f49730b = (TextView) view.findViewById(d.a.l0.a.f.hv_btn_subtext);
                this.f49731c = (LinearLayout) view;
                this.f49732d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f49729a.setText(aVar.f49723a);
            if (aVar.f49725c > 0) {
                this.f49729a.setTextColor(b.this.f49722i.getResources().getColor(aVar.f49725c));
            }
            if (!TextUtils.isEmpty(aVar.f49724b)) {
                this.f49730b.setVisibility(0);
                this.f49730b.setText(aVar.f49724b);
            } else {
                this.f49730b.setVisibility(8);
            }
            if (aVar.f49726d > 0) {
                this.f49730b.setTextColor(b.this.f49722i.getResources().getColor(aVar.f49726d));
            }
            this.f49731c.setOnClickListener(new a(aVar));
        }
    }

    public b(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.a.l0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(d.a.l0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        for (int i2 = 0; i2 < list.size(); i2++) {
            linearLayout.addView(i(list.get(i2), linearLayout));
            if (i2 < list.size() - 1) {
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

    public final View l(int i2) {
        View view = new View(this.k);
        view.setBackgroundColor(this.f49722i.getResources().getColor(d.a.l0.a.c.aiapps_dialog_gray));
        if (i2 == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    public final void m() {
        Context context = getContext();
        this.k = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.l0.a.g.aiapps_view_hv_dialog, c().e(), false);
        this.f49721h = viewGroup;
        this.f49722i = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.hv_content);
        this.l = this.f49721h.findViewById(d.a.l0.a.f.hv_divider);
        this.j = (FrameLayout) this.f49721h.findViewById(d.a.l0.a.f.hv_btn_content);
        View k = k(this.f49722i);
        if (k != null) {
            this.f49722i.addView(k);
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
        this.l.setBackgroundColor(getContext().getResources().getColor(d.a.l0.a.c.aiapps_dialog_gray));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        c().W(this.f49721h);
    }
}
