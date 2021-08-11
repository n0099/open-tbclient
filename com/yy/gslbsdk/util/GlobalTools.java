package com.yy.gslbsdk.util;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class GlobalTools {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACCOUNT_ID = null;
    public static Context APP_CONTEXT = null;
    public static String APP_DEV_ID = "";
    public static String APP_LOCALIZE_CODE = null;
    public static final int CHN_ISP_IP_NUM = 1;
    public static String CMD_GET_LOCALDNS_IP = "getprop net.dns1";
    public static final int CUR_ISP_IP_NUM = 2;
    public static String DB_NAME = "yygslbsdk.db";
    public static int DB_VERSION = 7;
    public static String HIJACK_MONITOR_NAME = "HIJACK_MONITOR";
    public static int HIJACK_MONITOR_PERIOD = 900000;
    public static final String HTTPDNS_HOST_RELEASE = "httpdns.gslb.yy.com";
    public static final String HTTPDNS_HOST_TEST = "test-httpdns.gslb.yy.com";
    public static String HTTPDNS_REPORT_HOST = "httpdns.gslb.yy.com";
    public static String HTTPDNS_SERVER_HOST = "httpdns.gslb.yy.com";
    public static int HTTPDNS_TIMEOUT = 3000;
    public static int HTTPS_LEVEL = 0;
    public static int HTTP_TIMEOUT = 3000;
    public static final int INTL_ISP_IP_NUM = 2;
    public static boolean IS_BACKGOUND_MODEL = false;
    public static boolean IS_TEST_ENV = false;
    public static int KEEP_HOST_NUM = 20;
    public static int LOCALDNS_TIMEOUT = 3000;
    public static boolean LOG_IS_OPEN = false;
    public static String LOG_TAG = "GslbSdk";
    public static final int MIN_CHN_ISP_IP_NUM = 3;
    public static final int MIN_INTL_ISP_IP_NUM = 3;
    public static final int MIN_ONE_STACK_NUM = 2;
    public static final int MIN_SECOND_TTL = 180;
    public static final int MIN_TWO_STACK_NUM = 3;
    public static int MONITOR_DELAY = 20000;
    public static long ONE_DAY_MILSEC = 86400000;
    public static final int OTHER_ISP_IP_NUM = 1;
    public static String QUALITY_MONITOR_NAME = "QUALITY_MONITOR";
    public static int QUALITY_MONITOR_PERIOD = 300000;
    public static boolean REFRESH_AFTER_NETWORK_CHANGE = true;
    public static final String SDK_VERSION = "2.2.18-lianyun";
    public static String STATS_REPORT_NAME = "STATS_REPORT";
    public static int STATS_REPORT_PERIOD = 180000;
    public static int STATS_REPORT_TIME = 0;
    public static int THREAD_POOL_MAX = 20;
    public static int THREAD_POOL_MIN = 5;
    public static float TTL_EXPIRED_FACTOR = 0.8f;
    public static int TTL_HOST_ALIVE_SECOND = 129600;
    public static int TTL_LIVE_SECOND = 3600;
    public static String TTL_MONITOR_NAME = "TTL_MONITOR";
    public static int TTL_MONITOR_PERIOD = 10000;
    public static int TTL_NEARLY_EXPIRED_TIME_SPAN = 20000;
    public static float TTL_PROBE_FACTOR = 0.5f;
    public static int UDP_LOCAL_PORT = 15189;
    public static int UDP_RETRY_TIME = 2;
    public static int UDP_TIMEOUT = 2000;
    public static int sMinSecondTTL = 180;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2135077764, "Lcom/yy/gslbsdk/util/GlobalTools;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2135077764, "Lcom/yy/gslbsdk/util/GlobalTools;");
        }
    }

    public GlobalTools() {
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
}
