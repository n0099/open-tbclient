package d.a.n0.g0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f58588a;

    /* renamed from: b  reason: collision with root package name */
    public float f58589b;

    /* renamed from: c  reason: collision with root package name */
    public float f58590c;

    /* renamed from: d  reason: collision with root package name */
    public float f58591d;

    /* renamed from: e  reason: collision with root package name */
    public b f58592e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f58593f = new C1395a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f58594g = new Handler(this.f58593f);

    /* renamed from: d.a.n0.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1395a implements Handler.Callback {
        public C1395a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            int i4 = message.what;
            if (i4 == 0) {
                a.this.f58592e.a(i2, i3);
                return true;
            } else if (i4 == 1) {
                a.this.f58592e.b(i2, i3);
                return true;
            } else if (i4 == 2) {
                a.this.f58592e.d(i2, i3);
                return true;
            } else if (i4 != 3) {
                return false;
            } else {
                a.this.f58592e.c(i2, i3);
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
        this.f58594g.removeMessages(2);
        if (this.f58594g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f58594g.sendMessageDelayed(message, 60L);
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
                    if (this.f58590c == 0.0f || this.f58591d == 0.0f) {
                        this.f58590c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f58591d = rawY2;
                        this.f58588a = this.f58590c;
                        this.f58589b = rawY2;
                    }
                    int i2 = (int) (rawY - this.f58589b);
                    int i3 = (int) (rawY - this.f58591d);
                    if (this.f58592e != null) {
                        if (i2 > 0) {
                            e(i3, i2);
                        } else {
                            g(i3, i2);
                        }
                    }
                    this.f58588a = rawX;
                    this.f58589b = rawY;
                }
            }
            if (this.f58592e != null) {
                int i4 = (int) (this.f58588a - this.f58590c);
                int i5 = (int) (this.f58589b - this.f58591d);
                if (Math.abs(i4) >= Math.abs(i5)) {
                    f(i4, (int) this.f58590c);
                } else {
                    b(i4, i5);
                }
            }
            this.f58590c = 0.0f;
            this.f58591d = 0.0f;
        } else {
            this.f58590c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f58591d = rawY3;
            this.f58588a = this.f58590c;
            this.f58589b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f58592e = bVar;
    }

    public final void e(int i2, int i3) {
        this.f58594g.removeMessages(0);
        if (this.f58594g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f58594g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i2, int i3) {
        this.f58594g.removeMessages(3);
        if (this.f58594g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f58594g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i2, int i3) {
        this.f58594g.removeMessages(1);
        if (this.f58594g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i2;
        message.arg2 = i3;
        this.f58594g.sendMessageDelayed(message, 60L);
    }
}
