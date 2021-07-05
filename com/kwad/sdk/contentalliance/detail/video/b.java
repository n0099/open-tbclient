package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.contentalliance.a.a, ap.a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ap f34967a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34968b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34969c;

    /* renamed from: d  reason: collision with root package name */
    public String f34970d;

    /* renamed from: e  reason: collision with root package name */
    public long f34971e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f34972f;

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f34973g;

    /* renamed from: h  reason: collision with root package name */
    public Context f34974h;

    /* renamed from: i  reason: collision with root package name */
    public SlidePlayViewPager f34975i;
    public g j;
    public c k;
    public boolean l;
    public AdTemplate m;
    public final int n;
    public f p;
    public c.d q;
    public AtomicBoolean r;
    public com.kwad.sdk.contentalliance.a.c s;
    public List<a> t;
    public List<com.kwad.sdk.core.i.c> u;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1917257839, "Lcom/kwad/sdk/contentalliance/detail/video/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1917257839, "Lcom/kwad/sdk/contentalliance/detail/video/b;");
        }
    }

    public b(KsFragment ksFragment, SlidePlayViewPager slidePlayViewPager, DetailVideoView detailVideoView, AdTemplate adTemplate, int i2) {
        long k;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, slidePlayViewPager, detailVideoView, adTemplate, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = false;
        this.r = new AtomicBoolean(false);
        this.s = new com.kwad.sdk.contentalliance.a.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34979a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34979a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34979a.g();
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "onDestroyView mCurrentPosition" + this.f34979a.n);
                    this.f34979a.q();
                    this.f34979a.f34972f.b(this.f34979a.q);
                    this.f34979a.f34972f.k();
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "onDestroy mCurrentPosition=" + this.f34979a.n);
                    this.f34979a.q();
                    this.f34979a.f34972f.b(this.f34979a.q);
                    this.f34979a.f34972f.b(this.f34979a.p);
                    this.f34979a.v();
                    this.f34979a.f34972f.k();
                }
            }
        };
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.f34973g = ksFragment;
        this.f34974h = ksFragment.getContext();
        this.f34975i = slidePlayViewPager;
        this.m = adTemplate;
        this.n = i2;
        if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f34970d = com.kwad.sdk.core.response.b.a.a(j);
            k = com.kwad.sdk.core.response.b.a.k(j);
        } else {
            PhotoInfo k2 = com.kwad.sdk.core.response.b.c.k(adTemplate);
            this.f34970d = com.kwad.sdk.core.response.b.d.b(k2);
            k = com.kwad.sdk.core.response.b.d.k(k2);
        }
        this.f34971e = k;
        this.j = new g(ksFragment.getContext());
        this.f34972f = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        n();
        this.j = new g(ksFragment.getContext());
        this.f34972f.a(new c.e(this) { // from class: com.kwad.sdk.contentalliance.detail.video.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34976a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34976a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    al.a().b(this.f34976a.m);
                    if (this.f34976a.f34969c && this.f34976a.f34973g.isResumed() && ao.a(this.f34976a.f34968b, 70)) {
                        this.f34976a.f34972f.f();
                    }
                }
            }
        });
        f fVar = new f(this, adTemplate) { // from class: com.kwad.sdk.contentalliance.detail.video.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f34977a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f34978b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34978b = this;
                this.f34977a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i5, i6) == null) {
                    super.a(i5, i6);
                    com.kwad.sdk.core.report.e.b(this.f34977a, i5, i6);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.d();
                    al.a().c(this.f34978b.m);
                }
            }
        };
        this.p = fVar;
        this.f34972f.a(fVar);
        this.f34972f.a(t());
        this.f34968b = (ViewGroup) detailVideoView.getParent().getParent();
    }

    @Nullable
    private com.kwai.video.ksvodplayerkit.d.b a(int i2, int i3) {
        InterceptResult invokeII;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            List<AdTemplate> data = this.f34975i.getData();
            if (data == null || i2 < 0 || i2 >= data.size() || (adTemplate = data.get(i2)) == null) {
                return null;
            }
            String l = com.kwad.sdk.core.response.b.c.l(adTemplate);
            if (ag.a(l)) {
                return null;
            }
            return new com.kwai.video.ksvodplayerkit.d.f(l, String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)), i3);
        }
        return (com.kwai.video.ksvodplayerkit.d.b) invokeII.objValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, this, z) == null) {
            if (z) {
                for (com.kwad.sdk.core.i.c cVar : this.u) {
                    cVar.c_();
                }
                r();
                return;
            }
            for (com.kwad.sdk.core.i.c cVar2 : this.u) {
                cVar2.b();
            }
            s();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.kwad.sdk.core.d.a.a("DetailPlayModule", "createPlayerAndPrepare()");
            this.f34972f.a(new d.a().a(o()).a(this.m.mVideoPlayerStatus).a(new c(this.f34971e)).a());
            al.a().a(this.m);
            this.f34972f.e();
            al.a().d(this.m);
        }
    }

    private String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? com.kwad.sdk.core.config.c.l() ? com.kwad.sdk.core.videocache.c.a.a(this.f34974h.getApplicationContext()).a(this.f34970d) : this.f34970d : (String) invokeV.objValue;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (this.f34967a == null) {
                this.f34967a = new ap(this);
            }
            this.f34967a.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ap apVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (apVar = this.f34967a) == null) {
            return;
        }
        apVar.removeCallbacksAndMessages(null);
        this.f34967a = null;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || this.l) {
            return;
        }
        this.j.a();
        this.l = true;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.j.b();
            this.l = false;
        }
    }

    private c.d t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (this.q == null) {
                this.q = new c.d(this) { // from class: com.kwad.sdk.contentalliance.detail.video.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f34980a;

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
                        this.f34980a = this;
                    }

                    @Override // com.kwad.sdk.core.video.a.c.d
                    public boolean a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
                        InterceptResult invokeLII;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, cVar, i2, i3)) == null) {
                            if (this.f34980a.f34969c && i2 == 10209 && com.kwad.sdk.core.config.c.ag() && 2 == cVar.o()) {
                                this.f34980a.u();
                                return false;
                            }
                            return false;
                        }
                        return invokeLII.booleanValue;
                    }
                };
            }
            return this.q;
        }
        return (c.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || this.r.get()) {
            return;
        }
        this.r.set(true);
        for (int i2 = 2; i2 < 5; i2++) {
            int i3 = this.n + i2;
            com.kwai.video.ksvodplayerkit.d.b a2 = a(i3, 1000 - i3);
            if (a2 != null) {
                com.kwai.video.ksvodplayerkit.d.c.a().a(a2);
                com.kwad.sdk.core.d.a.a("DetailPlayModule", "在当前页" + this.n + "添加预加载任务preLoadPosition=" + i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kwad.sdk.core.video.a.c a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && (a2 = this.f34972f.a()) != null && a2.o() == 2) {
            com.kwai.video.ksvodplayerkit.d.c.a().b();
        }
    }

    public void a(float f2) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (aVar = this.f34972f) == null) {
            return;
        }
        aVar.a(f2);
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f34972f.a(j);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    m.a();
                    o = false;
                    return;
                }
                return;
            }
            KsFragment ksFragment = this.f34973g;
            if (ksFragment == null) {
                return;
            }
            boolean z = (ksFragment.isResumed() && !this.f34973g.isAllFragmentIsHidden() && this.f34973g.isVisible()) ? false : true;
            if (!ao.a((View) this.f34968b, 50, false) || z) {
                if (!o) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "sendEmptyMessageDelayed(MSG_UPDATE_SESSION_ID)");
                    this.f34967a.sendEmptyMessageDelayed(2, 300000L);
                    o = true;
                }
                a(false);
                if (this.f34972f.i()) {
                    g();
                }
            } else {
                if (o) {
                    com.kwad.sdk.core.d.a.a("DetailPlayModule", "removeMessages(MSG_UPDATE_SESSION_ID)");
                    this.f34967a.removeMessages(2);
                    o = false;
                }
                if (this.k == null) {
                    c cVar = new c(this.f34971e, System.currentTimeMillis());
                    this.k = cVar;
                    this.f34972f.a(cVar);
                }
                a(true);
                if (!this.f34972f.i()) {
                    e();
                }
            }
            this.f34967a.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.t.add(aVar);
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f34972f.a(eVar);
        }
    }

    public void a(com.kwad.sdk.core.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.u.add(cVar);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34972f.i() : invokeV.booleanValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t.remove(aVar);
        }
    }

    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f34972f.b(eVar);
        }
    }

    public void b(com.kwad.sdk.core.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.u.remove(cVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34972f.d() : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34972f.b() : invokeV.intValue;
    }

    public com.kwad.sdk.contentalliance.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.s : (com.kwad.sdk.contentalliance.a.c) invokeV.objValue;
    }

    public void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f34969c && this.f34973g.isResumed()) {
            loop0: while (true) {
                for (a aVar : this.t) {
                    z = z || aVar.a();
                }
            }
            if (z) {
                return;
            }
            this.f34972f.h();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f34972f.c(new d.a().a(o()).a(this.m.mVideoPlayerStatus).a(new c(this.f34971e)).a());
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f34969c) {
            this.f34972f.j();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f34972f.g();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            q();
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f34972f;
            if (aVar != null) {
                aVar.p();
                this.f34972f.k();
            }
            this.l = false;
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            com.kwad.sdk.core.d.a.a("DetailPlayModule", "becomesAttachedOnPageSelected mCurrentPosition=" + this.n);
            p();
            this.f34969c = true;
            if (this.f34972f.a() == null) {
                n();
            }
            this.f34972f.f();
            r();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            com.kwad.sdk.core.d.a.a("DetailPlayModule", "becomesDetachedOnPageSelected mCurrentPosition=" + this.n);
            q();
            this.f34969c = false;
            this.k = null;
            this.f34972f.k();
            s();
            v();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }
}
