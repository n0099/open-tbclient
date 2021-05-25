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
    public BroadcastReceiver f48542a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48543b;

    /* renamed from: c  reason: collision with root package name */
    public int f48544c;

    /* renamed from: d  reason: collision with root package name */
    public b f48545d;

    /* renamed from: d.a.l0.v.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1090a extends BroadcastReceiver {
        public C1090a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f48544c) {
                if (a.this.f48545d != null) {
                    a.this.f48545d.a(a.this.f48544c, d2);
                }
                a.this.f48544c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);
    }

    public int d() {
        if (SwanAppNetworkUtils.j(this.f48543b)) {
            return 1;
        }
        return SwanAppNetworkUtils.i(this.f48543b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f48543b = context;
        this.f48544c = d();
        C1090a c1090a = new C1090a();
        this.f48542a = c1090a;
        this.f48543b.registerReceiver(c1090a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f48545d = bVar;
    }

    public void g() {
        Context context = this.f48543b;
        if (context != null) {
            context.unregisterReceiver(this.f48542a);
        }
    }
}
