package d.b.j0.d2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f54298h;

    /* renamed from: e  reason: collision with root package name */
    public int f54295e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f54296f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f54297g = 0;
    public long i = 500;
    public Handler j = new HandlerC1225a();

    /* renamed from: d.b.j0.d2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1225a extends Handler {
        public HandlerC1225a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                a.this.f54295e = 0;
                a.this.f54296f = 0L;
                a.this.f54297g = 0L;
            } else if (i == 1 && a.this.f54295e == 1) {
                if (a.this.f54298h != null) {
                    a.this.f54298h.a();
                }
                a.this.f54295e = 0;
                a.this.f54296f = 0L;
                a.this.f54297g = 0L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f54298h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f54298h == null) {
                return false;
            }
            int i = this.f54295e + 1;
            this.f54295e = i;
            if (i == 1) {
                this.f54296f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.i);
            } else if (i == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f54297g = currentTimeMillis;
                if (currentTimeMillis - this.f54296f < this.i) {
                    this.f54298h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
