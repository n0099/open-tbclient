package com.kwad.sdk.core.video.a;

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
import com.kwad.sdk.utils.as;
import com.kwai.video.ksvodplayerkit.CacheListener;
import com.kwai.video.ksvodplayerkit.CacheReceipt;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean k;
    public static final Queue<d> l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final KSVodPlayerWrapper f65084a;

    /* renamed from: b  reason: collision with root package name */
    public final a f65085b;

    /* renamed from: c  reason: collision with root package name */
    public String f65086c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f65087d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f65088e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65089f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65090g;

    /* renamed from: h  reason: collision with root package name */
    public int f65091h;

    /* renamed from: i  reason: collision with root package name */
    public int f65092i;
    public boolean j;
    public boolean m;
    public com.kwad.sdk.contentalliance.detail.video.c n;

    /* loaded from: classes2.dex */
    public static class a implements CacheListener, IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f65094a;

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
            this.f65094a = new WeakReference<>(dVar);
        }

        private d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f65094a.get() : (d) invokeV.objValue;
        }

        public void onBufferingUpdate(int i2) {
            d a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (a2 = a()) == null) {
                return;
            }
            a2.a(i2);
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
            d a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || (a2 = a()) == null) {
                return;
            }
            a2.j = false;
            a2.b(i2, i3);
        }

        public void onEvent(@KSVodConstants.KSVodPlayerEventType int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onEvent, what: " + i2);
                d a2 = a();
                if (a2 != null) {
                    if (i2 == 10100) {
                        a2.d();
                    } else if (i2 == 10101) {
                        a2.c();
                    } else {
                        if (i2 == 10209) {
                            a2.s();
                        }
                        a2.c(i2, i3);
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
                if (as.a().b()) {
                    d a2 = a();
                    if (a2 != null) {
                        a2.f65084a.setCacheSessionListener((CacheListener) null);
                    }
                } else if (cacheReceipt == null || cacheReceipt.mBytesReadFromSource <= 0 || cacheReceipt.mReadSourceTimeCostMills == 0) {
                } else {
                    as.a().a((cacheReceipt.mBytesReadFromSource - cacheReceipt.mInitAvailableBytesOfCache) / cacheReceipt.mReadSourceTimeCostMills);
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
                d a2 = a();
                if (a2 != null) {
                    a2.b();
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
                d a2 = a();
                if (a2 != null) {
                    a2.a(i2, i3);
                    a2.f65091h = i4;
                    a2.f65092i = i5;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1198306802, "Lcom/kwad/sdk/core/video/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1198306802, "Lcom/kwad/sdk/core/video/a/d;");
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
        this.f65088e = new Object();
        this.j = false;
        this.m = true;
        Context applicationContext = context.getApplicationContext();
        synchronized (this.f65088e) {
            this.f65084a = new KSVodPlayerWrapper(applicationContext);
        }
        a(context);
        this.f65085b = new a(this);
        q();
    }

    public static synchronized void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (d.class) {
                com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
                if (!k) {
                    KSVodPlayerCoreInitConfig.init(context);
                    if (com.kwad.sdk.core.config.c.r()) {
                        KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.a.d.1
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
                                    com.kwad.sdk.core.video.a.a.a.a(str, str2);
                                }
                            }
                        });
                    }
                    k = true;
                }
            }
        }
    }

    private void o() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (mediaDataSource = this.f65087d) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f65087d = null;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.j) {
            return;
        }
        int prepareAsync = this.f65084a.prepareAsync();
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        this.j = true;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f65084a.setOnPreparedListener(this.f65085b);
            this.f65084a.setBufferingUpdateListener(this.f65085b);
            this.f65084a.setOnEventListener(this.f65085b);
            this.f65084a.setVideoSizeChangedListener(this.f65085b);
            this.f65084a.setOnErrorListener(this.f65085b);
            if (com.kwad.sdk.core.config.c.w()) {
                this.f65084a.setCacheSessionListener(this.f65085b);
            }
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f65084a.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
            this.f65084a.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
            this.f65084a.setOnEventListener((IKSVodPlayer.OnEventListener) null);
            this.f65084a.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
            this.f65084a.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
            this.f65084a.setCacheSessionListener((CacheListener) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
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

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f65084a.setVolume(f2, f3);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f65084a.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surface) == null) {
            this.f65084a.setSurface(surface);
        }
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
        }
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f65084a == null || bVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(bVar.f64249a);
        kSVodVideoContext.mClickTime = bVar.f64250b;
        kSVodVideoContext.mExtra = bVar.a();
        this.f65084a.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.n = cVar;
            a(cVar.f64256d);
            a((TextUtils.isEmpty(cVar.f64254b) || !com.kwad.sdk.core.config.c.A()) ? cVar.f64253a : cVar.f64254b, (Map<String, String>) null);
        }
    }

    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, map) == null) {
            this.f65086c = str;
            this.f65084a.setDataSource(str, map);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f65090g = z;
            this.f65084a.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
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

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.m) {
                p();
                return true;
            }
            if (!l.contains(this)) {
                l.offer(this);
            }
            if (l.size() == 1) {
                p();
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "prepareAsync first");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "start");
            p();
            this.f65084a.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f65084a.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f65084a.getKwaiMediaPlayer().getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f65084a.getKwaiMediaPlayer().getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return this.f65084a.getCurrentPosition();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                return this.f65084a.getDuration();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean remove = l.remove(this);
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
            this.f65089f = true;
            this.f65084a.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener(this) { // from class: com.kwad.sdk.core.video.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f65093a;

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
                    this.f65093a = this;
                }

                public void onPlayerRelease() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
                    }
                }
            });
            o();
            a();
            r();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.j = false;
            try {
                this.f65084a.getKwaiMediaPlayer().reset();
            } catch (IllegalStateException unused) {
            }
            o();
            a();
            q();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
