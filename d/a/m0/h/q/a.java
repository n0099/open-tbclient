package d.a.m0.h.q;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import d.a.m0.a.k;
import d.a.m0.h.f0.h;
/* loaded from: classes3.dex */
public class a implements DebugConsole {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51429b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public long f51430a;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i2, String str) {
        if (!f51429b || h.d()) {
            return;
        }
        if (i2 == 0) {
            Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
        } else if (i2 == 1) {
            this.f51430a = System.currentTimeMillis();
            Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
        } else if (i2 != 2) {
        } else {
            Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f51430a), str));
        }
    }
}
