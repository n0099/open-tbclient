package com.kwad.sdk.collector.kwai;

import android.content.Context;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements b {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f57697b;

    public a() {
        this.a = true;
    }

    public a(boolean z) {
        this.a = z;
    }

    public List<b> a() {
        return this.f57697b;
    }

    @Override // com.kwad.sdk.collector.kwai.b
    public boolean a(Context context) {
        if (this.a) {
            List<b> a = a();
            if (a == null || a.size() <= 0) {
                try {
                    return b(context);
                } catch (Throwable unused) {
                    return false;
                }
            }
            for (b bVar : a) {
                if (bVar.a(context)) {
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
