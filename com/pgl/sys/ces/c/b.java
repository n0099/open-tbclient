package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.sys.ces.a.c;
/* loaded from: classes4.dex */
public class b extends com.pgl.a.a.b {

    /* renamed from: b  reason: collision with root package name */
    private Context f11704b;

    public b(Context context, String str) {
        super(context, str);
        this.f11704b = null;
        this.f11704b = context;
        this.f11681a = com.pgl.a.a.a.a() + "/v2/s" + a();
    }

    public String a() {
        String str = "";
        try {
            str = this.f11704b.getPackageManager().getPackageInfo(this.f11704b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((("?os=0&ver=0.6.11.30.02-PGL-Do&m=2&app_ver=" + str) + "&region=" + c.c(this.f11704b)) + "&appkey=" + com.pgl.sys.ces.b.b()) + "&did=" + com.pgl.sys.ces.b.c();
    }

    @Override // com.pgl.a.a.b
    public boolean f(int i, byte[] bArr) {
        boolean z;
        String str;
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && (str = (String) com.pgl.sys.ces.a.meta(200, this.f11704b, bArr)) != null && str.length() > 0) {
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
