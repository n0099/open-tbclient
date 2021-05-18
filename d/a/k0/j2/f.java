package d.a.k0.j2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f56673c;

    /* renamed from: d  reason: collision with root package name */
    public b f56674d;

    /* renamed from: e  reason: collision with root package name */
    public d f56675e;

    /* renamed from: f  reason: collision with root package name */
    public c f56676f;

    /* renamed from: a  reason: collision with root package name */
    public int f56671a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f56672b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56677g = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f56673c == null || !f.this.f56673c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f56673c.getCurrentPosition();
            int duration = f.this.f56673c.getDuration();
            if (currentPosition < f.this.f56672b) {
                if (f.this.f56674d != null) {
                    f.this.f56674d.a();
                }
            } else if (currentPosition == f.this.f56672b && f.this.f56675e != null) {
                f.this.f56675e.a();
            }
            if (f.this.f56676f != null) {
                f.this.f56676f.a(duration, currentPosition);
            }
            f.this.f56672b = currentPosition;
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
        this.f56677g.removeMessages(1);
        Handler handler = this.f56677g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f56671a);
    }

    public void i(b bVar) {
        this.f56674d = bVar;
    }

    public void j(c cVar) {
        this.f56676f = cVar;
    }

    public void k(d dVar) {
        this.f56675e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f56673c = mediaPlayerControl;
    }

    public void m() {
        this.f56672b = 0;
        h();
    }

    public void n() {
        this.f56677g.removeMessages(1);
    }
}
