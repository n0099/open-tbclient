package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class c extends FrameLayout {
    public static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public Timer f39916b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f39917c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final d f39918d;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f39918d = dVar;
    }

    public abstract void a(int i);

    public void a(int i, int i2) {
    }

    public abstract void e();

    public abstract void i();

    public void k() {
        l();
        if (this.f39916b == null) {
            this.f39916b = new Timer("ksad-IVideoPlayer-timer" + a.getAndIncrement());
        }
        if (this.f39917c == null) {
            this.f39917c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.post(new Runnable() { // from class: com.kwad.sdk.core.video.videoview.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.i();
                        }
                    });
                }
            };
        }
        this.f39916b.schedule(this.f39917c, 0L, 1000L);
    }

    public void l() {
        Timer timer = this.f39916b;
        if (timer != null) {
            timer.cancel();
            this.f39916b = null;
        }
        TimerTask timerTask = this.f39917c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f39917c = null;
        }
    }
}
