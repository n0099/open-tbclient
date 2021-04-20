package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zui.deviceidservice.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f41404b = "OpenDeviceId library";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41405c = false;

    /* renamed from: a  reason: collision with root package name */
    public com.zui.deviceidservice.a f41406a;

    /* renamed from: d  reason: collision with root package name */
    public a f41407d;

    /* renamed from: com.zui.opendeviceidlibrary.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f41408a;

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f41408a.f41406a = a.AbstractBinderC0538a.a(iBinder);
            if (this.f41408a.f41407d != null) {
                this.f41408a.f41407d.a(this.f41408a);
            }
            this.f41408a.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f41408a.f41406a = null;
            this.f41408a.a("Service onServiceDisconnected");
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f41405c) {
            Log.i(f41404b, str);
        }
    }
}
