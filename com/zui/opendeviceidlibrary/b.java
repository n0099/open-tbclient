package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f42011b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f42012c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f42013a;

    /* renamed from: d  reason: collision with root package name */
    public a f42014d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42015a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f42015a.f42013a = a.AbstractBinderC0532a.a(iBinder);
            if (this.f42015a.f42014d != null) {
                this.f42015a.f42014d.a(this.f42015a);
            }
            this.f42015a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f42015a.f42013a = null;
            this.f42015a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f42012c) {
            Log.i(f42011b, str);
        }
    }
}
