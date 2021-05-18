package d.a.j0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f50468a;

    /* renamed from: b  reason: collision with root package name */
    public String f50469b;

    /* renamed from: c  reason: collision with root package name */
    public String f50470c;

    /* renamed from: d  reason: collision with root package name */
    public String f50471d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50472e;

    public boolean a() {
        return TextUtils.isEmpty(this.f50469b) || this.f50468a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f50468a = jSONObject.optInt("tab_type");
        this.f50469b = jSONObject.optString("tab_name");
        this.f50470c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f50471d = jSONObject.optString("tab_version");
    }
}
