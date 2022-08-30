package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
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
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public final class RewardActionBarControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public Handler mHandler;
    public k nM;
    @Nullable
    public c rA;
    @Nullable
    public d rB;
    @Nullable
    public e rC;
    @NonNull
    public a rD;
    public final long rE;
    public boolean rF;
    public b rw;
    @Nullable
    public f rz;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ShowActionBarResult {
        public static final /* synthetic */ ShowActionBarResult[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ShowActionBarResult SHOW_H5_FAILURE;
        public static final ShowActionBarResult SHOW_H5_SUCCESS;
        public static final ShowActionBarResult SHOW_NATIVE_DEFAULT;
        public static final ShowActionBarResult SHOW_NATIVE_JINNIU;
        public static final ShowActionBarResult SHOW_NATIVE_LIVE_SUBSCRIBE;
        public static final ShowActionBarResult SHOW_NATIVE_ORDER;
        public static final ShowActionBarResult SHOW_NATIVE_PLAYABLE_PORTRAIT;
        public static final ShowActionBarResult SHOW_NEW_STYLE;
        public static final ShowActionBarResult SHOW_ORDER;
        public static final ShowActionBarResult TK;
        public static final ShowActionBarResult TK_NEW_STYLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500439904, "Lcom/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1500439904, "Lcom/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult;");
                    return;
                }
            }
            SHOW_NEW_STYLE = new ShowActionBarResult("SHOW_NEW_STYLE", 0);
            SHOW_NATIVE_DEFAULT = new ShowActionBarResult("SHOW_NATIVE_DEFAULT", 1);
            SHOW_H5_SUCCESS = new ShowActionBarResult("SHOW_H5_SUCCESS", 2);
            SHOW_H5_FAILURE = new ShowActionBarResult("SHOW_H5_FAILURE", 3);
            SHOW_ORDER = new ShowActionBarResult("SHOW_ORDER", 4);
            TK = new ShowActionBarResult("TK", 5);
            TK_NEW_STYLE = new ShowActionBarResult("TK_NEW_STYLE", 6);
            SHOW_NATIVE_ORDER = new ShowActionBarResult("SHOW_NATIVE_ORDER", 7);
            SHOW_NATIVE_JINNIU = new ShowActionBarResult("SHOW_NATIVE_JINNIU", 8);
            SHOW_NATIVE_PLAYABLE_PORTRAIT = new ShowActionBarResult("SHOW_NATIVE_PLAYABLE_PORTRAIT", 9);
            ShowActionBarResult showActionBarResult = new ShowActionBarResult("SHOW_NATIVE_LIVE_SUBSCRIBE", 10);
            SHOW_NATIVE_LIVE_SUBSCRIBE = showActionBarResult;
            $VALUES = new ShowActionBarResult[]{SHOW_NEW_STYLE, SHOW_NATIVE_DEFAULT, SHOW_H5_SUCCESS, SHOW_H5_FAILURE, SHOW_ORDER, TK, TK_NEW_STYLE, SHOW_NATIVE_ORDER, SHOW_NATIVE_JINNIU, SHOW_NATIVE_PLAYABLE_PORTRAIT, showActionBarResult};
        }

        public ShowActionBarResult(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ShowActionBarResult valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ShowActionBarResult) Enum.valueOf(ShowActionBarResult.class, str) : (ShowActionBarResult) invokeL.objValue;
        }

        public static ShowActionBarResult[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ShowActionBarResult[]) $VALUES.clone() : (ShowActionBarResult[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> rK;
        public ShowActionBarResult rL;

        public a() {
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
            this.rK = new CopyOnWriteArrayList();
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, showActionBarResult, view2) == null) {
                com.kwad.sdk.core.e.b.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
                this.rL = showActionBarResult;
                for (com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar : this.rK) {
                    aVar.a(showActionBarResult, view2);
                }
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.rK.add(aVar);
            }
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.rK.remove(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes7.dex */
    public interface e {
    }

    /* loaded from: classes7.dex */
    public interface f {
        boolean g(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(k kVar, Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, context, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rD = new a((byte) 0);
        this.nM = kVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.rF = false;
        long aO = !com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) ? com.kwad.sdk.core.response.a.b.aO(adTemplate) : 1000L;
        this.rE = aO > 0 ? aO : 1000L;
    }

    private ShowActionBarResult T(boolean z) {
        InterceptResult invokeZ;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            if (k.c(this.nM)) {
                if (com.kwad.sdk.core.response.a.b.e(this.mContext, this.mAdTemplate) && this.rC != null) {
                    return ShowActionBarResult.TK_NEW_STYLE;
                }
                d dVar = this.rB;
                if (dVar != null) {
                    dVar.f(this.rD);
                    return ShowActionBarResult.TK;
                }
            }
            if (com.kwad.components.ad.reward.kwai.b.h(this.mAdInfo) && (cVar = this.rA) != null) {
                cVar.e(this.rD);
                return ShowActionBarResult.SHOW_ORDER;
            } else if (com.kwad.sdk.core.response.a.a.c(this.mAdTemplate, this.mAdInfo)) {
                return ShowActionBarResult.SHOW_NEW_STYLE;
            } else {
                if (!com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate) || this.rz == null) {
                    U(z);
                    return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
                }
                com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar success in " + this.rE);
                return this.rz.g(this.rD) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
            }
        }
        return (ShowActionBarResult) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || this.rw == null) {
            return;
        }
        com.kwad.sdk.core.e.b.d("ActionBarControl", "showNativeActionBar");
        this.rw.a(z, this.rD);
    }

    public static void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, View view2, ShowActionBarResult showActionBarResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, view2, showActionBarResult) == null) || aVar == null) {
            return;
        }
        view2.post(new Runnable(aVar, showActionBarResult, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.kwad.components.ad.reward.presenter.platdetail.actionbar.a rH;
            public final /* synthetic */ ShowActionBarResult rI;
            public final /* synthetic */ View rJ;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, showActionBarResult, view2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.rH = aVar;
                this.rI = showActionBarResult;
                this.rJ = view2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.rH.a(this.rI, this.rJ);
                }
            }
        });
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ShowActionBarResult T = T(z);
            com.kwad.sdk.core.e.b.d("ActionBarControl", "showActionBarOnVideoStart result: " + T);
            if (T != ShowActionBarResult.SHOW_H5_FAILURE) {
                return;
            }
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RewardActionBarControl rG;

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
                    this.rG = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.rG.rF = true;
                        com.kwad.sdk.core.e.b.d("ActionBarControl", "mHasOutTime");
                        if (this.rG.rz != null && this.rG.rz.g(this.rG.rD)) {
                            com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar success on " + this.rG.rE);
                            return;
                        }
                        com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar out " + this.rG.rE);
                        com.kwad.components.core.j.a.og().e(this.rG.mAdTemplate, this.rG.rE);
                        com.kwad.components.ad.reward.monitor.a.a(this.rG.nM.mz, "play_card", com.kwad.sdk.core.response.a.b.aN(this.rG.nM.mAdTemplate), this.rG.rE);
                        this.rG.U(true);
                    }
                }
            }, this.rE);
        }
    }

    @MainThread
    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.rw = bVar;
        }
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.rA = cVar;
        }
    }

    public final void a(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.rB = dVar;
        }
    }

    @MainThread
    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.rz = fVar;
        }
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.rD.c(aVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.rD.d(aVar);
        }
    }

    public final void hw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.rF) {
                com.kwad.sdk.core.e.b.i("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            T(true);
        }
    }

    @Nullable
    public final ShowActionBarResult hx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.rD.rL : (ShowActionBarResult) invokeV.objValue;
    }
}
