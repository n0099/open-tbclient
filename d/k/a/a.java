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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f66204a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66205b;

    /* renamed from: c  reason: collision with root package name */
    public c f66206c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f66207d = new ServiceConnectionC1812a();

    /* renamed from: d.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ServiceConnectionC1812a implements ServiceConnection {
        public ServiceConnectionC1812a() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f66204a.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
            a.this.f66204a.removeMessages(2);
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
                a.this.f66206c.b(-1, null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                a.this.f66206c.b(-2, null);
            } else {
                OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                int i2 = -4;
                i2 = -4;
                i2 = -4;
                i2 = -4;
                try {
                    try {
                        a.this.f66206c.a(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                        try {
                            a.this.f66205b.unbindService(a.this.f66207d);
                        } catch (Exception e2) {
                            a.this.f66206c.b(-4, e2);
                        }
                    } catch (RemoteException e3) {
                        a.this.f66206c.b(-3, e3);
                        try {
                            Context context = a.this.f66205b;
                            ServiceConnection serviceConnection = a.this.f66207d;
                            context.unbindService(serviceConnection);
                            i2 = serviceConnection;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        a.this.f66205b.unbindService(a.this.f66207d);
                    } catch (Exception e4) {
                        a.this.f66206c.b(i2, e4);
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
        this.f66205b = context;
        this.f66206c = cVar;
        this.f66204a = new b(handler == null ? Looper.getMainLooper() : handler.getLooper());
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
        if (this.f66205b.bindService(intent, this.f66207d, 1)) {
            Handler handler = this.f66204a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 10000L);
            return;
        }
        this.f66204a.sendEmptyMessage(0);
    }
}
