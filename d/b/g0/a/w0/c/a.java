package d.b.g0.a.w0.c;

import android.content.Context;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import d.b.g0.a.p.c.r;
/* loaded from: classes2.dex */
public abstract class a implements r {
    @Override // d.b.g0.a.p.c.r
    public String D() {
        return String.format("%s/ma/landingpage?t=service_agreement_m", "https://ossapi.baidu.com");
    }

    @Override // d.b.g0.a.p.c.r
    public String E() {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public String F() {
        return String.format("%s/pms", "https://ossapi.baidu.com");
    }

    @Override // d.b.g0.a.p.c.r
    public String H() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/navigate", BaseUrlManager.ONLINE_URL));
    }

    @Override // d.b.g0.a.p.c.r
    public int J() {
        return 2;
    }

    @Override // d.b.g0.a.p.c.r
    public boolean K() {
        return false;
    }

    @Override // d.b.g0.a.p.c.r
    public String e() {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public void g() {
    }

    @Override // d.b.g0.a.p.c.r
    public String h() {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public String i(Context context) {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public void u() {
    }

    @Override // d.b.g0.a.p.c.r
    public String z(String str) {
        return d.b.g0.a.b0.c.u(str);
    }
}
