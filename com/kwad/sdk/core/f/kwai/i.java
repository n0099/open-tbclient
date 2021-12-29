package com.kwad.sdk.core.f.kwai;

import android.content.Context;
/* loaded from: classes3.dex */
public class i {
    public Context a;

    public i(Context context) {
        this.a = context;
    }

    public String a() {
        String str;
        Exception e2;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            str = (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.a);
        } catch (Exception e3) {
            str = "";
            e2 = e3;
        }
        try {
            com.kwad.sdk.core.d.a.c("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
        } catch (Exception e4) {
            e2 = e4;
            com.kwad.sdk.core.d.a.c("XiaomiDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.a.b(e2);
            return str;
        }
        return str;
    }
}
