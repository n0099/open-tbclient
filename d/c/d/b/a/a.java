package d.c.d.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final c f65773a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f65774b;

    /* renamed from: d.c.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1800a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public int f65775e;

        public C1800a(int i) {
            this.f65775e = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f65775e);
            a.this.f65774b = true;
        }
    }

    public a(c cVar, String str, int i) {
        super(str, i);
        this.f65774b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f65773a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.f65774b && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f65773a != null) {
            this.f65774b = false;
            c cVar = this.f65773a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1800a(5000).start();
        }
    }
}
