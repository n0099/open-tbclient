package d.a.k0.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f44306a;

    /* renamed from: b  reason: collision with root package name */
    public d f44307b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f44308c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.n.b f44309d;

    /* renamed from: d.a.k0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0617a implements ServiceConnection {
        public ServiceConnectionC0617a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f44307b = d.a.a(iBinder);
            d.a.k0.n.b bVar = a.this.f44309d;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a aVar = a.this;
            aVar.f44307b = null;
            d.a.k0.n.b bVar = aVar.f44309d;
        }
    }

    public a(Context context) {
        this.f44306a = null;
        this.f44306a = context;
    }

    public String a() {
        try {
            if (this.f44307b != null) {
                return ((d.a.C0150a) this.f44307b).a();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b() {
        this.f44308c = new ServiceConnectionC0617a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        this.f44306a.bindService(intent, this.f44308c, 1);
    }
}
