package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.sys.ces.a.c;
/* loaded from: classes6.dex */
public class a extends com.pgl.a.a.b {
    private Context b;

    public a(Context context, String str) {
        super(context, str);
        this.b = null;
        this.b = context;
        this.f7470a = com.pgl.a.a.a.a() + "/v2/r" + a();
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
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr.length == 37) {
                        com.pgl.sys.ces.b.c = true;
                    } else {
                        com.pgl.sys.ces.b.c = false;
                    }
                }
            } catch (Throwable th) {
                com.pgl.sys.ces.b.c = false;
            }
        }
        return true;
    }
}
