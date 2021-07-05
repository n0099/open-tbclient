package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.aegon.Aegon;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.cache.AwesomeCacheSoLoader;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.KsSoLoader;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.io.File;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile n f39991a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39992b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(245192123, "Lcom/kwai/video/ksvodplayerkit/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(245192123, "Lcom/kwai/video/ksvodplayerkit/h;");
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath() + File.separator + "ACache";
            }
            return context.getDir("vodCache", 0) + File.separator + "ACache";
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) || str == null) {
            return;
        }
        Aegon.initialize(context, str, context.getFilesDir().getAbsolutePath(), new Aegon.LibraryLoader() { // from class: com.kwai.video.ksvodplayerkit.h.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kuaishou.aegon.Aegon.LibraryLoader
            public void loadLibrary(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                    if (h.f39991a != null) {
                        h.f39991a.a(str2);
                        return;
                    }
                    com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! Aegon is using System.loadLibrary");
                    System.loadLibrary(str2);
                }
            }
        });
        Aegon.getCronetEngine();
        Aegon.setDebug(false);
    }

    public static void a(@NonNull Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, context, str, str2) == null) {
            AwesomeCacheInitConfig.setSoLoader(new AwesomeCacheSoLoader() { // from class: com.kwai.video.ksvodplayerkit.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwai.video.cache.AwesomeCacheSoLoader
                public void loadLibrary(String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                        if (h.f39991a != null) {
                            h.f39991a.a(str3);
                            return;
                        }
                        com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                        System.loadLibrary(str3);
                    }
                }
            });
            if (TextUtils.isEmpty(str)) {
                a(context);
            }
            AwesomeCacheInitConfig.init(context);
            KsMediaPlayerInitConfig.setSoLoader(new KsSoLoader() { // from class: com.kwai.video.ksvodplayerkit.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwai.video.player.KsSoLoader
                public void loadLibrary(String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                        if (h.f39991a != null) {
                            h.f39991a.a(str3);
                            return;
                        }
                        com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayerCommonInitConfig", "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                        System.loadLibrary(str3);
                    }
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
}
