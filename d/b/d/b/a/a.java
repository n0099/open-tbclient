package d.b.d.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final c f69575a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f69576b;

    /* renamed from: d.b.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1898a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public int f69577e;

        public C1898a(int i2) {
            this.f69577e = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f69577e);
            a.this.f69576b = true;
        }
    }

    public a(c cVar, String str, int i2) {
        super(str, i2);
        this.f69576b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f69575a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (this.f69576b && i2 == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f69575a != null) {
            this.f69576b = false;
            c cVar = this.f69575a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1898a(5000).start();
        }
    }
}
