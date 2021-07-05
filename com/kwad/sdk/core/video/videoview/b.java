package com.kwad.sdk.core.video.videoview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
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
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b extends AdBaseFrameLayout implements TextureView.SurfaceTextureListener, d {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36636a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36637b;

    /* renamed from: c  reason: collision with root package name */
    public AudioManager f36638c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f36639d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f36640e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.a f36641f;

    /* renamed from: g  reason: collision with root package name */
    public c f36642g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceTexture f36643h;

    /* renamed from: i  reason: collision with root package name */
    public Surface f36644i;
    public String j;
    public Map<String, String> k;
    public int l;
    public boolean m;
    public long n;
    public boolean p;
    public boolean q;
    public com.kwad.sdk.contentalliance.detail.video.d r;
    public com.kwad.sdk.contentalliance.detail.video.c s;
    public c.e t;
    public c.h u;
    public c.b v;
    public c.InterfaceC0438c w;
    public c.d x;
    public c.a y;
    public BroadcastReceiver z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(800676657, "Lcom/kwad/sdk/core/video/videoview/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(800676657, "Lcom/kwad/sdk/core/video/videoview/b;");
                return;
            }
        }
        o = new AtomicBoolean(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36636a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.t = new c.e(this) { // from class: com.kwad.sdk.core.video.videoview.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36645a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36645a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f36645a.f36636a = 2;
                    this.f36645a.f36642g.a(this.f36645a.f36636a);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.f();
                    if (this.f36645a.m) {
                        cVar.a((int) ae.a(this.f36645a.f36637b, this.f36645a.j));
                    }
                    if (this.f36645a.n != 0) {
                        cVar.a((int) this.f36645a.n);
                    }
                }
            }
        };
        this.u = new c.h(this) { // from class: com.kwad.sdk.core.video.videoview.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36646a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36646a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    if (!this.f36646a.q || i5 <= i4) {
                        this.f36646a.f36641f.a(i4, i5);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                    }
                }
            }
        };
        this.v = new c.b(this) { // from class: com.kwad.sdk.core.video.videoview.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36647a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36647a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f36647a.f36636a = 9;
                    this.f36647a.f36642g.a(this.f36647a.f36636a);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    this.f36647a.f36640e.setKeepScreenOn(false);
                }
            }
        };
        this.w = new c.InterfaceC0438c(this) { // from class: com.kwad.sdk.core.video.videoview.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36648a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36648a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0438c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.f36648a.f36636a = -1;
                        this.f36648a.f36642g.a(i4, i5);
                        this.f36648a.f36642g.a(this.f36648a.f36636a);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.x = new c.d(this) { // from class: com.kwad.sdk.core.video.videoview.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36649a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36649a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.d
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                StringBuilder sb;
                String str;
                String str2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 == 3) {
                        this.f36649a.f36636a = 4;
                        this.f36649a.f36642g.a(this.f36649a.f36636a);
                        str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                    } else if (i4 == 701) {
                        if (this.f36649a.f36636a == 5 || this.f36649a.f36636a == 7) {
                            this.f36649a.f36636a = 7;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                        } else {
                            this.f36649a.f36636a = 6;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                        }
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str2);
                        this.f36649a.f36642g.a(this.f36649a.f36636a);
                        return true;
                    } else if (i4 == 702) {
                        if (this.f36649a.f36636a == 6) {
                            this.f36649a.f36636a = 4;
                            this.f36649a.f36642g.a(this.f36649a.f36636a);
                            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (this.f36649a.f36636a != 7) {
                            return true;
                        }
                        this.f36649a.f36636a = 5;
                        this.f36649a.f36642g.a(this.f36649a.f36636a);
                        str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                    } else {
                        if (i4 == 10001) {
                            if (this.f36649a.f36641f == null) {
                                return true;
                            }
                            this.f36649a.f36641f.setRotation(i5);
                            sb = new StringBuilder();
                            sb.append("视频旋转角度：");
                            sb.append(i5);
                        } else if (i4 == 801) {
                            str = "视频不能seekTo，为直播视频";
                        } else {
                            sb = new StringBuilder();
                            sb.append("onInfo ——> what：");
                            sb.append(i4);
                        }
                        str = sb.toString();
                    }
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.y = new c.a(this) { // from class: com.kwad.sdk.core.video.videoview.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36650a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36650a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.f36650a.l = i4;
                }
            }
        };
        this.z = new BroadcastReceiver(this) { // from class: com.kwad.sdk.core.video.videoview.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36651a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36651a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                NetworkInfo c2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) || (c2 = com.ksad.download.d.b.c(context2)) == null) {
                    return;
                }
                c2.isConnected();
            }
        };
        this.f36637b = context;
        l();
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f36640e = new FrameLayout(this.f36637b);
            addView(this.f36640e, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.f36639d == null) {
            com.kwad.sdk.core.video.a.c a2 = com.kwad.sdk.contentalliance.detail.video.a.a(this.f36637b, false);
            this.f36639d = a2;
            a2.b(3);
            if (this.p) {
                return;
            }
            this.f36639d.a(0.0f, 0.0f);
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.f36641f == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.f36637b);
            this.f36641f = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.f36640e.removeView(this.f36641f);
            this.f36640e.addView(this.f36641f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.f36640e.setKeepScreenOn(true);
            this.f36639d.a(this.t);
            this.f36639d.a(this.u);
            this.f36639d.a(this.v);
            this.f36639d.a(this.w);
            this.f36639d.a(this.x);
            this.f36639d.a(this.y);
            try {
                if (this.r != null && this.s != null) {
                    this.r.f34985c = this.s;
                }
                this.f36639d.a(this.r);
                if (this.f36644i == null) {
                    this.f36644i = new Surface(this.f36643h);
                }
                this.f36639d.a(this.f36644i);
                if (this.f36639d.e()) {
                    this.f36636a = 1;
                    this.f36642g.a(1);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PREPARING");
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.d.a.a("KSVideoPlayerViewView", "打开播放器发生错误", e2);
            }
        }
    }

    private void setPlayType(int i2) {
        com.kwad.sdk.contentalliance.detail.video.d dVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65555, this, i2) == null) || (dVar = this.r) == null || (videoPlayerStatus = dVar.f34984b) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void a() {
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f36636a != 0) {
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
                return;
            }
            m();
            n();
            o();
            com.kwad.sdk.contentalliance.detail.video.d dVar = this.r;
            if (dVar == null || (videoPlayerStatus = dVar.f34984b) == null) {
                return;
            }
            setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
        }
    }

    public void a(int i2) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (cVar = this.f36639d) == null) {
            return;
        }
        cVar.a(i2);
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, map) == null) {
            this.r = dVar;
            this.j = dVar.f34983a;
            this.k = map;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f36636a;
            if (i2 == 5) {
                this.f36639d.f();
                this.f36636a = 4;
                this.f36642g.a(4);
                setPlayType(2);
                str = "STATE_PLAYING";
            } else if (i2 == 7) {
                this.f36639d.f();
                this.f36636a = 6;
                this.f36642g.a(6);
                str = "STATE_BUFFERING_PLAYING";
            } else if (i2 == 9 || i2 == -1) {
                this.f36639d.n();
                p();
                setPlayType(3);
                return;
            } else {
                str = "KSVideoPlayer在状态为 " + this.f36636a + " 时不能调用restart()方法.";
            }
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f36636a == 4) {
                this.f36639d.g();
                this.f36636a = 5;
                this.f36642g.a(5);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PAUSED");
            }
            if (this.f36636a == 6) {
                this.f36639d.g();
                this.f36636a = 7;
                this.f36642g.a(7);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36636a == 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36636a == 6 : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36636a == 7 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36636a == 4 : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : invokeV.intValue;
    }

    public c getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f36642g : (c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f36639d;
            if (cVar != null) {
                return cVar.k();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f36639d;
            if (cVar != null) {
                return cVar.l();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getMaxVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AudioManager audioManager = this.f36638c;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AudioManager audioManager = this.f36638c;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f36636a == 5 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36636a == 9 : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AudioManager audioManager = this.f36638c;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
                this.f36638c = null;
            }
            com.kwad.sdk.core.video.a.c cVar = this.f36639d;
            if (cVar != null) {
                cVar.m();
                this.f36639d = null;
            }
            this.f36640e.removeView(this.f36641f);
            Surface surface = this.f36644i;
            if (surface != null) {
                surface.release();
                this.f36644i = null;
            }
            SurfaceTexture surfaceTexture = this.f36643h;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f36643h = null;
            }
            this.f36636a = 0;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void k() {
        Context context;
        String str;
        long currentPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.m) {
                if (g() || e() || f() || h()) {
                    context = this.f36637b;
                    str = this.j;
                    currentPosition = getCurrentPosition();
                } else if (i()) {
                    context = this.f36637b;
                    str = this.j;
                    currentPosition = 0;
                }
                ae.a(context, str, currentPosition);
            }
            j();
            c cVar = this.f36642g;
            if (cVar != null) {
                cVar.c();
            }
            Runtime.getRuntime().gc();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, surfaceTexture, i2, i3) == null) {
            SurfaceTexture surfaceTexture2 = this.f36643h;
            if (surfaceTexture2 != null) {
                this.f36641f.setSurfaceTexture(surfaceTexture2);
                return;
            }
            this.f36643h = surfaceTexture;
            p();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048597, this, surfaceTexture, i2, i3) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, surfaceTexture) == null) {
        }
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.f36640e.removeView(this.f36642g);
            this.f36642g = cVar;
            cVar.c();
            this.f36640e.addView(this.f36642g, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setPortraitFullscreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.q = z;
        }
    }

    public void setVideoSoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
            com.kwad.sdk.core.video.a.c cVar = this.f36639d;
            if (cVar != null) {
                float f2 = z ? 1.0f : 0.0f;
                cVar.a(f2, f2);
            }
        }
    }

    public void setVolume(int i2) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (audioManager = this.f36638c) == null) {
            return;
        }
        audioManager.setStreamVolume(3, i2, 0);
    }
}
