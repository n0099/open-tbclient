package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class e {
    public static AtomicBoolean b;
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static int c = -1;
    public static boolean d = false;

    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: com.kwad.sdk.core.video.kwai.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3) {
        boolean z4;
        b bVar;
        b bVar2;
        try {
            if (b() && z2 && a()) {
                com.kwad.sdk.core.d.b.c("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(context);
                dVar.b(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.b.c("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar2 = new b();
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!d) {
                d = true;
                com.kwad.sdk.service.a.a(th);
            }
            z4 = true;
            bVar = new b();
        }
        int a2 = ah.a(b(), ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).d(), z2, a(), z4, z3, bVar.l());
        com.kwad.sdk.core.d.b.a("player v=" + Integer.toBinaryString(a2));
        if (c != a2) {
            c = a2;
            a(a2);
        }
        return bVar;
    }

    public static void a(int i) {
        m mVar = new m(10212L);
        mVar.aj = i;
        com.kwad.sdk.core.report.e.a2(mVar);
    }

    public static boolean a() {
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        b = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean b() {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        if (a.get()) {
            return true;
        }
        return (dVar != null && dVar.d()) || com.kwad.b.kwai.a.c.booleanValue();
    }
}
