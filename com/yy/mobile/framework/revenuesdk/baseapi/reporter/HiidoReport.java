package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class HiidoReport {
    public static /* synthetic */ Interceptable $ic;
    public static volatile HiidoReport sInstance;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes8.dex */
    public final class CReportParam {
        public static /* synthetic */ Interceptable $ic = null;
        public static int REVENUE_SCODE = 50552;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class CReportResponse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCmd;
        public String mDelay;
        public String mErrCode;
        public String mErrMsg;
        public String mEventId;
        public String mEventaliae;
        public String mOrderId;
        public String mPayTraceId;
        public int mPaysource;
        public long mUid;

        public CReportResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEventId = "";
            this.mErrCode = "0";
            this.mErrMsg = "";
            this.mUid = 0L;
            this.mPaysource = 0;
            this.mEventaliae = "";
            this.mDelay = "0";
            this.mOrderId = "";
            this.mPayTraceId = "";
            this.mCmd = 0;
        }
    }

    public HiidoReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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

    public String getRevenueUri(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, str)) == null) {
            return "paysdk/android/cmd_" + str + "/" + i + "/" + i2;
        }
        return (String) invokeIIL.objValue;
    }
}
