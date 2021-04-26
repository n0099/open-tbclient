package d.a.j0.d2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f52082h;

    /* renamed from: e  reason: collision with root package name */
    public int f52079e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f52080f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f52081g = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f52083i = 500;
    public Handler j = new HandlerC1164a();

    /* renamed from: d.a.j0.d2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1164a extends Handler {
        public HandlerC1164a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                a.this.f52079e = 0;
                a.this.f52080f = 0L;
                a.this.f52081g = 0L;
            } else if (i2 == 1 && a.this.f52079e == 1) {
                if (a.this.f52082h != null) {
                    a.this.f52082h.a();
                }
                a.this.f52079e = 0;
                a.this.f52080f = 0L;
                a.this.f52081g = 0L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f52082h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f52082h == null) {
                return false;
            }
            int i2 = this.f52079e + 1;
            this.f52079e = i2;
            if (i2 == 1) {
                this.f52080f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.f52083i);
            } else if (i2 == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f52081g = currentTimeMillis;
                if (currentTimeMillis - this.f52080f < this.f52083i) {
                    this.f52082h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
