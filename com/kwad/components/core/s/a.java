package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static volatile a SM;
    public com.kwad.sdk.utils.h SI;
    public List<WeakReference<OfflineOnAudioConflictListener>> SJ = new ArrayList();
    public boolean SK = false;
    public boolean SL = false;

    public a(@NonNull Context context) {
        init(context);
    }

    public static a ah(@NonNull Context context) {
        if (SM == null) {
            synchronized (a.class) {
                if (SM == null) {
                    SM = new a(context.getApplicationContext());
                }
            }
        }
        return SM;
    }

    private void init(Context context) {
        this.SK = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.SI = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.SJ.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.SJ.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aM(boolean z) {
        if (this.SI == null) {
            return false;
        }
        if (!z && this.SK) {
            return false;
        }
        this.SK = true;
        this.SL = false;
        return this.SI.JD();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.SJ.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.SL = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.SJ.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final boolean qJ() {
        return this.SL;
    }

    public final boolean qK() {
        return this.SK;
    }
}
