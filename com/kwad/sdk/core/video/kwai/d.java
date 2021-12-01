package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ay;
import com.kwai.video.ksvodplayerkit.CacheListener;
import com.kwai.video.ksvodplayerkit.CacheReceipt;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.core.video.kwai.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static volatile boolean f57848k;
    public static final Queue<d> l;
    public transient /* synthetic */ FieldHolder $fh;
    public final KSVodPlayerWrapper a;

    /* renamed from: b  reason: collision with root package name */
    public final a f57849b;

    /* renamed from: c  reason: collision with root package name */
    public String f57850c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f57851d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f57852e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57854g;

    /* renamed from: h  reason: collision with root package name */
    public int f57855h;

    /* renamed from: i  reason: collision with root package name */
    public int f57856i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57857j;
    public boolean m;
    public com.kwad.sdk.contentalliance.detail.video.c n;

    /* loaded from: classes2.dex */
    public static class a implements CacheListener, IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<d> a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(dVar);
        }

        private d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.a.get() : (d) invokeV.objValue;
        }

        public void onBufferingUpdate(int i2) {
            d a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (a = a()) == null) {
                return;
            }
            a.a(i2);
        }

        public void onCancelled(@Nullable CacheReceipt cacheReceipt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheReceipt) == null) {
            }
        }

        public void onCompleted(@Nullable CacheReceipt cacheReceipt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheReceipt) == null) {
            }
        }

        public void onError(int i2, int i3) {
            d a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || (a = a()) == null) {
                return;
            }
            a.f57857j = false;
            a.b(i2, i3);
        }

        public void onEvent(@KSVodConstants.KSVodPlayerEventType int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onEvent, what: " + i2);
                d a = a();
                if (a != null) {
                    if (i2 == 10100) {
                        a.d();
                    } else if (i2 == 10101) {
                        a.c();
                    } else {
                        if (i2 == 10209) {
                            a.t();
                        }
                        a.c(i2, i3);
                    }
                }
            }
        }

        public void onFailed(@Nullable CacheReceipt cacheReceipt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cacheReceipt) == null) {
            }
        }

        public void onFragmentCompleted(@Nullable CacheReceipt cacheReceipt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cacheReceipt) == null) {
                if (ay.a().b()) {
                    d a = a();
                    if (a != null) {
                        a.a.setCacheSessionListener((CacheListener) null);
                    }
                } else if (cacheReceipt == null || cacheReceipt.mBytesReadFromSource <= 0 || cacheReceipt.mReadSourceTimeCostMills == 0) {
                } else {
                    ay.a().a((cacheReceipt.mBytesReadFromSource - cacheReceipt.mInitAvailableBytesOfCache) / cacheReceipt.mReadSourceTimeCostMills);
                }
            }
        }

        public void onPlayerRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
            }
        }

        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPrepared");
                d a = a();
                if (a != null) {
                    a.b();
                }
            }
        }

        public void onProgress(@Nullable CacheReceipt cacheReceipt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cacheReceipt) == null) {
            }
        }

        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
                d a = a();
                if (a != null) {
                    a.a(i2, i3);
                    a.f57855h = i4;
                    a.f57856i = i5;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-939692087, "Lcom/kwad/sdk/core/video/kwai/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-939692087, "Lcom/kwad/sdk/core/video/kwai/d;");
                return;
            }
        }
        l = new ConcurrentLinkedQueue();
    }

    public d(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57852e = new Object();
        this.f57857j = false;
        this.m = true;
        Context applicationContext = context.getApplicationContext();
        synchronized (this.f57852e) {
            this.a = new KSVodPlayerWrapper(applicationContext);
        }
        a(context);
        this.f57849b = new a(this);
        r();
        a(false);
    }

    public static synchronized void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (d.class) {
                com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + f57848k);
                if (!f57848k) {
                    KSVodPlayerCoreInitConfig.init(context);
                    if (com.kwad.sdk.core.config.b.m()) {
                        KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.kwai.d.1
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

                            public void logTaskEvent(String str, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                                    com.kwad.sdk.core.video.kwai.kwai.a.a(str, str2);
                                }
                            }
                        });
                    }
                    f57848k = true;
                }
            }
        }
    }

    private void p() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (mediaDataSource = this.f57851d) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f57851d = null;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f57857j) {
            return;
        }
        try {
            int prepareAsync = this.a.prepareAsync();
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        } catch (IllegalStateException e2) {
            com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "realPrepare failed", e2);
        }
        this.f57857j = true;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.a.setOnPreparedListener(this.f57849b);
            this.a.setBufferingUpdateListener(this.f57849b);
            this.a.setOnEventListener(this.f57849b);
            this.a.setVideoSizeChangedListener(this.f57849b);
            this.a.setOnErrorListener(this.f57849b);
            if (com.kwad.sdk.core.config.b.u()) {
                this.a.setCacheSessionListener(this.f57849b);
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.a.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
            this.a.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
            this.a.setOnEventListener((IKSVodPlayer.OnEventListener) null);
            this.a.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
            this.a.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
            this.a.setCacheSessionListener((CacheListener) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Queue<d> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Iterator<d> it = l.iterator();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = 0;
                    break;
                } else if (it.next() == this) {
                    break;
                } else {
                    i3++;
                }
            }
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i3);
            int i4 = i3 + 1;
            if (i4 < l.size()) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
                while (true) {
                    queue = l;
                    if (i2 >= i4) {
                        break;
                    }
                    queue.poll();
                    i2++;
                }
                d poll = queue.poll();
                l.clear();
                if (poll != null) {
                    poll.e();
                } else {
                    com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.a.setVolume(f2, f3);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.a.seekTo((int) j2);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surface) == null) {
            this.a.setSurface(surface);
        }
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
        }
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.a == null || bVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(bVar.a);
        kSVodVideoContext.mClickTime = bVar.f57184b;
        kSVodVideoContext.mExtra = bVar.a();
        this.a.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.n = cVar;
            a(cVar.f57190e);
            a((TextUtils.isEmpty(cVar.f57188c) || !com.kwad.sdk.core.config.b.A()) ? cVar.f57187b : cVar.f57188c, (Map<String, String>) null);
        }
    }

    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, map) == null) {
            this.f57850c = str;
            this.a.setDataSource(str, map);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57854g = z;
            this.a.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.m) {
                q();
                return true;
            }
            if (!l.contains(this)) {
                l.offer(this);
            }
            if (l.size() == 1) {
                q();
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "prepareAsync first");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "start");
            q();
            this.a.start();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.getKwaiMediaPlayer().getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.getKwaiMediaPlayer().getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return this.a.getCurrentPosition();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                return this.a.getDuration();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean remove = l.remove(this);
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
            this.f57853f = true;
            this.a.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener(this) { // from class: com.kwad.sdk.core.video.kwai.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                public void onPlayerRelease() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
                    }
                }
            });
            p();
            a();
            s();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f57857j = false;
            try {
                IKwaiMediaPlayer kwaiMediaPlayer = this.a.getKwaiMediaPlayer();
                if (kwaiMediaPlayer != null) {
                    kwaiMediaPlayer.reset();
                }
            } catch (IllegalStateException unused) {
            }
            p();
            a();
            r();
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f57854g : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
