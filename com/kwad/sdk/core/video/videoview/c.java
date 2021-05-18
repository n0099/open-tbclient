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
    public final d f32770a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f32771b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f32772c;

    public c(Context context, @NonNull d dVar) {
        super(context);
        this.f32770a = dVar;
    }

    public abstract void a(int i2);

    public void a(int i2, int i3) {
    }

    public abstract void d();

    public abstract void h();

    public void i() {
        j();
        if (this.f32771b == null) {
            this.f32771b = new Timer();
        }
        if (this.f32772c == null) {
            this.f32772c = new TimerTask() { // from class: com.kwad.sdk.core.video.videoview.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.post(new Runnable() { // from class: com.kwad.sdk.core.video.videoview.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.h();
                        }
                    });
                }
            };
        }
        this.f32771b.schedule(this.f32772c, 0L, 1000L);
    }

    public void j() {
        Timer timer = this.f32771b;
        if (timer != null) {
            timer.cancel();
            this.f32771b = null;
        }
        TimerTask timerTask = this.f32772c;
        if (timerTask != null) {
            timerTask.cancel();
            this.f32772c = null;
        }
    }
}
