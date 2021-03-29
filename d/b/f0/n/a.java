package d.b.f0.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sso.m.d;
import d.b.f0.m.c;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f43037a;

    /* renamed from: b  reason: collision with root package name */
    public d f43038b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f43039c;

    /* renamed from: d  reason: collision with root package name */
    public String f43040d;

    /* renamed from: d.b.f0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0587a implements ServiceConnection {
        public ServiceConnectionC0587a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f43038b = d.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f43038b = null;
        }
    }

    public a(Context context, c cVar) {
        this.f43037a = null;
        this.f43037a = context;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f43040d)) {
            if (this.f43038b != null) {
                this.f43040d = this.f43038b.a();
            }
            return this.f43040d;
        }
        return this.f43040d;
    }
}
