package com.yy.hiidostatis.inner.util.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes2.dex */
public class StatisHttpUtil extends AbstractStatisHttpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] ADDRESSES;
    public static final String URL_FORMAT = "http://%s/c.gif";
    public static final String URL_SERVICE = "";
    public transient /* synthetic */ FieldHolder $fh;
    public String body;
    public String urlParams;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1017081133, "Lcom/yy/hiidostatis/inner/util/http/StatisHttpUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1017081133, "Lcom/yy/hiidostatis/inner/util/http/StatisHttpUtil;");
                return;
            }
        }
        ADDRESSES = new String[]{"183.61.2.91", "183.61.2.92", "183.61.2.93", "183.61.2.94", "183.61.2.95", "183.61.2.96", "183.61.2.97", "183.61.2.98"};
    }

    public StatisHttpUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String[] getUrlAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ADDRESSES : (String[]) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "http://%s/c.gif" : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public boolean sendContent(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(1048580, this, str, str2, i2)) != null) {
            return invokeLLI.booleanValue;
        }
        L.brief("hiido service address is %s", str);
        this.mThrowable = null;
        int i3 = i2;
        while (true) {
            try {
            } catch (Throwable th) {
                this.mThrowable = th;
                L.debug("StatisHttpUtil", "guid:%s. http statis exception %s", Util.parseParam(str2, BaseStatisContent.GUID), th);
            }
            if (getLastTryTimes() > 0 && !ArdUtil.isNetworkReach()) {
                L.debug(this, "isNetworkReach false.", new Object[0]);
                return false;
            }
            if (i2 != i3) {
                L.brief("Try again to send %s with url %s, tried times %d.", str2, str, Integer.valueOf(i2 - i3));
            }
            this.lastTryTimes++;
            if (!get(str, str2)) {
                L.debug(this, "Failed to send %s to %s.", str2, str);
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return false;
                }
                i3 = i4;
            } else {
                this.mThrowable = null;
                L.debug(this, "Successfully sent %s to %s", str2, str);
                return true;
            }
        }
    }
}
