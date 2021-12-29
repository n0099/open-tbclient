package com.kwad.sdk.c;

import android.content.Context;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public final Context a;

    public b(Context context) {
        this.a = context;
    }

    public String a(com.kwad.sdk.c.kwai.d dVar, boolean z) {
        com.kwad.sdk.c.b.b.a(dVar, 2);
        String b2 = com.kwad.sdk.c.b.a.b(this.a, dVar.f());
        try {
            com.kwad.sdk.c.b.a.a(b2, com.kwad.sdk.c.b.a.a(this.a, dVar.f()));
        } catch (Exception e2) {
            e2.printStackTrace();
            com.kwad.sdk.c.b.b.a(dVar, 2, e2.getMessage());
        }
        if (b2 != null) {
            q.c(new File(b2));
        }
        return dVar.f();
    }
}
