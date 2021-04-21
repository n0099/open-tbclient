package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f41499b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41500c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f41501a;

    /* renamed from: d  reason: collision with root package name */
    public a f41502d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f41503a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f41503a.f41501a = a.AbstractBinderC0541a.a(iBinder);
            if (this.f41503a.f41502d != null) {
                this.f41503a.f41502d.a(this.f41503a);
            }
            this.f41503a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f41503a.f41501a = null;
            this.f41503a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f41500c) {
            Log.i(f41499b, str);
        }
    }
}
