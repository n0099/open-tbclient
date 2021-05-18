package d.a.k0.f0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f54711a;

    /* renamed from: b  reason: collision with root package name */
    public float f54712b;

    /* renamed from: c  reason: collision with root package name */
    public float f54713c;

    /* renamed from: d  reason: collision with root package name */
    public float f54714d;

    /* renamed from: e  reason: collision with root package name */
    public b f54715e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f54716f = new C1321a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f54717g = new Handler(this.f54716f);

    /* renamed from: d.a.k0.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1321a implements Handler.Callback {
        public C1321a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            int i4 = message.what;
            if (i4 == 0) {
                a.this.f54715e.a(i2, i3);
                return true;
            } else if (i4 == 1) {
                a.this.f54715e.b(i2, i3);
                return true;
            } else if (i4 == 2) {
                a.this.f54715e.d(i2, i3);
                return true;
            } else if (i4 != 3) {
                return false;
            } else {
                a.this.f54715e.c(i2, i3);
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, int i3);

        void b(int i2, int i3);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    public final void b(int i2, int i3) {
        this.f54717g.removeMessages(2);
        if (this.f54717g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54717g.sendMessageDelayed(message, 60L);
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
                    if (this.f54713c == 0.0f || this.f54714d == 0.0f) {
                        this.f54713c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f54714d = rawY2;
                        this.f54711a = this.f54713c;
                        this.f54712b = rawY2;
                    }
                    int i2 = (int) (rawY - this.f54712b);
                    int i3 = (int) (rawY - this.f54714d);
                    if (this.f54715e != null) {
                        if (i2 > 0) {
                            e(i3, i2);
                        } else {
                            g(i3, i2);
                        }
                    }
                    this.f54711a = rawX;
                    this.f54712b = rawY;
                }
            }
            if (this.f54715e != null) {
                int i4 = (int) (this.f54711a - this.f54713c);
                int i5 = (int) (this.f54712b - this.f54714d);
                if (Math.abs(i4) >= Math.abs(i5)) {
                    f(i4, (int) this.f54713c);
                } else {
                    b(i4, i5);
                }
            }
            this.f54713c = 0.0f;
            this.f54714d = 0.0f;
        } else {
            this.f54713c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f54714d = rawY3;
            this.f54711a = this.f54713c;
            this.f54712b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f54715e = bVar;
    }

    public final void e(int i2, int i3) {
        this.f54717g.removeMessages(0);
        if (this.f54717g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54717g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i2, int i3) {
        this.f54717g.removeMessages(3);
        if (this.f54717g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54717g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i2, int i3) {
        this.f54717g.removeMessages(1);
        if (this.f54717g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54717g.sendMessageDelayed(message, 60L);
    }
}
