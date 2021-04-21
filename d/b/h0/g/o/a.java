package d.b.h0.g.o;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import d.b.h0.a.k;
import d.b.h0.g.c0.d;
/* loaded from: classes3.dex */
public class a implements DebugConsole {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49239b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public long f49240a;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i, String str) {
        if (!f49239b || d.d()) {
            return;
        }
        if (i == 0) {
            Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
        } else if (i == 1) {
            this.f49240a = System.currentTimeMillis();
            Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
        } else if (i != 2) {
        } else {
            Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f49240a), str));
        }
    }
}
