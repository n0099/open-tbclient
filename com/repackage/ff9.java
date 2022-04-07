package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.gf9;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ff9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;
    public final /* synthetic */ FunAdConfig b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ long d;
    public final /* synthetic */ gf9.a e;

    public ff9(List list, FunAdConfig funAdConfig, Map map, long j, gf9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, funAdConfig, map, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = funAdConfig;
        this.c = map;
        this.d = j;
        this.e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Ssp ssp : this.a) {
                if (!this.b.forbiddenPlatforms.contains(ssp.type)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogPrinter.d("sdk for %s init start", ssp.type);
                    String str3 = ssp.type;
                    str3.hashCode();
                    char c = 65535;
                    switch (str3.hashCode()) {
                        case 3407:
                            if (str3.equals(FunAdSdk.PLATFORM_JY)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3432:
                            if (str3.equals(FunAdSdk.PLATFORM_KS)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 3477:
                            if (str3.equals(FunAdSdk.PLATFORM_MB)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 102199:
                            if (str3.equals(FunAdSdk.PLATFORM_GDT)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 106042:
                            if (str3.equals(FunAdSdk.PLATFORM_KDS)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 113873:
                            if (str3.equals(FunAdSdk.PLATFORM_SIG)) {
                                c = 5;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str3.equals("baidu")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.JyModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 1:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KsModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 2:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.MbModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 3:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.GdtModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 4:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.KdsModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 5:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.SigModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        case 6:
                            str = ssp.type;
                            str2 = "com.fun.ad.sdk.channel.BaiduModule";
                            gf9.c(str, str2, this.b, this.c, ssp.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                        default:
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            break;
                    }
                } else {
                    LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp.type);
                }
            }
            gf9.b(this.d, this.e, this.c);
        }
    }
}
