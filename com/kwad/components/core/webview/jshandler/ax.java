package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c VH;
    public final Handler Wk = new Handler(Looper.getMainLooper());
    public final c XE;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public WeakReference<com.kwad.sdk.core.webview.c.c> XG;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.XG = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.XG.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    public ax(c cVar) {
        this.XE = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VH = cVar;
        this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // java.lang.Runnable
            public final void run() {
                ax.this.XE.a(new b(ax.this.VH));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VH = null;
        this.Wk.removeCallbacksAndMessages(null);
    }
}
