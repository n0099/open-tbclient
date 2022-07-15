package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.f.kwai.d;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.p;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l extends com.kwad.components.core.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    @Nullable
    public com.kwad.components.ad.reward.g.a.a B;
    @Nullable
    public com.kwad.components.ad.reward.g.kwai.a C;
    public int D;
    public long E;
    public long F;
    public boolean G;
    public boolean H;
    public m I;
    public Set<com.kwad.components.ad.reward.c.f> N;
    @Nullable
    public com.kwad.components.ad.reward.e.c O;
    @Nullable
    public com.kwad.components.core.webview.b.a.a P;
    @Nullable
    public e.a Q;
    @Nullable
    public e.b R;
    public boolean S;
    public boolean T;
    @Nullable
    public PlayableSource U;
    public boolean V;
    public Handler W;
    public int X;
    public boolean Y;
    public boolean Z;
    public long a;
    public boolean aa;
    public boolean ab;
    @Nullable
    public com.kwad.components.ad.reward.f.kwai.d ac;
    @Nullable
    public com.kwad.components.ad.reward.f.kwai.d ad;
    @NonNull
    public com.kwad.components.ad.reward.c.a b;
    @NonNull
    public com.kwad.components.ad.reward.c.c c;
    @NonNull
    public KsVideoPlayConfig d;
    @Nullable
    public JSONObject e;
    public int f;
    @NonNull
    public AdTemplate g;
    @NonNull
    public AdBaseFrameLayout h;
    public DetailVideoView i;
    @NonNull
    public com.kwad.components.ad.reward.h.a j;
    @Nullable
    public com.kwad.components.core.c.a.b k;
    @Nullable
    public com.kwad.components.core.playable.a l;
    @NonNull
    public RewardActionBarControl m;
    @Nullable
    public com.kwad.components.ad.h.b n;
    @Nullable
    public com.kwad.components.ad.h.b o;
    @Nullable
    public com.kwad.components.ad.h.a p;
    @Nullable
    public i q;
    public Set<com.kwad.components.ad.reward.c.e> r;
    public Set<com.kwad.components.ad.reward.c.d> s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public List<Integer> y;
    public boolean z;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.N = new HashSet();
        this.r = new HashSet();
        this.s = new HashSet();
        this.S = false;
        this.u = false;
        this.T = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = new ArrayList();
        this.z = false;
        this.U = null;
        this.V = false;
        this.W = new Handler(Looper.getMainLooper());
        this.A = false;
        this.X = 2;
        this.Y = false;
        this.Z = false;
        this.aa = false;
        this.ab = false;
    }

    public static long a(long j, AdInfo adInfo) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, adInfo)) == null) ? Math.min(com.kwad.sdk.core.response.a.a.r(adInfo), j) : invokeJL.longValue;
    }

    @Nullable
    public static com.kwad.components.ad.reward.b.b a(List<com.kwad.components.ad.reward.b.b> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, list, j)) == null) {
            if (j >= 0 && list != null) {
                for (com.kwad.components.ad.reward.b.b bVar : list) {
                    if (com.kwad.sdk.core.response.a.d.t(bVar.b()) == j) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (com.kwad.components.ad.reward.b.b) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, fVar) == null) {
            if (fVar == null) {
                fVar = new com.kwad.sdk.core.report.f();
            }
            fVar.a(i);
            fVar.a(this.h.getTouchCoords());
            com.kwad.sdk.core.report.a.a(this.g, fVar.a(), this.e);
            this.b.a();
        }
    }

    public static void a(l lVar, Activity activity, AdTemplate adTemplate, p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, lVar, activity, adTemplate, bVar) == null) {
            com.kwad.components.ad.reward.f.kwai.d p = lVar.p();
            if (p != null) {
                com.kwad.components.ad.reward.f.kwai.d.a(p, lVar.L, lVar.j.i(), bVar, new d.a(activity, adTemplate, bVar) { // from class: com.kwad.components.ad.reward.l.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity a;
                    public final /* synthetic */ AdTemplate b;
                    public final /* synthetic */ p.b c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {activity, adTemplate, bVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = activity;
                        this.b = adTemplate;
                        this.c = bVar;
                    }

                    @Override // com.kwad.components.ad.reward.f.kwai.d.a
                    public final boolean a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            p.a(this.a, this.b, this.c);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            } else {
                p.a(activity, adTemplate, bVar);
            }
        }
    }

    public static void a(l lVar, m.c cVar, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, lVar, cVar, aVar) == null) {
            com.kwad.components.ad.reward.f.kwai.d o = lVar.o();
            if (o != null) {
                com.kwad.components.ad.reward.f.kwai.d.a(o, lVar.L, lVar.j.i(), aVar, new d.a(lVar, cVar, aVar) { // from class: com.kwad.components.ad.reward.l.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ l a;
                    public final /* synthetic */ m.c b;
                    public final /* synthetic */ m.a c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lVar, cVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = lVar;
                        this.b = cVar;
                        this.c = aVar;
                    }

                    @Override // com.kwad.components.ad.reward.f.kwai.d.a
                    public final boolean a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            l.c(this.a, this.b, this.c);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            } else {
                c(lVar, cVar, aVar);
            }
        }
    }

    public static boolean a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lVar)) == null) {
            boolean z = false;
            if (com.kwad.sdk.core.config.d.C()) {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(lVar.g);
                boolean z2 = (com.kwad.sdk.core.response.a.a.aV(i) || (com.kwad.sdk.core.response.a.a.ar(i) && com.kwad.components.ad.reward.kwai.b.i()) || com.kwad.sdk.core.response.a.d.v(lVar.g)) ? false : true;
                lVar.u = z2 && !lVar.ab;
                if (z2 && !lVar.ab) {
                    z = true;
                }
                lVar.c(z);
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(com.kwad.sdk.core.response.a.d.i(adTemplate))) : invokeL.booleanValue;
    }

    public static boolean b(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lVar)) == null) {
            boolean z = false;
            if (com.kwad.sdk.core.config.d.C()) {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(lVar.g);
                boolean z2 = com.kwad.components.ad.reward.kwai.b.c(i) || !(com.kwad.components.ad.reward.kwai.b.b(i) || com.kwad.sdk.core.response.a.d.w(lVar.g) || com.kwad.sdk.core.response.a.a.aV(i));
                if (z2 && !lVar.ab) {
                    z = true;
                }
                lVar.u = z;
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.q(adTemplate) : invokeL.booleanValue;
    }

    public static void c(l lVar, m.c cVar, m.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, lVar, cVar, aVar) == null) || d(lVar)) {
            return;
        }
        m.a(lVar.L, lVar.g, cVar, aVar);
    }

    public static boolean c(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, lVar)) == null) {
            if (com.kwad.sdk.core.config.d.C() && !lVar.aa) {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(lVar.g);
                boolean z = com.kwad.components.ad.reward.kwai.b.c(i) || !(com.kwad.components.ad.reward.kwai.b.b(i) || com.kwad.sdk.core.response.a.a.aV(i) || (com.kwad.sdk.core.response.a.a.ar(i) && com.kwad.components.ad.reward.kwai.b.i()) || com.kwad.sdk.core.response.a.d.w(lVar.g) || com.kwad.sdk.core.response.a.a.b(lVar.g));
                return com.kwad.sdk.core.response.a.b.a(lVar.M, lVar.g) ? z : (a(lVar.g) || b(lVar.g) || !z) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) ? a(adTemplate) || b(adTemplate) : invokeL.booleanValue;
    }

    public static boolean d(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, lVar)) == null) {
            m mVar = lVar.I;
            return mVar != null && mVar.a();
        }
        return invokeL.booleanValue;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.J.clear();
            this.N.clear();
            this.s.clear();
            com.kwad.components.core.c.a.b bVar = this.k;
            if (bVar != null) {
                bVar.i();
            }
            com.kwad.components.ad.h.b bVar2 = this.n;
            if (bVar2 != null) {
                bVar2.h();
            }
            i iVar = this.q;
            if (iVar != null) {
                iVar.h();
            }
            Set<com.kwad.components.ad.reward.c.e> set = this.r;
            if (set != null) {
                set.clear();
            }
        }
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            for (com.kwad.components.ad.reward.c.f fVar : this.N) {
                fVar.d_();
            }
        }
    }

    @Override // com.kwad.components.core.g.a, com.kwad.sdk.mvp.a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q();
            com.kwad.components.ad.reward.h.a aVar = this.j;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.X = i;
        }
    }

    public final void a(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            for (com.kwad.components.ad.reward.c.e eVar : this.r) {
                eVar.a();
            }
        }
    }

    public final void a(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, context, i, i2) == null) {
            b(context, i, i2);
        }
    }

    public final void a(Context context, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            a(context, 40, 1, j, false, null);
        }
    }

    public final void a(Context context, int i, int i2, long j, boolean z, com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z), fVar}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(context).a(this.g).a(this.k).a(false).a(i2).a(j).a(new a.b(this, i, fVar) { // from class: com.kwad.components.ad.reward.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ com.kwad.sdk.core.report.f b;
                public final /* synthetic */ l c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = i;
                    this.b = fVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.c.a(this.a, this.b);
                    }
                }
            }));
        }
    }

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            az.a(new Runnable(this, KSRewardVideoActivityProxy.a.b(), bVar) { // from class: com.kwad.components.ad.reward.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.ad.reward.b.c a;
                public final /* synthetic */ com.kwad.components.ad.reward.b.b b;
                public final /* synthetic */ l c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, bVar};
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
                    this.a = r7;
                    this.b = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.b.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (cVar = this.a) == null) {
                        return;
                    }
                    cVar.a(this.b);
                }
            });
        }
    }

    @MainThread
    public final void a(com.kwad.components.ad.reward.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.s.add(dVar);
        }
    }

    @MainThread
    public final void a(com.kwad.components.ad.reward.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.N.add(fVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.O = cVar;
        }
    }

    public final void a(@Nullable com.kwad.components.ad.reward.f.kwai.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.ac = dVar;
        }
    }

    public final void a(@Nullable e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.Q = aVar;
        }
    }

    public final void a(@Nullable e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.R = bVar;
        }
    }

    public final void a(@Nullable PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, playableSource) == null) {
            this.U = playableSource;
        }
    }

    public final void a(com.kwad.components.core.webview.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.P = aVar;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if ("ksad-video-bottom-card-v2".equals(str)) {
                this.aa = true;
            } else if ("ksad-video-top-bar".equals(str)) {
                this.ab = true;
            }
            for (com.kwad.components.ad.reward.c.d dVar : this.s) {
                dVar.a(str);
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.Z = z;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            q();
            com.kwad.components.ad.reward.h.a aVar = this.j;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    public final void b(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, context, i, i2) == null) {
            a(context, i, i2, 0L, false, null);
        }
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            az.a(new Runnable(this, KSRewardVideoActivityProxy.a.b(), bVar) { // from class: com.kwad.components.ad.reward.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.ad.reward.b.c a;
                public final /* synthetic */ com.kwad.components.ad.reward.b.b b;
                public final /* synthetic */ l c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, bVar};
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
                    this.a = r7;
                    this.b = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.b.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (cVar = this.a) == null) {
                        return;
                    }
                    cVar.b(this.b);
                }
            });
        }
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.s.remove(dVar);
        }
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.N.remove(fVar);
        }
    }

    public final void b(@Nullable com.kwad.components.ad.reward.f.kwai.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            this.ad = dVar;
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.S = true;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (r()) {
                s();
            } else {
                this.W.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.l.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ l a;

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
                        }
                    }
                });
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.T = z;
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.X : invokeV.intValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.V = true;
        }
    }

    public final void e() {
        com.kwad.components.ad.reward.e.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (cVar = this.O) == null) {
            return;
        }
        cVar.onPlayAgainClick();
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.Y = true;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public final void g() {
        com.kwad.components.core.webview.b.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.P) == null) {
            return;
        }
        aVar.a();
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.T : invokeV.booleanValue;
    }

    @Nullable
    public final PlayableSource j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.U : (PlayableSource) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.V : invokeV.booleanValue;
    }

    @Nullable
    public final e.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.Q : (e.a) invokeV.objValue;
    }

    @Nullable
    public final e.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.R : (e.b) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.kwai.d o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.ac : (com.kwad.components.ad.reward.f.kwai.d) invokeV.objValue;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.kwai.d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.ad : (com.kwad.components.ad.reward.f.kwai.d) invokeV.objValue;
    }
}
