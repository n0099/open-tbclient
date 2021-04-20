package com.kuaishou.aegon;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.CronetEngine$Builder$LibraryLoader;
import aegon.chrome.net.impl.CronetLibraryLoader;
import aegon.chrome.net.impl.CronetUrlRequestContext;
import aegon.chrome.net.impl.NativeCronetEngineBuilderWithLibraryLoaderImpl;
import aegon.chrome.net.impl.VersionSafeCallbacks$LibraryLoader;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kuaishou.aegon.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class Aegon {
    public static final long CREATE_CRONET_CONTEXT_DELAY_MS = 3000;
    public static String LIBRARY_NAME = "aegon";
    public static final String TAG = "Aegon";
    public static Context sApplicationContext;
    public static volatile CronetUrlRequestContext sCronetContext;
    public static final Object sCronetContextMutex = new Object();
    public static AtomicBoolean sInitialized = new AtomicBoolean();
    public static SignalStrengthListener sSignalStrengthListener;

    /* loaded from: classes6.dex */
    public static abstract class LibraryLoader {
        public abstract void loadLibrary(String str);
    }

    public static void addExtraRequestHeader(String str, String str2) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$15.lambdaFactory$(str, str2));
        }
    }

    public static void addLogger(a aVar) {
        AegonLoggerDispatcher.a(aVar);
    }

    public static void clearHttpCache() {
        Runnable runnable;
        if (sInitialized.get()) {
            runnable = Aegon$$Lambda$7.instance;
            com.kuaishou.aegon.a.a.a(runnable);
        }
    }

    @Nullable
    public static CronetEngine getCronetEngine() {
        CronetUrlRequestContext cronetUrlRequestContext;
        Runnable runnable;
        Runnable runnable2;
        CronetUrlRequestContext cronetUrlRequestContext2 = sCronetContext;
        if (cronetUrlRequestContext2 != null) {
            return cronetUrlRequestContext2;
        }
        if (sInitialized.get()) {
            synchronized (sCronetContextMutex) {
                if (sCronetContext == null && sApplicationContext != null) {
                    long nanoTime = System.nanoTime();
                    NativeCronetEngineBuilderWithLibraryLoaderImpl nativeCronetEngineBuilderWithLibraryLoaderImpl = new NativeCronetEngineBuilderWithLibraryLoaderImpl(sApplicationContext);
                    nativeCronetEngineBuilderWithLibraryLoaderImpl.mLibraryLoader = new VersionSafeCallbacks$LibraryLoader(new CronetEngine$Builder$LibraryLoader() { // from class: com.kuaishou.aegon.Aegon.1
                        @Override // aegon.chrome.net.CronetEngine$Builder$LibraryLoader
                        public void loadLibrary(String str) {
                        }
                    });
                    sCronetContext = new CronetUrlRequestContext(nativeCronetEngineBuilderWithLibraryLoaderImpl);
                    runnable = Aegon$$Lambda$10.instance;
                    CronetLibraryLoader.postToInitThread(runnable);
                    runnable2 = Aegon$$Lambda$11.instance;
                    com.kuaishou.aegon.a.a.a(runnable2);
                    long nanoTime2 = System.nanoTime();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Create cronet engine finished, cost = ");
                    sb.append(nanoTime2 - nanoTime);
                    Log.i(TAG, sb.toString());
                }
                cronetUrlRequestContext = sCronetContext;
            }
            return cronetUrlRequestContext;
        }
        return null;
    }

    public static String getEffectiveConfig() {
        a.InterfaceC0367a interfaceC0367a;
        if (sInitialized.get()) {
            interfaceC0367a = Aegon$$Lambda$3.instance;
            return (String) com.kuaishou.aegon.a.a.a(interfaceC0367a);
        }
        return "";
    }

    public static long getHttpCacheUsedBytes() {
        a.InterfaceC0367a interfaceC0367a;
        if (sInitialized.get()) {
            interfaceC0367a = Aegon$$Lambda$6.instance;
            return ((Long) com.kuaishou.aegon.a.a.a(interfaceC0367a)).longValue();
        }
        return 0L;
    }

    public static String getPublicIP() {
        a.InterfaceC0367a interfaceC0367a;
        if (sInitialized.get()) {
            interfaceC0367a = Aegon$$Lambda$17.instance;
            return (String) com.kuaishou.aegon.a.a.a(interfaceC0367a);
        }
        return "";
    }

    @Nullable
    public static String getVersionString() {
        a.InterfaceC0367a interfaceC0367a;
        if (sInitialized.get()) {
            interfaceC0367a = Aegon$$Lambda$12.instance;
            return (String) com.kuaishou.aegon.a.a.a(interfaceC0367a);
        }
        return null;
    }

    public static void initialize(Context context, @Nullable String str, @Nullable String str2, @Nullable LibraryLoader libraryLoader) {
        Runnable runnable;
        Log.i(TAG, "Initializing, jsonConfig=" + str + ", storagePath=" + str2);
        long nanoTime = System.nanoTime();
        if (libraryLoader != null) {
            libraryLoader.loadLibrary(LIBRARY_NAME);
        } else {
            System.loadLibrary(LIBRARY_NAME);
        }
        com.kuaishou.aegon.a.a.a(Aegon$$Lambda$1.lambdaFactory$(str, str2));
        long nanoTime2 = System.nanoTime();
        Log.i(TAG, "Initialize finished, cost = " + (nanoTime2 - nanoTime));
        sApplicationContext = context;
        sInitialized.set(true);
        Handler handler = new Handler(context.getMainLooper());
        runnable = Aegon$$Lambda$2.instance;
        handler.postDelayed(runnable, 3000L);
    }

    public static boolean isInitialized() {
        return sInitialized.get();
    }

    public static native void nativeAddExtraRequestHeader(String str, String str2);

    public static native void nativeClearHttpCache();

    public static native String nativeGetEffectiveConfig();

    public static native long nativeGetHttpCacheUsedBytes();

    public static native String nativeGetPublicIP();

    public static native String nativeGetRequestExtraInfo(String str);

    public static native String nativeGetVersionString();

    public static native void nativeOnBackground();

    public static native void nativeOnForeground();

    public static native void nativeSetAutonomousNetworkAccessAllowed(boolean z);

    public static native void nativeSetDebug(boolean z);

    public static native void nativeSetInitialized(boolean z);

    public static native void nativeSetLoggingCallback(long j, boolean z);

    public static native void nativeSetPreconnectUrls(String str, String[] strArr);

    public static native void nativeUpdateConfig(String str, String str2);

    public static void onBackground() {
        Runnable runnable;
        if (sInitialized.get()) {
            runnable = Aegon$$Lambda$8.instance;
            com.kuaishou.aegon.a.a.a(runnable);
        }
    }

    public static void onForeground() {
        Runnable runnable;
        if (sInitialized.get()) {
            runnable = Aegon$$Lambda$9.instance;
            com.kuaishou.aegon.a.a.a(runnable);
        }
    }

    public static void removeLogger(a aVar) {
        AegonLoggerDispatcher.b(aVar);
    }

    public static void setAutonomousNetworkAccessAllowed(boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$16.lambdaFactory$(z));
        }
    }

    public static void setDebug(boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$4.lambdaFactory$(z));
        }
    }

    public static void setLoggingCallback(d dVar, boolean z) {
        AegonLoggingDispatcher.f31897a = dVar;
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$14.lambdaFactory$(z));
        }
    }

    public static void setNativeLoggingCallbackFunction(long j, boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$13.lambdaFactory$(j, z));
        }
    }

    public static void setPreconnectUrls(String str, String[] strArr) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$5.lambdaFactory$(str, strArr));
        }
    }

    public static void shutdown() {
        synchronized (sCronetContextMutex) {
            if (sCronetContext == null) {
                return;
            }
            sCronetContext.shutdown();
            sCronetContext = null;
        }
    }
}
