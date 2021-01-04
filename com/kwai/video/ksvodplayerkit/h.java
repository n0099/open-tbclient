package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.cache.AwesomeCacheSoLoader;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.KsSoLoader;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.io.File;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f11392a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11393b = true;

    public static String a(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir.getAbsolutePath() + File.separator + "ACache" : context.getDir("vodCache", 0) + File.separator + "ACache";
    }

    public static void a(Context context, String str) {
        if (str != null) {
            Aegon.a(context, str, context.getFilesDir().getAbsolutePath(), new Aegon.a() { // from class: com.kwai.video.ksvodplayerkit.h.3
                @Override // com.kuaishou.aegon.Aegon.a
                public void loadLibrary(String str2) {
                    if (h.f11392a != null) {
                        h.f11392a.a(str2);
                        return;
                    }
                    com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! Aegon is using System.loadLibrary");
                    System.loadLibrary(str2);
                }
            });
            Aegon.eDm();
            Aegon.setDebug(false);
        }
    }

    public static void a(@NonNull Context context, String str, String str2) {
        AwesomeCacheInitConfig.setSoLoader(new AwesomeCacheSoLoader() { // from class: com.kwai.video.ksvodplayerkit.h.1
            @Override // com.kwai.video.cache.AwesomeCacheSoLoader
            public void loadLibrary(String str3) {
                if (h.f11392a != null) {
                    h.f11392a.a(str3);
                    return;
                }
                com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                System.loadLibrary(str3);
            }
        });
        if (TextUtils.isEmpty(str)) {
            a(context);
        }
        AwesomeCacheInitConfig.init(context);
        KsMediaPlayerInitConfig.setSoLoader(new KsSoLoader() { // from class: com.kwai.video.ksvodplayerkit.h.2
            @Override // com.kwai.video.player.KsSoLoader
            public void loadLibrary(String str3) {
                if (h.f11392a != null) {
                    h.f11392a.a(str3);
                    return;
                }
                com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                System.loadLibrary(str3);
            }
        });
        KsMediaPlayerInitConfig.init(context);
        KsMediaPlayer.native_profileBegin("libkwaiplayer.so");
        KwaiMediaPlayer.native_setLogLevel(4);
        KwaiMediaPlayer.native_setKwaiLogLevel(4);
        if (!TextUtils.isEmpty(str2)) {
            a(context, str2);
        }
        com.kwai.video.ksvodplayerkit.d.c.a().a(context);
    }
}
