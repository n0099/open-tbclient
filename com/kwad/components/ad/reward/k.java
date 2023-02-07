package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class k extends com.kwad.components.core.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public com.kwad.components.ad.reward.j.a eF;
    public boolean mA;
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    @NonNull
    public com.kwad.components.ad.reward.d.c mAdRewardStepListener;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public boolean mB;
    public boolean mC;
    public l mCloseDialog;
    public boolean mD;
    public List<Integer> mE;
    public boolean mF;
    @Nullable
    public PlayableSource mG;
    public boolean mH;
    public Handler mHandler;
    public List<DialogInterface.OnDismissListener> mI;
    public boolean mJ;
    @Nullable
    public com.kwad.components.ad.reward.i.a.a mK;
    @Nullable
    public com.kwad.components.ad.reward.i.kwai.a mL;
    public int mM;
    public int mN;
    public long mO;
    public long mP;
    public long mPageEnterTime;
    public boolean mQ;
    public boolean mR;
    @Nullable
    public JSONObject mReportExtData;
    public boolean mRewardVerifyCalled;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public boolean mS;
    public int mScreenOrientation;
    public boolean mT;
    public boolean mU;
    public boolean mV;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    @Nullable
    public com.kwad.components.ad.reward.h.kwai.b mW;
    @Nullable
    public com.kwad.components.ad.reward.h.kwai.b mX;
    public DetailVideoView mj;
    @Nullable
    public com.kwad.components.core.playable.a mk;
    @NonNull
    public RewardActionBarControl ml;
    @Nullable
    public m mm;
    @Nullable
    public com.kwad.components.ad.i.b mn;
    @Nullable
    public com.kwad.components.ad.i.a mo;
    @Nullable
    public h mp;
    public Set<com.kwad.components.ad.reward.d.e> mq;
    public Set<com.kwad.components.ad.reward.d.d> mr;
    @Nullable
    public com.kwad.components.ad.reward.g.c ms;
    @Nullable
    public com.kwad.components.core.webview.b.d.a mt;
    @Nullable
    public e.a mu;
    @Nullable
    public e.b mv;
    public Set<com.kwad.components.core.webview.b.d.b> mw;
    public boolean mx;
    public boolean my;
    public boolean mz;

    public k() {
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
        this.mq = new HashSet();
        this.mr = new HashSet();
        this.mw = new HashSet();
        this.mx = false;
        this.my = false;
        this.mA = false;
        this.mB = false;
        this.mC = false;
        this.mRewardVerifyCalled = false;
        this.mD = false;
        this.mE = new ArrayList();
        this.mF = false;
        this.mG = null;
        this.mH = false;
        this.mI = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mJ = false;
        this.mN = 2;
        this.mR = false;
        this.mS = false;
        this.mU = false;
        this.mV = false;
    }

    public static long a(long j, AdInfo adInfo) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, adInfo)) == null) ? Math.min(com.kwad.sdk.core.response.a.a.T(adInfo), j) : invokeJL.longValue;
    }

    @Nullable
    public static com.kwad.components.ad.reward.c.b a(List<com.kwad.components.ad.reward.c.b> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, list, j)) == null) {
            if (j >= 0 && list != null) {
                for (com.kwad.components.ad.reward.c.b bVar : list) {
                    if (com.kwad.sdk.core.response.a.d.ca(bVar.getAdTemplate()) == j) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (com.kwad.components.ad.reward.c.b) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, fVar) == null) {
            if (fVar == null) {
                fVar = new com.kwad.sdk.core.report.f();
            }
            fVar.aI(i);
            fVar.b(this.mRootContainer.getTouchCoords());
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, fVar.uw(), this.mReportExtData);
            com.kwad.components.ad.reward.b.a.gp().b(this.mAdTemplate, com.kwad.components.ad.reward.b.b.STATUS_NONE);
            this.mAdOpenInteractionListener.bB();
        }
    }

    public static void a(Activity activity, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, kVar) == null) {
            com.kwad.components.ad.reward.h.kwai.b.a(activity, kVar.mAdTemplate, kVar.eF.getPlayDuration(), new DialogInterface.OnDismissListener(kVar) { // from class: com.kwad.components.ad.reward.k.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k lR;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lR = kVar;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        this.lR.d(dialogInterface);
                        com.kwad.sdk.core.c.b.tp();
                        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                        if (currentActivity == null || !currentActivity.equals(this.lR.getActivity())) {
                            return;
                        }
                        this.lR.eF.resume();
                    }
                }
            }, new com.kwad.components.core.webview.b.d.c(kVar) { // from class: com.kwad.components.ad.reward.k.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k lR;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lR = kVar;
                }

                @Override // com.kwad.components.core.webview.b.d.c
                public final void G(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    }
                }

                @Override // com.kwad.components.core.webview.b.d.c
                public final void fH() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.lR.eF.pause();
                    }
                }

                @Override // com.kwad.components.core.webview.b.d.c
                public final void fI() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
        }
    }

    public static void a(k kVar, Activity activity, AdTemplate adTemplate, o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, kVar, activity, adTemplate, bVar) == null) {
            com.kwad.components.ad.reward.h.kwai.b fF = kVar.fF();
            if (fF != null) {
                com.kwad.components.ad.reward.h.kwai.b.a(fF, kVar.getActivity(), kVar.eF.getPlayDuration(), bVar, new d.a(activity, adTemplate, bVar) { // from class: com.kwad.components.ad.reward.k.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity jG;
                    public final /* synthetic */ AdTemplate kp;
                    public final /* synthetic */ o.b ne;

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
                        this.jG = activity;
                        this.kp = adTemplate;
                        this.ne = bVar;
                    }

                    @Override // com.kwad.components.core.webview.b.b.d.a
                    public final boolean fG() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            o.a(this.jG, this.kp, this.ne);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            } else {
                o.a(activity, adTemplate, bVar);
            }
        }
    }

    public static void a(k kVar, l.c cVar, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, kVar, cVar, aVar) == null) {
            com.kwad.components.ad.reward.h.kwai.b fE = kVar.fE();
            if (fE == null) {
                fE = e(kVar);
            }
            com.kwad.components.ad.reward.h.kwai.b bVar = fE;
            if (bVar != null) {
                com.kwad.components.ad.reward.h.kwai.b.a(bVar, kVar.getActivity(), kVar.eF.getPlayDuration(), aVar, new d.a(kVar, cVar, aVar) { // from class: com.kwad.components.ad.reward.k.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ k lR;
                    public final /* synthetic */ l.c nc;
                    public final /* synthetic */ l.a nd;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {kVar, cVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.lR = kVar;
                        this.nc = cVar;
                        this.nd = aVar;
                    }

                    @Override // com.kwad.components.core.webview.b.b.d.a
                    public final boolean fG() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            k.b(this.lR, this.nc, this.nd);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            } else {
                b(kVar, cVar, aVar);
            }
        }
    }

    public static boolean a(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kVar)) == null) {
            boolean z = false;
            if (com.kwad.sdk.core.config.d.isCanUseTk() && com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) != null) {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
                boolean z2 = (com.kwad.sdk.core.response.a.a.bF(bQ) || (com.kwad.sdk.core.response.a.a.aY(bQ) && com.kwad.components.ad.reward.kwai.b.gc()) || com.kwad.sdk.core.response.a.d.cc(kVar.mAdTemplate)) ? false : true;
                kVar.mA = z2 && !kVar.mV;
                if (z2 && !kVar.mV) {
                    z = true;
                }
                kVar.D(z);
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(k kVar, l.c cVar, l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, kVar, cVar, aVar) == null) || d(kVar)) {
            return;
        }
        l.a(kVar.getActivity(), kVar.mAdTemplate, cVar, aVar);
    }

    public static boolean b(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, kVar)) == null) {
            boolean z = false;
            if (com.kwad.sdk.core.config.d.isCanUseTk() && com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) != null) {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
                boolean z2 = com.kwad.components.ad.reward.kwai.b.i(bQ) || !(com.kwad.components.ad.reward.kwai.b.h(bQ) || com.kwad.sdk.core.response.a.d.cd(kVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.bF(bQ));
                if (z2 && !kVar.mV) {
                    z = true;
                }
                kVar.mA = z;
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, kVar)) == null) {
            if (!com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) == null || kVar.mU) {
                return false;
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.bQ(bQ)) {
                return true;
            }
            boolean z = com.kwad.components.ad.reward.kwai.b.i(bQ) || !(com.kwad.components.ad.reward.kwai.b.h(bQ) || com.kwad.sdk.core.response.a.a.bF(bQ) || (com.kwad.sdk.core.response.a.a.aY(bQ) && com.kwad.components.ad.reward.kwai.b.gc()) || com.kwad.sdk.core.response.a.d.cd(kVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.aK(kVar.mAdTemplate));
            return com.kwad.sdk.core.response.a.b.e(kVar.mContext, kVar.mAdTemplate) ? z : (o(kVar.mAdTemplate) || p(kVar.mAdTemplate) || !z) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, kVar)) == null) {
            l lVar = kVar.mCloseDialog;
            return lVar != null && lVar.isShowing();
        }
        return invokeL.booleanValue;
    }

    public static com.kwad.components.ad.reward.h.kwai.b e(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, kVar)) == null) {
            if (com.kwad.sdk.core.response.a.a.bK(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate)) || com.kwad.sdk.core.response.a.a.bL(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate))) {
                d.b bVar = new d.b();
                bVar.setAdTemplate(kVar.mAdTemplate);
                bVar.aI("ksad-video-confirm-card");
                bVar.aE(false);
                bVar.aF(true);
                return com.kwad.components.ad.reward.h.kwai.b.a(bVar);
            }
            return null;
        }
        return (com.kwad.components.ad.reward.h.kwai.b) invokeL.objValue;
    }

    private void fq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.EF.clear();
            this.mq.clear();
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.clear();
            }
            m mVar = this.mm;
            if (mVar != null) {
                mVar.release();
            }
            h hVar = this.mp;
            if (hVar != null) {
                hVar.release();
            }
            Set<com.kwad.components.ad.reward.d.d> set = this.mr;
            if (set != null) {
                set.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            for (com.kwad.components.ad.reward.d.e eVar : this.mq) {
                eVar.bA();
            }
        }
    }

    public static boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public static boolean o(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) : invokeL.booleanValue;
    }

    public static boolean p(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.p(adTemplate) : invokeL.booleanValue;
    }

    public static boolean q(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adTemplate)) == null) {
            if (com.kwad.sdk.core.response.a.a.bQ(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                return false;
            }
            return o(adTemplate) || p(adTemplate);
        }
        return invokeL.booleanValue;
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mS = z;
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.my = true;
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mB = z;
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mH = true;
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mR = true;
        }
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.mN = i;
        }
    }

    public final void a(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            for (com.kwad.components.ad.reward.d.d dVar : this.mr) {
                dVar.bV();
            }
        }
    }

    public final void a(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, context, i, i2) == null) {
            b(context, i, i2);
        }
    }

    public final void a(Context context, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            a(context, 40, 1, j, false, null);
        }
    }

    public final void a(Context context, int i, int i2, long j, boolean z, com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z), fVar}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0597a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(i2).l(j).a(new a.b(this, i, fVar) { // from class: com.kwad.components.ad.reward.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int gB;
                public final /* synthetic */ k mY;
                public final /* synthetic */ com.kwad.sdk.core.report.f mZ;

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
                    this.mY = this;
                    this.gB = i;
                    this.mZ = fVar;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.mY.a(this.gB, this.mZ);
                    }
                }
            }));
        }
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onDismissListener) == null) {
            this.mI.add(onDismissListener);
        }
    }

    @MainThread
    public final void a(com.kwad.components.ad.reward.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.mq.add(eVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.ms = cVar;
        }
    }

    public final void a(@Nullable com.kwad.components.ad.reward.h.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.mW = bVar;
        }
    }

    public final void a(@Nullable e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.mu = aVar;
        }
    }

    public final void a(@Nullable e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.mv = bVar;
        }
    }

    public final void a(com.kwad.components.core.webview.b.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.mt = aVar;
        }
    }

    public final void b(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, context, i, i2) == null) {
            a(context, i, i2, 0L, false, null);
        }
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onDismissListener) == null) {
            this.mI.remove(onDismissListener);
        }
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            com.kwad.components.ad.reward.b.a.gp().a(this.mAdTemplate, bVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            bd.runOnUiThread(new Runnable(this, KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId()), bVar) { // from class: com.kwad.components.ad.reward.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k mY;
                public final /* synthetic */ com.kwad.components.ad.reward.c.c na;
                public final /* synthetic */ com.kwad.components.ad.reward.c.b nb;

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
                    this.mY = this;
                    this.na = r7;
                    this.nb = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.c.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (cVar = this.na) == null) {
                        return;
                    }
                    cVar.d(this.nb);
                }
            });
        }
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            this.mq.remove(eVar);
        }
    }

    public final void b(@Nullable com.kwad.components.ad.reward.h.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.mX = bVar;
        }
    }

    public final void c(com.kwad.components.ad.reward.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            bd.runOnUiThread(new Runnable(this, KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId()), bVar) { // from class: com.kwad.components.ad.reward.k.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k mY;
                public final /* synthetic */ com.kwad.components.ad.reward.c.c na;
                public final /* synthetic */ com.kwad.components.ad.reward.c.b nb;

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
                    this.mY = this;
                    this.na = r7;
                    this.nb = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.c.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (cVar = this.na) == null) {
                        return;
                    }
                    cVar.e(this.nb);
                }
            });
        }
    }

    public final void d(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dialogInterface) == null) {
            for (DialogInterface.OnDismissListener onDismissListener : this.mI) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, playableSource) == null) {
            this.mG = playableSource;
        }
    }

    public final boolean fA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mH : invokeV.booleanValue;
    }

    @Nullable
    public final e.a fB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mu : (e.a) invokeV.objValue;
    }

    @Nullable
    public final e.b fC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mv : (e.b) invokeV.objValue;
    }

    public final boolean fD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mR : invokeV.booleanValue;
    }

    @Nullable
    public final com.kwad.components.ad.reward.h.kwai.b fE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mW : (com.kwad.components.ad.reward.h.kwai.b) invokeV.objValue;
    }

    @Nullable
    public final com.kwad.components.ad.reward.h.kwai.b fF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mX : (com.kwad.components.ad.reward.h.kwai.b) invokeV.objValue;
    }

    public final void fr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (isMainThread()) {
                fs();
            } else {
                this.mHandler.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ k mY;

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
                        this.mY = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.mY.fs();
                        }
                    }
                });
            }
        }
    }

    public final int ft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mN : invokeV.intValue;
    }

    public final void fu() {
        com.kwad.components.ad.reward.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (cVar = this.ms) == null) {
            return;
        }
        cVar.onPlayAgainClick();
    }

    public final boolean fv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mS : invokeV.booleanValue;
    }

    public final void fw() {
        com.kwad.components.core.webview.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (aVar = this.mt) == null) {
            return;
        }
        aVar.cy();
    }

    public final boolean fx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.my : invokeV.booleanValue;
    }

    public final boolean fy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mB : invokeV.booleanValue;
    }

    @Nullable
    public final PlayableSource fz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mG : (PlayableSource) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.a, com.kwad.sdk.mvp.a
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            fq();
            com.kwad.components.ad.reward.j.a aVar = this.eF;
            if (aVar != null) {
                aVar.release();
            }
        }
    }

    public final void releaseSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            fq();
            com.kwad.components.ad.reward.j.a aVar = this.eF;
            if (aVar != null) {
                aVar.releaseSync();
            }
        }
    }
}
