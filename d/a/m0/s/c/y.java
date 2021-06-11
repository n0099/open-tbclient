package d.a.m0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f54220a;

    /* renamed from: b  reason: collision with root package name */
    public String f54221b;

    /* renamed from: c  reason: collision with root package name */
    public String f54222c;

    /* renamed from: d  reason: collision with root package name */
    public String f54223d;

    /* renamed from: e  reason: collision with root package name */
    public String f54224e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54225f;

    public boolean a() {
        return TextUtils.isEmpty(this.f54221b) || this.f54220a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f54220a = jSONObject.optInt("tab_type");
        this.f54221b = jSONObject.optString("tab_name");
        this.f54222c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f54223d = jSONObject.optString("tab_url");
        this.f54224e = jSONObject.optString("tab_version");
    }
}
