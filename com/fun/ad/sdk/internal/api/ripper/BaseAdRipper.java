package com.fun.ad.sdk.internal.api.ripper;

import b.g.i0;
import b.g.o0;
import b.g.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class BaseAdRipper implements AdRipper {
    public static /* synthetic */ Interceptable $ic;
    public static AdRipper FAKE_AD_RIPPER;

    /* renamed from: a  reason: collision with root package name */
    public static final Random f62841a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, RippedAd> f62842b;
    public final Ssp.Pid mPid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1859103896, "Lcom/fun/ad/sdk/internal/api/ripper/BaseAdRipper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1859103896, "Lcom/fun/ad/sdk/internal/api/ripper/BaseAdRipper;");
                return;
            }
        }
        FAKE_AD_RIPPER = new r();
        f62841a = new Random();
    }

    public BaseAdRipper(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62842b = new HashMap<>();
        this.mPid = pid;
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void destroy(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.f62842b) {
                this.f62842b.remove(obj);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final RippedAd getRippedAd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this.f62842b) {
                RippedAd rippedAd = this.f62842b.get(obj);
                if (rippedAd != null) {
                    return rippedAd;
                }
                RippedAd rippedAdInternal = getRippedAdInternal(obj);
                if (rippedAdInternal == null) {
                    return null;
                }
                this.f62842b.put(obj, rippedAdInternal);
                return rippedAdInternal;
            }
        }
        return (RippedAd) invokeL.objValue;
    }

    public abstract RippedAd getRippedAdInternal(Object obj);

    /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void report(Object obj, String str) {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, obj, str) == null) && BuildConfig.IS_ADM_REPORT.booleanValue() && obj != null) {
            float nextFloat = f62841a.nextFloat();
            if (nextFloat >= this.mPid.sample) {
                LogPrinter.d("Forbid report with sample %.2f ratio:%.2f", Float.valueOf(nextFloat), Float.valueOf(this.mPid.sample));
                return;
            }
            RippedAd rippedAdInternal = getRippedAdInternal(obj);
            if (rippedAdInternal == null) {
                return;
            }
            Ssp.Pid pid = this.mPid;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_platform", pid.ssp.type);
                jSONObject.put("aid", pid.pid);
                jSONObject.put("type", pid.type);
                jSONObject.put("sid", str);
                jSONObject.put("corp", rippedAdInternal.corporation);
                jSONObject.put("title", rippedAdInternal.title);
                jSONObject.put("desc", rippedAdInternal.description);
                jSONObject.put("iU", rippedAdInternal.iconUrl);
                jSONObject.put("appN", rippedAdInternal.appName);
                jSONObject.put("pkg", rippedAdInternal.appPkg);
                jSONObject.put("appUrl", rippedAdInternal.appUrl);
                jSONObject.put("imgU", rippedAdInternal.imageUrl);
                jSONObject.put("viU", rippedAdInternal.videoImageUrl);
                jSONObject.put("vU", rippedAdInternal.videoUrl);
                jSONObject.put("clkU", rippedAdInternal.clickUrl);
                jSONObject.put("dpU", rippedAdInternal.deepLinkUrl);
                jSONObject.put("convU", rippedAdInternal.convUrl);
                jSONObject.put("st", "ld");
                o0<i0> o0Var = i0.f31167b;
                synchronized (o0Var) {
                    if (o0Var.f31222a == null) {
                        o0Var.f31222a = o0Var.a();
                    }
                    i0Var = o0Var.f31222a;
                }
                i0Var.d("adM", jSONObject);
            } catch (JSONException e2) {
                LogPrinter.e(e2);
            }
            synchronized (this.f62842b) {
                this.f62842b.put(obj, rippedAdInternal);
            }
        }
    }
}
