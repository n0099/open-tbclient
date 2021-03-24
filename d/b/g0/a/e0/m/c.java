package d.b.g0.a.e0.m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import d.b.g0.a.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.z;
import d.b.g0.a.q1.b.b.b;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.q1.b.b.b {
    public View o;
    public TextView p;
    public SelectorTextView q;
    public C0666c r;

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

    /* renamed from: d.b.g0.a.e0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0666c extends b.C0761b {

        /* renamed from: g  reason: collision with root package name */
        public int f44087g;

        /* renamed from: h  reason: collision with root package name */
        public int f44088h;
        public int i;
        public b.c j;
        public b.c k;

        public C0666c(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public /* bridge */ /* synthetic */ g.a U(int i) {
            g0(i);
            return this;
        }

        @Override // d.b.g0.a.q1.b.b.b.C0761b, d.b.g0.a.q1.b.b.g.a
        public g c() {
            c cVar = (c) super.c();
            cVar.r(this);
            return cVar;
        }

        public C0666c e0(int i) {
            this.f44087g = i;
            return this;
        }

        public C0666c f0(int i, b.c cVar) {
            this.f44087g = i;
            this.k = cVar;
            return this;
        }

        public C0666c g0(int i) {
            super.U(i);
            return this;
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public g h(Context context) {
            return new c(context);
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public /* bridge */ /* synthetic */ g.a w(int i) {
            e0(i);
            return this;
        }
    }

    public c(Context context) {
        super(context);
    }

    @Override // d.b.g0.a.q1.b.b.b
    public View k(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.k).inflate(d.b.g0.a.g.aiapps_safe_dialog, viewGroup, false);
        this.o = inflate;
        TextView textView = (TextView) inflate.findViewById(f.safe_dialog_content);
        this.p = textView;
        textView.setTextColor(getContext().getResources().getColor(d.b.g0.a.c.aiapps_safe_dialog_message));
        SelectorTextView selectorTextView = (SelectorTextView) this.o.findViewById(f.safe_dialog_sub_content);
        this.q = selectorTextView;
        selectorTextView.setTextColor(getContext().getResources().getColor(d.b.g0.a.c.aiapps_safe_dialog_btn_blue));
        q();
        return this.o;
    }

    public final void q() {
        C0666c c0666c = this.r;
        if (c0666c == null) {
            return;
        }
        this.p.setText(this.k.getText(c0666c.f44087g));
        this.p.setOnClickListener(new a());
        if (this.r.f44088h > 0) {
            this.q.setVisibility(0);
            this.q.setText(this.k.getText(this.r.f44088h));
            this.q.setOnClickListener(new b());
        } else {
            this.q.setVisibility(8);
        }
        if (this.r.i > 0) {
            Drawable drawable = this.k.getResources().getDrawable(this.r.i);
            z.b(getContext(), drawable);
            drawable.setBounds(0, 0, h0.e(this.k, 12.0f), h0.e(this.k, 12.0f));
            this.q.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void r(C0666c c0666c) {
        this.r = c0666c;
    }
}
