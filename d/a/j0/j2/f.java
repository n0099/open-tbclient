package d.a.j0.j2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f55966c;

    /* renamed from: d  reason: collision with root package name */
    public b f55967d;

    /* renamed from: e  reason: collision with root package name */
    public d f55968e;

    /* renamed from: f  reason: collision with root package name */
    public c f55969f;

    /* renamed from: a  reason: collision with root package name */
    public int f55964a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f55965b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f55970g = new a(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f55966c == null || !f.this.f55966c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f55966c.getCurrentPosition();
            int duration = f.this.f55966c.getDuration();
            if (currentPosition < f.this.f55965b) {
                if (f.this.f55967d != null) {
                    f.this.f55967d.a();
                }
            } else if (currentPosition == f.this.f55965b && f.this.f55968e != null) {
                f.this.f55968e.a();
            }
            if (f.this.f55969f != null) {
                f.this.f55969f.a(duration, currentPosition);
            }
            f.this.f55965b = currentPosition;
            f.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();
    }

    public final void h() {
        this.f55970g.removeMessages(1);
        Handler handler = this.f55970g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f55964a);
    }

    public void i(b bVar) {
        this.f55967d = bVar;
    }

    public void j(c cVar) {
        this.f55969f = cVar;
    }

    public void k(d dVar) {
        this.f55968e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f55966c = mediaPlayerControl;
    }

    public void m() {
        this.f55965b = 0;
        h();
    }

    public void n() {
        this.f55970g.removeMessages(1);
    }
}
