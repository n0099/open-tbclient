package tv.athena.revenue.http;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a extends j.a.a.c.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f79482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79483b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f79484c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PSCIMessageRequest f79485d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f79486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f79487f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HttpDataSenderAdapter f79488g;

        public a(HttpDataSenderAdapter httpDataSenderAdapter, int i2, String str, byte[] bArr, PSCIMessageRequest pSCIMessageRequest, String str2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDataSenderAdapter, Integer.valueOf(i2), str, bArr, pSCIMessageRequest, str2, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79488g = httpDataSenderAdapter;
            this.f79482a = i2;
            this.f79483b = str;
            this.f79484c = bArr;
            this.f79485d = pSCIMessageRequest;
            this.f79486e = str2;
            this.f79487f = arrayList;
        }

        @Override // j.a.a.c.b.a
        public void a(Request request, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, request, exc) == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost onFail seq:" + this.f79483b + " exception: " + exc.getMessage(), new Object[0]);
                String retryDomain = this.f79488g.getRetryDomain(this.f79486e);
                if (!TextUtils.isEmpty(retryDomain)) {
                    try {
                        RLog.warn("HttpDataSenderAdapter", "Retry by next domain: " + retryDomain);
                        this.f79488g.sendByHttpPost(retryDomain, this.f79482a, this.f79483b, this.f79487f, this.f79484c);
                        return;
                    } catch (Exception e2) {
                        RLog.error("HttpDataSenderAdapter", "Retry error, dispatch onRequestError(), " + Log.getStackTraceString(e2), new Object[0]);
                    }
                }
                RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
                int i2 = this.f79482a;
                String str = this.f79483b;
                int cmd = this.f79485d.getCmd();
                revenueDataParser.onRequestError(i2, str, cmd, -500, "onFailure = " + exc.getMessage());
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost-----onFailure-----seq:" + this.f79483b + " exception:" + exc.getMessage(), new Object[0]);
            }
        }

        @Override // j.a.a.c.b.a
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.f79488g.onSuccess(this.f79482a, this.f79483b, this.f79484c, obj, this.f79485d);
            }
        }
    }

    public HttpDataSenderAdapter() {
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
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= objArr.length) {
                        break;
                    } else if (str.equals(objArr[i3])) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                int i4 = i2 + 1;
                r1 = i4 < objArr.length ? objArr[i4] : null;
                RLog.warn("HttpDataSenderAdapter", "getRetryDomain: backupDomain=" + r1 + ", cur=" + str);
            }
            return r1;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(int i2, String str, byte[] bArr, Object obj, PSCIMessageRequest pSCIMessageRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), str, bArr, obj, pSCIMessageRequest}) == null) {
            if (bArr == null) {
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----data == null", new Object[0]);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(obj.toString());
                int i3 = jSONObject.getInt("code");
                RLog.debug("HttpDataSenderAdapter", "sendByHttpPost----onSuccess-----:responeObject:" + jSONObject.toString());
                PSCIMessageResponse pSCIMessageResponse = new PSCIMessageResponse(obj.toString().getBytes());
                if (pSCIMessageResponse.appId == 0) {
                    pSCIMessageResponse.appId = i2;
                }
                if (pSCIMessageResponse.cmd == 0) {
                    pSCIMessageResponse.cmd = pSCIMessageRequest.getCmd();
                    RLog.error("HttpDataSenderAdapter", "response.cmd:" + pSCIMessageResponse.cmd, new Object[0]);
                }
                if (i3 == 200) {
                    if (pSCIMessageResponse.jsonMsg != null && !StringUtil.NULL_STRING.equals(pSCIMessageResponse.jsonMsg)) {
                        RevenueDataParser.INSTANCE.parserRevenueResponseData(i2, pSCIMessageResponse.marshall());
                        return;
                    }
                    RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
                    int cmd = pSCIMessageRequest.getCmd();
                    int i4 = pSCIMessageResponse.result;
                    revenueDataParser.onRequestError(i2, str, cmd, i4, "result = " + pSCIMessageResponse.result);
                    return;
                }
                RevenueDataParser revenueDataParser2 = RevenueDataParser.INSTANCE;
                int cmd2 = pSCIMessageRequest.getCmd();
                revenueDataParser2.onRequestError(i2, str, cmd2, -500, "ResultCode = " + i3);
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----:code:" + i3, new Object[0]);
            } catch (Exception e2) {
                RevenueDataParser revenueDataParser3 = RevenueDataParser.INSTANCE;
                int cmd3 = pSCIMessageRequest.getCmd();
                revenueDataParser3.onRequestError(i2, str, cmd3, -500, "ResultCode = json parse error " + e2.getLocalizedMessage());
                RLog.error("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----:Exception:" + e2.getLocalizedMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendByHttpPost(String str, int i2, String str2, ArrayList<Integer> arrayList, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Integer.valueOf(i2), str2, arrayList, bArr}) == null) {
            PSCIMessageRequest pSCIMessageRequest = new PSCIMessageRequest(bArr, ProtocolType.HTTP);
            JSONObject jSONObject = new JSONObject(pSCIMessageRequest.getJsonMsg());
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
            String str3 = str + "/api/" + i2 + "/" + pSCIMessageRequest.getCmd() + "?";
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sign", md5);
            hashMap2.put("data", jSONObject2.toString());
            hashMap2.put("ticket", pSCIMessageRequest.getTicket());
            RLog.info("HttpDataSenderAdapter", "sendByHttpPost requstUrl:" + str3 + " seq:" + str2 + " sign:" + md5 + " ticket:" + pSCIMessageRequest.getTicket() + " hostId:" + this.hostId + " authType:" + this.authType + " clientVersion:" + this.version);
            j.a.a.c.a.e().d(str3, hashMap2, i2, pSCIMessageRequest.getTraceid(), this.version, this.pakageName, this.hostId, this.authType, new a(this, i2, str2, bArr, pSCIMessageRequest, str, arrayList));
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataSenderConfig) == null) {
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
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, arrayList, bArr}) == null) {
            if (!this.isInit) {
                RLog.error("HttpDataSenderAdapter", "init first before sendData", new Object[0]);
                return;
            }
            DataSenderConfig dataSenderConfig = this.config;
            if (dataSenderConfig != null && !TextUtils.isEmpty(dataSenderConfig.gslbAppId)) {
                RLog.warn("HttpDataSenderAdapter", "tryInitHttpDns gslbAppId:" + this.config.gslbAppId);
                j.a.a.c.c.a b2 = j.a.a.c.c.a.b();
                DataSenderConfig dataSenderConfig2 = this.config;
                b2.e(dataSenderConfig2.appContext, dataSenderConfig2.gslbAppId, dataSenderConfig2.hdid);
            }
            try {
                sendByHttpPost(this.httpUrl, i2, str, arrayList, bArr);
            } catch (Exception e2) {
                RLog.error("HttpDataSenderAdapter", "sendData exeception:" + e2.getLocalizedMessage(), new Object[0]);
            }
        }
    }
}
