package d.l.a;

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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f67345a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67346b;

    /* renamed from: c  reason: collision with root package name */
    public c f67347c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f67348d = new ServiceConnectionC1852a();

    /* renamed from: d.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ServiceConnectionC1852a implements ServiceConnection {
        public ServiceConnectionC1852a() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f67345a.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
            a.this.f67345a.removeMessages(2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x001d */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.content.ServiceConnection */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                a.this.f67347c.b(-1, null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                a.this.f67347c.b(-2, null);
            } else {
                OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                int i2 = -4;
                i2 = -4;
                i2 = -4;
                i2 = -4;
                try {
                    try {
                        a.this.f67347c.a(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                        try {
                            a.this.f67346b.unbindService(a.this.f67348d);
                        } catch (Exception e2) {
                            a.this.f67347c.b(-4, e2);
                        }
                    } catch (RemoteException e3) {
                        a.this.f67347c.b(-3, e3);
                        try {
                            Context context = a.this.f67346b;
                            ServiceConnection serviceConnection = a.this.f67348d;
                            context.unbindService(serviceConnection);
                            i2 = serviceConnection;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        a.this.f67346b.unbindService(a.this.f67348d);
                    } catch (Exception e4) {
                        a.this.f67347c.b(i2, e4);
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(String str, boolean z);

        void b(int i, Exception exc);
    }

    public a(Context context, c cVar, Handler handler) {
        this.f67346b = context;
        this.f67347c = cVar;
        this.f67345a = new b(handler == null ? Looper.getMainLooper() : handler.getLooper());
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
        if (this.f67346b.bindService(intent, this.f67348d, 1)) {
            Handler handler = this.f67345a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 10000L);
            return;
        }
        this.f67345a.sendEmptyMessage(0);
    }
}
