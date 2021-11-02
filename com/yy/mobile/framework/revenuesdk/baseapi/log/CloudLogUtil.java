package com.yy.mobile.framework.revenuesdk.baseapi.log;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudLogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static int LOG_LOOP_TIME_INTERVAL = 0;
    public static int LOP_LOPP_START_TIME_DELAY = 0;
    public static int QUEUE_MAX_WAITING_NUM = 0;
    public static final String TAG = "CloudLogUtil";
    public static String mAppId = "";
    public static String mAppName = "";
    public static String mClientVer = "";
    public static String mDevice = "";
    public static String mDeviceId = "";
    public static String mOS = "";
    public static String mSdkVersion = "";
    public static String mUid = "";
    public static volatile boolean startLogLoop;
    public static List<JSONObject> waitingJsonList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(777869841, "Lcom/yy/mobile/framework/revenuesdk/baseapi/log/CloudLogUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(777869841, "Lcom/yy/mobile/framework/revenuesdk/baseapi/log/CloudLogUtil;");
                return;
            }
        }
        waitingJsonList = new LinkedList();
        QUEUE_MAX_WAITING_NUM = 30;
        LOG_LOOP_TIME_INTERVAL = 30;
        LOP_LOPP_START_TIME_DELAY = 5;
        startLogLoop = false;
    }

    public CloudLogUtil() {
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

    public static synchronized void addLogContent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            synchronized (CloudLogUtil.class) {
                String str3 = "addLogContent startLogLoop:" + startLogLoop;
                ThreadPool.getDefault().scheduledIO().execute(new Runnable(str, str2) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$logContent;
                    public final /* synthetic */ String val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$tag = str;
                        this.val$logContent = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("tag", this.val$tag);
                                jSONObject.put("uid", CloudLogUtil.mUid);
                                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, CloudLogUtil.mAppId);
                                jSONObject.put("device", CloudLogUtil.mDevice);
                                jSONObject.put("os", CloudLogUtil.mOS);
                                jSONObject.put("appName", CloudLogUtil.mAppName);
                                jSONObject.put("clientVer", CloudLogUtil.mClientVer);
                                jSONObject.put(CommandMessage.SDK_VERSION, CloudLogUtil.mSdkVersion);
                                jSONObject.put("deviceId", CloudLogUtil.mDeviceId);
                                jSONObject.put("timestamp", System.currentTimeMillis());
                                jSONObject.put(TbConfig.TMP_LOG_DIR_NAME, this.val$logContent);
                                CloudLogUtil.addLogContent(jSONObject, false);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                startLogLoop();
            }
        }
    }

    public static synchronized void doRetrySendLog(LogContent logContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, logContent) == null) {
            synchronized (CloudLogUtil.class) {
                if (logContent != null) {
                    if (logContent.copyWaitingJsonList != null && logContent.content != null) {
                        String str = "doRetrySendLog retryTime:" + logContent.retryCount.getAndIncrement();
                        sendLog(logContent);
                    }
                }
            }
        }
    }

    public static synchronized void retrySendLog(LogContent logContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, logContent) == null) {
            synchronized (CloudLogUtil.class) {
                if (logContent != null) {
                    if (logContent.copyWaitingJsonList != null && logContent.content != null) {
                        ThreadPool.getDefault().scheduledIO().schedule(new Runnable(logContent) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LogContent val$logContent;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {logContent};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$logContent = logContent;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    CloudLogUtil.doRetrySendLog(this.val$logContent);
                                }
                            }
                        }, 5L, TimeUnit.SECONDS);
                    }
                }
            }
        }
    }

    public static synchronized void sendLog(LogContent logContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, logContent) == null) {
            synchronized (CloudLogUtil.class) {
                ThreadPool.getDefault().scheduledIO().execute(new Runnable(logContent) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LogContent val$logContent;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {logContent};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$logContent = logContent;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("project", "yylive-lpfmmobileturnover");
                                jSONObject.put("region", "cn-shenzhen");
                                jSONObject.put("logStore", "turnover");
                                jSONObject.put("content", this.val$logContent.content);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            String postJson = HttpLoader.postJson("https://cloud-log.yy.com/api/log/put", jSONObject.toString());
                            String str = "sendLog res=" + postJson;
                            if (postJson != null && !postJson.isEmpty()) {
                                try {
                                    int i2 = new JSONObject(postJson).getInt("code");
                                    String str2 = "sendLog code=" + i2;
                                    if (i2 != 1000) {
                                        if (this.val$logContent.retryCount.get() > 3) {
                                            r2 = false;
                                        }
                                        String str3 = "sendLog->2 isRetry=" + r2 + " retryCount=" + this.val$logContent.retryCount;
                                        if (r2) {
                                            CloudLogUtil.retrySendLog(this.val$logContent);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                            r2 = this.val$logContent.retryCount.get() <= 3;
                            String str4 = "sendLog->1 isRetry=" + r2 + " retryCount=" + this.val$logContent.retryCount;
                            if (r2) {
                                CloudLogUtil.retrySendLog(this.val$logContent);
                            }
                        }
                    }
                });
            }
        }
    }

    public static synchronized void startLogLoop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (CloudLogUtil.class) {
                if (startLogLoop) {
                    return;
                }
                startLogLoop = true;
                ThreadPool.getDefault().scheduledIO().scheduleAtFixedRate(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            CloudLogUtil.addLogContent((JSONObject) null, true);
                        }
                    }
                }, LOP_LOPP_START_TIME_DELAY, LOG_LOOP_TIME_INTERVAL, TimeUnit.SECONDS);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:7:0x0009, B:8:0x000e, B:11:0x001a, B:16:0x0026, B:18:0x004e, B:19:0x005e, B:21:0x0064, B:22:0x0071), top: B:31:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void addLogContent(JSONObject jSONObject, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, jSONObject, z) == null) {
            synchronized (CloudLogUtil.class) {
                if (jSONObject != null) {
                    waitingJsonList.add(jSONObject);
                }
                if (waitingJsonList.size() < QUEUE_MAX_WAITING_NUM && (!z || waitingJsonList.size() <= 0)) {
                    z2 = false;
                    String str = "addLogContent waiting size:" + waitingJsonList.size() + " upload:" + z2 + " force:" + z;
                    if (z2) {
                        JSONArray jSONArray = new JSONArray();
                        ArrayList arrayList = new ArrayList();
                        for (JSONObject jSONObject2 : waitingJsonList) {
                            jSONArray.put(jSONObject2);
                            arrayList.add(jSONObject2);
                        }
                        waitingJsonList.clear();
                        LogContent logContent = new LogContent();
                        logContent.content = jSONArray;
                        logContent.copyWaitingJsonList = arrayList;
                        sendLog(logContent);
                    }
                }
                z2 = true;
                String str2 = "addLogContent waiting size:" + waitingJsonList.size() + " upload:" + z2 + " force:" + z;
                if (z2) {
                }
            }
        }
    }
}
