package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f57753b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f57754c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f57755d;
    public transient /* synthetic */ FieldHolder $fh;
    public c.d A;
    public c.a B;
    public volatile List<d> C;
    public String a;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f57756e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.kwai.c f57757f;

    /* renamed from: g  reason: collision with root package name */
    public int f57758g;

    /* renamed from: h  reason: collision with root package name */
    public long f57759h;

    /* renamed from: i  reason: collision with root package name */
    public Timer f57760i;

    /* renamed from: j  reason: collision with root package name */
    public TimerTask f57761j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f57762k;
    public Context l;
    public DetailVideoView m;
    public int n;
    public int o;
    public long p;
    public com.kwad.sdk.contentalliance.detail.video.c q;
    public int r;
    public List<c.d> s;
    public final AtomicBoolean t;
    public boolean u;
    public volatile List<c.e> v;
    public c.e w;
    public c.h x;
    public c.b y;
    public c.InterfaceC2087c z;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2072a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<a> a;

        public C2072a(a aVar) {
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
            this.a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a.get()) == null) {
                return;
            }
            aVar.s();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<a> a;

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
            this.a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a.get()) == null) {
                return;
            }
            long m = aVar.m();
            long k2 = aVar.k();
            for (d dVar : aVar.C) {
                dVar.a(k2, m);
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
        f57755d = new AtomicInteger(0);
    }

    public a(@Nullable DetailVideoView detailVideoView) {
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
        this.a = "MediaPlayerImpl";
        this.f57756e = 0;
        this.f57762k = new Handler(Looper.getMainLooper());
        this.p = 0L;
        this.r = 0;
        this.s = new CopyOnWriteArrayList();
        this.t = new AtomicBoolean(false);
        this.u = false;
        this.v = new CopyOnWriteArrayList();
        this.w = new c.e(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(com.kwad.sdk.core.video.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.a.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPrepared:");
                    a aVar = this.a;
                    sb.append(aVar.b(aVar.f57756e));
                    sb.append("->STATE_PREPARED");
                    com.kwad.sdk.core.d.a.c(str, sb.toString());
                    this.a.f57756e = 2;
                    a aVar2 = this.a;
                    aVar2.a(aVar2.f57756e);
                    for (c.e eVar : this.a.v) {
                        eVar.a(this.a.f57757f);
                    }
                }
            }
        };
        this.x = new c.h(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.h
            public void a(com.kwad.sdk.core.video.kwai.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    if (this.a.m != null) {
                        this.a.m.a(i4, i5);
                    }
                    String str = this.a.a;
                    com.kwad.sdk.core.d.a.c(str, "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                }
            }
        };
        this.y = new c.b(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.b
            public void a(com.kwad.sdk.core.video.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.a.f57756e = 9;
                    a aVar = this.a;
                    aVar.a(aVar.f57756e);
                    com.kwad.sdk.core.d.a.c(this.a.a, "onCompletion ——> STATE_COMPLETED");
                }
            }
        };
        this.z = new c.InterfaceC2087c(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC2087c
            public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.a.f57756e = -1;
                        this.a.n = i4;
                        this.a.o = i5;
                        a aVar = this.a;
                        aVar.a(aVar.f57756e);
                        String str = this.a.a;
                        com.kwad.sdk.core.d.a.c(str, "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.A = new c.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.d
            public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i4, int i5) {
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
                            if (this.a.f57756e == 5 || this.a.f57756e == 7) {
                                this.a.f57756e = 7;
                                str3 = this.a.a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.a.f57756e = 6;
                                str3 = this.a.a;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.d.a.c(str3, str4);
                            a aVar = this.a;
                            aVar.a(aVar.f57756e);
                        } else if (i4 == 702) {
                            if (this.a.f57756e == 6) {
                                this.a.f57756e = 4;
                                a aVar2 = this.a;
                                aVar2.a(aVar2.f57756e);
                                com.kwad.sdk.core.d.a.c(this.a.a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.a.f57756e == 7) {
                                this.a.f57756e = 5;
                                a aVar3 = this.a;
                                aVar3.a(aVar3.f57756e);
                                str = this.a.a;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            }
                        } else if (i4 != 10001) {
                            if (i4 == 801) {
                                str = this.a.a;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.d.a.c(str, str2);
                            } else {
                                str = this.a.a;
                                sb = new StringBuilder();
                                sb.append("onInfo ——> what：");
                                sb.append(i4);
                            }
                        }
                        a aVar4 = this.a;
                        aVar4.a(aVar4.f57757f, i4, i5);
                        return true;
                    }
                    this.a.f57756e = 4;
                    a aVar5 = this.a;
                    aVar5.a(aVar5.f57756e);
                    str = this.a.a;
                    sb = new StringBuilder();
                    sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.a.p);
                    str2 = sb.toString();
                    com.kwad.sdk.core.d.a.c(str, str2);
                    a aVar42 = this.a;
                    aVar42.a(aVar42.f57757f, i4, i5);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.B = new c.a(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.a
            public void a(com.kwad.sdk.core.video.kwai.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.a.f57758g = i4;
                }
            }
        };
        this.C = new CopyOnWriteArrayList();
        this.m = detailVideoView;
        if (detailVideoView != null) {
            this.l = detailVideoView.getContext().getApplicationContext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.kwad.sdk.core.video.kwai.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.kwai.c a(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        com.kwad.sdk.core.video.kwai.b bVar;
        com.kwad.sdk.core.video.kwai.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            try {
                if (com.kwad.sdk.core.video.kwai.e.b() && com.kwad.sdk.core.config.b.h() && com.kwad.sdk.core.video.kwai.e.a()) {
                    com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                    com.kwad.sdk.core.video.kwai.d dVar = new com.kwad.sdk.core.video.kwai.d(context);
                    dVar.b(z);
                    bVar2 = dVar;
                } else {
                    com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                    bVar2 = new com.kwad.sdk.core.video.kwai.b();
                }
                z2 = false;
                bVar = bVar2;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
                if (!f57754c) {
                    f57754c = true;
                    com.kwad.sdk.crash.a.a(th);
                }
                z2 = true;
                bVar = new com.kwad.sdk.core.video.kwai.b();
            }
            int a = ai.a(com.kwad.sdk.core.video.kwai.e.b(), KsAdSDKImpl.get().getIsExternal(), com.kwad.sdk.core.config.b.h(), com.kwad.sdk.core.video.kwai.e.a(), z2, com.kwad.sdk.core.config.b.G(), bVar.o());
            com.kwad.sdk.core.d.a.a("player v=" + Integer.toBinaryString(a));
            if (f57753b != a) {
                f57753b = a;
                com.kwad.sdk.core.report.d.c(a);
            }
            return bVar;
        }
        return (com.kwad.sdk.core.video.kwai.c) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.kwai.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, cVar, bVar) == null) || cVar == null) {
            return;
        }
        try {
            cVar.l();
            if (bVar != null) {
                bVar.a();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    private void b(boolean z) {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || (detailVideoView = this.m) == null) {
            return;
        }
        detailVideoView.setKeepScreenOn(z);
    }

    private void c(int i2) {
        com.kwad.sdk.contentalliance.detail.video.c cVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65548, this, i2) == null) || (cVar = this.q) == null || (videoPlayerStatus = cVar.f57770d) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void o() {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (cVar = this.f57757f) == null) {
            return;
        }
        cVar.a((c.InterfaceC2087c) null);
        this.f57757f.a((c.b) null);
        this.f57757f.a((c.e) null);
        this.f57757f.a((c.h) null);
        this.f57757f.a((c.d) null);
        this.f57757f.a((c.f) null);
        this.f57757f.a((c.a) null);
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.a.c(str, "reset:" + b(this.f57756e) + "->STATE_IDLE");
            this.f57757f.m();
            this.f57756e = 0;
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            r();
            if (this.f57760i == null) {
                this.f57760i = new Timer("ksad-DetailPlayer-timer" + f57755d.getAndIncrement());
            }
            if (this.f57761j == null) {
                C2072a c2072a = new C2072a(this);
                this.f57761j = c2072a;
                this.f57760i.schedule(c2072a, 0L, 500L);
            }
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            Timer timer = this.f57760i;
            if (timer != null) {
                timer.cancel();
                this.f57760i = null;
            }
            TimerTask timerTask = this.f57761j;
            if (timerTask != null) {
                timerTask.cancel();
                this.f57761j = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.f57762k.post(new c(this));
        }
    }

    public com.kwad.sdk.core.video.kwai.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57757f : (com.kwad.sdk.core.video.kwai.c) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (cVar = this.f57757f) == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.C == null) {
            return;
        }
        for (d dVar : this.C) {
            if (dVar != null) {
                switch (i2) {
                    case -1:
                        b(false);
                        r();
                        dVar.a(this.n, this.o);
                        continue;
                    case 1:
                        dVar.a();
                        continue;
                    case 2:
                        dVar.b();
                        continue;
                    case 3:
                        b(true);
                        dVar.c();
                        continue;
                    case 4:
                        b(true);
                        dVar.d();
                        continue;
                    case 5:
                        b(false);
                        dVar.e();
                        continue;
                    case 6:
                        dVar.g();
                        continue;
                    case 7:
                        dVar.h();
                        continue;
                    case 9:
                        com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
                        if (cVar != null && !cVar.n()) {
                            b(false);
                            r();
                        }
                        dVar.f();
                        continue;
                }
            }
        }
    }

    public void a(long j2) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || (cVar = this.f57757f) == null) {
            return;
        }
        cVar.a(j2);
    }

    public void a(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, surface) == null) || (cVar = this.f57757f) == null) {
            return;
        }
        cVar.a(surface);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            a(bVar, true);
        }
    }

    public void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, bVar, z) == null) || this.f57757f == null) {
            return;
        }
        b(false);
        this.f57762k.removeCallbacksAndMessages(null);
        r();
        o();
        this.m = null;
        com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
        if (cVar != null) {
            if (z) {
                i.a(new Runnable(this, cVar, bVar) { // from class: com.kwad.sdk.contentalliance.detail.video.a.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.sdk.core.video.kwai.c a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ b f57763b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f57764c;

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
                        this.f57764c = this;
                        this.a = cVar;
                        this.f57763b = bVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f57764c.a(this.a, this.f57763b);
                        }
                    }
                });
            } else {
                a(cVar, bVar);
            }
            this.f57757f = null;
        }
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "release:" + b(this.f57756e) + "->STATE_IDLE");
        this.f57756e = 0;
        this.r = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
            if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
                ((com.kwad.sdk.core.video.kwai.d) cVar).a(bVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            try {
                if (TextUtils.isEmpty(cVar.f57768b)) {
                    com.kwad.sdk.core.d.a.e(this.a, "videoUrl is null");
                    return;
                }
                String str = this.a;
                com.kwad.sdk.core.d.a.e(str, "videoUrl=" + cVar.f57768b);
                this.f57757f.a(cVar);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, detailVideoView) == null) {
            a(cVar, true, false, detailVideoView);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{cVar, Boolean.valueOf(z), detailVideoView, cVar2}) == null) {
            com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer");
            if (cVar == null || detailVideoView == null || cVar2 == null) {
                return;
            }
            if (this.l == null) {
                this.l = detailVideoView.getContext().getApplicationContext();
            }
            this.u = z;
            this.q = cVar;
            DetailVideoView detailVideoView2 = this.m;
            if (detailVideoView2 != detailVideoView) {
                com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer videoView changed");
                if (detailVideoView2 != null) {
                    detailVideoView2.setMediaPlayer(null);
                    detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                    detailVideoView2.setKeepScreenOn(false);
                }
                this.m = detailVideoView;
            }
            detailVideoView.setMediaPlayer(this);
            if (this.f57757f != cVar2) {
                com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer mediaPlayer changed");
                com.kwad.sdk.core.video.kwai.c cVar3 = this.f57757f;
                if (cVar3 != null) {
                    cVar2.a(cVar3.n());
                    o();
                    this.f57757f.l();
                }
                this.f57757f = cVar2;
                p();
                c();
                cVar2.b(3);
            } else {
                com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer mediaPlayer not changed");
                p();
                o();
                c();
            }
            this.f57757f.a(detailVideoView.f57743b);
            com.kwad.sdk.core.video.kwai.c cVar4 = this.f57757f;
            if (cVar4 instanceof com.kwad.sdk.core.video.kwai.d) {
                ((com.kwad.sdk.core.video.kwai.d) cVar4).a(detailVideoView);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{cVar, Boolean.valueOf(z), Boolean.valueOf(z2), detailVideoView}) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.a.c(str, "initMediaPlayer enablePreLoad:" + z);
            if (cVar == null || detailVideoView == null) {
                return;
            }
            com.kwad.sdk.core.video.kwai.c a = a(this.l, z);
            a.a(false);
            a(cVar, z2, detailVideoView, a);
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.C.add(dVar);
        }
    }

    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.v.add(eVar);
        }
    }

    public void a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, cVar, i2, i3) == null) {
            Iterator<c.d> it = this.s.iterator();
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

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            float f2 = z ? 1.0f : 0.0f;
            a(f2, f2);
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
            if (cVar != null) {
                return cVar.o();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
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

    public void b(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            if (this.f57757f == null) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "mMediaPlayer is null");
            } else if (this.f57756e == 2 || this.f57756e == 3 || this.f57756e == 4 || this.f57756e == 5) {
                com.kwad.sdk.core.d.a.d("resetAndPlay", "can not resetAndPlay in sate:" + this.f57756e);
            } else {
                p();
                o();
                c();
                d();
            }
        }
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.C.remove(dVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f57757f.a(this.w);
            this.f57757f.a(this.x);
            this.f57757f.a(this.y);
            this.f57757f.a(this.z);
            this.f57757f.a(this.A);
            this.f57757f.a(this.B);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.u) {
                if (this.t.compareAndSet(false, true)) {
                    i.a(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

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

                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                        /* JADX WARN: Removed duplicated region for block: B:24:0x00da A[Catch: all -> 0x00e5, TRY_ENTER, TryCatch #3 {Exception -> 0x00e8, blocks: (B:22:0x00d3, B:23:0x00d9, B:24:0x00da, B:25:0x00e3), top: B:42:0x00d3 }] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            boolean e2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String str = this.a.a;
                                StringBuilder sb = new StringBuilder();
                                sb.append("prepareAsync now:");
                                a aVar = this.a;
                                sb.append(aVar.b(aVar.f57756e));
                                com.kwad.sdk.core.d.a.c(str, sb.toString());
                                if (this.a.f57757f == null) {
                                    return;
                                }
                                try {
                                    synchronized (this.a.f57757f) {
                                        this.a.a(this.a.q);
                                        e2 = this.a.f57757f.e();
                                        String str2 = this.a.a;
                                        com.kwad.sdk.core.d.a.c(str2, "prepareAsync:" + this.a.b(this.a.f57756e) + "->STATE_PREPARING, success: " + e2);
                                        this.a.f57756e = 1;
                                    }
                                    if (e2) {
                                        this.a.f57762k.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.7.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass7 a;

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
                                                this.a = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    a aVar2 = this.a.a;
                                                    aVar2.a(aVar2.f57756e);
                                                }
                                            }
                                        });
                                    } else {
                                        com.kwad.sdk.core.d.a.e(this.a.a, "prepareAsync failed");
                                    }
                                } finally {
                                    try {
                                        synchronized (this.a.t) {
                                        }
                                    } finally {
                                    }
                                }
                                try {
                                    synchronized (this.a.t) {
                                        this.a.t.notifyAll();
                                    }
                                } catch (Exception e3) {
                                    com.kwad.sdk.core.d.a.a(e3);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
            try {
                a(this.q);
                if (this.f57757f.e()) {
                    String str = this.a;
                    com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + b(this.f57756e) + "->STATE_PREPARING");
                    this.f57756e = 1;
                    a(this.f57756e);
                } else {
                    com.kwad.sdk.core.d.a.e(this.a, "prepareAsync failed");
                }
            } catch (Throwable th) {
                if (b() != 2) {
                    int i2 = this.r;
                    this.r = i2 + 1;
                    if (i2 <= 4) {
                        b(this.q);
                    }
                }
                String str2 = this.a;
                com.kwad.sdk.core.d.a.c(str2, "prepareAsync Exception:" + b(this.f57756e));
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b4, code lost:
        if (r7.f57756e == 9) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.a.c(str, "start mCurrentState: " + b(this.f57756e));
            if (this.f57756e == 0) {
                com.kwad.sdk.core.d.a.c(this.a, "start, still not prepared well, prepare again");
                d();
                if (b() == 2) {
                    if (this.u && this.t.get()) {
                        i.a(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.video.a.8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ a a;

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

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (this.a.t.get()) {
                                        try {
                                            synchronized (this.a.t) {
                                                this.a.t.wait(5000L);
                                            }
                                        } catch (InterruptedException e2) {
                                            com.kwad.sdk.core.d.a.a(e2);
                                        }
                                    }
                                    if (this.a.b() == 2) {
                                        this.a.f57757f.f();
                                    }
                                }
                            }
                        });
                    } else {
                        this.f57757f.f();
                    }
                }
            } else if (this.f57756e == 2 || this.f57756e == 9) {
                this.p = System.currentTimeMillis();
                this.f57757f.f();
                long j2 = this.f57759h;
                if (j2 != 0) {
                    this.f57757f.a((int) j2);
                }
                String str2 = this.a;
                com.kwad.sdk.core.d.a.c(str2, "start:" + b(this.f57756e) + "->STATE_STARTED");
                com.kwad.sdk.contentalliance.detail.video.c cVar = this.q;
                if (cVar != null && cVar.f57770d != null) {
                    if (this.f57756e == 2) {
                        if (this.q.f57770d.mVideoPlayerType == 0) {
                            c(1);
                        }
                        c(3);
                    }
                }
                this.f57756e = 3;
                a(this.f57756e);
                q();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f57757f == null) {
                com.kwad.sdk.core.d.a.e(this.a, "resume but mMediaPlayer is null");
                return;
            }
            String str = this.a;
            com.kwad.sdk.core.d.a.c(str, "resume mCurrentState: " + b(this.f57756e));
            if (this.f57756e == 2 || this.f57756e == 0) {
                String str2 = this.a;
                com.kwad.sdk.core.d.a.c(str2, "resume:" + b(this.f57756e) + "->start()");
                e();
            } else if (this.f57756e == 5) {
                this.f57757f.f();
                String str3 = this.a;
                com.kwad.sdk.core.d.a.c(str3, "resume:" + b(this.f57756e) + "->STATE_PLAYING");
                this.f57756e = 4;
                a(this.f57756e);
                c(2);
            } else if (this.f57756e != 7) {
                String str4 = this.a;
                com.kwad.sdk.core.d.a.e(str4, "resume: " + b(this.f57756e) + " 此时不能调用resume()方法.");
            } else {
                this.f57757f.f();
                String str5 = this.a;
                com.kwad.sdk.core.d.a.c(str5, "resume:" + b(this.f57756e) + "->STATE_BUFFERING_PLAYING");
                this.f57756e = 6;
                a(this.f57756e);
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String str = this.a;
            com.kwad.sdk.core.d.a.c(str, "pause mCurrentState: " + b(this.f57756e));
            if (this.f57756e == 4) {
                this.f57757f.g();
                com.kwad.sdk.core.d.a.c(this.a, "pause STATE_PLAYING->STATE_PAUSED");
                this.f57756e = 5;
                a(this.f57756e);
                z = true;
            } else {
                z = false;
            }
            if (this.f57756e == 6) {
                this.f57757f.g();
                com.kwad.sdk.core.d.a.c(this.a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.f57756e = 7;
                a(this.f57756e);
                z = true;
            }
            if (this.f57756e == 3) {
                this.f57757f.g();
                com.kwad.sdk.core.d.a.c(this.a, "pause STATE_STARTED->STATE_PAUSED");
                this.f57756e = 5;
                a(this.f57756e);
                z = true;
            }
            if (this.f57756e == 9 && this.f57757f.n()) {
                this.f57757f.g();
                String str2 = this.a;
                com.kwad.sdk.core.d.a.c(str2, "pause " + b(this.f57756e) + "->STATE_PAUSED");
                this.f57756e = 5;
                a(this.f57756e);
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            a((b) null);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
            if (cVar != null) {
                return cVar.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.f57757f;
            if (cVar != null) {
                return cVar.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.C.clear();
        }
    }
}
