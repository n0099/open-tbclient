package d.a.l0.a.q1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.h0.g.k;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class f extends k {
    public Timer E0;

    /* loaded from: classes3.dex */
    public class a extends d.a.l0.a.h0.j.a {
        public a() {
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void a(String str) {
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", "title: " + str);
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void b(int i2) {
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i2);
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public boolean c(String str) {
            if (str != null && str.startsWith("weixin://wap/pay")) {
                d.a.l0.a.e0.d.g("SwanAppWxPayFragment", " weixin  url:   " + str);
                d.a.l0.a.j2.k.F("wechatH5Action", "intoPayment", 0);
                f.this.E0.cancel();
                f.this.E0 = null;
                k.L2();
                return false;
            }
            return super.c(str);
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i2 + " description = " + str;
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", str3);
            d.a.l0.a.j2.k.D(false, "wechatH5Action", d.a.l0.a.q1.a.c(str2, str3));
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void e(String str) {
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", "url: " + str);
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void goBack() {
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", "goBack: ");
        }
    }

    /* loaded from: classes3.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
            d.a.l0.a.j2.k.F("wechatH5Action", "outOfTime", 0);
        }
    }

    @Override // d.a.l0.a.h0.g.k
    public void J2(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(q()).inflate(g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // d.a.l0.a.h0.g.k
    public d.a.l0.a.h0.j.d M2() {
        return new a();
    }

    @Override // d.a.l0.a.h0.g.k, d.a.l0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        this.i0.setTitle(z().getString(h.aiapps_wx_pay_title));
        p2(false);
    }

    public Timer V2() {
        d.a.l0.a.e0.d.h("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
        Timer timer = new Timer();
        try {
            timer.schedule(new b(), 10000L);
        } catch (Exception e2) {
            if (k.D0) {
                e2.printStackTrace();
            }
            d.a.l0.a.e0.d.h("SwanAppWxPayFragment", e2.getMessage());
        }
        return timer;
    }

    @Override // d.a.l0.a.h0.g.k
    public d.a.l0.a.p.e.e m() {
        if (this.E0 == null) {
            this.E0 = V2();
        }
        return d.a.l0.a.h0.u.g.N().X().g(q());
    }
}
