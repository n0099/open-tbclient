package d.b.g0.s.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f49381a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49382b;

    /* renamed from: c  reason: collision with root package name */
    public int f49383c;

    /* renamed from: d  reason: collision with root package name */
    public b f49384d;

    /* renamed from: d.b.g0.s.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1034a extends BroadcastReceiver {
        public C1034a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f49383c) {
                if (a.this.f49384d != null) {
                    a.this.f49384d.a(a.this.f49383c, d2);
                }
                a.this.f49383c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2);
    }

    public int d() {
        if (SwanAppNetworkUtils.i(this.f49382b)) {
            return 1;
        }
        return SwanAppNetworkUtils.h(this.f49382b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f49382b = context;
        this.f49383c = d();
        C1034a c1034a = new C1034a();
        this.f49381a = c1034a;
        this.f49382b.registerReceiver(c1034a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f49384d = bVar;
    }

    public void g() {
        Context context = this.f49382b;
        if (context != null) {
            context.unregisterReceiver(this.f49381a);
        }
    }
}
