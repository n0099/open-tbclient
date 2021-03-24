package d.b.i0.c2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f52481h;

    /* renamed from: e  reason: collision with root package name */
    public int f52478e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f52479f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f52480g = 0;
    public long i = 500;
    public Handler j = new HandlerC1144a();

    /* renamed from: d.b.i0.c2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1144a extends Handler {
        public HandlerC1144a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                a.this.f52478e = 0;
                a.this.f52479f = 0L;
                a.this.f52480g = 0L;
            } else if (i == 1 && a.this.f52478e == 1) {
                if (a.this.f52481h != null) {
                    a.this.f52481h.a();
                }
                a.this.f52478e = 0;
                a.this.f52479f = 0L;
                a.this.f52480g = 0L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f52481h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f52481h == null) {
                return false;
            }
            int i = this.f52478e + 1;
            this.f52478e = i;
            if (i == 1) {
                this.f52479f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.i);
            } else if (i == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f52480g = currentTimeMillis;
                if (currentTimeMillis - this.f52479f < this.i) {
                    this.f52481h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
