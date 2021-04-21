package d.n.b.b.c;

import android.content.Context;
import d.n.b.b.a.c;
/* loaded from: classes6.dex */
public class a extends d.n.a.a.b {
    public Context q;

    public a(Context context, String str) {
        super(context, str);
        this.q = null;
        this.q = context;
        this.f67414c = d.n.a.a.a.a() + "/v2/r" + q();
    }

    @Override // d.n.a.a.b
    public boolean f(int i, byte[] bArr) {
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr.length == 37) {
                        com.pgl.sys.ces.b.f38374c = true;
                    } else {
                        com.pgl.sys.ces.b.f38374c = false;
                    }
                }
            } catch (Throwable unused) {
                com.pgl.sys.ces.b.f38374c = false;
            }
        }
        return true;
    }

    public String q() {
        String str;
        try {
            str = this.q.getPackageManager().getPackageInfo(this.q.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        return ((("?os=0&ver=0.6.11.30.08-PGL-Do-fix3&m=2&app_ver=" + str) + "&region=" + c.e(this.q)) + "&appkey=" + com.pgl.sys.ces.b.b()) + "&did=" + com.pgl.sys.ces.b.c();
    }
}
