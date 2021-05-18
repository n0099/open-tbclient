package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.i0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends h {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f45871h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f45872i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f45873a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f45874b;

        /* renamed from: c  reason: collision with root package name */
        public int f45875c;

        /* renamed from: d  reason: collision with root package name */
        public int f45876d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f45877e;

        public a(CharSequence charSequence, int i2, c cVar) {
            this.f45875c = -1;
            this.f45873a = charSequence;
            this.f45875c = i2;
            this.f45877e = cVar;
        }
    }

    /* renamed from: d.a.i0.a.z1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0920b extends h.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f45878f;

        public C0920b(Context context) {
            super(context);
            this.f45878f = new ArrayList();
            k(false);
            t(false);
        }

        public C0920b a0(a aVar) {
            if (aVar != null) {
                this.f45878f.add(aVar);
            }
            return this;
        }

        @Override // d.a.i0.a.z1.b.b.h.a
        public h c() {
            b bVar = (b) super.c();
            bVar.n(this.f45878f);
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
        public TextView f45879a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45880b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f45881c;

        /* renamed from: d  reason: collision with root package name */
        public b f45882d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f45884e;

            public a(a aVar) {
                this.f45884e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f45882d.dismiss();
                c cVar = this.f45884e.f45877e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f45879a = (TextView) view.findViewById(d.a.i0.a.f.hv_btn_text);
                this.f45880b = (TextView) view.findViewById(d.a.i0.a.f.hv_btn_subtext);
                this.f45881c = (LinearLayout) view;
                this.f45882d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f45879a.setText(aVar.f45873a);
            if (aVar.f45875c > 0) {
                this.f45879a.setTextColor(b.this.f45872i.getResources().getColor(aVar.f45875c));
            }
            if (!TextUtils.isEmpty(aVar.f45874b)) {
                this.f45880b.setVisibility(0);
                this.f45880b.setText(aVar.f45874b);
            } else {
                this.f45880b.setVisibility(8);
            }
            if (aVar.f45876d > 0) {
                this.f45880b.setTextColor(b.this.f45872i.getResources().getColor(aVar.f45876d));
            }
            this.f45881c.setOnClickListener(new a(aVar));
        }
    }

    public b(Context context) {
        super(context, d.a.i0.a.i.SwanAppNoTitleDialog);
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.a.i0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(d.a.i0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        view.setBackgroundColor(this.f45872i.getResources().getColor(d.a.i0.a.c.aiapps_dialog_gray));
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.i0.a.g.aiapps_view_hv_dialog, c().e(), false);
        this.f45871h = viewGroup;
        this.f45872i = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.hv_content);
        this.l = this.f45871h.findViewById(d.a.i0.a.f.hv_divider);
        this.j = (FrameLayout) this.f45871h.findViewById(d.a.i0.a.f.hv_btn_content);
        View k = k(this.f45872i);
        if (k != null) {
            this.f45872i.addView(k);
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
        this.l.setBackgroundColor(getContext().getResources().getColor(d.a.i0.a.c.aiapps_dialog_gray));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        c().W(this.f45871h);
    }
}
