package d.a.l0.v.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f52216a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52217b;

    /* renamed from: c  reason: collision with root package name */
    public int f52218c;

    /* renamed from: d  reason: collision with root package name */
    public b f52219d;

    /* renamed from: d.a.l0.v.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1146a extends BroadcastReceiver {
        public C1146a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f52218c) {
                if (a.this.f52219d != null) {
                    a.this.f52219d.a(a.this.f52218c, d2);
                }
                a.this.f52218c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);
    }

    public int d() {
        if (SwanAppNetworkUtils.j(this.f52217b)) {
            return 1;
        }
        return SwanAppNetworkUtils.i(this.f52217b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f52217b = context;
        this.f52218c = d();
        C1146a c1146a = new C1146a();
        this.f52216a = c1146a;
        this.f52217b.registerReceiver(c1146a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f52219d = bVar;
    }

    public void g() {
        Context context = this.f52217b;
        if (context != null) {
            context.unregisterReceiver(this.f52216a);
        }
    }
}
