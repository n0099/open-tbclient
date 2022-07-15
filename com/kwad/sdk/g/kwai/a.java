package com.kwad.sdk.g.kwai;

import android.content.Context;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public boolean a;
    public List<c> b;

    public a() {
        this.a = true;
    }

    public a(boolean z) {
        this.a = z;
    }

    private List<c> a() {
        return this.b;
    }

    @Override // com.kwad.sdk.g.kwai.c
    public final boolean a(Context context) {
        if (this.a) {
            List<c> a = a();
            if (a == null || a.size() <= 0) {
                try {
                    return b(context);
                } catch (Throwable unused) {
                    return false;
                }
            }
            for (c cVar : a) {
                if (cVar.a(context)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean b(Context context) {
        return false;
    }
}
