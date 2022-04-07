package com.kwad.sdk.core.f.kwai;

import android.content.Context;
/* loaded from: classes5.dex */
public class i {
    public Context a;

    public i(Context context) {
        this.a = context;
    }

    public String a() {
        String str;
        Exception e;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            str = (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.a);
        } catch (Exception e2) {
            str = "";
            e = e2;
        }
        try {
            com.kwad.sdk.core.d.a.c("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
        } catch (Exception e3) {
            e = e3;
            com.kwad.sdk.core.d.a.c("XiaomiDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.a.b(e);
            return str;
        }
        return str;
    }
}
