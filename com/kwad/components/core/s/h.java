package com.kwad.components.core.s;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public final class h {
    public long Bl;
    public a SU;
    public long SS = 100;
    public long ST = 0;
    public boolean Lv = false;
    @Nullable
    public Handler SV = new Handler(Looper.getMainLooper());
    public Runnable SW = new Runnable() { // from class: com.kwad.components.core.s.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.SV == null) {
                return;
            }
            if (h.this.Lv) {
                h.this.SV.postDelayed(this, h.this.SS / 2);
                return;
            }
            h.this.qQ();
            if (h.this.SV != null) {
                h.this.SV.postDelayed(this, h.this.SS);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void onProgress(long j, long j2);
    }

    public h(long j) {
        this.Bl = j;
    }

    public final void a(a aVar) {
        this.SU = aVar;
    }

    public final void pause() {
        this.Lv = true;
    }

    public final void qQ() {
        a aVar = this.SU;
        if (aVar != null) {
            long j = this.Bl;
            long j2 = j - this.ST;
            aVar.onProgress(j2, j);
            if (j2 <= 0) {
                stop();
            }
        }
        this.ST += this.SS;
    }

    public final void resume() {
        this.Lv = false;
    }

    public final void start() {
        Handler handler = this.SV;
        if (handler == null) {
            return;
        }
        handler.post(this.SW);
    }

    public final void stop() {
        Handler handler = this.SV;
        if (handler != null) {
            handler.removeCallbacks(this.SW);
            this.SV = null;
        }
    }
}
