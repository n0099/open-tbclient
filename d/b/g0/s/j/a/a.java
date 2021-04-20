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
    public BroadcastReceiver f49773a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49774b;

    /* renamed from: c  reason: collision with root package name */
    public int f49775c;

    /* renamed from: d  reason: collision with root package name */
    public b f49776d;

    /* renamed from: d.b.g0.s.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1046a extends BroadcastReceiver {
        public C1046a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f49775c) {
                if (a.this.f49776d != null) {
                    a.this.f49776d.a(a.this.f49775c, d2);
                }
                a.this.f49775c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2);
    }

    public int d() {
        if (SwanAppNetworkUtils.i(this.f49774b)) {
            return 1;
        }
        return SwanAppNetworkUtils.h(this.f49774b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f49774b = context;
        this.f49775c = d();
        C1046a c1046a = new C1046a();
        this.f49773a = c1046a;
        this.f49774b.registerReceiver(c1046a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f49776d = bVar;
    }

    public void g() {
        Context context = this.f49774b;
        if (context != null) {
            context.unregisterReceiver(this.f49773a);
        }
    }
}
