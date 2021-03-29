package d.b.i0.f0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f54611a;

    /* renamed from: b  reason: collision with root package name */
    public float f54612b;

    /* renamed from: c  reason: collision with root package name */
    public float f54613c;

    /* renamed from: d  reason: collision with root package name */
    public float f54614d;

    /* renamed from: e  reason: collision with root package name */
    public b f54615e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f54616f = new C1244a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f54617g = new Handler(this.f54616f);

    /* renamed from: d.b.i0.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1244a implements Handler.Callback {
        public C1244a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            int i3 = message.what;
            if (i3 == 0) {
                a.this.f54615e.b(i, i2);
                return true;
            } else if (i3 == 1) {
                a.this.f54615e.c(i, i2);
                return true;
            } else if (i3 == 2) {
                a.this.f54615e.a(i, i2);
                return true;
            } else if (i3 != 3) {
                return false;
            } else {
                a.this.f54615e.d(i, i2);
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
        this.f54617g.removeMessages(2);
        if (this.f54617g.hasMessages(2)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54617g.sendMessageDelayed(message, 60L);
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
                    if (this.f54613c == 0.0f || this.f54614d == 0.0f) {
                        this.f54613c = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.f54614d = rawY2;
                        this.f54611a = this.f54613c;
                        this.f54612b = rawY2;
                    }
                    int i = (int) (rawY - this.f54612b);
                    int i2 = (int) (rawY - this.f54614d);
                    if (this.f54615e != null) {
                        if (i > 0) {
                            e(i2, i);
                        } else {
                            g(i2, i);
                        }
                    }
                    this.f54611a = rawX;
                    this.f54612b = rawY;
                }
            }
            if (this.f54615e != null) {
                int i3 = (int) (this.f54611a - this.f54613c);
                int i4 = (int) (this.f54612b - this.f54614d);
                if (Math.abs(i3) >= Math.abs(i4)) {
                    f(i3, (int) this.f54613c);
                } else {
                    b(i3, i4);
                }
            }
            this.f54613c = 0.0f;
            this.f54614d = 0.0f;
        } else {
            this.f54613c = motionEvent.getRawX();
            float rawY3 = motionEvent.getRawY();
            this.f54614d = rawY3;
            this.f54611a = this.f54613c;
            this.f54612b = rawY3;
        }
        return true;
    }

    public void d(b bVar) {
        this.f54615e = bVar;
    }

    public final void e(int i, int i2) {
        this.f54617g.removeMessages(0);
        if (this.f54617g.hasMessages(1)) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54617g.sendMessageDelayed(message, 60L);
    }

    public final void f(int i, int i2) {
        this.f54617g.removeMessages(3);
        if (this.f54617g.hasMessages(3)) {
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54617g.sendMessageDelayed(message, 60L);
    }

    public final void g(int i, int i2) {
        this.f54617g.removeMessages(1);
        if (this.f54617g.hasMessages(0)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.arg1 = i;
        message.arg2 = i2;
        this.f54617g.sendMessageDelayed(message, 60L);
    }
}
