package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public class Env {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] BACKUP_DOMAIN_POOL;
    public final String PRODUCE_REVENUE_HTTP_URL;
    public String REVENUE_HTTP_REPORT_TAG;
    public String REVENUE_HTTP_URL;
    public int SERVICE_REVENUE;
    public String SERVICE_REVENUE_REPORT_TAG;
    public final String TAG;
    public final String TEST_REVENUE_HTTP_URL;
    public final long YY_REQUEST_HREADER_URI;
    public final long YY_RESPONSE_HREADER_URI;
    public boolean isTestEnv;

    /* renamed from: com.yy.mobile.framework.revenuesdk.baseapi.Env$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final Env instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1555737962, "Lcom/yy/mobile/framework/revenuesdk/baseapi/Env$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1555737962, "Lcom/yy/mobile/framework/revenuesdk/baseapi/Env$Holder;");
                    return;
                }
            }
            instance = new Env(null);
        }

        public Holder() {
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

    public /* synthetic */ Env(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Env instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Holder.instance : (Env) invokeV.objValue;
    }

    public synchronized void init(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            synchronized (this) {
                this.isTestEnv = z;
                this.SERVICE_REVENUE = z ? IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL : 30079;
                this.SERVICE_REVENUE_REPORT_TAG = this.SERVICE_REVENUE + "";
                RLog.debug("Revenue-Env", "SERVICE_REVENUE_REPORT_TAG:" + this.SERVICE_REVENUE_REPORT_TAG);
                this.REVENUE_HTTP_URL = this.isTestEnv ? "https://turnover-pre.yy.com" : "https://turnover.yy.com";
                RLog.debug("Revenue-Env", "REVENUE_HTTP_REPORT_TAG:" + this.REVENUE_HTTP_REPORT_TAG);
            }
        }
    }

    public boolean isTestEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isTestEnv : invokeV.booleanValue;
    }

    public Env() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "Revenue-Env";
        this.SERVICE_REVENUE = IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL;
        this.SERVICE_REVENUE_REPORT_TAG = "";
        this.YY_REQUEST_HREADER_URI = 4041273699L;
        this.YY_RESPONSE_HREADER_URI = 4040225123L;
        this.REVENUE_HTTP_URL = "";
        this.REVENUE_HTTP_REPORT_TAG = "";
        this.TEST_REVENUE_HTTP_URL = "https://turnover-pre.yy.com";
        this.PRODUCE_REVENUE_HTTP_URL = "https://turnover.yy.com";
        this.BACKUP_DOMAIN_POOL = new String[]{"https://api-turnover.zhiniu8.com", "https://turnover.myzhiniu.com"};
        RLog.debug("Revenue-Env", " env init()");
    }
}
