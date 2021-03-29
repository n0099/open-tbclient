package d.b.h0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public int f51232a;

    /* renamed from: b  reason: collision with root package name */
    public String f51233b;

    /* renamed from: c  reason: collision with root package name */
    public String f51234c;

    /* renamed from: d  reason: collision with root package name */
    public String f51235d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51236e;

    public boolean a() {
        return TextUtils.isEmpty(this.f51233b) || this.f51232a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f51232a = jSONObject.optInt("tab_type");
        this.f51233b = jSONObject.optString("tab_name");
        this.f51234c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51235d = jSONObject.optString("tab_version");
    }
}
