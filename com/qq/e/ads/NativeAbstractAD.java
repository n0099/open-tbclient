package com.qq.e.ads;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes8.dex */
public abstract class NativeAbstractAD extends AbstractAD {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownAPPConfirmPolicy f;

    /* loaded from: classes8.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public NativeAbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.ads.AbstractAD
    public void a(ADI adi) {
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, adi) == null) || (downAPPConfirmPolicy = this.f) == null) {
            return;
        }
        setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Deprecated
    public void setBrowserType(BrowserType browserType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, browserType) == null) {
            GDTLogger.w("setBrowserType已废弃，调用无效");
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downAPPConfirmPolicy) == null) {
            this.f = downAPPConfirmPolicy;
            Object obj = this.a;
            if (obj == null || downAPPConfirmPolicy == null) {
                return;
            }
            ((ADI) obj).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
