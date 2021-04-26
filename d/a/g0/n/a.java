package d.a.g0.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sso.m.d;
import d.a.g0.m.c;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40983a;

    /* renamed from: b  reason: collision with root package name */
    public d f40984b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f40985c;

    /* renamed from: d  reason: collision with root package name */
    public String f40986d;

    /* renamed from: d.a.g0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0557a implements ServiceConnection {
        public ServiceConnectionC0557a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f40984b = d.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f40984b = null;
        }
    }

    public a(Context context, c cVar) {
        this.f40983a = null;
        this.f40983a = context;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f40986d)) {
            if (this.f40984b != null) {
                this.f40986d = this.f40984b.a();
            }
            return this.f40986d;
        }
        return this.f40986d;
    }
}
