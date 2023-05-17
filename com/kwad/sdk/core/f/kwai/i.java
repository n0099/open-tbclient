package com.kwad.sdk.core.f.kwai;

import android.content.Context;
import com.kwad.sdk.utils.q;
/* loaded from: classes9.dex */
public final class i {
    public Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            String str = (String) q.a(q.b("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
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
