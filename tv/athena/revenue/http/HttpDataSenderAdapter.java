package tv.athena.revenue.http;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.MD5Utils;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Request;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class HttpDataSenderAdapter implements IDataSenderAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int authType;
    public DataSenderConfig config;
    public String hostId;
    public String httpUrl;
    public boolean isInit;
    public String pakageName;
    public ProtocolType protoType;
    public boolean sEnableBackupDomain;
    public String version;

    /* loaded from: classes8.dex */
    public class a extends h.a.a.c.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45827c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ byte[] f45828d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PSCIMessageRequest f45829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45830f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f45831g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HttpDataSenderAdapter f45832h;

        public a(HttpDataSenderAdapter httpDataSenderAdapter, int i, int i2, String str, byte[] bArr, PSCIMessageRequest pSCIMessageRequest, String str2, ArrayList arrayList) {
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
            this.f45832h = httpDataSenderAdapter;
            this.a = i;
            this.f45826b = i2;
            this.f45827c = str;
            this.f45828d = bArr;
            this.f45829e = pSCIMessageRequest;
            this.f45830f = str2;
            this.f45831g = arrayList;
        }

        @Override // h.a.a.c.b.a
        public void a(Request request, boolean z, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{request, Boolean.valueOf(z), exc}) == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost onFail seq:" + this.f45827c + " exception: " + exc.getMessage() + " isCanceled:" + z, new Object[0]);
                String retryDomain = this.f45832h.getRetryDomain(this.f45830f);
                if (!z && !TextUtils.isEmpty(retryDomain)) {
                    try {
                        RLog.warn("HttpDataSenderAdapter", "Retry by next domain: " + retryDomain);
                        this.f45832h.sendByHttpPost(retryDomain, this.a, this.f45826b, this.f45827c, this.f45831g, this.f45828d);
                        return;
                    } catch (Exception e2) {
                        RLog.error("HttpDataSenderAdapter", "Retry error, dispatch onRequestError(), " + Log.getStackTraceString(e2), new Object[0]);
                    }
                }
                RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
                int i = this.a;
                int i2 = this.f45826b;
                String str = this.f45827c;
                int cmd = this.f45829e.getCmd();
                revenueDataParser.onRequestError(i, i2, str, cmd, -500, "服务请求失败message:" + exc.getMessage());
            }
        }

        @Override // h.a.a.c.b.a
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.f45832h.onSuccess(this.a, this.f45826b, this.f45827c, this.f45828d, obj, this.f45829e);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRetryDomain(String str) {
        InterceptResult invokeL;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
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
                RLog.warn("HttpDataSenderAdapter", "getRetryDomain: backupDomain=" + r1 + ", cur=" + str);
            }
            return r1;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(int i, int i2, String str, byte[] bArr, Object obj, PSCIMessageRequest pSCIMessageRequest) {
        int i3;
        PSCIMessageResponse pSCIMessageResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bArr, obj, pSCIMessageRequest}) == null) {
            if (bArr == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----data == null", new Object[0]);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(obj.toString());
                i3 = jSONObject.getInt("code");
                RLog.debug("HttpDataSenderAdapter", "sendByHttpPost----onSuccess-----:responeObject:" + jSONObject.toString());
                pSCIMessageResponse = new PSCIMessageResponse(obj.toString().getBytes());
                if (pSCIMessageResponse.appId == 0) {
                    pSCIMessageResponse.appId = i;
                }
                if (pSCIMessageResponse.cmd == 0) {
                    pSCIMessageResponse.cmd = pSCIMessageRequest.getCmd();
                    RLog.error("HttpDataSenderAdapter", "response.cmd:" + pSCIMessageResponse.cmd, new Object[0]);
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                if (i3 == 200) {
                    if (pSCIMessageResponse.jsonMsg != null && !StringUtil.NULL_STRING.equals(pSCIMessageResponse.jsonMsg)) {
                        RevenueDataParser.INSTANCE.parserRevenueResponseData(i, i2, pSCIMessageResponse.marshall());
                    } else {
                        RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
                        int cmd = pSCIMessageRequest.getCmd();
                        int i4 = pSCIMessageResponse.result;
                        revenueDataParser.onRequestError(i, i2, str, cmd, i4, "服务请求失败result:" + pSCIMessageResponse.result);
                    }
                } else {
                    RevenueDataParser revenueDataParser2 = RevenueDataParser.INSTANCE;
                    int cmd2 = pSCIMessageRequest.getCmd();
                    revenueDataParser2.onRequestError(i, i2, str, cmd2, -500, "服务请求失败code:" + i3);
                    RLog.error("HttpDataSenderAdapter", "sendByHttpPost onRequestError code:" + i3, new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                RevenueDataParser revenueDataParser3 = RevenueDataParser.INSTANCE;
                int cmd3 = pSCIMessageRequest.getCmd();
                revenueDataParser3.onRequestError(i, i2, str, cmd3, -500, "服务请求失败error:" + e.getLocalizedMessage());
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost onRequestError error exception:" + e.getLocalizedMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendByHttpPost(String str, int i, int i2, String str2, ArrayList<Integer> arrayList, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, arrayList, bArr}) == null) {
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
            h.a.a.c.a.f().e(str3, hashMap2, i, i2, pSCIMessageRequest.getTraceid(), this.version, this.pakageName, this.hostId, this.authType, new a(this, i, i2, str2, bArr, pSCIMessageRequest, str, arrayList));
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            RLog.info("HttpDataSenderAdapter", "cancelAllRequest appId:" + i + " useChannel:" + i2);
            h.a.a.c.a.f().d(i, i2);
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
            this.sEnableBackupDomain = true ^ Env.instance().isTestEnv();
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
            DataSenderConfig dataSenderConfig = this.config;
            if (dataSenderConfig != null && !TextUtils.isEmpty(dataSenderConfig.gslbAppId)) {
                RLog.warn("HttpDataSenderAdapter", "tryInitHttpDns gslbAppId:" + this.config.gslbAppId);
                h.a.a.c.c.a b2 = h.a.a.c.c.a.b();
                DataSenderConfig dataSenderConfig2 = this.config;
                b2.e(dataSenderConfig2.appContext, dataSenderConfig2.gslbAppId, dataSenderConfig2.hdid);
            }
            try {
                sendByHttpPost(this.httpUrl, i, i2, str, arrayList, bArr);
            } catch (Exception e2) {
                RLog.error("HttpDataSenderAdapter", "sendData exeception:" + e2.getLocalizedMessage(), new Object[0]);
            }
        }
    }
}
