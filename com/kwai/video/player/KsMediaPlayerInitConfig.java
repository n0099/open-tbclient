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
/* loaded from: classes7.dex */
public class KsMediaPlayerInitConfig {
    public static String packageName;
    public static String packageVersion;
    public static volatile KsSoLoader sInjectedSoLoader;
    public static AtomicBoolean sSoLibInited = new AtomicBoolean(false);
    public static OnceReadyBarrier sSoLibReadyBarrirer = new OnceReadyBarrier();

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
                KsSoLoader ksSoLoader3 = KsSoLoader.this;
                if (ksSoLoader3 != null) {
                    ksSoLoader3.loadLibrary(str);
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

    public static void initAsync(final Context context) {
        new Thread() { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                KsMediaPlayerInitConfig.init(context);
            }
        }.start();
    }

    public static void initPackageName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageInfo.packageName;
                packageVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
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
