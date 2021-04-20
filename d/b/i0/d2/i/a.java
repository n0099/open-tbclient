package d.b.i0.d2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f53877h;

    /* renamed from: e  reason: collision with root package name */
    public int f53874e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f53875f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f53876g = 0;
    public long i = 500;
    public Handler j = new HandlerC1202a();

    /* renamed from: d.b.i0.d2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1202a extends Handler {
        public HandlerC1202a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                a.this.f53874e = 0;
                a.this.f53875f = 0L;
                a.this.f53876g = 0L;
            } else if (i == 1 && a.this.f53874e == 1) {
                if (a.this.f53877h != null) {
                    a.this.f53877h.a();
                }
                a.this.f53874e = 0;
                a.this.f53875f = 0L;
                a.this.f53876g = 0L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f53877h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f53877h == null) {
                return false;
            }
            int i = this.f53874e + 1;
            this.f53874e = i;
            if (i == 1) {
                this.f53875f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.i);
            } else if (i == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f53876g = currentTimeMillis;
                if (currentTimeMillis - this.f53875f < this.i) {
                    this.f53877h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
