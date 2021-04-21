package d.b.h0.a.i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import d.b.h0.a.e0.l.i;
import d.b.h0.a.g;
import d.b.h0.a.h;
/* loaded from: classes2.dex */
public class f extends i {

    /* loaded from: classes2.dex */
    public class a extends d.b.h0.a.e0.n.a {
        public a() {
        }

        @Override // d.b.h0.a.e0.n.a, d.b.h0.a.e0.n.d
        public boolean b(String str) {
            if (str != null && str.startsWith("weixin://wap/pay")) {
                d.b.h0.a.c0.c.g("SwanAppWxPayFragment", " weixin  url:   " + str);
                i.F2();
                return false;
            }
            return super.b(str);
        }
    }

    @Override // d.b.h0.a.e0.l.i
    public void D2(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(l()).inflate(g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // d.b.h0.a.e0.l.i
    public d.b.h0.a.e0.n.d G2() {
        return new a();
    }

    @Override // d.b.h0.a.e0.l.i, d.b.h0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        this.i0.setTitle(u().getString(h.aiapps_wx_pay_title));
        k2(false);
    }

    @Override // d.b.h0.a.e0.l.i
    public d.b.h0.a.p.d.e n() {
        return d.b.h0.a.e0.w.d.L().V().h(l());
    }
}
