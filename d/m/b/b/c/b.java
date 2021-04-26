package d.m.b.b.c;

import android.content.Context;
import d.m.b.b.a.c;
/* loaded from: classes6.dex */
public class b extends d.m.a.a.b {
    public Context q;

    public b(Context context, String str) {
        super(context, str);
        this.q = null;
        this.q = context;
        this.f65742c = d.m.a.a.a.a() + "/v2/s" + q();
    }

    @Override // d.m.a.a.b
    public boolean f(int i2, byte[] bArr) {
        String str;
        boolean z = true;
        if (i2 == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && (str = (String) com.pgl.sys.ces.a.meta(200, this.q, bArr)) != null && str.length() > 0) {
                    if (str.equalsIgnoreCase("AYE")) {
                        com.pgl.sys.ces.b.f35942d = true;
                        return z;
                    }
                    com.pgl.sys.ces.b.f35942d = false;
                }
            } catch (Throwable unused) {
                com.pgl.sys.ces.b.f35942d = false;
                return false;
            }
        }
        z = false;
        return z;
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
