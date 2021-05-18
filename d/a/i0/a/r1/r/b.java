package d.a.i0.a.r1.r;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.xiaomi.mipush.sdk.Constants;
import d.a.i0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public Map<Runnable, String> f44398b;

    /* renamed from: d.a.i0.a.r1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0802b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44399a = new b();
    }

    static {
        e.k();
    }

    public static b b() {
        return C0802b.f44399a;
    }

    public final void a() {
        if (this.f44398b.isEmpty()) {
            return;
        }
        if (d.a.i0.a.f1.f.a.f41678a) {
            Log.d("SwanPerformance", "main process batch handle thread, size = " + this.f44398b.size());
        }
        for (Map.Entry<Runnable, String> entry : this.f44398b.entrySet()) {
            if (entry != null) {
                ExecutorUtilsExt.postOnElastic(entry.getKey(), entry.getValue(), 2);
            }
        }
        this.f44398b.clear();
    }

    public void c(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("is_timeout", false);
        String string = bundle.getString(Constants.APP_ID, null);
        if (d.a.i0.a.f1.f.a.f41678a) {
            Log.e("SwanPerformance", "main process launch end，timeout = " + z + " ; appId = " + string);
        }
        a();
    }

    public void d(String str) {
        if (d.a.i0.a.f1.f.a.f41678a) {
            Log.e("SwanPerformance", "main process launch start，appId = " + str);
        }
        System.currentTimeMillis();
    }

    public b() {
        this.f44398b = new ConcurrentHashMap();
    }
}
