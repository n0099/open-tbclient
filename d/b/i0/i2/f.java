package d.b.i0.i2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f56121c;

    /* renamed from: d  reason: collision with root package name */
    public b f56122d;

    /* renamed from: e  reason: collision with root package name */
    public d f56123e;

    /* renamed from: f  reason: collision with root package name */
    public c f56124f;

    /* renamed from: a  reason: collision with root package name */
    public int f56119a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f56120b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56125g = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f56121c == null || !f.this.f56121c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f56121c.getCurrentPosition();
            int duration = f.this.f56121c.getDuration();
            if (currentPosition < f.this.f56120b) {
                if (f.this.f56122d != null) {
                    f.this.f56122d.a();
                }
            } else if (currentPosition == f.this.f56120b && f.this.f56123e != null) {
                f.this.f56123e.a();
            }
            if (f.this.f56124f != null) {
                f.this.f56124f.a(duration, currentPosition);
            }
            f.this.f56120b = currentPosition;
            f.this.h();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    public final void h() {
        this.f56125g.removeMessages(1);
        Handler handler = this.f56125g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f56119a);
    }

    public void i(b bVar) {
        this.f56122d = bVar;
    }

    public void j(c cVar) {
        this.f56124f = cVar;
    }

    public void k(d dVar) {
        this.f56123e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f56121c = mediaPlayerControl;
    }

    public void m() {
        this.f56120b = 0;
        h();
    }

    public void n() {
        this.f56125g.removeMessages(1);
    }
}
