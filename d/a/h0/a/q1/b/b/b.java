package d.a.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.h0.a.q1.b.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f43616h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f43617i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f43618a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f43619b;

        /* renamed from: c  reason: collision with root package name */
        public int f43620c;

        /* renamed from: d  reason: collision with root package name */
        public int f43621d = -1;

        /* renamed from: e  reason: collision with root package name */
        public c f43622e;

        public a(CharSequence charSequence, int i2, c cVar) {
            this.f43620c = -1;
            this.f43618a = charSequence;
            this.f43620c = i2;
            this.f43622e = cVar;
        }
    }

    /* renamed from: d.a.h0.a.q1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0733b extends g.a {

        /* renamed from: f  reason: collision with root package name */
        public List<a> f43623f;

        public C0733b(Context context) {
            super(context);
            this.f43623f = new ArrayList();
            k(false);
            u(false);
        }

        public C0733b a0(a aVar) {
            if (aVar != null) {
                this.f43623f.add(aVar);
            }
            return this;
        }

        @Override // d.a.h0.a.q1.b.b.g.a
        public g c() {
            b bVar = (b) super.c();
            bVar.n(this.f43623f);
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
        public TextView f43624a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43625b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f43626c;

        /* renamed from: d  reason: collision with root package name */
        public b f43627d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f43629e;

            public a(a aVar) {
                this.f43629e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f43627d.dismiss();
                c cVar = this.f43629e.f43622e;
                if (cVar != null) {
                    cVar.a(view);
                }
            }
        }

        public d(View view, b bVar) {
            if (view != null) {
                this.f43624a = (TextView) view.findViewById(d.a.h0.a.f.hv_btn_text);
                this.f43625b = (TextView) view.findViewById(d.a.h0.a.f.hv_btn_subtext);
                this.f43626c = (LinearLayout) view;
                this.f43627d = bVar;
            }
        }

        public void a(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f43624a.setText(aVar.f43618a);
            if (aVar.f43620c > 0) {
                this.f43624a.setTextColor(b.this.f43617i.getResources().getColor(aVar.f43620c));
            }
            if (!TextUtils.isEmpty(aVar.f43619b)) {
                this.f43625b.setVisibility(0);
                this.f43625b.setText(aVar.f43619b);
            } else {
                this.f43625b.setVisibility(8);
            }
            if (aVar.f43621d > 0) {
                this.f43625b.setTextColor(b.this.f43617i.getResources().getColor(aVar.f43621d));
            }
            this.f43626c.setOnClickListener(new a(aVar));
        }
    }

    public b(Context context) {
        super(context, d.a.h0.a.i.NoTitleDialog);
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.a.h0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(d.a.h0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        view.setBackgroundColor(this.f43617i.getResources().getColor(d.a.h0.a.c.aiapps_dialog_gray));
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.h0.a.g.aiapps_view_hv_dialog, c().e(), false);
        this.f43616h = viewGroup;
        this.f43617i = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.hv_content);
        this.l = this.f43616h.findViewById(d.a.h0.a.f.hv_divider);
        this.j = (FrameLayout) this.f43616h.findViewById(d.a.h0.a.f.hv_btn_content);
        View k = k(this.f43617i);
        if (k != null) {
            this.f43617i.addView(k);
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
        this.l.setBackgroundColor(getContext().getResources().getColor(d.a.h0.a.c.aiapps_dialog_gray));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        c().W(this.f43616h);
    }
}
