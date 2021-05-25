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
    public ViewGroup f46047h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f46048i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f46049a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f46050b;

        /* renamed from: c  reason: collision with root package name */
        public int f46051c;

        /* renamed from: d  reason: collision with root package name */
        public int f46052d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f46053e;

        public a(CharSequence charSequence, int i2, c cVar) {
            this.f46051c = -1;
            this.f46049a = charSequence;
            this.f46051c = i2;
            this.f46053e = cVar;
        }
    }

    /* renamed from: d.a.l0.a.z1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0931b extends h.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f46054f;

        public C0931b(Context context) {
            super(context);
            this.f46054f = new ArrayList();
            k(false);
            t(false);
        }

        public C0931b a0(a aVar) {
            if (aVar != null) {
                this.f46054f.add(aVar);
            }
            return this;
        }

        @Override // d.a.l0.a.z1.b.b.h.a
        public h c() {
            b bVar = (b) super.c();
            bVar.n(this.f46054f);
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
        public TextView f46055a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46056b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f46057c;

        /* renamed from: d  reason: collision with root package name */
        public b f46058d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f46060e;

            public a(a aVar) {
                this.f46060e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f46058d.dismiss();
                c cVar = this.f46060e.f46053e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f46055a = (TextView) view.findViewById(d.a.l0.a.f.hv_btn_text);
                this.f46056b = (TextView) view.findViewById(d.a.l0.a.f.hv_btn_subtext);
                this.f46057c = (LinearLayout) view;
                this.f46058d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f46055a.setText(aVar.f46049a);
            if (aVar.f46051c > 0) {
                this.f46055a.setTextColor(b.this.f46048i.getResources().getColor(aVar.f46051c));
            }
            if (!TextUtils.isEmpty(aVar.f46050b)) {
                this.f46056b.setVisibility(0);
                this.f46056b.setText(aVar.f46050b);
            } else {
                this.f46056b.setVisibility(8);
            }
            if (aVar.f46052d > 0) {
                this.f46056b.setTextColor(b.this.f46048i.getResources().getColor(aVar.f46052d));
            }
            this.f46057c.setOnClickListener(new a(aVar));
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
        view.setBackgroundColor(this.f46048i.getResources().getColor(d.a.l0.a.c.aiapps_dialog_gray));
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
        this.f46047h = viewGroup;
        this.f46048i = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.hv_content);
        this.l = this.f46047h.findViewById(d.a.l0.a.f.hv_divider);
        this.j = (FrameLayout) this.f46047h.findViewById(d.a.l0.a.f.hv_btn_content);
        View k = k(this.f46048i);
        if (k != null) {
            this.f46048i.addView(k);
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
        c().W(this.f46047h);
    }
}
