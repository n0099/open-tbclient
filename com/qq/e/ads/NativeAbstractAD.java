package com.qq.e.ads;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;
/* loaded from: classes10.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownAPPConfirmPolicy f;

    /* loaded from: classes10.dex */
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

    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (downAPPConfirmPolicy = this.f) == null) {
            return;
        }
        setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.qq.e.ads.NativeAbstractAD<T extends com.qq.e.comm.pi.ADI> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        a((NativeAbstractAD<T>) ((ADI) obj));
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downAPPConfirmPolicy) == null) {
            this.f = downAPPConfirmPolicy;
            T t = this.a;
            if (t == 0 || downAPPConfirmPolicy == null) {
                return;
            }
            ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
