package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
/* loaded from: classes10.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.a aVar) {
        i.wU().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.c cVar) {
        i.wU().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a i(Context context, String str) {
        com.kwad.library.solder.lib.a.a k = i.wU().k(context, str);
        if (k != null && k.isLoaded() && (k instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) k;
        }
        return null;
    }

    public static void j(Context context, String str) {
        i.wU().j(context, str);
    }
}
