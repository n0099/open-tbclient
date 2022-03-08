package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class c extends FrameLayout {
    public static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public Timer f54821b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f54822c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final d f54823d;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f54823d = dVar;
    }

    public abstract void a(int i2);

    public void a(int i2, int i3) {
    }

    public abstract void e();

    public abstract void i();

    public void k() {
        l();
        if (this.f54821b == null) {
            this.f54821b = new Timer("ksad-IVideoPlayer-timer" + a.getAndIncrement());
        }
        if (this.f54822c == null) {
            this.f54822c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
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
        this.f54821b.schedule(this.f54822c, 0L, 1000L);
    }

    public void l() {
        Timer timer = this.f54821b;
        if (timer != null) {
            timer.cancel();
            this.f54821b = null;
        }
        TimerTask timerTask = this.f54822c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f54822c = null;
        }
    }
}
