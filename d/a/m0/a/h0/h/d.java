package d.a.m0.a.h0.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.z1.b.b.b;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class d extends d.a.m0.a.z1.b.b.b {
    public FrameLayout o;
    public a p;

    /* loaded from: classes3.dex */
    public static class a extends b.C0990b {

        /* renamed from: g  reason: collision with root package name */
        public View f45932g;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.m0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a U(int i2) {
            d0(i2);
            return this;
        }

        @Override // d.a.m0.a.z1.b.b.b.C0990b, d.a.m0.a.z1.b.b.h.a
        public h c() {
            d dVar = (d) super.c();
            dVar.q(this);
            return dVar;
        }

        public a c0(View view) {
            this.f45932g = view;
            return this;
        }

        public a d0(int i2) {
            super.U(i2);
            return this;
        }

        @Override // d.a.m0.a.z1.b.b.h.a
        public h h(Context context) {
            return new d(context);
        }
    }

    public d(Context context) {
        super(context);
    }

    @Override // d.a.m0.a.z1.b.b.b
    public View k(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.k).inflate(g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.o = (FrameLayout) inflate.findViewById(f.ssl_certificate_container);
        p();
        return inflate;
    }

    public final void p() {
        a aVar = this.p;
        if (aVar != null) {
            this.o.addView(aVar.f45932g);
        }
    }

    public void q(a aVar) {
        this.p = aVar;
    }
}
