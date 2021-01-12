package com.kwai.video.cache;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.Hodor;
import com.kwai.video.hodor.HodorConfig;
import com.kwai.video.hodor.NetworkMonitor;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes4.dex */
public class AwesomeCacheInitConfig {
    private static volatile AwesomeCacheSoLoader sAwesomeCacheSoLoader;
    private static boolean mInited = false;
    private static OnceReadyBarrier sSoLibReadyBarrirer = new OnceReadyBarrier();

    public static synchronized void init(Context context) {
        synchronized (AwesomeCacheInitConfig.class) {
            if (!mInited) {
                final Context applicationContext = context == null ? null : context.getApplicationContext();
                final AwesomeCacheSoLoader awesomeCacheSoLoader = sAwesomeCacheSoLoader;
                AwesomeCacheSoLoader awesomeCacheSoLoader2 = new AwesomeCacheSoLoader() { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.1
                    @Override // com.kwai.video.cache.AwesomeCacheSoLoader
                    public void loadLibrary(String str) {
                        if (AwesomeCacheSoLoader.this != null) {
                            AwesomeCacheSoLoader.this.loadLibrary(str);
                        } else if (applicationContext != null) {
                            ReLinker.recursively().loadLibrary(applicationContext, str);
                        } else {
                            Timber.w("WARNING! AwesomeCacheSoLoader is using System.loadLibrary", new Object[0]);
                            System.loadLibrary(str);
                        }
                    }
                };
                awesomeCacheSoLoader2.loadLibrary("c++_shared");
                awesomeCacheSoLoader2.loadLibrary("aegon");
                awesomeCacheSoLoader2.loadLibrary("hodor");
                sSoLibReadyBarrirer.setReady();
                Hodor.loadJavaClass();
                HodorConfig.init(context);
                AwesomeCache.VodAdaptive.init(context);
                NetworkMonitor.initNetworkChangeReceiver(applicationContext);
                mInited = true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwai.video.cache.AwesomeCacheInitConfig$2] */
    public static void initAsync(final Context context) {
        new Thread() { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                AwesomeCacheInitConfig.init(context);
            }
        }.start();
    }

    public static void setReady() {
        sSoLibReadyBarrirer.setReady();
    }

    public static void setSoLoader(AwesomeCacheSoLoader awesomeCacheSoLoader) {
        sAwesomeCacheSoLoader = awesomeCacheSoLoader;
    }

    public static void waitSoLibReady() {
        sSoLibReadyBarrirer.waitReady();
    }
}
