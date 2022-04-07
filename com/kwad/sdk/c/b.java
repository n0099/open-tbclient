package com.kwad.sdk.c;

import android.content.Context;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes5.dex */
public class b {
    public final Context a;

    public b(Context context) {
        this.a = context;
    }

    public String a(com.kwad.sdk.c.kwai.d dVar, boolean z) {
        com.kwad.sdk.c.b.b.a(dVar, 2);
        String b = com.kwad.sdk.c.b.a.b(this.a, dVar.f());
        try {
            com.kwad.sdk.c.b.a.a(b, com.kwad.sdk.c.b.a.a(this.a, dVar.f()));
        } catch (Exception e) {
            e.printStackTrace();
            com.kwad.sdk.c.b.b.a(dVar, 2, e.getMessage());
        }
        if (b != null) {
            q.c(new File(b));
        }
        return dVar.f();
    }
}
