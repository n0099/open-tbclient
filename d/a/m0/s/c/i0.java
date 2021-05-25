package d.a.m0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.coreExtra.data.VcodeExtra;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50464a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f50465b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f50466c = null;

    /* renamed from: d  reason: collision with root package name */
    public VcodeExtra f50467d;

    public VcodeExtra a() {
        return this.f50467d;
    }

    public String b() {
        return this.f50464a;
    }

    public String c() {
        return this.f50465b;
    }

    public String d() {
        return this.f50466c;
    }

    public void e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
            }
            f(optJSONObject);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50464a = jSONObject.optString("vcode_md5");
            this.f50465b = jSONObject.optString("vcode_pic_url");
            this.f50466c = jSONObject.optString("vcode_type");
            JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
            VcodeExtra vcodeExtra = new VcodeExtra();
            this.f50467d = vcodeExtra;
            vcodeExtra.textImg = jSONObject2.optString("textimg");
            this.f50467d.slideImg = jSONObject2.optString("slideimg");
            this.f50467d.endPoint = jSONObject2.optString(ContentUtil.RESULT_KEY_ENDPOINT);
            this.f50467d.successImg = jSONObject2.optString("successimg");
            this.f50467d.slideEndPoint = jSONObject2.optString("slideendpoint");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
