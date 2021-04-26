package d.a.h0.s.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f47635a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47636b;

    /* renamed from: c  reason: collision with root package name */
    public int f47637c;

    /* renamed from: d  reason: collision with root package name */
    public b f47638d;

    /* renamed from: d.a.h0.s.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1005a extends BroadcastReceiver {
        public C1005a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f47637c) {
                if (a.this.f47638d != null) {
                    a.this.f47638d.a(a.this.f47637c, d2);
                }
                a.this.f47637c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);
    }

    public int d() {
        if (SwanAppNetworkUtils.i(this.f47636b)) {
            return 1;
        }
        return SwanAppNetworkUtils.h(this.f47636b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f47636b = context;
        this.f47637c = d();
        C1005a c1005a = new C1005a();
        this.f47635a = c1005a;
        this.f47636b.registerReceiver(c1005a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f47638d = bVar;
    }

    public void g() {
        Context context = this.f47636b;
        if (context != null) {
            context.unregisterReceiver(this.f47635a);
        }
    }
}
