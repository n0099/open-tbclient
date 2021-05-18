package d.a.i0.v.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f48366a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48367b;

    /* renamed from: c  reason: collision with root package name */
    public int f48368c;

    /* renamed from: d  reason: collision with root package name */
    public b f48369d;

    /* renamed from: d.a.i0.v.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1079a extends BroadcastReceiver {
        public C1079a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f48368c) {
                if (a.this.f48369d != null) {
                    a.this.f48369d.a(a.this.f48368c, d2);
                }
                a.this.f48368c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);
    }

    public int d() {
        if (SwanAppNetworkUtils.j(this.f48367b)) {
            return 1;
        }
        return SwanAppNetworkUtils.i(this.f48367b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f48367b = context;
        this.f48368c = d();
        C1079a c1079a = new C1079a();
        this.f48366a = c1079a;
        this.f48367b.registerReceiver(c1079a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f48369d = bVar;
    }

    public void g() {
        Context context = this.f48367b;
        if (context != null) {
            context.unregisterReceiver(this.f48366a);
        }
    }
}
