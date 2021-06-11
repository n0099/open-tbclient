package d.a.l0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.sapi2.SapiWebView;
import d.a.l0.f.j.b;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50626a;

    /* renamed from: b  reason: collision with root package name */
    public static long f50627b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f50628c;

    /* renamed from: d  reason: collision with root package name */
    public static long f50629d;

    /* renamed from: f  reason: collision with root package name */
    public static final a f50631f = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f50630e = C1050a.f50632e;

    /* renamed from: d.a.l0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1050a implements Handler.Callback {

        /* renamed from: e  reason: collision with root package name */
        public static final C1050a f50632e = new C1050a();

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 0 && a.f50631f.g()) {
                a aVar = a.f50631f;
                if (a.f50627b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a aVar2 = a.f50631f;
                    a aVar3 = a.f50631f;
                    a.f50627b = (a.f50627b + elapsedRealtime) - a.f50629d;
                    a aVar4 = a.f50631f;
                    a.f50629d = elapsedRealtime;
                    a aVar5 = a.f50631f;
                    Handler handler = a.f50628c;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(0, 1000L);
                    }
                    a aVar6 = a.f50631f;
                    if ((a.f50627b / 1000) % 15 == 0) {
                        b bVar = b.o;
                        a aVar7 = a.f50631f;
                        bVar.U(a.f50627b);
                        return true;
                    }
                    return true;
                }
            }
            a aVar8 = a.f50631f;
            a.f50629d = 0L;
            a.f50631f.i(false);
            return true;
        }
    }

    public final long f() {
        return f50627b;
    }

    public final boolean g() {
        return f50626a;
    }

    public final void h() {
        long j = f50627b;
        if (j < 30000) {
            return;
        }
        f50627b = j % 30000;
        b.o.M();
    }

    public final void i(boolean z) {
        f50626a = z;
    }

    public final void j() {
        if (f50628c == null) {
            f50628c = new Handler(f50630e);
        }
        f50627b = b.o.A();
        f50626a = true;
        f50629d = SystemClock.elapsedRealtime();
        Handler handler = f50628c;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public final void k() {
        f50626a = false;
        Handler handler = f50628c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (f50629d > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f50627b = (f50627b + elapsedRealtime) - f50629d;
            f50629d = elapsedRealtime;
        }
        b.o.U(f50627b);
    }
}
