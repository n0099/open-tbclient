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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f65140c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65141d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f65142e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.InterfaceC1951c A;
    public c.d B;
    public c.a C;
    public volatile List<d> D;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65143a;

    /* renamed from: b  reason: collision with root package name */
    public String f65144b;

    /* renamed from: f  reason: collision with root package name */
    public int f65145f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f65146g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f65147h;

    /* renamed from: i  reason: collision with root package name */
    public int f65148i;
    public long j;
    public Timer k;
    public TimerTask l;
    public Handler m;
    public DetailVideoView n;
    public WeakReference<DetailVideoView> o;
    public int p;
    public int q;
    public long r;
    public com.kwad.sdk.contentalliance.detail.video.c s;
    public int t;
    public List<c.d> u;
    public AtomicBoolean v;
    public volatile List<c.e> w;
    public c.e x;
    public c.h y;
    public c.b z;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1936a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f65160a;

        public C1936a(a aVar) {
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
            this.f65160a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f65160a.get()) == null) {
                return;
            }
            aVar.r();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f65161a;

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
            this.f65161a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f65161a.get()) == null) {
                return;
            }
            long l = aVar.l();
            long k = aVar.k();
            for (d dVar : aVar.D) {
                dVar.a(k, l);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1917257870, "Lcom/kwad/sdk/contentalliance/detail/video/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1917257870, "Lcom/kwad/sdk/contentalliance/detail/video/a;");
                return;
            }
        }
        f65142e = new AtomicInteger(0);
    }

    public a(DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailVideoView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65144b = "MediaPlayerImpl";
        this.f65145f = 0;
        this.m = new Handler(Looper.getMainLooper());
        this.r = 0L;
        this.t = 0;
        this.u = new CopyOnWriteArrayList();
        this.v = new AtomicBoolean(false);
        this.f65143a = false;
        this.w = new CopyOnWriteArrayList();
        this.x = new c.e(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65149a;

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
                this.f65149a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.f65149a.f65144b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPrepared:");
                    a aVar = this.f65149a;
                    sb.append(aVar.b(aVar.f65145f));
                    sb.append("->STATE_PREPARED");
                    com.kwad.sdk.core.d.a.c(str, sb.toString());
                    this.f65149a.f65145f = 2;
                    a aVar2 = this.f65149a;
                    aVar2.a(aVar2.f65145f);
                    for (c.e eVar : this.f65149a.w) {
                        eVar.a(this.f65149a.f65146g);
                    }
                }
            }
        };
        this.y = new c.h(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65150a;

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
                this.f65150a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    DetailVideoView detailVideoView2 = (DetailVideoView) this.f65150a.o.get();
                    if (detailVideoView2 != null) {
                        detailVideoView2.a(i4, i5);
                    }
                    String str = this.f65150a.f65144b;
                    com.kwad.sdk.core.d.a.c(str, "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                }
            }
        };
        this.z = new c.b(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65151a;

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
                this.f65151a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f65151a.f65145f = 9;
                    a aVar = this.f65151a;
                    aVar.a(aVar.f65145f);
                    com.kwad.sdk.core.d.a.c(this.f65151a.f65144b, "onCompletion ——> STATE_COMPLETED");
                }
            }
        };
        this.A = new c.InterfaceC1951c(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65152a;

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
                this.f65152a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC1951c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.f65152a.f65145f = -1;
                        this.f65152a.p = i4;
                        this.f65152a.q = i5;
                        a aVar = this.f65152a;
                        aVar.a(aVar.f65145f);
                        String str = this.f65152a.f65144b;
                        com.kwad.sdk.core.d.a.c(str, "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.B = new c.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65153a;

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
                this.f65153a = this;
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
                            if (this.f65153a.f65145f == 5 || this.f65153a.f65145f == 7) {
                                this.f65153a.f65145f = 7;
                                str3 = this.f65153a.f65144b;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.f65153a.f65145f = 6;
                                str3 = this.f65153a.f65144b;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.d.a.c(str3, str4);
                            a aVar = this.f65153a;
                            aVar.a(aVar.f65145f);
                        } else if (i4 == 702) {
                            if (this.f65153a.f65145f == 6) {
                                this.f65153a.f65145f = 4;
                                a aVar2 = this.f65153a;
                                aVar2.a(aVar2.f65145f);
                                com.kwad.sdk.core.d.a.c(this.f65153a.f65144b, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.f65153a.f65145f == 7) {
                                this.f65153a.f65145f = 5;
                                a aVar3 = this.f65153a;
                                aVar3.a(aVar3.f65145f);
                                str = this.f65153a.f65144b;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            }
                        } else if (i4 != 10001) {
                            if (i4 == 801) {
                                str = this.f65153a.f65144b;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            } else {
                                str = this.f65153a.f65144b;
                                sb = new StringBuilder();
                                sb.append("onInfo ——> what：");
                                sb.append(i4);
                            }
                        }
                        a aVar4 = this.f65153a;
                        aVar4.a(aVar4.f65146g, i4, i5);
                        return true;
                    }
                    this.f65153a.f65145f = 4;
                    a aVar5 = this.f65153a;
                    aVar5.a(aVar5.f65145f);
                    str = this.f65153a.f65144b;
                    sb = new StringBuilder();
                    sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.f65153a.r);
                    str2 = sb.toString();
                    com.kwad.sdk.core.d.a.c(str, str2);
                    a aVar42 = this.f65153a;
                    aVar42.a(aVar42.f65146g, i4, i5);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.C = new c.a(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65154a;

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
                this.f65154a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.f65154a.f65148i = i4;
                }
            }
        };
        this.D = new CopyOnWriteArrayList();
        this.n = detailVideoView;
        this.o = new WeakReference<>(detailVideoView);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.kwad.sdk.core.video.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.a.c a(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        com.kwad.sdk.core.video.a.b bVar;
        com.kwad.sdk.core.video.a.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            try {
                if (com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.k() && com.kwad.sdk.core.video.a.e.a()) {
                    com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                    com.kwad.sdk.core.video.a.d dVar = new com.kwad.sdk.core.video.a.d(context);
                    dVar.b(z);
                    bVar2 = dVar;
                } else {
                    com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                    bVar2 = new com.kwad.sdk.core.video.a.b();
                }
                z2 = false;
                bVar = bVar2;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
                if (!f65141d) {
                    f65141d = true;
                    com.kwad.sdk.crash.a.a(th);
                }
                z2 = true;
                bVar = new com.kwad.sdk.core.video.a.b();
            }
            int a2 = ae.a(com.kwad.sdk.core.video.a.e.b(), KsAdSDKImpl.get().getIsExternal(), com.kwad.sdk.core.config.c.k(), com.kwad.sdk.core.video.a.e.a(), z2, com.kwad.sdk.core.config.c.F(), bVar.n());
            com.kwad.sdk.core.d.a.a("player v=" + Integer.toBinaryString(a2));
            if (f65140c != a2) {
                f65140c = a2;
                com.kwad.sdk.core.report.d.c(a2);
            }
            return bVar;
        }
        return (com.kwad.sdk.core.video.a.c) invokeLZ.objValue;
    }

    private void a(boolean z) {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) || (detailVideoView = this.n) == null) {
            return;
        }
        detailVideoView.setKeepScreenOn(z);
    }

    private void c(int i2) {
        com.kwad.sdk.contentalliance.detail.video.c cVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i2) == null) || (cVar = this.s) == null || (videoPlayerStatus = cVar.f65168c) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void n() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (cVar = this.f65146g) == null) {
            return;
        }
        cVar.a((c.InterfaceC1951c) null);
        this.f65146g.a((c.b) null);
        this.f65146g.a((c.e) null);
        this.f65146g.a((c.d) null);
        this.f65146g.a((c.f) null);
        this.f65146g.a((c.a) null);
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            String str = this.f65144b;
            com.kwad.sdk.core.d.a.c(str, "reset:" + b(this.f65145f) + "->STATE_IDLE");
            this.f65146g.m();
            this.f65145f = 0;
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            q();
            if (this.k == null) {
                this.k = new Timer("ksad-DetailPlayer-timer" + f65142e.getAndIncrement());
            }
            if (this.l == null) {
                C1936a c1936a = new C1936a(this);
                this.l = c1936a;
                this.k.schedule(c1936a, 0L, 500L);
            }
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            Timer timer = this.k;
            if (timer != null) {
                timer.cancel();
                this.k = null;
            }
            TimerTask timerTask = this.l;
            if (timerTask != null) {
                timerTask.cancel();
                this.l = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.m.post(new c(this));
        }
    }

    public com.kwad.sdk.core.video.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65146g : (com.kwad.sdk.core.video.a.c) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (cVar = this.f65146g) == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.D == null) {
            return;
        }
        for (d dVar : this.D) {
            if (dVar != null) {
                switch (i2) {
                    case -1:
                        a(false);
                        q();
                        dVar.a(this.p, this.q);
                        continue;
                    case 1:
                        dVar.a();
                        continue;
                    case 2:
                        dVar.b();
                        continue;
                    case 3:
                        a(true);
                        dVar.c();
                        continue;
                    case 4:
                        a(true);
                        dVar.d();
                        continue;
                    case 5:
                        a(false);
                        dVar.e();
                        continue;
                    case 6:
                        dVar.g();
                        continue;
                    case 7:
                        dVar.h();
                        continue;
                    case 9:
                        a(false);
                        q();
                        dVar.f();
                        continue;
                }
            }
        }
    }

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.f65147h = surface;
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                cVar.a(surface);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f65146g == null) {
            return;
        }
        a(false);
        this.m.removeCallbacksAndMessages(null);
        q();
        n();
        com.kwad.sdk.core.video.a.c cVar = this.f65146g;
        if (cVar != null) {
            g.a(new Runnable(this, cVar, bVar) { // from class: com.kwad.sdk.contentalliance.detail.video.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.a.c f65157a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f65158b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f65159c;

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
                    this.f65159c = this;
                    this.f65157a = cVar;
                    this.f65158b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f65157a.l();
                            if (this.f65158b != null) {
                                this.f65158b.a();
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.a(th);
                        }
                    }
                }
            });
            this.f65146g = null;
        }
        String str = this.f65144b;
        com.kwad.sdk.core.d.a.c(str, "release:" + b(this.f65145f) + "->STATE_IDLE");
        this.f65145f = 0;
        this.t = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar).a(bVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            a(cVar, true, false);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String str = this.f65144b;
            com.kwad.sdk.core.d.a.c(str, "initMediaPlayer enablePreLoad:" + z);
            this.f65143a = z2;
            this.s = cVar;
            DetailVideoView detailVideoView = this.n;
            this.f65147h = detailVideoView.f65131b;
            detailVideoView.setMediaPlayer(this);
            com.kwad.sdk.core.video.a.c a2 = a(this.n.getContext(), z);
            this.f65146g = a2;
            a2.a(false);
            this.f65146g.a(this.f65147h);
            this.f65146g.b(3);
            com.kwad.sdk.core.video.a.c cVar2 = this.f65146g;
            if (cVar2 instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar2).a(this.n);
            }
            c();
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.D.add(dVar);
        }
    }

    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.w.add(eVar);
        }
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, cVar, i2, i3) == null) {
            Iterator<c.d> it = this.u.iterator();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                return cVar.n();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
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

    public void b(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            try {
                if (TextUtils.isEmpty(cVar.f65166a)) {
                    com.kwad.sdk.core.d.a.e(this.f65144b, "videoUrl is null");
                    return;
                }
                String str = this.f65144b;
                com.kwad.sdk.core.d.a.e(str, "videoUrl=" + cVar.f65166a);
                this.f65146g.a(cVar);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.D.remove(dVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f65146g.a(this.x);
            this.f65146g.a(this.y);
            this.f65146g.a(this.z);
            this.f65146g.a(this.A);
            this.f65146g.a(this.B);
            this.f65146g.a(this.C);
        }
    }

    public void c(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            if (this.f65146g == null) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "mMediaPlayer is null");
                return;
            }
            int i2 = this.f65145f;
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "can not resetAndPlay in sate:" + this.f65145f);
                return;
            }
            o();
            n();
            c();
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f65143a) {
                if (this.v.get()) {
                    return;
                }
                this.v.set(true);
                g.a(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65155a;

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
                        this.f65155a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean e2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65155a.f65146g == null) {
                            return;
                        }
                        try {
                            synchronized (this.f65155a.f65146g) {
                                this.f65155a.b(this.f65155a.s);
                                e2 = this.f65155a.f65146g.e();
                                String str = this.f65155a.f65144b;
                                com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + this.f65155a.b(this.f65155a.f65145f) + "->STATE_PREPARING");
                                this.f65155a.f65145f = 1;
                            }
                            if (e2) {
                                this.f65155a.m.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass7 f65156a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f65156a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            a aVar = this.f65156a.f65155a;
                                            aVar.a(aVar.f65145f);
                                        }
                                    }
                                });
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                });
                return;
            }
            try {
                b(this.s);
                if (this.f65146g.e()) {
                    String str = this.f65144b;
                    com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + b(this.f65145f) + "->STATE_PREPARING");
                    this.f65145f = 1;
                    a(1);
                }
            } catch (Throwable th) {
                String str2 = this.f65144b;
                com.kwad.sdk.core.d.a.c(str2, "prepareAsync Exception:" + b(this.f65145f));
                com.kwad.sdk.core.d.a.a(th);
                if (b() != 2) {
                    int i2 = this.t;
                    this.t = i2 + 1;
                    if (i2 <= 4) {
                        c(this.s);
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
    public void e() {
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            int i2 = this.f65145f;
            if (i2 == 0) {
                com.kwad.sdk.core.d.a.c(this.f65144b, "start, still not prepared well, prepare again");
                d();
                if (b() == 2) {
                    this.f65146g.f();
                }
            } else if (i2 == 2 || i2 == 9) {
                this.r = System.currentTimeMillis();
                this.f65146g.f();
                long j = this.j;
                if (j != 0) {
                    this.f65146g.a((int) j);
                }
                String str = this.f65144b;
                com.kwad.sdk.core.d.a.c(str, "start:" + b(this.f65145f) + "->STATE_STARTED");
                com.kwad.sdk.contentalliance.detail.video.c cVar = this.s;
                if (cVar != null && (videoPlayerStatus = cVar.f65168c) != null) {
                    int i3 = this.f65145f;
                    if (i3 == 2) {
                        if (videoPlayerStatus.mVideoPlayerType == 0) {
                            c(1);
                        }
                        c(3);
                    }
                }
                this.f65145f = 3;
                a(3);
                p();
            }
        }
    }

    public void f() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f65146g) == null) {
            return;
        }
        int i2 = this.f65145f;
        if (i2 == 2 || i2 == 0) {
            String str = this.f65144b;
            com.kwad.sdk.core.d.a.c(str, "resume:" + b(this.f65145f) + "->start()");
            e();
        } else if (i2 == 5) {
            cVar.f();
            String str2 = this.f65144b;
            com.kwad.sdk.core.d.a.c(str2, "resume:" + b(this.f65145f) + "->STATE_PLAYING");
            this.f65145f = 4;
            a(4);
            c(2);
        } else if (i2 == 7) {
            cVar.f();
            String str3 = this.f65144b;
            com.kwad.sdk.core.d.a.c(str3, "resume:" + b(this.f65145f) + "->STATE_BUFFERING_PLAYING");
            this.f65145f = 6;
            a(6);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.f65145f == 4) {
                this.f65146g.g();
                com.kwad.sdk.core.d.a.c(this.f65144b, "pause STATE_PLAYING->STATE_PAUSED");
                this.f65145f = 5;
                a(5);
            }
            if (this.f65145f == 6) {
                this.f65146g.g();
                com.kwad.sdk.core.d.a.c(this.f65144b, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.f65145f = 7;
                a(7);
            }
            if (this.f65145f == 3) {
                this.f65146g.g();
                com.kwad.sdk.core.d.a.c(this.f65144b, "pause STATE_STARTED->STATE_PAUSED");
                this.f65145f = 5;
                a(5);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            a((b) null);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                return cVar.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                return cVar.i();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                return cVar.k();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f65146g;
            if (cVar != null) {
                return cVar.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.D.clear();
        }
    }
}
