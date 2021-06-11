package d.a.l0.h.q;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import d.a.l0.a.k;
import d.a.l0.h.f0.h;
/* loaded from: classes3.dex */
public class a implements DebugConsole {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51321b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public long f51322a;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i2, String str) {
        if (!f51321b || h.d()) {
            return;
        }
        if (i2 == 0) {
            Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
        } else if (i2 == 1) {
            this.f51322a = System.currentTimeMillis();
            Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
        } else if (i2 != 2) {
        } else {
            Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f51322a), str));
        }
    }
}
