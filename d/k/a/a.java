package d.k.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f70292a;

    /* renamed from: b  reason: collision with root package name */
    public Context f70293b;

    /* renamed from: c  reason: collision with root package name */
    public c f70294c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f70295d = new ServiceConnectionC1918a();

    /* renamed from: d.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC1918a implements ServiceConnection {
        public ServiceConnectionC1918a() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f70292a.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
            a.this.f70292a.removeMessages(2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x001d */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.content.ServiceConnection */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                a.this.f70294c.a(-1, null);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                a.this.f70294c.a(-2, null);
            } else {
                OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                int i3 = -4;
                i3 = -4;
                i3 = -4;
                i3 = -4;
                try {
                    try {
                        a.this.f70294c.b(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                        try {
                            a.this.f70293b.unbindService(a.this.f70295d);
                        } catch (Exception e2) {
                            a.this.f70294c.a(-4, e2);
                        }
                    } catch (RemoteException e3) {
                        a.this.f70294c.a(-3, e3);
                        try {
                            Context context = a.this.f70293b;
                            ServiceConnection serviceConnection = a.this.f70295d;
                            context.unbindService(serviceConnection);
                            i3 = serviceConnection;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        a.this.f70293b.unbindService(a.this.f70295d);
                    } catch (Exception e4) {
                        a.this.f70294c.a(i3, e4);
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i2, Exception exc);

        void b(String str, boolean z);
    }

    public a(Context context, c cVar, Handler handler) {
        this.f70293b = context;
        this.f70294c = cVar;
        this.f70292a = new b(handler == null ? Looper.getMainLooper() : handler.getLooper());
    }

    public static void d(Context context, c cVar) {
        e(context, cVar, null);
    }

    public static void e(Context context, c cVar, Handler handler) {
        new a(context.getApplicationContext(), cVar, handler).f();
    }

    public final void f() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.f70293b.bindService(intent, this.f70295d, 1)) {
            Handler handler = this.f70292a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 10000L);
            return;
        }
        this.f70292a.sendEmptyMessage(0);
    }
}
