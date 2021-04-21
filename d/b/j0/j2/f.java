package d.b.j0.j2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f57989c;

    /* renamed from: d  reason: collision with root package name */
    public b f57990d;

    /* renamed from: e  reason: collision with root package name */
    public d f57991e;

    /* renamed from: f  reason: collision with root package name */
    public c f57992f;

    /* renamed from: a  reason: collision with root package name */
    public int f57987a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f57988b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f57993g = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f57989c == null || !f.this.f57989c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f57989c.getCurrentPosition();
            int duration = f.this.f57989c.getDuration();
            if (currentPosition < f.this.f57988b) {
                if (f.this.f57990d != null) {
                    f.this.f57990d.a();
                }
            } else if (currentPosition == f.this.f57988b && f.this.f57991e != null) {
                f.this.f57991e.a();
            }
            if (f.this.f57992f != null) {
                f.this.f57992f.a(duration, currentPosition);
            }
            f.this.f57988b = currentPosition;
            f.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    public final void h() {
        this.f57993g.removeMessages(1);
        Handler handler = this.f57993g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f57987a);
    }

    public void i(b bVar) {
        this.f57990d = bVar;
    }

    public void j(c cVar) {
        this.f57992f = cVar;
    }

    public void k(d dVar) {
        this.f57991e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f57989c = mediaPlayerControl;
    }

    public void m() {
        this.f57988b = 0;
        h();
    }

    public void n() {
        this.f57993g.removeMessages(1);
    }
}
