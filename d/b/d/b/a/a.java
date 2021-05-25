package d.b.d.b.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final c f65844a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f65845b;

    /* renamed from: d.b.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1839a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public int f65846e;

        public C1839a(int i2) {
            this.f65846e = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f65846e);
            a.this.f65845b = true;
        }
    }

    public a(c cVar, String str, int i2) {
        super(str, i2);
        this.f65845b = true;
        if (cVar != null && !TextUtils.isEmpty(str)) {
            this.f65844a = cVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (this.f65845b && i2 == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.f65844a != null) {
            this.f65845b = false;
            c cVar = this.f65844a;
            cVar.e(200, "/data/anr/" + str, 80);
            getClass();
            new C1839a(5000).start();
        }
    }
}
