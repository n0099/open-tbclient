package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34947a;

    /* renamed from: b  reason: collision with root package name */
    public int f34948b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f34949c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f34950d;

    /* renamed from: e  reason: collision with root package name */
    public int f34951e;

    /* renamed from: f  reason: collision with root package name */
    public long f34952f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f34953g;

    /* renamed from: h  reason: collision with root package name */
    public TimerTask f34954h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f34955i;
    public DetailVideoView j;
    public WeakReference<DetailVideoView> k;
    public int l;
    public int m;
    public long n;
    public d o;
    public int p;
    public List<c.d> q;
    public volatile List<c.e> r;
    public c.e s;
    public c.h t;
    public c.b u;
    public c.InterfaceC0438c v;
    public c.d w;
    public c.a x;
    public volatile List<e> y;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0411a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f34965a;

        public C0411a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34965a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f34965a.get()) == null) {
                return;
            }
            aVar.u();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f34966a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34966a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f34966a.get()) == null) {
                return;
            }
            long o = aVar.o();
            long n = aVar.n();
            for (e eVar : aVar.y) {
                eVar.a(n, o);
            }
        }
    }

    public a(DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34947a = "MediaPlayerImpl";
        this.f34948b = 0;
        this.f34955i = new Handler(Looper.getMainLooper());
        this.n = 0L;
        this.p = 0;
        this.q = new CopyOnWriteArrayList();
        this.r = new CopyOnWriteArrayList();
        this.s = new c.e(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34956a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34956a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.f34956a.f34947a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPrepared:");
                    a aVar = this.f34956a;
                    sb.append(aVar.b(aVar.f34948b));
                    sb.append("->STATE_PREPARED");
                    com.kwad.sdk.core.d.a.b(str, sb.toString());
                    this.f34956a.f34948b = 2;
                    a aVar2 = this.f34956a;
                    aVar2.a(aVar2.f34948b);
                    for (c.e eVar : this.f34956a.r) {
                        eVar.a(this.f34956a.f34949c);
                    }
                }
            }
        };
        this.t = new c.h(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34957a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34957a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    DetailVideoView detailVideoView2 = (DetailVideoView) this.f34957a.k.get();
                    if (detailVideoView2 != null) {
                        detailVideoView2.a(i4, i5);
                    }
                    String str = this.f34957a.f34947a;
                    com.kwad.sdk.core.d.a.b(str, "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                }
            }
        };
        this.u = new c.b(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34958a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34958a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f34958a.f34948b = 9;
                    a aVar = this.f34958a;
                    aVar.a(aVar.f34948b);
                    com.kwad.sdk.core.d.a.b(this.f34958a.f34947a, "onCompletion ——> STATE_COMPLETED");
                    DetailVideoView detailVideoView2 = (DetailVideoView) this.f34958a.k.get();
                    if (detailVideoView2 != null) {
                        detailVideoView2.setKeepScreenOn(true);
                    }
                }
            }
        };
        this.v = new c.InterfaceC0438c(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34959a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34959a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0438c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.f34959a.f34948b = -1;
                        this.f34959a.l = i4;
                        this.f34959a.m = i5;
                        a aVar = this.f34959a;
                        aVar.a(aVar.f34948b);
                        String str = this.f34959a.f34947a;
                        com.kwad.sdk.core.d.a.b(str, "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.w = new c.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34960a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34960a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.d
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                String str;
                StringBuilder sb;
                String str2;
                String str3;
                String str4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != 3) {
                        if (i4 == 701) {
                            if (this.f34960a.f34948b == 5 || this.f34960a.f34948b == 7) {
                                this.f34960a.f34948b = 7;
                                str3 = this.f34960a.f34947a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.f34960a.f34948b = 6;
                                str3 = this.f34960a.f34947a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.d.a.b(str3, str4);
                            a aVar = this.f34960a;
                            aVar.a(aVar.f34948b);
                        } else if (i4 == 702) {
                            if (this.f34960a.f34948b == 6) {
                                this.f34960a.f34948b = 4;
                                a aVar2 = this.f34960a;
                                aVar2.a(aVar2.f34948b);
                                com.kwad.sdk.core.d.a.b(this.f34960a.f34947a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.f34960a.f34948b == 7) {
                                this.f34960a.f34948b = 5;
                                a aVar3 = this.f34960a;
                                aVar3.a(aVar3.f34948b);
                                str = this.f34960a.f34947a;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.d.a.b(str, str2);
                            }
                        } else if (i4 != 10001) {
                            if (i4 == 801) {
                                str = this.f34960a.f34947a;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.d.a.b(str, str2);
                            } else {
                                str = this.f34960a.f34947a;
                                sb = new StringBuilder();
                                sb.append("onInfo ——> what：");
                                sb.append(i4);
                            }
                        }
                        a aVar4 = this.f34960a;
                        aVar4.a(aVar4.f34949c, i4, i5);
                        return true;
                    }
                    this.f34960a.f34948b = 4;
                    a aVar5 = this.f34960a;
                    aVar5.a(aVar5.f34948b);
                    str = this.f34960a.f34947a;
                    sb = new StringBuilder();
                    sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.f34960a.n);
                    str2 = sb.toString();
                    com.kwad.sdk.core.d.a.b(str, str2);
                    a aVar42 = this.f34960a;
                    aVar42.a(aVar42.f34949c, i4, i5);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.x = new c.a(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34961a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34961a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.f34961a.f34951e = i4;
                }
            }
        };
        this.y = new CopyOnWriteArrayList();
        this.j = detailVideoView;
        this.k = new WeakReference<>(detailVideoView);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: com.kwad.sdk.core.video.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.a.c a(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        com.kwad.sdk.core.video.a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            try {
                if (com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.p() && com.kwad.sdk.core.video.a.e.a()) {
                    com.kwad.sdk.core.d.a.b("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                    com.kwad.sdk.core.video.a.d dVar = new com.kwad.sdk.core.video.a.d(context);
                    dVar.b(z);
                    bVar = dVar;
                } else {
                    com.kwad.sdk.core.d.a.b("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                    bVar = new com.kwad.sdk.core.video.a.b();
                }
                return bVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
                return new com.kwad.sdk.core.video.a.b();
            }
        }
        return (com.kwad.sdk.core.video.a.c) invokeLZ.objValue;
    }

    private void c(int i2) {
        d dVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i2) == null) || (dVar = this.o) == null || (videoPlayerStatus = dVar.f34984b) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void q() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (cVar = this.f34949c) == null) {
            return;
        }
        cVar.a((c.InterfaceC0438c) null);
        this.f34949c.a((c.b) null);
        this.f34949c.a((c.e) null);
        this.f34949c.a((c.d) null);
        this.f34949c.a((c.f) null);
        this.f34949c.a((c.a) null);
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            String str = this.f34947a;
            com.kwad.sdk.core.d.a.b(str, "reset:" + b(this.f34948b) + "->STATE_IDLE");
            this.f34949c.n();
            this.f34948b = 0;
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            t();
            if (this.f34953g == null) {
                this.f34953g = new Timer();
            }
            if (this.f34954h == null) {
                C0411a c0411a = new C0411a(this);
                this.f34954h = c0411a;
                this.f34953g.schedule(c0411a, 0L, 1000L);
            }
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            Timer timer = this.f34953g;
            if (timer != null) {
                timer.cancel();
                this.f34953g = null;
            }
            TimerTask timerTask = this.f34954h;
            if (timerTask != null) {
                timerTask.cancel();
                this.f34954h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f34955i.post(new c(this));
        }
    }

    public com.kwad.sdk.core.video.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34949c : (com.kwad.sdk.core.video.a.c) invokeV.objValue;
    }

    public void a(float f2) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || (cVar = this.f34949c) == null) {
            return;
        }
        cVar.a(f2);
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (cVar = this.f34949c) == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.y == null) {
            return;
        }
        for (e eVar : this.y) {
            if (eVar != null) {
                switch (i2) {
                    case -1:
                        t();
                        eVar.a(this.l, this.m);
                        continue;
                    case 1:
                        eVar.e();
                        continue;
                    case 2:
                        eVar.h();
                        continue;
                    case 3:
                        eVar.b();
                        continue;
                    case 4:
                        eVar.d();
                        continue;
                    case 5:
                        eVar.c();
                        continue;
                    case 6:
                        eVar.g();
                        continue;
                    case 7:
                        eVar.f();
                        continue;
                    case 9:
                        t();
                        eVar.a();
                        continue;
                }
            }
        }
    }

    public void a(long j) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || (cVar = this.f34949c) == null) {
            return;
        }
        cVar.a(j);
    }

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, surface) == null) {
            this.f34950d = surface;
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                cVar.a(surface);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || this.f34949c == null) {
            return;
        }
        this.j.setKeepScreenOn(false);
        this.f34955i.removeCallbacksAndMessages(null);
        t();
        q();
        com.kwad.sdk.core.video.a.c cVar = this.f34949c;
        if (cVar != null) {
            com.kwad.sdk.utils.f.a(new Runnable(this, cVar, bVar) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.a.c f34962a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f34963b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f34964c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34964c = this;
                    this.f34962a = cVar;
                    this.f34963b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f34962a.m();
                            if (this.f34963b != null) {
                                this.f34963b.a();
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.a(th);
                        }
                    }
                }
            });
            this.f34949c = null;
        }
        String str = this.f34947a;
        com.kwad.sdk.core.d.a.b(str, "release:" + b(this.f34948b) + "->STATE_IDLE");
        this.f34948b = 0;
        this.p = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            com.kwad.sdk.core.video.a.c cVar2 = this.f34949c;
            if (cVar2 instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar2).a(cVar);
            }
        }
    }

    public void a(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            com.kwad.sdk.core.d.a.b(this.f34947a, "initMediaPlayer");
            this.o = dVar;
            DetailVideoView detailVideoView = this.j;
            this.f34950d = detailVideoView.f34938b;
            detailVideoView.setMediaPlayer(this);
            this.f34949c = a(this.j.getContext(), true);
            b(dVar);
            this.f34949c.a(false);
            this.f34949c.a(this.f34950d);
            this.f34949c.b(3);
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar).a(this.j);
            }
            c();
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.y.add(eVar);
        }
    }

    public void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) || dVar == null) {
            return;
        }
        this.q.add(dVar);
    }

    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.r.add(eVar);
        }
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, cVar, i2, i3) == null) {
            Iterator<c.d> it = this.q.iterator();
            while (it.hasNext()) {
                c.d next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    next.a(cVar, i2, i3);
                }
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34949c.o() : invokeV.intValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            switch (i2) {
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

    public void b(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            try {
                if (TextUtils.isEmpty(dVar.f34983a)) {
                    com.kwad.sdk.core.d.a.d(this.f34947a, "videoUrl is null");
                } else {
                    this.f34949c.a(dVar);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.y.remove(eVar);
        }
    }

    public void b(c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) || dVar == null) {
            return;
        }
        this.q.remove(dVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f34949c.a(this.s);
            this.f34949c.a(this.t);
            this.f34949c.a(this.u);
            this.f34949c.a(this.v);
            this.f34949c.a(this.w);
            this.f34949c.a(this.x);
        }
    }

    public void c(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            if (this.f34949c == null) {
                com.kwad.sdk.core.d.a.c("resetAndPlay", "mMediaPlayer is null");
                return;
            }
            int i2 = this.f34948b;
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                com.kwad.sdk.core.d.a.c("resetAndPlay", "can not resetAndPlay in sate:" + this.f34948b);
                return;
            }
            r();
            b(dVar);
            q();
            c();
            e();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f34948b == 1 : invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j.setKeepScreenOn(true);
            try {
                if (this.f34949c.e()) {
                    String str = this.f34947a;
                    com.kwad.sdk.core.d.a.b(str, "prepareAsync:" + b(this.f34948b) + "->STATE_PREPARING");
                    this.f34948b = 1;
                    a(1);
                }
            } catch (Exception e2) {
                String str2 = this.f34947a;
                com.kwad.sdk.core.d.a.b(str2, "prepareAsync Exception:" + b(this.f34948b));
                com.kwad.sdk.core.d.a.a(e2);
                if (b() != 2) {
                    int i2 = this.p;
                    this.p = i2 + 1;
                    if (i2 <= 4) {
                        c(this.o);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        if (r4 == 9) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int i2 = this.f34948b;
            if (i2 == 0) {
                com.kwad.sdk.core.d.a.b(this.f34947a, "start, still not prepared well, prepare again");
                e();
                if (b() == 2) {
                    this.f34949c.f();
                }
            } else if (i2 == 2 || i2 == 9) {
                this.n = System.currentTimeMillis();
                this.f34949c.f();
                long j = this.f34952f;
                if (j != 0) {
                    this.f34949c.a((int) j);
                }
                String str = this.f34947a;
                com.kwad.sdk.core.d.a.b(str, "start:" + b(this.f34948b) + "->STATE_STARTED");
                d dVar = this.o;
                if (dVar != null && (videoPlayerStatus = dVar.f34984b) != null) {
                    int i3 = this.f34948b;
                    if (i3 == 2) {
                        if (videoPlayerStatus.mVideoPlayerType == 0) {
                            c(1);
                        }
                        c(3);
                    }
                }
                this.f34948b = 3;
                a(3);
                s();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f34949c != null && this.f34948b == 9) {
                f();
            }
            c(3);
        }
    }

    public void h() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f34949c) == null) {
            return;
        }
        int i2 = this.f34948b;
        if (i2 == 2 || i2 == 0) {
            String str = this.f34947a;
            com.kwad.sdk.core.d.a.b(str, "resume:" + b(this.f34948b) + "->start()");
            f();
        } else if (i2 == 5) {
            cVar.f();
            String str2 = this.f34947a;
            com.kwad.sdk.core.d.a.b(str2, "resume:" + b(this.f34948b) + "->STATE_PLAYING");
            this.f34948b = 4;
            a(4);
            c(2);
        } else if (i2 == 7) {
            cVar.f();
            String str3 = this.f34947a;
            com.kwad.sdk.core.d.a.b(str3, "resume:" + b(this.f34948b) + "->STATE_BUFFERING_PLAYING");
            this.f34948b = 6;
            a(6);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                return cVar.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.f34948b == 4) {
                this.f34949c.g();
                com.kwad.sdk.core.d.a.b(this.f34947a, "pause STATE_PLAYING->STATE_PAUSED");
                this.f34948b = 5;
                a(5);
            }
            if (this.f34948b == 6) {
                this.f34949c.g();
                com.kwad.sdk.core.d.a.b(this.f34947a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.f34948b = 7;
                a(7);
            }
            if (this.f34948b == 3) {
                this.f34949c.g();
                com.kwad.sdk.core.d.a.b(this.f34947a, "pause STATE_STARTED->STATE_PAUSED");
                this.f34948b = 5;
                a(5);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            a((b) null);
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                return cVar.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                return cVar.i();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                return cVar.l();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f34949c;
            if (cVar != null) {
                return cVar.k();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.y.clear();
        }
    }
}
