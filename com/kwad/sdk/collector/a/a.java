package com.kwad.sdk.collector.a;

import android.content.Context;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f31854a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f31855b;

    public a() {
        this.f31854a = true;
    }

    public a(boolean z) {
        this.f31854a = z;
    }

    public List<b> a() {
        return this.f31855b;
    }

    @Override // com.kwad.sdk.collector.a.b
    public boolean a(Context context) {
        if (this.f31854a) {
            List<b> a2 = a();
            if (a2 == null || a2.size() <= 0) {
                try {
                    return b(context);
                } catch (Throwable unused) {
                    return false;
                }
            }
            for (b bVar : a2) {
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
