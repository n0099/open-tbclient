package d.a.n0.k2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f56853c;

    /* renamed from: d  reason: collision with root package name */
    public b f56854d;

    /* renamed from: e  reason: collision with root package name */
    public d f56855e;

    /* renamed from: f  reason: collision with root package name */
    public c f56856f;

    /* renamed from: a  reason: collision with root package name */
    public int f56851a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f56852b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56857g = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f56853c == null || !f.this.f56853c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f56853c.getCurrentPosition();
            int duration = f.this.f56853c.getDuration();
            if (currentPosition < f.this.f56852b) {
                if (f.this.f56854d != null) {
                    f.this.f56854d.a();
                }
            } else if (currentPosition == f.this.f56852b && f.this.f56855e != null) {
                f.this.f56855e.a();
            }
            if (f.this.f56856f != null) {
                f.this.f56856f.a(duration, currentPosition);
            }
            f.this.f56852b = currentPosition;
            f.this.h();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, int i3);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    public final void h() {
        this.f56857g.removeMessages(1);
        Handler handler = this.f56857g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f56851a);
    }

    public void i(b bVar) {
        this.f56854d = bVar;
    }

    public void j(c cVar) {
        this.f56856f = cVar;
    }

    public void k(d dVar) {
        this.f56855e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f56853c = mediaPlayerControl;
    }

    public void m() {
        this.f56852b = 0;
        h();
    }

    public void n() {
        this.f56857g.removeMessages(1);
    }
}
