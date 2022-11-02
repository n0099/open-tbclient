package com.fun.ad.sdk.internal.api.ripper;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.es9;
import com.baidu.tieba.hn9;
import com.baidu.tieba.ms9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseAdRipper implements AdRipper {
    public static /* synthetic */ Interceptable $ic;
    public static AdRipper FAKE_AD_RIPPER;
    public static final Random a;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Object, Boolean> b;
    public final HashMap<Object, Boolean> c;
    public final HashMap<Object, RippedAd> d;
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
        FAKE_AD_RIPPER = new hn9();
        a = new Random();
    }

    public BaseAdRipper(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.mPid = pid;
    }

    public final RippedAd a(Object obj) {
        InterceptResult invokeL;
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            synchronized (this.c) {
                Boolean bool = this.c.get(obj);
                if (bool == null || bool.booleanValue()) {
                    synchronized (this.d) {
                        rippedAd = this.d.get(obj);
                        if (rippedAd == null) {
                            rippedAd = getRippedAdInternal(obj);
                            boolean z = false;
                            if (rippedAd != null) {
                                this.d.put(obj, rippedAd);
                                z = true;
                            }
                            synchronized (this.c) {
                                this.c.put(obj, Boolean.valueOf(z));
                            }
                        }
                    }
                    return rippedAd;
                }
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void destroy(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this.d) {
                this.d.remove(obj);
            }
            synchronized (this.b) {
                this.b.remove(obj);
            }
            synchronized (this.c) {
                this.c.remove(obj);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final RippedAd getRippedAd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? getRippedAd(obj, true) : (RippedAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final RippedAd getRippedAd(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, obj, z)) == null) {
            synchronized (this.d) {
                RippedAd rippedAd = this.d.get(obj);
                return rippedAd != null ? rippedAd : z ? a(obj) : b(obj);
            }
        }
        return (RippedAd) invokeLZ.objValue;
    }

    public abstract RippedAd getRippedAdInternal(Object obj);

    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public void preParseRippedAd(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, obj) == null) || obj == null) {
            return;
        }
        b(obj);
    }

    public final RippedAd b(Object obj) {
        InterceptResult invokeL;
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this.b) {
                Boolean bool = this.b.get(obj);
                RippedAd rippedAd2 = null;
                if (bool == null) {
                    float nextFloat = a.nextFloat();
                    boolean z = false;
                    if (nextFloat >= this.mPid.sample) {
                        LogPrinter.d("Forbid getRipped-report with sample %.2f ratio:%.2f", Float.valueOf(nextFloat), Float.valueOf(this.mPid.sample));
                    } else {
                        z = true;
                    }
                    if (z) {
                        RippedAd a2 = a(obj);
                        this.b.put(obj, Boolean.TRUE);
                        rippedAd2 = a2;
                    } else {
                        this.b.put(obj, Boolean.FALSE);
                    }
                } else if (bool.booleanValue()) {
                    synchronized (this.d) {
                        rippedAd = this.d.get(obj);
                    }
                }
                rippedAd = rippedAd2;
            }
            return rippedAd;
        }
        return (RippedAd) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v18, types: [T, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.ripper.AdRipper
    public final void report(Object obj, String str, long j) {
        RippedAd b;
        Reporter reporter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{obj, str, Long.valueOf(j)}) == null) && BuildConfig.IS_ADM_REPORT.booleanValue() && obj != null && (b = b(obj)) != null) {
            Ssp.Pid pid = this.mPid;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_platform", pid.ssp.type);
                jSONObject.put("aid", pid.pid);
                jSONObject.put("type", pid.type);
                jSONObject.put("sid", str);
                jSONObject.put("corp", b.corporation);
                jSONObject.put("title", b.title);
                jSONObject.put("desc", b.description);
                jSONObject.put("iU", b.iconUrl);
                jSONObject.put("appN", b.appName);
                jSONObject.put("pkg", b.appPkg);
                jSONObject.put(DeepLinkItem.DEEPLINK_APPURL_KEY, b.appUrl);
                jSONObject.put("imgU", b.imageUrl);
                jSONObject.put("viU", b.videoImageUrl);
                jSONObject.put("vU", b.videoUrl);
                jSONObject.put("clkU", b.clickUrl);
                jSONObject.put("dpU", b.deepLinkUrl);
                jSONObject.put("convU", b.convUrl);
                jSONObject.put("uniqueId", b.uniqueId);
                jSONObject.put("lid", j);
                ms9<Reporter> ms9Var = es9.b;
                synchronized (ms9Var) {
                    if (ms9Var.a == null) {
                        ms9Var.a = ms9Var.a();
                    }
                    reporter = ms9Var.a;
                }
                reporter.logEvent("adM", jSONObject);
            } catch (JSONException e) {
                LogPrinter.e(e);
            }
        }
    }
}
