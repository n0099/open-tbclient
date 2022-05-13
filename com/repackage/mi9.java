package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBMediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class mi9 extends ReporterPidLoader<wh9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<wh9, b> i;

    /* loaded from: classes6.dex */
    public class a implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ wh9 c;
        public final /* synthetic */ mi9 d;

        public a(mi9 mi9Var, wh9 wh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi9Var, wh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mi9Var;
            this.c = wh9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.d.onAdClicked(this.b, new String[0]);
                this.b = true;
                synchronized (this.d.i) {
                    b bVar = this.d.i.get(this.c);
                    if (bVar != null) {
                        bVar.c.onAdClicked(bVar.a, this.d.mPid.ssp.type, this.d.mPid.pid);
                    }
                }
            }
        }

        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                LogPrinter.e("onFail code: " + i + ", message: " + str, new Object[0]);
                this.d.onError(i, str);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.d.onAdLoaded((mi9) this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public boolean b;
        public FunAdInteractionListener c;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashMap<>();
    }

    public JYNativeAdView a(wh9 wh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wh9Var)) == null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(R.layout.obfuscated_res_0x7f0d036a, (ViewGroup) null, false);
            jYNativeAdView.a.setText(wh9Var.f());
            jYNativeAdView.d.setText(wh9Var.h());
            GlideHelper.get().load(jYNativeAdView.getContext(), wh9Var.j(), jYNativeAdView.e);
            jYNativeAdView.f.setText(wh9Var.g());
            jYNativeAdView.g = (wh9Var.l() * 1.0f) / (wh9Var.k() * 1.0f);
            wh9Var.c(jYNativeAdView, jYNativeAdView.c);
            return jYNativeAdView;
        }
        return (JYNativeAdView) invokeL.objValue;
    }

    public final qi9 c(Context context, wh9 wh9Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wh9Var, str)) == null) {
            return new qi9(wh9Var, wh9Var.o() ? new PBMediaView(context.getApplicationContext()) : null, str, this.mPid, this);
        }
        return (qi9) invokeLLL.objValue;
    }

    public final void d(wh9 wh9Var, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, wh9Var, str, funAdInteractionListener) == null) {
            synchronized (this.i) {
                b bVar = this.i.get(wh9Var);
                if (bVar == null) {
                    bVar = new b(str);
                    this.i.put(wh9Var, bVar);
                }
                onShowStart(bVar.b);
                bVar.b = true;
                bVar.c = funAdInteractionListener;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        wh9 wh9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (wh9Var = (wh9) obj) == null) {
            return;
        }
        wh9Var.a();
        synchronized (this.i) {
            this.i.remove(wh9Var);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) ? c(context, (wh9) obj, str) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            wh9 wh9Var = (wh9) obj;
            qi9 c = c(context, wh9Var, str);
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, wh9Var, c, new ni9(this, c));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean isAdAvailable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            wh9 wh9Var = (wh9) obj;
            return wh9Var != null && wh9Var.n();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            wh9 wh9Var = (wh9) rh9.a(context, this.mPid);
            onLoadStart(funAdSlot);
            if (wh9Var == null) {
                onError(0, "jy native广告创建失败");
                return;
            }
            wh9Var.e(new a(this, wh9Var));
            wh9Var.b();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, obj)) == null) {
            onShowStart();
            JYNativeAdView a2 = a((wh9) obj);
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, str, funNativeAdInflater, obj)) == null) {
            wh9 wh9Var = (wh9) obj;
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(c(activity, wh9Var, str));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            wh9Var.d(adContainer, null, clickViews);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
