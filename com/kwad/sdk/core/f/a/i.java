package com.kwad.sdk.core.f.a;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Context f9144a;

    public i(Context context) {
        this.f9144a = context;
    }

    public String a() {
        String str;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            str = (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.f9144a);
        } catch (Exception e) {
            e = e;
            str = "";
        }
        try {
            com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.a.b(e);
            return str;
        }
        return str;
    }
}
