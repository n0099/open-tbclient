package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final GrsBaseInfo b;
    public final com.huawei.hms.framework.network.grs.e.a c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, grsBaseInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = grsBaseInfo;
        this.c = aVar;
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            String str2 = com.huawei.hms.framework.network.grs.a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
            Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
            String a = this.c.a().a("geoipCountryCodetime", "0");
            long j = 0;
            if (!TextUtils.isEmpty(a) && a.matches("\\d+")) {
                try {
                    j = Long.parseLong(a);
                } catch (NumberFormatException e) {
                    Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
                }
            }
            if (TextUtils.isEmpty(str2) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j))) {
                com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a);
                cVar.a("geoip.countrycode");
                com.huawei.hms.framework.network.grs.e.c c = this.c.c();
                if (c != null) {
                    try {
                        str = i.a(c.a("services", ""), cVar.c());
                    } catch (JSONException e2) {
                        Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        c.b("services", str);
                    }
                }
                if (z) {
                    d a2 = this.c.b().a(cVar, "geoip.countrycode", c);
                    if (a2 != null) {
                        str2 = com.huawei.hms.framework.network.grs.a.a(a2.j(), "geoip.countrycode").get("ROOT");
                    }
                    Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
                } else {
                    Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                    this.c.b().a(cVar, null, "geoip.countrycode", c);
                }
            }
            return str2;
        }
        return (String) invokeZ.objValue;
    }
}
