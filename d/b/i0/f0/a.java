package d.b.i0.f0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f54610a;

    /* renamed from: b  reason: collision with root package name */
    public float f54611b;

    /* renamed from: c  reason: collision with root package name */
    public float f54612c;

    /* renamed from: d  reason: collision with root package name */
    public float f54613d;

    /* renamed from: e  reason: collision with root package name */
    public b f54614e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f54615f = new C1243a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f54616g = new Handler(this.f54615f);

    /* renamed from: d.b.i0.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1243a implements Handler.Callback {
        public C1243a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            int i3 = message.what;
            if (i3 == 0) {
                a.this.f54614e.b(i, i2);
                return true;
            } else if (i3 == 1) {
                a.this.f54614e.c(i, i2);
                return true;
            } else if (i3 == 2) {
                a.this.f54614e.a(i, i2);
                return true;
            } else if (i3 != 3) {
                return false;
            } else {
                a.this.f54614e.d(i, i2);
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, int i2);

        void b(int i, int i2);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    public final void b(int i, int i2) {
        this.f54616g.removeMessages(2);
        if (this.f54616g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54616g.sendMessageDelayed(message, 60L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != 3) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (this.f54612c == 0.0f || this.f54613d == 0.0f) {
                        this.f54612c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f54613d = rawY2;
                        this.f54610a = this.f54612c;
                        this.f54611b = rawY2;
                    }
                    int i = (int) (rawY - this.f54611b);
                    int i2 = (int) (rawY - this.f54613d);
                    if (this.f54614e != null) {
                        if (i > 0) {
                            e(i2, i);
                        } else {
                            g(i2, i);
                        }
                    }
                    this.f54610a = rawX;
                    this.f54611b = rawY;
                }
            }
            if (this.f54614e != null) {
                int i3 = (int) (this.f54610a - this.f54612c);
                int i4 = (int) (this.f54611b - this.f54613d);
                if (Math.abs(i3) >= Math.abs(i4)) {
                    f(i3, (int) this.f54612c);
                } else {
                    b(i3, i4);
                }
            }
            this.f54612c = 0.0f;
            this.f54613d = 0.0f;
        } else {
            this.f54612c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f54613d = rawY3;
            this.f54610a = this.f54612c;
            this.f54611b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f54614e = bVar;
    }

    public final void e(int i, int i2) {
        this.f54616g.removeMessages(0);
        if (this.f54616g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54616g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i, int i2) {
        this.f54616g.removeMessages(3);
        if (this.f54616g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54616g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i, int i2) {
        this.f54616g.removeMessages(1);
        if (this.f54616g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54616g.sendMessageDelayed(message, 60L);
    }
}
