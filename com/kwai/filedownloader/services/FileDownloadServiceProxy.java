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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.b.b {
    private static final String TAG = "filedownloader";
    public Service context;
    private i handler;

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    /* loaded from: classes3.dex */
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        private String getProcessName(Context context) {
            String str;
            if (context == null) {
                return "ksad";
            }
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            str = "ksad";
            return str;
        }

        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(getProcessName(service.getApplicationContext()));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(FileDownloadServiceProxy.TAG, "WebView has already been initialized " + e.getMessage());
                }
            }
            super.onCreate(service);
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    /* loaded from: classes3.dex */
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
        com.kwai.filedownloader.f.c.a(this.context);
        try {
            com.kwai.filedownloader.f.f.a(com.kwai.filedownloader.f.e.a().f7213a);
            com.kwai.filedownloader.f.f.a(com.kwai.filedownloader.f.e.a().b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        g gVar = new g();
        if (com.kwai.filedownloader.f.e.a().d) {
            this.handler = new e(new WeakReference(this), gVar);
        } else {
            this.handler = new d(new WeakReference(this), gVar);
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.d();
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        this.handler.a(intent, i, i2);
        return 1;
    }
}
