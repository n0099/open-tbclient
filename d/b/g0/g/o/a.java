package d.b.g0.g.o;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import d.b.g0.a.k;
import d.b.g0.g.c0.d;
/* loaded from: classes3.dex */
public class a implements DebugConsole {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48910b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public long f48911a;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i, String str) {
        if (!f48910b || d.d()) {
            return;
        }
        if (i == 0) {
            Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
        } else if (i == 1) {
            this.f48911a = System.currentTimeMillis();
            Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
        } else if (i != 2) {
        } else {
            Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f48911a), str));
        }
    }
}
