package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class c extends FrameLayout {
    public static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public Timer f58467b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f58468c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final d f58469d;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f58469d = dVar;
    }

    public abstract void a(int i2);

    public void a(int i2, int i3) {
    }

    public abstract void e();

    public abstract void i();

    public void k() {
        l();
        if (this.f58467b == null) {
            this.f58467b = new Timer("ksad-IVideoPlayer-timer" + a.getAndIncrement());
        }
        if (this.f58468c == null) {
            this.f58468c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
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
        this.f58467b.schedule(this.f58468c, 0L, 1000L);
    }

    public void l() {
        Timer timer = this.f58467b;
        if (timer != null) {
            timer.cancel();
            this.f58467b = null;
        }
        TimerTask timerTask = this.f58468c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f58468c = null;
        }
    }
}
