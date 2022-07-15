package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
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
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public static final AtomicInteger c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a A;
    public String a;
    public volatile int d;
    public com.kwad.sdk.core.video.kwai.c e;
    public int f;
    public long g;
    public Runnable h;
    public Handler i;
    public Context j;
    public DetailVideoView k;
    public int l;
    public int m;
    public long n;
    public com.kwad.sdk.contentalliance.kwai.kwai.b o;
    public int p;
    public List<c.d> q;
    public final AtomicBoolean r;
    public boolean s;
    public volatile List<g> t;
    public volatile List<c.e> u;
    public c.e v;
    public c.h w;
    public c.b x;
    public c.InterfaceC0547c y;
    public c.d z;

    /* loaded from: classes5.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(127637514, "Lcom/kwad/components/core/video/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(127637514, "Lcom/kwad/components/core/video/b;");
                return;
            }
        }
        c = new AtomicInteger(0);
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailVideoView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "MediaPlayerImpl";
        this.d = 0;
        this.i = new Handler(Looper.getMainLooper());
        this.n = 0L;
        this.p = 0;
        this.q = new CopyOnWriteArrayList();
        this.r = new AtomicBoolean(false);
        this.s = false;
        this.t = new CopyOnWriteArrayList();
        this.u = new CopyOnWriteArrayList();
        this.v = new c.e(this) { // from class: com.kwad.components.core.video.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.a.a;
                    com.kwad.sdk.core.d.b.c(str, "onPrepared:" + b.b(this.a.d) + "->STATE_PREPARED");
                    this.a.d = 2;
                    b bVar = this.a;
                    bVar.a(bVar.d);
                    for (c.e eVar : this.a.u) {
                        eVar.a(this.a.e);
                    }
                }
            }
        };
        this.w = new c.h(this) { // from class: com.kwad.components.core.video.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    if (this.a.k != null) {
                        this.a.k.a(i3, i4);
                    }
                    String str = this.a.a;
                    com.kwad.sdk.core.d.b.c(str, "onVideoSizeChanged ——> width：" + i3 + "， height：" + i4);
                }
            }
        };
        this.x = new c.b(this) { // from class: com.kwad.components.core.video.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.d = 9;
                    b bVar = this.a;
                    bVar.a(bVar.d);
                    com.kwad.sdk.core.d.b.c(this.a.a, "onCompletion ——> STATE_COMPLETED");
                }
            }
        };
        this.y = new c.InterfaceC0547c(this) { // from class: com.kwad.components.core.video.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0547c
            public final boolean a(int i3, int i4) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i3, i4)) == null) {
                    if (i3 != -38) {
                        this.a.d = -1;
                        this.a.l = i3;
                        this.a.m = i4;
                        b bVar = this.a;
                        bVar.a(bVar.d);
                        String str = this.a.a;
                        com.kwad.sdk.core.d.b.c(str, "onError ——> STATE_ERROR ———— what：" + i3 + ", extra: " + i4);
                        return true;
                    }
                    return true;
                }
                return invokeII.booleanValue;
            }
        };
        this.z = new c.d(this) { // from class: com.kwad.components.core.video.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean a(int i3, int i4) {
                InterceptResult invokeII;
                String str;
                StringBuilder sb;
                String str2;
                String str3;
                String str4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i3, i4)) == null) {
                    if (i3 != 3) {
                        if (i3 == 701) {
                            if (this.a.d == 5 || this.a.d == 7) {
                                this.a.d = 7;
                                str3 = this.a.a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.a.d = 6;
                                str3 = this.a.a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.d.b.c(str3, str4);
                            b bVar = this.a;
                            bVar.a(bVar.d);
                        } else if (i3 == 702) {
                            if (this.a.d == 6) {
                                this.a.d = 4;
                                b bVar2 = this.a;
                                bVar2.a(bVar2.d);
                                com.kwad.sdk.core.d.b.c(this.a.a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.a.d == 7) {
                                this.a.d = 5;
                                b bVar3 = this.a;
                                bVar3.a(bVar3.d);
                                str = this.a.a;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.d.b.c(str, str2);
                            }
                        } else if (i3 != 10001) {
                            if (i3 == 801) {
                                str = this.a.a;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.d.b.c(str, str2);
                            } else {
                                str = this.a.a;
                                sb = new StringBuilder("onInfo ——> what：");
                                sb.append(i3);
                            }
                        }
                        b bVar4 = this.a;
                        bVar4.a(bVar4.e, i3, i4);
                        return true;
                    }
                    this.a.d = 4;
                    b bVar5 = this.a;
                    bVar5.a(bVar5.d);
                    str = this.a.a;
                    sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.a.n);
                    str2 = sb.toString();
                    com.kwad.sdk.core.d.b.c(str, str2);
                    b bVar42 = this.a;
                    bVar42.a(bVar42.e, i3, i4);
                    return true;
                }
                return invokeII.booleanValue;
            }
        };
        this.A = new c.a(this) { // from class: com.kwad.components.core.video.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.f = i3;
                }
            }
        };
        this.k = detailVideoView;
        if (detailVideoView != null) {
            this.j = detailVideoView.getContext().getApplicationContext();
        }
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            a((a) null, true);
        }
    }

    private void a(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65541, this, aVar, z) == null) || this.e == null) {
            return;
        }
        b(false);
        this.i.removeCallbacksAndMessages(null);
        r();
        m();
        this.k = null;
        com.kwad.sdk.core.video.kwai.c cVar = this.e;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.a(new Runnable(this, cVar, aVar) { // from class: com.kwad.components.core.video.b.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.sdk.core.video.kwai.c a;
                    public final /* synthetic */ a b;
                    public final /* synthetic */ b c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = cVar;
                        this.b = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b bVar = this.c;
                            b.a(this.a, this.b);
                        }
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.e = null;
        }
        String str = this.a;
        com.kwad.sdk.core.d.b.c(str, "release:" + b(this.d) + "->STATE_IDLE");
        this.d = 0;
        this.p = 0;
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{bVar, Boolean.valueOf(z), detailVideoView, cVar}) == null) {
            com.kwad.sdk.core.d.b.c(this.a, "initMediaPlayer");
            if (bVar == null || detailVideoView == null || cVar == null) {
                return;
            }
            if (this.j == null) {
                this.j = detailVideoView.getContext().getApplicationContext();
            }
            this.s = z;
            this.o = bVar;
            DetailVideoView detailVideoView2 = this.k;
            if (detailVideoView2 != detailVideoView) {
                com.kwad.sdk.core.d.b.c(this.a, "initMediaPlayer videoView changed");
                if (detailVideoView2 != null) {
                    detailVideoView2.setMediaPlayer(null);
                    detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                    detailVideoView2.setKeepScreenOn(false);
                }
                this.k = detailVideoView;
            }
            detailVideoView.setMediaPlayer(this);
            if (this.e != cVar) {
                com.kwad.sdk.core.d.b.c(this.a, "initMediaPlayer mediaPlayer changed");
                com.kwad.sdk.core.video.kwai.c cVar2 = this.e;
                if (cVar2 != null) {
                    cVar.a(cVar2.k());
                    m();
                    this.e.i();
                }
                this.e = cVar;
                o();
                l();
                cVar.b(3);
            } else {
                com.kwad.sdk.core.d.b.c(this.a, "initMediaPlayer mediaPlayer not changed");
                o();
                m();
                l();
            }
            this.e.a(detailVideoView.b);
        }
    }

    public static void a(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, cVar, aVar) == null) || cVar == null) {
            return;
        }
        try {
            cVar.i();
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            switch (i) {
                case -1:
                    return "STATE_ERROR";
                case 0:
                    return "STATE_IDLE";
                case 1:
                    return "STATE_PREPARING";
                case 2:
                    return "STATE_PREPARED";
                case 3:
                    return "STATE_STARTED";
                case 4:
                    return "STATE_PLAYING";
                case 5:
                    return "STATE_PAUSED";
                case 6:
                    return "STATE_BUFFERING_PLAYING";
                case 7:
                    return "STATE_BUFFERING_PAUSED";
                case 8:
                    return "PLAYER_STATE_STOPPED";
                case 9:
                    return "STATE_COMPLETED";
                default:
                    return "STATE_UNKNOWN";
            }
        }
        return (String) invokeI.objValue;
    }

    private void b(boolean z) {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65548, this, z) == null) || (detailVideoView = this.k) == null) {
            return;
        }
        detailVideoView.setKeepScreenOn(z);
    }

    private void c(int i) {
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65551, this, i) == null) || (bVar = this.o) == null || (videoPlayerStatus = bVar.d) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.e.a(this.v);
            this.e.a(this.w);
            this.e.a(this.x);
            this.e.a(this.y);
            this.e.a(this.z);
            this.e.a(this.A);
        }
    }

    private void m() {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (cVar = this.e) == null) {
            return;
        }
        cVar.a((c.InterfaceC0547c) null);
        this.e.a((c.b) null);
        this.e.a((c.e) null);
        this.e.a((c.h) null);
        this.e.a((c.d) null);
        this.e.a((c.f) null);
        this.e.a((c.a) null);
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.e == null) {
                com.kwad.sdk.core.d.b.d("resetAndPlay", "mMediaPlayer is null");
            } else if (this.d == 2 || this.d == 3 || this.d == 4 || this.d == 5) {
                com.kwad.sdk.core.d.b.d("resetAndPlay", "can not resetAndPlay in sate:" + this.d);
            } else {
                o();
                m();
                l();
                c();
            }
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.b.c(str, "reset:" + b(this.d) + "->STATE_IDLE");
            this.e.j();
            this.d = 0;
        }
    }

    private long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.e;
            if (cVar != null) {
                return cVar.h();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            r();
            if (this.h == null) {
                this.h = new Runnable(this) { // from class: com.kwad.components.core.video.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.s();
                            if (this.a.h != null) {
                                this.a.i.postDelayed(this.a.h, 500L);
                            }
                        }
                    }
                };
            }
            this.i.post(this.h);
        }
    }

    private void r() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (runnable = this.h) == null) {
            return;
        }
        this.i.removeCallbacks(runnable);
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            long j = j();
            long p = p();
            if (this.t != null) {
                for (g gVar : this.t) {
                    gVar.a(p, j);
                }
            }
        }
    }

    public final com.kwad.sdk.core.video.kwai.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (com.kwad.sdk.core.video.kwai.c) invokeV.objValue;
    }

    public final void a(float f, float f2) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (cVar = this.e) == null) {
            return;
        }
        cVar.a(f, f2);
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.t == null) {
            return;
        }
        for (g gVar : this.t) {
            if (gVar != null) {
                switch (i) {
                    case -1:
                        b(false);
                        r();
                        gVar.a(this.l, this.m);
                        continue;
                    case 1:
                        gVar.h();
                        continue;
                    case 2:
                        gVar.e();
                        continue;
                    case 3:
                        b(true);
                        gVar.c();
                        continue;
                    case 4:
                        b(true);
                        gVar.b();
                        continue;
                    case 5:
                        b(false);
                        gVar.a();
                        continue;
                    case 6:
                        gVar.g();
                        continue;
                    case 7:
                        gVar.f();
                        continue;
                    case 9:
                        try {
                            if (this.e != null && !this.e.k()) {
                                b(false);
                                r();
                            }
                            gVar.d();
                            continue;
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.b.b(e);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public final void a(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, surface) == null) || (cVar = this.e) == null) {
            return;
        }
        cVar.a(surface);
    }

    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.t.add(gVar);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.e;
            if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
                ((com.kwad.sdk.core.video.kwai.d) cVar).a(aVar);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            try {
                if (TextUtils.isEmpty(bVar.b)) {
                    com.kwad.sdk.core.d.b.e(this.a, "videoUrl is null");
                    return;
                }
                String str = this.a;
                com.kwad.sdk.core.d.b.e(str, "videoUrl=" + bVar.b);
                this.e.a(bVar);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bVar, detailVideoView) == null) {
            a(bVar, true, false, detailVideoView);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bVar, Boolean.valueOf(z), Boolean.valueOf(z2), detailVideoView}) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.b.c(str, "initMediaPlayer enablePreLoad:true");
            if (bVar == null || detailVideoView == null) {
                return;
            }
            com.kwad.sdk.core.video.kwai.c a2 = com.kwad.sdk.core.video.kwai.e.a(this.j, true, com.kwad.sdk.core.config.d.e(), com.kwad.sdk.core.config.d.p());
            a2.a(false);
            a(bVar, z2, detailVideoView, a2);
        }
    }

    public final void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.u.add(eVar);
        }
    }

    public final void a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, cVar, i, i2) == null) {
            Iterator<c.d> it = this.q.iterator();
            while (it.hasNext()) {
                c.d next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    next.a(i, i2);
                }
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            a(0.0f, 0.0f);
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.e;
            if (cVar != null) {
                return cVar.l();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.t.remove(gVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.s) {
                if (this.r.compareAndSet(false, true)) {
                    com.kwad.sdk.utils.g.a(new Runnable(this) { // from class: com.kwad.components.core.video.b.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONST_STR, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                        /* JADX WARN: Removed duplicated region for block: B:24:0x00cd A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #1 {Exception -> 0x00db, blocks: (B:22:0x00c6, B:23:0x00cc, B:24:0x00cd, B:25:0x00d6), top: B:39:0x00c6 }] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void run() {
                            boolean d;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String str = this.a.a;
                                com.kwad.sdk.core.d.b.c(str, "prepareAsync now:" + b.b(this.a.d));
                                if (this.a.e == null) {
                                    return;
                                }
                                try {
                                    try {
                                        synchronized (this.a.e) {
                                            this.a.a(this.a.o);
                                            d = this.a.e.d();
                                            String str2 = this.a.a;
                                            com.kwad.sdk.core.d.b.c(str2, "prepareAsync:" + b.b(this.a.d) + "->STATE_PREPARING, success: " + d);
                                            this.a.d = 1;
                                        }
                                        if (d) {
                                            this.a.i.post(new Runnable(this) { // from class: com.kwad.components.core.video.b.8.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass8 a;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i = newInitContext.flag;
                                                        if ((i & 1) != 0) {
                                                            int i2 = i & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.a = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        b bVar = this.a.a;
                                                        bVar.a(bVar.d);
                                                    }
                                                }
                                            });
                                        } else {
                                            com.kwad.sdk.core.d.b.e(this.a.a, "prepareAsync failed");
                                        }
                                    } finally {
                                        try {
                                            synchronized (this.a.r) {
                                            }
                                        } finally {
                                        }
                                    }
                                    synchronized (this.a.r) {
                                        this.a.r.notifyAll();
                                    }
                                } catch (Exception e) {
                                    com.kwad.sdk.core.d.b.a(e);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
            try {
                a(this.o);
                if (!this.e.d()) {
                    com.kwad.sdk.core.d.b.e(this.a, "prepareAsync failed");
                    return;
                }
                String str = this.a;
                com.kwad.sdk.core.d.b.c(str, "prepareAsync:" + b(this.d) + "->STATE_PREPARING");
                this.d = 1;
                a(this.d);
            } catch (Throwable th) {
                if (b() != 2) {
                    int i = this.p;
                    this.p = i + 1;
                    if (i <= 4) {
                        n();
                    }
                }
                String str2 = this.a;
                com.kwad.sdk.core.d.b.c(str2, "prepareAsync Exception:" + b(this.d));
                com.kwad.sdk.core.d.b.a(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        if (r7.d == 9) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.b.c(str, "start mCurrentState: " + b(this.d));
            if (this.d == 0) {
                com.kwad.sdk.core.d.b.c(this.a, "start, still not prepared well, prepare again");
                c();
                if (b() == 2) {
                    if (this.s && this.r.get()) {
                        com.kwad.sdk.utils.g.a(new Runnable(this) { // from class: com.kwad.components.core.video.b.9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (this.a.r.get()) {
                                        try {
                                            synchronized (this.a.r) {
                                                this.a.r.wait(5000L);
                                            }
                                        } catch (InterruptedException e) {
                                            com.kwad.sdk.core.d.b.a(e);
                                        }
                                    }
                                    if (this.a.b() == 2) {
                                        this.a.e.e();
                                    }
                                }
                            }
                        });
                    } else {
                        this.e.e();
                    }
                }
            } else if (this.d == 2 || this.d == 9) {
                this.n = System.currentTimeMillis();
                this.e.e();
                long j = this.g;
                if (j != 0) {
                    this.e.a((int) j);
                }
                String str2 = this.a;
                com.kwad.sdk.core.d.b.c(str2, "start:" + b(this.d) + "->STATE_STARTED");
                com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.o;
                if (bVar != null && bVar.d != null) {
                    if (this.d == 2) {
                        if (this.o.d.mVideoPlayerType == 0) {
                            c(1);
                        }
                        c(3);
                    }
                }
                this.d = 3;
                a(this.d);
                q();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.e == null) {
                com.kwad.sdk.core.d.b.e(this.a, "resume but mMediaPlayer is null");
                return;
            }
            String str = this.a;
            com.kwad.sdk.core.d.b.c(str, "resume mCurrentState: " + b(this.d));
            if (this.d == 2 || this.d == 0) {
                String str2 = this.a;
                com.kwad.sdk.core.d.b.c(str2, "resume:" + b(this.d) + "->start()");
                d();
            } else if (this.d == 5) {
                this.e.e();
                String str3 = this.a;
                com.kwad.sdk.core.d.b.c(str3, "resume:" + b(this.d) + "->STATE_PLAYING");
                this.d = 4;
                a(this.d);
                c(2);
            } else if (this.d != 7) {
                String str4 = this.a;
                com.kwad.sdk.core.d.b.e(str4, "resume: " + b(this.d) + " 此时不能调用resume()方法.");
            } else {
                this.e.e();
                String str5 = this.a;
                com.kwad.sdk.core.d.b.c(str5, "resume:" + b(this.d) + "->STATE_BUFFERING_PLAYING");
                this.d = 6;
                a(this.d);
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.b.c(str, "pause mCurrentState: " + b(this.d));
            if (this.d == 4) {
                this.e.f();
                com.kwad.sdk.core.d.b.c(this.a, "pause STATE_PLAYING->STATE_PAUSED");
                this.d = 5;
                a(this.d);
                z = true;
            } else {
                z = false;
            }
            if (this.d == 6) {
                this.e.f();
                com.kwad.sdk.core.d.b.c(this.a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.d = 7;
                a(this.d);
                z = true;
            }
            if (this.d == 3) {
                this.e.f();
                com.kwad.sdk.core.d.b.c(this.a, "pause STATE_STARTED->STATE_PAUSED");
                this.d = 5;
                a(this.d);
                z = true;
            }
            if (this.d == 9 && this.e.k()) {
                this.e.f();
                String str2 = this.a;
                com.kwad.sdk.core.d.b.c(str2, "pause " + b(this.d) + "->STATE_PAUSED");
                this.d = 5;
                a(this.d);
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            a((a) null);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            a((a) null, false);
        }
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.e;
            if (cVar != null) {
                return cVar.g();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.e;
            if (cVar != null) {
                return cVar.g();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.t.clear();
        }
    }
}
