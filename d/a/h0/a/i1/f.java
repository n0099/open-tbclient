package d.a.h0.a.i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.g;
import d.a.h0.a.h;
/* loaded from: classes3.dex */
public class f extends i {

    /* loaded from: classes3.dex */
    public class a extends d.a.h0.a.e0.n.a {
        public a() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public boolean b(String str) {
            if (str != null && str.startsWith("weixin://wap/pay")) {
                d.a.h0.a.c0.c.g("SwanAppWxPayFragment", " weixin  url:   " + str);
                i.E2();
                return false;
            }
            return super.b(str);
        }
    }

    @Override // d.a.h0.a.e0.l.i
    public void C2(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(m()).inflate(g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.e0.n.d F2() {
        return new a();
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public void L1(View view) {
        super.L1(view);
        this.i0.setTitle(t().getString(h.aiapps_wx_pay_title));
        j2(false);
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.p.d.e l() {
        return d.a.h0.a.e0.w.d.L().V().h(m());
    }
}
