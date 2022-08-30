package tv.athena.revenue.http;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tieba.a0a;
import com.baidu.tieba.b0a;
import com.baidu.tieba.c0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayNetStateStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.MD5Utils;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Request;
import org.json.JSONObject;
@Keep
/* loaded from: classes9.dex */
public class HttpDataSenderAdapter implements IDataSenderAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int authType;
    public DataSenderConfig config;
    public volatile Runnable delayDnsInitReportRunnable;
    public String hostId;
    public String httpUrl;
    public boolean isInit;
    public IPayNetStateStatistics mPayNetReporter;
    public String pakageName;
    public ProtocolType protoType;
    public Object runnableLock;
    public boolean sEnableBackupDomain;
    public String version;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ HttpDataSenderAdapter c;

        public a(HttpDataSenderAdapter httpDataSenderAdapter, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDataSenderAdapter, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = httpDataSenderAdapter;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RLog.info("HttpDataSenderAdapter", "delayDnsInitReportRunnable run");
                HttpDataSenderAdapter httpDataSenderAdapter = this.c;
                httpDataSenderAdapter.handleReportPayNetEvent(EventType.PayNetStateID.EVENT_INIT_GSLB, this.a + "", this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b0a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ byte[] d;
        public final /* synthetic */ PSCIMessageRequest e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ HttpDataSenderAdapter h;

        public b(HttpDataSenderAdapter httpDataSenderAdapter, int i, int i2, String str, byte[] bArr, PSCIMessageRequest pSCIMessageRequest, String str2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDataSenderAdapter, Integer.valueOf(i), Integer.valueOf(i2), str, bArr, pSCIMessageRequest, str2, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = httpDataSenderAdapter;
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = bArr;
            this.e = pSCIMessageRequest;
            this.f = str2;
            this.g = arrayList;
        }

        @Override // com.baidu.tieba.b0a
        public void a(Request request, boolean z, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{request, Boolean.valueOf(z), exc}) == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost onFail seq:" + this.c + " exception: " + exc.getMessage() + " isCanceled:" + z + " cmd:" + this.e.getCmd(), new Object[0]);
                String retryDomain = this.h.getRetryDomain(this.f);
                if (!z && !TextUtils.isEmpty(retryDomain)) {
                    try {
                        RLog.warn("HttpDataSenderAdapter", "Retry by next domain: " + retryDomain);
                        this.h.sendByHttpPost(retryDomain, this.a, this.b, this.c, this.g, this.d);
                        this.h.handleReportPayNetEvent(EventType.PayNetStateID.EVENT_RETRY_DOMAIN, "1", retryDomain);
                        return;
                    } catch (Exception e) {
                        RLog.error("HttpDataSenderAdapter", "Retry error, dispatch onRequestError(), " + Log.getStackTraceString(e), new Object[0]);
                    }
                }
                String str = "服务请求失败message:" + exc.getMessage();
                this.h.handleReportPayNetEvent(EventType.PayNetStateID.EVENT_HTTP_ERROR, "-1", str);
                RevenueDataParser.INSTANCE.onRequestError(this.a, this.b, this.c, this.e.getCmd(), ErrorCode.SERVER_ERROR, str);
            }
        }

        @Override // com.baidu.tieba.b0a
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.h.onSuccess(this.a, this.b, this.c, this.d, obj, this.e);
            }
        }
    }

    public HttpDataSenderAdapter() {
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
        this.TAG = "HttpDataSenderAdapter";
        this.httpUrl = "";
        this.protoType = ProtocolType.HTTP;
        this.pakageName = "";
        this.version = "";
        this.isInit = false;
        this.sEnableBackupDomain = false;
        this.delayDnsInitReportRunnable = null;
        this.runnableLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRetryDomain(String str) {
        InterceptResult invokeL;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (this.sEnableBackupDomain && (objArr = Env.instance().BACKUP_DOMAIN_POOL) != null && objArr.length > 0 && str != null) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= objArr.length) {
                        break;
                    } else if (str.equals(objArr[i2])) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                int i3 = i + 1;
                r1 = i3 < objArr.length ? objArr[i3] : null;
                RLog.warn("HttpDataSenderAdapter", "getRetryDomain backupDomain=" + r1 + ", cur=" + str);
            }
            return r1;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportPayNetEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, str, str2, str3) == null) {
            if (this.mPayNetReporter == null) {
                RLog.error("HttpDataSenderAdapter", "reportPayNetEvent error mPayNetReporter null", new Object[0]);
            }
            this.mPayNetReporter.reportPayNetEvent(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(int i, int i2, String str, byte[] bArr, Object obj, PSCIMessageRequest pSCIMessageRequest) {
        int i3;
        PSCIMessageResponse pSCIMessageResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bArr, obj, pSCIMessageRequest}) == null) {
            if (bArr == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----data == null", new Object[0]);
                return;
            }
            try {
                i3 = new JSONObject(obj.toString()).getInt("code");
                pSCIMessageResponse = new PSCIMessageResponse(obj.toString().getBytes());
                if (pSCIMessageResponse.appId == 0) {
                    pSCIMessageResponse.appId = i;
                    RLog.warn("HttpDataSenderAdapter", "response.appId:" + pSCIMessageResponse.appId);
                }
                if (pSCIMessageResponse.cmd == 0) {
                    pSCIMessageResponse.cmd = pSCIMessageRequest.getCmd();
                    RLog.warn("HttpDataSenderAdapter", "response.cmd:" + pSCIMessageResponse.cmd);
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                if (i3 == 200) {
                    if (pSCIMessageResponse.jsonMsg != null && !StringUtil.NULL_STRING.equals(pSCIMessageResponse.jsonMsg)) {
                        RevenueDataParser.INSTANCE.parserRevenueResponseData(i, i2, pSCIMessageResponse.marshall());
                    } else {
                        String str2 = "服务请求失败result:" + pSCIMessageResponse.result;
                        RevenueDataParser.INSTANCE.onRequestError(i, i2, str, pSCIMessageRequest.getCmd(), pSCIMessageResponse.result, str2);
                        handleReportPayNetEvent(EventType.PayNetStateID.EVENT_HTTP_ERROR, "-2", str2);
                        RLog.error("HttpDataSenderAdapter", "sendByHttpPost onRequestError " + str2, new Object[0]);
                    }
                } else {
                    String str3 = "服务请求失败code:" + i3;
                    RevenueDataParser.INSTANCE.onRequestError(i, i2, str, pSCIMessageRequest.getCmd(), ErrorCode.SERVER_ERROR, str3);
                    handleReportPayNetEvent(EventType.PayNetStateID.EVENT_HTTP_ERROR, "-3", str3);
                    RLog.error("HttpDataSenderAdapter", "sendByHttpPost onRequestError " + str3, new Object[0]);
                }
            } catch (Exception e2) {
                e = e2;
                String str4 = "服务请求失败error:" + e.getLocalizedMessage();
                RevenueDataParser.INSTANCE.onRequestError(i, i2, str, pSCIMessageRequest.getCmd(), ErrorCode.SERVER_ERROR, str4);
                handleReportPayNetEvent(EventType.PayNetStateID.EVENT_HTTP_ERROR, EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL, str4);
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost onRequestError " + str4, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendByHttpPost(String str, int i, int i2, String str2, ArrayList<Integer> arrayList, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, arrayList, bArr}) == null) {
            PSCIMessageRequest pSCIMessageRequest = new PSCIMessageRequest(bArr, ProtocolType.HTTP);
            JSONObject jSONObject = new JSONObject(pSCIMessageRequest.getJsonMsg());
            jSONObject.put(CommandMessage.SDK_VERSION, BuildConfig.VERSION_NAME);
            HashMap hashMap = new HashMap();
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, Integer.valueOf(pSCIMessageRequest.getAppId()));
            hashMap.put("cmd", Integer.valueOf(pSCIMessageRequest.getCmd()));
            hashMap.put("version", Integer.valueOf(pSCIMessageRequest.getVersion()));
            hashMap.put("jsonMsg", jSONObject);
            hashMap.put("clientVersion", this.version);
            JSONObject jSONObject2 = new JSONObject(hashMap);
            String md5 = MD5Utils.md5("turnover" + jSONObject2.toString());
            if (TextUtils.isEmpty(md5)) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost---- sign = null", new Object[0]);
                return;
            }
            String str3 = str + "/api/" + i + "/" + pSCIMessageRequest.getCmd() + "?";
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sign", md5);
            hashMap2.put("data", jSONObject2.toString());
            hashMap2.put("ticket", pSCIMessageRequest.getTicket());
            RLog.info("HttpDataSenderAdapter", "sendByHttpPost requstUrl:" + str3 + " seq:" + str2 + " sign:" + md5 + " hostId:" + this.hostId + " authType:" + this.authType + " clientVersion:" + this.version);
            a0a.f().e(str3, hashMap2, i, i2, pSCIMessageRequest.getTraceid(), this.version, this.pakageName, this.hostId, this.authType, new b(this, i, i2, str2, bArr, pSCIMessageRequest, str, arrayList));
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            RLog.info("HttpDataSenderAdapter", "cancelAllRequest appId:" + i + " useChannel:" + i2);
            a0a.f().d(i, i2);
            c0a.g(this.mPayNetReporter);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSenderConfig) == null) {
            this.pakageName = dataSenderConfig.pakageName;
            this.version = dataSenderConfig.version;
            this.httpUrl = dataSenderConfig.httpUrl;
            this.protoType = dataSenderConfig.protoType;
            this.hostId = dataSenderConfig.hostId;
            this.authType = dataSenderConfig.authType;
            this.config = dataSenderConfig;
            this.isInit = true;
            this.mPayNetReporter = dataSenderConfig.payNetReporter;
            this.sEnableBackupDomain = true ^ Env.instance().isTestEnv();
            if (dataSenderConfig != null && !TextUtils.isEmpty(dataSenderConfig.gslbAppId)) {
                int h = c0a.c().h(dataSenderConfig.appContext, dataSenderConfig.gslbAppId, dataSenderConfig.hdid);
                String str = "initHttpDns result " + h;
                RLog.info("HttpDataSenderAdapter", "tryInitHttpDns gslbAppId:" + dataSenderConfig.gslbAppId + " " + str);
                this.delayDnsInitReportRunnable = new a(this, h, str);
            }
            RLog.info("HttpDataSenderAdapter", "init httpUrl:" + this.httpUrl + " versionName:" + BuildConfig.VERSION_NAME + " config:" + dataSenderConfig.toString());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, bArr}) == null) {
            if (!this.isInit) {
                RLog.error("HttpDataSenderAdapter", "init first before sendData", new Object[0]);
                return;
            }
            c0a.a(this.mPayNetReporter);
            synchronized (this.runnableLock) {
                if (this.delayDnsInitReportRunnable != null) {
                    this.delayDnsInitReportRunnable.run();
                    this.delayDnsInitReportRunnable = null;
                }
            }
            try {
                RLog.debug("HttpDataSenderAdapter", "sendData->sendByHttpPost");
                sendByHttpPost(this.httpUrl, i, i2, str, arrayList, bArr);
            } catch (Exception e) {
                RLog.error("HttpDataSenderAdapter", "sendData exeception:" + e.getLocalizedMessage(), new Object[0]);
            }
        }
    }
}
