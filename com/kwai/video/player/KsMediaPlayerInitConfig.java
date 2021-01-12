package com.kwai.video.player;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.getkeepsafe.relinker.ReLinker;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class KsMediaPlayerInitConfig {
    private static volatile KsSoLoader sInjectedSoLoader;
    public static String packageName = null;
    public static String packageVersion = null;
    private static AtomicBoolean sSoLibInited = new AtomicBoolean(false);
    private static OnceReadyBarrier sSoLibReadyBarrirer = new OnceReadyBarrier();

    public static int getPlayerAliveCnt() {
        if (isSoLibInited()) {
            return KwaiMediaPlayer._getPlayerAliveCnt();
        }
        return -1;
    }

    public static void init(Context context) {
        final Context applicationContext = context.getApplicationContext();
        final KsSoLoader ksSoLoader = sInjectedSoLoader;
        KsSoLoader ksSoLoader2 = new KsSoLoader() { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.1
            @Override // com.kwai.video.player.KsSoLoader
            public void loadLibrary(String str) {
                if (KsSoLoader.this != null) {
                    KsSoLoader.this.loadLibrary(str);
                } else if (applicationContext != null) {
                    ReLinker.recursively().loadLibrary(applicationContext, str);
                } else {
                    System.loadLibrary(str);
                }
            }
        };
        ksSoLoader2.loadLibrary("c++_shared");
        ksSoLoader2.loadLibrary("kwaiplayer");
        sSoLibInited.set(true);
        sSoLibReadyBarrirer.setReady();
        Timber.v("[KsMediaPlayerInitConfig.init] to KwaiMediaPlayer.native_init", new Object[0]);
        KwaiMediaPlayer.native_init();
        Timber.v("[KsMediaPlayerInitConfig.init] to initPackageName", new Object[0]);
        initPackageName(context);
        Timber.v("[KsMediaPlayerInitConfig.init] all finish", new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwai.video.player.KsMediaPlayerInitConfig$4] */
    public static void initAsync(final Context context) {
        new Thread() { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                KsMediaPlayerInitConfig.init(context);
            }
        }.start();
    }

    private static void initPackageName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageInfo.packageName;
                packageVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSoLibInited() {
        return sSoLibInited.get();
    }

    public static void setReady() {
        sSoLibReadyBarrirer.setReady();
    }

    public static void setSoLoader(KsSoLoader ksSoLoader) {
        sInjectedSoLoader = ksSoLoader;
    }

    public static void waitSoLibReady() {
        AwesomeCacheInitConfig.waitSoLibReady();
        sSoLibReadyBarrirer.waitReady();
    }
}
