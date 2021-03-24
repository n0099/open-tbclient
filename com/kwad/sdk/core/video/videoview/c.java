package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public abstract class c extends FrameLayout {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final d f34150a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f34151b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f34152c;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f34150a = dVar;
    }

    public abstract void a(int i);

    public void a(int i, int i2) {
    }

    public abstract void c();

    public abstract void g();

    public void h() {
        i();
        if (this.f34151b == null) {
            this.f34151b = new Timer();
        }
        if (this.f34152c == null) {
            this.f34152c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
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
        this.f34151b.schedule(this.f34152c, 0L, 1000L);
    }

    public void i() {
        Timer timer = this.f34151b;
        if (timer != null) {
            timer.cancel();
            this.f34151b = null;
        }
        TimerTask timerTask = this.f34152c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f34152c = null;
        }
    }
}
