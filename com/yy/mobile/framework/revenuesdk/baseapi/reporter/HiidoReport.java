package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes8.dex */
public class HiidoReport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "hiidoReport";
    public static volatile HiidoReport sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Random random;

    /* loaded from: classes8.dex */
    public static final class CReportConfig {
        public static /* synthetic */ Interceptable $ic;
        public static String mAppName;
        public static Float mReportRatio;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-902361761, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportConfig;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-902361761, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportConfig;");
                    return;
                }
            }
            mReportRatio = Float.valueOf(1.0f);
            mAppName = "";
        }

        public CReportConfig() {
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

    /* loaded from: classes8.dex */
    public static final class CReportParam {
        public static /* synthetic */ Interceptable $ic = null;
        public static String ACT = "revenuepay";
        public static int INTER_SCODE = 50319;
        public static int REVENUE_SCODE = 50552;
        public static int SUMMARY_SCODE = 50321;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2025048984, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportParam;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2025048984, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportParam;");
            }
        }

        public CReportParam() {
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

    /* loaded from: classes8.dex */
    public static final class CReportResponse {
        public static /* synthetic */ Interceptable $ic = null;
        public static String mAppId = "";
        public static String mAppKey = "";
        public static String mCountry = "";
        public static String mDevice = "";
        public static String mOS = "";
        public static int mSys;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAppalias;
        public String mArea;
        public String mClientver;
        public int mCmd;
        public String mConfigTraceId;
        public String mDelay;
        public String mErrCode;
        public String mErrMsg;
        public String mEventId;
        public String mEventaliae;
        public String mFunctionName;
        public String mGPOrderId;
        public int mNet;
        public String mNtm;
        public String mOrderId;
        public String mPageId;
        public String mPayTraceId;
        public int mPaysource;
        public String mPurchaseTime;
        public int mRetry;
        public String mSdkver;
        public String mServiceName;
        public long mUid;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-741856576, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-741856576, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;");
            }
        }

        public CReportResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mEventId = "";
            this.mErrCode = "0";
            this.mErrMsg = "";
            this.mUid = 0L;
            this.mPaysource = 0;
            this.mRetry = 0;
            this.mClientver = "";
            this.mArea = "";
            this.mSdkver = "";
            this.mEventaliae = "";
            this.mAppalias = "";
            this.mNtm = "";
            this.mNet = 0;
            this.mDelay = "0";
            this.mOrderId = "";
            this.mGPOrderId = "";
            this.mPurchaseTime = "0";
            this.mServiceName = "";
            this.mFunctionName = "";
            this.mPageId = "";
            this.mConfigTraceId = "";
            this.mPayTraceId = "";
            this.mCmd = 0;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-909729196, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-909729196, "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport;");
        }
    }

    public HiidoReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.random = new Random();
    }

    public static synchronized HiidoReport getInstance() {
        InterceptResult invokeV;
        HiidoReport hiidoReport;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (HiidoReport.class) {
                if (sInstance == null) {
                    sInstance = new HiidoReport();
                }
                hiidoReport = sInstance;
            }
            return hiidoReport;
        }
        return (HiidoReport) invokeV.objValue;
    }

    public String getSummaryUri(String str, CReportResponse cReportResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cReportResponse)) == null) {
            return CReportConfig.mAppName + "/" + str;
        }
        return (String) invokeLL.objValue;
    }

    public String getUri(String str, CReportResponse cReportResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cReportResponse)) == null) {
            return CReportConfig.mAppName + "/" + str;
        }
        return (String) invokeLL.objValue;
    }

    public boolean isReportByRandomRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (CReportConfig.mReportRatio.floatValue() <= 0.0f) {
                return false;
            }
            if (CReportConfig.mReportRatio.floatValue() >= 1.0f) {
                return true;
            }
            int floatValue = (int) (CReportConfig.mReportRatio.floatValue() * 100.0f);
            int nextInt = this.random.nextInt(100);
            return nextInt >= 0 && nextInt < floatValue;
        }
        return invokeV.booleanValue;
    }
}
