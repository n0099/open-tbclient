package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f39081b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39082c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f39083a;

    /* renamed from: d  reason: collision with root package name */
    public a f39084d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f39085a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f39085a.f39083a = a.AbstractBinderC0485a.a(iBinder);
            if (this.f39085a.f39084d != null) {
                this.f39085a.f39084d.a(this.f39085a);
            }
            this.f39085a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f39085a.f39083a = null;
            this.f39085a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f39082c) {
            Log.i(f39081b, str);
        }
    }
}
