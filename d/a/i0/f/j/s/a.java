package d.a.i0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.i0.f.j.b;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f46776a;

    /* renamed from: b  reason: collision with root package name */
    public static long f46777b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f46778c;

    /* renamed from: d  reason: collision with root package name */
    public static long f46779d;

    /* renamed from: f  reason: collision with root package name */
    public static final a f46781f = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f46780e = C0983a.f46782e;

    /* renamed from: d.a.i0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0983a implements Handler.Callback {

        /* renamed from: e  reason: collision with root package name */
        public static final C0983a f46782e = new C0983a();

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 0 && a.f46781f.g()) {
                a aVar = a.f46781f;
                if (a.f46777b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a aVar2 = a.f46781f;
                    a aVar3 = a.f46781f;
                    a.f46777b = (a.f46777b + elapsedRealtime) - a.f46779d;
                    a aVar4 = a.f46781f;
                    a.f46779d = elapsedRealtime;
                    a aVar5 = a.f46781f;
                    Handler handler = a.f46778c;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(0, 1000L);
                    }
                    a aVar6 = a.f46781f;
                    if ((a.f46777b / 1000) % 15 == 0) {
                        b bVar = b.o;
                        a aVar7 = a.f46781f;
                        bVar.U(a.f46777b);
                        return true;
                    }
                    return true;
                }
            }
            a aVar8 = a.f46781f;
            a.f46779d = 0L;
            a.f46781f.i(false);
            return true;
        }
    }

    public final long f() {
        return f46777b;
    }

    public final boolean g() {
        return f46776a;
    }

    public final void h() {
        long j = f46777b;
        if (j < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            return;
        }
        f46777b = j % StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        b.o.M();
    }

    public final void i(boolean z) {
        f46776a = z;
    }

    public final void j() {
        if (f46778c == null) {
            f46778c = new Handler(f46780e);
        }
        f46777b = b.o.A();
        f46776a = true;
        f46779d = SystemClock.elapsedRealtime();
        Handler handler = f46778c;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public final void k() {
        f46776a = false;
        Handler handler = f46778c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (f46779d > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f46777b = (f46777b + elapsedRealtime) - f46779d;
            f46779d = elapsedRealtime;
        }
        b.o.U(f46777b);
    }
}
