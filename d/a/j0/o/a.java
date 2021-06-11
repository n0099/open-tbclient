package d.a.j0.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f44166a;

    /* renamed from: b  reason: collision with root package name */
    public d f44167b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f44168c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.n.b f44169d;

    /* renamed from: d.a.j0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0613a implements ServiceConnection {
        public ServiceConnectionC0613a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f44167b = d.a.a(iBinder);
            d.a.j0.n.b bVar = a.this.f44169d;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a aVar = a.this;
            aVar.f44167b = null;
            d.a.j0.n.b bVar = aVar.f44169d;
        }
    }

    public a(Context context) {
        this.f44166a = null;
        this.f44166a = context;
    }

    public String a() {
        try {
            if (this.f44167b != null) {
                return ((d.a.C0147a) this.f44167b).a();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b() {
        this.f44168c = new ServiceConnectionC0613a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        this.f44166a.bindService(intent, this.f44168c, 1);
    }
}
