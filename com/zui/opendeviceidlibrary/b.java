package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f38255b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f38256c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f38257a;

    /* renamed from: d  reason: collision with root package name */
    public a f38258d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f38259a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f38259a.f38257a = a.AbstractBinderC0473a.a(iBinder);
            if (this.f38259a.f38258d != null) {
                this.f38259a.f38258d.a(this.f38259a);
            }
            this.f38259a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f38259a.f38257a = null;
            this.f38259a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f38256c) {
            Log.i(f38255b, str);
        }
    }
}
