package d.c.d.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes5.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final c f66713a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66714b;

    /* renamed from: d.c.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1831a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public int f66715e;

        public C1831a(int i) {
            this.f66715e = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f66715e);
            a.this.f66714b = true;
        }
    }

    public a(c cVar, String str, int i) {
        super(str, i);
        this.f66714b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f66713a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.f66714b && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f66713a != null) {
            this.f66714b = false;
            c cVar = this.f66713a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1831a(5000).start();
        }
    }
}
