package d.b.h0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public int f51231a;

    /* renamed from: b  reason: collision with root package name */
    public String f51232b;

    /* renamed from: c  reason: collision with root package name */
    public String f51233c;

    /* renamed from: d  reason: collision with root package name */
    public String f51234d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51235e;

    public boolean a() {
        return TextUtils.isEmpty(this.f51232b) || this.f51231a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f51231a = jSONObject.optInt("tab_type");
        this.f51232b = jSONObject.optString("tab_name");
        this.f51233c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51234d = jSONObject.optString("tab_version");
    }
}
