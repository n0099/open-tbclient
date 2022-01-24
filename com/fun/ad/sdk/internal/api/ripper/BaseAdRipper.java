package com.fun.ad.sdk.internal.api.ripper;

import c.g.o0;
import c.g.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
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
/* loaded from: classes3.dex */
public abstract class BaseAdRipper implements AdRipper {
    public static /* synthetic */ Interceptable $ic;
    public static AdRipper FAKE_AD_RIPPER;
    public static final Random a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f54214b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<Object, RippedAd> f54215c;
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
        FAKE_AD_RIPPER = new v();
        a = new Random();
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
        this.f54214b = false;
        this.f54215c = new HashMap<>();
        this.mPid = pid;
    }

    public final RippedAd a(Object obj) {
        InterceptResult invokeL;
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            synchronized (this.f54215c) {
                rippedAd = this.f54215c.get(obj);
                if (rippedAd == null && (rippedAd = getRippedAdInternal(obj)) != null) {
                    this.f54215c.put(obj, rippedAd);
                }
            }
            return rippedAd;
        }
        return (RippedAd) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float nextFloat = a.nextFloat();
            if (nextFloat >= this.mPid.sample) {
                LogPrinter.d("Forbid getRipped-report with sample %.2f ratio:%.2f", Float.valueOf(nextFloat), Float.valueOf(this.mPid.sample));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void destroy(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this.f54215c) {
                this.f54215c.remove(obj);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final RippedAd getRippedAd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            synchronized (this.f54215c) {
                RippedAd rippedAd = this.f54215c.get(obj);
                if (rippedAd != null) {
                    return rippedAd;
                }
                RippedAd rippedAdInternal = getRippedAdInternal(obj);
                if (rippedAdInternal == null) {
                    return null;
                }
                this.f54215c.put(obj, rippedAdInternal);
                return rippedAdInternal;
            }
        }
        return (RippedAd) invokeL.objValue;
    }

    public abstract RippedAd getRippedAdInternal(Object obj);

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public void preParseRippedAd(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, obj) == null) || obj == null) {
            return;
        }
        if (!a()) {
            this.f54214b = true;
            return;
        }
        a(obj);
        this.f54214b = true;
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void report(Object obj, String str, long j2) {
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{obj, str, Long.valueOf(j2)}) == null) && BuildConfig.IS_ADM_REPORT.booleanValue() && obj != null) {
            if (this.f54214b) {
                synchronized (this.f54215c) {
                    rippedAd = this.f54215c.get(obj);
                }
            } else if (!a()) {
                return;
            } else {
                rippedAd = a(obj);
            }
            if (rippedAd == null) {
                return;
            }
            Ssp.Pid pid = this.mPid;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_platform", pid.ssp.type);
                jSONObject.put("aid", pid.pid);
                jSONObject.put("type", pid.type);
                jSONObject.put("sid", str);
                jSONObject.put("corp", rippedAd.corporation);
                jSONObject.put("title", rippedAd.title);
                jSONObject.put("desc", rippedAd.description);
                jSONObject.put("iU", rippedAd.iconUrl);
                jSONObject.put("appN", rippedAd.appName);
                jSONObject.put("pkg", rippedAd.appPkg);
                jSONObject.put(DeepLinkItem.DEEPLINK_APPURL_KEY, rippedAd.appUrl);
                jSONObject.put("imgU", rippedAd.imageUrl);
                jSONObject.put("viU", rippedAd.videoImageUrl);
                jSONObject.put("vU", rippedAd.videoUrl);
                jSONObject.put("clkU", rippedAd.clickUrl);
                jSONObject.put("dpU", rippedAd.deepLinkUrl);
                jSONObject.put("convU", rippedAd.convUrl);
                jSONObject.put("lid", j2);
                o0.a().d("adM", jSONObject);
            } catch (JSONException e2) {
                LogPrinter.e(e2);
            }
        }
    }
}
