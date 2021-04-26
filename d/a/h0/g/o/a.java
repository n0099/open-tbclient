package d.a.h0.g.o;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import d.a.h0.a.k;
import d.a.h0.g.c0.d;
/* loaded from: classes3.dex */
public class a implements DebugConsole {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46733b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public long f46734a;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i2, String str) {
        if (!f46733b || d.d()) {
            return;
        }
        if (i2 == 0) {
            Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
        } else if (i2 == 1) {
            this.f46734a = System.currentTimeMillis();
            Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
        } else if (i2 != 2) {
        } else {
            Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f46734a), str));
        }
    }
}
