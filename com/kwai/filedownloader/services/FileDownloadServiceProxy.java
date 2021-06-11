package com.kwai.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.lang.ref.WeakReference;
@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: classes7.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.b.b {
    public static final String TAG = "filedownloader";
    public Service context;
    public i handler;

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    /* loaded from: classes7.dex */
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        private String getProcessName(Context context) {
            if (context == null) {
                return "ksad";
            }
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "ksad";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "ksad";
            }
        }

        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(getProcessName(service.getApplicationContext()));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(FileDownloadServiceProxy.TAG, "WebView has already been initialized " + e2.getMessage());
                }
            }
            super.onCreate(service);
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    /* loaded from: classes7.dex */
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.a(intent);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        com.kwai.filedownloader.f.c.a(service);
        try {
            com.kwai.filedownloader.f.f.a(com.kwai.filedownloader.f.e.a().f37777a);
            com.kwai.filedownloader.f.f.a(com.kwai.filedownloader.f.e.a().f37778b);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        g gVar = new g();
        this.handler = com.kwai.filedownloader.f.e.a().f37780d ? new e(new WeakReference(this), gVar) : new d(new WeakReference(this), gVar);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.d();
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i2, int i3) {
        this.handler.a(intent, i2, i3);
        return 1;
    }
}
