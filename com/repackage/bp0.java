package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.np0;
import com.repackage.zk0;
import java.text.DecimalFormat;
/* loaded from: classes5.dex */
public abstract class bp0 extends np0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int H;
    public BdVideoSeries I;
    public int J;
    public IVideoUpdateStrategy K;
    public tw0 L;
    @Nullable
    public jq0 M;
    @Nullable
    public kq0 N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp0(@NonNull ts0 ts0Var, @Nullable Context context) {
        super(ts0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ts0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ts0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.H = 0;
        this.J = 0;
    }

    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) {
            B1(bdVideoSeries, true);
        }
    }

    @Override // com.repackage.ap0
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public void B1(@NonNull BdVideoSeries bdVideoSeries, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bdVideoSeries, z) == null) {
            dx0.g(M0("setVideoSeriesForPrepare(" + System.identityHashCode(bdVideoSeries) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX));
            StringBuilder sb = new StringBuilder();
            sb.append("series = ");
            sb.append(bdVideoSeries);
            dx0.g(M0(sb.toString() != null ? bdVideoSeries.toString() : null));
            boolean z2 = false;
            x1(false, this.I);
            this.I = bdVideoSeries;
            if (!TextUtils.isEmpty(bdVideoSeries.getNid())) {
                C0(this.I.getNid());
            }
            H1(bdVideoSeries);
            if (bdVideoSeries.getSelectedVideo() != null) {
                C1(bdVideoSeries);
                G1(this.a.b);
                boolean z3 = b0() && E().d(this, this.b);
                if (!z3 || D() <= 0) {
                    v1(false, bdVideoSeries);
                }
                ox0.s(this.I.getNid(), this.a.b);
                v0(bdVideoSeries.isPlayLoop());
                if (z) {
                    x0(bdVideoSeries.getPlayConf());
                }
                if (bdVideoSeries.getClarityList() != null) {
                    r0(bdVideoSeries.getClarityList().getClarityInfoStr());
                }
                F1(false);
                String str = this.a.b;
                if (z && !z3) {
                    z2 = true;
                }
                E0(str, z2);
            }
        }
    }

    public final void C1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdVideoSeries) == null) {
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                String localSavePath = selectedVideo.getLocalSavePath();
                if (cx0.a(localSavePath)) {
                    this.a.b = localSavePath;
                }
                this.a.c = selectedVideo.getTitle();
                this.a.a = selectedVideo.getSourceUrl();
            }
            ClarityUrlList clarityList = bdVideoSeries.getClarityList();
            if (clarityList != null && clarityList.size() > 0) {
                this.a.b = clarityList.getDefaultUrl();
            } else if (selectedVideo != null) {
                this.a.b = selectedVideo.getPlayUrl();
            }
            this.a.e = bdVideoSeries.getDuration();
            if (s1()) {
                return;
            }
            e1(bdVideoSeries);
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdNetUtils.i(m(), h1());
        }
    }

    public void E1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdVideoSeries) == null) {
            mv0.b(bdVideoSeries, (Q() || Math.abs(s() - D()) < 3000) ? 0 : 0, s());
        }
    }

    public abstract void F1(boolean z);

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && BdNetUtils.c()) {
            String a = u11.a().a(str);
            if (TextUtils.isEmpty(a) || TextUtils.equals(a, this.a.b)) {
                return;
            }
            this.a.b = a;
            t0(true);
        }
    }

    @Override // com.repackage.ap0
    public void H0(@Nullable Context context, @Nullable ou0 ou0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, ou0Var) == null) {
            super.H0(context, ou0Var);
            nq0.a(this);
        }
    }

    public final void H1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdVideoSeries) == null) {
        }
    }

    @Override // com.repackage.ap0
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            super.I0(context);
            d(yk0.b());
            if (s1()) {
                d(new fw0());
            }
            d(new hw0());
        }
    }

    @Override // com.repackage.ap0
    public void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.a.b)) {
            return;
        }
        if (BdNetUtils.e()) {
            l();
        } else if (BdNetUtils.h()) {
            if (n1().i() != 0) {
                l();
            }
        } else if (BdNetUtils.d()) {
            if (n1().i() == 2) {
                l();
                D1();
                return;
            }
            q().g();
        }
    }

    @Override // com.repackage.ap0
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w1();
            super.L0();
            this.A.cancel();
        }
    }

    @Override // com.repackage.np0, com.repackage.ap0
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = new zp0();
        }
    }

    @Override // com.repackage.np0, com.repackage.ap0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            zo0.e(false);
            zk0.a.a().b();
            S0();
        }
    }

    @Override // com.repackage.np0
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.A = new hs0(this);
            es0 es0Var = new es0(zo0.b(), 3);
            this.B = es0Var;
            if (es0Var.canDetectOrientation()) {
                this.E = true;
                this.B.disable();
                this.B.g(new np0.a(this));
            }
            this.C = new ds0(this);
        }
    }

    @Override // com.repackage.np0
    public void c1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            jq0 jq0Var = this.M;
            if (jq0Var == null || !jq0Var.a(i)) {
                super.c1(i);
            }
        }
    }

    @Override // com.repackage.np0
    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            kq0 kq0Var = this.N;
            if (kq0Var == null || !kq0Var.a(i)) {
                super.d1(i);
            }
        }
    }

    public final void e1(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdVideoSeries) == null) {
            try {
                this.a.d = 0;
                this.a.e = 0;
                if (bdVideoSeries.getSelectedVideo() != null) {
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getCurrentLength())) {
                        this.a.d = zw0.c(bdVideoSeries.getSelectedVideo().getCurrentLength());
                    }
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getTotalLength())) {
                        this.a.e = zw0.c(bdVideoSeries.getSelectedVideo().getTotalLength());
                    }
                }
                if (this.a.e < 0 || this.a.d < 0 || this.a.d > this.a.e) {
                    this.a.e = 0;
                    this.a.d = 0;
                }
            } catch (Exception e) {
                dx0.f("applyPosition(" + System.identityHashCode(bdVideoSeries) + SmallTailInfo.EMOTION_SUFFIX, e);
            }
        }
    }

    @Override // com.repackage.ap0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.f0(i);
            this.A.cancel();
        }
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.H : invokeV.intValue;
    }

    @Override // com.repackage.np0, com.repackage.ap0
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w1();
            super.g0();
            this.A.cancel();
            O0();
            this.M = null;
            this.N = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.np0, com.repackage.ap0
    @NonNull
    /* renamed from: g1 */
    public zp0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (zp0) this.m : (zp0) invokeV.objValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            float i1 = i1();
            return i1 <= 0.0f ? "" : new DecimalFormat("#.#").format(i1);
        }
        return (String) invokeV.objValue;
    }

    public float i1() {
        InterceptResult invokeV;
        ClarityUrlList clarityList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries == null || (clarityList = bdVideoSeries.getClarityList()) == null || clarityList.size() <= 0) {
                return 0.0f;
            }
            if (Y() && r() > 0) {
                return (1.0f - ((C() * 1.0f) / r())) * clarityList.getCurrentClarityUrl().k();
            }
            return clarityList.getCurrentClarityUrl().k();
        }
        return invokeV.floatValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ap0
    @Nullable
    public ou0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            w1();
            return super.k();
        }
        return (ou0) invokeV.objValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ap0
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.l();
            this.A.start();
            System.currentTimeMillis();
        }
    }

    @Override // com.repackage.ap0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.l0();
            this.A.start();
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.J : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ap0
    @NonNull
    /* renamed from: m1 */
    public tw0 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.L == null) {
                this.L = new tw0();
            }
            return this.L;
        }
        return (tw0) invokeV.objValue;
    }

    @NonNull
    public IVideoUpdateStrategy n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.K == null) {
                this.K = new sw0();
            }
            return this.K;
        }
        return (IVideoUpdateStrategy) invokeV.objValue;
    }

    @Nullable
    public BdVideoSeries o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.I : (BdVideoSeries) invokeV.objValue;
    }

    @Override // com.repackage.ap0, com.repackage.cu0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onCompletion();
            y().p(C(), p(), r());
            this.A.cancel();
        }
    }

    @Override // com.repackage.ap0, com.repackage.cu0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i, i2, obj)) == null) {
            this.A.cancel();
            w1();
            return super.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.repackage.ap0, com.repackage.cu0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onSeekComplete();
            this.A.start();
        }
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? r1() && !qp0.b() : invokeV.booleanValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries != null) {
                return bdVideoSeries.isInteractVideo();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t1(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bdVideoSeries)) == null) ? !s1() || bdVideoSeries == null || q1() || D() <= 0 || bdVideoSeries.getPositionMs() == D() : invokeL.booleanValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v1(boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048621, this, z, bdVideoSeries) == null) && s1() && !q1()) {
            y1("plugin_event_load_player_history", z, bdVideoSeries);
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            x1(true, this.I);
        }
    }

    public void x1(boolean z, @Nullable BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048623, this, z, bdVideoSeries) == null) || t1(bdVideoSeries)) {
            return;
        }
        E1(bdVideoSeries);
        y1("plugin_event_save_player_history", z, bdVideoSeries);
    }

    public final void y1(@NonNull String str, boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, Boolean.valueOf(z), bdVideoSeries}) == null) {
            ur0 w = nr0.w(str, z ? 1 : 0);
            w.n(1, bdVideoSeries);
            q0(w);
        }
    }

    public void z1(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, iVideoUpdateStrategy) == null) {
            this.K = iVideoUpdateStrategy;
        }
    }
}
