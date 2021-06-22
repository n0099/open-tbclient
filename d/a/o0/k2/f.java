package d.a.o0.k2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f60667c;

    /* renamed from: d  reason: collision with root package name */
    public b f60668d;

    /* renamed from: e  reason: collision with root package name */
    public d f60669e;

    /* renamed from: f  reason: collision with root package name */
    public c f60670f;

    /* renamed from: a  reason: collision with root package name */
    public int f60665a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f60666b = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f60671g = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 1 || f.this.f60667c == null || !f.this.f60667c.isPlaying()) {
                return;
            }
            int currentPosition = f.this.f60667c.getCurrentPosition();
            int duration = f.this.f60667c.getDuration();
            if (currentPosition < f.this.f60666b) {
                if (f.this.f60668d != null) {
                    f.this.f60668d.a();
                }
            } else if (currentPosition == f.this.f60666b && f.this.f60669e != null) {
                f.this.f60669e.a();
            }
            if (f.this.f60670f != null) {
                f.this.f60670f.a(duration, currentPosition);
            }
            f.this.f60666b = currentPosition;
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
        this.f60671g.removeMessages(1);
        Handler handler = this.f60671g;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f60665a);
    }

    public void i(b bVar) {
        this.f60668d = bVar;
    }

    public void j(c cVar) {
        this.f60670f = cVar;
    }

    public void k(d dVar) {
        this.f60669e = dVar;
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f60667c = mediaPlayerControl;
    }

    public void m() {
        this.f60666b = 0;
        h();
    }

    public void n() {
        this.f60671g.removeMessages(1);
    }
}
