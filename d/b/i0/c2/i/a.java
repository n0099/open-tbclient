package d.b.i0.c2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
public class a implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public b f52482h;

    /* renamed from: e  reason: collision with root package name */
    public int f52479e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f52480f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f52481g = 0;
    public long i = 500;
    public Handler j = new HandlerC1145a();

    /* renamed from: d.b.i0.c2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1145a extends Handler {
        public HandlerC1145a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                a.this.f52479e = 0;
                a.this.f52480f = 0L;
                a.this.f52481g = 0L;
            } else if (i == 1 && a.this.f52479e == 1) {
                if (a.this.f52482h != null) {
                    a.this.f52482h.a();
                }
                a.this.f52479e = 0;
                a.this.f52480f = 0L;
                a.this.f52481g = 0L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f52482h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f52482h == null) {
                return false;
            }
            int i = this.f52479e + 1;
            this.f52479e = i;
            if (i == 1) {
                this.f52480f = System.currentTimeMillis();
                this.j.sendEmptyMessageDelayed(1, this.i);
            } else if (i == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f52481g = currentTimeMillis;
                if (currentTimeMillis - this.f52480f < this.i) {
                    this.f52482h.b();
                }
                this.j.sendEmptyMessage(2);
            }
        }
        return true;
    }
}
