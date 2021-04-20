package d.c.d.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes5.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final c f66618a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66619b;

    /* renamed from: d.c.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1828a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public int f66620e;

        public C1828a(int i) {
            this.f66620e = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f66620e);
            a.this.f66619b = true;
        }
    }

    public a(c cVar, String str, int i) {
        super(str, i);
        this.f66619b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f66618a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.f66619b && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f66618a != null) {
            this.f66619b = false;
            c cVar = this.f66618a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1828a(5000).start();
        }
    }
}
