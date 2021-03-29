package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f41115b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41116c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f41117a;

    /* renamed from: d  reason: collision with root package name */
    public a f41118d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f41119a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f41119a.f41117a = a.AbstractBinderC0524a.a(iBinder);
            if (this.f41119a.f41118d != null) {
                this.f41119a.f41118d.a(this.f41119a);
            }
            this.f41119a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f41119a.f41117a = null;
            this.f41119a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f41116c) {
            Log.i(f41115b, str);
        }
    }
}
