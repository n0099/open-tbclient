package com.kwai.video.cache.util;

import com.kwai.video.cache.CacheSessionListener;
import com.kwai.video.hodor.anotations.CalledByNative;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CacheSessionListenerBridge {
    private static CacheSessionListener getListener(Object obj) {
        if (obj == null) {
            return null;
        }
        return (CacheSessionListener) ((WeakReference) obj).get();
    }

    @CalledByNative
    public static void onDownloadPaused(Object obj) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onDownloadPaused();
    }

    @CalledByNative
    public static void onDownloadProgress(Object obj, long j, long j2) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onDownloadProgress(j, j2);
    }

    @CalledByNative
    public static void onDownloadResumed(Object obj) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onDownloadResumed();
    }

    @CalledByNative
    public static void onDownloadStarted(Object obj, long j, String str, String str2, String str3, int i, long j2) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onDownloadStarted(j, str, str2, str3, i, j2);
    }

    @CalledByNative
    public static void onDownloadStopped(Object obj, int i, long j, long j2, String str, int i2, String str2, String str3, String str4, String str5) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onDownloadStopped(i, j, j2, str, i2, str2, str3, str4, str5);
    }

    @CalledByNative
    public static void onSessionClosed(Object obj, int i, long j, long j2, long j3, String str, boolean z) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onSessionClosed(i, j, j2, j3, str, z);
    }

    @CalledByNative
    public static void onSessionStart(Object obj, String str, long j, long j2, long j3) {
        CacheSessionListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.onSessionStart(str, j, j2, j3);
    }
}
