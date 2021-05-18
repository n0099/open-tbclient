package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f38326b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f38327c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f38328a;

    /* renamed from: d  reason: collision with root package name */
    public a f38329d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f38330a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f38330a.f38328a = a.AbstractBinderC0472a.a(iBinder);
            if (this.f38330a.f38329d != null) {
                this.f38330a.f38329d.a(this.f38330a);
            }
            this.f38330a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f38330a.f38328a = null;
            this.f38330a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f38327c) {
            Log.i(f38326b, str);
        }
    }
}
