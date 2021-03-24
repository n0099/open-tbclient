package d.b.h0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.coreExtra.data.VcodeExtra;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51162a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f51163b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f51164c = null;

    /* renamed from: d  reason: collision with root package name */
    public VcodeExtra f51165d;

    public VcodeExtra a() {
        return this.f51165d;
    }

    public String b() {
        return this.f51162a;
    }

    public String c() {
        return this.f51163b;
    }

    public String d() {
        return this.f51164c;
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
            this.f51162a = jSONObject.optString("vcode_md5");
            this.f51163b = jSONObject.optString("vcode_pic_url");
            this.f51164c = jSONObject.optString("vcode_type");
            JSONObject jSONObject2 = jSONObject.getJSONObject("vcode_extra");
            VcodeExtra vcodeExtra = new VcodeExtra();
            this.f51165d = vcodeExtra;
            vcodeExtra.textImg = jSONObject2.optString("textimg");
            this.f51165d.slideImg = jSONObject2.optString("slideimg");
            this.f51165d.endPoint = jSONObject2.optString(ContentUtil.RESULT_KEY_ENDPOINT);
            this.f51165d.successImg = jSONObject2.optString("successimg");
            this.f51165d.slideEndPoint = jSONObject2.optString("slideendpoint");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
