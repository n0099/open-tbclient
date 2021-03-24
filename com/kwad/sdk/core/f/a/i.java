package com.kwad.sdk.core.f.a;

import android.content.Context;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Context f33617a;

    public i(Context context) {
        this.f33617a = context;
    }

    public String a() {
        String str;
        Exception e2;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            str = (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.f33617a);
        } catch (Exception e3) {
            str = "";
            e2 = e3;
        }
        try {
            com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
        } catch (Exception e4) {
            e2 = e4;
            com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.a.b(e2);
            return str;
        }
        return str;
    }
}
