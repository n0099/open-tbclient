package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
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
import com.kwad.sdk.utils.al;
import com.kwai.video.ksvodplayerkit.a.c;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.ksvodplayerkit.j;
import com.kwai.video.ksvodplayerkit.k;
import com.kwai.video.ksvodplayerkit.l;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean k;
    public static final Queue<d> l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f36611a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36612b;

    /* renamed from: c  reason: collision with root package name */
    public String f36613c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f36614d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f36615e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36616f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36617g;

    /* renamed from: h  reason: collision with root package name */
    public int f36618h;

    /* renamed from: i  reason: collision with root package name */
    public int f36619i;
    public boolean j;
    public boolean m;
    public com.kwad.sdk.contentalliance.detail.video.d n;

    /* loaded from: classes7.dex */
    public static class a implements com.kwai.video.ksvodplayerkit.b, d.a, d.b, d.c, d.InterfaceC0499d, d.e, d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f36621a;

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
            this.f36621a = new WeakReference<>(dVar);
        }

        private d c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f36621a.get() : (d) invokeV.objValue;
        }

        @Override // com.kwai.video.ksvodplayerkit.d.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.a
        public void a(int i2) {
            d c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (c2 = c()) == null) {
                return;
            }
            c2.a(i2);
        }

        @Override // com.kwai.video.ksvodplayerkit.d.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onEvent, what: " + i2);
                d c2 = c();
                if (c2 != null) {
                    if (i2 == 10100) {
                        c2.d();
                    } else if (i2 == 10101) {
                        c2.c();
                    } else {
                        if (i2 == 10209) {
                            c2.u();
                        }
                        c2.c(i2, i3);
                    }
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.e
        public void a(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
                d c2 = c();
                if (c2 != null) {
                    c2.a(i2, i3);
                    c2.f36618h = i4;
                    c2.f36619i = i5;
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void a(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.InterfaceC0499d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPrepared");
                d c2 = c();
                if (c2 != null) {
                    c2.b();
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.b
        public void b(int i2, int i3) {
            d c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || (c2 = c()) == null) {
                return;
            }
            c2.j = false;
            c2.b(i2, i3);
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void b(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (al.a().b()) {
                    d c2 = c();
                    if (c2 != null) {
                        c2.f36611a.a((com.kwai.video.ksvodplayerkit.b) null);
                    }
                } else if (cVar != null) {
                    long j = cVar.f39906b;
                    if (j > 0) {
                        long j2 = cVar.l;
                        if (j2 != 0) {
                            al.a().a((j - cVar.f39905a) / j2);
                        }
                    }
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void c(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void d(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void e(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
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
        Object obj = new Object();
        this.f36615e = obj;
        this.j = false;
        this.m = true;
        synchronized (obj) {
            this.f36611a = new k(context.getApplicationContext());
        }
        a(context);
        this.f36612b = new a(this);
        s();
    }

    public static synchronized void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (d.class) {
                com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
                if (!k) {
                    j.a(context);
                    if (com.kwad.sdk.core.config.c.F()) {
                        com.kwai.video.ksvodplayerkit.a.c.a(new c.a() { // from class: com.kwad.sdk.core.video.a.d.1
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

                            @Override // com.kwai.video.ksvodplayerkit.a.c.a
                            public void a(String str, String str2) {
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

    public static synchronized boolean p() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (d.class) {
                z = k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void q() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (mediaDataSource = this.f36614d) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f36614d = null;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.j) {
            return;
        }
        int a2 = this.f36611a.a();
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "realPrepare: ret: " + a2);
        this.j = true;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f36611a.a((d.InterfaceC0499d) this.f36612b);
            this.f36611a.a((d.a) this.f36612b);
            this.f36611a.a((d.c) this.f36612b);
            this.f36611a.a((d.e) this.f36612b);
            this.f36611a.a((d.b) this.f36612b);
            if (com.kwad.sdk.core.config.c.U()) {
                this.f36611a.a((com.kwai.video.ksvodplayerkit.b) this.f36612b);
            }
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f36611a.a((d.InterfaceC0499d) null);
            this.f36611a.a((d.a) null);
            this.f36611a.a((d.c) null);
            this.f36611a.a((d.e) null);
            this.f36611a.a((d.b) null);
            this.f36611a.a((com.kwai.video.ksvodplayerkit.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Queue<d> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
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
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i3);
            int i4 = i3 + 1;
            if (i4 < l.size()) {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
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
                    com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f36611a.a(f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f36611a.a(f2, f3);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f36611a.a((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.f36611a.a(surface);
        }
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
        }
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || this.f36611a == null || cVar == null) {
            return;
        }
        l lVar = new l();
        lVar.f40017c = String.valueOf(cVar.f34981a);
        lVar.f40018d = cVar.f34982b;
        this.f36611a.a(lVar);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.n = dVar;
            a(dVar.f34985c);
            a(dVar.f34983a, (Map<String, String>) null);
        }
    }

    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, map) == null) {
            this.f36613c = str;
            this.f36611a.a(str, map);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f36617g = z;
            this.f36611a.a(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.m) {
                r();
                return true;
            }
            if (!l.contains(this)) {
                l.offer(this);
            }
            if (l.size() == 1) {
                r();
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "prepareAsync first");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "start");
            r();
            this.f36611a.e();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f36611a.g();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36611a.f().getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f36611a.f().getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                return this.f36611a.b();
            } catch (IllegalStateException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                return this.f36611a.c();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                return this.f36611a.d();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean remove = l.remove(this);
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
            this.f36616f = true;
            this.f36611a.a(new d.f(this) { // from class: com.kwad.sdk.core.video.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f36620a;

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
                    this.f36620a = this;
                }

                @Override // com.kwai.video.ksvodplayerkit.d.f
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
                    }
                }
            });
            q();
            a();
            t();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.j = false;
            try {
                this.f36611a.f().reset();
            } catch (IllegalStateException unused) {
            }
            q();
            a();
            s();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
