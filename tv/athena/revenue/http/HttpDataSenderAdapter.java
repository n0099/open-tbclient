package tv.athena.revenue.http;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import d.r.b.a.a.f.c.b;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.f.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Request;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class HttpDataSenderAdapter implements b {
    public int authType;
    public String hostId;
    public final String TAG = "HttpDataSenderAdapter";
    public String httpUrl = "";
    public ProtocolType protoType = ProtocolType.HTTP;
    public String pakageName = "";
    public String version = "";
    public boolean isInit = false;

    /* loaded from: classes8.dex */
    public class a extends i.a.a.c.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f69551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f69552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f69553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f69554d;

        public a(int i2, String str, byte[] bArr, c cVar) {
            this.f69551a = i2;
            this.f69552b = str;
            this.f69553c = bArr;
            this.f69554d = cVar;
        }

        @Override // i.a.a.c.b.a
        public void a(Request request, Exception exc) {
            RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
            int i2 = this.f69551a;
            String str = this.f69552b;
            int n = this.f69554d.n();
            revenueDataParser.onRequestError(i2, str, n, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, "onFailure = " + exc.getMessage());
            d.e("HttpDataSenderAdapter", "sendByHttpPost-----onFailure-----:" + exc.getMessage(), new Object[0]);
        }

        @Override // i.a.a.c.b.a
        public void b(Object obj) {
            HttpDataSenderAdapter.this.onSuccess(this.f69551a, this.f69552b, this.f69553c, obj, this.f69554d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(int i2, String str, byte[] bArr, Object obj, c cVar) {
        if (bArr == null) {
            d.e("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----data == null", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            int i3 = jSONObject.getInt("code");
            d.b("HttpDataSenderAdapter", "sendByHttpPost----onSuccess-----:responeObject:" + jSONObject.toString());
            d.r.b.a.a.f.e.d dVar = new d.r.b.a.a.f.e.d(obj.toString().getBytes());
            if (dVar.f67695f == 0) {
                dVar.f67695f = i2;
            }
            if (dVar.f67694e == 0) {
                dVar.f67694e = cVar.n();
                d.e("HttpDataSenderAdapter", "response.cmd:" + dVar.f67694e, new Object[0]);
            }
            if (i3 == 200) {
                if (dVar.f67697h != null && !StringUtil.NULL_STRING.equals(dVar.f67697h)) {
                    RevenueDataParser.INSTANCE.parserRevenueResponseData(i2, dVar.c());
                    return;
                }
                RevenueDataParser revenueDataParser = RevenueDataParser.INSTANCE;
                int n = cVar.n();
                int i4 = dVar.f67693d;
                revenueDataParser.onRequestError(i2, str, n, i4, "result = " + dVar.f67693d);
                return;
            }
            RevenueDataParser revenueDataParser2 = RevenueDataParser.INSTANCE;
            int n2 = cVar.n();
            revenueDataParser2.onRequestError(i2, str, n2, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, "ResultCode = " + i3);
            d.e("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----:code:" + i3, new Object[0]);
        } catch (Exception e2) {
            RevenueDataParser revenueDataParser3 = RevenueDataParser.INSTANCE;
            int n3 = cVar.n();
            revenueDataParser3.onRequestError(i2, str, n3, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, "ResultCode = json parse error " + e2.getLocalizedMessage());
            d.e("HttpDataSenderAdapter", "sendByHttpPost----onRequestError-----:Exception:" + e2.getLocalizedMessage(), new Object[0]);
        }
    }

    private void sendByHttpPost(int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) throws Exception {
        c cVar = new c(bArr);
        JSONObject jSONObject = new JSONObject(cVar.o());
        HashMap hashMap = new HashMap();
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, Integer.valueOf(cVar.m()));
        hashMap.put("cmd", Integer.valueOf(cVar.n()));
        hashMap.put("version", Integer.valueOf(cVar.r()));
        hashMap.put("jsonMsg", jSONObject);
        hashMap.put("clientVersion", this.version);
        JSONObject jSONObject2 = new JSONObject(hashMap);
        String a2 = d.r.b.a.a.f.h.a.a("turnover" + jSONObject2.toString());
        if (TextUtils.isEmpty(a2)) {
            d.e("HttpDataSenderAdapter", "sendByHttpPost---- sign = null", new Object[0]);
            return;
        }
        String str2 = this.httpUrl + "/api/" + i2 + "/" + cVar.n() + "?";
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sign", a2);
        hashMap2.put("data", jSONObject2.toString());
        hashMap2.put("ticket", cVar.p());
        d.b("HttpDataSenderAdapter", "sendByHttpPost requstUrl:" + str2 + " seq:" + str + " sign:" + a2 + " ticket:" + cVar.p() + " hostId:" + this.hostId + " authType:" + this.authType + " clientVersion:" + this.version);
        i.a.a.c.a.e().d(str2, hashMap2, i2, cVar.q(), this.version, this.pakageName, this.hostId, this.authType, new a(i2, str, bArr, cVar));
    }

    @Override // d.r.b.a.a.f.c.b
    public void init(String str, String str2, String str3, String str4, ProtocolType protocolType, int i2) {
        this.pakageName = str2;
        this.version = str3;
        this.httpUrl = str4;
        this.protoType = protocolType;
        this.hostId = str;
        this.authType = i2;
        this.isInit = true;
        d.f("HttpDataSenderAdapter", "init httpUrl:" + str4 + " versionName:4.1.4-bdpay");
    }

    @Override // d.r.b.a.a.f.c.d
    public void sendData(int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        if (!this.isInit) {
            d.e("HttpDataSenderAdapter", "init first before sendData", new Object[0]);
            return;
        }
        try {
            sendByHttpPost(i2, str, arrayList, bArr);
        } catch (Exception e2) {
            d.e("HttpDataSenderAdapter", "sendData exeception:" + e2.getLocalizedMessage(), new Object[0]);
        }
    }
}
