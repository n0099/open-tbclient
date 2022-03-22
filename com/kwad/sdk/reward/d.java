package com.kwad.sdk.reward;

import android.os.Looper;
import com.kwad.sdk.utils.ax;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class d {
    public final Set<com.kwad.sdk.reward.a.h> a;

    /* loaded from: classes7.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new HashSet();
    }

    public static d a() {
        return a.a;
    }

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void d() {
        if (this.a.size() == 0) {
            return;
        }
        for (com.kwad.sdk.reward.a.h hVar : this.a) {
            hVar.a();
        }
    }

    public void a(com.kwad.sdk.reward.a.h hVar) {
        if (hVar != null) {
            this.a.add(hVar);
        }
    }

    public void b() {
        if (c()) {
            d();
        } else {
            ax.a(new Runnable() { // from class: com.kwad.sdk.reward.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b();
                }
            });
        }
    }

    public void b(com.kwad.sdk.reward.a.h hVar) {
        this.a.remove(hVar);
    }
}
