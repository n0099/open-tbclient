package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.MediaPlayerImpl;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class e {
    public static boolean TB = false;
    public static AtomicBoolean aAn = null;
    public static int aAo = -1;
    public static final AtomicBoolean aAp = new AtomicBoolean(false);
    public static final AtomicBoolean aAq = new AtomicBoolean(false);
    public static int aAr;

    public static int EW() {
        return aAr;
    }

    public static boolean EX() {
        AtomicBoolean atomicBoolean = aAn;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aAn = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean zC() {
        if (!aAq.get() && !com.kwad.framework.a.a.Iu.booleanValue()) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: com.kwad.sdk.core.video.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        b bVar;
        boolean z5;
        b bVar2;
        try {
            if (zC() && z2 && EX()) {
                com.kwad.sdk.core.e.c.i(MediaPlayerImpl.TAG, "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aAr = 2;
                dVar.bn(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.e.c.i(MediaPlayerImpl.TAG, "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aAr = 1;
                bVar2 = bVar3;
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e(MediaPlayerImpl.TAG, "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!TB) {
                TB = true;
                com.kwad.sdk.service.c.gatherException(th);
            }
            b bVar4 = new b();
            aAr = 1;
            z4 = true;
            bVar = bVar4;
        }
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()) {
            z5 = true;
        } else {
            z5 = false;
        }
        int a = an.a(zC(), z5, z2, EX(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.e.c.m181do("player v=" + Integer.toBinaryString(a));
        if (aAo != a) {
            aAo = a;
            cT(a);
        }
        return bVar;
    }

    public static void cT(int i) {
        q qVar = new q(10212L);
        qVar.awo = i;
        i.a2(qVar);
    }
}
