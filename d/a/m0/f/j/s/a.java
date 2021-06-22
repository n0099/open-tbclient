package d.a.m0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.sapi2.SapiWebView;
import d.a.m0.f.j.b;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50734a;

    /* renamed from: b  reason: collision with root package name */
    public static long f50735b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f50736c;

    /* renamed from: d  reason: collision with root package name */
    public static long f50737d;

    /* renamed from: f  reason: collision with root package name */
    public static final a f50739f = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f50738e = C1053a.f50740e;

    /* renamed from: d.a.m0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1053a implements Handler.Callback {

        /* renamed from: e  reason: collision with root package name */
        public static final C1053a f50740e = new C1053a();

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 0 && a.f50739f.g()) {
                a aVar = a.f50739f;
                if (a.f50735b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a aVar2 = a.f50739f;
                    a aVar3 = a.f50739f;
                    a.f50735b = (a.f50735b + elapsedRealtime) - a.f50737d;
                    a aVar4 = a.f50739f;
                    a.f50737d = elapsedRealtime;
                    a aVar5 = a.f50739f;
                    Handler handler = a.f50736c;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(0, 1000L);
                    }
                    a aVar6 = a.f50739f;
                    if ((a.f50735b / 1000) % 15 == 0) {
                        b bVar = b.o;
                        a aVar7 = a.f50739f;
                        bVar.U(a.f50735b);
                        return true;
                    }
                    return true;
                }
            }
            a aVar8 = a.f50739f;
            a.f50737d = 0L;
            a.f50739f.i(false);
            return true;
        }
    }

    public final long f() {
        return f50735b;
    }

    public final boolean g() {
        return f50734a;
    }

    public final void h() {
        long j = f50735b;
        if (j < 30000) {
            return;
        }
        f50735b = j % 30000;
        b.o.M();
    }

    public final void i(boolean z) {
        f50734a = z;
    }

    public final void j() {
        if (f50736c == null) {
            f50736c = new Handler(f50738e);
        }
        f50735b = b.o.A();
        f50734a = true;
        f50737d = SystemClock.elapsedRealtime();
        Handler handler = f50736c;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public final void k() {
        f50734a = false;
        Handler handler = f50736c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (f50737d > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f50735b = (f50735b + elapsedRealtime) - f50737d;
            f50737d = elapsedRealtime;
        }
        b.o.U(f50735b);
    }
}
