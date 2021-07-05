package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.qos.KwaiPlayerResultQos;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.ksvodplayerkit.KSVodPlayerBuilder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.PlayerPostEvent;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.AspectAwesomeCache;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import com.kwai.video.player.kwai_player.ProductContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.video.ksvodplayerkit.HttpDns.d A;
    public AtomicInteger B;
    public com.kwai.video.ksvodplayerkit.b.f C;
    public boolean D;
    public long E;
    public long F;
    public IMediaPlayer.OnSeekCompleteListener G;
    public IMediaPlayer.OnInfoListener H;
    public IMediaPlayer.OnErrorListener I;
    public IMediaPlayer.OnPreparedListener J;
    public IMediaPlayer.OnVideoSizeChangedListener K;
    public IMediaPlayer.OnBufferingUpdateListener L;

    /* renamed from: a  reason: collision with root package name */
    public KwaiPlayerDebugInfoView f39961a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f39962b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f39963c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f39964d;

    /* renamed from: e  reason: collision with root package name */
    public IKwaiMediaPlayer f39965e;

    /* renamed from: f  reason: collision with root package name */
    public IKwaiMediaPlayer f39966f;

    /* renamed from: g  reason: collision with root package name */
    public String f39967g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f39968h;

    /* renamed from: i  reason: collision with root package name */
    public KSVodPlayerBuilder f39969i;
    public boolean j;
    public int k;
    public long l;
    public boolean m;
    public float n;
    public float o;
    public boolean p;
    public boolean q;
    public AtomicInteger r;
    public boolean s;
    public d.InterfaceC0499d t;
    public d.b u;
    public d.c v;
    public com.kwai.video.ksvodplayerkit.b w;
    public d.e x;
    public a y;
    public d.a z;

    /* loaded from: classes7.dex */
    public class a extends AwesomeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f39979a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.video.ksvodplayerkit.b f39980b;

        /* renamed from: c  reason: collision with root package name */
        public c f39981c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f39982d;

        public a(g gVar, com.kwai.video.ksvodplayerkit.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39979a = gVar;
            this.f39981c = new c();
            this.f39982d = false;
            this.f39980b = bVar;
        }

        public void a(com.kwai.video.ksvodplayerkit.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f39980b = bVar;
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acCallBackInfo) == null) {
                c cVar = this.f39981c;
                cVar.f39910f = acCallBackInfo.host;
                cVar.f39909e = acCallBackInfo.currentUri;
                int i2 = acCallBackInfo.transferConsumeMs;
                cVar.k = i2;
                cVar.m = acCallBackInfo.kwaiSign;
                cVar.n = acCallBackInfo.xKsCache;
                String str2 = acCallBackInfo.cdnStatJson;
                cVar.o = str2;
                cVar.f39912h = acCallBackInfo.sessionUUID;
                cVar.f39913i = acCallBackInfo.downloadUUID;
                cVar.o = str2;
                cVar.j = acCallBackInfo.httpResponseCode;
                cVar.p = acCallBackInfo.errorCode;
                int i3 = acCallBackInfo.stopReason;
                cVar.q = i3;
                cVar.l = i2;
                if (i3 == 1) {
                    com.kwai.video.ksvodplayerkit.b bVar2 = this.f39980b;
                    if (bVar2 != null && !this.f39982d) {
                        cVar.r++;
                        bVar2.b(cVar);
                    }
                    if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f39980b) != null && !this.f39982d) {
                        this.f39982d = true;
                        bVar.c(this.f39981c);
                    }
                    this.f39979a.i();
                } else if (i3 != 2) {
                    this.f39979a.b(str2);
                    String str3 = acCallBackInfo.currentUri;
                    String str4 = null;
                    if (this.f39979a.f39969i.f39857i == 2) {
                        str3 = this.f39979a.C != null ? this.f39979a.C.f39869a : null;
                    }
                    f.a().a(str3, this.f39979a.f39965e != null ? this.f39979a.f39965e.getCurrentPosition() : 0L);
                    if (com.kwai.video.ksvodplayerkit.c.a.a(this.f39979a.f39969i.f39849a) && this.f39979a.A != null) {
                        this.f39979a.A.a(false);
                        if (this.f39979a.A.f() > 0 && !this.f39979a.A.e() && this.f39979a.B.addAndGet(1) < i.a().e() && this.f39979a.A.a()) {
                            if (this.f39979a.f39969i.f39857i == 1) {
                                str = com.kwai.video.ksvodplayerkit.b.m.a(this.f39979a.A.g());
                            } else if (this.f39979a.f39969i.f39857i == 2) {
                                com.kwai.video.ksvodplayerkit.b.c h2 = this.f39979a.A.h();
                                if (h2 != null) {
                                    str4 = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                                    this.f39979a.f39968h.put("Host", h2.f39867d);
                                }
                                str = str4;
                            } else {
                                this.f39979a.f39968h.put("Host", this.f39979a.A.d());
                                str = this.f39979a.A.b().f39826b;
                            }
                            if (str != null && this.f39979a.a(str)) {
                                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + " refreshDataSource count:" + this.f39979a.B.get() + ", new url:" + str);
                                return;
                            }
                        }
                    }
                    this.f39979a.r.set(9);
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", already retry all urls, stop play");
                    com.kwai.video.ksvodplayerkit.b bVar3 = this.f39980b;
                    if (bVar3 != null) {
                        bVar3.d(this.f39981c);
                        return;
                    }
                    return;
                } else {
                    com.kwai.video.ksvodplayerkit.b bVar4 = this.f39980b;
                    if (bVar4 != null) {
                        bVar4.e(cVar);
                    }
                }
                this.f39979a.b(acCallBackInfo.cdnStatJson);
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, acCallBackInfo) == null) {
                c cVar = this.f39981c;
                cVar.f39908d = acCallBackInfo.contentLength;
                cVar.f39907c = acCallBackInfo.totalBytes;
                cVar.f39911g = acCallBackInfo.ip;
                long j = acCallBackInfo.cachedBytes;
                cVar.f39905a = j;
                long j2 = acCallBackInfo.progressPosition;
                cVar.f39906b = j2;
                if (j2 <= 0 && j > 0) {
                    cVar.f39906b = j;
                }
                com.kwai.video.ksvodplayerkit.b bVar2 = this.f39980b;
                if (bVar2 != null) {
                    bVar2.a(this.f39981c);
                }
                if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f39980b) != null && !this.f39982d) {
                    this.f39982d = true;
                    bVar.c(this.f39981c);
                    c cVar2 = this.f39981c;
                    cVar2.r++;
                    this.f39980b.b(cVar2);
                }
                com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "onSessionProgress ,cachedBytes:" + this.f39981c.f39906b + ",mPreloadThresholdBytes:" + i.a().s());
                if (this.f39979a.v == null || !this.f39981c.a()) {
                    return;
                }
                com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "notifyCanPreloadNext ,cachedBytes:" + this.f39981c.f39906b + ",mTotalBytesOfSource:" + this.f39981c.f39907c);
                this.f39979a.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39983a;

        /* renamed from: b  reason: collision with root package name */
        public String f39984b;

        /* renamed from: c  reason: collision with root package name */
        public String f39985c;

        /* renamed from: d  reason: collision with root package name */
        public long f39986d;

        /* renamed from: e  reason: collision with root package name */
        public String f39987e;

        /* renamed from: f  reason: collision with root package name */
        public long f39988f;

        /* renamed from: g  reason: collision with root package name */
        public long f39989g;

        /* renamed from: h  reason: collision with root package name */
        public long f39990h;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public g(KSVodPlayerBuilder kSVodPlayerBuilder) {
        com.kwai.video.ksvodplayerkit.b.h hVar;
        List<String> list;
        com.kwai.video.ksvodplayerkit.b.h hVar2;
        List<com.kwai.video.ksvodplayerkit.b.i> list2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kSVodPlayerBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39962b = new Object();
        this.k = 0;
        this.l = -1L;
        this.m = true;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = false;
        this.q = false;
        this.r = new AtomicInteger();
        this.s = false;
        this.B = new AtomicInteger();
        this.D = false;
        this.G = new IMediaPlayer.OnSeekCompleteListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39970a;

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
                this.f39970a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) || this.f39970a.v == null) {
                    return;
                }
                this.f39970a.v.a(10100, 0);
            }
        };
        this.H = new IMediaPlayer.OnInfoListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39971a;

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
                this.f39971a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i4, i5)) == null) {
                    if (i4 == 3) {
                        synchronized (this.f39971a.f39962b) {
                            if (this.f39971a.f39969i.f39853e != null) {
                                this.f39971a.l = System.currentTimeMillis() - this.f39971a.f39969i.f39853e.f40018d;
                            }
                        }
                        if (this.f39971a.v != null) {
                            this.f39971a.v.a(10207, 0);
                        }
                        i4 = 3;
                    } else if (i4 == 10101) {
                        if (this.f39971a.r.get() != 6 && this.f39971a.v != null) {
                            this.f39971a.v.a(10208, 0);
                            this.f39971a.q = true;
                        }
                        this.f39971a.r.set(6);
                        i4 = PlayerPostEvent.MEDIA_INFO_PLAY_TO_END;
                    } else if (i4 == 10103) {
                        this.f39971a.m = i5 == 5;
                        if (i5 == 6 && this.f39971a.r.get() != 6) {
                            if (this.f39971a.v != null) {
                                this.f39971a.v.a(10208, 0);
                            }
                            this.f39971a.q = true;
                        }
                        this.f39971a.r.set(i5);
                    } else if (i4 == 701) {
                        i4 = 701;
                    } else if (i4 != 702) {
                        switch (i4) {
                            case 10001:
                                i4 = 10001;
                                break;
                            case 10002:
                                i4 = 10002;
                                break;
                            case 10003:
                                i4 = 10003;
                                if (!this.f39971a.p && this.f39971a.q && this.f39971a.v != null) {
                                    this.f39971a.v.a(10207, 0);
                                    this.f39971a.q = false;
                                }
                                this.f39971a.p = false;
                                break;
                            case 10004:
                                i4 = 10004;
                                break;
                        }
                    } else {
                        i4 = 702;
                    }
                    if (this.f39971a.v != null) {
                        this.f39971a.v.a(i4, i5);
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        };
        this.I = new IMediaPlayer.OnErrorListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39972a;

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
                this.f39972a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i4, int i5) {
                InterceptResult invokeLII;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i4, i5)) == null) {
                    this.f39972a.r.set(9);
                    if (i4 == -23120 && i5 == -3120) {
                        z = this.f39972a.j();
                        Log.e("KSVodPlayer", "onError what: " + i4 + " extra: " + i5 + " retry: " + z + " retryCount: " + this.f39972a.B.get());
                    } else {
                        z = false;
                    }
                    if (this.f39972a.u != null && !z) {
                        this.f39972a.u.b(i4, i5);
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        };
        this.J = new IMediaPlayer.OnPreparedListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39973a;

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
                this.f39973a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) || this.f39973a.r.get() == 9) {
                    return;
                }
                synchronized (this.f39973a.f39962b) {
                    if (this.f39973a.f39966f == null || this.f39973a.f39965e == null) {
                        z = false;
                    } else {
                        if (!this.f39973a.m && this.f39973a.f39969i.f39855g) {
                            this.f39973a.f39965e.start();
                        }
                        this.f39973a.f39966f = null;
                        if (this.f39973a.f39963c != null) {
                            this.f39973a.f39965e.setSurface(this.f39973a.f39963c);
                        }
                        if (this.f39973a.f39964d != null) {
                            this.f39973a.f39965e.setDisplay(this.f39973a.f39964d);
                        }
                        z = true;
                        if (this.f39973a.f39961a != null && i.a().m()) {
                            this.f39973a.f39961a.stopMonitor();
                            this.f39973a.f39961a.startMonitor(this.f39973a.f39965e);
                        }
                    }
                }
                if (z || i.a().b() || this.f39973a.f39969i.f39857i == 2) {
                    String str = this.f39973a.f39967g;
                    if (this.f39973a.A != null && this.f39973a.A.i() != null) {
                        str = this.f39973a.A.i();
                    }
                    long c2 = f.a().c(str);
                    if (c2 > 0) {
                        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                        this.f39973a.f39965e.seekTo(c2);
                    }
                }
                if (z && this.f39973a.v != null) {
                    this.f39973a.v.a(10206, 0);
                }
                if (this.f39973a.t != null && (!z || this.f39973a.r.get() <= 2)) {
                    this.f39973a.r.set(3);
                    this.f39973a.t.b();
                }
                this.f39973a.r.set(3);
            }
        };
        this.K = new IMediaPlayer.OnVideoSizeChangedListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39974a;

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
                this.f39974a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i4, int i5, int i6, int i7) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{iMediaPlayer, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) || this.f39974a.x == null) {
                    return;
                }
                this.f39974a.x.a(i4, i5, i6, i7);
            }
        };
        this.L = new IMediaPlayer.OnBufferingUpdateListener(this) { // from class: com.kwai.video.ksvodplayerkit.g.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39975a;

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
                this.f39975a = this;
            }

            @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaPlayer, i4) == null) || this.f39975a.z == null) {
                    return;
                }
                this.f39975a.z.a(i4);
            }
        };
        this.r.set(0);
        this.f39969i = kSVodPlayerBuilder;
        this.f39967g = kSVodPlayerBuilder.f39850b;
        this.f39968h = kSVodPlayerBuilder.f39852d;
        this.B.set(0);
        if (TextUtils.isEmpty(this.f39967g) && (((list = this.f39969i.f39851c) == null || list.isEmpty() || TextUtils.isEmpty(this.f39969i.f39851c.get(0))) && ((hVar2 = this.f39969i.f39856h) == null || (list2 = hVar2.f39879b) == null || list2.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        if (this.f39968h == null) {
            this.f39968h = new HashMap();
        }
        Map<String, String> map = this.f39969i.k;
        if (map != null) {
            this.f39968h.putAll(map);
        }
        KSVodPlayerBuilder kSVodPlayerBuilder2 = this.f39969i;
        if (kSVodPlayerBuilder2.f39857i != 1 || (hVar = kSVodPlayerBuilder2.f39856h) == null) {
            KSVodPlayerBuilder kSVodPlayerBuilder3 = this.f39969i;
            if (kSVodPlayerBuilder3.f39857i == 2) {
                com.kwai.video.ksvodplayerkit.HttpDns.d dVar = new com.kwai.video.ksvodplayerkit.HttpDns.d(this.f39967g);
                this.A = dVar;
                com.kwai.video.ksvodplayerkit.b.c h2 = dVar.h();
                try {
                    this.f39967g = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                } catch (Exception e2) {
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e2);
                }
                this.f39968h.put("Host", h2.f39867d);
            } else {
                String str = this.f39967g;
                str = str == null ? kSVodPlayerBuilder3.f39851c.get(0) : str;
                this.f39967g = str;
                if (com.kwai.video.ksvodplayerkit.c.c.a(str) && !f.a().b(this.f39967g)) {
                    ArrayList arrayList = new ArrayList();
                    List<String> list3 = this.f39969i.f39851c;
                    if (list3 == null || list3.isEmpty()) {
                        arrayList.add(this.f39967g);
                    } else {
                        arrayList.addAll(this.f39969i.f39851c);
                    }
                    com.kwai.video.ksvodplayerkit.HttpDns.d dVar2 = new com.kwai.video.ksvodplayerkit.HttpDns.d(arrayList);
                    this.A = dVar2;
                    if (dVar2.b() != null && !TextUtils.isEmpty(this.A.b().f39826b)) {
                        this.f39967g = this.A.b().f39826b;
                        this.f39968h.put("Host", this.A.d());
                    }
                }
            }
        } else {
            com.kwai.video.ksvodplayerkit.HttpDns.d dVar3 = new com.kwai.video.ksvodplayerkit.HttpDns.d(hVar);
            this.A = dVar3;
            try {
                this.f39967g = com.kwai.video.ksvodplayerkit.b.m.a(dVar3.g());
            } catch (Exception e3) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e3);
            }
            this.f39967g = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
        }
        if (this.f39967g == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", new Exception("new KSVodPlayer"));
        }
        this.f39965e = a(this.f39969i.a());
        this.r.set(1);
    }

    private IKwaiMediaPlayer a(KwaiPlayerVodBuilder kwaiPlayerVodBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, kwaiPlayerVodBuilder)) == null) {
            kwaiPlayerVodBuilder.setUseNatvieCache(true).setStartOnPrepared(false).setOverlayFormat(PlayerSettingConstants.SDL_FCC_RV32).setEnableAccurateSeek(true).setStartOnPrepared(this.f39969i.n).setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
            long j = this.f39969i.o;
            if (j > 0) {
                kwaiPlayerVodBuilder.seekAtStart(j);
            }
            if (this.f39969i.l != null) {
                kwaiPlayerVodBuilder.setProductContext(new ProductContext.Builder().setBizType(this.f39969i.l).setPlayIndex(this.B.get()).build());
            }
            KSVodPlayerBuilder.VodPlayEnterType vodPlayEnterType = this.f39969i.f39854f;
            if (vodPlayEnterType == KSVodPlayerBuilder.VodPlayEnterType.CLICK) {
                kwaiPlayerVodBuilder.setMaxBufferStrategy(1).setMaxBufferTimeBspMs(i.a().r()).setStartPlayBlockBufferMs(i.a().c(), i.a().d());
            } else if (vodPlayEnterType == KSVodPlayerBuilder.VodPlayEnterType.SLIDE) {
                kwaiPlayerVodBuilder.setPreLoadDurationMs(1, i.a().f());
            }
            if (i.a().g()) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
            }
            if (i.a().h()) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
            }
            com.kwai.video.ksvodplayerkit.c.b bVar = this.f39969i.m;
            if (bVar != null) {
                kwaiPlayerVodBuilder.setUseMediaCodecByteBuffer(bVar.f39914a);
                if (bVar.f39915b) {
                    kwaiPlayerVodBuilder.setMediaCodecAvcHeightLimit(bVar.f39917d);
                    kwaiPlayerVodBuilder.setMediaCodecAvcWidthLimit(bVar.f39916c);
                    kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
                }
                if (bVar.f39918e) {
                    kwaiPlayerVodBuilder.setMediaCodecHevcHeightLimit(bVar.f39917d);
                    kwaiPlayerVodBuilder.setMediaCodecHevcWidthLimit(bVar.f39916c);
                    kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
                }
                if (bVar.f39915b && bVar.f39918e) {
                    kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(4096);
                }
                int i2 = bVar.f39919f;
                if (i2 > 0) {
                    kwaiPlayerVodBuilder.setMediaCodecMaxNum(i2);
                }
            }
            KSVodPlayerBuilder kSVodPlayerBuilder = this.f39969i;
            if (kSVodPlayerBuilder.f39857i == 1 && kSVodPlayerBuilder.f39856h != null) {
                kwaiPlayerVodBuilder.setVodManifest(com.kwai.video.ksvodplayerkit.c.a.d(kSVodPlayerBuilder.f39849a), com.kwai.video.ksvodplayerkit.c.c.a(this.f39969i.f39849a), com.kwai.video.ksvodplayerkit.c.c.b(this.f39969i.f39849a), i.a().k(), i.a().l(), 0);
            } else if (this.f39969i.f39857i == 2) {
                kwaiPlayerVodBuilder.setEnableAccurateSeek(false).setEnableSegmentCache(true).setEnableSeekForwardOffset(true);
                int i3 = this.f39969i.j;
                if (i3 >= 0) {
                    a(i3);
                }
            } else {
                kwaiPlayerVodBuilder.setCacheKey(f.a().a(this.f39967g));
            }
            if (i.a().b() && this.f39969i.f39857i == 0) {
                long c2 = f.a().c(this.f39967g);
                if (c2 > 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                    kwaiPlayerVodBuilder.seekAtStart(c2);
                }
            }
            if (com.kwai.video.ksvodplayerkit.c.c.b(this.f39967g)) {
                kwaiPlayerVodBuilder.setEnableAccurateSeek(false);
            }
            IKwaiMediaPlayer build = kwaiPlayerVodBuilder.build();
            build.setLooping(this.j);
            AspectAwesomeCache aspectAwesomeCache = build.getAspectAwesomeCache();
            aspectAwesomeCache.setCacheDownloadReadTimeoutMs(i.a().p());
            aspectAwesomeCache.setCacheDownloadConnectTimeoutMs(i.a().o());
            aspectAwesomeCache.setBufferedDataSourceSizeKB(i.a().q());
            a aVar = new a(this, this.w);
            this.y = aVar;
            aspectAwesomeCache.setAwesomeCacheCallback(aVar);
            if (i.a().i()) {
                aspectAwesomeCache.setDataSourceType(0);
            }
            if (com.kwai.video.ksvodplayerkit.c.c.b(this.f39967g)) {
                aspectAwesomeCache.setDataSourceType(2);
            }
            if (i.a().n() > 0) {
                aspectAwesomeCache.setCacheSocketBufferSizeKb(i.a().n());
            }
            build.setOnPreparedListener(this.J);
            build.setOnInfoListener(this.H);
            build.setOnErrorListener(this.I);
            build.setOnVideoSizeChangedListener(this.K);
            build.setOnSeekCompleteListener(this.G);
            build.setOnBufferingUpdateListener(this.L);
            if (!TextUtils.isEmpty(this.f39967g)) {
                try {
                    if (this.f39969i.f39857i == 2) {
                        build.setKwaiManifest(this.C != null ? this.C.f39869a : "no_prefer_url", this.f39967g, this.f39968h);
                    } else {
                        build.setDataSource(this.f39967g, this.f39968h);
                    }
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer, url:" + this.f39967g);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "setDataSource error", new Exception("setDataSource"));
                }
            }
            Surface surface = this.f39963c;
            if (surface != null) {
                build.setSurface(surface);
            }
            SurfaceHolder surfaceHolder = this.f39964d;
            if (surfaceHolder != null) {
                build.setDisplay(surfaceHolder);
            }
            return build;
        }
        return (IKwaiMediaPlayer) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KwaiPlayerResultQos kwaiPlayerResultQos) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, kwaiPlayerResultQos) == null) {
            String str = kwaiPlayerResultQos.videoStatJson;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("qos", str);
            if (this.f39969i.f39853e != null) {
                b bVar = new b();
                l lVar = this.f39969i.f39853e;
                bVar.f39985c = lVar.f40017c;
                bVar.f39984b = lVar.f40016b;
                bVar.f39983a = lVar.f40015a;
                bVar.f39987e = lVar.f40019e;
                bVar.f39986d = this.l;
                bVar.f39988f = this.E;
                bVar.f39989g = this.F;
                bVar.f39990h = lVar.f40018d;
                jSONObject.put("stats", m.a(bVar));
                com.kwai.video.ksvodplayerkit.d.g a2 = com.kwai.video.ksvodplayerkit.d.c.a().a(this.f39969i.f39853e.f40017c);
                if (a2 != null) {
                    jSONObject.put(PrefetchEvent.MODULE, com.kwai.video.ksvodplayerkit.d.h.a(a2));
                }
            }
            String jSONObject2 = jSONObject.toString();
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "logVideoStatJson VP_PLAYFINISHED；" + jSONObject2);
            com.kwai.video.ksvodplayerkit.a.c.a(jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.f39965e.setOnErrorListener(null);
                    this.f39965e.setOnPreparedListener(null);
                    this.f39965e.setOnVideoSizeChangedListener(null);
                    this.f39965e.setOnInfoListener(null);
                    this.f39965e.setOnBufferingUpdateListener(null);
                    this.f39965e.releaseAsync();
                    this.f39965e = null;
                }
                this.f39967g = str;
                this.f39966f = a(this.f39969i.a());
                if (this.n != 1.0f || this.o != 1.0f) {
                    this.f39966f.setVolume(this.n, this.o);
                }
                if (this.k != 0) {
                    this.f39966f.setVideoScalingMode(this.k);
                }
                this.r.set(2);
                this.f39966f.prepareAsync();
                this.f39965e = this.f39966f;
            }
            d.c cVar = this.v;
            if (cVar != null) {
                cVar.a(10205, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qos", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rank", this.A != null ? this.A.c() : 0);
            jSONObject.put("stats", jSONObject2.toString());
            jSONObject.put("resource_type", "video");
            String jSONObject3 = jSONObject.toString();
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "logVideoStatJson VP_CDN_RESOURCE：" + jSONObject3);
            com.kwai.video.ksvodplayerkit.a.c.b(jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (cVar = this.v) == null) {
            return;
        }
        cVar.a(10209, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            if (!com.kwai.video.ksvodplayerkit.c.a.a(this.f39969i.f39849a) || this.B.addAndGet(1) >= i.a().e()) {
                return false;
            }
            return g();
        }
        return invokeV.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e == null || !(this.r.get() == 1 || this.r.get() == 7)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("prepareAsync error, playback state:");
                    sb.append(this.r.get());
                    sb.append(",mCurrentPlayer == null:");
                    sb.append(this.f39965e == null);
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", sb.toString(), new Exception("prepareAsync"));
                    return -1;
                }
                if (this.E == 0) {
                    this.E = System.currentTimeMillis();
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync");
                this.r.set(2);
                this.f39965e.prepareAsync();
                if (this.f39969i.f39856h != null) {
                    this.A.a(this.f39965e.getVodAdaptiveUrl());
                    if (i.a().b()) {
                        long c2 = f.a().c(this.f39965e.getVodAdaptiveUrl());
                        if (c2 > 0) {
                            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync, multi rate use history play progress");
                            this.f39965e.seekTo(c2);
                        }
                    }
                }
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.f39965e.setSpeed(f2);
                }
            }
        }
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.f39965e.setVolume(f2, f3);
                }
                this.n = f2;
                this.o = f3;
            }
        }
    }

    public void a(int i2) {
        com.kwai.video.ksvodplayerkit.b.c h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this.f39962b) {
                if (this.f39969i.f39857i == 2 && (h2 = this.A.h()) != null && h2.f39866c != null) {
                    Iterator<com.kwai.video.ksvodplayerkit.b.f> it = h2.f39866c.f39868a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.kwai.video.ksvodplayerkit.b.f next = it.next();
                        if (next.f39875g == i2) {
                            this.C = next;
                            break;
                        }
                    }
                    if (this.C == null) {
                        this.C = h2.f39866c.f39868a.get(0);
                    }
                    if (this.C != null) {
                        this.A.a(this.C.f39869a);
                    }
                }
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.p = true;
                    this.f39965e.seekTo(j);
                }
            }
        }
    }

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, surface) == null) {
            synchronized (this.f39962b) {
                this.f39963c = surface;
                if (this.f39965e != null) {
                    this.f39965e.setSurface(surface);
                }
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) || surfaceHolder == null) {
            return;
        }
        synchronized (this.f39962b) {
            this.f39964d = surfaceHolder;
            if (this.f39965e != null) {
                this.f39965e.setDisplay(surfaceHolder);
            }
        }
    }

    public void a(com.kwai.video.ksvodplayerkit.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.w = bVar;
            if (this.f39965e != null && bVar != null) {
                a aVar = this.y;
                if (aVar != null) {
                    aVar.a(bVar);
                } else {
                    this.y = new a(this, bVar);
                }
                this.f39965e.getAspectAwesomeCache().setAwesomeCacheCallback(this.y);
            }
            if (bVar == null) {
                this.y = null;
            }
        }
    }

    public void a(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.z = aVar;
        }
    }

    public void a(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void a(d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.v = cVar;
        }
    }

    public void a(d.InterfaceC0499d interfaceC0499d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0499d) == null) {
            this.t = interfaceC0499d;
        }
    }

    public void a(d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.x = eVar;
        }
    }

    public void a(d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            a(true, fVar);
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, lVar) == null) {
            synchronized (this.f39962b) {
                this.f39969i.f39853e = lVar;
            }
        }
    }

    public void a(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kwaiPlayerDebugInfoView) == null) {
            this.f39961a = kwaiPlayerDebugInfoView;
            if (i.a().m()) {
                this.f39961a.setVisibility(0);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.j = z;
                    this.f39965e.setLooping(z);
                }
            }
        }
    }

    public void a(boolean z, d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, fVar) == null) {
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "releaseAsync,needReportQos:" + z);
            this.r.set(9);
            OnPlayerReleaseListener onPlayerReleaseListener = new OnPlayerReleaseListener(this, fVar, z) { // from class: com.kwai.video.ksvodplayerkit.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.f f39976a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f39977b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f39978c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fVar, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39978c = this;
                    this.f39976a = fVar;
                    this.f39977b = z;
                }

                @Override // com.kwai.player.OnPlayerReleaseListener
                public void onRelease(KwaiPlayerResultQos kwaiPlayerResultQos) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, kwaiPlayerResultQos) == null) {
                        synchronized (this.f39978c.f39962b) {
                            if (this.f39978c.D) {
                                com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayer", "logVideoStatJson already reported!");
                                return;
                            }
                            this.f39978c.D = true;
                            d.f fVar2 = this.f39976a;
                            if (fVar2 != null) {
                                fVar2.a();
                            }
                            if (this.f39977b) {
                                try {
                                    this.f39978c.a(kwaiPlayerResultQos);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            };
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    this.f39965e.setOnPreparedListener(null);
                    this.f39965e.setOnInfoListener(null);
                    this.f39965e.setOnErrorListener(null);
                    this.f39965e.setOnVideoSizeChangedListener(null);
                    this.f39965e.setOnSeekCompleteListener(null);
                    this.f39965e.setOnBufferingUpdateListener(null);
                    this.f39965e.releaseAsync(onPlayerReleaseListener);
                    this.f39965e = null;
                }
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    return this.f39965e.isPlaying();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    return this.f39965e.getCurrentPosition();
                }
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null) {
                    return this.f39965e.getDuration();
                }
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null && !this.f39965e.isPlaying()) {
                    if (this.F == 0) {
                        this.F = System.currentTimeMillis();
                    }
                    if (this.f39961a != null && i.a().m()) {
                        this.f39961a.startMonitor(this.f39965e);
                    }
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "start");
                    this.f39965e.start();
                }
            }
            if (e.a(this.f39967g)) {
                i();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this.f39962b) {
                if (this.f39965e != null && this.f39965e.isPlaying()) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "pause");
                    this.f39965e.pause();
                }
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.r.get() != 9) {
                str = "refreshDataSource failed! last player not finish!";
            } else {
                com.kwai.video.ksvodplayerkit.HttpDns.d dVar = this.A;
                if (dVar != null) {
                    dVar.a(true);
                    if (this.A.f() > 0) {
                        if (this.f39969i.f39856h != null) {
                            str2 = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
                        } else {
                            if (this.f39968h == null) {
                                this.f39968h = new HashMap();
                            }
                            this.f39968h.put("Host", this.A.d());
                            str2 = this.A.b().f39826b;
                        }
                        if (str2 != null && a(str2)) {
                            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "refreshDataSource success!");
                            return true;
                        }
                        com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "refreshDataSource failed! dns url error:" + str2);
                    }
                }
                str = "refreshDataSource failed, dns failed or already try all urls!";
            }
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", str);
            return false;
        }
        return invokeV.booleanValue;
    }

    public IKwaiMediaPlayer h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            IKwaiMediaPlayer iKwaiMediaPlayer = this.f39965e;
            if (iKwaiMediaPlayer != null) {
                return iKwaiMediaPlayer;
            }
            return null;
        }
        return (IKwaiMediaPlayer) invokeV.objValue;
    }
}
