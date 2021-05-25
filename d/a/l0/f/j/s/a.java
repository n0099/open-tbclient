package d.a.l0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.l0.f.j.b;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f46952a;

    /* renamed from: b  reason: collision with root package name */
    public static long f46953b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f46954c;

    /* renamed from: d  reason: collision with root package name */
    public static long f46955d;

    /* renamed from: f  reason: collision with root package name */
    public static final a f46957f = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f46956e = C0994a.f46958e;

    /* renamed from: d.a.l0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0994a implements Handler.Callback {

        /* renamed from: e  reason: collision with root package name */
        public static final C0994a f46958e = new C0994a();

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 0 && a.f46957f.g()) {
                a aVar = a.f46957f;
                if (a.f46953b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a aVar2 = a.f46957f;
                    a aVar3 = a.f46957f;
                    a.f46953b = (a.f46953b + elapsedRealtime) - a.f46955d;
                    a aVar4 = a.f46957f;
                    a.f46955d = elapsedRealtime;
                    a aVar5 = a.f46957f;
                    Handler handler = a.f46954c;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(0, 1000L);
                    }
                    a aVar6 = a.f46957f;
                    if ((a.f46953b / 1000) % 15 == 0) {
                        b bVar = b.o;
                        a aVar7 = a.f46957f;
                        bVar.U(a.f46953b);
                        return true;
                    }
                    return true;
                }
            }
            a aVar8 = a.f46957f;
            a.f46955d = 0L;
            a.f46957f.i(false);
            return true;
        }
    }

    public final long f() {
        return f46953b;
    }

    public final boolean g() {
        return f46952a;
    }

    public final void h() {
        long j = f46953b;
        if (j < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            return;
        }
        f46953b = j % StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        b.o.M();
    }

    public final void i(boolean z) {
        f46952a = z;
    }

    public final void j() {
        if (f46954c == null) {
            f46954c = new Handler(f46956e);
        }
        f46953b = b.o.A();
        f46952a = true;
        f46955d = SystemClock.elapsedRealtime();
        Handler handler = f46954c;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public final void k() {
        f46952a = false;
        Handler handler = f46954c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (f46955d > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f46953b = (f46953b + elapsedRealtime) - f46955d;
            f46955d = elapsedRealtime;
        }
        b.o.U(f46953b);
    }
}
