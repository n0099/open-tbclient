package d.b.h0.s.j.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f50102a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50103b;

    /* renamed from: c  reason: collision with root package name */
    public int f50104c;

    /* renamed from: d  reason: collision with root package name */
    public b f50105d;

    /* renamed from: d.b.h0.s.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1066a extends BroadcastReceiver {
        public C1066a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = a.this.d()) != a.this.f50104c) {
                if (a.this.f50105d != null) {
                    a.this.f50105d.a(a.this.f50104c, d2);
                }
                a.this.f50104c = d2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2);
    }

    public int d() {
        if (SwanAppNetworkUtils.i(this.f50103b)) {
            return 1;
        }
        return SwanAppNetworkUtils.h(this.f50103b) ? 2 : 0;
    }

    public void e(Context context) {
        this.f50103b = context;
        this.f50104c = d();
        C1066a c1066a = new C1066a();
        this.f50102a = c1066a;
        this.f50103b.registerReceiver(c1066a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void f(b bVar) {
        this.f50105d = bVar;
    }

    public void g() {
        Context context = this.f50103b;
        if (context != null) {
            context.unregisterReceiver(this.f50102a);
        }
    }
}
