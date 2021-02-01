package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.sys.ces.a.c;
/* loaded from: classes6.dex */
public class a extends com.pgl.a.a.b {

    /* renamed from: b  reason: collision with root package name */
    private Context f11406b;

    public a(Context context, String str) {
        super(context, str);
        this.f11406b = null;
        this.f11406b = context;
        this.f11384a = com.pgl.a.a.a.a() + "/v2/r" + a();
    }

    public String a() {
        String str = "";
        try {
            str = this.f11406b.getPackageManager().getPackageInfo(this.f11406b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((("?os=0&ver=0.6.11.30.02-PGL-Do&m=2&app_ver=" + str) + "&region=" + c.c(this.f11406b)) + "&appkey=" + com.pgl.sys.ces.b.b()) + "&did=" + com.pgl.sys.ces.b.c();
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
