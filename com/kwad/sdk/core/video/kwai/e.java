package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class e {
    public static boolean JD = false;
    public static AtomicBoolean adS = null;
    public static int adT = -1;
    public static final AtomicBoolean adU = new AtomicBoolean(false);
    public static final AtomicBoolean adV = new AtomicBoolean(false);

    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: com.kwad.sdk.core.video.kwai.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3) {
        boolean z4;
        b bVar;
        b bVar2;
        try {
            if (rr() && z2 && vB()) {
                com.kwad.sdk.core.e.b.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(context);
                dVar.aM(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.e.b.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar2 = new b();
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!JD) {
                JD = true;
                com.kwad.sdk.service.a.gatherException(th);
            }
            z4 = true;
            bVar = new b();
        }
        int a = ak.a(rr(), ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getIsExternal(), z2, vB(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.e.b.bT("player v=" + Integer.toBinaryString(a));
        if (adT != a) {
            adT = a;
            aY(a);
        }
        return bVar;
    }

    public static void aY(int i) {
        m mVar = new m(10212L);
        mVar.aaQ = i;
        com.kwad.sdk.core.report.e.a2(mVar);
    }

    public static boolean rr() {
        return adV.get() || com.kwad.b.kwai.a.CM.booleanValue();
    }

    public static boolean vB() {
        AtomicBoolean atomicBoolean = adS;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        adS = atomicBoolean2;
        return atomicBoolean2.get();
    }
}
