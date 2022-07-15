package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import com.kwad.sdk.utils.q;
/* loaded from: classes5.dex */
public final class i {
    public Context a;

    public i(Context context) {
        this.a = context;
    }

    public final String a() {
        try {
            String str = (String) q.a(q.a("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.a);
            try {
                new StringBuilder("getOAID oaid:").append(str);
                return str;
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return "";
        }
    }
}
