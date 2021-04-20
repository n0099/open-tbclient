package d.b.i0.f0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f55709a;

    /* renamed from: b  reason: collision with root package name */
    public float f55710b;

    /* renamed from: c  reason: collision with root package name */
    public float f55711c;

    /* renamed from: d  reason: collision with root package name */
    public float f55712d;

    /* renamed from: e  reason: collision with root package name */
    public b f55713e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f55714f = new C1287a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f55715g = new Handler(this.f55714f);

    /* renamed from: d.b.i0.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1287a implements Handler.Callback {
        public C1287a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            int i3 = message.what;
            if (i3 == 0) {
                a.this.f55713e.b(i, i2);
                return true;
            } else if (i3 == 1) {
                a.this.f55713e.c(i, i2);
                return true;
            } else if (i3 == 2) {
                a.this.f55713e.a(i, i2);
                return true;
            } else if (i3 != 3) {
                return false;
            } else {
                a.this.f55713e.d(i, i2);
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
        this.f55715g.removeMessages(2);
        if (this.f55715g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        message.arg2 = i2;
        this.f55715g.sendMessageDelayed(message, 60L);
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
                    if (this.f55711c == 0.0f || this.f55712d == 0.0f) {
                        this.f55711c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f55712d = rawY2;
                        this.f55709a = this.f55711c;
                        this.f55710b = rawY2;
                    }
                    int i = (int) (rawY - this.f55710b);
                    int i2 = (int) (rawY - this.f55712d);
                    if (this.f55713e != null) {
                        if (i > 0) {
                            e(i2, i);
                        } else {
                            g(i2, i);
                        }
                    }
                    this.f55709a = rawX;
                    this.f55710b = rawY;
                }
            }
            if (this.f55713e != null) {
                int i3 = (int) (this.f55709a - this.f55711c);
                int i4 = (int) (this.f55710b - this.f55712d);
                if (Math.abs(i3) >= Math.abs(i4)) {
                    f(i3, (int) this.f55711c);
                } else {
                    b(i3, i4);
                }
            }
            this.f55711c = 0.0f;
            this.f55712d = 0.0f;
        } else {
            this.f55711c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f55712d = rawY3;
            this.f55709a = this.f55711c;
            this.f55710b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f55713e = bVar;
    }

    public final void e(int i, int i2) {
        this.f55715g.removeMessages(0);
        if (this.f55715g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        message.arg2 = i2;
        this.f55715g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i, int i2) {
        this.f55715g.removeMessages(3);
        if (this.f55715g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i;
        message.arg2 = i2;
        this.f55715g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i, int i2) {
        this.f55715g.removeMessages(1);
        if (this.f55715g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i;
        message.arg2 = i2;
        this.f55715g.sendMessageDelayed(message, 60L);
    }
}
