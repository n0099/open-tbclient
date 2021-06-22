package d.a.o0.e2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f56801h;

    /* renamed from: e  reason: collision with root package name */
    public int f56798e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f56799f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f56800g = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f56802i = 500;
    public Handler j = new HandlerC1314a();

    /* renamed from: d.a.o0.e2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1314a extends Handler {
        public HandlerC1314a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                a.this.f56798e = 0;
                a.this.f56799f = 0L;
                a.this.f56800g = 0L;
            } else if (i2 == 1 && a.this.f56798e == 1) {
                if (a.this.f56801h != null) {
                    a.this.f56801h.a();
                }
                a.this.f56798e = 0;
                a.this.f56799f = 0L;
                a.this.f56800g = 0L;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f56801h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f56801h == null) {
                return false;
            }
            int i2 = this.f56798e + 1;
            this.f56798e = i2;
            if (i2 == 1) {
                this.f56799f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.f56802i);
            } else if (i2 == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f56800g = currentTimeMillis;
                if (currentTimeMillis - this.f56799f < this.f56802i) {
                    this.f56801h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
