package d.a.n0.k2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f60542c;

    /* renamed from: d  reason: collision with root package name */
    public b f60543d;

    /* renamed from: e  reason: collision with root package name */
    public d f60544e;

    /* renamed from: f  reason: collision with root package name */
    public c f60545f;

    /* renamed from: a  reason: collision with root package name */
    public int f60540a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f60541b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f60546g = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f60542c == null || !f.this.f60542c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f60542c.getCurrentPosition();
            int duration = f.this.f60542c.getDuration();
            if (currentPosition < f.this.f60541b) {
                if (f.this.f60543d != null) {
                    f.this.f60543d.a();
                }
            } else if (currentPosition == f.this.f60541b && f.this.f60544e != null) {
                f.this.f60544e.a();
            }
            if (f.this.f60545f != null) {
                f.this.f60545f.a(duration, currentPosition);
            }
            f.this.f60541b = currentPosition;
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
        this.f60546g.removeMessages(1);
        Handler handler = this.f60546g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f60540a);
    }

    public void i(b bVar) {
        this.f60543d = bVar;
    }

    public void j(c cVar) {
        this.f60545f = cVar;
    }

    public void k(d dVar) {
        this.f60544e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f60542c = mediaPlayerControl;
    }

    public void m() {
        this.f60541b = 0;
        h();
    }

    public void n() {
        this.f60546g.removeMessages(1);
    }
}
