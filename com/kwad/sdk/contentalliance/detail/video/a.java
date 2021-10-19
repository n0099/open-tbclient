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
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f71753b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f71754c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f71755d;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a A;
    public volatile List<d> B;

    /* renamed from: a  reason: collision with root package name */
    public String f71756a;

    /* renamed from: e  reason: collision with root package name */
    public int f71757e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f71758f;

    /* renamed from: g  reason: collision with root package name */
    public Surface f71759g;

    /* renamed from: h  reason: collision with root package name */
    public int f71760h;

    /* renamed from: i  reason: collision with root package name */
    public long f71761i;

    /* renamed from: j  reason: collision with root package name */
    public Timer f71762j;
    public TimerTask k;
    public Handler l;
    public DetailVideoView m;
    public WeakReference<DetailVideoView> n;
    public int o;
    public int p;
    public long q;
    public com.kwad.sdk.contentalliance.detail.video.c r;
    public int s;
    public List<c.d> t;
    public volatile List<c.e> u;
    public c.e v;
    public c.h w;
    public c.b x;
    public c.InterfaceC2001c y;
    public c.d z;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1987a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f71772a;

        public C1987a(a aVar) {
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
            this.f71772a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f71772a.get()) == null) {
                return;
            }
            aVar.r();
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes10.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f71773a;

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
            this.f71773a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f71773a.get()) == null) {
                return;
            }
            long l = aVar.l();
            long k = aVar.k();
            for (d dVar : aVar.B) {
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
        f71755d = new AtomicInteger(0);
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
        this.f71756a = "MediaPlayerImpl";
        this.f71757e = 0;
        this.l = new Handler(Looper.getMainLooper());
        this.q = 0L;
        this.s = 0;
        this.t = new CopyOnWriteArrayList();
        this.u = new CopyOnWriteArrayList();
        this.v = new c.e(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71763a;

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
                this.f71763a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.f71763a.f71756a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPrepared:");
                    a aVar = this.f71763a;
                    sb.append(aVar.b(aVar.f71757e));
                    sb.append("->STATE_PREPARED");
                    com.kwad.sdk.core.d.a.c(str, sb.toString());
                    this.f71763a.f71757e = 2;
                    a aVar2 = this.f71763a;
                    aVar2.a(aVar2.f71757e);
                    for (c.e eVar : this.f71763a.u) {
                        eVar.a(this.f71763a.f71758f);
                    }
                }
            }
        };
        this.w = new c.h(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71764a;

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
                this.f71764a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    DetailVideoView detailVideoView2 = (DetailVideoView) this.f71764a.n.get();
                    if (detailVideoView2 != null) {
                        detailVideoView2.a(i4, i5);
                    }
                    String str = this.f71764a.f71756a;
                    com.kwad.sdk.core.d.a.c(str, "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                }
            }
        };
        this.x = new c.b(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71765a;

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
                this.f71765a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f71765a.f71757e = 9;
                    a aVar = this.f71765a;
                    aVar.a(aVar.f71757e);
                    com.kwad.sdk.core.d.a.c(this.f71765a.f71756a, "onCompletion ——> STATE_COMPLETED");
                }
            }
        };
        this.y = new c.InterfaceC2001c(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71766a;

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
                this.f71766a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC2001c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.f71766a.f71757e = -1;
                        this.f71766a.o = i4;
                        this.f71766a.p = i5;
                        a aVar = this.f71766a;
                        aVar.a(aVar.f71757e);
                        String str = this.f71766a.f71756a;
                        com.kwad.sdk.core.d.a.c(str, "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.z = new c.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71767a;

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
                this.f71767a = this;
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
                            if (this.f71767a.f71757e == 5 || this.f71767a.f71757e == 7) {
                                this.f71767a.f71757e = 7;
                                str3 = this.f71767a.f71756a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.f71767a.f71757e = 6;
                                str3 = this.f71767a.f71756a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.d.a.c(str3, str4);
                            a aVar = this.f71767a;
                            aVar.a(aVar.f71757e);
                        } else if (i4 == 702) {
                            if (this.f71767a.f71757e == 6) {
                                this.f71767a.f71757e = 4;
                                a aVar2 = this.f71767a;
                                aVar2.a(aVar2.f71757e);
                                com.kwad.sdk.core.d.a.c(this.f71767a.f71756a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.f71767a.f71757e == 7) {
                                this.f71767a.f71757e = 5;
                                a aVar3 = this.f71767a;
                                aVar3.a(aVar3.f71757e);
                                str = this.f71767a.f71756a;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            }
                        } else if (i4 != 10001) {
                            if (i4 == 801) {
                                str = this.f71767a.f71756a;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            } else {
                                str = this.f71767a.f71756a;
                                sb = new StringBuilder();
                                sb.append("onInfo ——> what：");
                                sb.append(i4);
                            }
                        }
                        a aVar4 = this.f71767a;
                        aVar4.a(aVar4.f71758f, i4, i5);
                        return true;
                    }
                    this.f71767a.f71757e = 4;
                    a aVar5 = this.f71767a;
                    aVar5.a(aVar5.f71757e);
                    str = this.f71767a.f71756a;
                    sb = new StringBuilder();
                    sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.f71767a.q);
                    str2 = sb.toString();
                    com.kwad.sdk.core.d.a.c(str, str2);
                    a aVar42 = this.f71767a;
                    aVar42.a(aVar42.f71758f, i4, i5);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.A = new c.a(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71768a;

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
                this.f71768a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.f71768a.f71760h = i4;
                }
            }
        };
        this.B = new CopyOnWriteArrayList();
        this.m = detailVideoView;
        this.n = new WeakReference<>(detailVideoView);
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
                if (!f71754c) {
                    f71754c = true;
                    com.kwad.sdk.crash.a.a(th);
                }
                z2 = true;
                bVar = new com.kwad.sdk.core.video.a.b();
            }
            int a2 = ae.a(com.kwad.sdk.core.video.a.e.b(), KsAdSDKImpl.get().getIsExternal(), com.kwad.sdk.core.config.c.k(), com.kwad.sdk.core.video.a.e.a(), z2, com.kwad.sdk.core.config.c.F(), bVar.n());
            com.kwad.sdk.core.d.a.a("player v=" + Integer.toBinaryString(a2));
            if (f71753b != a2) {
                f71753b = a2;
                com.kwad.sdk.core.report.d.c(a2);
            }
            return bVar;
        }
        return (com.kwad.sdk.core.video.a.c) invokeLZ.objValue;
    }

    private void a(boolean z) {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) || (detailVideoView = this.m) == null) {
            return;
        }
        detailVideoView.setKeepScreenOn(z);
    }

    private void c(int i2) {
        com.kwad.sdk.contentalliance.detail.video.c cVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i2) == null) || (cVar = this.r) == null || (videoPlayerStatus = cVar.f71780c) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void n() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (cVar = this.f71758f) == null) {
            return;
        }
        cVar.a((c.InterfaceC2001c) null);
        this.f71758f.a((c.b) null);
        this.f71758f.a((c.e) null);
        this.f71758f.a((c.d) null);
        this.f71758f.a((c.f) null);
        this.f71758f.a((c.a) null);
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            String str = this.f71756a;
            com.kwad.sdk.core.d.a.c(str, "reset:" + b(this.f71757e) + "->STATE_IDLE");
            this.f71758f.m();
            this.f71757e = 0;
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            q();
            if (this.f71762j == null) {
                this.f71762j = new Timer("ksad-DetailPlayer-timer" + f71755d.getAndIncrement());
            }
            if (this.k == null) {
                C1987a c1987a = new C1987a(this);
                this.k = c1987a;
                this.f71762j.schedule(c1987a, 0L, 1000L);
            }
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            Timer timer = this.f71762j;
            if (timer != null) {
                timer.cancel();
                this.f71762j = null;
            }
            TimerTask timerTask = this.k;
            if (timerTask != null) {
                timerTask.cancel();
                this.k = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.l.post(new c(this));
        }
    }

    public com.kwad.sdk.core.video.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71758f : (com.kwad.sdk.core.video.a.c) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (cVar = this.f71758f) == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.B == null) {
            return;
        }
        for (d dVar : this.B) {
            if (dVar != null) {
                switch (i2) {
                    case -1:
                        a(false);
                        q();
                        dVar.a(this.o, this.p);
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
            this.f71759g = surface;
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
            if (cVar != null) {
                cVar.a(surface);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f71758f == null) {
            return;
        }
        a(false);
        this.l.removeCallbacksAndMessages(null);
        q();
        n();
        com.kwad.sdk.core.video.a.c cVar = this.f71758f;
        if (cVar != null) {
            g.a(new Runnable(this, cVar, bVar) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.video.a.c f71769a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f71770b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f71771c;

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
                    this.f71771c = this;
                    this.f71769a = cVar;
                    this.f71770b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f71769a.l();
                            if (this.f71770b != null) {
                                this.f71770b.a();
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.a(th);
                        }
                    }
                }
            });
            this.f71758f = null;
        }
        String str = this.f71756a;
        com.kwad.sdk.core.d.a.c(str, "release:" + b(this.f71757e) + "->STATE_IDLE");
        this.f71757e = 0;
        this.s = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
            if (cVar instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar).a(bVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            a(cVar, true);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, cVar, z) == null) {
            String str = this.f71756a;
            com.kwad.sdk.core.d.a.c(str, "initMediaPlayer enablePreLoad:" + z);
            this.r = cVar;
            DetailVideoView detailVideoView = this.m;
            this.f71759g = detailVideoView.f71743b;
            detailVideoView.setMediaPlayer(this);
            this.f71758f = a(this.m.getContext(), z);
            b(cVar);
            this.f71758f.a(false);
            this.f71758f.a(this.f71759g);
            this.f71758f.b(3);
            com.kwad.sdk.core.video.a.c cVar2 = this.f71758f;
            if (cVar2 instanceof com.kwad.sdk.core.video.a.d) {
                ((com.kwad.sdk.core.video.a.d) cVar2).a(this.m);
            }
            c();
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.B.add(dVar);
        }
    }

    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.u.add(eVar);
        }
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, cVar, i2, i3) == null) {
            Iterator<c.d> it = this.t.iterator();
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
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
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
                if (TextUtils.isEmpty(cVar.f71778a)) {
                    com.kwad.sdk.core.d.a.e(this.f71756a, "videoUrl is null");
                    return;
                }
                String str = this.f71756a;
                com.kwad.sdk.core.d.a.e(str, "videoUrl=" + cVar.f71778a);
                this.f71758f.a(cVar);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.B.remove(dVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f71758f.a(this.v);
            this.f71758f.a(this.w);
            this.f71758f.a(this.x);
            this.f71758f.a(this.y);
            this.f71758f.a(this.z);
            this.f71758f.a(this.A);
        }
    }

    public void c(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            if (this.f71758f == null) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "mMediaPlayer is null");
                return;
            }
            int i2 = this.f71757e;
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "can not resetAndPlay in sate:" + this.f71757e);
                return;
            }
            o();
            b(cVar);
            n();
            c();
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                if (this.f71758f.e()) {
                    String str = this.f71756a;
                    com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + b(this.f71757e) + "->STATE_PREPARING");
                    this.f71757e = 1;
                    a(1);
                }
            } catch (Exception e2) {
                String str2 = this.f71756a;
                com.kwad.sdk.core.d.a.c(str2, "prepareAsync Exception:" + b(this.f71757e));
                com.kwad.sdk.core.d.a.a(e2);
                if (b() != 2) {
                    int i2 = this.s;
                    this.s = i2 + 1;
                    if (i2 <= 4) {
                        c(this.r);
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
            int i2 = this.f71757e;
            if (i2 == 0) {
                com.kwad.sdk.core.d.a.c(this.f71756a, "start, still not prepared well, prepare again");
                d();
                if (b() == 2) {
                    this.f71758f.f();
                }
            } else if (i2 == 2 || i2 == 9) {
                this.q = System.currentTimeMillis();
                this.f71758f.f();
                long j2 = this.f71761i;
                if (j2 != 0) {
                    this.f71758f.a((int) j2);
                }
                String str = this.f71756a;
                com.kwad.sdk.core.d.a.c(str, "start:" + b(this.f71757e) + "->STATE_STARTED");
                com.kwad.sdk.contentalliance.detail.video.c cVar = this.r;
                if (cVar != null && (videoPlayerStatus = cVar.f71780c) != null) {
                    int i3 = this.f71757e;
                    if (i3 == 2) {
                        if (videoPlayerStatus.mVideoPlayerType == 0) {
                            c(1);
                        }
                        c(3);
                    }
                }
                this.f71757e = 3;
                a(3);
                p();
            }
        }
    }

    public void f() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f71758f) == null) {
            return;
        }
        int i2 = this.f71757e;
        if (i2 == 2 || i2 == 0) {
            String str = this.f71756a;
            com.kwad.sdk.core.d.a.c(str, "resume:" + b(this.f71757e) + "->start()");
            e();
        } else if (i2 == 5) {
            cVar.f();
            String str2 = this.f71756a;
            com.kwad.sdk.core.d.a.c(str2, "resume:" + b(this.f71757e) + "->STATE_PLAYING");
            this.f71757e = 4;
            a(4);
            c(2);
        } else if (i2 == 7) {
            cVar.f();
            String str3 = this.f71756a;
            com.kwad.sdk.core.d.a.c(str3, "resume:" + b(this.f71757e) + "->STATE_BUFFERING_PLAYING");
            this.f71757e = 6;
            a(6);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.f71757e == 4) {
                this.f71758f.g();
                com.kwad.sdk.core.d.a.c(this.f71756a, "pause STATE_PLAYING->STATE_PAUSED");
                this.f71757e = 5;
                a(5);
            }
            if (this.f71757e == 6) {
                this.f71758f.g();
                com.kwad.sdk.core.d.a.c(this.f71756a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.f71757e = 7;
                a(7);
            }
            if (this.f71757e == 3) {
                this.f71758f.g();
                com.kwad.sdk.core.d.a.c(this.f71756a, "pause STATE_STARTED->STATE_PAUSED");
                this.f71757e = 5;
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
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
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
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
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
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
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
            com.kwad.sdk.core.video.a.c cVar = this.f71758f;
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
            this.B.clear();
        }
    }
}
