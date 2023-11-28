package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public abstract class b extends RelativeLayout {
    public Runnable TH;
    @NonNull
    public final c aAB;

    public abstract void onPlayStateChanged(int i);

    public void p(int i, int i2) {
    }

    public abstract void rd();

    public abstract void reset();

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aAB = cVar;
    }

    public final void rj() {
        rk();
        if (this.TH == null) {
            this.TH = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.rd();
                    if (b.this.TH != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.TH, 1000L);
                    }
                }
            };
        }
        post(this.TH);
    }

    public final void rk() {
        Runnable runnable = this.TH;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.TH = null;
        }
    }
}
