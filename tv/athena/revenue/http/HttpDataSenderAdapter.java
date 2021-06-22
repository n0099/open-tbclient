package tv.athena.revenue.http;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
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
    public int authType;
    public DataSenderConfig config;
    public String hostId;
    public final String TAG = "HttpDataSenderAdapter";
    public String httpUrl = "";
    public ProtocolType protoType = ProtocolType.HTTP;
    public String pakageName = "";
    public String version = "";
    public boolean isInit = false;
    public boolean sEnableBackupDomain = false;

    /* loaded from: classes8.dex */
    public class a extends i.a.a.c.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f73007a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f73008b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f73009c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PSCIMessageRequest f73010d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f73011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f73012f;

        public a(int i2, String str, byte[] bArr, PSCIMessageRequest pSCIMessageRequest, String str2, ArrayList arrayList) {
            this.f73007a = i2;
            this.f73008b = str;
            this.f73009c = bArr;
            this.f73010d = pSCIMessageRequest;
            this.f73011e = str2;
            this.f73012f = arrayList;
        }

        @Override // i.a.a.c.b.a
        public void a(Request request, Exception exc) {
            RLog.error("HttpDataSenderAdapter", "sendByHttpPost onFail seq:" + this.f73008b + " exception: " + exc.getMessage(), new Object[0]);
            String retryDomain = HttpDataSenderAdapter.this.getRetryDomain(this.f73011e);
            if (!TextUtils.isEmpty(retryDomain)) {
                try {
                    RLog.warn("HttpDataSenderAdapter", "Retry by next domain: " + retryDomain);
                    HttpDataSenderAdapter.this.sendByHttpPost(retryDomain, this.f73007a, this.f73008b, this.f73012f, this.f73009c);
                    return;
                } catch (Exception e2) {
                    RLog.error("HttpDataSenderAdapter", "Retry error, dispatch onRequestError(), " + Log.getStackTraceString(e2), new Object[0]);
                }
            }
            RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
            int i2 = this.f73007a;
            String str = this.f73008b;
            int cmd = this.f73010d.getCmd();
            revenueDataParser.onRequestError(i2, str, cmd, -500, "onFailure = " + exc.getMessage());
            RLog.error("HttpDataSenderAdapter", "sendByHttpPost-----onFailure-----seq:" + this.f73008b + " exception:" + exc.getMessage(), new Object[0]);
        }

        @Override // i.a.a.c.b.a
        public void b(Object obj) {
            HttpDataSenderAdapter.this.onSuccess(this.f73007a, this.f73008b, this.f73009c, obj, this.f73010d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRetryDomain(String str) {
        Object[] objArr;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(int i2, String str, byte[] bArr, Object obj, PSCIMessageRequest pSCIMessageRequest) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendByHttpPost(String str, int i2, String str2, ArrayList<Integer> arrayList, byte[] bArr) throws Exception {
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
        i.a.a.c.a.e().d(str3, hashMap2, i2, pSCIMessageRequest.getTraceid(), this.version, this.pakageName, this.hostId, this.authType, new a(i2, str2, bArr, pSCIMessageRequest, str, arrayList));
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        if (!this.isInit) {
            RLog.error("HttpDataSenderAdapter", "init first before sendData", new Object[0]);
            return;
        }
        DataSenderConfig dataSenderConfig = this.config;
        if (dataSenderConfig != null && !TextUtils.isEmpty(dataSenderConfig.gslbAppId)) {
            RLog.warn("HttpDataSenderAdapter", "tryInitHttpDns gslbAppId:" + this.config.gslbAppId);
            i.a.a.c.c.a b2 = i.a.a.c.c.a.b();
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
