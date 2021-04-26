package d.a.h0.a.w0.c;

import android.content.Context;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import d.a.h0.a.p.c.r;
/* loaded from: classes2.dex */
public abstract class a implements r {
    @Override // d.a.h0.a.p.c.r
    public String K() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // d.a.h0.a.p.c.r
    public String L() {
        return null;
    }

    @Override // d.a.h0.a.p.c.r
    public String M() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // d.a.h0.a.p.c.r
    public boolean N() {
        return false;
    }

    @Override // d.a.h0.a.p.c.r
    public void d() {
    }

    @Override // d.a.h0.a.p.c.r
    public void i() {
    }

    @Override // d.a.h0.a.p.c.r
    public String l(String str) {
        return d.a.h0.a.b0.c.u(str);
    }

    @Override // d.a.h0.a.p.c.r
    public String o() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // d.a.h0.a.p.c.r
    public int r() {
        return 2;
    }

    @Override // d.a.h0.a.p.c.r
    public String x() {
        return null;
    }

    @Override // d.a.h0.a.p.c.r
    public String y() {
        return null;
    }

    @Override // d.a.h0.a.p.c.r
    public String z(Context context) {
        return null;
    }
}
