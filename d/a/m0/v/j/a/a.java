package d.a.m0.v.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f52324a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52325b;

    /* renamed from: c  reason: collision with root package name */
    public int f52326c;

    /* renamed from: d  reason: collision with root package name */
    public b f52327d;

    /* renamed from: d.a.m0.v.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1149a extends BroadcastReceiver {
        public C1149a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f52326c) {
                if (a.this.f52327d != null) {
                    a.this.f52327d.a(a.this.f52326c, d2);
                }
                a.this.f52326c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);
    }

    public int d() {
        if (SwanAppNetworkUtils.j(this.f52325b)) {
            return 1;
        }
        return SwanAppNetworkUtils.i(this.f52325b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f52325b = context;
        this.f52326c = d();
        C1149a c1149a = new C1149a();
        this.f52324a = c1149a;
        this.f52325b.registerReceiver(c1149a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f52327d = bVar;
    }

    public void g() {
        Context context = this.f52325b;
        if (context != null) {
            context.unregisterReceiver(this.f52324a);
        }
    }
}
