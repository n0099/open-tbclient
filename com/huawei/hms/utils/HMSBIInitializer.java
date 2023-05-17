package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class HMSBIInitializer {
    public static /* synthetic */ Interceptable $ic;
    public static final Object d;
    public static HMSBIInitializer e;
    public static HiAnalyticsInstance f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public AtomicBoolean b;
    public boolean c;

    /* loaded from: classes9.dex */
    public class a implements IQueryUrlCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HMSBIInitializer a;

        public a(HMSBIInitializer hMSBIInitializer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hMSBIInitializer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hMSBIInitializer;
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i);
                this.a.b.set(false);
            }
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    if (!this.a.c) {
                        HmsHiAnalyticsUtils.init(this.a.a, false, false, false, str, "com.huawei.hwid");
                    } else {
                        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                        HiAnalyticsInstance unused = HMSBIInitializer.f = new HiAnalyticsInstance.Builder(this.a.a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                        HMSBIInitializer.f.setAppid("com.huawei.hwid");
                    }
                    HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
                }
                this.a.b.set(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AsyncTask<String, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HMSBIInitializer a;

        public b(HMSBIInitializer hMSBIInitializer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hMSBIInitializer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hMSBIInitializer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (Void) invokeL.objValue;
            }
            this.a.a(strArr[0]);
            return null;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this(hMSBIInitializer);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(458013825, "Lcom/huawei/hms/utils/HMSBIInitializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(458013825, "Lcom/huawei/hms/utils/HMSBIInitializer;");
                return;
            }
        }
        d = new Object();
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return f;
        }
        return (HiAnalyticsInstance) invokeV.objValue;
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.c) {
                return HmsHiAnalyticsUtils.getInitFlag();
            }
            return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        return invokeV.booleanValue;
    }

    public HMSBIInitializer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new AtomicBoolean(false);
        this.a = context;
        this.c = c.a();
    }

    public static HMSBIInitializer getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            synchronized (d) {
                if (e == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        e = new HMSBIInitializer(applicationContext);
                    } else {
                        e = new HMSBIInitializer(context);
                    }
                }
            }
            return e;
        }
        return (HMSBIInitializer) invokeL.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            HMSLog.i("HMSBIInitializer", "Start to query GRS");
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setIssueCountry(str);
            new GrsClient(this.a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a(this));
        }
    }

    public void initBI() {
        boolean initFlag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.c) {
                initFlag = HmsHiAnalyticsUtils.getInitFlag();
            } else {
                initFlag = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
            }
            HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
            if (!initFlag && !com.huawei.hms.stats.a.c(this.a) && this.b.compareAndSet(false, true)) {
                String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.a);
                if (!TextUtils.isEmpty(issueCountryCode)) {
                    issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
                }
                if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
                    new b(this, null).execute(issueCountryCode);
                    return;
                }
                HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                this.b.set(false);
            }
        }
    }
}
