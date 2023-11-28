package com.kwad.components.core.g;

import android.os.Handler;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public final class a implements Runnable {
    public long Lu = 1000;
    public boolean Lv = true;
    public long Lw = 0;
    public InterfaceC0645a Lx;
    @Nullable
    public volatile Handler fS;

    /* renamed from: com.kwad.components.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0645a {
        void x(long j);
    }

    public a(Handler handler) {
        this.fS = handler;
    }

    public final void a(InterfaceC0645a interfaceC0645a) {
        this.Lx = interfaceC0645a;
    }

    public final void destroy() {
        stop();
        this.fS = null;
    }

    public final void pause() {
        this.Lv = true;
    }

    public final void resume() {
        this.Lv = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        if (this.fS != null) {
            if (!this.Lv && this.Lx != null) {
                this.Lx.x(this.Lw);
                this.Lw += this.Lu;
            }
            if (this.fS != null) {
                this.fS.postDelayed(this, this.Lu);
            }
        }
    }

    public final void start() {
        this.Lv = false;
        if (this.fS != null) {
            this.fS.post(this);
        }
    }

    public final void stop() {
        if (this.fS != null) {
            this.fS.removeCallbacks(this);
        }
    }
}
