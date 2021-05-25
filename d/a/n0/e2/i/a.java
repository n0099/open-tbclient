package d.a.n0.e2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f52987h;

    /* renamed from: e  reason: collision with root package name */
    public int f52984e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f52985f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f52986g = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f52988i = 500;
    public Handler j = new HandlerC1254a();

    /* renamed from: d.a.n0.e2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1254a extends Handler {
        public HandlerC1254a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                a.this.f52984e = 0;
                a.this.f52985f = 0L;
                a.this.f52986g = 0L;
            } else if (i2 == 1 && a.this.f52984e == 1) {
                if (a.this.f52987h != null) {
                    a.this.f52987h.a();
                }
                a.this.f52984e = 0;
                a.this.f52985f = 0L;
                a.this.f52986g = 0L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f52987h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f52987h == null) {
                return false;
            }
            int i2 = this.f52984e + 1;
            this.f52984e = i2;
            if (i2 == 1) {
                this.f52985f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.f52988i);
            } else if (i2 == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f52986g = currentTimeMillis;
                if (currentTimeMillis - this.f52985f < this.f52988i) {
                    this.f52987h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
