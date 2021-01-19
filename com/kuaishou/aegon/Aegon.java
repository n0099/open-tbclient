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
import com.baidu.android.imsdk.internal.IMConnection;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class Aegon {
    public static String LIBRARY_NAME = "aegon";
    public static SignalStrengthListener pNC;
    public static volatile CronetUrlRequestContext pNE;
    public static Context sApplicationContext;
    public static final Object pND = new Object();
    public static AtomicBoolean sInitialized = new AtomicBoolean();

    /* loaded from: classes4.dex */
    public static abstract class a {
        public abstract void loadLibrary(String str);
    }

    public static void a(Context context, @Nullable String str, @Nullable String str2, @Nullable a aVar) {
        Runnable runnable;
        Log.i("Aegon", "Initializing, jsonConfig=" + str + ", storagePath=" + str2);
        long nanoTime = System.nanoTime();
        if (aVar != null) {
            aVar.loadLibrary(LIBRARY_NAME);
        } else {
            System.loadLibrary(LIBRARY_NAME);
        }
        com.kuaishou.aegon.a.a.a(com.kuaishou.aegon.a.hq(str, str2));
        Log.i("Aegon", "Initialize finished, cost = " + (System.nanoTime() - nanoTime));
        sApplicationContext = context;
        sInitialized.set(true);
        Handler handler = new Handler(context.getMainLooper());
        runnable = d.pNJ;
        handler.postDelayed(runnable, IMConnection.RETRY_DELAY_TIMES);
    }

    @Nullable
    public static CronetEngine ezY() {
        CronetUrlRequestContext cronetUrlRequestContext;
        Runnable runnable;
        Runnable runnable2;
        CronetUrlRequestContext cronetUrlRequestContext2 = pNE;
        if (cronetUrlRequestContext2 != null) {
            return cronetUrlRequestContext2;
        }
        if (sInitialized.get()) {
            synchronized (pND) {
                if (pNE == null && sApplicationContext != null) {
                    long nanoTime = System.nanoTime();
                    NativeCronetEngineBuilderWithLibraryLoaderImpl nativeCronetEngineBuilderWithLibraryLoaderImpl = new NativeCronetEngineBuilderWithLibraryLoaderImpl(sApplicationContext);
                    nativeCronetEngineBuilderWithLibraryLoaderImpl.mLibraryLoader = new VersionSafeCallbacks$LibraryLoader(new CronetEngine$Builder$LibraryLoader() { // from class: com.kuaishou.aegon.Aegon.1
                        @Override // aegon.chrome.net.CronetEngine$Builder$LibraryLoader
                        public void loadLibrary(String str) {
                        }
                    });
                    pNE = new CronetUrlRequestContext(nativeCronetEngineBuilderWithLibraryLoaderImpl);
                    runnable = b.pNH;
                    CronetLibraryLoader.postToInitThread(runnable);
                    runnable2 = c.pNI;
                    com.kuaishou.aegon.a.a.a(runnable2);
                    Log.i("Aegon", "Create cronet engine finished, cost = " + (System.nanoTime() - nanoTime));
                }
                cronetUrlRequestContext = pNE;
            }
            return cronetUrlRequestContext;
        }
        return null;
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

    public static void setDebug(boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(e.Bm(z));
        }
    }
}
