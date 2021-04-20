package d.b.g0.a.e0.m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.b.g0.a.f;
import d.b.g0.a.q1.b.b.b;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.q1.b.b.b {
    public FrameLayout o;
    public a p;

    /* loaded from: classes2.dex */
    public static class a extends b.C0774b {

        /* renamed from: g  reason: collision with root package name */
        public View f44482g;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public /* bridge */ /* synthetic */ g.a U(int i) {
            d0(i);
            return this;
        }

        @Override // d.b.g0.a.q1.b.b.b.C0774b, d.b.g0.a.q1.b.b.g.a
        public g c() {
            d dVar = (d) super.c();
            dVar.q(this);
            return dVar;
        }

        public a c0(View view) {
            this.f44482g = view;
            return this;
        }

        public a d0(int i) {
            super.U(i);
            return this;
        }

        @Override // d.b.g0.a.q1.b.b.g.a
        public g h(Context context) {
            return new d(context);
        }
    }

    public d(Context context) {
        super(context);
    }

    @Override // d.b.g0.a.q1.b.b.b
    public View k(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.k).inflate(d.b.g0.a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.o = (FrameLayout) inflate.findViewById(f.ssl_certificate_container);
        p();
        return inflate;
    }

    public final void p() {
        a aVar = this.p;
        if (aVar != null) {
            this.o.addView(aVar.f44482g);
        }
    }

    public void q(a aVar) {
        this.p = aVar;
    }
}
