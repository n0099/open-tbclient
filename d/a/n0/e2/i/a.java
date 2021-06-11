package d.a.n0.e2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f56676h;

    /* renamed from: e  reason: collision with root package name */
    public int f56673e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f56674f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f56675g = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f56677i = 500;
    public Handler j = new HandlerC1310a();

    /* renamed from: d.a.n0.e2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1310a extends Handler {
        public HandlerC1310a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                a.this.f56673e = 0;
                a.this.f56674f = 0L;
                a.this.f56675g = 0L;
            } else if (i2 == 1 && a.this.f56673e == 1) {
                if (a.this.f56676h != null) {
                    a.this.f56676h.a();
                }
                a.this.f56673e = 0;
                a.this.f56674f = 0L;
                a.this.f56675g = 0L;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f56676h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f56676h == null) {
                return false;
            }
            int i2 = this.f56673e + 1;
            this.f56673e = i2;
            if (i2 == 1) {
                this.f56674f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.f56677i);
            } else if (i2 == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f56675g = currentTimeMillis;
                if (currentTimeMillis - this.f56674f < this.f56677i) {
                    this.f56676h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
