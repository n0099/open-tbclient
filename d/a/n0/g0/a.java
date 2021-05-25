package d.a.n0.g0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f54899a;

    /* renamed from: b  reason: collision with root package name */
    public float f54900b;

    /* renamed from: c  reason: collision with root package name */
    public float f54901c;

    /* renamed from: d  reason: collision with root package name */
    public float f54902d;

    /* renamed from: e  reason: collision with root package name */
    public b f54903e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f54904f = new C1339a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f54905g = new Handler(this.f54904f);

    /* renamed from: d.a.n0.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1339a implements Handler.Callback {
        public C1339a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            int i4 = message.what;
            if (i4 == 0) {
                a.this.f54903e.a(i2, i3);
                return true;
            } else if (i4 == 1) {
                a.this.f54903e.b(i2, i3);
                return true;
            } else if (i4 == 2) {
                a.this.f54903e.d(i2, i3);
                return true;
            } else if (i4 != 3) {
                return false;
            } else {
                a.this.f54903e.c(i2, i3);
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
        this.f54905g.removeMessages(2);
        if (this.f54905g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54905g.sendMessageDelayed(message, 60L);
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
                    if (this.f54901c == 0.0f || this.f54902d == 0.0f) {
                        this.f54901c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f54902d = rawY2;
                        this.f54899a = this.f54901c;
                        this.f54900b = rawY2;
                    }
                    int i2 = (int) (rawY - this.f54900b);
                    int i3 = (int) (rawY - this.f54902d);
                    if (this.f54903e != null) {
                        if (i2 > 0) {
                            e(i3, i2);
                        } else {
                            g(i3, i2);
                        }
                    }
                    this.f54899a = rawX;
                    this.f54900b = rawY;
                }
            }
            if (this.f54903e != null) {
                int i4 = (int) (this.f54899a - this.f54901c);
                int i5 = (int) (this.f54900b - this.f54902d);
                if (Math.abs(i4) >= Math.abs(i5)) {
                    f(i4, (int) this.f54901c);
                } else {
                    b(i4, i5);
                }
            }
            this.f54901c = 0.0f;
            this.f54902d = 0.0f;
        } else {
            this.f54901c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f54902d = rawY3;
            this.f54899a = this.f54901c;
            this.f54900b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f54903e = bVar;
    }

    public final void e(int i2, int i3) {
        this.f54905g.removeMessages(0);
        if (this.f54905g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54905g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i2, int i3) {
        this.f54905g.removeMessages(3);
        if (this.f54905g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54905g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i2, int i3) {
        this.f54905g.removeMessages(1);
        if (this.f54905g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f54905g.sendMessageDelayed(message, 60L);
    }
}
