package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public abstract class b extends FrameLayout {
    public Runnable a;
    @NonNull
    public final c h;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.h = cVar;
    }

    public abstract void a(int i);

    public void a(int i, int i2) {
    }

    public abstract void e();

    public abstract void k();

    public final void p() {
        q();
        if (this.a == null) {
            this.a = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.k();
                    if (b.this.a != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.a, 1000L);
                    }
                }
            };
        }
        post(this.a);
    }

    public final void q() {
        Runnable runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.a = null;
        }
    }
}
