package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public abstract class b extends FrameLayout {
    public Runnable JJ;
    @NonNull
    public final c aef;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aef = cVar;
    }

    public void l(int i, int i2) {
    }

    public abstract void oR();

    public final void oX() {
        oY();
        if (this.JJ == null) {
            this.JJ = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.oR();
                    if (b.this.JJ != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.JJ, 1000L);
                    }
                }
            };
        }
        post(this.JJ);
    }

    public final void oY() {
        Runnable runnable = this.JJ;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.JJ = null;
        }
    }

    public abstract void onPlayStateChanged(int i);

    public abstract void reset();
}
