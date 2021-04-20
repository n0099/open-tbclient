package d.b.i0.j2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f57568c;

    /* renamed from: d  reason: collision with root package name */
    public b f57569d;

    /* renamed from: e  reason: collision with root package name */
    public d f57570e;

    /* renamed from: f  reason: collision with root package name */
    public c f57571f;

    /* renamed from: a  reason: collision with root package name */
    public int f57566a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f57567b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f57572g = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f57568c == null || !f.this.f57568c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f57568c.getCurrentPosition();
            int duration = f.this.f57568c.getDuration();
            if (currentPosition < f.this.f57567b) {
                if (f.this.f57569d != null) {
                    f.this.f57569d.a();
                }
            } else if (currentPosition == f.this.f57567b && f.this.f57570e != null) {
                f.this.f57570e.a();
            }
            if (f.this.f57571f != null) {
                f.this.f57571f.a(duration, currentPosition);
            }
            f.this.f57567b = currentPosition;
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
        this.f57572g.removeMessages(1);
        Handler handler = this.f57572g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f57566a);
    }

    public void i(b bVar) {
        this.f57569d = bVar;
    }

    public void j(c cVar) {
        this.f57571f = cVar;
    }

    public void k(d dVar) {
        this.f57570e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f57568c = mediaPlayerControl;
    }

    public void m() {
        this.f57567b = 0;
        h();
    }

    public void n() {
        this.f57572g.removeMessages(1);
    }
}
