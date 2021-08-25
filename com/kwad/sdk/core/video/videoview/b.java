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
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.am;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class b extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, d {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72125a;

    /* renamed from: b  reason: collision with root package name */
    public Context f72126b;

    /* renamed from: c  reason: collision with root package name */
    public AudioManager f72127c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f72128d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f72129e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.a f72130f;

    /* renamed from: g  reason: collision with root package name */
    public c f72131g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceTexture f72132h;

    /* renamed from: i  reason: collision with root package name */
    public Surface f72133i;

    /* renamed from: j  reason: collision with root package name */
    public String f72134j;
    public Map<String, String> k;
    public int l;
    public boolean m;
    public long n;
    public boolean p;
    public boolean q;
    public com.kwad.sdk.contentalliance.detail.video.c r;
    public com.kwad.sdk.contentalliance.detail.video.b s;
    public c.e t;
    public c.h u;
    public c.b v;
    public c.InterfaceC1995c w;
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
        this.f72125a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.t = new c.e(this) { // from class: com.kwad.sdk.core.video.videoview.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72135a;

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
                this.f72135a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f72135a.f72125a = 2;
                    this.f72135a.f72131g.a(this.f72135a.f72125a);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.f();
                    if (this.f72135a.m) {
                        cVar.a((int) am.a(this.f72135a.f72126b, this.f72135a.f72134j));
                    }
                    if (this.f72135a.n != 0) {
                        cVar.a((int) this.f72135a.n);
                    }
                }
            }
        };
        this.u = new c.h(this) { // from class: com.kwad.sdk.core.video.videoview.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72136a;

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
                this.f72136a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, cVar, i4, i5) == null) {
                    if (!this.f72136a.q || i5 <= i4) {
                        this.f72136a.f72130f.a(i4, i5);
                        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i4 + "， height：" + i5);
                    }
                }
            }
        };
        this.v = new c.b(this) { // from class: com.kwad.sdk.core.video.videoview.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72137a;

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
                this.f72137a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f72137a.f72125a = 9;
                    this.f72137a.f72131g.a(this.f72137a.f72125a);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    this.f72137a.f72129e.setKeepScreenOn(false);
                }
            }
        };
        this.w = new c.InterfaceC1995c(this) { // from class: com.kwad.sdk.core.video.videoview.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72138a;

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
                this.f72138a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC1995c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i4, i5)) == null) {
                    if (i4 != -38) {
                        this.f72138a.f72125a = -1;
                        this.f72138a.f72131g.a(i4, i5);
                        this.f72138a.f72131g.a(this.f72138a.f72125a);
                        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i4 + ", extra: " + i5);
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
            public final /* synthetic */ b f72139a;

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
                this.f72139a = this;
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
                        this.f72139a.f72125a = 4;
                        this.f72139a.f72131g.a(this.f72139a.f72125a);
                        str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                    } else if (i4 == 701) {
                        if (this.f72139a.f72125a == 5 || this.f72139a.f72125a == 7) {
                            this.f72139a.f72125a = 7;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                        } else {
                            this.f72139a.f72125a = 6;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                        }
                        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str2);
                        this.f72139a.f72131g.a(this.f72139a.f72125a);
                        return true;
                    } else if (i4 == 702) {
                        if (this.f72139a.f72125a == 6) {
                            this.f72139a.f72125a = 4;
                            this.f72139a.f72131g.a(this.f72139a.f72125a);
                            com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (this.f72139a.f72125a != 7) {
                            return true;
                        }
                        this.f72139a.f72125a = 5;
                        this.f72139a.f72131g.a(this.f72139a.f72125a);
                        str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                    } else {
                        if (i4 == 10001) {
                            if (this.f72139a.f72130f == null) {
                                return true;
                            }
                            this.f72139a.f72130f.setRotation(i5);
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
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str);
                    return true;
                }
                return invokeLII.booleanValue;
            }
        };
        this.y = new c.a(this) { // from class: com.kwad.sdk.core.video.videoview.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72140a;

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
                this.f72140a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, cVar, i4) == null) {
                    this.f72140a.l = i4;
                }
            }
        };
        this.z = new BroadcastReceiver(this) { // from class: com.kwad.sdk.core.video.videoview.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72141a;

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
                this.f72141a = this;
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
        this.f72126b = context;
        q();
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f72129e = new FrameLayout(this.f72126b);
            addView(this.f72129e, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.f72128d == null) {
            com.kwad.sdk.core.video.a.c a2 = com.kwad.sdk.contentalliance.detail.video.a.a(this.f72126b, false);
            this.f72128d = a2;
            a2.b(3);
            if (this.p) {
                return;
            }
            this.f72128d.a(0.0f, 0.0f);
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.f72130f == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.f72126b);
            this.f72130f = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i2) {
        com.kwad.sdk.contentalliance.detail.video.c cVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, this, i2) == null) || (cVar = this.r) == null || (videoPlayerStatus = cVar.f71246c) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.f72129e.removeView(this.f72130f);
            this.f72129e.addView(this.f72130f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f72129e.setKeepScreenOn(true);
            this.f72128d.a(this.t);
            this.f72128d.a(this.u);
            this.f72128d.a(this.v);
            this.f72128d.a(this.w);
            this.f72128d.a(this.x);
            this.f72128d.a(this.y);
            try {
                if (this.r != null && this.s != null) {
                    this.r.f71247d = this.s;
                }
                this.f72128d.a(this.r);
                if (this.f72133i == null) {
                    this.f72133i = new Surface(this.f72132h);
                }
                this.f72128d.a(this.f72133i);
                if (this.f72128d.e()) {
                    this.f72125a = 1;
                    this.f72131g.a(1);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "STATE_PREPARING");
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.d.a.a("KSVideoPlayerViewView", "打开播放器发生错误", e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void a() {
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f72125a != 0) {
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
                return;
            }
            r();
            s();
            t();
            com.kwad.sdk.contentalliance.detail.video.c cVar = this.r;
            if (cVar == null || (videoPlayerStatus = cVar.f71246c) == null) {
                return;
            }
            setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
        }
    }

    public void a(int i2) {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (cVar = this.f72128d) == null) {
            return;
        }
        cVar.a(i2);
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, map) == null) {
            this.r = cVar;
            this.f72134j = cVar.f71244a;
            this.k = map;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f72125a;
            if (i2 == 5) {
                this.f72128d.f();
                this.f72125a = 4;
                this.f72131g.a(4);
                setPlayType(2);
                str = "STATE_PLAYING";
            } else if (i2 == 7) {
                this.f72128d.f();
                this.f72125a = 6;
                this.f72131g.a(6);
                str = "STATE_BUFFERING_PLAYING";
            } else if (i2 == 9 || i2 == -1) {
                this.f72128d.m();
                u();
                setPlayType(3);
                return;
            } else {
                str = "KSVideoPlayer在状态为 " + this.f72125a + " 时不能调用restart()方法.";
            }
            com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f72125a == 4) {
                this.f72128d.g();
                this.f72125a = 5;
                this.f72131g.a(5);
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "STATE_PAUSED");
            }
            if (this.f72125a == 6) {
                this.f72128d.g();
                this.f72125a = 7;
                this.f72131g.a(7);
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72125a == 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72125a == 6 : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72125a == 7 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72125a == 4 : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f72131g : (c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.kwad.sdk.core.video.a.c cVar = this.f72128d;
            if (cVar != null) {
                return cVar.j();
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
            com.kwad.sdk.core.video.a.c cVar = this.f72128d;
            if (cVar != null) {
                return cVar.k();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getMaxVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AudioManager audioManager = this.f72127c;
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
            AudioManager audioManager = this.f72127c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f72125a == 5 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f72125a == 9 : invokeV.booleanValue;
    }

    public void j() {
        com.kwad.sdk.core.video.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (cVar = this.f72128d) == null || this.v == null) {
            return;
        }
        cVar.l();
        this.v.a(this.f72128d);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            AudioManager audioManager = this.f72127c;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
                this.f72127c = null;
            }
            com.kwad.sdk.core.video.a.c cVar = this.f72128d;
            if (cVar != null) {
                cVar.l();
                this.f72128d = null;
            }
            this.f72129e.removeView(this.f72130f);
            Surface surface = this.f72133i;
            if (surface != null) {
                surface.release();
                this.f72133i = null;
            }
            SurfaceTexture surfaceTexture = this.f72132h;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f72132h = null;
            }
            this.f72125a = 0;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void l() {
        Context context;
        String str;
        long currentPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.m) {
                if (g() || e() || f() || h()) {
                    context = this.f72126b;
                    str = this.f72134j;
                    currentPosition = getCurrentPosition();
                } else if (i()) {
                    context = this.f72126b;
                    str = this.f72134j;
                    currentPosition = 0;
                }
                am.a(context, str, currentPosition);
            }
            k();
            c cVar = this.f72131g;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048596, this, surfaceTexture, i2, i3) == null) {
            SurfaceTexture surfaceTexture2 = this.f72132h;
            if (surfaceTexture2 != null) {
                this.f72130f.setSurfaceTexture(surfaceTexture2);
                return;
            }
            this.f72132h = surfaceTexture;
            u();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, surfaceTexture, i2, i3) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, surfaceTexture) == null) {
        }
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.f72129e.removeView(this.f72131g);
            this.f72131g = cVar;
            cVar.d();
            this.f72129e.addView(this.f72131g, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.s = bVar;
        }
    }

    public void setPortraitFullscreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.q = z;
        }
    }

    public void setVideoSoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.p = z;
            com.kwad.sdk.core.video.a.c cVar = this.f72128d;
            if (cVar != null) {
                float f2 = z ? 1.0f : 0.0f;
                cVar.a(f2, f2);
            }
        }
    }

    public void setVolume(int i2) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (audioManager = this.f72127c) == null) {
            return;
        }
        audioManager.setStreamVolume(3, i2, 0);
    }
}
