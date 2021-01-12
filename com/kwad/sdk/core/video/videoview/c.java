package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public abstract class c extends FrameLayout {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final d f9469a;

    /* renamed from: b  reason: collision with root package name */
    private Timer f9470b;
    private TimerTask c;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f9469a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(int i);

    public void a(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c();

    protected abstract void g();

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        i();
        if (this.f9470b == null) {
            this.f9470b = new Timer();
        }
        if (this.c == null) {
            this.c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.post(new Runnable() { // from class: com.kwad.sdk.core.video.videoview.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.g();
                        }
                    });
                }
            };
        }
        this.f9470b.schedule(this.c, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        if (this.f9470b != null) {
            this.f9470b.cancel();
            this.f9470b = null;
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }
}
