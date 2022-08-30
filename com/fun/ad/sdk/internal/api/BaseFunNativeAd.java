package com.fun.ad.sdk.internal.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.wl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeInfo;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.s0;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseFunNativeAd implements FunNativeAd, FunNativeInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wl9.a a;
    public final String mSid;

    public BaseFunNativeAd(String str, Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSid = str;
        this.a = new wl9.a(str, pid);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public final void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            if (context == null || viewGroup == null || list == null || funAdInteractionListener == null) {
                throw new IllegalArgumentException();
            }
            wl9.a aVar = this.a;
            aVar.getClass();
            aVar.a.logEvent("ad_ldr", new s0(aVar, new Object[0], "ldr_sh_start"));
            showInternal(context, viewGroup, list, list2, funAdInteractionListener);
        }
    }

    public abstract void showInternal(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener);
}
