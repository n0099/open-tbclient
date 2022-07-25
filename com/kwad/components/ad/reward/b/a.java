package com.kwad.components.ad.reward.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a oE;
    public transient /* synthetic */ FieldHolder $fh;
    public k nM;
    @Nullable
    public b oF;
    public volatile boolean oG;
    public volatile boolean oH;
    public List<WeakReference<com.kwad.components.core.webview.jshandler.a>> oI;

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
        this.oG = false;
        this.oH = false;
        this.oI = new CopyOnWriteArrayList();
    }

    public static a gp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (oE == null) {
                synchronized (a.class) {
                    if (oE == null) {
                        oE = new a();
                    }
                }
            }
            return oE;
        }
        return (a) invokeV.objValue;
    }

    private synchronized boolean gr() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                if (this.oF != null) {
                    z = this.oF.oM == b.oJ;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void O(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            boolean gr = gr();
            com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gr + ", hadToast: " + this.oH);
            if (this.oH || !gr) {
                return;
            }
            this.oH = true;
            t.z(context, "恭喜获得第2份奖励");
        }
    }

    public final void a(com.kwad.components.core.webview.jshandler.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + aVar);
            if (aVar != null) {
                this.oI.add(new WeakReference<>(aVar));
            }
        }
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, bVar) == null) {
            synchronized (this) {
                if (adTemplate == null) {
                    return;
                }
                com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
                this.oF = bVar;
                if (bVar.oM == b.oJ && !this.oG) {
                    this.oG = true;
                    c.a(this.oF, KSRewardVideoActivityProxy.a.E(adTemplate.getUniqueId()));
                    com.kwad.sdk.core.report.a.aF(adTemplate);
                }
                for (WeakReference<com.kwad.components.core.webview.jshandler.a> weakReference : this.oI) {
                    if (weakReference.get() == null) {
                        this.oI.remove(weakReference);
                    } else {
                        b gq = gq();
                        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gq.toJson().toString());
                        weakReference.get().a(gq);
                    }
                }
            }
        }
    }

    public final synchronized void b(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, adTemplate, i) == null) {
            synchronized (this) {
                com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
                if (this.nM != null && this.nM.mRewardVerifyCalled && i == b.STATUS_NONE) {
                    com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
                    return;
                }
                b gq = gp().gq();
                gq.N(i);
                gp().a(adTemplate, gq);
            }
        }
    }

    @NonNull
    public final synchronized b gq() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.oF == null) {
                    b gt = c.gt();
                    this.oF = gt;
                    gt.oM = 0;
                }
                com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.oF.oM);
                bVar = this.oF;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.oF = null;
                this.oH = false;
                this.oG = false;
                this.nM = null;
            }
        }
    }

    public final void setCallerContext(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kVar) == null) {
            this.nM = kVar;
        }
    }
}
