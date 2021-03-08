package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.sys.ces.a.c;
/* loaded from: classes6.dex */
public class b extends com.pgl.a.a.b {
    private Context b;

    public b(Context context, String str) {
        super(context, str);
        this.b = null;
        this.b = context;
        this.f7470a = com.pgl.a.a.a.a() + "/v2/s" + a();
    }

    public String a() {
        String str = "";
        try {
            str = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((("?os=0&ver=0.6.11.30.08-PGL-Do-fix3&m=2&app_ver=" + str) + "&region=" + c.c(this.b)) + "&appkey=" + com.pgl.sys.ces.b.b()) + "&did=" + com.pgl.sys.ces.b.c();
    }

    @Override // com.pgl.a.a.b
    public boolean f(int i, byte[] bArr) {
        boolean z;
        String str;
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && (str = (String) com.pgl.sys.ces.a.meta(200, this.b, bArr)) != null && str.length() > 0) {
                    if (str.equalsIgnoreCase("AYE")) {
                        com.pgl.sys.ces.b.d = true;
                        z = true;
                        return z;
                    }
                    com.pgl.sys.ces.b.d = false;
                }
            } catch (Throwable th) {
                com.pgl.sys.ces.b.d = false;
                return false;
            }
        }
        z = false;
        return z;
    }
}
