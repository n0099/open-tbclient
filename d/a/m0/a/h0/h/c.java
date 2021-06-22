package d.a.m0.a.h0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.v2.b0;
import d.a.m0.a.v2.n0;
import d.a.m0.a.z1.b.b.b;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.z1.b.b.b {
    public View o;
    public TextView p;
    public SelectorTextView q;
    public C0724c r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.r.k != null) {
                c.this.r.k.a(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.r.j != null) {
                c.this.r.j.a(view);
            }
        }
    }

    /* renamed from: d.a.m0.a.h0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0724c extends b.C0990b {

        /* renamed from: g  reason: collision with root package name */
        public int f45929g;

        /* renamed from: h  reason: collision with root package name */
        public int f45930h;

        /* renamed from: i  reason: collision with root package name */
        public int f45931i;
        public b.c j;
        public b.c k;

        public C0724c(Context context) {
            super(context);
        }

        @Override // d.a.m0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a U(int i2) {
            g0(i2);
            return this;
        }

        @Override // d.a.m0.a.z1.b.b.b.C0990b, d.a.m0.a.z1.b.b.h.a
        public h c() {
            c cVar = (c) super.c();
            cVar.r(this);
            return cVar;
        }

        public C0724c e0(int i2) {
            this.f45929g = i2;
            return this;
        }

        public C0724c f0(int i2, b.c cVar) {
            this.f45929g = i2;
            this.k = cVar;
            return this;
        }

        public C0724c g0(int i2) {
            super.U(i2);
            return this;
        }

        @Override // d.a.m0.a.z1.b.b.h.a
        public h h(Context context) {
            return new c(context);
        }

        @Override // d.a.m0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a v(int i2) {
            e0(i2);
            return this;
        }
    }

    public c(Context context) {
        super(context);
    }

    @Override // d.a.m0.a.z1.b.b.b
    public View k(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.k).inflate(g.aiapps_safe_dialog, viewGroup, false);
        this.o = inflate;
        TextView textView = (TextView) inflate.findViewById(f.safe_dialog_content);
        this.p = textView;
        textView.setTextColor(getContext().getResources().getColor(d.a.m0.a.c.aiapps_safe_dialog_message));
        SelectorTextView selectorTextView = (SelectorTextView) this.o.findViewById(f.safe_dialog_sub_content);
        this.q = selectorTextView;
        selectorTextView.setTextColor(getContext().getResources().getColor(d.a.m0.a.c.aiapps_safe_dialog_btn_blue));
        q();
        return this.o;
    }

    public final void q() {
        C0724c c0724c = this.r;
        if (c0724c == null) {
            return;
        }
        this.p.setText(this.k.getText(c0724c.f45929g));
        this.p.setOnClickListener(new a());
        if (this.r.f45930h > 0) {
            this.q.setVisibility(0);
            this.q.setText(this.k.getText(this.r.f45930h));
            this.q.setOnClickListener(new b());
        } else {
            this.q.setVisibility(8);
        }
        if (this.r.f45931i > 0) {
            Drawable drawable = this.k.getResources().getDrawable(this.r.f45931i);
            b0.b(getContext(), drawable);
            drawable.setBounds(0, 0, n0.f(this.k, 12.0f), n0.f(this.k, 12.0f));
            this.q.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void r(C0724c c0724c) {
        this.r = c0724c;
    }
}
