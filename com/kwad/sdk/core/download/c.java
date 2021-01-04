package com.kwad.sdk.core.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f9415a = KsAdSDKImpl.get().isDebugLogEnable();

    public static void a(String str) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadStart(), id=" + str);
        }
        Intent intent = new Intent(a.f9389b);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void a(String str, int i, int i2, int i3) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i);
        }
        Intent intent = new Intent(a.c);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putInt("KEY_RESULT_PROGRESS", i);
        bundle.putInt("KEY_RESULT_PROGRESS_SOFARBYTES", i2);
        bundle.putInt("KEY_RESULT_PROGRESS_TOTALBYTES", i3);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void a(String str, int i, String str2) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFail(), id=" + str + " error=" + i);
        }
        Intent intent = new Intent(a.e);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putInt("KEY_RESULT_ERROR_CODE", i);
        bundle.putString("KEY_RESULT_ERROR_MSG", str2);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void a(String str, String str2) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFinished(), id=" + str);
        }
        Intent intent = new Intent(a.d);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putString("KEY_REUSLT_FILEPATH", str2);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void b(String str) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadPaused(), id=" + str);
        }
        Intent intent = new Intent(a.f);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void c(String str) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadResumed(), id=" + str);
        }
        Intent intent = new Intent(a.g);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void d(String str) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
        }
        Intent intent = new Intent(a.h);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }

    public static void e(String str) {
        if (f9415a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
        }
        Intent intent = new Intent(a.m);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
        }
    }
}
