package com.kwad.sdk.c.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.c.a.b;
import com.kwad.sdk.c.kwai.d;
import com.kwad.sdk.utils.i;
/* loaded from: classes5.dex */
public class a implements b.a {
    @NonNull
    public final com.kwad.sdk.c.c a;

    public a(@NonNull com.kwad.sdk.c.c cVar) {
        this.a = cVar;
    }

    @Override // com.kwad.sdk.c.a.b.a
    public void a(final d dVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.c.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a.b(dVar);
            }
        });
    }

    @Override // com.kwad.sdk.c.a.b.a
    public void b(d dVar) {
        this.a.c(dVar);
    }
}
