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
/* loaded from: classes10.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DownAPPConfirmPolicy f74727b;

    /* loaded from: classes10.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public NativeAbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (downAPPConfirmPolicy = this.f74727b) == null) {
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
            this.f74727b = downAPPConfirmPolicy;
            T t = this.f74712a;
            if (t == 0 || downAPPConfirmPolicy == null) {
                return;
            }
            ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
